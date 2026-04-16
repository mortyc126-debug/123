/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause1;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0017J\u0014\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H'J\u001a\u0010\u0014\u001a\u00020\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019H&J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u00a6\u0002J\u000f\u0010\u001c\u001a\u0004\u0018\u00018\u0000H\u0017\u00a2\u0006\u0002\u0010\u001dJ\u0011\u0010\u001e\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\"\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u00a6@\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\u001fJ\u0013\u0010\"\u001a\u0004\u0018\u00018\u0000H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH&\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00048&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00048&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0007R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000bX\u00a6\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\"\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006%"}, d2={"Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isEmpty", "isEmpty$annotations", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveOrNull", "tryReceive", "tryReceive-PtdJZtk", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public interface ReceiveChannel<E> {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel();

    public void cancel(CancellationException var1);

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable var1);

    public SelectClause1<E> getOnReceive();

    public SelectClause1<ChannelResult<E>> getOnReceiveCatching();

    public SelectClause1<E> getOnReceiveOrNull();

    public boolean isClosedForReceive();

    public boolean isEmpty();

    public ChannelIterator<E> iterator();

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith=@ReplaceWith(expression="tryReceive().getOrNull()", imports={}))
    public E poll();

    public Object receive(Continuation<? super E> var1);

    public Object receiveCatching-JP2dKIU(Continuation<? super ChannelResult<? extends E>> var1);

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}))
    public Object receiveOrNull(Continuation<? super E> var1);

    public Object tryReceive-PtdJZtk();

    @Metadata(k=3, mv={1, 8, 0}, xi=48)
    public static final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static /* synthetic */ void cancel(ReceiveChannel receiveChannel) {
            receiveChannel.cancel(null);
        }

        public static /* synthetic */ void cancel$default(ReceiveChannel receiveChannel, CancellationException cancellationException, int n, Object object) {
            if (object == null) {
                if ((n & 1) != 0) {
                    cancellationException = null;
                }
                receiveChannel.cancel(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ boolean cancel$default(ReceiveChannel receiveChannel, Throwable throwable, int n, Object object) {
            if (object == null) {
                if ((n & 1) != 0) {
                    throwable = null;
                }
                return receiveChannel.cancel(throwable);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <E> SelectClause1<E> getOnReceiveOrNull(ReceiveChannel<? extends E> receiveChannel) {
            Intrinsics.checkNotNull(receiveChannel, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel<E of kotlinx.coroutines.channels.ReceiveChannel>");
            return ((BufferedChannel)receiveChannel).getOnReceiveOrNull();
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in favor of onReceiveCatching extension", replaceWith=@ReplaceWith(expression="onReceiveCatching", imports={}))
        public static /* synthetic */ void getOnReceiveOrNull$annotations() {
        }

        public static /* synthetic */ void isClosedForReceive$annotations() {
        }

        public static /* synthetic */ void isEmpty$annotations() {
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith=@ReplaceWith(expression="tryReceive().getOrNull()", imports={}))
        public static <E> E poll(ReceiveChannel<? extends E> object) {
            if (ChannelResult.isSuccess-impl(object = object.tryReceive-PtdJZtk())) {
                return (E)ChannelResult.getOrThrow-impl(object);
            }
            if ((object = ChannelResult.exceptionOrNull-impl(object)) == null) {
                return null;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(object);
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}))
        public static <E> Object receiveOrNull(ReceiveChannel<? extends E> var0, Continuation<? super E> var1_1) {
            if (!(var1_1 /* !! */  instanceof receiveOrNull.1)) ** GOTO lbl-1000
            var2_2 /* !! */  = var1_1 /* !! */ ;
            if ((var2_2 /* !! */ .label & -2147483648) != 0) {
                var2_2 /* !! */ .label += -2147483648;
                var1_1 /* !! */  = var2_2 /* !! */ ;
            } else lbl-1000:
            // 2 sources

            {
                var1_1 /* !! */  = new ContinuationImpl(var1_1 /* !! */ ){
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return DefaultImpls.receiveOrNull(null, (Continuation)this);
                    }
                };
            }
            var3_3 = var1_1 /* !! */ .result;
            var2_2 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var1_1 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    ResultKt.throwOnFailure((Object)var3_3);
                    var0 = ((ChannelResult)var3_3).unbox-impl();
                    break;
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var3_3);
                    var1_1 /* !! */ .label = 1;
                    var0 = var1_1 /* !! */  = var0.receiveCatching-JP2dKIU(var1_1 /* !! */ );
                    if (var1_1 /* !! */  != var2_2 /* !! */ ) break;
                    return var2_2 /* !! */ ;
                }
            }
            return ChannelResult.getOrNull-impl(var0);
        }
    }
}

