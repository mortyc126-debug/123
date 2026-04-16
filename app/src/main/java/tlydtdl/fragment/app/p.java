package tlydtdl.fragment.app;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends k {
    public final Object b;
    public final boolean c;
    public final Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(j2 j2Var, boolean z, boolean z2) {
        super(j2Var);
        k0 k0Var = j2Var.c;
        this.b = j2Var.a == 2 ? z ? k0Var.getReenterTransition() : k0Var.getEnterTransition() : z ? k0Var.getReturnTransition() : k0Var.getExitTransition();
        this.c = j2Var.a == 2 ? z ? k0Var.getAllowReturnTransitionOverlap() : k0Var.getAllowEnterTransitionOverlap() : true;
        this.d = z2 ? z ? k0Var.getSharedElementReturnTransition() : k0Var.getSharedElementEnterTransition() : null;
    }

    public final e2 b() {
        Object obj = this.b;
        e2 e2VarC = c(obj);
        Object obj2 = this.d;
        e2 e2VarC2 = c(obj2);
        if (e2VarC == null || e2VarC2 == null || e2VarC == e2VarC2) {
            return e2VarC == null ? e2VarC2 : e2VarC;
        }
        throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.a.c + " returned Transition " + obj + " which uses a different Transition  type than its shared element transition " + obj2).toString());
    }

    public final e2 c(Object obj) {
        if (obj == null) {
            return null;
        }
        c2 c2Var = x1.a;
        if (c2Var.g(obj)) {
            return c2Var;
        }
        e2 e2Var = x1.b;
        if (e2Var != null && e2Var.g(obj)) {
            return e2Var;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.a.c + " is not a valid framework Transition or AndroidX Transition");
    }
}
