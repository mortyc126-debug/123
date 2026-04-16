package tlydtdl.compose.foundation.lazy.layout;

import com.gnacba.amuvvoafs.gms.internal.measurement.i4;
import java.util.List;
import jh0.s;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;
import t3.p;
import tlydtdl.compose.foundation.layout.e2;
import tlydtdl.compose.foundation.layout.f2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k0 implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ p b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f505f;
    public final /* synthetic */ Object g;

    public /* synthetic */ k0(int i, int i2, int i3, Object obj, Object obj2, Object obj3, p pVar) {
        this.a = i3;
        this.c = obj;
        this.b = pVar;
        this.f505f = obj2;
        this.g = obj3;
        this.d = i;
        this.e = i2;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, java.util.List] */
    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Integer) obj2).getClass();
                m.d((Function0) this.c, this.b, (z0) this.f505f, (o0) this.g, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
            case 1:
                ((Integer) obj2).getClass();
                s.d((mu0.r) this.f505f, (of1.n) this.g, this.b, (Function0) this.c, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
            case 2:
                ((Integer) obj2).getClass();
                ve.g.h((List) this.c, this.b, (tlydtdl.compose.foundation.layout.h) this.f505f, (tlydtdl.compose.foundation.layout.j) this.g, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
            case 3:
                ((Integer) obj2).getClass();
                ve.g.h((List) this.c, this.b, (tlydtdl.compose.foundation.layout.h) this.f505f, (tlydtdl.compose.foundation.layout.k) this.g, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
            case 4:
                ((Integer) obj2).getClass();
                int iB = tlydtdl.compose.runtime.a0.B(1);
                ve.g.j((x10.l) this.c, this.d, (of1.n) this.f505f, this.b, (ld1.r) this.g, (tlydtdl.compose.runtime.m) obj, iB, this.e);
                break;
            case 5:
                ((Integer) obj2).getClass();
                x10.a.b(this.b, (i4) this.c, (e2) this.f505f, (q3.k) this.g, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
            case 6:
                ((Integer) obj2).getClass();
                y10.r.s((wz0.i0) this.c, (f2) this.f505f, this.b, (q3.k) this.g, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
            default:
                ((Integer) obj2).getClass();
                y10.r.q((wz0.i0) this.f505f, this.b, (String) this.g, (Function0) this.c, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ k0(mu0.r rVar, of1.n nVar, p pVar, Function0 function0, int i, int i2) {
        this.a = 1;
        this.f505f = rVar;
        this.g = nVar;
        this.b = pVar;
        this.c = function0;
        this.d = i;
        this.e = i2;
    }

    public /* synthetic */ k0(p pVar, i4 i4Var, e2 e2Var, q3.k kVar, int i, int i2) {
        this.a = 5;
        this.b = pVar;
        this.c = i4Var;
        this.f505f = e2Var;
        this.g = kVar;
        this.d = i;
        this.e = i2;
    }

    public /* synthetic */ k0(wz0.i0 i0Var, f2 f2Var, p pVar, q3.k kVar, int i, int i2) {
        this.a = 6;
        this.c = i0Var;
        this.f505f = f2Var;
        this.b = pVar;
        this.g = kVar;
        this.d = i;
        this.e = i2;
    }

    public /* synthetic */ k0(wz0.i0 i0Var, p pVar, String str, Function0 function0, int i, int i2) {
        this.a = 7;
        this.f505f = i0Var;
        this.b = pVar;
        this.g = str;
        this.c = function0;
        this.d = i;
        this.e = i2;
    }

    public /* synthetic */ k0(x10.l lVar, int i, of1.n nVar, p pVar, ld1.r rVar, int i2, int i3) {
        this.a = 4;
        this.c = lVar;
        this.d = i;
        this.f505f = nVar;
        this.b = pVar;
        this.g = rVar;
        this.e = i3;
    }
}
