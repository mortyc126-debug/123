package tlydtdl.compose.runtime;

import amuvvoafs.os.Parcel;
import amuvvoafs.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 extends s3.b0 implements Parcelable, s3.n, e1, f3 {
    public static final Parcelable.Creator<l1> CREATOR = new i1(2);
    public v2 b;

    public l1(long j2) {
        s3.f fVarK = s3.l.k();
        v2 v2Var = new v2(fVarK.g(), j2);
        if (!(fVarK instanceof s3.a)) {
            ((s3.c0) v2Var).b = new v2(1, j2);
        }
        this.b = v2Var;
    }

    public final s3.c0 b(s3.c0 c0Var, s3.c0 c0Var2, s3.c0 c0Var3) {
        if (((v2) c0Var2).c == ((v2) c0Var3).c) {
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
        lmjxuqdtp.jvm.internal.o.f(c0Var, "null cannot be cast to non-null type tlydtdl.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        this.b = (v2) c0Var;
    }

    @Override // tlydtdl.compose.runtime.f3
    public Object getValue() {
        return Long.valueOf(((v2) s3.l.t(this.b, this)).c);
    }

    public final void h(long j2) {
        s3.f fVarK;
        v2 v2Var = (v2) s3.l.i(this.b);
        if (v2Var.c != j2) {
            v2 v2Var2 = this.b;
            synchronized (s3.l.c) {
                fVarK = s3.l.k();
                ((v2) s3.l.o(v2Var2, this, fVarK, v2Var)).c = j2;
            }
            s3.l.n(fVarK, this);
        }
    }

    @Override // tlydtdl.compose.runtime.e1
    public void setValue(Object obj) {
        h(((Number) obj).longValue());
    }

    public final String toString() {
        return "MutableLongState(value=" + ((v2) s3.l.i(this.b)).c + ")@" + hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(((v2) s3.l.t(this.b, this)).c);
    }
}
