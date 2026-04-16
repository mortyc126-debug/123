package kp;

import lmjxuqdtp.jvm.functions.Function3;
import lx1.b0;
import sx1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends i implements Function3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f266j;
    public /* synthetic */ String k;
    public /* synthetic */ String l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i, int i2, qx1.d dVar) {
        super(i, dVar);
        this.f266j = i2;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        String str = (String) obj;
        String str2 = (String) obj2;
        qx1.d dVar = (qx1.d) obj3;
        switch (this.f266j) {
            case 0:
                d dVar2 = new d(3, 0, dVar);
                dVar2.k = str;
                dVar2.l = str2;
                return dVar2.invokeSuspend(b0.a);
            default:
                d dVar3 = new d(3, 1, dVar);
                dVar3.k = str;
                dVar3.l = str2;
                return dVar3.invokeSuspend(b0.a);
        }
    }

    public final Object invokeSuspend(Object obj) {
        switch (this.f266j) {
            case 0:
                String str = this.k;
                String str2 = this.l;
                rx1.a aVar = rx1.a.a;
                lg.e.O(obj);
                return Boolean.valueOf(str.length() > 0 && str2.length() > 0);
            default:
                String str3 = this.k;
                String str4 = this.l;
                rx1.a aVar2 = rx1.a.a;
                lg.e.O(obj);
                return str3 == null ? str4 : str3;
        }
    }
}
