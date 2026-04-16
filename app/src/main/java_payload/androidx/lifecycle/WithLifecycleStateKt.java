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
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleDestroyedException;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.WithLifecycleStateKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1={"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aA\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0081@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u001a+\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u001a+\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a+\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u001a+\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a3\u0010\u0012\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001a3\u0010\u0012\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u001a3\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0081H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2={"suspendWithStateAtLeastUnchecked", "R", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "dispatchNeeded", "", "lifecycleDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "block", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withResumed", "withStarted", "withStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "lifecycle-runtime-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class WithLifecycleStateKt {
    public static final <R> Object suspendWithStateAtLeastUnchecked(Lifecycle object, Lifecycle.State object2, boolean bl, CoroutineDispatcher coroutineDispatcher, Function0<? extends R> function0, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        object2 = new LifecycleEventObserver((Lifecycle.State)((Object)object2), (Lifecycle)object, cancellableContinuation, function0){
            final Function0<R> $block;
            final CancellableContinuation<R> $co;
            final Lifecycle.State $state;
            final Lifecycle $this_suspendWithStateAtLeastUnchecked;
            {
                this.$state = state;
                this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
                this.$co = cancellableContinuation;
                this.$block = function0;
            }

            public void onStateChanged(LifecycleOwner object, Lifecycle.Event object2) {
                Intrinsics.checkNotNullParameter((Object)object, (String)"source");
                Intrinsics.checkNotNullParameter((Object)object2, (String)"event");
                if (object2 == Lifecycle.Event.Companion.upTo(this.$state)) {
                    this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
                    object2 = this.$co;
                    Function0<R> function0 = this.$block;
                    try {
                        object = Result.Companion;
                        object = Result.constructor-impl((Object)function0.invoke());
                    }
                    catch (Throwable throwable) {
                        object = Result.Companion;
                        object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                    }
                    object2.resumeWith(object);
                } else if (object2 == Lifecycle.Event.ON_DESTROY) {
                    this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
                    object = this.$co;
                    object2 = Result.Companion;
                    object.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)new LifecycleDestroyedException())));
                }
            }
        };
        if (bl) {
            coroutineDispatcher.dispatch((CoroutineContext)EmptyCoroutineContext.INSTANCE, new Runnable((Lifecycle)object, object2){
                final suspendWithStateAtLeastUnchecked.2.observer.1 $observer;
                final Lifecycle $this_suspendWithStateAtLeastUnchecked;
                {
                    this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
                    this.$observer = var2_2;
                }

                public final void run() {
                    this.$this_suspendWithStateAtLeastUnchecked.addObserver(this.$observer);
                }
            });
        } else {
            ((Lifecycle)object).addObserver((LifecycleObserver)object2);
        }
        cancellableContinuation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(coroutineDispatcher, (Lifecycle)object, object2){
            final CoroutineDispatcher $lifecycleDispatcher;
            final suspendWithStateAtLeastUnchecked.2.observer.1 $observer;
            final Lifecycle $this_suspendWithStateAtLeastUnchecked;
            {
                this.$lifecycleDispatcher = coroutineDispatcher;
                this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
                this.$observer = var3_3;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                if (this.$lifecycleDispatcher.isDispatchNeeded((CoroutineContext)EmptyCoroutineContext.INSTANCE)) {
                    this.$lifecycleDispatcher.dispatch((CoroutineContext)EmptyCoroutineContext.INSTANCE, new Runnable(this.$this_suspendWithStateAtLeastUnchecked, this.$observer){
                        final suspendWithStateAtLeastUnchecked.2.observer.1 $observer;
                        final Lifecycle $this_suspendWithStateAtLeastUnchecked;
                        {
                            this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
                            this.$observer = var2_2;
                        }

                        public final void run() {
                            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this.$observer);
                        }
                    });
                } else {
                    this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this.$observer);
                }
            }
        }));
        object = cancellableContinuationImpl.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return object;
    }

    public static final <R> Object withCreated(Lifecycle object, Function0<? extends R> function0, Continuation<? super R> continuation) {
        block2: {
            boolean bl;
            MainCoroutineDispatcher mainCoroutineDispatcher;
            Lifecycle.State state;
            block0: {
                block1: {
                    state = Lifecycle.State.CREATED;
                    mainCoroutineDispatcher = Dispatchers.getMain().getImmediate();
                    bl = mainCoroutineDispatcher.isDispatchNeeded(continuation.getContext());
                    if (bl) break block0;
                    if (((Lifecycle)object).getCurrentState() == Lifecycle.State.DESTROYED) break block1;
                    if (((Lifecycle)object).getCurrentState().compareTo((Enum)state) < 0) break block0;
                    object = function0.invoke();
                    break block2;
                }
                throw new LifecycleDestroyedException();
            }
            object = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked((Lifecycle)object, state, bl, mainCoroutineDispatcher, (Function0)new Function0<R>(function0){
                final Function0<R> $block;
                {
                    this.$block = function0;
                    super(0);
                }

                public final R invoke() {
                    return (R)this.$block.invoke();
                }
            }, continuation);
        }
        return object;
    }

    public static final <R> Object withCreated(LifecycleOwner object, Function0<? extends R> function0, Continuation<? super R> continuation) {
        block2: {
            boolean bl;
            MainCoroutineDispatcher mainCoroutineDispatcher;
            Lifecycle.State state;
            block0: {
                block1: {
                    object = object.getLifecycle();
                    state = Lifecycle.State.CREATED;
                    mainCoroutineDispatcher = Dispatchers.getMain().getImmediate();
                    bl = mainCoroutineDispatcher.isDispatchNeeded(continuation.getContext());
                    if (bl) break block0;
                    if (((Lifecycle)object).getCurrentState() == Lifecycle.State.DESTROYED) break block1;
                    if (((Lifecycle)object).getCurrentState().compareTo((Enum)state) < 0) break block0;
                    object = function0.invoke();
                    break block2;
                }
                throw new LifecycleDestroyedException();
            }
            object = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked((Lifecycle)object, state, bl, mainCoroutineDispatcher, (Function0)new /* invalid duplicate definition of identical inner class */, continuation);
        }
        return object;
    }

    private static final <R> Object withCreated$$forInline(Lifecycle object, Function0<? extends R> function0, Continuation<? super R> continuation) {
        object = Lifecycle.State.CREATED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark((int)3);
        throw new NullPointerException();
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner object, Function0<? extends R> function0, Continuation<? super R> continuation) {
        object.getLifecycle();
        object = Lifecycle.State.CREATED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark((int)3);
        throw new NullPointerException();
    }

    public static final <R> Object withResumed(Lifecycle object, Function0<? extends R> function0, Continuation<? super R> continuation) {
        block2: {
            boolean bl;
            MainCoroutineDispatcher mainCoroutineDispatcher;
            Lifecycle.State state;
            block0: {
                block1: {
                    state = Lifecycle.State.RESUMED;
                    mainCoroutineDispatcher = Dispatchers.getMain().getImmediate();
                    bl = mainCoroutineDispatcher.isDispatchNeeded(continuation.getContext());
                    if (bl) break block0;
                    if (((Lifecycle)object).getCurrentState() == Lifecycle.State.DESTROYED) break block1;
                    if (((Lifecycle)object).getCurrentState().compareTo((Enum)state) < 0) break block0;
                    object = function0.invoke();
                    break block2;
                }
                throw new LifecycleDestroyedException();
            }
            object = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked((Lifecycle)object, state, bl, mainCoroutineDispatcher, (Function0)new /* invalid duplicate definition of identical inner class */, continuation);
        }
        return object;
    }

    public static final <R> Object withResumed(LifecycleOwner object, Function0<? extends R> function0, Continuation<? super R> continuation) {
        block2: {
            boolean bl;
            MainCoroutineDispatcher mainCoroutineDispatcher;
            Lifecycle lifecycle;
            block0: {
                block1: {
                    lifecycle = object.getLifecycle();
                    object = Lifecycle.State.RESUMED;
                    mainCoroutineDispatcher = Dispatchers.getMain().getImmediate();
                    bl = mainCoroutineDispatcher.isDispatchNeeded(continuation.getContext());
                    if (bl) break block0;
                    if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) break block1;
                    if (lifecycle.getCurrentState().compareTo((Enum)object) < 0) break block0;
                    object = function0.invoke();
                    break block2;
                }
                throw new LifecycleDestroyedException();
            }
            object = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(lifecycle, (Lifecycle.State)((Object)object), bl, mainCoroutineDispatcher, (Function0)new /* invalid duplicate definition of identical inner class */, continuation);
        }
        return object;
    }

    private static final <R> Object withResumed$$forInline(Lifecycle object, Function0<? extends R> function0, Continuation<? super R> continuation) {
        object = Lifecycle.State.RESUMED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark((int)3);
        throw new NullPointerException();
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner object, Function0<? extends R> function0, Continuation<? super R> continuation) {
        object.getLifecycle();
        object = Lifecycle.State.RESUMED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark((int)3);
        throw new NullPointerException();
    }

    public static final <R> Object withStarted(Lifecycle object, Function0<? extends R> function0, Continuation<? super R> continuation) {
        block2: {
            boolean bl;
            MainCoroutineDispatcher mainCoroutineDispatcher;
            Lifecycle.State state;
            block0: {
                block1: {
                    state = Lifecycle.State.STARTED;
                    mainCoroutineDispatcher = Dispatchers.getMain().getImmediate();
                    bl = mainCoroutineDispatcher.isDispatchNeeded(continuation.getContext());
                    if (bl) break block0;
                    if (((Lifecycle)object).getCurrentState() == Lifecycle.State.DESTROYED) break block1;
                    if (((Lifecycle)object).getCurrentState().compareTo((Enum)state) < 0) break block0;
                    object = function0.invoke();
                    break block2;
                }
                throw new LifecycleDestroyedException();
            }
            object = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked((Lifecycle)object, state, bl, mainCoroutineDispatcher, (Function0)new /* invalid duplicate definition of identical inner class */, continuation);
        }
        return object;
    }

    public static final <R> Object withStarted(LifecycleOwner object, Function0<? extends R> function0, Continuation<? super R> continuation) {
        block2: {
            boolean bl;
            MainCoroutineDispatcher mainCoroutineDispatcher;
            Lifecycle.State state;
            block0: {
                block1: {
                    object = object.getLifecycle();
                    state = Lifecycle.State.STARTED;
                    mainCoroutineDispatcher = Dispatchers.getMain().getImmediate();
                    bl = mainCoroutineDispatcher.isDispatchNeeded(continuation.getContext());
                    if (bl) break block0;
                    if (((Lifecycle)object).getCurrentState() == Lifecycle.State.DESTROYED) break block1;
                    if (((Lifecycle)object).getCurrentState().compareTo((Enum)state) < 0) break block0;
                    object = function0.invoke();
                    break block2;
                }
                throw new LifecycleDestroyedException();
            }
            object = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked((Lifecycle)object, state, bl, mainCoroutineDispatcher, (Function0)new /* invalid duplicate definition of identical inner class */, continuation);
        }
        return object;
    }

    private static final <R> Object withStarted$$forInline(Lifecycle object, Function0<? extends R> function0, Continuation<? super R> continuation) {
        object = Lifecycle.State.STARTED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark((int)3);
        throw new NullPointerException();
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner object, Function0<? extends R> function0, Continuation<? super R> continuation) {
        object.getLifecycle();
        object = Lifecycle.State.STARTED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark((int)3);
        throw new NullPointerException();
    }

    public static final <R> Object withStateAtLeast(Lifecycle object, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        block0: {
            block3: {
                boolean bl;
                MainCoroutineDispatcher mainCoroutineDispatcher;
                block1: {
                    block2: {
                        boolean bl2 = state.compareTo((Enum)Lifecycle.State.CREATED) >= 0;
                        if (!bl2) break block0;
                        mainCoroutineDispatcher = Dispatchers.getMain().getImmediate();
                        bl = mainCoroutineDispatcher.isDispatchNeeded(continuation.getContext());
                        if (bl) break block1;
                        if (((Lifecycle)object).getCurrentState() == Lifecycle.State.DESTROYED) break block2;
                        if (((Lifecycle)object).getCurrentState().compareTo((Enum)state) < 0) break block1;
                        object = function0.invoke();
                        break block3;
                    }
                    throw new LifecycleDestroyedException();
                }
                object = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked((Lifecycle)object, state, bl, mainCoroutineDispatcher, (Function0)new /* invalid duplicate definition of identical inner class */, continuation);
            }
            return object;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + (Object)((Object)state)).toString());
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner object, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        block0: {
            block3: {
                boolean bl;
                Lifecycle lifecycle;
                block1: {
                    block2: {
                        lifecycle = object.getLifecycle();
                        boolean bl2 = state.compareTo((Enum)Lifecycle.State.CREATED) >= 0;
                        if (!bl2) break block0;
                        object = Dispatchers.getMain().getImmediate();
                        bl = ((CoroutineDispatcher)((Object)object)).isDispatchNeeded(continuation.getContext());
                        if (bl) break block1;
                        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) break block2;
                        if (lifecycle.getCurrentState().compareTo((Enum)state) < 0) break block1;
                        object = function0.invoke();
                        break block3;
                    }
                    throw new LifecycleDestroyedException();
                }
                object = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(lifecycle, state, bl, (CoroutineDispatcher)((Object)object), (Function0)new /* invalid duplicate definition of identical inner class */, continuation);
            }
            return object;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + (Object)((Object)state)).toString());
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        boolean bl = state.compareTo((Enum)Lifecycle.State.CREATED) >= 0;
        if (!bl) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + (Object)((Object)state)).toString());
        }
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark((int)3);
        throw new NullPointerException();
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        lifecycleOwner.getLifecycle();
        boolean bl = state.compareTo((Enum)Lifecycle.State.CREATED) >= 0;
        if (!bl) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + (Object)((Object)state)).toString());
        }
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark((int)3);
        throw new NullPointerException();
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        MainCoroutineDispatcher mainCoroutineDispatcher = Dispatchers.getMain().getImmediate();
        boolean bl = mainCoroutineDispatcher.isDispatchNeeded(continuation.getContext());
        if (!bl) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo((Enum)state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(lifecycle, state, bl, mainCoroutineDispatcher, (Function0)new /* invalid duplicate definition of identical inner class */, continuation);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark((int)3);
        throw new NullPointerException();
    }
}

