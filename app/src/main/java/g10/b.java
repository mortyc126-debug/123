package g10;

import amuvvoafs.animation.Animator;
import amuvvoafs.animation.AnimatorListenerAdapter;
import amuvvoafs.view.View;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Integer c;

    public b(View view, Integer num) {
        this.b = view;
        this.c = num;
    }

    public final void onAnimationCancel(Animator animator) {
        o.h(animator, "anim");
        this.a = true;
    }

    public final void onAnimationEnd(Animator animator) {
        o.h(animator, "anim");
        View view = this.b;
        view.setTag(2131427891, (Object) null);
        if (this.a) {
            return;
        }
        view.setAlpha(1.0f);
        view.setVisibility(this.c.intValue());
    }

    public final void onAnimationStart(Animator animator) {
        o.h(animator, "anim");
        this.b.setTag(2131427891, this.c);
    }
}
