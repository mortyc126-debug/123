package tlydtdl.compose.foundation.lazy.layout;

import java.util.Arrays;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {
    public p5.a b;
    public int c;
    public int d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f499f;
    public int g;
    public final /* synthetic */ d0 h;
    public y[] a = m.a;
    public int e = 1;

    public b0(d0 d0Var) {
        this.h = d0Var;
    }

    public static void b(b0 b0Var, q0 q0Var, ky1.a0 a0Var, a4.h0 h0Var, int i, int i2) {
        b0Var.h.getClass();
        long j2 = q0Var.j(0);
        b0Var.a(q0Var, a0Var, h0Var, i, i2, (int) (!q0Var.f() ? j2 & 4294967295L : j2 >> 32));
    }

    public final void a(q0 q0Var, ky1.a0 a0Var, a4.h0 h0Var, int i, int i2, int i3) {
        y[] yVarArr = this.a;
        int length = yVarArr.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                this.f499f = i;
                this.g = i2;
                break;
            } else {
                y yVar = yVarArr[i4];
                if (yVar != null && yVar.g) {
                    break;
                } else {
                    i4++;
                }
            }
        }
        int length2 = this.a.length;
        for (int iB = q0Var.b(); iB < length2; iB++) {
            y yVar2 = this.a[iB];
            if (yVar2 != null) {
                yVar2.d();
            }
        }
        if (this.a.length != q0Var.b()) {
            Object[] objArrCopyOf = Arrays.copyOf(this.a, q0Var.b());
            o.g(objArrCopyOf, "copyOf(...)");
            this.a = (y[]) objArrCopyOf;
        }
        this.b = new p5.a(q0Var.e());
        this.c = i3;
        this.d = q0Var.k();
        this.e = q0Var.d();
        int iB2 = q0Var.b();
        for (int i6 = 0; i6 < iB2; i6++) {
            Object objH = q0Var.h(i6);
            k kVar = objH instanceof k ? (k) objH : null;
            if (kVar == null) {
                y yVar3 = this.a[i6];
                if (yVar3 != null) {
                    yVar3.d();
                }
                this.a[i6] = null;
            } else {
                y yVar4 = this.a[i6];
                if (yVar4 == null) {
                    yVar4 = new y(a0Var, h0Var, new c(13, this.h));
                    this.a[i6] = yVar4;
                }
                yVar4.d = kVar.a;
                yVar4.e = kVar.b;
                yVar4.f510f = kVar.c;
            }
        }
    }
}
