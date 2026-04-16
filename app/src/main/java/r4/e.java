package r4;

import lmjxuqdtp.KotlinNothingValueException;
import s4.d2;
import s4.j0;
import s4.n;
import t3.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface e extends g, n {
    default uz1.g G() {
        return b.a;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    @Override // r4.g
    default Object f(h hVar) throws KotlinNothingValueException {
        dl.c cVar;
        o oVar = (o) this;
        if (!oVar.getNode().isAttached()) {
            p4.a.a("ModifierLocal accessed from an unattached node");
        }
        if (!oVar.getNode().isAttached()) {
            p4.a.b("visitAncestors called on an unattached node");
        }
        o parent$ui_release = oVar.getNode().getParent$ui_release();
        j0 j0VarU = s4.g.u(this);
        while (j0VarU != null) {
            if ((((o) j0VarU.E.g).getAggregateChildKindSet$ui_release() & 32) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & 32) != 0) {
                        o oVarE = parent$ui_release;
                        k3.e eVar = null;
                        while (oVarE != null) {
                            if (oVarE instanceof e) {
                                e eVar2 = (e) oVarE;
                                if (eVar2.G().m(hVar)) {
                                    return eVar2.G().s(hVar);
                                }
                            } else if ((oVarE.getKindSet$ui_release() & 32) != 0 && (oVarE instanceof s4.o)) {
                                int i = 0;
                                for (o child$ui_release = ((s4.o) oVarE).b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                                    if ((child$ui_release.getKindSet$ui_release() & 32) != 0) {
                                        i++;
                                        if (i == 1) {
                                            oVarE = child$ui_release;
                                        } else {
                                            if (eVar == null) {
                                                eVar = new k3.e(0, new o[16]);
                                            }
                                            if (oVarE != null) {
                                                eVar.d(oVarE);
                                                oVarE = null;
                                            }
                                            eVar.d(child$ui_release);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            oVarE = s4.g.e(eVar);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            j0VarU = j0VarU.v();
            parent$ui_release = (j0VarU == null || (cVar = j0VarU.E) == null) ? null : (d2) cVar.f89f;
        }
        return hVar.a.invoke();
    }
}
