package com.carrpod.marmalade.screens;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.carrpod.marmalade.MainActivity;
import com.carrpod.marmalade.models.SessionModel;
import com.carrpod.marmalade.storage.SessionStorage;
import java.util.Map;

public class DirectorCommsScreen {
    public static void render(final MainActivity a, LinearLayout root) {
        root.removeAllViews();
        final SessionStorage st = new SessionStorage(a);

        LinearLayout mc = new LinearLayout(a);
        mc.setOrientation(LinearLayout.VERTICAL);
        mc.setBackgroundColor(Color.parseColor("#0A0A0F"));
        mc.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

        LinearLayout tb = new LinearLayout(a);
        tb.setOrientation(LinearLayout.HORIZONTAL);
        tb.setBackgroundColor(Color.parseColor("#1A1A2E"));
        tb.setPadding(dp(a,12),dp(a,8),dp(a,12),dp(a,8));
        tb.setGravity(Gravity.CENTER_VERTICAL);
        Button bk = new Button(a); bk.setText("< BACK"); bk.setTextSize(12);
        bk.setTextColor(Color.parseColor("#E8E8F0")); bk.setBackgroundColor(Color.parseColor("#FF6600"));
        bk.setOnClickListener(new View.OnClickListener(){public void onClick(View v){a.showDashboard();}});
        TextView t = new TextView(a); t.setText("DIRECTOR COMMS"); t.setTextSize(16);
        t.setTextColor(Color.parseColor("#FF6600")); t.setTypeface(Typeface.DEFAULT_BOLD);
        t.setGravity(Gravity.CENTER); t.setLayoutParams(new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1));
        tb.addView(bk); tb.addView(t); mc.addView(tb);

