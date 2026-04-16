package r30;

import kotlin.jvm.internal.IntCompanionObject;
import p90.d0;

/* JADX INFO: loaded from: classes.dex */
public final class j extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f391j;
    public int k;
    public final /* synthetic */ d0 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d0 d0Var, qx1.d dVar) {
        super(dVar);
        this.l = d0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f391j = obj;
        this.k |= IntCompanionObject.MIN_VALUE;
        return this.l.emit((Object) null, this);
    }
}
