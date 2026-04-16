/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.text.TextUtils
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SharedPreferencesManager {
    private static final String LIST_DELIMITER = "\u201a\u2017\u2017\u201a";
    private static SharedPreferences mSharedPref;

    public static void ClearList(Context context, String string2) {
        try {
            SharedPreferencesManager.init(context);
            context = mSharedPref.edit();
            context.remove(string2);
            context.apply();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String Read(Context object, String string2, String string3) {
        try {
            SharedPreferencesManager.init(object);
            object = mSharedPref.getString(string2, string3);
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return string3;
        }
    }

    public static boolean ReadBool(Context context, String string2, boolean bl) {
        try {
            SharedPreferencesManager.init(context);
            boolean bl2 = mSharedPref.getBoolean(string2, bl);
            return bl2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return bl;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ArrayList<String> ReadList(Context object, String string2) {
        try {
            SharedPreferencesManager.init((Context)object);
            object = mSharedPref.getString(string2, null);
            if (object == null) return new ArrayList();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        if (!((String)object).isEmpty()) return new ArrayList<String>(Arrays.asList(((String)object).split(LIST_DELIMITER, -1)));
        return new ArrayList();
    }

    public static void Write(Context context, String string2, String string3) {
        try {
            SharedPreferencesManager.init(context);
            context = mSharedPref.edit();
            context.putString(string2, string3);
            context.apply();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void WriteBool(Context context, String string2, boolean bl) {
        try {
            SharedPreferencesManager.init(context);
            context = mSharedPref.edit();
            context.putBoolean(string2, bl);
            context.apply();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void WriteList(Context object, String string2, ArrayList<String> editor) {
        try {
            SharedPreferencesManager.init((Context)object);
            object = mSharedPref.getString(string2, null);
            ArrayList<String> arrayList = new ArrayList<String>();
            if (object != null && !((String)object).isEmpty()) {
                arrayList.addAll(Arrays.asList(((String)object).split(LIST_DELIMITER, -1)));
            }
            if (editor != null && !editor.isEmpty()) {
                arrayList.addAll((Collection<String>)editor);
            }
            object = TextUtils.join((CharSequence)LIST_DELIMITER, arrayList);
            editor = mSharedPref.edit();
            editor.putString(string2, (String)object);
            editor.commit();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void init(Context context) {
        if (mSharedPref == null) {
            mSharedPref = context.getSharedPreferences(context.getPackageName(), 0);
        }
    }
}

