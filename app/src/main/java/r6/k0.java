package r6;

import amuvvoafs.os.Build;
import amuvvoafs.view.View;
import amuvvoafs.view.WindowInsets;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements View.OnApplyWindowInsetsListener {
    public z1 a = null;
    public final /* synthetic */ View b;
    public final /* synthetic */ u c;

    public k0(View view, u uVar) {
        this.b = view;
        this.c = uVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        z1 z1VarG = z1.g(view, windowInsets);
        int i = Build.VERSION.SDK_INT;
        u uVar = this.c;
        if (i < 30) {
            l0.a(windowInsets, this.b);
            if (z1VarG.equals(this.a)) {
                return uVar.o(z1VarG, view).f();
            }
        }
        this.a = z1VarG;
        z1 z1VarO = uVar.o(z1VarG, view);
        if (i >= 30) {
            return z1VarO.f();
        }
        WeakHashMap weakHashMap = u0.a;
        j0.c(view);
        return z1VarO.f();
    }
}
