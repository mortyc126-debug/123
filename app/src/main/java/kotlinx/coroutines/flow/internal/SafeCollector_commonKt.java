/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.flow.internal.SafeCollector_commonKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0005\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004\u00a2\u0006\u0002\b\tH\u0081\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0080\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2={"unsafeFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "checkContext", "Lkotlinx/coroutines/flow/internal/SafeCollector;", "currentContext", "Lkotlin/coroutines/CoroutineContext;", "transitiveCoroutineParent", "Lkotlinx/coroutines/Job;", "collectJob", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class SafeCollector_commonKt {
    public static final void checkContext(SafeCollector<?> object, CoroutineContext coroutineContext) {
        if (((Number)coroutineContext.fold((Object)0, (Function2)new Function2<Integer, CoroutineContext.Element, Integer>(object){
            final SafeCollector<?> $this_checkContext;
            {
                this.$this_checkContext = safeCollector;
                super(2);
            }

            public final Integer invoke(int n, CoroutineContext.Element object) {
                Object object2 = object.getKey();
                Object object3 = this.$this_checkContext.collectContext.get(object2);
                if (object2 != Job.Key) {
                    n = object != object3 ? Integer.MIN_VALUE : ++n;
                    return n;
                }
                object2 = (Job)object3;
                Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.Job");
                object = SafeCollector_commonKt.transitiveCoroutineParent((Job)object, (Job)object2);
                if (object == object2) {
                    if (object2 != null) {
                        ++n;
                    }
                    return n;
                }
                object3 = new StringBuilder().append("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of ");
                object = ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object).append(", expected child of ");
                object = ((StringBuilder)object).append(object2);
                throw new IllegalStateException(((StringBuilder)object).append(".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString().toString());
            }
        })).intValue() == ((SafeCollector)object).collectContextSize) {
            return;
        }
        object = new StringBuilder().append("Flow invariant is violated:\n\t\tFlow was collected in ").append(((SafeCollector)object).collectContext);
        object = ((StringBuilder)object).append(",\n\t\tbut emission happened in ");
        object = ((StringBuilder)object).append(coroutineContext);
        throw new IllegalStateException(((StringBuilder)object).append(".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString().toString());
    }

    public static final Job transitiveCoroutineParent(Job job2, Job job3) {
        while (job2 != null) {
            if (job2 == job3) {
                return job2;
            }
            if (!(job2 instanceof ScopeCoroutine)) {
                return job2;
            }
            job2 = job2.getParent();
        }
        return null;
    }

    public static final <T> Flow<T> unsafeFlow(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new Flow<T>(function2){
            final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> $block;
            {
                this.$block = function2;
            }

            public Object collect(FlowCollector<? super T> object, Continuation<? super Unit> continuation) {
                if ((object = this.$block.invoke(object, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            public Object collect$$forInline(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, continuation){
                    int label;
                    Object result;
                    final unsafeFlow.1<T> this$0;
                    {
                        this.this$0 = var1_1;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect(null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
                InlineMarker.mark((int)5);
                this.$block.invoke(flowCollector, continuation);
                return Unit.INSTANCE;
            }
        };
    }
}

