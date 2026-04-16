/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ShareKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.SharingConfig;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.SubscribedSharedFlow;
import kotlinx.coroutines.flow.internal.ChannelFlow;

@Metadata(d1={"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u00a2\u0006\u0002\b\f\u001aM\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0002H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001aA\u0010\u0019\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0002*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\t2\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u001cH\u0002\u00a2\u0006\u0002\b\u001d\u001aS\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012-\u0010\u001f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\"\u0012\u0006\u0012\u0004\u0018\u00010#0 \u00a2\u0006\u0002\b$\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%\u001a6\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a/\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010'\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)\u001a9\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010*\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2={"asSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "T", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "asStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "configureSharing", "Lkotlinx/coroutines/flow/SharingConfig;", "Lkotlinx/coroutines/flow/Flow;", "replay", "", "configureSharing$FlowKt__ShareKt", "launchSharing", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "upstream", "shared", "started", "Lkotlinx/coroutines/flow/SharingStarted;", "initialValue", "launchSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/Job;", "launchSharingDeferred", "", "result", "Lkotlinx/coroutines/CompletableDeferred;", "launchSharingDeferred$FlowKt__ShareKt", "onSubscription", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/SharedFlow;", "shareIn", "scope", "stateIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ShareKt {
    public static final <T> SharedFlow<T> asSharedFlow(MutableSharedFlow<T> mutableSharedFlow) {
        return new ReadonlySharedFlow(mutableSharedFlow, null);
    }

    public static final <T> StateFlow<T> asStateFlow(MutableStateFlow<T> mutableStateFlow) {
        return new ReadonlyStateFlow(mutableStateFlow, null);
    }

    private static final <T> SharingConfig<T> configureSharing$FlowKt__ShareKt(Flow<? extends T> flow2, int n) {
        Flow flow3;
        int n2;
        boolean bl = DebugKt.getASSERTIONS_ENABLED();
        int n3 = 1;
        if (bl && (n2 = n >= 0 ? 1 : 0) == 0) {
            throw new AssertionError();
        }
        n2 = RangesKt.coerceAtLeast((int)n, (int)Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core()) - n;
        if (flow2 instanceof ChannelFlow && (flow3 = ((ChannelFlow)flow2).dropChannelOperators()) != null) {
            switch (((ChannelFlow)flow2).capacity) {
                default: {
                    n = ((ChannelFlow)flow2).capacity;
                    break;
                }
                case -3: 
                case -2: 
                case 0: {
                    if (((ChannelFlow)flow2).onBufferOverflow == BufferOverflow.SUSPEND) {
                        if (((ChannelFlow)flow2).capacity == 0) {
                            n = 0;
                            break;
                        }
                        n = n2;
                        break;
                    }
                    n = n == 0 ? n3 : 0;
                }
            }
            return new SharingConfig(flow3, n, ((ChannelFlow)flow2).onBufferOverflow, ((ChannelFlow)flow2).context);
        }
        return new SharingConfig<T>(flow2, n2, BufferOverflow.SUSPEND, (CoroutineContext)EmptyCoroutineContext.INSTANCE);
    }

    private static final <T> Job launchSharing$FlowKt__ShareKt(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Flow<? extends T> flow2, MutableSharedFlow<T> mutableSharedFlow, SharingStarted sharingStarted, T t) {
        CoroutineStart coroutineStart = Intrinsics.areEqual((Object)sharingStarted, (Object)SharingStarted.Companion.getEagerly()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED;
        return BuildersKt.launch(coroutineScope, coroutineContext, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(sharingStarted, flow2, mutableSharedFlow, t, null){
            final T $initialValue;
            final MutableSharedFlow<T> $shared;
            final SharingStarted $started;
            final Flow<T> $upstream;
            int label;
            {
                this.$started = sharingStarted;
                this.$upstream = flow2;
                this.$shared = mutableSharedFlow;
                this.$initialValue = t;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2;
                block9: {
                    Continuation continuation;
                    Object object3;
                    object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 4: {
                            ResultKt.throwOnFailure((Object)object);
                            return Unit.INSTANCE;
                        }
                        case 3: {
                            ResultKt.throwOnFailure((Object)object);
                            return Unit.INSTANCE;
                        }
                        case 2: {
                            ResultKt.throwOnFailure((Object)object);
                            break;
                        }
                        case 1: {
                            ResultKt.throwOnFailure((Object)object);
                            return Unit.INSTANCE;
                        }
                        case 0: {
                            ResultKt.throwOnFailure((Object)object);
                            if (this.$started == SharingStarted.Companion.getEagerly()) {
                                Flow<T> flow2 = this.$upstream;
                                object = this.$shared;
                                Continuation continuation2 = (Continuation)this;
                                this.label = 1;
                                if (flow2.collect((FlowCollector<T>)object, (Continuation<Unit>)continuation2) != object2) return Unit.INSTANCE;
                                return object2;
                            }
                            if (this.$started == SharingStarted.Companion.getLazily()) {
                                object3 = this.$shared.getSubscriptionCount();
                                object = (Function2)new Function2<Integer, Continuation<? super Boolean>, Object>(null){
                                    int I$0;
                                    int label;

                                    public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                                        object2 = new /* invalid duplicate definition of identical inner class */;
                                        object2.I$0 = ((Number)object).intValue();
                                        return object2;
                                    }

                                    public final Object invoke(int n, Continuation<? super Boolean> continuation) {
                                        return (this.create(n, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    public final Object invokeSuspend(Object object) {
                                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            default: {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            case 0: 
                                        }
                                        ResultKt.throwOnFailure((Object)object);
                                        boolean bl = this.I$0 > 0;
                                        return Boxing.boxBoolean((boolean)bl);
                                    }
                                };
                                continuation = (Continuation)this;
                                this.label = 2;
                                if (FlowKt.first(object3, object, continuation) != object2) break;
                                return object2;
                            }
                            break block9;
                        }
                    }
                    continuation = this.$upstream;
                    object3 = this.$shared;
                    object = (Continuation)this;
                    this.label = 3;
                    if (continuation.collect(object3, (Continuation<? super Unit>)((Continuation<Unit>)object)) != object2) return Unit.INSTANCE;
                    return object2;
                }
                Flow<SharingCommand> flow3 = FlowKt.distinctUntilChanged(this.$started.command(this.$shared.getSubscriptionCount()));
                object = (Function2)new Function2<SharingCommand, Continuation<? super Unit>, Object>(this.$upstream, this.$shared, this.$initialValue, null){
                    final T $initialValue;
                    final MutableSharedFlow<T> $shared;
                    final Flow<T> $upstream;
                    Object L$0;
                    int label;
                    {
                        this.$upstream = flow2;
                        this.$shared = mutableSharedFlow;
                        this.$initialValue = t;
                        super(2, continuation);
                    }

                    public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                        object2 = new /* invalid duplicate definition of identical inner class */;
                        object2.L$0 = object;
                        return object2;
                    }

                    public final Object invoke(SharingCommand sharingCommand, Continuation<? super Unit> continuation) {
                        return (this.create((Object)((Object)sharingCommand), continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object object) {
                        Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        block0 : switch (this.label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 1: {
                                ResultKt.throwOnFailure((Object)object);
                                break;
                            }
                            case 0: {
                                ResultKt.throwOnFailure((Object)object);
                                object = (SharingCommand)((Object)this.L$0);
                                switch (launchSharing.WhenMappings.$EnumSwitchMapping$0[((Enum)object).ordinal()]) {
                                    default: {
                                        break block0;
                                    }
                                    case 3: {
                                        if (this.$initialValue == SharedFlowKt.NO_VALUE) {
                                            this.$shared.resetReplayCache();
                                            break block0;
                                        }
                                        this.$shared.tryEmit(this.$initialValue);
                                        break block0;
                                    }
                                    case 2: {
                                        break block0;
                                    }
                                    case 1: 
                                }
                                Flow<T> flow2 = this.$upstream;
                                object = this.$shared;
                                Continuation continuation = (Continuation)this;
                                this.label = 1;
                                if (flow2.collect((FlowCollector<T>)object, (Continuation<Unit>)continuation) != object2) break;
                                return object2;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                Continuation continuation = (Continuation)this;
                this.label = 4;
                if (FlowKt.collectLatest(flow3, object, (Continuation<? super Unit>)continuation) != object2) return Unit.INSTANCE;
                return object2;
            }
        }));
    }

    private static final <T> void launchSharingDeferred$FlowKt__ShareKt(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Flow<? extends T> flow2, CompletableDeferred<StateFlow<T>> completableDeferred) {
        BuildersKt.launch$default(coroutineScope, coroutineContext, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(flow2, completableDeferred, null){
            final CompletableDeferred<StateFlow<T>> $result;
            final Flow<T> $upstream;
            private Object L$0;
            int label;
            {
                this.$upstream = flow2;
                this.$result = completableDeferred;
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

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final Object invokeSuspend(Object object) {
                void var1_4;
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        try {
                            ResultKt.throwOnFailure((Object)object);
                            return Unit.INSTANCE;
                        }
                        catch (Throwable throwable) {
                            break;
                        }
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        CoroutineScope coroutineScope = (CoroutineScope)this.L$0;
                        try {
                            Object object3 = new Ref.ObjectRef();
                            object = this.$upstream;
                            FlowCollector flowCollector = new FlowCollector(object3, coroutineScope, this.$result){
                                final CoroutineScope $$this$launch;
                                final CompletableDeferred<StateFlow<T>> $result;
                                final Ref.ObjectRef<MutableStateFlow<T>> $state;
                                {
                                    this.$state = objectRef;
                                    this.$$this$launch = coroutineScope;
                                    this.$result = completableDeferred;
                                }

                                public final Object emit(T object, Continuation<? super Unit> object2) {
                                    object2 = (MutableStateFlow)this.$state.element;
                                    if (object2 != null) {
                                        object2.setValue(object);
                                        object2 = Unit.INSTANCE;
                                    } else {
                                        object2 = null;
                                    }
                                    if (object2 == null) {
                                        CoroutineScope coroutineScope = this.$$this$launch;
                                        object2 = this.$state;
                                        CompletableDeferred<StateFlow<ReadonlyStateFlow<T>>> completableDeferred = this.$result;
                                        object = StateFlowKt.MutableStateFlow(object);
                                        completableDeferred.complete(new ReadonlyStateFlow<T>((StateFlow)object, JobKt.getJob(coroutineScope.getCoroutineContext())));
                                        ((Ref.ObjectRef)object2).element = object;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            object3 = flowCollector;
                            flowCollector = (FlowCollector)((Object)this);
                            this.label = 1;
                            object = object.collect(object3, (Continuation<? super Unit>)((Continuation<Unit>)flowCollector));
                            if (object != object2) return Unit.INSTANCE;
                            return object2;
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                }
                this.$result.completeExceptionally((Throwable)var1_4);
                throw var1_4;
            }
        }, 2, null);
    }

    public static final <T> SharedFlow<T> onSubscription(SharedFlow<? extends T> sharedFlow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new SubscribedSharedFlow<T>(sharedFlow, function2);
    }

    public static final <T> SharedFlow<T> shareIn(Flow<? extends T> flow2, CoroutineScope object, SharingStarted sharingStarted, int n) {
        SharingConfig<? extends T> sharingConfig = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt(flow2, n);
        flow2 = SharedFlowKt.MutableSharedFlow(n, sharingConfig.extraBufferCapacity, sharingConfig.onBufferOverflow);
        object = FlowKt__ShareKt.launchSharing$FlowKt__ShareKt((CoroutineScope)object, sharingConfig.context, sharingConfig.upstream, flow2, sharingStarted, (Object)SharedFlowKt.NO_VALUE);
        return new ReadonlySharedFlow((SharedFlow)flow2, (Job)object);
    }

    public static /* synthetic */ SharedFlow shareIn$default(Flow flow2, CoroutineScope coroutineScope, SharingStarted sharingStarted, int n, int n2, Object object) {
        if ((n2 & 4) != 0) {
            n = 0;
        }
        return FlowKt.shareIn(flow2, coroutineScope, sharingStarted, n);
    }

    public static final <T> Object stateIn(Flow<? extends T> object, CoroutineScope coroutineScope, Continuation<? super StateFlow<? extends T>> continuation) {
        SharingConfig<? extends T> sharingConfig = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt(object, 1);
        object = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        FlowKt__ShareKt.launchSharingDeferred$FlowKt__ShareKt(coroutineScope, sharingConfig.context, sharingConfig.upstream, object);
        return object.await(continuation);
    }

    public static final <T> StateFlow<T> stateIn(Flow<? extends T> flow2, CoroutineScope object, SharingStarted sharingStarted, T t) {
        SharingConfig<? extends T> sharingConfig = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt(flow2, 1);
        flow2 = StateFlowKt.MutableStateFlow(t);
        object = FlowKt__ShareKt.launchSharing$FlowKt__ShareKt((CoroutineScope)object, sharingConfig.context, sharingConfig.upstream, (MutableSharedFlow)flow2, sharingStarted, t);
        return new ReadonlyStateFlow((StateFlow)flow2, (Job)object);
    }
}

