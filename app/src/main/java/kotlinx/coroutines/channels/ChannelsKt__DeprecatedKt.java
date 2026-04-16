/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.IndexedValue
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 */
package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1={"\u0000\u00a0\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aJ\u0010\u0000\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00072\u001a\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\t\"\u0006\u0012\u0002\b\u00030\nH\u0001\u00a2\u0006\u0002\u0010\u000b\u001a!\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a1\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007*\u0006\u0012\u0002\b\u00030\nH\u0001\u001a!\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0007\u001aZ\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001a0\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001aT\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001a)\u0010!\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\"\u001a\u00020\u0012H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#\u001a+\u0010$\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\"\u001a\u00020\u0012H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#\u001aT\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001ai\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001727\u0010 \u001a3\b\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(\u001aT\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001a$\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\b\b\u0000\u0010\u000e*\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0001\u001aA\u0010+\u001a\u0002H,\"\b\b\u0000\u0010\u000e*\u00020\u001b\"\u0010\b\u0001\u0010,*\n\u0012\u0006\b\u0000\u0012\u0002H\u000e0-*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/\u001a?\u0010+\u001a\u0002H,\"\b\b\u0000\u0010\u000e*\u00020\u001b\"\u000e\b\u0001\u0010,*\b\u0012\u0004\u0012\u0002H\u000e00*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101\u001a!\u00102\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a#\u00103\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a`\u00104\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172(\u00106\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50\n0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001a)\u00107\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00108\u001a\u0002H\u000eH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00109\u001a!\u0010:\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a)\u0010;\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00108\u001a\u0002H\u000eH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00109\u001a#\u0010<\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001aZ\u0010=\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u00106\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001ao\u0010>\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001727\u00106\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(\u001au\u0010?\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\b\b\u0001\u00105*\u00020\u001b*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001729\u00106\u001a5\b\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(\u001a`\u0010@\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\b\b\u0001\u00105*\u00020\u001b*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172$\u00106\u001a \b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001a?\u0010A\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0Cj\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`DH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010E\u001a?\u0010F\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0Cj\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`DH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010E\u001a!\u0010G\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a$\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\b\b\u0000\u0010\u000e*\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0007\u001a!\u0010I\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a#\u0010J\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a0\u0010K\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001aT\u0010L\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001a9\u0010M\u001a\u0002H,\"\u0004\b\u0000\u0010\u000e\"\u000e\b\u0001\u0010,*\b\u0012\u0004\u0012\u0002H\u000e00*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0081@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101\u001a;\u0010N\u001a\u0002H,\"\u0004\b\u0000\u0010\u000e\"\u0010\b\u0001\u0010,*\n\u0012\u0006\b\u0000\u0012\u0002H\u000e0-*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0081@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/\u001a?\u0010O\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0P\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010Q*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0R0\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001aU\u0010O\u001a\u0002HS\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010Q\"\u0018\b\u0002\u0010S*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0015\u0012\u0006\b\u0000\u0012\u0002HQ0T*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0R0\n2\u0006\u0010.\u001a\u0002HSH\u0081@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010U\u001a'\u0010V\u001a\b\u0012\u0004\u0012\u0002H\u000e0W\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a'\u0010X\u001a\b\u0012\u0004\u0012\u0002H\u000e0Y\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0081@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a'\u0010Z\u001a\b\u0012\u0004\u0012\u0002H\u000e0[\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a.\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0]0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001a?\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H50R0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002H50\nH\u0087\u0004\u001az\u0010^\u001a\b\u0012\u0004\u0012\u0002HQ0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105\"\u0004\b\u0002\u0010Q*\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002H50\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001726\u00106\u001a2\u0012\u0013\u0012\u0011H\u000e\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(`\u0012\u0013\u0012\u0011H5\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(a\u0012\u0004\u0012\u0002HQ0\u0019H\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006b"}, d2={"consumesAll", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "channels", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "any", "", "E", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumes", "count", "", "distinct", "distinctBy", "K", "context", "Lkotlin/coroutines/CoroutineContext;", "selector", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "drop", "n", "dropWhile", "predicate", "elementAt", "index", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterNot", "filterNotNull", "filterNotNullTo", "C", "", "destination", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "first", "firstOrNull", "flatMap", "R", "transform", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapNotNull", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "requireNoNulls", "single", "singleOrNull", "take", "takeWhile", "toChannel", "toCollection", "toMap", "", "V", "Lkotlin/Pair;", "M", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", "", "toMutableSet", "", "toSet", "", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/channels/ChannelsKt")
final class ChannelsKt__DeprecatedKt {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object any(ReceiveChannel var0, Continuation var1_1) {
        block12: {
            if (!(var1_1 /* !! */  instanceof any.1)) ** GOTO lbl-1000
            var2_5 = var1_1 /* !! */ ;
            if ((var2_5.label & -2147483648) != 0) {
                var2_5.label += -2147483648;
                var1_1 /* !! */  = var2_5;
            } else lbl-1000:
            // 2 sources

            {
                var1_1 /* !! */  = new ContinuationImpl((Continuation<? super any.1>)var1_1 /* !! */ ){
                    Object L$0;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return ChannelsKt.any(null, (Continuation)this);
                    }
                };
            }
            var2_5 = var1_1 /* !! */ .result;
            var3_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var1_1 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    var0 = (ReceiveChannel)var1_1 /* !! */ .L$0;
                    try {
                        ResultKt.throwOnFailure((Object)var2_5);
                        var1_1 /* !! */  = var2_5;
                        break;
                    }
                    catch (Throwable var1_2) {
                        break block12;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var2_5);
                    var2_5 = var0.iterator();
                    var1_1 /* !! */ .L$0 = var0;
                    var1_1 /* !! */ .label = 1;
                    var2_5 = var2_5.hasNext((Continuation<? super Boolean>)var1_1 /* !! */ );
                    var1_1 /* !! */  = var2_5;
                    if (var2_5 != var3_7) break;
                    return var3_7;
                }
            }
            ChannelsKt.cancelConsumed(var0, null);
            return var1_1 /* !! */ ;
            catch (Throwable var1_3) {
                // empty catch block
            }
        }
        try {
            throw var1_4;
        }
        catch (Throwable var2_6) {
            ChannelsKt.cancelConsumed(var0, (Throwable)var1_4);
            throw var2_6;
        }
    }

    public static final Function1<Throwable, Unit> consumes(ReceiveChannel<?> receiveChannel) {
        return (Function1)new Function1<Throwable, Unit>(receiveChannel){
            final ReceiveChannel<?> $this_consumes;
            {
                this.$this_consumes = receiveChannel;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                ChannelsKt.cancelConsumed(this.$this_consumes, throwable);
            }
        };
    }

    public static final Function1<Throwable, Unit> consumesAll(ReceiveChannel<?> ... receiveChannelArray) {
        return (Function1)new Function1<Throwable, Unit>(receiveChannelArray){
            final ReceiveChannel<?>[] $channels;
            {
                this.$channels = receiveChannelArray;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                Throwable throwable2 = null;
                for (ReceiveChannel<?> receiveChannel : this.$channels) {
                    try {
                        ChannelsKt.cancelConsumed(receiveChannel, throwable);
                    }
                    catch (Throwable throwable3) {
                        if (throwable2 == null) {
                            throwable2 = throwable3;
                            continue;
                        }
                        ExceptionsKt.addSuppressed((Throwable)throwable2, (Throwable)throwable3);
                    }
                }
                if (throwable2 == null) {
                    return;
                }
                throw throwable2;
            }
        };
    }

    /*
     * Exception decompiling
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object count(ReceiveChannel var0, Continuation var1_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [2 : 196->203)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel distinct(ReceiveChannel receiveChannel) {
        return ChannelsKt.distinctBy$default(receiveChannel, null, new Function2<E, Continuation<? super E>, Object>(null){
            Object L$0;
            int label;

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(E e, Continuation<? super E> continuation) {
                return (this.create(e, continuation)).invokeSuspend(Unit.INSTANCE);
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
                return this.L$0;
            }
        }, 1, null);
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>(receiveChannel, function2, null){
            final Function2<E, Continuation<? super K>, Object> $selector;
            final ReceiveChannel<E> $this_distinctBy;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            {
                this.$this_distinctBy = receiveChannel;
                this.$selector = function2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[CASE], 0[SWITCH]], but top level block is 6[UNCONDITIONALDOLOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel receiveChannel, int n, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>(n, receiveChannel, null){
            final int $n;
            final ReceiveChannel<E> $this_drop;
            int I$0;
            private Object L$0;
            Object L$1;
            int label;
            {
                this.$n = n;
                this.$this_drop = receiveChannel;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[CASE], 0[SWITCH]], but top level block is 6[UNCONDITIONALDOLOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int n, CoroutineContext coroutineContext, int n2, Object object) {
        if ((n2 & 2) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.drop(receiveChannel, n, coroutineContext);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>(receiveChannel, function2, null){
            final Function2<E, Continuation<? super Boolean>, Object> $predicate;
            final ReceiveChannel<E> $this_dropWhile;
            private Object L$0;
            Object L$1;
            Object L$2;
            int label;
            {
                this.$this_dropWhile = receiveChannel;
                this.$predicate = function2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[CASE], 0[SWITCH]], but top level block is 8[UNCONDITIONALDOLOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.dropWhile(receiveChannel, coroutineContext, function2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object elementAt(ReceiveChannel var0, int var1_1, Continuation var2_2) {
        if (!(var2_2 instanceof elementAt.1)) ** GOTO lbl-1000
        var8_9 = (ContinuationImpl)var2_2;
        if ((var8_9.label & -2147483648) != 0) {
            var8_9.label += -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            var8_9 = new ContinuationImpl((Continuation<? super elementAt.1>)var2_2){
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.elementAt(null, 0, (Continuation)this);
                }
            };
        }
        var2_2 = var8_9.result;
        var5_10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        block7 : switch (var8_9.label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var4_12 = var8_9.I$1;
                var1_1 = var8_9.I$0;
                var6_13 = (ChannelIterator)var8_9.L$1;
                var0 = (ReceiveChannel)var8_9.L$0;
                try {
                    ResultKt.throwOnFailure((Object)var2_2);
                    var10_14 = null;
                    var7_15 = var5_10;
                    var5_10 = var2_2;
                    var9_16 = var2_2;
                    var2_2 = var7_15;
                    var7_15 = var10_14;
                    ** break;
                }
                catch (Throwable var2_3) {
                    break;
                }
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var2_2);
                if (var1_1 >= 0) {
                    var6_13 = var0.iterator();
                    var4_12 = 0;
                    var7_15 = null;
                    var3_17 = var1_1;
                    var1_1 = var4_12;
                    while (true) lbl-1000:
                    // 2 sources

                    {
                        try {
                            var8_9.L$0 = var0;
                            var8_9.L$1 = var6_13;
                            var8_9.I$0 = var3_17;
                            var8_9.I$1 = var1_1;
                            var8_9.label = 1;
                            var9_16 = var6_13.hasNext((Continuation<? super Boolean>)var8_9);
                            if (var9_16 == var5_10) {
                                return var5_10;
                            }
                            var10_14 = var2_2;
                            var4_12 = var1_1;
                            var2_2 = var5_10;
                            var1_1 = var3_17;
                            var5_10 = var10_14;
                        }
                        catch (Throwable var2_6) {
                            break block7;
                        }
                        break;
                    }
                }
                ** GOTO lbl-1000
lbl-1000:
                // 2 sources

                {
                    try {
                        if (!((Boolean)var9_16).booleanValue()) break;
                        var9_16 = var6_13.next();
                        if (var1_1 == var4_12) {
                        }
                        ** GOTO lbl66
                    }
                    catch (Throwable var2_5) {
                        break block7;
                    }
                    ChannelsKt.cancelConsumed(var0, (Throwable)var7_15);
                    return var9_16;
lbl66:
                    // 1 sources

                    var3_17 = var1_1;
                    var9_16 = var2_2;
                    var1_1 = var4_12 + 1;
                    var2_2 = var5_10;
                    var5_10 = var9_16;
                    ** while (true)
                }
                try {
                    var2_2 = new StringBuilder();
                    var5_10 = new IndexOutOfBoundsException(var2_2.append("ReceiveChannel doesn't contain element at index ").append(var1_1).append('.').toString());
                    throw var5_10;
                }
                catch (Throwable var2_4) {
                    break;
                }
                catch (Throwable var2_7) {
                    break;
                }
lbl-1000:
                // 1 sources

                {
                    var2_2 = new StringBuilder();
                    var5_10 = new IndexOutOfBoundsException(var2_2.append("ReceiveChannel doesn't contain element at index ").append(var1_1).append('.').toString());
                    throw var5_10;
                }
            }
        }
        try {
            throw var2_8;
        }
        catch (Throwable var5_11) {
            ChannelsKt.cancelConsumed(var0, (Throwable)var2_8);
            throw var5_11;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel var0, int var1_1, Continuation var2_2) {
        if (!(var2_2 /* !! */  instanceof elementAtOrNull.1)) ** GOTO lbl-1000
        var8_8 = (ContinuationImpl)var2_2 /* !! */ ;
        if ((var8_8.label & -2147483648) != 0) {
            var8_8.label += -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            var8_8 = new ContinuationImpl((Continuation<? super elementAtOrNull.1>)var2_2 /* !! */ ){
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.elementAtOrNull(null, 0, (Continuation)this);
                }
            };
        }
        var2_2 /* !! */  = var8_8.result;
        var5_9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        block5 : switch (var8_8.label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var4_11 = var8_8.I$1;
                var1_1 = var8_8.I$0;
                var7_12 = (ChannelIterator)var8_8.L$1;
                var0 = (ReceiveChannel)var8_8.L$0;
                try {
                    ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                    var10_13 /* !! */  = null;
                    var6_14 = var5_9;
                    var5_9 = var2_2 /* !! */ ;
                    var9_15 /* !! */  = var2_2 /* !! */ ;
                    var2_2 /* !! */  = var6_14;
                    var6_14 = var10_13 /* !! */ ;
                    ** break;
                }
                catch (Throwable var2_3) {
                    break;
                }
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                if (var1_1 < 0) {
                    ChannelsKt.cancelConsumed(var0, null);
                    return null;
                }
                var7_12 = null;
                try {
                    var6_14 = var0.iterator();
                    var4_11 = 0;
                    var3_16 = var1_1;
                    var1_1 = var4_11;
                }
                catch (Throwable var2_6) {
                    // empty catch block
                }
                while (true) {
                    try {
                        var8_8.L$0 = var0;
                        var8_8.L$1 = var6_14;
                        var8_8.I$0 = var3_16;
                        var8_8.I$1 = var1_1;
                        var8_8.label = 1;
                        var9_15 /* !! */  = var6_14.hasNext((Continuation<? super Boolean>)var8_8);
                        if (var9_15 /* !! */  == var5_9) {
                            return var5_9;
                        }
                        var10_13 /* !! */  = var2_2 /* !! */ ;
                        var11_17 = var7_12;
                        var7_12 = var6_14;
                        var4_11 = var1_1;
                        var2_2 /* !! */  = var5_9;
                        var6_14 = var11_17;
                        var1_1 = var3_16;
                        var5_9 = var10_13 /* !! */ ;
                    }
                    catch (Throwable var2_5) {
                        break block5;
                    }
lbl60:
                    // 2 sources

                    try {
                        if (!((Boolean)var9_15 /* !! */ ).booleanValue()) break;
                        var9_15 /* !! */  = var7_12.next();
                        if (var1_1 == var4_11) {
                        }
                        ** GOTO lbl70
                    }
                    catch (Throwable var2_4) {
                        break block5;
                    }
                    ChannelsKt.cancelConsumed(var0, (Throwable)var6_14);
                    return var9_15 /* !! */ ;
lbl70:
                    // 1 sources

                    var3_16 = var1_1;
                    var9_15 /* !! */  = var7_12;
                    var7_12 = var6_14;
                    var6_14 = var2_2 /* !! */ ;
                    var1_1 = var4_11 + 1;
                    var2_2 /* !! */  = var5_9;
                    var5_9 = var6_14;
                    var6_14 = var9_15 /* !! */ ;
                }
                ChannelsKt.cancelConsumed(var0, (Throwable)var6_14);
                return null;
            }
        }
        try {
            throw var2_7;
        }
        catch (Throwable var5_10) {
            ChannelsKt.cancelConsumed(var0, (Throwable)var2_7);
            throw var5_10;
        }
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>(receiveChannel, function2, null){
            final Function2<E, Continuation<? super Boolean>, Object> $predicate;
            final ReceiveChannel<E> $this_filter;
            private Object L$0;
            Object L$1;
            Object L$2;
            int label;
            {
                this.$this_filter = receiveChannel;
                this.$predicate = function2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[CASE], 0[SWITCH]], but top level block is 6[UNCONDITIONALDOLOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.filter(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>(receiveChannel, function3, null){
            final Function3<Integer, E, Continuation<? super Boolean>, Object> $predicate;
            final ReceiveChannel<E> $this_filterIndexed;
            int I$0;
            private Object L$0;
            Object L$1;
            Object L$2;
            int label;
            {
                this.$this_filterIndexed = receiveChannel;
                this.$predicate = function3;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[CASE], 0[SWITCH]], but top level block is 6[UNCONDITIONALDOLOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.filterIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt.filter(receiveChannel, coroutineContext, (Function2)new Function2<E, Continuation<? super Boolean>, Object>(function2, null){
            final Function2<E, Continuation<? super Boolean>, Object> $predicate;
            Object L$0;
            int label;
            {
                this.$predicate = function2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(E e, Continuation<? super Boolean> continuation) {
                return (this.create(e, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
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
                        object = this.L$0;
                        Function2<E, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                        this.label = 1;
                        object = function2.invoke(object, (Object)((Object)this));
                        if (object != object2) break;
                        return object2;
                    }
                }
                return Boxing.boxBoolean((boolean)((Boolean)object ^ true));
            }
        });
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.filterNot(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        receiveChannel = ChannelsKt.filter$default(receiveChannel, null, new Function2<E, Continuation<? super Boolean>, Object>(null){
            Object L$0;
            int label;

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(E e, Continuation<? super Boolean> continuation) {
                return (this.create(e, continuation)).invokeSuspend(Unit.INSTANCE);
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
                boolean bl = this.L$0 != null;
                return Boxing.boxBoolean((boolean)bl);
            }
        }, 1, null);
        Intrinsics.checkNotNull((Object)receiveChannel, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return receiveChannel;
    }

    /*
     * Exception decompiling
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel var0, Collection var1_2, Continuation var2_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [2 : 184->191)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel var0, SendChannel var1_1, Continuation var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[SWITCH], 12[CASE]], but top level block is 18[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object first(ReceiveChannel var0, Continuation var1_1) {
        if (!(var1_1 /* !! */  instanceof first.1)) ** GOTO lbl-1000
        var2_5 /* !! */  = var1_1 /* !! */ ;
        if ((var2_5 /* !! */ .label & -2147483648) != 0) {
            var2_5 /* !! */ .label += -2147483648;
            var1_1 /* !! */  = var2_5 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 /* !! */  = new ContinuationImpl((Continuation<? super first.1>)var1_1 /* !! */ ){
                Object L$0;
                Object L$1;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.first(null, (Continuation)this);
                }
            };
        }
        var2_5 /* !! */  = var1_1 /* !! */ .result;
        var4_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var1_1 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var3_8 = (ChannelIterator<E>)var1_1 /* !! */ .L$1;
                var1_1 /* !! */  = (ReceiveChannel)var1_1 /* !! */ .L$0;
                var0 = var1_1 /* !! */ ;
                try {
                    ResultKt.throwOnFailure((Object)var2_5 /* !! */ );
                    ** break;
                }
                catch (Throwable var1_2) {
                    break;
                }
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var2_5 /* !! */ );
                try {
                    var3_8 = var0.iterator();
                    var1_1 /* !! */ .L$0 = var0;
                    var1_1 /* !! */ .L$1 = var3_8;
                    var1_1 /* !! */ .label = 1;
                    var2_5 /* !! */  = var3_8.hasNext((Continuation<Boolean>)var1_1 /* !! */ );
                    if (var2_5 /* !! */  == var4_7) {
                        return var4_7;
                    }
                    var1_1 /* !! */  = var0;
                }
                catch (Throwable var1_3) {
                    // empty catch block
                    break;
                }
lbl37:
                // 2 sources

                var0 = var1_1 /* !! */ ;
                {
                    if (!((Boolean)var2_5 /* !! */ ).booleanValue()) ** GOTO lbl43
                    var0 = var1_1 /* !! */ ;
                    var2_5 /* !! */  = var3_8.next();
                }
                ChannelsKt.cancelConsumed(var1_1 /* !! */ , null);
                return var2_5 /* !! */ ;
lbl43:
                // 1 sources

                var0 = var1_1 /* !! */ ;
                {
                    var0 = var1_1 /* !! */ ;
                    var2_5 /* !! */  = new NoSuchElementException("ReceiveChannel is empty.");
                    var0 = var1_1 /* !! */ ;
                    throw var2_5 /* !! */ ;
                }
            }
        }
        try {
            throw var1_4;
        }
        catch (Throwable var2_6) {
            ChannelsKt.cancelConsumed(var0, (Throwable)var1_4);
            throw var2_6;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel var0, Continuation var1_1) {
        block16: {
            block17: {
                if (!(var1_1 /* !! */  instanceof firstOrNull.1)) ** GOTO lbl-1000
                var4_4 = var1_1 /* !! */ ;
                if ((var4_4.label & -2147483648) != 0) {
                    var4_4.label += -2147483648;
                    var1_1 /* !! */  = var4_4;
                } else lbl-1000:
                // 2 sources

                {
                    var1_1 /* !! */  = new ContinuationImpl((Continuation<? super firstOrNull.1>)var1_1 /* !! */ ){
                        Object L$0;
                        Object L$1;
                        int label;
                        Object result;

                        public final Object invokeSuspend(Object object) {
                            this.result = object;
                            this.label |= Integer.MIN_VALUE;
                            return ChannelsKt.firstOrNull(null, (Continuation)this);
                        }
                    };
                }
                var4_4 = var1_1 /* !! */ .result;
                var6_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                var2_8 = var1_1 /* !! */ .label;
                var5_9 = null;
                switch (var2_8) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        var6_7 = (ChannelIterator)var1_1 /* !! */ .L$1;
                        var0 = (ReceiveChannel)var1_1 /* !! */ .L$0;
                        try {
                            ResultKt.throwOnFailure((Object)var4_4);
                            var1_1 /* !! */  = var4_4;
                            var4_4 = var6_7;
                            break;
                        }
                        catch (Throwable var1_2) {
                            var4_4 = var0;
                            var0 = var1_2;
                            var1_1 /* !! */  = var4_4;
                            break block16;
                        }
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)var4_4);
                        var4_4 = var0.iterator();
                        var1_1 /* !! */ .L$0 = var0;
                        var1_1 /* !! */ .L$1 = var4_4;
                        var1_1 /* !! */ .label = 1;
                        var1_1 /* !! */  = var4_4.hasNext((Continuation<? super Boolean>)var1_1 /* !! */ );
                        if (var1_1 /* !! */  != var6_7) break;
                        return var6_7;
                    }
                }
                var3_10 = (Boolean)var1_1 /* !! */ ;
                if (var3_10) break block17;
                var1_1 /* !! */  = var5_9;
