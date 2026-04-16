package tlydtdl.work;

import amuvvoafs.content.Context;
import cd.x;
import cd.z;
import dd.t;
import dd.v;
import ic.b;
import java.util.Collections;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkManagerInitializer implements b {
    public static final String a = x.g("WrkMgrInitializer");

    public final List a() {
        return Collections.EMPTY_LIST;
    }

    public final Object create(Context context) {
        x.e().a(a, "Initializing WorkManager with default configuration.");
        cd.b bVar = new cd.b(new z());
        o.h(context, "context");
        synchronized (t.p) {
            try {
                t tVar = t.n;
                if (tVar != null && t.o != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (tVar == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (t.o == null) {
                        t.o = v.q(applicationContext, bVar);
                    }
                    t.n = t.o;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t.P(context);
    }
}
