/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006\u00a2\u0006\u0002\b\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006\u00a2\u0006\u0002\b\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2={"repeatOnLifecycle", "", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class RepeatOnLifecycleKt {
    public static final Object repeatOnLifecycle(Lifecycle object, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        boolean bl = state != Lifecycle.State.INITIALIZED;
        if (bl) {
            if (((Lifecycle)object).getCurrentState() == Lifecycle.State.DESTROYED) {
                return Unit.INSTANCE;
            }
            if ((object = CoroutineScopeKt.coroutineScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Lifecycle)object, state, function2, null){
                final Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
                final Lifecycle.State $state;
                final Lifecycle $this_repeatOnLifecycle;
                private Object L$0;
                int label;
                {
                    this.$this_repeatOnLifecycle = lifecycle;
                    this.$state = state;
                    this.$block = function2;
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
                            CoroutineScope coroutineScope = (CoroutineScope)this.L$0;
                            object = (CoroutineContext)Dispatchers.getMain().getImmediate();
                            coroutineScope = (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.$this_repeatOnLifecycle, this.$state, coroutineScope, this.$block, null){
                                final CoroutineScope $$this$coroutineScope;
                                final Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
                                final Lifecycle.State $state;
                                final Lifecycle $this_repeatOnLifecycle;
                                Object L$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                Object L$4;
                                Object L$5;
                                int label;
                                {
                                    this.$this_repeatOnLifecycle = lifecycle;
                                    this.$state = state;
                                    this.$$this$coroutineScope = coroutineScope;
                                    this.$block = function2;
                                    super(2, continuation);
                                }

                                public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                }

                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                /*
                                 * Loose catch block
                                 */
                                public final Object invokeSuspend(Object object) {
                                    Object object2;
                                    Object object3;
                                    block15: {
                                        Object object4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            default: {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            case 1: {
                                                object3 = (Function2)this.L$5;
                                                object3 = (CoroutineScope)this.L$4;
                                                object3 = (Lifecycle)this.L$3;
                                                object3 = (Lifecycle.State)((Object)this.L$2);
                                                object4 = (Ref.ObjectRef)this.L$1;
                                                object3 = (Ref.ObjectRef)this.L$0;
                                                try {
                                                    ResultKt.throwOnFailure((Object)object);
                                                    break;
                                                }
                                                catch (Throwable throwable) {
                                                    object2 = object4;
                                                    break block15;
                                                }
                                            }
                                            case 0: {
                                                ResultKt.throwOnFailure((Object)object);
                                                if (this.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                                                    return Unit.INSTANCE;
                                                }
                                                object3 = new Ref.ObjectRef();
                                                object = new Ref.ObjectRef();
                                                Enum enum_ = this.$state;
                                                Lifecycle lifecycle = this.$this_repeatOnLifecycle;
                                                Object object5 = this.$$this$coroutineScope;
                                                Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.$block;
                                                this.L$0 = object3;
                                                this.L$1 = object;
                                                this.L$2 = enum_;
                                                this.L$3 = lifecycle;
                                                this.L$4 = object5;
                                                this.L$5 = function2;
                                                this.label = 1;
                                                Object object6 = (Continuation)this;
                                                Object object7 = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)object6), 1);
                                                ((CancellableContinuationImpl)object7).initCancellability();
                                                CancellableContinuation cancellableContinuation = (CancellableContinuation)object7;
                                                object6 = Lifecycle.Event.Companion.upTo((Lifecycle.State)enum_);
                                                enum_ = Lifecycle.Event.Companion.downFrom((Lifecycle.State)enum_);
                                                Mutex mutex = MutexKt.Mutex$default(false, 1, null);
                                                LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver((Lifecycle.Event)((Object)object6), (Ref.ObjectRef<Job>)object3, (CoroutineScope)object5, (Lifecycle.Event)enum_, cancellableContinuation, mutex, function2){
                                                    final CoroutineScope $$this$coroutineScope;
                                                    final Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
                                                    final Lifecycle.Event $cancelWorkEvent;
                                                    final CancellableContinuation<Unit> $cont;
                                                    final Ref.ObjectRef<Job> $launchedJob;
                                                    final Mutex $mutex;
                                                    final Lifecycle.Event $startWorkEvent;
                                                    {
                                                        this.$startWorkEvent = event;
                                                        this.$launchedJob = objectRef;
                                                        this.$$this$coroutineScope = coroutineScope;
                                                        this.$cancelWorkEvent = event2;
                                                        this.$cont = cancellableContinuation;
                                                        this.$mutex = mutex;
                                                        this.$block = function2;
                                                    }

                                                    public final void onStateChanged(LifecycleOwner object, Lifecycle.Event event) {
                                                        Intrinsics.checkNotNullParameter((Object)object, (String)"<anonymous parameter 0>");
                                                        Intrinsics.checkNotNullParameter((Object)((Object)event), (String)"event");
                                                        if (event == this.$startWorkEvent) {
                                                            this.$launchedJob.element = BuildersKt.launch$default(this.$$this$coroutineScope, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.$mutex, this.$block, null){
                                                                final Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
                                                                final Mutex $mutex;
                                                                Object L$0;
                                                                Object L$1;
                                                                int label;
                                                                {
                                                                    this.$mutex = mutex;
                                                                    this.$block = function2;
                                                                    super(2, continuation);
                                                                }

                                                                public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                                                                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                                                }

                                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                    return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                }

                                                                /*
                                                                 * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
                                                                 * Enabled aggressive block sorting
                                                                 * Enabled unnecessary exception pruning
                                                                 * Enabled aggressive exception aggregation
                                                                 */
                                                                public final Object invokeSuspend(Object object) {
                                                                    Object object2;
                                                                    block12: {
                                                                        Object object3;
                                                                        block11: {
                                                                            Object object4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                            switch (this.label) {
                                                                                default: {
                                                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                }
                                                                                case 2: {
                                                                                    object3 = object2 = (Continuation)this.L$0;
                                                                                    try {
                                                                                        ResultKt.throwOnFailure((Object)object);
                                                                                        object = object2;
                                                                                        break block11;
                                                                                    }
                                                                                    catch (Throwable throwable) {
                                                                                        object2 = object3;
                                                                                        break block12;
                                                                                    }
                                                                                }
                                                                                case 1: {
                                                                                    object3 = (Function2)this.L$1;
                                                                                    object2 = (Mutex)this.L$0;
                                                                                    ResultKt.throwOnFailure((Object)object);
                                                                                    object = object2;
                                                                                    break;
                                                                                }
                                                                                case 0: {
                                                                                    ResultKt.throwOnFailure((Object)object);
                                                                                    object = this.$mutex;
                                                                                    object3 = this.$block;
                                                                                    object2 = (Continuation)this;
                                                                                    this.L$0 = object;
                                                                                    this.L$1 = object3;
                                                                                    this.label = 1;
                                                                                    if (object.lock(null, (Continuation<? super Unit>)object2) != object4) break;
                                                                                    return object4;
                                                                                }
                                                                            }
                                                                            try {
                                                                                object2 = new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>)object3, null){
                                                                                    final Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
                                                                                    private Object L$0;
                                                                                    int label;
                                                                                    {
                                                                                        this.$block = function2;
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

                                                                                    public final Object invokeSuspend(Object function2) {
                                                                                        Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                                        switch (this.label) {
                                                                                            default: {
                                                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                            }
                                                                                            case 1: {
                                                                                                ResultKt.throwOnFailure((Object)function2);
                                                                                                break;
                                                                                            }
                                                                                            case 0: {
                                                                                                ResultKt.throwOnFailure((Object)function2);
                                                                                                CoroutineScope coroutineScope = (CoroutineScope)this.L$0;
                                                                                                function2 = this.$block;
                                                                                                this.label = 1;
                                                                                                if (function2.invoke((Object)coroutineScope, (Object)((Object)this)) != object) break;
                                                                                                return object;
                                                                                            }
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                };
                                                                                object3 = (Function2)object2;
                                                                                this.L$0 = object;
                                                                                this.L$1 = null;
                                                                                this.label = 2;
                                                                                object3 = CoroutineScopeKt.coroutineScope(object3, this);
                                                                                if (object3 == object4) {
                                                                                    return object4;
                                                                                }
                                                                            }
                                                                            catch (Throwable throwable) {
                                                                                object2 = object;
                                                                                object = throwable;
                                                                                break block12;
                                                                            }
                                                                        }
                                                                        object3 = object;
                                                                        {
                                                                            object2 = Unit.INSTANCE;
                                                                            object.unlock(null);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }
                                                                    object2.unlock(null);
                                                                    throw object;
                                                                }
                                                            }, 3, null);
                                                            return;
                                                        }
                                                        if (event == this.$cancelWorkEvent) {
                                                            object = (Job)this.$launchedJob.element;
                                                            if (object != null) {
                                                                Job.DefaultImpls.cancel$default((Job)object, null, 1, null);
                                                            }
                                                            this.$launchedJob.element = null;
                                                        }
                                                        if (event == Lifecycle.Event.ON_DESTROY) {
                                                            event = this.$cont;
                                                            object = Result.Companion;
                                                            event.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
                                                        }
                                                    }
                                                };
                                                object5 = ((Ref.ObjectRef)object).element = lifecycleEventObserver;
                                                Intrinsics.checkNotNull((Object)object5, (String)"null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");
                                                lifecycle.addObserver((LifecycleEventObserver)object5);
                                                object7 = ((CancellableContinuationImpl)object7).getResult();
                                                if (object7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                    DebugProbesKt.probeCoroutineSuspended((Continuation)((Continuation)this));
                                                }
                                                if (object7 == object4) {
                                                    return object4;
                                                }
                                                object4 = object;
                                            }
                                        }
                                        object = (Job)object3.element;
                                        if (object != null) {
                                            Job.DefaultImpls.cancel$default((Job)object, null, 1, null);
                                        }
                                        if ((object = (LifecycleEventObserver)((Ref.ObjectRef)object4).element) != null) {
                                            this.$this_repeatOnLifecycle.removeObserver((LifecycleObserver)object);
                                        }
                                        return Unit.INSTANCE;
                                        catch (Throwable throwable) {
                                            object2 = object;
                                            object = throwable;
                                        }
                                    }
                                    object3 = (Job)object3.element;
                                    if (object3 != null) {
                                        Job.DefaultImpls.cancel$default((Job)object3, null, 1, null);
                                    }
                                    if ((object3 = (LifecycleEventObserver)((Ref.ObjectRef)object2).element) != null) {
                                        this.$this_repeatOnLifecycle.removeObserver((LifecycleObserver)object3);
                                    }
                                    throw object;
                                }
                            };
                            Continuation continuation = (Continuation)this;
                            this.label = 1;
                            if (BuildersKt.withContext((CoroutineContext)object, coroutineScope, continuation) != object2) break;
                            return object2;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return object;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    }

    public static final Object repeatOnLifecycle(LifecycleOwner object, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        if ((object = RepeatOnLifecycleKt.repeatOnLifecycle(object.getLifecycle(), state, function2, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }
}

