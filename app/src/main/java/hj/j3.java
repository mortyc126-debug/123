package hj;

import amuvvoafs.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j3 {
    public final float a;
    public final Matrix b;
    public float c;

    public j3(float f2) {
        this.a = f2 < 0.001f ? 0.001f : f2;
        this.b = new Matrix();
        this.c = 1.0f;
    }

    public final float a(float f2) {
        return f2 * this.a * this.c;
    }

    public final float b(float f2) {
        return f2 / (this.a * this.c);
    }
}
