package g10;

import amuvvoafs.view.View;
import b02.d0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends jr1.c {
    public final /* synthetic */ wu0.a a;
    public final /* synthetic */ wu0.a b;

    public c(d0 d0Var, d0 d0Var2) {
        this.a = d0Var;
        this.b = d0Var2;
    }

    public final void onSlide(View view, float f2) {
    }

    public final void onStateChanged(View view, int i) {
        wu0.a aVar;
        if (i == 3) {
            wu0.a aVar2 = this.a;
            if (aVar2 != null) {
                aVar2.call();
                return;
            }
            return;
        }
        if (i == 4 || i != 5 || (aVar = this.b) == null) {
            return;
        }
        aVar.call();
    }
}
