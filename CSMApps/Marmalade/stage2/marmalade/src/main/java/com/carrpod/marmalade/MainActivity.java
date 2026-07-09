package com.carrpod.marmalade;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private LinearLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.setGravity(Gravity.CENTER);
        rootLayout.setBackgroundColor(Color.parseColor("#0A0A0F"));
        rootLayout.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        showSplash();
    }

    private void showSplash() {
        rootLayout.removeAllViews();
        LinearLayout splash = new LinearLayout(this);
        splash.setOrientation(LinearLayout.VERTICAL);
        splash.setGravity(Gravity.CENTER);

        TextView logo = new TextView(this);
        logo.setText("CARRPOD"); logo.setTextSize(48);
        logo.setTextColor(Color.parseColor("#FF6600"));
        logo.setTypeface(Typeface.DEFAULT_BOLD);
        logo.setGravity(Gravity.CENTER);
        logo.setPadding(0,0,0,dp(16));
        splash.addView(logo);

        TextView sub = new TextView(this);
        sub.setText("Safe Pod Engineering Company"); sub.setTextSize(12);
        sub.setTextColor(Color.parseColor("#8888A0"));
        sub.setGravity(Gravity.CENTER);
        sub.setPadding(0,0,0,dp(64));
        splash.addView(sub);

        TextView name = new TextView(this);
        name.setText("Marmalade"); name.setTextSize(32);
        name.setTextColor(Color.parseColor("#E8E8F0"));
        name.setTypeface(Typeface.DEFAULT_BOLD);
        name.setGravity(Gravity.CENTER);
        name.setPadding(0,0,0,dp(8));
        splash.addView(name);

        TextView ver = new TextView(this);
        ver.setText("Stage Super2 — v2.0.0"); ver.setTextSize(12);
        ver.setTextColor(Color.parseColor("#FF6600"));
        ver.setGravity(Gravity.CENTER);
        ver.setPadding(0,0,0,dp(16));
        splash.addView(ver);

        TextView prot = new TextView(this);
        prot.setText("CITADEL Protocol Active"); prot.setTextSize(10);
        prot.setTextColor(Color.parseColor("#00FF88"));
        prot.setGravity(Gravity.CENTER);
        splash.addView(prot);

        rootLayout.addView(splash);
        setContentView(rootLayout);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){
            public void run(){ showDashboard(); }
        }, 3000);
    }

    public void showDashboard() {
        com.carrpod.marmalade.screens.DashboardScreen.render(this, rootLayout);
    }
    public void showSessionConfig(int slot) {
        com.carrpod.marmalade.screens.SessionConfigScreen.render(this, rootLayout, slot);
    }
    public void showDirectorComms() {
        com.carrpod.marmalade.screens.DirectorCommsScreen.render(this, rootLayout);
    }
    public void showBtDiagnostic() {
        com.carrpod.marmalade.screens.BtDiagnosticScreen.render(this, rootLayout);
    }
    public void showSettings() {
        com.carrpod.marmalade.screens.SettingsScreen.render(this, rootLayout);
    }
    public LinearLayout getRootLayout() { return rootLayout; }
    private int dp(int px) { return (int)(px * getResources().getDisplayMetrics().density); }
}
