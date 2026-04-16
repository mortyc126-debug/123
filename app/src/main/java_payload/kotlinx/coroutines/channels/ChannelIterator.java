/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 */
package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0011\u0010\u0003\u001a\u00020\u0004H\u00a6B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00028\u0000H\u00a6\u0002\u00a2\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00028\u0000H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2={"Lkotlinx/coroutines/channels/ChannelIterator;", "E", "", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "next0", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public interface ChannelIterator<E> {
    public Object hasNext(Continuation<? super Boolean> var1);

    public E next();

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.3.0, binary compatibility with versions <= 1.2.x")
    public /* synthetic */ Object next(Continuation var1);

    @Metadata(k=3, mv={1, 8, 0}, xi=48)
    public static final class DefaultImpls {
        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public static /* synthetic */ Object next(ChannelIterator var0, Continuation var1_1) {
            if (!(var1_1 /* !! */  instanceof next0.1)) ** GOTO lbl-1000
            var2_2 /* !! */  = var1_1 /* !! */ ;
            if ((var2_2 /* !! */ .label & -2147483648) != 0) {
                var2_2 /* !! */ .label += -2147483648;
                var1_1 /* !! */  = var2_2 /* !! */ ;
            } else lbl-1000:
            // 2 sources

            {
                var1_1 /* !! */  = new ContinuationImpl((Continuation<? super next0.1>)var1_1 /* !! */ ){
                    Object L$0;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return DefaultImpls.next(null, (Continuation)this);
                    }
                };
            }
            var2_2 /* !! */  = var1_1 /* !! */ .result;
            var3_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var1_1 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    var0 = (ChannelIterator)var1_1 /* !! */ .L$0;
                    ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                    var1_1 /* !! */  = var2_2 /* !! */ ;
                    break;
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                    var1_1 /* !! */ .L$0 = var0;
                    var1_1 /* !! */ .label = 1;
                    var2_2 /* !! */  = var0.hasNext((Continuation<Boolean>)var1_1 /* !! */ );
                    var1_1 /* !! */  = var2_2 /* !! */ ;
                    if (var2_2 /* !! */  != var3_3) break;
                    return var3_3;
                }
            }
            if (((Boolean)var1_1 /* !! */ ).booleanValue()) {
                return var0.next();
            }
            throw new ClosedReceiveChannelException("Channel was closed");
        }
    }
}

