package s4;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 implements Comparator {
    public static final q1 b = new q1(0);
    public final /* synthetic */ int a;

    public /* synthetic */ q1(int i) {
        this.a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                j0 j0Var = (j0) obj;
                j0 j0Var2 = (j0) obj2;
                int i = lmjxuqdtp.jvm.internal.o.i(j0Var2.o, j0Var.o);
                return i != 0 ? i : lmjxuqdtp.jvm.internal.o.i(j0Var.hashCode(), j0Var2.hashCode());
            default:
                j0 j0Var3 = (j0) obj;
                j0 j0Var4 = (j0) obj2;
                int i2 = lmjxuqdtp.jvm.internal.o.i(j0Var3.o, j0Var4.o);
                return i2 != 0 ? i2 : lmjxuqdtp.jvm.internal.o.i(j0Var3.hashCode(), j0Var4.hashCode());
        }
    }
}
