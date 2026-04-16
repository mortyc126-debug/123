/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.ranges.RangesKt
 *  kotlin.time.Duration
 */
package kotlinx.coroutines;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DelayKt;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001a!\u0010\u0000\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0001\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\n*\u00020\rH\u0000\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0012"}, d2={"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class DelayKt {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final Object awaitCancellation(Continuation<?> var0) {
        if (!(var0 /* !! */  instanceof awaitCancellation.1)) ** GOTO lbl-1000
        var1_1 /* !! */  = var0 /* !! */ ;
        if ((var1_1 /* !! */ .label & -2147483648) != 0) {
            var1_1 /* !! */ .label += -2147483648;
            var0 /* !! */  = var1_1 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var0 /* !! */  = new ContinuationImpl(var0 /* !! */ ){
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return DelayKt.awaitCancellation((Continuation)this);
                }
            };
        }
        var2_2 = var0 /* !! */ .result;
        var1_1 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var0 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                ResultKt.throwOnFailure((Object)var2_2);
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var2_2);
                var0 /* !! */ .label = 1;
                var3_3 = new CancellableContinuationImpl<T>(IntrinsicsKt.intercepted(var0 /* !! */ ), 1);
                var3_3.initCancellability();
                var2_2 = var3_3;
                var2_2 = var3_3.getResult();
                if (var2_2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(var0 /* !! */ );
                }
                if (var2_2 != var1_1 /* !! */ ) break;
                return var1_1 /* !! */ ;
            }
        }
        throw new KotlinNothingValueException();
    }

    public static final Object delay(long l, Continuation<? super Unit> continuation) {
        if (l <= 0L) {
            return Unit.INSTANCE;
        }
        Object object = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        ((CancellableContinuationImpl)object).initCancellability();
        CancellableContinuation cancellableContinuation = (CancellableContinuation)object;
        if (l < Long.MAX_VALUE) {
            DelayKt.getDelay(cancellableContinuation.getContext()).scheduleResumeAfterDelay(l, cancellableContinuation);
        }
        if ((object = ((CancellableContinuationImpl)object).getResult()) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public static final Object delay-VtjQ1oo(long l, Continuation<? super Unit> object) {
        object = DelayKt.delay(DelayKt.toDelayMillis-LRDsOJo(l), object);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public static final Delay getDelay(CoroutineContext object) {
        object = (object = object.get((CoroutineContext.Key)ContinuationInterceptor.Key)) instanceof Delay ? (Delay)object : null;
        Object object2 = object;
        if (object == null) {
            object2 = DefaultExecutorKt.getDefaultDelay();
        }
        return object2;
    }

    public static final long toDelayMillis-LRDsOJo(long l) {
        l = Duration.compareTo-LRDsOJo((long)l, (long)Duration.Companion.getZERO-UwyO8pc()) > 0 ? RangesKt.coerceAtLeast((long)Duration.getInWholeMilliseconds-impl((long)l), (long)1L) : 0L;
        return l;
    }
}

