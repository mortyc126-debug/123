package g4;

import a4.b1;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e0 {
    public Function1 a;

    public abstract void a(c4.d dVar);

    public Function1 b() {
        return this.a;
    }

    public final void c() {
        Function1 function1B = b();
        if (function1B != null) {
            function1B.invoke(this);
        }
    }

    public void d(b1 b1Var) {
        this.a = b1Var;
    }
}
