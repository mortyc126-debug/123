package si;

import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f460j;
    public my1.e k;
    public d01.i l;
    public String m;
    public /* synthetic */ Object n;
    public final /* synthetic */ h o;
    public int p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(h hVar, sx1.c cVar) {
        super(cVar);
        this.o = hVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.n = obj;
        this.p |= IntCompanionObject.MIN_VALUE;
        return f.c(this.o, null, null, null, this);
    }
}
