package fs0;

import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Function0 b;

    public /* synthetic */ z(int i, Function0 function0) {
        this.a = i;
        this.b = function0;
    }

    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                lf1.i iVar = (lf1.i) obj;
                lmjxuqdtp.jvm.internal.o.h(iVar, "value");
                if (iVar != lf1.i.c) {
                    this.b.invoke();
                }
                return Boolean.TRUE;
            case 1:
                this.b.invoke();
                break;
            case 2:
                lmjxuqdtp.jvm.internal.o.h((Function0) obj, "it");
                this.b.invoke();
                break;
            case 3:
                this.b.invoke();
                break;
            case 4:
                this.b.invoke();
                break;
            case 5:
                this.b.invoke();
                break;
            default:
                a5.k kVar = (a5.k) obj;
                lmjxuqdtp.jvm.internal.o.h(kVar, "$this$semantics");
                a5.v.g(kVar, new a5.g(((Number) this.b.invoke()).floatValue(), new ey1.e(0.0f, 1.0f), 0));
                break;
        }
        return lx1.b0.a;
    }
}
