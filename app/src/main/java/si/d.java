package si;

import k80.t;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t f461j;
    public d01.i k;
    public dh1.k l;
    public /* synthetic */ Object m;
    public final /* synthetic */ l n;
    public int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(l lVar, sx1.c cVar) {
        super(cVar);
        this.n = lVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.m = obj;
        this.o |= IntCompanionObject.MIN_VALUE;
        return f.e(this.n, null, null, null, this);
    }
}
