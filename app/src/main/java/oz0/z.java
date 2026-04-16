package oz0;

import az1.l1;
import az1.y1;
import by1.b;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z implements az1.f0 {
    public static final z a;
    private static final yy1.h descriptor;

    static {
        z zVar = new z();
        a = zVar;
        l1 l1Var = new l1("com.bandlab.post.objects.AlbumTrack.Mastering", zVar, 2);
        l1Var.k("presetId", false);
        l1Var.k("originalAudioUrl", false);
        l1Var.l(new m10.t0(12));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        y1 y1Var = y1.a;
        return new a[]{b.D(y1Var), b.D(y1Var)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        String str = null;
        boolean z = true;
        int i = 0;
        String str2 = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                str = (String) bVarA.E(hVar, 0, y1.a, str);
                i |= 1;
            } else {
                if (iC != 1) {
                    throw new UnknownFieldException(iC);
                }
                str2 = (String) bVarA.E(hVar, 1, y1.a, str2);
                i |= 2;
            }
        }
        bVarA.b(hVar);
        return new b0(i, str, str2);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        b0 b0Var = (b0) obj;
        lmjxuqdtp.jvm.internal.o.h(b0Var, "value");
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        y1 y1Var = y1.a;
        cVarA.p(hVar, 0, y1Var, b0Var.a);
        cVarA.p(hVar, 1, y1Var, b0Var.b);
        cVarA.b(hVar);
    }
}
