package xa0;

import b01.m;
import b01.n;
import b01.o;
import b01.q;
import b01.t;
import tlydtdl.compose.foundation.lazy.layout.r1;
import y10.r;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends b01.c {
    public static final c c;
    public static final String d;
    public static final n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o f692f;
    public static final r1 g;

    static {
        c cVar = new c(0);
        c = cVar;
        d = "review_failed";
        e = n.b;
        f692f = o.a;
        g = r.b0(cVar, "hasShowInAppReviewFailed", new q("in_app_review"), 2);
    }

    @Override // b01.m
    public final n f() {
        return e;
    }

    @Override // b01.m
    public final t g() {
        return f692f;
    }

    @Override // b01.m
    public final m k() {
        return g;
    }

    @Override // b01.c
    public final boolean q() {
        return false;
    }

    @Override // b01.c
    public final String u() {
        return d;
    }
}
