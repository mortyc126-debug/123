package r6;

import amuvvoafs.view.View;
import amuvvoafs.view.WindowInsetsAnimation;
import i6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends h1 {
    public final WindowInsetsAnimation e;

    public g1(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.e = windowInsetsAnimation;
    }

    public static c f(WindowInsetsAnimation.Bounds bounds) {
        return c.d(bounds.getUpperBound());
    }

    public static c g(WindowInsetsAnimation.Bounds bounds) {
        return c.d(bounds.getLowerBound());
    }

    public static void h(View view, tlydtdl.datastore.preferences.protobuf.k kVar) {
        view.setWindowInsetsAnimationCallback(kVar != null ? new f1(kVar) : null);
    }

    @Override // r6.h1
    public final float a() {
        return this.e.getAlpha();
    }

    @Override // r6.h1
    public final long b() {
        return this.e.getDurationMillis();
    }

    @Override // r6.h1
    public final float c() {
        return this.e.getInterpolatedFraction();
    }

    @Override // r6.h1
    public final int d() {
        return this.e.getTypeMask();
    }

    @Override // r6.h1
    public final void e(float f2) {
        this.e.setFraction(f2);
    }
}
