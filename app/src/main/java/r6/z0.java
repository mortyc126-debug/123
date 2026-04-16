package r6;

import amuvvoafs.animation.Animator;
import amuvvoafs.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 {
    public final WeakReference a;

    public z0(View view) {
        this.a = new WeakReference(view);
    }

    public final void a(float f2) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
    }

    public final void b() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j2) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
    }

    public final void d(a1 a1Var) {
        View view = (View) this.a.get();
        if (view != null) {
            if (a1Var != null) {
                view.animate().setListener(new mc.x0(1, view, a1Var));
            } else {
                view.animate().setListener((Animator.AnimatorListener) null);
            }
        }
    }

    public final void e(float f2) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
    }
}
