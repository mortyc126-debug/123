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
package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"TAG", "", "listen", "Lkotlinx/coroutines/Job;", "Landroidx/work/impl/constraints/WorkConstraintsTracker;", "spec", "Landroidx/work/impl/model/WorkSpec;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "listener", "Landroidx/work/impl/constraints/OnConstraintsStateChangedListener;", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class WorkConstraintsTrackerKt {
    private static final String TAG;

    static {
        String string2 = Logger.tagWithPrefix("WorkConstraintsTracker");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"tagWithPrefix(\"WorkConstraintsTracker\")");
        TAG = string2;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    public static final Job listen(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, CoroutineDispatcher coroutineDispatcher, OnConstraintsStateChangedListener onConstraintsStateChangedListener) {
        Intrinsics.checkNotNullParameter((Object)workConstraintsTracker, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)workSpec, (String)"spec");
        Intrinsics.checkNotNullParameter((Object)((Object)coroutineDispatcher), (String)"dispatcher");
        Intrinsics.checkNotNullParameter((Object)onConstraintsStateChangedListener, (String)"listener");
        CompletableJob completableJob = JobKt.Job$default(null, 1, null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(coroutineDispatcher.plus((CoroutineContext)completableJob)), null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(workConstraintsTracker, workSpec, onConstraintsStateChangedListener, null){
            final OnConstraintsStateChangedListener $listener;
            final WorkSpec $spec;
            final WorkConstraintsTracker $this_listen;
            int label;
            {
                this.$this_listen = workConstraintsTracker;
                this.$spec = workSpec;
                this.$listener = onConstraintsStateChangedListener;
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
                        Flow<ConstraintsState> flow2 = this.$this_listen.track(this.$spec);
                        object = new FlowCollector(this.$listener, this.$spec){
                            final OnConstraintsStateChangedListener $listener;
                            final WorkSpec $spec;
                            {
                                this.$listener = onConstraintsStateChangedListener;
                                this.$spec = workSpec;
                            }

                            public final Object emit(ConstraintsState constraintsState, Continuation<? super Unit> continuation) {
                                this.$listener.onConstraintsStateChanged(this.$spec, constraintsState);
                                return Unit.INSTANCE;
                            }
                        };
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (flow2.collect((FlowCollector<ConstraintsState>)object, (Continuation<Unit>)continuation) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        }, 3, null);
        return completableJob;
    }
}

