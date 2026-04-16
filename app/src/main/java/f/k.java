package f;

import amuvvoafs.os.Looper;
import amuvvoafs.os.SystemClock;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewTreeObserver;
import com.ironsource.environment.thread.a;
import tlydtdl.activity.ComponentActivity;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements j, ViewTreeObserver.OnDrawListener, Runnable {
    public final long a = SystemClock.uptimeMillis() + ((long) 10000);
    public Runnable b;
    public boolean c;
    public final /* synthetic */ ComponentActivity d;

    public k(ComponentActivity componentActivity) {
        this.d = componentActivity;
    }

    public final void a(View view) {
        if (this.c) {
            return;
        }
        this.c = true;
        view.getViewTreeObserver().addOnDrawListener(this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        lmjxuqdtp.jvm.internal.o.h(runnable, "runnable");
        this.b = runnable;
        View decorView = this.d.getWindow().getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView, "getDecorView(...)");
        if (!this.c) {
            decorView.postOnAnimation(new a(1, this));
        } else if (lmjxuqdtp.jvm.internal.o.c(Looper.myLooper(), Looper.getMainLooper())) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    public final void onDraw() {
        Runnable runnable = this.b;
        ComponentActivity componentActivity = this.d;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.a) {
                this.c = false;
                componentActivity.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.b = null;
        if (componentActivity.getFullyDrawnReporter().b()) {
            this.c = false;
            componentActivity.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
