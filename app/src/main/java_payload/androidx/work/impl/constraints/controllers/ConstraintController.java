/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u0018\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Landroidx/work/impl/constraints/controllers/ConstraintController;", "T", "", "tracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "(Landroidx/work/impl/constraints/trackers/ConstraintTracker;)V", "reason", "", "getReason$annotations", "()V", "getReason", "()I", "hasConstraint", "", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "isConstrained", "value", "(Ljava/lang/Object;)Z", "track", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/work/impl/constraints/ConstraintsState;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class ConstraintController<T> {
    private final ConstraintTracker<T> tracker;

    public ConstraintController(ConstraintTracker<T> constraintTracker) {
        Intrinsics.checkNotNullParameter(constraintTracker, (String)"tracker");
        this.tracker = constraintTracker;
    }

    public static final /* synthetic */ ConstraintTracker access$getTracker$p(ConstraintController constraintController) {
        return constraintController.tracker;
    }

    public static /* synthetic */ void getReason$annotations() {
    }

    public abstract int getReason();

    public abstract boolean hasConstraint(WorkSpec var1);

    public final boolean isConstrained(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter((Object)workSpec, (String)"workSpec");
        boolean bl = this.hasConstraint(workSpec) && this.isConstrained(this.tracker.readSystemState());
        return bl;
    }

    public abstract boolean isConstrained(T var1);

    public final Flow<ConstraintsState> track() {
        return FlowKt.callbackFlow((Function2)new Function2<ProducerScope<? super ConstraintsState>, Continuation<? super Unit>, Object>(this, null){
            private Object L$0;
            int label;
            final ConstraintController<T> this$0;
            {
                this.this$0 = constraintController;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super ConstraintsState> producerScope, Continuation<? super Unit> continuation) {
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
                        object = (ProducerScope)this.L$0;
                        ConstraintListener<T> constraintListener = new ConstraintListener<T>(this.this$0, (ProducerScope<? super ConstraintsState>)object){
                            final ProducerScope<ConstraintsState> $$this$callbackFlow;
                            final ConstraintController<T> this$0;
                            {
                                this.this$0 = constraintController;
                                this.$$this$callbackFlow = producerScope;
                            }

                            public void onConstraintChanged(T object) {
                                object = this.this$0.isConstrained(object) ? new ConstraintsState.ConstraintsNotMet(this.this$0.getReason()) : ConstraintsState.ConstraintsMet.INSTANCE;
                                object = (ConstraintsState)object;
                                this.$$this$callbackFlow.getChannel().trySend-JP2dKIU((ConstraintsState)object);
                            }
                        };
                        ConstraintController.access$getTracker$p(this.this$0).addListener(constraintListener);
                        Function0 function0 = (Function0)new Function0<Unit>(this.this$0, constraintListener){
                            final track.listener.1<T> $listener;
                            final ConstraintController<T> this$0;
                            {
                                this.this$0 = constraintController;
                                this.$listener = var2_2;
                                super(0);
                            }

                            public final void invoke() {
                                ConstraintController.access$getTracker$p(this.this$0).removeListener(this.$listener);
                            }
                        };
                        constraintListener = (Continuation)this;
                        this.label = 1;
                        if (ProduceKt.awaitClose(object, (Function0<Unit>)function0, (Continuation<? super Unit>)constraintListener) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }
}

