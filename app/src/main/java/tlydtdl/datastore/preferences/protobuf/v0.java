package tlydtdl.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v0 {
    public static final Class a;
    public static final a1 b;
    public static final c1 c;

    static {
        Class<?> cls;
        Class<?> cls2;
        r0 r0Var = r0.c;
        a1 a1Var = null;
        try {
            cls = Class.forName("tlydtdl.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            r0 r0Var2 = r0.c;
            try {
                cls2 = Class.forName("tlydtdl.datastore.preferences.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                a1Var = (a1) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        b = a1Var;
        c = new c1();
    }

    public static int a(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iU = 0;
        for (int i = 0; i < size; i++) {
            iU += m.U(((Integer) list.get(i)).intValue());
        }
        return iU;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (m.S(i) + 4) * size;
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (m.S(i) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iU = 0;
        for (int i = 0; i < size; i++) {
            iU += m.U(((Integer) list.get(i)).intValue());
        }
        return iU;
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iU = 0;
        for (int i = 0; i < size; i++) {
            iU += m.U(((Long) list.get(i)).longValue());
        }
        return iU;
    }

    public static int f(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = 0;
        for (int i = 0; i < size; i++) {
            int iIntValue = ((Integer) list.get(i)).intValue();
            iT += m.T((iIntValue >> 31) ^ (iIntValue << 1));
        }
        return iT;
    }

    public static int g(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iU = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iU += m.U((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iU;
    }

    public static int h(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = 0;
        for (int i = 0; i < size; i++) {
            iT += m.T(((Integer) list.get(i)).intValue());
        }
        return iT;
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iU = 0;
        for (int i = 0; i < size; i++) {
            iU += m.U(((Long) list.get(i)).longValue());
        }
        return iU;
    }

    public static Object j(Object obj, int i, x xVar, Object obj2, a1 a1Var) {
        return obj2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void k(a1 a1Var, Object obj, Object obj2) {
        ((c1) a1Var).getClass();
        w wVar = (w) obj;
        b1 b1Var = wVar.unknownFields;
        b1 b1Var2 = ((w) obj2).unknownFields;
        b1 b1Var3 = b1.f568f;
        if (!b1Var3.equals(b1Var2)) {
            if (b1Var3.equals(b1Var)) {
                int i = b1Var.a + b1Var2.a;
                int[] iArrCopyOf = Arrays.copyOf(b1Var.b, i);
                System.arraycopy(b1Var2.b, 0, iArrCopyOf, b1Var.a, b1Var2.a);
                Object[] objArrCopyOf = Arrays.copyOf(b1Var.c, i);
                System.arraycopy(b1Var2.c, 0, objArrCopyOf, b1Var.a, b1Var2.a);
                b1Var = new b1(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                b1Var.getClass();
                if (!b1Var2.equals(b1Var3)) {
                    if (!b1Var.e) {
                        throw new UnsupportedOperationException();
                    }
                    int i2 = b1Var.a + b1Var2.a;
                    b1Var.a(i2);
                    System.arraycopy(b1Var2.b, 0, b1Var.b, b1Var.a, b1Var2.a);
                    System.arraycopy(b1Var2.c, 0, b1Var.c, b1Var.a, b1Var2.a);
                    b1Var.a = i2;
                }
            }
        }
        wVar.unknownFields = b1Var;
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void m(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                mVar.Z(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            Logger logger = m.g;
            i3++;
        }
        mVar.n0(i3);
        while (i2 < list.size()) {
            mVar.X(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void n(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                double dDoubleValue = ((Double) list.get(i2)).doubleValue();
                mVar.getClass();
                mVar.e0(i, Double.doubleToRawLongBits(dDoubleValue));
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            Logger logger = m.g;
            i3 += 8;
        }
        mVar.n0(i3);
        while (i2 < list.size()) {
            mVar.f0(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public static void o(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                mVar.g0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int iU = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iU += m.U(((Integer) list.get(i3)).intValue());
        }
        mVar.n0(iU);
        while (i2 < list.size()) {
            mVar.h0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void p(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                mVar.c0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            Logger logger = m.g;
            i3 += 4;
        }
        mVar.n0(i3);
        while (i2 < list.size()) {
            mVar.d0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void q(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                mVar.e0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            Logger logger = m.g;
            i3 += 8;
        }
        mVar.n0(i3);
        while (i2 < list.size()) {
            mVar.f0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void r(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                float fFloatValue = ((Float) list.get(i2)).floatValue();
                mVar.getClass();
                mVar.c0(i, Float.floatToRawIntBits(fFloatValue));
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            Logger logger = m.g;
            i3 += 4;
        }
        mVar.n0(i3);
        while (i2 < list.size()) {
            mVar.d0(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public static void s(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                mVar.g0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int iU = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iU += m.U(((Integer) list.get(i3)).intValue());
        }
        mVar.n0(iU);
        while (i2 < list.size()) {
            mVar.h0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void t(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                mVar.o0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int iU = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iU += m.U(((Long) list.get(i3)).longValue());
        }
        mVar.n0(iU);
        while (i2 < list.size()) {
            mVar.p0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void u(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                mVar.c0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            Logger logger = m.g;
            i3 += 4;
        }
        mVar.n0(i3);
        while (i2 < list.size()) {
            mVar.d0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void v(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                mVar.e0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            Logger logger = m.g;
            i3 += 8;
        }
        mVar.n0(i3);
        while (i2 < list.size()) {
            mVar.f0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void w(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                mVar.m0(i, (iIntValue >> 31) ^ (iIntValue << 1));
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int iT = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = ((Integer) list.get(i3)).intValue();
            iT += m.T((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        mVar.n0(iT);
        while (i2 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            mVar.n0((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i2++;
        }
    }

    public static void x(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                mVar.o0(i, (jLongValue >> 63) ^ (jLongValue << 1));
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int iU = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iU += m.U((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        mVar.n0(iU);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            mVar.p0((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i2++;
        }
    }

    public static void y(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                mVar.m0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int iT = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iT += m.T(((Integer) list.get(i3)).intValue());
        }
        mVar.n0(iT);
        while (i2 < list.size()) {
            mVar.n0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void z(int i, List list, e0 e0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m mVar = (m) e0Var.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                mVar.o0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        mVar.l0(i, 2);
        int iU = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iU += m.U(((Long) list.get(i3)).longValue());
        }
        mVar.n0(iU);
        while (i2 < list.size()) {
            mVar.p0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }
}
