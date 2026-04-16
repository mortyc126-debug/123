package b60;

import a80.p;
import az1.f0;
import az1.l1;
import az1.p0;
import az1.y1;
import java.util.List;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.c;
import zy1.d;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements f0 {
    public static final a a;
    private static final yy1.h descriptor;

    static {
        a aVar = new a();
        a = aVar;
        l1 l1Var = new l1("com.bandlab.easter.impl.EasterEgg", aVar, 6);
        l1Var.k("id", false);
        l1Var.k("links", false);
        l1Var.k("animation_size", false);
        l1Var.k("animation_url", false);
        l1Var.k("crack_animation_url", false);
        l1Var.k("key", false);
        l1Var.l(new p(1));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        lx1.h[] hVarArr = h.g;
        wy1.a aVarD = by1.b.D((wy1.a) hVarArr[0].getValue());
        wy1.a aVarD2 = by1.b.D((wy1.a) hVarArr[1].getValue());
        wy1.a aVarD3 = by1.b.D(p0.a);
        y1 y1Var = y1.a;
        return new wy1.a[]{aVarD, aVarD2, aVarD3, by1.b.D(y1Var), by1.b.D(y1Var), by1.b.D(y1Var)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = h.g;
        int i = 0;
        c60.b bVar = null;
        List list = null;
        Integer num = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        boolean z = true;
        while (z) {
            int iC = bVarA.C(hVar);
            switch (iC) {
                case -1:
                    z = false;
                    break;
                case 0:
                    bVar = (c60.b) bVarA.E(hVar, 0, (wy1.a) hVarArr[0].getValue(), bVar);
                    i |= 1;
                    break;
                case 1:
                    list = (List) bVarA.E(hVar, 1, (wy1.a) hVarArr[1].getValue(), list);
                    i |= 2;
                    break;
                case 2:
                    num = (Integer) bVarA.E(hVar, 2, p0.a, num);
                    i |= 4;
                    break;
                case 3:
                    str = (String) bVarA.E(hVar, 3, y1.a, str);
                    i |= 8;
                    break;
                case 4:
                    str2 = (String) bVarA.E(hVar, 4, y1.a, str2);
                    i |= 16;
                    break;
                case 5:
                    str3 = (String) bVarA.E(hVar, 5, y1.a, str3);
                    i |= 32;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        bVarA.b(hVar);
        return new h(i, bVar, list, num, str, str2, str3);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        h hVar = (h) obj;
        lmjxuqdtp.jvm.internal.o.h(hVar, "value");
        yy1.h hVar2 = descriptor;
        c cVarA = eVar.a(hVar2);
        lx1.h[] hVarArr = h.g;
        cVarA.p(hVar2, 0, (wy1.a) hVarArr[0].getValue(), hVar.a);
        cVarA.p(hVar2, 1, (wy1.a) hVarArr[1].getValue(), hVar.b);
        cVarA.p(hVar2, 2, p0.a, hVar.c);
        y1 y1Var = y1.a;
        cVarA.p(hVar2, 3, y1Var, hVar.d);
        cVarA.p(hVar2, 4, y1Var, hVar.e);
        cVarA.p(hVar2, 5, y1Var, hVar.f17f);
        cVarA.b(hVar2);
    }
}
