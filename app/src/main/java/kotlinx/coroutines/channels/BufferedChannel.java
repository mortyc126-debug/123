/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.text.StringsKt
 */
package kotlinx.coroutines.channels;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelSegment;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveCatching;
import kotlinx.coroutines.channels.WaiterEB;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\"\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004\u00de\u0001\u00df\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u0006\u0010R\u001a\u00020\u0007J\u0010\u0010R\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016J\u0016\u0010R\u001a\u00020\u00072\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UJ\u0017\u0010V\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0010\u00a2\u0006\u0002\bWJ\u001e\u0010X\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010K\u001a\u00020\u0010H\u0002J\u0006\u0010Z\u001a\u00020\u0007J\u0012\u0010[\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001a\u0010]\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u00162\u0006\u0010R\u001a\u00020\u001cH\u0014J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0010H\u0002J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010_\u001a\u00020\u0010H\u0002J\b\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0010H\u0004J\b\u0010d\u001a\u00020\u0007H\u0002J.\u0010e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010h\u001a\u00020\u0010H\u0002J&\u0010i\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J&\u0010j\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\r\u0010k\u001a\u00020\u001cH\u0000\u00a2\u0006\u0002\blJ\u0012\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020\u0010H\u0002J\b\u0010o\u001a\u00020\u0007H\u0002J-\u0010p\u001a\u00020\u00072#\u0010q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010r\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0010H\u0002J\u0018\u0010v\u001a\u00020\u001c2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000yH\u0096\u0002J\u0016\u0010z\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010{\u001a\u00020\u0007H\u0002J\b\u0010|\u001a\u00020\u0007H\u0002J\b\u0010}\u001a\u00020\u0007H\u0002J\u001e\u0010~\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010\u007f\u001a\u00020\u0007H\u0014J\"\u0010\u0080\u0001\u001a\u00020\u00072\u0014\u0010\u0081\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0\u0082\u0001H\u0002\u00f8\u0001\u0000J\u0019\u0010\u0083\u0001\u001a\u00020\u00072\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0082\u0001H\u0002J\u0015\u0010\u0084\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002J$\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002\u00a2\u0006\u0003\u0010\u0087\u0001J\u001c\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0089\u0001J(\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0082\u0001H\u0002\u00a2\u0006\u0003\u0010\u008b\u0001J\t\u0010\u008c\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u008d\u0001\u001a\u00020\u0007H\u0014J!\u0010\u008e\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0091\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0092\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0093\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0013\u0010\u0094\u0001\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0095\u0001J%\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0096@\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u0097\u0001\u0010\u0095\u0001JD\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u008c\u0002\u0010\u009c\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0001\u0010\u009d\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2$\u0010\u009f\u0001\u001a\u001f\u0012\u0014\u0012\u00128\u0000\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0005\u0012\u0003H\u009d\u00010\u00062V\u0010\u00a0\u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u00a1\u0001\u0012\u0014\u0012\u00120\u0004\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u00a2\u0001\u0012\u0014\u0012\u00120\u0010\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u0001082\u000f\u0010\u00a3\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010\u00a4\u00012X\b\u0002\u0010\u00a5\u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u00a1\u0001\u0012\u0014\u0012\u00120\u0004\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u00a2\u0001\u0012\u0014\u0012\u00120\u0010\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u000108H\u0082\b\u00a2\u0006\u0003\u0010\u00a6\u0001Jh\u0010\u00a7\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\b\u0010\u009e\u0001\u001a\u00030\u00a8\u00012#\u0010\u009f\u0001\u001a\u001e\u0012\u0014\u0012\u00128\u0000\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010\u00a3\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u00a4\u0001H\u0082\bJ2\u0010\u00a9\u0001\u001a\u00028\u00002\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u009b\u0001J \u0010\u00aa\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\fH\u0002J \u0010\u00ab\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\fH\u0014J\u0017\u0010\u00ac\u0001\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001c\u0010\u00ad\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0089\u0001J\u001f\u0010\u00ae\u0001\u001a\u00020\u001c2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0090@\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u00af\u0001\u0010\u0089\u0001J\u0082\u0002\u0010\u00b0\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0001\u0010\u009d\u00012\u0007\u0010\u0086\u0001\u001a\u00028\u00002\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010\u00b1\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010\u00a4\u00012A\u0010\u00a0\u0001\u001a<\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u00a1\u0001\u0012\u0014\u0012\u00120\u0004\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u00a2\u0001\u0012\u0005\u0012\u0003H\u009d\u00010\u00b2\u00012\u000f\u0010\u00a3\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010\u00a4\u00012o\b\u0002\u0010\u00a5\u0001\u001ah\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u00a1\u0001\u0012\u0014\u0012\u00120\u0004\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u00a2\u0001\u0012\u0014\u0012\u00128\u0000\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0014\u0012\u00120\u0010\u00a2\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u00b4\u0001\u0012\u0005\u0012\u0003H\u009d\u00010\u00b3\u0001H\u0084\b\u00a2\u0006\u0003\u0010\u00b5\u0001Jb\u0010\u00b6\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010\u00b4\u0001\u001a\u00020\u00102\b\u0010\u009e\u0001\u001a\u00030\u00a8\u00012\u000e\u0010\u00b1\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u00a4\u00012\u000e\u0010\u00a3\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u00a4\u0001H\u0082\b\u00a2\u0006\u0003\u0010\u00b7\u0001J;\u0010\u00b8\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010\u00b4\u0001\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00b9\u0001J\u000f\u0010\u00ba\u0001\u001a\u00020\u001cH\u0010\u00a2\u0006\u0003\b\u00bb\u0001J\u0012\u0010\u00ba\u0001\u001a\u00020\u001c2\u0007\u0010\u00bc\u0001\u001a\u00020\u0010H\u0003J\n\u0010\u00bd\u0001\u001a\u00030\u00be\u0001H\u0016J\u0010\u0010\u00bf\u0001\u001a\u00030\u00be\u0001H\u0000\u00a2\u0006\u0003\b\u00c0\u0001J!\u0010\u00c1\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0016\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u00c2\u0001\u0010\u00c3\u0001J*\u0010\u00c4\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0016\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u00c5\u0001\u0010\u00c6\u0001J(\u0010\u00c7\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u00c8\u0001\u001a\u00020\u0010H\u0002J(\u0010\u00c9\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u00c8\u0001\u001a\u00020\u0010H\u0002J5\u0010\u00ca\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002J5\u0010\u00cb\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002JK\u0010\u00cc\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010\u00b4\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u00cd\u0001\u001a\u00020\u001cH\u0002\u00a2\u0006\u0003\u0010\u00ce\u0001JK\u0010\u00cf\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010\u00b4\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u00cd\u0001\u001a\u00020\u001cH\u0002\u00a2\u0006\u0003\u0010\u00ce\u0001J\u0012\u0010\u00d0\u0001\u001a\u00020\u00072\u0007\u0010\u00d1\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010\u00d2\u0001\u001a\u00020\u00072\u0007\u0010\u00d1\u0001\u001a\u00020\u0010H\u0002J\u0017\u0010\u00d3\u0001\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0010H\u0000\u00a2\u0006\u0003\b\u00d4\u0001J$\u0010\u00d5\u0001\u001a\u00020\u0007*\u00030\u00a8\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J$\u0010\u00d6\u0001\u001a\u00020\u0007*\u00030\u00a8\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J\u000e\u0010\u00d7\u0001\u001a\u00020\u0007*\u00030\u00a8\u0001H\u0002J\u000e\u0010\u00d8\u0001\u001a\u00020\u0007*\u00030\u00a8\u0001H\u0002J\u0017\u0010\u00d9\u0001\u001a\u00020\u0007*\u00030\u00a8\u00012\u0007\u0010\u00da\u0001\u001a\u00020\u001cH\u0002J\u001c\u0010\u00db\u0001\u001a\u00020\u001c*\u00020\f2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0002\u00a2\u0006\u0003\u0010\u00dc\u0001J#\u0010\u00dd\u0001\u001a\u00020\u001c*\u00020\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\t\u0010\u001a\u001a\u00020\u000eX\u0082\u0004R\u001a\u0010\u001b\u001a\u00020\u001c8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001fR\u001a\u0010 \u001a\u00020\u001c8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b!\u0010\u001e\u001a\u0004\b \u0010\u001fR\u0014\u0010\"\u001a\u00020\u001c8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001c8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b$\u0010\u001e\u001a\u0004\b#\u0010\u001fR\u0014\u0010%\u001a\u00020\u001c8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'8VX\u0096\u0004\u00a2\u0006\f\u0012\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*R)\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0'8VX\u0096\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010*R\"\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000'8VX\u0096\u0004\u00a2\u0006\f\u0012\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010*R,\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000038VX\u0096\u0004\u00a2\u0006\f\u0012\u0004\b4\u0010\u001e\u001a\u0004\b5\u00106R*\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b8\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000Ru\u00107\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u000309\u00a2\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u000108j\u0004\u0018\u0001`?X\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b@\u0010\u001eR\u0014\u0010A\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010\u0018R\u0015\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010D\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010E\u001a\u00020\u00108@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010\u0012R\u0014\u0010G\u001a\u00020\u00168DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010\u0018R\u0015\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010J\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010K\u001a\u00020\u00108@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010\u0012R\u0018\u0010M\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010NR\u0018\u0010O\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bO\u0010N\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u00e0\u0001"}, d2={"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "capacity", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlin/jvm/functions/Function1;)V", "_closeCause", "Lkotlinx/atomicfu/AtomicRef;", "", "bufferEnd", "Lkotlinx/atomicfu/AtomicLong;", "bufferEndCounter", "", "getBufferEndCounter", "()J", "bufferEndSegment", "Lkotlinx/coroutines/channels/ChannelSegment;", "closeCause", "", "getCloseCause", "()Ljava/lang/Throwable;", "closeHandler", "completedExpandBuffersAndPauseFlag", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isClosedForSend", "isClosedForSend$annotations", "isConflatedDropOldest", "isEmpty", "isEmpty$annotations", "isRendezvousOrUnlimited", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", "param", "internalResult", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "receiveException", "getReceiveException", "receiveSegment", "receivers", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "sendException", "getSendException", "sendSegment", "sendersAndCloseStatus", "sendersCounter", "getSendersCounter$kotlinx_coroutines_core", "isClosedForReceive0", "(J)Z", "isClosedForSend0", "bufferOrRendezvousSend", "curSenders", "cancel", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelSuspendedReceiveRequests", "lastSegment", "checkSegmentStructureInvariants", "close", "closeLinkedList", "closeOrCancelImpl", "completeCancel", "sendersCur", "completeClose", "completeCloseOrCancel", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "expandBuffer", "findSegmentBufferEnd", "id", "startFrom", "currentBufferEndCounter", "findSegmentReceive", "findSegmentSend", "hasElements", "hasElements$kotlinx_coroutines_core", "incCompletedExpandBufferAttempts", "nAttempts", "invokeCloseHandler", "invokeOnClose", "handler", "isCellNonEmpty", "segment", "index", "globalIndex", "isClosed", "sendersAndCloseStatusCur", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "markAllEmptyCellsAsClosed", "markCancellationStarted", "markCancelled", "markClosed", "moveSegmentBufferEndToSpecifiedOrLast", "onClosedIdempotent", "onClosedReceiveCatchingOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "onClosedReceiveOnNoWaiterSuspend", "onClosedSelectOnReceive", "onClosedSelectOnSend", "element", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "onClosedSend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSendOnNoWaiterSuspend", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "onReceiveDequeued", "onReceiveEnqueued", "processResultSelectReceive", "ignoredParam", "selectResult", "processResultSelectReceiveCatching", "processResultSelectReceiveOrNull", "processResultSelectSend", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "r", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveImpl", "R", "waiter", "onElementRetrieved", "onSuspend", "segm", "i", "onClosed", "Lkotlin/Function0;", "onNoWaiterSuspend", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "Lkotlinx/coroutines/Waiter;", "receiveOnNoWaiterSuspend", "registerSelectForReceive", "registerSelectForSend", "removeUnprocessedElements", "send", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "onRendezvousOrBuffered", "Lkotlin/Function2;", "Lkotlin/Function4;", "s", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "sendOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "curSendersAndCloseStatus", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "updateCellReceive", "updateCellReceiveSlow", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "updateReceiversCounterIfLower", "value", "updateSendersCounterIfLower", "waitExpandBufferCompletion", "waitExpandBufferCompletion$kotlinx_coroutines_core", "prepareReceiverForSuspension", "prepareSenderForSuspension", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "tryResumeSender", "BufferedChannelIterator", "SendBroadcast", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class BufferedChannel<E>
implements Channel<E> {
    private static final AtomicReferenceFieldUpdater _closeCause$FU;
    private static final AtomicLongFieldUpdater bufferEnd$FU;
    private static final AtomicReferenceFieldUpdater bufferEndSegment$FU;
    private static final AtomicReferenceFieldUpdater closeHandler$FU;
    private static final AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$FU;
    private static final AtomicReferenceFieldUpdater receiveSegment$FU;
    private static final AtomicLongFieldUpdater receivers$FU;
    private static final AtomicReferenceFieldUpdater sendSegment$FU;
    private static final AtomicLongFieldUpdater sendersAndCloseStatus$FU;
    @Volatile
    private volatile Object _closeCause;
    @Volatile
    private volatile long bufferEnd;
    @Volatile
    private volatile Object bufferEndSegment;
    private final int capacity;
    @Volatile
    private volatile Object closeHandler;
    @Volatile
    private volatile long completedExpandBuffersAndPauseFlag;
    public final Function1<E, Unit> onUndeliveredElement;
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onUndeliveredElementReceiveCancellationConstructor;
    @Volatile
    private volatile Object receiveSegment;
    @Volatile
    private volatile long receivers;
    @Volatile
    private volatile Object sendSegment;
    @Volatile
    private volatile long sendersAndCloseStatus;

    static {
        sendersAndCloseStatus$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");
        receivers$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");
        bufferEnd$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");
        completedExpandBuffersAndPauseFlag$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");
        sendSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");
        receiveSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");
        bufferEndSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");
        _closeCause$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");
        closeHandler$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");
    }

    public BufferedChannel(int n, Function1<? super E, Unit> object) {
        this.capacity = n;
        this.onUndeliveredElement = object;
        n = this.capacity >= 0 ? 1 : 0;
        if (n != 0) {
            this.bufferEnd = BufferedChannelKt.access$initialBufferEnd(this.capacity);
            this.completedExpandBuffersAndPauseFlag = this.getBufferEndCounter();
            object = new ChannelSegment(0L, null, this, 3);
            this.sendSegment = object;
            this.receiveSegment = object;
            if (this.isRendezvousOrUnlimited()) {
                object = BufferedChannelKt.access$getNULL_SEGMENT$p();
                Intrinsics.checkNotNull(object, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = object;
            object = this.onUndeliveredElement != null ? (Function3)new Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>(this){
                final BufferedChannel<E> this$0;
                {
                    this.this$0 = bufferedChannel;
                    super(3);
                }

                public final Function1<Throwable, Unit> invoke(SelectInstance<?> selectInstance, Object object, Object object2) {
                    return (Function1)new Function1<Throwable, Unit>(object2, this.this$0, selectInstance){
                        final Object $element;
                        final SelectInstance<?> $select;
                        final BufferedChannel<E> this$0;
                        {
                            this.$element = object;
                            this.this$0 = bufferedChannel;
                            this.$select = selectInstance;
                            super(1);
                        }

                        public final void invoke(Throwable throwable) {
                            if (this.$element != BufferedChannelKt.getCHANNEL_CLOSED()) {
                                OnUndeliveredElementKt.callUndeliveredElement(this.this$0.onUndeliveredElement, this.$element, this.$select.getContext());
                            }
                        }
                    };
                }
            } : null;
            this.onUndeliveredElementReceiveCancellationConstructor = object;
            this._closeCause = BufferedChannelKt.access$getNO_CLOSE_CAUSE$p();
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + this.capacity + ", should be >=0").toString());
    }

    public /* synthetic */ BufferedChannel(int n, Function1 function1, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            function1 = null;
        }
        this(n, function1);
    }

    public static final /* synthetic */ void access$onClosedReceiveCatchingOnNoWaiterSuspend(BufferedChannel bufferedChannel, CancellableContinuation cancellableContinuation) {
        bufferedChannel.onClosedReceiveCatchingOnNoWaiterSuspend(cancellableContinuation);
    }

    public static final /* synthetic */ void access$onClosedReceiveOnNoWaiterSuspend(BufferedChannel bufferedChannel, CancellableContinuation cancellableContinuation) {
        bufferedChannel.onClosedReceiveOnNoWaiterSuspend(cancellableContinuation);
    }

    public static final /* synthetic */ Object access$onClosedSend(BufferedChannel bufferedChannel, Object object, Continuation continuation) {
        return bufferedChannel.onClosedSend(object, (Continuation<Unit>)continuation);
    }

    public static final /* synthetic */ void access$onClosedSendOnNoWaiterSuspend(BufferedChannel bufferedChannel, Object object, CancellableContinuation cancellableContinuation) {
        bufferedChannel.onClosedSendOnNoWaiterSuspend(object, cancellableContinuation);
    }

    public static final /* synthetic */ Object access$processResultSelectReceive(BufferedChannel bufferedChannel, Object object, Object object2) {
        return bufferedChannel.processResultSelectReceive(object, object2);
    }

    public static final /* synthetic */ Object access$processResultSelectReceiveCatching(BufferedChannel bufferedChannel, Object object, Object object2) {
        return bufferedChannel.processResultSelectReceiveCatching(object, object2);
    }

    public static final /* synthetic */ Object access$processResultSelectReceiveOrNull(BufferedChannel bufferedChannel, Object object, Object object2) {
        return bufferedChannel.processResultSelectReceiveOrNull(object, object2);
    }

    public static final /* synthetic */ Object access$processResultSelectSend(BufferedChannel bufferedChannel, Object object, Object object2) {
        return bufferedChannel.processResultSelectSend(object, object2);
    }

    public static final /* synthetic */ Object access$receiveCatchingOnNoWaiterSuspend-GKJJFZk(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int n, long l, Continuation continuation) {
        return bufferedChannel.receiveCatchingOnNoWaiterSuspend-GKJJFZk(channelSegment, n, l, continuation);
    }

    public static final /* synthetic */ Object access$receiveOnNoWaiterSuspend(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int n, long l, Continuation continuation) {
        return bufferedChannel.receiveOnNoWaiterSuspend(channelSegment, n, l, continuation);
    }

    public static final /* synthetic */ void access$registerSelectForReceive(BufferedChannel bufferedChannel, SelectInstance selectInstance, Object object) {
        bufferedChannel.registerSelectForReceive(selectInstance, object);
    }

    public static final /* synthetic */ Object access$sendOnNoWaiterSuspend(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int n, Object object, long l, Continuation continuation) {
        return bufferedChannel.sendOnNoWaiterSuspend(channelSegment, n, object, l, (Continuation<Unit>)continuation);
    }

    private final boolean bufferOrRendezvousSend(long l) {
        boolean bl = l < this.getBufferEndCounter() || l < this.getReceiversCounter$kotlinx_coroutines_core() + (long)this.capacity;
        return bl;
    }

    /*
     * Unable to fully structure code
     */
    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> var1_1, long var2_2) {
        var6_3 = InlineList.constructor-impl$default(null, 1, null);
        var5_4 = var1_1;
        var1_1 = var6_3;
        block0: while (true) {
            var6_3 = var1_1;
            if (var5_4 == null) break;
            block1: for (var4_5 = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < var4_5; --var4_5) {
                var6_3 = var1_1;
                if (var5_4.id * (long)BufferedChannelKt.SEGMENT_SIZE + (long)var4_5 < var2_2) break block0;
                do lbl-1000:
                // 4 sources

                {
                    block7: {
                        if ((var6_3 = var5_4.getState$kotlinx_coroutines_core(var4_5)) == null || var6_3 == BufferedChannelKt.access$getIN_BUFFER$p()) continue;
                        if (!(var6_3 instanceof WaiterEB)) break block7;
                        if (!var5_4.casState$kotlinx_coroutines_core(var4_5, var6_3, BufferedChannelKt.getCHANNEL_CLOSED())) ** GOTO lbl-1000
                        var1_1 = InlineList.plus-FjFbRPM(var1_1, ((WaiterEB)var6_3).waiter);
                        var5_4.onCancelledRequest(var4_5, true);
                        continue block1;
                    }
                    if (!(var6_3 instanceof Waiter)) continue block1;
                    if (!var5_4.casState$kotlinx_coroutines_core(var4_5, var6_3, BufferedChannelKt.getCHANNEL_CLOSED())) ** GOTO lbl-1000
                    var1_1 = InlineList.plus-FjFbRPM(var1_1, var6_3);
                    var5_4.onCancelledRequest(var4_5, true);
                    continue block1;
                } while (!var5_4.casState$kotlinx_coroutines_core(var4_5, var6_3, BufferedChannelKt.getCHANNEL_CLOSED()));
                var5_4.onSlotCleaned();
            }
            var5_4 = (ChannelSegment)var5_4.getPrev();
        }
        if (var6_3 != null) {
            if (!(var6_3 instanceof ArrayList)) {
                this.resumeReceiverOnClosedChannel((Waiter)var6_3);
            } else {
                Intrinsics.checkNotNull((Object)var6_3, (String)"null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                var1_1 = (ArrayList)var6_3;
                for (var4_5 = var1_1.size() - 1; -1 < var4_5; --var4_5) {
                    this.resumeReceiverOnClosedChannel((Waiter)var1_1.get(var4_5));
                }
            }
        }
    }

    private final ChannelSegment<E> closeLinkedList() {
        Object object = bufferEndSegment$FU.get(this);
        ChannelSegment<Object> channelSegment = (ChannelSegment)sendSegment$FU.get(this);
        Object object2 = object;
        if (channelSegment.id > ((ChannelSegment)object).id) {
            object2 = channelSegment;
        }
        object = (ChannelSegment)receiveSegment$FU.get(this);
        channelSegment = object2;
        if (((ChannelSegment)object).id > ((ChannelSegment)object2).id) {
            channelSegment = object;
        }
        return (ChannelSegment)ConcurrentLinkedListKt.close((ConcurrentLinkedListNode)channelSegment);
    }

    private final void completeCancel(long l) {
        this.removeUnprocessedElements(this.completeClose(l));
    }

    private final ChannelSegment<E> completeClose(long l) {
        long l2;
        ChannelSegment<E> channelSegment = this.closeLinkedList();
        if (this.isConflatedDropOldest() && (l2 = this.markAllEmptyCellsAsClosed(channelSegment)) != -1L) {
            this.dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(l2);
        }
        this.cancelSuspendedReceiveRequests(channelSegment, l);
        return channelSegment;
    }

    private final void completeCloseOrCancel() {
        this.isClosedForSend();
    }

    private final void expandBuffer() {
        if (this.isRendezvousOrUnlimited()) {
            return;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment<E>)bufferEndSegment$FU.get(this);
        while (true) {
            long l = bufferEnd$FU.getAndIncrement(this);
            long l2 = l / (long)BufferedChannelKt.SEGMENT_SIZE;
            if (this.getSendersCounter$kotlinx_coroutines_core() <= l) {
                if (channelSegment.id < l2 && channelSegment.getNext() != null) {
                    this.moveSegmentBufferEndToSpecifiedOrLast(l2, channelSegment);
                }
                BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            if (channelSegment.id != l2) {
                ChannelSegment<E> channelSegment2 = this.findSegmentBufferEnd(l2, channelSegment, l);
                if (channelSegment2 == null) continue;
                channelSegment = channelSegment2;
            }
            if (this.updateCellExpandBuffer(channelSegment, (int)(l % (long)BufferedChannelKt.SEGMENT_SIZE), l)) {
                BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        }
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long l, ChannelSegment<E> segment, long l2) {
        boolean bl;
        Segment segment2;
        boolean bl2;
        boolean bl3;
        Object object;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$FU;
        Function2 function2 = (Function2)BufferedChannelKt.createSegmentFunction();
        block0: while (true) {
            object = ConcurrentLinkedListKt.findSegmentInternal((Segment)segment, l, function2);
            bl3 = SegmentOrClosed.isClosed-impl(object);
            bl2 = false;
            if (bl3) break;
            Object s = SegmentOrClosed.getSegment-impl(object);
            bl3 = false;
            while (true) {
                block18: {
                    block16: {
                        block17: {
                            block15: {
                                segment2 = (Segment)atomicReferenceFieldUpdater.get(this);
                                if (segment2.id < ((Segment)s).id) break block15;
                                bl = true;
                                break block16;
                            }
                            if (((Segment)s).tryIncPointers$kotlinx_coroutines_core()) break block17;
                            bl = false;
                            break block16;
                        }
                        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment2, s)) break block18;
                        if (segment2.decPointers$kotlinx_coroutines_core()) {
                            segment2.remove();
                        }
                        bl = true;
                    }
                    if (!bl) continue block0;
                    break block0;
                }
                if (!((Segment)s).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)s).remove();
            }
            break;
        }
        bl3 = SegmentOrClosed.isClosed-impl(object);
        segment2 = null;
        if (bl3) {
            this.completeCloseOrCancel();
            this.moveSegmentBufferEndToSpecifiedOrLast(l, (ChannelSegment<E>)segment);
            BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            segment = segment2;
        } else {
            segment = (ChannelSegment)SegmentOrClosed.getSegment-impl(object);
            if (segment.id > l) {
                if (bufferEnd$FU.compareAndSet(this, l2 + 1L, segment.id * (long)BufferedChannelKt.SEGMENT_SIZE)) {
                    this.incCompletedExpandBufferAttempts(segment.id * (long)BufferedChannelKt.SEGMENT_SIZE - l2);
                } else {
                    BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                }
                segment = segment2;
            } else if (DebugKt.getASSERTIONS_ENABLED()) {
                bl = bl2;
                if (segment.id == l) {
                    bl = true;
                }
                if (!bl) {
                    throw new AssertionError();
                }
            }
        }
        return segment;
    }

    private final ChannelSegment<E> findSegmentReceive(long l, ChannelSegment<E> object) {
        boolean bl;
        Object object2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$FU;
        Object object3 = (Function2)BufferedChannelKt.createSegmentFunction();
        boolean bl2 = false;
        block0: while (!SegmentOrClosed.isClosed-impl(object2 = ConcurrentLinkedListKt.findSegmentInternal((Segment)object, l, object3))) {
            Object s = SegmentOrClosed.getSegment-impl(object2);
            while (true) {
                block19: {
                    block17: {
                        Segment segment;
                        block18: {
                            block16: {
                                segment = (Segment)atomicReferenceFieldUpdater.get(this);
                                if (segment.id < ((Segment)s).id) break block16;
                                bl = true;
                                break block17;
                            }
                            if (((Segment)s).tryIncPointers$kotlinx_coroutines_core()) break block18;
                            bl = false;
                            break block17;
                        }
                        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment, s)) break block19;
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                        bl = true;
                    }
                    if (!bl) continue block0;
                    break block0;
                }
                if (!((Segment)s).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)s).remove();
            }
        }
        if (SegmentOrClosed.isClosed-impl(object3 = object2)) {
            this.completeCloseOrCancel();
            if (((ChannelSegment)object).id * (long)BufferedChannelKt.SEGMENT_SIZE < this.getSendersCounter$kotlinx_coroutines_core()) {
                ((ConcurrentLinkedListNode)object).cleanPrev();
            }
            object = null;
        } else {
            object2 = (ChannelSegment)SegmentOrClosed.getSegment-impl(object3);
            if (!this.isRendezvousOrUnlimited() && l <= this.getBufferEndCounter() / (long)BufferedChannelKt.SEGMENT_SIZE) {
                atomicReferenceFieldUpdater = bufferEndSegment$FU;
                object = object3;
                while (true) {
                    object3 = (Segment)atomicReferenceFieldUpdater.get(this);
                    if (((Segment)object3).id >= ((Segment)object2).id || !((Segment)object2).tryIncPointers$kotlinx_coroutines_core()) break;
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, object3, (Segment)object2)) {
                        if (!((Segment)object3).decPointers$kotlinx_coroutines_core()) break;
                        ((ConcurrentLinkedListNode)object3).remove();
                        break;
                    }
                    if (!((Segment)object2).decPointers$kotlinx_coroutines_core()) continue;
                    ((Segment)object2).remove();
                }
            }
            if (((ChannelSegment)object2).id > l) {
                this.updateReceiversCounterIfLower(((ChannelSegment)object2).id * (long)BufferedChannelKt.SEGMENT_SIZE);
                if (((ChannelSegment)object2).id * (long)BufferedChannelKt.SEGMENT_SIZE < this.getSendersCounter$kotlinx_coroutines_core()) {
                    ((ConcurrentLinkedListNode)object2).cleanPrev();
                }
                object = null;
            } else {
                if (DebugKt.getASSERTIONS_ENABLED() && !(bl = ((ChannelSegment)object2).id == l)) {
                    throw new AssertionError();
                }
                object = object2;
            }
        }
        return object;
    }

    private final ChannelSegment<E> findSegmentSend(long l, ChannelSegment<E> channelSegment) {
        boolean bl;
        Object object;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$FU;
        Function2 function2 = (Function2)BufferedChannelKt.createSegmentFunction();
        boolean bl2 = false;
        block0: while (!SegmentOrClosed.isClosed-impl(object = ConcurrentLinkedListKt.findSegmentInternal((Segment)channelSegment, l, function2))) {
            Object s = SegmentOrClosed.getSegment-impl(object);
            while (true) {
                block16: {
                    block14: {
                        Segment segment;
                        block15: {
                            block13: {
                                segment = (Segment)atomicReferenceFieldUpdater.get(this);
                                if (segment.id < ((Segment)s).id) break block13;
                                bl = true;
                                break block14;
                            }
                            if (((Segment)s).tryIncPointers$kotlinx_coroutines_core()) break block15;
                            bl = false;
                            break block14;
                        }
                        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment, s)) break block16;
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                        bl = true;
                    }
                    if (!bl) continue block0;
                    break block0;
                }
                if (!((Segment)s).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)s).remove();
            }
        }
        bl2 = SegmentOrClosed.isClosed-impl(object);
        function2 = null;
        if (bl2) {
            this.completeCloseOrCancel();
            if (channelSegment.id * (long)BufferedChannelKt.SEGMENT_SIZE < this.getReceiversCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            channelSegment = function2;
        } else {
            channelSegment = (ChannelSegment)SegmentOrClosed.getSegment-impl(object);
            if (channelSegment.id > l) {
                this.updateSendersCounterIfLower(channelSegment.id * (long)BufferedChannelKt.SEGMENT_SIZE);
                if (channelSegment.id * (long)BufferedChannelKt.SEGMENT_SIZE < this.getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                channelSegment = function2;
            } else if (DebugKt.getASSERTIONS_ENABLED() && !(bl = channelSegment.id == l)) {
                throw new AssertionError();
            }
        }
        return channelSegment;
    }

    private final Object getAndUpdate$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1, Object object) {
        Object v;
        while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, object, v = atomicReferenceFieldUpdater.get(object), function1.invoke(v))) {
        }
        return v;
    }

    private final long getBufferEndCounter() {
        return bufferEnd$FU.get(this);
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private static /* synthetic */ void getOnUndeliveredElementReceiveCancellationConstructor$annotations() {
    }

    private final Throwable getReceiveException() {
        Throwable throwable;
        Throwable throwable2 = throwable = this.getCloseCause();
        if (throwable == null) {
            throwable2 = new ClosedReceiveChannelException("Channel was closed");
        }
        return throwable2;
    }

    private final void incCompletedExpandBufferAttempts(long l) {
        boolean bl = (completedExpandBuffersAndPauseFlag$FU.addAndGet(this, l) & 0x4000000000000000L) != 0L;
        if (bl) {
            while (bl = (completedExpandBuffersAndPauseFlag$FU.get(this) & 0x4000000000000000L) != 0L) {
            }
        }
    }

    static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long l, int n, Object object) {
        if (object == null) {
            if ((n & 1) != 0) {
                l = 1L;
            }
            bufferedChannel.incCompletedExpandBufferAttempts(l);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void invokeCloseHandler() {
        Symbol symbol;
        Object v;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$FU;
        while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, v, symbol = (v = atomicReferenceFieldUpdater.get(this)) == null ? BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p() : BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p())) {
        }
        if (v == null) {
            return;
        }
        symbol = (Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(v, (int)1);
        ((Function1)v).invoke((Object)this.getCloseCause());
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> channelSegment, int n, long l) {
        Object object;
        do {
            object = channelSegment.getState$kotlinx_coroutines_core(n);
            boolean bl = false;
            if (object == null || object == BufferedChannelKt.access$getIN_BUFFER$p()) continue;
            if (object == BufferedChannelKt.BUFFERED) {
                return true;
            }
            if (object == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) {
                return false;
            }
            if (object == BufferedChannelKt.getCHANNEL_CLOSED()) {
                return false;
            }
            if (object == BufferedChannelKt.access$getDONE_RCV$p()) {
                return false;
            }
            if (object == BufferedChannelKt.access$getPOISONED$p()) {
                return false;
            }
            if (object == BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
                return true;
            }
            if (object == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) {
                return false;
            }
            if (l == this.getReceiversCounter$kotlinx_coroutines_core()) {
                bl = true;
            }
            return bl;
        } while (!channelSegment.casState$kotlinx_coroutines_core(n, object, BufferedChannelKt.access$getPOISONED$p()));
        this.expandBuffer();
        return false;
    }

    private final boolean isClosed(long l, boolean bl) {
        boolean bl2;
        int n = (int)(l >> 60);
        boolean bl3 = true;
        switch (n) {
            default: {
                throw new IllegalStateException(("unexpected close status: " + (int)(l >> 60)).toString());
            }
            case 3: {
                this.completeCancel(l & 0xFFFFFFFFFFFFFFFL);
                bl2 = bl3;
                break;
            }
            case 2: {
                this.completeClose(l & 0xFFFFFFFFFFFFFFFL);
                bl2 = bl3;
                if (!bl) break;
                if (!this.hasElements$kotlinx_coroutines_core()) {
                    bl2 = bl3;
                    break;
                }
                bl2 = false;
                break;
            }
            case 1: {
                bl2 = false;
                break;
            }
            case 0: {
                bl2 = false;
            }
        }
        return bl2;
    }

    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    private final boolean isClosedForReceive0(long l) {
        return this.isClosed(l, true);
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    private final boolean isClosedForSend0(long l) {
        return this.isClosed(l, false);
    }

    public static /* synthetic */ void isEmpty$annotations() {
    }

    private final boolean isRendezvousOrUnlimited() {
        long l = this.getBufferEndCounter();
        boolean bl = l == 0L || l == Long.MAX_VALUE;
        return bl;
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1, Object object) {
        while (true) {
            function1.invoke((Object)atomicLongFieldUpdater.get(object));
        }
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object object) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(object));
        }
    }

    private final long markAllEmptyCellsAsClosed(ChannelSegment<E> channelSegment) {
        do {
            block1: for (int i = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i; --i) {
                Object object;
                long l = channelSegment.id * (long)BufferedChannelKt.SEGMENT_SIZE + (long)i;
                if (l < this.getReceiversCounter$kotlinx_coroutines_core()) {
                    return -1L;
                }
                do {
                    if ((object = channelSegment.getState$kotlinx_coroutines_core(i)) == null || object == BufferedChannelKt.access$getIN_BUFFER$p()) continue;
                    if (object != BufferedChannelKt.BUFFERED) continue block1;
                    return l;
                } while (!channelSegment.casState$kotlinx_coroutines_core(i, object, BufferedChannelKt.getCHANNEL_CLOSED()));
                channelSegment.onSlotCleaned();
            }
        } while ((channelSegment = (ChannelSegment)channelSegment.getPrev()) != null);
        return -1L;
    }

    private final void markCancellationStarted() {
        long l;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        while ((int)((l = atomicLongFieldUpdater.get(this)) >> 60) == 0) {
            long l2 = BufferedChannelKt.access$constructSendersAndCloseStatus(l & 0xFFFFFFFFFFFFFFFL, 1);
            if (!atomicLongFieldUpdater.compareAndSet(this, l, l2)) continue;
            return;
        }
    }

    private final void markCancelled() {
        long l;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        while (!atomicLongFieldUpdater.compareAndSet(this, l = atomicLongFieldUpdater.get(this), BufferedChannelKt.access$constructSendersAndCloseStatus(l & 0xFFFFFFFFFFFFFFFL, 3))) {
        }
    }

    private final void markClosed() {
        long l;
        long l2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            l2 = atomicLongFieldUpdater.get(this);
            switch ((int)(l2 >> 60)) {
                default: {
                    return;
                }
                case 1: {
                    l = BufferedChannelKt.access$constructSendersAndCloseStatus(0xFFFFFFFFFFFFFFFL & l2, 3);
                    break;
                }
                case 0: {
                    l = BufferedChannelKt.access$constructSendersAndCloseStatus(0xFFFFFFFFFFFFFFFL & l2, 2);
                }
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, l2, l));
    }

    private final void moveSegmentBufferEndToSpecifiedOrLast(long l, ChannelSegment<E> object) {
        Object object2;
        while (true) {
            object2 = object;
            if (((ChannelSegment)object).id >= l) break;
            object2 = (ChannelSegment)((ConcurrentLinkedListNode)object).getNext();
            if (object2 == null) {
                object2 = object;
                break;
            }
            object = object2;
        }
        block1: while (true) {
            object = object2;
            while (((Segment)object).isRemoved() && (object2 = (ChannelSegment)((ConcurrentLinkedListNode)object).getNext()) != null) {
                object = object2;
            }
            object2 = bufferEndSegment$FU;
            while (true) {
                block11: {
                    boolean bl;
                    block9: {
                        Segment segment;
                        block10: {
                            segment = (Segment)((AtomicReferenceFieldUpdater)object2).get(this);
                            l = segment.id;
                            long l2 = ((Segment)object).id;
                            bl = true;
                            if (l >= l2) break block9;
                            if (((Segment)object).tryIncPointers$kotlinx_coroutines_core()) break block10;
                            bl = false;
                            break block9;
                        }
                        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m((AtomicReferenceFieldUpdater)object2, this, segment, (Segment)object)) break block11;
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    }
                    object2 = object;
                    if (!bl) continue block1;
                    return;
                }
                if (!((Segment)object).decPointers$kotlinx_coroutines_core()) continue;
                ((Segment)object).remove();
            }
            break;
        }
    }

    private final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> companion) {
        Continuation continuation = (Continuation)companion;
        companion = Result.Companion;
        continuation.resumeWith(Result.constructor-impl((Object)ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause()))));
    }

    private final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> companion) {
        Continuation continuation = (Continuation)companion;
        companion = Result.Companion;
        continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)this.getReceiveException())));
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> selectInstance) {
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final void onClosedSelectOnSend(E e, SelectInstance<?> selectInstance) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, e, selectInstance.getContext());
        }
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final Object onClosedSend(E object, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        Result.Companion companion = this.onUndeliveredElement;
        if (companion != null && (object = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(companion, object, null, 2, null)) != null) {
            ExceptionsKt.addSuppressed((Throwable)((Throwable)object), (Throwable)this.getSendException());
            cancellableContinuation = cancellableContinuation;
            companion = Result.Companion;
            object = DebugKt.getRECOVER_STACK_TRACES() && cancellableContinuation instanceof CoroutineStackFrame ? StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)object, (CoroutineStackFrame)cancellableContinuation) : (Throwable)object;
            cancellableContinuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure(object)));
        } else {
            cancellableContinuation = cancellableContinuation;
            object = this.getSendException();
            companion = Result.Companion;
            if (DebugKt.getRECOVER_STACK_TRACES() && cancellableContinuation instanceof CoroutineStackFrame) {
                object = StackTraceRecoveryKt.access$recoverFromStackFrame(object, (CoroutineStackFrame)cancellableContinuation);
            }
            cancellableContinuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure(object)));
        }
        object = cancellableContinuationImpl.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final void onClosedSendOnNoWaiterSuspend(E object, CancellableContinuation<? super Unit> companion) {
        Object object2 = this.onUndeliveredElement;
        if (object2 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(object2, object, companion.getContext());
        }
        Continuation continuation = (Continuation)companion;
        object2 = this.getSendException();
        object = object2;
        if (DebugKt.getRECOVER_STACK_TRACES()) {
            object = !((Continuation)companion instanceof CoroutineStackFrame) ? object2 : StackTraceRecoveryKt.access$recoverFromStackFrame(object2, (CoroutineStackFrame)((Continuation)companion));
        }
        companion = Result.Companion;
        continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure(object)));
    }

    private final void prepareReceiverForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int n) {
        this.onReceiveEnqueued();
        waiter.invokeOnCancellation((Segment)channelSegment, n);
    }

    private final void prepareSenderForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int n) {
        waiter.invokeOnCancellation((Segment)channelSegment, BufferedChannelKt.SEGMENT_SIZE + n);
    }

    private final Object processResultSelectReceive(Object object, Object object2) {
        if (object2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return object2;
        }
        throw this.getReceiveException();
    }

    private final Object processResultSelectReceiveCatching(Object object, Object object2) {
        object = object2 == BufferedChannelKt.getCHANNEL_CLOSED() ? ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause()) : ChannelResult.Companion.success-JP2dKIU(object2);
        return ChannelResult.box-impl(object);
    }

    private final Object processResultSelectReceiveOrNull(Object object, Object object2) {
        if (object2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            if (this.getCloseCause() == null) {
                object2 = null;
            } else {
                throw this.getReceiveException();
            }
        }
        return object2;
    }

    private final Object processResultSelectSend(Object object, Object object2) {
        if (object2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return this;
        }
        throw this.getSendException();
    }

    static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> object, Continuation<? super E> continuation) {
        Object object2 = (ChannelSegment)BufferedChannel.receiveSegment$FU.get(object);
        while (!((BufferedChannel)object).isClosedForReceive()) {
            Object object3;
            long l = BufferedChannel.receivers$FU.getAndIncrement(object);
            long l2 = l / (long)BufferedChannelKt.SEGMENT_SIZE;
            int n = (int)(l % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (((ChannelSegment)object2).id != l2) {
                object3 = ((BufferedChannel)object).findSegmentReceive(l2, (ChannelSegment)object2);
                if (object3 == null) continue;
                object2 = object3;
            }
            if ((object3 = ((BufferedChannel)object).updateCellReceive((ChannelSegment)object2, n, l, null)) != BufferedChannelKt.access$getSUSPEND$p()) {
                if (object3 == BufferedChannelKt.access$getFAILED$p()) {
                    if (l >= ((BufferedChannel)object).getSendersCounter$kotlinx_coroutines_core()) continue;
                    ((ConcurrentLinkedListNode)object2).cleanPrev();
                    continue;
                }
                if (object3 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    object = super.receiveOnNoWaiterSuspend((ChannelSegment<E>)object2, n, l, continuation);
                    return object;
                }
                ((ConcurrentLinkedListNode)object2).cleanPrev();
                return object3;
            }
            throw new IllegalStateException("unexpected".toString());
        }
        throw StackTraceRecoveryKt.recoverStackTrace(super.getReceiveException());
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static /* synthetic */ <E> Object receiveCatching-JP2dKIU$suspendImpl(BufferedChannel<E> var0, Continuation<? super ChannelResult<? extends E>> var1_1) {
        block10: {
            if (!(var1_1 /* !! */  instanceof receiveCatching.1)) ** GOTO lbl-1000
            var7_2 = var1_1 /* !! */ ;
            if ((var7_2.label & -2147483648) != 0) {
                var7_2.label += -2147483648;
                var1_1 /* !! */  = var7_2;
            } else lbl-1000:
            // 2 sources

            {
                var1_1 /* !! */  = new ContinuationImpl(var0, (Continuation<? super receiveCatching.1>)var1_1 /* !! */ ){
                    int label;
                    Object result;
                    final BufferedChannel<E> this$0;
                    {
                        this.this$0 = bufferedChannel;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        object = BufferedChannel.receiveCatching-JP2dKIU$suspendImpl(this.this$0, (Continuation)this);
                        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            return object;
                        }
                        return ChannelResult.box-impl(object);
                    }
                };
            }
            var7_2 = var1_1 /* !! */ .result;
            var9_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            block0 : switch (var1_1 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    ResultKt.throwOnFailure((Object)var7_2);
                    var0 = ((ChannelResult)var7_2).unbox-impl();
                    break;
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var7_2);
                    var8_4 = (ChannelSegment)BufferedChannel.access$getReceiveSegment$FU$p().get(var0);
                    while (true) {
                        if (var0.isClosedForReceive()) {
                            var0 = ChannelResult.Companion.closed-JP2dKIU(var0.getCloseCause());
                            break block0;
                        }
                        var5_7 = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(var0);
                        var3_6 = var5_7 / (long)BufferedChannelKt.SEGMENT_SIZE;
                        var2_5 = (int)(var5_7 % (long)BufferedChannelKt.SEGMENT_SIZE);
                        var7_2 = var8_4;
                        if (var8_4.id != var3_6 && (var7_2 = BufferedChannel.access$findSegmentReceive((BufferedChannel)var0, var3_6, (ChannelSegment)var8_4)) == null) continue;
                        var8_4 = BufferedChannel.access$updateCellReceive((BufferedChannel)var0, (ChannelSegment)var7_2, var2_5, var5_7, null);
                        if (var8_4 == BufferedChannelKt.access$getSUSPEND$p()) break block10;
                        if (var8_4 != BufferedChannelKt.access$getFAILED$p()) break;
                        if (var5_7 < var0.getSendersCounter$kotlinx_coroutines_core()) {
                            var7_2.cleanPrev();
                        }
                        var8_4 = var7_2;
                    }
                    if (var8_4 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                        var1_1 /* !! */ .label = 1;
                        if ((var0 = super.receiveCatchingOnNoWaiterSuspend-GKJJFZk((ChannelSegment<E>)var7_2, var2_5, var5_7, var1_1 /* !! */ )) != var9_3) break;
                        return var9_3;
                    }
                    var7_2.cleanPrev();
                    var0 = ChannelResult.Companion.success-JP2dKIU(var8_4);
                }
            }
            return var0;
        }
        throw new IllegalStateException("unexpected".toString());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Object receiveCatchingOnNoWaiterSuspend-GKJJFZk(ChannelSegment<E> var1_1, int var2_5, long var3_6, Continuation<? super ChannelResult<? extends E>> var5_7) {
        block23: {
            block24: {
                if (!(var5_7 /* !! */  instanceof receiveCatchingOnNoWaiterSuspend.1)) ** GOTO lbl-1000
                var8_8 /* !! */  = var5_7 /* !! */ ;
                if ((var8_8 /* !! */ .label & -2147483648) != 0) {
                    var8_8 /* !! */ .label += -2147483648;
                    var5_7 /* !! */  = var8_8 /* !! */ ;
                } else lbl-1000:
                // 2 sources

                {
                    var5_7 /* !! */  = new ContinuationImpl(this, var5_7 /* !! */ ){
                        int I$0;
                        long J$0;
                        Object L$0;
                        Object L$1;
                        int label;
                        Object result;
                        final BufferedChannel<E> this$0;
                        {
                            this.this$0 = bufferedChannel;
                            super(continuation);
                        }

                        public final Object invokeSuspend(Object object) {
                            this.result = object;
                            this.label |= Integer.MIN_VALUE;
                            object = BufferedChannel.access$receiveCatchingOnNoWaiterSuspend-GKJJFZk(this.this$0, null, 0, 0L, (Continuation)this);
                            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return object;
                            }
                            return ChannelResult.box-impl(object);
                        }
                    };
                }
                var8_8 /* !! */  = var5_7 /* !! */ .result;
                var12_9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (var5_7 /* !! */ .label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        var3_6 = var5_7 /* !! */ .J$0;
                        var2_5 = var5_7 /* !! */ .I$0;
                        var1_1 = (ChannelSegment)var5_7 /* !! */ .L$1;
                        var1_1 = (BufferedChannel)var5_7 /* !! */ .L$0;
                        ResultKt.throwOnFailure((Object)var8_8 /* !! */ );
                        var1_1 = var8_8 /* !! */ ;
                        return ((ChannelResult)var1_1).unbox-impl();
                    }
                    case 0: 
                }
                ResultKt.throwOnFailure((Object)var8_8 /* !! */ );
                var5_7 /* !! */ .L$0 = this;
                var5_7 /* !! */ .L$1 = var1_1;
                var5_7 /* !! */ .I$0 = var2_5;
                var5_7 /* !! */ .J$0 = var3_6;
                var5_7 /* !! */ .label = 1;
                var11_10 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(var5_7 /* !! */ ));
                try {
                    Intrinsics.checkNotNull(var11_10, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>");
                    var13_11 = new ReceiveCatching<E>(var11_10);
                    var8_8 /* !! */  = var13_11;
                }
                catch (Throwable var1_3) {
                    // empty catch block
                    break block23;
                }
                try {
                    var14_12 = BufferedChannel.access$updateCellReceive(this, var1_1, var2_5, var3_6, var8_8 /* !! */ );
                    if (var14_12 == BufferedChannelKt.access$getSUSPEND$p()) {
                        BufferedChannel.access$prepareReceiverForSuspension(this, var13_11, var1_1, var2_5);
                        break block24;
                    }
                    var15_13 = BufferedChannelKt.access$getFAILED$p();
                    var9_14 = null;
                    var8_8 /* !! */  = null;
                    var10_15 /* !! */  = null;
                    if (var14_12 == var15_13) {
                    }
                    ** GOTO lbl96
                }
                catch (Throwable var1_2) {
                    break block23;
                }
            }
