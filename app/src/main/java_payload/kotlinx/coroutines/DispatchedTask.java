/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutinesInternalError;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedTaskKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010\u00a2\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010\u00a2\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001b\u001a\u00020\fJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH \u00a2\u0006\u0002\b\u001dR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u00a0\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class DispatchedTask<T>
extends Task {
    public int resumeMode;

    public DispatchedTask(int n) {
        this.resumeMode = n;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object object, Throwable throwable) {
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object object) {
        boolean bl = object instanceof CompletedExceptionally;
        Throwable throwable = null;
        object = bl ? (CompletedExceptionally)object : null;
        if (object != null) {
            throwable = ((CompletedExceptionally)object).cause;
        }
        return throwable;
    }

    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object object) {
        return (T)object;
    }

    public final void handleFatalException(Throwable throwable, Throwable object) {
        if (throwable == null && object == null) {
            return;
        }
        if (throwable != null && object != null) {
            ExceptionsKt.addSuppressed((Throwable)throwable, (Throwable)object);
        }
        if (throwable == null) {
            throwable = object;
        }
        object = "Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers";
        Intrinsics.checkNotNull((Object)throwable);
        throwable = new CoroutinesInternalError((String)object, throwable);
        CoroutineExceptionHandlerKt.handleCoroutineException(this.getDelegate$kotlinx_coroutines_core().getContext(), throwable);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public final void run() {
        block31: {
            block32: {
                block27: {
                    block30: {
                        block33: {
                            block28: {
                                block29: {
                                    block26: {
                                        block25: {
                                            block24: {
                                                if (DebugKt.getASSERTIONS_ENABLED() && !(var1_1 = this.resumeMode != -1)) {
                                                    throw new AssertionError();
                                                }
                                                var8_2 = this.taskContext;
                                                var6_3 = null;
                                                var5_4 = null;
                                                var3_5 = this.getDelegate$kotlinx_coroutines_core();
                                                Intrinsics.checkNotNull(var3_5, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
                                                var3_5 = (DispatchedContinuation)var3_5;
                                                var11_11 = var3_5.continuation;
                                                var3_5 = var3_5.countOrElement;
                                                var9_12 = var11_11.getContext();
                                                var10_13 = ThreadContextKt.updateThreadContext(var9_12, var3_5);
                                                var3_5 = ThreadContextKt.NO_THREAD_ELEMENTS;
                                                var7_14 = null;
                                                if (var10_13 == var3_5) break block24;
                                                var4_15 = CoroutineContextKt.updateUndispatchedCompletion(var11_11, var9_12, var10_13);
                                                break block25;
                                            }
                                            var4_15 = null;
                                        }
                                        var14_18 = var11_11.getContext();
                                        var12_19 = this.takeState$kotlinx_coroutines_core();
                                        var13_20 = this.getExceptionalResult$kotlinx_coroutines_core(var12_19);
                                        var3_5 = var7_14;
                                        if (var13_20 != null) break block26;
                                        var3_5 = var7_14;
                                        try {
                                            if (!DispatchedTaskKt.isCancellableMode(this.resumeMode)) break block26;
                                            var3_5 = (Job)var14_18.get((CoroutineContext.Key)Job.Key);
                                        }
                                        catch (Throwable var3_6) {
                                            break block27;
                                        }
                                    }
                                    if (var3_5 == null) break block28;
                                    if (var3_5.isActive()) break block28;
                                    var3_5 = var3_5.getCancellationException();
                                    this.cancelCompletedResult$kotlinx_coroutines_core(var12_19, (Throwable)var3_5);
                                    var7_14 = Result.Companion;
                                    var2_21 = DebugKt.getRECOVER_STACK_TRACES();
                                    if (!var2_21) break block29;
                                    if (!(var11_11 instanceof CoroutineStackFrame)) break block29;
                                    var3_5 = (Throwable)var3_5;
                                    try {
                                        var3_5 = StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)var3_5, (CoroutineStackFrame)var11_11);
                                        ** GOTO lbl57
                                    }
                                    catch (Throwable var3_8) {}
                                    catch (Throwable var3_7) {
                                        break block27;
                                    }
                                }
                                var3_5 = (Throwable)var3_5;
lbl57:
                                // 2 sources

                                var11_11.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var3_5)));
                                ** GOTO lbl67
                            }
                            if (var13_20 == null) ** GOTO lbl65
                            var3_5 = Result.Companion;
                            var11_11.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var13_20)));
                            break block33;
lbl65:
                            // 1 sources

                            var3_5 = Result.Companion;
                            var11_11.resumeWith(Result.constructor-impl(this.getSuccessfulResult$kotlinx_coroutines_core(var12_19)));
                        }
                        var3_5 = Unit.INSTANCE;
                        if (var4_15 == null) ** GOTO lbl72
                        if (!var4_15.clearThreadContext()) break block30;
lbl72:
                        // 2 sources

                        ThreadContextKt.restoreThreadContext(var9_12, var10_13);
                    }
                    try {
                        var3_5 = Result.Companion;
                        var3_5 = this;
                        var8_2.afterTask();
                        var4_15 = Result.constructor-impl((Object)Unit.INSTANCE);
                        var3_5 = var6_3;
                        break block31;
                    }
                    catch (Throwable var4_16) {
                        var3_5 = var5_4;
                        break block32;
                    }
                    break block27;
                    catch (Throwable var3_9) {
                        // empty catch block
                    }
                }
                if (var4_15 == null) ** GOTO lbl91
                try {
                    block34: {
                        if (!var4_15.clearThreadContext()) break block34;
lbl91:
                        // 2 sources

                        ThreadContextKt.restoreThreadContext(var9_12, var10_13);
                    }
                    throw var3_5;
                }
                catch (Throwable var3_10) {
                    try {
                        var4_15 = Result.Companion;
                        var8_2.afterTask();
                        var4_15 = Result.constructor-impl((Object)Unit.INSTANCE);
                        break block31;
                    }
                    catch (Throwable var4_17) {
                        // empty catch block
                    }
                }
            }
            var5_4 = Result.Companion;
            var4_15 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var4_15));
        }
        this.handleFatalException((Throwable)var3_5, Result.exceptionOrNull-impl((Object)var4_15));
    }

    public abstract Object takeState$kotlinx_coroutines_core();
}

