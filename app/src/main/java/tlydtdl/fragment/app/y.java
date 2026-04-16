package tlydtdl.fragment.app;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y implements Runnable {
    public final /* synthetic */ k0 a;

    public /* synthetic */ y(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k0 k0Var = this.a;
        f2 f2Var = k0Var.mViewLifecycleOwner;
        f2Var.f582f.a(k0Var.mSavedViewRegistryState);
        k0Var.mSavedViewRegistryState = null;
    }
}
