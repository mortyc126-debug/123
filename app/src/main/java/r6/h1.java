package r6;

import amuvvoafs.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h1 {
    public final int a;
    public float b;
    public final Interpolator c;
    public final long d;

    public h1(int i, Interpolator interpolator, long j2) {
        this.a = i;
        this.c = interpolator;
        this.d = j2;
    }

    public float a() {
        return 1.0f;
    }

    public long b() {
        return this.d;
    }

    public float c() {
        Interpolator interpolator = this.c;
        return interpolator != null ? interpolator.getInterpolation(this.b) : this.b;
    }

    public int d() {
        return this.a;
    }

    public void e(float f2) {
        this.b = f2;
    }
}
