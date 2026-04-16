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
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 */
package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0017J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "stopTimeout", "", "replayExpiration", "(JJ)V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "equals", "", "other", "", "hashCode", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class StartedWhileSubscribed
implements SharingStarted {
    private final long replayExpiration;
    private final long stopTimeout;

    public StartedWhileSubscribed(long l, long l2) {
        this.stopTimeout = l;
        this.replayExpiration = l2;
        l = this.stopTimeout;
        boolean bl = true;
        boolean bl2 = l >= 0L;
        if (bl2) {
            bl2 = this.replayExpiration >= 0L ? bl : false;
            if (bl2) {
                return;
            }
            throw new IllegalArgumentException(("replayExpiration(" + this.replayExpiration + " ms) cannot be negative").toString());
        }
        throw new IllegalArgumentException(("stopTimeout(" + this.stopTimeout + " ms) cannot be negative").toString());
    }

    public static final /* synthetic */ long access$getReplayExpiration$p(StartedWhileSubscribed startedWhileSubscribed) {
        return startedWhileSubscribed.replayExpiration;
    }

    public static final /* synthetic */ long access$getStopTimeout$p(StartedWhileSubscribed startedWhileSubscribed) {
        return startedWhileSubscribed.stopTimeout;
    }

    @Override
    public Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest((Flow)stateFlow, (Function3)new Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object>(this, null){
            int I$0;
            private Object L$0;
            int label;
            final StartedWhileSubscribed this$0;
            {
                this.this$0 = startedWhileSubscribed;
                super(3, continuation);
            }

            public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, int n, Continuation<? super Unit> object) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.L$0 = flowCollector;
                object.I$0 = n;
                return object.invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object var1_1) {
                block13: {
                    block14: {
                        block15: {
                            var6_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 5: {
                                    ResultKt.throwOnFailure((Object)var1_1);
                                    break block13;
                                }
                                case 4: {
                                    var5_3 = (FlowCollector)this.L$0;
                                    ResultKt.throwOnFailure((Object)var1_1);
                                    break block14;
                                }
                                case 3: {
                                    var5_3 = (FlowCollector)this.L$0;
                                    ResultKt.throwOnFailure((Object)var1_1);
                                    break block15;
                                }
                                case 2: {
                                    var5_3 = (FlowCollector)this.L$0;
                                    ResultKt.throwOnFailure((Object)var1_1);
                                    var1_1 = var5_3;
                                    break;
                                }
                                case 1: {
                                    ResultKt.throwOnFailure((Object)var1_1);
                                    break block13;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)var1_1);
                                    var1_1 = (FlowCollector)this.L$0;
                                    var2_5 = this.I$0;
                                    if (var2_5 <= 0) ** GOTO lbl35
                                    var7_6 = SharingCommand.START;
                                    var5_4 = (Continuation)this;
                                    this.label = 1;
                                    if (var1_1.emit(var7_6, (Continuation<? super Unit>)var5_4) == var6_2) {
                                        return var6_2;
                                    }
                                    break block13;
lbl35:
                                    // 1 sources

                                    var3_8 = StartedWhileSubscribed.access$getStopTimeout$p(this.this$0);
                                    var5_3 = (Continuation)this;
                                    this.L$0 = var1_1;
                                    this.label = 2;
                                    if (DelayKt.delay(var3_8, (Continuation<? super Unit>)var5_3) != var6_2) break;
                                    return var6_2;
                                }
                            }
                            var5_3 = var1_1;
                            if (StartedWhileSubscribed.access$getReplayExpiration$p(this.this$0) > 0L) {
                                var7_7 /* !! */  = SharingCommand.STOP;
                                var8_9 = (Continuation)this;
                                this.L$0 = var1_1;
                                this.label = 3;
                                var5_3 = var1_1;
                                if (var1_1.emit(var7_7 /* !! */ , (Continuation<? super Unit>)var8_9) == var6_2) {
                                    return var6_2;
                                } else {
                                    ** GOTO lbl51
                                }
                            }
                            break block14;
                        }
                        var3_8 = StartedWhileSubscribed.access$getReplayExpiration$p(this.this$0);
                        var1_1 = (Continuation)this;
                        this.L$0 = var5_3;
                        this.label = 4;
                        if (DelayKt.delay(var3_8, (Continuation<? super Unit>)var1_1) == var6_2) {
                            return var6_2;
                        }
                    }
                    var1_1 = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                    var7_7 /* !! */  = (Continuation)this;
                    this.L$0 = null;
                    this.label = 5;
                    if (var5_3.emit(var1_1, (Continuation<Unit>)var7_7 /* !! */ ) == var6_2) {
                        return var6_2;
                    }
                }
                return Unit.INSTANCE;
            }
        }), (Function2)new Function2<SharingCommand, Continuation<? super Boolean>, Object>(null){
            Object L$0;
            int label;

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(SharingCommand sharingCommand, Continuation<? super Boolean> continuation) {
                return (this.create((Object)((Object)sharingCommand), continuation)).invokeSuspend(Unit.INSTANCE);
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
                boolean bl = (SharingCommand)((Object)this.L$0) != SharingCommand.START;
                return Boxing.boxBoolean((boolean)bl);
            }
        }));
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof StartedWhileSubscribed && this.stopTimeout == ((StartedWhileSubscribed)object).stopTimeout && this.replayExpiration == ((StartedWhileSubscribed)object).replayExpiration;
        return bl;
    }

    public int hashCode() {
        return Long.hashCode(this.stopTimeout) * 31 + Long.hashCode(this.replayExpiration);
    }

    public String toString() {
        List list = CollectionsKt.createListBuilder((int)2);
        if (this.stopTimeout > 0L) {
            list.add("stopTimeout=" + this.stopTimeout + "ms");
        }
        if (this.replayExpiration < Long.MAX_VALUE) {
            list.add("replayExpiration=" + this.replayExpiration + "ms");
        }
        list = CollectionsKt.build((List)list);
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.joinToString$default((Iterable)list, null, null, null, (int)0, null, null, (int)63, null) + ')';
    }
}

