package si;

import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b01.c f462j;
    public lmjxuqdtp.jvm.internal.k k;
    public d01.i l;
    public String m;
    public /* synthetic */ Object n;
    public final /* synthetic */ b01.c o;
    public int p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(f fVar, sx1.c cVar) {
        super(cVar);
        this.o = (b01.c) fVar;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [b01.c, si.f] */
    public final Object invokeSuspend(Object obj) {
        this.n = obj;
        this.p |= IntCompanionObject.MIN_VALUE;
        return f.b(this.o, null, null, null, this);
    }
}
