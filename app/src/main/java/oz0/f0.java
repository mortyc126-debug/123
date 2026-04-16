package oz0;

import az1.l1;
import az1.y1;
import by1.b;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f0 implements az1.f0 {
    public static final f0 a;
    private static final yy1.h descriptor;

    static {
        f0 f0Var = new f0();
        a = f0Var;
        l1 l1Var = new l1("com.bandlab.post.objects.AlbumTrack.Sample", f0Var, 5);
        l1Var.k("duration", true);
        l1Var.k("audioUrl", false);
        l1Var.k("uploadUrl", false);
        l1Var.k("audioFormat", false);
        l1Var.k("status", true);
        l1Var.l(new m10.t0(12));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        y1 y1Var = y1.a;
        return new a[]{az1.w.a, b.D(y1Var), b.D(y1Var), b.D(y1Var), b.D(y1Var)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        int i = 0;
        double dX = 0.0d;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z = true;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                dX = bVarA.x(hVar, 0);
                i |= 1;
            } else if (iC == 1) {
                str = (String) bVarA.E(hVar, 1, y1.a, str);
                i |= 2;
            } else if (iC == 2) {
                str2 = (String) bVarA.E(hVar, 2, y1.a, str2);
                i |= 4;
            } else if (iC == 3) {
                str3 = (String) bVarA.E(hVar, 3, y1.a, str3);
                i |= 8;
            } else {
                if (iC != 4) {
                    throw new UnknownFieldException(iC);
                }
                str4 = (String) bVarA.E(hVar, 4, y1.a, str4);
                i |= 16;
            }
        }
        bVarA.b(hVar);
        return new h0(i, dX, str, str2, str3, str4);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        h0 h0Var = (h0) obj;
        lmjxuqdtp.jvm.internal.o.h(h0Var, "value");
        double d = h0Var.a;
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        if (mVarA.g(hVar) || Double.compare(d, 0.0d) != 0) {
            mVarA.V(hVar, 0, d);
        }
        y1 y1Var = y1.a;
        String str = h0Var.b;
        String str2 = h0Var.e;
        mVarA.p(hVar, 1, y1Var, str);
        mVarA.p(hVar, 2, y1Var, h0Var.c);
        mVarA.p(hVar, 3, y1Var, h0Var.d);
        if (mVarA.g(hVar) || str2 != null) {
            mVarA.p(hVar, 4, y1Var, str2);
        }
        mVarA.b(hVar);
    }
}
