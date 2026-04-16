package nu0;

import com.bandlab.mixeditor.uikit.actionbar.StudioActionBarView;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ StudioActionBarView b;

    public /* synthetic */ f(StudioActionBarView studioActionBarView, int i, int i2) {
        this.a = i2;
        this.b = studioActionBarView;
    }

    public final Object invoke(Object obj, Object obj2) {
        int i = this.a;
        b0 b0Var = b0.a;
        StudioActionBarView studioActionBarView = this.b;
        m mVar = (m) obj;
        ((Integer) obj2).getClass();
        int i2 = StudioActionBarView.k;
        switch (i) {
            case 0:
                studioActionBarView.a(mVar, a0.B(1));
                break;
            case 1:
                studioActionBarView.a(mVar, a0.B(1));
                break;
            default:
                studioActionBarView.a(mVar, a0.B(1));
                break;
        }
        return b0Var;
    }
}
