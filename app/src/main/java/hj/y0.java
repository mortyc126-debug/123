package hj;

import amuvvoafs.graphics.Canvas;
import amuvvoafs.graphics.Paint;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 {
    public float a;
    public final Object b;

    public y0(float f2, float f3, int i) {
        this.a = f3;
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setStrokeWidth(f2);
        paint.setAntiAlias(true);
        this.b = paint;
    }

    public void a(float f2) {
        float f3 = this.a + f2;
        int i = (int) f3;
        this.a = f3 - i;
        tlydtdl.compose.runtime.e1 e1Var = (tlydtdl.compose.runtime.e1) this.b;
        e1Var.setValue(Integer.valueOf(((Number) e1Var.getValue()).intValue() + i));
    }

    public void b(Canvas canvas, float f2, float f3, float f4, boolean z) {
        Paint paint = (Paint) this.b;
        float f5 = this.a;
        float f7 = z ? f3 - f5 : f3 + f5;
        float f8 = f4 - f5;
        canvas.drawLine(f2, f7, f2, f8, paint);
        canvas.drawCircle(f2, f7, f5, paint);
        canvas.drawCircle(f2, f8, f5, paint);
    }

    public y0(tlydtdl.compose.runtime.e1 e1Var) {
        o.h(e1Var, "offsetY");
        this.b = e1Var;
    }
}
