package b2;

import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1 f13j;
    public /* synthetic */ Object k;
    public final /* synthetic */ h l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h hVar, sx1.c cVar) {
        super(cVar);
        this.l = hVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.k = obj;
        this.m |= IntCompanionObject.MIN_VALUE;
        return this.l.d(null, 0.0f, null, this);
    }
}
