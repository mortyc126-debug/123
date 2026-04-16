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
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.model;

import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDaoKt$dedup$;
import androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00070\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u001a\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001a&\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006*\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0001\u001a&\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006*\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0001\"\u0010\u0010\u0000\u001a\u00020\u00018\u0002X\u0083T\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0002X\u0083T\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u00018\u0002X\u0083T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"WORK_INFO_BY_IDS", "", "WORK_INFO_BY_NAME", "WORK_INFO_BY_TAG", "WORK_INFO_COLUMNS", "dedup", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/work/WorkInfo;", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getWorkStatusPojoFlowDataForIds", "Landroidx/work/impl/model/WorkSpecDao;", "id", "Ljava/util/UUID;", "getWorkStatusPojoFlowForName", "name", "getWorkStatusPojoFlowForTag", "tag", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class WorkSpecDaoKt {
    private static final String WORK_INFO_BY_IDS = "SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (:ids)";
    private static final String WORK_INFO_BY_NAME = "SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)";
    private static final String WORK_INFO_BY_TAG = "SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=:tag)";
    private static final String WORK_INFO_COLUMNS = "id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason";

    public static final Flow<List<WorkInfo>> dedup(Flow<? extends List<WorkSpec.WorkInfoPojo>> flow2, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(flow2, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)((Object)coroutineDispatcher), (String)"dispatcher");
        flow2 = new Flow<List<? extends WorkInfo>>(flow2){
            final Flow $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new FlowCollector((FlowCollector)object){
                    final FlowCollector $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, Continuation var2_2) {
                        if (!(var2_2 /* !! */  instanceof dedup$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var3_3 /* !! */  = var2_2 /* !! */ ;
                        if ((var3_3 /* !! */ .label & -2147483648) != 0) {
                            var3_3 /* !! */ .label += -2147483648;
                            var2_2 /* !! */  = var3_3 /* !! */ ;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                Object L$0;
                                int label;
                                Object result;
                                final dedup$$inlined$map$1$2 this$0;
                                {
                                    this.this$0 = var1_1;
                                    super(continuation);
                                }

                                public final Object invokeSuspend(Object object) {
                                    this.result = object;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit((Object)null, (Continuation)this);
                                }
                            };
                        }
                        var4_4 = var2_2 /* !! */ .result;
                        var3_3 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (var2_2 /* !! */ .label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 1: {
                                ResultKt.throwOnFailure((Object)var4_4);
                                break;
                            }
                            case 0: {
                                ResultKt.throwOnFailure((Object)var4_4);
                                var4_4 = this.$this_unsafeFlow;
                                var5_5 = var2_2 /* !! */ ;
                                var5_5 = (List)var1_1;
                                var1_1 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)var5_5, (int)10));
                                var5_5 = var5_5.iterator();
                                while (var5_5.hasNext()) {
                                    var1_1.add(((WorkSpec.WorkInfoPojo)var5_5.next()).toWorkInfo());
                                }
                                var1_1 = (List)var1_1;
                                var2_2 /* !! */ .label = 1;
                                if (var4_4.emit(var1_1, (Continuation<? super Unit>)var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                return var3_3 /* !! */ ;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
        return FlowKt.flowOn(FlowKt.distinctUntilChanged(flow2), (CoroutineContext)coroutineDispatcher);
    }

    public static final Flow<WorkInfo> getWorkStatusPojoFlowDataForIds(WorkSpecDao object, UUID uUID) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"id");
        object = object.getWorkStatusPojoFlowDataForIds(CollectionsKt.listOf((Object)String.valueOf(uUID)));
        object = new Flow<WorkInfo>((Flow)object){
            final Flow $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new FlowCollector((FlowCollector)object){
                    final FlowCollector $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, Continuation var2_2) {
                        if (!(var2_2 /* !! */  instanceof getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var3_3 /* !! */  = var2_2 /* !! */ ;
                        if ((var3_3 /* !! */ .label & -2147483648) != 0) {
                            var3_3 /* !! */ .label += -2147483648;
                            var2_2 /* !! */  = var3_3 /* !! */ ;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                                Object L$0;
                                int label;
                                Object result;
                                final getWorkStatusPojoFlowDataForIds$$inlined$map$1$2 this$0;
                                {
                                    this.this$0 = var1_1;
                                    super(continuation);
                                }

                                public final Object invokeSuspend(Object object) {
                                    this.result = object;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit((Object)null, (Continuation)this);
                                }
                            };
                        }
                        var4_4 = var2_2 /* !! */ .result;
                        var3_3 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (var2_2 /* !! */ .label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 1: {
                                ResultKt.throwOnFailure((Object)var4_4);
                                break;
                            }
                            case 0: {
                                ResultKt.throwOnFailure((Object)var4_4);
                                var4_4 = this.$this_unsafeFlow;
                                var5_5 /* !! */  = var2_2 /* !! */ ;
                                var1_1 = (WorkSpec.WorkInfoPojo)CollectionsKt.firstOrNull((List)((List)var1_1));
                                var1_1 = var1_1 != null ? var1_1.toWorkInfo() : null;
                                var2_2 /* !! */ .label = 1;
                                if (var4_4.emit(var1_1, (Continuation<? super Unit>)var2_2 /* !! */ ) != var3_3 /* !! */ ) break;
                                return var3_3 /* !! */ ;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
        return FlowKt.distinctUntilChanged(object);
    }

    public static final Flow<List<WorkInfo>> getWorkStatusPojoFlowForName(WorkSpecDao workSpecDao, CoroutineDispatcher coroutineDispatcher, String string2) {
        Intrinsics.checkNotNullParameter((Object)workSpecDao, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)((Object)coroutineDispatcher), (String)"dispatcher");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        return WorkSpecDaoKt.dedup(workSpecDao.getWorkStatusPojoFlowForName(string2), coroutineDispatcher);
    }

    public static final Flow<List<WorkInfo>> getWorkStatusPojoFlowForTag(WorkSpecDao workSpecDao, CoroutineDispatcher coroutineDispatcher, String string2) {
        Intrinsics.checkNotNullParameter((Object)workSpecDao, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)((Object)coroutineDispatcher), (String)"dispatcher");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"tag");
        return WorkSpecDaoKt.dedup(workSpecDao.getWorkStatusPojoFlowForTag(string2), coroutineDispatcher);
    }
}

