package com.carrpod.marmalade;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class BtDiagnosticActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(buildLayout());
    }

    private ScrollView buildLayout() {
        ScrollView scroll = new ScrollView(this);
        scroll.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ));

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setBackgroundColor(Color.parseColor("#0A0A0F"));
        root.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ));
        root.setPadding(dp(24), dp(48), dp(24), dp(48));

        TextView title = new TextView(this);
        title.setText("Marmalade Diagnostic");
        title.setTextSize(24f);
        title.setTextColor(Color.parseColor("#FF6600"));
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 0, 0, dp(12));
        root.addView(title);

        TextView sectionBt = new TextView(this);
        sectionBt.setText("Bluetooth Information");
        sectionBt.setTextSize(14f);
        sectionBt.setTextColor(Color.parseColor("#8888A0"));
        sectionBt.setTypeface(Typeface.DEFAULT_BOLD);
        sectionBt.setGravity(Gravity.CENTER);
        sectionBt.setPadding(0, dp(8), 0, dp(4));
        root.addView(sectionBt);

        TextView btInfo = new TextView(this);
        btInfo.setText(getBluetoothInfo());
        btInfo.setTextSize(14f);
        btInfo.setTextColor(Color.parseColor("#E8E8F0"));
        btInfo.setGravity(Gravity.CENTER);
        btInfo.setPadding(0, 0, 0, dp(12));
        root.addView(btInfo);

        TextView sectionDev = new TextView(this);
        sectionDev.setText("Device Information");
        sectionDev.setTextSize(14f);
        sectionDev.setTextColor(Color.parseColor("#8888A0"));
        sectionDev.setTypeface(Typeface.DEFAULT_BOLD);
        sectionDev.setGravity(Gravity.CENTER);
        sectionDev.setPadding(0, dp(8), 0, dp(4));
        root.addView(sectionDev);

        TextView deviceInfo = new TextView(this);
        deviceInfo.setText(getDeviceInfo());
        deviceInfo.setTextSize(12f);
        deviceInfo.setTextColor(Color.parseColor("#8888A0"));
        deviceInfo.setGravity(Gravity.CENTER);
        deviceInfo.setPadding(0, 0, 0, dp(16));
        root.addView(deviceInfo);

        View divider = new View(this);
        divider.setBackgroundColor(Color.parseColor("#252540"));
        divider.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, dp(1)
        ));
        divider.setPadding(0, dp(8), 0, dp(8));
        root.addView(divider);

        TextView thanks = new TextView(this);
        thanks.setText("Thank you.\nCarrPod AEGIS active.");
        thanks.setTextSize(16f);
        thanks.setTextColor(Color.parseColor("#00FF88"));
        thanks.setGravity(Gravity.CENTER);
        thanks.setPadding(0, dp(12), 0, dp(24));
        root.addView(thanks);

        Button releaseBtn = new Button(this);
        releaseBtn.setText("Release Memory");
        releaseBtn.setTextSize(14f);
        releaseBtn.setTextColor(Color.parseColor("#FFFFFF"));
        releaseBtn.setBackgroundColor(Color.parseColor("#FF4466"));
        releaseBtn.setPadding(dp(24), dp(10), dp(24), dp(10));
        releaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                Process.killProcess(Process.myPid());
                System.exit(0);
            }
        });
        root.addView(releaseBtn);

        scroll.addView(root);
        return scroll;
    }

    private String getBluetoothInfo() {
        StringBuilder sb = new StringBuilder();

        try {
            BluetoothManager btManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
            if (btManager != null) {
                BluetoothAdapter adapter = btManager.getAdapter();
                if (adapter != null) {
                    sb.append("State: ").append(adapter.isEnabled() ? "ON" : "OFF");
                    sb.append("\nAddress: ").append(adapter.getAddress());
                    sb.append("\nName: ").append(adapter.getName());
                    sb.append("\nScan Mode: ").append(getScanModeString(adapter.getScanMode()));
                    sb.append("\nBLE Support: ").append(
                        getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") ? "YES" : "NO"
                    );
                } else {
                    sb.append("No Bluetooth adapter detected.");
                }
            } else {
                sb.append("Bluetooth service unavailable.");
            }
        } catch (SecurityException e) {
            sb.append("Bluetooth permission denied.\nCheck BLUETOOTH_CONNECT permission.");
        } catch (Exception e) {
            sb.append("Error reading Bluetooth: ").append(e.getMessage());
        }

        return sb.toString();
    }

    private String getDeviceInfo() {
        return "Manufacturer: " + Build.MANUFACTURER + "\n" +
               "Model: " + Build.MODEL + "\n" +
               "Android: " + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ")\n" +
               "Board: " + Build.BOARD + "\n" +
               "Hardware: " + Build.HARDWARE + "\n" +
               "Product: " + Build.PRODUCT;
    }

    private String getScanModeString(int scanMode) {
        switch (scanMode) {
            case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
                return "Discoverable";
            case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
                return "Connectable";
            case BluetoothAdapter.SCAN_MODE_NONE:
                return "Not Connectable";
            default:
                return "Unknown (" + scanMode + ")";
        }
    }

    private int dp(int px) {
        return (int)(px * getResources().getDisplayMetrics().density);
    }
}
