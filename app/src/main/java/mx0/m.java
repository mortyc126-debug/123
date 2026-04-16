package mx0;

import java.util.Date;
import kotlin.jvm.internal.IntCompanionObject;
import sx1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Date f335j;
    public Date k;
    public lx1.l[] l;
    public lx1.l[] m;
    public String n;
    public int o;
    public /* synthetic */ Object p;
    public final /* synthetic */ o q;
    public int r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(o oVar, c cVar) {
        super(cVar);
        this.q = oVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.p = obj;
        this.r |= IntCompanionObject.MIN_VALUE;
        return this.q.e(this);
    }
}
