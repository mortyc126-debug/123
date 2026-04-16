package tlydtdl.compose.runtime;

import amuvvoafs.os.Parcel;
import amuvvoafs.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n1 extends s3.b0 implements Parcelable, s3.n {
    public static final Parcelable.Creator<n1> CREATOR = new m1();
    public final x2 b;
    public w2 c;

    public n1(Object obj, x2 x2Var) {
        this.b = x2Var;
        s3.f fVarK = s3.l.k();
        w2 w2Var = new w2(obj, fVarK.g());
        if (!(fVarK instanceof s3.a)) {
            ((s3.c0) w2Var).b = new w2(obj, 1);
        }
        this.c = w2Var;
    }

    public final s3.c0 b(s3.c0 c0Var, s3.c0 c0Var2, s3.c0 c0Var3) {
        if (this.b.a(((w2) c0Var2).c, ((w2) c0Var3).c)) {
            return c0Var2;
        }
        return null;
    }

    public final x2 c() {
        return this.b;
    }

    public final s3.c0 d() {
        return this.c;
    }

    public final int describeContents() {
        return 0;
    }

    public final void e(s3.c0 c0Var) {
        lmjxuqdtp.jvm.internal.o.f(c0Var, "null cannot be cast to non-null type tlydtdl.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of tlydtdl.compose.runtime.SnapshotMutableStateImpl>");
        this.c = (w2) c0Var;
    }

    public final Object getValue() {
        return ((w2) s3.l.t(this.c, this)).c;
    }

    public final void setValue(Object obj) {
        s3.f fVarK;
        w2 w2Var = (w2) s3.l.i(this.c);
        if (this.b.a(w2Var.c, obj)) {
            return;
        }
        w2 w2Var2 = this.c;
        synchronized (s3.l.c) {
            fVarK = s3.l.k();
            ((w2) s3.l.o(w2Var2, this, fVarK, w2Var)).c = obj;
        }
        s3.l.n(fVarK, this);
    }

    public final String toString() {
        return "MutableState(value=" + ((w2) s3.l.i(this.c)).c + ")@" + hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeValue(getValue());
        x0 x0Var = x0.c;
        x2 x2Var = this.b;
        if (lmjxuqdtp.jvm.internal.o.c(x2Var, x0Var)) {
            i2 = 0;
        } else if (lmjxuqdtp.jvm.internal.o.c(x2Var, x0.f548f)) {
            i2 = 1;
        } else {
            if (!lmjxuqdtp.jvm.internal.o.c(x2Var, x0.d)) {
                throw new IllegalStateException("Only known types of MutableState's SnapshotMutationPolicy are supported");
            }
            i2 = 2;
        }
        parcel.writeInt(i2);
    }
}
