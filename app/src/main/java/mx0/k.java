package mx0;

import kotlin.jvm.internal.IntCompanionObject;
import sx1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ty1.a f333j;
    public int k;
    public /* synthetic */ Object l;
    public final /* synthetic */ o m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(o oVar, c cVar) {
        super(cVar);
        this.m = oVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.l = obj;
        this.n |= IntCompanionObject.MIN_VALUE;
        return this.m.c(this);
    }
}
