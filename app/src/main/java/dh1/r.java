package dh1;

import a80.p;
import az1.f0;
import az1.l1;
import az1.y1;
import by1.b;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IntCompanionObject;
import m10.i1;
import m10.j0;
import m10.k1;
import m10.u0;
import m10.w0;
import n10.d;
import n10.f;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import q10.l0;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements f0 {
    public static final r a;
    private static final yy1.h descriptor;

    static {
        r rVar = new r();
        a = rVar;
        l1 l1Var = new l1("com.bandlab.user.vmsrhfaqrb.User", rVar, 41);
        l1Var.k("id", false);
        l1Var.k("username", false);
        l1Var.k("name", true);
        l1Var.k("picture", true);
        l1Var.k("backgroundPicture", true);
        l1Var.k("backgroundPictureId", true);
        l1Var.k("conversationId", true);
        l1Var.k("about", true);
        l1Var.k("email", true);
        l1Var.k("birthday", true);
        l1Var.k("gender", true);
        l1Var.k("followingState", true);
        l1Var.k("followingMeState", true);
        l1Var.k("collaborationStatus", true);
        l1Var.k("followRequestedOn", true);
        l1Var.k("isSubscriber", true);
        l1Var.k("isBetaUser", true);
        l1Var.k("role", true);
        l1Var.k("counters", true);
        l1Var.k("isEmailConfirmed", true);
        l1Var.k("hasPassword", true);
        l1Var.k("skills", true);
        l1Var.k("genres", true);
        l1Var.k("badges", true);
        l1Var.k("place", true);
        l1Var.k("isVerified", true);
        l1Var.k("isTippable", true);
        l1Var.k("isBlocked", true);
        l1Var.k("isBlockingMe", true);
        l1Var.k("isPrivate", true);
        l1Var.k("permissions", true);
        l1Var.k("createdOn", true);
        l1Var.k("introVideo", true);
        l1Var.k("phone", true);
        l1Var.k("links", true);
        l1Var.k("inspiredBy", true);
        l1Var.k("isBoosted", true);
        l1Var.k("trackingEvents", true);
        l1Var.k("lookingFor", true);
        l1Var.k("isSocial", true);
        l1Var.k("language", true);
        l1Var.l(new p(8));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        lx1.h[] hVarArr = w.Q;
        wy1.a aVar = y1.a;
        wy1.a aVarD = b.D(aVar);
        wy1.a aVarD2 = b.D(aVar);
        m10.h0 h0Var = m10.h0.a;
        wy1.a aVarD3 = b.D(h0Var);
        wy1.a aVarD4 = b.D(h0Var);
        wy1.a aVarD5 = b.D(aVar);
        wy1.a aVarD6 = b.D(aVar);
        wy1.a aVarD7 = b.D(aVar);
        wy1.a aVarD8 = b.D(aVar);
        wy1.a aVarD9 = b.D(aVar);
        wy1.a aVarD10 = b.D((wy1.a) hVarArr[10].getValue());
        wy1.a aVarD11 = b.D((wy1.a) hVarArr[11].getValue());
        wy1.a aVarD12 = b.D((wy1.a) hVarArr[12].getValue());
        wy1.a aVarD13 = b.D((wy1.a) hVarArr[13].getValue());
        wy1.a aVarD14 = b.D(aVar);
        wy1.a aVar2 = az1.g.a;
        return new wy1.a[]{aVar, aVarD, aVarD2, aVarD3, aVarD4, aVarD5, aVarD6, aVarD7, aVarD8, aVarD9, aVarD10, aVarD11, aVarD12, aVarD13, aVarD14, aVar2, aVar2, b.D(aVar), b.D(b0.a), aVar2, aVar2, b.D((wy1.a) hVarArr[21].getValue()), b.D((wy1.a) hVarArr[22].getValue()), b.D((wy1.a) hVarArr[23].getValue()), b.D(u0.a), aVar2, aVar2, aVar2, aVar2, b.D(aVar2), b.D(t.a), b.D(aVar), b.D(i1.a), b.D(aVar), b.D((wy1.a) hVarArr[34].getValue()), b.D((wy1.a) hVarArr[35].getValue()), b.D(aVar2), b.D(d.a), b.D(a.a), aVar2, b.D(aVar)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        List list;
        w0 w0Var;
        int i;
        String str;
        Map map;
        int i2;
        w0 w0Var2;
        int i3;
        int i4;
        w0 w0Var3;
        int i6;
        int i7;
        int i8;
        int i9;
        w0 w0Var4;
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = w.Q;
        Boolean bool = null;
        List list2 = null;
        Map map2 = null;
        String str2 = null;
        v vVar = null;
        String str3 = null;
        k1 k1Var = null;
        Boolean bool2 = null;
        f fVar = null;
        c cVar = null;
        String str4 = null;
        List list3 = null;
        w0 w0Var5 = null;
        String strA = null;
        String str5 = null;
        String str6 = null;
        j0 j0Var = null;
        j0 j0Var2 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        k kVar = null;
        l0 l0Var = null;
        l0 l0Var2 = null;
        m10.n nVar = null;
        String str12 = null;
        String str13 = null;
        d0 d0Var = null;
        List list4 = null;
        List list5 = null;
        int i10 = 0;
        boolean z = true;
        int i11 = 0;
        boolean zB = false;
        boolean zB2 = false;
        boolean zB3 = false;
        boolean zB4 = false;
        boolean zB5 = false;
        boolean zB6 = false;
        boolean zB7 = false;
        boolean zB8 = false;
        boolean zB9 = false;
        while (z) {
            List list6 = list3;
            int iC = bVarA.C(hVar);
            switch (iC) {
                case -1:
                    list = list2;
                    w0Var = w0Var5;
                    i = i11;
                    str = str12;
                    map = map2;
                    z = false;
                    w0Var5 = w0Var;
                    i2 = i;
                    list3 = list6;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 0:
                    list = list2;
                    w0Var = w0Var5;
                    int i12 = i11;
                    str = str12;
                    map = map2;
                    strA = bVarA.A(hVar, 0);
                    i = i12 | 1;
                    w0Var5 = w0Var;
                    i2 = i;
                    list3 = list6;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 1:
                    list = list2;
                    int i13 = i11;
                    str = str12;
                    map = map2;
                    i = i13 | 2;
                    str5 = (String) bVarA.E(hVar, 1, y1.a, str5);
                    str6 = str6;
                    w0Var5 = w0Var5;
                    i2 = i;
                    list3 = list6;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 2:
                    list = list2;
                    w0Var2 = w0Var5;
                    int i14 = i11;
                    str = str12;
                    map = map2;
                    i3 = i14 | 4;
                    str6 = (String) bVarA.E(hVar, 2, y1.a, str6);
                    i2 = i3;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 3:
                    list = list2;
                    w0Var2 = w0Var5;
                    int i15 = i11;
                    str = str12;
                    map = map2;
                    i3 = i15 | 8;
                    j0Var = (j0) bVarA.E(hVar, 3, m10.h0.a, j0Var);
                    i2 = i3;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 4:
                    list = list2;
                    w0Var2 = w0Var5;
                    int i16 = i11;
                    str = str12;
                    map = map2;
                    i3 = i16 | 16;
                    j0Var2 = (j0) bVarA.E(hVar, 4, m10.h0.a, j0Var2);
                    i2 = i3;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 5:
                    list = list2;
                    w0Var2 = w0Var5;
                    int i17 = i11;
                    str = str12;
                    map = map2;
                    i3 = i17 | 32;
                    str7 = (String) bVarA.E(hVar, 5, y1.a, str7);
                    i2 = i3;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 6:
                    list = list2;
                    w0Var2 = w0Var5;
                    int i18 = i11;
                    str = str12;
                    map = map2;
                    i3 = i18 | 64;
                    str8 = (String) bVarA.E(hVar, 6, y1.a, str8);
                    i2 = i3;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 7:
                    list = list2;
                    w0Var2 = w0Var5;
                    int i19 = i11;
                    str = str12;
                    map = map2;
                    i3 = i19 | 128;
                    str9 = (String) bVarA.E(hVar, 7, y1.a, str9);
                    i2 = i3;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 8:
                    list = list2;
                    w0Var2 = w0Var5;
                    int i20 = i11;
                    str = str12;
                    map = map2;
                    i3 = i20 | 256;
                    str10 = (String) bVarA.E(hVar, 8, y1.a, str10);
                    i2 = i3;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 9:
                    list = list2;
                    w0Var2 = w0Var5;
                    int i21 = i11;
                    str = str12;
                    map = map2;
                    i3 = i21 | 512;
                    str11 = (String) bVarA.E(hVar, 9, y1.a, str11);
                    i2 = i3;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 10:
                    list = list2;
                    w0Var2 = w0Var5;
                    int i22 = i11;
                    str = str12;
                    map = map2;
                    i3 = i22 | 1024;
                    kVar = (k) bVarA.E(hVar, 10, (wy1.a) hVarArr[10].getValue(), kVar);
                    i2 = i3;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 11:
                    list = list2;
                    w0Var2 = w0Var5;
                    int i23 = i11;
                    str = str12;
                    map = map2;
                    i3 = i23 | 2048;
                    l0Var = (l0) bVarA.E(hVar, 11, (wy1.a) hVarArr[11].getValue(), l0Var);
                    i2 = i3;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 12:
                    list = list2;
                    w0Var2 = w0Var5;
                    int i24 = i11;
                    str = str12;
                    map = map2;
                    i3 = i24 | 4096;
                    l0Var2 = (l0) bVarA.E(hVar, 12, (wy1.a) hVarArr[12].getValue(), l0Var2);
                    i2 = i3;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 13:
                    list = list2;
                    w0Var2 = w0Var5;
                    int i25 = i11;
                    str = str12;
                    map = map2;
                    i3 = i25 | 8192;
                    nVar = (m10.n) bVarA.E(hVar, 13, (wy1.a) hVarArr[13].getValue(), nVar);
                    i2 = i3;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 14:
                    list = list2;
                    w0Var2 = w0Var5;
                    String str14 = (String) bVarA.E(hVar, 14, y1.a, str12);
                    int i26 = i11 | Http2.INITIAL_MAX_FRAME_SIZE;
                    str = str14;
                    map = map2;
                    i2 = i26;
                    list3 = list6;
                    w0Var5 = w0Var2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 15:
                    list = list2;
                    zB = bVarA.B(hVar, 15);
                    i4 = 32768;
                    i7 = i11 | i4;
                    i2 = i7;
                    str = str12;
                    list3 = list6;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 16:
                    list = list2;
                    zB2 = bVarA.B(hVar, 16);
                    i4 = 65536;
                    i7 = i11 | i4;
                    i2 = i7;
                    str = str12;
                    list3 = list6;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 17:
                    list = list2;
                    w0Var3 = w0Var5;
                    i6 = i11 | 131072;
                    str13 = (String) bVarA.E(hVar, 17, y1.a, str13);
                    i2 = i6;
                    str = str12;
                    list3 = list6;
                    w0Var5 = w0Var3;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 18:
                    list = list2;
                    w0Var3 = w0Var5;
                    i6 = i11 | 262144;
                    d0Var = (d0) bVarA.E(hVar, 18, b0.a, d0Var);
                    i2 = i6;
                    str = str12;
                    list3 = list6;
                    w0Var5 = w0Var3;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 19:
                    list = list2;
                    zB3 = bVarA.B(hVar, 19);
                    i4 = 524288;
                    i7 = i11 | i4;
                    i2 = i7;
                    str = str12;
                    list3 = list6;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 20:
                    list = list2;
                    zB4 = bVarA.B(hVar, 20);
                    i4 = 1048576;
                    i7 = i11 | i4;
                    i2 = i7;
                    str = str12;
                    list3 = list6;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 21:
                    list = list2;
                    w0Var3 = w0Var5;
                    i6 = i11 | 2097152;
                    list4 = (List) bVarA.E(hVar, 21, (wy1.a) hVarArr[21].getValue(), list4);
                    i2 = i6;
                    str = str12;
                    list3 = list6;
                    w0Var5 = w0Var3;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 22:
                    list = list2;
                    w0Var3 = w0Var5;
                    i6 = i11 | 4194304;
                    list5 = (List) bVarA.E(hVar, 22, (wy1.a) hVarArr[22].getValue(), list5);
                    i2 = i6;
                    str = str12;
                    list3 = list6;
                    w0Var5 = w0Var3;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 23:
                    list = list2;
                    i2 = i11 | 8388608;
                    str = str12;
                    w0Var5 = w0Var5;
                    list3 = (List) bVarA.E(hVar, 23, (wy1.a) hVarArr[23].getValue(), list6);
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 24:
                    list = list2;
                    w0 w0Var6 = (w0) bVarA.E(hVar, 24, u0.a, w0Var5);
                    i7 = i11 | Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
                    w0Var5 = w0Var6;
                    i2 = i7;
                    str = str12;
                    list3 = list6;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 25:
                    zB5 = bVarA.B(hVar, 25);
                    i8 = 33554432;
                    i7 = i11 | i8;
                    list = list2;
                    i2 = i7;
                    str = str12;
                    list3 = list6;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 26:
                    zB6 = bVarA.B(hVar, 26);
                    i8 = 67108864;
                    i7 = i11 | i8;
                    list = list2;
                    i2 = i7;
                    str = str12;
                    list3 = list6;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 27:
                    zB7 = bVarA.B(hVar, 27);
                    i8 = 134217728;
                    i7 = i11 | i8;
                    list = list2;
                    i2 = i7;
                    str = str12;
                    list3 = list6;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 28:
                    zB8 = bVarA.B(hVar, 28);
                    i8 = 268435456;
                    i7 = i11 | i8;
                    list = list2;
                    i2 = i7;
                    str = str12;
                    list3 = list6;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 29:
                    w0Var3 = w0Var5;
                    bool = (Boolean) bVarA.E(hVar, 29, az1.g.a, bool);
                    i9 = 536870912;
                    i6 = i11 | i9;
                    list = list2;
                    i2 = i6;
                    str = str12;
                    list3 = list6;
                    w0Var5 = w0Var3;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 30:
                    w0Var3 = w0Var5;
                    vVar = (v) bVarA.E(hVar, 30, t.a, vVar);
                    i9 = 1073741824;
                    i6 = i11 | i9;
                    list = list2;
                    i2 = i6;
                    str = str12;
                    list3 = list6;
                    w0Var5 = w0Var3;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 31:
                    w0Var3 = w0Var5;
                    str3 = (String) bVarA.E(hVar, 31, y1.a, str3);
                    i9 = IntCompanionObject.MIN_VALUE;
                    i6 = i11 | i9;
                    list = list2;
                    i2 = i6;
                    str = str12;
                    list3 = list6;
                    w0Var5 = w0Var3;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 32:
                    w0Var4 = w0Var5;
                    k1Var = (k1) bVarA.E(hVar, 32, i1.a, k1Var);
                    i10 |= 1;
                    list = list2;
                    i2 = i11;
                    list3 = list6;
                    w0Var5 = w0Var4;
                    str = str12;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 33:
                    w0Var4 = w0Var5;
                    str2 = (String) bVarA.E(hVar, 33, y1.a, str2);
                    i10 |= 2;
                    list = list2;
                    i2 = i11;
                    list3 = list6;
                    w0Var5 = w0Var4;
                    str = str12;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 34:
                    w0Var4 = w0Var5;
                    map2 = (Map) bVarA.E(hVar, 34, (wy1.a) hVarArr[34].getValue(), map2);
                    i10 |= 4;
                    list = list2;
                    i2 = i11;
                    list3 = list6;
                    w0Var5 = w0Var4;
                    str = str12;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 35:
                    w0Var4 = w0Var5;
                    list2 = (List) bVarA.E(hVar, 35, (wy1.a) hVarArr[35].getValue(), list2);
                    i10 |= 8;
                    list = list2;
                    i2 = i11;
                    list3 = list6;
                    w0Var5 = w0Var4;
                    str = str12;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 36:
                    w0Var4 = w0Var5;
                    bool2 = (Boolean) bVarA.E(hVar, 36, az1.g.a, bool2);
                    i10 |= 16;
                    list = list2;
                    i2 = i11;
                    list3 = list6;
                    w0Var5 = w0Var4;
                    str = str12;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 37:
                    w0Var4 = w0Var5;
                    fVar = (f) bVarA.E(hVar, 37, d.a, fVar);
                    i10 |= 32;
                    list = list2;
                    i2 = i11;
                    list3 = list6;
                    w0Var5 = w0Var4;
                    str = str12;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 38:
                    w0Var4 = w0Var5;
                    cVar = (c) bVarA.E(hVar, 38, a.a, cVar);
                    i10 |= 64;
                    list = list2;
                    i2 = i11;
                    list3 = list6;
                    w0Var5 = w0Var4;
                    str = str12;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 39:
                    zB9 = bVarA.B(hVar, 39);
                    i10 |= 128;
                    list = list2;
                    i2 = i11;
                    list3 = list6;
                    str = str12;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                case 40:
                    w0Var4 = w0Var5;
                    str4 = (String) bVarA.E(hVar, 40, y1.a, str4);
                    i10 |= 256;
                    list = list2;
                    i2 = i11;
                    list3 = list6;
                    w0Var5 = w0Var4;
                    str = str12;
                    map = map2;
                    map2 = map;
                    str12 = str;
                    list2 = list;
                    i11 = i2;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        List list7 = list3;
        w0 w0Var7 = w0Var5;
        String str15 = str5;
        String str16 = str6;
        int i27 = i11;
        String str17 = str12;
        Map map3 = map2;
        bVarA.b(hVar);
        return new w(i27, i10, strA, str15, str16, j0Var, j0Var2, str7, str8, str9, str10, str11, kVar, l0Var, l0Var2, nVar, str17, zB, zB2, str13, d0Var, zB3, zB4, list4, list5, list7, w0Var7, zB5, zB6, zB7, zB8, bool, vVar, str3, k1Var, str2, map3, list2, bool2, fVar, cVar, zB9, str4);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        w wVar = (w) obj;
        lmjxuqdtp.jvm.internal.o.h(wVar, "value");
        String str = wVar.O;
        boolean z = wVar.N;
        c cVar = wVar.M;
        f fVar = wVar.L;
        Boolean bool = wVar.K;
        List list = wVar.J;
        Map map = wVar.I;
        String str2 = wVar.H;
        k1 k1Var = wVar.G;
        String str3 = wVar.F;
        v vVar = wVar.E;
        Boolean bool2 = wVar.D;
        boolean z2 = wVar.C;
        boolean z3 = wVar.B;
        boolean z4 = wVar.A;
        boolean z5 = wVar.z;
        w0 w0Var = wVar.y;
        List list2 = wVar.x;
        List list3 = wVar.w;
        List list4 = wVar.v;
        boolean z6 = wVar.u;
        boolean z7 = wVar.t;
        d0 d0Var = wVar.s;
        String str4 = wVar.r;
        boolean z8 = wVar.q;
        boolean z9 = wVar.p;
        String str5 = wVar.o;
        m10.n nVar = wVar.n;
        l0 l0Var = wVar.m;
        l0 l0Var2 = wVar.l;
        k kVar = wVar.k;
        String str6 = wVar.f88j;
        String str7 = wVar.i;
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        lx1.h[] hVarArr = w.Q;
        String str8 = wVar.a;
        String str9 = wVar.h;
        String str10 = wVar.g;
        String str11 = wVar.f87f;
        j0 j0Var = wVar.e;
        j0 j0Var2 = wVar.d;
        String str12 = wVar.c;
        un0.m mVar = mVarA;
        mVar.d0(hVar, 0, str8);
        y1 y1Var = y1.a;
        mVar.p(hVar, 1, y1Var, wVar.b);
        if (mVar.g(hVar) || str12 != null) {
            mVar.p(hVar, 2, y1Var, str12);
        }
        if (mVar.g(hVar) || j0Var2 != null) {
            mVar.p(hVar, 3, m10.h0.a, j0Var2);
        }
        if (mVar.g(hVar) || j0Var != null) {
            mVar.p(hVar, 4, m10.h0.a, j0Var);
        }
        if (mVar.g(hVar) || str11 != null) {
            mVar.p(hVar, 5, y1Var, str11);
        }
        if (mVar.g(hVar) || str10 != null) {
            mVar.p(hVar, 6, y1Var, str10);
        }
        if (mVar.g(hVar) || str9 != null) {
            mVar.p(hVar, 7, y1Var, str9);
        }
        if (mVar.g(hVar) || str7 != null) {
            mVar.p(hVar, 8, y1Var, str7);
        }
        if (mVar.g(hVar) || str6 != null) {
            mVar.p(hVar, 9, y1Var, str6);
        }
        if (mVar.g(hVar) || kVar != null) {
            mVar.p(hVar, 10, (wy1.a) hVarArr[10].getValue(), kVar);
        }
        if (mVar.g(hVar) || l0Var2 != null) {
            mVar.p(hVar, 11, (wy1.a) hVarArr[11].getValue(), l0Var2);
        }
        if (mVar.g(hVar) || l0Var != null) {
            mVar.p(hVar, 12, (wy1.a) hVarArr[12].getValue(), l0Var);
        }
        if (mVar.g(hVar) || nVar != null) {
            mVar.p(hVar, 13, (wy1.a) hVarArr[13].getValue(), nVar);
        }
        if (mVar.g(hVar) || str5 != null) {
            mVar.p(hVar, 14, y1Var, str5);
        }
        if (mVar.g(hVar) || z9) {
            mVar.U(hVar, 15, z9);
        }
        if (mVar.g(hVar) || z8) {
            mVar.U(hVar, 16, z8);
        }
        if (mVar.g(hVar) || str4 != null) {
            mVar.p(hVar, 17, y1Var, str4);
        }
        if (mVar.g(hVar) || d0Var != null) {
            mVar.p(hVar, 18, b0.a, d0Var);
        }
        if (mVar.g(hVar) || z7) {
            mVar.U(hVar, 19, z7);
        }
        if (mVar.g(hVar) || z6) {
            mVar.U(hVar, 20, z6);
        }
        if (mVar.g(hVar) || list4 != null) {
            mVar.p(hVar, 21, (wy1.a) hVarArr[21].getValue(), list4);
        }
        if (mVar.g(hVar) || list3 != null) {
            mVar.p(hVar, 22, (wy1.a) hVarArr[22].getValue(), list3);
        }
        if (mVar.g(hVar) || list2 != null) {
            mVar.p(hVar, 23, (wy1.a) hVarArr[23].getValue(), list2);
        }
        if (mVar.g(hVar) || w0Var != null) {
            mVar.p(hVar, 24, u0.a, w0Var);
        }
        if (mVar.g(hVar) || z5) {
            mVar.U(hVar, 25, z5);
        }
        if (mVar.g(hVar) || z4) {
            mVar.U(hVar, 26, z4);
        }
        if (mVar.g(hVar) || z3) {
            mVar.U(hVar, 27, z3);
        }
        if (mVar.g(hVar) || z2) {
            mVar.U(hVar, 28, z2);
        }
        if (mVar.g(hVar) || bool2 != null) {
            mVar.p(hVar, 29, az1.g.a, bool2);
        }
        if (mVar.g(hVar) || vVar != null) {
            mVar.p(hVar, 30, t.a, vVar);
        }
        if (mVar.g(hVar) || str3 != null) {
            mVar.p(hVar, 31, y1Var, str3);
        }
        if (mVar.g(hVar) || k1Var != null) {
            mVar.p(hVar, 32, i1.a, k1Var);
        }
        if (mVar.g(hVar) || str2 != null) {
            mVar.p(hVar, 33, y1Var, str2);
        }
        if (mVar.g(hVar) || map != null) {
            mVar.p(hVar, 34, (wy1.a) hVarArr[34].getValue(), map);
        }
        if (mVar.g(hVar) || list != null) {
            mVar.p(hVar, 35, (wy1.a) hVarArr[35].getValue(), list);
        }
        if (mVar.g(hVar) || bool != null) {
            mVar.p(hVar, 36, az1.g.a, bool);
        }
        if (mVar.g(hVar) || fVar != null) {
            mVar.p(hVar, 37, d.a, fVar);
        }
        if (mVar.g(hVar) || cVar != null) {
            mVar.p(hVar, 38, a.a, cVar);
        }
        if (mVar.g(hVar) || z) {
            mVar.U(hVar, 39, z);
        }
        if (mVar.g(hVar) || str != null) {
            mVar.p(hVar, 40, y1Var, str);
        }
        mVarA.b(hVar);
    }
}
