package ln1;

import amuvvoafs.content.Context;
import com.facebook.internal.g0;
import com.facebook.s;
import com.gnacba.amuvvoafs.gms.internal.ads.ui1;
import l9.y;
import lmjxuqdtp.jvm.internal.o;
import pt1.q;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(Context context, String str, long j2) {
        this.b = j2;
        this.c = str;
        this.d = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ui1 ui1Var;
        switch (this.a) {
            case 0:
                long j2 = this.b;
                String str = this.c;
                Context context = (Context) this.d;
                ui1 ui1Var2 = d.g;
                Long l = ui1Var2 != null ? (Long) ui1Var2.c : null;
                if (d.g == null) {
                    d.g = new ui1(Long.valueOf(j2), (Long) null);
                    String str2 = d.i;
                    o.g(context, "appContext");
                    n.b(context, str, str2);
                } else if (l != null) {
                    long jLongValue = j2 - l.longValue();
                    String str3 = d.a;
                    if (jLongValue > (g0.b(s.b()) == null ? 60 : r4.b) * 1000) {
                        n.d(str, d.g, d.i);
                        String str4 = d.i;
                        o.g(context, "appContext");
                        n.b(context, str, str4);
                        d.g = new ui1(Long.valueOf(j2), (Long) null);
                    } else if (jLongValue > 1000 && (ui1Var = d.g) != null) {
                        ui1Var.a++;
                    }
                }
                ui1 ui1Var3 = d.g;
                if (ui1Var3 != null) {
                    ui1Var3.c = Long.valueOf(j2);
                }
                ui1 ui1Var4 = d.g;
                if (ui1Var4 != null) {
                    ui1Var4.b();
                }
                break;
            default:
                q qVar = (q) this.d;
                qVar.p.b.a(new y(qVar, this.b, this.c));
                break;
        }
    }

    public /* synthetic */ a(q qVar, long j2, String str) {
        this.d = qVar;
        this.b = j2;
        this.c = str;
    }
}
