package com.carrpod.marmalade.screens;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.carrpod.marmalade.MainActivity;

public class SettingsScreen {
    private static final String SP="marmalade_settings";
    public static void render(final MainActivity a, LinearLayout root) {
        root.removeAllViews();
        final Context c=a;
        LinearLayout mc=new LinearLayout(a);
        mc.setOrientation(LinearLayout.VERTICAL);
        mc.setBackgroundColor(Color.parseColor("#0A0A0F"));
        mc.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

        LinearLayout tb=new LinearLayout(a);
        tb.setOrientation(LinearLayout.HORIZONTAL);
        tb.setBackgroundColor(Color.parseColor("#1A1A2E"));
        tb.setPadding(dp(c,12),dp(c,8),dp(c,12),dp(c,8));
        tb.setGravity(android.view.Gravity.CENTER_VERTICAL);
        Button bk=new Button(a);bk.setText("< BACK");bk.setTextSize(12);bk.setTextColor(Color.parseColor("#E8E8F0"));bk.setBackgroundColor(Color.parseColor("#FF6600"));bk.setOnClickListener(new View.OnClickListener(){public void onClick(View v){a.showDashboard();}});
        TextView t=new TextView(a);t.setText("SETTINGS");t.setTextSize(16);t.setTextColor(Color.parseColor("#FF6600"));t.setTypeface(Typeface.DEFAULT_BOLD);t.setGravity(android.view.Gravity.CENTER);
        t.setLayoutParams(new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1));
        tb.addView(bk);tb.addView(t);mc.addView(tb);

        ScrollView sv=new ScrollView(a);sv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1));
        LinearLayout f=new LinearLayout(a);f.setOrientation(LinearLayout.VERTICAL);f.setPadding(dp(c,16),dp(c,12),dp(c,16),dp(c,12));
        final SharedPreferences p=c.getSharedPreferences(SP,Context.MODE_PRIVATE);

        f.addView(sl(c,"POLLING"));
        final EditText po=sf(c,p.getString("poll","5"));f.addView(fld(c,"Poll Interval (s)",po,"How often to check heartbeats"));
        final EditText st=sf(c,p.getString("stale","30"));f.addView(fld(c,"Stale Threshold (s)",st,"Marked STALE after this"));

        f.addView(sl(c,"GITHUB"));
        final EditText gu=sf(c,p.getString("git_url","https://raw.githubusercontent.com/ZirconiaAegisC/CarrPod/main/"));gu.setSingleLine(false);gu.setMinLines(2);f.addView(fld(c,"Raw Base URL",gu,"For COMMS file access"));
        final EditText gt=sf(c,p.getString("git_token",""));gt.setHint("ghp_****");gt.setHintTextColor(Color.parseColor("#555566"));f.addView(fld(c,"Token (masked)",gt,"PAT for auth"));

        f.addView(sl(c,"DIRECTOR"));
        final EditText se=sf(c,p.getString("citadel_session","agent_7d77648c-9af0-4e38-a3b0-fe31f037ba16"));f.addView(fld(c,"Session ID",se,"Director's agent session ID"));

        f.addView(sl(c,"ABOUT"));
        TextView ab=new TextView(c);ab.setText("Marmalade Stage Super2 v2.0.0\nNo-Gradle aapt2+d8 build\nTarget: API 35\nBuild: 2026-07-09\nCITADEL Protocol\ngithub.com/ZirconiaAegisC/CarrPod");ab.setTextSize(11);ab.setTextColor(Color.parseColor("#8888A0"));f.addView(ab);

        Button svb=new Button(c);svb.setText("SAVE SETTINGS");svb.setTextSize(14);svb.setTextColor(Color.parseColor("#FFFFFF"));svb.setBackgroundColor(Color.parseColor("#00FF88"));svb.setPadding(dp(c,24),dp(c,10),dp(c,24),dp(c,10));
        svb.setOnClickListener(new View.OnClickListener(){public void onClick(View v){
            SharedPreferences.Editor e=p.edit();
            e.putString("poll",po.getText().toString());e.putString("stale",st.getText().toString());
            e.putString("git_url",gu.getText().toString());e.putString("git_token",gt.getText().toString());
            e.putString("citadel_session",se.getText().toString());e.apply();
            new AlertDialog.Builder(c).setTitle("Saved").setMessage("Settings saved.").setPositiveButton("OK",null).show();
        }});
        f.addView(sv);

        Button rs=new Button(c);rs.setText("RESET ALL DATA");rs.setTextSize(14);rs.setTextColor(Color.parseColor("#FFFFFF"));rs.setBackgroundColor(Color.parseColor("#FF4466"));rs.setPadding(dp(c,24),dp(c,10),dp(c,24),dp(c,10));
        rs.setOnClickListener(new View.OnClickListener(){public void onClick(View v){
            new AlertDialog.Builder(c).setTitle("CONFIRM").setMessage("Delete ALL 100 slots?").setPositiveButton("YES",new DialogInterface.OnClickListener(){public void onClick(DialogInterface d,int w){c.getSharedPreferences("marmalade_sessions",Context.MODE_PRIVATE).edit().clear().apply();c.getSharedPreferences(SP,Context.MODE_PRIVATE).edit().clear().apply();new AlertDialog.Builder(c).setTitle("Done").setMessage("All cleared.").setPositiveButton("OK",null).show();}}).setNegativeButton("NO",null).show();
        }});
        f.addView(rs);

        Button bt=new Button(c);bt.setText("BLUETOOTH DIAGNOSTIC");bt.setTextSize(14);bt.setTextColor(Color.parseColor("#FFFFFF"));bt.setBackgroundColor(Color.parseColor("#4488FF"));bt.setPadding(dp(c,24),dp(c,10),dp(c,24),dp(c,10));bt.setOnClickListener(new View.OnClickListener(){public void onClick(View v){a.showBtDiagnostic();}});f.addView(bt);

        sv.addView(f);mc.addView(sv);root.addView(mc);a.setContentView(root);
    }

    private static TextView sl(Context c,String t){TextView tv=new TextView(c);tv.setText(t);tv.setTextSize(11);tv.setTextColor(Color.parseColor("#FF6600"));tv.setTypeface(Typeface.DEFAULT_BOLD);tv.setPadding(0,dp(c,16),0,dp(c,6));return tv;}
    private static EditText sf(Context c,String v){EditText e=new EditText(c);e.setText(v);e.setTextSize(13);e.setTextColor(Color.parseColor("#E8E8F0"));e.setBackgroundColor(Color.parseColor("#1A1A2E"));e.setPadding(dp(c,8),dp(c,8),dp(c,8),dp(c,8));e.setSingleLine(true);return e;}
    private static LinearLayout fld(Context c,String l,EditText f,String h){
        LinearLayout r=new LinearLayout(c);r.setOrientation(LinearLayout.VERTICAL);
        TextView lb=new TextView(c);lb.setText(l);lb.setTextSize(11);lb.setTextColor(Color.parseColor("#8888A0"));r.addView(lb);
        r.addView(f);
        TextView hv=new TextView(c);hv.setText(h);hv.setTextSize(9);hv.setTextColor(Color.parseColor("#555566"));r.addView(hv);
        return r;
    }
    private static int dp(Context c,int px){return (int)(px*c.getResources().getDisplayMetrics().density);}
}
