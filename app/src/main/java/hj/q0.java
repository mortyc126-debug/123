package hj;

import amuvvoafs.graphics.Canvas;
import amuvvoafs.graphics.Paint;
import amuvvoafs.graphics.Path;
import amuvvoafs.graphics.PointF;
import com.bandlab.arrangement.view.ArrangementView;
import com.bandlab.audiocore.generated.Transport;
import eh0.b;
import ny1.r2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 {
    public final float a;
    public final j3 b;
    public float c;
    public final float d;
    public final dr0.j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrangementView f206f;
    public final ArrangementView g;
    public u30.h h;
    public final Path i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f207j;
    public final Paint k;
    public final Paint l;
    public o0 m;
    public boolean n;
    public p0 o;
    public u30.a p;
    public final float q;
    public PointF r;

    public q0(float f2, j3 j3Var, float f3, float f4, dr0.j jVar, ArrangementView arrangementView, ArrangementView arrangementView2) {
        this.a = f2;
        this.b = j3Var;
        this.c = f3;
        this.d = f4;
        this.e = jVar;
        this.f206f = arrangementView;
        this.g = arrangementView2;
        float f5 = arrangementView.getResources().getDisplayMetrics().density * 6.0f;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(f5, 0.0f);
        path.lineTo(0.0f, f5);
        path.close();
        this.i = path;
        Paint paint = new Paint();
        paint.setColor(-1996541184);
        this.f207j = paint;
        Paint paint2 = new Paint();
        paint2.setColor(1157575424);
        this.k = paint2;
        Paint paint3 = new Paint();
        paint3.setColor(-52480);
        paint3.setAntiAlias(true);
        this.l = paint3;
        this.m = o0.a;
        this.q = arrangementView.getResources().getDisplayMetrics().density * 10.0f;
    }

    public final boolean a(float f2, float f3, p0 p0Var) {
        u30.h hVar = this.h;
        if (hVar == null || !c(f2, f3, hVar)) {
            return false;
        }
        float fAbs = Math.abs(f2 - p0Var.a());
        float f4 = this.q;
        return fAbs < f4 && Math.abs(f3 - p0Var.c()) < f4;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0211  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(amuvvoafs.view.MotionEvent r18) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 594
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: hj.q0.b(amuvvoafs.view.MotionEvent):boolean");
    }

    public final boolean c(float f2, float f3, u30.h hVar) {
        float f4 = this.c;
        float f5 = hVar.a;
        j3 j3Var = this.b;
        float fA = j3Var.a(f5) + f4;
        float fA2 = j3Var.a(hVar.b) + this.c;
        if (Float.compare(f2, fA) >= 0 && Float.compare(f2, fA2) <= 0) {
            float f7 = 0;
            if (Float.compare(f3, this.d) <= 0 && Float.compare(f3, f7) >= 0) {
                return true;
            }
        }
        return false;
    }

    public final void d(Canvas canvas) {
        u30.h hVar = this.h;
        if (hVar == null) {
            return;
        }
        boolean z = hVar.c;
        if (hVar.d) {
            Paint paint = z ? this.f207j : this.k;
            float f2 = this.c;
            float f3 = hVar.a;
            j3 j3Var = this.b;
            float fA = j3Var.a(f3) + f2;
            float fA2 = j3Var.a(hVar.b) + this.c;
            canvas.drawRect(fA, 0.0f, fA2, this.d, paint);
            if (z) {
                Path path = this.i;
                Paint paint2 = this.l;
                int iSave = canvas.save();
                try {
                    canvas.translate(fA, 0.0f);
                    canvas.drawPath(path, paint2);
                    canvas.drawLine(0.0f, 0.0f, 0.0f, this.d, paint2);
                    canvas.scale(-1.0f, 1.0f, (fA2 - fA) / 2.0f, this.d / 2.0f);
                    canvas.drawPath(path, paint2);
                    canvas.drawLine(0.0f, 0.0f, 0.0f, this.d, paint2);
                } finally {
                    canvas.restoreToCount(iSave);
                }
            }
        }
    }

    public final void e(float f2, boolean z, boolean z2) {
        float fB = this.b.b(f2 - this.c);
        if (z) {
            u30.a aVar = this.p;
            if (aVar != null) {
                u30.e eVar = (u30.e) aVar;
                if (eVar.d.a()) {
                    v80.h hVar = eVar.e;
                    b bVar = eVar.b;
                    double d = bVar.a * ((double) (fB / bVar.b));
                    if (hVar.g() && !hg1.u.a(d, ((z11.e) ((r2) hVar.c).getValue()).a)) {
                        new ak.s1(d, 6).invoke((Transport) hVar.b);
                        hVar.h();
                    }
                    if (z2) {
                        qi.y.k(eVar.a, "cycle_bounds_changed", eVar.c(), (qi.h) null, 12);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        u30.a aVar2 = this.p;
        if (aVar2 != null) {
            u30.e eVar2 = (u30.e) aVar2;
            if (eVar2.d.a()) {
                v80.h hVar2 = eVar2.e;
                b bVar2 = eVar2.b;
                double d3 = bVar2.a * ((double) (fB / bVar2.b));
                if (hVar2.g() && !hg1.u.a(d3, ((z11.e) ((r2) hVar2.c).getValue()).b)) {
                    new ak.s1(d3, 5).invoke((Transport) hVar2.b);
                    hVar2.h();
                }
                if (z2) {
                    qi.y.k(eVar2.a, "cycle_bounds_changed", eVar2.c(), (qi.h) null, 12);
                }
            }
        }
    }

    public final boolean f() {
        if (!this.n) {
            return false;
        }
        this.n = false;
        this.m = o0.c;
        u30.a aVar = this.p;
        if (aVar == null) {
            return true;
        }
        u30.e eVar = (u30.e) aVar;
        if (!eVar.d.a()) {
            return true;
        }
        v80.h hVar = eVar.e;
        new z71.m0(12).invoke((Transport) hVar.b);
        hVar.h();
        return true;
    }
}
