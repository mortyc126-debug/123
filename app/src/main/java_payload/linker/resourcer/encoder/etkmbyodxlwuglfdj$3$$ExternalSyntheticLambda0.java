/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  okhttp3.WebSocket
 */
package linker.resourcer.encoder;

import android.content.Context;
import linker.resourcer.encoder.etkmbyodxlwuglfdj;
import okhttp3.WebSocket;

public final class etkmbyodxlwuglfdj$3$$ExternalSyntheticLambda0
implements Runnable {
    public final etkmbyodxlwuglfdj.3 f$0;
    public final Context f$1;
    public final String f$2;
    public final String f$3;
    public final String f$4;
    public final WebSocket f$5;

    public /* synthetic */ etkmbyodxlwuglfdj$3$$ExternalSyntheticLambda0(etkmbyodxlwuglfdj.3 var1_1, Context context, String string2, String string3, String string4, WebSocket webSocket) {
        this.f$0 = var1_1;
        this.f$1 = context;
        this.f$2 = string2;
        this.f$3 = string3;
        this.f$4 = string4;
        this.f$5 = webSocket;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onOpen$0$com-icontrol-protector-etkmbyodxlwuglfdj$3(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}

