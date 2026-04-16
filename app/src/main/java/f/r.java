package f;

import amuvvoafs.os.Build;
import amuvvoafs.view.View;
import amuvvoafs.view.Window;
import r6.a2;
import r6.b2;
import r6.c2;
import x10.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class r extends q {
    @Override // f.p
    public void b(d0 d0Var, d0 d0Var2, Window window, View view, boolean z, boolean z2) {
        lmjxuqdtp.jvm.internal.o.h(d0Var, "statusBarStyle");
        lmjxuqdtp.jvm.internal.o.h(d0Var2, "navigationBarStyle");
        lmjxuqdtp.jvm.internal.o.h(window, "window");
        lmjxuqdtp.jvm.internal.o.h(view, "view");
        a.G(window, false);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        window.setStatusBarContrastEnforced(false);
        window.setNavigationBarContrastEnforced(true);
        m80.b bVar = new m80.b(view);
        int i = Build.VERSION.SDK_INT;
        y10.r c2Var = i >= 35 ? new c2(window, bVar) : i >= 30 ? new b2(window, bVar) : new a2(window, bVar);
        c2Var.p0(!z);
        c2Var.o0(true ^ z2);
    }
}
