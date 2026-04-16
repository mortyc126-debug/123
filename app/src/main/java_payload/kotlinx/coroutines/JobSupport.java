/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequenceScope
 *  kotlin.sequences.SequencesKt
 */
package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildHandleNode;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Empty;
import kotlinx.coroutines.InactiveNodeList;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.InvokeOnCancelling;
import kotlinx.coroutines.InvokeOnCompletion;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.NodeList;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.ParentJob;
import kotlinx.coroutines.ResumeAwaitOnCompletion;
import kotlinx.coroutines.ResumeOnCompletion;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectInstance;

@Deprecated(level=DeprecationLevel.ERROR, message="This is internal API and may be removed in the future releases")
@Metadata(d1={"\u0000\u00e2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\n\u00b2\u0001\u00b3\u0001\u00b4\u0001\u00b5\u0001\u00b6\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u001e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00112\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110KH\u0002J\u0012\u0010L\u001a\u00020H2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0014J\u000e\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0002J\u0013\u0010O\u001a\u0004\u0018\u00010\u000bH\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u0004\u0018\u00010\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010PJ\u0012\u0010R\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0017J\u0018\u0010R\u001a\u00020H2\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UH\u0016J\u0010\u0010V\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u0011J\u0017\u0010W\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0000\u00a2\u0006\u0002\bXJ\u0010\u0010Y\u001a\u00020H2\u0006\u0010S\u001a\u00020\u0011H\u0016J\u0014\u0010Z\u001a\u0004\u0018\u00010\u000b2\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0011H\u0002J\b\u0010\\\u001a\u00020]H\u0014J\u0010\u0010^\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0011H\u0016J\u001a\u0010_\u001a\u00020H2\u0006\u00108\u001a\u00020?2\b\u0010`\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010a\u001a\u00020H2\u0006\u00108\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010f\u001a\u00020\u00112\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010g\u001a\u00020h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010]2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0011H\u0080\b\u00a2\u0006\u0002\bjJ\u001c\u0010k\u001a\u0004\u0018\u00010\u000b2\u0006\u00108\u001a\u00020b2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010l\u001a\u0004\u0018\u00010d2\u0006\u00108\u001a\u00020?H\u0002J\n\u0010m\u001a\u00060Tj\u0002`UJ\f\u0010n\u001a\u00060Tj\u0002`UH\u0016J\u000f\u0010o\u001a\u0004\u0018\u00010\u000bH\u0000\u00a2\u0006\u0002\bpJ\b\u0010q\u001a\u0004\u0018\u00010\u0011J \u0010r\u001a\u0004\u0018\u00010\u00112\u0006\u00108\u001a\u00020b2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110KH\u0002J\u0012\u0010s\u001a\u0004\u0018\u00010D2\u0006\u00108\u001a\u00020?H\u0002J\u0010\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u0011H\u0014J\u0015\u0010v\u001a\u00020H2\u0006\u0010u\u001a\u00020\u0011H\u0010\u00a2\u0006\u0002\bwJ\u0012\u0010x\u001a\u00020H2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0004JA\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00052)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011\u00a2\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u0001J1\u0010y\u001a\u00020z2)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011\u00a2\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u0001J\u0012\u0010\u0082\u0001\u001a\u00020HH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010PJ\t\u0010\u0083\u0001\u001a\u00020\u0005H\u0002J\u0012\u0010\u0084\u0001\u001a\u00020HH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010PJ\"\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0015\u0010\u0087\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020H0~H\u0082\bJ\u0015\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010\u0089\u0001\u001a\u00020\u00052\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0000\u00a2\u0006\u0003\b\u008a\u0001J\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0000\u00a2\u0006\u0003\b\u008c\u0001J<\u0010\u008d\u0001\u001a\u00020F2)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011\u00a2\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u00012\u0006\u0010{\u001a\u00020\u0005H\u0002J\u000f\u0010\u008e\u0001\u001a\u00020]H\u0010\u00a2\u0006\u0003\b\u008f\u0001J\u0019\u0010\u0090\u0001\u001a\u00020H2\u0006\u0010C\u001a\u00020D2\u0006\u0010S\u001a\u00020\u0011H\u0002J)\u0010\u0091\u0001\u001a\u00020H\"\u000b\b\u0000\u0010\u0092\u0001\u0018\u0001*\u00020F2\u0006\u0010C\u001a\u00020D2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0082\bJ!\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u0096\u0001\u001a\u00020H2\f\u0010\u0097\u0001\u001a\u0007\u0012\u0002\b\u00030\u0098\u00012\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010{\u001a\u00020H2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0014J\u0013\u0010\u0099\u0001\u001a\u00020H2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0014J\t\u0010\u009a\u0001\u001a\u00020HH\u0014J\u0010\u0010\u009b\u0001\u001a\u00020H2\u0007\u0010\u009c\u0001\u001a\u00020\u0003J\u0012\u0010\u009d\u0001\u001a\u00020H2\u0007\u00108\u001a\u00030\u009e\u0001H\u0002J\u0011\u0010\u009f\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020FH\u0002J\"\u0010\u00a0\u0001\u001a\u00020H2\f\u0010\u0097\u0001\u001a\u0007\u0012\u0002\b\u00030\u0098\u00012\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0017\u0010\u00a1\u0001\u001a\u00020H2\u0006\u0010E\u001a\u00020FH\u0000\u00a2\u0006\u0003\b\u00a2\u0001J\u0007\u0010\u00a3\u0001\u001a\u00020\u0005J\u0014\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0002J\u0013\u0010\u00a6\u0001\u001a\u00020]2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0002J\t\u0010\u00a7\u0001\u001a\u00020]H\u0007J\t\u0010\u00a8\u0001\u001a\u00020]H\u0016J\u001b\u0010\u00a9\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020?2\b\u0010`\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010\u00aa\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020?2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u001f\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\u000b2\b\u00108\u001a\u0004\u0018\u00010\u000b2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u001d\u0010\u00ac\u0001\u001a\u0004\u0018\u00010\u000b2\u0006\u00108\u001a\u00020?2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J$\u0010\u00ad\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020b2\u0006\u0010N\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0082\u0010J\u0010\u0010\u00ae\u0001\u001a\u0004\u0018\u00010d*\u00030\u00af\u0001H\u0002J\u0017\u0010\u00b0\u0001\u001a\u00020H*\u00020D2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0002J\u001d\u0010\u00b1\u0001\u001a\u00060Tj\u0002`U*\u00020\u00112\n\b\u0002\u0010i\u001a\u0004\u0018\u00010]H\u0004R\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0082\u0004R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00058DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00058PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00058TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R\u0015\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u0006\u0012\u0002\b\u00030#8DX\u0084\u0004\u00a2\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00058PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u0016R\u0017\u0010*\u001a\u00020+8F\u00a2\u0006\f\u0012\u0004\b,\u0010%\u001a\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R(\u00103\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u00010\t8@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u00108\u001a\u0004\u0018\u00010\u000b8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u0018\u0010>\u001a\u00020\u0005*\u00020?8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010@\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00b7\u0001"}, d2={"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "active", "", "(Z)V", "_parentHandle", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/ChildHandle;", "_state", "", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "completionCause", "", "getCompletionCause", "()Ljava/lang/Throwable;", "completionCauseHandled", "getCompletionCauseHandled", "()Z", "handlesException", "getHandlesException$kotlinx_coroutines_core", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onAwaitInternal", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwaitInternal$annotations", "()V", "getOnAwaitInternal", "()Lkotlinx/coroutines/selects/SelectClause1;", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parent", "getParent", "()Lkotlinx/coroutines/Job;", "value", "parentHandle", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "exceptionOrNull", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "isCancelling", "Lkotlinx/coroutines/Incomplete;", "(Lkotlinx/coroutines/Incomplete;)Z", "addLastAtomic", "expect", "list", "Lkotlinx/coroutines/NodeList;", "node", "Lkotlinx/coroutines/JobNode;", "addSuppressedExceptions", "", "rootCause", "exceptions", "", "afterCompletion", "attachChild", "child", "awaitInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSuspend", "cancel", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelCoroutine", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelInternal", "cancelMakeCompleting", "cancelParent", "cancellationExceptionMessage", "", "childCancelled", "completeStateFinalization", "update", "continueCompleting", "Lkotlinx/coroutines/JobSupport$Finishing;", "lastChild", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "createCauseException", "defaultCancellationException", "Lkotlinx/coroutines/JobCancellationException;", "message", "defaultCancellationException$kotlinx_coroutines_core", "finalizeFinishingState", "firstChild", "getCancellationException", "getChildJobCancellationCause", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "getCompletionExceptionOrNull", "getFinalRootCause", "getOrPromoteCancellingList", "handleJobException", "exception", "handleOnCompletionException", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "joinInternal", "joinSuspend", "loopOnState", "", "block", "makeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "makeNode", "nameString", "nameString$kotlinx_coroutines_core", "notifyCancelling", "notifyHandlers", "T", "onAwaitInternalProcessResFunc", "ignoredParam", "result", "onAwaitInternalRegFunc", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onCompletionInternal", "onStart", "parentCancelled", "parentJob", "promoteEmptyToNodeList", "Lkotlinx/coroutines/Empty;", "promoteSingleToNodeList", "registerSelectForOnJoin", "removeNode", "removeNode$kotlinx_coroutines_core", "start", "startInternal", "", "stateString", "toDebugString", "toString", "tryFinalizeSimpleState", "tryMakeCancelling", "tryMakeCompleting", "tryMakeCompletingSlowPath", "tryWaitForChild", "nextChild", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "notifyCompletion", "toCancellationException", "AwaitContinuation", "ChildCompletion", "Finishing", "SelectOnAwaitCompletionHandler", "SelectOnJoinCompletionHandler", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class JobSupport
implements Job,
ChildJob,
ParentJob {
    private static final AtomicReferenceFieldUpdater _parentHandle$FU;
    private static final AtomicReferenceFieldUpdater _state$FU;
    @Volatile
    private volatile Object _parentHandle;
    @Volatile
    private volatile Object _state;

    static {
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
        _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle");
    }

    public JobSupport(boolean bl) {
        Empty empty = bl ? JobSupportKt.access$getEMPTY_ACTIVE$p() : JobSupportKt.access$getEMPTY_NEW$p();
        this._state = empty;
    }

    public static final /* synthetic */ Object access$awaitSuspend(JobSupport jobSupport, Continuation continuation) {
        return jobSupport.awaitSuspend((Continuation<Object>)continuation);
    }

    public static final /* synthetic */ Object access$joinSuspend(JobSupport jobSupport, Continuation continuation) {
        return jobSupport.joinSuspend((Continuation<? super Unit>)continuation);
    }

    public static final /* synthetic */ Object access$onAwaitInternalProcessResFunc(JobSupport jobSupport, Object object, Object object2) {
        return jobSupport.onAwaitInternalProcessResFunc(object, object2);
    }

    public static final /* synthetic */ void access$onAwaitInternalRegFunc(JobSupport jobSupport, SelectInstance selectInstance, Object object) {
        jobSupport.onAwaitInternalRegFunc(selectInstance, object);
    }

    public static final /* synthetic */ void access$registerSelectForOnJoin(JobSupport jobSupport, SelectInstance selectInstance, Object object) {
        jobSupport.registerSelectForOnJoin(selectInstance, object);
    }

    private final boolean addLastAtomic(Object object, NodeList lockFreeLinkedListNode, JobNode jobNode) {
        boolean bl;
        lockFreeLinkedListNode = lockFreeLinkedListNode;
        object = new LockFreeLinkedListNode.CondAddOp(jobNode, this, object){
            final Object $expect$inlined;
            final JobSupport this$0;
            {
                this.this$0 = jobSupport;
                this.$expect$inlined = object;
                super(lockFreeLinkedListNode);
            }

            public Object prepare(LockFreeLinkedListNode object) {
                boolean bl = this.this$0.getState$kotlinx_coroutines_core() == this.$expect$inlined;
                object = bl ? null : LockFreeLinkedListKt.getCONDITION_FALSE();
                return object;
            }
        };
        block4: while (true) {
            switch (lockFreeLinkedListNode.getPrevNode().tryCondAddNext(jobNode, lockFreeLinkedListNode, (LockFreeLinkedListNode.CondAddOp)object)) {
                default: {
                    continue block4;
                }
                case 2: {
                    bl = false;
                    break block4;
                }
                case 1: {
                    bl = true;
                }
            }
            break;
        }
        return bl;
    }

    private final void addSuppressedExceptions(Throwable throwable, List<? extends Throwable> object) {
        if (object.size() <= 1) {
            return;
        }
        Set<Object> set = Collections.newSetFromMap(new IdentityHashMap(object.size()));
        Throwable throwable2 = !DebugKt.getRECOVER_STACK_TRACES() ? throwable : StackTraceRecoveryKt.unwrapImpl(throwable);
        Iterator<? extends Throwable> iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                object = StackTraceRecoveryKt.unwrapImpl(object);
            }
            if (object == throwable || object == throwable2 || object instanceof CancellationException || !set.add(object)) continue;
            ExceptionsKt.addSuppressed((Throwable)throwable, (Throwable)object);
        }
    }

    private final Object awaitSuspend(Continuation<Object> continuation) {
        Object object = new AwaitContinuation(IntrinsicsKt.intercepted(continuation), this);
        ((CancellableContinuationImpl)object).initCancellability();
        CancellableContinuationKt.disposeOnCancellation((CancellableContinuation)object, this.invokeOnCompletion(new ResumeAwaitOnCompletion((CancellableContinuationImpl)object)));
        object = ((CancellableContinuationImpl)object).getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return object;
    }

    private final Object cancelMakeCompleting(Object object) {
        Object object2;
        while (!(!((object2 = this.getState$kotlinx_coroutines_core()) instanceof Incomplete) || object2 instanceof Finishing && ((Finishing)object2).isCompleting())) {
            if ((object2 = this.tryMakeCompleting(object2, new CompletedExceptionally(this.createCauseException(object), false, 2, null))) == JobSupportKt.access$getCOMPLETING_RETRY$p()) continue;
            return object2;
        }
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    }

    private final boolean cancelParent(Throwable throwable) {
        boolean bl = this.isScopedCoroutine();
        boolean bl2 = true;
        if (bl) {
            return true;
        }
        boolean bl3 = throwable instanceof CancellationException;
        ChildHandle childHandle = this.getParentHandle$kotlinx_coroutines_core();
        if (childHandle != null && childHandle != NonDisposableHandle.INSTANCE) {
            bl = bl2;
            if (!childHandle.childCancelled(throwable)) {
                bl = bl3 ? bl2 : false;
            }
            return bl;
        }
        return bl3;
    }

    private final void completeStateFinalization(Incomplete incomplete, Object object) {
        Object object2 = this.getParentHandle$kotlinx_coroutines_core();
        if (object2 != null) {
            object2.dispose();
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
        boolean bl = object instanceof CompletedExceptionally;
        object2 = null;
        object = bl ? (CompletedExceptionally)object : null;
        if (object != null) {
            object2 = ((CompletedExceptionally)object).cause;
        }
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode)incomplete).invoke((Throwable)object2);
            }
            catch (Throwable throwable) {
                this.handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, throwable));
            }
        } else if ((incomplete = incomplete.getList()) != null) {
            this.notifyCompletion((NodeList)incomplete, (Throwable)object2);
        }
    }

    private final void continueCompleting(Finishing finishing, ChildHandleNode childHandleNode, Object object) {
        boolean bl;
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = this.getState$kotlinx_coroutines_core() == finishing)) {
            throw new AssertionError();
        }
        if ((childHandleNode = this.nextChild(childHandleNode)) != null && this.tryWaitForChild(finishing, childHandleNode, object)) {
            return;
        }
        this.afterCompletion(this.finalizeFinishingState(finishing, object));
    }

    private final Throwable createCauseException(Object object) {
        boolean bl = object == null ? true : object instanceof Throwable;
        if (bl) {
            Throwable throwable = (Throwable)object;
            object = throwable;
            if (throwable == null) {
                object = new JobCancellationException(this.cancellationExceptionMessage(), null, this);
            }
        } else {
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
            object = ((ParentJob)object).getChildJobCancellationCause();
        }
        return object;
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport jobSupport, String string2, Throwable throwable, int n, Object object) {
        if (object == null) {
            if ((n & 1) != 0) {
                string2 = null;
            }
            if ((n & 2) != 0) {
                throwable = null;
            }
            if (string2 == null) {
                string2 = jobSupport.cancellationExceptionMessage();
            }
            return new JobCancellationException(string2, throwable, jobSupport);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final Object finalizeFinishingState(Finishing finishing, Object object) {
        boolean bl;
        boolean bl2 = DebugKt.getASSERTIONS_ENABLED();
        boolean bl3 = true;
        if (bl2) {
            bl = this.getState$kotlinx_coroutines_core() == finishing;
            if (!bl) throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(finishing.isSealed() ^ true)) throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!finishing.isCompleting()) throw new AssertionError();
        }
        Object object2 = object instanceof CompletedExceptionally ? (CompletedExceptionally)object : null;
        object2 = object2 != null ? ((CompletedExceptionally)object2).cause : null;
        // MONITORENTER : finishing
        bl2 = finishing.isCancelling();
        List<Throwable> list = finishing.sealLocked((Throwable)object2);
        Throwable throwable = this.getFinalRootCause(finishing, list);
        if (throwable != null) {
            this.addSuppressedExceptions(throwable, list);
        }
        // MONITOREXIT : finishing
        if (throwable != null && throwable != object2) {
            object = new CompletedExceptionally(throwable, false, 2, null);
        }
        if (throwable != null) {
            bl = bl3;
            if (!this.cancelParent(throwable)) {
                bl = this.handleJobException(throwable) ? bl3 : false;
            }
            if (bl) {
                Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((CompletedExceptionally)object).makeHandled();
            }
        }
        if (!bl2) {
            this.onCancelling(throwable);
        }
        this.onCompletionInternal(object);
        bl2 = AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, finishing, JobSupportKt.boxIncomplete(object));
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!bl2) throw new AssertionError();
        }
        this.completeStateFinalization(finishing, object);
        return object;
    }

    private final ChildHandleNode firstChild(Incomplete incomplete) {
        boolean bl = incomplete instanceof ChildHandleNode;
        Object var4_3 = null;
        LockFreeLinkedListNode lockFreeLinkedListNode = bl ? (ChildHandleNode)incomplete : null;
        if (lockFreeLinkedListNode == null) {
            lockFreeLinkedListNode = incomplete.getList();
            incomplete = var4_3;
            if (lockFreeLinkedListNode != null) {
                incomplete = this.nextChild(lockFreeLinkedListNode);
            }
        } else {
            incomplete = lockFreeLinkedListNode;
        }
        return incomplete;
    }

    private final Throwable getExceptionOrNull(Object object) {
        boolean bl = object instanceof CompletedExceptionally;
        Throwable throwable = null;
        object = bl ? (CompletedExceptionally)object : null;
        if (object != null) {
            throwable = ((CompletedExceptionally)object).cause;
        }
        return throwable;
    }

    private final Throwable getFinalRootCause(Finishing object3, List<? extends Throwable> object2) {
        Object var5_4;
        block7: {
            boolean bl = object2.isEmpty();
            var5_4 = null;
            if (bl) {
                if (((Finishing)object3).isCancelling()) {
                    return new JobCancellationException(this.cancellationExceptionMessage(), null, this);
                }
                return null;
            }
            for (Object object3 : (Iterable)object2) {
                if (!((Throwable)object3 instanceof CancellationException ^ true)) continue;
                break block7;
            }
            object3 = null;
        }
        object3 = (Throwable)object3;
        if (object3 != null) {
            return object3;
        }
        Throwable throwable = object2.get(0);
        if (throwable instanceof TimeoutCancellationException) {
            block8: {
                for (Object object3 : (Iterable)object2) {
                    Throwable throwable2 = (Throwable)object3;
                    boolean bl = throwable2 != throwable && throwable2 instanceof TimeoutCancellationException;
                    if (!bl) continue;
                    break block8;
                }
                object3 = var5_4;
            }
            object3 = (Throwable)object3;
            if (object3 != null) {
                return object3;
            }
        }
        return throwable;
    }

    protected static /* synthetic */ void getOnAwaitInternal$annotations() {
    }

    public static /* synthetic */ void getOnJoin$annotations() {
    }

    private final NodeList getOrPromoteCancellingList(Incomplete incomplete) {
        NodeList nodeList;
        NodeList nodeList2 = nodeList = incomplete.getList();
        if (nodeList == null) {
            if (incomplete instanceof Empty) {
                nodeList2 = new NodeList();
            } else if (incomplete instanceof JobNode) {
                this.promoteSingleToNodeList((JobNode)incomplete);
                nodeList2 = null;
            } else {
                throw new IllegalStateException(("State should have list: " + incomplete).toString());
            }
        }
        return nodeList2;
    }

    private final boolean isCancelling(Incomplete incomplete) {
        boolean bl = incomplete instanceof Finishing && ((Finishing)incomplete).isCancelling();
        return bl;
    }

    private final boolean joinInternal() {
        Object object;
        do {
            if ((object = this.getState$kotlinx_coroutines_core()) instanceof Incomplete) continue;
            return false;
        } while (this.startInternal(object) < 0);
        return true;
    }

    private final Object joinSuspend(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Object object = cancellableContinuationImpl;
        CancellableContinuationKt.disposeOnCancellation(object, this.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)new ResumeOnCompletion((Continuation<? super Unit>)((Continuation)object)))));
        object = cancellableContinuationImpl.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object object) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(object));
        }
    }

    private final Void loopOnState(Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(this.getState$kotlinx_coroutines_core());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Object makeCancelling(Object object) {
        Object object2;
        Throwable throwable = null;
        while (true) {
            Throwable throwable2;
            Object object3 = this.getState$kotlinx_coroutines_core();
            boolean bl = object3 instanceof Finishing;
            object2 = null;
            boolean bl2 = false;
            if (bl) {
                synchronized (object3) {
                    if (((Finishing)object3).isSealed()) {
                        return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
                    }
                    bl = ((Finishing)object3).isCancelling();
                    if (object != null || !bl) {
                        if (throwable == null) {
                            throwable = this.createCauseException(object);
                            object = throwable;
                        } else {
                            object = throwable;
                        }
                        ((Finishing)object3).addExceptionLocked(throwable);
                    }
                    throwable = ((Finishing)object3).getRootCause();
                    if (!bl) {
                        bl2 = true;
                    }
                    object = object2;
                    if (bl2) {
                        object = throwable;
                    }
                }
                if (object == null) return JobSupportKt.access$getCOMPLETING_ALREADY$p();
                this.notifyCancelling(((Finishing)object3).getList(), (Throwable)object);
                return JobSupportKt.access$getCOMPLETING_ALREADY$p();
            }
            if (!(object3 instanceof Incomplete)) {
                return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
            }
            if (throwable == null) {
                throwable = this.createCauseException(object);
                object2 = throwable;
                throwable2 = object2;
            } else {
                object2 = throwable;
                throwable2 = throwable;
                throwable = object2;
            }
            if (((Incomplete)object3).isActive()) {
                if (!this.tryMakeCancelling((Incomplete)object3, throwable2)) continue;
                return JobSupportKt.access$getCOMPLETING_ALREADY$p();
            }
            object2 = this.tryMakeCompleting(object3, new CompletedExceptionally(throwable2, false, 2, null));
            if (object2 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                throw new IllegalStateException(("Cannot happen in " + object3).toString());
            }
            if (object2 != JobSupportKt.access$getCOMPLETING_RETRY$p()) break;
        }
        return object2;
    }

    private final JobNode makeNode(Function1<? super Throwable, Unit> function1, boolean bl) {
        JobCancellingNode jobCancellingNode = null;
        JobNode jobNode = null;
        if (bl) {
            if (function1 instanceof JobCancellingNode) {
                jobNode = (JobCancellingNode)function1;
            }
            jobCancellingNode = jobNode;
            if (jobNode == null) {
                jobCancellingNode = new InvokeOnCancelling(function1);
            }
            jobNode = jobCancellingNode;
        } else {
            jobNode = jobCancellingNode;
            if (function1 instanceof JobNode) {
                jobNode = (JobNode)function1;
            }
            if (jobNode != null) {
                if (DebugKt.getASSERTIONS_ENABLED() && !(jobNode instanceof JobCancellingNode ^ true)) {
                    throw new AssertionError();
                }
            } else {
                jobNode = new InvokeOnCompletion(function1);
            }
        }
        jobNode.setJob(this);
        return jobNode;
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        while (true) {
            lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            if (!lockFreeLinkedListNode.isRemoved()) break;
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode2 = lockFreeLinkedListNode = lockFreeLinkedListNode2.getNextNode();
            if (lockFreeLinkedListNode.isRemoved()) continue;
            if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                return (ChildHandleNode)lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            if (lockFreeLinkedListNode instanceof NodeList) break;
        }
        return null;
    }

    private final void notifyCancelling(NodeList object, Throwable throwable) {
        this.onCancelling(throwable);
        LockFreeLinkedListHead lockFreeLinkedListHead = (LockFreeLinkedListHead)object;
        object = lockFreeLinkedListHead.getNext();
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode)object;
        object = null;
        while (!Intrinsics.areEqual((Object)lockFreeLinkedListNode, (Object)lockFreeLinkedListHead)) {
            Object object2 = object;
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                block6: {
                    JobNode jobNode = (JobNode)lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(throwable);
                    }
                    catch (Throwable throwable2) {
                        Throwable throwable3 = (Throwable)object;
                        if (throwable3 != null) {
                            ExceptionsKt.addSuppressed((Throwable)throwable3, (Throwable)throwable2);
                            if (throwable3 != null) break block6;
                        }
                        object = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, throwable2);
                        object2 = Unit.INSTANCE;
                    }
                }
                object2 = object;
            }
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            object = object2;
        }
        if ((object = (Throwable)object) != null) {
            this.handleOnCompletionException$kotlinx_coroutines_core((Throwable)object);
        }
        this.cancelParent(throwable);
    }

    private final void notifyCompletion(NodeList object, Throwable throwable) {
        LockFreeLinkedListHead lockFreeLinkedListHead = (LockFreeLinkedListHead)object;
        object = lockFreeLinkedListHead.getNext();
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode)object;
        object = null;
        while (!Intrinsics.areEqual((Object)lockFreeLinkedListNode, (Object)lockFreeLinkedListHead)) {
            block6: {
                if (lockFreeLinkedListNode instanceof JobNode) {
                    JobNode jobNode = (JobNode)lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(throwable);
                    }
                    catch (Throwable throwable2) {
                        Throwable throwable3 = (Throwable)object;
                        if (throwable3 != null) {
                            ExceptionsKt.addSuppressed((Throwable)throwable3, (Throwable)throwable2);
                            if (throwable3 != null) break block6;
                        }
                        object = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, throwable2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
        }
        if ((object = (Throwable)object) != null) {
            this.handleOnCompletionException$kotlinx_coroutines_core((Throwable)object);
        }
    }

    private final /* synthetic */ <T extends JobNode> void notifyHandlers(NodeList object, Throwable throwable) {
        Object object2 = null;
        LockFreeLinkedListHead lockFreeLinkedListHead = (LockFreeLinkedListHead)object;
        object = lockFreeLinkedListHead.getNext();
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode)object;
        object = object2;
        while (!Intrinsics.areEqual((Object)lockFreeLinkedListNode, (Object)lockFreeLinkedListHead)) {
            Intrinsics.reifiedOperationMarker((int)3, (String)"T");
            object2 = object;
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                block6: {
                    JobNode jobNode = (JobNode)lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(throwable);
                    }
                    catch (Throwable throwable2) {
                        Throwable throwable3 = (Throwable)object;
                        if (throwable3 != null) {
                            ExceptionsKt.addSuppressed((Throwable)throwable3, (Throwable)throwable2);
                            Throwable throwable4 = throwable3;
                            if (throwable3 != null) break block6;
                        }
                        object = this;
                        object = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + object, throwable2);
                        object2 = Unit.INSTANCE;
                    }
                }
                object2 = object;
            }
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            object = object2;
        }
        if ((object = (Throwable)object) != null) {
            this.handleOnCompletionException$kotlinx_coroutines_core((Throwable)object);
        }
    }

    private final Object onAwaitInternalProcessResFunc(Object object, Object object2) {
        if (!(object2 instanceof CompletedExceptionally)) {
            return object2;
        }
        throw ((CompletedExceptionally)object2).cause;
    }

    private final void onAwaitInternalRegFunc(SelectInstance<?> selectInstance, Object object) {
        do {
            if ((object = this.getState$kotlinx_coroutines_core()) instanceof Incomplete) continue;
            if (!(object instanceof CompletedExceptionally)) {
                object = JobSupportKt.unboxState(object);
            }
            selectInstance.selectInRegistrationPhase(object);
            return;
        } while (this.startInternal(object) < 0);
        selectInstance.disposeOnCompletion(this.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)new SelectOnAwaitCompletionHandler(this, selectInstance))));
    }

    private final void promoteEmptyToNodeList(Empty empty) {
        Incomplete incomplete = new NodeList();
        incomplete = empty.isActive() ? (Incomplete)incomplete : (Incomplete)new InactiveNodeList((NodeList)incomplete);
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, empty, incomplete);
    }

    private final void promoteSingleToNodeList(JobNode jobNode) {
        jobNode.addOneIfEmpty(new NodeList());
        LockFreeLinkedListNode lockFreeLinkedListNode = jobNode.getNextNode();
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, jobNode, lockFreeLinkedListNode);
    }

    private final void registerSelectForOnJoin(SelectInstance<?> selectInstance, Object object) {
        if (!this.joinInternal()) {
            selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }
        selectInstance.disposeOnCompletion(this.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)new SelectOnJoinCompletionHandler(this, selectInstance))));
    }

    private final int startInternal(Object object) {
        if (object instanceof Empty) {
            if (((Empty)object).isActive()) {
                return 0;
            }
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, object, JobSupportKt.access$getEMPTY_ACTIVE$p())) {
                return -1;
            }
            this.onStart();
            return 1;
        }
        if (object instanceof InactiveNodeList) {
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, object, ((InactiveNodeList)object).getList())) {
                return -1;
            }
            this.onStart();
            return 1;
        }
        return 0;
    }

    private final String stateString(Object object) {
        boolean bl = object instanceof Finishing;
        String string2 = "Active";
        object = bl ? (((Finishing)object).isCancelling() ? "Cancelling" : (((Finishing)object).isCompleting() ? "Completing" : string2)) : (object instanceof Incomplete ? (((Incomplete)object).isActive() ? string2 : "New") : (object instanceof CompletedExceptionally ? "Cancelled" : "Completed"));
        return object;
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable throwable, String string2, int n, Object object) {
        if (object == null) {
            if ((n & 1) != 0) {
                string2 = null;
            }
            return jobSupport.toCancellationException(throwable, string2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean tryFinalizeSimpleState(Incomplete incomplete, Object object) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = incomplete instanceof Empty || incomplete instanceof JobNode;
            if (!bl) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !(object instanceof CompletedExceptionally ^ true)) {
            throw new AssertionError();
        }
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, incomplete, JobSupportKt.boxIncomplete(object))) {
            return false;
        }
        this.onCancelling(null);
        this.onCompletionInternal(object);
        this.completeStateFinalization(incomplete, object);
        return true;
    }

    private final boolean tryMakeCancelling(Incomplete incomplete, Throwable throwable) {
        if (DebugKt.getASSERTIONS_ENABLED() && !(incomplete instanceof Finishing ^ true)) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !incomplete.isActive()) {
            throw new AssertionError();
        }
        NodeList nodeList = this.getOrPromoteCancellingList(incomplete);
        if (nodeList == null) {
            return false;
        }
        Finishing finishing = new Finishing(nodeList, false, throwable);
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, incomplete, finishing)) {
            return false;
        }
        this.notifyCancelling(nodeList, throwable);
        return true;
    }

    private final Object tryMakeCompleting(Object object, Object object2) {
        if (!(object instanceof Incomplete)) {
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        }
        if ((object instanceof Empty || object instanceof JobNode) && !(object instanceof ChildHandleNode) && !(object2 instanceof CompletedExceptionally)) {
            if (this.tryFinalizeSimpleState((Incomplete)object, object2)) {
                return object2;
            }
            return JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        return this.tryMakeCompletingSlowPath((Incomplete)object, object2);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Object tryMakeCompletingSlowPath(Incomplete object, Object object2) {
        void var2_2;
        NodeList nodeList = this.getOrPromoteCancellingList((Incomplete)object);
        if (nodeList == null) {
            return JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        boolean bl = object instanceof Finishing;
        Object var7_5 = null;
        Object object3 = bl ? (Finishing)object : null;
        bl = false;
        Finishing finishing = object3;
        if (object3 == null) {
            finishing = new Finishing(nodeList, false, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (finishing) {
            if (finishing.isCompleting()) {
                return JobSupportKt.access$getCOMPLETING_ALREADY$p();
            }
            finishing.setCompleting(true);
            if (finishing != object && !AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, object, finishing)) {
                return JobSupportKt.access$getCOMPLETING_RETRY$p();
            }
            if (DebugKt.getASSERTIONS_ENABLED() && !(finishing.isSealed() ^ true)) {
                object = new AssertionError();
                throw object;
            }
            boolean bl2 = finishing.isCancelling();
            object3 = var2_2 instanceof CompletedExceptionally ? (CompletedExceptionally)var2_2 : null;
            if (object3 != null) {
                finishing.addExceptionLocked(((CompletedExceptionally)object3).cause);
            }
            Throwable throwable = finishing.getRootCause();
            if (!bl2) {
                bl = true;
            }
            object3 = var7_5;
            if (Boolean.valueOf(bl).booleanValue()) {
                object3 = throwable;
            }
            objectRef.element = object3;
            object3 = Unit.INSTANCE;
        }
        object3 = (Throwable)objectRef.element;
        if (object3 != null) {
            this.notifyCancelling(nodeList, (Throwable)object3);
        }
        if ((object = this.firstChild((Incomplete)object)) == null) return this.finalizeFinishingState(finishing, var2_2);
        if (!this.tryWaitForChild(finishing, (ChildHandleNode)object, var2_2)) return this.finalizeFinishingState(finishing, var2_2);
        return JobSupportKt.COMPLETING_WAITING_CHILDREN;
    }

    private final boolean tryWaitForChild(Finishing finishing, ChildHandleNode childHandleNode, Object object) {
        do {
            if (Job.DefaultImpls.invokeOnCompletion$default(childHandleNode.childJob, false, false, new ChildCompletion(this, finishing, childHandleNode, object), 1, null) == NonDisposableHandle.INSTANCE) continue;
            return true;
        } while ((childHandleNode = this.nextChild(childHandleNode)) != null);
        return false;
    }

    protected void afterCompletion(Object object) {
    }

    @Override
    public final ChildHandle attachChild(ChildJob object) {
        object = Job.DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildHandleNode((ChildJob)object), 2, null);
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle)object;
    }

    protected final Object awaitInternal(Continuation<Object> continuation) {
        Object object;
        do {
            if ((object = this.getState$kotlinx_coroutines_core()) instanceof Incomplete) continue;
            if (object instanceof CompletedExceptionally) {
                object = ((CompletedExceptionally)object).cause;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    if (!(continuation instanceof CoroutineStackFrame)) {
                        throw object;
                    }
                    throw StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)object, (CoroutineStackFrame)continuation);
                }
                throw object;
            }
            return JobSupportKt.unboxState(object);
        } while (this.startInternal(object) < 0);
        return this.awaitSuspend(continuation);
    }

    @Override
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        Job.DefaultImpls.cancel(this);
    }

    @Override
    public void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(this.cancellationExceptionMessage(), null, this);
        }
        this.cancelInternal(cancellationException);
    }

    @Override
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable throwable) {
        block3: {
            block2: {
                if (throwable == null) break block2;
                CancellationException cancellationException = JobSupport.toCancellationException$default(this, throwable, null, 1, null);
                throwable = cancellationException;
                if (cancellationException != null) break block3;
            }
            throwable = new JobCancellationException(this.cancellationExceptionMessage(), null, this);
        }
        this.cancelInternal(throwable);
        return true;
    }

    public final boolean cancelCoroutine(Throwable throwable) {
        return this.cancelImpl$kotlinx_coroutines_core(throwable);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(Object object) {
        Object object2;
        Object object3 = JobSupportKt.access$getCOMPLETING_ALREADY$p();
        boolean bl = this.getOnCancelComplete$kotlinx_coroutines_core();
        boolean bl2 = true;
        if (bl) {
            object3 = object2 = this.cancelMakeCompleting(object);
            if (object2 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        }
        object2 = object3;
        if (object3 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            object2 = this.makeCancelling(object);
        }
        if (object2 != JobSupportKt.access$getCOMPLETING_ALREADY$p() && object2 != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (object2 == JobSupportKt.access$getTOO_LATE_TO_CANCEL$p()) {
                bl2 = false;
            } else {
                this.afterCompletion(object2);
            }
        }
        return bl2;
    }

    public void cancelInternal(Throwable throwable) {
        this.cancelImpl$kotlinx_coroutines_core(throwable);
    }

    protected String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(Throwable throwable) {
        boolean bl = throwable instanceof CancellationException;
        boolean bl2 = true;
        if (bl) {
            return true;
        }
        if (!this.cancelImpl$kotlinx_coroutines_core(throwable) || !this.getHandlesException$kotlinx_coroutines_core()) {
            bl2 = false;
        }
        return bl2;
    }

    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(String string2, Throwable throwable) {
        if (string2 == null) {
            string2 = this.cancellationExceptionMessage();
        }
        return new JobCancellationException(string2, throwable, this);
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return Job.DefaultImpls.fold(this, r, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return Job.DefaultImpls.get(this, key);
    }

    @Override
    public final CancellationException getCancellationException() {
        block7: {
            Object object;
            block6: {
                block5: {
                    object = this.getState$kotlinx_coroutines_core();
                    if (!(object instanceof Finishing)) break block5;
                    if ((object = ((Finishing)object).getRootCause()) == null || (object = this.toCancellationException((Throwable)object, DebugStringsKt.getClassSimpleName(this) + " is cancelling")) == null) {
                        throw new IllegalStateException(("Job is still new or active: " + this).toString());
                    }
                    break block6;
                }
                if (object instanceof Incomplete) break block7;
                object = object instanceof CompletedExceptionally ? JobSupport.toCancellationException$default(this, ((CompletedExceptionally)object).cause, null, 1, null) : (CancellationException)new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", null, this);
            }
            return object;
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override
    public CancellationException getChildJobCancellationCause() {
        Object object;
        block8: {
            Throwable throwable;
            CancellationException cancellationException;
            block6: {
                block7: {
                    block5: {
                        object = this.getState$kotlinx_coroutines_core();
                        boolean bl = object instanceof Finishing;
                        cancellationException = null;
                        if (!bl) break block5;
                        throwable = ((Finishing)object).getRootCause();
                        break block6;
                    }
                    if (!(object instanceof CompletedExceptionally)) break block7;
                    throwable = ((CompletedExceptionally)object).cause;
                    break block6;
                }
                if (object instanceof Incomplete) break block8;
                throwable = null;
            }
            if (throwable instanceof CancellationException) {
                cancellationException = (CancellationException)throwable;
            }
            CancellationException cancellationException2 = cancellationException;
            if (cancellationException == null) {
                cancellationException2 = new JobCancellationException("Parent job is " + this.stateString(object), throwable, this);
            }
            return cancellationException2;
        }
        throw new IllegalStateException(("Cannot be cancelling child in this state: " + object).toString());
    }

    @Override
    public final Sequence<Job> getChildren() {
        return SequencesKt.sequence((Function2)((Function2)new Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object>(this, null){
            private Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final JobSupport this$0;
            {
                this.this$0 = jobSupport;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(SequenceScope<? super Job> sequenceScope, Continuation<? super Unit> continuation) {
                return (this.create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[SWITCH], 4[CASE]], but top level block is 5[WHILELOOP]
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
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.dumpInner(CastExpression.java:114)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:139)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.dumpInner(CastExpression.java:114)
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
        }));
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object object = this.getState$kotlinx_coroutines_core();
        if (object instanceof Incomplete ^ true) {
            if (!(object instanceof CompletedExceptionally)) {
                return JobSupportKt.unboxState(object);
            }
            throw ((CompletedExceptionally)object).cause;
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    protected final Throwable getCompletionCause() {
        block7: {
            Object object;
            block6: {
                block5: {
                    object = this.getState$kotlinx_coroutines_core();
                    if (!(object instanceof Finishing)) break block5;
                    if ((object = ((Finishing)object).getRootCause()) == null) {
                        throw new IllegalStateException(("Job is still new or active: " + this).toString());
                    }
                    break block6;
                }
                if (object instanceof Incomplete) break block7;
                object = object instanceof CompletedExceptionally ? ((CompletedExceptionally)object).cause : null;
            }
            return object;
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    protected final boolean getCompletionCauseHandled() {
        Object object = this.getState$kotlinx_coroutines_core();
        boolean bl = object instanceof CompletedExceptionally && ((CompletedExceptionally)object).getHandled();
        return bl;
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object object = this.getState$kotlinx_coroutines_core();
        if (object instanceof Incomplete ^ true) {
            return this.getExceptionOrNull(object);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    public final CoroutineContext.Key<?> getKey() {
        return Job.Key;
    }

    protected final SelectClause1<?> getOnAwaitInternal() {
        onAwaitInternal.1 var1_1 = onAwaitInternal.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var1_1), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        var1_1 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var1_1), (int)3);
        onAwaitInternal.2 var2_2 = onAwaitInternal.2.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var2_2), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, var1_1, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var2_2), (int)3), null, 8, null);
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @Override
    public final SelectClause0 getOnJoin() {
        onJoin.1 var1_1 = onJoin.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var1_1), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new SelectClause0Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var1_1), (int)3), null, 4, null);
    }

    @Override
    public Job getParent() {
        Object object = this.getParentHandle$kotlinx_coroutines_core();
        object = object != null ? object.getParent() : null;
        return object;
    }

    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle)_parentHandle$FU.get(this);
    }

    public final Object getState$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        Object v;
        while ((v = atomicReferenceFieldUpdater.get(this)) instanceof OpDescriptor) {
            ((OpDescriptor)v).perform(this);
        }
        return v;
    }

    protected boolean handleJobException(Throwable throwable) {
        return false;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable throwable) {
        throw throwable;
    }

    protected final void initParentJob(Job object) {
        boolean bl;
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = this.getParentHandle$kotlinx_coroutines_core() == null)) {
            throw new AssertionError();
        }
        if (object == null) {
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        object.start();
        object = object.attachChild(this);
        this.setParentHandle$kotlinx_coroutines_core((ChildHandle)object);
        if (this.isCompleted()) {
            object.dispose();
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    @Override
    public final DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        return this.invokeOnCompletion(false, true, function1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final DisposableHandle invokeOnCompletion(boolean bl, boolean bl2, Function1<? super Throwable, Unit> object) {
        Object object2;
        Object object3;
        Object object4;
        block14: {
            JobNode jobNode = this.makeNode((Function1<? super Throwable, Unit>)object, bl);
            while (true) {
                Throwable throwable;
                NodeList nodeList;
                block15: {
                    if ((object4 = this.getState$kotlinx_coroutines_core()) instanceof Empty) {
                        if (((Empty)object4).isActive()) {
                            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, object4, jobNode)) continue;
                            return jobNode;
                        }
                        this.promoteEmptyToNodeList((Empty)object4);
                        continue;
                    }
                    if (!(object4 instanceof Incomplete)) break block14;
                    nodeList = ((Incomplete)object4).getList();
                    if (nodeList == null) {
                        Intrinsics.checkNotNull((Object)object4, (String)"null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        this.promoteSingleToNodeList((JobNode)object4);
                        continue;
                    }
                    Throwable throwable2 = null;
                    object3 = NonDisposableHandle.INSTANCE;
                    throwable = throwable2;
                    object2 = object3;
                    if (!bl) break block15;
                    throwable = throwable2;
                    object2 = object3;
                    if (!(object4 instanceof Finishing)) break block15;
                    synchronized (object4) {
                        block17: {
                            boolean bl3;
                            block16: {
                                throwable = ((Finishing)object4).getRootCause();
                                if (throwable == null) break block16;
                                object2 = object3;
                                if (!(object instanceof ChildHandleNode)) break block17;
                                object2 = object3;
                                if (((Finishing)object4).isCompleting()) break block17;
                            }
                            if (!(bl3 = this.addLastAtomic(object4, nodeList, jobNode))) {
                                continue;
                            }
                            if (throwable == null) {
                                return jobNode;
                            }
                            object2 = jobNode;
                        }
                        object3 = Unit.INSTANCE;
                    }
                }
                if (throwable != null) {
                    if (!bl2) return (DisposableHandle)object2;
                    object.invoke(throwable);
                    return (DisposableHandle)object2;
                }
                if (this.addLastAtomic(object4, nodeList, jobNode)) break;
            }
            return jobNode;
        }
        if (!bl2) return NonDisposableHandle.INSTANCE;
        bl = object4 instanceof CompletedExceptionally;
        object3 = null;
        object2 = bl ? (CompletedExceptionally)object4 : null;
        if (object2 != null) {
            object3 = ((CompletedExceptionally)object2).cause;
        }
        object.invoke(object3);
        return NonDisposableHandle.INSTANCE;
    }

    @Override
    public boolean isActive() {
        Object object = this.getState$kotlinx_coroutines_core();
        boolean bl = object instanceof Incomplete && ((Incomplete)object).isActive();
        return bl;
    }

    @Override
    public final boolean isCancelled() {
        Object object = this.getState$kotlinx_coroutines_core();
        boolean bl = object instanceof CompletedExceptionally || object instanceof Finishing && ((Finishing)object).isCancelling();
        return bl;
    }

    @Override
    public final boolean isCompleted() {
        return this.getState$kotlinx_coroutines_core() instanceof Incomplete ^ true;
    }

    public final boolean isCompletedExceptionally() {
        return this.getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    protected boolean isScopedCoroutine() {
        return false;
    }

    @Override
    public final Object join(Continuation<? super Unit> object) {
        if (!this.joinInternal()) {
            JobKt.ensureActive(object.getContext());
            return Unit.INSTANCE;
        }
        if ((object = this.joinSuspend((Continuation<? super Unit>)object)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object object) {
        Object object2;
        do {
            if ((object2 = this.tryMakeCompleting(this.getState$kotlinx_coroutines_core(), object)) == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                return false;
            }
            if (object2 != JobSupportKt.COMPLETING_WAITING_CHILDREN) continue;
            return true;
        } while (object2 == JobSupportKt.access$getCOMPLETING_RETRY$p());
        this.afterCompletion(object2);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object object) {
        Object object2;
        while ((object2 = this.tryMakeCompleting(this.getState$kotlinx_coroutines_core(), object)) != JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            if (object2 == JobSupportKt.access$getCOMPLETING_RETRY$p()) continue;
            return object2;
        }
        object2 = new StringBuilder().append("Job ").append(this).append(" is already complete or completing, but is being completed with ");
        throw new IllegalStateException(((StringBuilder)object2).append(object).toString(), this.getExceptionOrNull(object));
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.minusKey(this, key);
    }

    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    protected void onCancelling(Throwable throwable) {
    }

    protected void onCompletionInternal(Object object) {
    }

    protected void onStart() {
    }

    @Override
    public final void parentCancelled(ParentJob parentJob) {
        this.cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return Job.DefaultImpls.plus((Job)this, coroutineContext);
    }

    @Override
    @Deprecated(level=DeprecationLevel.ERROR, message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(Job job2) {
        return Job.DefaultImpls.plus((Job)this, job2);
    }

    public final void removeNode$kotlinx_coroutines_core(JobNode jobNode) {
        Object object;
        while ((object = this.getState$kotlinx_coroutines_core()) instanceof JobNode) {
            if (object != jobNode) {
                return;
            }
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, object, JobSupportKt.access$getEMPTY_ACTIVE$p())) continue;
            return;
        }
        if (object instanceof Incomplete) {
            if (((Incomplete)object).getList() != null) {
                jobNode.remove();
            }
            return;
        }
    }

    public final void setParentHandle$kotlinx_coroutines_core(ChildHandle childHandle) {
        _parentHandle$FU.set(this, childHandle);
    }

    @Override
    public final boolean start() {
        block4: while (true) {
            switch (this.startInternal(this.getState$kotlinx_coroutines_core())) {
                default: {
                    continue block4;
                }
                case 1: {
                    return true;
                }
                case 0: 
            }
            break;
        }
        return false;
    }

    protected final CancellationException toCancellationException(Throwable throwable, String string2) {
        CancellationException cancellationException = throwable instanceof CancellationException ? (CancellationException)throwable : null;
        CancellationException cancellationException2 = cancellationException;
        if (cancellationException == null) {
            if (string2 == null) {
                string2 = this.cancellationExceptionMessage();
            }
            cancellationException2 = new JobCancellationException(string2, throwable, this);
        }
        return cancellationException2;
    }

    public final String toDebugString() {
        return this.nameString$kotlinx_coroutines_core() + '{' + this.stateString(this.getState$kotlinx_coroutines_core()) + '}';
    }

    public String toString() {
        return this.toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private static final class AwaitContinuation<T>
    extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        public AwaitContinuation(Continuation<? super T> continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.job = jobSupport;
        }

        @Override
        public Throwable getContinuationCancellationCause(Job job2) {
            Throwable throwable;
            Object object = this.job.getState$kotlinx_coroutines_core();
            if (object instanceof Finishing && (throwable = ((Finishing)object).getRootCause()) != null) {
                return throwable;
            }
            if (object instanceof CompletedExceptionally) {
                return ((CompletedExceptionally)object).cause;
            }
            return job2.getCancellationException();
        }

        @Override
        protected String nameString() {
            return "AwaitContinuation";
        }
    }

    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private static final class ChildCompletion
    extends JobNode {
        private final ChildHandleNode child;
        private final JobSupport parent;
        private final Object proposedUpdate;
        private final Finishing state;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object object) {
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = object;
        }

        @Override
        public void invoke(Throwable throwable) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }
    }

    @Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tJ\u0018\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\t0&j\b\u0012\u0004\u0012\u00020\t`'H\u0002J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0)2\b\u0010*\u001a\u0004\u0018\u00010\tJ\b\u0010+\u001a\u00020,H\u0016R\u0011\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0011\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fX\u0082\u0004R(\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0017\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006-"}, d2={"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "_exceptionsHolder", "Lkotlinx/atomicfu/AtomicRef;", "_isCompleting", "Lkotlinx/atomicfu/AtomicBoolean;", "_rootCause", "value", "exceptionsHolder", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "(Ljava/lang/Throwable;)V", "addExceptionLocked", "", "exception", "allocateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sealLocked", "", "proposedException", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private static final class Finishing
    implements Incomplete {
        private static final AtomicReferenceFieldUpdater _exceptionsHolder$FU;
        private static final AtomicIntegerFieldUpdater _isCompleting$FU;
        private static final AtomicReferenceFieldUpdater _rootCause$FU;
        @Volatile
        private volatile Object _exceptionsHolder;
        @Volatile
        private volatile int _isCompleting;
        @Volatile
        private volatile Object _rootCause;
        private final NodeList list;

        static {
            _isCompleting$FU = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting");
            _rootCause$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause");
            _exceptionsHolder$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder");
        }

        public Finishing(NodeList nodeList, boolean bl, Throwable throwable) {
            this.list = nodeList;
            this._isCompleting = bl ? 1 : 0;
            this._rootCause = throwable;
        }

        private final ArrayList<Throwable> allocateList() {
            return new ArrayList<Throwable>(4);
        }

        private final Object getExceptionsHolder() {
            return _exceptionsHolder$FU.get(this);
        }

        private final void setExceptionsHolder(Object object) {
            _exceptionsHolder$FU.set(this, object);
        }

        public final void addExceptionLocked(Throwable throwable) {
            Object object;
            block9: {
                block7: {
                    block8: {
                        Serializable serializable;
                        block6: {
                            serializable = this.getRootCause();
                            if (serializable == null) {
                                this.setRootCause(throwable);
                                return;
                            }
                            if (throwable == serializable) {
                                return;
                            }
                            object = this.getExceptionsHolder();
                            if (object != null) break block6;
                            this.setExceptionsHolder(throwable);
                            break block7;
                        }
                        if (!(object instanceof Throwable)) break block8;
                        if (throwable == object) {
                            return;
                        }
                        serializable = this.allocateList();
                        ((ArrayList)serializable).add(object);
                        ((ArrayList)serializable).add(throwable);
                        this.setExceptionsHolder(serializable);
                        break block7;
                    }
                    if (!(object instanceof ArrayList)) break block9;
                    ((ArrayList)object).add(throwable);
                }
                return;
            }
            throw new IllegalStateException(("State is " + object).toString());
        }

        @Override
        public NodeList getList() {
            return this.list;
        }

        public final Throwable getRootCause() {
            return (Throwable)_rootCause$FU.get(this);
        }

        @Override
        public boolean isActive() {
            boolean bl = this.getRootCause() == null;
            return bl;
        }

        public final boolean isCancelling() {
            boolean bl = this.getRootCause() != null;
            return bl;
        }

        public final boolean isCompleting() {
            boolean bl = _isCompleting$FU.get(this) != 0;
            return bl;
        }

        public final boolean isSealed() {
            boolean bl = this.getExceptionsHolder() == JobSupportKt.access$getSEALED$p();
            return bl;
        }

        public final List<Throwable> sealLocked(Throwable throwable) {
            Object object;
            block8: {
                ArrayList arrayList;
                block6: {
                    block7: {
                        block5: {
                            object = this.getExceptionsHolder();
                            if (object != null) break block5;
                            arrayList = this.allocateList();
                            break block6;
                        }
                        if (!(object instanceof Throwable)) break block7;
                        arrayList = this.allocateList();
                        arrayList.add((Throwable)object);
                        break block6;
                    }
                    if (!(object instanceof ArrayList)) break block8;
                    arrayList = (ArrayList)object;
                }
                object = this.getRootCause();
                if (object != null) {
                    arrayList.add(0, object);
                }
                if (throwable != null && !Intrinsics.areEqual((Object)throwable, (Object)object)) {
                    arrayList.add(throwable);
                }
                this.setExceptionsHolder(JobSupportKt.access$getSEALED$p());
                return arrayList;
            }
            throw new IllegalStateException(("State is " + object).toString());
        }

        public final void setCompleting(boolean bl) {
            _isCompleting$FU.set(this, bl ? 1 : 0);
        }

        public final void setRootCause(Throwable throwable) {
            _rootCause$FU.set(this, throwable);
        }

        public String toString() {
            return "Finishing[cancelling=" + this.isCancelling() + ", completing=" + this.isCompleting() + ", rootCause=" + this.getRootCause() + ", exceptions=" + this.getExceptionsHolder() + ", list=" + this.getList() + ']';
        }
    }

    @Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lkotlinx/coroutines/JobSupport$SelectOnAwaitCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class SelectOnAwaitCompletionHandler
    extends JobNode {
        private final SelectInstance<?> select;
        final JobSupport this$0;

        public SelectOnAwaitCompletionHandler(JobSupport jobSupport, SelectInstance<?> selectInstance) {
            this.this$0 = jobSupport;
            this.select = selectInstance;
        }

        @Override
        public void invoke(Throwable object) {
            object = this.this$0.getState$kotlinx_coroutines_core();
            if (!(object instanceof CompletedExceptionally)) {
                object = JobSupportKt.unboxState(object);
            }
            this.select.trySelect(this.this$0, object);
        }
    }

    @Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lkotlinx/coroutines/JobSupport$SelectOnJoinCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class SelectOnJoinCompletionHandler
    extends JobNode {
        private final SelectInstance<?> select;
        final JobSupport this$0;

        public SelectOnJoinCompletionHandler(JobSupport jobSupport, SelectInstance<?> selectInstance) {
            this.this$0 = jobSupport;
            this.select = selectInstance;
        }

        @Override
        public void invoke(Throwable throwable) {
            this.select.trySelect(this.this$0, Unit.INSTANCE);
        }
    }
}

