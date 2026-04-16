package cs0;

import ak.f3;
import kotlin.jvm.internal.IntCompanionObject;
import qx1.d;
import sx1.c;

/* JADX INFO: loaded from: classes.dex */
public final class q extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f51j;
    public int k;
    public final /* synthetic */ f3 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(f3 f3Var, d dVar) {
        super(dVar);
        this.l = f3Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f51j = obj;
        this.k |= IntCompanionObject.MIN_VALUE;
        return this.l.emit((Object) null, this);
    }
}
