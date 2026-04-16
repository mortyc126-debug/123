package hj;

import com.bandlab.arrangement.view.ArrangementView;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ArrangementView b;

    public /* synthetic */ m(ArrangementView arrangementView, int i) {
        this.a = i;
        this.b = arrangementView;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return ArrangementView.k(this.b);
            case 1:
                return this.b.k;
            default:
                return Boolean.valueOf(this.b.i);
        }
    }
}
