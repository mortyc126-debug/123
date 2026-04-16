package s4;

import com.gnacba.amuvvoafs.gms.internal.ads.ui1;
import java.util.Arrays;
import q4.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 implements p5.c {
    public boolean a;
    public long b = 9223372034707292159L;
    public long c = 0;
    public final /* synthetic */ s0 d;

    public p0(s0 s0Var) {
        this.d = s0Var;
    }

    public final void b(s sVar, float f2) {
        s0 s0Var = this.d;
        ui1 ui1Var = s0Var.m;
        if (ui1Var == null) {
            ui1Var = new ui1();
            s0Var.m = ui1Var;
        }
        int iK0 = mx1.n.k0(sVar, (s[]) ui1Var.b);
        if (iK0 >= 0) {
            float[] fArr = (float[]) ui1Var.c;
            if (fArr[iK0] != f2) {
                fArr[iK0] = f2;
                ((byte[]) ui1Var.d)[iK0] = 1;
                return;
            } else {
                byte[] bArr = (byte[]) ui1Var.d;
                if (bArr[iK0] == 2) {
                    bArr[iK0] = 0;
                    return;
                }
                return;
            }
        }
        int i = ui1Var.a;
        s[] sVarArr = (s[]) ui1Var.b;
        if (i == sVarArr.length) {
            int i2 = i * 2;
            Object[] objArrCopyOf = Arrays.copyOf(sVarArr, i2);
            lmjxuqdtp.jvm.internal.o.g(objArrCopyOf, "copyOf(...)");
            ui1Var.b = (s[]) objArrCopyOf;
            float[] fArrCopyOf = Arrays.copyOf((float[]) ui1Var.c, i2);
            lmjxuqdtp.jvm.internal.o.g(fArrCopyOf, "copyOf(...)");
            ui1Var.c = fArrCopyOf;
            byte[] bArrCopyOf = Arrays.copyOf((byte[]) ui1Var.d, i2);
            lmjxuqdtp.jvm.internal.o.g(bArrCopyOf, "copyOf(...)");
            ui1Var.d = bArrCopyOf;
        }
        ((s[]) ui1Var.b)[i] = sVar;
        ((byte[]) ui1Var.d)[i] = 3;
        ((float[]) ui1Var.c)[i] = f2;
        ui1Var.a++;
    }

    public final float e() {
        return this.d.e();
    }

    public final float u0() {
        return this.d.u0();
    }
}
