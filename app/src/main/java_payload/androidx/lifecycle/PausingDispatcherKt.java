/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleController;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.PausingDispatcher;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aD\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u00a2\u0006\u0002\b\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001aD\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\n2'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u00a2\u0006\u0002\b\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001aD\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u00a2\u0006\u0002\b\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001aD\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\n2'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u00a2\u0006\u0002\b\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001aD\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u00a2\u0006\u0002\b\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001aD\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\n2'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u00a2\u0006\u0002\b\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001aL\u0010\u000e\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u00a2\u0006\u0002\b\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2={"whenCreated", "T", "Landroidx/lifecycle/Lifecycle;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "whenResumed", "whenStarted", "whenStateAtLeast", "minState", "Landroidx/lifecycle/Lifecycle$State;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-common"}, k=2, mv={1, 8, 0}, xi=48)
public final class PausingDispatcherKt {
    @Deprecated(message="whenCreated has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withCreated for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenCreated(Lifecycle lifecycle, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return PausingDispatcherKt.whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, function2, continuation);
    }

    @Deprecated(message="whenCreated has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withCreated for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return PausingDispatcherKt.whenCreated(lifecycleOwner.getLifecycle(), function2, continuation);
    }

    @Deprecated(message="whenResumed has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withResumed for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenResumed(Lifecycle lifecycle, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return PausingDispatcherKt.whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, function2, continuation);
    }

    @Deprecated(message="whenResumed has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withResumed for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return PausingDispatcherKt.whenResumed(lifecycleOwner.getLifecycle(), function2, continuation);
    }

    @Deprecated(message="whenStarted has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStarted for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenStarted(Lifecycle lifecycle, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return PausingDispatcherKt.whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, function2, continuation);
    }

    @Deprecated(message="whenStarted has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStarted for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return PausingDispatcherKt.whenStarted(lifecycleOwner.getLifecycle(), function2, continuation);
    }

    @Deprecated(message="whenStateAtLeast has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStateAtLeast for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return BuildersKt.withContext((CoroutineContext)Dispatchers.getMain().getImmediate(), (Function2)new Function2<CoroutineScope, Continuation<? super T>, Object>(lifecycle, state, function2, null){
            final Function2<CoroutineScope, Continuation<? super T>, Object> $block;
            final Lifecycle.State $minState;
            final Lifecycle $this_whenStateAtLeast;
            private Object L$0;
            int label;
            {
                this.$this_whenStateAtLeast = lifecycle;
                this.$minState = state;
                this.$block = function2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Loose catch block
             */
            public final Object invokeSuspend(Object object) {
                block10: {
                    Object object2;
                    Object object3;
                    block9: {
                        object3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 1: {
                                object3 = (LifecycleController)this.L$0;
                                try {
                                    ResultKt.throwOnFailure((Object)object);
                                    object2 = object;
                                    break;
                                }
                                catch (Throwable throwable) {
                                    object2 = throwable;
                                    break block9;
                                }
                            }
                            case 0: {
                                ResultKt.throwOnFailure((Object)object);
                                object = (Job)((CoroutineScope)this.L$0).getCoroutineContext().get((CoroutineContext.Key)Job.Key);
                                if (object == null) break block10;
                                object2 = new PausingDispatcher();
                                object = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, object2.dispatchQueue, (Job)object);
                                CoroutineContext coroutineContext = (CoroutineContext)object2;
                                object2 = this.$block;
                                Continuation continuation = (Continuation)this;
                                this.L$0 = object;
                                this.label = 1;
                                object2 = BuildersKt.withContext(coroutineContext, object2, continuation);
                                if (object2 == object3) {
                                    return object3;
                                }
                                object3 = object;
                            }
                        }
                        ((LifecycleController)object3).finish();
                        return object2;
                        catch (Throwable throwable) {
                            object2 = throwable;
                            object3 = object;
                        }
                    }
                    ((LifecycleController)object3).finish();
                    throw object2;
                }
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
        }, continuation);
    }
}

