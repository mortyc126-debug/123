/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.activity.contextaware;

import android.content.Context;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareKt;
import androidx.activity.contextaware.OnContextAvailableListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a@\u0010\u0000\u001a\u0007H\u0001\u00a2\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\u0001*\u00020\u00032\u001e\b\u0004\u0010\u0004\u001a\u0018\u0012\t\u0012\u00070\u0006\u00a2\u0006\u0002\b\u0002\u0012\t\u0012\u0007H\u0001\u00a2\u0006\u0002\b\u00020\u0005H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2={"withContextAvailable", "R", "Lkotlin/jvm/JvmSuppressWildcards;", "Landroidx/activity/contextaware/ContextAware;", "onContextAvailable", "Lkotlin/Function1;", "Landroid/content/Context;", "(Landroidx/activity/contextaware/ContextAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware object, Function1<Context, R> object2, Continuation<R> continuation) {
        Object object3 = object.peekAvailableContext();
        if (object3 != null) {
            return object2.invoke(object3);
        }
        object3 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        ((CancellableContinuationImpl)object3).initCancellability();
        CancellableContinuation cancellableContinuation = (CancellableContinuation)object3;
        object2 = new OnContextAvailableListener(cancellableContinuation, object2){
            final CancellableContinuation<R> $co;
            final Function1<Context, R> $onContextAvailable;
            {
                this.$co = cancellableContinuation;
                this.$onContextAvailable = function1;
            }

            public void onContextAvailable(Context object) {
                Intrinsics.checkNotNullParameter((Object)object, (String)"context");
                CancellableContinuation<R> cancellableContinuation = this.$co;
                Result.Companion companion = this.$onContextAvailable;
                try {
                    Object object2 = Result.Companion;
                    object2 = this;
                    object = Result.constructor-impl((Object)companion.invoke(object));
                }
                catch (Throwable throwable) {
                    companion = Result.Companion;
                    object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                }
                cancellableContinuation.resumeWith(object);
            }
        };
        object.addOnContextAvailableListener((OnContextAvailableListener)object2);
        cancellableContinuation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>((ContextAware)object, object2){
            final withContextAvailable.2.listener.1<R> $listener;
            final ContextAware $this_withContextAvailable;
            {
                this.$this_withContextAvailable = contextAware;
                this.$listener = var2_2;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                this.$this_withContextAvailable.removeOnContextAvailableListener(this.$listener);
            }
        }));
        object = ((CancellableContinuationImpl)object3).getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return object;
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware object, Function1<Context, R> object2, Continuation<R> continuation) {
        Object object3 = object.peekAvailableContext();
        if (object3 != null) {
            return object2.invoke(object3);
        }
        InlineMarker.mark((int)0);
        object3 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        ((CancellableContinuationImpl)object3).initCancellability();
        CancellableContinuation cancellableContinuation = (CancellableContinuation)object3;
        object2 = new /* invalid duplicate definition of identical inner class */;
        object.addOnContextAvailableListener((OnContextAvailableListener)object2);
        cancellableContinuation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new /* invalid duplicate definition of identical inner class */));
        object = Unit.INSTANCE;
        object = ((CancellableContinuationImpl)object3).getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark((int)1);
        return object;
    }
}

