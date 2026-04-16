package s51;

import kotlin.jvm.internal.IntCompanionObject;
import sx1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f448j;
    public final /* synthetic */ b0 k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(b0 b0Var, c cVar) {
        super(cVar);
        this.k = b0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f448j = obj;
        this.l |= IntCompanionObject.MIN_VALUE;
        return this.k.k(this);
    }
}
