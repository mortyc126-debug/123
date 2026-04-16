/*
 * Decompiled with CFR 0.152.
 */
package androidx.room;

import androidx.room.MultiInstanceInvalidationClient;

public final class MultiInstanceInvalidationClient$callback$1$$ExternalSyntheticLambda0
implements Runnable {
    public final MultiInstanceInvalidationClient f$0;
    public final String[] f$1;

    public /* synthetic */ MultiInstanceInvalidationClient$callback$1$$ExternalSyntheticLambda0(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] stringArray) {
        this.f$0 = multiInstanceInvalidationClient;
        this.f$1 = stringArray;
    }

    @Override
    public final void run() {
        MultiInstanceInvalidationClient.callback.1.$r8$lambda$YbA_oLvwgwIT6Ag339-3Mj03vfc(this.f$0, this.f$1);
    }
}

