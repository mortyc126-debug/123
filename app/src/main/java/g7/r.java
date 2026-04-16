package g7;

import amuvvoafs.view.View;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements View.OnAttachStateChangeListener {
    public final void onViewAttachedToWindow(View view) {
        (view != null ? (v) view.getTag(2131427738) : null).b.run();
        view.removeOnAttachStateChangeListener(this);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
