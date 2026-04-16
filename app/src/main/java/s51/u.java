package s51;

import kotlin.jvm.internal.IntCompanionObject;
import p90.d0;
import qx1.d;
import sx1.c;

/* JADX INFO: loaded from: classes.dex */
public final class u extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f453j;
    public int k;
    public final /* synthetic */ d0 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(d0 d0Var, d dVar) {
        super(dVar);
        this.l = d0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f453j = obj;
        this.k |= IntCompanionObject.MIN_VALUE;
        return this.l.emit((Object) null, this);
    }
}
