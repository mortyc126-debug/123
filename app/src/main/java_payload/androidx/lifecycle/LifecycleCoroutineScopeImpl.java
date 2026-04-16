/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0090\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2={"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getLifecycle$lifecycle_common", "()Landroidx/lifecycle/Lifecycle;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "register", "lifecycle-common"}, k=1, mv={1, 8, 0}, xi=48)
public final class LifecycleCoroutineScopeImpl
extends LifecycleCoroutineScope
implements LifecycleEventObserver {
    private final CoroutineContext coroutineContext;
    private final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter((Object)lifecycle, (String)"lifecycle");
        Intrinsics.checkNotNullParameter((Object)coroutineContext, (String)"coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (this.getLifecycle$lifecycle_common().getCurrentState() == Lifecycle.State.DESTROYED) {
            JobKt.cancel$default(this.getCoroutineContext(), null, 1, null);
        }
    }

    @Override
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override
    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    @Override
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter((Object)lifecycleOwner, (String)"source");
        Intrinsics.checkNotNullParameter((Object)((Object)event), (String)"event");
        if (this.getLifecycle$lifecycle_common().getCurrentState().compareTo((Enum)Lifecycle.State.DESTROYED) <= 0) {
            this.getLifecycle$lifecycle_common().removeObserver(this);
            JobKt.cancel$default(this.getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getMain().getImmediate(), null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            private Object L$0;
            int label;
            final LifecycleCoroutineScopeImpl this$0;
            {
                this.this$0 = lifecycleCoroutineScopeImpl;
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
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 0: 
                }
                ResultKt.throwOnFailure((Object)object);
                object = (CoroutineScope)this.L$0;
                if (this.this$0.getLifecycle$lifecycle_common().getCurrentState().compareTo((Enum)Lifecycle.State.INITIALIZED) >= 0) {
                    this.this$0.getLifecycle$lifecycle_common().addObserver(this.this$0);
                } else {
                    JobKt.cancel$default(object.getCoroutineContext(), null, 1, null);
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }
}

