package zq0;

import d01.i;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i f756j;
    public /* synthetic */ Object k;
    public final /* synthetic */ u l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(u uVar, sx1.c cVar) {
        super(cVar);
        this.l = uVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.k = obj;
        this.m |= IntCompanionObject.MIN_VALUE;
        return this.l.b(null, this);
    }
}
