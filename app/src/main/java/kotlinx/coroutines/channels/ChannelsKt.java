/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 */
package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelsKt__ChannelsKt;
import kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt;
import kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata(d1={"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, k=4, mv={1, 8, 0}, xi=48)
public final class ChannelsKt {
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object any(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.any(receiveChannel, continuation);
    }

    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable throwable) {
        ChannelsKt__Channels_commonKt.cancelConsumed(receiveChannel, throwable);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E, R> R consume(BroadcastChannel<E> broadcastChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        return ChannelsKt__Channels_commonKt.consume(broadcastChannel, function1);
    }

    public static final <E, R> R consume(ReceiveChannel<? extends E> receiveChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        return ChannelsKt__Channels_commonKt.consume(receiveChannel, function1);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach(broadcastChannel, function1, continuation);
    }

    public static final <E> Object consumeEach(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach(receiveChannel, function1, continuation);
    }

    public static final Function1<Throwable, Unit> consumes(ReceiveChannel<?> receiveChannel) {
        return ChannelsKt__DeprecatedKt.consumes(receiveChannel);
    }

    public static final Function1<Throwable, Unit> consumesAll(ReceiveChannel<?> ... receiveChannelArray) {
        return ChannelsKt__DeprecatedKt.consumesAll(receiveChannelArray);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object count(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.count(receiveChannel, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel distinct(ReceiveChannel receiveChannel) {
        return ChannelsKt__DeprecatedKt.distinct(receiveChannel);
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        return ChannelsKt__DeprecatedKt.distinctBy$default(receiveChannel, coroutineContext, function2, n, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel receiveChannel, int n, CoroutineContext coroutineContext) {
        return ChannelsKt__DeprecatedKt.drop(receiveChannel, n, coroutineContext);
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int n, CoroutineContext coroutineContext, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.drop$default(receiveChannel, n, coroutineContext, n2, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__DeprecatedKt.dropWhile(receiveChannel, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        return ChannelsKt__DeprecatedKt.dropWhile$default(receiveChannel, coroutineContext, function2, n, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object elementAt(ReceiveChannel receiveChannel, int n, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.elementAt(receiveChannel, n, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel receiveChannel, int n, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.elementAtOrNull(receiveChannel, n, continuation);
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.filter(receiveChannel, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        return ChannelsKt__DeprecatedKt.filter$default(receiveChannel, coroutineContext, function2, n, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ChannelsKt__DeprecatedKt.filterIndexed(receiveChannel, coroutineContext, function3);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int n, Object object) {
        return ChannelsKt__DeprecatedKt.filterIndexed$default(receiveChannel, coroutineContext, function3, n, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__DeprecatedKt.filterNot(receiveChannel, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        return ChannelsKt__DeprecatedKt.filterNot$default(receiveChannel, coroutineContext, function2, n, object);
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__DeprecatedKt.filterNotNull(receiveChannel);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel receiveChannel, Collection collection, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.filterNotNullTo(receiveChannel, collection, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.filterNotNullTo(receiveChannel, sendChannel, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object first(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.first(receiveChannel, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.firstOrNull(receiveChannel, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__DeprecatedKt.flatMap(receiveChannel, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        return ChannelsKt__DeprecatedKt.flatMap$default(receiveChannel, coroutineContext, function2, n, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object indexOf(ReceiveChannel receiveChannel, Object object, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.indexOf(receiveChannel, object, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object last(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.last(receiveChannel, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel receiveChannel, Object object, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.lastIndexOf(receiveChannel, object, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.lastOrNull(receiveChannel, continuation);
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.map(receiveChannel, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        return ChannelsKt__DeprecatedKt.map$default(receiveChannel, coroutineContext, function2, n, object);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ChannelsKt__DeprecatedKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int n, Object object) {
        return ChannelsKt__DeprecatedKt.mapIndexed$default(receiveChannel, coroutineContext, function3, n, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ChannelsKt__DeprecatedKt.mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int n, Object object) {
        return ChannelsKt__DeprecatedKt.mapIndexedNotNull$default(receiveChannel, coroutineContext, function3, n, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__DeprecatedKt.mapNotNull(receiveChannel, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        return ChannelsKt__DeprecatedKt.mapNotNull$default(receiveChannel, coroutineContext, function2, n, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object maxWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.maxWith(receiveChannel, comparator, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object minWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.minWith(receiveChannel, comparator, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object none(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.none(receiveChannel, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in the favour of 'onReceiveCatching'")
    public static final /* synthetic */ SelectClause1 onReceiveOrNull(ReceiveChannel receiveChannel) {
        return ChannelsKt__Channels_commonKt.onReceiveOrNull(receiveChannel);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in the favour of 'receiveCatching'", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}))
    public static final /* synthetic */ Object receiveOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.receiveOrNull(receiveChannel, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Left for binary compatibility")
    public static final /* synthetic */ ReceiveChannel requireNoNulls(ReceiveChannel receiveChannel) {
        return ChannelsKt__DeprecatedKt.requireNoNulls(receiveChannel);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith=@ReplaceWith(expression="trySendBlocking(element)", imports={}))
    public static final /* synthetic */ void sendBlocking(SendChannel sendChannel, Object object) {
        ChannelsKt__ChannelsKt.sendBlocking(sendChannel, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object single(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.single(receiveChannel, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.singleOrNull(receiveChannel, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel receiveChannel, int n, CoroutineContext coroutineContext) {
        return ChannelsKt__DeprecatedKt.take(receiveChannel, n, coroutineContext);
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int n, CoroutineContext coroutineContext, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.take$default(receiveChannel, n, coroutineContext, n2, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt__DeprecatedKt.takeWhile(receiveChannel, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        return ChannelsKt__DeprecatedKt.takeWhile$default(receiveChannel, coroutineContext, function2, n, object);
    }

    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.toChannel(receiveChannel, c, continuation);
    }

    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.toCollection(receiveChannel, c, continuation);
    }

    public static final <E> Object toList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.toList(receiveChannel, continuation);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        return ChannelsKt__DeprecatedKt.toMap(receiveChannel, m, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object toMap(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.toMap(receiveChannel, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object toMutableList(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.toMutableList(receiveChannel, continuation);
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt__DeprecatedKt.toMutableSet(receiveChannel, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object toSet(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.toSet(receiveChannel, continuation);
    }

    public static final <E> Object trySendBlocking(SendChannel<? super E> sendChannel, E e) {
        return ChannelsKt__ChannelsKt.trySendBlocking(sendChannel, e);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel receiveChannel, CoroutineContext coroutineContext) {
        return ChannelsKt__DeprecatedKt.withIndex(receiveChannel, coroutineContext);
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int n, Object object) {
        return ChannelsKt__DeprecatedKt.withIndex$default(receiveChannel, coroutineContext, n, object);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel zip(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2) {
        return ChannelsKt__DeprecatedKt.zip(receiveChannel, receiveChannel2);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext coroutineContext, Function2<? super E, ? super R, ? extends V> function2) {
        return ChannelsKt__DeprecatedKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        return ChannelsKt__DeprecatedKt.zip$default(receiveChannel, receiveChannel2, coroutineContext, function2, n, object);
    }
}

