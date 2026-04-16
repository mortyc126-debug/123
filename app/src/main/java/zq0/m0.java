package zq0;

import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f753j;
    public final /* synthetic */ n0 k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(n0 n0Var, sx1.c cVar) {
        super(cVar);
        this.k = n0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f753j = obj;
        this.l |= IntCompanionObject.MIN_VALUE;
        Object objA = this.k.a(false, this);
        return objA == rx1.a.a ? objA : new lx1.o(objA);
    }
}
