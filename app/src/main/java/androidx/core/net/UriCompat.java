/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.core.net;

import android.net.Uri;

public final class UriCompat {
    private UriCompat() {
    }

    public static String toSafeString(Uri object) {
        String string2;
        String string3;
        block8: {
            String string4;
            block9: {
                block10: {
                    string3 = object.getScheme();
                    string2 = string4 = object.getSchemeSpecificPart();
                    if (string3 == null) break block8;
                    if (string3.equalsIgnoreCase("tel") || string3.equalsIgnoreCase("sip") || string3.equalsIgnoreCase("sms") || string3.equalsIgnoreCase("smsto") || string3.equalsIgnoreCase("mailto") || string3.equalsIgnoreCase("nfc")) break block9;
                    if (string3.equalsIgnoreCase("http") || string3.equalsIgnoreCase("https") || string3.equalsIgnoreCase("ftp")) break block10;
                    string2 = string4;
                    if (!string3.equalsIgnoreCase("rtsp")) break block8;
                }
                StringBuilder stringBuilder = new StringBuilder().append("//");
                string2 = object.getHost();
                string4 = "";
                string2 = string2 != null ? object.getHost() : "";
                stringBuilder = stringBuilder.append(string2);
                string2 = string4;
                if (object.getPort() != -1) {
                    string2 = ":" + object.getPort();
                }
                string2 = stringBuilder.append(string2).append("/...").toString();
                break block8;
            }
            object = new StringBuilder(64);
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(':');
            if (string4 != null) {
                for (int i = 0; i < string4.length(); ++i) {
                    char c = string4.charAt(i);
                    if (c != '-' && c != '@' && c != '.') {
                        ((StringBuilder)object).append('x');
                        continue;
                    }
                    ((StringBuilder)object).append(c);
                }
            }
            return ((StringBuilder)object).toString();
        }
        object = new StringBuilder(64);
        if (string3 != null) {
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(':');
        }
        if (string2 != null) {
            ((StringBuilder)object).append(string2);
        }
        return ((StringBuilder)object).toString();
    }
}

