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

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__CollectionKt;

@Metadata(d1={"\u0000(\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010#\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0010\b\u0001\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u001a7\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2={"toCollection", "C", "T", "", "Lkotlinx/coroutines/flow/Flow;", "destination", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSet", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__CollectionKt {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T, C extends Collection<? super T>> Object toCollection(Flow<? extends T> var0, C var1_1, Continuation<? super C> var2_2) {
        if (!(var2_2 /* !! */  instanceof toCollection.1)) ** GOTO lbl-1000
        var3_3 /* !! */  = var2_2 /* !! */ ;
        if ((var3_3 /* !! */ .label & -2147483648) != 0) {
            var3_3 /* !! */ .label += -2147483648;
            var2_2 /* !! */  = var3_3 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var2_2 /* !! */  = new ContinuationImpl(var2_2 /* !! */ ){
                Object L$0;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt.toCollection(null, null, (Continuation)this);
                }
            };
        }
        var3_3 /* !! */  = var2_2 /* !! */ .result;
        var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var2_2 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var1_1 /* !! */  = (Collection)var2_2 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var3_3 /* !! */ );
                var3_3 /* !! */  = new FlowCollector(var1_1 /* !! */ ){
                    final C $destination;
                    {
                        this.$destination = c;
                    }

                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        this.$destination.add(t);
                        return Unit.INSTANCE;
                    }
                };
                var2_2 /* !! */ .L$0 = var1_1 /* !! */ ;
                var2_2 /* !! */ .label = 1;
                if (var0.collect((FlowCollector<T>)var3_3 /* !! */ , (Continuation<Unit>)var2_2 /* !! */ ) != var4_4) break;
                return var4_4;
            }
        }
        return var1_1 /* !! */ ;
    }

    public static final <T> Object toList(Flow<? extends T> flow2, List<T> list, Continuation<? super List<? extends T>> continuation) {
        return FlowKt.toCollection(flow2, (Collection)list, continuation);
    }

    public static /* synthetic */ Object toList$default(Flow flow2, List list, Continuation continuation, int n, Object object) {
        if ((n & 1) != 0) {
            list = new ArrayList();
        }
        return FlowKt.toList(flow2, list, continuation);
    }

    public static final <T> Object toSet(Flow<? extends T> flow2, Set<T> set, Continuation<? super Set<? extends T>> continuation) {
        return FlowKt.toCollection(flow2, (Collection)set, continuation);
    }

    public static /* synthetic */ Object toSet$default(Flow flow2, Set set, Continuation continuation, int n, Object object) {
        if ((n & 1) != 0) {
            set = new LinkedHashSet();
        }
        return FlowKt.toSet(flow2, set, continuation);
    }
}

