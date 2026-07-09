package com.carrpod.marmalade.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.carrpod.marmalade.models.SessionModel;
import java.util.HashMap;
import java.util.Map;

public class SessionStorage {
    private static final String PREFS_NAME = "marmalade_sessions";
    private static final int MAX_SLOTS = 100;
    private final SharedPreferences prefs;
    private final Map<Integer, SessionModel> cache;

    public SessionStorage(Context ctx) {
        prefs = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        cache = new HashMap<>();
        loadAll();
    }

    private String key(int s, String f) { return "s_" + s + "_" + f; }

    private void loadAll() {
        for (int i = 1; i <= MAX_SLOTS; i++) {
            String sid = prefs.getString(key(i,"sid"), "");
            if (sid.isEmpty()) continue;
            SessionModel sm = new SessionModel(i);
            sm.sessionId = sid;
            sm.directorId = prefs.getString(key(i,"did"), "");
            sm.codename = prefs.getString(key(i,"cod"), "");
            sm.personName = prefs.getString(key(i,"pnm"), "");
            sm.sopUrl = prefs.getString(key(i,"sop"), "");
            sm.llmEngine = prefs.getString(key(i,"llm"), "");
            sm.gitBranch = prefs.getString(key(i,"git"), "main");
            sm.heartbeatPath = prefs.getString(key(i,"hb"), "");
            sm.outboxPath = prefs.getString(key(i,"out"), "");
            sm.inboxPath = prefs.getString(key(i,"in"), "");
            sm.status = prefs.getInt(key(i,"st"), 0);
            sm.lastHeartbeatTs = prefs.getLong(key(i,"lhb"), 0);
            sm.createdAt = prefs.getLong(key(i,"cat"), 0);
            sm.product = prefs.getString(key(i,"prd"), "");
            cache.put(i, sm);
        }
    }

    public SessionModel getSession(int n) {
        SessionModel s = cache.get(n);
        return s != null ? s : new SessionModel(n);
    }

    public Map<Integer, SessionModel> getAllSessions() { return new HashMap<>(cache); }

    public void saveSession(SessionModel sm) {
        SharedPreferences.Editor e = prefs.edit();
        int s = sm.slotNumber;
        e.putString(key(s,"sid"), sm.sessionId);
        e.putString(key(s,"did"), sm.directorId);
        e.putString(key(s,"cod"), sm.codename);
        e.putString(key(s,"pnm"), sm.personName);
        e.putString(key(s,"sop"), sm.sopUrl);
        e.putString(key(s,"llm"), sm.llmEngine);
        e.putString(key(s,"git"), sm.gitBranch);
        e.putString(key(s,"hb"), sm.heartbeatPath);
        e.putString(key(s,"out"), sm.outboxPath);
        e.putString(key(s,"in"), sm.inboxPath);
        e.putInt(key(s,"st"), sm.status);
        e.putLong(key(s,"lhb"), sm.lastHeartbeatTs);
        e.putLong(key(s,"cat"), sm.createdAt);
        e.putString(key(s,"prd"), sm.product);
        e.apply();
        cache.put(s, sm);
    }

    public void deleteSession(int n) {
        SharedPreferences.Editor e = prefs.edit();
        String[] f = {"sid","did","cod","pnm","sop","llm","git","hb","out","in","st","lhb","cat","prd"};
        for (String ff : f) e.remove(key(n, ff));
        e.apply();
        cache.remove(n);
    }

    public int getActiveCount() {
        int c = 0;
        for (SessionModel sm : cache.values()) if (sm.status == 3) c++;
        return c;
    }

    public int getConfiguredCount() { return cache.size(); }
}
