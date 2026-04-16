package tlydtdl.lifecycle;

import com.gnacba.amuvvoafs.gms.internal.ads.cy;
import java.util.concurrent.atomic.AtomicReference;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class u1 {
    public static final kd.h b = new kd.h(6);
    public final Object a;

    public u1() {
        this.a = new AtomicReference(null);
    }

    public u1(v1 v1Var, r1 r1Var, b8.c cVar) {
        o.h(v1Var, "store");
        o.h(r1Var, "factory");
        o.h(cVar, "defaultCreationExtras");
        this.a = new cy(v1Var, r1Var, cVar);
    }

    public u1(z0 z0Var) {
        this.a = z0Var;
    }
}
