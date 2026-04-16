/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorCoroutine;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b\u0000\u001aM\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a2\u0006\u0002\b\fH\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2={"SupervisorJob", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "SupervisorJob0", "supervisorScope", "R", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class SupervisorKt {
    public static final CompletableJob SupervisorJob(Job job2) {
        return new SupervisorJobImpl(job2);
    }

    public static /* synthetic */ CompletableJob SupervisorJob$default(Job job2, int n, Object object) {
        if ((n & 1) != 0) {
            job2 = null;
        }
        return SupervisorKt.SupervisorJob(job2);
    }

    public static /* synthetic */ Job SupervisorJob$default(Job job2, int n, Object object) {
        if ((n & 1) != 0) {
            job2 = null;
        }
        return SupervisorKt.SupervisorJob(job2);
    }

    public static final <R> Object supervisorScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> object, Continuation<? super R> continuation) {
        SupervisorCoroutine<R> supervisorCoroutine = new SupervisorCoroutine<R>(continuation.getContext(), continuation);
        object = UndispatchedKt.startUndispatchedOrReturn((ScopeCoroutine)supervisorCoroutine, supervisorCoroutine, object);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return object;
    }
}

