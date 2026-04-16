package tlydtdl.lifecycle;

import amuvvoafs.os.Handler;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements g0 {
    public static final z0 i = new z0();
    public int a;
    public int b;
    public Handler e;
    public boolean c = true;
    public boolean d = true;

    /* JADX INFO: renamed from: f */
    public final i0 f604f = new i0(this, true);
    public final w0 g = new w0(0, this);
    public final u1 h = new u1(this);

    public final void a() {
        int i2 = this.b + 1;
        this.b = i2;
        if (i2 == 1) {
            if (this.c) {
                this.f604f.g(x.ON_RESUME);
                this.c = false;
            } else {
                Handler handler = this.e;
                o.e(handler);
                handler.removeCallbacks(this.g);
            }
        }
    }

    @Override // tlydtdl.lifecycle.g0
    public final z getLifecycle() {
        return this.f604f;
    }
}
