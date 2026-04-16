/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\fR\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Landroidx/work/impl/constraints/WorkConstraintsTracker;", "", "trackers", "Landroidx/work/impl/constraints/trackers/Trackers;", "(Landroidx/work/impl/constraints/trackers/Trackers;)V", "controllers", "", "Landroidx/work/impl/constraints/controllers/ConstraintController;", "(Ljava/util/List;)V", "areAllConstraintsMet", "", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "track", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/work/impl/constraints/ConstraintsState;", "spec", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class WorkConstraintsTracker {
    private final List<ConstraintController<?>> controllers;

    public WorkConstraintsTracker(Trackers object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"trackers");
        BatteryChargingController batteryChargingController = new BatteryChargingController(((Trackers)object).getBatteryChargingTracker());
        BatteryNotLowController batteryNotLowController = new BatteryNotLowController(((Trackers)object).getBatteryNotLowTracker());
        StorageNotLowController storageNotLowController = new StorageNotLowController(((Trackers)object).getStorageNotLowTracker());
        NetworkConnectedController networkConnectedController = new NetworkConnectedController(((Trackers)object).getNetworkStateTracker());
        NetworkUnmeteredController networkUnmeteredController = new NetworkUnmeteredController(((Trackers)object).getNetworkStateTracker());
        NetworkNotRoamingController networkNotRoamingController = new NetworkNotRoamingController(((Trackers)object).getNetworkStateTracker());
        object = new NetworkMeteredController(((Trackers)object).getNetworkStateTracker());
        this(CollectionsKt.listOf((Object[])new ConstraintController[]{batteryChargingController, batteryNotLowController, storageNotLowController, networkConnectedController, networkUnmeteredController, networkNotRoamingController, object}));
    }

    public WorkConstraintsTracker(List<? extends ConstraintController<?>> list) {
        Intrinsics.checkNotNullParameter(list, (String)"controllers");
        this.controllers = list;
    }

    public final boolean areAllConstraintsMet(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter((Object)workSpec, (String)"workSpec");
        Object object = this.controllers;
        Collection collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e = object.next();
            if (!((ConstraintController)e).isConstrained(workSpec)) continue;
            collection.add(e);
        }
        if ((collection = (List)collection).isEmpty() ^ true) {
            Logger.get().debug(WorkConstraintsTrackerKt.access$getTAG$p(), "Work " + workSpec.id + " constrained by " + CollectionsKt.joinToString$default((Iterable)collection, null, null, null, (int)0, null, (Function1)areAllConstraintsMet.1.INSTANCE, (int)31, null));
        }
        return collection.isEmpty();
    }

    public final Flow<ConstraintsState> track(WorkSpec object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"spec");
        Object object2 = this.controllers;
        Object object3 = new ArrayList();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Object e = object2.next();
            if (!((ConstraintController)e).hasConstraint((WorkSpec)object)) continue;
            object3.add(e);
        }
        object = (List)object3;
        object3 = (Iterable)object;
        object = new ArrayList(CollectionsKt.collectionSizeOrDefault(object3, (int)10));
        object3 = object3.iterator();
        while (object3.hasNext()) {
            object.add(((ConstraintController)object3.next()).track());
        }
        object = (List)object;
        object = new Flow<ConstraintsState>(((Collection)CollectionsKt.toList((Iterable)((Iterable)object))).toArray(new Flow[0])){
            final Flow[] $flowArray$inlined;
            {
                this.$flowArray$inlined = flowArray;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = CombineKt.combineInternal(object, this.$flowArray$inlined, (Function0<T[]>)((Function0)new Function0<ConstraintsState[]>(this.$flowArray$inlined){
                    final Flow[] $flowArray;
                    {
                        this.$flowArray = flowArray;
                        super(0);
                    }

                    public final ConstraintsState[] invoke() {
                        return new ConstraintsState[this.$flowArray.length];
                    }
                }), (Function3)new Function3<FlowCollector<? super ConstraintsState>, ConstraintsState[], Continuation<? super Unit>, Object>(null){
                    private Object L$0;
                    Object L$1;
                    int label;

                    /*
                     * Ignored method signature, as it can't be verified against descriptor
                     */
                    public final Object invoke(FlowCollector flowCollector, Object[] objectArray, Continuation object) {
                        object = new /* invalid duplicate definition of identical inner class */;
                        object.L$0 = flowCollector;
                        object.L$1 = objectArray;
                        return object.invokeSuspend(Unit.INSTANCE);
                    }

                    /*
                     * WARNING - void declaration
                     * Enabled aggressive block sorting
                     */
                    public final Object invokeSuspend(Object object) {
                        void var5_14;
                        void var1_6;
                        FlowCollector flowCollector;
                        Object object2;
                        block7: {
                            object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 1: {
                                    ResultKt.throwOnFailure((Object)object);
                                    return Unit.INSTANCE;
                                }
                                case 0: 
                            }
                            ResultKt.throwOnFailure((Object)object);
                            flowCollector = (FlowCollector)this.L$0;
                            Object[] objectArray = (Object[])this.L$1;
                            Continuation continuation = (Continuation)this;
                            for (ConstraintsState constraintsState : (ConstraintsState[])objectArray) {
                                boolean bl = !Intrinsics.areEqual((Object)constraintsState, (Object)ConstraintsState.ConstraintsMet.INSTANCE);
                                if (!bl) {
                                    continue;
                                }
                                break block7;
                            }
                            Object var1_5 = null;
                        }
                        void var5_12 = var1_6;
                        if (var1_6 == null) {
                            ConstraintsState constraintsState = ConstraintsState.ConstraintsMet.INSTANCE;
                        }
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (flowCollector.emit(var5_14, (Continuation<Unit>)continuation) != object2) return Unit.INSTANCE;
                        return object2;
                    }
                }, (Continuation<? super Unit>)continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
        return FlowKt.distinctUntilChanged(object);
    }
}

