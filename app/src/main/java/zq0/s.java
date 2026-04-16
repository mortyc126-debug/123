package zq0;

import kotlin.jvm.internal.IntCompanionObject;
import yr.b5;

/* JADX INFO: loaded from: classes.dex */
public final class s extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f757j;
    public int k;
    public final /* synthetic */ b5 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(b5 b5Var, qx1.d dVar) {
        super(dVar);
        this.l = b5Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f757j = obj;
        this.k |= IntCompanionObject.MIN_VALUE;
        return this.l.emit((Object) null, this);
    }
}
