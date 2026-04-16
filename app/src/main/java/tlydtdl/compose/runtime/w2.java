package tlydtdl.compose.runtime;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class w2 extends s3.c0 {
    public Object c;

    public w2(Object obj, long j2) {
        super(j2);
        this.c = obj;
    }

    public final void a(s3.c0 c0Var) {
        lmjxuqdtp.jvm.internal.o.f(c0Var, "null cannot be cast to non-null type tlydtdl.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of tlydtdl.compose.runtime.SnapshotMutableStateImpl.StateStateRecord>");
        this.c = ((w2) c0Var).c;
    }

    public final s3.c0 b() {
        return new w2(this.c, s3.l.k().g());
    }

    public final s3.c0 c(long j2) {
        return new w2(this.c, s3.l.k().g());
    }
}
