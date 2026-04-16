package bh;

import bb.w;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.ironsource.mediationsdk.IronSource;
import java.util.ArrayList;
import ky1.a0;
import lg.e;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import qx1.d;
import sx1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o f28j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(o oVar, d dVar) {
        super(2, dVar);
        this.f28j = oVar;
    }

    public final d create(Object obj, d dVar) {
        return new k(this.f28j, dVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return create((a0) obj, (d) obj2).invokeSuspend(b0.a);
    }

    public final Object invokeSuspend(Object obj) {
        o oVar = this.f28j;
        rx1.a aVar = rx1.a.a;
        e.O(obj);
        try {
            IronSource.init(oVar.b, oVar.a, new b4.d(8), new IronSource.AD_UNIT[]{IronSource.AD_UNIT.INTERSTITIAL, IronSource.AD_UNIT.BANNER});
            return Boolean.TRUE;
        } catch (Exception e) {
            w wVar = new w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[]{"Ads", "IronSource"});
            j.w("Not able to init IronSource SDK", new TaggedException(e, (String[]) arrayList.toArray(new String[arrayList.size()])));
            return Boolean.FALSE;
        }
    }
}
