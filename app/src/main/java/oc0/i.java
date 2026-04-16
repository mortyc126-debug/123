package oc0;

import java.util.List;
import ky1.a0;
import lmjxuqdtp.jvm.functions.Function3;
import lx1.b0;
import rx1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends sx1.i implements Function3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f366j;
    public int k;
    public int l;
    public /* synthetic */ a0 m;
    public /* synthetic */ tc0.p n;
    public final /* synthetic */ l o;
    public final /* synthetic */ sx1.i p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(l lVar, Function3 function3, qx1.d dVar) {
        super(3, dVar);
        this.o = lVar;
        this.p = (sx1.i) function3;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        i iVar = new i(this.o, this.p, (qx1.d) obj3);
        iVar.m = (a0) obj;
        iVar.n = (tc0.p) obj2;
        return iVar.invokeSuspend(b0.a);
    }

    public final Object invokeSuspend(Object obj) {
        int i;
        int i2;
        a0 a0Var = this.m;
        tc0.p pVar = this.n;
        a aVar = a.a;
        int i3 = this.l;
        if (i3 == 0) {
            lg.e.O(obj);
            String str = pVar.c;
            int i4 = str != null ? Integer.parseInt(str) : 0;
            l lVar = this.o;
            int i6 = pVar.d + (i4 == 0 ? lVar.d : 0);
            gc0.a aVar2 = new gc0.a(i4, i6, lVar.c);
            this.m = null;
            this.n = null;
            this.f366j = i4;
            this.k = i6;
            this.l = 1;
            Object objInvoke = this.p.invoke(a0Var, aVar2, this);
            if (objInvoke == aVar) {
                return aVar;
            }
            i = i4;
            obj = objInvoke;
            i2 = i6;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i2 = this.k;
            i = this.f366j;
            lg.e.O(obj);
        }
        List list = (List) obj;
        return new tc0.l(list, new tc0.s(new Integer(list.size()), new tc0.h(list.size() == i2 ? String.valueOf(i + i2) : null, (String) null), 2));
    }
}