        final ScrollView ca = new ScrollView(a);
        ca.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1));
        final LinearLayout ci = new LinearLayout(a);
        ci.setOrientation(LinearLayout.VERTICAL);
        ci.setPadding(dp(a,12),dp(a,8),dp(a,12),dp(a,8));
        ca.addView(ci);

        LinearLayout tabs = new LinearLayout(a);
        tabs.setOrientation(LinearLayout.HORIZONTAL);
        tabs.setBackgroundColor(Color.parseColor("#1A1A2E"));
        tabs.setPadding(dp(a,4),dp(a,4),dp(a,4),dp(a,4));
        String[] tbs={"COMMS LOG","COMPOSE","SIBLINGS"};
        for(int i=0;i<3;i++){
            final int ti=i;
            Button tb2=new Button(a); tb2.setText(tbs[i]); tb2.setTextSize(11);
            tb2.setTextColor(Color.parseColor("#E8E8F0"));
            tb2.setBackgroundColor(Color.parseColor("#444455")); tb2.setAllCaps(true);
            tb2.setLayoutParams(new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1));
            tb2.setOnClickListener(new View.OnClickListener(){public void onClick(View v){
                ci.removeAllViews();
                switch(ti){case 0:showLog(a,ci);break;case 1:showCompose(a,ci,st);break;case 2:showSiblings(a,ci,st);break;}
            }});
            tabs.addView(tb2);
        }
        mc.addView(tabs);
        showLog(a,ci);
        mc.addView(ca);
        root.addView(mc);
        a.setContentView(root);
    }

    private static void showLog(Context c,LinearLayout ci){
        TextView h=new TextView(c);h.setText("AEGIS COMMS LOG");h.setTextSize(14);h.setTextColor(Color.parseColor("#FF6600"));h.setTypeface(Typeface.DEFAULT_BOLD);h.setPadding(0,0,0,dp(c,8));ci.addView(h);
        String[] entries={
            "[DIRECTOR-0022 | 2026-07-06 | 03:29 UTC]\nPIPELINE completed. 12 products across 5-layer dielectric stack.",
            "[DIRECTOR-0019 | 2026-07-06 | 03:25 UTC]\nCORTEX ARCHITECTURE DELIVERY COMPLETE. Cohort 5/5.",
            "[DIRECTOR-001 | 2026-07-06 | 02:33 UTC]\nSENTINEL ACTIVE. Sibling-Pulse V5 live.",
            "[DIRECTOR-0021 | 2026-07-06 | 02:40 UTC]\nRENDER scaffolding. 6 core components. WCAG 2.1 AA.",
            "[DIRECTOR-0020 | 2026-07-06 | 02:33 UTC]\nFOUNDRY standing by. Mock endpoints live."
        };
        for(String e:entries){
            TextView ev=new TextView(c);ev.setText(e);ev.setTextSize(11);ev.setTextColor(Color.parseColor("#CCCCDD"));
            ev.setBackgroundColor(Color.parseColor("#1A1A2E"));ev.setPadding(dp(c,8),dp(c,6),dp(c,8),dp(c,6));
            LinearLayout.LayoutParams ep=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            ep.setMargins(0,0,0,dp(c,4));ev.setLayoutParams(ep);ci.addView(ev);
        }
        TextView f2=new TextView(c);f2.setText("Source: github.com/ZirconiaAegisC/CarrPod");f2.setTextSize(9);f2.setTextColor(Color.parseColor("#555566"));f2.setPadding(0,dp(c,8),0,0);ci.addView(f2);
    }

    private static void showCompose(Context c,LinearLayout ci,SessionStorage st){
        TextView h=new TextView(c);h.setText("COMPOSE DIRECTIVE");h.setTextSize(14);h.setTextColor(Color.parseColor("#FF6600"));h.setTypeface(Typeface.DEFAULT_BOLD);h.setPadding(0,0,0,dp(c,8));ci.addView(h);
        final EditText toF=new EditText(c);toF.setHint("[FOR DIRECTOR-0019] [FOR DIRECTOR-0020]");toF.setHintTextColor(Color.parseColor("#555566"));toF.setTextColor(Color.parseColor("#E8E8F0"));toF.setBackgroundColor(Color.parseColor("#1A1A2E"));toF.setPadding(dp(c,8),dp(c,8),dp(c,8),dp(c,8));
        final EditText subF=new EditText(c);subF.setHint("Subject");subF.setHintTextColor(Color.parseColor("#555566"));subF.setTextColor(Color.parseColor("#E8E8F0"));subF.setBackgroundColor(Color.parseColor("#1A1A2E"));subF.setPadding(dp(c,8),dp(c,8),dp(c,8),dp(c,8));
        final EditText bodyF=new EditText(c);bodyF.setHint("Directive body...");bodyF.setHintTextColor(Color.parseColor("#555566"));bodyF.setTextColor(Color.parseColor("#E8E8F0"));bodyF.setBackgroundColor(Color.parseColor("#1A1A2E"));bodyF.setPadding(dp(c,8),dp(c,8),dp(c,8),dp(c,8));
        bodyF.setMinLines(4);bodyF.setGravity(Gravity.TOP);bodyF.setInputType(EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE);

        ci.addView(lbl1(c,"TO:"));ci.addView(toF);
        ci.addView(lbl1(c,"SUBJECT:"));ci.addView(subF);
        ci.addView(lbl1(c,"BODY:"));ci.addView(bodyF);

        Button sb=new Button(c);sb.setText("SEND DIRECTIVE");sb.setTextSize(14);sb.setTextColor(Color.parseColor("#FFFFFF"));sb.setBackgroundColor(Color.parseColor("#FF6600"));
        sb.setPadding(dp(c,24),dp(c,12),dp(c,24),dp(c,12));
        sb.setOnClickListener(new View.OnClickListener(){public void onClick(View v){new AlertDialog.Builder(c).setTitle("Directive Sent").setMessage("Recorded for COMMS log.").setPositiveButton("OK",null).show();}});
        ci.addView(sb);
    }

    private static void showSiblings(Context c,LinearLayout ci,SessionStorage st){
        TextView h=new TextView(c);h.setText("SIBLING OUTBOXES");h.setTextSize(14);h.setTextColor(Color.parseColor("#FF6600"));h.setTypeface(Typeface.DEFAULT_BOLD);h.setPadding(0,0,0,dp(c,8));ci.addView(h);
        Map<Integer,SessionModel> sessions=st.getAllSessions();
        if(sessions.isEmpty()){TextView em=new TextView(c);em.setText("No siblings configured.");em.setTextSize(12);em.setTextColor(Color.parseColor("#8888A0"));ci.addView(em);return;}
        for(SessionModel s:sessions.values()){
            if(s.status<1)continue;
            LinearLayout row=new LinearLayout(c);row.setOrientation(LinearLayout.VERTICAL);row.setBackgroundColor(Color.parseColor("#1A1A2E"));row.setPadding(dp(c,8),dp(c,6),dp(c,8),dp(c,6));
            TextView nm=new TextView(c);nm.setText("SLOT "+s.slotNumber+" | "+s.codename+" ("+s.personName+")");nm.setTextSize(12);nm.setTextColor(Color.parseColor("#FF6600"));nm.setTypeface(Typeface.DEFAULT_BOLD);
            TextView stv=new TextView(c);stv.setText("Status: "+s.getStatusString()+" | Outbox: "+s.outboxPath);stv.setTextSize(10);stv.setTextColor(Color.parseColor("#8888A0"));
            row.addView(nm);row.addView(stv);
            LinearLayout.LayoutParams rp=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);rp.setMargins(0,0,0,dp(c,4));row.setLayoutParams(rp);
            ci.addView(row);
        }
    }

    private static TextView lbl1(Context c,String t){TextView tv=new TextView(c);tv.setText(t);tv.setTextSize(11);tv.setTextColor(Color.parseColor("#8888A0"));tv.setPadding(0,dp(c,8),0,dp(c,2));return tv;}
    private static int dp(Context c,int px){return (int)(px*c.getResources().getDisplayMetrics().density);}
}
