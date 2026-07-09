package com.carrpod.marmalade.util;
import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class GitCommsHelper {
    private static final String DEF_URL = "https://raw.githubusercontent.com/ZirconiaAegisC/CarrPod/main/";
    public static String getBaseUrl(Context c){return c.getSharedPreferences("marmalade_settings",Context.MODE_PRIVATE).getString("git_url",DEF_URL);}
    public static String fetchUrl(String u){StringBuilder r=new StringBuilder();try{HttpURLConnection cn=(HttpURLConnection)new URL(u).openConnection();cn.setRequestMethod("GET");cn.setConnectTimeout(5000);cn.setReadTimeout(5000);if(cn.getResponseCode()==200){BufferedReader rd=new BufferedReader(new InputStreamReader(cn.getInputStream()));String ln;while((ln=rd.readLine())!=null)r.append(ln).append("\n");rd.close();}cn.disconnect();}catch(Exception e){return "Error: "+e.getMessage();}return r.toString();}
}
