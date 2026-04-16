package zq0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f747j;
    public ty1.a k;
    public List l;
    public Collection m;
    public Iterator n;
    public wq0.c o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public /* synthetic */ Object u;
    public final /* synthetic */ g v;
    public int w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar, sx1.c cVar) {
        super(cVar);
        this.v = gVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.u = obj;
        this.w |= IntCompanionObject.MIN_VALUE;
        return this.v.a(null, this);
    }
}
