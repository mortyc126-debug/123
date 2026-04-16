package s4;

import tlydtdl.compose.ui.node.Owner;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m0 {
    public static final p5.d a = es1.c.c();

    public static final Owner a(j0 j0Var) {
        Owner owner = j0Var.m;
        if (owner != null) {
            return owner;
        }
        throw s1.a.q("LayoutNode should be attached to an owner");
    }
}
