package bn1;

import a2.b1;
import a2.k2;
import a4.a1;
import a4.y;
import ak.b;
import amuvvoafs.content.SharedPreferences;
import amuvvoafs.util.Log;
import com.bandlab.amuvvoafs.common.activity.CommonActivity;
import com.facebook.d0;
import com.facebook.internal.j0;
import com.gnacba.amuvvoafs.gms.internal.ads.ps0;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.gnacba.amuvvoafs.gms.internal.play_billing.y3;
import d5.o0;
import dg1.g;
import eu0.k;
import iu1.d;
import iz1.q0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import je1.t;
import l.f;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.o;
import md1.n0;
import mr.z3;
import mx1.z;
import nc0.a;
import nc0.r;
import nc0.s;
import ny1.p2;
import of1.e;
import okhttp3.HttpUrl;
import p5.n;
import q4.t0;
import q4.t1;
import rd1.q;
import s4.j;
import st.w0;
import t1.v1;
import t3.p;
import t4.r1;
import tc0.m;
import tlydtdl.compose.foundation.layout.LayoutWeightElement;
import tlydtdl.compose.foundation.layout.h;
import tlydtdl.compose.foundation.layout.j2;
import tlydtdl.compose.foundation.layout.l2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.s0;
import tlydtdl.compose.foundation.lazy.layout.p0;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.f3;
import tlydtdl.compose.runtime.u1;
import tlydtdl.datastore.preferences.protobuf.j1;
import tlydtdl.fragment.app.FragmentActivity;
import tlydtdl.lifecycle.i1;
import w90.u;
import wm.f0;
import x10.l;
import x10.v;
import xd1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static boolean a;

    public static final boolean A(v vVar) {
        return vVar == null || y(vVar);
    }

    public static final a B(a aVar, Function2 function2, Function2 function22) {
        o.h(aVar, "<this>");
        return aVar instanceof m ? new s((m) aVar, function22, function2) : new r(aVar, function22, function2);
    }

    public static final v C(v vVar) {
        if (vVar != null) {
            return vVar;
        }
        v.Companion.getClass();
        return v.a;
    }

    public static void D(HashMap map) {
        SharedPreferences sharedPreferences = com.facebook.s.a().getSharedPreferences("com.facebook.sdk.CloudBridgeSavedCredentials", 0);
        if (sharedPreferences == null) {
            return;
        }
        Object obj = map.get(b.a(3));
        Object obj2 = map.get(b.a(1));
        Object obj3 = map.get(b.a(4));
        if (obj == null || obj2 == null || obj3 == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(b.a(3), obj.toString());
        editorEdit.putString(b.a(1), obj2.toString());
        editorEdit.putString(b.a(4), obj3.toString());
        editorEdit.apply();
        d dVar = j0.c;
        d.q(d0.c, "bn1.c".toString(), " \n\nSaving Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", new Object[]{obj, obj2, obj3});
    }

    public static final void E(CommonActivity commonActivity, Function0 function0) {
        f fVar = new f(commonActivity);
        fVar.a();
        fVar.c(2132019415);
        fVar.setPositiveButton(2132018289, new dh0.c(0, function0)).i();
    }

    public static final l F(String str) {
        if (str == null) {
            return null;
        }
        v.Companion.getClass();
        return x10.c.d(str);
    }

    public static /* synthetic */ boolean G(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, y3 y3Var, Object obj, Object obj2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(y3Var, obj, obj2)) {
            if (atomicReferenceFieldUpdater.get(y3Var) != obj && atomicReferenceFieldUpdater.get(y3Var) != obj) {
                return false;
            }
        }
        return true;
    }

    public static final void a(k kVar, p pVar, rd1.s sVar, tlydtdl.compose.runtime.m mVar, int i) {
        p pVar2;
        rd1.s sVar2;
        p pVar3;
        rd1.s sVar3;
        o.h(kVar, "state");
        tlydtdl.compose.runtime.s sVar4 = (tlydtdl.compose.runtime.s) mVar;
        sVar4.h0(268664619);
        int i2 = i | (sVar4.g(kVar) ? 4 : 2) | 176;
        if (sVar4.W(i2 & 1, (i2 & 147) != 146)) {
            sVar4.b0();
            if ((i & 1) == 0 || sVar4.D()) {
                q qVar = q.a;
                pVar3 = t3.m.a;
                sVar3 = qVar;
            } else {
                sVar4.Z();
                pVar3 = pVar;
                sVar3 = sVar;
            }
            sVar4.s();
            long jLongValue = ((Number) w0.r((p2) kVar.b, sVar4, 0, 7).getValue()).longValue();
            g gVar = new g(2131231300, false);
            ud1.b[] bVarArr = ud1.b.a;
            x30.c.a(jLongValue, gVar, sVar3, (Function0) kVar.c, tlydtdl.compose.ui.platform.a.a(pVar3, "comment-btn"), false, sVar4, 384);
            pVar2 = pVar3;
            sVar2 = sVar3;
        } else {
            sVar4.Z();
            pVar2 = pVar;
            sVar2 = sVar;
        }
        a2 a2VarV = sVar4.v();
        if (a2VarV != null) {
            a2VarV.d = new b1(i, 6, kVar, pVar2, sVar2);
        }
    }

    public static final l2.d b(int i) {
        return new l2.d(i);
    }

    public static final void c(ny1.l lVar, p pVar, s0 s0Var, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        p pVar2;
        s0 s0Var2;
        int i3;
        o.h(lVar, "flow");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(1439497187);
        if ((i & 6) == 0) {
            i2 = (sVar.i(lVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i4 = i2 | 48;
        if ((i & 384) == 0) {
            i4 = i2 | 176;
        }
        if (sVar.W(i4 & 1, (i4 & 147) != 146)) {
            sVar.b0();
            if ((i & 1) == 0 || sVar.D()) {
                s0Var = new s0(7);
                i3 = i4 & (-897);
                pVar = t3.m.a;
            } else {
                sVar.Z();
                i3 = i4 & (-897);
            }
            p pVar3 = pVar;
            s0 s0Var3 = s0Var;
            sVar.s();
            t tVar = (i) w0.p(lVar, (Object) null, sVar, (i3 & 14) | 48).getValue();
            if (tVar == null) {
                sVar.f0(-1187518902);
            } else {
                sVar.f0(-1187518901);
                if (tVar instanceof t) {
                    sVar.f0(-39281424);
                    f(tVar, pVar3, s0Var3, sVar, i3 & 1008);
                    sVar.r(false);
                } else {
                    if (tVar instanceof xd1.d) {
                        sVar.f0(-39275613);
                        m8.d.b((xd1.d) tVar, pVar3, s0Var3, sVar, i3 & 1008, 0);
                    } else {
                        sVar.f0(-1221878173);
                    }
                    sVar.r(false);
                }
            }
            sVar.r(false);
            pVar2 = pVar3;
            s0Var2 = s0Var3;
        } else {
            sVar.Z();
            pVar2 = pVar;
            s0Var2 = s0Var;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new je1.o(lVar, pVar2, s0Var2, i, 0);
        }
    }

    public static final void d(u uVar, w90.k kVar, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(54162776);
        if ((i & 6) == 0) {
            i2 = (sVar.g(uVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.e(kVar.ordinal()) ? 32 : 16;
        }
        if (sVar.W(i2 & 1, (i2 & 19) != 18)) {
            e1 e1VarR = w0.r(uVar.c, sVar, 0, 7);
            e1 e1VarR2 = w0.r(uVar.f, sVar, 0, 7);
            boolean zH = sVar.h(((Boolean) e1VarR.getValue()).booleanValue()) | sVar.h(((Boolean) e1VarR2.getValue()).booleanValue());
            Object objR = sVar.R();
            if (zH || objR == tlydtdl.compose.runtime.l.a) {
                objR = Integer.valueOf((((Boolean) e1VarR2.getValue()).booleanValue() ? 1 : 0) + (((Boolean) e1VarR.getValue()).booleanValue() ? 1 : 0) + 2);
                sVar.q0(objR);
            }
            int iIntValue = ((Number) objR).intValue();
            h hVar = (iIntValue < 4 || kVar == w90.k.g) ? tlydtdl.compose.foundation.layout.l.g : tlydtdl.compose.foundation.layout.l.a;
            t3.m mVar2 = t3.m.a;
            p pVarB = com.bandlab.uikit.compose.a.b(o2.e(mVar2, 1.0f));
            l2 l2VarA = j2.a(hVar, t3.c.j, sVar, 0);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarB);
            s4.l.f436d2.getClass();
            j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            a0.y(sVar, l2VarA, s4.k.f435f);
            a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            a0.y(sVar, pVarX, s4.k.d);
            w90.g.a(((Boolean) w0.r(uVar.a, sVar, 0, 7).getValue()).booleanValue(), uVar.b, sVar, 0);
            if (((Boolean) e1VarR.getValue()).booleanValue()) {
                sVar.f0(-1500195640);
                if (iIntValue != 4 || kVar == w90.k.d || kVar == w90.k.g) {
                    sVar.f0(-1503651954);
                } else {
                    sVar.f0(-1499986266);
                    tlydtdl.compose.foundation.layout.m.i(sVar, o2.u(mVar2, 53));
                }
                sVar.r(false);
                w90.g.b(((Boolean) w0.r(uVar.d, sVar, 0, 7).getValue()).booleanValue(), uVar.e, sVar, 0);
            } else {
                sVar.f0(-1503651954);
            }
            sVar.r(false);
            if (iIntValue != 4 || kVar == w90.k.g) {
                sVar.f0(-1503651954);
            } else {
                sVar.f0(-1499585808);
                if (1.0f <= 0.0d) {
                    e2.a.a("invalid weight; must be greater than zero");
                }
                tlydtdl.compose.foundation.layout.m.i(sVar, new LayoutWeightElement(1.0f, true));
            }
            sVar.r(false);
            if (((Boolean) e1VarR2.getValue()).booleanValue()) {
                sVar.f0(-1499477494);
                qd0.c.m(uVar.g, o2.f(mVar2, 48), sVar, 48);
                if (iIntValue != 4 || kVar == w90.k.d || kVar == w90.k.g) {
                    sVar.f0(-1503651954);
                } else {
                    sVar.f0(-1499122234);
                    tlydtdl.compose.foundation.layout.m.i(sVar, o2.u(mVar2, 53));
                }
                sVar.r(false);
            } else {
                sVar.f0(-1503651954);
            }
            sVar.r(false);
            w90.g.c(uVar.h, sVar, 0);
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new an0.i(uVar, kVar, i, 18);
        }
    }

    public static final void e(Long l, g gVar, ld1.r rVar, p pVar, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        g gVar2;
        tlydtdl.compose.runtime.s sVar;
        a2 a2VarV;
        ud1.m mVar2;
        v vVar;
        o.h(rVar, "glyphsColor");
        tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
        sVar2.h0(-1655019460);
        if ((i & 6) == 0) {
            i2 = (sVar2.g(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            gVar2 = gVar;
            i2 |= sVar2.g(gVar2) ? 32 : 16;
        } else {
            gVar2 = gVar;
        }
        if ((i & 384) == 0) {
            i2 |= sVar2.g(rVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar2.g(pVar) ? 2048 : 1024;
        }
        int i3 = i2;
        if (sVar2.W(i3 & 1, (i3 & 1171) != 1170)) {
            if (l == null) {
                sVar2.f0(1539989614);
                sVar2.r(false);
                vVar = null;
            } else {
                sVar2.f0(1539989615);
                v vVarL = aq1.b.L(l.longValue(), false, sVar2, 48);
                sVar2.r(false);
                vVar = vVarL;
            }
            if (vVar == null) {
                a2VarV = sVar2.v();
                if (a2VarV != null) {
                    mVar2 = new ud1.m(l, gVar2, rVar, pVar, i, 0);
                    a2VarV.d = mVar2;
                }
                return;
            }
            f3 f3VarO = md1.g.o(rVar, "glyphs_color", (v1) null, sVar2, ((i3 >> 6) & 14) | 48, 12);
            tlydtdl.compose.foundation.layout.j jVarG = tlydtdl.compose.foundation.layout.l.g(4);
            t3.g gVar3 = t3.c.k;
            p pVarC = tlydtdl.compose.animation.c.c(pVar, null, 3);
            l2 l2VarA = j2.a(jVarG, gVar3, sVar2, 54);
            int iHashCode = Long.hashCode(sVar2.T);
            u1 u1VarM = sVar2.m();
            p pVarX = j4.x(sVar2, pVarC);
            s4.l.f436d2.getClass();
            j jVar = s4.k.b;
            sVar2.j0();
            if (sVar2.S) {
                sVar2.l(jVar);
            } else {
                sVar2.t0();
            }
            a0.y(sVar2, l2VarA, s4.k.f435f);
            a0.y(sVar2, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar2.S || !o.c(sVar2.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar2, iHashCode, iVar);
            }
            a0.y(sVar2, pVarX, s4.k.d);
            p5.c cVar = (p5.c) sVar2.k(r1.h);
            o0 o0VarZ = j1.z(sVar2);
            boolean zG = sVar2.g(cVar);
            Object objR = sVar2.R();
            if (zG || objR == tlydtdl.compose.runtime.l.a) {
                objR = new p5.f(cVar.p0((int) (o0.a(o0VarZ, HttpUrl.FRAGMENT_ENCODE_SET, of1.q.h().a(), 1020).c & 4294967295L)));
                sVar2.q0(objR);
            }
            float f2 = ((p5.f) objR).a;
            a4.q qVar = new a4.q(((y) f3VarO.getValue()).a, 5);
            float f3 = 12;
            float f4 = f2 - f3;
            float f5 = 0;
            if (f4 < f5) {
                f4 = f5;
            }
            t3.m mVar3 = t3.m.a;
            fe1.f.a(gVar, (String) null, (a1) null, o2.p(tlydtdl.compose.foundation.layout.m.F(mVar3, 0.0f, f4 / 2, 1), f3), (t3.d) null, (q4.m) null, 0.0f, qVar, (Function0) null, false, (n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, (fe1.k) null, sVar2, ((i3 >> 3) & 14) | 432, 0, 65392);
            z10.d.h(vVar, md1.g.x(ld1.r.Companion, ((y) f3VarO.getValue()).a), of1.q.h(), tlydtdl.compose.ui.platform.a.a(mVar3, "static_counter_text"), false, (e) null, 0, (Function1) null, sVar2, 3072, 240);
            sVar = sVar2;
            sVar.r(true);
        } else {
            sVar = sVar2;
            sVar.Z();
        }
        a2VarV = sVar.v();
        if (a2VarV != null) {
            mVar2 = new ud1.m(l, gVar, rVar, pVar, i, 1);
            a2VarV.d = mVar2;
        }
    }

    public static final void f(t tVar, p pVar, s0 s0Var, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(785768766);
        if ((i & 6) == 0) {
            i2 = (sVar.g(tVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.g(pVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? sVar.g(s0Var) : sVar.i(s0Var) ? 256 : 128;
        }
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            sVar.b0();
            if ((i & 1) != 0 && !sVar.D()) {
                sVar.Z();
            }
            sVar.s();
            t1.a(pVar, tVar.a(), s0Var, q3.p.d(-1458407786, new je1.p(tVar, 0), sVar), sVar, ((i2 >> 3) & 14) | 3072 | (i2 & 896), 0);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new je1.q(i, 0, tVar, pVar, s0Var);
        }
    }

    public static final ve.q g(q0 q0Var) {
        b02.j jVarV0;
        int i = q0Var.d;
        long j2 = q0Var.l;
        long j3 = q0Var.m;
        iz1.a0 a0Var = q0Var.f;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        lmjxuqdtp.jvm.internal.b it = a0Var.iterator();
        while (true) {
            lmjxuqdtp.jvm.internal.b bVar = it;
            if (!bVar.hasNext()) {
                break;
            }
            lx1.l lVar = (lx1.l) bVar.next();
            String str = (String) lVar.a;
            String str2 = (String) lVar.b;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            o.g(lowerCase, "toLowerCase(...)");
            Object arrayList = linkedHashMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(lowerCase, arrayList);
            }
            ((List) arrayList).add(str2);
        }
        ve.o oVar = new ve.o(z.d0(linkedHashMap));
        iz1.s0 s0Var = q0Var.g;
        return new ve.q(i, j2, j3, oVar, (s0Var == null || (jVarV0 = s0Var.v0()) == null) ? null : new ve.r(jVarV0), q0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final iz1.l0 h(ve.p r5, sx1.c r6) {
        /*
            boolean r0 = r6 instanceof ye.d
            if (r0 == 0) goto L13
            r0 = r6
            ye.d r0 = (ye.d) r0
            int r1 = r0.k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.k = r1
            goto L18
        L13:
            ye.d r0 = new ye.d
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f713j
            rx1.a r1 = rx1.a.a
            int r0 = r0.k
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L43
            if (r0 != r1) goto L3b
            lg.e.O(r6)
            b02.k r6 = (b02.k) r6
            if (r6 == 0) goto L36
            int r5 = iz1.o0.a
            iz1.m0 r5 = new iz1.m0
            r5.<init>(r6)
            r6 = r2
            r0 = r6
            r3 = r0
            goto L58
        L36:
            r5 = r2
            r6 = r5
            r0 = r6
            r3 = r0
            goto L54
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L43:
            lg.e.O(r6)
            iz1.k0 r6 = new iz1.k0
            r6.<init>()
            java.lang.String r0 = r5.a
            r6.f(r0)
            java.lang.String r0 = r5.b
            r3 = r0
            r0 = r6
        L54:
            r4 = r6
            r6 = r5
            r5 = r2
            r2 = r4
        L58:
            r2.e(r3, r5)
            ve.o r5 = r6.c
            bb.w r6 = new bb.w
            r6.<init>(r1)
            java.util.Map r5 = r5.a
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L6c:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L98
            java.lang.Object r1 = r5.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r1 = r1.iterator()
        L88:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L6c
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            r6.f(r2, r3)
            goto L88
        L98:
            iz1.a0 r5 = r6.h()
            r0.d(r5)
            iz1.l0 r5 = new iz1.l0
            r5.<init>(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: bn1.c.h(ve.p, sx1.c):iz1.l0");
    }

    public static final a2.q i(cd1.g gVar, String str, aq1.b bVar) {
        o.h(gVar, "<this>");
        return new a2.q(gVar, str, bVar, 6);
    }

    public static final ps0 j(ScheduledExecutorService scheduledExecutorService, mg.c cVar, ig.e eVar) {
        o.h(scheduledExecutorService, "<this>");
        o.h(cVar, "config");
        ps0 ps0Var = new ps0(cVar, scheduledExecutorService);
        synchronized (ps0Var.e) {
            if (ps0Var.a) {
                return ps0Var;
            }
            ps0Var.a = true;
            ps0Var.b(0, 500L, eVar);
            return ps0Var;
        }
    }

    public static final boolean k(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            h02.a.S("Could not find " + str + ". If expected, import the dependency into your app.");
            return false;
        }
    }

    public static final void l(xu0.p pVar, tlydtdl.lifecycle.z zVar, FragmentActivity fragmentActivity) {
        o.h(pVar, "<this>");
        o.h(zVar, "lifecycle");
        cv0.a aVar = new cv0.a(fragmentActivity);
        ny1.z.J(i1.f(zVar), i1.c(z10.d.l(new qi.k(aVar, (qx1.d) null, 22), pVar.a), zVar, tlydtdl.lifecycle.y.d));
    }

    public static a80.l m(iw1.b bVar, iw1.b bVar2, f0 f0Var, vl.e eVar, yt.a aVar, vs0.a aVar2, yt.a aVar3) {
        o.h(bVar, "context");
        o.h(bVar2, "exploreTagNavActions");
        return new a80.l(bVar, bVar2, f0Var, eVar, aVar, aVar2, aVar3, 23);
    }

    public static b41.c n(l71.b bVar, l71.b bVar2, l71.b bVar3, iw1.b bVar4, qs0.a aVar, v31.a aVar2, iw1.b bVar5, b81.c cVar, z3 z3Var, com.bandlab.audio.controller.audioToMidi.h hVar, jw1.f fVar, a10.c cVar2) {
        o.h(bVar2, "shareVideoCache");
        o.h(bVar3, "shareImageCache");
        o.h(bVar4, "shareSampleDownloader");
        o.h(bVar5, "toaster");
        o.h(cVar, "mediaFileProcessor");
        o.h(z3Var, "mixdownStatusProvider");
        o.h(fVar, "trackTemplateFactory");
        o.h(cVar2, "clock");
        return new b41.c(bVar, bVar2, bVar3, bVar4, aVar, aVar2, bVar5, cVar, z3Var, hVar, fVar, cVar2);
    }

    public static mz0.b o(jw1.e eVar, f0 f0Var, ct.b bVar, iw1.b bVar2, jq0.d dVar, iw1.b bVar3, iw1.b bVar4, qs0.a aVar, f0 f0Var2, jw1.e eVar2, jw1.e eVar3, iw1.b bVar5, zs.o oVar, jw1.c cVar, kr0.a aVar2, jw1.f fVar, jw1.f fVar2, au0.j jVar, jw1.f fVar3, jw1.c cVar2) {
        o.h(eVar, "param");
        o.h(bVar, "postLikeRepository");
        o.h(bVar2, "userIdProvider");
        o.h(bVar3, "userRepository");
        o.h(bVar4, "toaster");
        o.h(eVar2, "navigation");
        o.h(eVar3, "lifecycle");
        o.h(bVar5, "postTracker");
        o.h(cVar, "preferenceConfig");
        o.h(aVar2, "commentRepository");
        o.h(fVar, "videoPostCardViewModelFactory");
        o.h(fVar2, "audioPostCardViewModelFactory");
        o.h(fVar3, "boostButtonFactory");
        o.h(cVar2, "apiServiceFactory");
        return new mz0.b(eVar, f0Var, bVar, bVar2, dVar, bVar3, bVar4, aVar, f0Var2, eVar2, eVar3, bVar5, oVar, cVar, aVar2, fVar, fVar2, jVar, fVar3, cVar2);
    }

    public static v31.a p(iw1.b bVar) {
        return md1.b1.r(bVar, "json", bVar);
    }

    public static void q(String str, Object obj, String str2) {
        String strConcat = "TRuntime.".concat(str);
        if (Log.isLoggable(strConcat, 3)) {
            Log.d(strConcat, String.format(str2, obj));
        }
    }

    public static void r(Exception exc, String str, String str2) {
        String strConcat = "TRuntime.".concat(str);
        if (Log.isLoggable(strConcat, 6)) {
            Log.e(strConcat, str2, exc);
        }
    }

    public static final rc0.b s() {
        return new rc0.b(mx1.t.a);
    }

    public static final LinkedHashMap t(Map map) {
        o.h(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final rc0.b u(vu0.d dVar) {
        return new rc0.b(ct1.b.B(dVar));
    }

    public static final rc0.b v(List list) {
        o.h(list, "list");
        return new rc0.b(list);
    }

    public static final i2.e w(p0 p0Var, int i, long j2, i2.p pVar, long j3, k2 k2Var, t3.f fVar, t3.g gVar, n nVar, int i2, q1.z zVar) {
        List list;
        Object objD = pVar.d(i);
        List list2 = (List) zVar.b(i);
        if (list2 != null) {
            list = list2;
        } else {
            List listB = p0Var.b(i);
            int size = listB.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(((t0) listB.get(i3)).T(j2));
            }
            zVar.h(i, arrayList);
            list = arrayList;
        }
        return new i2.e(i, i2, list, j3, objD, k2Var, fVar, gVar, nVar);
    }

    public static final int x(h5.s sVar, int i) {
        boolean z = sVar.a(h5.s.d) >= 0;
        boolean z2 = i == 1;
        if (z2 && z) {
            return 3;
        }
        if (z) {
            return 1;
        }
        return z2 ? 2 : 0;
    }

    public static final boolean y(v vVar) throws NoWhenBranchMatchedException {
        o.h(vVar, "<this>");
        if (vVar instanceof l) {
            return ((l) vVar).e.length() == 0;
        }
        if (!(vVar instanceof x10.f)) {
            if ((vVar instanceof x10.r) || (vVar instanceof x10.u) || (vVar instanceof x10.o)) {
                return false;
            }
            if (vVar instanceof x10.i) {
                return y(((x10.i) vVar).a());
            }
            throw new NoWhenBranchMatchedException();
        }
        List list = ((x10.f) vVar).e;
        if (list != null && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!y((v) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final boolean z(v vVar) {
        o.h(vVar, "<this>");
        return !y(vVar);
    }
}
