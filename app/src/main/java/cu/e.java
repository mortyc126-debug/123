package cu;

import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f57j;
    public final /* synthetic */ f k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, sx1.c cVar) {
        super(cVar);
        this.k = fVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f57j = obj;
        this.l |= IntCompanionObject.MIN_VALUE;
        return this.k.b(this);
    }
}
