package tlydtdl.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {
    public static final r0 c = new r0();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final e0 a = new e0();

    public final u0 a(Class cls) {
        m0 m0VarW;
        Class cls2;
        y.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.b;
        u0 u0Var = (u0) concurrentHashMap.get(cls);
        if (u0Var != null) {
            return u0Var;
        }
        e0 e0Var = this.a;
        e0Var.getClass();
        Class cls3 = v0.a;
        if (!w.class.isAssignableFrom(cls) && (cls2 = v0.a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        t0 t0VarA = ((d0) e0Var.a).a(cls);
        int i = t0VarA.d;
        a aVar = t0VarA.a;
        if ((i & 2) == 2) {
            if (w.class.isAssignableFrom(cls)) {
                m0VarW = m0.j(v0.c, q.a, aVar);
            } else {
                a1 a1Var = v0.b;
                p pVar = q.b;
                if (pVar == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                m0VarW = m0.j(a1Var, pVar, aVar);
            }
        } else if (w.class.isAssignableFrom(cls)) {
            p pVar2 = null;
            n0 n0Var = o0.b;
            b0 b0Var = c0.b;
            c1 c1Var = v0.c;
            if (z.p.k(t0VarA.a()) != 1) {
                pVar2 = q.a;
            }
            p pVar3 = pVar2;
            h0 h0Var = i0.b;
            if (!(t0VarA instanceof t0)) {
                int[] iArr = l0.n;
                t0VarA.getClass();
                throw new ClassCastException();
            }
            m0VarW = l0.w(t0VarA, n0Var, b0Var, c1Var, pVar3, h0Var);
        } else {
            p pVar4 = null;
            n0 n0Var2 = o0.a;
            b0 b0Var2 = c0.a;
            a1 a1Var2 = v0.b;
            if (z.p.k(t0VarA.a()) != 1 && (pVar4 = q.b) == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            p pVar5 = pVar4;
            h0 h0Var2 = i0.a;
            if (!(t0VarA instanceof t0)) {
                int[] iArr2 = l0.n;
                t0VarA.getClass();
                throw new ClassCastException();
            }
            m0VarW = l0.w(t0VarA, n0Var2, b0Var2, a1Var2, pVar5, h0Var2);
        }
        u0 u0Var2 = (u0) concurrentHashMap.putIfAbsent(cls, m0VarW);
        return u0Var2 != null ? u0Var2 : m0VarW;
    }
}
