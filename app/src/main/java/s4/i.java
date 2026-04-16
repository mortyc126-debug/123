package s4;

import lmjxuqdtp.jvm.functions.Function2;
import q4.u0;
import t4.b3;
import tlydtdl.compose.runtime.g3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends lmjxuqdtp.jvm.internal.p implements Function2 {
    public static final i d = new i(2, 0);
    public static final i e = new i(2, 1);

    /* JADX INFO: renamed from: f */
    public static final i f432f = new i(2, 2);
    public static final i g = new i(2, 3);
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(int i, int i2) {
        super(i);
        this.c = i2;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.c) {
            case 0:
                ((Number) obj2).intValue();
                ((l) obj).getClass();
                break;
            case 1:
                ((j0) ((l) obj)).g0((u0) obj2);
                break;
            case 2:
                ((j0) ((l) obj)).h0((t3.p) obj2);
                break;
            default:
                q3.o oVar = (tlydtdl.compose.runtime.c0) obj2;
                j0 j0Var = (j0) ((l) obj);
                j0Var.A = oVar;
                dl.c cVar = j0Var.E;
                g3 g3Var = t4.r1.h;
                q3.o oVar2 = oVar;
                oVar2.getClass();
                j0Var.c0((p5.c) tlydtdl.compose.runtime.a0.v(oVar2, g3Var));
                p5.n nVar = (p5.n) tlydtdl.compose.runtime.a0.v(oVar2, t4.r1.n);
                if (j0Var.y != nVar) {
                    j0Var.y = nVar;
                    j0Var.E();
                    j0 j0VarV = j0Var.v();
                    if (j0VarV != null) {
                        j0VarV.C();
                    }
                    j0Var.D();
                    for (t3.o child$ui_release = (t3.o) cVar.g; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                        child$ui_release.onLayoutDirectionChange();
                    }
                }
                j0Var.i0((b3) tlydtdl.compose.runtime.a0.v(oVar2, t4.r1.s));
                if ((((t3.o) cVar.g).getAggregateChildKindSet$ui_release() & 32768) != 0) {
                    for (t3.o child$ui_release2 = (t3.o) cVar.g; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild$ui_release()) {
                        if ((child$ui_release2.getKindSet$ui_release() & 32768) != 0) {
                            t3.o oVarE = child$ui_release2;
                            k3.e eVar = null;
                            while (oVarE != null) {
                                if (oVarE instanceof m) {
                                    t3.o node = ((m) oVarE).getNode();
                                    if (node.isAttached()) {
                                        l1.d(node);
                                    } else {
                                        node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                                    }
                                } else if ((oVarE.getKindSet$ui_release() & 32768) != 0 && (oVarE instanceof o)) {
                                    int i = 0;
                                    for (t3.o child$ui_release3 = ((o) oVarE).b; child$ui_release3 != null; child$ui_release3 = child$ui_release3.getChild$ui_release()) {
                                        if ((child$ui_release3.getKindSet$ui_release() & 32768) != 0) {
                                            i++;
                                            if (i == 1) {
                                                oVarE = child$ui_release3;
                                            } else {
                                                if (eVar == null) {
                                                    eVar = new k3.e(0, new t3.o[16]);
                                                }
                                                if (oVarE != null) {
                                                    eVar.d(oVarE);
                                                    oVarE = null;
                                                }
                                                eVar.d(child$ui_release3);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                oVarE = g.e(eVar);
                            }
                        }
                        if ((child$ui_release2.getAggregateChildKindSet$ui_release() & 32768) != 0) {
                        }
                    }
                }
                break;
        }
        return lx1.b0.a;
    }
}
