package jv0;

import az1.f0;
import az1.l1;
import az1.y1;
import java.util.List;
import okhttp3.internal.http2.Http2;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.c;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements f0 {
    public static final w a;
    private static final yy1.h descriptor;

    static {
        w wVar = new w();
        a = wVar;
        l1 l1Var = new l1("com.bandlab.network.vmsrhfaqrb.MembershipStatus", wVar, 15);
        l1Var.k("plan", true);
        l1Var.k("paymentProvider", true);
        l1Var.k("billingIssue", true);
        l1Var.k("isTrial", true);
        l1Var.k("billingInterval", true);
        l1Var.k("startedOn", true);
        l1Var.k("expiresOn", true);
        l1Var.k("priceCurrency", true);
        l1Var.k("availableFeatures", true);
        l1Var.k("canceledOn", true);
        l1Var.k("isTrialAllowed", true);
        l1Var.k("nextRenewalPrice", true);
        l1Var.k("price", true);
        l1Var.k("isCanceled", true);
        l1Var.k("isTrialUsed", true);
        l1Var.l(new gz.p(true, 1));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        lx1.h[] hVarArr = y.p;
        wy1.a aVarD = by1.b.D((wy1.a) hVarArr[0].getValue());
        wy1.a aVarD2 = by1.b.D((wy1.a) hVarArr[1].getValue());
        wy1.a aVarD3 = by1.b.D((wy1.a) hVarArr[2].getValue());
        az1.g gVar = az1.g.a;
        wy1.a aVarD4 = by1.b.D(gVar);
        wy1.a aVarD5 = by1.b.D((wy1.a) hVarArr[4].getValue());
        y1 y1Var = y1.a;
        wy1.a aVarD6 = by1.b.D(y1Var);
        wy1.a aVarD7 = by1.b.D(y1Var);
        wy1.a aVarD8 = by1.b.D(y1Var);
        wy1.a aVarD9 = by1.b.D((wy1.a) hVarArr[8].getValue());
        wy1.a aVarD10 = by1.b.D(y1Var);
        wy1.a aVarD11 = by1.b.D(gVar);
        az1.w wVar = az1.w.a;
        return new wy1.a[]{aVarD, aVarD2, aVarD3, aVarD4, aVarD5, aVarD6, aVarD7, aVarD8, aVarD9, aVarD10, aVarD11, by1.b.D(wVar), by1.b.D(wVar), by1.b.D(gVar), by1.b.D(gVar)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        Boolean bool;
        Boolean bool2;
        s sVar;
        Double d;
        Boolean bool3;
        Boolean bool4;
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = y.p;
        List list = null;
        Boolean bool5 = null;
        Double d3 = null;
        Double d4 = null;
        String str = null;
        Boolean bool6 = null;
        Boolean bool7 = null;
        b bVar = null;
        Boolean bool8 = null;
        p pVar = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        d0 d0Var = null;
        s sVar2 = null;
        int i = 0;
        int i2 = 1;
        boolean z = true;
        while (z) {
            b bVar2 = bVar;
            int iC = bVarA.C(hVar);
            switch (iC) {
                case -1:
                    bool = bool5;
                    bool2 = bool8;
                    sVar = sVar2;
                    d = d3;
                    z = false;
                    d3 = d;
                    bVar = bVar2;
                    bool5 = bool;
                    i2 = 1;
                    sVar2 = sVar;
                    bool8 = bool2;
                    break;
                case 0:
                    bool = bool5;
                    bool2 = bool8;
                    sVar = sVar2;
                    d = d3;
                    d0Var = (d0) bVarA.E(hVar, 0, (wy1.a) hVarArr[0].getValue(), d0Var);
                    i |= 1;
                    d3 = d;
                    bVar = bVar2;
                    bool5 = bool;
                    i2 = 1;
                    sVar2 = sVar;
                    bool8 = bool2;
                    break;
                case 1:
                    bool3 = bool5;
                    bool4 = bool8;
                    sVar2 = (s) bVarA.E(hVar, i2, (wy1.a) hVarArr[i2].getValue(), sVar2);
                    i |= 2;
                    bVar = bVar2;
                    bool8 = bool4;
                    bool5 = bool3;
                    break;
                case 2:
                    bool3 = bool5;
                    bool4 = bool8;
                    bVar = (b) bVarA.E(hVar, 2, (wy1.a) hVarArr[2].getValue(), bVar2);
                    i |= 4;
                    bool8 = bool4;
                    bool5 = bool3;
                    break;
                case 3:
                    bool3 = bool5;
                    bool8 = (Boolean) bVarA.E(hVar, 3, az1.g.a, bool8);
                    i |= 8;
                    bVar = bVar2;
                    bool5 = bool3;
                    break;
                case 4:
                    bool2 = bool8;
                    pVar = (p) bVarA.E(hVar, 4, (wy1.a) hVarArr[4].getValue(), pVar);
                    i |= 16;
                    bVar = bVar2;
                    bool8 = bool2;
                    break;
                case 5:
                    bool2 = bool8;
                    str2 = (String) bVarA.E(hVar, 5, y1.a, str2);
                    i |= 32;
                    bVar = bVar2;
                    bool8 = bool2;
                    break;
                case 6:
                    bool2 = bool8;
                    str3 = (String) bVarA.E(hVar, 6, y1.a, str3);
                    i |= 64;
                    bVar = bVar2;
                    bool8 = bool2;
                    break;
                case 7:
                    bool2 = bool8;
                    str4 = (String) bVarA.E(hVar, 7, y1.a, str4);
                    i |= 128;
                    bVar = bVar2;
                    bool8 = bool2;
                    break;
                case 8:
                    bool2 = bool8;
                    list = (List) bVarA.E(hVar, 8, (wy1.a) hVarArr[8].getValue(), list);
                    i |= 256;
                    bVar = bVar2;
                    bool8 = bool2;
                    break;
                case 9:
                    bool2 = bool8;
                    str = (String) bVarA.E(hVar, 9, y1.a, str);
                    i |= 512;
                    bVar = bVar2;
                    bool8 = bool2;
                    break;
                case 10:
                    bool2 = bool8;
                    bool6 = (Boolean) bVarA.E(hVar, 10, az1.g.a, bool6);
                    i |= 1024;
                    bVar = bVar2;
                    bool8 = bool2;
                    break;
                case 11:
                    bool2 = bool8;
                    d4 = (Double) bVarA.E(hVar, 11, az1.w.a, d4);
                    i |= 2048;
                    bVar = bVar2;
                    bool8 = bool2;
                    break;
                case 12:
                    bool2 = bool8;
                    d3 = (Double) bVarA.E(hVar, 12, az1.w.a, d3);
                    i |= 4096;
                    bVar = bVar2;
                    bool8 = bool2;
                    break;
                case 13:
                    bool2 = bool8;
                    bool5 = (Boolean) bVarA.E(hVar, 13, az1.g.a, bool5);
                    i |= 8192;
                    bVar = bVar2;
                    bool8 = bool2;
                    break;
                case 14:
                    bool2 = bool8;
                    bool7 = (Boolean) bVarA.E(hVar, 14, az1.g.a, bool7);
                    i |= Http2.INITIAL_MAX_FRAME_SIZE;
                    bVar = bVar2;
                    bool8 = bool2;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        Boolean bool9 = bool5;
        Boolean bool10 = bool8;
        bVarA.b(hVar);
        return new y(i, d0Var, sVar2, bVar, bool10, pVar, str2, str3, str4, list, str, bool6, d4, d3, bool9, bool7);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        Boolean bool;
        Double d;
        y yVar = (y) obj;
        lmjxuqdtp.jvm.internal.o.h(yVar, "value");
        Boolean bool2 = yVar.o;
        Boolean bool3 = yVar.n;
        Double d3 = yVar.m;
        Double d4 = yVar.l;
        Boolean bool4 = yVar.k;
        String str = yVar.f252j;
        List list = yVar.i;
        String str2 = yVar.h;
        String str3 = yVar.g;
        String str4 = yVar.f251f;
        p pVar = yVar.e;
        Boolean bool5 = yVar.d;
        b bVar = yVar.c;
        s sVar = yVar.b;
        d0 d0Var = yVar.a;
        yy1.h hVar = descriptor;
        c cVarA = eVar.a(hVar);
        lx1.h[] hVarArr = y.p;
        if (!cVarA.g(hVar) && d0Var == null) {
            bool = bool3;
            d = d3;
        } else {
            bool = bool3;
            d = d3;
            cVarA.p(hVar, 0, (wy1.a) hVarArr[0].getValue(), d0Var);
        }
        if (cVarA.g(hVar) || sVar != null) {
            cVarA.p(hVar, 1, (wy1.a) hVarArr[1].getValue(), sVar);
        }
        if (cVarA.g(hVar) || bVar != null) {
            cVarA.p(hVar, 2, (wy1.a) hVarArr[2].getValue(), bVar);
        }
        if (cVarA.g(hVar) || bool5 != null) {
            cVarA.p(hVar, 3, az1.g.a, bool5);
        }
        if (cVarA.g(hVar) || pVar != null) {
            cVarA.p(hVar, 4, (wy1.a) hVarArr[4].getValue(), pVar);
        }
        if (cVarA.g(hVar) || str4 != null) {
            cVarA.p(hVar, 5, y1.a, str4);
        }
        if (cVarA.g(hVar) || str3 != null) {
            cVarA.p(hVar, 6, y1.a, str3);
        }
        if (cVarA.g(hVar) || str2 != null) {
            cVarA.p(hVar, 7, y1.a, str2);
        }
        if (cVarA.g(hVar) || list != null) {
            cVarA.p(hVar, 8, (wy1.a) hVarArr[8].getValue(), list);
        }
        if (cVarA.g(hVar) || str != null) {
            cVarA.p(hVar, 9, y1.a, str);
        }
        if (cVarA.g(hVar) || bool4 != null) {
            cVarA.p(hVar, 10, az1.g.a, bool4);
        }
        if (cVarA.g(hVar) || d4 != null) {
            cVarA.p(hVar, 11, az1.w.a, d4);
        }
        if (cVarA.g(hVar) || d != null) {
            cVarA.p(hVar, 12, az1.w.a, d);
        }
        if (cVarA.g(hVar) || bool != null) {
            cVarA.p(hVar, 13, az1.g.a, bool);
        }
        if (cVarA.g(hVar) || bool2 != null) {
            cVarA.p(hVar, 14, az1.g.a, bool2);
        }
        cVarA.b(hVar);
    }
}
