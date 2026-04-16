/*
 * Decompiled with CFR 0.152.
 */
package kotlinx.coroutines.android;

import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.android.HandlerContext;

public final class HandlerContext$$ExternalSyntheticLambda0
implements DisposableHandle {
    public final HandlerContext f$0;
    public final Runnable f$1;

    public /* synthetic */ HandlerContext$$ExternalSyntheticLambda0(HandlerContext handlerContext, Runnable runnable2) {
        this.f$0 = handlerContext;
        this.f$1 = runnable2;
    }

    @Override
    public final void dispose() {
        HandlerContext.$r8$lambda$uWNO1FUkgOtv52K5-E4QlFYJYR0(this.f$0, this.f$1);
    }
}

