package kb;

import amuvvoafs.os.Build;
import amuvvoafs.window.OnBackInvokedCallback;
import amuvvoafs.window.OnBackInvokedDispatcher;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q extends i {
    public final OnBackInvokedDispatcher c;
    public final int d;
    public final OnBackInvokedCallback e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f260f;

    public q(OnBackInvokedDispatcher onBackInvokedDispatcher, int i) {
        OnBackInvokedCallback pVar;
        this.c = onBackInvokedDispatcher;
        this.d = i;
        if (Build.VERSION.SDK_INT == 33) {
            final int i2 = 0;
            pVar = new OnBackInvokedCallback() { // from class: kb.o
                public final void onBackInvoked() {
                    switch (i2) {
                        case 0:
                            ((q) this).b();
                            break;
                        default:
                            Function0 function0 = (Function0) this;
                            if (function0 != null) {
                                function0.invoke();
                            }
                            break;
                    }
                }
            };
        } else {
            pVar = new p(this);
        }
        this.e = pVar;
    }

    @Override // kb.i
    public final void c(boolean z) {
        if (z && !this.f260f) {
            this.c.registerOnBackInvokedCallback(this.d, this.e);
            this.f260f = true;
        } else {
            if (z || !this.f260f) {
                return;
            }
            this.c.unregisterOnBackInvokedCallback(this.e);
            this.f260f = false;
        }
    }
}
