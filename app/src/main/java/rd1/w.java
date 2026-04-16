package rd1;

import lmjxuqdtp.NoWhenBranchMatchedException;
import tlydtdl.compose.foundation.layout.f2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class w {
    public static final /* synthetic */ w a = new w();
    public static final y b = new y(null, 0.0f, 0.0f, 15);
    public static final z c = new z(null, 0.0f, null, 15);
    public static final v d = new v(null, 0.0f, 0.0f, null, 15);

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public static f2 a(a0 a0Var) throws NoWhenBranchMatchedException {
        lmjxuqdtp.jvm.internal.o.h(a0Var, "layoutParams");
        if (a0Var instanceof v) {
            return tlydtdl.compose.foundation.layout.m.f(4, 0.0f, 2);
        }
        if (a0Var instanceof z) {
            return tlydtdl.compose.foundation.layout.m.f(6, 0.0f, 2);
        }
        if (a0Var instanceof y) {
            return tlydtdl.compose.foundation.layout.m.f(8, 0.0f, 2);
        }
        if (a0Var instanceof x) {
            return tlydtdl.compose.foundation.layout.m.f(0.0f, 0.0f, 3);
        }
        throw new NoWhenBranchMatchedException();
    }
}
