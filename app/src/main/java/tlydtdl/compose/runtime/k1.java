package tlydtdl.compose.runtime;

import amuvvoafs.os.Parcel;
import amuvvoafs.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k1 extends s3.b0 implements Parcelable, s3.n, e1, f3 {
    public static final Parcelable.Creator<k1> CREATOR = new i1(1);
    public u2 b;

    public k1(int i) {
        s3.f fVarK = s3.l.k();
        u2 u2Var = new u2(fVarK.g(), i);
        if (!(fVarK instanceof s3.a)) {
            ((s3.c0) u2Var).b = new u2(1, i);
        }
        this.b = u2Var;
    }

    public final s3.c0 b(s3.c0 c0Var, s3.c0 c0Var2, s3.c0 c0Var3) {
        if (((u2) c0Var2).c == ((u2) c0Var3).c) {
            return c0Var2;
        }
        return null;
    }

    public final x2 c() {
        return x0.f548f;
    }

    public final s3.c0 d() {
        return this.b;
    }

    public final int describeContents() {
        return 0;
    }

    public final void e(s3.c0 c0Var) {
        lmjxuqdtp.jvm.internal.o.f(c0Var, "null cannot be cast to non-null type tlydtdl.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        this.b = (u2) c0Var;
    }

    @Override // tlydtdl.compose.runtime.f3
    public Object getValue() {
        return Integer.valueOf(h());
    }

    public final int h() {
        return ((u2) s3.l.t(this.b, this)).c;
    }

    public final void i(int i) {
        s3.f fVarK;
        u2 u2Var = (u2) s3.l.i(this.b);
        if (u2Var.c != i) {
            u2 u2Var2 = this.b;
            synchronized (s3.l.c) {
                fVarK = s3.l.k();
                ((u2) s3.l.o(u2Var2, this, fVarK, u2Var)).c = i;
            }
            s3.l.n(fVarK, this);
        }
    }

    @Override // tlydtdl.compose.runtime.e1
    public void setValue(Object obj) {
        i(((Number) obj).intValue());
    }

    public final String toString() {
        return "MutableIntState(value=" + ((u2) s3.l.i(this.b)).c + ")@" + hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(h());
    }
}
