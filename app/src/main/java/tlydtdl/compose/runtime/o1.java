package tlydtdl.compose.runtime;

import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1 f536j;
    public /* synthetic */ Object k;
    public final /* synthetic */ p1 l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(p1 p1Var, qx1.d dVar) {
        super(dVar);
        this.l = p1Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.k = obj;
        this.m |= IntCompanionObject.MIN_VALUE;
        return this.l.F(null, this);
    }
}
