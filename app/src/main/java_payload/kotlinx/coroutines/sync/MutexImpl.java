/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlinx.coroutines.sync;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.SemaphoreImpl;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0002*+B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u001b\u0010\u001e\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u001b\u0010 \u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u001e\u0010!\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\"\u001a\u0004\u0018\u00010\nH\u0014J\u001e\u0010#\u001a\u00020\u00192\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010'\u001a\u00020(2\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010)\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0006\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R(\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\t8VX\u0096\u0004\u00a2\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eRk\u0010\u000f\u001a_\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00170\u0010j\u0002`\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001cX\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2={"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "(Z)V", "isLocked", "()Z", "onLock", "Lkotlinx/coroutines/selects/SelectClause2;", "", "getOnLock$annotations", "()V", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSelectCancellationUnlockConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", "param", "internalResult", "Lkotlin/Function1;", "", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "owner", "Lkotlinx/atomicfu/AtomicRef;", "holdsLock", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "onLockProcessResult", "result", "onLockRegFunction", "toString", "", "tryLock", "tryLockImpl", "", "unlock", "CancellableContinuationWithOwner", "SelectInstanceWithOwner", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class MutexImpl
extends SemaphoreImpl
implements Mutex {
    private static final AtomicReferenceFieldUpdater owner$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onSelectCancellationUnlockConstructor;
    @Volatile
    private volatile Object owner;

    public MutexImpl(boolean bl) {
        super(1, bl ? 1 : 0);
        Symbol symbol = bl ? null : MutexKt.access$getNO_OWNER$p();
        this.owner = symbol;
        this.onSelectCancellationUnlockConstructor = new Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>(this){
            final MutexImpl this$0;
            {
                this.this$0 = mutexImpl;
                super(3);
            }

            public final Function1<Throwable, Unit> invoke(SelectInstance<?> selectInstance, Object object, Object object2) {
                return (Function1)new Function1<Throwable, Unit>(this.this$0, object){
                    final Object $owner;
                    final MutexImpl this$0;
                    {
                        this.this$0 = mutexImpl;
                        this.$owner = object;
                        super(1);
                    }

                    public final void invoke(Throwable throwable) {
                        this.this$0.unlock(this.$owner);
                    }
                };
            }
        };
    }

    public static final /* synthetic */ Object access$lockSuspend(MutexImpl mutexImpl, Object object, Continuation continuation) {
        return mutexImpl.lockSuspend(object, (Continuation<? super Unit>)continuation);
    }

    public static /* synthetic */ void getOnLock$annotations() {
    }

    static /* synthetic */ Object lock$suspendImpl(MutexImpl object, Object object2, Continuation<? super Unit> continuation) {
        if (((MutexImpl)object).tryLock(object2)) {
            return Unit.INSTANCE;
        }
        if ((object = ((MutexImpl)object).lockSuspend(object2, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final Object lockSuspend(Object object, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            CancellableContinuationWithOwner cancellableContinuationWithOwner = new CancellableContinuationWithOwner(this, cancellableContinuationImpl, object);
            this.acquire(cancellableContinuationWithOwner);
            object = cancellableContinuationImpl.getResult();
        }
        catch (Throwable throwable) {
            cancellableContinuationImpl.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw throwable;
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final int tryLockImpl(Object object) {
        do {
            boolean bl = this.tryAcquire();
            boolean bl2 = true;
            if (bl) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (owner$FU.get(this) != MutexKt.access$getNO_OWNER$p()) {
                        bl2 = false;
                    }
                    if (!bl2) {
                        throw new AssertionError();
                    }
                }
                owner$FU.set(this, object);
                return 0;
            }
            if (object == null) break;
            if (!this.holdsLock(object)) continue;
            return 2;
        } while (!this.isLocked());
        return 1;
    }

    @Override
    public SelectClause2<Object, Mutex> getOnLock() {
        onLock.1 var1_1 = onLock.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var1_1), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        var1_1 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var1_1), (int)3);
        onLock.2 var2_2 = onLock.2.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var2_2), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, var1_1, (Function3<Object, Object, Object, ? extends Object>)((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var2_2), (int)3)), this.onSelectCancellationUnlockConstructor);
    }

    @Override
    public boolean holdsLock(Object object) {
        boolean bl;
        Object v;
        do {
            boolean bl2 = this.isLocked();
            bl = false;
            if (bl2) continue;
            return false;
        } while ((v = owner$FU.get(this)) == MutexKt.access$getNO_OWNER$p());
        if (v == object) {
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean isLocked() {
        boolean bl = this.getAvailablePermits() == 0;
        return bl;
    }

    @Override
    public Object lock(Object object, Continuation<? super Unit> continuation) {
        return MutexImpl.lock$suspendImpl(this, object, continuation);
    }

    protected Object onLockProcessResult(Object object, Object object2) {
        if (!Intrinsics.areEqual((Object)object2, (Object)MutexKt.access$getON_LOCK_ALREADY_LOCKED_BY_OWNER$p())) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + object).toString());
    }

    protected void onLockRegFunction(SelectInstance<?> selectInstance, Object object) {
        if (object != null && this.holdsLock(object)) {
            selectInstance.selectInRegistrationPhase(MutexKt.access$getON_LOCK_ALREADY_LOCKED_BY_OWNER$p());
        } else {
            Intrinsics.checkNotNull(selectInstance, (String)"null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            this.onAcquireRegFunction(new SelectInstanceWithOwner(this, (SelectInstanceInternal)selectInstance, object), object);
        }
    }

    public String toString() {
        return "Mutex@" + DebugStringsKt.getHexAddress(this) + "[isLocked=" + this.isLocked() + ",owner=" + owner$FU.get(this) + ']';
    }

    @Override
    public boolean tryLock(Object object) {
        boolean bl;
        switch (this.tryLockImpl(object)) {
            default: {
                throw new IllegalStateException("unexpected".toString());
            }
            case 2: {
                throw new IllegalStateException(("This mutex is already locked by the specified owner: " + object).toString());
            }
            case 1: {
                bl = false;
                break;
            }
            case 0: {
                bl = true;
            }
        }
        return bl;
    }

    @Override
    public void unlock(Object object) {
        while (this.isLocked()) {
            Object v = owner$FU.get(this);
            if (v == MutexKt.access$getNO_OWNER$p()) continue;
            boolean bl = v == object || object == null;
            if (bl) {
                if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(owner$FU, this, v, MutexKt.access$getNO_OWNER$p())) continue;
                this.release();
                return;
            }
            throw new IllegalStateException(("This mutex is locked by " + v + ", but " + object + " is expected").toString());
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    @Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0015\u0010\u0012\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0007H\u0097\u0001J\t\u0010\u0017\u001a\u00020\u0002H\u0097\u0001J2\u0010\u0018\u001a\u00020\u00022'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00020\u001aj\u0002`\u001dH\u0096\u0001J\u001d\u0010\u0018\u001a\u00020\u00022\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010 \u001a\u00020!H\u0096\u0001J:\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022#\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aH\u0016\u00a2\u0006\u0002\u0010%J\u001f\u0010&\u001a\u00020\u00022\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020(H\u0096\u0001\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J$\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0007H\u0097\u0001\u00a2\u0006\u0002\u0010,JF\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\u00072#\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aH\u0016\u00a2\u0006\u0002\u0010-J\u0013\u0010.\u001a\u0004\u0018\u00010\u00072\u0006\u0010/\u001a\u00020\u0014H\u0097\u0001J\u001a\u00100\u001a\u00020\u0002*\u0002012\u0006\u0010#\u001a\u00020\u0002H\u0097\u0001\u00a2\u0006\u0002\u00102J\u0015\u00103\u001a\u00020\u0002*\u0002012\u0006\u0010/\u001a\u00020\u0014H\u0097\u0001R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\nX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u000eX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0012\u0010\u0011\u001a\u00020\u000eX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00064"}, d2={"Lkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner;", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Object;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "isActive", "", "()Z", "isCancelled", "isCompleted", "cancel", "cause", "", "completeResume", "token", "initCancellability", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "resume", "value", "onCancellation", "(Lkotlin/Unit;Lkotlin/jvm/functions/Function1;)V", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "tryResume", "idempotent", "(Lkotlin/Unit;Ljava/lang/Object;)Ljava/lang/Object;", "(Lkotlin/Unit;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tryResumeWithException", "exception", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/Unit;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class CancellableContinuationWithOwner
    implements CancellableContinuation<Unit>,
    Waiter {
        public final CancellableContinuationImpl<Unit> cont;
        public final Object owner;
        final MutexImpl this$0;

        public CancellableContinuationWithOwner(MutexImpl mutexImpl, CancellableContinuationImpl<? super Unit> cancellableContinuationImpl, Object object) {
            this.this$0 = mutexImpl;
            this.cont = cancellableContinuationImpl;
            this.owner = object;
        }

        @Override
        public boolean cancel(Throwable throwable) {
            return this.cont.cancel(throwable);
        }

        @Override
        public void completeResume(Object object) {
            this.cont.completeResume(object);
        }

        public CoroutineContext getContext() {
            return this.cont.getContext();
        }

        @Override
        public void initCancellability() {
            this.cont.initCancellability();
        }

        @Override
        public void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
            this.cont.invokeOnCancellation(function1);
        }

        @Override
        public void invokeOnCancellation(Segment<?> segment, int n) {
            this.cont.invokeOnCancellation(segment, n);
        }

        @Override
        public boolean isActive() {
            return this.cont.isActive();
        }

        @Override
        public boolean isCancelled() {
            return this.cont.isCancelled();
        }

        @Override
        public boolean isCompleted() {
            return this.cont.isCompleted();
        }

        @Override
        public void resume(Unit unit, Function1<? super Throwable, Unit> object) {
            boolean bl;
            object = this.this$0;
            if (DebugKt.getASSERTIONS_ENABLED() && !(bl = owner$FU.get(object) == MutexKt.access$getNO_OWNER$p())) {
                throw new AssertionError();
            }
            owner$FU.set(this.this$0, this.owner);
            this.cont.resume(unit, (Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(this.this$0, this){
                final MutexImpl this$0;
                final CancellableContinuationWithOwner this$1;
                {
                    this.this$0 = mutexImpl;
                    this.this$1 = cancellableContinuationWithOwner;
                    super(1);
                }

                public final void invoke(Throwable throwable) {
                    this.this$0.unlock(this.this$1.owner);
                }
            }));
        }

        @Override
        public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, Unit unit) {
            this.cont.resumeUndispatched(coroutineDispatcher, unit);
        }

        @Override
        public void resumeUndispatchedWithException(CoroutineDispatcher coroutineDispatcher, Throwable throwable) {
            this.cont.resumeUndispatchedWithException(coroutineDispatcher, throwable);
        }

        public void resumeWith(Object object) {
            this.cont.resumeWith(object);
        }

        @Override
        public Object tryResume(Unit unit, Object object) {
            return this.cont.tryResume(unit, object);
        }

        @Override
        public Object tryResume(Unit object, Object object2, Function1<? super Throwable, Unit> object3) {
            boolean bl;
            object3 = this.this$0;
            boolean bl2 = DebugKt.getASSERTIONS_ENABLED();
            boolean bl3 = true;
            if (bl2 && !(bl = owner$FU.get(object3) == MutexKt.access$getNO_OWNER$p())) {
                throw new AssertionError();
            }
            if ((object2 = this.cont.tryResume((Unit)object, object2, (Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(this.this$0, this){
                final MutexImpl this$0;
                final CancellableContinuationWithOwner this$1;
                {
                    this.this$0 = mutexImpl;
                    this.this$1 = cancellableContinuationWithOwner;
                    super(1);
                }

                public final void invoke(Throwable object) {
                    MutexImpl mutexImpl = this.this$0;
                    object = this.this$1;
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        mutexImpl = MutexImpl.access$getOwner$FU$p().get(mutexImpl);
                        boolean bl = mutexImpl == MutexKt.access$getNO_OWNER$p() || mutexImpl == ((CancellableContinuationWithOwner)object).owner;
                        if (!bl) {
                            throw new AssertionError();
                        }
                    }
                    MutexImpl.access$getOwner$FU$p().set(this.this$0, this.this$1.owner);
                    this.this$0.unlock(this.this$1.owner);
                }
            }))) != null) {
                object = this.this$0;
                if (DebugKt.getASSERTIONS_ENABLED() && !(bl = owner$FU.get(object) == MutexKt.access$getNO_OWNER$p() ? bl3 : false)) {
                    throw new AssertionError();
                }
                owner$FU.set(this.this$0, this.owner);
            }
            return object2;
        }

        @Override
        public Object tryResumeWithException(Throwable throwable) {
            return this.cont.tryResumeWithException(throwable);
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u001d\u0010\u000f\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016R\u0012\u0010\u0007\u001a\u00020\bX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner;", "Q", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "select", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/selects/SelectInstanceInternal;Ljava/lang/Object;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "disposeOnCompletion", "", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "selectInRegistrationPhase", "internalResult", "trySelect", "", "clauseObject", "result", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class SelectInstanceWithOwner<Q>
    implements SelectInstanceInternal<Q> {
        public final Object owner;
        public final SelectInstanceInternal<Q> select;
        final MutexImpl this$0;

        public SelectInstanceWithOwner(MutexImpl mutexImpl, SelectInstanceInternal<Q> selectInstanceInternal, Object object) {
            this.this$0 = mutexImpl;
            this.select = selectInstanceInternal;
            this.owner = object;
        }

        @Override
        public void disposeOnCompletion(DisposableHandle disposableHandle) {
            this.select.disposeOnCompletion(disposableHandle);
        }

        @Override
        public CoroutineContext getContext() {
            return this.select.getContext();
        }

        @Override
        public void invokeOnCancellation(Segment<?> segment, int n) {
            this.select.invokeOnCancellation(segment, n);
        }

        @Override
        public void selectInRegistrationPhase(Object object) {
            boolean bl;
            MutexImpl mutexImpl = this.this$0;
            if (DebugKt.getASSERTIONS_ENABLED() && !(bl = owner$FU.get(mutexImpl) == MutexKt.access$getNO_OWNER$p())) {
                throw new AssertionError();
            }
            owner$FU.set(this.this$0, this.owner);
            this.select.selectInRegistrationPhase(object);
        }

        @Override
        public boolean trySelect(Object object, Object object2) {
            boolean bl;
            MutexImpl mutexImpl = this.this$0;
            if (DebugKt.getASSERTIONS_ENABLED() && !(bl = owner$FU.get(mutexImpl) == MutexKt.access$getNO_OWNER$p())) {
                throw new AssertionError();
            }
            boolean bl2 = this.select.trySelect(object, object2);
            object = this.this$0;
            if (bl2) {
                owner$FU.set(object, this.owner);
            }
            return bl2;
        }
    }
}

