/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import java.util.ArrayDeque;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u001a9\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u000b\u001a\u0002H\t2\u0006\u0010\f\u001a\u0002H\t2\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u000f0\u000eH\u0002\u00a2\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u000f0\u000e2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002\u001a1\u0010\u0015\u001a\u00020\u00162\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u000f0\u00182\u0010\u0010\f\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u000f0\u000eH\u0002\u00a2\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0080H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001d\u001a+\u0010\u001e\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\t2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002\u00a2\u0006\u0002\u0010\u001f\u001a\u001f\u0010 \u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\tH\u0000\u00a2\u0006\u0002\u0010!\u001a,\u0010 \u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\t2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\"H\u0080\b\u00a2\u0006\u0002\u0010#\u001a \u0010$\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\tH\u0080\b\u00a2\u0006\u0002\u0010!\u001a\u001f\u0010%\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u001c\u001a\u0002H\tH\u0000\u00a2\u0006\u0002\u0010!\u001a1\u0010&\u001a\u0018\u0012\u0004\u0012\u0002H\t\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u000f0\u00180'\"\b\b\u0000\u0010\t*\u00020\n*\u0002H\tH\u0002\u00a2\u0006\u0002\u0010(\u001a\u001c\u0010)\u001a\u00020**\u00060\u0001j\u0002`\u000f2\n\u0010+\u001a\u00060\u0001j\u0002`\u000fH\u0002\u001a#\u0010,\u001a\u00020-*\f\u0012\b\u0012\u00060\u0001j\u0002`\u000f0\u00182\u0006\u0010.\u001a\u00020\u0003H\u0002\u00a2\u0006\u0002\u0010/\u001a\u0014\u00100\u001a\u00020\u0016*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\u0010\u00101\u001a\u00020**\u00060\u0001j\u0002`\u000fH\u0000\u001a\u001b\u00102\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n*\u0002H\tH\u0002\u00a2\u0006\u0002\u0010!\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000*\f\b\u0000\u00103\"\u00020\u00132\u00020\u0013*\f\b\u0000\u00104\"\u00020\u00012\u00020\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2={"ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "createFinalException", "E", "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "firstFrameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class StackTraceRecoveryKt {
    private static final StackTraceElement ARTIFICIAL_FRAME;
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    private static final String stackTraceRecoveryClassName;

    static {
        Object object;
        String string2 = stackTraceRecoveryClass;
        String string3 = baseContinuationImplClass;
        ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineBoundary();
        try {
            object = Result.Companion;
            object = Result.constructor-impl((Object)Class.forName(baseContinuationImplClass).getCanonicalName());
        }
        catch (Throwable throwable) {
            Result.Companion companion = Result.Companion;
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        if (Result.exceptionOrNull-impl((Object)object) != null) {
            object = string3;
        }
        baseContinuationImplClassName = (String)object;
        try {
            object = Result.Companion;
            object = Result.constructor-impl((Object)Class.forName(stackTraceRecoveryClass).getCanonicalName());
        }
        catch (Throwable throwable) {
            object = Result.Companion;
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        if (Result.exceptionOrNull-impl((Object)object) != null) {
            object = string2;
        }
        stackTraceRecoveryClassName = (String)object;
    }

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E object) {
        Throwable throwable = ((Throwable)object).getCause();
        if (throwable != null && Intrinsics.areEqual(throwable.getClass(), object.getClass())) {
            int n;
            StackTraceElement[] stackTraceElementArray;
            block3: {
                stackTraceElementArray = ((Throwable)object).getStackTrace();
                int n2 = stackTraceElementArray.length;
                for (n = 0; n < n2; ++n) {
                    if (!StackTraceRecoveryKt.isArtificial(stackTraceElementArray[n])) continue;
                    n = 1;
                    break block3;
                }
                n = 0;
            }
            object = n != 0 ? TuplesKt.to((Object)throwable, (Object)stackTraceElementArray) : TuplesKt.to((Object)object, (Object)new StackTraceElement[0]);
        } else {
            object = TuplesKt.to(object, (Object)new StackTraceElement[0]);
        }
        return object;
    }

    private static final <E extends Throwable> E createFinalException(E object, E e, ArrayDeque<StackTraceElement> object2) {
        int n;
        ((ArrayDeque)object2).addFirst((StackTraceElement)ARTIFICIAL_FRAME);
        StackTraceElement[] stackTraceElementArray = object.getStackTrace();
        int n2 = StackTraceRecoveryKt.firstFrameIndex(stackTraceElementArray, baseContinuationImplClassName);
        int n3 = 0;
        if (n2 == -1) {
            e.setStackTrace(((Collection)object2).toArray(new StackTraceElement[0]));
            return e;
        }
        object = new StackTraceElement[((ArrayDeque)object2).size() + n2];
        for (n = 0; n < n2; ++n) {
            object[n] = stackTraceElementArray[n];
        }
        object2 = ((ArrayDeque)object2).iterator();
        n = n3;
        while (true) {
            n3 = n;
            if (!object2.hasNext()) break;
            n = n3 + 1;
            object[n2 + n3] = (StackTraceElement)object2.next();
        }
        e.setStackTrace((StackTraceElement[])object);
        return e;
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame object) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<StackTraceElement>();
        StackTraceElement stackTraceElement = object.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(object instanceof CoroutineStackFrame)) {
                object = null;
            }
            if (object == null || (stackTraceElement = object.getCallerFrame()) == null) break;
            StackTraceElement stackTraceElement2 = stackTraceElement.getStackTraceElement();
            object = stackTraceElement;
            if (stackTraceElement2 == null) continue;
            arrayDeque.add(stackTraceElement2);
            object = stackTraceElement;
        }
        return arrayDeque;
    }

    private static final boolean elementWiseEquals(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        boolean bl = stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && Intrinsics.areEqual((Object)stackTraceElement.getMethodName(), (Object)stackTraceElement2.getMethodName()) && Intrinsics.areEqual((Object)stackTraceElement.getFileName(), (Object)stackTraceElement2.getFileName()) && Intrinsics.areEqual((Object)stackTraceElement.getClassName(), (Object)stackTraceElement2.getClassName());
        return bl;
    }

    private static final int firstFrameIndex(StackTraceElement[] stackTraceElementArray, String string2) {
        int n;
        block2: {
            int n2 = stackTraceElementArray.length;
            for (n = 0; n < n2; ++n) {
                if (!Intrinsics.areEqual((Object)string2, (Object)stackTraceElementArray[n].getClassName())) {
                    continue;
                }
                break block2;
            }
            n = -1;
        }
        return n;
    }

    public static final void initCause(Throwable throwable, Throwable throwable2) {
        throwable.initCause(throwable2);
    }

    public static final boolean isArtificial(StackTraceElement stackTraceElement) {
        return StringsKt.startsWith$default((String)stackTraceElement.getClassName(), (String)CoroutineDebuggingKt.getARTIFICIAL_FRAME_PACKAGE_NAME(), (boolean)false, (int)2, null);
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] stackTraceElementArray, ArrayDeque<StackTraceElement> arrayDeque) {
        int n;
        int n2;
        block5: {
            n2 = stackTraceElementArray.length;
            for (n = 0; n < n2; ++n) {
                if (!StackTraceRecoveryKt.isArtificial(stackTraceElementArray[n])) {
                    continue;
                }
                break block5;
            }
            n = -1;
        }
        n2 = n + 1;
        n = stackTraceElementArray.length - 1;
        if (n2 <= n) {
            while (true) {
                if (StackTraceRecoveryKt.elementWiseEquals(stackTraceElementArray[n], arrayDeque.getLast())) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArray[n]);
                if (n == n2) break;
                --n;
            }
        }
    }

    public static final Object recoverAndThrow(Throwable throwable, Continuation<?> continuation) {
        if (DebugKt.getRECOVER_STACK_TRACES()) {
            if (!(continuation instanceof CoroutineStackFrame)) {
                throw throwable;
            }
            throw StackTraceRecoveryKt.recoverFromStackFrame(throwable, (CoroutineStackFrame)continuation);
        }
        throw throwable;
    }

    private static final Object recoverAndThrow$$forInline(Throwable throwable, Continuation<?> continuation) {
        if (DebugKt.getRECOVER_STACK_TRACES()) {
            InlineMarker.mark((int)0);
            if (!(continuation instanceof CoroutineStackFrame)) {
                throw throwable;
            }
            throw StackTraceRecoveryKt.recoverFromStackFrame(throwable, (CoroutineStackFrame)continuation);
        }
        throw throwable;
    }

    private static final <E extends Throwable> E recoverFromStackFrame(E e, CoroutineStackFrame object) {
        Object object2 = StackTraceRecoveryKt.causeAndStacktrace(e);
        Throwable throwable = (Throwable)object2.component1();
        StackTraceElement[] stackTraceElementArray = (StackTraceElement[])object2.component2();
        object2 = ExceptionsConstructorKt.tryCopyException(throwable);
        if (object2 == null) {
            return e;
        }
        if (((ArrayDeque)(object = StackTraceRecoveryKt.createStackTrace((CoroutineStackFrame)object))).isEmpty()) {
            return e;
        }
        if (throwable != e) {
            StackTraceRecoveryKt.mergeRecoveredTraces(stackTraceElementArray, (ArrayDeque<StackTraceElement>)object);
        }
        return (E)StackTraceRecoveryKt.createFinalException(throwable, object2, (ArrayDeque<StackTraceElement>)object);
    }

    public static final <E extends Throwable> E recoverStackTrace(E e) {
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            return e;
        }
        E e2 = ExceptionsConstructorKt.tryCopyException(e);
        if (e2 == null) {
            return e;
        }
        return StackTraceRecoveryKt.sanitizeStackTrace(e2);
    }

    public static final <E extends Throwable> E recoverStackTrace(E e, Continuation<?> continuation) {
        if (DebugKt.getRECOVER_STACK_TRACES() && continuation instanceof CoroutineStackFrame) {
            return (E)StackTraceRecoveryKt.recoverFromStackFrame(e, (CoroutineStackFrame)continuation);
        }
        return e;
    }

    private static final <E extends Throwable> E sanitizeStackTrace(E e) {
        StackTraceElement stackTraceElement;
        int n;
        int n2;
        int n3;
        int n4;
        StackTraceElement[] stackTraceElementArray;
        block4: {
            stackTraceElementArray = e.getStackTrace();
            n4 = stackTraceElementArray.length;
            n3 = stackTraceElementArray.length - 1;
            if (n3 >= 0) {
                do {
                    n = n3;
                    n2 = n3 - 1;
                    stackTraceElement = stackTraceElementArray[n];
                    if (Intrinsics.areEqual((Object)stackTraceRecoveryClassName, (Object)stackTraceElement.getClassName())) {
                        n3 = n;
                        break block4;
                    }
                    n3 = n2;
                } while (n2 >= 0);
            }
            n3 = -1;
        }
        n = StackTraceRecoveryKt.firstFrameIndex(stackTraceElementArray, baseContinuationImplClassName);
        n2 = 0;
        n = n == -1 ? 0 : n4 - n;
        n4 = n4 - n3 - n;
        StackTraceElement[] stackTraceElementArray2 = new StackTraceElement[n4];
        for (n = n2; n < n4; ++n) {
            stackTraceElement = n == 0 ? ARTIFICIAL_FRAME : stackTraceElementArray[n3 + 1 + n - 1];
            stackTraceElementArray2[n] = stackTraceElement;
        }
        e.setStackTrace(stackTraceElementArray2);
        return e;
    }

    public static final <E extends Throwable> E unwrap(E e) {
        if (DebugKt.getRECOVER_STACK_TRACES()) {
            e = StackTraceRecoveryKt.unwrapImpl(e);
        }
        return e;
    }

    public static final <E extends Throwable> E unwrapImpl(E e) {
        Throwable throwable = e.getCause();
        if (throwable != null && Intrinsics.areEqual(throwable.getClass(), e.getClass())) {
            int n;
            block3: {
                StackTraceElement[] stackTraceElementArray = e.getStackTrace();
                int n2 = stackTraceElementArray.length;
                int n3 = 0;
                for (n = 0; n < n2; ++n) {
                    if (!StackTraceRecoveryKt.isArtificial(stackTraceElementArray[n])) continue;
                    n = 1;
                    break block3;
                }
                n = n3;
            }
            if (n != 0) {
                return (E)throwable;
            }
            return e;
        }
        return e;
    }
}

