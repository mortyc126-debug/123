/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.emoji2.text;

import android.os.Handler;
import androidx.emoji2.text.ConcurrencyHelpers;
import java.util.concurrent.Executor;

public final class ConcurrencyHelpers$$ExternalSyntheticLambda1
implements Executor {
    public final Handler f$0;

    public /* synthetic */ ConcurrencyHelpers$$ExternalSyntheticLambda1(Handler handler) {
        this.f$0 = handler;
    }

    @Override
    public final void execute(Runnable runnable2) {
        ConcurrencyHelpers.$r8$lambda$xMC8M6LLEeW997bBmO6BCC6GGAM(this.f$0, runnable2);
    }
}

