package oz0;

import az1.l1;
import az1.y1;
import by1.b;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x implements az1.f0 {
    public static final x a;
    private static final yy1.h descriptor;

    static {
        x xVar = new x();
        a = xVar;
        l1 l1Var = new l1("com.bandlab.post.objects.AlbumTrack", xVar, 8);
        l1Var.k("name", true);
        l1Var.k("genreId", true);
        l1Var.k("permissions", true);
        l1Var.k("picture", true);
        l1Var.k("mastering", true);
        l1Var.k("sample", true);
        l1Var.k("spatialSample", true);
        l1Var.k("revisionId", true);
        l1Var.l(new m10.t0(12));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        y1 y1Var = y1.a;
        a aVarD = b.D(y1Var);
        a aVarD2 = b.D(y1Var);
        a aVarD3 = b.D(c0.a);
        a aVarD4 = b.D(m10.h0.a);
        a aVarD5 = b.D(z.a);
        f0 f0Var = f0.a;
        return new a[]{aVarD, aVarD2, aVarD3, aVarD4, aVarD5, b.D(f0Var), b.D(f0Var), b.D(y1Var)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        int i = 0;
        String str = null;
        String str2 = null;
        e0 e0Var = null;
        m10.j0 j0Var = null;
        b0 b0Var = null;
        h0 h0Var = null;
        h0 h0Var2 = null;
        String str3 = null;
        boolean z = true;
        while (z) {
            int iC = bVarA.C(hVar);
            switch (iC) {
                case -1:
                    z = false;
                    break;
                case 0:
                    str = (String) bVarA.E(hVar, 0, y1.a, str);
                    i |= 1;
                    break;
                case 1:
                    str2 = (String) bVarA.E(hVar, 1, y1.a, str2);
                    i |= 2;
                    break;
                case 2:
                    e0Var = (e0) bVarA.E(hVar, 2, c0.a, e0Var);
                    i |= 4;
                    break;
                case 3:
                    j0Var = (m10.j0) bVarA.E(hVar, 3, m10.h0.a, j0Var);
                    i |= 8;
                    break;
                case 4:
                    b0Var = (b0) bVarA.E(hVar, 4, z.a, b0Var);
                    i |= 16;
                    break;
                case 5:
                    h0Var = (h0) bVarA.E(hVar, 5, f0.a, h0Var);
                    i |= 32;
                    break;
                case 6:
                    h0Var2 = (h0) bVarA.E(hVar, 6, f0.a, h0Var2);
                    i |= 64;
                    break;
                case 7:
                    str3 = (String) bVarA.E(hVar, 7, y1.a, str3);
                    i |= 128;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        bVarA.b(hVar);
        return new i0(i, str, str2, e0Var, j0Var, b0Var, h0Var, h0Var2, str3);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        i0 i0Var = (i0) obj;
        lmjxuqdtp.jvm.internal.o.h(i0Var, "value");
        String str = i0Var.h;
        h0 h0Var = i0Var.g;
        h0 h0Var2 = i0Var.f383f;
        b0 b0Var = i0Var.e;
        m10.j0 j0Var = i0Var.d;
        e0 e0Var = i0Var.c;
        String str2 = i0Var.b;
        String str3 = i0Var.a;
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        if (cVarA.g(hVar) || str3 != null) {
            cVarA.p(hVar, 0, y1.a, str3);
        }
        if (cVarA.g(hVar) || str2 != null) {
            cVarA.p(hVar, 1, y1.a, str2);
        }
        if (cVarA.g(hVar) || e0Var != null) {
            cVarA.p(hVar, 2, c0.a, e0Var);
        }
        if (cVarA.g(hVar) || j0Var != null) {
            cVarA.p(hVar, 3, m10.h0.a, j0Var);
        }
        if (cVarA.g(hVar) || b0Var != null) {
            cVarA.p(hVar, 4, z.a, b0Var);
        }
        if (cVarA.g(hVar) || h0Var2 != null) {
            cVarA.p(hVar, 5, f0.a, h0Var2);
        }
        if (cVarA.g(hVar) || h0Var != null) {
            cVarA.p(hVar, 6, f0.a, h0Var);
        }
        if (cVarA.g(hVar) || str != null) {
            cVarA.p(hVar, 7, y1.a, str);
        }
        cVarA.b(hVar);
    }
}
