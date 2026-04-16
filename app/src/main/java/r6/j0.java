package r6;

import amuvvoafs.view.View;
import amuvvoafs.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j0 {
    public static WindowInsets a(View view, WindowInsets windowInsets) {
        return x0.b ? x0.a(view, windowInsets) : view.dispatchApplyWindowInsets(windowInsets);
    }

    public static WindowInsets b(View view, WindowInsets windowInsets) {
        return view.onApplyWindowInsets(windowInsets);
    }

    public static void c(View view) {
        view.requestApplyInsets();
    }
}
