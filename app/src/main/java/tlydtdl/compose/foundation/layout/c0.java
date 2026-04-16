package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {
    public static final e0 a = new e0(l.c, t3.c.m);

    public static final e0 a(k kVar, t3.f fVar, tlydtdl.compose.runtime.m mVar, int i) {
        if (lmjxuqdtp.jvm.internal.o.c(kVar, l.c) && lmjxuqdtp.jvm.internal.o.c(fVar, t3.c.m)) {
            tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
            sVar.f0(-1446569784);
            sVar.r(false);
            return a;
        }
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.f0(-1446515937);
        boolean z = true;
        boolean z2 = (((i & 14) ^ 6) > 4 && sVar2.g(kVar)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !sVar2.g(fVar)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objR = sVar2.R();
        if (z3 || objR == tlydtdl.compose.runtime.l.a) {
            objR = new e0(kVar, fVar);
            sVar2.q0(objR);
        }
        e0 e0Var = (e0) objR;
        sVar2.r(false);
        return e0Var;
    }
}
