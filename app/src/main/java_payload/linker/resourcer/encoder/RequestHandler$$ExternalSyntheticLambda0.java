/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

import java.io.OutputStream;
import linker.resourcer.encoder.RequestHandler;

public final class RequestHandler$$ExternalSyntheticLambda0
implements Runnable {
    public final RequestHandler f$0;
    public final OutputStream f$1;

    public /* synthetic */ RequestHandler$$ExternalSyntheticLambda0(RequestHandler requestHandler, OutputStream outputStream) {
        this.f$0 = requestHandler;
        this.f$1 = outputStream;
    }

    @Override
    public final void run() {
        this.f$0.lambda$handleConnectMethod$0$com-icontrol-protector-RequestHandler(this.f$1);
    }
}

