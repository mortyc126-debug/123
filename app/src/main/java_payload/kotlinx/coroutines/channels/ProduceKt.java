/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(d1={"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u001a\u009e\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2-\b\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017\u00a2\u0006\u0002\b\u001aH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001b\u001a\u00a8\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2-\b\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017\u00a2\u0006\u0002\b\u001aH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001e\u001ae\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017\u00a2\u0006\u0002\b\u001aH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2={"awaitClose", "", "Lkotlinx/coroutines/channels/ProducerScope;", "block", "Lkotlin/Function0;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produce", "Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class ProduceKt {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final Object awaitClose(ProducerScope<?> var0, Function0<Unit> var1_2, Continuation<? super Unit> var2_3) {
        block12: {
            if (!(var2_3 instanceof awaitClose.1)) ** GOTO lbl-1000
            var4_4 = var2_3;
            if ((var4_4.label & -2147483648) != 0) {
                var4_4.label += -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                var4_4 = new ContinuationImpl((Continuation<? super awaitClose.1>)var2_3){
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return ProduceKt.awaitClose(null, null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
            }
            var6_5 = var4_4.result;
            var5_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var4_4.label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    var0 = var4_4.L$1;
                    var1_2 = (ProducerScope)var4_4.L$0;
                    var2_3 = var0;
                    try {
                        ResultKt.throwOnFailure((Object)var6_5);
                        break;
                    }
                    catch (Throwable var0_1) {
                        break block12;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var6_5);
                    var3_7 = var4_4.getContext().get((CoroutineContext.Key)Job.Key) == var0;
                    if (!var3_7) throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
                    var2_3 = var1_2;
                    {
                        var4_4.L$0 = var0;
                        var2_3 = var1_2;
                        var4_4.L$1 = var1_2;
                        var2_3 = var1_2;
                        var4_4.label = 1;
                        var2_3 = var1_2;
                        var7_8 /* !! */  = (Continuation)var4_4;
                        var2_3 = var1_2;
                        var2_3 = var1_2;
                        var6_5 = new CancellableContinuationImpl<T>(IntrinsicsKt.intercepted((Continuation)var7_8 /* !! */ ), 1);
                        var2_3 = var1_2;
                        var6_5.initCancellability();
                        var2_3 = var1_2;
                        var8_9 = var6_5;
                        var2_3 = var1_2;
                        var2_3 = var1_2;
                        var7_8 /* !! */  = new Function1<Throwable, Unit>(var8_9){
                            final CancellableContinuation<Unit> $cont;
                            {
                                this.$cont = cancellableContinuation;
                                super(1);
                            }

                            public final void invoke(Throwable throwable) {
                                throwable = this.$cont;
                                Result.Companion companion = Result.Companion;
                                throwable.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
                            }
                        };
                        var2_3 = var1_2;
                        var0.invokeOnClose((Function1<Throwable, Unit>)((Function1)var7_8 /* !! */ ));
                        var2_3 = var1_2;
                        var0 = var6_5.getResult();
                        var2_3 = var1_2;
                        if (var0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            var2_3 = var1_2;
                            DebugProbesKt.probeCoroutineSuspended((Continuation)((Continuation)var4_4));
                        }
                        if (var0 == var5_6) {
                            return var5_6;
                        }
                        var0 = var1_2;
                    }
                }
            }
            var0.invoke();
            return Unit.INSTANCE;
        }
        var2_3.invoke();
        throw var0_1;
    }

    public static /* synthetic */ Object awaitClose$default(ProducerScope producerScope, Function0 function0, Continuation continuation, int n, Object object) {
        if ((n & 1) != 0) {
            function0 = awaitClose.2.INSTANCE;
        }
        return ProduceKt.awaitClose(producerScope, (Function0<Unit>)function0, (Continuation<? super Unit>)continuation);
    }

    public static final <E> ReceiveChannel<E> produce(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int n, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return ProduceKt.produce(coroutineScope, coroutineContext, n, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, function2);
    }

    public static final <E> ReceiveChannel<E> produce(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int n, CoroutineStart coroutineStart, Function1<? super Throwable, Unit> function1, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return ProduceKt.produce(coroutineScope, coroutineContext, n, BufferOverflow.SUSPEND, coroutineStart, function1, function2);
    }

    public static final <E> ReceiveChannel<E> produce(CoroutineScope producerCoroutine, CoroutineContext coroutineContext, int n, BufferOverflow object, CoroutineStart coroutineStart, Function1<? super Throwable, Unit> function1, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        object = ChannelKt.Channel$default(n, object, null, 4, null);
        producerCoroutine = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(producerCoroutine, coroutineContext), object);
        if (function1 != null) {
            producerCoroutine.invokeOnCompletion(function1);
        }
        producerCoroutine.start(coroutineStart, producerCoroutine, function2);
        return producerCoroutine;
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int n, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n2 & 2) != 0) {
            n = 0;
        }
        return ProduceKt.produce(coroutineScope, coroutineContext, n, function2);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int n, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int n2, Object object) {
        block3: {
            if ((n2 & 1) != 0) {
                coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
            }
            if ((n2 & 2) != 0) {
                n = 0;
            }
            if ((n2 & 4) != 0) {
                coroutineStart = CoroutineStart.DEFAULT;
            }
            if ((n2 & 8) == 0) break block3;
            function1 = null;
        }
        return ProduceKt.produce(coroutineScope, coroutineContext, n, coroutineStart, (Function1<? super Throwable, Unit>)function1, function2);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int n, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int n2, Object object) {
        block4: {
            if ((n2 & 1) != 0) {
                coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
            }
            if ((n2 & 2) != 0) {
                n = 0;
            }
            if ((n2 & 4) != 0) {
                bufferOverflow = BufferOverflow.SUSPEND;
            }
            if ((n2 & 8) != 0) {
                coroutineStart = CoroutineStart.DEFAULT;
            }
            if ((n2 & 0x10) == 0) break block4;
            function1 = null;
        }
        return ProduceKt.produce(coroutineScope, coroutineContext, n, bufferOverflow, coroutineStart, (Function1<? super Throwable, Unit>)function1, function2);
    }
}

