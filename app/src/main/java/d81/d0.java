package d81;

import java.util.Iterator;
import kotlin.jvm.internal.IntCompanionObject;
import sx1.c;
import ty1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f80j;
    public Iterator k;
    public int l;
    public int m;
    public int n;
    public /* synthetic */ Object o;
    public final /* synthetic */ f0 p;
    public int q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(f0 f0Var, c cVar) {
        super(cVar);
        this.p = f0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.o = obj;
        this.q |= IntCompanionObject.MIN_VALUE;
        return f0.a(this.p, this);
    }
}
