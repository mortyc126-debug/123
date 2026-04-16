package jg0;

import ak.t0;
import ak.u0;
import ak.v0;
import ak.w0;
import com.bandlab.audiocore.generated.CleanLimiter;
import com.bandlab.audiocore.generated.FloatParam;
import com.gnacba.amuvvoafs.gms.internal.play_billing.o1;
import di0.x;
import f3.f2;
import f60.q;
import fh0.d;
import fh0.e;
import gq.n0;
import hi0.v;
import hi0.w;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kb1.r;
import ks0.i;
import ky1.c0;
import ky1.m0;
import lg1.q0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.k;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import nk.h;
import ny1.r2;
import pl.c;
import pl.g;
import qi.y;
import qk.m;
import so0.t;
import tc0.p;
import uq0.i0;
import yp.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b extends k implements Function1 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(i, i2, cls, obj, str, str2);
        this.b = i3;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invoke(Object obj) throws NoWhenBranchMatchedException {
        Object value;
        v vVarZ;
        m mVarC;
        double norm;
        float f2;
        m mVarC2;
        int i = this.b;
        u0 u0Var = u0.a;
        t0 t0Var = t0.a;
        q qVar = null;
        b0 b0Var = b0.a;
        switch (i) {
            case 0:
                d dVar = (e) obj;
                o.h(dVar, "p0");
                l lVar = (l) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                lVar.getClass();
                if (dVar instanceof d) {
                    lVar.f237j.u(t0Var, dVar.a());
                }
                return b0Var;
            case 1:
                d dVar2 = (e) obj;
                o.h(dVar2, "p0");
                l lVar2 = (l) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                lVar2.getClass();
                if (dVar2 instanceof d) {
                    lVar2.f237j.u(u0Var, dVar2.a());
                }
                return b0Var;
            case 2:
                w0 w0Var = (w0) obj;
                o.h(w0Var, "p0");
                l lVar3 = (l) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                lVar3.getClass();
                s sVar = lVar3.f237j;
                if (w0Var.equals(v0.a)) {
                    sVar.y = sVar.r(sVar.y, w0Var);
                } else if (w0Var.equals(t0Var)) {
                    sVar.z = sVar.r(sVar.z, w0Var);
                } else {
                    if (!w0Var.equals(u0Var)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    sVar.A = sVar.r(sVar.A, w0Var);
                }
                return b0Var;
            case 3:
                float fFloatValue = ((Number) obj).floatValue();
                l lVar4 = (l) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                lVar4.getClass();
                s02.d.a.getClass();
                s02.b.t("AB:: play pos changed by user: " + fFloatValue);
                s1.a.r(fFloatValue, lVar4.m, (Object) null);
                return b0Var;
            case 4:
                Set set = (Set) obj;
                o.h(set, "p0");
                x xVar = (x) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                o.h(xVar, "<this>");
                r2 r2Var = xVar.c;
                do {
                    value = r2Var.getValue();
                    w wVar = (v) value;
                    o.h(wVar, "request");
                    vVarZ = o1.z(wVar, new hi0.x(0, set));
                } while (!r2Var.d(value, o1.I(vVarZ, new p((String) null, vVarZ.e().intValue(), 3))));
                return b0Var;
            case 5:
                jl.o oVar = (jl.o) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                r2 r2Var2 = oVar.k;
                ks0.d dVarA = ks0.d.a((ks0.d) oVar.l.a.getValue(), (String) obj, (i) null, 5);
                r2Var2.getClass();
                r2Var2.i((Object) null, dVarA);
                return b0Var;
            case 6:
                long j2 = ((p5.m) obj).a;
                ip0.d dVar3 = (ip0.d) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                dVar3.E = j2;
                dVar3.z();
                return b0Var;
            case 7:
                nk.i iVar = (nk.i) obj;
                o.h(iVar, "p0");
                ip0.d dVar4 = (ip0.d) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                dVar4.getClass();
                ml.i iVar2 = dVar4.r;
                String str = iVar.a;
                if (((g) iVar2).d(str)) {
                    dVar4.u.j(2132017961);
                } else {
                    if (iVar instanceof nk.g) {
                        ml.i iVar3 = iVar2;
                        lk.a aVar = (lk.a) ((c) iVar3).f.a.getValue();
                        if (aVar != null && (mVarC2 = aVar.c("input")) != null) {
                            FloatParam floatParam = mVarC2.a;
                            mVarC2.c();
                            float norm2 = (float) floatParam.getNorm();
                            CleanLimiter cleanLimiterE = iVar3.e();
                            if (cleanLimiterE != null) {
                                cleanLimiterE.setInputLevel(norm2);
                            }
                            ((g) iVar3).l.a(b0Var);
                            norm = floatParam.getNorm();
                            f2 = (float) norm;
                        }
                        f2 = 0.0f;
                    } else {
                        if (!(iVar instanceof h)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        ml.i iVar4 = iVar2;
                        lk.a aVar2 = (lk.a) ((c) iVar4).f.a.getValue();
                        if (aVar2 != null && (mVarC = aVar2.c("threshold")) != null) {
                            FloatParam floatParam2 = mVarC.a;
                            mVarC.c();
                            float norm3 = (float) floatParam2.getNorm();
                            CleanLimiter cleanLimiterE2 = iVar4.e();
                            if (cleanLimiterE2 != null) {
                                cleanLimiterE2.setThresholdLevel(norm3);
                            }
                            ((g) iVar4).l.a(b0Var);
                            norm = floatParam2.getNorm();
                            f2 = (float) norm;
                        }
                        f2 = 0.0f;
                    }
                    dVar4.D.put(str, Float.valueOf(st.w0.i(f2, 0.0f, 1.0f)));
                    z10.d.H(dVar4.s.c, t.a);
                }
                return b0Var;
            case 8:
                qr.l lVar5 = (qr.l) obj;
                o.h(lVar5, "p0");
                ((jq.g) ((lmjxuqdtp.jvm.internal.d) this).receiver).e.d(lVar5, qr.l.Companion.serializer());
                return b0Var;
            case 9:
                jr0.j.a((jr0.j) ((lmjxuqdtp.jvm.internal.d) this).receiver, ((Number) obj).floatValue());
                return b0Var;
            case 10:
                ((jr0.q) ((lmjxuqdtp.jvm.internal.d) this).receiver).c(((Number) obj).intValue());
                return b0Var;
            case 11:
                ((v01.h) ((lmjxuqdtp.jvm.internal.d) this).receiver).a((xd1.d) obj);
                return b0Var;
            case 12:
                String str2 = (String) obj;
                o.h(str2, "p0");
                k50.k.a((k50.k) ((lmjxuqdtp.jvm.internal.d) this).receiver, str2);
                return b0Var;
            case 13:
                String str3 = (String) obj;
                o.h(str3, "p0");
                k50.k.a((k50.k) ((lmjxuqdtp.jvm.internal.d) this).receiver, str3);
                return b0Var;
            case 14:
                String str4 = (String) obj;
                o.h(str4, "p0");
                k50.k.a((k50.k) ((lmjxuqdtp.jvm.internal.d) this).receiver, str4);
                return b0Var;
            case 15:
                String str5 = (String) obj;
                o.h(str5, "p0");
                k50.k.a((k50.k) ((lmjxuqdtp.jvm.internal.d) this).receiver, str5);
                return b0Var;
            case 16:
                String str6 = (String) obj;
                o.h(str6, "p0");
                k50.k.a((k50.k) ((lmjxuqdtp.jvm.internal.d) this).receiver, str6);
                return b0Var;
            case 17:
                return Boolean.valueOf(((HashSet) ((lmjxuqdtp.jvm.internal.d) this).receiver).contains((String) obj));
            case 18:
                dh1.w wVar2 = (dh1.w) obj;
                o.h(wVar2, "p0");
                r2 r2Var3 = ((r) ((lmjxuqdtp.jvm.internal.d) this).receiver).n;
                Object obj2 = ((kb1.c) r2Var3.getValue()).a;
                if (((List) obj2) == null || !(!r2.isEmpty())) {
                    obj2 = null;
                }
                List list = (List) obj2;
                if (list != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj3 : list) {
                        if (!o.c(((r51.d) obj3).a, wVar2)) {
                            arrayList.add(obj3);
                        }
                    }
                    r2Var3.i((Object) null, kb1.c.a((kb1.c) r2Var3.getValue(), arrayList));
                }
                return b0Var;
            case 19:
                oq.d dVar5 = ((n0) ((lmjxuqdtp.jvm.internal.d) this).receiver).a;
                ry1.e eVar = m0.a;
                Object objR = c0.R(x30.b.a, new mn0.d(dVar5, (qx1.d) null, 28), (qx1.d) obj);
                rx1.a aVar3 = rx1.a.a;
                if (objR != aVar3) {
                    objR = b0Var;
                }
                return objR == aVar3 ? objR : b0Var;
            case 20:
                s51.b0 b0Var2 = ((com.bandlab.library.service.song.c) ((lmjxuqdtp.jvm.internal.d) this).receiver).a;
                ry1.e eVar2 = m0.a;
                Object objR2 = c0.R(x30.b.a, new lj1.g(b0Var2, (qx1.d) null, 29), (qx1.d) obj);
                rx1.a aVar4 = rx1.a.a;
                if (objR2 != aVar4) {
                    objR2 = b0Var;
                }
                return objR2 == aVar4 ? objR2 : b0Var;
            case 21:
                kd1.g gVar = (kd1.g) obj;
                o.h(gVar, "p0");
                kd1.p.c((kd1.p) ((lmjxuqdtp.jvm.internal.d) this).receiver, gVar);
                return b0Var;
            case 22:
                ((nh.q) ((lmjxuqdtp.jvm.internal.d) this).receiver).b.setValue((xd1.d) obj);
                return b0Var;
            case 23:
                mq0.c cVar = (mq0.d) obj;
                o.h(cVar, "p0");
                kq0.g gVar2 = (kq0.g) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                kq0.c cVar2 = gVar2.g;
                if (cVar instanceof mq0.a) {
                    cVar2.b(true);
                    cVar2.e.setValue((Object) null);
                } else if (cVar instanceof mq0.b) {
                    c0.F(cVar2.a, (qx1.i) null, (ky1.b0) null, new j61.m(gVar2, (qx1.d) null, 13), 3);
                } else {
                    if (!(cVar instanceof mq0.c)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    mq0.l lVar6 = cVar.a;
                    i0 i0Var = gVar2.d;
                    String str7 = lVar6.a;
                    o.h(str7, "promptSlug");
                    y yVar = i0Var.a;
                    ArrayList arrayList2 = new ArrayList();
                    f2.z("prompt_slug", str7, arrayList2);
                    y.k(yVar, "fx_ai_prompt_default_use", arrayList2, qi.h.b, 8);
                    v2.q.e(cVar2.b, lVar6.b);
                }
                return b0Var;
            case 24:
                CharSequence charSequence = (CharSequence) obj;
                o.h(charSequence, "p0");
                ((x10.c) ((lmjxuqdtp.jvm.internal.d) this).receiver).getClass();
                return x10.c.d(charSequence);
            case 25:
                f60.p pVar = (f60.p) obj;
                o.h(pVar, "p0");
                l60.j jVar = (l60.j) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                if (jVar.e().b != pVar) {
                    zi.k kVarA = jVar.a();
                    j60.d dVar6 = (j60.d) kVarA.e;
                    if (pVar == f60.p.b && (qVar = dVar6.c) == null) {
                        qVar = q.c;
                    }
                    kVarA.a(j60.d.a(dVar6, (List) null, pVar, qVar, false, 1));
                    jVar.c.f(jVar.e());
                }
                return b0Var;
            case 26:
                ((ld0.x) ((lmjxuqdtp.jvm.internal.d) this).receiver).E((Boolean) obj);
                return b0Var;
            case 27:
                LocalDate localDate = (LocalDate) obj;
                o.h(localDate, "p0");
                q0 q0Var = (q0) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                q0Var.getClass();
                ((zi.k) q0Var.q.d(q0Var, q0.F[0])).a(localDate.toString());
                q0Var.d().a(lg1.j.INSTANCE);
                return b0Var;
            case 28:
                String str8 = (String) obj;
                o.h(str8, "p0");
                lp0.q qVar2 = (lp0.q) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                c0.F(qVar2.a, (qx1.i) null, (ky1.b0) null, new l61.m(qVar2, str8, (qx1.d) null, 6), 3);
                return b0Var;
            default:
                float fFloatValue2 = ((Number) obj).floatValue();
                lx.d dVar7 = (lx.d) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                s1.a.r(fFloatValue2, dVar7.d, (Object) null);
                dVar7.c.setValue(dVar7.b.get(by1.b.P(fFloatValue2)));
                return b0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(l lVar, int i) {
        super(1, 0, l.class, lVar, "onBassClicked", "onBassClicked(Lcom/bandlab/mixeditor/autobeat/ui/AutoBeatClipState;)V");
        this.b = i;
        switch (i) {
            case 1:
                super(1, 0, l.class, lVar, "onChordsClicked", "onChordsClicked(Lcom/bandlab/mixeditor/autobeat/ui/AutoBeatClipState;)V");
                break;
            case 2:
                super(1, 0, l.class, lVar, "onReload", "onReload(Lcom/bandlab/audio/controller/api/ClipType;)V");
                break;
            case 3:
                super(1, 0, l.class, lVar, "onPlayPositionChanged", "onPlayPositionChanged(F)V");
                break;
            default:
                break;
        }
    }
}
