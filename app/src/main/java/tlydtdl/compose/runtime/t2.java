package tlydtdl.compose.runtime;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t2 extends s3.c0 {
    public float c;

    public t2(long j2, float f2) {
        super(j2);
        this.c = f2;
    }

    public final void a(s3.c0 c0Var) {
        lmjxuqdtp.jvm.internal.o.f(c0Var, "null cannot be cast to non-null type tlydtdl.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        this.c = ((t2) c0Var).c;
    }

    public final s3.c0 b() {
        return c(s3.l.k().g());
    }

    public final s3.c0 c(long j2) {
        return new t2(j2, this.c);
    }
}
