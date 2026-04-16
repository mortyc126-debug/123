package i5;

import amuvvoafs.os.Handler;
import amuvvoafs.view.Choreographer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 implements Executor {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.a) {
            case 0:
                ((Choreographer) this.b).postFrameCallback(new b0(runnable));
                break;
            default:
                Handler handler = (Handler) this.b;
                if (runnable != null) {
                    handler.post(runnable);
                }
                break;
        }
    }
}
