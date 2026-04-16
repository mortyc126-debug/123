package f60;

import kotlin.jvm.internal.IntCompanionObject;
import sx1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f118j;
    public /* synthetic */ Object k;
    public final /* synthetic */ n l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(n nVar, c cVar) {
        super(cVar);
        this.l = nVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.k = obj;
        this.m |= IntCompanionObject.MIN_VALUE;
        return this.l.e(this);
    }
}
