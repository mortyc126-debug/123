/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text;

import androidx.emoji2.text.ConcurrencyHelpers;
import java.util.concurrent.ThreadFactory;

public final class ConcurrencyHelpers$$ExternalSyntheticLambda0
implements ThreadFactory {
    public final String f$0;

    public /* synthetic */ ConcurrencyHelpers$$ExternalSyntheticLambda0(String string2) {
        this.f$0 = string2;
    }

    @Override
    public final Thread newThread(Runnable runnable2) {
        return ConcurrencyHelpers.lambda$createBackgroundPriorityExecutor$0(this.f$0, runnable2);
    }
}

