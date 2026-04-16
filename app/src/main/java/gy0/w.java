package gy0;

import a80.p;
import az1.f0;
import az1.l1;
import az1.y1;
import by1.b;
import lmjxuqdtp.jvm.internal.o;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import yy1.h;
import zy1.c;
import zy1.d;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements f0 {
    public static final w a;
    private static final h descriptor;

    static {
        w wVar = new w();
        a = wVar;
        l1 l1Var = new l1("com.bandlab.playlist.api.TrendingInGenreConfig.TrendingInGenre", wVar, 2);
        l1Var.k("channelId", false);
        l1Var.k("collectionId", false);
        l1Var.l(new p(12));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        y1 y1Var = y1.a;
        return new a[]{b.D(y1Var), b.D(y1Var)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        h hVar = descriptor;
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
        return new y(i, str, str2);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        y yVar = (y) obj;
        o.h(yVar, "value");
        h hVar = descriptor;
        c cVarA = eVar.a(hVar);
        y1 y1Var = y1.a;
        cVarA.p(hVar, 0, y1Var, yVar.a);
        cVarA.p(hVar, 1, y1Var, yVar.b);
        cVarA.b(hVar);
    }
}
