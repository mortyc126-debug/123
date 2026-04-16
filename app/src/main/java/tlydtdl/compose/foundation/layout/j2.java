package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j2 {
    public static final l2 a = new l2(l.a, t3.c.j);

    public static final l2 a(h hVar, t3.g gVar, tlydtdl.compose.runtime.m mVar, int i) {
        if (lmjxuqdtp.jvm.internal.o.c(hVar, l.a) && lmjxuqdtp.jvm.internal.o.c(gVar, t3.c.j)) {
            tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
            sVar.f0(-1073795767);
            sVar.r(false);
            return a;
        }
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.f0(-1073744896);
        boolean z = true;
        boolean z2 = (((i & 14) ^ 6) > 4 && sVar2.g(hVar)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !sVar2.g(gVar)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objR = sVar2.R();
        if (z3 || objR == tlydtdl.compose.runtime.l.a) {
            objR = new l2(hVar, gVar);
            sVar2.q0(objR);
        }
        l2 l2Var = (l2) objR;
        sVar2.r(false);
        return l2Var;
    }
}
