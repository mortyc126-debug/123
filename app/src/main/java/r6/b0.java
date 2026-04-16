package r6;

import amuvvoafs.os.Build;
import amuvvoafs.view.View;
import amuvvoafs.view.WindowInsets;
import amuvvoafs.view.WindowInsetsController;
import amuvvoafs.view.inputmethod.InputMethodManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends m80.b {
    public View d;

    public final void k() {
        View view = this.d;
        WindowInsetsController windowInsetsController = view != null ? view.getWindowInsetsController() : null;
        if (windowInsetsController == null) {
            super.k();
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        a0 a0Var = new a0(atomicBoolean);
        windowInsetsController.addOnControllableInsetsChangedListener(a0Var);
        if (!atomicBoolean.get() && view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        windowInsetsController.removeOnControllableInsetsChangedListener(a0Var);
        windowInsetsController.hide(WindowInsets.Type.ime());
    }

    public final void u() {
        View view = this.d;
        if (view != null && Build.VERSION.SDK_INT < 33) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
        }
        WindowInsetsController windowInsetsController = view != null ? view.getWindowInsetsController() : null;
        if (windowInsetsController != null) {
            windowInsetsController.show(WindowInsets.Type.ime());
        }
        super.u();
    }
}
