/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.PausingDispatcherKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\b\u0000\u00a2\u0006\u0002\u0010\u0002J9\u0010\u0007\u001a\u00020\b2'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n\u00a2\u0006\u0002\b\u000eH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ9\u0010\u0010\u001a\u00020\b2'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n\u00a2\u0006\u0002\b\u000eH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ9\u0010\u0011\u001a\u00020\b2'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n\u00a2\u0006\u0002\b\u000eH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u0012\u0010\u0003\u001a\u00020\u0004X\u00a0\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2={"Landroidx/lifecycle/LifecycleCoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle$lifecycle_common", "()Landroidx/lifecycle/Lifecycle;", "launchWhenCreated", "Lkotlinx/coroutines/Job;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "launchWhenResumed", "launchWhenStarted", "lifecycle-common"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class LifecycleCoroutineScope
implements CoroutineScope {
    public abstract Lifecycle getLifecycle$lifecycle_common();

    @Deprecated(message="launchWhenCreated is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.CREATED.")
    public final Job launchWhenCreated(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, (String)"block");
        return BuildersKt.launch$default(this, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, function2, null){
            final Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
            int label;
            final LifecycleCoroutineScope this$0;
            {
                this.this$0 = lifecycleCoroutineScope;
                this.$block = function2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
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
                        Lifecycle lifecycle = this.this$0.getLifecycle$lifecycle_common();
                        function2 = this.$block;
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (PausingDispatcherKt.whenCreated(lifecycle, function2, continuation) != object) break;
                        return object;
                    }
                }
                return Unit.INSTANCE;
            }
        }, 3, null);
    }

    @Deprecated(message="launchWhenResumed is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.RESUMED.")
    public final Job launchWhenResumed(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, (String)"block");
        return BuildersKt.launch$default(this, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, function2, null){
            final Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
            int label;
            final LifecycleCoroutineScope this$0;
            {
                this.this$0 = lifecycleCoroutineScope;
                this.$block = function2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
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
                        Lifecycle lifecycle = this.this$0.getLifecycle$lifecycle_common();
                        function2 = this.$block;
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (PausingDispatcherKt.whenResumed(lifecycle, function2, continuation) != object) break;
                        return object;
                    }
                }
                return Unit.INSTANCE;
            }
        }, 3, null);
    }

    @Deprecated(message="launchWhenStarted is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.STARTED.")
    public final Job launchWhenStarted(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, (String)"block");
        return BuildersKt.launch$default(this, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, function2, null){
            final Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
            int label;
            final LifecycleCoroutineScope this$0;
            {
                this.this$0 = lifecycleCoroutineScope;
                this.$block = function2;
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
                        object = this.this$0.getLifecycle$lifecycle_common();
                        Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.$block;
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (PausingDispatcherKt.whenStarted((Lifecycle)object, function2, continuation) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        }, 3, null);
    }
}

