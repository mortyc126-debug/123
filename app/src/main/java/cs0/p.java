package cs0;

import b60.u;
import kotlin.jvm.internal.IntCompanionObject;
import qx1.d;
import sx1.c;

/* JADX INFO: loaded from: classes.dex */
public final class p extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f50j;
    public int k;
    public final /* synthetic */ u l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(u uVar, d dVar) {
        super(dVar);
        this.l = uVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f50j = obj;
        this.k |= IntCompanionObject.MIN_VALUE;
        return this.l.emit(null, this);
    }
}
