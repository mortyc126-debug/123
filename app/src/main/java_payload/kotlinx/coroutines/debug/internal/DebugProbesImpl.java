/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinVersion
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.concurrent.ThreadsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.ranges.RangesKt
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.StringsKt
 */
package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.debug.internal.AgentInstallationType;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfo;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import kotlinx.coroutines.debug.internal.DebugProbesImplKt;
import kotlinx.coroutines.debug.internal.DebuggerInfo;
import kotlinx.coroutines.debug.internal.StackTraceFrame;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata(d1={"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001wB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J,\u0010.\u001a\b\u0012\u0004\u0012\u0002H00/\"\u0004\b\u0000\u001002\f\u00101\u001a\b\u0012\u0004\u0012\u0002H00/2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u000e\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u000206J\f\u00107\u001a\b\u0012\u0004\u0012\u00020908J\u0011\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00010;\u00a2\u0006\u0002\u0010<J9\u0010=\u001a\b\u0012\u0004\u0012\u0002H>08\"\b\b\u0000\u0010>*\u00020\u00012\u001e\b\u0004\u0010?\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u0002H>0@H\u0082\bJ\u0010\u0010B\u001a\u00020\u00142\u0006\u00105\u001a\u000206H\u0002J\f\u0010C\u001a\b\u0012\u0004\u0012\u00020D08J\"\u0010E\u001a\b\u0012\u0004\u0012\u00020\u0004082\u0006\u0010F\u001a\u0002092\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000408J\u000e\u0010H\u001a\u00020&2\u0006\u0010F\u001a\u000209J.\u0010I\u001a\b\u0012\u0004\u0012\u00020\u0004082\u0006\u0010J\u001a\u00020&2\b\u0010K\u001a\u0004\u0018\u00010$2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000408H\u0002J=\u0010L\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001a\u00020N2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040;2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000408H\u0002\u00a2\u0006\u0002\u0010QJ1\u0010R\u001a\u00020N2\u0006\u0010S\u001a\u00020N2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040;2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000408H\u0002\u00a2\u0006\u0002\u0010TJ\u0016\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\u000e\u0010V\u001a\u00020&2\u0006\u0010W\u001a\u00020'J\u0006\u0010X\u001a\u00020\u0014J\u001e\u0010Y\u001a\u00020\u00142\u0006\u00105\u001a\u0002062\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u000408H\u0002J\u0014\u0010[\u001a\u00020\u00142\n\u0010\\\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002J'\u0010]\u001a\b\u0012\u0004\u0012\u0002H00/\"\u0004\b\u0000\u001002\f\u00101\u001a\b\u0012\u0004\u0012\u0002H00/H\u0000\u00a2\u0006\u0002\b^J\u0019\u0010_\u001a\u00020\u00142\n\u00102\u001a\u0006\u0012\u0002\b\u00030/H\u0000\u00a2\u0006\u0002\b`J\u0019\u0010a\u001a\u00020\u00142\n\u00102\u001a\u0006\u0012\u0002\b\u00030/H\u0000\u00a2\u0006\u0002\bbJ%\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000408\"\b\b\u0000\u00100*\u00020d2\u0006\u0010e\u001a\u0002H0H\u0002\u00a2\u0006\u0002\u0010fJ\b\u0010g\u001a\u00020\u0014H\u0002J\b\u0010h\u001a\u00020\u0014H\u0002J\u0006\u0010i\u001a\u00020\u0014J\u0018\u0010j\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00072\u0006\u0010J\u001a\u00020&H\u0002J\u001c\u0010k\u001a\u00020\u00142\n\u00102\u001a\u0006\u0012\u0002\b\u00030/2\u0006\u0010J\u001a\u00020&H\u0002J(\u0010k\u001a\u00020\u00142\n\u0010\\\u001a\u0006\u0012\u0002\b\u00030\u000b2\n\u00102\u001a\u0006\u0012\u0002\b\u00030/2\u0006\u0010J\u001a\u00020&H\u0002J4\u0010l\u001a\u00020\u0014*\u00020'2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\b0n2\n\u0010o\u001a\u00060pj\u0002`q2\u0006\u0010r\u001a\u00020&H\u0002J\u0010\u0010s\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u000bH\u0002J\u0016\u0010\\\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b*\u0006\u0012\u0002\b\u00030/H\u0002J\u0013\u0010\\\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b*\u00020\u0007H\u0082\u0010J\u000f\u0010t\u001a\u0004\u0018\u00010\u0007*\u00020\u0007H\u0082\u0010J\u0012\u0010u\u001a\u000203*\b\u0012\u0004\u0012\u00020\u000408H\u0002J\f\u0010v\u001a\u00020&*\u00020\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\t\u0010\u001a\u001a\u00020\u001bX\u0082\u0004R\u0014\u0010\u001c\u001a\u00020\u000f8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\t\u0010!\u001a\u00020\"X\u0082\u0004R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020&*\u00020'8BX\u0082\u0004\u00a2\u0006\f\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010,\u001a\u00020\u000f*\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u0006x"}, d2={"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "()V", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "callerInfoCache", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "capturedCoroutines", "", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "getCapturedCoroutines", "()Ljava/util/Set;", "capturedCoroutinesMap", "", "dateFormat", "Ljava/text/SimpleDateFormat;", "dynamicAttach", "Lkotlin/Function1;", "", "enableCreationStackTraces", "getEnableCreationStackTraces", "()Z", "setEnableCreationStackTraces", "(Z)V", "installations", "Lkotlinx/atomicfu/AtomicInt;", "isInstalled", "isInstalled$kotlinx_coroutines_core", "sanitizeStackTraces", "getSanitizeStackTraces", "setSanitizeStackTraces", "sequenceNumber", "Lkotlinx/atomicfu/AtomicLong;", "weakRefCleanerThread", "Ljava/lang/Thread;", "debugString", "", "Lkotlinx/coroutines/Job;", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "getDebugString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "createOwner", "Lkotlin/coroutines/Continuation;", "T", "completion", "frame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "dumpCoroutines", "out", "Ljava/io/PrintStream;", "dumpCoroutinesInfo", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfoAsJsonAndReferences", "", "()[Ljava/lang/Object;", "dumpCoroutinesInfoImpl", "R", "create", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "dumpCoroutinesSynchronized", "dumpDebuggerInfo", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "enhanceStackTraceWithThreadDump", "info", "coroutineTrace", "enhanceStackTraceWithThreadDumpAsJson", "enhanceStackTraceWithThreadDumpImpl", "state", "thread", "findContinuationStartIndex", "Lkotlin/Pair;", "", "indexOfResumeWith", "actualTrace", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "findIndexOfFrame", "frameIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "getDynamicAttach", "hierarchyToString", "job", "install", "printStackTrace", "frames", "probeCoroutineCompleted", "owner", "probeCoroutineCreated", "probeCoroutineCreated$kotlinx_coroutines_core", "probeCoroutineResumed", "probeCoroutineResumed$kotlinx_coroutines_core", "probeCoroutineSuspended", "probeCoroutineSuspended$kotlinx_coroutines_core", "sanitizeStackTrace", "", "throwable", "(Ljava/lang/Throwable;)Ljava/util/List;", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "uninstall", "updateRunningState", "updateState", "build", "map", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "indent", "isFinished", "realCaller", "toStackTraceFrame", "toStringRepr", "CoroutineOwner", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class DebugProbesImpl {
    private static final StackTraceElement ARTIFICIAL_FRAME;
    public static final DebugProbesImpl INSTANCE;
    private static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> callerInfoCache;
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> capturedCoroutinesMap;
    private static final SimpleDateFormat dateFormat;
    private static final Function1<Boolean, Unit> dynamicAttach;
    private static boolean enableCreationStackTraces;
    private static final Installations.kotlinx.VolatileWrapper installations$kotlinx$VolatileWrapper;
    private static boolean sanitizeStackTraces;
    private static final SequenceNumber.kotlinx.VolatileWrapper sequenceNumber$kotlinx$VolatileWrapper;
    private static Thread weakRefCleanerThread;

    static {
        INSTANCE = new DebugProbesImpl();
        ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineCreation();
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        capturedCoroutinesMap = new ConcurrentWeakMap(false, 1, null);
        sanitizeStackTraces = true;
        enableCreationStackTraces = true;
        dynamicAttach = INSTANCE.getDynamicAttach();
        callerInfoCache = new ConcurrentWeakMap(true);
        installations$kotlinx$VolatileWrapper = new Installations.kotlinx.VolatileWrapper(null);
        sequenceNumber$kotlinx$VolatileWrapper = new SequenceNumber.kotlinx.VolatileWrapper(null);
    }

    private DebugProbesImpl() {
    }

    public static final /* synthetic */ ConcurrentWeakMap access$getCallerInfoCache$p() {
        return callerInfoCache;
    }

    public static final /* synthetic */ boolean access$isFinished(DebugProbesImpl debugProbesImpl, CoroutineOwner coroutineOwner) {
        return debugProbesImpl.isFinished(coroutineOwner);
    }

    private final void build(Job object, Map<Job, DebugCoroutineInfoImpl> map2, StringBuilder stringBuilder, String string2) {
        Object object2 = map2.get(object);
        if (object2 == null) {
            if (!(object instanceof ScopeCoroutine)) {
                stringBuilder.append(string2 + this.getDebugString((Job)object) + '\n');
                string2 = string2 + '\t';
            }
        } else {
            StackTraceElement stackTraceElement = (StackTraceElement)CollectionsKt.firstOrNull(((DebugCoroutineInfoImpl)object2).lastObservedStackTrace());
            object2 = ((DebugCoroutineInfoImpl)object2).getState();
            stringBuilder.append(string2 + this.getDebugString((Job)object) + ", continuation is " + (String)object2 + " at line " + stackTraceElement + '\n');
            string2 = string2 + '\t';
        }
        object = object.getChildren().iterator();
        while (object.hasNext()) {
            this.build((Job)object.next(), map2, stringBuilder, string2);
        }
    }

    private final <T> Continuation<T> createOwner(Continuation<? super T> continuation, StackTraceFrame stackTraceFrame) {
        if (!this.isInstalled$kotlinx_coroutines_core()) {
            return continuation;
        }
        continuation = new CoroutineOwner<T>(continuation, new DebugCoroutineInfoImpl(continuation.getContext(), stackTraceFrame, SequenceNumber.kotlinx.VolatileWrapper.sequenceNumber$FU.incrementAndGet(sequenceNumber$kotlinx$VolatileWrapper)));
        ((Map)((Object)capturedCoroutinesMap)).put(continuation, true);
        if (!this.isInstalled$kotlinx_coroutines_core()) {
            capturedCoroutinesMap.clear();
        }
        return continuation;
    }

    private final <R> List<R> dumpCoroutinesInfoImpl(Function2<? super CoroutineOwner<?>, ? super CoroutineContext, ? extends R> function2) {
        if (this.isInstalled$kotlinx_coroutines_core()) {
            Sequence sequence = CollectionsKt.asSequence((Iterable)this.getCapturedCoroutines());
            return SequencesKt.toList((Sequence)SequencesKt.mapNotNull((Sequence)SequencesKt.sortedWith((Sequence)sequence, (Comparator)new Comparator(){

                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Comparable)Long.valueOf(((CoroutineOwner)t).info.sequenceNumber), (Comparable)Long.valueOf(((CoroutineOwner)t2).info.sequenceNumber));
                }
            }), (Function1)new Function1<CoroutineOwner<?>, R>(function2){
                final Function2<CoroutineOwner<?>, CoroutineContext, R> $create;
                {
                    this.$create = function2;
                    super(1);
                }

                public final R invoke(CoroutineOwner<?> coroutineOwner) {
                    CoroutineContext coroutineContext;
                    boolean bl = DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, coroutineOwner);
                    Object object = null;
                    if (!bl && (coroutineContext = coroutineOwner.info.getContext()) != null) {
                        object = this.$create.invoke(coroutineOwner, (Object)coroutineContext);
                    }
                    return (R)object;
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final void dumpCoroutinesSynchronized(PrintStream printStream) {
        if (this.isInstalled$kotlinx_coroutines_core()) {
            printStream.print("Coroutines dump " + dateFormat.format(System.currentTimeMillis()));
            Object object = SequencesKt.filter((Sequence)CollectionsKt.asSequence((Iterable)this.getCapturedCoroutines()), (Function1)dumpCoroutinesSynchronized.2.INSTANCE);
            object = SequencesKt.sortedWith((Sequence)object, (Comparator)new Comparator(){

                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Comparable)Long.valueOf(((CoroutineOwner)t).info.sequenceNumber), (Comparable)Long.valueOf(((CoroutineOwner)t2).info.sequenceNumber));
                }
            });
            for (CoroutineOwner coroutineOwner : object) {
                DebugCoroutineInfoImpl debugCoroutineInfoImpl = coroutineOwner.info;
                List<StackTraceElement> list = debugCoroutineInfoImpl.lastObservedStackTrace();
                List<StackTraceElement> list2 = INSTANCE.enhanceStackTraceWithThreadDumpImpl(debugCoroutineInfoImpl.getState(), debugCoroutineInfoImpl.lastObservedThread, list);
                object = Intrinsics.areEqual((Object)debugCoroutineInfoImpl.getState(), (Object)"RUNNING") && list2 == list ? debugCoroutineInfoImpl.getState() + " (Last suspension stacktrace, not an actual stacktrace)" : debugCoroutineInfoImpl.getState();
                printStream.print("\n\nCoroutine " + coroutineOwner.delegate + ", state: " + (String)object);
                if (list.isEmpty()) {
                    printStream.print("\n\tat " + ARTIFICIAL_FRAME);
                    INSTANCE.printStackTrace(printStream, debugCoroutineInfoImpl.getCreationStackTrace());
                    continue;
                }
                INSTANCE.printStackTrace(printStream, list2);
            }
            return;
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl(String stackTraceElementArray, Thread object, List<StackTraceElement> list) {
        if (Intrinsics.areEqual((Object)stackTraceElementArray, (Object)"RUNNING") && object != null) {
            int n;
            int n2;
            int n3;
            block10: {
                try {
                    stackTraceElementArray = Result.Companion;
                    stackTraceElementArray = this;
                    stackTraceElementArray = Result.constructor-impl((Object)object.getStackTrace());
                }
                catch (Throwable throwable) {
                    object = Result.Companion;
                    stackTraceElementArray = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                }
                object = stackTraceElementArray;
                if (Result.isFailure-impl((Object)stackTraceElementArray)) {
                    object = null;
                }
                if ((stackTraceElementArray = (StackTraceElement[])object) == null) {
                    return list;
                }
                n3 = stackTraceElementArray.length;
                for (n2 = 0; n2 < n3; ++n2) {
                    object = stackTraceElementArray[n2];
                    n = Intrinsics.areEqual((Object)object.getClassName(), (Object)"kotlin.coroutines.jvm.internal.BaseContinuationImpl") && Intrinsics.areEqual((Object)object.getMethodName(), (Object)"resumeWith") && Intrinsics.areEqual((Object)object.getFileName(), (Object)"ContinuationImpl.kt") ? 1 : 0;
                    if (n == 0) {
                        continue;
                    }
                    break block10;
                }
                n2 = -1;
            }
            object = this.findContinuationStartIndex(n2, stackTraceElementArray, list);
            int n4 = ((Number)object.component1()).intValue();
            n3 = ((Number)object.component2()).intValue();
            if (n4 == -1) {
                return list;
            }
            object = new ArrayList(list.size() + n2 - n4 - 1 - n3);
            for (n = 0; n < n2 - n3; ++n) {
                ((Collection)object).add(stackTraceElementArray[n]);
            }
            n = list.size();
            for (n2 = n4 + 1; n2 < n; ++n2) {
                ((Collection)object).add(list.get(n2));
            }
            return (List)object;
        }
        return list;
    }

    private final Pair<Integer, Integer> findContinuationStartIndex(int n, StackTraceElement[] stackTraceElementArray, List<StackTraceElement> list) {
        for (int i = 0; i < 3; ++i) {
            int n2 = INSTANCE.findIndexOfFrame(n - 1 - i, stackTraceElementArray, list);
            if (n2 == -1) continue;
            return TuplesKt.to((Object)n2, (Object)i);
        }
        return TuplesKt.to((Object)-1, (Object)0);
    }

    private final int findIndexOfFrame(int n, StackTraceElement[] object, List<StackTraceElement> object2) {
        block3: {
            object = (StackTraceElement)ArraysKt.getOrNull((Object[])object, (int)n);
            int n2 = -1;
            if (object == null) {
                return -1;
            }
            n = 0;
            object2 = object2.iterator();
            while (object2.hasNext()) {
                StackTraceElement stackTraceElement = (StackTraceElement)object2.next();
                boolean bl = Intrinsics.areEqual((Object)stackTraceElement.getFileName(), (Object)((StackTraceElement)object).getFileName()) && Intrinsics.areEqual((Object)stackTraceElement.getClassName(), (Object)((StackTraceElement)object).getClassName()) && Intrinsics.areEqual((Object)stackTraceElement.getMethodName(), (Object)((StackTraceElement)object).getMethodName());
                if (!bl) {
                    ++n;
                    continue;
                }
                break block3;
            }
            n = n2;
        }
        return n;
    }

    private final Set<CoroutineOwner<?>> getCapturedCoroutines() {
        return capturedCoroutinesMap.keySet();
    }

    private final String getDebugString(Job object) {
        object = object instanceof JobSupport ? ((JobSupport)object).toDebugString() : object.toString();
        return object;
    }

    private static /* synthetic */ void getDebugString$annotations(Job job2) {
    }

    private final Function1<Boolean, Unit> getDynamicAttach() {
        Object object;
        try {
            object = Result.Companion;
            object = this;
            object = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            object = Result.constructor-impl((Object)((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)object, (int)1)));
        }
        catch (Throwable throwable) {
            object = Result.Companion;
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        Object object2 = object;
        if (Result.isFailure-impl((Object)object)) {
            object2 = null;
        }
        return (Function1)object2;
    }

    private final boolean isFinished(CoroutineOwner<?> coroutineOwner) {
        Object object = coroutineOwner.info.getContext();
        if (object != null && (object = (Job)object.get((CoroutineContext.Key)Job.Key)) != null) {
            if (!object.isCompleted()) {
                return false;
            }
            capturedCoroutinesMap.remove(coroutineOwner);
            return true;
        }
        return false;
    }

    private final boolean isInternalMethod(StackTraceElement stackTraceElement) {
        return StringsKt.startsWith$default((String)stackTraceElement.getClassName(), (String)"kotlinx.coroutines", (boolean)false, (int)2, null);
    }

    private final CoroutineOwner<?> owner(Continuation<?> object) {
        boolean bl = object instanceof CoroutineStackFrame;
        CoroutineOwner<?> coroutineOwner = null;
        object = bl ? (CoroutineStackFrame)object : null;
        if (object != null) {
            coroutineOwner = this.owner((CoroutineStackFrame)object);
        }
        return coroutineOwner;
    }

    private final CoroutineOwner<?> owner(CoroutineStackFrame coroutineStackFrame) {
        block1: {
            do {
                if (!(coroutineStackFrame instanceof CoroutineOwner)) continue;
                coroutineStackFrame = (CoroutineOwner)coroutineStackFrame;
                break block1;
            } while ((coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null);
            coroutineStackFrame = null;
        }
        return coroutineStackFrame;
    }

    private final void printStackTrace(PrintStream printStream, List<StackTraceElement> object2) {
        for (Object object2 : (Iterable)object2) {
            printStream.print("\n\tat " + object2);
        }
    }

    private final void probeCoroutineCompleted(CoroutineOwner<?> coroutineStackFrame) {
        capturedCoroutinesMap.remove(coroutineStackFrame);
        coroutineStackFrame = coroutineStackFrame.info.getLastObservedFrame$kotlinx_coroutines_core();
        if (coroutineStackFrame != null && (coroutineStackFrame = this.realCaller(coroutineStackFrame)) != null) {
            callerInfoCache.remove(coroutineStackFrame);
            return;
        }
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame coroutineStackFrame) {
        do {
            if ((coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) continue;
            return null;
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    private final <T extends Throwable> List<StackTraceElement> sanitizeStackTrace(T object) {
        int n;
        int n2;
        int n3;
        int n4;
        block9: {
            object = object.getStackTrace();
            n4 = ((T)object).length;
            n3 = ((T)object).length;
            n2 = -1;
            if (--n3 >= 0) {
                do {
                    n = n3 - 1;
                    if (Intrinsics.areEqual((Object)((StackTraceElement)((Object)object[n3])).getClassName(), (Object)"kotlin.coroutines.jvm.internal.DebugProbesKt")) break block9;
                    n3 = n;
                } while (n >= 0);
            }
            n3 = n2;
        }
        n2 = n3 + 1;
        if (!sanitizeStackTraces) {
            n = n4 - n2;
            ArrayList<T> arrayList = new ArrayList<T>(n);
            for (n3 = 0; n3 < n; ++n3) {
                arrayList.add(object[n3 + n2]);
            }
            return arrayList;
        }
        ArrayList arrayList = new ArrayList(n4 - n2 + 1);
        n3 = n2;
        while (n3 < n4) {
            if (this.isInternalMethod((StackTraceElement)((Object)object[n3]))) {
                ((Collection)arrayList).add(object[n3]);
                for (n2 = n3 + 1; n2 < n4 && this.isInternalMethod((StackTraceElement)((Object)object[n2])); ++n2) {
                }
                for (n = n2 - 1; n > n3 && ((StackTraceElement)((Object)object[n])).getFileName() == null; --n) {
                }
                if (n > n3 && n < n2 - 1) {
                    ((Collection)arrayList).add(object[n]);
                }
                ((Collection)arrayList).add(object[n2 - 1]);
                n3 = n2;
                continue;
            }
            ((Collection)arrayList).add(object[n3]);
            ++n3;
        }
        return arrayList;
    }

    private final void startWeakRefCleanerThread() {
        weakRefCleanerThread = ThreadsKt.thread$default((boolean)false, (boolean)true, null, (String)"Coroutines Debugger Cleaner", (int)0, (Function0)startWeakRefCleanerThread.1.INSTANCE, (int)21, null);
    }

    private final void stopWeakRefCleanerThread() {
        Thread thread = weakRefCleanerThread;
        if (thread == null) {
            return;
        }
        weakRefCleanerThread = null;
        thread.interrupt();
        thread.join();
    }

    private final StackTraceFrame toStackTraceFrame(List<StackTraceElement> object) {
        Object object2 = null;
        Object var3_3 = null;
        if (!object.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = object.listIterator(object.size());
            object = var3_3;
            while (true) {
                object2 = object;
                if (!listIterator.hasPrevious()) break;
                object2 = listIterator.previous();
                object = new StackTraceFrame((CoroutineStackFrame)object, (StackTraceElement)object2);
            }
        }
        return new StackTraceFrame((CoroutineStackFrame)object2, ARTIFICIAL_FRAME);
    }

    private final String toStringRepr(Object object) {
        return DebugProbesImplKt.access$repr(object.toString());
    }

    private final void updateRunningState(CoroutineStackFrame coroutineStackFrame, String string2) {
        block8: {
            boolean bl;
            Object object;
            block7: {
                block6: {
                    if (!this.isInstalled$kotlinx_coroutines_core()) {
                        return;
                    }
                    object = callerInfoCache.remove(coroutineStackFrame);
                    if (object == null) break block6;
                    bl = false;
                    break block7;
                }
                CoroutineOwner<?> coroutineOwner = this.owner(coroutineStackFrame);
                if (coroutineOwner == null || (coroutineOwner = coroutineOwner.info) == null) break block8;
                boolean bl2 = true;
                object = ((DebugCoroutineInfoImpl)((Object)coroutineOwner)).getLastObservedFrame$kotlinx_coroutines_core();
                CoroutineStackFrame coroutineStackFrame2 = object != null ? this.realCaller((CoroutineStackFrame)object) : null;
                object = coroutineOwner;
                bl = bl2;
                if (coroutineStackFrame2 != null) {
                    callerInfoCache.remove(coroutineStackFrame2);
                    bl = bl2;
                    object = coroutineOwner;
                }
            }
            Intrinsics.checkNotNull((Object)coroutineStackFrame, (String)"null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            ((DebugCoroutineInfoImpl)object).updateState$kotlinx_coroutines_core(string2, (Continuation)coroutineStackFrame, bl);
            coroutineStackFrame = this.realCaller(coroutineStackFrame);
            if (coroutineStackFrame == null) {
                return;
            }
            ((Map)((Object)callerInfoCache)).put(coroutineStackFrame, object);
            return;
        }
    }

    private final void updateState(Continuation<?> object, String string2) {
        if (!this.isInstalled$kotlinx_coroutines_core()) {
            return;
        }
        if (Intrinsics.areEqual((Object)string2, (Object)"RUNNING") && KotlinVersion.CURRENT.isAtLeast(1, 3, 30)) {
            if ((object = object instanceof CoroutineStackFrame ? (CoroutineStackFrame)object : null) == null) {
                return;
            }
            this.updateRunningState((CoroutineStackFrame)object, string2);
            return;
        }
        CoroutineOwner<?> coroutineOwner = this.owner((Continuation<?>)object);
        if (coroutineOwner == null) {
            return;
        }
        this.updateState(coroutineOwner, (Continuation<?>)object, string2);
    }

    private final void updateState(CoroutineOwner<?> coroutineOwner, Continuation<?> continuation, String string2) {
        if (!this.isInstalled$kotlinx_coroutines_core()) {
            return;
        }
        coroutineOwner.info.updateState$kotlinx_coroutines_core(string2, continuation, true);
    }

    public final void dumpCoroutines(PrintStream printStream) {
        synchronized (printStream) {
            INSTANCE.dumpCoroutinesSynchronized(printStream);
            Unit unit = Unit.INSTANCE;
            return;
        }
    }

    public final List<DebugCoroutineInfo> dumpCoroutinesInfo() {
        if (this.isInstalled$kotlinx_coroutines_core()) {
            Object object = CollectionsKt.asSequence((Iterable)this.getCapturedCoroutines());
            object = SequencesKt.toList((Sequence)SequencesKt.mapNotNull((Sequence)SequencesKt.sortedWith((Sequence)object, (Comparator)new /* invalid duplicate definition of identical inner class */), (Function1)new Function1<CoroutineOwner<?>, DebugCoroutineInfo>(){

                public final DebugCoroutineInfo invoke(CoroutineOwner<?> coroutineOwner) {
                    CoroutineContext coroutineContext;
                    boolean bl = DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, coroutineOwner);
                    DebugCoroutineInfo debugCoroutineInfo = null;
                    if (!bl && (coroutineContext = coroutineOwner.info.getContext()) != null) {
                        debugCoroutineInfo = new DebugCoroutineInfo(coroutineOwner.info, coroutineContext);
                    }
                    return debugCoroutineInfo;
                }
            }));
            return object;
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        Object object;
        CoroutineStackFrame[] coroutineStackFrameArray;
        Object object2;
        DebugCoroutineInfo[] debugCoroutineInfoArray = this.dumpCoroutinesInfo();
        int n = debugCoroutineInfoArray.size();
        ArrayList<Thread> arrayList = new ArrayList<Thread>(n);
        ArrayList<CoroutineStackFrame> arrayList2 = new ArrayList<CoroutineStackFrame>(n);
        ArrayList<String> arrayList3 = new ArrayList<String>(n);
        for (DebugCoroutineInfo debugCoroutineInfo : debugCoroutineInfoArray) {
            Object object3 = debugCoroutineInfo.getContext();
            object2 = (CoroutineName)object3.get((CoroutineContext.Key)CoroutineName.Key);
            coroutineStackFrameArray = null;
            object = object2 != null && (object2 = ((CoroutineName)((Object)object2)).getName()) != null ? this.toStringRepr(object2) : null;
            object2 = (CoroutineDispatcher)object3.get((CoroutineContext.Key)CoroutineDispatcher.Key);
            object2 = object2 != null ? this.toStringRepr(object2) : null;
            StringBuilder stringBuilder = new StringBuilder().append("\n                {\n                    \"name\": ");
            object = stringBuilder.append((String)object);
            stringBuilder = ((StringBuilder)object).append(",\n                    \"id\": ");
            object3 = (CoroutineId)object3.get((CoroutineContext.Key)CoroutineId.Key);
            object = coroutineStackFrameArray;
            if (object3 != null) {
                object = ((CoroutineId)object3).getId();
            }
            object = stringBuilder.append(object);
            object = ((StringBuilder)object).append(",\n                    \"dispatcher\": ");
            object2 = ((StringBuilder)object).append((String)object2);
            object2 = ((StringBuilder)object2).append(",\n                    \"sequenceNumber\": ").append(debugCoroutineInfo.getSequenceNumber());
            object2 = ((StringBuilder)object2).append(",\n                    \"state\": \"").append(debugCoroutineInfo.getState());
            arrayList3.add(StringsKt.trimIndent((String)((StringBuilder)object2).append("\"\n                } \n                ").toString()));
            arrayList2.add(debugCoroutineInfo.getLastObservedFrame());
            arrayList.add(debugCoroutineInfo.getLastObservedThread());
        }
        object2 = '[' + CollectionsKt.joinToString$default((Iterable)arrayList3, null, null, null, (int)0, null, null, (int)63, null) + ']';
        object = ((Collection)arrayList).toArray(new Thread[0]);
        coroutineStackFrameArray = ((Collection)arrayList2).toArray(new CoroutineStackFrame[0]);
        debugCoroutineInfoArray = ((Collection)debugCoroutineInfoArray).toArray(new DebugCoroutineInfo[0]);
        return new Object[]{object2, object, coroutineStackFrameArray, debugCoroutineInfoArray};
    }

    public final List<DebuggerInfo> dumpDebuggerInfo() {
        if (this.isInstalled$kotlinx_coroutines_core()) {
            Object object = CollectionsKt.asSequence((Iterable)this.getCapturedCoroutines());
            object = SequencesKt.toList((Sequence)SequencesKt.mapNotNull((Sequence)SequencesKt.sortedWith((Sequence)object, (Comparator)new /* invalid duplicate definition of identical inner class */), (Function1)new Function1<CoroutineOwner<?>, DebuggerInfo>(){

                public final DebuggerInfo invoke(CoroutineOwner<?> coroutineOwner) {
                    CoroutineContext coroutineContext;
                    boolean bl = DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, coroutineOwner);
                    DebuggerInfo debuggerInfo = null;
                    if (!bl && (coroutineContext = coroutineOwner.info.getContext()) != null) {
                        debuggerInfo = new DebuggerInfo(coroutineOwner.info, coroutineContext);
                    }
                    return debuggerInfo;
                }
            }));
            return object;
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(DebugCoroutineInfo debugCoroutineInfo, List<StackTraceElement> list) {
        return this.enhanceStackTraceWithThreadDumpImpl(debugCoroutineInfo.getState(), debugCoroutineInfo.getLastObservedThread(), list);
    }

    public final String enhanceStackTraceWithThreadDumpAsJson(DebugCoroutineInfo object) {
        object = this.enhanceStackTraceWithThreadDump((DebugCoroutineInfo)object, ((DebugCoroutineInfo)object).lastObservedStackTrace());
        List list = new ArrayList();
        Iterator iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            StackTraceElement stackTraceElement = (StackTraceElement)iterator2.next();
            object = new StringBuilder().append("\n                {\n                    \"declaringClass\": \"").append(stackTraceElement.getClassName());
            object = ((StringBuilder)object).append("\",\n                    \"methodName\": \"").append(stackTraceElement.getMethodName());
            StringBuilder stringBuilder = ((StringBuilder)object).append("\",\n                    \"fileName\": ");
            object = stackTraceElement.getFileName();
            object = object != null ? this.toStringRepr(object) : null;
            object = stringBuilder.append((String)object);
            object = ((StringBuilder)object).append(",\n                    \"lineNumber\": ").append(stackTraceElement.getLineNumber());
            list.add(StringsKt.trimIndent((String)((StringBuilder)object).append("\n                }\n                ").toString()));
        }
        return '[' + CollectionsKt.joinToString$default((Iterable)list, null, null, null, (int)0, null, null, (int)63, null) + ']';
    }

    public final boolean getEnableCreationStackTraces() {
        return enableCreationStackTraces;
    }

    public final boolean getSanitizeStackTraces() {
        return sanitizeStackTraces;
    }

    public final String hierarchyToString(Job object) {
        if (this.isInstalled$kotlinx_coroutines_core()) {
            Object object2;
            Object object3 = this.getCapturedCoroutines();
            Object object4 = new ArrayList();
            object3 = object3.iterator();
            while (object3.hasNext()) {
                object2 = object3.next();
                boolean bl = ((CoroutineOwner)object2).delegate.getContext().get((CoroutineContext.Key)Job.Key) != null;
                if (!bl) continue;
                object4.add(object2);
            }
            object4 = (List)object4;
            object3 = (Iterable)object4;
            object4 = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)object3, (int)10)), (int)16));
            object3 = object3.iterator();
            while (object3.hasNext()) {
                object2 = object3.next();
                object4.put(JobKt.getJob(((CoroutineOwner)object2).delegate.getContext()), ((CoroutineOwner)object2).info);
            }
            object3 = new StringBuilder();
            INSTANCE.build((Job)object, (Map<Job, DebugCoroutineInfoImpl>)object4, (StringBuilder)object3, "");
            object = ((StringBuilder)object3).toString();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"StringBuilder().apply(builderAction).toString()");
            return object;
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final void install() {
        if (Installations.kotlinx.VolatileWrapper.installations$FU.incrementAndGet(installations$kotlinx$VolatileWrapper) > 1) {
            return;
        }
        this.startWeakRefCleanerThread();
        if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core()) {
            return;
        }
        Function1<Boolean, Unit> function1 = dynamicAttach;
        if (function1 != null) {
            function1.invoke((Object)true);
        }
    }

    public final boolean isInstalled$kotlinx_coroutines_core() {
        boolean bl = Installations.kotlinx.VolatileWrapper.installations$FU.get(installations$kotlinx$VolatileWrapper) > 0;
        return bl;
    }

    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(Continuation<? super T> continuation) {
        if (!this.isInstalled$kotlinx_coroutines_core()) {
            return continuation;
        }
        if (this.owner(continuation) != null) {
            return continuation;
        }
        StackTraceFrame stackTraceFrame = enableCreationStackTraces ? this.toStackTraceFrame(this.sanitizeStackTrace((Throwable)new Exception())) : null;
        return this.createOwner(continuation, stackTraceFrame);
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation<?> continuation) {
        this.updateState(continuation, "RUNNING");
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation<?> continuation) {
        this.updateState(continuation, "SUSPENDED");
    }

    public final void setEnableCreationStackTraces(boolean bl) {
        enableCreationStackTraces = bl;
    }

    public final void setSanitizeStackTraces(boolean bl) {
        sanitizeStackTraces = bl;
    }

    public final void uninstall() {
        if (this.isInstalled$kotlinx_coroutines_core()) {
            if (Installations.kotlinx.VolatileWrapper.installations$FU.decrementAndGet(installations$kotlinx$VolatileWrapper) != 0) {
                return;
            }
            this.stopWeakRefCleanerThread();
            capturedCoroutinesMap.clear();
            callerInfoCache.clear();
            if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core()) {
                return;
            }
            Function1<Boolean, Unit> function1 = dynamicAttach;
            if (function1 != null) {
                function1.invoke((Object)false);
            }
            return;
        }
        throw new IllegalStateException("Agent was not installed".toString());
    }

    @Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2={"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "frame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getFrame", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private static final class CoroutineOwner<T>
    implements Continuation<T>,
    CoroutineStackFrame {
        public final Continuation<T> delegate;
        public final DebugCoroutineInfoImpl info;

        public CoroutineOwner(Continuation<? super T> continuation, DebugCoroutineInfoImpl debugCoroutineInfoImpl) {
            this.delegate = continuation;
            this.info = debugCoroutineInfoImpl;
        }

        private final StackTraceFrame getFrame() {
            return this.info.getCreationStackBottom();
        }

        public CoroutineStackFrame getCallerFrame() {
            StackTraceFrame stackTraceFrame = this.getFrame();
            stackTraceFrame = stackTraceFrame != null ? stackTraceFrame.getCallerFrame() : null;
            return stackTraceFrame;
        }

        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        public StackTraceElement getStackTraceElement() {
            Object object = this.getFrame();
            object = object != null ? ((StackTraceFrame)object).getStackTraceElement() : null;
            return object;
        }

        public void resumeWith(Object object) {
            INSTANCE.probeCoroutineCompleted(this);
            this.delegate.resumeWith(object);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }
}

