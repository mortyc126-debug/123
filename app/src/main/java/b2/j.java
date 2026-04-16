package b2;

import a2.x2;
import java.util.concurrent.CancellationException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.z;
import lx1.b0;
import st.w0;
import t1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ float b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ j(float f2, z zVar, x2 x2Var, Function1 function1) {
        this.b = f2;
        this.d = zVar;
        this.e = x2Var;
        this.c = function1;
    }

    public final Object invoke(Object obj) {
        float f2;
        boolean z;
        switch (this.a) {
            case 0:
                z zVar = (z) this.d;
                x2 x2Var = (x2) this.e;
                i iVar = (i) obj;
                float fD = m.d(((Number) iVar.e.getValue()).floatValue(), this.b);
                float f3 = fD - zVar.a;
                try {
                    f2 = x2Var.f(f3);
                    break;
                } catch (CancellationException unused) {
                    iVar.a();
                    f2 = 0.0f;
                }
                this.c.invoke(Float.valueOf(f2));
                if (Math.abs(f3 - f2) > 0.5f || fD != ((Number) iVar.e.getValue()).floatValue()) {
                    iVar.a();
                }
                zVar.a += f2;
                return b0.a;
            default:
                ey1.f fVar = (ey1.f) this.d;
                Function0 function0 = (Function0) this.e;
                float fI = w0.i(((Float) obj).floatValue(), ((Number) fVar.b()).floatValue(), ((Number) fVar.h()).floatValue());
                if (fI == this.b) {
                    z = false;
                } else {
                    this.c.invoke(Float.valueOf(fI));
                    z = true;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
                return Boolean.valueOf(z);
        }
    }

    public /* synthetic */ j(ey1.f fVar, float f2, Function1 function1, Function0 function0) {
        this.d = fVar;
        this.b = f2;
        this.c = function1;
        this.e = function0;
    }
}
