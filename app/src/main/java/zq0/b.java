package zq0;

import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f744j;
    public final /* synthetic */ c k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, sx1.c cVar2) {
        super(cVar2);
        this.k = cVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f744j = obj;
        this.l |= IntCompanionObject.MIN_VALUE;
        Object objA = this.k.a(false, this);
        return objA == rx1.a.a ? objA : new lx1.o(objA);
    }
}