lbl50:
            // 5 sources

            while (true) {
                var1_1 = var11_10.getResult();
                if (var1_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(var5_7 /* !! */ );
                }
                if (var1_1 != var12_9) return ((ChannelResult)var1_1).unbox-impl();
                return var12_9;
            }
            {
                if (var3_6 < this.getSendersCounter$kotlinx_coroutines_core()) {
                    var1_1.cleanPrev();
                }
                var8_8 /* !! */  = (ChannelSegment)BufferedChannel.access$getReceiveSegment$FU$p().get(this);
                while (true) {
                    block26: {
                        block25: {
                            if (!this.isClosedForReceive()) break block25;
                            BufferedChannel.access$onClosedReceiveCatchingOnNoWaiterSuspend(this, var11_10);
                            ** GOTO lbl50
                        }
                        var6_16 = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(this);
                        var3_6 = var6_16 / (long)BufferedChannelKt.SEGMENT_SIZE;
                        var2_5 = (int)(var6_16 % (long)BufferedChannelKt.SEGMENT_SIZE);
                        var1_1 = var8_8 /* !! */ ;
                        if (var8_8 /* !! */ .id != var3_6 && (var1_1 = BufferedChannel.access$findSegmentReceive(this, var3_6, (ChannelSegment)var8_8 /* !! */ )) == null) continue;
                        var8_8 /* !! */  = BufferedChannel.access$updateCellReceive(this, var1_1, var2_5, var6_16, var13_11);
                        if (var8_8 /* !! */  != BufferedChannelKt.access$getSUSPEND$p()) break block26;
                        var8_8 /* !! */  = var10_15 /* !! */ ;
                        if ((Waiter)var13_11 instanceof Waiter) {
                            var8_8 /* !! */  = var13_11;
                        }
                        if (var8_8 /* !! */  != null) {
                            BufferedChannel.access$prepareReceiverForSuspension(this, var8_8 /* !! */ , (ChannelSegment)var1_1, var2_5);
                        }
                        ** GOTO lbl50
                    }
                    if (var8_8 /* !! */  != BufferedChannelKt.access$getFAILED$p()) break;
                    if (var6_16 < this.getSendersCounter$kotlinx_coroutines_core()) {
                        var1_1.cleanPrev();
                    }
                    var8_8 /* !! */  = var1_1;
                }
                if (var8_8 /* !! */  == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    var1_1 = new IllegalStateException("unexpected".toString());
                    throw var1_1;
                }
                var1_1.cleanPrev();
                var10_15 /* !! */  = ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(var8_8 /* !! */ ));
                var13_11 = this.onUndeliveredElement;
                var1_1 = var9_14;
                if (var13_11 != null) {
                    var1_1 = OnUndeliveredElementKt.bindCancellationFun(var13_11, var8_8 /* !! */ , var11_10.getContext());
                }
                var11_10.resume(var10_15 /* !! */ , (Function1<Throwable, Unit>)var1_1);
                ** GOTO lbl50
