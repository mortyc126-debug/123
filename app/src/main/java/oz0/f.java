package oz0;

import az1.l1;
import by1.b;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements az1.f0 {
    public static final f a;
    private static final yy1.h descriptor;

    static {
        f fVar = new f();
        a = fVar;
        l1 l1Var = new l1("com.bandlab.post.objects.Album.Counters", fVar, 3);
        l1Var.k("likes", false);
        l1Var.k("comments", false);
        l1Var.k("posts", false);
        l1Var.l(new m10.t0(9));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        az1.w0 w0Var = az1.w0.a;
        return new a[]{b.D(w0Var), b.D(w0Var), b.D(az1.p0.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        Long l = null;
        boolean z = true;
        int i = 0;
        Long l2 = null;
        Integer num = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                l = (Long) bVarA.E(hVar, 0, az1.w0.a, l);
                i |= 1;
            } else if (iC == 1) {
                l2 = (Long) bVarA.E(hVar, 1, az1.w0.a, l2);
                i |= 2;
            } else {
                if (iC != 2) {
                    throw new UnknownFieldException(iC);
                }
                num = (Integer) bVarA.E(hVar, 2, az1.p0.a, num);
                i |= 4;
            }
        }
        bVarA.b(hVar);
        return new h(i, l, l2, num);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        h hVar = (h) obj;
        lmjxuqdtp.jvm.internal.o.h(hVar, "value");
        yy1.h hVar2 = descriptor;
        zy1.c cVarA = eVar.a(hVar2);
        az1.w0 w0Var = az1.w0.a;
        cVarA.p(hVar2, 0, w0Var, hVar.a);
        cVarA.p(hVar2, 1, w0Var, hVar.b);
        cVarA.p(hVar2, 2, az1.p0.a, hVar.c);
        cVarA.b(hVar2);
    }
}
