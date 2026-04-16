package zq0;

import com.gnacba.amuvvoafs.gms.internal.measurement.i4;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f759j;
    public ty1.a k;
    public int l;
    public /* synthetic */ Object m;
    public final /* synthetic */ i4 n;
    public int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(i4 i4Var, sx1.c cVar) {
        super(cVar);
        this.n = i4Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.m = obj;
        this.o |= IntCompanionObject.MIN_VALUE;
        return this.n.f(false, this);
    }
}
