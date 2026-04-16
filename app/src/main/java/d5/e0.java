package d5;

import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements r3.k {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ Function1 b;

    public e0(Function1 function1, Function2 function2) {
        this.a = function2;
        this.b = function1;
    }

    public final Object b(r3.b bVar, Object obj) {
        return this.a.invoke(bVar, obj);
    }

    public final Object d(Object obj) {
        return this.b.invoke(obj);
    }
}
