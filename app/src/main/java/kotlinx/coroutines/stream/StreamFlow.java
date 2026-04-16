/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.Volatile
 */
package kotlinx.coroutines.stream;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.stream.StreamFlow;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0002\u0010\u0005J\u001f\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\t\u0010\u0006\u001a\u00020\u0007X\u0082\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2={"Lkotlinx/coroutines/stream/StreamFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "stream", "Ljava/util/stream/Stream;", "(Ljava/util/stream/Stream;)V", "consumed", "Lkotlinx/atomicfu/AtomicBoolean;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class StreamFlow<T>
implements Flow<T> {
    private static final AtomicIntegerFieldUpdater consumed$FU = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed");
    @Volatile
    private volatile int consumed;
    private final Stream<T> stream;

    public StreamFlow(Stream<T> stream) {
        this.stream = stream;
        this.consumed = 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Object collect(FlowCollector<? super T> var1_1, Continuation<? super Unit> var2_3) {
        block12: {
            block11: {
                if (!(var2_3 /* !! */  instanceof collect.1)) ** GOTO lbl-1000
                var4_4 = var2_3 /* !! */ ;
                if ((var4_4.label & -2147483648) != 0) {
                    var4_4.label += -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    var4_4 = new ContinuationImpl(this, var2_3 /* !! */ ){
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        int label;
                        Object result;
                        final StreamFlow<T> this$0;
                        {
                            this.this$0 = streamFlow;
                            super(continuation);
                        }

                        public final Object invokeSuspend(Object object) {
                            this.result = object;
                            this.label |= Integer.MIN_VALUE;
                            return this.this$0.collect(null, (Continuation<Unit>)((Continuation)this));
                        }
                    };
                }
                var7_5 = var4_4.result;
                var6_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (var4_4.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        var5_7 = (Iterator<T>)var4_4.L$2;
                        var3_8 = (FlowCollector)var4_4.L$1;
                        var1_1 = (StreamFlow)var4_4.L$0;
                        var2_3 /* !! */  = var1_1;
                        try {
                            ResultKt.throwOnFailure((Object)var7_5);
                            ** break;
                        }
                        catch (Throwable var1_2) {
                            var2_3 /* !! */ .stream.close();
                            throw var1_2;
                        }
                    }
                    case 0: 
                }
                ResultKt.throwOnFailure((Object)var7_5);
                var3_8 = this;
                if (!StreamFlow.consumed$FU.compareAndSet(var3_8, 0, 1)) break block12;
                var2_3 /* !! */  = var3_8;
                {
                    var5_7 = var3_8.stream.iterator();
                    var2_3 /* !! */  = var1_1;
                    var1_1 = var3_8;
                    var3_8 = var2_3 /* !! */ ;
lbl32:
                    // 2 sources

                    do {
                        var2_3 /* !! */  = var1_1;
                        if (!var5_7.hasNext()) break block11;
                        var2_3 /* !! */  = var1_1;
                        var7_5 = var5_7.next();
                        var2_3 /* !! */  = var1_1;
                        var4_4.L$0 = var1_1;
                        var2_3 /* !! */  = var1_1;
                        var4_4.L$1 = var3_8;
                        var2_3 /* !! */  = var1_1;
                        var4_4.L$2 = var5_7;
                        var2_3 /* !! */  = var1_1;
                        var4_4.label = 1;
                        var2_3 /* !! */  = var1_1;
                    } while ((var7_5 = var3_8.emit((Object)var7_5, (Continuation<Unit>)var4_4)) != var6_6);
                    return var6_6;
                }
            }
            var1_1.stream.close();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("Stream.consumeAsFlow can be collected only once".toString());
    }
}

