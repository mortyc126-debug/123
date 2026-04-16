package m8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i implements g {
    public f b;
    public f c;
    public f d;
    public f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ByteBuffer f324f;
    public ByteBuffer g;
    public boolean h;

    public i() {
        ByteBuffer byteBuffer = g.a;
        this.f324f = byteBuffer;
        this.g = byteBuffer;
        f fVar = f.e;
        this.d = fVar;
        this.e = fVar;
        this.b = fVar;
        this.c = fVar;
    }

    public abstract f a(f fVar);

    public void b() {
    }

    public void c() {
    }

    @Override // m8.g
    public final f configure(f fVar) {
        this.d = fVar;
        this.e = a(fVar);
        return isActive() ? this.e : f.e;
    }

    public void d() {
    }

    public final ByteBuffer e(int i) {
        if (this.f324f.capacity() < i) {
            this.f324f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f324f.clear();
        }
        ByteBuffer byteBuffer = this.f324f;
        this.g = byteBuffer;
        return byteBuffer;
    }

    @Override // m8.g
    public final void flush() {
        this.g = g.a;
        this.h = false;
        this.b = this.d;
        this.c = this.e;
        b();
    }

    @Override // m8.g
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.g;
        this.g = g.a;
        return byteBuffer;
    }

    @Override // m8.g
    public boolean isActive() {
        return this.e != f.e;
    }

    @Override // m8.g
    public boolean isEnded() {
        return this.h && this.g == g.a;
    }

    @Override // m8.g
    public final void queueEndOfStream() {
        this.h = true;
        c();
    }

    @Override // m8.g
    public final void reset() {
        flush();
        this.f324f = g.a;
        f fVar = f.e;
        this.d = fVar;
        this.e = fVar;
        this.b = fVar;
        this.c = fVar;
        d();
    }
}
