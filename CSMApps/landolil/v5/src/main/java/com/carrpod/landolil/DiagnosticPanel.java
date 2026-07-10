package com.carrpod.landolil;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Locale;

public class DiagnosticPanel {

    private final Context context;
    private final FrameLayout rootContainer;
    private final LinearLayout panel;
    private boolean isOpen = false;
    private Runnable onStatsRefresh;

    private TextView txtRam, txtCpu, txtGpu, txtFps, txtQuality, txtHeap, txtNative;
    private GpuMonitor monitor;

    public DiagnosticPanel(Context context, FrameLayout rootContainer) {
        this.context = context;
        this.rootContainer = rootContainer;
        this.monitor = new GpuMonitor(context);

        panel = buildPanel();
    }

    private LinearLayout buildPanel() {
        LinearLayout panel = new LinearLayout(context);
        panel.setOrientation(LinearLayout.VERTICAL);
        panel.setBackgroundColor(Color.parseColor("#E50A0A0F"));
        panel.setPadding(dp(16), dp(40), dp(16), dp(16));
        panel.setVisibility(View.GONE);

        FrameLayout.LayoutParams panelParams = new FrameLayout.LayoutParams(
            dp(280), ViewGroup.LayoutParams.MATCH_PARENT
        );
        panelParams.gravity = Gravity.END | Gravity.TOP;
        panel.setLayoutParams(panelParams);

        TextView title = new TextView(context);
        title.setText("Tardigradia Diagnostics");
        title.setTextSize(16f);
        title.setTextColor(Color.parseColor("#FF6600"));
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setPadding(0, 0, 0, dp(16));
        panel.addView(title);

        panel.addView(makeSection("GPU / Renderer"));
        txtGpu = makeValue("detecting...");
        panel.addView(txtGpu);

        panel.addView(makeSection("WebGL Version"));
        TextView txtWebGL = makeValue("detecting...");
        panel.addView(txtWebGL);

        panel.addView(makeSpacer());

        panel.addView(makeSection("CPU Usage"));
        txtCpu = makeValue("-- %");
        panel.addView(txtCpu);

        panel.addView(makeSection("RAM (App Heap)"));
        txtHeap = makeValue("-- MB");
        panel.addView(txtHeap);

        panel.addView(makeSection("RAM (Native)"));
        txtNative = makeValue("-- MB");
        panel.addView(txtNative);

        panel.addView(makeSection("System RAM Used"));
        txtRam = makeValue("-- / -- MB");
        panel.addView(txtRam);

        panel.addView(makeSpacer());

        panel.addView(makeSection("FPS (WebGL)"));
        txtFps = makeValue("-- fps");
        panel.addView(txtFps);

        panel.addView(makeSection("Quality Tier"));
        txtQuality = makeValue("AUTO");
        panel.addView(txtQuality);

        panel.addView(makeSpacer());

        Button closeBtn = new Button(context);
        closeBtn.setText("Close Panel");
        closeBtn.setTextSize(12f);
        closeBtn.setTextColor(Color.parseColor("#FF6600"));
        closeBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        closeBtn.setPadding(dp(12), dp(6), dp(12), dp(6));
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
        panel.addView(closeBtn);

        return panel;
    }

    private TextView makeSection(String label) {
        TextView tv = new TextView(context);
        tv.setText(label);
        tv.setTextSize(10f);
        tv.setTextColor(Color.parseColor("#8888A0"));
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setPadding(0, dp(8), 0, dp(2));
        return tv;
    }

    private TextView makeValue(String initial) {
        TextView tv = new TextView(context);
        tv.setText(initial);
        tv.setTextSize(13f);
        tv.setTextColor(Color.parseColor("#E8E8F0"));
        tv.setPadding(0, 0, 0, dp(4));
        return tv;
    }

    private View makeSpacer() {
        View v = new View(context);
        v.setBackgroundColor(Color.parseColor("#252540"));
        v.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, dp(1)
        ));
        v.setPadding(0, dp(8), 0, dp(8));
        return v;
    }

    public View getPanel() {
        return panel;
    }

    public void toggle() {
        if (isOpen) {
            panel.setVisibility(View.GONE);
            isOpen = false;
        } else {
            panel.setVisibility(View.VISIBLE);
            refreshStats();
            isOpen = true;
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void refreshStats() {
        GpuMonitor.Stats stats = monitor.collectStats();

        txtRam.setText(String.format(Locale.getDefault(), "%d / %d MB", stats.usedMemMB, stats.totalMemMB));
        txtCpu.setText(stats.cpuPercent >= 0 ? stats.cpuPercent + " %" : "-- %");
        txtHeap.setText(stats.appHeapMB + " MB");
        txtNative.setText(stats.appNativeMB + " MB");
        txtGpu.setText(stats.gpuRenderer != null ? stats.gpuRenderer : "detecting...");
        txtFps.setText(stats.fps > 0 ? stats.fps + " fps" : "calibrating...");
        txtQuality.setText(stats.qualityTier);
    }

    public void updateWebGlInfo(String gpu, String vendor, String webgl, int fps) {
        txtGpu.setText(gpu != null && !gpu.isEmpty() ? gpu : "unknown");
        if (vendor != null && !vendor.isEmpty()) {
            txtGpu.setText(txtGpu.getText() + "\n  " + vendor);
        }
        txtFps.setText(fps > 0 ? fps + " fps" : txtFps.getText());
    }

    private int dp(int px) {
        return (int)(px * context.getResources().getDisplayMetrics().density);
    }
}
