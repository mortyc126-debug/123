package r6;

import amuvvoafs.view.View;
import amuvvoafs.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m0 {
    public static z1 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        z1 z1VarG = z1.g(null, rootWindowInsets);
        w1 w1Var = z1VarG.a;
        w1Var.t(z1VarG);
        w1Var.d(view.getRootView());
        return z1VarG;
    }

    public static void b(View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }
}
