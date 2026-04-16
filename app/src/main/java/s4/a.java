package s4;

import java.util.HashMap;
import java.util.Map;
import mx1.z;
import q4.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public final m1 a;
    public boolean c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f425f;
    public boolean b = true;
    public final HashMap g = new HashMap();

    public a(b bVar) {
        this.a = (m1) bVar;
    }

    public static final void a(a aVar, q4.a aVar2, int i, k1 k1Var) {
        long jB;
        HashMap map = aVar.g;
        float f2 = i;
        long jFloatToRawIntBits = ((long) Float.floatToRawIntBits(f2)) << 32;
        long jFloatToRawIntBits2 = ((long) Float.floatToRawIntBits(f2)) & 4294967295L;
        loop0: while (true) {
            jB = jFloatToRawIntBits | jFloatToRawIntBits2;
            do {
                jB = aVar.b(k1Var, jB);
                k1Var = k1Var.q;
                lmjxuqdtp.jvm.internal.o.e(k1Var);
                if (k1Var.equals(aVar.a.G())) {
                    break loop0;
                }
            } while (!aVar.c(k1Var).containsKey(aVar2));
            float fD = aVar.d(k1Var, aVar2);
            long jFloatToRawIntBits3 = Float.floatToRawIntBits(fD);
            long jFloatToRawIntBits4 = Float.floatToRawIntBits(fD);
            jFloatToRawIntBits = jFloatToRawIntBits3 << 32;
            jFloatToRawIntBits2 = jFloatToRawIntBits4 & 4294967295L;
        }
        int iRound = Math.round(aVar2 instanceof q4.q ? Float.intBitsToFloat((int) (jB & 4294967295L)) : Float.intBitsToFloat((int) (jB >> 32)));
        if (map.containsKey(aVar2)) {
            int iIntValue = ((Number) z.O(aVar2, map)).intValue();
            q4.q qVar = q4.d.a;
            iRound = ((Number) aVar2.a.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iRound))).intValue();
        }
        map.put(aVar2, Integer.valueOf(iRound));
    }

    public abstract long b(k1 k1Var, long j2);

    public abstract Map c(k1 k1Var);

    public abstract int d(k1 k1Var, q4.a aVar);

    public final boolean e() {
        return this.c || this.d || this.e;
    }

    public final boolean f() {
        i();
        return this.f425f != null;
    }

    public final void g() {
        this.b = true;
        m1 m1Var = this.a;
        b bVarF = m1Var.f();
        if (bVarF == null) {
            return;
        }
        if (this.c) {
            bVarF.requestLayout();
        }
        if (this.d) {
            m1Var.a0();
        }
        if (this.e) {
            m1Var.requestLayout();
        }
        bVarF.b().g();
    }

    public final void h() {
        HashMap map = this.g;
        map.clear();
        tlydtdl.fragment.app.q qVar = new tlydtdl.fragment.app.q(17, this);
        m1 m1Var = this.a;
        m1Var.j(qVar);
        map.putAll(c(m1Var.G()));
        this.b = false;
    }

    public final void i() {
        a aVarB;
        a aVarB2;
        boolean zE = e();
        b bVar = this.a;
        if (!zE) {
            b bVarF = bVar.f();
            if (bVarF == null) {
                return;
            }
            bVar = bVarF.b().f425f;
            if (bVar == null || !bVar.b().e()) {
                b bVar2 = this.f425f;
                if (bVar2 == null || bVar2.b().e()) {
                    return;
                }
                b bVarF2 = bVar2.f();
                if (bVarF2 != null && (aVarB2 = bVarF2.b()) != null) {
                    aVarB2.i();
                }
                b bVarF3 = bVar2.f();
                bVar = (bVarF3 == null || (aVarB = bVarF3.b()) == null) ? null : aVarB.f425f;
            }
        }
        this.f425f = bVar;
    }
}
