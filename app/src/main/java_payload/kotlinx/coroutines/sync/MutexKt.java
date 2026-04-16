/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n\u001aB\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f*\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010H\u0086H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0002\u0010\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2={"NO_OWNER", "Lkotlinx/coroutines/internal/Symbol;", "ON_LOCK_ALREADY_LOCKED_BY_OWNER", "TRY_LOCK_ALREADY_LOCKED_BY_OWNER", "", "TRY_LOCK_FAILED", "TRY_LOCK_SUCCESS", "Mutex", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "withLock", "T", "owner", "", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class MutexKt {
    private static final Symbol NO_OWNER = new Symbol("NO_OWNER");
    private static final Symbol ON_LOCK_ALREADY_LOCKED_BY_OWNER = new Symbol("ALREADY_LOCKED_BY_OWNER");
    private static final int TRY_LOCK_ALREADY_LOCKED_BY_OWNER = 2;
    private static final int TRY_LOCK_FAILED = 1;
    private static final int TRY_LOCK_SUCCESS = 0;

    public static final Mutex Mutex(boolean bl) {
        return new MutexImpl(bl);
    }

    public static /* synthetic */ Mutex Mutex$default(boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        return MutexKt.Mutex(bl);
    }

    public static final /* synthetic */ Symbol access$getNO_OWNER$p() {
        return NO_OWNER;
    }

    public static final /* synthetic */ Symbol access$getON_LOCK_ALREADY_LOCKED_BY_OWNER$p() {
        return ON_LOCK_ALREADY_LOCKED_BY_OWNER;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object withLock(Mutex var0, Object var1_1, Function0<? extends T> var2_2, Continuation<? super T> var3_4) {
        if (!(var3_4 instanceof withLock.1)) ** GOTO lbl-1000
        var4_5 /* !! */  = var3_4;
        if ((var4_5 /* !! */ .label & -2147483648) != 0) {
            var4_5 /* !! */ .label += -2147483648;
            var3_4 = var4_5 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var3_4 = new ContinuationImpl(var3_4){
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return MutexKt.withLock(null, null, null, (Continuation)this);
                }
            };
        }
        var4_5 /* !! */  = var3_4.result;
        var5_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var3_4.label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var2_2 /* !! */  = (Function0)var3_4.L$2;
                var0 = var3_4.L$1;
                var1_1 /* !! */  = (Mutex)var3_4.L$0;
                ResultKt.throwOnFailure((Object)var4_5 /* !! */ );
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var4_5 /* !! */ );
                var3_4.L$0 = var0;
                var3_4.L$1 = var1_1 /* !! */ ;
                var3_4.L$2 = var2_2 /* !! */ ;
                var3_4.label = 1;
                if (var0.lock(var1_1 /* !! */ , var3_4) == var5_6) {
                    return var5_6;
                }
                var3_4 = var0;
                var0 = var1_1 /* !! */ ;
                var1_1 /* !! */  = var3_4;
            }
        }
        try {
            var2_2 /* !! */  = var2_2 /* !! */ .invoke();
            return var2_2 /* !! */ ;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            var1_1 /* !! */ .unlock(var0);
            InlineMarker.finallyEnd((int)1);
        }
    }

    private static final <T> Object withLock$$forInline(Mutex mutex, Object object, Function0<? extends T> object2, Continuation<? super T> continuation) {
        InlineMarker.mark((int)0);
        mutex.lock(object, continuation);
        InlineMarker.mark((int)1);
        try {
            object2 = object2.invoke();
            return object2;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            mutex.unlock(object);
            InlineMarker.finallyEnd((int)1);
        }
    }

    public static /* synthetic */ Object withLock$default(Mutex mutex, Object object, Function0 object2, Continuation continuation, int n, Object object3) {
        if ((n & 1) != 0) {
            object = null;
        }
        InlineMarker.mark((int)0);
        mutex.lock(object, (Continuation<? super Unit>)continuation);
        InlineMarker.mark((int)1);
        try {
            object2 = object2.invoke();
            return object2;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            mutex.unlock(object);
            InlineMarker.finallyEnd((int)1);
        }
    }
}

