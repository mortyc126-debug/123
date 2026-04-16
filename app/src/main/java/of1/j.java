package of1;

import fs0.z;
import java.util.LinkedHashMap;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public final LinkedHashMap a = new LinkedHashMap();
    public final LinkedHashMap b = new LinkedHashMap();

    public final void a(Function0 function0) {
        this.a.put(null, new z(3, function0));
    }

    public final void b(String str, Function1 function1) {
        lmjxuqdtp.jvm.internal.o.h(str, "key");
        this.a.put(str, function1);
    }
}
