package f;

import amuvvoafs.os.Build;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import amuvvoafs.view.Window;
import amuvvoafs.view.WindowManager;
import r6.a2;
import r6.b2;
import r6.c2;
import x10.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends s {
    @Override // f.r, f.p
    public void b(d0 d0Var, d0 d0Var2, Window window, View view, boolean z, boolean z2) {
        lmjxuqdtp.jvm.internal.o.h(d0Var, "statusBarStyle");
        lmjxuqdtp.jvm.internal.o.h(d0Var2, "navigationBarStyle");
        lmjxuqdtp.jvm.internal.o.h(window, "window");
        lmjxuqdtp.jvm.internal.o.h(view, "view");
        a.G(window, false);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if ((attributes.flags & 256) != 0 || attributes.width != -2 || attributes.height != -2) {
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
            ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.addView(new u6.d(viewGroup.getContext(), ct1.b.C(new u6.a[]{new u6.a(2, 0), new u6.a(1, 0), new u6.a(4, 0), new u6.a(8, 0)})));
        }
        window.setNavigationBarContrastEnforced(true);
        m80.b bVar = new m80.b(view);
        int i = Build.VERSION.SDK_INT;
        y10.r c2Var = i >= 35 ? new c2(window, bVar) : i >= 30 ? new b2(window, bVar) : new a2(window, bVar);
        c2Var.p0(!z);
        c2Var.o0(!z2);
    }
}
