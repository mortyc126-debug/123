/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0007\u00a2\u0006\u0002\u0010\u0005\u001a,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2={"sendBlocking", "", "E", "Lkotlinx/coroutines/channels/SendChannel;", "element", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)V", "trySendBlocking", "Lkotlinx/coroutines/channels/ChannelResult;", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/channels/ChannelsKt")
final class ChannelsKt__ChannelsKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith=@ReplaceWith(expression="trySendBlocking(element)", imports={}))
    public static final /* synthetic */ void sendBlocking(SendChannel sendChannel, Object object) {
        if (ChannelResult.isSuccess-impl(sendChannel.trySend-JP2dKIU(object))) {
            return;
        }
        BuildersKt.runBlocking$default(null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(sendChannel, object, null){
            final E $element;
            final SendChannel<E> $this_sendBlocking;
            int label;
            {
                this.$this_sendBlocking = sendChannel;
                this.$element = e;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object sendChannel) {
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)sendChannel);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)sendChannel);
                        sendChannel = this.$this_sendBlocking;
                        E e = this.$element;
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (sendChannel.send(e, (Continuation<Unit>)continuation) != object) break;
                        return object;
                    }
                }
                return Unit.INSTANCE;
            }
        }, 1, null);
    }

    public static final <E> Object trySendBlocking(SendChannel<? super E> unit, E e) {
        Object object = unit.trySend-JP2dKIU(e);
        if (!(object instanceof ChannelResult.Failed)) {
            unit = (Unit)object;
            return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
        }
        return ((ChannelResult)BuildersKt.runBlocking$default(null, (Function2)new Function2<CoroutineScope, Continuation<? super ChannelResult<? extends Unit>>, Object>(unit, e, null){
            final E $element;
            final SendChannel<E> $this_trySendBlocking;
            private Object L$0;
            int label;
            {
                this.$this_trySendBlocking = sendChannel;
                this.$element = e;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ChannelResult<Unit>> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final Object invokeSuspend(Object object) {
                block10: {
                    Object object2;
                    block11: {
                        object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
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
                                object = (CoroutineScope)this.L$0;
                                SendChannel<Object> sendChannel = this.$this_trySendBlocking;
                                object = this.$element;
                                Result.Companion companion = Result.Companion;
                                this.label = 1;
                                object = sendChannel.send(object, (Continuation<Unit>)this);
                                if (object != object2) break;
                                return object2;
                            }
                        }
                        try {
                            object = Result.constructor-impl((Object)Unit.INSTANCE);
                            break block10;
                        }
                        catch (Throwable throwable) {
                            break block11;
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    object2 = Result.Companion;
                    object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)object));
                }
                if (Result.isSuccess-impl((Object)object)) {
                    object = ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
                    return ChannelResult.box-impl(object);
                }
                object = ChannelResult.Companion.closed-JP2dKIU(Result.exceptionOrNull-impl((Object)object));
                return ChannelResult.box-impl(object);
            }
        }, 1, null)).unbox-impl();
    }
}

