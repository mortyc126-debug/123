package hj;

import a2.c1;
import a2.p3;
import amuvvoafs.graphics.Canvas;
import amuvvoafs.graphics.Matrix;
import amuvvoafs.graphics.Paint;
import amuvvoafs.graphics.Path;
import amuvvoafs.graphics.Rect;
import amuvvoafs.graphics.RectF;
import es1.c;
import fz0.o;
import ij.i;
import ij.q;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.NoWhenBranchMatchedException;
import qx1.d;
import vt1.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {
    public final j3 a;
    public d3 b;
    public float c;
    public String d;
    public final o e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g0 f203f;
    public final AtomicReference g;
    public final my1.a h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p3 f204j;

    public m0(j3 j3Var, d3 d3Var, float f2, String str, ky1.a0 a0Var, o oVar, g0 g0Var, ij.j jVar, boolean z) {
        lmjxuqdtp.jvm.internal.o.h(j3Var, "zoomConverter");
        lmjxuqdtp.jvm.internal.o.h(d3Var, "verticalPosition");
        lmjxuqdtp.jvm.internal.o.h(str, "trackId");
        lmjxuqdtp.jvm.internal.o.h(a0Var, "scope");
        this.a = j3Var;
        this.b = d3Var;
        this.c = f2;
        this.d = str;
        this.e = oVar;
        this.f203f = g0Var;
        this.g = new AtomicReference(new i(q.a, new ij.m(), new ij.n(null, null, null, null, null, 511), new b(g0Var)));
        my1.a aVarM = c.m(a0Var, (qx1.i) null, IntCompanionObject.MAX_VALUE, new c1(this, (d) null), 13);
        this.h = aVarM;
        aVarM.h(new k0(jVar.b, false));
        this.i = true;
        e(z);
        this.f204j = new p3(20, this);
    }

    public static final List a(m0 m0Var, ij.o oVar) {
        return ct1.b.C(new Float[]{Float.valueOf(oVar.b() * m0Var.a.a * 1.0f), Float.valueOf(m0Var.b(oVar.c()))});
    }

    public final float b(double d) {
        float fL = com.facebook.appevents.l.L(this.b);
        g0 g0Var = this.f203f;
        float f2 = 2;
        return (g0Var.c.getStrokeWidth() / f2) + ((fL - ((g0Var.c.getStrokeWidth() / f2) * f2)) * ((float) (((double) 1) - d))) + this.b.a;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void c(Canvas canvas, RectF rectF) throws NoWhenBranchMatchedException {
        g0 g0Var = this.f203f;
        Paint paint = g0Var.g;
        lmjxuqdtp.jvm.internal.o.h(rectF, "viewPort");
        i iVar = (i) this.g.get();
        ij.s sVar = iVar.a;
        if (!(sVar instanceof ij.p)) {
            if (sVar instanceof ij.r) {
                float fB = b(((ij.r) sVar).a);
                canvas.drawLine(this.c, fB, rectF.right, fB, paint);
                return;
            } else {
                if (!sVar.equals(q.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                return;
            }
        }
        ij.n nVar = iVar.c;
        if (nVar.a.length == 0) {
            return;
        }
        float[] fArr = nVar.f222f;
        float[] fArr2 = nVar.g;
        float[] fArr3 = nVar.h;
        canvas.translate(this.c, 0.0f);
        float[] fArr4 = nVar.b;
        j3 j3Var = this.a;
        Matrix matrix = j3Var.b;
        Matrix matrix2 = j3Var.b;
        matrix.mapPoints(fArr2, fArr4);
        matrix2.mapPoints(fArr, nVar.a);
        matrix2.mapPoints(fArr3, nVar.c);
        fArr2[1] = fArr[1];
        fArr2[fArr2.length - 2] = rectF.right - this.c;
        int length = fArr2.length - 1;
        if (fArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        fArr2[length] = fArr[fArr.length - 1];
        canvas.drawLines(fArr2, paint);
        if (this.i) {
            canvas.drawPoints(fArr, g0Var.c);
            canvas.drawPoints(fArr, g0Var.e);
            canvas.drawPoints(fArr3, g0Var.f194f);
        } else {
            canvas.drawPoints(fArr, g0Var.d);
        }
        canvas.translate(-this.c, 0.0f);
    }

    public final void d(Canvas canvas, RectF rectF) {
        lmjxuqdtp.jvm.internal.o.h(rectF, "viewPort");
        i iVar = (i) this.g.get();
        if (iVar.a instanceof ij.p) {
            ij.n nVar = iVar.c;
            float[] fArr = nVar.d;
            String str = nVar.e;
            if (fArr.length == 0 || str == null) {
                return;
            }
            b bVar = iVar.d;
            float[] fArr2 = nVar.i;
            this.a.b.mapPoints(fArr2, fArr);
            float f2 = fArr2[0];
            float f3 = fArr2[1];
            canvas.translate(this.c, 0.0f);
            float f4 = rectF.top;
            float f5 = rectF.bottom;
            g0 g0Var = this.f203f;
            canvas.drawLine(f2, f4, f2, f5, g0Var.a);
            RectF rectF2 = (RectF) bVar.d;
            Path path = (Path) bVar.e;
            float fCenterX = f2 - rectF2.centerX();
            float fHeight = ((f3 - ((RectF) bVar.d).height()) - g0Var.c.getStrokeWidth()) - g0Var.m;
            float f7 = rectF.top;
            if (fHeight < f7) {
                fHeight = f7;
            }
            ((Path) bVar.c).offset(fCenterX, fHeight, path);
            canvas.drawPath(path, g0Var.i);
            canvas.drawText(str, fCenterX + g0Var.k, (fHeight + ((Rect) bVar.f).height()) - g0Var.f195j, g0Var.h);
            canvas.translate(-this.c, 0.0f);
        }
    }

    public final void e(boolean z) {
        int i;
        if (z == this.i) {
            return;
        }
        this.i = z;
        g0 g0Var = this.f203f;
        Paint paint = g0Var.g;
        if (z) {
            g0Var.getClass();
            i = 255;
        } else {
            g0Var.getClass();
            i = 51;
        }
        paint.setAlpha(i);
    }
}
