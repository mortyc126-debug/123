package tlydtdl.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i1 {
    public static final Unsafe a;
    public static final Class b;
    public static final h1 c;
    public static final boolean d;
    public static final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f570f;
    public static final boolean g;

    static {
        Unsafe unsafeI = i();
        a = unsafeI;
        b = c.a;
        boolean zH = h(Long.TYPE);
        boolean zH2 = h(Integer.TYPE);
        f1 g1Var = null;
        if (unsafeI != null) {
            if (!c.a()) {
                g1Var = new g1(unsafeI);
            } else if (zH) {
                g1Var = new f1(unsafeI);
            } else if (zH2) {
                g1Var = new e1(unsafeI);
            }
        }
        c = g1Var;
        d = g1Var == null ? false : g1Var.r();
        e = g1Var == null ? false : g1Var.q();
        f570f = e(byte[].class);
        e(boolean[].class);
        f(boolean[].class);
        e(int[].class);
        f(int[].class);
        e(long[].class);
        f(long[].class);
        e(float[].class);
        f(float[].class);
        e(double[].class);
        f(double[].class);
        e(Object[].class);
        f(Object[].class);
        Field fieldG = g();
        if (fieldG != null && g1Var != null) {
            g1Var.i(fieldG);
        }
        g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(i1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static boolean b(Object obj, long j2) {
        return ((byte) ((c.f(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255)) != 0;
    }

    public static boolean c(Object obj, long j2) {
        return ((byte) ((c.f(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255)) != 0;
    }

    public static Object d(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int e(Class cls) {
        if (e) {
            return c.a(cls);
        }
        return -1;
    }

    public static void f(Class cls) {
        if (e) {
            c.b(cls);
        }
    }

    public static Field g() {
        Field declaredField;
        Field declaredField2;
        if (c.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    public static boolean h(Class cls) {
        if (!c.a()) {
            return false;
        }
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Unsafe i() {
        try {
            return (Unsafe) AccessController.doPrivileged(new d1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(byte[] bArr, long j2, byte b3) {
        c.k(bArr, f570f + j2, b3);
    }

    public static void k(Object obj, long j2, byte b3) {
        long j3 = (-4) & j2;
        int iF = c.f(obj, j3);
        int i = ((~((int) j2)) & 3) << 3;
        m(j3, obj, ((255 & b3) << i) | (iF & (~(255 << i))));
    }

    public static void l(Object obj, long j2, byte b3) {
        long j3 = (-4) & j2;
        int i = (((int) j2) & 3) << 3;
        m(j3, obj, ((255 & b3) << i) | (c.f(obj, j3) & (~(255 << i))));
    }

    public static void m(long j2, Object obj, int i) {
        c.n(j2, obj, i);
    }

    public static void n(Object obj, long j2, long j3) {
        c.o(obj, j2, j3);
    }

    public static void o(long j2, Object obj, Object obj2) {
        c.p(j2, obj, obj2);
    }
}
