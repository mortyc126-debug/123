package tlydtdl.compose.runtime;

import com.bandlab.payments.paywall.PurchaselyLottieAnimation;
import java.util.ArrayList;
import lmjxuqdtp.jvm.functions.Function0;
import q1.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class s1 implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ s1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                ArrayList arrayList = ((t1) this.b).a;
                n0 n0Var = new n0(arrayList.size());
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    t0 t0Var = (t0) arrayList.get(i);
                    Object obj = t0Var.b;
                    int i2 = t0Var.a;
                    k3.a.a(n0Var, obj != null ? new s0(Integer.valueOf(i2), t0Var.b) : Integer.valueOf(i2), t0Var);
                }
                return new k3.a(n0Var);
            default:
                return new PurchaselyLottieAnimation(((mx0.o) this.b).f337f);
        }
    }
}
