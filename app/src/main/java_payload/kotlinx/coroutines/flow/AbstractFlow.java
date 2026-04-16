/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.AbstractFlow;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.SafeCollector;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2={"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "()V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class AbstractFlow<T>
implements Flow<T>,
CancellableFlow<T> {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public final Object collect(FlowCollector<? super T> var1_1, Continuation<? super Unit> var2_2) {
        if (!(var2_2 /* !! */  instanceof collect.1)) ** GOTO lbl-1000
        var3_4 /* !! */  = var2_2 /* !! */ ;
        if ((var3_4 /* !! */ .label & -2147483648) != 0) {
            var3_4 /* !! */ .label += -2147483648;
            var2_2 /* !! */  = var3_4 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                Object L$0;
                int label;
                Object result;
                final AbstractFlow<T> this$0;
                {
                    this.this$0 = abstractFlow;
                    super(continuation);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.collect(null, (Continuation<Unit>)((Continuation)this));
                }
            };
        }
        var3_4 /* !! */  = var2_2 /* !! */ .result;
        var4_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var2_2 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var2_2 /* !! */  = (SafeCollector)var2_2 /* !! */ .L$0;
                var1_1 /* !! */  = var2_2 /* !! */ ;
                ResultKt.throwOnFailure((Object)var3_4 /* !! */ );
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var3_4 /* !! */ );
                var3_4 /* !! */  = new SafeCollector<T>(var1_1 /* !! */ , var2_2 /* !! */ .getContext());
                var1_1 /* !! */  = var3_4 /* !! */ ;
                var5_6 = (FlowCollector)var3_4 /* !! */ ;
                var1_1 /* !! */  = var3_4 /* !! */ ;
                var2_2 /* !! */ .L$0 = var3_4 /* !! */ ;
                var1_1 /* !! */  = var3_4 /* !! */ ;
                var2_2 /* !! */ .label = 1;
                var1_1 /* !! */  = var3_4 /* !! */ ;
                var5_6 = this.collectSafely((FlowCollector<? super T>)var5_6, (Continuation<? super Unit>)((Continuation<Unit>)var2_2 /* !! */ ));
                var2_2 /* !! */  = var3_4 /* !! */ ;
                if (var5_6 != var4_5) break;
                return var4_5;
            }
        }
        var2_2 /* !! */ .releaseIntercepted();
        return Unit.INSTANCE;
        catch (Throwable var2_3) {
            var1_1 /* !! */ .releaseIntercepted();
            throw var2_3;
        }
    }

    public abstract Object collectSafely(FlowCollector<? super T> var1, Continuation<? super Unit> var2);
}

