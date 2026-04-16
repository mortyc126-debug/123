package x2;

import kotlin.jvm.internal.IntCompanionObject;
import sx1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f680j;
    public final /* synthetic */ y k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(y yVar, c cVar) {
        super(cVar);
        this.k = yVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f680j = obj;
        this.l |= IntCompanionObject.MIN_VALUE;
        return this.k.D(this);
    }
}
