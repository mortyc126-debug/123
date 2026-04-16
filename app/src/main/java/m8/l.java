package m8;

import com.gnacba.amuvvoafs.gms.internal.ads.m20;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import o8.f0;
import okhttp3.internal.ws.RealWebSocket;
import tlydtdl.media3.common.audio.AudioProcessor$UnhandledAudioFormatException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements g {
    public final boolean b;
    public int c;
    public float d = 1.0f;
    public float e = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f325f;
    public f g;
    public f h;
    public f i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f326j;
    public m20 k;
    public ByteBuffer l;
    public ShortBuffer m;
    public ByteBuffer n;
    public long o;
    public long p;
    public boolean q;

    public l(boolean z) {
        f fVar = f.e;
        this.f325f = fVar;
        this.g = fVar;
        this.h = fVar;
        this.i = fVar;
        ByteBuffer byteBuffer = g.a;
        this.l = byteBuffer;
        this.m = byteBuffer.asShortBuffer();
        this.n = byteBuffer;
        this.c = -1;
        this.b = z;
    }

    @Override // m8.g
    public final f configure(f fVar) throws AudioProcessor$UnhandledAudioFormatException {
        if (fVar.c != 2) {
            throw new AudioProcessor$UnhandledAudioFormatException(fVar);
        }
        int i = this.c;
        if (i == -1) {
            i = fVar.a;
        }
        this.f325f = fVar;
        f fVar2 = new f(i, fVar.b, 2);
        this.g = fVar2;
        this.f326j = true;
        return fVar2;
    }

    @Override // m8.g
    public final void flush() {
        if (isActive()) {
            f fVar = this.f325f;
            this.h = fVar;
            f fVar2 = this.g;
            this.i = fVar2;
            if (this.f326j) {
                this.k = new m20(fVar.a, fVar.b, this.d, this.e, fVar2.a, 1);
            } else {
                m20 m20Var = this.k;
                if (m20Var != null) {
                    m20Var.e();
                }
            }
        }
        this.n = g.a;
        this.o = 0L;
        this.p = 0L;
        this.q = false;
    }

    @Override // m8.g
    public final long getDurationAfterProcessorApplied(long j2) {
        if (this.p < RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            return (long) (j2 / ((double) this.d));
        }
        long j3 = this.o;
        m20 m20Var = this.k;
        m20Var.getClass();
        long jH = j3 - ((long) m20Var.h());
        int i = this.i.a;
        int i2 = this.h.a;
        return i == i2 ? f0.b0(j2, this.p, jH, RoundingMode.DOWN) : f0.b0(j2, this.p * ((long) i2), jH * ((long) i), RoundingMode.DOWN);
    }

    @Override // m8.g
    public final ByteBuffer getOutput() {
        int iG;
        m20 m20Var = this.k;
        if (m20Var != null && (iG = m20Var.g()) > 0) {
            if (this.l.capacity() < iG) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iG).order(ByteOrder.nativeOrder());
                this.l = byteBufferOrder;
                this.m = byteBufferOrder.asShortBuffer();
            } else {
                this.l.clear();
                this.m.clear();
            }
            m20Var.f(this.m);
            this.p += (long) iG;
            this.l.limit(iG);
            this.n = this.l;
        }
        ByteBuffer byteBuffer = this.n;
        this.n = g.a;
        return byteBuffer;
    }

    @Override // m8.g
    public final boolean isActive() {
        if (this.g.a != -1) {
            return this.b || Math.abs(this.d - 1.0f) >= 1.0E-4f || Math.abs(this.e - 1.0f) >= 1.0E-4f || this.g.a != this.f325f.a;
        }
        return false;
    }

    @Override // m8.g
    public final boolean isEnded() {
        if (!this.q) {
            return false;
        }
        m20 m20Var = this.k;
        return m20Var == null || m20Var.g() == 0;
    }

    @Override // m8.g
    public final void queueEndOfStream() {
        m20 m20Var = this.k;
        if (m20Var != null) {
            m20Var.k();
        }
        this.q = true;
    }

    @Override // m8.g
    public final void queueInput(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            m20 m20Var = this.k;
            m20Var.getClass();
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.o += (long) iRemaining;
            m20Var.l(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // m8.g
    public final void reset() {
        this.d = 1.0f;
        this.e = 1.0f;
        f fVar = f.e;
        this.f325f = fVar;
        this.g = fVar;
        this.h = fVar;
        this.i = fVar;
        ByteBuffer byteBuffer = g.a;
        this.l = byteBuffer;
        this.m = byteBuffer.asShortBuffer();
        this.n = byteBuffer;
        this.c = -1;
        this.f326j = false;
        this.k = null;
        this.o = 0L;
        this.p = 0L;
        this.q = false;
    }
}
