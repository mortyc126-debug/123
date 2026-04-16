/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.provider.ContactsContract$PhoneLookup
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;

public class Tools {
    public static String getContactNameFromNumber(Context context, String string2) {
        block8: {
            Object object;
            block9: {
                if (string2 == null) {
                    return null;
                }
                object = Uri.withAppendedPath((Uri)ContactsContract.PhoneLookup.CONTENT_FILTER_URI, (String)Uri.encode((String)string2));
                string2 = null;
                try {
                    context = context.getContentResolver().query(object, new String[]{"display_name"}, null, null, null);
                    if (context == null) break block8;
                    string2 = context;
                }
                catch (Throwable throwable) {
                    if (string2 != null) {
                        string2.close();
                    }
                    throw throwable;
                }
                if (!context.moveToFirst()) break block8;
                string2 = context;
                int n = context.getColumnIndex("display_name");
                if (n < 0) break block8;
                string2 = context;
                object = context.getString(n);
                if (context == null) break block9;
                context.close();
            }
            return object;
        }
        if (context != null) {
            context.close();
        }
        return null;
    }

    public static String getOrientationString(Context context) {
        try {
            int n = context.getResources().getConfiguration().orientation;
            if (n == 2) {
                return "L";
            }
            if (n == 1) {
                return "P";
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return "U";
    }
}

