package wg;

import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f650j;
    public final /* synthetic */ u k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(u uVar, sx1.c cVar) {
        super(cVar);
        this.k = uVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f650j = obj;
        this.l |= IntCompanionObject.MIN_VALUE;
        this.k.c(this);
        return null;
    }
}
