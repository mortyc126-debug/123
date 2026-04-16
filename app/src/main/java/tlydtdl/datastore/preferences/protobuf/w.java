package tlydtdl.datastore.preferences.protobuf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w extends a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, w> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected b1 unknownFields;

    public w() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = b1.f568f;
    }

    public static w d(Class cls) {
        w wVar = defaultInstanceMap.get(cls);
        if (wVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                wVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = (w) ((w) i1.d(cls)).c(6);
        if (wVar2 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, wVar2);
        return wVar2;
    }

    public static Object e(Method method, w wVar, Object... objArr) {
        try {
            return method.invoke(wVar, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final boolean f(w wVar, boolean z) {
        byte bByteValue = ((Byte) wVar.c(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        r0 r0Var = r0.c;
        r0Var.getClass();
        boolean zC = r0Var.a(wVar.getClass()).c(wVar);
        if (z) {
            wVar.c(2);
        }
        return zC;
    }

    public static void j(Class cls, w wVar) {
        wVar.h();
        defaultInstanceMap.put(cls, wVar);
    }

    @Override // tlydtdl.datastore.preferences.protobuf.a
    public final int a(u0 u0Var) {
        int iG;
        int iG2;
        if (g()) {
            if (u0Var == null) {
                r0 r0Var = r0.c;
                r0Var.getClass();
                iG2 = r0Var.a(getClass()).g(this);
            } else {
                iG2 = u0Var.g(this);
            }
            if (iG2 >= 0) {
                return iG2;
            }
            throw new IllegalStateException(o6.c.k(iG2, "serialized size must be non-negative, was "));
        }
        int i = this.memoizedSerializedSize;
        if ((i & IntCompanionObject.MAX_VALUE) != Integer.MAX_VALUE) {
            return i & IntCompanionObject.MAX_VALUE;
        }
        if (u0Var == null) {
            r0 r0Var2 = r0.c;
            r0Var2.getClass();
            iG = r0Var2.a(getClass()).g(this);
        } else {
            iG = u0Var.g(this);
        }
        k(iG);
        return iG;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.a
    public final void b(m mVar) {
        r0 r0Var = r0.c;
        r0Var.getClass();
        u0 u0VarA = r0Var.a(getClass());
        e0 e0Var = mVar.b;
        if (e0Var == null) {
            e0Var = new e0(mVar);
        }
        u0VarA.e(this, e0Var);
    }

    public abstract Object c(int i);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r0 r0Var = r0.c;
        r0Var.getClass();
        return r0Var.a(getClass()).i(this, (w) obj);
    }

    public final boolean g() {
        return (this.memoizedSerializedSize & Integer.MIN_VALUE) != 0;
    }

    public final void h() {
        this.memoizedSerializedSize &= IntCompanionObject.MAX_VALUE;
    }

    public final int hashCode() {
        if (g()) {
            r0 r0Var = r0.c;
            r0Var.getClass();
            return r0Var.a(getClass()).h(this);
        }
        if (this.memoizedHashCode == 0) {
            r0 r0Var2 = r0.c;
            r0Var2.getClass();
            this.memoizedHashCode = r0Var2.a(getClass()).h(this);
        }
        return this.memoizedHashCode;
    }

    public final w i() {
        return (w) c(4);
    }

    public final void k(int i) {
        if (i < 0) {
            throw new IllegalStateException(o6.c.k(i, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i & IntCompanionObject.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
    }

    public final String toString() {
        return k0.d(this, super.toString());
    }
}
