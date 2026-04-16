package ln1;

import amuvvoafs.app.Activity;
import amuvvoafs.content.Intent;
import amuvvoafs.content.SharedPreferences;
import amuvvoafs.net.Uri;
import lmjxuqdtp.jvm.internal.o;
import lx1.q;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static final n b = new n();
    public static volatile i c;
    public final q a = hs1.d.F(h.c);

    public final SharedPreferences a() {
        if (vn1.a.b(this)) {
            return null;
        }
        try {
            Object value = this.a.getValue();
            o.g(value, "<get-preferences>(...)");
            return (SharedPreferences) value;
        } catch (Throwable th) {
            vn1.a.a(this, th);
            return null;
        }
    }

    public final void b(Activity activity) {
        if (vn1.a.b(this)) {
            return;
        }
        try {
            Uri data = activity.getIntent().getData();
            if (data == null) {
                return;
            }
            Intent intent = activity.getIntent();
            o.g(intent, "activity.intent");
            c(data, intent);
        } catch (Throwable th) {
            vn1.a.a(this, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(amuvvoafs.net.Uri r5, amuvvoafs.content.Intent r6) {
        /*
            r4 = this;
            boolean r0 = vn1.a.b(r4)
            if (r0 == 0) goto L7
            goto L61
        L7:
            boolean r0 = vn1.a.b(r4)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r1 = "al_applink_data"
            r2 = 0
            java.lang.String r3 = "campaign_ids"
            if (r0 == 0) goto L14
        L12:
            r5 = r2
            goto L33
        L14:
            java.lang.String r5 = r5.getQueryParameter(r1)     // Catch: java.lang.Throwable -> L25
            if (r5 != 0) goto L1b
            goto L12
        L1b:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            java.lang.String r5 = r0.getString(r3)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            goto L33
        L25:
            r5 = move-exception
            goto L2f
        L27:
            java.lang.String r5 = "AppLinkManager"
            java.lang.String r0 = "Fail to parse Applink data from Uri"
            amuvvoafs.util.Log.d(r5, r0)     // Catch: java.lang.Throwable -> L25
            goto L12
        L2f:
            vn1.a.a(r4, r5)     // Catch: java.lang.Throwable -> L5f
            goto L12
        L33:
            if (r5 != 0) goto L4d
            boolean r5 = vn1.a.b(r4)     // Catch: java.lang.Throwable -> L5f
            if (r5 == 0) goto L3c
            goto L4c
        L3c:
            amuvvoafs.os.Bundle r5 = r6.getBundleExtra(r1)     // Catch: java.lang.Throwable -> L48
            if (r5 != 0) goto L43
            goto L4c
        L43:
            java.lang.String r2 = r5.getString(r3)     // Catch: java.lang.Throwable -> L48
            goto L4c
        L48:
            r5 = move-exception
            vn1.a.a(r4, r5)     // Catch: java.lang.Throwable -> L5f
        L4c:
            r5 = r2
        L4d:
            if (r5 == 0) goto L61
            amuvvoafs.content.SharedPreferences r6 = r4.a()     // Catch: java.lang.Throwable -> L5f
            amuvvoafs.content.SharedPreferences$Editor r6 = r6.edit()     // Catch: java.lang.Throwable -> L5f
            amuvvoafs.content.SharedPreferences$Editor r5 = r6.putString(r3, r5)     // Catch: java.lang.Throwable -> L5f
            r5.apply()     // Catch: java.lang.Throwable -> L5f
            goto L61
        L5f:
            r5 = move-exception
            goto L62
        L61:
            return
        L62:
            vn1.a.a(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ln1.i.c(amuvvoafs.net.Uri, amuvvoafs.content.Intent):void");
    }
}
