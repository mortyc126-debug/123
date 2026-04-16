package tlydtdl.datastore.preferences.protobuf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import r6.z1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public int a;
    public Object b;

    public k(int i) {
        this.a = i;
    }

    public static int t(int i, FileInputStream fileInputStream) throws IOException, com.gnacba.protobuf.InvalidProtocolBufferException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = fileInputStream.read();
            if (i4 == -1) {
                throw com.gnacba.protobuf.InvalidProtocolBufferException.e();
            }
            i2 |= (i4 & 127) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i6 = fileInputStream.read();
            if (i6 == -1) {
                throw com.gnacba.protobuf.InvalidProtocolBufferException.e();
            }
            if ((i6 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw com.gnacba.protobuf.InvalidProtocolBufferException.c();
    }

    public abstract int A();

    public abstract int B();

    public abstract long C();

    public abstract boolean D(int i);

    public void E() {
        int iA;
        do {
            iA = A();
            if (iA == 0) {
                return;
            }
            int i = this.a;
            if (i >= 100) {
                throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.a = i + 1;
            this.a--;
        } while (D(iA));
    }

    public abstract void a(int i);

    public abstract int b();

    public abstract boolean c();

    public void d(r6.i1 i1Var) {
    }

    public void e(r6.i1 i1Var) {
    }

    public abstract z1 f(z1 z1Var, List list);

    public i11.c g(r6.i1 i1Var, i11.c cVar) {
        return cVar;
    }

    public abstract void h(int i);

    public abstract int i(int i);

    public abstract boolean j();

    public abstract g k();

    public abstract double l();

    public abstract int m();

    public abstract int n();

    public abstract long p();

    public abstract float q();

    public abstract int r();

    public abstract long s();

    public abstract int u();

    public abstract long v();

    public abstract int w();

    public abstract long x();

    public abstract String y();

    public abstract String z();
}
