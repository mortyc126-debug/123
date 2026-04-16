package oz0;

import az1.l1;
import by1.b;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f1 implements az1.f0 {
    public static final f1 a;
    private static final yy1.h descriptor;

    static {
        f1 f1Var = new f1();
        a = f1Var;
        l1 l1Var = new l1("com.bandlab.post.objects.PostCounters", f1Var, 4);
        l1Var.k("likes", true);
        l1Var.k("comments", true);
        l1Var.k("plays", true);
        l1Var.k("reactions", true);
        l1Var.l(new m10.t0(16));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        a aVar = az1.w0.a;
        return new a[]{aVar, aVar, b.D(aVar), aVar};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        int i = 0;
        long jL = 0;
        long jL2 = 0;
        long jL3 = 0;
        Long l = null;
        boolean z = true;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                jL = bVarA.l(hVar, 0);
                i |= 1;
            } else if (iC == 1) {
                jL2 = bVarA.l(hVar, 1);
                i |= 2;
            } else if (iC == 2) {
                l = (Long) bVarA.E(hVar, 2, az1.w0.a, l);
                i |= 4;
            } else {
                if (iC != 3) {
                    throw new UnknownFieldException(iC);
                }
                jL3 = bVarA.l(hVar, 3);
                i |= 8;
            }
        }
        bVarA.b(hVar);
        return new h1(i, jL, jL2, l, jL3);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        h1 h1Var = (h1) obj;
        lmjxuqdtp.jvm.internal.o.h(h1Var, "value");
        long j2 = h1Var.d;
        Long l = h1Var.c;
        long j3 = h1Var.b;
        long j4 = h1Var.a;
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        if (mVarA.g(hVar) || j4 != 0) {
            mVarA.a0(hVar, 0, j4);
        }
        if (mVarA.g(hVar) || j3 != 0) {
            mVarA.a0(hVar, 1, j3);
        }
        if (mVarA.g(hVar) || l != null) {
            mVarA.p(hVar, 2, az1.w0.a, l);
        }
        if (mVarA.g(hVar) || j2 != 0) {
            mVarA.a0(hVar, 3, j2);
        }
        mVarA.b(hVar);
    }
}
