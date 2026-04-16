package tlydtdl.fragment.app;

import amuvvoafs.view.View;
import lmjxuqdtp.jvm.internal.o;
import o6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public final j2 a;

    public k(j2 j2Var) {
        o.h(j2Var, "operation");
        this.a = j2Var;
    }

    public final boolean a() {
        int i;
        j2 j2Var = this.a;
        View view = j2Var.c.mView;
        if (view != null) {
            i = 4;
            if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                int visibility = view.getVisibility();
                if (visibility == 0) {
                    i = 2;
                } else if (visibility != 4) {
                    if (visibility != 8) {
                        throw new IllegalArgumentException(c.k(visibility, "Unknown visibility "));
                    }
                    i = 3;
                }
            }
        } else {
            i = 0;
        }
        int i2 = j2Var.a;
        if (i != i2) {
            return (i == 2 || i2 == 2) ? false : true;
        }
        return true;
    }
}
