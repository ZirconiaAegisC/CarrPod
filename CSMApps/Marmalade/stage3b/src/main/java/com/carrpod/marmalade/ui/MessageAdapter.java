package com.carrpod.marmalade.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.carrpod.marmalade.models.Message;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MessageAdapter extends BaseAdapter {

    private final Context context;
    private final List<Message> messages;
    private final SimpleDateFormat timeFormat;

    public MessageAdapter(Context context, List<Message> messages) {
        this.context = context;
        this.messages = messages;
        this.timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Message getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message msg = messages.get(position);
        LinearLayout card = new LinearLayout(context);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(16), dp(12), dp(16), dp(12));
        card.setBackgroundColor(Color.parseColor("#1A1A2E"));

        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        cardParams.setMargins(dp(8), dp(4), dp(8), dp(4));
        card.setLayoutParams(cardParams);

        LinearLayout headerRow = new LinearLayout(context);
        headerRow.setOrientation(LinearLayout.HORIZONTAL);
        headerRow.setGravity(Gravity.CENTER_VERTICAL);

        TextView agentBadge = new TextView(context);
        agentBadge.setText("[" + msg.fromCodename + "]");
        agentBadge.setTextSize(13f);
        agentBadge.setTextColor(Color.parseColor("#FF6600"));
        agentBadge.setTypeface(Typeface.DEFAULT_BOLD);
        agentBadge.setPadding(0, 0, dp(8), 0);

        TextView nameText = new TextView(context);
        nameText.setText(msg.fromName);
        nameText.setTextSize(13f);
        nameText.setTextColor(Color.parseColor("#E8E8F0"));
        nameText.setTypeface(Typeface.DEFAULT_BOLD);
        nameText.setPadding(0, 0, dp(12), 0);

        LinearLayout badgeRow = new LinearLayout(context);
        badgeRow.setOrientation(LinearLayout.HORIZONTAL);
        badgeRow.setLayoutParams(new LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f
        ));

        if (msg.isDirective) {
            TextView directiveBadge = new TextView(context);
            directiveBadge.setText("DIRECTIVE");
            directiveBadge.setTextSize(10f);
            directiveBadge.setTextColor(Color.parseColor("#FFFFFF"));
            directiveBadge.setBackgroundColor(Color.parseColor("#FF4466"));
            directiveBadge.setPadding(dp(6), dp(2), dp(6), dp(2));
            badgeRow.addView(directiveBadge);
        }

        if (msg.isOverride) {
            TextView overrideBadge = new TextView(context);
            overrideBadge.setText("@OVERRIDE");
            overrideBadge.setTextSize(10f);
            overrideBadge.setTextColor(Color.parseColor("#FFFFFF"));
            overrideBadge.setBackgroundColor(Color.parseColor("#CC5200"));
            overrideBadge.setPadding(dp(6), dp(2), dp(6), dp(2));
            badgeRow.addView(overrideBadge);
        }

        TextView vocalBadge = new TextView(context);
        vocalBadge.setText(msg.vocalMode);
        vocalBadge.setTextSize(10f);
        vocalBadge.setTextColor(getVocalColor(msg.vocalMode));
        vocalBadge.setPadding(dp(6), dp(2), dp(6), dp(2));

        headerRow.addView(agentBadge);
        headerRow.addView(nameText);
        headerRow.addView(badgeRow);
        headerRow.addView(vocalBadge);

        TextView attentionLine = null;
        if (msg.attentionHeader != null && !msg.attentionHeader.isEmpty()) {
            attentionLine = new TextView(context);
            attentionLine.setText(msg.attentionHeader);
            attentionLine.setTextSize(11f);
            attentionLine.setTextColor(Color.parseColor("#8888A0"));
            attentionLine.setPadding(0, dp(2), 0, dp(2));
        }

        TextView bodyText = new TextView(context);
        bodyText.setText(msg.body);
        bodyText.setTextSize(14f);
        bodyText.setTextColor(Color.parseColor("#E8E8F0"));
        bodyText.setPadding(0, dp(4), 0, dp(4));

        TextView timeText = new TextView(context);
        timeText.setText(timeFormat.format(new Date(msg.timestamp)));
        timeText.setTextSize(10f);
        timeText.setTextColor(Color.parseColor("#555570"));
        timeText.setPadding(0, dp(4), 0, 0);

        card.addView(headerRow);
        if (attentionLine != null) {
            card.addView(attentionLine);
        }
        card.addView(bodyText);
        card.addView(timeText);

        return card;
    }

    private int getVocalColor(String mode) {
        switch (mode) {
            case "ROAR": return Color.parseColor("#FF4466");
            case "BURST": return Color.parseColor("#FF8844");
            case "HOVER": return Color.parseColor("#44AAFF");
            case "BRAKE": return Color.parseColor("#FFCC00");
            case "WHISPER": return Color.parseColor("#8888A0");
            case "DROP": return Color.parseColor("#00FF88");
            default: return Color.parseColor("#E8E8F0");
        }
    }

    private int dp(int px) {
        return (int)(px * context.getResources().getDisplayMetrics().density);
    }
}
