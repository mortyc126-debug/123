package p10;

import az1.f0;
import az1.g;
import az1.l1;
import az1.p0;
import az1.w;
import az1.y1;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.jvm.internal.o;
import m10.h0;
import m10.j;
import m10.j0;
import m10.t0;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import un0.m;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import yy1.h;
import zy1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements f0 {
    public static final a a;
    private static final h descriptor;

    static {
        a aVar = new a();
        a = aVar;
        l1 l1Var = new l1("com.bandlab.common.vmsrhfaqrb.beat.Beat", aVar, 34);
        l1Var.k("id", false);
        l1Var.k("name", true);
        l1Var.k("creatorName", true);
        l1Var.k("genre", true);
        l1Var.k("genreId", true);
        l1Var.k("bpm", true);
        l1Var.k("price", true);
        l1Var.k("audioUrl", true);
        l1Var.k("duration", true);
        l1Var.k("audioPreviewUrl", true);
        l1Var.k("previewDuration", true);
        l1Var.k("picture", true);
        l1Var.k("isPurchased", true);
        l1Var.k("licenseUrl", true);
        l1Var.k("description", true);
        l1Var.k("previewWaveform", true);
        l1Var.k("waveform", true);
        l1Var.k("key", true);
        l1Var.k("curatedHashtag", true);
        l1Var.k("curatedColor", true);
        l1Var.k("curatorName", true);
        l1Var.k("curatorDescription", true);
        l1Var.k("paymentProviderPriceIds", true);
        l1Var.k("sale", true);
        l1Var.k("saleLimitation", true);
        l1Var.k("backgroundPicture", true);
        l1Var.k("isSaved", true);
        l1Var.k("sampleId", true);
        l1Var.k("spatialAudioUrl", true);
        l1Var.k("spatialAudioPreviewUrl", true);
        l1Var.k("isMembersOnly", true);
        l1Var.k("hasStems", true);
        l1Var.k("stemsUrl", true);
        l1Var.k("promoBadge", true);
        l1Var.l(new t0(20));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        wy1.a aVar = y1.a;
        wy1.a aVarD = by1.b.D(aVar);
        wy1.a aVarD2 = by1.b.D(aVar);
        wy1.a aVarD3 = by1.b.D(aVar);
        wy1.a aVarD4 = by1.b.D(aVar);
        wy1.a aVarD5 = by1.b.D(p0.a);
        wy1.a aVarD6 = by1.b.D(j.a);
        wy1.a aVarD7 = by1.b.D(aVar);
        w wVar = w.a;
        wy1.a aVarD8 = by1.b.D(wVar);
        wy1.a aVarD9 = by1.b.D(aVar);
        wy1.a aVarD10 = by1.b.D(wVar);
        h0 h0Var = h0.a;
        wy1.a aVarD11 = by1.b.D(h0Var);
        g gVar = g.a;
        return new wy1.a[]{aVar, aVarD, aVarD2, aVarD3, aVarD4, aVarD5, aVarD6, aVarD7, aVarD8, aVarD9, aVarD10, aVarD11, by1.b.D(gVar), by1.b.D(aVar), by1.b.D(aVar), by1.b.D(aVar), by1.b.D(aVar), by1.b.D(aVar), by1.b.D(aVar), by1.b.D(aVar), by1.b.D(aVar), by1.b.D(aVar), by1.b.D(c.a), by1.b.D(f.a), by1.b.D(i.a), by1.b.D(h0Var), by1.b.D(gVar), by1.b.D(aVar), by1.b.D(aVar), by1.b.D(aVar), by1.b.D(gVar), by1.b.D(gVar), by1.b.D(aVar), by1.b.D(aVar)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        String str;
        String str2;
        Boolean bool;
        String str3;
        int i;
        String str4;
        h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        e eVar = null;
        String str5 = null;
        Boolean bool2 = null;
        h hVar2 = null;
        k kVar = null;
        j0 j0Var = null;
        String str6 = null;
        String str7 = null;
        Boolean bool3 = null;
        Boolean bool4 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String strA = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        Integer num = null;
        m10.l lVar = null;
        String str15 = null;
        Double d = null;
        String str16 = null;
        Double d3 = null;
        j0 j0Var2 = null;
        Boolean bool5 = null;
        String str17 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        String str22 = null;
        String str23 = null;
        String str24 = null;
        int i2 = 0;
        boolean z = true;
        int i3 = 0;
        while (z) {
            int i4 = i2;
            int iC = bVarA.C(hVar);
            switch (iC) {
                case -1:
                    str = str5;
                    str2 = str10;
                    i2 = i4;
                    bool = bool2;
                    z = false;
                    str10 = str2;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 0:
                    str = str5;
                    str2 = str10;
                    bool = bool2;
                    strA = bVarA.A(hVar, 0);
                    i2 = i4 | 1;
                    str10 = str2;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 1:
                    str = str5;
                    bool = bool2;
                    i2 = i4 | 2;
                    str11 = (String) bVarA.E(hVar, 1, y1.a, str11);
                    str12 = str12;
                    str10 = str10;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 2:
                    str = str5;
                    str3 = str10;
                    bool = bool2;
                    i2 = i4 | 4;
                    str12 = (String) bVarA.E(hVar, 2, y1.a, str12);
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 3:
                    str = str5;
                    str3 = str10;
                    bool = bool2;
                    i2 = i4 | 8;
                    str13 = (String) bVarA.E(hVar, 3, y1.a, str13);
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 4:
                    str = str5;
                    str3 = str10;
                    bool = bool2;
                    i2 = i4 | 16;
                    str14 = (String) bVarA.E(hVar, 4, y1.a, str14);
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 5:
                    str = str5;
                    str3 = str10;
                    bool = bool2;
                    i2 = i4 | 32;
                    num = (Integer) bVarA.E(hVar, 5, p0.a, num);
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 6:
                    str = str5;
                    str3 = str10;
                    bool = bool2;
                    i2 = i4 | 64;
                    lVar = (m10.l) bVarA.E(hVar, 6, j.a, lVar);
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 7:
                    str = str5;
                    str3 = str10;
                    bool = bool2;
                    i2 = i4 | 128;
                    str15 = (String) bVarA.E(hVar, 7, y1.a, str15);
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 8:
                    str = str5;
                    str3 = str10;
                    bool = bool2;
                    i2 = i4 | 256;
                    d = (Double) bVarA.E(hVar, 8, w.a, d);
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 9:
                    str = str5;
                    str3 = str10;
                    bool = bool2;
                    i2 = i4 | 512;
                    str16 = (String) bVarA.E(hVar, 9, y1.a, str16);
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 10:
                    str = str5;
                    str3 = str10;
                    bool = bool2;
                    i2 = i4 | 1024;
                    d3 = (Double) bVarA.E(hVar, 10, w.a, d3);
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 11:
                    str = str5;
                    str3 = str10;
                    bool = bool2;
                    i2 = i4 | 2048;
                    j0Var2 = (j0) bVarA.E(hVar, 11, h0.a, j0Var2);
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 12:
                    str = str5;
                    str3 = str10;
                    bool = bool2;
                    i2 = i4 | 4096;
                    bool5 = (Boolean) bVarA.E(hVar, 12, g.a, bool5);
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 13:
                    str = str5;
                    str3 = str10;
                    bool = bool2;
                    i2 = i4 | 8192;
                    str17 = (String) bVarA.E(hVar, 13, y1.a, str17);
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 14:
                    str = str5;
                    str3 = str10;
                    String str25 = (String) bVarA.E(hVar, 14, y1.a, str18);
                    i2 = i4 | Http2.INITIAL_MAX_FRAME_SIZE;
                    str18 = str25;
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 15:
                    str = str5;
                    str3 = str10;
                    i2 = i4 | 32768;
                    str19 = (String) bVarA.E(hVar, 15, y1.a, str19);
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 16:
                    str = str5;
                    str3 = str10;
                    i2 = i4 | 65536;
                    str20 = (String) bVarA.E(hVar, 16, y1.a, str20);
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 17:
                    str = str5;
                    str3 = str10;
                    i2 = i4 | 131072;
                    str21 = (String) bVarA.E(hVar, 17, y1.a, str21);
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 18:
                    str = str5;
                    str3 = str10;
                    i2 = i4 | 262144;
                    str22 = (String) bVarA.E(hVar, 18, y1.a, str22);
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 19:
                    str = str5;
                    str3 = str10;
                    i2 = i4 | 524288;
                    str23 = (String) bVarA.E(hVar, 19, y1.a, str23);
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 20:
                    str = str5;
                    str3 = str10;
                    i2 = i4 | 1048576;
                    str24 = (String) bVarA.E(hVar, 20, y1.a, str24);
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 21:
                    str = str5;
                    i2 = i4 | 2097152;
                    str10 = (String) bVarA.E(hVar, 21, y1.a, str10);
                    bool = bool2;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 22:
                    str3 = str10;
                    eVar = (e) bVarA.E(hVar, 22, c.a, eVar);
                    i = 4194304;
                    i2 = i4 | i;
                    str = str5;
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 23:
                    str3 = str10;
                    hVar2 = (h) bVarA.E(hVar, 23, f.a, hVar2);
                    i = 8388608;
                    i2 = i4 | i;
                    str = str5;
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 24:
                    str3 = str10;
                    kVar = (k) bVarA.E(hVar, 24, i.a, kVar);
                    i = Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
                    i2 = i4 | i;
                    str = str5;
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 25:
                    str3 = str10;
                    j0Var = (j0) bVarA.E(hVar, 25, h0.a, j0Var);
                    i = 33554432;
                    i2 = i4 | i;
                    str = str5;
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 26:
                    str3 = str10;
                    bool2 = (Boolean) bVarA.E(hVar, 26, g.a, bool2);
                    i = 67108864;
                    i2 = i4 | i;
                    str = str5;
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 27:
                    str3 = str10;
                    str5 = (String) bVarA.E(hVar, 27, y1.a, str5);
                    i = 134217728;
                    i2 = i4 | i;
                    str = str5;
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 28:
                    str3 = str10;
                    str6 = (String) bVarA.E(hVar, 28, y1.a, str6);
                    i = 268435456;
                    i2 = i4 | i;
                    str = str5;
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 29:
                    str3 = str10;
                    str7 = (String) bVarA.E(hVar, 29, y1.a, str7);
                    i = 536870912;
                    i2 = i4 | i;
                    str = str5;
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 30:
                    str3 = str10;
                    bool3 = (Boolean) bVarA.E(hVar, 30, g.a, bool3);
                    i = 1073741824;
                    i2 = i4 | i;
                    str = str5;
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 31:
                    str3 = str10;
                    bool4 = (Boolean) bVarA.E(hVar, 31, g.a, bool4);
                    i = IntCompanionObject.MIN_VALUE;
                    i2 = i4 | i;
                    str = str5;
                    bool = bool2;
                    str10 = str3;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 32:
                    str4 = str10;
                    str8 = (String) bVarA.E(hVar, 32, y1.a, str8);
                    i3 |= 1;
                    str = str5;
                    i2 = i4;
                    str10 = str4;
                    bool = bool2;
                    bool2 = bool;
                    str5 = str;
                    break;
                case 33:
                    str4 = str10;
                    str9 = (String) bVarA.E(hVar, 33, y1.a, str9);
                    i3 |= 2;
                    str = str5;
                    i2 = i4;
                    str10 = str4;
                    bool = bool2;
                    bool2 = bool;
                    str5 = str;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        String str26 = str5;
        String str27 = str10;
        String str28 = str11;
        String str29 = str12;
        bVarA.b(hVar);
        String str30 = str15;
        String str31 = str20;
        j0 j0Var3 = j0Var;
        return new l(i2, i3, strA, str28, str29, str13, str14, num, lVar, str30, d, str16, d3, j0Var2, bool5, str17, str18, str19, str31, str21, str22, str23, str24, str27, eVar, hVar2, kVar, j0Var3, bool2, str26, str6, str7, bool3, bool4, str8, str9);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        l lVar = (l) obj;
        o.h(lVar, "value");
        String str = lVar.H;
        String str2 = lVar.G;
        Boolean bool = lVar.F;
        Boolean bool2 = lVar.E;
        String str3 = lVar.D;
        String str4 = lVar.C;
        String str5 = lVar.B;
        Boolean bool3 = lVar.A;
        j0 j0Var = lVar.z;
        k kVar = lVar.y;
        h hVar = lVar.x;
        e eVar2 = lVar.w;
        String str6 = lVar.v;
        String str7 = lVar.u;
        String str8 = lVar.t;
        String str9 = lVar.s;
        String str10 = lVar.r;
        String str11 = lVar.q;
        String str12 = lVar.p;
        String str13 = lVar.o;
        String str14 = lVar.n;
        Boolean bool4 = lVar.m;
        h hVar2 = descriptor;
        m mVarA = eVar.a(hVar2);
        String str15 = lVar.a;
        j0 j0Var2 = lVar.l;
        Double d = lVar.k;
        String str16 = lVar.f386j;
        Double d3 = lVar.i;
        String str17 = lVar.h;
        m10.l lVar2 = lVar.g;
        Integer num = lVar.f385f;
        String str18 = lVar.e;
        String str19 = lVar.d;
        String str20 = lVar.c;
        String str21 = lVar.b;
        m mVar = mVarA;
        mVar.d0(hVar2, 0, str15);
        if (mVar.g(hVar2) || str21 != null) {
            mVar.p(hVar2, 1, y1.a, str21);
        }
        if (mVar.g(hVar2) || str20 != null) {
            mVar.p(hVar2, 2, y1.a, str20);
        }
        if (mVar.g(hVar2) || str19 != null) {
            mVar.p(hVar2, 3, y1.a, str19);
        }
        if (mVar.g(hVar2) || str18 != null) {
            mVar.p(hVar2, 4, y1.a, str18);
        }
        if (mVar.g(hVar2) || num != null) {
            mVar.p(hVar2, 5, p0.a, num);
        }
        if (mVar.g(hVar2) || lVar2 != null) {
            mVar.p(hVar2, 6, j.a, lVar2);
        }
        if (mVar.g(hVar2) || str17 != null) {
            mVar.p(hVar2, 7, y1.a, str17);
        }
        if (mVar.g(hVar2) || d3 != null) {
            mVar.p(hVar2, 8, w.a, d3);
        }
        if (mVar.g(hVar2) || str16 != null) {
            mVar.p(hVar2, 9, y1.a, str16);
        }
        if (mVar.g(hVar2) || d != null) {
            mVar.p(hVar2, 10, w.a, d);
        }
        if (mVar.g(hVar2) || j0Var2 != null) {
            mVar.p(hVar2, 11, h0.a, j0Var2);
        }
        if (mVar.g(hVar2) || bool4 != null) {
            mVar.p(hVar2, 12, g.a, bool4);
        }
        if (mVar.g(hVar2) || str14 != null) {
            mVar.p(hVar2, 13, y1.a, str14);
        }
        if (mVar.g(hVar2) || str13 != null) {
            mVar.p(hVar2, 14, y1.a, str13);
        }
        if (mVar.g(hVar2) || str12 != null) {
            mVar.p(hVar2, 15, y1.a, str12);
        }
        if (mVar.g(hVar2) || str11 != null) {
            mVar.p(hVar2, 16, y1.a, str11);
        }
        if (mVar.g(hVar2) || str10 != null) {
            mVar.p(hVar2, 17, y1.a, str10);
        }
        if (mVar.g(hVar2) || str9 != null) {
            mVar.p(hVar2, 18, y1.a, str9);
        }
        if (mVar.g(hVar2) || str8 != null) {
            mVar.p(hVar2, 19, y1.a, str8);
        }
        if (mVar.g(hVar2) || str7 != null) {
            mVar.p(hVar2, 20, y1.a, str7);
        }
        if (mVar.g(hVar2) || str6 != null) {
            mVar.p(hVar2, 21, y1.a, str6);
        }
        if (mVar.g(hVar2) || eVar2 != null) {
            mVar.p(hVar2, 22, c.a, eVar2);
        }
        if (mVar.g(hVar2) || hVar != null) {
            mVar.p(hVar2, 23, f.a, hVar);
        }
        if (mVar.g(hVar2) || kVar != null) {
            mVar.p(hVar2, 24, i.a, kVar);
        }
        if (mVar.g(hVar2) || j0Var != null) {
            mVar.p(hVar2, 25, h0.a, j0Var);
        }
        if (mVar.g(hVar2) || bool3 != null) {
            mVar.p(hVar2, 26, g.a, bool3);
        }
        if (mVar.g(hVar2) || str5 != null) {
            mVar.p(hVar2, 27, y1.a, str5);
        }
        if (mVar.g(hVar2) || str4 != null) {
            mVar.p(hVar2, 28, y1.a, str4);
        }
        if (mVar.g(hVar2) || str3 != null) {
            mVar.p(hVar2, 29, y1.a, str3);
        }
        if (mVar.g(hVar2) || bool2 != null) {
            mVar.p(hVar2, 30, g.a, bool2);
        }
        if (mVar.g(hVar2) || bool != null) {
            mVar.p(hVar2, 31, g.a, bool);
        }
        if (mVar.g(hVar2) || str2 != null) {
            mVar.p(hVar2, 32, y1.a, str2);
        }
        if (mVar.g(hVar2) || str != null) {
            mVar.p(hVar2, 33, y1.a, str);
        }
        mVarA.b(hVar2);
    }
}
