package tlydtdl.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h1 {
    public final Unsafe a;

    public h1(Unsafe unsafe) {
        this.a = unsafe;
    }

    public final int a(Class cls) {
        return this.a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.a.arrayIndexScale(cls);
    }

    public abstract boolean c(Object obj, long j2);

    public abstract double d(Object obj, long j2);

    public abstract float e(Object obj, long j2);

    public final int f(Object obj, long j2) {
        return this.a.getInt(obj, j2);
    }

    public final long g(Object obj, long j2) {
        return this.a.getLong(obj, j2);
    }

    public final Object h(Object obj, long j2) {
        return this.a.getObject(obj, j2);
    }

    public final long i(Field field) {
        return this.a.objectFieldOffset(field);
    }

    public abstract void j(Object obj, long j2, boolean z);

    public abstract void k(Object obj, long j2, byte b);

    public abstract void l(Object obj, long j2, double d);

    public abstract void m(Object obj, long j2, float f2);

    public final void n(long j2, Object obj, int i) {
        this.a.putInt(obj, j2, i);
    }

    public final void o(Object obj, long j2, long j3) {
        this.a.putLong(obj, j2, j3);
    }

    public final void p(long j2, Object obj, Object obj2) {
        this.a.putObject(obj, j2, obj2);
    }

    public boolean q() {
        Unsafe unsafe = this.a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            return true;
        } catch (Throwable th) {
            i1.a(th);
            return false;
        }
    }

    public abstract boolean r();
}
