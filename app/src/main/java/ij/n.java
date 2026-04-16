package ij;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public final float[] a;
    public final float[] b;
    public final float[] c;
    public final float[] d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f222f;
    public final float[] g;
    public final float[] h;
    public final float[] i;

    public n(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, String str, int i) {
        fArr = (i & 1) != 0 ? new float[0] : fArr;
        fArr2 = (i & 2) != 0 ? new float[0] : fArr2;
        fArr3 = (i & 4) != 0 ? new float[0] : fArr3;
        fArr4 = (i & 8) != 0 ? new float[0] : fArr4;
        str = (i & 16) != 0 ? null : str;
        float[] fArr5 = new float[fArr.length];
        float[] fArr6 = new float[fArr2.length];
        float[] fArr7 = new float[fArr3.length];
        float[] fArr8 = new float[fArr4.length];
        this.a = fArr;
        this.b = fArr2;
        this.c = fArr3;
        this.d = fArr4;
        this.e = str;
        this.f222f = fArr5;
        this.g = fArr6;
        this.h = fArr7;
        this.i = fArr8;
    }
}
