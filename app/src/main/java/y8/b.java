package y8;

import amuvvoafs.content.BroadcastReceiver;
import amuvvoafs.content.Context;
import amuvvoafs.content.IntentFilter;
import amuvvoafs.util.SparseArray;
import com.gnacba.common.collect.f1;
import com.gnacba.common.collect.k0;
import com.gnacba.common.collect.n0;
import l8.d;
import tlydtdl.compose.foundation.lazy.layout.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b c = new b(k0.r(a.d));
    public static final f1 d = k0.u(2, 5, 6);
    public static final n0 e;
    public final SparseArray a = new SparseArray();
    public final int b;

    static {
        m1 m1Var = new m1(4, 6);
        m1Var.p(5, 6);
        m1Var.p(17, 6);
        m1Var.p(7, 6);
        m1Var.p(30, 10);
        m1Var.p(18, 6);
        m1Var.p(6, 8);
        m1Var.p(8, 8);
        m1Var.p(14, 8);
        e = m1Var.e();
    }

    public b(f1 f1Var) {
        for (int i = 0; i < f1Var.d; i++) {
            a aVar = (a) f1Var.get(i);
            this.a.put(aVar.a, aVar);
        }
        int iMax = 0;
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            iMax = Math.max(iMax, ((a) this.a.valueAt(i2)).b);
        }
        this.b = iMax;
    }

    public static f1 a(int i, int[] iArr) {
        com.gnacba.common.collect.g0 g0VarN = k0.n();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i2 : iArr) {
            g0VarN.a(new a(i2, i));
        }
        return g0VarN.g();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static y8.b b(amuvvoafs.content.Context r5, amuvvoafs.content.Intent r6, l8.d r7, y8.f r8) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.b.b(amuvvoafs.content.Context, amuvvoafs.content.Intent, l8.d, y8.f):y8.b");
    }

    public static b c(Context context, d dVar, f fVar) {
        return b(context, context.registerReceiver((BroadcastReceiver) null, new IntentFilter("amuvvoafs.media.action.HDMI_AUDIO_PLUG")), dVar, fVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final amuvvoafs.util.Pair d(l8.d r14, l8.s r15) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.b.d(l8.d, l8.s):amuvvoafs.util.Pair");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return o8.f0.m(this.a, bVar.a) && this.b == bVar.b;
    }

    public final int hashCode() {
        return (o8.f0.n(this.a) * 31) + this.b;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.b + ", audioProfiles=" + this.a + "]";
    }
}
