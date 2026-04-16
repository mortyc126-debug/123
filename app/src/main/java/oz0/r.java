package oz0;

import az1.l1;
import az1.y1;
import by1.b;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements az1.f0 {
    public static final r a;
    private static final yy1.h descriptor;

    static {
        r rVar = new r();
        a = rVar;
        l1 l1Var = new l1("com.bandlab.post.objects.AlbumTheme", rVar, 3);
        l1Var.k("id", false);
        l1Var.k("colors", false);
        l1Var.k("images", false);
        l1Var.l(new m10.t0(11));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        return new a[]{b.D(y1.a), b.D(j.a), b.D(t.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        String str = null;
        boolean z = true;
        int i = 0;
        l lVar = null;
        v vVar = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                str = (String) bVarA.E(hVar, 0, y1.a, str);
                i |= 1;
            } else if (iC == 1) {
                lVar = (l) bVarA.E(hVar, 1, j.a, lVar);
                i |= 2;
            } else {
                if (iC != 2) {
                    throw new UnknownFieldException(iC);
                }
                vVar = (v) bVarA.E(hVar, 2, t.a, vVar);
                i |= 4;
            }
        }
        bVarA.b(hVar);
        return new w(i, str, lVar, vVar);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        w wVar = (w) obj;
        lmjxuqdtp.jvm.internal.o.h(wVar, "value");
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        cVarA.p(hVar, 0, y1.a, wVar.a);
        cVarA.p(hVar, 1, j.a, wVar.b);
        cVarA.p(hVar, 2, t.a, wVar.c);
        cVarA.b(hVar);
    }
}
