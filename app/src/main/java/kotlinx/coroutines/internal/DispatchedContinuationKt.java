/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0082\b\u001aU\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00122%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u001a\u0012\u0010\u001a\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\r0\u0005H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2={"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED", "executeUnconfined", "", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class DispatchedContinuationKt {
    public static final Symbol REUSABLE_CLAIMED;
    private static final Symbol UNDEFINED;

    static {
        UNDEFINED = new Symbol("UNDEFINED");
        REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");
    }

    public static final /* synthetic */ Symbol access$getUNDEFINED$p() {
        return UNDEFINED;
    }

    private static final boolean executeUnconfined(DispatchedContinuation<?> dispatchedTask, Object object, int n, boolean bl, Function0<Unit> function0) {
        block9: {
            EventLoop eventLoop;
            boolean bl2;
            block8: {
                boolean bl3;
                boolean bl4 = DebugKt.getASSERTIONS_ENABLED();
                bl2 = false;
                if (bl4 && !(bl3 = n != -1)) {
                    throw new AssertionError();
                }
                eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
                if (bl && eventLoop.isUnconfinedQueueEmpty()) {
                    return false;
                }
                if (!eventLoop.isUnconfinedLoopActive()) break block8;
                ((DispatchedContinuation)dispatchedTask)._state = object;
                ((DispatchedContinuation)dispatchedTask).resumeMode = n;
                eventLoop.dispatchUnconfined(dispatchedTask);
                bl = true;
                break block9;
            }
            dispatchedTask = dispatchedTask;
            eventLoop.incrementUseCount(true);
            try {
                function0.invoke();
                while (bl = eventLoop.processUnconfinedEvent()) {
                }
            }
            catch (Throwable throwable) {
                dispatchedTask.handleFatalException(throwable, null);
            }
            InlineMarker.finallyStart((int)1);
            eventLoop.decrementUseCount(true);
            InlineMarker.finallyEnd((int)1);
            bl = bl2;
        }
        return bl;
        {
            finally {
                InlineMarker.finallyStart((int)1);
            }
        }
    }

    static /* synthetic */ boolean executeUnconfined$default(DispatchedContinuation dispatchedTask, Object object, int n, boolean bl, Function0 function0, int n2, Object object2) {
        block10: {
            boolean bl2;
            block9: {
                if ((n2 & 4) != 0) {
                    bl = false;
                }
                boolean bl3 = DebugKt.getASSERTIONS_ENABLED();
                bl2 = false;
                if (bl3 && (n2 = n != -1 ? 1 : 0) == 0) {
                    throw new AssertionError();
                }
                object2 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
                if (bl && ((EventLoop)((Object)object2)).isUnconfinedQueueEmpty()) {
                    return false;
                }
                if (!((EventLoop)((Object)object2)).isUnconfinedLoopActive()) break block9;
                ((DispatchedContinuation)dispatchedTask)._state = object;
                ((DispatchedContinuation)dispatchedTask).resumeMode = n;
                ((EventLoop)((Object)object2)).dispatchUnconfined(dispatchedTask);
                bl = true;
                break block10;
            }
            dispatchedTask = dispatchedTask;
            ((EventLoop)((Object)object2)).incrementUseCount(true);
            try {
                function0.invoke();
                while (bl = ((EventLoop)((Object)object2)).processUnconfinedEvent()) {
                }
            }
            catch (Throwable throwable) {
                dispatchedTask.handleFatalException(throwable, null);
            }
            InlineMarker.finallyStart((int)1);
            ((EventLoop)((Object)object2)).decrementUseCount(true);
            InlineMarker.finallyEnd((int)1);
            bl = bl2;
        }
        return bl;
        {
            finally {
                InlineMarker.finallyStart((int)1);
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final <T> void resumeCancellableWith(Continuation<? super T> var0, Object var1_8, Function1<? super Throwable, Unit> var2_12) {
        block28: {
            block29: {
                block27: {
                    if (!(var0 instanceof DispatchedContinuation)) {
                        var0.resumeWith(var1_8);
                        return;
                    }
                    var7_13 = (Continuation<T>)var0;
                    var6_14 = CompletionStateKt.toState(var1_8, (Function1<? super Throwable, Unit>)var2_12);
                    if (var7_13.dispatcher.isDispatchNeeded(var7_13.getContext())) {
                        var7_13._state = var6_14;
                        var7_13.resumeMode = 1;
                        var7_13.dispatcher.dispatch(var7_13.getContext(), (Runnable)var7_13);
                        return;
                    }
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        // empty if block
                    }
                    if ((var2_12 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core()).isUnconfinedLoopActive()) {
                        var7_13._state = var6_14;
                        var7_13.resumeMode = 1;
                        var2_12.dispatchUnconfined((DispatchedTask)var7_13);
                        return;
                    }
                    var5_15 = (DispatchedTask)var7_13;
                    var2_12.incrementUseCount(true);
                    try {
                        var0 = (Job)var7_13.getContext().get((CoroutineContext.Key)Job.Key);
                        if (var0 == null) break block27;
                    }
                    catch (Throwable var0_5) {
                        // empty catch block
                        break block28;
                    }
                    try {
                        if (var0.isActive()) break block27;
                        var0 = var0.getCancellationException();
                        var7_13.cancelCompletedResult$kotlinx_coroutines_core(var6_14, (Throwable)var0);
                        var6_14 = (Continuation)var7_13;
                        var8_16 = Result.Companion;
                        var6_14.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)((Throwable)var0))));
                        var3_17 = true;
                        break block29;
                    }
                    catch (Throwable var0_1) {
                        break block28;
                    }
                }
                var3_17 = false;
            }
            if (var3_17) ** GOTO lbl84
            {
                var0 = var7_13.continuation;
                var8_16 = var7_13.countOrElement;
                var6_14 = var0.getContext();
            }
            var8_16 = ThreadContextKt.updateThreadContext((CoroutineContext)var6_14, var8_16);
            var9_18 = ThreadContextKt.NO_THREAD_ELEMENTS;
            if (var8_16 != var9_18) {
            }
            ** GOTO lbl58
            {
                block33: {
                    block31: {
                        block32: {
                            block30: {
                                catch (Throwable var0_3) {
                                    break block28;
                                }
                                try {
                                    var0 = CoroutineContextKt.updateUndispatchedCompletion(var0, (CoroutineContext)var6_14, var8_16);
                                    break block30;
                                }
                                catch (Throwable var0_2) {
                                    break block28;
                                }
lbl58:
                                // 1 sources

                                var0 = null;
                            }
                            try {
                                var7_13 = var7_13.continuation;
                            }
                            catch (Throwable var1_10) {
                                // empty catch block
                                break block31;
                            }
                            try {
                                var7_13.resumeWith(var1_8);
                                var1_8 = Unit.INSTANCE;
                                if (var0 == null) break block32;
                            }
                            catch (Throwable var1_9) {
                                break block31;
                            }
                            ** try [egrp 7[TRYBLOCK] [8 : 305->357)] { 
lbl74:
                            // 1 sources

                            if (!var0.clearThreadContext()) break block33;
                        }
                        ThreadContextKt.restoreThreadContext((CoroutineContext)var6_14, var8_16);
                        break block33;
                    }
                    if (var0 != null) {
                        if (var0.clearThreadContext() == false) throw var1_11;
                    }
                    ThreadContextKt.restoreThreadContext((CoroutineContext)var6_14, var8_16);
                    throw var1_11;
                }
                while (var4_19 = var2_12.processUnconfinedEvent()) {
                }
                return;
            }
lbl88:
            // 1 sources

            catch (Throwable var0_4) {}
        }
        try {
            var5_15.handleFatalException((Throwable)var0_6, null);
            return;
        }
        finally {
            var2_12.decrementUseCount(true);
        }
    }

    public static /* synthetic */ void resumeCancellableWith$default(Continuation continuation, Object object, Function1 function1, int n, Object object2) {
        if ((n & 2) != 0) {
            function1 = null;
        }
        DispatchedContinuationKt.resumeCancellableWith(continuation, object, (Function1<? super Throwable, Unit>)function1);
    }

    public static final boolean yieldUndispatched(DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Object object = Unit.INSTANCE;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            // empty if block
        }
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        boolean bl = eventLoop.isUnconfinedQueueEmpty();
        boolean bl2 = false;
        boolean bl3 = false;
        if (bl) {
            bl3 = bl2;
        } else if (eventLoop.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = object;
            dispatchedContinuation.resumeMode = 1;
            eventLoop.dispatchUnconfined((DispatchedTask)dispatchedContinuation);
            bl3 = true;
        } else {
            object = dispatchedContinuation;
            eventLoop.incrementUseCount(true);
            try {
                dispatchedContinuation.run();
                while (bl2 = eventLoop.processUnconfinedEvent()) {
                }
            }
            catch (Throwable throwable) {
                ((DispatchedTask)object).handleFatalException(throwable, null);
            }
        }
        return bl3;
        {
            finally {
                eventLoop.decrementUseCount(true);
            }
        }
    }
}

