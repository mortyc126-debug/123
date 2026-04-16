/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

import linker.resourcer.encoder.CommandProcessor;
import linker.resourcer.encoder.CommandExecutor;

public final class CommandExecutor$1$$ExternalSyntheticLambda4
implements Runnable {
    public final CommandProcessor f$0;
    public final String f$1;
    public final String f$2;

    public /* synthetic */ CommandExecutor$1$$ExternalSyntheticLambda4(CommandProcessor commandProcessor, String string2, String string3) {
        this.f$0 = commandProcessor;
        this.f$1 = string2;
        this.f$2 = string3;
    }

    @Override
    public final void run() {
        CommandExecutor.1.lambda$HandleBot$1(this.f$0, this.f$1, this.f$2);
    }
}

