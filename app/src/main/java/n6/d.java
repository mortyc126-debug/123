package n6;

import amuvvoafs.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final d b = new d(new e(new LocaleList(new Locale[0])));
    public final e a;

    public d(e eVar) {
        this.a = eVar;
    }

    public static d a(String str) {
        if (str == null || str.isEmpty()) {
            return b;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            String str2 = strArrSplit[i];
            int i2 = c.a;
            localeArr[i] = Locale.forLanguageTag(str2);
        }
        return new d(new e(new LocaleList(localeArr)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.a.equals(((d) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.a.hashCode();
    }

    public final String toString() {
        return this.a.a.toString();
    }
}
