/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.coroutines.sync.SemaphoreKt;
import kotlinx.coroutines.sync.SemaphoreSegment;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u001a\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002\u001a6\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0002\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2={"BROKEN", "Lkotlinx/coroutines/internal/Symbol;", "CANCELLED", "MAX_SPIN_CYCLES", "", "PERMIT", "SEGMENT_SIZE", "TAKEN", "Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "acquiredPermits", "createSegment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "id", "", "prev", "withPermit", "T", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class SemaphoreKt {
    private static final Symbol BROKEN;
    private static final Symbol CANCELLED;
    private static final int MAX_SPIN_CYCLES;
    private static final Symbol PERMIT;
    private static final int SEGMENT_SIZE;
    private static final Symbol TAKEN;

    static {
        MAX_SPIN_CYCLES = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        PERMIT = new Symbol("PERMIT");
        TAKEN = new Symbol("TAKEN");
        BROKEN = new Symbol("BROKEN");
        CANCELLED = new Symbol("CANCELLED");
        SEGMENT_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
    }

    public static final Semaphore Semaphore(int n, int n2) {
        return new SemaphoreImpl(n, n2);
    }

    public static /* synthetic */ Semaphore Semaphore$default(int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        return SemaphoreKt.Semaphore(n, n2);
    }

    public static final /* synthetic */ SemaphoreSegment access$createSegment(long l, SemaphoreSegment semaphoreSegment) {
        return SemaphoreKt.createSegment(l, semaphoreSegment);
    }

    public static final /* synthetic */ Symbol access$getBROKEN$p() {
        return BROKEN;
    }

    public static final /* synthetic */ Symbol access$getCANCELLED$p() {
        return CANCELLED;
    }

    public static final /* synthetic */ int access$getMAX_SPIN_CYCLES$p() {
        return MAX_SPIN_CYCLES;
    }

    public static final /* synthetic */ Symbol access$getPERMIT$p() {
        return PERMIT;
    }

    public static final /* synthetic */ int access$getSEGMENT_SIZE$p() {
        return SEGMENT_SIZE;
    }

    public static final /* synthetic */ Symbol access$getTAKEN$p() {
        return TAKEN;
    }

    private static final SemaphoreSegment createSegment(long l, SemaphoreSegment semaphoreSegment) {
        return new SemaphoreSegment(l, semaphoreSegment, 0);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object withPermit(Semaphore var0, Function0<? extends T> var1_1, Continuation<? super T> var2_3) {
        if (!(var2_3 /* !! */  instanceof withPermit.1)) ** GOTO lbl-1000
        var3_4 /* !! */  = var2_3 /* !! */ ;
        if ((var3_4 /* !! */ .label & -2147483648) != 0) {
            var3_4 /* !! */ .label += -2147483648;
            var2_3 /* !! */  = var3_4 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var2_3 /* !! */  = new ContinuationImpl(var2_3 /* !! */ ){
                Object L$0;
                Object L$1;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return SemaphoreKt.withPermit(null, null, (Continuation)this);
                }
            };
        }
        var3_4 /* !! */  = var2_3 /* !! */ .result;
        var4_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var2_3 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var1_1 /* !! */  = (Function0)var2_3 /* !! */ .L$1;
                var0 = (Semaphore)var2_3 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var3_4 /* !! */ );
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var3_4 /* !! */ );
                var2_3 /* !! */ .L$0 = var0;
                var2_3 /* !! */ .L$1 = var1_1 /* !! */ ;
                var2_3 /* !! */ .label = 1;
                if (var0.acquire(var2_3 /* !! */ ) != var4_5) break;
                return var4_5;
            }
        }
        try {
            var1_1 /* !! */  = var1_1 /* !! */ .invoke();
            return var1_1 /* !! */ ;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            var0.release();
            InlineMarker.finallyEnd((int)1);
        }
    }

    private static final <T> Object withPermit$$forInline(Semaphore semaphore, Function0<? extends T> object, Continuation<? super T> continuation) {
        InlineMarker.mark((int)0);
        semaphore.acquire(continuation);
        InlineMarker.mark((int)1);
        try {
            object = object.invoke();
            return object;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            semaphore.release();
            InlineMarker.finallyEnd((int)1);
        }
    }
}

