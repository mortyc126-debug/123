package q5;

import p5.j;
import q1.t;
import q1.y0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final float[] a = {8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f};
    public static volatile y0 b = new y0(0);
    public static final Object[] c;

    static {
        Object[] objArr = new Object[0];
        c = objArr;
        synchronized (objArr) {
            b.f((int) 115.0f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.8f, 21.8f, 25.2f, 30.0f, 100.0f}));
            b.f((int) 130.0f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{10.4f, 13.0f, 15.6f, 18.8f, 21.6f, 23.6f, 26.4f, 30.0f, 100.0f}));
            b.f((int) 150.0f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{12.0f, 15.0f, 18.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, 100.0f}));
            b.f((int) 180.0f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{14.4f, 18.0f, 21.6f, 24.4f, 27.6f, 30.8f, 32.8f, 34.8f, 100.0f}));
            b.f((int) 200.0f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{16.0f, 20.0f, 24.0f, 26.0f, 30.0f, 34.0f, 36.0f, 38.0f, 100.0f}));
        }
        if ((b.e(0) / 100.0f) - 0.01f > 1.03f) {
            return;
        }
        j.b("You should only apply non-linear scaling to font scales > 1");
    }

    public static a a(float f2) {
        float fE;
        a cVar;
        float[] fArr = a;
        if (f2 < 1.03f) {
            return null;
        }
        int i = (int) (f2 * 100.0f);
        a aVar = (a) b.d(i);
        if (aVar != null) {
            return aVar;
        }
        y0 y0Var = b;
        if (y0Var.a) {
            t.a(y0Var);
        }
        int iA = r1.a.a(y0Var.d, i, y0Var.b);
        if (iA >= 0) {
            return (a) b.h(iA);
        }
        int i2 = -(iA + 1);
        int i3 = i2 - 1;
        if (i2 >= b.g()) {
            c cVar2 = new c(new float[]{1.0f}, new float[]{f2});
            b(f2, cVar2);
            return cVar2;
        }
        if (i3 < 0) {
            cVar = new c(fArr, fArr);
            fE = 1.0f;
        } else {
            fE = b.e(i3) / 100.0f;
            cVar = (a) b.h(i3);
        }
        float fJ = d.j(0.0f, 1.0f, fE, b.e(i2) / 100.0f, f2);
        a aVar2 = (a) b.h(i2);
        float[] fArr2 = new float[9];
        for (int i4 = 0; i4 < 9; i4++) {
            float f3 = fArr[i4];
            fArr2[i4] = d.p(cVar.b(f3), aVar2.b(f3), fJ);
        }
        c cVar3 = new c(fArr, fArr2);
        b(f2, cVar3);
        return cVar3;
    }

    public static void b(float f2, c cVar) {
        synchronized (c) {
            y0 y0VarC = b.c();
            y0VarC.f((int) (f2 * 100.0f), cVar);
            b = y0VarC;
        }
    }
}
