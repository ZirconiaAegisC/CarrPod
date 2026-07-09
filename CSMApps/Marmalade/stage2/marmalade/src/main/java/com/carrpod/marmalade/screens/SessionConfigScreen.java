package com.carrpod.marmalade.screens;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class SessionConfigScreen {
    private static final String[] CODENAMES={"CITADEL","PHANTOM","PROTON","NEURAL","CERVICAL","MAGLEV","SILENCER","THORAX","STELLAR","WAYFINDER","PET-SAFE","CLOUD-NEST","ASCENSION","ULNAR","FLUID-DAMP","HORIZON","VEIL","AURA","CORTEX","BASTION","FOUNDRY","RENDER","PIPELINE","SENTINEL"};
    private static final String[] NAMES={"Kairos Steele","Nyx Calder","Solara Vance","Theron Nash","Lyra Kade","Rook Draven","Orion Cross","Zephyr Arden","Cypher Voss","Eira Solven","Bran Solara","Thalia Rook","Auric Veyne","Iris Dorne","Sylas Fen","Meridia Vaun","Corvus Nyx","Aura Kind","Kael Forge","BASTION","Mira Sable","Ash Vero","Dax Sever","Tess Mara"};
    private static final String[] DIDS={"DIRECTOR-0001","DIRECTOR-0002","DIRECTOR-0003","DIRECTOR-0004","DIRECTOR-0005","DIRECTOR-0006","DIRECTOR-0007","DIRECTOR-0008","DIRECTOR-0009","DIRECTOR-0010","DIRECTOR-0011","DIRECTOR-0012","DIRECTOR-0013","DIRECTOR-0014","DIRECTOR-0015","DIRECTOR-0016","DIRECTOR-0017","DIRECTOR-0018","DIRECTOR-0019","DIRECTOR-001B","DIRECTOR-0020","DIRECTOR-0021","DIRECTOR-0022","DIRECTOR-0023"};
    private static final String[] LLMS={"deepseek-v4-pro","gemini-2.5-pro","claude-sonnet-4","gpt-4o","claude-opus-4","gemini-2.5-flash"};
    private static final String[] GITS={"main","origin/main"};

    public static void render(final MainActivity a, LinearLayout root, final int sn) {
        root.removeAllViews();
        final SessionStorage st = new SessionStorage(a);
        final SessionModel sess = st.getSession(sn);
        sess.slotNumber = sn;

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
        TextView t = new TextView(a);
        t.setText("CONFIG: SLOT "+sn); t.setTextSize(16); t.setTextColor(Color.parseColor("#FF6600"));
        t.setTypeface(Typeface.DEFAULT_BOLD); t.setGravity(android.view.Gravity.CENTER);
        t.setLayoutParams(new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1));
        tb.addView(bk); tb.addView(t); mc.addView(tb);

        ScrollView sv = new ScrollView(a);
        sv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1));
        LinearLayout f = new LinearLayout(a);
        f.setOrientation(LinearLayout.VERTICAL);
        f.setPadding(dp(a,16),dp(a,8),dp(a,16),dp(a,8));

        f.addView(lbl(a,"CODENAME"));
        final TextView codv = fv(a,sess.codename.isEmpty()?"e.g. CITADEL":sess.codename,sess.codename.isEmpty());
        codv.setOnClickListener(new View.OnClickListener(){public void onClick(View v){pick(a,"Codename",CODENAMES,codv);}});
        f.addView(codv);

        f.addView(lbl(a,"PERSON NAME"));
        final TextView pnv = fv(a,sess.personName.isEmpty()?"e.g. Kairos Steele":sess.personName,sess.personName.isEmpty());
        pnv.setOnClickListener(new View.OnClickListener(){public void onClick(View v){pick(a,"Name",NAMES,pnv);}});
        f.addView(pnv);

        f.addView(lbl(a,"DIRECTOR ID"));
        final TextView dv = fv(a,sess.directorId.isEmpty()?"e.g. DIRECTOR-0001":sess.directorId,sess.directorId.isEmpty());
        dv.setOnClickListener(new View.OnClickListener(){public void onClick(View v){pick(a,"Director ID",DIDS,dv);}});
        f.addView(dv);

        f.addView(lbl(a,"SESSION ID"));
        final EditText sid = ef(a,sess.sessionId,"agent_XXXX");
        f.addView(sid);

        f.addView(lbl(a,"SOP URL"));
        final EditText sop = ef(a,sess.sopUrl,"https://github.com/.../DIRECTOR-XXXX.md");
        sop.setSingleLine(false); sop.setMinLines(2);
        f.addView(sop);

        f.addView(lbl(a,"LLM ENGINE"));
        final TextView lv = fv(a,sess.llmEngine.isEmpty()?"e.g. deepseek-v4-pro":sess.llmEngine,sess.llmEngine.isEmpty());
        lv.setOnClickListener(new View.OnClickListener(){public void onClick(View v){pick(a,"LLM Engine",LLMS,lv);}});
        f.addView(lv);

        f.addView(lbl(a,"GIT BRANCH"));
        final TextView gv = fv(a,sess.gitBranch.isEmpty()?"main":sess.gitBranch,sess.gitBranch.isEmpty());
        gv.setOnClickListener(new View.OnClickListener(){public void onClick(View v){pick(a,"Git Branch",GITS,gv);}});
        f.addView(gv);

        f.addView(lbl(a,"HEARTBEAT PATH"));
        final EditText hb = ef(a,sess.heartbeatPath,"CSMGen/CSMAegis/COMMS/HEARTBEATS/director-XXXX.txt");
        f.addView(hb);
        f.addView(lbl(a,"OUTBOX PATH"));
        final EditText ob = ef(a,sess.outboxPath,"CSMGen/CSMAegis/COMMS/director-XXXX-outbox.md");
        f.addView(ob);
        f.addView(lbl(a,"INBOX PATH"));
        final EditText ib = ef(a,sess.inboxPath,"CSMGen/CSMAegis/COMMS/director-XXXX-inbox.md");
        f.addView(ib);
        f.addView(lbl(a,"PRODUCT"));
        final EditText pr = ef(a,sess.product,"Aegis-C Composite Shield");
        f.addView(pr);

        View sp = new View(a); sp.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dp(a,16))); f.addView(sp);
        Button svb = new Button(a); svb.setText("SAVE"); svb.setTextSize(16);
        svb.setTextColor(Color.parseColor("#FFFFFF")); svb.setBackgroundColor(Color.parseColor("#00FF88"));
        svb.setPadding(dp(a,24),dp(a,12),dp(a,24),dp(a,12));
        svb.setOnClickListener(new View.OnClickListener(){public void onClick(View v){
            sess.codename=codv.getText().toString(); sess.personName=pnv.getText().toString();
            sess.directorId=dv.getText().toString(); sess.sessionId=sid.getText().toString();
            sess.sopUrl=sop.getText().toString(); sess.llmEngine=lv.getText().toString();
            sess.gitBranch=gv.getText().toString(); sess.heartbeatPath=hb.getText().toString();
            sess.outboxPath=ob.getText().toString(); sess.inboxPath=ib.getText().toString();
            sess.product=pr.getText().toString();
            if(sess.status==0&&!sess.sessionId.isEmpty())sess.status=1;
            sess.createdAt=System.currentTimeMillis()/1000;
            st.saveSession(sess); a.showDashboard();
        }});
        f.addView(svb);

        View sp2 = new View(a); sp2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dp(a,8))); f.addView(sp2);
        Button dbt = new Button(a); dbt.setText("DELETE SLOT "+sn); dbt.setTextSize(14);
        dbt.setTextColor(Color.parseColor("#FFFFFF")); dbt.setBackgroundColor(Color.parseColor("#FF4466"));
        dbt.setPadding(dp(a,24),dp(a,8),dp(a,24),dp(a,8));
        dbt.setOnClickListener(new View.OnClickListener(){public void onClick(View v){st.deleteSession(sn);a.showDashboard();}});
        f.addView(dbt);

        sv.addView(f); mc.addView(sv); root.addView(mc); a.setContentView(root);
    }

    private static TextView lbl(Context c,String t){TextView tv=new TextView(c);tv.setText(t);tv.setTextSize(10);tv.setTextColor(Color.parseColor("#FF6600"));tv.setTypeface(Typeface.DEFAULT_BOLD);tv.setPadding(0,dp(c,12),0,dp(c,4));return tv;}
    private static TextView fv(Context c,String v,boolean hint){TextView tv=new TextView(c);tv.setText(v);tv.setTextSize(14);tv.setTextColor(hint?Color.parseColor("#555566"):Color.parseColor("#E8E8F0"));tv.setBackgroundColor(Color.parseColor("#1A1A2E"));tv.setPadding(dp(c,8),dp(c,8),dp(c,8),dp(c,8));tv.setMinHeight(dp(c,40));return tv;}
    private static EditText ef(Context c,String val,String hint){EditText et=new EditText(c);et.setText(val);et.setTextColor(Color.parseColor("#E8E8F0"));et.setHint(hint);et.setHintTextColor(Color.parseColor("#555566"));et.setBackgroundColor(Color.parseColor("#1A1A2E"));et.setPadding(dp(c,8),dp(c,8),dp(c,8),dp(c,8));et.setInputType(EditorInfo.TYPE_CLASS_TEXT);return et;}
    private static void pick(Context c,String t,String[] items,final TextView tg){new AlertDialog.Builder(c).setTitle(t).setItems(items,new DialogInterface.OnClickListener(){public void onClick(DialogInterface d,int w){tg.setText(items[w]);tg.setTextColor(Color.parseColor("#E8E8F0"));}}).show();}
    private static int dp(Context c,int px){return (int)(px*c.getResources().getDisplayMetrics().density);}
}
