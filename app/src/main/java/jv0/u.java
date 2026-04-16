package jv0;

import kotlin.jvm.internal.IntCompanionObject;
import sx1.c;

/* JADX INFO: loaded from: classes.dex */
public final class u extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f250j;
    public int k;
    public final /* synthetic */ hw.o l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(hw.o oVar, qx1.d dVar) {
        super(dVar);
        this.l = oVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f250j = obj;
        this.k |= IntCompanionObject.MIN_VALUE;
        return this.l.emit((Object) null, this);
    }
}
