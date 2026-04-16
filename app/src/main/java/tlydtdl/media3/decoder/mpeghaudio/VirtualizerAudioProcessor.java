package tlydtdl.media3.decoder.mpeghaudio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import l8.l0;
import m8.f;
import m8.g;
import o8.b;
import o8.o;
import tlydtdl.media3.common.audio.AudioProcessor$UnhandledAudioFormatException;
import tlydtdl.media3.decoder.mpeghaudio.CoefConfigFile;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class VirtualizerAudioProcessor implements g, MpeghPseudoFlushInterface {
    private static final int BUFFER_SIZE_PER_FRAME = 4096;
    private static final int INPUT_BUFFER_SIZE_PER_FRAME = 57344;
    private static final int INPUT_CHANNEL_COUNT = 14;
    private static final o LOADER;
    private static final int OUTPUT_BUFFER_SIZE = 81920;
    private static final int OUTPUT_BUFFER_SIZE_PER_FRAME = 8192;
    private static final int OUTPUT_CHANNEL_COUNT = 2;
    private static final int SAMPLES_PER_FLAME = 1024;
    private static final String TAG = "Virtualizer";
    private String appRootPath;
    private String configFilePathCp;
    private String configFilePathHrtf;
    private boolean initialized;
    private f inputAudioFormat;
    private boolean inputEnded;
    private LocalBuffer localBuffer;
    private long nativeHandler;
    private f outputAudioFormat;
    private ByteBuffer tempFloatBuffer;

    /* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
    public static class LocalBuffer {
        private static int SIA_VIR_FRAME_END = 2;
        private static int SIA_VIR_FRAME_MIDDLE = 0;
        private static int SIA_VIR_FRAME_START = 1;
        private f audioFormat;
        public int streamStatus;
        public int validSample;
        public int[] zero_snd_flags;
        private boolean isFirstSample = true;
        private boolean isLastData = false;
        public ByteBuffer buffer = ByteBuffer.allocateDirect(VirtualizerAudioProcessor.INPUT_BUFFER_SIZE_PER_FRAME).order(ByteOrder.nativeOrder());
        public ByteBuffer processedBuffer = ByteBuffer.allocateDirect(8192).order(ByteOrder.nativeOrder());

        /* JADX INFO: Access modifiers changed from: private */
        public void appendSampleData(ByteBuffer byteBuffer) {
            int iPosition = byteBuffer.position();
            int iLimit = byteBuffer.limit();
            if (byteBuffer.hasRemaining()) {
                int iRemaining = byteBuffer.remaining();
                int iRemaining2 = this.buffer.remaining();
                if (iRemaining2 < iRemaining) {
                    iRemaining = iRemaining2;
                }
                byteBuffer.limit(iPosition + iRemaining);
                this.buffer.put(byteBuffer);
                byteBuffer.limit(iLimit);
            }
        }

        private boolean isFullData() {
            return !this.buffer.hasRemaining();
        }

        private boolean isLastData() {
            return this.isLastData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isNeedProc() {
            return isLastData() || isFullData();
        }

        private void writePadding(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining() / 4;
            for (int i = 0; i < iRemaining; i++) {
                byteBuffer.putFloat(0.0f);
            }
        }

        public void clear() {
            this.buffer.clear();
            this.processedBuffer.clear();
            for (int i = 0; i < this.audioFormat.b; i++) {
                this.zero_snd_flags[i] = 0;
            }
        }

        public void doPrepareSingleVirtualizerProc() {
            this.validSample = 1024;
            this.streamStatus = SIA_VIR_FRAME_MIDDLE;
            if (this.isLastData) {
                this.streamStatus = SIA_VIR_FRAME_END;
                this.isLastData = false;
                setFirstTime();
                if (!isFullData()) {
                    this.validSample = 1024 - (this.buffer.remaining() / this.audioFormat.d);
                    writePadding(this.buffer);
                }
            } else if (this.isFirstSample) {
                this.streamStatus = SIA_VIR_FRAME_START;
                this.isFirstSample = false;
            }
            this.buffer.flip();
            this.processedBuffer.clear();
        }

        public void setAudioFormat(f fVar) {
            f fVar2 = this.audioFormat;
            if (fVar2 != null && fVar2.a == fVar.a && fVar2.b == fVar.b && fVar2.c == fVar.c) {
                return;
            }
            this.audioFormat = fVar;
            this.zero_snd_flags = new int[fVar.b];
            clear();
        }

        public void setFirstTime() {
            this.isFirstSample = true;
        }

        public void setLastData() {
            this.isLastData = true;
        }
    }

    static {
        l0.a("media3.decoder.virtualizer");
        LOADER = new o("mpeghaudio") { // from class: tlydtdl.media3.decoder.mpeghaudio.VirtualizerAudioProcessor.1
            public void loadLibrary(String str) {
                System.loadLibrary(str);
            }
        };
    }

    public VirtualizerAudioProcessor(String str) {
        b.l(TAG, "constructor()");
        isAvailable();
        f fVar = f.e;
        this.inputAudioFormat = fVar;
        this.outputAudioFormat = fVar;
        this.nativeHandler = 0L;
        this.initialized = false;
        this.appRootPath = str;
        CoefConfigFile coefConfigFile = new CoefConfigFile(str);
        this.configFilePathHrtf = coefConfigFile.getRelativeConfigFilePath(CoefConfigFile.CoefType.Hrtf13);
        this.configFilePathCp = coefConfigFile.getRelativeConfigFilePath(CoefConfigFile.CoefType.Cp);
        this.localBuffer = new LocalBuffer();
    }

    private native long VirtualizerInitialize(String str, String str2, String str3);

    private native boolean VirtualizerProc(long j2, int i, int i2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int[] iArr);

    private native void VirtualizerRelease(long j2);

    private native long VirtualizerReset(long j2);

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
        this.localBuffer.setAudioFormat(this.inputAudioFormat);
        this.localBuffer.appendSampleData(byteBuffer);
        return this.localBuffer.isNeedProc();
    }

    private boolean haveOutputDataThatCanGenerateFrame() {
        this.tempFloatBuffer.flip();
        return this.tempFloatBuffer.hasRemaining();
    }

    public static boolean isAvailable() {
        boolean zIsAvailable = LOADER.isAvailable();
        if (!zIsAvailable) {
            b.l(TAG, "isAvailable() == false");
        }
        return zIsAvailable;
    }

    private long nativeInitialize() {
        long jVirtualizerInitialize = VirtualizerInitialize(this.appRootPath, this.configFilePathHrtf, this.configFilePathCp);
        if (0 == jVirtualizerInitialize) {
            b.m(TAG, "VirtualizerInitialize() Error");
        }
        return jVirtualizerInitialize;
    }

    private void nativeProcFrame(ByteBuffer byteBuffer) {
        this.localBuffer.doPrepareSingleVirtualizerProc();
        long j2 = this.nativeHandler;
        LocalBuffer localBuffer = this.localBuffer;
        if (VirtualizerProc(j2, localBuffer.streamStatus, localBuffer.validSample, localBuffer.processedBuffer, localBuffer.buffer, localBuffer.zero_snd_flags)) {
            this.localBuffer.processedBuffer.position(0);
            this.localBuffer.processedBuffer.limit(8192);
            this.tempFloatBuffer.clear();
            this.tempFloatBuffer.put(this.localBuffer.processedBuffer);
        } else {
            b.m(TAG, "VirtualizerProc() called input_size:" + this.localBuffer.validSample);
        }
        this.localBuffer.clear();
    }

    private void nativeRelease() {
        VirtualizerRelease(this.nativeHandler);
    }

    private void nativeReset() {
        VirtualizerReset(this.nativeHandler);
    }

    private f onConfigure(f fVar) {
        this.localBuffer.setAudioFormat(fVar);
        this.tempFloatBuffer = ByteBuffer.allocateDirect(OUTPUT_BUFFER_SIZE).order(ByteOrder.nativeOrder());
        f fVar2 = this.inputAudioFormat;
        return new f(fVar2.a, 2, fVar2.c);
    }

    private void onFlush() {
        VirtualizerReset(this.nativeHandler);
        this.localBuffer.clear();
        this.localBuffer.setFirstTime();
    }

    private ByteBuffer onGetOutput() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(this.tempFloatBuffer.remaining()).order(ByteOrder.nativeOrder());
        byteBufferOrder.put(this.tempFloatBuffer);
        byteBufferOrder.flip();
        this.tempFloatBuffer.clear();
        return byteBufferOrder;
    }

    private void onReset() {
    }

    private void prepareNative(f fVar) throws AudioProcessor$UnhandledAudioFormatException {
        if (this.nativeHandler != 0) {
            nativeReset();
        }
        long jNativeInitialize = nativeInitialize();
        this.nativeHandler = jNativeInitialize;
        if (jNativeInitialize == 0) {
            throw new AudioProcessor$UnhandledAudioFormatException(fVar);
        }
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

    public void endOfCodec() {
        this.localBuffer.setLastData();
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

    public void onQueueEndOfStream() {
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
