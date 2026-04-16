package ne0;

import amuvvoafs.content.Context;
import amuvvoafs.os.Bundle;
import bb.e0;
import bb.f0;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import ke0.m;
import lmjxuqdtp.jvm.functions.Function0;
import m2.i2;
import ny1.r2;
import ny1.z;
import okhttp3.HttpUrl;
import st.w0;
import xu1.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public final x a;
    public final Object b;
    public final r2 c;
    public final LinkedHashMap d;
    public final r2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r2 f345f;
    public final r2 g;
    public final n30.k h;
    public final g i;

    public h(final Context context, x xVar) {
        this.a = xVar;
        final int i = 0;
        this.b = hs1.d.E(lx1.j.b, new Function0() { // from class: ne0.f
            public final Object invoke() {
                switch (i) {
                    case 0:
                        return f0.d(context);
                    case 1:
                        return com.braze.managers.x.a(context);
                    case 2:
                        File fileO = uz1.g.o(context, "firebaseSessions/sessionConfigsDataStore.data");
                        o.c(fileO);
                        return fileO;
                    default:
                        File fileO2 = uz1.g.o(context, "firebaseSessions/sessionDataStore.data");
                        o.c(fileO2);
                        return fileO2;
                }
            }
        });
        r2 r2VarC = z.c(mx1.t.a);
        this.c = r2VarC;
        this.d = new LinkedHashMap();
        r2 r2VarC2 = z.c(new m((ke0.j) null));
        this.e = r2VarC2;
        this.f345f = r2VarC;
        this.g = r2VarC2;
        this.h = w0.o0(r2VarC2, new i2(18));
        this.i = new g(this);
    }

    public static void c(String str) {
        i.A("CastDeviceManager:: ", str, s02.d.a);
    }

    public static ke0.j e(e0 e0Var) {
        int i = e0Var.n;
        ke0.o oVar = i != 1 ? i != 2 ? ke0.o.a : ke0.o.c : ke0.o.b;
        String str = e0Var.d;
        lmjxuqdtp.jvm.internal.o.g(str, "getName(...)");
        String str2 = e0Var.c;
        lmjxuqdtp.jvm.internal.o.g(str2, "getId(...)");
        String str3 = e0Var.e;
        if (str3 == null) {
            str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return new ke0.j(str, str3, str2, oVar);
    }

    public final void a(e0 e0Var) {
        r2 r2Var;
        Object value;
        Collection collectionS0;
        String str = e0Var.c;
        this.d.put(str, e0Var);
        ke0.j jVarE = e(e0Var);
        do {
            r2Var = this.c;
            value = r2Var.getValue();
            collectionS0 = (List) value;
            if (collectionS0 == null || !collectionS0.isEmpty()) {
                Iterator it = collectionS0.iterator();
                while (it.hasNext()) {
                    if (lmjxuqdtp.jvm.internal.o.c(((ke0.j) it.next()).c, str)) {
                        break;
                    }
                }
                collectionS0 = mx1.o.S0(collectionS0, jVarE);
            } else {
                collectionS0 = mx1.o.S0(collectionS0, jVarE);
            }
        } while (!r2Var.d(value, collectionS0));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, lx1.h] */
    public final f0 b() {
        return (f0) this.b.getValue();
    }

    public final void d(boolean z) {
        int i = z ? 1 : 4;
        c("Starting search…");
        ArrayList arrayList = new ArrayList();
        if (!arrayList.contains("amuvvoafs.media.intent.category.REMOTE_PLAYBACK")) {
            arrayList.add("amuvvoafs.media.intent.category.REMOTE_PLAYBACK");
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("controlCategories", arrayList);
        bb.x xVar = new bb.x(bundle, arrayList);
        c("Adding initial routes…");
        b().getClass();
        f0.b();
        for (e0 e0Var : f0.c().j) {
            if (e0Var.e(xVar)) {
                a(e0Var);
            }
        }
        b().getClass();
        f0.b();
        e0 e0VarF = f0.c().f();
        lmjxuqdtp.jvm.internal.o.g(e0VarF, "getSelectedRoute(...)");
        if (e0VarF.e(xVar)) {
            ke0.j jVarE = e(e0VarF);
            r2 r2Var = this.e;
            if (z) {
                m mVar = new m(jVarE);
                r2Var.getClass();
                r2Var.i((Object) null, mVar);
            } else {
                ke0.k kVar = new ke0.k(jVarE);
                r2Var.getClass();
                r2Var.i((Object) null, kVar);
            }
        }
        b().a(xVar, this.i, i);
    }
}
