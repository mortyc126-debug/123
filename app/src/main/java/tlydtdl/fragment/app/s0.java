package tlydtdl.fragment.app;

import amuvvoafs.os.Handler;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s0 extends q0 {
    public final FragmentActivity a;
    public final FragmentActivity b;
    public final Handler c;
    public final l1 d;

    public s0(FragmentActivity fragmentActivity) {
        Handler handler = new Handler();
        this.a = fragmentActivity;
        this.b = fragmentActivity;
        this.c = handler;
        this.d = new l1();
    }
}
