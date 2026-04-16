package b60;

import kotlin.jvm.internal.IntCompanionObject;
import qx1.d;
import sx1.c;

/* JADX INFO: loaded from: classes.dex */
public final class t extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f21j;
    public int k;
    public final /* synthetic */ u l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, d dVar) {
        super(dVar);
        this.l = uVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f21j = obj;
        this.k |= IntCompanionObject.MIN_VALUE;
        return this.l.emit(null, this);
    }
}
