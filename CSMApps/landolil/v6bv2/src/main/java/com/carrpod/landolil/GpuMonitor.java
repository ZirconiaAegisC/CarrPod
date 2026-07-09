package com.carrpod.landolil;

import android.app.Activity;
import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;

public class GpuMonitor {

    private final Context context;
    private final Handler handler;
    private long lastCpuTime;
    private long lastAppCpuTime;
    private int pid;

    public GpuMonitor(Context context) {
        this.context = context;
        this.handler = new Handler(Looper.getMainLooper());
        this.pid = android.os.Process.myPid();
        this.lastCpuTime = 0;
        this.lastAppCpuTime = 0;
    }

    public static class Stats {
        public long availMemMB;
        public long totalMemMB;
        public long usedMemMB;
        public long appHeapMB;
        public long appNativeMB;
        public int cpuPercent;
        public String gpuRenderer;
        public String gpuVendor;
        public String webglInfo;
        public int fps;
        public String qualityTier;
    }

    public Stats collectStats() {
        Stats s = new Stats();

        android.app.ActivityManager am = (android.app.ActivityManager)
            context.getSystemService(Context.ACTIVITY_SERVICE);

        android.app.ActivityManager.MemoryInfo memInfo =
            new android.app.ActivityManager.MemoryInfo();
        am.getMemoryInfo(memInfo);

        s.availMemMB = memInfo.availMem / (1024 * 1024);
        s.totalMemMB = (Runtime.getRuntime().totalMemory() / (1024 * 1024)) + s.availMemMB;
        if (memInfo.totalMem > 0) {
            s.totalMemMB = memInfo.totalMem / (1024 * 1024);
        }
        s.totalMemMB = Math.max(s.totalMemMB, 1);
        s.usedMemMB = s.totalMemMB - s.availMemMB;

        Runtime rt = Runtime.getRuntime();
        s.appHeapMB = (rt.totalMemory() - rt.freeMemory()) / (1024 * 1024);
        s.appNativeMB = Debug.getNativeHeapAllocatedSize() / (1024 * 1024);

        s.cpuPercent = readCpuUsage();

        s.gpuRenderer = "EGL/WebGL on CPU";
        s.gpuVendor = "Android compositor";
        s.qualityTier = "AUTO";
        s.fps = 0;
        s.webglInfo = "pending";

        return s;
    }

    private int readCpuUsage() {
        try {
            String stat = new String(java.nio.file.Files.readAllBytes(
                java.nio.file.Paths.get("/proc/self/stat")));
            String[] parts = stat.split(" ");
            long utime = Long.parseLong(parts[13]);
            long stime = Long.parseLong(parts[14]);
            long appTime = utime + stime;

            if (lastAppCpuTime == 0) {
                lastAppCpuTime = appTime;
                lastCpuTime = System.currentTimeMillis();
                return 0;
            }

            long elapsed = System.currentTimeMillis() - lastCpuTime;
            if (elapsed == 0) return 0;

            int cpu = (int)(((appTime - lastAppCpuTime) * 1000L / elapsed + 5) / 10);
            lastAppCpuTime = appTime;
            lastCpuTime = System.currentTimeMillis();
            return Math.min(100, Math.max(0, cpu));
        } catch (Exception e) {
            return -1;
        }
    }

    public void injectQualityScript(android.webkit.WebView webView) {
        String script =
            "(function(){" +
            "  var canvas=document.querySelector('canvas');" +
            "  var gl=canvas?canvas.getContext('webgl2')||canvas.getContext('webgl'):null;" +
            "  if(gl){" +
            "    var debugInfo=gl.getExtension('WEBGL_debug_renderer_info');" +
            "    var gpu=debugInfo?gl.getParameter(debugInfo.UNMASKED_RENDERER_WEBGL):'unknown';" +
            "    var vendor=debugInfo?gl.getParameter(debugInfo.UNMASKED_VENDOR_WEBGL):'unknown';" +
            "    window.__lolGpu=gpu;" +
            "    window.__lolVendor=vendor;" +
            "    window.__lolWebGL=gl.getParameter(gl.VERSION);" +
            "  } else {" +
            "    window.__lolGpu='no webgl';" +
            "    window.__lolVendor='none';" +
            "    window.__lolWebGL='none';" +
            "  }" +
            "})();";
        webView.evaluateJavascript(script, null);
    }

    public void injectFpsMonitor(android.webkit.WebView webView) {
        String script =
            "(function(){" +
            "  var frames=0, lastTime=performance.now();" +
            "  window.__lolFps=0;" +
            "  function tick(){" +
            "    frames++;" +
            "    var now=performance.now();" +
            "    if(now-lastTime>=1000){" +
            "      window.__lolFps=Math.round(frames*1000/(now-lastTime));" +
            "      frames=0; lastTime=now;" +
            "    }" +
            "    requestAnimationFrame(tick);" +
            "  }" +
            "  requestAnimationFrame(tick);" +
            "})();";
        webView.evaluateJavascript(script, null);
    }

    public void injectAdaptiveQuality(android.webkit.WebView webView) {
        String script =
            "(function(){" +
            "  window.__lolQuality='auto';" +
            "  window.__lolSetQuality=function(tier){" +
            "    window.__lolQuality=tier;" +
            "    var els=document.querySelectorAll('mesh,particle,point');" +
            "    els.forEach(function(el,i){" +
            "      if(tier==='low'&&i%3!==0){el.visible=false;}" +
            "      else if(tier==='med'&&i%2!==0){el.visible=false;}" +
            "      else {el.visible=true;}" +
            "    });" +
            "  };" +
            "  window.__lolAutoTune=function(){" +
            "    var fps=window.__lolFps||0;" +
            "    if(fps>45){window.__lolSetQuality('high');}" +
            "    else if(fps>25){window.__lolSetQuality('med');}" +
            "    else{window.__lolSetQuality('low');}" +
            "  };" +
            "  setInterval(function(){" +
            "    if(window.__lolAutoTune)window.__lolAutoTune();" +
            "  },5000);" +
            "})();";
        webView.evaluateJavascript(script, null);
    }

    public void injectOverlayToggle(android.webkit.WebView webView) {
        String script =
            "(function(){" +
            "  window.__lolOverlaysVisible=true;" +
            "  window.__lolToggleOverlays=function(){" +
            "    window.__lolOverlaysVisible=!window.__lolOverlaysVisible;" +
            "    var els=document.querySelectorAll('div,h1,h2,h3,h4,span,p,a,button,header,nav,footer,label');" +
            "    els.forEach(function(el){" +
            "      el.style.display=window.__lolOverlaysVisible?'':'none';" +
            "    });" +
            "    return window.__lolOverlaysVisible;" +
            "  };" +
            "})();";
        webView.evaluateJavascript(script, null);
    }

    public void queryWebGlInfo(android.webkit.WebView webView, final WebGlCallback callback) {
        String script =
            "(function(){" +
            "  return JSON.stringify({" +
            "    gpu:window.__lolGpu||'pending'," +
            "    vendor:window.__lolVendor||'pending'," +
            "    webgl:window.__lolWebGL||'pending'," +
            "    fps:window.__lolFps||0," +
            "    quality:window.__lolQuality||'auto'" +
            "  });" +
            "})();";
        webView.evaluateJavascript(script, new android.webkit.ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                if (callback != null) {
                    callback.onResult(value != null ? value.replace("\"", "").replace("\\", "") : "{}");
                }
            }
        });
    }

    public interface WebGlCallback {
        void onResult(String json);
    }
}
