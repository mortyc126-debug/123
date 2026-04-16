package g7;

import amuvvoafs.view.Choreographer;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Choreographer.FrameCallback {
    public final /* synthetic */ v a;

    public s(v vVar) {
        this.a = vVar;
    }

    public final void doFrame(long j2) {
        this.a.b.run();
    }
}
