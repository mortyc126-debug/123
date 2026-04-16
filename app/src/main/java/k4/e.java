package k4;

import amuvvoafs.view.KeyEvent;
import lmjxuqdtp.jvm.functions.Function1;
import t3.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends o implements d {
    public Function1 a;
    public Function1 b;

    @Override // k4.d
    public final boolean Y(KeyEvent keyEvent) {
        Function1 function1 = this.b;
        if (function1 != null) {
            return ((Boolean) function1.invoke(b.a(keyEvent))).booleanValue();
        }
        return false;
    }

    @Override // k4.d
    public final boolean k0(KeyEvent keyEvent) {
        Function1 function1 = this.a;
        if (function1 != null) {
            return ((Boolean) function1.invoke(b.a(keyEvent))).booleanValue();
        }
        return false;
    }
}
