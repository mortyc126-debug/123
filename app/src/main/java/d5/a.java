package d5;

import a4.w0;
import a4.z0;
import amuvvoafs.graphics.Canvas;
import amuvvoafs.graphics.RectF;
import amuvvoafs.os.Build;
import amuvvoafs.text.TextUtils;
import com.gnacba.firebase.messaging.j;
import e5.h;
import e5.m;
import e5.n;
import uc0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final l5.c a;
    public final int b;
    public final long c;
    public final n d;
    public final CharSequence e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f67f;

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(l5.c r22, int r23, int r24, long r25) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 1002
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.a.<init>(l5.c, int, int, long):void");
    }

    public final n a(int i, int i2, TextUtils.TruncateAt truncateAt, int i3, int i4, int i6, int i7, int i8, CharSequence charSequence) {
        z zVar;
        float fD = d();
        l5.c cVar = this.a;
        l5.d dVar = cVar.g;
        int i9 = cVar.l;
        h hVar = cVar.i;
        q0 q0Var = cVar.b;
        l5.a aVar = l5.b.a;
        b0 b0Var = q0Var.c;
        return new n(charSequence, fD, dVar, i, truncateAt, i9, (b0Var == null || (zVar = b0Var.b) == null) ? false : zVar.a, i3, i6, i7, i8, i4, i2, hVar);
    }

    public final float b() {
        return this.d.a();
    }

    public final long c(z3.c cVar, int i, j jVar) {
        int[] iArrG;
        RectF rectFV = w0.v(cVar);
        int i2 = (!g0.a(i, 0) && g0.a(i, 1)) ? 1 : 0;
        cr0.h hVar = new cr0.h(8, jVar);
        int i3 = Build.VERSION.SDK_INT;
        n nVar = this.d;
        if (i3 >= 34) {
            nVar.getClass();
            iArrG = a4.d0.l(nVar, rectFV, i2, hVar);
        } else {
            iArrG = xn1.a.G(nVar, nVar.f, nVar.c(), rectFV, i2, hVar);
        }
        return iArrG == null ? p0.b : p.h(iArrG[0], iArrG[1]);
    }

    public final float d() {
        return p5.a.h(this.c);
    }

    public final void e(a4.w wVar) {
        Canvas canvasA = a4.d.a(wVar);
        n nVar = this.d;
        if (nVar.d) {
            canvasA.save();
            canvasA.clipRect(0.0f, 0.0f, d(), b());
        }
        int i = nVar.h;
        if (canvasA.getClipBounds(nVar.p)) {
            if (i != 0) {
                canvasA.translate(0.0f, i);
            }
            m mVar = e5.o.a;
            mVar.a = canvasA;
            nVar.f.draw(mVar);
            if (i != 0) {
                canvasA.translate(0.0f, (-1) * i);
            }
        }
        if (nVar.d) {
            canvasA.restore();
        }
    }

    public final void f(a4.w wVar, long j2, z0 z0Var, o5.l lVar, c4.e eVar) {
        l5.d dVar = this.a.g;
        int i = dVar.c;
        dVar.d(j2);
        dVar.f(z0Var);
        dVar.g(lVar);
        dVar.e(eVar);
        dVar.b(3);
        e(wVar);
        dVar.b(i);
    }

    public final void g(a4.w wVar, a4.u uVar, float f2, z0 z0Var, o5.l lVar, c4.e eVar) {
        l5.d dVar = this.a.g;
        int i = dVar.c;
        float fD = d();
        dVar.c(uVar, (((long) Float.floatToRawIntBits(b())) & 4294967295L) | (Float.floatToRawIntBits(fD) << 32), f2);
        dVar.f(z0Var);
        dVar.g(lVar);
        dVar.e(eVar);
        dVar.b(3);
        e(wVar);
        dVar.b(i);
    }
}
