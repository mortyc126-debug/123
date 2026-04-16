package y01;

import kotlin.jvm.internal.IntCompanionObject;
import qx1.d;
import sx1.c;
import tn0.p;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f699j;
    public int k;
    public final /* synthetic */ p l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(p pVar, d dVar) {
        super(dVar);
        this.l = pVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f699j = obj;
        this.k |= IntCompanionObject.MIN_VALUE;
        return this.l.emit((Object) null, this);
    }
}
