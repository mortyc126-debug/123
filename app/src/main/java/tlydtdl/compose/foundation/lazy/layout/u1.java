package tlydtdl.compose.foundation.lazy.layout;

import amuvvoafs.os.Build;
import java.util.Locale;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u1 {
    public static final t1 a;

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        o.g(lowerCase, "toLowerCase(...)");
        a = lowerCase.equals("robolectric") ? new t1() : null;
    }
}
