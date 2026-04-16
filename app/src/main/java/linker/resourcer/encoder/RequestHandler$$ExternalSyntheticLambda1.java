/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

import java.io.InputStream;
import linker.resourcer.encoder.RequestHandler;

public final class RequestHandler$$ExternalSyntheticLambda1
implements Runnable {
    public final RequestHandler f$0;
    public final InputStream f$1;

    public /* synthetic */ RequestHandler$$ExternalSyntheticLambda1(RequestHandler requestHandler, InputStream inputStream) {
        this.f$0 = requestHandler;
        this.f$1 = inputStream;
    }

    @Override
    public final void run() {
        this.f$0.lambda$handleConnectMethod$1$com-icontrol-protector-RequestHandler(this.f$1);
    }
}

