package tlydtdl.compose.runtime;

import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends x1 {
    public final /* synthetic */ int b = 1;
    public final Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(Function0 function0) {
        super(function0);
        x0 x0Var = x0.f548f;
        this.c = x0Var;
    }

    @Override // tlydtdl.compose.runtime.x1
    public final y1 a(Object obj) {
        switch (this.b) {
            case 0:
                return new y1(this, obj, obj == null, null, true);
            default:
                return new y1(this, obj, obj == null, (x2) this.c, true);
        }
    }

    @Override // tlydtdl.compose.runtime.x1
    public i3 b() {
        switch (this.b) {
            case 0:
                return (f0) this.c;
            default:
                return super.b();
        }
    }

    public e0(Function1 function1) {
        super(new g(14));
        this.c = new f0(function1);
    }
}
