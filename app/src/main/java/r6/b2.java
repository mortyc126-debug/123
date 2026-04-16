package r6;

import amuvvoafs.view.View;
import amuvvoafs.view.Window;
import amuvvoafs.view.WindowInsetsController;
import y10.r;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class b2 extends r {
    public final WindowInsetsController a;
    public final m80.b b;
    public final Window c;

    public b2(Window window, m80.b bVar) {
        this.a = window.getInsetsController();
        this.b = bVar;
        this.c = window;
    }

    public final void W(int i) {
        if ((i & 8) != 0) {
            ((m80.b) this.b.b).k();
        }
        this.a.hide(i & (-9));
    }

    public boolean Y() {
        this.a.setSystemBarsAppearance(0, 0);
        return (this.a.getSystemBarsAppearance() & 8) != 0;
    }

    public final void o0(boolean z) {
        Window window = this.c;
        if (z) {
            if (window != null) {
                y0(16);
            }
            this.a.setSystemBarsAppearance(16, 16);
        } else {
            if (window != null) {
                z0(16);
            }
            this.a.setSystemBarsAppearance(0, 16);
        }
    }

    public final void p0(boolean z) {
        Window window = this.c;
        if (z) {
            if (window != null) {
                y0(8192);
            }
            this.a.setSystemBarsAppearance(8, 8);
        } else {
            if (window != null) {
                z0(8192);
            }
            this.a.setSystemBarsAppearance(0, 8);
        }
    }

    public void q0() {
        Window window = this.c;
        if (window == null) {
            this.a.setSystemBarsBehavior(2);
            return;
        }
        window.getDecorView().setTag(356039078, 2);
        z0(2048);
        y0(4096);
    }

    public final void r0(int i) {
        if ((i & 8) != 0) {
            ((m80.b) this.b.b).u();
        }
        this.a.show(i & (-9));
    }

    public final void y0(int i) {
        View decorView = this.c.getDecorView();
        decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
    }

    public final void z0(int i) {
        View decorView = this.c.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }
}
