/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.FusibleFlow;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u001f\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u00a4@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH$J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 H\u0016J&\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u001c\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R9\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b8@X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00068@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectToFun", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "produceCapacity", "getProduceCapacity$kotlinx_coroutines_core", "()I", "additionalToStringProps", "", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "fuse", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class ChannelFlow<T>
implements FusibleFlow<T> {
    public final int capacity;
    public final CoroutineContext context;
    public final BufferOverflow onBufferOverflow;

    public ChannelFlow(CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        this.context = coroutineContext;
        this.capacity = n;
        this.onBufferOverflow = bufferOverflow;
        if (DebugKt.getASSERTIONS_ENABLED() && (n = this.capacity != -1 ? 1 : 0) == 0) {
            throw new AssertionError();
        }
    }

    static /* synthetic */ <T> Object collect$suspendImpl(ChannelFlow<T> object, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        if ((object = CoroutineScopeKt.coroutineScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(flowCollector, object, null){
            final FlowCollector<T> $collector;
            private Object L$0;
            int label;
            final ChannelFlow<T> this$0;
            {
                this.$collector = flowCollector;
                this.this$0 = channelFlow;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object flowCollector) {
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)flowCollector);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)flowCollector);
                        Object object2 = (CoroutineScope)this.L$0;
                        flowCollector = this.$collector;
                        object2 = this.this$0.produceImpl((CoroutineScope)object2);
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (FlowKt.emitAll(flowCollector, object2, (Continuation<? super Unit>)continuation) != object) break;
                        return object;
                    }
                }
                return Unit.INSTANCE;
            }
        }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    protected String additionalToStringProps() {
        return null;
    }

    @Override
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ChannelFlow.collect$suspendImpl(this, flowCollector, continuation);
    }

    protected abstract Object collectTo(ProducerScope<? super T> var1, Continuation<? super Unit> var2);

    protected abstract ChannelFlow<T> create(CoroutineContext var1, int var2, BufferOverflow var3);

    public Flow<T> dropChannelOperators() {
        return null;
    }

    @Override
    public Flow<T> fuse(CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow) {
        boolean bl;
        boolean bl2 = DebugKt.getASSERTIONS_ENABLED();
        boolean bl3 = true;
        if (bl2 && !(bl = n != -1)) {
            throw new AssertionError();
        }
        coroutineContext = coroutineContext.plus(this.context);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            if (this.capacity != -3) {
                if (n == -3) {
                    n = this.capacity;
                } else if (this.capacity != -2) {
                    if (n == -2) {
                        n = this.capacity;
                    } else {
                        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = this.capacity >= 0)) {
                            throw new AssertionError();
                        }
                        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = n >= 0 ? bl3 : false)) {
                            throw new AssertionError();
                        }
                        if ((n = this.capacity + n) < 0) {
                            n = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            bufferOverflow = this.onBufferOverflow;
        }
        if (Intrinsics.areEqual((Object)coroutineContext, (Object)this.context) && n == this.capacity && bufferOverflow == this.onBufferOverflow) {
            return this;
        }
        return this.create(coroutineContext, n, bufferOverflow);
    }

    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> getCollectToFun$kotlinx_coroutines_core() {
        return new Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object>(this, null){
            Object L$0;
            int label;
            final ChannelFlow<T> this$0;
            {
                this.this$0 = channelFlow;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        ProducerScope producerScope = (ProducerScope)this.L$0;
                        ChannelFlow<T> channelFlow = this.this$0;
                        object = (Continuation)this;
                        this.label = 1;
                        if (channelFlow.collectTo(producerScope, (Continuation<Unit>)object) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        };
    }

    public final int getProduceCapacity$kotlinx_coroutines_core() {
        int n = this.capacity == -3 ? -2 : this.capacity;
        return n;
    }

    public ReceiveChannel<T> produceImpl(CoroutineScope coroutineScope) {
        return ProduceKt.produce$default(coroutineScope, this.context, this.getProduceCapacity$kotlinx_coroutines_core(), this.onBufferOverflow, CoroutineStart.ATOMIC, null, this.getCollectToFun$kotlinx_coroutines_core(), 16, null);
    }

    public String toString() {
        ArrayList<String> arrayList = new ArrayList<String>(4);
        String string2 = this.additionalToStringProps();
        if (string2 != null) {
            arrayList.add(string2);
        }
        if (this.context != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + this.context);
        }
        if (this.capacity != -3) {
            arrayList.add("capacity=" + this.capacity);
        }
        if (this.onBufferOverflow != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + (Object)((Object)this.onBufferOverflow));
        }
        return DebugStringsKt.getClassSimpleName(this) + '[' + CollectionsKt.joinToString$default((Iterable)arrayList, (CharSequence)", ", null, null, (int)0, null, null, (int)62, null) + ']';
    }
}

