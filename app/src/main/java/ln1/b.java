package ln1;

import amuvvoafs.content.Context;
import amuvvoafs.content.SharedPreferences;
import amuvvoafs.os.Bundle;
import amuvvoafs.preference.PreferenceManager;
import com.facebook.appevents.m;
import com.facebook.i0;
import com.facebook.internal.d0;
import com.facebook.internal.g0;
import com.facebook.s;
import com.gnacba.amuvvoafs.gms.internal.ads.ui1;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public /* synthetic */ b(int i, long j2, String str) {
        this.a = i;
        this.b = j2;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        long j2 = this.b;
        switch (i) {
            case 0:
                String str = this.c;
                if (d.g == null) {
                    d.g = new ui1(Long.valueOf(j2), (Long) null);
                }
                ui1 ui1Var = d.g;
                if (ui1Var != null) {
                    ui1Var.c = Long.valueOf(j2);
                }
                int i2 = 1;
                if (d.f321f.get() <= 0) {
                    b bVar = new b(i2, j2, str);
                    synchronized (d.e) {
                        d.d = d.b.schedule(bVar, g0.b(s.b()) == null ? 60 : r8.b, TimeUnit.SECONDS);
                    }
                }
                long j3 = d.f322j;
                long j4 = j3 > 0 ? (j2 - j3) / ((long) 1000) : 0L;
                ru1.c cVar = k.a;
                Context contextA = s.a();
                d0 d0VarK = g0.k(s.b(), false);
                if (d0VarK != null && d0VarK.e && j4 > 0) {
                    m mVar = new m(contextA, (String) null);
                    Bundle bundle = new Bundle(1);
                    bundle.putCharSequence("fb_aa_time_spent_view_name", str);
                    double d = j4;
                    if (i0.c() && !vn1.a.b(mVar)) {
                        try {
                            m.f(mVar, "fb_aa_time_spent_on_view", Double.valueOf(d), bundle, false, d.b());
                        } catch (Throwable th) {
                            vn1.a.a(mVar, th);
                        }
                    }
                    break;
                }
                ui1 ui1Var2 = d.g;
                if (ui1Var2 != null) {
                    ui1Var2.b();
                    return;
                }
                return;
            default:
                String str2 = this.c;
                if (d.g == null) {
                    d.g = new ui1(Long.valueOf(j2), (Long) null);
                }
                if (d.f321f.get() <= 0) {
                    n.d(str2, d.g, d.i);
                    SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(s.a()).edit();
                    editorEdit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
                    editorEdit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
                    editorEdit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
                    editorEdit.remove("com.facebook.appevents.SessionInfo.sessionId");
                    editorEdit.apply();
                    SharedPreferences.Editor editorEdit2 = PreferenceManager.getDefaultSharedPreferences(s.a()).edit();
                    editorEdit2.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
                    editorEdit2.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
                    editorEdit2.apply();
                    d.g = null;
                }
                synchronized (d.e) {
                    d.d = null;
                }
                return;
        }
    }
}
