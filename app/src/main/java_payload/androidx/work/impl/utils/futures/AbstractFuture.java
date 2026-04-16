/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl.utils.futures;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import androidx.work.impl.utils.futures.DirectExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractFuture<V>
implements ListenableFuture<V> {
    static final AtomicHelper ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000L;
    private static final Logger log;
    volatile Listener listeners;
    volatile Object value;
    volatile Waiter waiters;

    static {
        AtomicHelper atomicHelper;
        GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        log = Logger.getLogger(AbstractFuture.class.getName());
        Throwable throwable = null;
        try {
            atomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
        }
        catch (Throwable throwable2) {
            atomicHelper = new SynchronizedHelper();
        }
        ATOMIC_HELPER = atomicHelper;
        if (throwable != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", throwable);
        }
        NULL = new Object();
    }

    protected AbstractFuture() {
    }

    private void addDoneString(StringBuilder stringBuilder) {
        try {
            V v = AbstractFuture.getUninterruptibly(this);
            stringBuilder.append("SUCCESS, result=[").append(this.userObjectToString(v)).append("]");
        }
        catch (RuntimeException runtimeException) {
            stringBuilder.append("UNKNOWN, cause=[").append(runtimeException.getClass()).append(" thrown from get()]");
        }
        catch (CancellationException cancellationException) {
            stringBuilder.append("CANCELLED");
        }
        catch (ExecutionException executionException) {
            stringBuilder.append("FAILURE, cause=[").append(executionException.getCause()).append("]");
        }
    }

    private static CancellationException cancellationExceptionWithCause(String object, Throwable throwable) {
        object = new CancellationException((String)object);
        ((Throwable)object).initCause(throwable);
        return object;
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    private Listener clearListeners(Listener listener2) {
        Listener listener3;
        while (!ATOMIC_HELPER.casListeners(this, listener3 = this.listeners, Listener.TOMBSTONE)) {
        }
        Listener listener4 = listener2;
        listener2 = listener3;
        while (listener2 != null) {
            listener3 = listener2.next;
            listener2.next = listener4;
            listener4 = listener2;
            listener2 = listener3;
        }
        return listener4;
    }

    static void complete(AbstractFuture<?> object) {
        Object object2 = null;
        AbstractFuture abstractFuture = object;
        object = object2;
        block0: while (true) {
            super.releaseWaiters();
            abstractFuture.afterDone();
            object = super.clearListeners((Listener)object);
            while ((abstractFuture = object) != null) {
                object = ((Listener)((Object)abstractFuture)).next;
                object2 = ((Listener)((Object)abstractFuture)).task;
                if (object2 instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture)object2;
                    abstractFuture = setFuture.owner;
                    if (abstractFuture.value != setFuture || !ATOMIC_HELPER.casValue(abstractFuture, setFuture, object2 = AbstractFuture.getFutureValue(setFuture.future))) continue;
                    continue block0;
                }
                AbstractFuture.executeListener((Runnable)object2, ((Listener)((Object)abstractFuture)).executor);
            }
            break;
        }
    }

    private static void executeListener(Runnable runnable2, Executor executor) {
        try {
            executor.execute(runnable2);
        }
        catch (RuntimeException runtimeException) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable2 + " with executor " + executor, runtimeException);
        }
    }

    private V getDoneValue(Object object) throws ExecutionException {
        if (!(object instanceof Cancellation)) {
            if (!(object instanceof Failure)) {
                if (object == NULL) {
                    return null;
                }
                return (V)object;
            }
            throw new ExecutionException(((Failure)object).exception);
        }
        throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", ((Cancellation)object).cause);
    }

    static Object getFutureValue(ListenableFuture<?> object) {
        block11: {
            Object object2;
            block10: {
                if (object instanceof AbstractFuture) {
                    Object object3 = ((AbstractFuture)object).value;
                    object = object3;
                    if (object3 instanceof Cancellation) {
                        Cancellation cancellation = (Cancellation)object3;
                        object = object3;
                        if (cancellation.wasInterrupted) {
                            object = cancellation.cause != null ? new Cancellation(false, cancellation.cause) : Cancellation.CAUSELESS_CANCELLED;
                        }
                    }
                    return object;
                }
                boolean bl = object.isCancelled();
                if ((GENERATE_CANCELLATION_CAUSES ^ true) & bl) {
                    return Cancellation.CAUSELESS_CANCELLED;
                }
                object2 = AbstractFuture.getUninterruptibly(object);
                if (object2 != null) break block10;
                try {
                    object2 = NULL;
                    object = object2;
                    break block11;
                }
                catch (Throwable throwable) {
                    return new Failure(throwable);
                }
                catch (CancellationException cancellationException) {
                    if (!bl) {
                        return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + object, cancellationException));
                    }
                    return new Cancellation(false, cancellationException);
                }
                catch (ExecutionException executionException) {
                    return new Failure(executionException.getCause());
                }
            }
            object = object2;
        }
        return object;
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        boolean bl = false;
        while (true) {
            V v;
            block5: {
                try {
                    v = future.get();
                    if (!bl) break block5;
                    Thread.currentThread().interrupt();
                }
                catch (Throwable throwable) {
                    if (bl) {
                        Thread.currentThread().interrupt();
                    }
                    throw throwable;
                }
                catch (InterruptedException interruptedException) {
                    bl = true;
                    continue;
                }
            }
            return v;
            break;
        }
    }

    private void releaseWaiters() {
        Waiter waiter;
        while (!ATOMIC_HELPER.casWaiters(this, waiter = this.waiters, Waiter.TOMBSTONE)) {
        }
        while (waiter != null) {
            waiter.unpark();
            waiter = waiter.next;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void removeWaiter(Waiter var1_1) {
        var1_1.thread = null;
        block0: while (true) {
            var2_2 = null;
            var1_1 = var3_3 = this.waiters;
            if (var3_3 == Waiter.TOMBSTONE) {
                return;
            }
            while (var1_1 != null) {
                var4_4 = var1_1.next;
                if (var1_1.thread != null) {
                    var3_3 = var1_1;
                } else if (var2_2 != null) {
                    var2_2.next = var4_4;
                    var3_3 = var2_2;
                    if (var2_2.thread == null) {
                        continue block0;
                    }
                } else {
                    var3_3 = var2_2;
                    if (AbstractFuture.ATOMIC_HELPER.casWaiters(this, var1_1, var4_4)) ** break;
                    continue block0;
                }
                var1_1 = var4_4;
                var2_2 = var3_3;
            }
            break;
        }
    }

    private String userObjectToString(Object object) {
        if (object == this) {
            return "this future";
        }
        return String.valueOf(object);
    }

    public final void addListener(Runnable runnable2, Executor executor) {
        AbstractFuture.checkNotNull(runnable2);
        AbstractFuture.checkNotNull(executor);
        Listener listener2 = this.listeners;
        if (listener2 != Listener.TOMBSTONE) {
            Listener listener3;
            Listener listener4 = new Listener(runnable2, executor);
            do {
                listener4.next = listener2;
                if (ATOMIC_HELPER.casListeners(this, listener2, listener4)) {
                    return;
                }
                listener2 = listener3 = this.listeners;
            } while (listener3 != Listener.TOMBSTONE);
        }
        AbstractFuture.executeListener(runnable2, executor);
    }

    protected void afterDone() {
    }

    public final boolean cancel(boolean bl) {
        Object object = this.value;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = object == null;
        if (bl4 | object instanceof SetFuture) {
            Cancellation cancellation = GENERATE_CANCELLATION_CAUSES ? new Cancellation(bl, new CancellationException("Future.cancel() was called.")) : (bl ? Cancellation.CAUSELESS_INTERRUPTED : Cancellation.CAUSELESS_CANCELLED);
            AbstractFuture abstractFuture = this;
            bl2 = bl3;
            while (true) {
                if (ATOMIC_HELPER.casValue(abstractFuture, object, cancellation)) {
                    bl3 = true;
                    boolean bl5 = true;
                    if (bl) {
                        abstractFuture.interruptTask();
                    }
                    AbstractFuture.complete(abstractFuture);
                    bl2 = bl3;
                    if (!(object instanceof SetFuture)) break;
                    object = ((SetFuture)object).future;
                    if (object instanceof AbstractFuture) {
                        abstractFuture = (AbstractFuture)object;
                        object = abstractFuture.value;
                        bl4 = object == null;
                        if (bl4 | object instanceof SetFuture) {
                            bl2 = bl5;
                            continue;
                        }
                    } else {
                        object.cancel(bl);
                    }
                    bl2 = bl3;
                    break;
                }
                Object object2 = abstractFuture.value;
                object = object2;
                if (!(object2 instanceof SetFuture)) break;
            }
        }
        return bl2;
    }

    public final V get() throws InterruptedException, ExecutionException {
        if (!Thread.interrupted()) {
            Object object = this.value;
            boolean bl = object != null;
            if (bl & (object instanceof SetFuture ^ true)) {
                return this.getDoneValue(object);
            }
            object = this.waiters;
            if (object != Waiter.TOMBSTONE) {
                Waiter waiter;
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.setNext((Waiter)object);
                    if (ATOMIC_HELPER.casWaiters(this, (Waiter)object, waiter2)) {
                        block6: {
                            do {
                                LockSupport.park(this);
                                if (Thread.interrupted()) break block6;
                            } while (!((bl = (object = this.value) != null) & (object instanceof SetFuture ^ true)));
                            return this.getDoneValue(object);
                        }
                        this.removeWaiter(waiter2);
                        throw new InterruptedException();
                    }
                    waiter = this.waiters;
                    object = waiter;
                } while (waiter != Waiter.TOMBSTONE);
            }
            return this.getDoneValue(this.value);
        }
        throw new InterruptedException();
    }

    public final V get(long l, TimeUnit object) throws InterruptedException, TimeoutException, ExecutionException {
        long l2 = ((TimeUnit)((Object)object)).toNanos(l);
        if (!Thread.interrupted()) {
            Object object2;
            long l3;
            long l4;
            boolean bl;
            Object object3;
            block17: {
                object3 = this.value;
                bl = object3 != null;
                if (bl & (object3 instanceof SetFuture ^ true)) {
                    return this.getDoneValue(object3);
                }
                l4 = l2 > 0L ? System.nanoTime() + l2 : 0L;
                l3 = l2;
                if (l2 >= 1000L) {
                    object3 = this.waiters;
                    if (object3 != Waiter.TOMBSTONE) {
                        object2 = new Waiter();
                        do {
                            ((Waiter)object2).setNext((Waiter)object3);
                            if (!ATOMIC_HELPER.casWaiters(this, (Waiter)object3, (Waiter)object2)) continue;
                            while (true) {
                                LockSupport.parkNanos(this, l2);
                                if (Thread.interrupted()) break;
                                object3 = this.value;
                                bl = object3 != null;
                                if (bl & (object3 instanceof SetFuture ^ true)) {
                                    return this.getDoneValue(object3);
                                }
                                l3 = l4 - System.nanoTime();
                                if (l3 < 1000L) {
                                    this.removeWaiter((Waiter)object2);
                                    break block17;
                                }
                                l2 = l3;
                            }
                            this.removeWaiter((Waiter)object2);
                            throw new InterruptedException();
                        } while ((object3 = this.waiters) != Waiter.TOMBSTONE);
                    }
                    return this.getDoneValue(this.value);
                }
            }
            while (l3 > 0L) {
                object3 = this.value;
                bl = object3 != null;
                if (bl & (object3 instanceof SetFuture ^ true)) {
                    return this.getDoneValue(object3);
                }
                if (!Thread.interrupted()) {
                    l3 = l4 - System.nanoTime();
                    continue;
                }
                throw new InterruptedException();
            }
            object2 = this.toString();
            String string2 = ((Enum)object).toString().toLowerCase(Locale.ROOT);
            object3 = "Waited " + l + " " + ((Enum)object).toString().toLowerCase(Locale.ROOT);
            if (l3 + 1000L < 0L) {
                object3 = (String)object3 + " (plus ";
                l3 = -l3;
                l = ((TimeUnit)((Object)object)).convert(l3, TimeUnit.NANOSECONDS);
                bl = l == 0L || (l3 -= ((TimeUnit)((Object)object)).toNanos(l)) > 1000L;
                object = object3;
                if (l > 0L) {
                    object = (String)object3 + l + " " + string2;
                    if (bl) {
                        object = (String)object + ",";
                    }
                    object = (String)object + " ";
                }
                object3 = object;
                if (bl) {
                    object3 = (String)object + l3 + " nanoseconds ";
                }
                object = (String)object3 + "delay)";
            } else {
                object = object3;
            }
            if (this.isDone()) {
                throw new TimeoutException((String)object + " but future completed as timeout expired");
            }
            throw new TimeoutException((String)object + " for " + (String)object2);
        }
        throw new InterruptedException();
    }

    protected void interruptTask() {
    }

    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    public final boolean isDone() {
        Object object = this.value;
        boolean bl = object != null;
        return (true ^ object instanceof SetFuture) & bl;
    }

    final void maybePropagateCancellationTo(Future<?> future) {
        boolean bl = future != null;
        if (bl & this.isCancelled()) {
            future.cancel(this.wasInterrupted());
        }
    }

    protected String pendingToString() {
        Object object = this.value;
        if (object instanceof SetFuture) {
            return "setFuture=[" + this.userObjectToString(((SetFuture)object).future) + "]";
        }
        if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture)((Object)this)).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
        return null;
    }

    protected boolean set(V object) {
        if (object == null) {
            object = NULL;
        }
        if (ATOMIC_HELPER.casValue(this, null, object)) {
            AbstractFuture.complete(this);
            return true;
        }
        return false;
    }

    protected boolean setException(Throwable object) {
        if (ATOMIC_HELPER.casValue(this, null, object = new Failure(AbstractFuture.checkNotNull(object)))) {
            AbstractFuture.complete(this);
            return true;
        }
        return false;
    }

    protected boolean setFuture(ListenableFuture<? extends V> object) {
        AbstractFuture.checkNotNull(object);
        SetFuture<? extends V> setFuture = this.value;
        SetFuture<? extends V> setFuture2 = setFuture;
        if (setFuture == null) {
            if (object.isDone()) {
                if (ATOMIC_HELPER.casValue(this, null, object = AbstractFuture.getFutureValue(object))) {
                    AbstractFuture.complete(this);
                    return true;
                }
                return false;
            }
            setFuture2 = new SetFuture<V>(this, object);
            if (ATOMIC_HELPER.casValue(this, null, setFuture2)) {
                try {
                    object.addListener(setFuture2, (Executor)DirectExecutor.INSTANCE);
                }
                catch (Throwable throwable) {
                    try {
                        object = new Object(throwable);
                    }
                    catch (Throwable throwable2) {
                        object = Failure.FALLBACK_INSTANCE;
                    }
                    ATOMIC_HELPER.casValue(this, setFuture2, object);
                }
                return true;
            }
            setFuture2 = this.value;
        }
        if (setFuture2 instanceof Cancellation) {
            object.cancel(((Cancellation)((Object)setFuture2)).wasInterrupted);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append(super.toString()).append("[status=");
        if (this.isCancelled()) {
            stringBuilder.append("CANCELLED");
        } else if (this.isDone()) {
            this.addDoneString(stringBuilder);
        } else {
            String string2;
            try {
                string2 = this.pendingToString();
            }
            catch (RuntimeException runtimeException) {
                string2 = "Exception thrown from implementation: " + runtimeException.getClass();
            }
            if (string2 != null && !string2.isEmpty()) {
                stringBuilder.append("PENDING, info=[").append(string2).append("]");
            } else if (this.isDone()) {
                this.addDoneString(stringBuilder);
            } else {
                stringBuilder.append("PENDING");
            }
        }
        return stringBuilder.append("]").toString();
    }

    protected final boolean wasInterrupted() {
        Object object = this.value;
        boolean bl = object instanceof Cancellation && ((Cancellation)object).wasInterrupted;
        return bl;
    }

    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        abstract boolean casListeners(AbstractFuture<?> var1, Listener var2, Listener var3);

        abstract boolean casValue(AbstractFuture<?> var1, Object var2, Object var3);

        abstract boolean casWaiters(AbstractFuture<?> var1, Waiter var2, Waiter var3);

        abstract void putNext(Waiter var1, Waiter var2);

        abstract void putThread(Waiter var1, Thread var2);
    }

    private static final class Cancellation {
        static final Cancellation CAUSELESS_CANCELLED;
        static final Cancellation CAUSELESS_INTERRUPTED;
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
            } else {
                CAUSELESS_CANCELLED = new Cancellation(false, null);
                CAUSELESS_INTERRUPTED = new Cancellation(true, null);
            }
        }

        Cancellation(boolean bl, Throwable throwable) {
            this.wasInterrupted = bl;
            this.cause = throwable;
        }
    }

    private static final class Failure {
        static final Failure FALLBACK_INSTANCE = new Failure(new Throwable("Failure occurred while trying to finish a future."){

            /*
             * Enabled aggressive block sorting
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            @Override
            public Throwable fillInStackTrace() {
                // MONITORENTER : this
                // MONITOREXIT : this
                return this;
            }
        });
        final Throwable exception;

        Failure(Throwable throwable) {
            this.exception = AbstractFuture.checkNotNull(throwable);
        }
    }

    private static final class Listener {
        static final Listener TOMBSTONE = new Listener(null, null);
        final Executor executor;
        Listener next;
        final Runnable task;

        Listener(Runnable runnable2, Executor executor) {
            this.task = runnable2;
            this.executor = executor;
        }
    }

    private static final class SafeAtomicHelper
    extends AtomicHelper {
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        @Override
        boolean casListeners(AbstractFuture<?> abstractFuture, Listener listener2, Listener listener3) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.listenersUpdater, abstractFuture, listener2, listener3);
        }

        @Override
        boolean casValue(AbstractFuture<?> abstractFuture, Object object, Object object2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.valueUpdater, abstractFuture, object, object2);
        }

        @Override
        boolean casWaiters(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.waitersUpdater, abstractFuture, waiter, waiter2);
        }

        @Override
        void putNext(Waiter waiter, Waiter waiter2) {
            this.waiterNextUpdater.lazySet(waiter, waiter2);
        }

        @Override
        void putThread(Waiter waiter, Thread thread) {
            this.waiterThreadUpdater.lazySet(waiter, thread);
        }
    }

    private static final class SetFuture<V>
    implements Runnable {
        final ListenableFuture<? extends V> future;
        final AbstractFuture<V> owner;

        SetFuture(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.owner = abstractFuture;
            this.future = listenableFuture;
        }

        @Override
        public void run() {
            if (this.owner.value != this) {
                return;
            }
            Object object = AbstractFuture.getFutureValue(this.future);
            if (ATOMIC_HELPER.casValue(this.owner, this, object)) {
                AbstractFuture.complete(this.owner);
            }
        }
    }

    private static final class SynchronizedHelper
    extends AtomicHelper {
        SynchronizedHelper() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        boolean casListeners(AbstractFuture<?> abstractFuture, Listener listener2, Listener listener3) {
            synchronized (abstractFuture) {
                if (abstractFuture.listeners == listener2) {
                    abstractFuture.listeners = listener3;
                    return true;
                }
                return false;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        boolean casValue(AbstractFuture<?> abstractFuture, Object object, Object object2) {
            synchronized (abstractFuture) {
                if (abstractFuture.value == object) {
                    abstractFuture.value = object2;
                    return true;
                }
                return false;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        boolean casWaiters(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                if (abstractFuture.waiters == waiter) {
                    abstractFuture.waiters = waiter2;
                    return true;
                }
                return false;
            }
        }

        @Override
        void putNext(Waiter waiter, Waiter waiter2) {
            waiter.next = waiter2;
        }

        @Override
        void putThread(Waiter waiter, Thread thread) {
            waiter.thread = thread;
        }
    }

    private static final class Waiter {
        static final Waiter TOMBSTONE = new Waiter(false);
        volatile Waiter next;
        volatile Thread thread;

        Waiter() {
            ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }

        Waiter(boolean bl) {
        }

        void setNext(Waiter waiter) {
            ATOMIC_HELPER.putNext(this, waiter);
        }

        void unpark() {
            Thread thread = this.thread;
            if (thread != null) {
                this.thread = null;
                LockSupport.unpark(thread);
            }
        }
    }
}

