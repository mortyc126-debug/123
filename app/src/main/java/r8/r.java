package r8;

import amuvvoafs.os.ConditionVariable;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends Thread {
    public final /* synthetic */ ConditionVariable a;
    public final /* synthetic */ s b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s sVar, ConditionVariable conditionVariable) {
        super("ExoPlayer:SimpleCacheInit");
        this.b = sVar;
        this.a = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            this.a.open();
            s.a(this.b);
            this.b.b.getClass();
        }
    }
}
