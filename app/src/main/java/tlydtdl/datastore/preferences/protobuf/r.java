package tlydtdl.datastore.preferences.protobuf;

import f3.f2;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r {
    public static final /* synthetic */ int c = 0;
    public final w0 a = w0.f();
    public boolean b;

    static {
        new r(0);
    }

    public r() {
    }

    public static void b(m mVar, p1 p1Var, int i, Object obj) {
        if (p1Var == p1.d) {
            mVar.l0(i, 3);
            ((a) obj).b(mVar);
            mVar.l0(i, 4);
        }
        mVar.l0(i, p1Var.b);
        switch (p1Var.ordinal()) {
            case 0:
                mVar.f0(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                mVar.d0(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                mVar.p0(((Long) obj).longValue());
                break;
            case 3:
                mVar.p0(((Long) obj).longValue());
                break;
            case 4:
                mVar.h0(((Integer) obj).intValue());
                break;
            case 5:
                mVar.f0(((Long) obj).longValue());
                break;
            case 6:
                mVar.d0(((Integer) obj).intValue());
                break;
            case 7:
                mVar.X(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof g)) {
                    mVar.k0((String) obj);
                } else {
                    mVar.b0((g) obj);
                }
                break;
            case 9:
                ((a) obj).b(mVar);
                break;
            case 10:
                a aVar = (a) obj;
                mVar.getClass();
                mVar.n0(((w) aVar).a(null));
                aVar.b(mVar);
                break;
            case 11:
                if (!(obj instanceof g)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    mVar.n0(length);
                    mVar.Y(bArr, 0, length);
                } else {
                    mVar.b0((g) obj);
                }
                break;
            case 12:
                mVar.n0(((Integer) obj).intValue());
                break;
            case 13:
                mVar.h0(((Integer) obj).intValue());
                break;
            case 14:
                mVar.d0(((Integer) obj).intValue());
                break;
            case 15:
                mVar.f0(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                mVar.n0((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                mVar.p0((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a() {
        if (this.b) {
            return;
        }
        w0 w0Var = this.a;
        int size = w0Var.a.size();
        for (int i = 0; i < size; i++) {
            Map.Entry entryC = w0Var.c(i);
            if (entryC.getValue() instanceof w) {
                w wVar = (w) entryC.getValue();
                wVar.getClass();
                r0 r0Var = r0.c;
                r0Var.getClass();
                r0Var.a(wVar.getClass()).b(wVar);
                wVar.h();
            }
        }
        if (!w0Var.c) {
            if (w0Var.a.size() > 0) {
                w0Var.c(0).getKey().getClass();
                throw new ClassCastException();
            }
            Iterator it = w0Var.d().iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if (!w0Var.c) {
            w0Var.b = w0Var.b.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(w0Var.b);
            w0Var.e = w0Var.e.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(w0Var.e);
            w0Var.c = true;
        }
        this.b = true;
    }

    public final Object clone() {
        r rVar = new r();
        w0 w0Var = this.a;
        if (w0Var.a.size() > 0) {
            Map.Entry entryC = w0Var.c(0);
            f2.y(entryC.getKey());
            entryC.getValue();
            throw null;
        }
        Iterator it = w0Var.d().iterator();
        if (!it.hasNext()) {
            return rVar;
        }
        Map.Entry entry = (Map.Entry) it.next();
        f2.y(entry.getKey());
        entry.getValue();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            return this.a.equals(((r) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public r(int i) {
        a();
        a();
    }
}
