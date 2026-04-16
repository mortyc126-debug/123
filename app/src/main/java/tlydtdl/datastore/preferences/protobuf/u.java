package tlydtdl.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u implements Cloneable {
    public final w a;
    public w b;

    public u(w wVar) {
        this.a = wVar;
        if (wVar.g()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.b = wVar.i();
    }

    public final w a() {
        w wVarC = c();
        wVarC.getClass();
        if (w.f(wVarC, true)) {
            return wVarC;
        }
        throw new UninitializedMessageException();
    }

    public final w c() {
        if (!this.b.g()) {
            return this.b;
        }
        w wVar = this.b;
        wVar.getClass();
        r0 r0Var = r0.c;
        r0Var.getClass();
        r0Var.a(wVar.getClass()).b(wVar);
        wVar.h();
        return this.b;
    }

    public final Object clone() {
        u uVar = (u) this.a.c(5);
        uVar.b = c();
        return uVar;
    }

    public final void d() {
        if (this.b.g()) {
            return;
        }
        w wVarI = this.a.i();
        w wVar = this.b;
        r0 r0Var = r0.c;
        r0Var.getClass();
        r0Var.a(wVarI.getClass()).a(wVarI, wVar);
        this.b = wVarI;
    }
}
