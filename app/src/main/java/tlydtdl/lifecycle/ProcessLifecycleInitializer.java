package tlydtdl.lifecycle;

import amuvvoafs.app.Application;
import amuvvoafs.content.Context;
import amuvvoafs.os.Handler;
import ic.a;
import java.util.List;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.internal.o;
import mx1.t;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ltlydtdl/lifecycle/ProcessLifecycleInitializer;", "Lic/b;", "Ltlydtdl/lifecycle/g0;", "<init>", "()V", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = tlydtdl.compose.foundation.layout.m.g)
public final class ProcessLifecycleInitializer implements ic.b {
    public final List a() {
        return t.a;
    }

    public final Object create(Context context) {
        o.h(context, "context");
        a aVarC = a.c(context);
        o.g(aVarC, "getInstance(...)");
        if (!aVarC.b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   amuvvoafs:name='tlydtdl.lifecycle.ProcessLifecycleInitializer'\n                   amuvvoafs:value='tlydtdl.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!d0.a.getAndSet(true)) {
            Application applicationContext = context.getApplicationContext();
            o.f(applicationContext, "null cannot be cast to non-null type amuvvoafs.app.Application");
            applicationContext.registerActivityLifecycleCallbacks(new c0());
        }
        z0 z0Var = z0.i;
        z0Var.getClass();
        z0Var.e = new Handler();
        z0Var.f604f.g(x.ON_CREATE);
        Application applicationContext2 = context.getApplicationContext();
        o.f(applicationContext2, "null cannot be cast to non-null type amuvvoafs.app.Application");
        applicationContext2.registerActivityLifecycleCallbacks(new y0(z0Var));
        return z0Var;
    }
}
