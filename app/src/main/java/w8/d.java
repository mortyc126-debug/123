package w8;

import amuvvoafs.content.Context;
import j9.g;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements xs1.m {
    public final /* synthetic */ int a;
    public final /* synthetic */ Context b;

    public /* synthetic */ d(Context context, int i) {
        this.a = i;
        this.b = context;
    }

    public final Object get() {
        g gVar;
        switch (this.a) {
            case 0:
                return m8.d.C(this.b);
            case 1:
                return new i9.r(this.b);
            case 2:
                Context context = this.b;
                com.gnacba.common.collect.f1 f1Var = g.p;
                synchronized (g.class) {
                    try {
                        if (g.v == null) {
                            Context applicationContext = context == null ? null : context.getApplicationContext();
                            HashMap map = new HashMap(8);
                            map.put(0, 1000000L);
                            map.put(2, -9223372036854775807L);
                            map.put(3, -9223372036854775807L);
                            map.put(4, -9223372036854775807L);
                            map.put(5, -9223372036854775807L);
                            map.put(10, -9223372036854775807L);
                            map.put(9, -9223372036854775807L);
                            map.put(7, -9223372036854775807L);
                            g.v = new g(applicationContext, map);
                        }
                        gVar = g.v;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return gVar;
            case 3:
                return new k(this.b);
            case 4:
                return new k(this.b);
            default:
                return new f9.p(this.b, new n9.j());
        }
    }
}
