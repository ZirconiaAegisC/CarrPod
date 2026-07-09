package com.carrpod.landolil;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.animation.ValueAnimator;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class MainActivity extends Activity {

    private ElementView elementView;
    private PowerManager.WakeLock wakeLock;
    private boolean stayAwake = true;
    private FrameLayout rootLayout;
    private ScrollView menuDrawer;
    private View menuTab;
    private boolean menuOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK
                | PowerManager.ACQUIRE_CAUSES_WAKEUP, "LandOLil:ScreenOn");
        if (stayAwake) wakeLock.acquire(10 * 60 * 1000L);

        rootLayout = new FrameLayout(this);
        rootLayout.setBackgroundColor(0xFF0A0A0F);

        elementView = new ElementView(this);
        rootLayout.addView(elementView, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        buildMenu();
        buildMenuTab();

        setContentView(rootLayout);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (wakeLock != null && wakeLock.isHeld()) wakeLock.release();
    }

    private void buildMenu() {
        ScrollView scroll = new ScrollView(this);
        LinearLayout menu = new LinearLayout(this);
        menu.setOrientation(LinearLayout.VERTICAL);
        menu.setBackgroundColor(0xFF0E0E16);
        menu.setPadding(32, 16, 32, 16);

        TextView title = new TextView(this);
        title.setText("LAND O LIL");
        title.setTextColor(0xFFFF6600);
        title.setTextSize(18);
        title.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
        menu.addView(title);

        TextView sub = new TextView(this);
        sub.setText("v7 — Aegis Chromatic");
        sub.setTextColor(0xFF8888A0);
        sub.setTextSize(10);
        sub.setPadding(0, 2, 0, 16);
        menu.addView(sub);

        menu.addView(sep());
        menu.addView(section("ELEMENTS"));
        for (final ElementType t : ElementType.values()) {
            menu.addView(elementRow(t));
        }

        menu.addView(sep());
        menu.addView(section("DISPLAY"));

        LinearLayout awakeRow = new LinearLayout(this);
        awakeRow.setOrientation(LinearLayout.HORIZONTAL);
        awakeRow.setPadding(0, 8, 0, 8);
        TextView al = new TextView(this);
        al.setText("Stay Awake");
        al.setTextColor(0xFFE8E8F0);
        al.setTextSize(12);
        Switch as = new Switch(this);
        as.setChecked(stayAwake);
        as.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton b, boolean on) {
                stayAwake = on;
                if (on) wakeLock.acquire(10 * 60 * 1000L);
                else if (wakeLock.isHeld()) wakeLock.release();
            }
        });
        awakeRow.addView(al);
        awakeRow.addView(as);
        menu.addView(awakeRow);

        menu.addView(sep());
        menu.addView(section("PHYSICS"));
        menu.addView(slider("Stiffness", 200, 50, 500, new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar s, int v, boolean f) { elementView.springStiffness = v; }
            public void onStartTrackingTouch(SeekBar s) {}
            public void onStopTrackingTouch(SeekBar s) {}
        }));
        menu.addView(slider("Damping", 50, 5, 95, new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar s, int v, boolean f) { elementView.springDamping = v / 100f; }
            public void onStartTrackingTouch(SeekBar s) {}
            public void onStopTrackingTouch(SeekBar s) {}
        }));

        menu.addView(sep());
        menu.addView(section("COLORS"));
        RadioGroup rg = new RadioGroup(this);
        String[] modes = {"Aegis Chromatic", "Classic Elements", "Monochrome"};
        for (int i = 0; i < 3; i++) {
            RadioButton rb = new RadioButton(this);
            rb.setText(modes[i]);
            rb.setTextColor(0xFFE8E8F0);
            final int mode = i;
            rb.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) { elementView.colorMode = mode; }
            });
            if (i == 0) rb.setChecked(true);
            rg.addView(rb);
        }
        menu.addView(rg);

        menu.addView(sep());
        TextView about = new TextView(this);
        about.setText("Land O Lil v7\nAegis Chromatic System\nCarrPod / CSM Aegis\nZrB2-SiC · MXene · YInMn Blue\nDirector Kairos Steele — CITADEL");
        about.setTextColor(0xFF666688);
        about.setTextSize(9);
        about.setPadding(0, 8, 0, 8);
        menu.addView(about);

        menu.addView(sep());
        LinearLayout btns = new LinearLayout(this);
        btns.setOrientation(LinearLayout.HORIZONTAL);
        Button close = new Button(this);
        close.setText("CLOSE");
        close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { toggleMenu(); }
        });
        btns.addView(close);
        Button reset = new Button(this);
        reset.setText("RESET");
        reset.setTextColor(0xFFFF6600);
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { elementView.resetElements(); }
        });
        btns.addView(reset);
        menu.addView(btns);

        scroll.addView(menu);
        menuDrawer = scroll;

        int w = (int) (280 * getResources().getDisplayMetrics().density);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(w,
                ViewGroup.LayoutParams.MATCH_PARENT);
        lp.gravity = android.view.Gravity.END;
        menuDrawer.setLayoutParams(lp);
        menuDrawer.setTranslationX(w);
        menuDrawer.setVisibility(View.VISIBLE);
        rootLayout.addView(menuDrawer);
    }

    private void buildMenuTab() {
        menuTab = new View(this);
        menuTab.setBackgroundColor(0xFFFF6600);
        int tw = (int) (8 * getResources().getDisplayMetrics().density);
        int th = (int) (48 * getResources().getDisplayMetrics().density);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(tw, th);
        lp.gravity = android.view.Gravity.END | android.view.Gravity.CENTER_VERTICAL;
        menuTab.setLayoutParams(lp);
        menuTab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { toggleMenu(); }
        });
        rootLayout.addView(menuTab);
    }

    private void toggleMenu() {
        menuOpen = !menuOpen;
        float target = menuOpen ? 0f : (280 * getResources().getDisplayMetrics().density);
        ValueAnimator anim = ValueAnimator.ofFloat(menuDrawer.getTranslationX(), target);
        anim.setDuration(300);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator a) {
                float v = (Float) a.getAnimatedValue();
                menuDrawer.setTranslationX(v);
                menuTab.setTranslationX(-v);
                menuTab.setVisibility(menuOpen ? View.GONE : View.VISIBLE);
            }
        });
        anim.start();
    }

    private View sep() {
        View v = new View(this);
        v.setBackgroundColor(0xFF252540);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 1);
        lp.setMargins(0, 8, 0, 8);
        v.setLayoutParams(lp);
        return v;
    }

    private TextView section(String text) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextColor(0xFFFF6600);
        tv.setTextSize(12);
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setPadding(0, 8, 0, 4);
        return tv;
    }

    private LinearLayout elementRow(final ElementType type) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setPadding(0, 4, 0, 4);

        TextView l = new TextView(this);
        l.setText(type.name);
        l.setTextColor(typeColor(type));
        l.setTextSize(12);
        l.setPadding(0, 0, 16, 0);
        row.addView(l);

        final TextView cnt = new TextView(this);
        cnt.setText(String.valueOf(elementView.getCount(type)));
        cnt.setTextColor(0xFFE8E8F0);
        cnt.setTextSize(12);
        cnt.setPadding(8, 0, 8, 0);
        row.addView(cnt);

        Button minus = new Button(this);
        minus.setText("-");
        minus.setTextSize(12);
        minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elementView.removeElement(type);
                cnt.setText(String.valueOf(elementView.getCount(type)));
            }
        });
        row.addView(minus);

        Button plus = new Button(this);
        plus.setText("+");
        plus.setTextSize(12);
        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elementView.addElement(type);
                cnt.setText(String.valueOf(elementView.getCount(type)));
            }
        });
        row.addView(plus);
        return row;
    }

    private LinearLayout slider(String label, int value, int min, int max,
            final SeekBar.OnSeekBarChangeListener listener) {
        LinearLayout col = new LinearLayout(this);
        col.setOrientation(LinearLayout.VERTICAL);
        col.setPadding(0, 4, 0, 8);

        final TextView vl = new TextView(this);
        vl.setText(label + ": " + value);
        vl.setTextColor(0xFFE8E8F0);
        vl.setTextSize(12);
        col.addView(vl);

        SeekBar sb = new SeekBar(this);
        sb.setMax(max - min);
        sb.setProgress(value - min);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar s, int v, boolean f) {
                vl.setText(label + ": " + (v + min));
                listener.onProgressChanged(s, v + min, f);
            }
            public void onStartTrackingTouch(SeekBar s) {}
            public void onStopTrackingTouch(SeekBar s) {}
        });
        col.addView(sb);
        return col;
    }

    private int typeColor(ElementType type) {
        switch (type) {
            case FIRE: return 0xFFFFFFE0;
            case EARTH: return 0xFFF5E6D3;
            case AIR: return 0xFF2E0854;
            case WATER: return 0xFF1B4F8A;
            case METAL: return 0xFFC0C0C0;
            case VOID: return 0xFF0A0A0F;
            default: return 0xFFFFFFFF;
        }
    }

    enum ElementType {
        FIRE("Fire"), EARTH("Earth"), AIR("Air"),
        WATER("Water"), METAL("Metal"), VOID("Void");
        final String name;
        ElementType(String n) { name = n; }
    }

    class Element {
        String id = UUID.randomUUID().toString();
        ElementType type;
        float x, y, vx, vy;
        float homeX, homeY;
        float temperature;
        boolean selected;
        float pulseRadius = 40f;
        float pulseTimer;

        Element(ElementType t, float x, float y) {
            this.type = t;
            this.x = x;
            this.y = y;
            this.homeX = x;
            this.homeY = y;
            this.temperature = baseTemp(t);
        }

        float baseTemp(ElementType t) {
            switch (t) {
                case FIRE: return 1800f;
                case EARTH: return 288f;
                case AIR: return 273f;
                case WATER: return 280f;
                case METAL: return 300f;
                case VOID: return 250f;
                default: return 300f;
            }
        }

        float distanceTo(Element other) {
            float dx = x - other.x;
            float dy = y - other.y;
            return (float) Math.sqrt(dx * dx + dy * dy);
        }
    }

    class ElementView extends View {
        List<Element> elements = new ArrayList<>();
        Random rng = new Random();
        float fps = 60f;
        int frames;
        long lastFps;
        int dwellIdx;
        int dwellSec = 30;
        long dwellElapsed;
        boolean dwellPaused;
        float springStiffness = 200f;
        float springDamping = 0.5f;
        int colorMode;
        int cw, ch;

        ElementView(Context ctx) {
            super(ctx);
            lastFps = System.currentTimeMillis();
            post(new Runnable() {
                public void run() {
                    cw = getWidth();
                    ch = getHeight();
                    if (cw == 0) { cw = 1080; ch = 1920; }
                    initElements();
                    startLoop();
                }
            });
        }

        void initElements() {
            for (ElementType type : ElementType.values()) {
                for (int i = 0; i < 3; i++) {
                    float ex = 100 + rng.nextFloat() * (cw - 200);
                    float ey = 150 + rng.nextFloat() * (ch - 500);
                    elements.add(new Element(type, ex, ey));
                }
            }
            if (!elements.isEmpty()) elements.get(0).selected = true;
        }

        int getCount(ElementType type) {
            int c = 0;
            for (Element e : elements) if (e.type == type) c++;
            return c;
        }

        void addElement(ElementType type) {
            if (getCount(type) >= 10) return;
            float ex = cw / 2f + rng.nextFloat() * 200 - 100;
            float ey = ch / 2f + rng.nextFloat() * 200 - 100;
            elements.add(new Element(type, ex, ey));
        }

        void removeElement(ElementType type) {
            if (getCount(type) <= 1) return;
            for (int i = elements.size() - 1; i >= 0; i--) {
                if (elements.get(i).type == type) {
                    elements.remove(i);
                    break;
                }
            }
        }

        void resetElements() {
            elements.clear();
            initElements();
        }

        void startLoop() {
            postDelayed(new Runnable() {
                public void run() {
                    update(0.016f);
                    invalidate();
                    frames++;
                    long now = System.currentTimeMillis();
                    if (now - lastFps >= 1000) {
                        fps = frames * 1000f / (now - lastFps);
                        frames = 0;
                        lastFps = now;
                    }
                    postDelayed(this, 16);
                }
            }, 16);
        }

        void update(float dt) {
            for (Element e : elements) {
                float hfx = (e.homeX - e.x) * 20f;
                float hfy = (e.homeY - e.y) * 20f;
                e.vx += hfx * dt;
                e.vy += hfy * dt;
                e.vx *= 0.99f;
                e.vy *= 0.99f;
                e.x += e.vx * dt;
                e.y += e.vy * dt;
                if (e.x < 30) { e.x = 30; e.vx *= -0.5f; }
                if (e.x > cw - 30) { e.x = cw - 30; e.vx *= -0.5f; }
                if (e.y < 30) { e.y = 30; e.vy *= -0.5f; }
                if (e.y > ch - 300) { e.y = ch - 300; e.vy *= -0.5f; }

                if (e.selected) {
                    e.pulseTimer += dt;
                    e.pulseRadius = 40f + (float) Math.sin(e.pulseTimer * 12.56637f) * 8f;
                } else {
                    e.pulseRadius = 40f;
                }
            }

            if (!dwellPaused && !elements.isEmpty()) {
                dwellElapsed += (long)(dt * 1000);
                if (dwellElapsed >= dwellSec * 1000L) {
                    dwellElapsed = 0;
                    for (Element e : elements) e.selected = false;
                    dwellIdx = (dwellIdx + 1) % elements.size();
                    elements.get(dwellIdx).selected = true;
                }
            }

            for (int i = 0; i < elements.size(); i++) {
                for (int j = i + 1; j < elements.size(); j++) {
                    Element a = elements.get(i);
                    Element b = elements.get(j);
                    float dist = a.distanceTo(b);
                    if (dist < 150f) {
                        float f = (1f - dist / 150f) * 10f;
                        float dx = (b.x - a.x) / dist * f * dt;
                        float dy = (b.y - a.y) / dist * f * dt;
                        a.vx += dx;
                        a.vy += dy;
                        b.vx -= dx;
                        b.vy -= dy;
                    }
                }
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                float tx = event.getX();
                float ty = event.getY();
                boolean hit = false;
                for (int i = elements.size() - 1; i >= 0; i--) {
                    Element e = elements.get(i);
                    float d = (float) Math.sqrt((tx - e.x) * (tx - e.x) + (ty - e.y) * (ty - e.y));
                    if (d <= 45f) {
                        for (Element el : elements) el.selected = false;
                        e.selected = true;
                        dwellPaused = true;
                        dwellIdx = i;
                        hit = true;
                        break;
                    }
                }
                if (!hit) {
                    dwellPaused = false;
                    dwellElapsed = 0;
                }
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            cw = getWidth();
            ch = getHeight();
            if (cw == 0 || ch == 0) return;

            canvas.drawColor(0xFF0A0A0F);
            Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

            for (int i = 0; i < elements.size(); i++) {
                for (int j = i + 1; j < elements.size(); j++) {
                    Element a = elements.get(i);
                    Element b = elements.get(j);
                    float dist = a.distanceTo(b);
                    if (dist < 150f) {
                        float intensity = 1f - dist / 150f;
                        int lineColor = (dist < 80f) ? 0xFFFF6600 : 0xFF2E0854;
                        p.setColor(lineColor);
                        p.setAlpha((int)(intensity * 77));
                        p.setStrokeWidth(1f + intensity * 3f);
                        canvas.drawLine(a.x, a.y, b.x, b.y, p);
                    }
                }
            }

            for (Element e : elements) {
                int bc;
                switch (e.type) {
                    case FIRE: bc = 0xFFFFFFE0; break;
                    case EARTH: bc = 0xFFF5E6D3; break;
                    case AIR: bc = 0xFF2E0854; break;
                    case WATER: bc = 0xFF1B4F8A; break;
                    case METAL: bc = 0xFFC0C0C0; break;
                    case VOID: bc = 0xFF1A1A2E; break;
                    default: bc = 0xFFFFFFFF;
                }
                if (colorMode == 2) bc = 0xFFE8E8F0;

                float r = e.pulseRadius;

                p.setColor(bc);
                p.setAlpha(30);
                canvas.drawCircle(e.x, e.y, 50f, p);

                p.setColor(bc);
                p.setAlpha(220);
                canvas.drawCircle(e.x, e.y, r, p);

                p.setColor(0xFFFFFFFF);
                p.setAlpha(50);
                canvas.drawCircle(e.x - r * 0.2f, e.y - r * 0.2f, r * 0.4f, p);

                if (e.selected) {
                    p.setStyle(Paint.Style.STROKE);
                    p.setColor(0xFFFF6600);
                    p.setAlpha(255);
                    p.setStrokeWidth(3f);
                    canvas.drawCircle(e.x, e.y, r + 4f, p);
                    p.setStyle(Paint.Style.FILL);
                }

                p.setColor(0xFFFFFFFF);
                p.setAlpha(230);
                p.setTextSize(30f);
                p.setTypeface(Typeface.DEFAULT_BOLD);
                p.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(e.type.name.substring(0, 1), e.x, e.y + 10f, p);

                p.setTextSize(18f);
                p.setAlpha(150);
                p.setTypeface(Typeface.DEFAULT);
                canvas.drawText(e.type.name, e.x, e.y + r + 20f, p);
            }

            p.setColor(0xFF00FF00);
            p.setTextSize(20f);
            p.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("FPS: " + (int) fps, 10, ch - 10, p);

            p.setColor(0xFFE8E8F0);
            p.setTextSize(22f);
            p.setTextAlign(Paint.Align.CENTER);
            if (dwellPaused) {
                p.setColor(0xFF8888A0);
                canvas.drawText("PAUSED", cw / 2f, 40, p);
            } else {
                int rem = dwellSec - (int)(dwellElapsed / 1000);
                if (rem < 0) rem = 0;
                String l = "NEXT: " + rem + "s";
                if (dwellIdx < elements.size()) l += " " + elements.get(dwellIdx).type.name;
                canvas.drawText(l, cw / 2f, 40, p);
            }
        }
    }
}
