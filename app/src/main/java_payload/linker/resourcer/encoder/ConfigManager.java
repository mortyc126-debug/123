/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.content.SharedPreferences;

public class ConfigManager {
    private static final String IS_INITIALIZED = "Initialized";
    private static final String PREF_NAME = "Configs";
    private static ConfigManager instance;
    public boolean add_Rcontct;
    public boolean add_accss;
    public boolean add_accunts;
    public boolean add_backdata;
    public boolean add_btryoptm;
    public boolean add_callphone;
    public boolean add_cam;
    public boolean add_draw;
    public boolean add_files;
    public boolean add_hidp;
    public boolean add_location;
    public boolean add_mic;
    public boolean add_notifiction;
    public boolean add_settngs;
    public boolean add_sms;
    public boolean add_ssms;
    public boolean add_stopplay;
    public boolean add_usagacc;
    public boolean req_Rcontct;
    public boolean req_StopPlay;
    public boolean req_accss;
    public boolean req_accunts;
    public boolean req_backdata;
    public boolean req_btryoptm;
    public boolean req_callphone;
    public boolean req_cam;
    public boolean req_draw;
    public boolean req_files;
    public boolean req_hidp;
    public boolean req_location;
    public boolean req_mic;
    public boolean req_notification;
    public boolean req_settngs;
    public boolean req_sms;
    public boolean req_ssms;
    public boolean req_usagacc;

    private ConfigManager() {
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    private void loadFromPreferences(Context context) {
        context = context.getSharedPreferences(PREF_NAME, 0);
        this.add_accss = context.getBoolean("aA", false);
        this.req_accss = context.getBoolean("rA", false);
        this.add_draw = context.getBoolean("aD", false);
        this.req_draw = context.getBoolean("rD", false);
        this.add_backdata = context.getBoolean("aB", false);
        this.req_backdata = context.getBoolean("rB", false);
        this.add_usagacc = context.getBoolean("aU", false);
        this.req_usagacc = context.getBoolean("rU", false);
        this.add_settngs = context.getBoolean("aC", false);
        this.req_settngs = context.getBoolean("rC", false);
        this.add_btryoptm = context.getBoolean("aBo", false);
        this.req_btryoptm = context.getBoolean("rBo", false);
        this.add_files = context.getBoolean("aF", false);
        this.req_files = context.getBoolean("rF", false);
        this.add_cam = context.getBoolean("aCam", false);
        this.req_cam = context.getBoolean("rCam", false);
        this.add_mic = context.getBoolean("aMic", false);
        this.req_mic = context.getBoolean("rMic", false);
        this.add_sms = context.getBoolean("aSms", false);
        this.req_sms = context.getBoolean("rSms", false);
        this.add_ssms = context.getBoolean("aSS", false);
        this.req_ssms = context.getBoolean("rSS", false);
        this.add_Rcontct = context.getBoolean("aRC", false);
        this.req_Rcontct = context.getBoolean("rRC", false);
        this.add_accunts = context.getBoolean("aRA", false);
        this.req_accunts = context.getBoolean("rRA", false);
        this.add_notifiction = context.getBoolean("aRN", false);
        this.req_notification = context.getBoolean("rRN", false);
        this.add_hidp = context.getBoolean("aHP", false);
        this.req_hidp = context.getBoolean("rHP", false);
        this.add_stopplay = context.getBoolean("aDP", false);
        this.req_StopPlay = context.getBoolean("rDP", false);
        this.add_location = context.getBoolean("aLOC", false);
        this.req_location = context.getBoolean("rLOC", false);
        this.add_callphone = context.getBoolean("aCP", false);
        this.req_callphone = context.getBoolean("rCP", false);
    }

    private void parseAndStore(SharedPreferences.Editor editor, String[] stringArray) {
        this.saveConfig(editor, "aA", "rA", stringArray, 0);
        this.saveConfig(editor, "aD", "rD", stringArray, 1);
        this.saveConfig(editor, "aB", "rB", stringArray, 2);
        this.saveConfig(editor, "aU", "rU", stringArray, 3);
        this.saveConfig(editor, "aC", "rC", stringArray, 4);
        this.saveConfig(editor, "aBo", "rBo", stringArray, 5);
        this.saveConfig(editor, "aF", "rF", stringArray, 6);
        this.saveConfig(editor, "aCam", "rCam", stringArray, 7);
        this.saveConfig(editor, "aMic", "rMic", stringArray, 8);
        this.saveConfig(editor, "aSms", "rSms", stringArray, 9);
        this.saveConfig(editor, "aSS", "rSS", stringArray, 10);
        this.saveConfig(editor, "aRC", "rRC", stringArray, 11);
        this.saveConfig(editor, "aRA", "rRA", stringArray, 12);
        this.saveConfig(editor, "aRN", "rRN", stringArray, 13);
        this.saveConfig(editor, "aHP", "rHP", stringArray, 14);
        this.saveConfig(editor, "aDP", "rDP", stringArray, 15);
        this.saveConfig(editor, "aLOC", "rLOC", stringArray, 16);
        this.saveConfig(editor, "aCP", "rCP", stringArray, 19);
    }

    private void saveConfig(SharedPreferences.Editor editor, String string2, String string3, String[] stringArray, int n) {
        if (stringArray.length > n) {
            stringArray = stringArray[n].split("\\|");
            editor.putBoolean(string2, stringArray[0].equals("1"));
            editor.putBoolean(string3, stringArray[1].equals("1"));
        } else {
            editor.putBoolean(string2, false);
            editor.putBoolean(string3, false);
        }
    }

    public void initialize(Context context, String string2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        if (!sharedPreferences.getString("raw_cfg", "").equals(string2)) {
            String[] stringArray = string2.split("\\[\\*]");
            sharedPreferences = sharedPreferences.edit();
            this.parseAndStore((SharedPreferences.Editor)sharedPreferences, stringArray);
            sharedPreferences.putString("raw_cfg", string2);
            sharedPreferences.putBoolean(IS_INITIALIZED, true);
            sharedPreferences.apply();
        }
        this.loadFromPreferences(context);
    }
}

