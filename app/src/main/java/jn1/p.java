package jn1;

import amuvvoafs.content.Context;
import amuvvoafs.content.pm.ApplicationInfo;
import amuvvoafs.os.Bundle;
import com.facebook.appevents.r;
import com.facebook.internal.x;
import com.facebook.internal.z;
import com.facebook.s;
import hy1.q;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import ln1.e;
import lx1.l;
import vn1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public static String d;
    public static final p a = new p();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final ConcurrentHashMap c = new ConcurrentHashMap();
    public static final AtomicBoolean e = new AtomicBoolean(false);

    /* JADX WARN: Removed duplicated region for block: B:210:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00fe A[Catch: all -> 0x007b, TryCatch #1 {all -> 0x007b, blocks: (B:181:0x005f, B:183:0x0072, B:188:0x0088, B:191:0x0090, B:192:0x0099, B:194:0x009f, B:198:0x00cc, B:200:0x00d4, B:208:0x00f1, B:212:0x00fe, B:207:0x00ed, B:217:0x011b, B:218:0x0120, B:221:0x0130, B:223:0x0137, B:225:0x0144, B:229:0x015f, B:231:0x0167, B:232:0x016f, B:234:0x0177, B:243:0x01b6, B:237:0x018d, B:239:0x0195, B:240:0x019d, B:242:0x01a5, B:186:0x007e, B:246:0x01c2, B:247:0x01c9, B:249:0x01cf, B:251:0x01d7, B:255:0x01ef, B:256:0x01f4, B:258:0x01fa, B:260:0x0216, B:263:0x021e, B:265:0x0224, B:266:0x022c, B:267:0x0234, B:269:0x023a, B:270:0x0242, B:252:0x01e2, B:204:0x00e7), top: B:285:0x005f, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final synchronized amuvvoafs.os.Bundle c(java.util.List r25, long r26, boolean r28, java.util.List r29) {
        /*
            Method dump skipped, instruction units count: 603
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: jn1.p.c(java.util.List, long, boolean, java.util.List):amuvvoafs.os.Bundle");
    }

    public static final void d() {
        if (a.b(p.class)) {
            return;
        }
        try {
            if (e.get()) {
                int iA = a.a();
                int iK = z.p.k(iA);
                if (iK == 1) {
                    d.b(2);
                    return;
                }
                if (iK != 2) {
                    if (iK == 3 && z.b(x.y)) {
                        f.b(s.a(), iA);
                        return;
                    }
                    return;
                }
                if (z.b(x.x)) {
                    f.b(s.a(), iA);
                } else {
                    d.b(3);
                }
            }
        } catch (Throwable th) {
            a.a(p.class, th);
        }
    }

    public final int a() {
        if (a.b(this)) {
            return 0;
        }
        try {
            Context contextA = s.a();
            ApplicationInfo applicationInfo = contextA.getPackageManager().getApplicationInfo(contextA.getPackageName(), 128);
            lmjxuqdtp.jvm.internal.o.g(applicationInfo, "context.packageManager.g…TA_DATA\n                )");
            String string = applicationInfo.metaData.getString("com.gnacba.amuvvoafs.play.billingclient.version");
            if (string == null) {
                return 1;
            }
            List listY0 = q.Y0(string, new String[]{"."}, 3, 2);
            if (string.length() != 0) {
                String strConcat = "GPBL.".concat(string);
                if (!a.b(p.class)) {
                    try {
                        d = strConcat;
                    } catch (Throwable th) {
                        a.a(p.class, th);
                    }
                }
                Integer numV0 = hy1.x.v0((String) listY0.get(0));
                if (numV0 != null) {
                    int iIntValue = numV0.intValue();
                    if (iIntValue == 1) {
                        return 2;
                    }
                    return iIntValue < 5 ? 3 : 4;
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th2) {
            a.a(this, th2);
            return 0;
        }
        return 4;
    }

    public final String b(Bundle bundle, r rVar, Bundle bundle2, r rVar2, boolean z, boolean z2) {
        if (!a.b(this)) {
            try {
                List<l> listE = z2 ? m.e(z) : m.c(z);
                if (listE != null) {
                    for (l lVar : listE) {
                        Map map = r.b;
                        Object objV = e.v((String) lVar.a, bundle, rVar);
                        String str = objV instanceof String ? (String) objV : null;
                        if (str != null && str.length() != 0) {
                            for (String str2 : (List) lVar.b) {
                                Map map2 = r.b;
                                Object objV2 = e.v(str2, bundle2, rVar2);
                                String str3 = objV2 instanceof String ? (String) objV2 : null;
                                if (str3 != null && str3.length() != 0 && str3.equals(str)) {
                                    return z ? (String) lVar.a : str2;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                a.a(this, th);
                return null;
            }
        }
        return null;
    }
}
