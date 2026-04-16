/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.time.Duration
 *  kotlin.time.DurationKt
 *  kotlin.time.DurationUnit
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DelayWithTimeoutDiagnostics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutCoroutine;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a_\u0010\b\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\n\"\b\b\u0001\u0010\u000b*\u0002H\n2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\f2'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e\u00a2\u0006\u0002\b\u0011H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001aU\u0010\u0013\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0014\u001a\u00020\u00032'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e\u00a2\u0006\u0002\b\u0011H\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0002\u0010\u0015\u001a]\u0010\u0013\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e\u00a2\u0006\u0002\b\u0011H\u0086@\u00f8\u0001\u0001\u00f8\u0001\u0000\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\u0018\u0010\u0015\u001aJ\u0010\u0019\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0014\u001a\u00020\u00032'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e\u00a2\u0006\u0002\b\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u001aR\u0010\u0019\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e\u00a2\u0006\u0002\b\u0011H\u0086@\u00f8\u0001\u0001\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0015\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001b"}, d2={"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "", "delay", "Lkotlinx/coroutines/Delay;", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", "T", "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeout", "Lkotlin/time/Duration;", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class TimeoutKt {
    public static final TimeoutCancellationException TimeoutCancellationException(long l, Delay object, Job job2) {
        block3: {
            block2: {
                if ((object = object instanceof DelayWithTimeoutDiagnostics ? (DelayWithTimeoutDiagnostics)object : null) == null) break block2;
                Object object2 = Duration.Companion;
                object2 = object.timeoutMessage-LRDsOJo(DurationKt.toDuration((long)l, (DurationUnit)DurationUnit.MILLISECONDS));
                object = object2;
                if (object2 != null) break block3;
            }
            object = "Timed out waiting for " + l + " ms";
        }
        return new TimeoutCancellationException((String)object, job2);
    }

    private static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        CoroutineContext coroutineContext = timeoutCoroutine.uCont.getContext();
        JobKt.disposeOnCompletion(timeoutCoroutine, DelayKt.getDelay(coroutineContext).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.getContext()));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout((ScopeCoroutine)timeoutCoroutine, timeoutCoroutine, function2);
    }

    public static final <T> Object withTimeout(long l, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> object, Continuation<? super T> continuation) {
        if (l > 0L) {
            if ((object = TimeoutKt.setupTimeout(new TimeoutCoroutine(l, continuation), object)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return object;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    public static final <T> Object withTimeout-KLykuaI(long l, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return TimeoutKt.withTimeout(DelayKt.toDelayMillis-LRDsOJo(l), function2, continuation);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object withTimeoutOrNull(long var0, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> var2_1, Continuation<? super T> var3_2) {
        block13: {
            if (!(var3_2 instanceof withTimeoutOrNull.1)) ** GOTO lbl-1000
            var4_6 /* !! */  = var3_2;
            if ((var4_6 /* !! */ .label & -2147483648) != 0) {
                var4_6 /* !! */ .label += -2147483648;
                var3_2 = var4_6 /* !! */ ;
            } else lbl-1000:
            // 2 sources

            {
                var3_2 = new ContinuationImpl((Continuation<? super withTimeoutOrNull.1>)var3_2){
                    long J$0;
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return TimeoutKt.withTimeoutOrNull(0L, null, (Continuation)this);
                    }
                };
            }
            var4_6 /* !! */  = var3_2.result;
            var5_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var3_2.label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    var0 = var3_2.J$0;
                    var2_1 /* !! */  = (Ref.ObjectRef)var3_2.L$1;
                    var3_2 = (Function2)var3_2.L$0;
                    try {
                        ResultKt.throwOnFailure((Object)var4_6 /* !! */ );
                        var2_1 /* !! */  = var4_6 /* !! */ ;
                        break;
                    }
                    catch (TimeoutCancellationException var3_3) {
                        break block13;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var4_6 /* !! */ );
                    if (var0 <= 0L) {
                        return null;
                    }
                    var4_6 /* !! */  = new Ref.ObjectRef();
                    var3_2.L$0 = var2_1 /* !! */ ;
                    var3_2.L$1 = var4_6 /* !! */ ;
                    var3_2.J$0 = var0;
                    var3_2.label = 1;
                    var6_8 = (Continuation)var3_2;
                    var4_6 /* !! */ .element = var7_9 = new TimeoutCoroutine<U, T>(var0, var6_8);
                    var2_1 /* !! */  = TimeoutKt.setupTimeout(var7_9, var2_1 /* !! */ );
                    if (var2_1 /* !! */  == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended((Continuation)((Continuation)var3_2));
                    }
                    if (var2_1 /* !! */  != var5_7) break;
                    return var5_7;
                }
            }
            return var2_1 /* !! */ ;
            catch (TimeoutCancellationException var3_4) {
                var2_1 /* !! */  = var4_6 /* !! */ ;
            }
        }
        if (var3_5.coroutine == var2_1 /* !! */ .element) {
            return null;
        }
        throw var3_5;
    }

    public static final <T> Object withTimeoutOrNull-KLykuaI(long l, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return TimeoutKt.withTimeoutOrNull(DelayKt.toDelayMillis-LRDsOJo(l), function2, continuation);
    }
}

