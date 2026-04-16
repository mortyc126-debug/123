package kb;

import amuvvoafs.window.BackEvent;
import amuvvoafs.window.OnBackAnimationCallback;
import ny1.r2;
import tlydtdl.core.app.h0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements OnBackAnimationCallback {
    public final /* synthetic */ q a;

    public p(q qVar) {
        this.a = qVar;
    }

    public final void onBackCancelled() {
        q qVar = this.a;
        c cVar = qVar.a;
        if (cVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (!qVar.b) {
            cVar.d(qVar, null);
        }
        j jVar = cVar.b;
        jVar.getClass();
        if (qVar.equals(jVar.h) && -1 == jVar.g) {
            e eVarC = jVar.f258f;
            if (eVarC == null) {
                eVarC = jVar.c(-1);
            }
            jVar.f258f = null;
            jVar.g = 0;
            jVar.h = null;
            k kVar = k.a;
            if (eVarC != null) {
                eVarC.d = kVar;
                eVarC.a();
            }
            r2 r2Var = jVar.a;
            r2Var.getClass();
            r2Var.i((Object) null, kVar);
        }
        qVar.b = false;
    }

    public final void onBackInvoked() {
        this.a.b();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        lmjxuqdtp.jvm.internal.o.h(backEvent, "backEvent");
        b bVarA = h0.a(backEvent);
        q qVar = this.a;
        c cVar = qVar.a;
        if (cVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (qVar.b) {
            j jVar = cVar.b;
            jVar.getClass();
            if (qVar.equals(jVar.h) && -1 == jVar.g) {
                e eVarC = jVar.f258f;
                if (eVarC == null) {
                    eVarC = jVar.c(-1);
                }
                if (eVarC != null) {
                    eVarC.d = new l(bVarA, -1);
                    eVarC.c(bVarA);
                }
                r2 r2Var = jVar.a;
                l lVar = new l(bVarA, -1);
                r2Var.getClass();
                r2Var.i((Object) null, lVar);
            }
        }
    }

    public final void onBackStarted(BackEvent backEvent) {
        lmjxuqdtp.jvm.internal.o.h(backEvent, "backEvent");
        b bVarA = h0.a(backEvent);
        q qVar = this.a;
        c cVar = qVar.a;
        if (cVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (qVar.b) {
            return;
        }
        cVar.d(qVar, bVarA);
        qVar.b = true;
    }
}
