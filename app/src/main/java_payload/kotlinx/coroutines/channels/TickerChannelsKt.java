/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.channels.TickerChannelsKt;
import kotlinx.coroutines.channels.TickerMode;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2={"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class TickerChannelsKt {
    public static final /* synthetic */ Object access$fixedDelayTicker(long l, long l2, SendChannel sendChannel, Continuation continuation) {
        return TickerChannelsKt.fixedDelayTicker(l, l2, sendChannel, (Continuation<? super Unit>)continuation);
    }

    public static final /* synthetic */ Object access$fixedPeriodTicker(long l, long l2, SendChannel sendChannel, Continuation continuation) {
        return TickerChannelsKt.fixedPeriodTicker(l, l2, sendChannel, (Continuation<? super Unit>)continuation);
    }

    /*
     * Unable to fully structure code
     */
    private static final Object fixedDelayTicker(long var0, long var2_1, SendChannel<? super Unit> var4_2, Continuation<? super Unit> var5_3) {
        if (!(var5_3 instanceof fixedDelayTicker.1)) ** GOTO lbl-1000
        var6_4 = var5_3;
        if ((var6_4.label & -2147483648) != 0) {
            var6_4.label += -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            var6_4 = new ContinuationImpl((Continuation<? super fixedDelayTicker.1>)var5_3){
                long J$0;
                Object L$0;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return TickerChannelsKt.access$fixedDelayTicker(0L, 0L, null, (Continuation)this);
                }
            };
        }
        var8_5 = var6_4.result;
        var7_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var6_4.label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 3: {
                var0 = var6_4.J$0;
                var4_2 = (SendChannel)var6_4.L$0;
                ResultKt.throwOnFailure((Object)var8_5);
                ** GOTO lbl50
            }
            case 2: {
                var2_1 = var6_4.J$0;
                var4_2 = (SendChannel)var6_4.L$0;
                ResultKt.throwOnFailure((Object)var8_5);
                ** GOTO lbl44
            }
            case 1: {
                var0 = var6_4.J$0;
                var5_3 = (SendChannel)var6_4.L$0;
                ResultKt.throwOnFailure((Object)var8_5);
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var8_5);
                var6_4.L$0 = var4_2;
                var6_4.J$0 = var0;
                var6_4.label = 1;
                if (DelayKt.delay(var2_1, (Continuation<? super Unit>)var6_4) == var7_6) {
                    return var7_6;
                }
                var5_3 = var4_2;
            }
        }
        while (true) {
            var8_5 = Unit.INSTANCE;
            var6_4.L$0 = var5_3;
            var6_4.J$0 = var0;
            var6_4.label = 2;
            var2_1 = var0;
            var4_2 = var5_3;
            if (var5_3.send((Object)var8_5, (Continuation<Unit>)var6_4) == var7_6) {
                return var7_6;
            }
lbl44:
            // 3 sources

            var6_4.L$0 = var4_2;
            var6_4.J$0 = var2_1;
            var6_4.label = 3;
            var0 = var2_1;
            if (DelayKt.delay(var2_1, (Continuation<? super Unit>)var6_4) == var7_6) {
                return var7_6;
            }
lbl50:
            // 3 sources

            var5_3 = var4_2;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static final Object fixedPeriodTicker(long var0, long var2_1, SendChannel<? super Unit> var4_2, Continuation<? super Unit> var5_3) {
        block12: {
            if (!(var5_3 /* !! */  instanceof fixedPeriodTicker.1)) ** GOTO lbl-1000
            var10_4 /* !! */  = var5_3 /* !! */ ;
            if ((var10_4 /* !! */ .label & -2147483648) != 0) {
                var10_4 /* !! */ .label += -2147483648;
                var5_3 /* !! */  = var10_4 /* !! */ ;
            } else lbl-1000:
            // 2 sources

            {
                var5_3 /* !! */  = new ContinuationImpl(var5_3 /* !! */ ){
                    long J$0;
                    long J$1;
                    Object L$0;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return TickerChannelsKt.access$fixedPeriodTicker(0L, 0L, null, (Continuation)this);
                    }
                };
            }
            var11_5 = var5_3 /* !! */ .result;
            var10_4 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var5_3 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 4: {
                    var0 = var5_3 /* !! */ .J$1;
                    var2_1 = var5_3 /* !! */ .J$0;
                    var4_2 = (SendChannel)var5_3 /* !! */ .L$0;
                    ResultKt.throwOnFailure((Object)var11_5);
                    break block12;
                }
                case 3: {
                    var0 = var5_3 /* !! */ .J$1;
                    var2_1 = var5_3 /* !! */ .J$0;
                    var4_2 = (SendChannel)var5_3 /* !! */ .L$0;
                    ResultKt.throwOnFailure((Object)var11_5);
                    break block12;
                }
                case 2: {
                    var0 = var5_3 /* !! */ .J$1;
                    var2_1 = var5_3 /* !! */ .J$0;
                    var4_2 = (SendChannel)var5_3 /* !! */ .L$0;
                    ResultKt.throwOnFailure((Object)var11_5);
                    ** GOTO lbl61
                }
                case 1: {
                    var0 = var5_3 /* !! */ .J$1;
                    var2_1 = var5_3 /* !! */ .J$0;
                    var4_2 = (SendChannel)var5_3 /* !! */ .L$0;
                    ResultKt.throwOnFailure((Object)var11_5);
                    break;
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var11_5);
                    var11_5 = AbstractTimeSourceKt.getTimeSource();
                    var6_6 = var11_5 != null ? var11_5.nanoTime() : System.nanoTime();
                    var5_3 /* !! */ .L$0 = var4_2;
                    var5_3 /* !! */ .J$0 = var0;
                    var5_3 /* !! */ .J$1 = var6_6 += EventLoop_commonKt.delayToNanos(var2_1);
                    var5_3 /* !! */ .label = 1;
                    if (DelayKt.delay(var2_1, var5_3 /* !! */ ) == var10_4 /* !! */ ) {
                        return var10_4 /* !! */ ;
                    }
                    var2_1 = var0;
                    var0 = var6_6;
                }
            }
            var6_6 = EventLoop_commonKt.delayToNanos(var2_1);
            var2_1 = var0;
            var0 = var6_6;
        }
        do lbl-1000:
        // 3 sources

        {
            block13: {
                var11_5 = Unit.INSTANCE;
                var5_3 /* !! */ .L$0 = var4_2;
                var5_3 /* !! */ .J$0 = var2_1 += var0;
                var5_3 /* !! */ .J$1 = var0;
                var5_3 /* !! */ .label = 2;
                if (var4_2.send(var11_5, var5_3 /* !! */ ) == var10_4 /* !! */ ) {
                    return var10_4 /* !! */ ;
                }
lbl61:
                // 3 sources

                var11_5 = AbstractTimeSourceKt.getTimeSource();
                var6_6 = var11_5 != null ? var11_5.nanoTime() : System.nanoTime();
                var8_7 = RangesKt.coerceAtLeast((long)(var2_1 - var6_6), (long)0L);
                if (var8_7 != 0L || var0 == 0L) break block13;
                var8_7 = var0 - (var6_6 - var2_1) % var0;
                var2_1 = var6_6 + var8_7;
                var6_6 = EventLoop_commonKt.delayNanosToMillis(var8_7);
                var5_3 /* !! */ .L$0 = var4_2;
                var5_3 /* !! */ .J$0 = var2_1;
                var5_3 /* !! */ .J$1 = var0;
                var5_3 /* !! */ .label = 3;
                if (DelayKt.delay(var6_6, var5_3 /* !! */ ) != var10_4 /* !! */ ) ** GOTO lbl-1000
                return var10_4 /* !! */ ;
            }
            var6_6 = EventLoop_commonKt.delayNanosToMillis(var8_7);
            var5_3 /* !! */ .L$0 = var4_2;
            var5_3 /* !! */ .J$0 = var2_1;
            var5_3 /* !! */ .J$1 = var0;
            var5_3 /* !! */ .label = 4;
        } while (DelayKt.delay(var6_6, var5_3 /* !! */ ) != var10_4 /* !! */ );
        return var10_4 /* !! */ ;
    }

    public static final ReceiveChannel<Unit> ticker(long l, long l2, CoroutineContext coroutineContext, TickerMode tickerMode) {
        boolean bl = true;
        boolean bl2 = l >= 0L;
        if (bl2) {
            bl2 = l2 >= 0L ? bl : false;
            if (bl2) {
                return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, (Function2)new Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object>(tickerMode, l, l2, null){
                    final long $delayMillis;
                    final long $initialDelayMillis;
                    final TickerMode $mode;
                    private Object L$0;
                    int label;
                    {
                        this.$mode = tickerMode;
                        this.$delayMillis = l;
                        this.$initialDelayMillis = l2;
                        super(2, continuation);
                    }

                    public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                        object2 = new /* invalid duplicate definition of identical inner class */;
                        object2.L$0 = object;
                        return object2;
                    }

                    public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
                        return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object object) {
                        Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        block0 : switch (this.label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 2: {
                                ResultKt.throwOnFailure((Object)object);
                                break;
                            }
                            case 1: {
                                ResultKt.throwOnFailure((Object)object);
                                break;
                            }
                            case 0: {
                                ResultKt.throwOnFailure((Object)object);
                                object = (ProducerScope)this.L$0;
                                Object object3 = this.$mode;
                                switch (ticker.WhenMappings.$EnumSwitchMapping$0[object3.ordinal()]) {
                                    default: {
                                        break block0;
                                    }
                                    case 2: {
                                        long l = this.$delayMillis;
                                        long l2 = this.$initialDelayMillis;
                                        object3 = object.getChannel();
                                        object = (Continuation)this;
                                        this.label = 2;
                                        if (TickerChannelsKt.access$fixedDelayTicker(l, l2, (SendChannel)object3, (Continuation)object) != object2) break block0;
                                        return object2;
                                    }
                                    case 1: {
                                        long l = this.$delayMillis;
                                        long l3 = this.$initialDelayMillis;
                                        object3 = object.getChannel();
                                        object = (Continuation)this;
                                        this.label = 1;
                                        if (TickerChannelsKt.access$fixedPeriodTicker(l, l3, (SendChannel)object3, (Continuation)object) != object2) break block0;
                                        return object2;
                                    }
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + l2 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + l + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long l, long l2, CoroutineContext coroutineContext, TickerMode tickerMode, int n, Object object) {
        if ((n & 2) != 0) {
            l2 = l;
        }
        if ((n & 4) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return TickerChannelsKt.ticker(l, l2, coroutineContext, tickerMode);
    }
}

