package tlydtdl.emoji2.text;

import amuvvoafs.content.Context;
import aq1.c;
import ic.a;
import ic.b;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import q7.e;
import q7.i;
import q7.j;
import q7.r;
import tlydtdl.lifecycle.ProcessLifecycleInitializer;
import tlydtdl.lifecycle.g0;
import tlydtdl.lifecycle.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements b {
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    public final Object create(Context context) {
        Object objB;
        r rVar = new r(new c(context, 12));
        ((e) rVar).a = 1;
        if (i.k == null) {
            synchronized (i.j) {
                try {
                    if (i.k == null) {
                        i.k = new i(rVar);
                    }
                } finally {
                }
            }
        }
        a aVarC = a.c(context);
        aVarC.getClass();
        synchronized (a.e) {
            try {
                objB = aVarC.a.get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = aVarC.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        z lifecycle = ((g0) objB).getLifecycle();
        lifecycle.a(new j(this, lifecycle));
        return Boolean.TRUE;
    }
}
