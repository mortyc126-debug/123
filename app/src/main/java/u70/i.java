package u70;

import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public final class i extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f617j;
    public int k;
    public final /* synthetic */ tn0.p l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(tn0.p pVar, qx1.d dVar) {
        super(dVar);
        this.l = pVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f617j = obj;
        this.k |= IntCompanionObject.MIN_VALUE;
        return this.l.emit((Object) null, this);
    }
}
