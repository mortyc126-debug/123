/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequenceScope
 *  kotlin.sequences.SequencesKt
 */
package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.debug.internal.StackTraceFrame;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\b\u0010&\u001a\u00020\u000eH\u0016J)\u0010'\u001a\u00020(2\u0006\u0010 \u001a\u00020\u000e2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*2\u0006\u0010+\u001a\u00020,H\u0000\u00a2\u0006\u0002\b-J%\u0010.\u001a\u00020(*\b\u0012\u0004\u0012\u00020\u00150/2\b\u0010)\u001a\u0004\u0018\u00010\fH\u0082P\u00f8\u0001\u0000\u00a2\u0006\u0002\u00100R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\f8@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2={"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "creationStackBottom", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "sequenceNumber", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/debug/internal/StackTraceFrame;J)V", "_context", "Ljava/lang/ref/WeakReference;", "_lastObservedFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "_state", "", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getCreationStackBottom", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "creationStackTrace", "", "Ljava/lang/StackTraceElement;", "getCreationStackTrace", "()Ljava/util/List;", "value", "lastObservedFrame", "getLastObservedFrame$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "setLastObservedFrame$kotlinx_coroutines_core", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "lastObservedThread", "Ljava/lang/Thread;", "state", "getState", "()Ljava/lang/String;", "unmatchedResume", "", "lastObservedStackTrace", "toString", "updateState", "", "frame", "Lkotlin/coroutines/Continuation;", "shouldBeMatched", "", "updateState$kotlinx_coroutines_core", "yieldFrames", "Lkotlin/sequences/SequenceScope;", "(Lkotlin/sequences/SequenceScope;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class DebugCoroutineInfoImpl {
    private final WeakReference<CoroutineContext> _context;
    private volatile WeakReference<CoroutineStackFrame> _lastObservedFrame;
    private volatile String _state;
    private final StackTraceFrame creationStackBottom;
    public volatile Thread lastObservedThread;
    public final long sequenceNumber;
    private int unmatchedResume;

    public DebugCoroutineInfoImpl(CoroutineContext coroutineContext, StackTraceFrame stackTraceFrame, long l) {
        this.creationStackBottom = stackTraceFrame;
        this.sequenceNumber = l;
        this._context = new WeakReference<CoroutineContext>(coroutineContext);
        this._state = "CREATED";
    }

    public static final /* synthetic */ Object access$yieldFrames(DebugCoroutineInfoImpl debugCoroutineInfoImpl, SequenceScope sequenceScope, CoroutineStackFrame coroutineStackFrame, Continuation continuation) {
        return debugCoroutineInfoImpl.yieldFrames((SequenceScope<? super StackTraceElement>)sequenceScope, coroutineStackFrame, (Continuation<? super Unit>)continuation);
    }

    private final List<StackTraceElement> creationStackTrace() {
        StackTraceFrame stackTraceFrame = this.creationStackBottom;
        if (stackTraceFrame == null) {
            return CollectionsKt.emptyList();
        }
        return SequencesKt.toList((Sequence)SequencesKt.sequence((Function2)((Function2)new Function2<SequenceScope<? super StackTraceElement>, Continuation<? super Unit>, Object>(this, stackTraceFrame, null){
            final StackTraceFrame $bottom;
            private Object L$0;
            int label;
            final DebugCoroutineInfoImpl this$0;
            {
                this.this$0 = debugCoroutineInfoImpl;
                this.$bottom = stackTraceFrame;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(SequenceScope<? super StackTraceElement> sequenceScope, Continuation<? super Unit> continuation) {
                return (this.create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        SequenceScope sequenceScope = (SequenceScope)this.L$0;
                        object = this.this$0;
                        CoroutineStackFrame coroutineStackFrame = this.$bottom.getCallerFrame();
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (DebugCoroutineInfoImpl.access$yieldFrames((DebugCoroutineInfoImpl)object, sequenceScope, coroutineStackFrame, continuation) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        })));
    }

    /*
     * Exception decompiling
     */
    private final Object yieldFrames(SequenceScope<? super StackTraceElement> var1_1, CoroutineStackFrame var2_2, Continuation<? super Unit> var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CASE], 0[SWITCH]], but top level block is 4[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
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

    public final CoroutineContext getContext() {
        return (CoroutineContext)this._context.get();
    }

    public final StackTraceFrame getCreationStackBottom() {
        return this.creationStackBottom;
    }

    public final List<StackTraceElement> getCreationStackTrace() {
        return this.creationStackTrace();
    }

    public final CoroutineStackFrame getLastObservedFrame$kotlinx_coroutines_core() {
        Object object = this._lastObservedFrame;
        object = object != null ? (CoroutineStackFrame)object.get() : null;
        return object;
    }

    public final String getState() {
        return this._state;
    }

    public final List<StackTraceElement> lastObservedStackTrace() {
        CoroutineStackFrame coroutineStackFrame = this.getLastObservedFrame$kotlinx_coroutines_core();
        if (coroutineStackFrame == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList<StackTraceElement> arrayList = new ArrayList<StackTraceElement>();
        while (coroutineStackFrame != null) {
            StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
        }
        return arrayList;
    }

    public final void setLastObservedFrame$kotlinx_coroutines_core(CoroutineStackFrame object) {
        object = object != null ? new WeakReference<CoroutineStackFrame>((CoroutineStackFrame)object) : null;
        this._lastObservedFrame = object;
    }

    public String toString() {
        return "DebugCoroutineInfo(state=" + this.getState() + ",context=" + this.getContext() + ')';
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void updateState$kotlinx_coroutines_core(String object, Continuation<?> coroutineStackFrame, boolean bl) {
        synchronized (this) {
            CoroutineStackFrame coroutineStackFrame2;
            CoroutineStackFrame coroutineStackFrame3;
            boolean bl2;
            if (Intrinsics.areEqual((Object)this._state, (Object)"RUNNING") && Intrinsics.areEqual((Object)object, (Object)"RUNNING") && bl2) {
                ++this.unmatchedResume;
            } else if (this.unmatchedResume > 0 && Intrinsics.areEqual((Object)object, (Object)"SUSPENDED")) {
                --this.unmatchedResume;
                return;
            }
            if (Intrinsics.areEqual((Object)this._state, (Object)object) && Intrinsics.areEqual((Object)object, (Object)"SUSPENDED") && (coroutineStackFrame3 = this.getLastObservedFrame$kotlinx_coroutines_core()) != null) {
                return;
            }
            this._state = object;
            bl2 = coroutineStackFrame2 instanceof CoroutineStackFrame;
            coroutineStackFrame3 = null;
            coroutineStackFrame2 = bl2 ? (CoroutineStackFrame)coroutineStackFrame2 : null;
            this.setLastObservedFrame$kotlinx_coroutines_core(coroutineStackFrame2);
            object = Intrinsics.areEqual((Object)object, (Object)"RUNNING") ? Thread.currentThread() : coroutineStackFrame3;
            this.lastObservedThread = object;
            return;
        }
    }
}

