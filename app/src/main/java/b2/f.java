package b2;

import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f14j;
    public final /* synthetic */ h k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, sx1.c cVar) {
        super(cVar);
        this.k = hVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f14j = obj;
        this.l |= IntCompanionObject.MIN_VALUE;
        return this.k.b(null, 0.0f, null, this);
    }
}
