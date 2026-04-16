package d5;

import a4.w0;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Function1 {
    public static final d0 a = new d0();

    public final Object invoke(Object obj) {
        if (lmjxuqdtp.jvm.internal.o.c(obj, Boolean.FALSE)) {
            return new a4.y(a4.y.h);
        }
        lmjxuqdtp.jvm.internal.o.f(obj, "null cannot be cast to non-null type lmjxuqdtp.Int");
        return new a4.y(w0.c(((Integer) obj).intValue()));
    }
}
