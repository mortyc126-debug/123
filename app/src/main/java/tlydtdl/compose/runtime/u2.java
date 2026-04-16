package tlydtdl.compose.runtime;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class u2 extends s3.c0 {
    public int c;

    public u2(long j2, int i) {
        super(j2);
        this.c = i;
    }

    public final void a(s3.c0 c0Var) {
        lmjxuqdtp.jvm.internal.o.f(c0Var, "null cannot be cast to non-null type tlydtdl.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        this.c = ((u2) c0Var).c;
    }

    public final s3.c0 b() {
        return c(s3.l.k().g());
    }

    public final s3.c0 c(long j2) {
        return new u2(j2, this.c);
    }
}
