/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ConflatedBufferedChannel;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u001aX\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u000b0\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a^\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u0016\u0010\u0013\u001a^\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u0017\u0010\u0013\u001a\\\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u0011H\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u001a\u0010\u0013\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2={"Channel", "Lkotlinx/coroutines/channels/Channel;", "E", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "getOrElse", "T", "Lkotlinx/coroutines/channels/ChannelResult;", "onFailure", "", "Lkotlin/ParameterName;", "name", "exception", "getOrElse-WpGqRn0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onClosed", "action", "onClosed-WpGqRn0", "onFailure-WpGqRn0", "onSuccess", "value", "onSuccess-WpGqRn0", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class ChannelKt {
    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final <E> Channel<E> Channel(int n, BufferOverflow object, Function1<? super E, Unit> function1) {
        void var1_14;
        void var1_16;
        block11: {
            void var2_17;
            int n2 = 0;
            switch (n) {
                default: {
                    if (object != BufferOverflow.SUSPEND) break;
                    BufferedChannel bufferedChannel = new BufferedChannel(n, var2_17);
                    break block11;
                }
                case 0x7FFFFFFF: {
                    Channel channel = new BufferedChannel(Integer.MAX_VALUE, var2_17);
                    return var1_16;
                }
                case 0: {
                    void var1_6;
                    if (object == BufferOverflow.SUSPEND) {
                        BufferedChannel bufferedChannel = new BufferedChannel(0, var2_17);
                    } else {
                        BufferedChannel bufferedChannel = new ConflatedBufferedChannel(1, (BufferOverflow)((Object)object), var2_17);
                    }
                    Channel channel = (Channel)var1_6;
                    return var1_16;
                }
                case -1: {
                    n = n2;
                    if (object == BufferOverflow.SUSPEND) {
                        n = 1;
                    }
                    if (n == 0) throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
                    Channel channel = new ConflatedBufferedChannel(1, BufferOverflow.DROP_OLDEST, var2_17);
                    return var1_16;
                }
                case -2: {
                    void var1_11;
                    if (object == BufferOverflow.SUSPEND) {
                        BufferedChannel bufferedChannel = new BufferedChannel(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core(), var2_17);
                    } else {
                        BufferedChannel bufferedChannel = new ConflatedBufferedChannel(1, (BufferOverflow)((Object)object), var2_17);
                    }
                    Channel channel = (Channel)var1_11;
                    return var1_16;
                }
            }
            BufferedChannel bufferedChannel = new ConflatedBufferedChannel(n, (BufferOverflow)((Object)object), var2_17);
        }
        Channel channel = (Channel)var1_14;
        return var1_16;
    }

    public static /* synthetic */ Channel Channel$default(int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        return ChannelKt.Channel$default(n, null, null, 6, null);
    }

    public static /* synthetic */ Channel Channel$default(int n, BufferOverflow bufferOverflow, Function1 function1, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        if ((n2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((n2 & 4) != 0) {
            function1 = null;
        }
        return ChannelKt.Channel(n, bufferOverflow, function1);
    }

    public static final <T> T getOrElse-WpGqRn0(Object object, Function1<? super Throwable, ? extends T> function1) {
        block0: {
            if (!(object instanceof ChannelResult.Failed)) break block0;
            object = function1.invoke((Object)ChannelResult.exceptionOrNull-impl(object));
        }
        return (T)object;
    }

    public static final <T> Object onClosed-WpGqRn0(Object object, Function1<? super Throwable, Unit> function1) {
        if (object instanceof ChannelResult.Closed) {
            function1.invoke((Object)ChannelResult.exceptionOrNull-impl(object));
        }
        return object;
    }

    public static final <T> Object onFailure-WpGqRn0(Object object, Function1<? super Throwable, Unit> function1) {
        if (object instanceof ChannelResult.Failed) {
            function1.invoke((Object)ChannelResult.exceptionOrNull-impl(object));
        }
        return object;
    }

    public static final <T> Object onSuccess-WpGqRn0(Object object, Function1<? super T, Unit> function1) {
        if (!(object instanceof ChannelResult.Failed)) {
            function1.invoke(object);
        }
        return object;
    }
}