lbl96:
                // 1 sources

                var1_1.cleanPrev();
                var9_14 = ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(var14_12));
                var10_15 /* !! */  = this.onUndeliveredElement;
                var1_1 = var8_8 /* !! */ ;
                if (var10_15 /* !! */  != null) {
                    var1_1 = OnUndeliveredElementKt.bindCancellationFun(var10_15 /* !! */ , var14_12, var11_10.getContext());
                }
                var11_10.resume(var9_14, (Function1<Throwable, Unit>)var1_1);
                ** continue;
            }
        }
        var11_10.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        throw var1_4;
    }

    private final <R> R receiveImpl(Object object, Function1<? super E, ? extends R> function1, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function3, Function0<? extends R> function0, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function32) {
        block7: {
            Object object2;
            int n;
            long l;
            Object object3 = (ChannelSegment)BufferedChannel.receiveSegment$FU.get(this);
            while (true) {
                if (this.isClosedForReceive()) {
                    return (R)function0.invoke();
                }
                l = BufferedChannel.receivers$FU.getAndIncrement(this);
                long l2 = l / (long)BufferedChannelKt.SEGMENT_SIZE;
                n = (int)(l % (long)BufferedChannelKt.SEGMENT_SIZE);
                if (((ChannelSegment)object3).id != l2) {
                    object2 = this.findSegmentReceive(l2, (ChannelSegment)object3);
                    if (object2 == null) continue;
                    object3 = object2;
                }
                if ((object2 = this.updateCellReceive((ChannelSegment)object3, n, l, object)) == BufferedChannelKt.access$getSUSPEND$p()) {
                    if ((object = object instanceof Waiter ? (Waiter)object : null) != null) {
                        this.prepareReceiverForSuspension((Waiter)object, (ChannelSegment)object3, n);
                    }
                    object = function3.invoke(object3, (Object)n, (Object)l);
                    break block7;
                }
                if (object2 != BufferedChannelKt.access$getFAILED$p()) break;
                if (l >= this.getSendersCounter$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)object3).cleanPrev();
            }
            if (object2 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                object = function32.invoke(object3, (Object)n, (Object)l);
            } else {
                ((ConcurrentLinkedListNode)object3).cleanPrev();
                object = function1.invoke(object2);
            }
        }
        return (R)object;
    }

    static /* synthetic */ Object receiveImpl$default(BufferedChannel object, Object object2, Function1 function1, Function3 function3, Function0 function0, Function3 object3, int n, Object object4) {
        if (object4 == null) {
            block8: {
                Object object5;
                long l;
                object4 = (n & 0x10) != 0 ? (Function3)receiveImpl.1.INSTANCE : object3;
                object3 = (ChannelSegment)BufferedChannel.receiveSegment$FU.get(object);
                while (true) {
                    if (((BufferedChannel)object).isClosedForReceive()) {
                        return function0.invoke();
                    }
                    l = BufferedChannel.receivers$FU.getAndIncrement(object);
                    long l2 = l / (long)BufferedChannelKt.SEGMENT_SIZE;
                    n = (int)(l % (long)BufferedChannelKt.SEGMENT_SIZE);
                    if (((ChannelSegment)object3).id != l2) {
                        object5 = ((BufferedChannel)object).findSegmentReceive(l2, (ChannelSegment)object3);
                        if (object5 == null) continue;
                        object3 = object5;
                    }
                    if ((object5 = ((BufferedChannel)object).updateCellReceive((ChannelSegment)object3, n, l, object2)) == BufferedChannelKt.access$getSUSPEND$p()) {
                        if ((object2 = object2 instanceof Waiter ? (Waiter)object2 : null) != null) {
                            ((BufferedChannel)object).prepareReceiverForSuspension((Waiter)object2, (ChannelSegment)object3, n);
                        }
                        object = function3.invoke(object3, (Object)n, (Object)l);
                        break block8;
                    }
                    if (object5 != BufferedChannelKt.access$getFAILED$p()) break;
                    if (l >= ((BufferedChannel)object).getSendersCounter$kotlinx_coroutines_core()) continue;
                    ((ConcurrentLinkedListNode)object3).cleanPrev();
                }
                if (object5 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    object = object4.invoke(object3, (Object)n, (Object)l);
                } else {
                    ((ConcurrentLinkedListNode)object3).cleanPrev();
                    object = function1.invoke(object5);
                }
            }
            return object;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final void receiveImplOnNoWaiter(ChannelSegment<E> object, int n, long l, Waiter waiter, Function1<? super E, Unit> function1, Function0<Unit> function0) {
        boolean bl = false;
        Object object2 = this.updateCellReceive((ChannelSegment)object, n, l, waiter);
        if (object2 == BufferedChannelKt.access$getSUSPEND$p()) {
            this.prepareReceiverForSuspension(waiter, (ChannelSegment)object, n);
            return;
        }
        if (object2 == BufferedChannelKt.access$getFAILED$p()) {
            if (l < this.getSendersCounter$kotlinx_coroutines_core()) {
                ((ConcurrentLinkedListNode)object).cleanPrev();
            }
            object = (ChannelSegment)BufferedChannel.receiveSegment$FU.get(this);
            while (true) {
                if (this.isClosedForReceive()) {
                    function0.invoke();
                    return;
                }
                l = BufferedChannel.receivers$FU.getAndIncrement(this);
                long l2 = l / (long)BufferedChannelKt.SEGMENT_SIZE;
                n = (int)(l % (long)BufferedChannelKt.SEGMENT_SIZE);
                if (((ChannelSegment)object).id != l2) {
                    object2 = this.findSegmentReceive(l2, (ChannelSegment)object);
                    if (object2 == null) continue;
                    object = object2;
                }
                if ((object2 = this.updateCellReceive((ChannelSegment)object, n, l, waiter)) == BufferedChannelKt.access$getSUSPEND$p()) {
                    if (!(waiter instanceof Waiter)) {
                        waiter = null;
                    }
                    if (waiter != null) {
                        this.prepareReceiverForSuspension(waiter, (ChannelSegment)object, n);
                    }
                    object = Unit.INSTANCE;
                    return;
                }
                if (object2 != BufferedChannelKt.access$getFAILED$p()) break;
                if (l >= this.getSendersCounter$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)object).cleanPrev();
            }
            if (object2 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) throw new IllegalStateException("unexpected".toString());
            ((ConcurrentLinkedListNode)object).cleanPrev();
            function1.invoke(object2);
            return;
        }
        ((ConcurrentLinkedListNode)object).cleanPrev();
        function1.invoke(object2);
    }

    /*
     * Exception decompiling
     */
    private final Object receiveOnNoWaiterSuspend(ChannelSegment<E> var1_1, int var2_7, long var3_8, Continuation<? super E> var5_9) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 6[TRYBLOCK] [6 : 196->200)] java.lang.Throwable
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

    private final void registerSelectForReceive(SelectInstance<?> object, Object object2) {
        block11: {
            block10: {
                Object object3 = (ChannelSegment)BufferedChannel.receiveSegment$FU.get(this);
                while (true) {
                    if (this.isClosedForReceive()) {
                        this.onClosedSelectOnReceive((SelectInstance<?>)object);
                        break block10;
                    }
                    long l = BufferedChannel.receivers$FU.getAndIncrement(this);
                    long l2 = l / (long)BufferedChannelKt.SEGMENT_SIZE;
                    int n = (int)(l % (long)BufferedChannelKt.SEGMENT_SIZE);
                    object2 = object3;
                    if (((ChannelSegment)object3).id != l2 && (object2 = this.findSegmentReceive(l2, (ChannelSegment)object3)) == null) continue;
                    object3 = this.updateCellReceive((ChannelSegment)object2, n, l, object);
                    if (object3 == BufferedChannelKt.access$getSUSPEND$p()) {
                        if ((object = object instanceof Waiter ? (Waiter)object : null) != null) {
                            this.prepareReceiverForSuspension((Waiter)object, (ChannelSegment)object2, n);
                        }
                        break block10;
                    }
                    if (object3 != BufferedChannelKt.access$getFAILED$p()) break;
                    if (l < this.getSendersCounter$kotlinx_coroutines_core()) {
                        ((ConcurrentLinkedListNode)object2).cleanPrev();
                    }
                    object3 = object2;
                }
                if (object3 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) break block11;
                ((ConcurrentLinkedListNode)object2).cleanPrev();
                object.selectInRegistrationPhase(object3);
            }
            return;
        }
        throw new IllegalStateException("unexpected".toString());
    }

    private final void removeUnprocessedElements(ChannelSegment<E> object) {
        int n;
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        Object object2 = null;
        Object object3 = InlineList.constructor-impl$default(null, 1, null);
        ChannelSegment channelSegment = object;
        object = object2;
        block0: do {
            block1: for (n = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < n; --n) {
                long l = channelSegment.id * (long)BufferedChannelKt.SEGMENT_SIZE + (long)n;
                while ((object2 = channelSegment.getState$kotlinx_coroutines_core(n)) != BufferedChannelKt.access$getDONE_RCV$p()) {
                    if (object2 == BufferedChannelKt.BUFFERED) {
                        if (l < this.getReceiversCounter$kotlinx_coroutines_core()) break block0;
                        if (!channelSegment.casState$kotlinx_coroutines_core(n, object2, BufferedChannelKt.getCHANNEL_CLOSED())) continue;
                        object2 = object;
                        if (function1 != null) {
                            object2 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, channelSegment.getElement$kotlinx_coroutines_core(n), (UndeliveredElementException)object);
                        }
                        channelSegment.cleanElement$kotlinx_coroutines_core(n);
                        channelSegment.onSlotCleaned();
                        object = object2;
                        continue block1;
                    }
                    if (object2 != BufferedChannelKt.access$getIN_BUFFER$p() && object2 != null) {
                        if (!(object2 instanceof Waiter) && !(object2 instanceof WaiterEB)) {
                            if (object2 == BufferedChannelKt.access$getRESUMING_BY_EB$p() || object2 == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) break block0;
                            if (object2 == BufferedChannelKt.access$getRESUMING_BY_EB$p()) continue;
                            continue block1;
                        }
                        if (l < this.getReceiversCounter$kotlinx_coroutines_core()) break block0;
                        Waiter waiter = object2 instanceof WaiterEB ? ((WaiterEB)object2).waiter : (Waiter)object2;
                        if (!channelSegment.casState$kotlinx_coroutines_core(n, object2, BufferedChannelKt.getCHANNEL_CLOSED())) continue;
                        object2 = object;
                        if (function1 != null) {
                            object2 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, channelSegment.getElement$kotlinx_coroutines_core(n), (UndeliveredElementException)object);
                        }
                        object3 = InlineList.plus-FjFbRPM(object3, waiter);
                        channelSegment.cleanElement$kotlinx_coroutines_core(n);
                        channelSegment.onSlotCleaned();
                        object = object2;
                        continue block1;
                    }
                    if (!channelSegment.casState$kotlinx_coroutines_core(n, object2, BufferedChannelKt.getCHANNEL_CLOSED())) continue;
                    channelSegment.onSlotCleaned();
                    continue block1;
                }
                break block0;
            }
        } while ((channelSegment = (ChannelSegment)channelSegment.getPrev()) != null);
        if (object3 != null) {
            if (!(object3 instanceof ArrayList)) {
                this.resumeSenderOnCancelledChannel((Waiter)object3);
            } else {
                Intrinsics.checkNotNull((Object)object3, (String)"null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                object2 = (ArrayList)object3;
                for (n = ((ArrayList)object2).size() - 1; -1 < n; --n) {
                    this.resumeSenderOnCancelledChannel((Waiter)((ArrayList)object2).get(n));
                }
            }
        }
        if (object == null) {
            return;
        }
        throw object;
    }

    private final void resumeReceiverOnClosedChannel(Waiter waiter) {
        this.resumeWaiterOnClosedChannel(waiter, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter waiter) {
        this.resumeWaiterOnClosedChannel(waiter, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter object, boolean bl) {
        block7: {
            block3: {
                block6: {
                    block5: {
                        block4: {
                            block2: {
                                if (!(object instanceof SendBroadcast)) break block2;
                                object = ((SendBroadcast)object).getCont();
                                Result.Companion companion = Result.Companion;
                                object.resumeWith(Result.constructor-impl((Object)false));
                                break block3;
                            }
                            if (!(object instanceof CancellableContinuation)) break block4;
                            Continuation continuation = (Continuation)object;
                            object = Result.Companion;
                            object = bl ? this.getReceiveException() : this.getSendException();
                            continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)object)));
                            break block3;
                        }
                        if (!(object instanceof ReceiveCatching)) break block5;
                        object = ((ReceiveCatching)object).cont;
                        Result.Companion companion = Result.Companion;
                        object.resumeWith(Result.constructor-impl((Object)ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause()))));
                        break block3;
                    }
                    if (!(object instanceof BufferedChannelIterator)) break block6;
                    ((BufferedChannelIterator)object).tryResumeHasNextOnClosedChannel();
                    break block3;
                }
                if (!(object instanceof SelectInstance)) break block7;
                ((SelectInstance)object).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
            }
            return;
        }
        throw new IllegalStateException(("Unexpected waiter: " + object).toString());
    }

    static /* synthetic */ <E> Object send$suspendImpl(BufferedChannel<E> object, E e, Continuation<? super Unit> continuation) {
        ChannelSegment channelSegment = (ChannelSegment)BufferedChannel.sendSegment$FU.get(object);
        block8: while (true) {
            long l = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(object);
            long l2 = l & 0xFFFFFFFFFFFFFFFL;
            boolean bl = ((BufferedChannel)object).isClosedForSend0(l);
            l = l2 / (long)BufferedChannelKt.SEGMENT_SIZE;
            int n = (int)(l2 % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != l) {
                ChannelSegment channelSegment2 = ((BufferedChannel)object).findSegmentSend(l, channelSegment);
                if (channelSegment2 == null) {
                    if (!bl) continue;
                    if ((object = super.onClosedSend(e, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) break;
                    return object;
                }
                channelSegment = channelSegment2;
            }
            switch (((BufferedChannel)object).updateCellSend(channelSegment, n, e, l2, null, bl)) {
                default: {
                    continue block8;
                }
                case 5: {
                    channelSegment.cleanPrev();
                    continue block8;
                }
                case 4: {
                    if (l2 < ((BufferedChannel)object).getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    if ((object = super.onClosedSend(e, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) break block8;
                    return object;
                }
                case 3: {
                    object = super.sendOnNoWaiterSuspend(channelSegment, n, e, l2, continuation);
                    if (object != IntrinsicsKt.getCOROUTINE_SUSPENDED()) break block8;
                    return object;
                }
                case 2: {
                    if (bl) {
                        channelSegment.onSlotCleaned();
                        object = super.onClosedSend(e, continuation);
                        if (object != IntrinsicsKt.getCOROUTINE_SUSPENDED()) break block8;
                        return object;
                    }
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        throw new AssertionError();
                    }
                    break block8;
                }
                case 1: {
                    break block8;
                }
                case 0: {
                    channelSegment.cleanPrev();
                }
            }
            break;
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ <E> Object sendBroadcast$suspendImpl(BufferedChannel<E> object, E object2, Continuation<? super Boolean> continuation) {
        boolean bl = false;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        int n = object.onUndeliveredElement == null ? 1 : 0;
        if (n != 0) {
            SendBroadcast sendBroadcast = new SendBroadcast(cancellableContinuation);
            ChannelSegment channelSegment = (ChannelSegment)BufferedChannel.sendSegment$FU.get(object);
            block8: while (true) {
                long l = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(object);
                long l2 = l & 0xFFFFFFFFFFFFFFFL;
                boolean bl2 = ((BufferedChannel)object).isClosedForSend0(l);
                l = l2 / (long)BufferedChannelKt.SEGMENT_SIZE;
                n = (int)(l2 % (long)BufferedChannelKt.SEGMENT_SIZE);
                if (channelSegment.id != l) {
                    ChannelSegment channelSegment2 = ((BufferedChannel)object).findSegmentSend(l, channelSegment);
                    if (channelSegment2 == null) {
                        if (!bl2) continue;
                        object = cancellableContinuation;
                        object2 = Result.Companion;
                        object.resumeWith(Result.constructor-impl((Object)Boxing.boxBoolean((boolean)false)));
                        break;
                    }
                    channelSegment = channelSegment2;
                }
                switch (((BufferedChannel)object).updateCellSend(channelSegment, n, object2, l2, sendBroadcast, bl2)) {
                    default: {
                        continue block8;
                    }
                    case 5: {
                        channelSegment.cleanPrev();
                        continue block8;
                    }
                    case 4: {
                        if (l2 < object.getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        object = cancellableContinuation;
                        object2 = Result.Companion;
                        object.resumeWith(Result.constructor-impl((Object)Boxing.boxBoolean((boolean)false)));
                        break block8;
                    }
                    case 3: {
                        throw new IllegalStateException("unexpected".toString());
                    }
                    case 2: {
                        if (bl2) {
                            channelSegment.onSlotCleaned();
                            object2 = cancellableContinuation;
                            object = Result.Companion;
                            object2.resumeWith(Result.constructor-impl((Object)Boxing.boxBoolean((boolean)false)));
                            break block8;
                        }
                        object2 = sendBroadcast instanceof Waiter ? (Waiter)sendBroadcast : null;
                        if (object2 == null) break block8;
                        ((BufferedChannel)object).prepareSenderForSuspension(object2, channelSegment, n);
                        break block8;
                    }
                    case 1: {
                        object = cancellableContinuation;
                        object2 = Result.Companion;
                        object.resumeWith(Result.constructor-impl((Object)Boxing.boxBoolean((boolean)true)));
                        break block8;
                    }
                    case 0: {
                        channelSegment.cleanPrev();
                        object2 = cancellableContinuation;
                        object = Result.Companion;
                        object2.resumeWith(Result.constructor-impl((Object)Boxing.boxBoolean((boolean)true)));
                    }
                }
                break;
            }
            object = cancellableContinuationImpl.getResult();
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return object;
        }
        throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`".toString());
    }

    public static /* synthetic */ Object sendImpl$default(BufferedChannel bufferedChannel, Object object, Object object2, Function0 function0, Function2 function2, Function0 function02, Function4 object3, int n, Object object4) {
        if (object4 == null) {
            object4 = (n & 0x20) != 0 ? (Function4)sendImpl.1.INSTANCE : object3;
            object3 = (ChannelSegment)BufferedChannel.sendSegment$FU.get(bufferedChannel);
            block8: while (true) {
                long l = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(bufferedChannel);
                long l2 = l & 0xFFFFFFFFFFFFFFFL;
                boolean bl = bufferedChannel.isClosedForSend0(l);
                l = l2 / (long)BufferedChannelKt.SEGMENT_SIZE;
                n = (int)(l2 % (long)BufferedChannelKt.SEGMENT_SIZE);
                if (((ChannelSegment)object3).id != l) {
                    ChannelSegment channelSegment = bufferedChannel.findSegmentSend(l, (ChannelSegment)object3);
                    if (channelSegment == null) {
                        if (!bl) continue;
                        return function02.invoke();
                    }
                    object3 = channelSegment;
                }
                switch (bufferedChannel.updateCellSend((ChannelSegment)object3, n, object, l2, object2, bl)) {
                    default: {
                        continue block8;
                    }
                    case 5: {
                        ((ConcurrentLinkedListNode)object3).cleanPrev();
                        continue block8;
                    }
                    case 4: {
                        if (l2 < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                            ((ConcurrentLinkedListNode)object3).cleanPrev();
                        }
                        return function02.invoke();
                    }
                    case 3: {
                        return object4.invoke(object3, (Object)n, object, (Object)l2);
                    }
                    case 2: {
                        if (bl) {
                            ((Segment)object3).onSlotCleaned();
                            return function02.invoke();
                        }
                        object = object2 instanceof Waiter ? (Waiter)object2 : null;
                        if (object != null) {
                            bufferedChannel.prepareSenderForSuspension((Waiter)object, (ChannelSegment)object3, n);
                        }
                        return function2.invoke(object3, (Object)n);
                    }
                    case 1: {
                        return function0.invoke();
                    }
                    case 0: 
                }
                break;
            }
            ((ConcurrentLinkedListNode)object3).cleanPrev();
            return function0.invoke();
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
    }

    private final void sendImplOnNoWaiter(ChannelSegment<E> channelSegment, int n, E object, long l, Waiter waiter, Function0<Unit> function0, Function0<Unit> function02) {
        boolean bl = false;
        block0 : switch (this.updateCellSend(channelSegment, n, object, l, waiter, false)) {
            default: {
                throw new IllegalStateException("unexpected".toString());
            }
            case 5: {
                channelSegment.cleanPrev();
                channelSegment = (ChannelSegment)BufferedChannel.sendSegment$FU.get(this);
                block15: while (true) {
                    long l2 = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this);
                    l = l2 & 0xFFFFFFFFFFFFFFFL;
                    boolean bl2 = this.isClosedForSend0(l2);
                    l2 = l / (long)BufferedChannelKt.SEGMENT_SIZE;
                    n = (int)(l % (long)BufferedChannelKt.SEGMENT_SIZE);
                    if (channelSegment.id != l2) {
                        ChannelSegment channelSegment2 = this.findSegmentSend(l2, channelSegment);
                        if (channelSegment2 == null) {
                            if (!bl2) continue;
                            function02.invoke();
                            break block0;
                        }
                        channelSegment = channelSegment2;
                    }
                    switch (this.updateCellSend(channelSegment, n, object, l, waiter, bl2)) {
                        default: {
                            continue block15;
                        }
                        case 5: {
                            channelSegment.cleanPrev();
                            continue block15;
                        }
                        case 4: {
                            if (l < this.getReceiversCounter$kotlinx_coroutines_core()) {
                                channelSegment.cleanPrev();
                            }
                            function02.invoke();
                            break block0;
                        }
                        case 3: {
                            throw new IllegalStateException("unexpected".toString());
                        }
                        case 2: {
                            if (bl2) {
                                channelSegment.onSlotCleaned();
                                function02.invoke();
                                break block0;
                            }
                            object = waiter instanceof Waiter ? waiter : null;
                            if (object != null) {
                                this.prepareSenderForSuspension(object, channelSegment, n);
                            }
                            channelSegment = Unit.INSTANCE;
                            break block0;
                        }
                        case 1: {
                            function0.invoke();
                            break block0;
                        }
                        case 0: 
                    }
                    break;
                }
                channelSegment.cleanPrev();
                function0.invoke();
                break;
            }
            case 4: {
                if (l < this.getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                function02.invoke();
                break;
            }
            case 2: {
                this.prepareSenderForSuspension(waiter, channelSegment, n);
                break;
            }
            case 1: {
                function0.invoke();
                break;
            }
            case 0: {
                channelSegment.cleanPrev();
                function0.invoke();
            }
        }
    }

    /*
     * Exception decompiling
     */
    private final Object sendOnNoWaiterSuspend(ChannelSegment<E> var1_1, int var2_9, E var3_10, long var4_11, Continuation<? super Unit> var6_12) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 19[TRYBLOCK] [29 : 609->621)] java.lang.Throwable
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

    private final boolean shouldSendSuspend(long l) {
        if (this.isClosedForSend0(l)) {
            return false;
        }
        return this.bufferOrRendezvousSend(l & 0xFFFFFFFFFFFFFFFL) ^ true;
    }

    private final boolean tryResumeReceiver(Object object, E e) {
        block9: {
            boolean bl;
            block6: {
                Function1<Throwable, Unit> function1;
                Object object2;
                block8: {
                    block7: {
                        block5: {
                            if (!(object instanceof SelectInstance)) break block5;
                            bl = ((SelectInstance)object).trySelect(this, e);
                            break block6;
                        }
                        bl = object instanceof ReceiveCatching;
                        object2 = null;
                        function1 = null;
                        if (!bl) break block7;
                        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
                        object2 = (ReceiveCatching)object;
                        object2 = ((ReceiveCatching)object).cont;
                        ChannelResult channelResult = ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(e));
                        Function1<E, Unit> function12 = this.onUndeliveredElement;
                        if (function12 != null) {
                            function1 = OnUndeliveredElementKt.bindCancellationFun(function12, e, ((ReceiveCatching)object).cont.getContext());
                        }
                        bl = BufferedChannelKt.access$tryResume0((CancellableContinuation)object2, channelResult, (Function1)function1);
                        break block6;
                    }
                    if (!(object instanceof BufferedChannelIterator)) break block8;
                    Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
                    function1 = (BufferedChannelIterator)object;
                    bl = ((BufferedChannelIterator)object).tryResumeHasNext(e);
                    break block6;
                }
                if (!(object instanceof CancellableContinuation)) break block9;
                Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
                function1 = (CancellableContinuation)object;
                CancellableContinuation cancellableContinuation = (CancellableContinuation)object;
                Function1<E, Unit> function13 = this.onUndeliveredElement;
                function1 = object2;
                if (function13 != null) {
                    function1 = OnUndeliveredElementKt.bindCancellationFun(function13, e, ((CancellableContinuation)object).getContext());
                }
                bl = BufferedChannelKt.access$tryResume0(cancellableContinuation, e, (Function1)function1);
            }
            return bl;
        }
        throw new IllegalStateException(("Unexpected receiver type: " + object).toString());
    }

    private final boolean tryResumeSender(Object object, ChannelSegment<E> object2, int n) {
        block7: {
            boolean bl;
            block5: {
                block6: {
                    block4: {
                        if (!(object instanceof CancellableContinuation)) break block4;
                        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                        object2 = (CancellableContinuation)object;
                        bl = BufferedChannelKt.tryResume0$default((CancellableContinuation)object, Unit.INSTANCE, null, 2, null);
                        break block5;
                    }
                    if (!(object instanceof SelectInstance)) break block6;
                    Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
                    SelectImplementation selectImplementation = (SelectImplementation)object;
                    object = ((SelectImplementation)object).trySelectDetailed(this, Unit.INSTANCE);
                    if (object == TrySelectDetailedResult.REREGISTER) {
                        ((ChannelSegment)object2).cleanElement$kotlinx_coroutines_core(n);
                    }
                    bl = object == TrySelectDetailedResult.SUCCESSFUL;
                    break block5;
                }
                if (!(object instanceof SendBroadcast)) break block7;
                bl = BufferedChannelKt.tryResume0$default(((SendBroadcast)object).getCont(), true, null, 2, null);
            }
            return bl;
        }
        throw new IllegalStateException(("Unexpected waiter: " + object).toString());
    }

    private final void update$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1, Object object) {
        long l;
        while (!atomicLongFieldUpdater.compareAndSet(object, l = atomicLongFieldUpdater.get(object), ((Number)function1.invoke((Object)l)).longValue())) {
        }
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> channelSegment, int n, long l) {
        Object object = channelSegment.getState$kotlinx_coroutines_core(n);
        if (object instanceof Waiter && l >= receivers$FU.get(this) && channelSegment.casState$kotlinx_coroutines_core(n, object, BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
            boolean bl;
            if (this.tryResumeSender(object, channelSegment, n)) {
                channelSegment.setState$kotlinx_coroutines_core(n, BufferedChannelKt.BUFFERED);
                bl = true;
            } else {
                channelSegment.setState$kotlinx_coroutines_core(n, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                bl = false;
                channelSegment.onCancelledRequest(n, false);
            }
            return bl;
        }
        return this.updateCellExpandBufferSlow(channelSegment, n, l);
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> channelSegment, int n, long l) {
        block9: {
            Object object;
            while (true) {
                object = channelSegment.getState$kotlinx_coroutines_core(n);
                boolean bl = object instanceof Waiter;
                boolean bl2 = false;
                if (bl) {
                    if (l < receivers$FU.get(this)) {
                        if (!channelSegment.casState$kotlinx_coroutines_core(n, object, new WaiterEB((Waiter)object))) continue;
                        return true;
                    }
                    if (!channelSegment.casState$kotlinx_coroutines_core(n, object, BufferedChannelKt.access$getRESUMING_BY_EB$p())) continue;
                    if (this.tryResumeSender(object, channelSegment, n)) {
                        channelSegment.setState$kotlinx_coroutines_core(n, BufferedChannelKt.BUFFERED);
                        bl2 = true;
                    } else {
                        channelSegment.setState$kotlinx_coroutines_core(n, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                        channelSegment.onCancelledRequest(n, false);
                    }
                    return bl2;
                }
                if (object == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) {
                    return false;
                }
                if (object == null) {
                    if (!channelSegment.casState$kotlinx_coroutines_core(n, object, BufferedChannelKt.access$getIN_BUFFER$p())) continue;
                    return true;
                }
                if (object == BufferedChannelKt.BUFFERED) {
                    return true;
                }
                if (object == BufferedChannelKt.access$getPOISONED$p() || object == BufferedChannelKt.access$getDONE_RCV$p() || object == BufferedChannelKt.access$getINTERRUPTED_RCV$p()) break block9;
                if (object == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return true;
                }
                if (object != BufferedChannelKt.access$getRESUMING_BY_RCV$p()) break;
            }
            throw new IllegalStateException(("Unexpected cell state: " + object).toString());
        }
        return true;
    }

    private final Object updateCellReceive(ChannelSegment<E> channelSegment, int n, long l, Object object) {
        Object object2 = channelSegment.getState$kotlinx_coroutines_core(n);
        if (object2 == null) {
            long l2 = sendersAndCloseStatus$FU.get(this);
            if (l >= (l2 & 0xFFFFFFFFFFFFFFFL)) {
                if (object == null) {
                    return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
                }
                if (channelSegment.casState$kotlinx_coroutines_core(n, object2, object)) {
                    this.expandBuffer();
                    return BufferedChannelKt.access$getSUSPEND$p();
                }
            }
        } else if (object2 == BufferedChannelKt.BUFFERED && channelSegment.casState$kotlinx_coroutines_core(n, object2, BufferedChannelKt.access$getDONE_RCV$p())) {
            this.expandBuffer();
            return channelSegment.retrieveElement$kotlinx_coroutines_core(n);
        }
        return this.updateCellReceiveSlow(channelSegment, n, l, object);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> object, int n, long l, Object object2) {
        while (true) {
            Object object3;
            if ((object3 = ((ChannelSegment)object).getState$kotlinx_coroutines_core(n)) != null && object3 != BufferedChannelKt.access$getIN_BUFFER$p()) {
                if (object3 == BufferedChannelKt.BUFFERED) {
                    if (!((ChannelSegment)object).casState$kotlinx_coroutines_core(n, object3, BufferedChannelKt.access$getDONE_RCV$p())) continue;
                    this.expandBuffer();
                    return ((ChannelSegment)object).retrieveElement$kotlinx_coroutines_core(n);
                }
                if (object3 == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) {
                    return BufferedChannelKt.access$getFAILED$p();
                }
                if (object3 == BufferedChannelKt.access$getPOISONED$p()) {
                    return BufferedChannelKt.access$getFAILED$p();
                }
                if (object3 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    this.expandBuffer();
                    return BufferedChannelKt.access$getFAILED$p();
                }
                if (object3 == BufferedChannelKt.access$getRESUMING_BY_EB$p() || !((ChannelSegment)object).casState$kotlinx_coroutines_core(n, object3, BufferedChannelKt.access$getRESUMING_BY_RCV$p())) continue;
                boolean bl = object3 instanceof WaiterEB;
                object2 = object3 instanceof WaiterEB ? ((WaiterEB)object3).waiter : object3;
                if (this.tryResumeSender(object2, (ChannelSegment<E>)object, n)) {
                    ((ChannelSegment)object).setState$kotlinx_coroutines_core(n, BufferedChannelKt.access$getDONE_RCV$p());
                    this.expandBuffer();
                    object = ((ChannelSegment)object).retrieveElement$kotlinx_coroutines_core(n);
                } else {
                    ((ChannelSegment)object).setState$kotlinx_coroutines_core(n, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                    ((ChannelSegment)object).onCancelledRequest(n, false);
                    if (bl) {
                        this.expandBuffer();
                    }
                    object = BufferedChannelKt.access$getFAILED$p();
                }
                return object;
            }
            long l2 = sendersAndCloseStatus$FU.get(this);
            if (l < (l2 & 0xFFFFFFFFFFFFFFFL)) {
                if (!((ChannelSegment)object).casState$kotlinx_coroutines_core(n, object3, BufferedChannelKt.access$getPOISONED$p())) continue;
                this.expandBuffer();
                return BufferedChannelKt.access$getFAILED$p();
            }
            if (object2 == null) {
                return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
            }
            if (((ChannelSegment)object).casState$kotlinx_coroutines_core(n, object3, object2)) break;
        }
        this.expandBuffer();
        return BufferedChannelKt.access$getSUSPEND$p();
    }

    private final int updateCellSend(ChannelSegment<E> channelSegment, int n, E e, long l, Object object, boolean bl) {
        channelSegment.storeElement$kotlinx_coroutines_core(n, e);
        if (bl) {
            return this.updateCellSendSlow(channelSegment, n, e, l, object, bl);
        }
        Object object2 = channelSegment.getState$kotlinx_coroutines_core(n);
        if (object2 == null) {
            if (this.bufferOrRendezvousSend(l)) {
                if (channelSegment.casState$kotlinx_coroutines_core(n, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (object == null) {
                    return 3;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(n, null, object)) {
                    return 2;
                }
            }
        } else if (object2 instanceof Waiter) {
            channelSegment.cleanElement$kotlinx_coroutines_core(n);
            if (this.tryResumeReceiver(object2, e)) {
                channelSegment.setState$kotlinx_coroutines_core(n, BufferedChannelKt.access$getDONE_RCV$p());
                this.onReceiveDequeued();
                n = 0;
            } else {
                if (channelSegment.getAndSetState$kotlinx_coroutines_core(n, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                    channelSegment.onCancelledRequest(n, true);
                }
                n = 5;
            }
            return n;
        }
        return this.updateCellSendSlow(channelSegment, n, e, l, object, bl);
    }

    private final int updateCellSendSlow(ChannelSegment<E> channelSegment, int n, E e, long l, Object object, boolean bl) {
        int n2;
        Object object2;
        block13: {
            while (true) {
                object2 = channelSegment.getState$kotlinx_coroutines_core(n);
                n2 = 0;
                if (object2 == null) {
                    if (this.bufferOrRendezvousSend(l) && !bl) {
                        if (!channelSegment.casState$kotlinx_coroutines_core(n, null, BufferedChannelKt.BUFFERED)) continue;
                        return 1;
                    }
                    if (bl) {
                        if (!channelSegment.casState$kotlinx_coroutines_core(n, null, BufferedChannelKt.access$getINTERRUPTED_SEND$p())) continue;
                        channelSegment.onCancelledRequest(n, false);
                        return 4;
                    }
                    if (object == null) {
                        return 3;
                    }
                    if (!channelSegment.casState$kotlinx_coroutines_core(n, null, object)) continue;
                    return 2;
                }
                if (object2 != BufferedChannelKt.access$getIN_BUFFER$p()) break block13;
                if (channelSegment.casState$kotlinx_coroutines_core(n, object2, BufferedChannelKt.BUFFERED)) break;
            }
            return 1;
        }
        if (object2 == BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
            channelSegment.cleanElement$kotlinx_coroutines_core(n);
            return 5;
        }
        if (object2 == BufferedChannelKt.access$getPOISONED$p()) {
            channelSegment.cleanElement$kotlinx_coroutines_core(n);
            return 5;
        }
        if (object2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            channelSegment.cleanElement$kotlinx_coroutines_core(n);
            this.completeCloseOrCancel();
            return 4;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = object2 instanceof Waiter || object2 instanceof WaiterEB;
            if (!bl2) {
                throw new AssertionError();
            }
        }
        channelSegment.cleanElement$kotlinx_coroutines_core(n);
        object = object2 instanceof WaiterEB ? ((WaiterEB)object2).waiter : object2;
        if (this.tryResumeReceiver(object, e)) {
            channelSegment.setState$kotlinx_coroutines_core(n, BufferedChannelKt.access$getDONE_RCV$p());
            this.onReceiveDequeued();
            n = n2;
        } else {
            if (channelSegment.getAndSetState$kotlinx_coroutines_core(n, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                channelSegment.onCancelledRequest(n, true);
            }
            n = 5;
        }
        return n;
    }

    private final void updateReceiversCounterIfLower(long l) {
        long l2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
        do {
            if ((l2 = atomicLongFieldUpdater.get(this)) < l) continue;
            return;
        } while (!receivers$FU.compareAndSet(this, l2, l));
    }

    private final void updateSendersCounterIfLower(long l) {
        long l2;
        long l3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            if ((l2 = (l3 = atomicLongFieldUpdater.get(this)) & 0xFFFFFFFFFFFFFFFL) < l) continue;
            return;
        } while (!sendersAndCloseStatus$FU.compareAndSet(this, l3, l2 = BufferedChannelKt.access$constructSendersAndCloseStatus(l2, (int)(l3 >> 60))));
    }

    @Override
    public final void cancel() {
        this.cancelImpl$kotlinx_coroutines_core(null);
    }

    @Override
    public final void cancel(CancellationException cancellationException) {
        this.cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    @Override
    public final boolean cancel(Throwable throwable) {
        return this.cancelImpl$kotlinx_coroutines_core(throwable);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable throwable) {
        block0: {
            if (throwable != null) break block0;
            throwable = new CancellationException("Channel was cancelled");
        }
        return this.closeOrCancelImpl(throwable, true);
    }

    /*
     * Unable to fully structure code
     */
    public final void checkSegmentStructureInvariants() {
        block16: {
            block17: {
                block18: {
                    block15: {
                        block14: {
                            if (!this.isRendezvousOrUnlimited()) break block14;
                            var1_1 = BufferedChannel.bufferEndSegment$FU.get(this) == BufferedChannelKt.access$getNULL_SEGMENT$p() ? 1 : 0;
                            if (var1_1 == 0) {
                                var12_2 = new StringBuilder().append("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: ");
                                throw new IllegalStateException(var12_2.append(this).toString().toString());
                            }
                            break block15;
                        }
                        var1_1 = ((ChannelSegment)BufferedChannel.receiveSegment$FU.get(this)).id <= ((ChannelSegment)BufferedChannel.bufferEndSegment$FU.get(this)).id ? 1 : 0;
                        if (var1_1 == 0) break block16;
                    }
                    var13_5 = CollectionsKt.listOf((Object[])new ChannelSegment[]{BufferedChannel.receiveSegment$FU.get(this), BufferedChannel.sendSegment$FU.get(this), BufferedChannel.bufferEndSegment$FU.get(this)});
                    var12_3 = new ArrayList<E>();
                    var14_6 = var13_5.iterator();
                    while (var14_6.hasNext()) {
                        var13_5 = var14_6.next();
                        var1_1 = (ChannelSegment)var13_5 != BufferedChannelKt.access$getNULL_SEGMENT$p() ? 1 : 0;
                        if (var1_1 == 0) continue;
                        var12_3.add(var13_5);
                    }
                    var15_7 = ((Iterable)(var12_3 = (List)var12_3)).iterator();
                    if (!var15_7.hasNext()) break block17;
                    var13_5 = var15_7.next();
                    if (!var15_7.hasNext()) {
                        var12_3 = var13_5;
                    } else {
                        var6_8 = ((ChannelSegment)var13_5).id;
                        do {
                            var14_6 = var15_7.next();
                            var10_10 = ((ChannelSegment)var14_6).id;
                            var12_3 = var13_5;
                            var8_9 = var6_8;
                            if (var6_8 > var10_10) {
                                var12_3 = var14_6;
                                var8_9 = var10_10;
                            }
                            var13_5 = var12_3;
                            var6_8 = var8_9;
                        } while (var15_7.hasNext());
                    }
                    var12_3 = (ChannelSegment)var12_3;
                    var1_1 = var12_3.getPrev() == null ? 1 : 0;
                    if (var1_1 == 0) break block18;
                    while (var12_3.getNext() != null) {
                        block19: {
                            var13_5 = var12_3.getNext();
                            Intrinsics.checkNotNull((Object)var13_5);
                            if (((ChannelSegment)var13_5).getPrev() == null) ** GOTO lbl-1000
                            var13_5 = var12_3.getNext();
                            Intrinsics.checkNotNull((Object)var13_5);
                            if (((ChannelSegment)var13_5).getPrev() != var12_3) {
                                var1_1 = 0;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var1_1 = 1;
                            }
                            if (var1_1 == 0) break block19;
                            var2_11 = 0;
                            var4_13 = BufferedChannelKt.SEGMENT_SIZE;
                            for (var1_1 = 0; var1_1 < var4_13; ++var1_1) {
                                block20: {
                                    block21: {
                                        block22: {
                                            var13_5 = var12_3.getState$kotlinx_coroutines_core(var1_1);
                                            var3_12 = var2_11;
                                            if (Intrinsics.areEqual((Object)var13_5, (Object)BufferedChannelKt.BUFFERED)) break block20;
                                            var3_12 = var2_11;
                                            if (var13_5 instanceof Waiter) break block20;
                                            var5_14 = Intrinsics.areEqual((Object)var13_5, (Object)BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != false ? true : Intrinsics.areEqual((Object)var13_5, (Object)BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                                            if (!(var5_14 = var5_14 != false ? true : Intrinsics.areEqual((Object)var13_5, (Object)BufferedChannelKt.getCHANNEL_CLOSED()))) break block21;
                                            var3_12 = var12_3.getElement$kotlinx_coroutines_core(var1_1) == null ? 1 : 0;
                                            if (var3_12 == 0) break block22;
                                            var3_12 = var2_11 + 1;
                                            break block20;
                                        }
                                        throw new IllegalStateException("Check failed.".toString());
                                    }
                                    var5_14 = Intrinsics.areEqual((Object)var13_5, (Object)BufferedChannelKt.access$getPOISONED$p()) != false ? true : Intrinsics.areEqual((Object)var13_5, (Object)BufferedChannelKt.access$getDONE_RCV$p());
                                    if (!var5_14) ** GOTO lbl77
                                    var3_12 = var12_3.getElement$kotlinx_coroutines_core(var1_1) == null ? 1 : 0;
                                    if (var3_12 != 0) {
                                        var3_12 = var2_11;
                                    } else {
                                        throw new IllegalStateException("Check failed.".toString());
lbl77:
                                        // 1 sources

                                        throw new IllegalStateException(("Unexpected segment cell state: " + var13_5 + ".\nChannel state: " + this).toString());
                                    }
                                }
                                var2_11 = var3_12;
                            }
                            if (var2_11 == BufferedChannelKt.SEGMENT_SIZE) {
                                var1_1 = var12_3 != BufferedChannel.receiveSegment$FU.get(this) && var12_3 != BufferedChannel.sendSegment$FU.get(this) && var12_3 != BufferedChannel.bufferEndSegment$FU.get(this) ? 0 : 1;
                                if (var1_1 == 0) {
                                    throw new IllegalStateException(("Logically removed segment is reachable.\nChannel state: " + this).toString());
                                }
                            }
                            var12_3 = var12_3.getNext();
                            Intrinsics.checkNotNull((Object)var12_3);
                            var12_3 = (ChannelSegment)var12_3;
                            continue;
                        }
                        var12_3 = new StringBuilder().append("The `segment.next.prev === segment` invariant is violated.\nChannel state: ");
                        throw new IllegalStateException(var12_3.append(this).toString().toString());
                    }
                    return;
                }
                var12_3 = new StringBuilder().append("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: ");
                throw new IllegalStateException(var12_3.append(this).toString().toString());
            }
            throw new NoSuchElementException();
        }
        var12_4 = new StringBuilder().append("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: ");
        throw new IllegalStateException(var12_4.append(this).toString().toString());
    }

    @Override
    public boolean close(Throwable throwable) {
        return this.closeOrCancelImpl(throwable, false);
    }

    protected boolean closeOrCancelImpl(Throwable throwable, boolean bl) {
        if (bl) {
            this.markCancellationStarted();
        }
        boolean bl2 = AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_closeCause$FU, this, BufferedChannelKt.access$getNO_CLOSE_CAUSE$p(), throwable);
        if (bl) {
            this.markCancelled();
        } else {
            this.markClosed();
        }
        this.completeCloseOrCancel();
        this.onClosedIdempotent();
        if (bl2) {
            this.invokeCloseHandler();
        }
        return bl2;
    }

    protected final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long l) {
        if (DebugKt.getASSERTIONS_ENABLED() && !this.isConflatedDropOldest()) {
            throw new AssertionError();
        }
        Object object = (ChannelSegment<E>)receiveSegment$FU.get(this);
        while (true) {
            long l2;
            if (l < Math.max((long)this.capacity + (l2 = receivers$FU.get(this)), this.getBufferEndCounter())) {
                return;
            }
            if (!receivers$FU.compareAndSet(this, l2, l2 + 1L)) continue;
            long l3 = l2 / (long)BufferedChannelKt.SEGMENT_SIZE;
            int n = (int)(l2 % (long)BufferedChannelKt.SEGMENT_SIZE);
            ChannelSegment<E> channelSegment = object;
            if (((ChannelSegment)object).id != l3 && (channelSegment = this.findSegmentReceive(l3, (ChannelSegment<E>)object)) == null) continue;
            Object object2 = this.updateCellReceive(channelSegment, n, l2, null);
            if (object2 == BufferedChannelKt.access$getFAILED$p()) {
                object = channelSegment;
                if (l2 >= this.getSendersCounter$kotlinx_coroutines_core()) continue;
                channelSegment.cleanPrev();
                object = channelSegment;
                continue;
            }
            channelSegment.cleanPrev();
            Function1<E, Unit> function1 = this.onUndeliveredElement;
            object = channelSegment;
            if (function1 == null) continue;
            object = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, object2, null, 2, null);
            if (object != null) break;
            object = channelSegment;
        }
        throw object;
    }

    protected final Throwable getCloseCause() {
        return (Throwable)_closeCause$FU.get(this);
    }

    @Override
    public SelectClause1<E> getOnReceive() {
        onReceive.1 var1_1 = onReceive.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var1_1), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        var1_1 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var1_1), (int)3);
        onReceive.2 var2_2 = onReceive.2.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var2_2), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, var1_1, (Function3<Object, Object, Object, ? extends Object>)((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var2_2), (int)3)), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        onReceiveCatching.1 var1_1 = onReceiveCatching.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var1_1), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        var1_1 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var1_1), (int)3);
        onReceiveCatching.2 var2_2 = onReceiveCatching.2.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var2_2), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, var1_1, (Function3<Object, Object, Object, ? extends Object>)((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var2_2), (int)3)), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override
    public SelectClause1<E> getOnReceiveOrNull() {
        onReceiveOrNull.1 var1_1 = onReceiveOrNull.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var1_1), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        var1_1 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var1_1), (int)3);
        onReceiveOrNull.2 var2_2 = onReceiveOrNull.2.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var2_2), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, var1_1, (Function3<Object, Object, Object, ? extends Object>)((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var2_2), (int)3)), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override
    public SelectClause2<E, BufferedChannel<E>> getOnSend() {
        onSend.1 var1_1 = onSend.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var1_1), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        var1_1 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var1_1), (int)3);
        onSend.2 var2_2 = onSend.2.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var2_2), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, var1_1, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var2_2), (int)3), null, 8, null);
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$FU.get(this);
    }

    protected final Throwable getSendException() {
        Throwable throwable;
        Throwable throwable2 = throwable = this.getCloseCause();
        if (throwable == null) {
            throwable2 = new ClosedSendChannelException("Channel was closed");
        }
        return throwable2;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$FU.get(this) & 0xFFFFFFFFFFFFFFFL;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            ChannelSegment<E> channelSegment = (ChannelSegment<E>)receiveSegment$FU.get(this);
            long l = this.getReceiversCounter$kotlinx_coroutines_core();
            if (this.getSendersCounter$kotlinx_coroutines_core() <= l) {
                return false;
            }
            long l2 = l / (long)BufferedChannelKt.SEGMENT_SIZE;
            ChannelSegment<E> channelSegment2 = channelSegment;
            if (channelSegment.id != l2 && (channelSegment2 = this.findSegmentReceive(l2, channelSegment)) == null) {
                if (((ChannelSegment)BufferedChannel.receiveSegment$FU.get(this)).id >= l2) continue;
                return false;
            }
            channelSegment2.cleanPrev();
            if (this.isCellNonEmpty(channelSegment2, (int)(l % (long)BufferedChannelKt.SEGMENT_SIZE), l)) {
                return true;
            }
            receivers$FU.compareAndSet(this, l, l + 1L);
        }
    }

    @Override
    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        Object v;
        if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$FU, this, null, function1)) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$FU;
        while ((v = atomicReferenceFieldUpdater.get(this)) == BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p()) {
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$FU, this, BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p(), BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p())) continue;
            function1.invoke((Object)this.getCloseCause());
            return;
        }
        if (v == BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()) {
            throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
        }
        throw new IllegalStateException(("Another handler is already registered: " + v).toString());
    }

    @Override
    public boolean isClosedForReceive() {
        return this.isClosedForReceive0(sendersAndCloseStatus$FU.get(this));
    }

    @Override
    public boolean isClosedForSend() {
        return this.isClosedForSend0(sendersAndCloseStatus$FU.get(this));
    }

    protected boolean isConflatedDropOldest() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (this.isClosedForReceive()) {
            return false;
        }
        if (this.hasElements$kotlinx_coroutines_core()) {
            return false;
        }
        return this.isClosedForReceive() ^ true;
    }

    @Override
    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator(this);
    }

    @Override
    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of 'trySend' method", replaceWith=@ReplaceWith(expression="trySend(element).isSuccess", imports={}))
    public boolean offer(E e) {
        return Channel.DefaultImpls.offer(this, e);
    }

    protected void onClosedIdempotent() {
    }

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }

    @Override
    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith=@ReplaceWith(expression="tryReceive().getOrNull()", imports={}))
    public E poll() {
        return Channel.DefaultImpls.poll(this);
    }

    @Override
    public Object receive(Continuation<? super E> continuation) {
        return BufferedChannel.receive$suspendImpl(this, continuation);
    }

    @Override
    public Object receiveCatching-JP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        return BufferedChannel.receiveCatching-JP2dKIU$suspendImpl(this, continuation);
    }

    @Override
    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}))
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    protected void registerSelectForSend(SelectInstance<?> object, Object object2) {
        boolean bl = false;
        ChannelSegment channelSegment = (ChannelSegment)BufferedChannel.sendSegment$FU.get(this);
        block8: while (true) {
            long l = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this);
            long l2 = l & 0xFFFFFFFFFFFFFFFL;
            boolean bl2 = this.isClosedForSend0(l);
            l = l2 / (long)BufferedChannelKt.SEGMENT_SIZE;
            int n = (int)(l2 % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != l) {
                ChannelSegment channelSegment2 = this.findSegmentSend(l, channelSegment);
                if (channelSegment2 == null) {
                    if (!bl2) continue;
                    this.onClosedSelectOnSend((E)object2, (SelectInstance<?>)object);
                    break;
                }
                channelSegment = channelSegment2;
            }
            switch (this.updateCellSend(channelSegment, n, object2, l2, object, bl2)) {
                default: {
                    continue block8;
                }
                case 5: {
                    channelSegment.cleanPrev();
                    continue block8;
                }
                case 4: {
                    if (l2 < this.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    this.onClosedSelectOnSend((E)object2, (SelectInstance<?>)object);
                    break block8;
                }
                case 3: {
                    throw new IllegalStateException("unexpected".toString());
                }
                case 2: {
                    if (bl2) {
                        channelSegment.onSlotCleaned();
                        this.onClosedSelectOnSend((E)object2, (SelectInstance<?>)object);
                        break block8;
                    }
                    if ((object = object instanceof Waiter ? (Waiter)object : null) == null) break block8;
                    this.prepareSenderForSuspension((Waiter)object, channelSegment, n);
                    break block8;
                }
                case 1: {
                    object.selectInRegistrationPhase(Unit.INSTANCE);
                    break block8;
                }
                case 0: {
                    channelSegment.cleanPrev();
                    object.selectInRegistrationPhase(Unit.INSTANCE);
                }
            }
            break;
        }
    }

    @Override
    public Object send(E e, Continuation<? super Unit> continuation) {
        return BufferedChannel.send$suspendImpl(this, e, continuation);
    }

    public Object sendBroadcast$kotlinx_coroutines_core(E e, Continuation<? super Boolean> continuation) {
        return BufferedChannel.sendBroadcast$suspendImpl(this, e, continuation);
    }

    protected final <R> R sendImpl(E object, Object object2, Function0<? extends R> function0, Function2<? super ChannelSegment<E>, ? super Integer, ? extends R> function2, Function0<? extends R> function02, Function4<? super ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> function4) {
        ChannelSegment channelSegment = (ChannelSegment)BufferedChannel.sendSegment$FU.get(this);
        block8: while (true) {
            long l = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this);
            long l2 = l & 0xFFFFFFFFFFFFFFFL;
            boolean bl = this.isClosedForSend0(l);
            l = l2 / (long)BufferedChannelKt.SEGMENT_SIZE;
            int n = (int)(l2 % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != l) {
                ChannelSegment channelSegment2 = this.findSegmentSend(l, channelSegment);
                if (channelSegment2 == null) {
                    if (!bl) continue;
                    return (R)function02.invoke();
                }
                channelSegment = channelSegment2;
            }
            switch (this.updateCellSend(channelSegment, n, object, l2, object2, bl)) {
                default: {
                    continue block8;
                }
                case 5: {
                    channelSegment.cleanPrev();
                    continue block8;
                }
                case 4: {
                    if (l2 < this.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    return (R)function02.invoke();
                }
                case 3: {
                    return (R)function4.invoke((Object)channelSegment, (Object)n, object, (Object)l2);
                }
                case 2: {
                    if (bl) {
                        channelSegment.onSlotCleaned();
                        return (R)function02.invoke();
                    }
                    object = object2 instanceof Waiter ? (Waiter)object2 : null;
                    if (object != null) {
                        this.prepareSenderForSuspension(object, channelSegment, n);
                    }
                    return (R)function2.invoke((Object)channelSegment, (Object)n);
                }
                case 1: {
                    return (R)function0.invoke();
                }
                case 0: 
            }
            break;
        }
        channelSegment.cleanPrev();
        return (R)function0.invoke();
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return this.shouldSendSuspend(sendersAndCloseStatus$FU.get(this));
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        long l;
        long l2;
        long l3;
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        switch ((int)(sendersAndCloseStatus$FU.get(this) >> 60)) {
            default: {
                break;
            }
            case 3: {
                stringBuilder.append("cancelled,");
                break;
            }
            case 2: {
                stringBuilder.append("closed,");
            }
        }
        stringBuilder.append("capacity=" + this.capacity + ',');
        stringBuilder.append("data=[");
        Object object = CollectionsKt.listOf((Object[])new ChannelSegment[]{receiveSegment$FU.get(this), sendSegment$FU.get(this), bufferEndSegment$FU.get(this)});
        Object object2 = new ArrayList();
        Iterator iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            n = (ChannelSegment)object != BufferedChannelKt.access$getNULL_SEGMENT$p() ? 1 : 0;
            if (n == 0) continue;
            object2.add(object);
        }
        iterator2 = ((Iterable)(object2 = (List)object2)).iterator();
        if (!iterator2.hasNext()) {
            throw new NoSuchElementException();
        }
        object2 = iterator2.next();
        if (iterator2.hasNext()) {
            l3 = ((ChannelSegment)object2).id;
            while (true) {
                object = iterator2.next();
                l2 = ((ChannelSegment)object).id;
                l = l3;
                if (l3 > l2) {
                    object2 = object;
                    l = l2;
                }
                if (!iterator2.hasNext()) {
                    break;
                }
                l3 = l;
            }
        }
        object = (ChannelSegment)object2;
        l3 = this.getReceiversCounter$kotlinx_coroutines_core();
        l = this.getSendersCounter$kotlinx_coroutines_core();
        iterator2 = object;
        block6: do {
            int n2 = BufferedChannelKt.SEGMENT_SIZE;
            for (n = 0; n < n2; ++n) {
                l2 = ((ChannelSegment)((Object)iterator2)).id * (long)BufferedChannelKt.SEGMENT_SIZE + (long)n;
                if (l2 >= l && l2 >= l3) break block6;
                object2 = ((ChannelSegment)((Object)iterator2)).getState$kotlinx_coroutines_core(n);
                Object e = ((ChannelSegment)((Object)iterator2)).getElement$kotlinx_coroutines_core(n);
                if (object2 instanceof CancellableContinuation) {
                    object2 = l2 < l3 && l2 >= l ? "receive" : (l2 < l && l2 >= l3 ? "send" : "cont");
                } else if (object2 instanceof SelectInstance) {
                    object2 = l2 < l3 && l2 >= l ? "onReceive" : (l2 < l && l2 >= l3 ? "onSend" : "select");
                } else if (object2 instanceof ReceiveCatching) {
                    object2 = "receiveCatching";
                } else if (object2 instanceof SendBroadcast) {
                    object2 = "sendBroadcast";
                } else if (object2 instanceof WaiterEB) {
                    object2 = "EB(" + object2 + ')';
                } else {
                    boolean bl = Intrinsics.areEqual((Object)object2, (Object)BufferedChannelKt.access$getRESUMING_BY_RCV$p()) ? true : Intrinsics.areEqual((Object)object2, (Object)BufferedChannelKt.access$getRESUMING_BY_EB$p());
                    if (bl) {
                        object2 = "resuming_sender";
                    } else {
                        bl = object2 == null ? true : Intrinsics.areEqual((Object)object2, (Object)BufferedChannelKt.access$getIN_BUFFER$p());
                        bl = bl ? true : Intrinsics.areEqual((Object)object2, (Object)BufferedChannelKt.access$getDONE_RCV$p());
                        bl = bl ? true : Intrinsics.areEqual((Object)object2, (Object)BufferedChannelKt.access$getPOISONED$p());
                        bl = bl ? true : Intrinsics.areEqual((Object)object2, (Object)BufferedChannelKt.access$getINTERRUPTED_RCV$p());
                        bl = bl ? true : Intrinsics.areEqual((Object)object2, (Object)BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                        if (bl = bl ? true : Intrinsics.areEqual((Object)object2, (Object)BufferedChannelKt.getCHANNEL_CLOSED())) continue;
                        object2 = object2.toString();
                    }
                }
                if (e != null) {
                    stringBuilder.append('(' + (String)object2 + ',' + e + "),");
                    continue;
                }
                stringBuilder.append((String)object2 + ',');
            }
        } while ((iterator2 = (ChannelSegment)((ConcurrentLinkedListNode)((Object)iterator2)).getNext()) != null);
        if (StringsKt.last((CharSequence)stringBuilder) == ',') {
            Intrinsics.checkNotNullExpressionValue((Object)stringBuilder.deleteCharAt(stringBuilder.length() - 1), (String)"this.deleteCharAt(index)");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final String toStringDebug$kotlinx_coroutines_core() {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("S=" + this.getSendersCounter$kotlinx_coroutines_core() + ",R=" + this.getReceiversCounter$kotlinx_coroutines_core() + ",B=" + this.getBufferEndCounter() + ",B'=" + completedExpandBuffersAndPauseFlag$FU.get(this) + ",C=" + (int)(sendersAndCloseStatus$FU.get(this) >> 60) + ',');
        switch ((int)(sendersAndCloseStatus$FU.get(this) >> 60)) {
            default: {
                break;
            }
            case 3: {
                stringBuilder.append("CANCELLED,");
                break;
            }
            case 2: {
                stringBuilder.append("CLOSED,");
                break;
            }
            case 1: {
                stringBuilder.append("CANCELLATION_STARTED,");
            }
        }
        stringBuilder.append("SEND_SEGM=" + DebugStringsKt.getHexAddress(sendSegment$FU.get(this)) + ",RCV_SEGM=" + DebugStringsKt.getHexAddress(receiveSegment$FU.get(this)));
        if (!this.isRendezvousOrUnlimited()) {
            stringBuilder.append(",EB_SEGM=" + DebugStringsKt.getHexAddress(bufferEndSegment$FU.get(this)));
        }
        stringBuilder.append("  ");
        Object object = CollectionsKt.listOf((Object[])new ChannelSegment[]{receiveSegment$FU.get(this), sendSegment$FU.get(this), bufferEndSegment$FU.get(this)});
        Object object2 = new ArrayList();
        Object object3 = object.iterator();
        while (object3.hasNext()) {
            object = object3.next();
            n = (ChannelSegment)object != BufferedChannelKt.access$getNULL_SEGMENT$p() ? 1 : 0;
            if (n == 0) continue;
            object2.add(object);
        }
        Iterator iterator2 = ((Iterable)(object2 = (List)object2)).iterator();
        if (iterator2.hasNext()) {
            object = iterator2.next();
            if (!iterator2.hasNext()) {
                object2 = object;
            } else {
                long l = ((ChannelSegment)object).id;
                do {
                    object3 = iterator2.next();
                    long l2 = ((ChannelSegment)object3).id;
                    object2 = object;
                    long l3 = l;
                    if (l > l2) {
                        object2 = object3;
                        l3 = l2;
                    }
                    object = object2;
                    l = l3;
                } while (iterator2.hasNext());
            }
            object = (ChannelSegment)object2;
            do {
                object3 = new StringBuilder().append(DebugStringsKt.getHexAddress(object)).append("=[");
                object2 = ((Segment)object).isRemoved() ? "*" : "";
                iterator2 = ((StringBuilder)object3).append((String)object2).append(((ChannelSegment)object).id).append(",prev=");
                object2 = (ChannelSegment)((ConcurrentLinkedListNode)object).getPrev();
                object3 = null;
                object2 = object2 != null ? DebugStringsKt.getHexAddress(object2) : null;
                stringBuilder.append(((StringBuilder)((Object)iterator2)).append((String)object2).append(',').toString());
                int n2 = BufferedChannelKt.SEGMENT_SIZE;
                for (n = 0; n < n2; ++n) {
                    object2 = ((ChannelSegment)object).getState$kotlinx_coroutines_core(n);
                    iterator2 = ((ChannelSegment)object).getElement$kotlinx_coroutines_core(n);
                    object2 = object2 instanceof CancellableContinuation ? "cont" : (object2 instanceof SelectInstance ? "select" : (object2 instanceof ReceiveCatching ? "receiveCatching" : (object2 instanceof SendBroadcast ? "send(broadcast)" : (object2 instanceof WaiterEB ? "EB(" + object2 + ')' : String.valueOf(object2)))));
                    stringBuilder.append("" + '[' + n + "]=(" + (String)object2 + ',' + iterator2 + "),");
                }
                iterator2 = new StringBuilder().append("next=");
                ChannelSegment channelSegment = (ChannelSegment)((ConcurrentLinkedListNode)object).getNext();
                object2 = object3;
                if (channelSegment != null) {
                    object2 = DebugStringsKt.getHexAddress(channelSegment);
                }
                stringBuilder.append(((StringBuilder)((Object)iterator2)).append((String)object2).append("]  ").toString());
            } while ((object = (ChannelSegment)((ConcurrentLinkedListNode)object).getNext()) != null);
            return stringBuilder.toString();
        }
        throw new NoSuchElementException();
    }

    @Override
    public Object tryReceive-PtdJZtk() {
        block12: {
            Object object;
            block11: {
                Object object2;
                long l = receivers$FU.get(this);
                long l2 = sendersAndCloseStatus$FU.get(this);
                if (this.isClosedForReceive0(l2)) {
                    return ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause());
                }
                if (l >= (l2 & 0xFFFFFFFFFFFFFFFL)) {
                    return ChannelResult.Companion.failure-PtdJZtk();
                }
                Symbol symbol = BufferedChannelKt.access$getINTERRUPTED_RCV$p();
                object = (ChannelSegment)BufferedChannel.receiveSegment$FU.get(this);
                while (true) {
                    if (this.isClosedForReceive()) {
                        object = ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause());
                        break block11;
                    }
                    l2 = BufferedChannel.receivers$FU.getAndIncrement(this);
                    long l3 = l2 / (long)BufferedChannelKt.SEGMENT_SIZE;
                    int n = (int)(l2 % (long)BufferedChannelKt.SEGMENT_SIZE);
                    if (((ChannelSegment)object).id != l3) {
                        object2 = this.findSegmentReceive(l3, (ChannelSegment)object);
                        if (object2 == null) continue;
                        object = object2;
                    }
                    if ((object2 = this.updateCellReceive((ChannelSegment)object, n, l2, symbol)) == BufferedChannelKt.access$getSUSPEND$p()) {
                        object2 = symbol instanceof Waiter ? (Waiter)((Object)symbol) : null;
                        if (object2 != null) {
                            this.prepareReceiverForSuspension((Waiter)object2, (ChannelSegment)object, n);
                        }
                        this.waitExpandBufferCompletion$kotlinx_coroutines_core(l2);
                        ((Segment)object).onSlotCleaned();
                        object = ChannelResult.Companion.failure-PtdJZtk();
                        break block11;
                    }
                    if (object2 != BufferedChannelKt.access$getFAILED$p()) break;
                    if (l2 >= this.getSendersCounter$kotlinx_coroutines_core()) continue;
                    ((ConcurrentLinkedListNode)object).cleanPrev();
                }
                if (object2 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) break block12;
                ((ConcurrentLinkedListNode)object).cleanPrev();
                object = ChannelResult.Companion.success-JP2dKIU(object2);
            }
            return object;
        }
        throw new IllegalStateException("unexpected".toString());
    }

    @Override
    public Object trySend-JP2dKIU(E object) {
        if (this.shouldSendSuspend(sendersAndCloseStatus$FU.get(this))) {
            return ChannelResult.Companion.failure-PtdJZtk();
        }
        Symbol symbol = BufferedChannelKt.access$getINTERRUPTED_SEND$p();
        boolean bl = false;
        ChannelSegment channelSegment = (ChannelSegment)BufferedChannel.sendSegment$FU.get(this);
        block8: while (true) {
            long l = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this);
            long l2 = l & 0xFFFFFFFFFFFFFFFL;
            boolean bl2 = this.isClosedForSend0(l);
            l = l2 / (long)BufferedChannelKt.SEGMENT_SIZE;
            int n = (int)(l2 % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id != l) {
                ChannelSegment channelSegment2 = this.findSegmentSend(l, channelSegment);
                if (channelSegment2 == null) {
                    if (!bl2) continue;
                    object = ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                    break;
                }
                channelSegment = channelSegment2;
            }
            switch (this.updateCellSend(channelSegment, n, object, l2, symbol, bl2)) {
                default: {
                    continue block8;
                }
                case 5: {
                    channelSegment.cleanPrev();
                    continue block8;
                }
                case 4: {
                    if (l2 < this.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    object = ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                    break block8;
                }
                case 3: {
                    throw new IllegalStateException("unexpected".toString());
                }
                case 2: {
                    if (bl2) {
                        channelSegment.onSlotCleaned();
                        object = ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                        break block8;
                    }
                    object = symbol instanceof Waiter ? (Waiter)((Object)symbol) : null;
                    if (object != null) {
                        this.prepareSenderForSuspension(object, channelSegment, n);
                    }
                    channelSegment.onSlotCleaned();
                    object = ChannelResult.Companion.failure-PtdJZtk();
                    break block8;
                }
                case 1: {
                    object = ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
                    break block8;
                }
                case 0: {
                    channelSegment.cleanPrev();
                    object = ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
                }
            }
            break;
        }
        return object;
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long l) {
        long l2;
        int n;
        if (this.isRendezvousOrUnlimited()) {
            return;
        }
        while (this.getBufferEndCounter() <= l) {
        }
        int n2 = BufferedChannelKt.access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p();
        for (n = 0; n < n2; ++n) {
            l = this.getBufferEndCounter();
            if (l != (0x3FFFFFFFFFFFFFFFL & (l2 = completedExpandBuffersAndPauseFlag$FU.get(this))) || l != this.getBufferEndCounter()) continue;
            return;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$FU;
        while (!atomicLongFieldUpdater.compareAndSet(this, l = atomicLongFieldUpdater.get(this), BufferedChannelKt.access$constructEBCompletedAndPauseFlag(l & 0x3FFFFFFFFFFFFFFFL, true))) {
        }
        while (true) {
            long l3 = this.getBufferEndCounter();
            l2 = completedExpandBuffersAndPauseFlag$FU.get(this);
            l = l2 & 0x3FFFFFFFFFFFFFFFL;
            n = (l2 & 0x4000000000000000L) != 0L ? 1 : 0;
            if (l3 == l && l3 == this.getBufferEndCounter()) {
                atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$FU;
                while (!atomicLongFieldUpdater.compareAndSet(this, l2 = atomicLongFieldUpdater.get(this), BufferedChannelKt.access$constructEBCompletedAndPauseFlag(l2 & 0x3FFFFFFFFFFFFFFFL, false))) {
                }
                return;
            }
            if (n != 0) continue;
            atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$FU;
            atomicLongFieldUpdater.compareAndSet(this, l2, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(l, true));
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0011\u0010\t\u001a\u00020\u0006H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ/\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0013\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0014R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2={"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "receiveResult", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "next", "()Ljava/lang/Object;", "onClosedHasNext", "onClosedHasNextNoWaiterSuspend", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class BufferedChannelIterator
    implements ChannelIterator<E>,
    Waiter {
        private CancellableContinuationImpl<? super Boolean> continuation;
        private Object receiveResult;
        final BufferedChannel<E> this$0;

        public BufferedChannelIterator(BufferedChannel bufferedChannel) {
            this.this$0 = bufferedChannel;
            this.receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
        }

        public static final /* synthetic */ Object access$hasNextOnNoWaiterSuspend(BufferedChannelIterator bufferedChannelIterator, ChannelSegment channelSegment, int n, long l, Continuation continuation) {
            return bufferedChannelIterator.hasNextOnNoWaiterSuspend(channelSegment, n, l, (Continuation<? super Boolean>)continuation);
        }

        public static final /* synthetic */ void access$onClosedHasNextNoWaiterSuspend(BufferedChannelIterator bufferedChannelIterator) {
            bufferedChannelIterator.onClosedHasNextNoWaiterSuspend();
        }

        public static final /* synthetic */ void access$setContinuation$p(BufferedChannelIterator bufferedChannelIterator, CancellableContinuationImpl cancellableContinuationImpl) {
            bufferedChannelIterator.continuation = cancellableContinuationImpl;
        }

        public static final /* synthetic */ void access$setReceiveResult$p(BufferedChannelIterator bufferedChannelIterator, Object object) {
            bufferedChannelIterator.receiveResult = object;
        }

        /*
         * Exception decompiling
         */
        private final Object hasNextOnNoWaiterSuspend(ChannelSegment<E> var1_1, int var2_7, long var3_8, Continuation<? super Boolean> var5_9) {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * 
             * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 7[TRYBLOCK] [7 : 211->215)] java.lang.Throwable
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
             *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
             *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
             *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
             *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
             *     at org.benf.cfr.reader.Main.main(Main.java:54)
             */
            throw new IllegalStateException("Decompilation failed");
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable throwable = this.this$0.getCloseCause();
            if (throwable == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(throwable);
        }

        private final void onClosedHasNextNoWaiterSuspend() {
            Result.Companion companion = this.continuation;
            Intrinsics.checkNotNull(companion);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable throwable = this.this$0.getCloseCause();
            if (throwable == null) {
                throwable = (Continuation)companion;
                Result.Companion companion2 = Result.Companion;
                throwable.resumeWith(Result.constructor-impl((Object)false));
            } else {
                Continuation continuation = (Continuation)companion;
                if (DebugKt.getRECOVER_STACK_TRACES() && (Continuation)companion instanceof CoroutineStackFrame) {
                    throwable = StackTraceRecoveryKt.access$recoverFromStackFrame(throwable, (CoroutineStackFrame)((Continuation)companion));
                }
                companion = Result.Companion;
                continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable)));
            }
        }

        @Override
        public Object hasNext(Continuation<? super Boolean> object) {
            block5: {
                block4: {
                    Object object2;
                    int n;
                    long l;
                    BufferedChannel bufferedChannel = this.this$0;
                    Object object3 = (ChannelSegment)receiveSegment$FU.get(bufferedChannel);
                    while (true) {
                        if (bufferedChannel.isClosedForReceive()) {
                            object = Boxing.boxBoolean((boolean)this.onClosedHasNext());
                            break block4;
                        }
                        l = receivers$FU.getAndIncrement(bufferedChannel);
                        long l2 = l / (long)BufferedChannelKt.SEGMENT_SIZE;
                        n = (int)(l % (long)BufferedChannelKt.SEGMENT_SIZE);
                        if (((ChannelSegment)object3).id != l2) {
                            object2 = bufferedChannel.findSegmentReceive(l2, (ChannelSegment)object3);
                            if (object2 == null) continue;
                            object3 = object2;
                        }
                        if ((object2 = bufferedChannel.updateCellReceive((ChannelSegment)object3, n, l, null)) == BufferedChannelKt.access$getSUSPEND$p()) break block5;
                        if (object2 != BufferedChannelKt.access$getFAILED$p()) break;
                        if (l >= bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) continue;
                        ((ConcurrentLinkedListNode)object3).cleanPrev();
                    }
                    if (object2 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                        return this.hasNextOnNoWaiterSuspend((ChannelSegment)object3, n, l, (Continuation<? super Boolean>)object);
                    }
                    ((ConcurrentLinkedListNode)object3).cleanPrev();
                    this.receiveResult = object2;
                    object = Boxing.boxBoolean((boolean)true);
                }
                return object;
            }
            throw new IllegalStateException("unreachable".toString());
        }

        @Override
        public void invokeOnCancellation(Segment<?> segment, int n) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, n);
            }
        }

        @Override
        public E next() {
            Object object = this.receiveResult;
            boolean bl = object != BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
            if (bl) {
                this.receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
                if (object != BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return object;
                }
                throw StackTraceRecoveryKt.recoverStackTrace(this.this$0.getReceiveException());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }

        @Override
        @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object next(Continuation continuation) {
            return ChannelIterator.DefaultImpls.next(this, continuation);
        }

        public final boolean tryResumeHasNext(E e) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            Function1<Throwable, Unit> function1 = null;
            this.continuation = null;
            this.receiveResult = e;
            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
            Function1 function12 = this.this$0.onUndeliveredElement;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function12, e, cancellableContinuationImpl.getContext());
            }
            return BufferedChannelKt.access$tryResume0(cancellableContinuation, true, function1);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            Result.Companion companion = this.continuation;
            Intrinsics.checkNotNull(companion);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable throwable = this.this$0.getCloseCause();
            if (throwable == null) {
                Continuation continuation = (Continuation)companion;
                throwable = Result.Companion;
                continuation.resumeWith(Result.constructor-impl((Object)false));
            } else {
                Continuation continuation = (Continuation)companion;
                if (DebugKt.getRECOVER_STACK_TRACES() && (Continuation)companion instanceof CoroutineStackFrame) {
                    throwable = StackTraceRecoveryKt.access$recoverFromStackFrame(throwable, (CoroutineStackFrame)((Continuation)companion));
                }
                companion = Result.Companion;
                continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable)));
            }
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private static final class SendBroadcast
    implements Waiter {
        private final CancellableContinuationImpl<Boolean> $$delegate_0;
        private final CancellableContinuation<Boolean> cont;

        public SendBroadcast(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.cont = cancellableContinuation;
            Intrinsics.checkNotNull(cancellableContinuation, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (CancellableContinuationImpl)cancellableContinuation;
        }

        public final CancellableContinuation<Boolean> getCont() {
            return this.cont;
        }

        @Override
        public void invokeOnCancellation(Segment<?> segment, int n) {
            this.$$delegate_0.invokeOnCancellation(segment, n);
        }
    }
}

