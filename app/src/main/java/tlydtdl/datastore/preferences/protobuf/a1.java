package tlydtdl.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a1 {
    public abstract b1 a(Object obj);

    public final boolean b(int i, l lVar, Object obj) throws InvalidProtocolBufferException {
        int i2 = lVar.b;
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            lVar.w(0);
            ((b1) obj).c(i3 << 3, Long.valueOf(lVar.a.s()));
            return true;
        }
        if (i4 == 1) {
            lVar.w(1);
            ((b1) obj).c((i3 << 3) | 1, Long.valueOf(lVar.a.p()));
            return true;
        }
        if (i4 == 2) {
            ((b1) obj).c((i3 << 3) | 2, lVar.e());
            return true;
        }
        if (i4 != 3) {
            if (i4 == 4) {
                return false;
            }
            if (i4 != 5) {
                throw InvalidProtocolBufferException.b();
            }
            lVar.w(5);
            ((b1) obj).c(5 | (i3 << 3), Integer.valueOf(lVar.a.n()));
            return true;
        }
        b1 b1Var = new b1(0, new int[8], new Object[8], true);
        int i6 = i3 << 3;
        int i7 = i6 | 4;
        int i8 = i + 1;
        if (i8 >= 100) {
            throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (lVar.a() != Integer.MAX_VALUE && b(i8, lVar, b1Var)) {
        }
        if (i7 != lVar.b) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
        if (b1Var.e) {
            b1Var.e = false;
        }
        ((b1) obj).c(i6 | 3, b1Var);
        return true;
    }
}
