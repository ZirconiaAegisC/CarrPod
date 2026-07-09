package com.carrpod.marmalade.screens;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.carrpod.marmalade.MainActivity;
import com.carrpod.marmalade.models.SessionModel;
import com.carrpod.marmalade.storage.SessionStorage;
import java.util.Map;

public class DashboardScreen {
    public static void render(MainActivity a, LinearLayout root) {
        root.removeAllViews();
        final SessionStorage st = new SessionStorage(a);
        final Map<Integer, SessionModel> sessions = st.getAllSessions();

        LinearLayout mc = new LinearLayout(a);
        mc.setOrientation(LinearLayout.VERTICAL);
        mc.setBackgroundColor(Color.parseColor("#0A0A0F"));
        mc.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        LinearLayout tb = new LinearLayout(a);
        tb.setOrientation(LinearLayout.HORIZONTAL);
        tb.setBackgroundColor(Color.parseColor("#1A1A2E"));
        tb.setPadding(dp(a,12),dp(a,8),dp(a,12),dp(a,8));
        tb.setGravity(Gravity.CENTER_VERTICAL);

        TextView stv = new TextView(a);
        stv.setText("ACTIVE: " + st.getActiveCount() + "/100 | CONFIGURED: " + st.getConfiguredCount() + "/100");
        stv.setTextSize(12); stv.setTextColor(Color.parseColor("#E8E8F0"));
        stv.setTypeface(Typeface.DEFAULT_BOLD);

        TextView tt = new TextView(a);
        tt.setText("SESSION DASHBOARD"); tt.setTextSize(14);
        tt.setTextColor(Color.parseColor("#FF6600"));
        tt.setTypeface(Typeface.DEFAULT_BOLD); tt.setGravity(Gravity.CENTER);
        tt.setLayoutParams(new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1));

        tb.addView(stv); tb.addView(tt); mc.addView(tb);

        ScrollView sv = new ScrollView(a);
        sv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1));
        LinearLayout grid = new LinearLayout(a);
        grid.setOrientation(LinearLayout.VERTICAL);
        grid.setPadding(dp(a,8),dp(a,8),dp(a,8),dp(a,8));
        int cs = dp(a,32);

        for (int r=0; r<10; r++) {
            LinearLayout row = new LinearLayout(a);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setGravity(Gravity.CENTER);
            for (int c=0; c<10; c++) {
                final int sn = r*10 + c + 1;
                SessionModel sm = sessions.get(sn);
                if (sm==null) sm=new SessionModel(sn);
                final SessionModel sess = sm;
                FrameLayout cell = new FrameLayout(a);
                int bg = sess.getStatusColor();
                cell.setBackgroundColor(bg);
                cell.setLayoutParams(new LinearLayout.LayoutParams(cs,cs));
                TextView ct = new TextView(a);
                ct.setText(String.valueOf(sn)); ct.setTextSize(9);
                ct.setTextColor(bg==0xFF8888A0 ? Color.parseColor("#555566") : Color.parseColor("#0A0A0F"));
                ct.setGravity(Gravity.CENTER);
                ct.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                cell.addView(ct);
                cell.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){ a.showSessionConfig(sn); }
                });
                row.addView(cell);
            }
            grid.addView(row);
        }
        sv.addView(grid); mc.addView(sv);

        LinearLayout nb = new LinearLayout(a);
        nb.setOrientation(LinearLayout.HORIZONTAL);
        nb.setBackgroundColor(Color.parseColor("#1A1A2E"));
        nb.setPadding(dp(a,4),dp(a,6),dp(a,4),dp(a,6));
        nb.setGravity(Gravity.CENTER);
        String[] lbs={"SESSIONS","COMMS","SETTINGS","BT","RELEASE"};
        View.OnClickListener[] acts={
            new View.OnClickListener(){public void onClick(View v){a.showDashboard();}},
            new View.OnClickListener(){public void onClick(View v){a.showDirectorComms();}},
            new View.OnClickListener(){public void onClick(View v){a.showSettings();}},
            new View.OnClickListener(){public void onClick(View v){a.showBtDiagnostic();}},
            new View.OnClickListener(){public void onClick(View v){a.finishAffinity();android.os.Process.killProcess(android.os.Process.myPid());System.exit(0);}}
        };
        for(int i=0;i<5;i++){
            Button b = new Button(a); b.setText(lbs[i]); b.setTextSize(10);
            b.setTextColor(Color.parseColor("#E8E8F0"));
            b.setBackgroundColor(Color.parseColor("#FF6600"));
            b.setPadding(dp(a,8),dp(a,4),dp(a,8),dp(a,4)); b.setAllCaps(true);
            b.setOnClickListener(acts[i]);
            LinearLayout.LayoutParams bp = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1);
            bp.setMargins(dp(a,2),0,dp(a,2),0); b.setLayoutParams(bp);
            nb.addView(b);
        }
        mc.addView(nb);
        root.addView(mc);
        a.setContentView(root);
    }
    private static int dp(Context c, int px){return (int)(px*c.getResources().getDisplayMetrics().density);}
}
