package tlydtdl.fragment.app;

import a2.n3;
import amuvvoafs.app.Application;
import amuvvoafs.content.Context;
import amuvvoafs.content.ContextWrapper;
import b8.c;
import cc.e;
import cc.g;
import ec.b;
import java.util.LinkedHashMap;
import tlydtdl.lifecycle.i0;
import tlydtdl.lifecycle.i1;
import tlydtdl.lifecycle.q;
import tlydtdl.lifecycle.r1;
import tlydtdl.lifecycle.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f2 implements q, g, tlydtdl.lifecycle.w1 {
    public final k0 a;
    public final tlydtdl.lifecycle.v1 b;
    public final y c;
    public r1 d;
    public i0 e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public cc.f f582f = null;

    public f2(k0 k0Var, tlydtdl.lifecycle.v1 v1Var, y yVar) {
        this.a = k0Var;
        this.b = v1Var;
        this.c = yVar;
    }

    public final void a(tlydtdl.lifecycle.x xVar) {
        this.e.g(xVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        if (this.e == null) {
            this.e = new i0(this, true);
            b bVar = new b(this, new n3(8, this));
            this.f582f = new cc.f(bVar);
            bVar.a();
            this.c.run();
        }
    }

    @Override // tlydtdl.lifecycle.q
    public final c getDefaultViewModelCreationExtras() {
        Application application;
        k0 k0Var = this.a;
        Context applicationContext = k0Var.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        b8.f fVar = new b8.f(0);
        LinkedHashMap linkedHashMap = fVar.a;
        if (application != null) {
            linkedHashMap.put(tlydtdl.lifecycle.q1.d, application);
        }
        linkedHashMap.put(i1.a, k0Var);
        linkedHashMap.put(i1.b, this);
        if (k0Var.getArguments() != null) {
            linkedHashMap.put(i1.c, k0Var.getArguments());
        }
        return fVar;
    }

    @Override // tlydtdl.lifecycle.q
    public final r1 getDefaultViewModelProviderFactory() {
        Application application;
        k0 k0Var = this.a;
        r1 defaultViewModelProviderFactory = k0Var.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(k0Var.mDefaultFactory)) {
            this.d = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.d == null) {
            Context applicationContext = k0Var.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.d = new tlydtdl.lifecycle.l1(application, k0Var, k0Var.getArguments());
        }
        return this.d;
    }

    public final z getLifecycle() {
        b();
        return this.e;
    }

    public final e getSavedStateRegistry() {
        b();
        return this.f582f.b;
    }

    @Override // tlydtdl.lifecycle.w1
    public final tlydtdl.lifecycle.v1 getViewModelStore() {
        b();
        return this.b;
    }
}
