package tlydtdl.media3.decoder.mpeghaudio;

import java.nio.ByteBuffer;
import l8.l0;
import m8.f;
import m8.g;
import o8.b;
import o8.o;
import tlydtdl.media3.common.audio.AudioProcessor$UnhandledAudioFormatException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class AlcAudioProcessor implements g, MpeghPseudoFlushInterface {
    private static final int BUFFER_SIZE_PER_FRAME = 4096;
    private static final int INPUT_BUFFER_SIZE_PER_FRAME = 8192;
    private static final int INPUT_CHANNEL_COUNT = 2;
    private static final o LOADER;
    private static final int OUTPUT_BUFFER_SIZE = 81920;
    private static final int OUTPUT_BUFFER_SIZE_PER_FRAME = 8192;
    private static final int OUTPUT_CHANNEL_COUNT = 2;
    private static final int SAMPLES_PER_FLAME = 1024;
    private static final String TAG = "Alc";
    private boolean initialized;
    private f inputAudioFormat;
    private boolean inputEnded;
    private LocalOutputBufferQueue localOutputBufferQueue;
    private long nativeHandler;
    private f outputAudioFormat;

    static {
        l0.a("media3.decoder.alc");
        LOADER = new o("mpeghaudio") { // from class: tlydtdl.media3.decoder.mpeghaudio.AlcAudioProcessor.1
            public void loadLibrary(String str) {
                System.loadLibrary(str);
            }
        };
    }

    public AlcAudioProcessor() {
        b.l(TAG, "constructor()");
        isAvailable();
        f fVar = f.e;
        this.inputAudioFormat = fVar;
        this.outputAudioFormat = fVar;
        this.nativeHandler = 0L;
        this.initialized = false;
    }

    private native long AlcInitialize();

    private native boolean AlcProcFrame(long j2, int i, ByteBuffer byteBuffer, int i2);

    private native void AlcRelease(long j2);

    private boolean canSkipConfigure(f fVar) {
        if (this.initialized) {
            f fVar2 = this.inputAudioFormat;
            if (fVar2.a == fVar.a && fVar2.b == fVar.b && fVar2.c == fVar.c) {
                return true;
            }
        }
        return false;
    }

    private boolean haveInputDataThatCanGenerateFrame(ByteBuffer byteBuffer) {
        return byteBuffer.hasRemaining();
    }

    private boolean haveOutputDataThatCanGenerateFrame() {
        return true;
    }

    public static boolean isAvailable() {
        boolean zIsAvailable = LOADER.isAvailable();
        if (!zIsAvailable) {
            b.l(TAG, "isAvailable() == false");
        }
        return zIsAvailable;
    }

    private long nativeInitialize() {
        long jAlcInitialize = AlcInitialize();
        if (0 == jAlcInitialize) {
            b.m(TAG, "AlcInitialize() Error");
        }
        return jAlcInitialize;
    }

    private void nativeProcFrame(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        if (AlcProcFrame(this.nativeHandler, 0, byteBuffer, byteBuffer.limit())) {
            byteBuffer.position(0);
            byteBuffer.limit(iLimit);
            this.localOutputBufferQueue.enqueue(byteBuffer);
        }
    }

    private void nativeRelease() {
        AlcRelease(this.nativeHandler);
    }

    private void nativeReset() {
        AlcRelease(this.nativeHandler);
    }

    private f onConfigure(f fVar) {
        this.localOutputBufferQueue = new LocalOutputBufferQueue(OUTPUT_BUFFER_SIZE);
        return fVar;
    }

    private void onFlush() {
        this.localOutputBufferQueue.reset();
    }

    private ByteBuffer onGetOutput() {
        return this.localOutputBufferQueue.getOutputBuffer();
    }

    private void onQueueEndOfStream() {
    }

    private void onReset() {
        onFlush();
    }

    public static void setLibraries(String... strArr) {
        LOADER.setLibraries(strArr);
    }

    @Override // m8.g
    public synchronized f configure(f fVar) throws AudioProcessor$UnhandledAudioFormatException {
        if (canSkipConfigure(fVar)) {
            return this.outputAudioFormat;
        }
        b.l(TAG, "configure() :" + fVar.toString());
        if (fVar.c != 4) {
            throw new AudioProcessor$UnhandledAudioFormatException(fVar);
        }
        this.inputAudioFormat = fVar;
        this.outputAudioFormat = onConfigure(fVar);
        prepareNative(fVar);
        this.initialized = true;
        return this.outputAudioFormat;
    }

    @Override // tlydtdl.media3.decoder.mpeghaudio.MpeghPseudoFlushInterface
    public void flush(boolean z) {
        if (z) {
            b.l(TAG, "PseudoFlush()");
        } else {
            onFlush();
        }
        this.inputEnded = false;
    }

    @Override // m8.g
    public long getDurationAfterProcessorApplied(long j2) {
        return j2;
    }

    @Override // m8.g
    public ByteBuffer getOutput() {
        boolean z = this.initialized;
        ByteBuffer byteBuffer = g.a;
        if (z) {
            return !haveOutputDataThatCanGenerateFrame() ? byteBuffer : onGetOutput();
        }
        b.m(TAG, "getOutput Error not initialized");
        return byteBuffer;
    }

    @Override // m8.g
    public boolean isActive() {
        boolean z = this.nativeHandler != 0;
        if (!z) {
            b.l(TAG, "IaActive() == false");
        }
        return z;
    }

    @Override // m8.g
    public boolean isEnded() {
        if (this.inputEnded) {
            b.l(TAG, "isEnded() == true");
        }
        return this.inputEnded;
    }

    public void prepareNative(f fVar) throws AudioProcessor$UnhandledAudioFormatException {
        if (this.nativeHandler != 0) {
            nativeReset();
        }
        long jNativeInitialize = nativeInitialize();
        this.nativeHandler = jNativeInitialize;
        if (jNativeInitialize == 0) {
            throw new AudioProcessor$UnhandledAudioFormatException(fVar);
        }
    }

    @Override // m8.g
    public void queueEndOfStream() {
        if (!this.initialized) {
            b.m(TAG, "queueEndOfStream Error not initialized");
        } else {
            this.inputEnded = true;
            onQueueEndOfStream();
        }
    }

    @Override // m8.g
    public void queueInput(ByteBuffer byteBuffer) {
        if (!this.initialized) {
            b.m(TAG, "queueInput Error not initialized");
        } else if (haveInputDataThatCanGenerateFrame(byteBuffer)) {
            nativeProcFrame(byteBuffer);
        }
    }

    @Override // m8.g
    public synchronized void reset() {
        onReset();
        this.inputEnded = false;
        nativeRelease();
        this.initialized = false;
        this.nativeHandler = 0L;
    }

    @Override // m8.g
    public void flush() {
        onFlush();
        this.inputEnded = false;
    }
}
