/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.background.greedy;

import androidx.work.impl.StartStopToken;
import androidx.work.impl.background.greedy.TimeLimiter;

public final class TimeLimiter$$ExternalSyntheticLambda0
implements Runnable {
    public final TimeLimiter f$0;
    public final StartStopToken f$1;

    public /* synthetic */ TimeLimiter$$ExternalSyntheticLambda0(TimeLimiter timeLimiter, StartStopToken startStopToken) {
        this.f$0 = timeLimiter;
        this.f$1 = startStopToken;
    }

    @Override
    public final void run() {
        TimeLimiter.$r8$lambda$-vpfYFCUMjLBVsa47nEhUzlZ9xY(this.f$0, this.f$1);
    }
}

