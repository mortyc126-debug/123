/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.Constructor;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt$$ExternalSyntheticLambda0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0011\u0010\b\u001a\u00020\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0001H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001a\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a\u001d\u0010\u0010\u001a\u00020\u0003*\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007\u00a2\u0006\u0002\b\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2={"MAX_DELAY", "", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "getMain$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFrameSlowPath", "postFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", "", "from", "asHandler", "Landroid/os/Looper;", "async", "", "kotlinx-coroutines-android"}, k=2, mv={1, 8, 0}, xi=48)
public final class HandlerDispatcherKt {
    private static final long MAX_DELAY = 0x3FFFFFFFFFFFFFFFL;
    public static final HandlerDispatcher Main;
    private static volatile Choreographer choreographer;

    public static /* synthetic */ void $r8$lambda$JvkVT-pCVfLu3tzMCeYQAqDm6wU(CancellableContinuation cancellableContinuation, long l) {
        HandlerDispatcherKt.postFrameCallback$lambda$6(cancellableContinuation, l);
    }

    static {
        Object object;
        Object var1 = null;
        try {
            object = Result.Companion;
            object = new HandlerContext(HandlerDispatcherKt.asHandler(Looper.getMainLooper(), true), null, 2, null);
            object = Result.constructor-impl((Object)object);
        }
        catch (Throwable throwable) {
            Result.Companion companion = Result.Companion;
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        if (Result.isFailure-impl((Object)object)) {
            object = var1;
        }
        Main = (HandlerDispatcher)object;
    }

    public static final /* synthetic */ Object access$awaitFrameSlowPath(Continuation continuation) {
        return HandlerDispatcherKt.awaitFrameSlowPath((Continuation<? super Long>)continuation);
    }

    public static final Handler asHandler(Looper object, boolean bl) {
        if (bl) {
            Constructor constructor;
            if (Build.VERSION.SDK_INT >= 28) {
                object = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, object);
                Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type android.os.Handler");
                return (Handler)object;
            }
            try {
                constructor = Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                return new Handler(object);
            }
            return (Handler)constructor.newInstance(object, null, true);
        }
        return new Handler(object);
    }

    public static final Object awaitFrame(Continuation<? super Long> continuation) {
        Choreographer choreographer = HandlerDispatcherKt.choreographer;
        if (choreographer != null) {
            Object object = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            ((CancellableContinuationImpl)object).initCancellability();
            HandlerDispatcherKt.postFrameCallback(choreographer, (CancellableContinuation)object);
            object = ((CancellableContinuationImpl)object).getResult();
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return object;
        }
        return HandlerDispatcherKt.awaitFrameSlowPath(continuation);
    }

    private static final Object awaitFrameSlowPath(Continuation<? super Long> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Object object = cancellableContinuationImpl;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            HandlerDispatcherKt.updateChoreographerAndPostFrameCallback((CancellableContinuation)object);
        } else {
            Dispatchers.getMain().dispatch(object.getContext(), new Runnable((CancellableContinuation)object){
                final CancellableContinuation $cont$inlined;
                {
                    this.$cont$inlined = cancellableContinuation;
                }

                public final void run() {
                    HandlerDispatcherKt.access$updateChoreographerAndPostFrameCallback(this.$cont$inlined);
                }
            });
        }
        object = cancellableContinuationImpl.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return object;
    }

    public static final HandlerDispatcher from(Handler handler) {
        return HandlerDispatcherKt.from$default(handler, null, 1, null);
    }

    public static final HandlerDispatcher from(Handler handler, String string2) {
        return new HandlerContext(handler, string2);
    }

    public static /* synthetic */ HandlerDispatcher from$default(Handler handler, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = null;
        }
        return HandlerDispatcherKt.from(handler, string2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use Dispatchers.Main instead")
    public static /* synthetic */ void getMain$annotations() {
    }

    private static final void postFrameCallback(Choreographer choreographer, CancellableContinuation<? super Long> cancellableContinuation) {
        choreographer.postFrameCallback((Choreographer.FrameCallback)new HandlerDispatcherKt$$ExternalSyntheticLambda0(cancellableContinuation));
    }

    private static final void postFrameCallback$lambda$6(CancellableContinuation cancellableContinuation, long l) {
        cancellableContinuation.resumeUndispatched(Dispatchers.getMain(), l);
    }

    private static final void updateChoreographerAndPostFrameCallback(CancellableContinuation<? super Long> cancellableContinuation) {
        Choreographer choreographer;
        Choreographer choreographer2 = choreographer = HandlerDispatcherKt.choreographer;
        if (choreographer == null) {
            choreographer2 = Choreographer.getInstance();
            Intrinsics.checkNotNull((Object)choreographer2);
            HandlerDispatcherKt.choreographer = choreographer2;
        }
        HandlerDispatcherKt.postFrameCallback(choreographer2, cancellableContinuation);
    }
}

