/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

import linker.resourcer.encoder.DownloadForegroundService;

public final class DownloadForegroundService$$ExternalSyntheticLambda0
implements Runnable {
    public final DownloadForegroundService f$0;
    public final String f$1;
    public final String f$2;
    public final String f$3;

    public /* synthetic */ DownloadForegroundService$$ExternalSyntheticLambda0(DownloadForegroundService downloadForegroundService, String string2, String string3, String string4) {
        this.f$0 = downloadForegroundService;
        this.f$1 = string2;
        this.f$2 = string3;
        this.f$3 = string4;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onStartCommand$0$com-icontrol-protector-DownloadForegroundService(this.f$1, this.f$2, this.f$3);
    }
}

