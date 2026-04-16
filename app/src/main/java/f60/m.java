package f60;

import java.util.Iterator;
import kotlin.jvm.internal.IntCompanionObject;
import oz0.d1;
import sx1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends c {

    /* JADX INFO: renamed from: j */
    public Iterator f119j;
    public d1 k;
    public int l;
    public int m;
    public /* synthetic */ Object n;
    public final /* synthetic */ n o;
    public int p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, c cVar) {
        super(cVar);
        this.o = nVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.n = obj;
        this.p |= IntCompanionObject.MIN_VALUE;
        return this.o.f(null, this);
    }
}
