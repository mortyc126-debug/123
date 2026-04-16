package tlydtdl.datastore.preferences.protobuf;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class g implements Iterable, Serializable {
    public static final g c = new g(y.b);
    public static final f d;
    public int a = 0;
    public final byte[] b;

    static {
        d = c.a() ? new h() : new yr1.f(8);
    }

    public g(byte[] bArr) {
        bArr.getClass();
        this.b = bArr;
    }

    public static int d(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(z.p.c(i, "Beginning index: ", " < 0"));
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException(s1.a.j("Beginning index larger than ending index: ", i, i2, ", "));
        }
        throw new IndexOutOfBoundsException(s1.a.j("End index: ", i2, i3, " >= "));
    }

    public static g e(byte[] bArr, int i, int i2) {
        d(i, i + i2, bArr.length);
        return new g(d.a(bArr, i, i2));
    }

    public byte b(int i) {
        return this.b[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g) || size() != ((g) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof g)) {
            return obj.equals(this);
        }
        g gVar = (g) obj;
        int i = this.a;
        int i2 = gVar.a;
        if (i != 0 && i2 != 0 && i != i2) {
            return false;
        }
        int size = size();
        if (size > gVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > gVar.size()) {
            StringBuilder sbR = o6.c.r(size, "Ran off end of other: 0, ", ", ");
            sbR.append(gVar.size());
            throw new IllegalArgumentException(sbR.toString());
        }
        byte[] bArr = gVar.b;
        int i3 = i() + size;
        int i4 = i();
        int i6 = gVar.i();
        while (i4 < i3) {
            if (this.b[i4] != bArr[i6]) {
                return false;
            }
            i4++;
            i6++;
        }
        return true;
    }

    public void h(int i, byte[] bArr) {
        System.arraycopy(this.b, 0, bArr, 0, i);
    }

    public final int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int size = size();
        int i2 = i();
        int i3 = size;
        for (int i4 = i2; i4 < i2 + size; i4++) {
            i3 = (i3 * 31) + this.b[i4];
        }
        if (i3 == 0) {
            i3 = 1;
        }
        this.a = i3;
        return i3;
    }

    public int i() {
        return 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new d(this);
    }

    public byte k(int i) {
        return this.b[i];
    }

    public int size() {
        return this.b.length;
    }

    public final String toString() {
        String string;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            string = xn1.a.y(this);
        } else {
            StringBuilder sb = new StringBuilder();
            int iD = d(0, 47, size());
            sb.append(xn1.a.y(iD == 0 ? c : new e(this.b, i(), iD)));
            sb.append("...");
            string = sb.toString();
        }
        return i.p(i.r("<ByteString@", size, hexString, " size=", " contents=\""), string, "\">");
    }
}
