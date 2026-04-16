package r4;

import java.util.HashSet;
import s4.j0;
import t3.o;
import t4.x;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final x a;
    public final k3.e b = new k3.e(0, new s4.d[16]);
    public final k3.e c = new k3.e(0, new h[16]);
    public final k3.e d = new k3.e(0, new j0[16]);
    public final k3.e e = new k3.e(0, new h[16]);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f395f;

    public d(x xVar) {
        this.a = xVar;
    }

    public static void b(o oVar, h hVar, HashSet hashSet) {
        if (!oVar.getNode().isAttached()) {
            p4.a.b("visitSubtreeIf called on an unattached node");
        }
        k3.e eVar = new k3.e(0, new o[16]);
        o child$ui_release = oVar.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            s4.g.b(eVar, oVar.getNode());
        } else {
            eVar.d(child$ui_release);
        }
        while (true) {
            int i = eVar.c;
            if (i == 0) {
                return;
            }
            o oVar2 = (o) eVar.o(i - 1);
            if ((oVar2.getAggregateChildKindSet$ui_release() & 32) != 0) {
                for (o child$ui_release2 = oVar2; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild$ui_release()) {
                    if ((child$ui_release2.getKindSet$ui_release() & 32) != 0) {
                        o oVarE = child$ui_release2;
                        k3.e eVar2 = null;
                        while (oVarE != null) {
                            if (oVarE instanceof e) {
                                e eVar3 = (e) oVarE;
                                if (eVar3 instanceof s4.d) {
                                    s4.d dVar = (s4.d) eVar3;
                                    if ((dVar.a instanceof c) && dVar.c.contains(hVar)) {
                                        hashSet.add(eVar3);
                                    }
                                }
                                if (eVar3.G().m(hVar)) {
                                    break;
                                }
                            } else if ((oVarE.getKindSet$ui_release() & 32) != 0 && (oVarE instanceof s4.o)) {
                                int i2 = 0;
                                for (o child$ui_release3 = ((s4.o) oVarE).b; child$ui_release3 != null; child$ui_release3 = child$ui_release3.getChild$ui_release()) {
                                    if ((child$ui_release3.getKindSet$ui_release() & 32) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            oVarE = child$ui_release3;
                                        } else {
                                            if (eVar2 == null) {
                                                eVar2 = new k3.e(0, new o[16]);
                                            }
                                            if (oVarE != null) {
                                                eVar2.d(oVarE);
                                                oVarE = null;
                                            }
                                            eVar2.d(child$ui_release3);
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            oVarE = s4.g.e(eVar2);
                        }
                    }
                }
            }
            s4.g.b(eVar, oVar2);
        }
    }

    public final void a() {
        if (this.f395f) {
            return;
        }
        this.f395f = true;
        b5.b bVar = new b5.b(14, this);
        q1.j0 j0Var = this.a.v0;
        if (j0Var.f(bVar) >= 0) {
            return;
        }
        j0Var.a(bVar);
    }
}
