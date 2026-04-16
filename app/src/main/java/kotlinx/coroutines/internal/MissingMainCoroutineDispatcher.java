/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package kotlinx.coroutines.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatchersKt;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0002J\u001e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\""}, d2={"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "", "limitedParallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class MissingMainCoroutineDispatcher
extends MainCoroutineDispatcher
implements Delay {
    private final Throwable cause;
    private final String errorHint;

    public MissingMainCoroutineDispatcher(Throwable throwable, String string2) {
        this.cause = throwable;
        this.errorHint = string2;
    }

    public /* synthetic */ MissingMainCoroutineDispatcher(Throwable throwable, String string2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            string2 = null;
        }
        this(throwable, string2);
    }

    private final Void missing() {
        block2: {
            String string2;
            StringBuilder stringBuilder;
            block4: {
                block3: {
                    String string3;
                    if (this.cause == null) break block2;
                    stringBuilder = new StringBuilder().append("Module with the Main dispatcher had failed to initialize");
                    string2 = this.errorHint;
                    if (string2 == null) break block3;
                    string2 = string3 = ". " + string2;
                    if (string3 != null) break block4;
                }
                string2 = "";
            }
            throw new IllegalStateException(stringBuilder.append(string2).toString(), this.cause);
        }
        MainDispatchersKt.throwMissingMainDispatcherException();
        throw new KotlinNothingValueException();
    }

    @Override
    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long l, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, l, continuation);
    }

    public Void dispatch(CoroutineContext coroutineContext, Runnable runnable2) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    @Override
    public MainCoroutineDispatcher getImmediate() {
        return this;
    }

    @Override
    public DisposableHandle invokeOnTimeout(long l, Runnable runnable2, CoroutineContext coroutineContext) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    @Override
    public CoroutineDispatcher limitedParallelism(int n) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    public Void scheduleResumeAfterDelay(long l, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("Dispatchers.Main[missing");
        String string2 = this.cause != null ? ", cause=" + this.cause : "";
        return stringBuilder.append(string2).append(']').toString();
    }
}

