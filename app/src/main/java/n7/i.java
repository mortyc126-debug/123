package n7;

import amuvvoafs.content.Context;
import java.util.LinkedHashSet;
import java.util.Set;
import lmjxuqdtp.jvm.internal.o;
import tlydtdl.lifecycle.a0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static final LinkedHashSet a = new LinkedHashSet();

    public static final m7.c a(Context context, String str, Set set) {
        o.h(context, "context");
        o.h(str, "sharedPreferencesName");
        o.h(set, "keysToMigrate");
        return set == a ? new m7.c(context, str, new a0(set, null, 27), new es0.d(3, 4, null), 4) : new m7.c(context, str, set, new a0(set, null, 27), new es0.d(3, 4, null));
    }
}
