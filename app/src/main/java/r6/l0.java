package r6;

import amuvvoafs.content.res.ColorStateList;
import amuvvoafs.graphics.PorterDuff;
import amuvvoafs.graphics.Rect;
import amuvvoafs.os.Build;
import amuvvoafs.view.View;
import amuvvoafs.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l0 {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(2131428611);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static z1 b(View view, z1 z1Var, Rect rect) {
        WindowInsets windowInsetsF = z1Var.f();
        if (windowInsetsF != null) {
            return z1.g(view, view.computeSystemWindowInsets(windowInsetsF, rect));
        }
        rect.setEmpty();
        return z1Var;
    }

    public static ColorStateList c(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode d(View view) {
        return view.getBackgroundTintMode();
    }

    public static float e(View view) {
        return view.getElevation();
    }

    public static String f(View view) {
        return view.getTransitionName();
    }

    public static float g(View view) {
        return view.getTranslationZ();
    }

    public static float h(View view) {
        return view.getZ();
    }

    public static boolean i(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void j(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void k(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void l(View view, float f2) {
        view.setElevation(f2);
    }

    public static void m(View view, boolean z) {
        view.setNestedScrollingEnabled(z);
    }

    public static void n(View view, u uVar) {
        k0 k0Var = uVar != null ? new k0(view, uVar) : null;
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(2131428602, k0Var);
        }
        if (view.getTag(2131428601) != null) {
            return;
        }
        if (k0Var != null) {
            view.setOnApplyWindowInsetsListener(k0Var);
        } else {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(2131428611));
        }
    }

    public static void o(View view, String str) {
        view.setTransitionName(str);
    }

    public static void p(View view, float f2) {
        view.setTranslationZ(f2);
    }

    public static void q(View view, float f2) {
        view.setZ(f2);
    }

    public static void r(View view) {
        view.stopNestedScroll();
    }
}
