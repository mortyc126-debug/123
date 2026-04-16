package o80;

import c4.d;
import c4.h;
import d5.m0;
import d5.r;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import org.apache.commons.net.ftp.FTPReply;
import tlydtdl.compose.runtime.e1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ float a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ e1 d;

    public /* synthetic */ a(float f2, long j2, long j3, e1 e1Var) {
        this.a = f2;
        this.b = j2;
        this.c = j3;
        this.d = e1Var;
    }

    public final Object invoke(Object obj) {
        d dVar = (d) obj;
        o.h(dVar, "$this$drawBehind");
        m0 m0Var = (m0) this.d.getValue();
        if (m0Var != null) {
            r rVar = m0Var.b;
            int i = rVar.f75f - 1;
            if (i >= 0) {
                int i2 = 0;
                while (true) {
                    float fE = m0Var.e(i2);
                    float f2 = this.a;
                    float fW0 = fE - dVar.w0(f2);
                    float fW02 = dVar.w0(f2) + m0Var.f(i2);
                    float f3 = rVar.f(i2);
                    float fB = rVar.b(i2);
                    float f4 = fW02 - fW0;
                    float f5 = fB - f3;
                    d.s(dVar, this.b, (((long) Float.floatToRawIntBits(fW0)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L), (((long) Float.floatToRawIntBits(f5)) & 4294967295L) | (Float.floatToRawIntBits(f4) << 32), 0.0f, (h) null, FTPReply.SERVICE_NOT_READY);
                    d.s(dVar, this.c, (((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (Float.floatToRawIntBits(fW0) << 32), (((long) Float.floatToRawIntBits(f5)) & 4294967295L) | (Float.floatToRawIntBits(f4) << 32), 0.0f, (h) null, FTPReply.SERVICE_NOT_READY);
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return b0.a;
    }
}
