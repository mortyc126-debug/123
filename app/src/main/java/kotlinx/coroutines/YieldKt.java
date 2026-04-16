/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.YieldContext;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0003"}, d2={"yield", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class YieldKt {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final Object yield(Continuation<? super Unit> var0) {
        block5: {
            block6: {
                block4: {
                    var2_1 = var0.getContext();
                    JobKt.ensureActive(var2_1);
                    var1_2 /* !! */  = IntrinsicsKt.intercepted(var0);
                    var1_2 /* !! */  = var1_2 /* !! */  instanceof DispatchedContinuation != false ? (DispatchedContinuation)var1_2 /* !! */  : null;
                    if (var1_2 /* !! */  != null) break block4;
                    var1_2 /* !! */  = Unit.INSTANCE;
                    break block5;
                }
                if (!var1_2 /* !! */ .dispatcher.isDispatchNeeded(var2_1)) break block6;
                var1_2 /* !! */ .dispatchYield$kotlinx_coroutines_core(var2_1, Unit.INSTANCE);
                ** GOTO lbl-1000
            }
            var3_3 = new YieldContext();
            var1_2 /* !! */ .dispatchYield$kotlinx_coroutines_core(var2_1.plus((CoroutineContext)var3_3), Unit.INSTANCE);
            if (var3_3.dispatcherWasUnconfined) {
                var1_2 /* !! */  = DispatchedContinuationKt.yieldUndispatched((DispatchedContinuation<? super Unit>)var1_2 /* !! */ ) ? IntrinsicsKt.getCOROUTINE_SUSPENDED() : Unit.INSTANCE;
            } else lbl-1000:
            // 2 sources

            {
                var1_2 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        }
        if (var1_2 /* !! */  == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(var0);
        }
        if (var1_2 /* !! */  == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return var1_2 /* !! */ ;
        }
        return Unit.INSTANCE;
    }
}

