package oc0;

import kotlin.jvm.internal.IntCompanionObject;
import sx1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f367j;
    public final /* synthetic */ l k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(l lVar, qx1.d dVar) {
        super(dVar);
        this.k = lVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f367j = obj;
        this.l |= IntCompanionObject.MIN_VALUE;
        return this.k.n(this);
    }
}
