package r6;

import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import amuvvoafs.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x0 {
    public static final WindowInsets a = z1.b.f();
    public static boolean b = false;

    public static WindowInsets a(View view, WindowInsets windowInsets) {
        Object tag = view.getTag(2131428602);
        Object tag2 = view.getTag(2131428611);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = tag instanceof View.OnApplyWindowInsetsListener ? (View.OnApplyWindowInsetsListener) tag : tag2 instanceof View.OnApplyWindowInsetsListener ? (View.OnApplyWindowInsetsListener) tag2 : null;
        WindowInsets windowInsets2 = a;
        WindowInsets[] windowInsetsArr = {windowInsets2};
        view.setOnApplyWindowInsetsListener(new v0(windowInsetsArr, onApplyWindowInsetsListener));
        view.dispatchApplyWindowInsets(windowInsets);
        Object tag3 = view.getTag(2131428601);
        if (tag3 instanceof View.OnApplyWindowInsetsListener) {
            onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) tag3;
        }
        view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListener);
        WindowInsets windowInsets3 = windowInsetsArr[0];
        if (windowInsets3 != null && !windowInsets3.isConsumed() && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(viewGroup.getChildAt(i), windowInsetsArr[0]);
            }
        }
        WindowInsets windowInsets4 = windowInsetsArr[0];
        return windowInsets4 != null ? windowInsets4 : windowInsets2;
    }
}
