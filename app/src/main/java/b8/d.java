package b8;

import java.util.Arrays;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.o;
import tlydtdl.lifecycle.o1;
import tlydtdl.lifecycle.r1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements r1 {
    public final g[] a;

    public d(g... gVarArr) {
        o.h(gVarArr, "initializers");
        this.a = gVarArr;
    }

    @Override // tlydtdl.lifecycle.r1
    public final o1 c(Class cls, f fVar) {
        o1 o1Var;
        g gVar;
        Function1 function1;
        lmjxuqdtp.jvm.internal.f fVarA = d0.a(cls);
        g[] gVarArr = this.a;
        g[] gVarArr2 = (g[]) Arrays.copyOf(gVarArr, gVarArr.length);
        o.h(gVarArr2, "initializers");
        int length = gVarArr2.length;
        int i = 0;
        while (true) {
            o1Var = null;
            if (i >= length) {
                gVar = null;
                break;
            }
            gVar = gVarArr2[i];
            if (gVar.a.equals(fVarA)) {
                break;
            }
            i++;
        }
        if (gVar != null && (function1 = gVar.b) != null) {
            o1Var = (o1) function1.invoke(fVar);
        }
        if (o1Var != null) {
            return o1Var;
        }
        throw new IllegalArgumentException(("No initializer set for given class " + fVarA.e()).toString());
    }
}
