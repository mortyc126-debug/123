/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__CollectKt;
import kotlinx.coroutines.flow.internal.NopCollector;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0003\u001aV\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u000223\b\u0004\u0010\u0005\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006H\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u001ak\u0010\r\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00022H\b\u0004\u0010\u0005\u001aB\b\u0001\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u0011H\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000eH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001aT\u0010\u0012\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u000221\u0010\u0005\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u001a/\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u001a\u001e\u0010\u0017\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00022\u0006\u0010\u0019\u001a\u00020\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2={"collect", "", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectIndexed", "Lkotlin/Function3;", "", "index", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectLatest", "emitAll", "Lkotlinx/coroutines/flow/FlowCollector;", "flow", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchIn", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__CollectKt {
    public static final Object collect(Flow<?> object, Continuation<? super Unit> continuation) {
        if ((object = object.collect(NopCollector.INSTANCE, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Backwards compatibility with JS and K/N")
    public static final /* synthetic */ <T> Object collect(Flow<? extends T> object, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        if ((object = object.collect(new FlowCollector<T>(function2){
            final Function2<T, Continuation<? super Unit>, Object> $action;
            {
                this.$action = function2;
            }

            public Object emit(T object, Continuation<? super Unit> continuation) {
                if ((object = this.$action.invoke(object, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            public Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, continuation){
                    int label;
                    Object result;
                    final collect.3<T> this$0;
                    {
                        this.this$0 = var1_1;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.emit(null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
                InlineMarker.mark((int)5);
                this.$action.invoke(t, continuation);
                return Unit.INSTANCE;
            }
        }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Backwards compatibility with JS and K/N")
    private static final /* synthetic */ <T> Object collect$$forInline(Flow<? extends T> flow2, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> object, Continuation<? super Unit> continuation) {
        object = new /* invalid duplicate definition of identical inner class */;
        InlineMarker.mark((int)0);
        flow2.collect((FlowCollector<T>)object, (Continuation<Unit>)continuation);
        InlineMarker.mark((int)1);
        return Unit.INSTANCE;
    }

    public static final <T> Object collectIndexed(Flow<? extends T> object, Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        if ((object = object.collect(new FlowCollector<T>(function3){
            final Function3<Integer, T, Continuation<? super Unit>, Object> $action;
            private int index;
            {
                this.$action = function3;
            }

            public Object emit(T object, Continuation<? super Unit> continuation) {
                Function3<Integer, T, Continuation<? super Unit>, Object> function3 = this.$action;
                int n = this.index;
                this.index = n + 1;
                if (n >= 0) {
                    object = function3.invoke((Object)Boxing.boxInt((int)n), object, continuation);
                    if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return object;
                    }
                    return Unit.INSTANCE;
                }
                throw new ArithmeticException("Index overflow has happened");
            }

            public Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, continuation){
                    int label;
                    Object result;
                    final collectIndexed.2<T> this$0;
                    {
                        this.this$0 = var1_1;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.emit(null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
                InlineMarker.mark((int)5);
                Function3<Integer, T, Continuation<? super Unit>, Object> function3 = this.$action;
                int n = this.index;
                this.index = n + 1;
                if (n >= 0) {
                    function3.invoke((Object)n, t, continuation);
                    return Unit.INSTANCE;
                }
                throw new ArithmeticException("Index overflow has happened");
            }
        }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private static final <T> Object collectIndexed$$forInline(Flow<? extends T> flow2, Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> object, Continuation<? super Unit> continuation) {
        object = new /* invalid duplicate definition of identical inner class */;
        InlineMarker.mark((int)0);
        flow2.collect((FlowCollector<T>)object, (Continuation<Unit>)continuation);
        InlineMarker.mark((int)1);
        return Unit.INSTANCE;
    }

    public static final <T> Object collectLatest(Flow<? extends T> object, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        if ((object = FlowKt.collect(FlowKt.buffer$default(FlowKt.mapLatest(object, function2), 0, null, 2, null), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public static final <T> Object emitAll(FlowCollector<? super T> object, Flow<? extends T> flow2, Continuation<? super Unit> continuation) {
        FlowKt.ensureActive(object);
        object = flow2.collect((FlowCollector<? super T>)object, (Continuation<Unit>)continuation);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public static final <T> Job launchIn(Flow<? extends T> flow2, CoroutineScope coroutineScope) {
        return BuildersKt.launch$default(coroutineScope, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(flow2, null){
            final Flow<T> $this_launchIn;
            int label;
            {
                this.$this_launchIn = flow2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)object);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        Flow<T> flow2 = this.$this_launchIn;
                        object = (Continuation)this;
                        this.label = 1;
                        if (FlowKt.collect(flow2, (Continuation<? super Unit>)object) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        }, 3, null);
    }
}

