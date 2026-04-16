/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.android.HandlerContext$$ExternalSyntheticLambda0;
import kotlinx.coroutines.android.HandlerDispatcher;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100#H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0000X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2={"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "cancelOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"}, k=1, mv={1, 8, 0}, xi=48)
public final class HandlerContext
extends HandlerDispatcher
implements Delay {
    private volatile HandlerContext _immediate;
    private final Handler handler;
    private final HandlerContext immediate;
    private final boolean invokeImmediately;
    private final String name;

    public static /* synthetic */ void $r8$lambda$uWNO1FUkgOtv52K5-E4QlFYJYR0(HandlerContext handlerContext, Runnable runnable2) {
        HandlerContext.invokeOnTimeout$lambda$3(handlerContext, runnable2);
    }

    public HandlerContext(Handler handler, String string2) {
        this(handler, string2, false);
    }

    public /* synthetic */ HandlerContext(Handler handler, String string2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            string2 = null;
        }
        this(handler, string2);
    }

    private HandlerContext(Handler object, String object2, boolean bl) {
        Object var4_4 = null;
        super(null);
        this.handler = object;
        this.name = object2;
        this.invokeImmediately = bl;
        object = var4_4;
        if (this.invokeImmediately) {
            object = this;
        }
        this._immediate = object;
        object2 = this._immediate;
        object = object2;
        if (object2 == null) {
            object = new HandlerContext(this.handler, this.name, true);
            this._immediate = object;
        }
        this.immediate = object;
    }

    public static final /* synthetic */ Handler access$getHandler$p(HandlerContext handlerContext) {
        return handlerContext.handler;
    }

    private final void cancelOnRejection(CoroutineContext coroutineContext, Runnable runnable2) {
        JobKt.cancel(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.getIO().dispatch(coroutineContext, runnable2);
    }

    private static final void invokeOnTimeout$lambda$3(HandlerContext handlerContext, Runnable runnable2) {
        handlerContext.handler.removeCallbacks(runnable2);
    }

    @Override
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable2) {
        if (!this.handler.post(runnable2)) {
            this.cancelOnRejection(coroutineContext, runnable2);
        }
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof HandlerContext && ((HandlerContext)object).handler == this.handler;
        return bl;
    }

    @Override
    public HandlerContext getImmediate() {
        return this.immediate;
    }

    public int hashCode() {
        return System.identityHashCode(this.handler);
    }

    @Override
    public DisposableHandle invokeOnTimeout(long l, Runnable runnable2, CoroutineContext coroutineContext) {
        if (this.handler.postDelayed(runnable2, RangesKt.coerceAtMost((long)l, (long)0x3FFFFFFFFFFFFFFFL))) {
            return new HandlerContext$$ExternalSyntheticLambda0(this, runnable2);
        }
        this.cancelOnRejection(coroutineContext, runnable2);
        return NonDisposableHandle.INSTANCE;
    }

    @Override
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        boolean bl = !this.invokeImmediately || !Intrinsics.areEqual((Object)Looper.myLooper(), (Object)this.handler.getLooper());
        return bl;
    }

    @Override
    public void scheduleResumeAfterDelay(long l, CancellableContinuation<? super Unit> cancellableContinuation) {
        Runnable runnable2 = new Runnable(cancellableContinuation, this){
            final CancellableContinuation $continuation$inlined;
            final HandlerContext this$0;
            {
                this.$continuation$inlined = cancellableContinuation;
                this.this$0 = handlerContext;
            }

            public final void run() {
                this.$continuation$inlined.resumeUndispatched(this.this$0, Unit.INSTANCE);
            }
        };
        if (this.handler.postDelayed(runnable2, RangesKt.coerceAtMost((long)l, (long)0x3FFFFFFFFFFFFFFFL))) {
            cancellableContinuation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(this, runnable2){
                final Runnable $block;
                final HandlerContext this$0;
                {
                    this.this$0 = handlerContext;
                    this.$block = runnable2;
                    super(1);
                }

                public final void invoke(Throwable throwable) {
                    HandlerContext.access$getHandler$p(this.this$0).removeCallbacks(this.$block);
                }
            }));
        } else {
            this.cancelOnRejection(cancellableContinuation.getContext(), runnable2);
        }
    }

    @Override
    public String toString() {
        String string2;
        block2: {
            String string3;
            string2 = string3 = this.toStringInternalImpl();
            if (string3 != null) break block2;
            HandlerContext handlerContext = this;
            string2 = string3 = handlerContext.name;
            if (string3 == null) {
                string2 = handlerContext.handler.toString();
            }
            if (handlerContext.invokeImmediately) {
                string2 = string2 + ".immediate";
            }
        }
        return string2;
    }
}

