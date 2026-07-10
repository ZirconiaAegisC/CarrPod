package com.carrpod.marmalade.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.carrpod.marmalade.data.SampleMessageProvider;
import com.carrpod.marmalade.models.Message;

import java.util.List;

public class MessagesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            );
        }

        setContentView(buildLayout());
    }

    private LinearLayout buildLayout() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.parseColor("#0A0A0F"));
        root.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ));

        // ─── HEADER ────────────────────────────────────
        LinearLayout topBar = new LinearLayout(this);
        topBar.setOrientation(LinearLayout.HORIZONTAL);
        topBar.setPadding(dp(12), dp(12), dp(12), dp(8));
        topBar.setBackgroundColor(Color.parseColor("#E50A0A0F"));

        Button backBtn = new Button(this);
        backBtn.setText("\u2190");
        backBtn.setTextSize(16f);
        backBtn.setTextColor(Color.parseColor("#FF6600"));
        backBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        backBtn.setPadding(dp(16), dp(6), dp(16), dp(6));
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        topBar.addView(backBtn);

        TextView title = new TextView(this);
        title.setText("Message Stream");
        title.setTextSize(20f);
        title.setTextColor(Color.parseColor("#FF6600"));
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        title.setLayoutParams(new LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f
        ));
        topBar.addView(title);

        root.addView(topBar);

        TextView census = new TextView(this);
        census.setText("CITADEL Cohort: 5/5 ONLINE  |  Messages: 10");
        census.setTextSize(12f);
        census.setTextColor(Color.parseColor("#8888A0"));
        census.setGravity(Gravity.CENTER);
        census.setPadding(0, 0, 0, dp(6));
        root.addView(census);

        // ─── MESSAGE LIST (weight=1, takes all remaining space) ──
        List<Message> messages = SampleMessageProvider.getSampleMessages();

        ListView listView = new ListView(this);
        LinearLayout.LayoutParams listParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            0
        );
        listParams.weight = 1f;
        listView.setLayoutParams(listParams);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setPadding(dp(8), dp(4), dp(8), dp(4));
        listView.setClipToPadding(false);

        MessageAdapter adapter = new MessageAdapter(this, messages);
        listView.setAdapter(adapter);
        root.addView(listView);

        // ─── TAB BAR (docked to bottom, no overlap) ───
        LinearLayout tabBar = new LinearLayout(this);
        tabBar.setOrientation(LinearLayout.HORIZONTAL);
        tabBar.setBackgroundColor(Color.parseColor("#E51A1A2E"));
        tabBar.setPadding(0, dp(6), 0, dp(6));
        tabBar.setGravity(Gravity.CENTER);
        tabBar.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        Button msgTab = makeTabButton("Messages", true);
        Button agentsTab = makeTabButton("Agents", false);
        Button sessionsTab = makeTabButton("Sessions", false);
        Button consoleTab = makeTabButton("Console", false);

        tabBar.addView(msgTab);
        tabBar.addView(agentsTab);
        tabBar.addView(sessionsTab);
        tabBar.addView(consoleTab);
        root.addView(tabBar);

        return root;
    }

    private Button makeTabButton(String label, boolean active) {
        Button btn = new Button(this);
        btn.setText(label);
        btn.setTextSize(11f);
        btn.setTextColor(Color.parseColor(active ? "#FF6600" : "#8888A0"));
        btn.setBackgroundColor(Color.parseColor(active ? "#252540" : "#1A1A2E"));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f
        );
        btn.setLayoutParams(lp);
        btn.setPadding(0, dp(8), 0, dp(8));
        btn.setAllCaps(true);
        return btn;
    }

    private int dp(int px) {
        return (int)(px * getResources().getDisplayMetrics().density);
    }
}
