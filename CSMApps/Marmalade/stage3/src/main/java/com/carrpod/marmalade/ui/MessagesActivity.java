package com.carrpod.marmalade.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
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

        TextView header = new TextView(this);
        header.setText("Message Stream");
        header.setTextSize(20f);
        header.setTextColor(Color.parseColor("#FF6600"));
        header.setTypeface(Typeface.DEFAULT_BOLD);
        header.setGravity(Gravity.CENTER);
        header.setPadding(0, dp(16), 0, dp(8));
        root.addView(header);

        TextView census = new TextView(this);
        census.setText("CITADEL Cohort: 5/5 ONLINE  |  " + "Messages: 10");
        census.setTextSize(12f);
        census.setTextColor(Color.parseColor("#8888A0"));
        census.setGravity(Gravity.CENTER);
        census.setPadding(0, 0, 0, dp(8));
        root.addView(census);

        List<Message> messages = SampleMessageProvider.getSampleMessages();

        ListView listView = new ListView(this);
        listView.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            0, 1f
        ));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setPadding(dp(8), dp(4), dp(8), dp(4));

        MessageAdapter adapter = new MessageAdapter(this, messages);
        listView.setAdapter(adapter);
        root.addView(listView);

        LinearLayout tabBar = new LinearLayout(this);
        tabBar.setOrientation(LinearLayout.HORIZONTAL);
        tabBar.setBackgroundColor(Color.parseColor("#1A1A2E"));
        tabBar.setPadding(0, dp(8), 0, dp(8));
        tabBar.setGravity(Gravity.CENTER);

        Button msgTab = makeTabButton("Messages", true);
        Button agentsTab = makeTabButton("Agents", false);
        Button sessionsTab = makeTabButton("Sessions", false);
        Button consoleTab = makeTabButton("Console", false);

        agentsTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        sessionsTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        consoleTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

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
        btn.setPadding(dp(12), dp(6), dp(12), dp(6));
        btn.setAllCaps(true);
        return btn;
    }

    private int dp(int px) {
        return (int)(px * getResources().getDisplayMetrics().density);
    }
}
