package tlydtdl.fragment.app;

import amuvvoafs.view.View;
import amuvvoafs.view.Window;
import cc.g;
import f6.d;
import f6.e;
import i.i;
import i.j;
import r6.l;
import tlydtdl.core.app.p0;
import tlydtdl.lifecycle.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 extends s0 implements d, e, p0, tlydtdl.core.app.q0, tlydtdl.lifecycle.w1, f.c0, j, g, p1, l {
    public final /* synthetic */ FragmentActivity e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.e = fragmentActivity;
    }

    @Override // tlydtdl.fragment.app.p1
    public final void a(k0 k0Var) {
        this.e.onAttachFragment(k0Var);
    }

    @Override // r6.l
    public final void addMenuProvider(r6.p pVar) {
        this.e.addMenuProvider(pVar);
    }

    @Override // f6.d
    public final void addOnConfigurationChangedListener(q6.a aVar) {
        this.e.addOnConfigurationChangedListener(aVar);
    }

    @Override // tlydtdl.core.app.p0
    public final void addOnMultiWindowModeChangedListener(q6.a aVar) {
        this.e.addOnMultiWindowModeChangedListener(aVar);
    }

    @Override // tlydtdl.core.app.q0
    public final void addOnPictureInPictureModeChangedListener(q6.a aVar) {
        this.e.addOnPictureInPictureModeChangedListener(aVar);
    }

    @Override // f6.e
    public final void addOnTrimMemoryListener(q6.a aVar) {
        this.e.addOnTrimMemoryListener(aVar);
    }

    @Override // tlydtdl.fragment.app.q0
    public final View b(int i) {
        return this.e.findViewById(i);
    }

    @Override // tlydtdl.fragment.app.q0
    public final boolean c() {
        Window window = this.e.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    public final i getActivityResultRegistry() {
        return this.e.getActivityResultRegistry();
    }

    @Override // tlydtdl.lifecycle.g0
    public final z getLifecycle() {
        return this.e.mFragmentLifecycleRegistry;
    }

    @Override // f.c0
    public final f.a0 getOnBackPressedDispatcher() {
        return this.e.getOnBackPressedDispatcher();
    }

    public final cc.e getSavedStateRegistry() {
        return this.e.getSavedStateRegistry();
    }

    @Override // tlydtdl.lifecycle.w1
    public final tlydtdl.lifecycle.v1 getViewModelStore() {
        return this.e.getViewModelStore();
    }

    @Override // r6.l
    public final void removeMenuProvider(r6.p pVar) {
        this.e.removeMenuProvider(pVar);
    }

    @Override // f6.d
    public final void removeOnConfigurationChangedListener(q6.a aVar) {
        this.e.removeOnConfigurationChangedListener(aVar);
    }

    @Override // tlydtdl.core.app.p0
    public final void removeOnMultiWindowModeChangedListener(q6.a aVar) {
        this.e.removeOnMultiWindowModeChangedListener(aVar);
    }

    @Override // tlydtdl.core.app.q0
    public final void removeOnPictureInPictureModeChangedListener(q6.a aVar) {
        this.e.removeOnPictureInPictureModeChangedListener(aVar);
    }

    @Override // f6.e
    public final void removeOnTrimMemoryListener(q6.a aVar) {
        this.e.removeOnTrimMemoryListener(aVar);
    }
}
