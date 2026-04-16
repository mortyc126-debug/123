package g7;

import java.lang.ref.WeakReference;
import tlydtdl.lifecycle.f0;
import tlydtdl.lifecycle.v0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements f0 {
    public final WeakReference a;

    public t(v vVar) {
        this.a = new WeakReference(vVar);
    }

    @v0(tlydtdl.lifecycle.x.ON_START)
    public void onStart() {
        v vVar = (v) this.a.get();
        if (vVar != null) {
            vVar.k();
        }
    }
}
