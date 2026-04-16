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
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 */
package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\b"}, d2={"Lkotlinx/coroutines/DelayWithTimeoutDiagnostics;", "Lkotlinx/coroutines/Delay;", "timeoutMessage", "", "timeout", "Lkotlin/time/Duration;", "timeoutMessage-LRDsOJo", "(J)Ljava/lang/String;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public interface DelayWithTimeoutDiagnostics
extends Delay {
    public String timeoutMessage-LRDsOJo(long var1);

    @Metadata(k=3, mv={1, 8, 0}, xi=48)
    public static final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use")
        public static Object delay(DelayWithTimeoutDiagnostics object, long l, Continuation<? super Unit> continuation) {
            if ((object = Delay.DefaultImpls.delay((Delay)object, l, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return object;
            }
            return Unit.INSTANCE;
        }

        public static DisposableHandle invokeOnTimeout(DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics, long l, Runnable runnable2, CoroutineContext coroutineContext) {
            return Delay.DefaultImpls.invokeOnTimeout(delayWithTimeoutDiagnostics, l, runnable2, coroutineContext);
        }
    }
}

