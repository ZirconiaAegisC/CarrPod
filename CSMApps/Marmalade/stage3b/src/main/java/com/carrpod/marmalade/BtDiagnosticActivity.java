package com.carrpod.marmalade;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.Toast;

public class BtDiagnosticActivity extends Activity {

    private static final int REQUEST_BT_PERMISSION = 1001;
    private TextView btInfoView;

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
        root.setPadding(dp(24), dp(16), dp(24), dp(48));

        // ─── BACK BUTTON ──────────────────────────────
        Button backBtn = new Button(this);
        backBtn.setText("\u2190 Back");
        backBtn.setTextSize(13f);
        backBtn.setTextColor(Color.parseColor("#FF6600"));
        backBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        backBtn.setPadding(dp(20), dp(8), dp(20), dp(8));
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        root.addView(backBtn);

        TextView title = new TextView(this);
        title.setText("Marmalade Diagnostic");
        title.setTextSize(24f);
        title.setTextColor(Color.parseColor("#FF6600"));
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, dp(12), 0, dp(12));
        root.addView(title);

        // ─── BLUETOOTH SECTION ─────────────────────────
        TextView sectionBt = new TextView(this);
        sectionBt.setText("Bluetooth Information");
        sectionBt.setTextSize(14f);
        sectionBt.setTextColor(Color.parseColor("#8888A0"));
        sectionBt.setTypeface(Typeface.DEFAULT_BOLD);
        sectionBt.setGravity(Gravity.CENTER);
        sectionBt.setPadding(0, dp(8), 0, dp(4));
        root.addView(sectionBt);

        btInfoView = new TextView(this);
        btInfoView.setText(getBluetoothInfo());
        btInfoView.setTextSize(14f);
        btInfoView.setTextColor(Color.parseColor("#E8E8F0"));
        btInfoView.setGravity(Gravity.CENTER);
        btInfoView.setPadding(0, 0, 0, dp(8));
        root.addView(btInfoView);

        // ─── REQUEST FULL BT ACCESS BUTTON ─────────────
        Button requestBtn = new Button(this);
        requestBtn.setText("Request Full Bluetooth Access");
        requestBtn.setTextSize(13f);
        requestBtn.setTextColor(Color.parseColor("#FFFFFF"));
        requestBtn.setBackgroundColor(Color.parseColor("#FF6600"));
        requestBtn.setPadding(dp(20), dp(10), dp(20), dp(10));
        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestBluetoothPermission();
            }
        });
        root.addView(requestBtn);

        // ─── DEVICE SECTION ────────────────────────────
        TextView sectionDev = new TextView(this);
        sectionDev.setText("Device Information");
        sectionDev.setTextSize(14f);
        sectionDev.setTextColor(Color.parseColor("#8888A0"));
        sectionDev.setTypeface(Typeface.DEFAULT_BOLD);
        sectionDev.setGravity(Gravity.CENTER);
        sectionDev.setPadding(0, dp(16), 0, dp(4));
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

    private void requestBluetoothPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                    new String[]{Manifest.permission.BLUETOOTH_CONNECT},
                    REQUEST_BT_PERMISSION
                );
            } else {
                Toast.makeText(this, "Bluetooth permission already granted.", Toast.LENGTH_SHORT).show();
                refreshBluetoothInfo();
            }
        } else {
            Toast.makeText(this, "Runtime BT permission not needed on this Android version.", Toast.LENGTH_SHORT).show();
            refreshBluetoothInfo();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_BT_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Bluetooth permission granted. Refreshing info.", Toast.LENGTH_SHORT).show();
                refreshBluetoothInfo();
            } else {
                Toast.makeText(this, "Bluetooth permission denied. Showing limited info.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void refreshBluetoothInfo() {
        if (btInfoView != null) {
            btInfoView.setText(getBluetoothInfo());
        }
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
            sb.append("Permission required.\nTap \"Request Full Bluetooth Access\" to unlock details.");
        } catch (Exception e) {
            sb.append("Error: ").append(e.getMessage());
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
