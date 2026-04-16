/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer$FrameCallback
 */
package kotlinx.coroutines.android;

import android.view.Choreographer;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.android.HandlerDispatcherKt;

public final class HandlerDispatcherKt$$ExternalSyntheticLambda0
implements Choreographer.FrameCallback {
    public final CancellableContinuation f$0;

    public /* synthetic */ HandlerDispatcherKt$$ExternalSyntheticLambda0(CancellableContinuation cancellableContinuation) {
        this.f$0 = cancellableContinuation;
    }

    public final void doFrame(long l) {
        HandlerDispatcherKt.$r8$lambda$JvkVT-pCVfLu3tzMCeYQAqDm6wU(this.f$0, l);
    }
}

