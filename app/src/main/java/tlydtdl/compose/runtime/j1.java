package tlydtdl.compose.runtime;

import amuvvoafs.os.Parcel;
import amuvvoafs.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 extends s3.b0 implements Parcelable, d1, s3.n {
    public static final Parcelable.Creator<j1> CREATOR = new i1(0);
    public t2 b;

    public j1(float f2) {
        s3.f fVarK = s3.l.k();
        t2 t2Var = new t2(fVarK.g(), f2);
        if (!(fVarK instanceof s3.a)) {
            ((s3.c0) t2Var).b = new t2(1, f2);
        }
        this.b = t2Var;
    }

    public final s3.c0 b(s3.c0 c0Var, s3.c0 c0Var2, s3.c0 c0Var3) {
        if (((t2) c0Var2).c == ((t2) c0Var3).c) {
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
        lmjxuqdtp.jvm.internal.o.f(c0Var, "null cannot be cast to non-null type tlydtdl.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        this.b = (t2) c0Var;
    }

    public final float h() {
        return ((t2) s3.l.t(this.b, this)).c;
    }

    public final void i(float f2) {
        s3.f fVarK;
        t2 t2Var = (t2) s3.l.i(this.b);
        if (t2Var.c == f2) {
            return;
        }
        t2 t2Var2 = this.b;
        synchronized (s3.l.c) {
            fVarK = s3.l.k();
            ((t2) s3.l.o(t2Var2, this, fVarK, t2Var)).c = f2;
        }
        s3.l.n(fVarK, this);
    }

    public final String toString() {
        return "MutableFloatState(value=" + ((t2) s3.l.i(this.b)).c + ")@" + hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(h());
    }
}
