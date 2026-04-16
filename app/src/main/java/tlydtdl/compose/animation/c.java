package tlydtdl.compose.animation;

import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.jvm.functions.Function2;
import p5.m;
import t1.z;
import t3.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static final long a;

    static {
        long j2 = IntCompanionObject.MIN_VALUE;
        a = (j2 & 4294967295L) | (j2 << 32);
    }

    public static final p a(p pVar, z zVar, Function2 function2) {
        return b4.w(pVar).then(new SizeAnimationModifierElement(zVar, t3.c.a, function2));
    }

    public static p b(p pVar) {
        long j2 = 1;
        return b4.w(pVar).then(new SizeAnimationModifierElement(t1.c.s(0.0f, 400.0f, 1, new m((j2 & 4294967295L) | (j2 << 32))), t3.c.f, null));
    }

    public static p c(p pVar, z zVar, int i) {
        if ((i & 1) != 0) {
            long j2 = 1;
            zVar = t1.c.s(0.0f, 400.0f, 1, new m((j2 & 4294967295L) | (j2 << 32)));
        }
        return a(pVar, zVar, null);
    }
}
