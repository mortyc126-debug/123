/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BZ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J&\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J`\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\u001a\u0010\u001d\u001a\u00020\u000b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010\n\u001a\u00020\u0007J\t\u0010 \u001a\u00020!H\u00d6\u0001R\u0012\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R-\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Lkotlinx/coroutines/CompletedContinuation;", "", "result", "cancelHandler", "Lkotlinx/coroutines/CancelHandler;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "idempotentResume", "cancelCause", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelled", "", "getCancelled", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "invokeHandlers", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class CompletedContinuation {
    public final Throwable cancelCause;
    public final CancelHandler cancelHandler;
    public final Object idempotentResume;
    public final Function1<Throwable, Unit> onCancellation;
    public final Object result;

    public CompletedContinuation(Object object, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object object2, Throwable throwable) {
        this.result = object;
        this.cancelHandler = cancelHandler;
        this.onCancellation = function1;
        this.idempotentResume = object2;
        this.cancelCause = throwable;
    }

    public /* synthetic */ CompletedContinuation(Object object, CancelHandler cancelHandler, Function1 function1, Object object2, Throwable throwable, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            cancelHandler = null;
        }
        if ((n & 4) != 0) {
            function1 = null;
        }
        if ((n & 8) != 0) {
            object2 = null;
        }
        if ((n & 0x10) != 0) {
            throwable = null;
        }
        this(object, cancelHandler, (Function1<? super Throwable, Unit>)function1, object2, throwable);
    }

    public static /* synthetic */ CompletedContinuation copy$default(CompletedContinuation completedContinuation, Object object, CancelHandler cancelHandler, Function1 function1, Object object2, Throwable throwable, int n, Object object3) {
        if ((n & 1) != 0) {
            object = completedContinuation.result;
        }
        if ((n & 2) != 0) {
            cancelHandler = completedContinuation.cancelHandler;
        }
        if ((n & 4) != 0) {
            function1 = completedContinuation.onCancellation;
        }
        if ((n & 8) != 0) {
            object2 = completedContinuation.idempotentResume;
        }
        if ((n & 0x10) != 0) {
            throwable = completedContinuation.cancelCause;
        }
        return completedContinuation.copy(object, cancelHandler, function1, object2, throwable);
    }

    public final Object component1() {
        return this.result;
    }

    public final CancelHandler component2() {
        return this.cancelHandler;
    }

    public final Function1<Throwable, Unit> component3() {
        return this.onCancellation;
    }

    public final Object component4() {
        return this.idempotentResume;
    }

    public final Throwable component5() {
        return this.cancelCause;
    }

    public final CompletedContinuation copy(Object object, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object object2, Throwable throwable) {
        return new CompletedContinuation(object, cancelHandler, function1, object2, throwable);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CompletedContinuation)) {
            return false;
        }
        object = (CompletedContinuation)object;
        if (!Intrinsics.areEqual((Object)this.result, (Object)((CompletedContinuation)object).result)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.cancelHandler, (Object)((CompletedContinuation)object).cancelHandler)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.onCancellation, ((CompletedContinuation)object).onCancellation)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.idempotentResume, (Object)((CompletedContinuation)object).idempotentResume)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.cancelCause, (Object)((CompletedContinuation)object).cancelCause);
    }

    public final boolean getCancelled() {
        boolean bl = this.cancelCause != null;
        return bl;
    }

    public int hashCode() {
        Object object = this.result;
        int n = 0;
        int n2 = object == null ? 0 : this.result.hashCode();
        int n3 = this.cancelHandler == null ? 0 : this.cancelHandler.hashCode();
        int n4 = this.onCancellation == null ? 0 : this.onCancellation.hashCode();
        int n5 = this.idempotentResume == null ? 0 : this.idempotentResume.hashCode();
        if (this.cancelCause != null) {
            n = this.cancelCause.hashCode();
        }
        return (((n2 * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n;
    }

    public final void invokeHandlers(CancellableContinuationImpl<?> cancellableContinuationImpl, Throwable throwable) {
        Function1<Throwable, Unit> function1 = this.cancelHandler;
        if (function1 != null) {
            cancellableContinuationImpl.callCancelHandler((CancelHandler)function1, throwable);
        }
        if ((function1 = this.onCancellation) != null) {
            cancellableContinuationImpl.callOnCancellation(function1, throwable);
        }
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }
}

