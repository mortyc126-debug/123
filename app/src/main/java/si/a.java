package si;

import com.braze.BrazeUser;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i f458j;
    public BrazeUser k;
    public d01.i l;
    public Boolean m;
    public /* synthetic */ Object n;
    public final /* synthetic */ i o;
    public int p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(i iVar, sx1.c cVar) {
        super(cVar);
        this.o = iVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.n = obj;
        this.p |= IntCompanionObject.MIN_VALUE;
        return f.m(this.o, null, null, null, this);
    }
}
