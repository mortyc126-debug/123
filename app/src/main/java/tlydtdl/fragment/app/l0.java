package tlydtdl.fragment.app;

import amuvvoafs.os.Bundle;
import cc.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l0 implements d {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ l0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final Bundle b() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                FragmentActivity fragmentActivity = (FragmentActivity) obj;
                int i2 = FragmentActivity.b;
                fragmentActivity.markFragmentsCreated();
                fragmentActivity.mFragmentLifecycleRegistry.g(tlydtdl.lifecycle.x.ON_STOP);
                return new Bundle();
            default:
                return ((k1) obj).c0();
        }
    }
}