lbl42:
                // 2 sources

                while (true) {
                    ChannelsKt.cancelConsumed(var0, null);
                    return var1_1 /* !! */ ;
                }
            }
            try {
                var1_1 /* !! */  = var4_4.next();
                ** continue;
            }
            catch (Throwable var1_3) {
                var4_4 = var0;
                var0 = var1_3;
                var1_1 /* !! */  = var4_4;
            }
            break block16;
            catch (Throwable var4_5) {
                var1_1 /* !! */  = var0;
                var0 = var4_5;
            }
        }
        try {
            throw var0;
        }
        catch (Throwable var4_6) {
            ChannelsKt.cancelConsumed(var1_1 /* !! */ , (Throwable)var0);
            throw var4_6;
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object>(receiveChannel, function2, null){
            final ReceiveChannel<E> $this_flatMap;
            final Function2<E, Continuation<? super ReceiveChannel<? extends R>>, Object> $transform;
            private Object L$0;
            Object L$1;
            int label;
            {
                this.$this_flatMap = receiveChannel;
                this.$transform = function2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[SWITCH], 5[CASE]], but top level block is 6[UNCONDITIONALDOLOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.flatMap(receiveChannel, coroutineContext, function2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object indexOf(ReceiveChannel var0, Object var1_2, Continuation var2_4) {
        if (!(var2_4 /* !! */  instanceof indexOf.1)) ** GOTO lbl-1000
        var7_10 /* !! */  = var2_4 /* !! */ ;
        if ((var7_10 /* !! */ .label & -2147483648) != 0) {
            var7_10 /* !! */ .label += -2147483648;
            var2_4 /* !! */  = var7_10 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var2_4 /* !! */  = new ContinuationImpl((Continuation<? super indexOf.1>)var2_4 /* !! */ ){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.indexOf(null, null, (Continuation)this);
                }
            };
        }
        var7_10 /* !! */  = var2_4 /* !! */ .result;
        var14_11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        block7 : switch (var2_4 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var8_12 = (ChannelIterator)var2_4 /* !! */ .L$3;
                var0 = (ReceiveChannel)var2_4 /* !! */ .L$2;
                var10_13 /* !! */  = (Ref.IntRef)var2_4 /* !! */ .L$1;
                var1_2 = var2_4 /* !! */ .L$0;
                try {
                    ResultKt.throwOnFailure((Object)var7_10 /* !! */ );
                    var13_14 /* !! */  = null;
                    var3_15 = false;
                    var4_16 = false;
                    var5_17 = false;
                    var9_18 /* !! */  = var7_10 /* !! */ ;
                    var11_19 /* !! */  = var2_4 /* !! */ ;
                    var12_20 /* !! */  = var7_10 /* !! */ ;
                    var7_10 /* !! */  = var10_13 /* !! */ ;
                    var2_4 /* !! */  = var1_2;
                    var1_2 = var13_14 /* !! */ ;
                    ** break;
                }
                catch (Throwable var2_5) {
                    var1_2 = var0;
                    var0 = var2_5;
                    break;
                }
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var7_10 /* !! */ );
                var8_12 = new Ref.IntRef();
                var10_13 /* !! */  = var0.iterator();
                var9_18 /* !! */  = var1_2;
                var4_16 = false;
                var3_15 = false;
                var1_2 = var10_13 /* !! */ ;
                var5_17 = false;
                var10_13 /* !! */  = null;
                var11_19 /* !! */  = var2_4 /* !! */ ;
                while (true) {
                    try {
                        var11_19 /* !! */ .L$0 = var9_18 /* !! */ ;
                        var11_19 /* !! */ .L$1 = var8_12;
                        var11_19 /* !! */ .L$2 = var0;
                        var11_19 /* !! */ .L$3 = var1_2;
                        var11_19 /* !! */ .label = 1;
                        var12_20 /* !! */  = var1_2.hasNext((Continuation<? super Boolean>)var11_19 /* !! */ );
                        if (var12_20 /* !! */  == var14_11) {
                            return var14_11;
                        }
                        var13_14 /* !! */  = var7_10 /* !! */ ;
                        var2_4 /* !! */  = var9_18 /* !! */ ;
                        var7_10 /* !! */  = var8_12;
                        var8_12 = var1_2;
                        var6_21 = var5_17;
                        var5_17 = var3_15;
                        var1_2 = var10_13 /* !! */ ;
                        var3_15 = var6_21;
                        var9_18 /* !! */  = var13_14 /* !! */ ;
                    }
                    catch (Throwable var2_7) {
                        var1_2 = var0;
                        var0 = var2_7;
                        break block7;
                    }
lbl71:
                    // 2 sources

                    try {
                        if (!((Boolean)var12_20 /* !! */ ).booleanValue()) break;
                        if (Intrinsics.areEqual((Object)var2_4 /* !! */ , var8_12.next())) {
                            var2_4 /* !! */  = Boxing.boxInt((int)var7_10 /* !! */ .element);
                        }
                        ** GOTO lbl84
                    }
                    catch (Throwable var1_3) {
                        var2_4 /* !! */  = var0;
                        var0 = var1_3;
                        var1_2 = var2_4 /* !! */ ;
                        break block7;
                    }
                    ChannelsKt.cancelConsumed(var0, (Throwable)var1_2);
                    return var2_4 /* !! */ ;
lbl84:
                    // 1 sources

                    try {
                        ++var7_10 /* !! */ .element;
                        var12_20 /* !! */  = var9_18 /* !! */ ;
                        var6_21 = var5_17;
                        var5_17 = var3_15;
                        var10_13 /* !! */  = var1_2;
                        var9_18 /* !! */  = var7_10 /* !! */ ;
                        var7_10 /* !! */  = var12_20 /* !! */ ;
                        var3_15 = var6_21;
                        var1_2 = var8_12;
                        var8_12 = var9_18 /* !! */ ;
                        var9_18 /* !! */  = var2_4 /* !! */ ;
                    }
                    catch (Throwable var2_6) {
                        var1_2 = var0;
                        var0 = var2_6;
                        break block7;
                    }
                }
                var2_4 /* !! */  = var0;
                try {
                    var0 = Unit.INSTANCE;
                }
                catch (Throwable var0_1) {
                    var1_2 = var2_4 /* !! */ ;
                    break;
                }
                ChannelsKt.cancelConsumed(var2_4 /* !! */ , (Throwable)var1_2);
                return Boxing.boxInt((int)-1);
                catch (Throwable var2_8) {
                    var1_2 = var0;
                    var0 = var2_8;
                }
            }
        }
        try {
            throw var0;
        }
        catch (Throwable var2_9) {
            ChannelsKt.cancelConsumed(var1_2, (Throwable)var0);
            throw var2_9;
        }
    }

    /*
     * Unable to fully structure code
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object last(ReceiveChannel var0, Continuation var1_3) {
        block25: {
            block26: {
                if (!(var1_3 instanceof last.1)) ** GOTO lbl-1000
                var7_4 = (ContinuationImpl)var1_3;
                if ((var7_4.label & -2147483648) != 0) {
                    var7_4.label += -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    var7_4 = new ContinuationImpl((Continuation<? super last.1>)var1_3){
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        int label;
                        Object result;

                        public final Object invokeSuspend(Object object) {
                            this.result = object;
                            this.label |= Integer.MIN_VALUE;
                            return ChannelsKt.last(null, (Continuation)this);
                        }
                    };
                }
                var1_3 = var7_4.result;
                var8_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (var7_4.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 2: {
                        var6_6 = var7_4.L$2;
                        var5_7 = (ChannelIterator)var7_4.L$1;
                        var0 = (ReceiveChannel)var7_4.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)var1_3);
                            var9_8 = null;
                            var2_9 = false;
                            var3_10 = var8_5;
                            var4_16 = var1_3;
                            var8_5 = var1_3;
                            var1_3 = var5_7;
                            var5_7 = var9_8;
                            ** GOTO lbl76
                        }
                        catch (Throwable var3_11) {
                            var1_3 = var0;
                            var0 = var3_11;
                            break block25;
                        }
                    }
                    case 1: {
                        var4_16 = var7_4.L$1;
                        var3_10 = (ReceiveChannel)var7_4.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)var1_3);
                            var5_7 = var0 = var1_3;
                            break;
                        }
                        catch (Throwable var0_1) {
                            var1_3 = var3_10;
                            break block25;
                        }
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_3);
                        var4_16 = var0.iterator();
                        var7_4.L$0 = var0;
                        var7_4.L$1 = var4_16;
                        var7_4.label = 1;
                        var5_7 = var4_16.hasNext((Continuation<? super Boolean>)var7_4);
                        if (var5_7 == var8_5) {
                            return var8_5;
                        }
                        var3_10 = var0;
                    }
                }
                if (!((Boolean)var5_7).booleanValue()) break block26;
                var5_7 = var4_16.next();
                var0 = var3_10;
                var2_9 = false;
                var3_10 = var5_7;
                var6_6 = null;
                var5_7 = var4_16;
                var4_16 = var3_10;
                var3_10 = var8_5;
                while (true) {
                    var7_4.L$0 = var0;
                    var7_4.L$1 = var5_7;
                    var7_4.L$2 = var4_16;
                    var7_4.label = 2;
                    var8_5 = var5_7.hasNext((Continuation<? super Boolean>)var7_4);
                    if (var8_5 == var3_10) {
                        return var3_10;
                    }
                    var9_8 = var1_3;
                    var1_3 = var5_7;
                    var5_7 = var6_6;
                    var6_6 = var4_16;
                    var4_16 = var9_8;
lbl76:
                    // 3 sources

                    if (!((Boolean)var8_5).booleanValue()) break;
                    var8_5 = var1_3.next();
                    var6_6 = var5_7;
                    var5_7 = var8_5;
                    var8_5 = var1_3;
                    var1_3 = var4_16;
                    var4_16 = var5_7;
                    var5_7 = var8_5;
                    continue;
                    break;
                }
                ChannelsKt.cancelConsumed(var0, (Throwable)var5_7);
                return var6_6;
                catch (Throwable var3_12) {
                    var1_3 = var0;
                    var0 = var3_12;
                    break block25;
                }
                catch (Throwable var3_13) {
                    var1_3 = var0;
                    var0 = var3_13;
                    break block25;
                }
            }
            try {
                var0 = new NoSuchElementException("ReceiveChannel is empty.");
                throw var0;
            }
            catch (Throwable var0_2) {
                var1_3 = var3_10;
            }
            break block25;
            catch (Throwable var3_14) {
                var1_3 = var0;
                var0 = var3_14;
            }
        }
        try {
            throw var0;
        }
        catch (Throwable var3_15) {
            ChannelsKt.cancelConsumed(var1_3, (Throwable)var0);
            throw var3_15;
        }
    }

    /*
     * Exception decompiling
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel var0, Object var1_2, Continuation var2_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [2 : 246->253)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel var0, Continuation var1_1) {
        block25: {
            block26: {
                if (!(var1_1 instanceof lastOrNull.1)) ** GOTO lbl-1000
                var8_10 = (ContinuationImpl)var1_1;
                if ((var8_10.label & -2147483648) != 0) {
                    var8_10.label += -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    var8_10 = new ContinuationImpl((Continuation<? super lastOrNull.1>)var1_1){
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        int label;
                        Object result;

                        public final Object invokeSuspend(Object object) {
                            this.result = object;
                            this.label |= Integer.MIN_VALUE;
                            return ChannelsKt.lastOrNull(null, (Continuation)this);
                        }
                    };
                }
                var1_1 = var8_10.result;
                var4_11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (var8_10.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 2: {
                        var11_13 = var8_10.L$2;
                        var7_14 = (ChannelIterator)var8_10.L$1;
                        var0 = (ReceiveChannel)var8_10.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)var1_1);
                            var9_15 = null;
                            var2_16 = false;
                            var6_17 /* !! */  = var1_1;
                            var10_18 /* !! */  = var1_1;
                            var5_19 /* !! */  = var4_11;
                            var4_11 = var9_15;
                            var1_1 = var7_14;
                            ** GOTO lbl74
                        }
                        catch (Throwable var1_2) {
                            break block25;
                        }
                    }
                    case 1: {
                        var7_14 = (ChannelIterator)var8_10.L$1;
                        var0 = (ReceiveChannel)var8_10.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)var1_1);
                            var5_19 /* !! */  = var1_1;
                            break;
                        }
                        catch (Throwable var1_3) {
                            break block25;
                        }
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        var7_14 = var0.iterator();
                        var8_10.L$0 = var0;
                        var8_10.L$1 = var7_14;
                        var8_10.label = 1;
                        var5_19 /* !! */  = var7_14.hasNext((Continuation<? super Boolean>)var8_10);
                        if (var5_19 /* !! */  != var4_11) break;
                        return var4_11;
                    }
                }
                var2_16 = false;
                var3_20 = (Boolean)var5_19 /* !! */ ;
                if (var3_20) break block26;
                ChannelsKt.cancelConsumed(var0, null);
                return null;
            }
            try {
                var6_17 /* !! */  = var7_14.next();
                var5_19 /* !! */  = null;
            }
            catch (Throwable var1_7) {}
            while (true) {
                var8_10.L$0 = var0;
                var8_10.L$1 = var7_14;
                var8_10.L$2 = var6_17 /* !! */ ;
                var8_10.label = 2;
                var10_18 /* !! */  = var7_14.hasNext((Continuation<? super Boolean>)var8_10);
                if (var10_18 /* !! */  == var4_11) {
                    return var4_11;
                }
                var9_15 = var1_1;
                var1_1 = var7_14;
                var7_14 = var5_19 /* !! */ ;
                var5_19 /* !! */  = var4_11;
                var11_13 = var6_17 /* !! */ ;
                var4_11 = var7_14;
                var6_17 /* !! */  = var9_15;
lbl74:
                // 3 sources

                if (!((Boolean)var10_18 /* !! */ ).booleanValue()) break;
                var7_14 = var1_1.next();
                var10_18 /* !! */  = var6_17 /* !! */ ;
                var6_17 /* !! */  = var4_11;
                var9_15 = var1_1;
                var1_1 = var10_18 /* !! */ ;
                var4_11 = var5_19 /* !! */ ;
                var5_19 /* !! */  = var6_17 /* !! */ ;
                var6_17 /* !! */  = var7_14;
                var7_14 = var9_15;
                continue;
                break;
            }
            ChannelsKt.cancelConsumed(var0, (Throwable)var4_11);
            return var11_13;
            catch (Throwable var1_5) {
                break block25;
            }
            catch (Throwable var1_6) {
                break block25;
            }
            break block25;
            catch (Throwable var1_8) {}
            break block25;
            catch (Throwable var1_9) {
                // empty catch block
            }
        }
        try {
            throw var1_4;
        }
        catch (Throwable var4_12) {
            ChannelsKt.cancelConsumed(var0, (Throwable)var1_4);
            throw var4_12;
        }
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object>(receiveChannel, function2, null){
            final ReceiveChannel<E> $this_map;
            final Function2<E, Continuation<? super R>, Object> $transform;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            {
                this.$this_map = receiveChannel;
                this.$transform = function2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [28[SWITCH], 33[CASE]], but top level block is 39[UNCONDITIONALDOLOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.map(receiveChannel, coroutineContext, function2);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object>(receiveChannel, function3, null){
            final ReceiveChannel<E> $this_mapIndexed;
            final Function3<Integer, E, Continuation<? super R>, Object> $transform;
            int I$0;
            private Object L$0;
            Object L$1;
            Object L$2;
            int label;
            {
                this.$this_mapIndexed = receiveChannel;
                this.$transform = function3;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[SWITCH], 5[CASE]], but top level block is 6[UNCONDITIONALDOLOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3));
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt.filterNotNull(ChannelsKt.map(receiveChannel, coroutineContext, function2));
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapNotNull(receiveChannel, coroutineContext, function2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object maxWith(ReceiveChannel var0, Comparator var1_1, Continuation var2_10) {
        block27: {
            block28: {
                if (!(var2_10 /* !! */  instanceof maxWith.1)) ** GOTO lbl-1000
                var9_12 = (ContinuationImpl)var2_10 /* !! */ ;
                if ((var9_12.label & -2147483648) != 0) {
                    var9_12.label += -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    var9_12 = new ContinuationImpl((Continuation<? super maxWith.1>)var2_10 /* !! */ ){
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;

                        public final Object invokeSuspend(Object object) {
                            this.result = object;
                            this.label |= Integer.MIN_VALUE;
                            return ChannelsKt.maxWith(null, null, (Continuation)this);
                        }
                    };
                }
                var2_10 /* !! */  = var9_12.result;
                var10_13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (var9_12.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 2: {
                        var8_14 = var9_12.L$3;
                        var1_1 = (ChannelIterator)var9_12.L$2;
                        var0 = (ReceiveChannel)var9_12.L$1;
                        var7_15 = (Comparator)var9_12.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)var2_10 /* !! */ );
                            var11_16 /* !! */  = null;
                            var5_17 = var10_13;
                            var6_18 /* !! */  = var2_10 /* !! */ ;
                            var10_13 = var2_10 /* !! */ ;
                            var2_10 /* !! */  = var11_16 /* !! */ ;
                            ** GOTO lbl81
                        }
                        catch (Throwable var1_2) {
                            break block27;
                        }
                    }
                    case 1: {
                        var7_15 = (ChannelIterator<E>)var9_12.L$2;
                        var0 = (ReceiveChannel)var9_12.L$1;
                        var8_14 = (Comparator)var9_12.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)var2_10 /* !! */ );
                            var1_1 = var2_10 /* !! */ ;
                            break;
                        }
                        catch (Throwable var1_3) {
                            break block27;
                        }
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)var2_10 /* !! */ );
                        var7_15 = var0.iterator();
                        var9_12.L$0 = var1_1;
                        var9_12.L$1 = var0;
                        var9_12.L$2 = var7_15;
                        var9_12.label = 1;
                        var5_17 = var7_15.hasNext((Continuation<? super Boolean>)var9_12);
                        if (var5_17 == var10_13) {
                            return var10_13;
                        }
                        var8_14 = var1_1;
                        var1_1 = var5_17;
                    }
                }
                var4_19 = (Boolean)var1_1;
                if (var4_19) break block28;
                ChannelsKt.cancelConsumed(var0, null);
                return null;
            }
            try {
                var5_17 = var7_15.next();
                var6_18 /* !! */  = null;
                var1_1 = var10_13;
            }
            catch (Throwable var1_6) {}
            while (true) {
                var9_12.L$0 = var8_14;
                var9_12.L$1 = var0;
                var9_12.L$2 = var7_15;
                var9_12.L$3 = var5_17;
                var9_12.label = 2;
                var10_13 = var7_15.hasNext((Continuation<? super Boolean>)var9_12);
                if (var10_13 == var1_1) {
                    return var1_1;
                }
                var11_16 /* !! */  = var2_10 /* !! */ ;
                var12_21 = var8_14;
                var8_14 = var7_15;
                var2_10 /* !! */  = var6_18 /* !! */ ;
                var6_18 /* !! */  = var1_1;
                var7_15 = var12_21;
                var1_1 = var8_14;
                var8_14 = var5_17;
                var5_17 = var6_18 /* !! */ ;
                var6_18 /* !! */  = var11_16 /* !! */ ;
lbl81:
                // 3 sources

                if (!((Boolean)var10_13).booleanValue()) break;
                var10_13 = var1_1.next();
                var3_20 = var7_15.compare(var8_14, var10_13);
                if (var3_20 < 0) {
                    var8_14 = var7_15;
                    var7_15 = var10_13;
                    var11_16 /* !! */  = var2_10 /* !! */ ;
                    var10_13 = var1_1;
                    var2_10 /* !! */  = var6_18 /* !! */ ;
                    var1_1 = var5_17;
                    var5_17 = var7_15;
                    var6_18 /* !! */  = var11_16 /* !! */ ;
                    var7_15 = var10_13;
                    continue;
                }
                var10_13 = var7_15;
                var11_16 /* !! */  = var6_18 /* !! */ ;
                var7_15 = var5_17;
                var5_17 = var8_14;
                var6_18 /* !! */  = var2_10 /* !! */ ;
                var8_14 = var1_1;
                var2_10 /* !! */  = var11_16 /* !! */ ;
                var1_1 = var7_15;
                var7_15 = var8_14;
                var8_14 = var10_13;
                continue;
                break;
            }
            ChannelsKt.cancelConsumed(var0, (Throwable)var2_10 /* !! */ );
            return var8_14;
            catch (Throwable var1_4) {
                break block27;
            }
            catch (Throwable var1_5) {
                break block27;
            }
            break block27;
            catch (Throwable var1_7) {}
            break block27;
            catch (Throwable var1_8) {
                // empty catch block
            }
        }
        try {
            throw var1_9;
        }
        catch (Throwable var2_11) {
            ChannelsKt.cancelConsumed(var0, (Throwable)var1_9);
            throw var2_11;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object minWith(ReceiveChannel var0, Comparator var1_1, Continuation var2_10) {
        block27: {
            block28: {
                if (!(var2_10 /* !! */  instanceof minWith.1)) ** GOTO lbl-1000
                var9_12 = (ContinuationImpl)var2_10 /* !! */ ;
                if ((var9_12.label & -2147483648) != 0) {
                    var9_12.label += -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    var9_12 = new ContinuationImpl((Continuation<? super minWith.1>)var2_10 /* !! */ ){
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;

                        public final Object invokeSuspend(Object object) {
                            this.result = object;
                            this.label |= Integer.MIN_VALUE;
                            return ChannelsKt.minWith(null, null, (Continuation)this);
                        }
                    };
                }
                var2_10 /* !! */  = var9_12.result;
                var10_13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (var9_12.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 2: {
                        var8_14 = var9_12.L$3;
                        var1_1 = (ChannelIterator)var9_12.L$2;
                        var0 = (ReceiveChannel)var9_12.L$1;
                        var7_15 = (Comparator)var9_12.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)var2_10 /* !! */ );
                            var12_16 = null;
                            var5_17 = var10_13;
                            var6_18 /* !! */  = var2_10 /* !! */ ;
                            var11_19 /* !! */  = var2_10 /* !! */ ;
                            var2_10 /* !! */  = var12_16;
                            ** GOTO lbl80
                        }
                        catch (Throwable var1_2) {
                            break block27;
                        }
                    }
                    case 1: {
                        var7_15 = (ChannelIterator<E>)var9_12.L$2;
                        var0 = (ReceiveChannel)var9_12.L$1;
                        var8_14 = (Comparator)var9_12.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)var2_10 /* !! */ );
                            var1_1 = var2_10 /* !! */ ;
                            break;
                        }
                        catch (Throwable var1_3) {
                            break block27;
                        }
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)var2_10 /* !! */ );
                        var7_15 = var0.iterator();
                        var9_12.L$0 = var1_1;
                        var9_12.L$1 = var0;
                        var9_12.L$2 = var7_15;
                        var9_12.label = 1;
                        var5_17 = var7_15.hasNext((Continuation<? super Boolean>)var9_12);
                        if (var5_17 == var10_13) {
                            return var10_13;
                        }
                        var8_14 = var1_1;
                        var1_1 = var5_17;
                    }
                }
                var4_20 = (Boolean)var1_1;
                if (var4_20) break block28;
                ChannelsKt.cancelConsumed(var0, null);
                return null;
            }
            try {
                var5_17 = var7_15.next();
                var6_18 /* !! */  = null;
                var1_1 = var10_13;
            }
            catch (Throwable var1_6) {}
            while (true) {
                var9_12.L$0 = var8_14;
                var9_12.L$1 = var0;
                var9_12.L$2 = var7_15;
                var9_12.L$3 = var5_17;
                var9_12.label = 2;
                var11_19 /* !! */  = var7_15.hasNext((Continuation<? super Boolean>)var9_12);
                if (var11_19 /* !! */  == var1_1) {
                    return var1_1;
                }
                var10_13 = var2_10 /* !! */ ;
                var12_16 = var8_14;
                var2_10 /* !! */  = var7_15;
                var8_14 = var5_17;
                var5_17 = var1_1;
                var7_15 = var12_16;
                var1_1 = var2_10 /* !! */ ;
                var2_10 /* !! */  = var6_18 /* !! */ ;
                var6_18 /* !! */  = var10_13;
lbl80:
                // 3 sources

                if (!((Boolean)var11_19 /* !! */ ).booleanValue()) break;
                var10_13 = var1_1.next();
                var3_21 = var7_15.compare(var8_14, var10_13);
                if (var3_21 > 0) {
                    var8_14 = var7_15;
                    var7_15 = var10_13;
                    var11_19 /* !! */  = var6_18 /* !! */ ;
                    var6_18 /* !! */  = var2_10 /* !! */ ;
                    var10_13 = var1_1;
                    var2_10 /* !! */  = var11_19 /* !! */ ;
                    var1_1 = var5_17;
                    var5_17 = var7_15;
                    var7_15 = var10_13;
                    continue;
                }
                var10_13 = var7_15;
                var11_19 /* !! */  = var5_17;
                var5_17 = var8_14;
                var7_15 = var2_10 /* !! */ ;
                var8_14 = var1_1;
                var2_10 /* !! */  = var6_18 /* !! */ ;
                var1_1 = var11_19 /* !! */ ;
                var6_18 /* !! */  = var7_15;
                var7_15 = var8_14;
                var8_14 = var10_13;
                continue;
                break;
            }
            ChannelsKt.cancelConsumed(var0, (Throwable)var2_10 /* !! */ );
            return var8_14;
            catch (Throwable var1_4) {
                break block27;
            }
            catch (Throwable var1_5) {
                break block27;
            }
            break block27;
            catch (Throwable var1_7) {}
            break block27;
            catch (Throwable var1_8) {
                // empty catch block
            }
        }
        try {
            throw var1_9;
        }
        catch (Throwable var2_11) {
            ChannelsKt.cancelConsumed(var0, (Throwable)var1_9);
            throw var2_11;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object none(ReceiveChannel var0, Continuation var1_1) {
        if (!(var1_1 /* !! */  instanceof none.1)) ** GOTO lbl-1000
        var4_5 = var1_1 /* !! */ ;
        if ((var4_5.label & -2147483648) != 0) {
            var4_5.label += -2147483648;
            var1_1 /* !! */  = var4_5;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 /* !! */  = new ContinuationImpl((Continuation<? super none.1>)var1_1 /* !! */ ){
                Object L$0;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.none(null, (Continuation)this);
                }
            };
        }
        var4_5 = var1_1 /* !! */ .result;
        var5_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        var2_8 = var1_1 /* !! */ .label;
        var3_9 = true;
        switch (var2_8) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var1_1 /* !! */  = (ReceiveChannel)var1_1 /* !! */ .L$0;
                var0 = var1_1 /* !! */ ;
                try {
                    ResultKt.throwOnFailure((Object)var4_5);
                    ** break;
                }
                catch (Throwable var1_2) {
                    break;
                }
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var4_5);
                try {
                    var4_5 = var0.iterator();
                    var1_1 /* !! */ .L$0 = var0;
                    var1_1 /* !! */ .label = 1;
                    var4_5 = var4_5.hasNext((Continuation<? super Boolean>)var1_1 /* !! */ );
                    if (var4_5 == var5_7) {
                        return var5_7;
                    }
                    var1_1 /* !! */  = var0;
                }
                catch (Throwable var1_3) {
                    // empty catch block
                    break;
                }
