package com.carrpod.marmalade.screens;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Process;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.carrpod.marmalade.MainActivity;

public class BtDiagnosticScreen {
    public static void render(final MainActivity a, LinearLayout root) {
        root.removeAllViews();
        LinearLayout mc = new LinearLayout(a);
        mc.setOrientation(LinearLayout.VERTICAL);
        mc.setGravity(Gravity.CENTER);
        mc.setBackgroundColor(Color.parseColor("#0A0A0F"));
        mc.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        mc.setPadding(dp(a,24),dp(a,24),dp(a,24),dp(a,24));

        TextView t=new TextView(a);t.setText("Marmalade Diagnostic");t.setTextSize(24);t.setTextColor(Color.parseColor("#FF6600"));t.setTypeface(Typeface.DEFAULT_BOLD);t.setGravity(Gravity.CENTER);t.setPadding(0,0,0,dp(a,8));
        TextView p=new TextView(a);p.setText("CITADEL Protocol V2");p.setTextSize(10);p.setTextColor(Color.parseColor("#00FF88"));p.setGravity(Gravity.CENTER);p.setPadding(0,0,0,dp(a,24));

        TextView bi=new TextView(a);
        bi.setText(getBtInfo(a));bi.setTextSize(14);bi.setTextColor(Color.parseColor("#E8E8F0"));bi.setGravity(Gravity.CENTER);bi.setPadding(0,dp(a,8),0,dp(a,4));

        TextView di=new TextView(a);
        di.setText(getDeviceInfo());di.setTextSize(11);di.setTextColor(Color.parseColor("#8888A0"));di.setGravity(Gravity.CENTER);di.setPadding(0,dp(a,4),0,dp(a,16));

        TextView th=new TextView(a);th.setText("Thank you. CarrPod AEGIS active.");th.setTextSize(16);th.setTextColor(Color.parseColor("#00FF88"));th.setGravity(Gravity.CENTER);th.setPadding(0,dp(a,8),0,dp(a,24));

        Button bk=new Button(a);bk.setText("BACK TO DASHBOARD");bk.setTextSize(14);bk.setTextColor(Color.parseColor("#FFFFFF"));bk.setBackgroundColor(Color.parseColor("#FF6600"));bk.setPadding(dp(a,24),dp(a,10),dp(a,24),dp(a,10));bk.setOnClickListener(new View.OnClickListener(){public void onClick(View v){a.showDashboard();}});

        Button rb=new Button(a);rb.setText("Release Memory");rb.setTextSize(14);rb.setTextColor(Color.parseColor("#FFFFFF"));rb.setBackgroundColor(Color.parseColor("#FF4466"));rb.setPadding(dp(a,24),dp(a,10),dp(a,24),dp(a,10));rb.setOnClickListener(new View.OnClickListener(){public void onClick(View v){a.finishAffinity();Process.killProcess(Process.myPid());System.exit(0);}});

        mc.addView(t);mc.addView(p);mc.addView(bi);mc.addView(di);mc.addView(th);mc.addView(bk);mc.addView(rb);
        root.addView(mc);a.setContentView(root);
    }

    private static String getBtInfo(Context c){
        StringBuilder sb=new StringBuilder();sb.append("Bluetooth Support:\n\n");
        try{
            BluetoothManager m=(BluetoothManager)c.getSystemService(Context.BLUETOOTH_SERVICE);
            if(m!=null){BluetoothAdapter ad=m.getAdapter();if(ad!=null){
                sb.append("State: ").append(ad.isEnabled()?"ON":"OFF").append("\n");
                try{sb.append("Address: ").append(ad.getAddress()!=null?ad.getAddress():"N/A").append("\n");}catch(SecurityException e){sb.append("Address: [Permission Required]\n");}
                try{sb.append("Name: ").append(ad.getName()!=null?ad.getName():"N/A").append("\n");}catch(SecurityException e){sb.append("Name: [Permission Required]\n");}
                try{sb.append("Scan Mode: ").append(getScanMode(ad.getScanMode())).append("\n");}catch(SecurityException e){sb.append("Scan Mode: [Permission Required]\n");}
            }else{sb.append("No adapter found.\n");}}else{sb.append("Service unavailable.\n");}
        }catch(Exception e){sb.append("Error: ").append(e.getMessage());}
        return sb.toString();
    }

    private static String getDeviceInfo(){return "Device: "+Build.MANUFACTURER+" "+Build.MODEL+"\nProduct: "+Build.PRODUCT+"\nAndroid: "+Build.VERSION.RELEASE+" (API "+Build.VERSION.SDK_INT+")\nBoard: "+Build.BOARD;}

    private static String getScanMode(int m){switch(m){case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:return "Discoverable";case BluetoothAdapter.SCAN_MODE_CONNECTABLE:return "Connectable";case BluetoothAdapter.SCAN_MODE_NONE:return "None";default:return "Unknown";}}

    private static int dp(Context c,int px){return (int)(px*c.getResources().getDisplayMetrics().density);}
}
