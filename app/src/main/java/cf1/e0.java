package cf1;

import a4.y;
import c4.d;
import c4.e;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.jvm.functions.Function1;
import org.apache.commons.net.ftp.FTPReply;
import p5.f;
import tlydtdl.compose.runtime.f3;
import x3.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e0 implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ f3 b;
    public final /* synthetic */ f3 c;

    public /* synthetic */ e0(f3 f3Var, f3 f3Var2, int i) {
        this.a = i;
        this.b = f3Var;
        this.c = f3Var2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    public final Object invoke(Object obj) throws KotlinNothingValueException {
        switch (this.a) {
            case 0:
                c cVar = (c) obj;
                lmjxuqdtp.jvm.internal.o.h(cVar, "$this$drawWithCache");
                return cVar.b(new e0(this.b, this.c, 1));
            default:
                s4.l0 l0Var = (s4.l0) obj;
                lmjxuqdtp.jvm.internal.o.h(l0Var, "$this$onDrawWithContent");
                l0Var.b();
                d.y0(l0Var, ((y) this.b.getValue()).a, l0Var.w0(((f) this.c.getValue()).a), l0Var.a.H0(), 0.0f, (e) null, 0, FTPReply.SERVICE_NOT_READY);
                return lx1.b0.a;
        }
    }
}
