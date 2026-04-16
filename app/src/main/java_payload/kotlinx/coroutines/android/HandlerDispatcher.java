/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package kotlinx.coroutines.android;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\u0007\u00a8\u0006\b"}, d2={"Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class HandlerDispatcher
extends MainCoroutineDispatcher
implements Delay {
    private HandlerDispatcher() {
    }

    public /* synthetic */ HandlerDispatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override
    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long l, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, l, continuation);
    }

    @Override
    public abstract HandlerDispatcher getImmediate();

    @Override
    public DisposableHandle invokeOnTimeout(long l, Runnable runnable2, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.invokeOnTimeout(this, l, runnable2, coroutineContext);
    }
}

