package f;

import amuvvoafs.content.res.Resources;
import amuvvoafs.graphics.Color;
import amuvvoafs.os.Build;
import amuvvoafs.view.View;
import amuvvoafs.view.Window;
import lmjxuqdtp.jvm.functions.Function1;
import tlydtdl.activity.ComponentActivity;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public static final int a = Color.argb(230, 255, 255, 255);
    public static final int b = Color.argb(128, 27, 27, 27);
    public static p c;

    public static final void a(ComponentActivity componentActivity, d0 d0Var, d0 d0Var2) {
        lmjxuqdtp.jvm.internal.o.h(componentActivity, "<this>");
        lmjxuqdtp.jvm.internal.o.h(d0Var, "statusBarStyle");
        View decorView = componentActivity.getWindow().getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView, "getDecorView(...)");
        Function1 function1 = d0Var.c;
        Resources resources = decorView.getResources();
        lmjxuqdtp.jvm.internal.o.g(resources, "getResources(...)");
        boolean zBooleanValue = ((Boolean) function1.invoke(resources)).booleanValue();
        Function1 function12 = d0Var2.c;
        Resources resources2 = decorView.getResources();
        lmjxuqdtp.jvm.internal.o.g(resources2, "getResources(...)");
        boolean zBooleanValue2 = ((Boolean) function12.invoke(resources2)).booleanValue();
        p tVar = c;
        if (tVar == null) {
            int i = Build.VERSION.SDK_INT;
            tVar = i >= 35 ? new t() : i >= 30 ? new s() : i >= 29 ? new r() : i >= 28 ? new q() : new p();
            c = tVar;
        }
        p pVar = tVar;
        Window window = componentActivity.getWindow();
        lmjxuqdtp.jvm.internal.o.g(window, "getWindow(...)");
        pVar.b(d0Var, d0Var2, window, decorView, zBooleanValue, zBooleanValue2);
        Window window2 = componentActivity.getWindow();
        lmjxuqdtp.jvm.internal.o.g(window2, "getWindow(...)");
        pVar.a(window2);
    }

    public static void b(ComponentActivity componentActivity, d0 d0Var, int i) {
        if ((i & 1) != 0) {
            d0Var = new d0(0, 0, new dr0.i(14));
        }
        a(componentActivity, d0Var, new d0(a, b, new dr0.i(14)));
    }
}
