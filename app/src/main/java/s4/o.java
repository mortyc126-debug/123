package s4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o extends t3.o {
    public final int a = l1.f(this);
    public t3.o b;

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q0(n nVar) {
        t3.o node = nVar.getNode();
        if (node != nVar) {
            t3.o oVar = nVar instanceof t3.o ? (t3.o) nVar : null;
            t3.o parent$ui_release = oVar != null ? oVar.getParent$ui_release() : null;
            if (node != getNode() || !lmjxuqdtp.jvm.internal.o.c(parent$ui_release, this)) {
                throw new IllegalStateException("Cannot delegate to an already delegated node");
            }
            return;
        }
        if (node.isAttached()) {
            p4.a.b("Cannot delegate to an already attached node");
        }
        node.setAsDelegateTo$ui_release(getNode());
        int kindSet$ui_release = getKindSet$ui_release();
        int iG = l1.g(node);
        node.setKindSet$ui_release(iG);
        int kindSet$ui_release2 = getKindSet$ui_release();
        int i = iG & 2;
        if (i != 0 && (kindSet$ui_release2 & 2) != 0 && !(this instanceof a0)) {
            p4.a.b("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + node);
        }
        node.setChild$ui_release(this.b);
        this.b = node;
        node.setParent$ui_release(this);
        S0(iG | getKindSet$ui_release(), false);
        if (isAttached()) {
            if (i == 0 || (kindSet$ui_release & 2) != 0) {
                updateCoordinator$ui_release(getCoordinator$ui_release());
            } else {
                dl.c cVar = g.u(this).E;
                getNode().updateCoordinator$ui_release((k1) null);
                cVar.t();
            }
            node.markAsAttached$ui_release();
            node.runAttachLifecycle$ui_release();
            l1.a(node);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R0(n nVar) {
        t3.o oVar = null;
        for (t3.o child$ui_release = this.b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            if (child$ui_release == nVar) {
                if (child$ui_release.isAttached()) {
                    q1.f0 f0Var = l1.a;
                    if (!child$ui_release.isAttached()) {
                        p4.a.b("autoInvalidateRemovedNode called on unattached node");
                    }
                    l1.b(child$ui_release, -1, 2);
                    child$ui_release.runDetachLifecycle$ui_release();
                    child$ui_release.markAsDetached$ui_release();
                }
                child$ui_release.setAsDelegateTo$ui_release(child$ui_release);
                child$ui_release.setAggregateChildKindSet$ui_release(0);
                if (oVar == null) {
                    this.b = child$ui_release.getChild$ui_release();
                } else {
                    oVar.setChild$ui_release(child$ui_release.getChild$ui_release());
                }
                child$ui_release.setChild$ui_release((t3.o) null);
                child$ui_release.setParent$ui_release((t3.o) null);
                int kindSet$ui_release = getKindSet$ui_release();
                int iG = l1.g(this);
                S0(iG, true);
                if (isAttached() && (kindSet$ui_release & 2) != 0 && (iG & 2) == 0) {
                    dl.c cVar = g.u(this).E;
                    getNode().updateCoordinator$ui_release((k1) null);
                    cVar.t();
                    return;
                }
                return;
            }
            oVar = child$ui_release;
        }
        throw new IllegalStateException(("Could not find delegate: " + nVar).toString());
    }

    public final void S0(int i, boolean z) {
        t3.o child$ui_release;
        int kindSet$ui_release = getKindSet$ui_release();
        setKindSet$ui_release(i);
        if (kindSet$ui_release != i) {
            if (getNode() == this) {
                setAggregateChildKindSet$ui_release(i);
            }
            if (isAttached()) {
                t3.o node = getNode();
                t3.o parent$ui_release = this;
                while (parent$ui_release != null) {
                    i |= parent$ui_release.getKindSet$ui_release();
                    parent$ui_release.setKindSet$ui_release(i);
                    if (parent$ui_release == node) {
                        break;
                    } else {
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                if (z && parent$ui_release == node) {
                    i = l1.g(node);
                    node.setKindSet$ui_release(i);
                }
                int aggregateChildKindSet$ui_release = i | ((parent$ui_release == null || (child$ui_release = parent$ui_release.getChild$ui_release()) == null) ? 0 : child$ui_release.getAggregateChildKindSet$ui_release());
                while (parent$ui_release != null) {
                    aggregateChildKindSet$ui_release |= parent$ui_release.getKindSet$ui_release();
                    parent$ui_release.setAggregateChildKindSet$ui_release(aggregateChildKindSet$ui_release);
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
        }
    }

    public final void markAsAttached$ui_release() {
        super.markAsAttached$ui_release();
        for (t3.o child$ui_release = this.b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            child$ui_release.updateCoordinator$ui_release(getCoordinator$ui_release());
            if (!child$ui_release.isAttached()) {
                child$ui_release.markAsAttached$ui_release();
            }
        }
    }

    public final void markAsDetached$ui_release() {
        for (t3.o child$ui_release = this.b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            child$ui_release.markAsDetached$ui_release();
        }
        super.markAsDetached$ui_release();
    }

    public final void reset$ui_release() {
        super.reset$ui_release();
        for (t3.o child$ui_release = this.b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            child$ui_release.reset$ui_release();
        }
    }

    public final void runAttachLifecycle$ui_release() {
        for (t3.o child$ui_release = this.b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            child$ui_release.runAttachLifecycle$ui_release();
        }
        super.runAttachLifecycle$ui_release();
    }

    public final void runDetachLifecycle$ui_release() {
        super.runDetachLifecycle$ui_release();
        for (t3.o child$ui_release = this.b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            child$ui_release.runDetachLifecycle$ui_release();
        }
    }

    public final void setAsDelegateTo$ui_release(t3.o oVar) {
        super.setAsDelegateTo$ui_release(oVar);
        for (t3.o child$ui_release = this.b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            child$ui_release.setAsDelegateTo$ui_release(oVar);
        }
    }

    public final void updateCoordinator$ui_release(k1 k1Var) {
        super.updateCoordinator$ui_release(k1Var);
        for (t3.o child$ui_release = this.b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            child$ui_release.updateCoordinator$ui_release(k1Var);
        }
    }
}
