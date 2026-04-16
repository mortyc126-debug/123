package fz0;

import java.util.regex.Pattern;
import ny1.r2;
import o10.a4;
import okhttp3.HttpUrl;
import oz0.d1;
import zs.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public final wz0.y a;
    public final mt.d b;
    public final vk1.d c;
    public final zs.h0 d;
    public final n0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final xu0.p f147f;
    public final i11.t g;
    public final boolean h;
    public final r2 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final wz0.z f148j;
    public final wz0.n0 k;

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public l(wz0.y r29, mt.d r30, vk1.d r31, zs.h0 r32, zs.n0 r33, xu0.p r34, i11.t r35) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fz0.l.<init>(wz0.y, mt.d, vk1.d, zs.h0, zs.n0, xu0.p, i11.t):void");
    }

    public final String a() {
        String string;
        if (!this.h) {
            String str = b().f378f;
            return str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str;
        }
        String str2 = b().f378f;
        if (str2 != null) {
            Pattern patternCompile = Pattern.compile("^(https?://\\S+|www\\.\\S+|\\b\\S+\\.\\S{2,})|(https?://\\S+|www\\.\\S+|\\b\\S+\\.\\S{2,})$");
            lmjxuqdtp.jvm.internal.o.g(patternCompile, "compile(...)");
            String strReplaceFirst = patternCompile.matcher(str2).replaceFirst(HttpUrl.FRAGMENT_ENCODE_SET);
            lmjxuqdtp.jvm.internal.o.g(strReplaceFirst, "replaceFirst(...)");
            string = hy1.q.o1(strReplaceFirst).toString();
        } else {
            string = null;
        }
        return string == null ? HttpUrl.FRAGMENT_ENCODE_SET : string;
    }

    public final d1 b() {
        return this.a.a.a;
    }

    public final boolean c() {
        if (!((Boolean) this.g.c(bt.g.a)).booleanValue()) {
            return false;
        }
        a4 a4Var = this.a.e;
        return a4Var == a4.F || a4Var == a4.G || a4Var == a4.n;
    }

    public final boolean d() {
        return x30.c.H(b()) == wz0.e.c;
    }
}
