/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.selects;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import kotlinx.coroutines.selects.SelectKt;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

@Metadata(d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001HB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u001a\u0010\u001d\u001a\u00020\u001b2\u0010\u0010\u001e\u001a\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0011\u0010\u001f\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0011\u0010$\u001a\u00028\u0000H\u0091@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0011\u0010%\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u001c\u0010&\u001a\u000e\u0018\u00010\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0013\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0002J\u001c\u0010*\u001a\u00020\u001b2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020\u0014H\u0016J-\u0010.\u001a\u00028\u00002\u0010\u0010/\u001a\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00100J\u0010\u00101\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0012\u00102\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u00103\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u00105\u001a\u0002062\u0006\u0010\u001c\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010\u000eJ\u001a\u00107\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0002J\u0011\u00108\u001a\u00020\u001bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J3\u0010'\u001a\u00020\u001b*\u0002092\u001c\u0010:\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0;H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010=JE\u0010'\u001a\u00020\u001b\"\u0004\b\u0001\u0010>*\b\u0012\u0004\u0012\u0002H>0?2\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H>\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0@H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010AJY\u0010'\u001a\u00020\u001b\"\u0004\b\u0001\u0010B\"\u0004\b\u0002\u0010>*\u000e\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002H>0C2\u0006\u0010D\u001a\u0002HB2\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H>\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0@H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010EJ \u0010F\u001a\u00020\u001b*\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010G\u001a\u00020\u0010H\u0001R \u0010\b\u001a\u0014\u0012\u000e\u0012\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006I"}, d2={"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "clauses", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "disposableHandleOrSegment", "", "inRegistrationPhase", "", "getInRegistrationPhase", "()Z", "indexInSegment", "", "internalResult", "isCancelled", "isSelected", "state", "Lkotlinx/atomicfu/AtomicRef;", "checkClauseObject", "", "clauseObject", "cleanup", "selectedClause", "complete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disposeOnCompletion", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "doSelect", "doSelectSuspend", "findClause", "invoke", "cause", "", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "processResultAndInvokeBlockRecoveringException", "clause", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reregisterClause", "selectInRegistrationPhase", "trySelect", "result", "trySelectDetailed", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectInternal", "waitUntilSelected", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "register", "reregister", "ClauseData", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class SelectImplementation<R>
extends CancelHandler
implements SelectBuilder<R>,
SelectInstanceInternal<R> {
    private static final AtomicReferenceFieldUpdater state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");
    private List<ClauseData> clauses;
    private final CoroutineContext context;
    private Object disposableHandleOrSegment;
    private int indexInSegment;
    private Object internalResult;
    @Volatile
    private volatile Object state;

    public SelectImplementation(CoroutineContext coroutineContext) {
        this.context = coroutineContext;
        this.state = SelectKt.access$getSTATE_REG$p();
        this.clauses = new ArrayList(2);
        this.indexInSegment = -1;
        this.internalResult = SelectKt.access$getNO_RESULT$p();
    }

    public static final /* synthetic */ Object access$complete(SelectImplementation selectImplementation, Continuation continuation) {
        return selectImplementation.complete(continuation);
    }

    public static final /* synthetic */ Object access$doSelectSuspend(SelectImplementation selectImplementation, Continuation continuation) {
        return selectImplementation.doSelectSuspend(continuation);
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater access$getState$FU$p() {
        return state$FU;
    }

    public static final /* synthetic */ Object access$processResultAndInvokeBlockRecoveringException(SelectImplementation selectImplementation, ClauseData clauseData, Object object, Continuation continuation) {
        return selectImplementation.processResultAndInvokeBlockRecoveringException(clauseData, object, continuation);
    }

    public static final /* synthetic */ void access$reregisterClause(SelectImplementation selectImplementation, Object object) {
        selectImplementation.reregisterClause(object);
    }

    public static final /* synthetic */ Object access$waitUntilSelected(SelectImplementation selectImplementation, Continuation continuation) {
        return selectImplementation.waitUntilSelected((Continuation<Unit>)continuation);
    }

    private final void checkClauseObject(Object object) {
        boolean bl;
        block4: {
            Object object2 = this.clauses;
            Intrinsics.checkNotNull(object2);
            object2 = (Iterable)object2;
            boolean bl2 = object2 instanceof Collection;
            boolean bl3 = true;
            if (bl2 && ((Collection)object2).isEmpty()) {
                bl = bl3;
            } else {
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    bl = ((ClauseData)object2.next()).clauseObject == object;
                    if (!bl) continue;
                    bl = false;
                    break block4;
                }
                bl = bl3;
            }
        }
        if (bl) {
            return;
        }
        throw new IllegalStateException(("Cannot use select clauses on the same object: " + object).toString());
    }

    private final void cleanup(ClauseData clauseData) {
        if (DebugKt.getASSERTIONS_ENABLED() && !Intrinsics.areEqual(state$FU.get(this), (Object)clauseData)) {
            throw new AssertionError();
        }
        List<ClauseData> list = this.clauses;
        if (list == null) {
            return;
        }
        for (ClauseData clauseData2 : (Iterable)list) {
            if (clauseData2 == clauseData) continue;
            clauseData2.dispose();
        }
        state$FU.set(this, SelectKt.access$getSTATE_COMPLETED$p());
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
    }

    private final Object complete(Continuation<? super R> continuation) {
        if (DebugKt.getASSERTIONS_ENABLED() && !this.isSelected()) {
            throw new AssertionError();
        }
        Object object = state$FU.get(this);
        Intrinsics.checkNotNull(object, (String)"null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        object = (ClauseData)object;
        Object object2 = this.internalResult;
        this.cleanup((ClauseData)object);
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            return ((ClauseData)object).invokeBlock(((ClauseData)object).processResult(object2), continuation);
        }
        return this.processResultAndInvokeBlockRecoveringException((ClauseData)object, object2, continuation);
    }

    static /* synthetic */ <R> Object doSelect$suspendImpl(SelectImplementation<R> selectImplementation, Continuation<? super R> continuation) {
        if (super.isSelected()) {
            return super.complete(continuation);
        }
        return super.doSelectSuspend(continuation);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final Object doSelectSuspend(Continuation<? super R> var1_1) {
        block8: {
            if (!(var1_1 /* !! */  instanceof doSelectSuspend.1)) ** GOTO lbl-1000
            var2_2 = var1_1 /* !! */ ;
            if ((var2_2.label & -2147483648) != 0) {
                var2_2.label += -2147483648;
                var1_1 /* !! */  = var2_2;
            } else lbl-1000:
            // 2 sources

            {
                var1_1 /* !! */  = new ContinuationImpl(this, var1_1 /* !! */ ){
                    Object L$0;
                    int label;
                    Object result;
                    final SelectImplementation<R> this$0;
                    {
                        this.this$0 = selectImplementation;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return SelectImplementation.access$doSelectSuspend(this.this$0, (Continuation)this);
                    }
                };
            }
            var2_2 = var1_1 /* !! */ .result;
            var4_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var1_1 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 2: {
                    ResultKt.throwOnFailure((Object)var2_2);
                    var1_1 /* !! */  = var2_2;
                    break block8;
                }
                case 1: {
                    var3_4 = (SelectImplementation)var1_1 /* !! */ .L$0;
                    ResultKt.throwOnFailure((Object)var2_2);
                    break;
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var2_2);
                    var1_1 /* !! */ .L$0 = var2_2 = this;
                    var1_1 /* !! */ .label = 1;
                    var3_4 = var2_2;
                    if (super.waitUntilSelected(var1_1 /* !! */ ) != var4_3) break;
                    return var4_3;
                }
            }
            var1_1 /* !! */ .L$0 = null;
            var1_1 /* !! */ .label = 2;
            var2_2 = var3_4.complete(var1_1 /* !! */ );
            var1_1 /* !! */  = var2_2;
            if (var2_2 == var4_3) {
                return var4_3;
            }
        }
        return var1_1 /* !! */ ;
    }

    private final ClauseData findClause(Object object) {
        boolean bl;
        Object object2 = this.clauses;
        Object var4_3 = null;
        if (object2 == null) {
            return null;
        }
        Iterator iterator2 = ((Iterable)object2).iterator();
        do {
            object2 = var4_3;
            if (!iterator2.hasNext()) break;
            object2 = iterator2.next();
        } while (!(bl = ((ClauseData)object2).clauseObject == object));
        if ((object2 = (ClauseData)object2) != null) {
            return object2;
        }
        throw new IllegalStateException(("Clause with object " + object + " is not found").toString());
    }

    private final boolean getInRegistrationPhase() {
        Object v = state$FU.get(this);
        boolean bl = v == SelectKt.access$getSTATE_REG$p() || v instanceof List;
        return bl;
    }

    private final boolean isCancelled() {
        boolean bl = state$FU.get(this) == SelectKt.access$getSTATE_CANCELLED$p();
        return bl;
    }

    private final boolean isSelected() {
        return state$FU.get(this) instanceof ClauseData;
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object object) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(object));
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Object processResultAndInvokeBlockRecoveringException(ClauseData var1_1, Object var2_3, Continuation<? super R> var3_4) {
        if (!(var3_4 /* !! */  instanceof processResultAndInvokeBlockRecoveringException.1)) ** GOTO lbl-1000
        var4_5 /* !! */  = var3_4 /* !! */ ;
        if ((var4_5 /* !! */ .label & -2147483648) != 0) {
            var4_5 /* !! */ .label += -2147483648;
            var3_4 /* !! */  = var4_5 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var3_4 /* !! */  = new ContinuationImpl(this, var3_4 /* !! */ ){
                int label;
                Object result;
                final SelectImplementation<R> this$0;
                {
                    this.this$0 = selectImplementation;
                    super(continuation);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return SelectImplementation.access$processResultAndInvokeBlockRecoveringException(this.this$0, null, null, (Continuation)this);
                }
            };
        }
        var4_5 /* !! */  = var3_4 /* !! */ .result;
        var5_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var3_4 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                try {
                    ResultKt.throwOnFailure((Object)var4_5 /* !! */ );
                    return var4_5 /* !! */ ;
                }
                catch (Throwable var1_2) {
                    break;
                }
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var4_5 /* !! */ );
                {
                    var2_3 = var1_1.processResult(var2_3);
                    var3_4 /* !! */ .label = 1;
                    var1_1 = var2_3 = var1_1.invokeBlock(var2_3, var3_4 /* !! */ );
                    if (var2_3 != var5_6) return var1_1;
                    return var5_6;
                }
            }
        }
        if (DebugKt.getRECOVER_STACK_TRACES() == false) throw var1_2;
        if (var3_4 /* !! */  instanceof CoroutineStackFrame != false) throw StackTraceRecoveryKt.access$recoverFromStackFrame(var1_2, (CoroutineStackFrame)var3_4 /* !! */ );
        throw var1_2;
    }

    public static /* synthetic */ void register$default(SelectImplementation selectImplementation, ClauseData clauseData, boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 1) != 0) {
                bl = false;
            }
            selectImplementation.register(clauseData, bl);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    private final void reregisterClause(Object object) {
        object = this.findClause(object);
        Intrinsics.checkNotNull((Object)object);
        ((ClauseData)object).disposableHandleOrSegment = null;
        ((ClauseData)object).indexInSegment = -1;
        this.register((ClauseData)object, true);
    }

    private final int trySelectInternal(Object object, Object object2) {
        Object v;
        block6: {
            while (true) {
                if ((v = state$FU.get(this)) instanceof CancellableContinuation) {
                    ClauseData clauseData = this.findClause(object);
                    if (clauseData == null) continue;
                    Function1<Throwable, Unit> function1 = clauseData.createOnCancellationAction(this, object2);
                    if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(state$FU, this, v, clauseData)) continue;
                    object = (CancellableContinuation)v;
                    this.internalResult = object2;
                    if (SelectKt.access$tryResume((CancellableContinuation)object, function1)) {
                        return 0;
                    }
                    this.internalResult = null;
                    return 2;
                }
                boolean bl = Intrinsics.areEqual(v, (Object)SelectKt.access$getSTATE_COMPLETED$p()) ? true : v instanceof ClauseData;
                if (bl) {
                    return 3;
                }
                if (Intrinsics.areEqual(v, (Object)SelectKt.access$getSTATE_CANCELLED$p())) {
                    return 2;
                }
                if (Intrinsics.areEqual(v, (Object)SelectKt.access$getSTATE_REG$p())) {
                    if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(state$FU, this, v, CollectionsKt.listOf((Object)object))) continue;
                    return 1;
                }
                if (!(v instanceof List)) break block6;
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(state$FU, this, v, CollectionsKt.plus((Collection)((Collection)v), (Object)object))) break;
            }
            return 1;
        }
        throw new IllegalStateException(("Unexpected state: " + v).toString());
    }

    private final void update$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1, Object object) {
        Object v;
        while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, object, v = atomicReferenceFieldUpdater.get(object), function1.invoke(v))) {
        }
    }

    /*
     * Unable to fully structure code
     */
    private final Object waitUntilSelected(Continuation<? super Unit> var1_1) {
        block10: {
            block9: {
                var2_2 = false;
                var5_3 = new CancellableContinuationImpl<T>(IntrinsicsKt.intercepted(var1_1), 1);
                var5_3.initCancellability();
                var3_4 = var5_3;
                var4_5 = SelectImplementation.access$getState$FU$p();
                block0: while (true) {
                    if ((var6_6 = var4_5.get(this)) == SelectKt.access$getSTATE_REG$p()) {
                        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SelectImplementation.access$getState$FU$p(), this, var6_6, var3_4)) continue;
                        var3_4.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)this));
                        break block9;
                    }
                    if (!(var6_6 instanceof List)) break;
                    if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SelectImplementation.access$getState$FU$p(), this, var6_6, SelectKt.access$getSTATE_REG$p())) continue;
                    var7_7 = (List)var6_6;
                    var6_6 = ((Iterable)var6_6).iterator();
                    while (true) {
                        if (var6_6.hasNext()) ** break;
                        continue block0;
                        SelectImplementation.access$reregisterClause(this, var6_6.next());
                    }
                    break;
                }
                if (!(var6_6 instanceof ClauseData)) break block10;
                var3_4.resume(Unit.INSTANCE, ((ClauseData)var6_6).createOnCancellationAction(this, SelectImplementation.access$getInternalResult$p(this)));
            }
            var3_4 = var5_3.getResult();
            if (var3_4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(var1_1);
            }
            if (var3_4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return var3_4;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(("unexpected state: " + var6_6).toString());
    }

    @Override
    public void disposeOnCompletion(DisposableHandle disposableHandle) {
        this.disposableHandleOrSegment = disposableHandle;
    }

    public Object doSelect(Continuation<? super R> continuation) {
        return SelectImplementation.doSelect$suspendImpl(this, continuation);
    }

    @Override
    public CoroutineContext getContext() {
        return this.context;
    }

    @Override
    public void invoke(Throwable object) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
        do {
            if ((object = atomicReferenceFieldUpdater.get(this)) != SelectKt.access$getSTATE_COMPLETED$p()) continue;
            return;
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, object, SelectKt.access$getSTATE_CANCELLED$p()));
        object = this.clauses;
        if (object == null) {
            return;
        }
        object = ((Iterable)object).iterator();
        while (object.hasNext()) {
            ((ClauseData)object.next()).dispose();
        }
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
    }

    @Override
    public void invoke(SelectClause0 selectClause0, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        SelectImplementation.register$default(this, new ClauseData(this, selectClause0.getClauseObject(), selectClause0.getRegFunc(), selectClause0.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), function1, selectClause0.getOnCancellationConstructor()), false, 1, null);
    }

    @Override
    public <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectImplementation.register$default(this, new ClauseData(this, selectClause1.getClauseObject(), selectClause1.getRegFunc(), selectClause1.getProcessResFunc(), null, function2, selectClause1.getOnCancellationConstructor()), false, 1, null);
    }

    @Override
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectImplementation.register$default(this, new ClauseData(this, selectClause2.getClauseObject(), selectClause2.getRegFunc(), selectClause2.getProcessResFunc(), p, function2, selectClause2.getOnCancellationConstructor()), false, 1, null);
    }

    @Override
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.DefaultImpls.invoke(this, selectClause2, function2);
    }

    @Override
    public void invokeOnCancellation(Segment<?> segment, int n) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = n;
    }

    @Override
    @Deprecated(level=DeprecationLevel.ERROR, message="Replaced with the same extension function", replaceWith=@ReplaceWith(expression="onTimeout", imports={"kotlinx.coroutines.selects.onTimeout"}))
    public void onTimeout(long l, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        SelectBuilder.DefaultImpls.onTimeout(this, l, function1);
    }

    public final void register(ClauseData clauseData, boolean bl) {
        boolean bl2;
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl2 = state$FU.get(this) != SelectKt.access$getSTATE_CANCELLED$p())) {
            throw new AssertionError();
        }
        if (state$FU.get(this) instanceof ClauseData) {
            return;
        }
        if (!bl) {
            this.checkClauseObject(clauseData.clauseObject);
        }
        if (clauseData.tryRegisterAsWaiter(this)) {
            if (!bl) {
                List<ClauseData> list = this.clauses;
                Intrinsics.checkNotNull(list);
                ((Collection)list).add(clauseData);
            }
            clauseData.disposableHandleOrSegment = this.disposableHandleOrSegment;
            clauseData.indexInSegment = this.indexInSegment;
            this.disposableHandleOrSegment = null;
            this.indexInSegment = -1;
        } else {
            state$FU.set(this, clauseData);
        }
    }

    @Override
    public void selectInRegistrationPhase(Object object) {
        this.internalResult = object;
    }

    @Override
    public boolean trySelect(Object object, Object object2) {
        boolean bl = this.trySelectInternal(object, object2) == 0;
        return bl;
    }

    public final TrySelectDetailedResult trySelectDetailed(Object object, Object object2) {
        return SelectKt.access$TrySelectDetailedResult(this.trySelectInternal(object, object2));
    }

    @Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u00b6\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012U\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000b\u0012U\u0010\f\u001aQ\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000e\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012g\u0010\u0010\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012\u0018\u00010\u0004j\u0004\u0018\u0001`\u0014\u00a2\u0006\u0002\u0010\u0015J*\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u001a\u001a\u00020\nJ\u001b\u0010\u001b\u001a\u00028\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001J\u0014\u0010 \u001a\u00020!2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\"R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000Rq\u0010\u0010\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012\u0018\u00010\u0004j\u0004\u0018\u0001`\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R]\u0010\f\u001aQ\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R]\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2={"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "clauseObject", "regFunc", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "param", "", "Lkotlinx/coroutines/selects/RegistrationFunction;", "processResFunc", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "block", "onCancellationConstructor", "internalResult", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "disposableHandleOrSegment", "indexInSegment", "", "createOnCancellationAction", "dispose", "invokeBlock", "argument", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processResult", "result", "tryRegisterAsWaiter", "", "Lkotlinx/coroutines/selects/SelectImplementation;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    public final class ClauseData {
        private final Object block;
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment;
        public final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;
        private final Object param;
        private final Function3<Object, Object, Object, Object> processResFunc;
        private final Function3<Object, SelectInstance<?>, Object, Unit> regFunc;
        final SelectImplementation<R> this$0;

        public ClauseData(SelectImplementation selectImplementation, Object object, Function3<Object, ? super SelectInstance<?>, Object, Unit> function3, Function3<Object, Object, Object, ? extends Object> function32, Object object2, Object object3, Function3<? super SelectInstance<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> function33) {
            this.this$0 = selectImplementation;
            this.clauseObject = object;
            this.regFunc = function3;
            this.processResFunc = function32;
            this.param = object2;
            this.block = object3;
            this.onCancellationConstructor = function33;
            this.indexInSegment = -1;
        }

        public final Function1<Throwable, Unit> createOnCancellationAction(SelectInstance<?> object, Object object2) {
            Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> function3 = this.onCancellationConstructor;
            object = function3 != null ? (Function1)function3.invoke(object, this.param, object2) : null;
            return object;
        }

        public final void dispose() {
            Object object = this.disposableHandleOrSegment;
            SelectImplementation selectImplementation = this.this$0;
            boolean bl = object instanceof Segment;
            DisposableHandle disposableHandle = null;
            if (bl) {
                ((Segment)object).onCancellation(this.indexInSegment, null, selectImplementation.getContext());
            } else {
                if (object instanceof DisposableHandle) {
                    disposableHandle = (DisposableHandle)object;
                }
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                }
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public final Object invokeBlock(Object object, Continuation<? super R> continuation) {
            Object object2 = this.block;
            if (this.param == SelectKt.getPARAM_CLAUSE_0()) {
                Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                object = (Function1)object2;
                return ((Function1)object2).invoke(continuation);
            }
            Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            Function2 function2 = (Function2)object2;
            return ((Function2)object2).invoke(object, continuation);
        }

        public final Object processResult(Object object) {
            return this.processResFunc.invoke(this.clauseObject, this.param, object);
        }

        public final boolean tryRegisterAsWaiter(SelectImplementation<R> selectImplementation) {
            boolean bl;
            boolean bl2 = DebugKt.getASSERTIONS_ENABLED();
            boolean bl3 = false;
            if (bl2) {
                bl = selectImplementation.getInRegistrationPhase() || selectImplementation.isCancelled();
                if (!bl) {
                    throw new AssertionError();
                }
            }
            if (DebugKt.getASSERTIONS_ENABLED() && !(bl = selectImplementation.internalResult == SelectKt.access$getNO_RESULT$p())) {
                throw new AssertionError();
            }
            this.regFunc.invoke(this.clauseObject, selectImplementation, this.param);
            if (selectImplementation.internalResult == SelectKt.access$getNO_RESULT$p()) {
                bl3 = true;
            }
            return bl3;
        }
    }
}

