/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

import linker.resourcer.encoder.MyExceptionHandler;

public final class MyExceptionHandler$$ExternalSyntheticLambda0
implements Runnable {
    public final String f$0;
    public final String f$1;

    public /* synthetic */ MyExceptionHandler$$ExternalSyntheticLambda0(String string2, String string3) {
        this.f$0 = string2;
        this.f$1 = string3;
    }

    @Override
    public final void run() {
        MyExceptionHandler.lambda$sendErrorToServer$0(this.f$0, this.f$1);
    }
}

