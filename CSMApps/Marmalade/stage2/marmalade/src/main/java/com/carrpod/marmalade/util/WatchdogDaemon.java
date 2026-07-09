package com.carrpod.marmalade.util;
import java.text.SimpleDateFormat;
import java.util.Date;
public class WatchdogDaemon {
    private String cmd; private long expMs; private int maxR; private long start; private int attempts; private String err;
    public WatchdogDaemon(String c,long e,int m){this.cmd=c;this.expMs=e;this.maxR=m;this.attempts=0;this.err=null;}
    public void start(){this.start=System.currentTimeMillis();this.attempts++;}
    public boolean timeout(){return (System.currentTimeMillis()-start)>(expMs*2);}
    public boolean shouldRetry(){return attempts<maxR;}
    public void recordError(String e){this.err=e;}
    public String logLine(boolean ok){return String.format("[%s] [%s] [%s] [%dms %d/%d]",new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(new Date()),cmd,ok?"OK":"FAIL:"+err,System.currentTimeMillis()-start,attempts,maxR);}
}
