package i30;

import b60.u;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public final class b extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f214j;
    public int k;
    public final /* synthetic */ u l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(u uVar, qx1.d dVar) {
        super(dVar);
        this.l = uVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f214j = obj;
        this.k |= IntCompanionObject.MIN_VALUE;
        return this.l.emit(null, this);
    }
}
