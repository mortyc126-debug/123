package s51;

import lmjxuqdtp.jvm.functions.Function1;
import nd.c;
import p90.f;
import pd.a;
import qd.d;
import rd.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends c {
    public final String b;
    public final long c;
    public final /* synthetic */ n0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(n0 n0Var, String str, long j2, f fVar) {
        super(fVar);
        this.d = n0Var;
        this.b = str;
        this.c = j2;
    }

    public final void a(a aVar) {
        ((g) this.d.a).a(new String[]{"Songs"}, aVar);
    }

    public final d b(Function1 function1) {
        return ((g) this.d.a).f(null, hy1.r.d0("\n    |SELECT count(*) > 0 FROM Songs\n    |WHERE\n    |    userId = ?\n    |    AND\n    |    (status IS NULL OR status != 'Deleted')\n    |    AND\n    |    (? IS NULL OR authorId IS ?)\n    |    AND\n    |    (? = 0 OR isCollaborator = 1 OR collaboratorsCount > 0)\n    "), function1, 4, new lb.d(28, this));
    }

    public final void e(a aVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
        ((g) this.d.a).t(new String[]{"Songs"}, aVar);
    }

    public final String toString() {
        return "Song.sq:hasSongList";
    }
}
