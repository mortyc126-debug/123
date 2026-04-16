package n7;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import tlydtdl.datastore.preferences.protobuf.a0;
import tlydtdl.datastore.preferences.protobuf.p0;
import tlydtdl.datastore.preferences.protobuf.q0;
import tlydtdl.datastore.preferences.protobuf.s0;
import tlydtdl.datastore.preferences.protobuf.t0;
import tlydtdl.datastore.preferences.protobuf.u;
import tlydtdl.datastore.preferences.protobuf.v;
import tlydtdl.datastore.preferences.protobuf.w;
import tlydtdl.datastore.preferences.protobuf.x;
import tlydtdl.datastore.preferences.protobuf.y;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends w {
    private static final f DEFAULT_INSTANCE;
    private static volatile p0 PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private x strings_ = s0.d;

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        w.j(f.class, fVar);
    }

    public static void l(f fVar, Iterable iterable) {
        x xVar = fVar.strings_;
        if (!((tlydtdl.datastore.preferences.protobuf.b) xVar).a) {
            s0 s0Var = (s0) xVar;
            int i = s0Var.c;
            fVar.strings_ = s0Var.e(i == 0 ? 10 : i * 2);
        }
        RandomAccess randomAccess = fVar.strings_;
        Charset charset = y.a;
        if (iterable instanceof a0) {
            List listJ = ((a0) iterable).j();
            if (randomAccess != null) {
                throw new ClassCastException();
            }
            ((s0) randomAccess).getClass();
            Iterator it = listJ.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                if (next instanceof tlydtdl.datastore.preferences.protobuf.g) {
                    throw null;
                }
                if (!(next instanceof byte[])) {
                    throw null;
                }
                byte[] bArr = (byte[]) next;
                tlydtdl.datastore.preferences.protobuf.g.e(bArr, 0, bArr.length);
                throw null;
            }
            return;
        }
        if (iterable instanceof q0) {
            ((tlydtdl.datastore.preferences.protobuf.b) randomAccess).addAll((Collection) iterable);
            return;
        }
        if ((randomAccess instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) randomAccess).ensureCapacity(((Collection) iterable).size() + ((s0) randomAccess).c);
        }
        s0 s0Var2 = (s0) randomAccess;
        int i2 = s0Var2.c;
        for (Object obj : iterable) {
            if (obj == null) {
                String str = "Element at index " + (s0Var2.c - i2) + " is null.";
                for (int i3 = s0Var2.c - 1; i3 >= i2; i3--) {
                    s0Var2.remove(i3);
                }
                throw new NullPointerException(str);
            }
            s0Var2.add(obj);
        }
    }

    public static f m() {
        return DEFAULT_INSTANCE;
    }

    public static e o() {
        return (e) ((u) DEFAULT_INSTANCE.c(5));
    }

    @Override // tlydtdl.datastore.preferences.protobuf.w
    public final Object c(int i) {
        p0 vVar;
        switch (p.k(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new t0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new f();
            case 4:
                return new e(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p0 p0Var = PARSER;
                if (p0Var != null) {
                    return p0Var;
                }
                synchronized (f.class) {
                    try {
                        vVar = PARSER;
                        if (vVar == null) {
                            vVar = new v();
                            PARSER = vVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return vVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final x n() {
        return this.strings_;
    }
}