lbl37:
                // 2 sources

                var0 = var1_1 /* !! */ ;
                {
                    if (((Boolean)var4_5).booleanValue()) {
                        var3_9 = false;
                    }
                    var0 = var1_1 /* !! */ ;
                    var4_5 = Boxing.boxBoolean((boolean)var3_9);
                }
                ChannelsKt.cancelConsumed(var1_1 /* !! */ , null);
                return var4_5;
            }
        }
        try {
            throw var1_4;
        }
        catch (Throwable var4_6) {
            ChannelsKt.cancelConsumed(var0, (Throwable)var1_4);
            throw var4_6;
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Left for binary compatibility")
    public static final /* synthetic */ ReceiveChannel requireNoNulls(ReceiveChannel receiveChannel) {
        return ChannelsKt.map$default(receiveChannel, null, new Function2<E, Continuation<? super E>, Object>(receiveChannel, null){
            final ReceiveChannel<E> $this_requireNoNulls;
            Object L$0;
            int label;
            {
                this.$this_requireNoNulls = receiveChannel;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(E e, Continuation<? super E> continuation) {
                return (this.create(e, continuation)).invokeSuspend(Unit.INSTANCE);
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
                object = this.L$0;
                if (object != null) {
                    return object;
                }
                throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
            }
        }, 1, null);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object single(ReceiveChannel var0, Continuation var1_2) {
        block23: {
            block24: {
                block22: {
                    if (!(var1_2 /* !! */  instanceof single.1)) ** GOTO lbl-1000
                    var3_3 /* !! */  = (ContinuationImpl)var1_2 /* !! */ ;
                    if ((var3_3 /* !! */ .label & -2147483648) != 0) {
                        var3_3 /* !! */ .label += -2147483648;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var3_3 /* !! */  = new ContinuationImpl((Continuation<? super single.1>)var1_2 /* !! */ ){
                            Object L$0;
                            Object L$1;
                            int label;
                            Object result;

                            public final Object invokeSuspend(Object object) {
                                this.result = object;
                                this.label |= Integer.MIN_VALUE;
                                return ChannelsKt.single(null, (Continuation)this);
                            }
                        };
                    }
                    var4_7 = var3_3 /* !! */ .result;
                    var7_8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (var3_3 /* !! */ .label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 2: {
                            var5_9 = var3_3 /* !! */ .L$1;
                            var1_2 /* !! */  = (ReceiveChannel)var3_3 /* !! */ .L$0;
                            var0 = var1_2 /* !! */ ;
                            try {
                                ResultKt.throwOnFailure(var4_7);
                                var3_3 /* !! */  = var4_7;
                                var4_7 = var5_9;
                                break block22;
                            }
                            catch (Throwable var3_4) {
                                var1_2 /* !! */  = var0;
                                var0 = var3_4;
                                ** GOTO lbl34
                            }
                        }
                        case 1: {
                            var6_11 = (ChannelIterator)var3_3 /* !! */ .L$1;
                            var0 = (ReceiveChannel)var3_3 /* !! */ .L$0;
                            var1_2 /* !! */  = var0;
                            try {
                                ResultKt.throwOnFailure(var4_7);
                                var5_10 = var4_7;
                                var4_7 = var6_11;
                                ** break;
                            }
                            catch (Throwable var0_1) {
                            }
lbl34:
                            // 3 sources

                            while (true) {
                                try {
                                    throw var0;
                                }
                                catch (Throwable var3_6) {
                                    ChannelsKt.cancelConsumed(var1_2 /* !! */ , (Throwable)var0);
                                    throw var3_6;
                                }
                                break;
                            }
                        }
                        case 0: 
                    }
                    ResultKt.throwOnFailure((Object)var4_7);
                    try {
                        var4_7 = var0.iterator();
                        var3_3 /* !! */ .L$0 = var0;
                        var3_3 /* !! */ .L$1 = var4_7;
                        var3_3 /* !! */ .label = 1;
                        var5_10 = var4_7.hasNext((Continuation<? super Boolean>)var3_3 /* !! */ );
                        if (var5_10 == var7_8) {
                            return var7_8;
                        }
                    }
                    catch (Throwable var3_5) {
                        var1_2 /* !! */  = var0;
                        var0 = var3_5;
                        ** continue;
                    }
lbl57:
                    // 2 sources

                    var1_2 /* !! */  = var0;
                    {
                        if (!((Boolean)var5_10).booleanValue()) break block23;
                        var1_2 /* !! */  = var0;
                        var5_10 = var4_7.next();
                        var1_2 /* !! */  = var0;
                        var3_3 /* !! */ .L$0 = var0;
                        var1_2 /* !! */  = var0;
                        var3_3 /* !! */ .L$1 = var5_10;
                        var1_2 /* !! */  = var0;
                        var3_3 /* !! */ .label = 2;
                        var1_2 /* !! */  = var0;
                        if ((var3_3 /* !! */  = var4_7.hasNext((Continuation<? super Boolean>)var3_3 /* !! */ )) == var7_8) {
                            return var7_8;
                        }
                        var4_7 = var5_10;
                        var1_2 /* !! */  = var0;
                    }
                }
                var0 = var1_2 /* !! */ ;
                {
                    var2_12 = (Boolean)var3_3 /* !! */ ;
                    if (var2_12) break block24;
                }
                ChannelsKt.cancelConsumed(var1_2 /* !! */ , null);
                return var4_7;
            }
            var0 = var1_2 /* !! */ ;
            {
                var0 = var1_2 /* !! */ ;
                var3_3 /* !! */  = new IllegalArgumentException("ReceiveChannel has more than one element.");
                var0 = var1_2 /* !! */ ;
                throw var3_3 /* !! */ ;
            }
        }
        var1_2 /* !! */  = var0;
        {
            var1_2 /* !! */  = var0;
            var3_3 /* !! */  = new NoSuchElementException("ReceiveChannel is empty.");
            var1_2 /* !! */  = var0;
            throw var3_3 /* !! */ ;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel var0, Continuation var1_1) {
        block23: {
            block25: {
                block22: {
                    block24: {
                        if (!(var1_1 /* !! */  instanceof singleOrNull.1)) ** GOTO lbl-1000
                        var3_9 /* !! */  = var1_1 /* !! */ ;
                        if ((var3_9 /* !! */ .label & -2147483648) != 0) {
                            var3_9 /* !! */ .label += -2147483648;
                            var1_1 /* !! */  = var3_9 /* !! */ ;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var1_1 /* !! */  = new ContinuationImpl((Continuation<? super singleOrNull.1>)var1_1 /* !! */ ){
                                Object L$0;
                                Object L$1;
                                int label;
                                Object result;

                                public final Object invokeSuspend(Object object) {
                                    this.result = object;
                                    this.label |= Integer.MIN_VALUE;
                                    return ChannelsKt.singleOrNull(null, (Continuation)this);
                                }
                            };
                        }
                        var3_9 /* !! */  = var1_1 /* !! */ .result;
                        var5_11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (var1_1 /* !! */ .label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 2: {
                                var4_12 = var1_1 /* !! */ .L$1;
                                var0 = (ReceiveChannel)var1_1 /* !! */ .L$0;
                                try {
                                    ResultKt.throwOnFailure((Object)var3_9 /* !! */ );
                                    var1_1 /* !! */  = var4_12;
                                    break block22;
                                }
                                catch (Throwable var1_2) {
                                    break block23;
                                }
                            }
                            case 1: {
                                var4_13 = (ChannelIterator<E>)var1_1 /* !! */ .L$1;
                                var0 = (ReceiveChannel)var1_1 /* !! */ .L$0;
                                try {
                                    ResultKt.throwOnFailure((Object)var3_9 /* !! */ );
                                    break;
                                }
                                catch (Throwable var1_3) {
                                    break block23;
                                }
                            }
                            case 0: {
                                ResultKt.throwOnFailure((Object)var3_9 /* !! */ );
                                var4_13 = var0.iterator();
                                var1_1 /* !! */ .L$0 = var0;
                                var1_1 /* !! */ .L$1 = var4_13;
                                var1_1 /* !! */ .label = 1;
                                var3_9 /* !! */  = var4_13.hasNext((Continuation<Boolean>)var1_1 /* !! */ );
                                if (var3_9 /* !! */  != var5_11) break;
                                return var5_11;
                            }
                        }
                        try {
                            var2_14 = (Boolean)var3_9 /* !! */ ;
                            if (var2_14) break block24;
                        }
                        catch (Throwable var1_6) {}
                        ChannelsKt.cancelConsumed(var0, null);
                        return null;
                    }
                    try {
                        var3_9 /* !! */  = var4_13.next();
                        var1_1 /* !! */ .L$0 = var0;
                        var1_1 /* !! */ .L$1 = var3_9 /* !! */ ;
                        var1_1 /* !! */ .label = 2;
                        var4_13 = var4_13.hasNext((Continuation<Boolean>)var1_1 /* !! */ );
                        if (var4_13 == var5_11) {
                            return var5_11;
                        }
                        var1_1 /* !! */  = var3_9 /* !! */ ;
                        var3_9 /* !! */  = var4_13;
                    }
                    catch (Throwable var1_5) {}
                }
                try {
                    var2_14 = (Boolean)var3_9 /* !! */ ;
                    if (!var2_14) break block25;
                }
                catch (Throwable var1_4) {}
                ChannelsKt.cancelConsumed(var0, null);
                return null;
            }
            ChannelsKt.cancelConsumed(var0, null);
            return var1_1 /* !! */ ;
            break block23;
            catch (Throwable var1_7) {
                // empty catch block
            }
        }
        try {
            throw var1_8;
        }
        catch (Throwable var3_10) {
            ChannelsKt.cancelConsumed(var0, (Throwable)var1_8);
            throw var3_10;
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel receiveChannel, int n, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>(n, receiveChannel, null){
            final int $n;
            final ReceiveChannel<E> $this_take;
            int I$0;
            private Object L$0;
            Object L$1;
            int label;
            {
                this.$n = n;
                this.$this_take = receiveChannel;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[SWITCH], 4[CASE]], but top level block is 5[UNCONDITIONALDOLOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int n, CoroutineContext coroutineContext, int n2, Object object) {
        if ((n2 & 2) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.take(receiveChannel, n, coroutineContext);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>(receiveChannel, function2, null){
            final Function2<E, Continuation<? super Boolean>, Object> $predicate;
            final ReceiveChannel<E> $this_takeWhile;
            private Object L$0;
            Object L$1;
            Object L$2;
            int label;
            {
                this.$this_takeWhile = receiveChannel;
                this.$predicate = function2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[SWITCH], 5[CASE]], but top level block is 6[UNCONDITIONALDOLOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.takeWhile(receiveChannel, coroutineContext, function2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> var0, C var1_1, Continuation<? super C> var2_7) {
        block22: {
            if (!(var2_7 /* !! */  instanceof toChannel.1)) ** GOTO lbl-1000
            var4_9 /* !! */  = var2_7 /* !! */ ;
            if ((var4_9 /* !! */ .label & -2147483648) != 0) {
                var4_9 /* !! */ .label += -2147483648;
                var2_7 /* !! */  = var4_9 /* !! */ ;
            } else lbl-1000:
            // 2 sources

            {
                var2_7 /* !! */  = new ContinuationImpl(var2_7 /* !! */ ){
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return ChannelsKt.toChannel(null, null, (Continuation)this);
                    }
                };
            }
            var4_9 /* !! */  = var2_7 /* !! */ .result;
            var5_10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var2_7 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 2: {
                    var7_11 = (ChannelIterator<E>)var2_7 /* !! */ .L$2;
                    var9_12 /* !! */  = null;
                    var6_13 = (Continuation<C>)var2_7 /* !! */ .L$1;
                    var8_14 = (SendChannel)var2_7 /* !! */ .L$0;
                    var0 = var6_13;
                    ResultKt.throwOnFailure((Object)var4_9 /* !! */ );
                    var3_15 = false;
                    var0 = var5_10;
                    var1_1 /* !! */  = var4_9 /* !! */ ;
                    var5_10 = var2_7 /* !! */ ;
                    var2_7 /* !! */  = var0;
                    var4_9 /* !! */  = var9_12 /* !! */ ;
                    var0 = var6_13;
                    var6_13 = var8_14;
                    break;
                }
                case 1: {
                    var3_15 = false;
                    var7_11 = (ChannelIterator)var2_7 /* !! */ .L$2;
                    var10_16 = null;
                    var6_13 = (ReceiveChannel)var2_7 /* !! */ .L$1;
                    var8_14 = (SendChannel)var2_7 /* !! */ .L$0;
                    var0 = var6_13;
                    try {
                        ResultKt.throwOnFailure((Object)var4_9 /* !! */ );
                        var1_1 /* !! */  = var4_9 /* !! */ ;
                        var9_12 /* !! */  = var4_9 /* !! */ ;
                        var4_9 /* !! */  = var10_16;
                        var0 = var6_13;
                        var6_13 = var8_14;
                        var8_14 = var2_7 /* !! */ ;
                        ** GOTO lbl73
                    }
                    catch (Throwable var1_2) {
                        break block22;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var4_9 /* !! */ );
                    var10_16 = null;
                    var7_11 = var0.iterator();
                    var3_15 = false;
                    var9_12 /* !! */  = var5_10;
                    var8_14 = var4_9 /* !! */ ;
                    var5_10 = var2_7 /* !! */ ;
                    var6_13 = var1_1 /* !! */ ;
                    var4_9 /* !! */  = var10_16;
                    var2_7 /* !! */  = var9_12 /* !! */ ;
                    var1_1 /* !! */  = var8_14;
                }
            }
            while (true) {
                var5_10.L$0 = var6_13;
                var5_10.L$1 = var0;
                var5_10.L$2 = var7_11;
                var5_10.label = 1;
                var9_12 /* !! */  = var7_11.hasNext(var5_10);
                if (var9_12 /* !! */  == var2_7 /* !! */ ) {
                    return var2_7 /* !! */ ;
                }
                var8_14 = var5_10;
                var5_10 = var2_7 /* !! */ ;
lbl73:
                // 3 sources

                if (!((Boolean)var9_12 /* !! */ ).booleanValue()) break;
                var2_7 /* !! */  = var7_11.next();
                var8_14.L$0 = var6_13;
                var8_14.L$1 = var0;
                var8_14.L$2 = var7_11;
                var8_14.label = 2;
                if (var6_13.send(var2_7 /* !! */ , var8_14) == var5_10) {
                    return var5_10;
                }
                var2_7 /* !! */  = var5_10;
                var5_10 = var8_14;
                continue;
                break;
            }
            try {
                var1_1 /* !! */  = Unit.INSTANCE;
            }
            catch (Throwable var1_3) {
                break block22;
            }
            ChannelsKt.cancelConsumed(var0, var4_9 /* !! */ );
            return var6_13;
            catch (Throwable var1_4) {
                break block22;
            }
            catch (Throwable var1_5) {
                // empty catch block
            }
        }
        try {
            throw var1_6;
        }
        catch (Throwable var2_8) {
            ChannelsKt.cancelConsumed(var0, (Throwable)var1_6);
            throw var2_8;
        }
    }

    /*
     * Exception decompiling
     */
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> var0, C var1_2, Continuation<? super C> var2_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [2 : 184->191)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> var0, M var1_2, Continuation<? super M> var2_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [2 : 184->191)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object toMap(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt.toMap(receiveChannel, (Map)new LinkedHashMap(), continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object toMutableList(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt.toCollection(receiveChannel, (Collection)new ArrayList(), continuation);
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, (Collection)new LinkedHashSet(), continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ Object toSet(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt.toMutableSet(receiveChannel, continuation);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel receiveChannel, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object>(receiveChannel, null){
            final ReceiveChannel<E> $this_withIndex;
            int I$0;
            private Object L$0;
            Object L$1;
            int label;
            {
                this.$this_withIndex = receiveChannel;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super IndexedValue<? extends E>> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[SWITCH], 4[CASE]], but top level block is 5[UNCONDITIONALDOLOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int n, Object object) {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.withIndex(receiveChannel, coroutineContext);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility")
    public static final /* synthetic */ ReceiveChannel zip(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2) {
        return ChannelsKt.zip$default(receiveChannel, receiveChannel2, null, zip.1.INSTANCE, 2, null);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext coroutineContext, Function2<? super E, ? super R, ? extends V> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumesAll(receiveChannel, receiveChannel2), new Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object>(receiveChannel2, receiveChannel, function2, null){
            final ReceiveChannel<R> $other;
            final ReceiveChannel<E> $this_zip;
            final Function2<E, R, V> $transform;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;
            {
                this.$other = receiveChannel;
                this.$this_zip = receiveChannel2;
                this.$transform = function2;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super V> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 4[TRYBLOCK] [4 : 401->408)] java.lang.Throwable
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int n, Object object) {
        if ((n & 2) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }
}

