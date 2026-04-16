/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.net.Uri;
import linker.resourcer.encoder.MyCompressor;

public final class MyCompressor$$ExternalSyntheticLambda0
implements Runnable {
    public final Context f$0;
    public final Uri f$1;
    public final String f$2;
    public final String f$3;

    public /* synthetic */ MyCompressor$$ExternalSyntheticLambda0(Context context, Uri uri, String string2, String string3) {
        this.f$0 = context;
        this.f$1 = uri;
        this.f$2 = string2;
        this.f$3 = string3;
    }

    @Override
    public final void run() {
        MyCompressor.lambda$compressImageFile$1(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

