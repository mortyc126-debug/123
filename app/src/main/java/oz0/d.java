package oz0;

import az1.l1;
import az1.y1;
import by1.b;
import java.util.List;
import okhttp3.internal.http2.Http2;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements az1.f0 {
    public static final d a;
    private static final yy1.h descriptor;

    static {
        d dVar = new d();
        a = dVar;
        l1 l1Var = new l1("com.bandlab.post.objects.Album", dVar, 21);
        l1Var.k("id", false);
        l1Var.k("name", true);
        l1Var.k("creator", true);
        l1Var.k("artist", true);
        l1Var.k("counters", true);
        l1Var.k("releaseDate", true);
        l1Var.k("isReleaseScheduled", true);
        l1Var.k("isPurchased", true);
        l1Var.k("picture", true);
        l1Var.k("description", true);
        l1Var.k("posts", true);
        l1Var.k("isLiked", true);
        l1Var.k("genreId", true);
        l1Var.k("theme", true);
        l1Var.k("themeId", true);
        l1Var.k("type", true);
        l1Var.k("state", true);
        l1Var.k("supporters", true);
        l1Var.k("permissions", true);
        l1Var.k("isCommentingAllowed", true);
        l1Var.k("isAutoRepostEnabled", true);
        l1Var.l(new m10.t0(9));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        lx1.h[] hVarArr = i.v;
        a aVar = y1.a;
        a aVarD = b.D(aVar);
        a aVarD2 = b.D(m10.o.a);
        a aVarD3 = b.D(m10.a.a);
        a aVarD4 = b.D(f.a);
        a aVarD5 = b.D(aVar);
        az1.g gVar = az1.g.a;
        return new a[]{aVar, aVarD, aVarD2, aVarD3, aVarD4, aVarD5, b.D(gVar), b.D(gVar), b.D(m10.h0.a), b.D(aVar), b.D((a) hVarArr[10].getValue()), b.D(gVar), b.D(aVar), b.D(r.a), b.D(aVar), b.D((a) hVarArr[15].getValue()), b.D((a) hVarArr[16].getValue()), b.D((a) hVarArr[17].getValue()), b.D(m.a), b.D(gVar), b.D(gVar)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        String str;
        int i;
        w wVar;
        String str2;
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = i.v;
        m10.j0 j0Var = null;
        w wVar2 = null;
        String str3 = null;
        Boolean bool = null;
        String str4 = null;
        List list = null;
        String str5 = null;
        k0 k0Var = null;
        q qVar = null;
        List list2 = null;
        o oVar = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        String strA = null;
        String str6 = null;
        m10.q qVar2 = null;
        m10.f fVar = null;
        h hVar2 = null;
        String str7 = null;
        Boolean bool4 = null;
        Boolean bool5 = null;
        int i2 = 0;
        boolean z = true;
        while (z) {
            m10.j0 j0Var2 = j0Var;
            int iC = bVarA.C(hVar);
            switch (iC) {
                case -1:
                    wVar = wVar2;
                    str2 = str4;
                    z = false;
                    j0Var = j0Var2;
                    str4 = str2;
                    wVar2 = wVar;
                    break;
                case 0:
                    wVar = wVar2;
                    str2 = str4;
                    strA = bVarA.A(hVar, 0);
                    i2 |= 1;
                    j0Var = j0Var2;
                    str4 = str2;
                    wVar2 = wVar;
                    break;
                case 1:
                    wVar = wVar2;
                    str2 = str4;
                    str6 = (String) bVarA.E(hVar, 1, y1.a, str6);
                    i2 |= 2;
                    qVar2 = qVar2;
                    j0Var = j0Var2;
                    str4 = str2;
                    wVar2 = wVar;
                    break;
                case 2:
                    wVar = wVar2;
                    str2 = str4;
                    qVar2 = (m10.q) bVarA.E(hVar, 2, m10.o.a, qVar2);
                    i2 |= 4;
                    j0Var = j0Var2;
                    str4 = str2;
                    wVar2 = wVar;
                    break;
                case 3:
                    wVar = wVar2;
                    str2 = str4;
                    fVar = (m10.f) bVarA.E(hVar, 3, m10.a.a, fVar);
                    i2 |= 8;
                    j0Var = j0Var2;
                    str4 = str2;
                    wVar2 = wVar;
                    break;
                case 4:
                    wVar = wVar2;
                    str2 = str4;
                    hVar2 = (h) bVarA.E(hVar, 4, f.a, hVar2);
                    i2 |= 16;
                    j0Var = j0Var2;
                    str4 = str2;
                    wVar2 = wVar;
                    break;
                case 5:
                    wVar = wVar2;
                    str2 = str4;
                    str7 = (String) bVarA.E(hVar, 5, y1.a, str7);
                    i2 |= 32;
                    j0Var = j0Var2;
                    str4 = str2;
                    wVar2 = wVar;
                    break;
                case 6:
                    wVar = wVar2;
                    str2 = str4;
                    bool4 = (Boolean) bVarA.E(hVar, 6, az1.g.a, bool4);
                    i2 |= 64;
                    j0Var = j0Var2;
                    str4 = str2;
                    wVar2 = wVar;
                    break;
                case 7:
                    wVar = wVar2;
                    str2 = str4;
                    bool5 = (Boolean) bVarA.E(hVar, 7, az1.g.a, bool5);
                    i2 |= 128;
                    j0Var = j0Var2;
                    str4 = str2;
                    wVar2 = wVar;
                    break;
                case 8:
                    wVar = wVar2;
                    str2 = str4;
                    j0Var = (m10.j0) bVarA.E(hVar, 8, m10.h0.a, j0Var2);
                    i2 |= 256;
                    str4 = str2;
                    wVar2 = wVar;
                    break;
                case 9:
                    wVar = wVar2;
                    str4 = (String) bVarA.E(hVar, 9, y1.a, str4);
                    i2 |= 512;
                    j0Var = j0Var2;
                    wVar2 = wVar;
                    break;
                case 10:
                    str = str4;
                    list = (List) bVarA.E(hVar, 10, (a) hVarArr[10].getValue(), list);
                    i2 |= 1024;
                    j0Var = j0Var2;
                    str4 = str;
                    break;
                case 11:
                    str = str4;
                    bool = (Boolean) bVarA.E(hVar, 11, az1.g.a, bool);
                    i2 |= 2048;
                    j0Var = j0Var2;
                    str4 = str;
                    break;
                case 12:
                    str = str4;
                    str3 = (String) bVarA.E(hVar, 12, y1.a, str3);
                    i2 |= 4096;
                    j0Var = j0Var2;
                    str4 = str;
                    break;
                case 13:
                    str = str4;
                    wVar2 = (w) bVarA.E(hVar, 13, r.a, wVar2);
                    i2 |= 8192;
                    j0Var = j0Var2;
                    str4 = str;
                    break;
                case 14:
                    str = str4;
                    str5 = (String) bVarA.E(hVar, 14, y1.a, str5);
                    i2 |= Http2.INITIAL_MAX_FRAME_SIZE;
                    j0Var = j0Var2;
                    str4 = str;
                    break;
                case 15:
                    str = str4;
                    k0Var = (k0) bVarA.E(hVar, 15, (a) hVarArr[15].getValue(), k0Var);
                    i = 32768;
                    i2 |= i;
                    j0Var = j0Var2;
                    str4 = str;
                    break;
                case 16:
                    str = str4;
                    qVar = (q) bVarA.E(hVar, 16, (a) hVarArr[16].getValue(), qVar);
                    i = 65536;
                    i2 |= i;
                    j0Var = j0Var2;
                    str4 = str;
                    break;
                case 17:
                    str = str4;
                    list2 = (List) bVarA.E(hVar, 17, (a) hVarArr[17].getValue(), list2);
                    i = 131072;
                    i2 |= i;
                    j0Var = j0Var2;
                    str4 = str;
                    break;
                case 18:
                    str = str4;
                    oVar = (o) bVarA.E(hVar, 18, m.a, oVar);
                    i = 262144;
                    i2 |= i;
                    j0Var = j0Var2;
                    str4 = str;
                    break;
                case 19:
                    str = str4;
                    bool2 = (Boolean) bVarA.E(hVar, 19, az1.g.a, bool2);
                    i = 524288;
                    i2 |= i;
                    j0Var = j0Var2;
                    str4 = str;
                    break;
                case 20:
                    str = str4;
                    bool3 = (Boolean) bVarA.E(hVar, 20, az1.g.a, bool3);
                    i = 1048576;
                    i2 |= i;
                    j0Var = j0Var2;
                    str4 = str;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        w wVar3 = wVar2;
        String str8 = str4;
        String str9 = str6;
        m10.q qVar3 = qVar2;
        bVarA.b(hVar);
        String str10 = strA;
        List list3 = list;
        return new i(i2, str10, str9, qVar3, fVar, hVar2, str7, bool4, bool5, j0Var, str8, list3, bool, str3, wVar3, str5, k0Var, qVar, list2, oVar, bool2, bool3);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        i iVar = (i) obj;
        lmjxuqdtp.jvm.internal.o.h(iVar, "value");
        Boolean bool = iVar.u;
        Boolean bool2 = iVar.t;
        o oVar = iVar.s;
        List list = iVar.r;
        q qVar = iVar.q;
        k0 k0Var = iVar.p;
        String str = iVar.o;
        w wVar = iVar.n;
        String str2 = iVar.m;
        Boolean bool3 = iVar.l;
        List list2 = iVar.k;
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        lx1.h[] hVarArr = i.v;
        String str3 = iVar.a;
        String str4 = iVar.f382j;
        m10.j0 j0Var = iVar.i;
        Boolean bool4 = iVar.h;
        Boolean bool5 = iVar.g;
        String str5 = iVar.f381f;
        h hVar2 = iVar.e;
        m10.f fVar = iVar.d;
        m10.q qVar2 = iVar.c;
        String str6 = iVar.b;
        un0.m mVar = mVarA;
        mVar.d0(hVar, 0, str3);
        if (mVar.g(hVar) || str6 != null) {
            mVar.p(hVar, 1, y1.a, str6);
        }
        if (mVar.g(hVar) || qVar2 != null) {
            mVar.p(hVar, 2, m10.o.a, qVar2);
        }
        if (mVar.g(hVar) || fVar != null) {
            mVar.p(hVar, 3, m10.a.a, fVar);
        }
        if (mVar.g(hVar) || hVar2 != null) {
            mVar.p(hVar, 4, f.a, hVar2);
        }
        if (mVar.g(hVar) || str5 != null) {
            mVar.p(hVar, 5, y1.a, str5);
        }
        if (mVar.g(hVar) || bool5 != null) {
            mVar.p(hVar, 6, az1.g.a, bool5);
        }
        if (mVar.g(hVar) || bool4 != null) {
            mVar.p(hVar, 7, az1.g.a, bool4);
        }
        if (mVar.g(hVar) || j0Var != null) {
            mVar.p(hVar, 8, m10.h0.a, j0Var);
        }
        if (mVar.g(hVar) || str4 != null) {
            mVar.p(hVar, 9, y1.a, str4);
        }
        if (mVar.g(hVar) || list2 != null) {
            mVar.p(hVar, 10, (a) hVarArr[10].getValue(), list2);
        }
        if (mVar.g(hVar) || bool3 != null) {
            mVar.p(hVar, 11, az1.g.a, bool3);
        }
        if (mVar.g(hVar) || str2 != null) {
            mVar.p(hVar, 12, y1.a, str2);
        }
        if (mVar.g(hVar) || wVar != null) {
            mVar.p(hVar, 13, r.a, wVar);
        }
        if (mVar.g(hVar) || str != null) {
            mVar.p(hVar, 14, y1.a, str);
        }
        if (mVar.g(hVar) || k0Var != null) {
            mVar.p(hVar, 15, (a) hVarArr[15].getValue(), k0Var);
        }
        if (mVar.g(hVar) || qVar != null) {
            mVar.p(hVar, 16, (a) hVarArr[16].getValue(), qVar);
        }
        if (mVar.g(hVar) || list != null) {
            mVar.p(hVar, 17, (a) hVarArr[17].getValue(), list);
        }
        if (mVar.g(hVar) || oVar != null) {
            mVar.p(hVar, 18, m.a, oVar);
        }
        if (mVar.g(hVar) || bool2 != null) {
            mVar.p(hVar, 19, az1.g.a, bool2);
        }
        if (mVar.g(hVar) || bool != null) {
            mVar.p(hVar, 20, az1.g.a, bool);
        }
        mVarA.b(hVar);
    }
}
