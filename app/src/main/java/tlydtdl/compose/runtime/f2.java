package tlydtdl.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lmjxuqdtp.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f2 extends sx1.i implements Function3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f530j;
    public List k;
    public List l;
    public q1.o0 m;
    public q1.o0 n;
    public q1.o0 o;
    public Set p;
    public q1.o0 q;
    public int r;
    public /* synthetic */ y0 s;
    public final /* synthetic */ g2 t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f2(g2 g2Var, qx1.d dVar) {
        super(3, dVar);
        this.t = g2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(tlydtdl.compose.runtime.g2 r22, java.util.List r23, java.util.List r24, java.util.List r25, q1.o0 r26, q1.o0 r27, q1.o0 r28, q1.o0 r29) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.f2.b(tlydtdl.compose.runtime.g2, java.util.List, java.util.List, java.util.List, q1.o0, q1.o0, q1.o0, q1.o0):void");
    }

    public static final void c(List list, g2 g2Var) {
        list.clear();
        synchronized (g2Var.b) {
            try {
                ArrayList arrayList = g2Var.f533j;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    list.add((c1) arrayList.get(i));
                }
                g2Var.f533j.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        f2 f2Var = new f2(this.t, (qx1.d) obj3);
        f2Var.s = (y0) obj2;
        f2Var.invokeSuspend(lx1.b0.a);
        return rx1.a.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0099 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0125 -> B:44:0x012d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0203 -> B:12:0x0094). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.f2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
