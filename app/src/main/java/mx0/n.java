package mx0;

import kotlin.jvm.internal.IntCompanionObject;
import qx1.d;
import sx1.c;

/* JADX INFO: loaded from: classes.dex */
public final class n extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f336j;
    public int k;
    public final /* synthetic */ hw.o l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(hw.o oVar, d dVar) {
        super(dVar);
        this.l = oVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f336j = obj;
        this.k |= IntCompanionObject.MIN_VALUE;
        return this.l.emit((Object) null, this);
    }
}
