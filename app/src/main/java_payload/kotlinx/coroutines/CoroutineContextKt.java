/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Ref$ObjectRef
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CopyableThreadContextElement;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedCoroutine;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.UndispatchedMarker;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a8\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b\u00a2\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b\u00a2\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\n*\u00020\u0003H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003H\u0007\u001a\u0013\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u00020\u001dH\u0080\u0010\u001a(\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00038@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006 "}, d2={"DEBUG_THREAD_NAME_SEPARATOR", "", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "foldCopies", "originalContext", "appendContext", "isNewCoroutine", "", "withContinuationContext", "T", "continuation", "Lkotlin/coroutines/Continuation;", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withCoroutineContext", "context", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasCopyableElements", "newCoroutineContext", "addedContext", "Lkotlinx/coroutines/CoroutineScope;", "undispatchedCompletion", "Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateUndispatchedCompletion", "oldValue", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class CoroutineContextKt {
    private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";

    private static final CoroutineContext foldCopies(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean bl) {
        boolean bl2 = CoroutineContextKt.hasCopyableElements(coroutineContext);
        boolean bl3 = CoroutineContextKt.hasCopyableElements(coroutineContext2);
        if (!bl2 && !bl3) {
            return coroutineContext.plus(coroutineContext2);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = coroutineContext2;
        coroutineContext = (CoroutineContext)coroutineContext.fold((Object)EmptyCoroutineContext.INSTANCE, (Function2)new Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext>((Ref.ObjectRef<CoroutineContext>)objectRef, bl){
            final boolean $isNewCoroutine;
            final Ref.ObjectRef<CoroutineContext> $leftoverContext;
            {
                this.$leftoverContext = objectRef;
                this.$isNewCoroutine = bl;
                super(2);
            }

            public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.Element copyableThreadContextElement) {
                if (!(copyableThreadContextElement instanceof CopyableThreadContextElement)) {
                    return coroutineContext.plus((CoroutineContext)copyableThreadContextElement);
                }
                CoroutineContext.Element element = ((CoroutineContext)this.$leftoverContext.element).get(copyableThreadContextElement.getKey());
                if (element == null) {
                    copyableThreadContextElement = this.$isNewCoroutine ? ((CopyableThreadContextElement)copyableThreadContextElement).copyForChild() : (CopyableThreadContextElement)copyableThreadContextElement;
                    return coroutineContext.plus((CoroutineContext)copyableThreadContextElement);
                }
                this.$leftoverContext.element = ((CoroutineContext)this.$leftoverContext.element).minusKey(copyableThreadContextElement.getKey());
                return coroutineContext.plus(copyableThreadContextElement.mergeForChild(element));
            }
        });
        if (bl3) {
            objectRef.element = ((CoroutineContext)objectRef.element).fold((Object)EmptyCoroutineContext.INSTANCE, (Function2)foldCopies.1.INSTANCE);
        }
        return coroutineContext.plus((CoroutineContext)objectRef.element);
    }

    public static final String getCoroutineName(CoroutineContext object) {
        CoroutineId coroutineId;
        block6: {
            block5: {
                if (!DebugKt.getDEBUG()) {
                    return null;
                }
                coroutineId = (CoroutineId)object.get((CoroutineContext.Key)CoroutineId.Key);
                if (coroutineId == null) {
                    return null;
                }
                if ((object = (CoroutineName)object.get((CoroutineContext.Key)CoroutineName.Key)) == null) break block5;
                String string2 = ((CoroutineName)((Object)object)).getName();
                object = string2;
                if (string2 != null) break block6;
            }
            object = "coroutine";
        }
        return (String)object + '#' + coroutineId.getId();
    }

    private static final boolean hasCopyableElements(CoroutineContext coroutineContext) {
        return (Boolean)coroutineContext.fold((Object)false, (Function2)hasCopyableElements.1.INSTANCE);
    }

    public static final CoroutineContext newCoroutineContext(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        if (!CoroutineContextKt.hasCopyableElements(coroutineContext2)) {
            return coroutineContext.plus(coroutineContext2);
        }
        return CoroutineContextKt.foldCopies(coroutineContext, coroutineContext2, false);
    }

    public static final CoroutineContext newCoroutineContext(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        block0: {
            coroutineContext = CoroutineContextKt.foldCopies(coroutineScope.getCoroutineContext(), coroutineContext, true);
            coroutineScope = DebugKt.getDEBUG() ? coroutineContext.plus((CoroutineContext)new CoroutineId(DebugKt.getCOROUTINE_ID().incrementAndGet())) : coroutineContext;
            if (coroutineContext == Dispatchers.getDefault() || coroutineContext.get((CoroutineContext.Key)ContinuationInterceptor.Key) != null) break block0;
            coroutineScope = coroutineScope.plus((CoroutineContext)Dispatchers.getDefault());
        }
        return coroutineScope;
    }

    public static final UndispatchedCoroutine<?> undispatchedCompletion(CoroutineStackFrame coroutineStackFrame) {
        do {
            if (coroutineStackFrame instanceof DispatchedCoroutine) {
                return null;
            }
            if ((coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) continue;
            return null;
        } while (!(coroutineStackFrame instanceof UndispatchedCoroutine));
        return (UndispatchedCoroutine)coroutineStackFrame;
    }

    public static final UndispatchedCoroutine<?> updateUndispatchedCompletion(Continuation<?> continuation, CoroutineContext coroutineContext, Object object) {
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        boolean bl = coroutineContext.get((CoroutineContext.Key)UndispatchedMarker.INSTANCE) != null;
        if (!bl) {
            return null;
        }
        if ((continuation = CoroutineContextKt.undispatchedCompletion((CoroutineStackFrame)continuation)) != null) {
            continuation.saveThreadContext(coroutineContext, object);
        }
        return continuation;
    }

    public static final <T> T withContinuationContext(Continuation<?> continuation, Object object, Function0<? extends T> object2) {
        CoroutineContext coroutineContext = continuation.getContext();
        object = ThreadContextKt.updateThreadContext(coroutineContext, object);
        continuation = object != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation, coroutineContext, object) : null;
        try {
            object2 = object2.invoke();
            return (T)object2;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            if (continuation == null || continuation.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(coroutineContext, object);
            }
            InlineMarker.finallyEnd((int)1);
        }
    }

    public static final <T> T withCoroutineContext(CoroutineContext coroutineContext, Object object, Function0<? extends T> object2) {
        object = ThreadContextKt.updateThreadContext(coroutineContext, object);
        try {
            object2 = object2.invoke();
            return (T)object2;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            ThreadContextKt.restoreThreadContext(coroutineContext, object);
            InlineMarker.finallyEnd((int)1);
        }
    }
}

