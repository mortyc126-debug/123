package a51;

import kotlin.jvm.internal.IntCompanionObject;
import sx1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public s10.c f6j;
    public a k;
    public /* synthetic */ Object l;
    public final /* synthetic */ h m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, c cVar) {
        super(cVar);
        this.m = hVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.l = obj;
        this.n |= IntCompanionObject.MIN_VALUE;
        return this.m.a(null, null, this);
    }
}
