/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.core.net;

import android.net.Uri;
import androidx.core.net.ParseException;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class MailTo {
    private static final String BCC = "bcc";
    private static final String BODY = "body";
    private static final String CC = "cc";
    private static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";
    private static final String TO = "to";
    private HashMap<String, String> mHeaders = new HashMap();

    private MailTo() {
    }

    public static boolean isMailTo(Uri uri) {
        boolean bl = uri != null && MAILTO.equals(uri.getScheme());
        return bl;
    }

    public static boolean isMailTo(String string2) {
        boolean bl = string2 != null && string2.startsWith(MAILTO_SCHEME);
        return bl;
    }

    public static MailTo parse(Uri uri) throws ParseException {
        return MailTo.parse(uri.toString());
    }

    public static MailTo parse(String stringArray) throws ParseException {
        Preconditions.checkNotNull(stringArray);
        if (MailTo.isMailTo((String)stringArray)) {
            String[] stringArray2;
            int n = stringArray.indexOf(35);
            Object object = stringArray;
            if (n != -1) {
                object = stringArray.substring(0, n);
            }
            if ((n = object.indexOf(63)) == -1) {
                stringArray = Uri.decode((String)object.substring(MAILTO_SCHEME.length()));
                object = null;
            } else {
                stringArray = Uri.decode((String)object.substring(MAILTO_SCHEME.length(), n));
                object = object.substring(n + 1);
            }
            MailTo mailTo = new MailTo();
            if (object != null) {
                stringArray2 = object.split("&");
                int n2 = stringArray2.length;
                for (n = 0; n < n2; ++n) {
                    object = stringArray2[n].split("=", 2);
                    if (((String[])object).length == 0) continue;
                    String string2 = Uri.decode((String)object[0]).toLowerCase(Locale.ROOT);
                    object = ((String[])object).length > 1 ? Uri.decode((String)object[1]) : null;
                    mailTo.mHeaders.put(string2, (String)object);
                }
            }
            stringArray2 = mailTo.getTo();
            object = stringArray;
            if (stringArray2 != null) {
                object = (String)stringArray + ", " + (String)stringArray2;
            }
            mailTo.mHeaders.put(TO, (String)object);
            return mailTo;
        }
        throw new ParseException("Not a mailto scheme");
    }

    public String getBcc() {
        return this.mHeaders.get(BCC);
    }

    public String getBody() {
        return this.mHeaders.get(BODY);
    }

    public String getCc() {
        return this.mHeaders.get(CC);
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public String getSubject() {
        return this.mHeaders.get(SUBJECT);
    }

    public String getTo() {
        return this.mHeaders.get(TO);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(MAILTO_SCHEME);
        stringBuilder.append('?');
        for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
            stringBuilder.append(Uri.encode((String)entry.getKey()));
            stringBuilder.append('=');
            stringBuilder.append(Uri.encode((String)entry.getValue()));
            stringBuilder.append('&');
        }
        return stringBuilder.toString();
    }
}

