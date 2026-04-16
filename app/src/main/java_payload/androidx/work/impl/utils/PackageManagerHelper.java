/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 */
package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger;

public class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    private PackageManagerHelper() {
    }

    private static int getComponentEnabledSetting(Context context, String string2) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, string2));
    }

    private static boolean isComponentEnabled(int n, boolean bl) {
        if (n == 0) {
            return bl;
        }
        bl = true;
        if (n != 1) {
            bl = false;
        }
        return bl;
    }

    public static boolean isComponentExplicitlyEnabled(Context context, Class<?> clazz) {
        return PackageManagerHelper.isComponentEnabled(PackageManagerHelper.getComponentEnabledSetting(context, clazz.getName()), false);
    }

    public static boolean isComponentExplicitlyEnabled(Context context, String string2) {
        int n = PackageManagerHelper.getComponentEnabledSetting(context, string2);
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        return bl;
    }

    public static void setComponentEnabled(Context object, Class<?> serializable, boolean bl) {
        String string2 = "enabled";
        if (bl == PackageManagerHelper.isComponentEnabled(PackageManagerHelper.getComponentEnabledSetting((Context)object, ((Class)serializable).getName()), false)) {
            object = Logger.get();
            String string3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            ((Logger)object).debug(string3, stringBuilder.append("Skipping component enablement for ").append(((Class)serializable).getName()).toString());
            return;
        }
        Object object2 = object.getPackageManager();
        Object object3 = new ComponentName((Context)object, ((Class)serializable).getName());
        int n = bl ? 1 : 2;
        object2.setComponentEnabledSetting((ComponentName)object3, n, 1);
        object3 = Logger.get();
        object2 = TAG;
        object = new StringBuilder();
        CharSequence charSequence = ((StringBuilder)object).append(((Class)serializable).getName()).append(" ");
        object = bl ? "enabled" : "disabled";
        try {
            ((Logger)object3).debug((String)object2, ((StringBuilder)charSequence).append((String)object).toString());
        }
        catch (Exception exception) {
            object2 = Logger.get();
            charSequence = TAG;
            serializable = new StringBuilder().append(((Class)serializable).getName()).append("could not be ");
            object = bl ? string2 : "disabled";
            ((Logger)object2).debug((String)charSequence, ((StringBuilder)serializable).append((String)object).toString(), exception);
        }
    }
}

