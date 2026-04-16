/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class CallbackToFutureAdapter {
    private CallbackToFutureAdapter() {
    }

    public static <T> ListenableFuture<T> getFuture(Resolver<T> object) {
        SafeFuture safeFuture;
        block3: {
            Completer completer = new Completer();
            safeFuture = new SafeFuture(completer);
            completer.future = safeFuture;
            completer.tag = object.getClass();
            object = object.attachCompleter(completer);
            if (object == null) break block3;
            try {
                completer.tag = object;
            }
            catch (Exception exception) {
                safeFuture.setException(exception);
            }
        }
        return safeFuture;
    }

    public static final class Completer<T> {
        private boolean attemptedSetting;
        private ResolvableFuture<Void> cancellationFuture = ResolvableFuture.create();
        SafeFuture<T> future;
        Object tag;

        Completer() {
        }

        private void setCompletedNormally() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture = null;
        }

        public void addCancellationListener(Runnable runnable2, Executor executor) {
            ResolvableFuture<Void> resolvableFuture = this.cancellationFuture;
            if (resolvableFuture != null) {
                resolvableFuture.addListener(runnable2, executor);
            }
        }

        protected void finalize() {
            Object object = this.future;
            if (object != null && !((SafeFuture)object).isDone()) {
                ((SafeFuture)object).setException(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
            }
            if (!this.attemptedSetting && (object = this.cancellationFuture) != null) {
                ((ResolvableFuture)object).set(null);
            }
        }

        void fireCancellationListeners() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture.set(null);
        }

        public boolean set(T t) {
            boolean bl = true;
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture == null || !safeFuture.set(t)) {
                bl = false;
            }
            if (bl) {
                this.setCompletedNormally();
            }
            return bl;
        }

        public boolean setCancelled() {
            boolean bl = true;
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture == null || !safeFuture.cancelWithoutNotifyingCompleter(true)) {
                bl = false;
            }
            if (bl) {
                this.setCompletedNormally();
            }
            return bl;
        }

        public boolean setException(Throwable throwable) {
            boolean bl = true;
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture == null || !safeFuture.setException(throwable)) {
                bl = false;
            }
            if (bl) {
                this.setCompletedNormally();
            }
            return bl;
        }
    }

    static final class FutureGarbageCollectedException
    extends Throwable {
        FutureGarbageCollectedException(String string2) {
            super(string2);
        }

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
    }

    public static interface Resolver<T> {
        public Object attachCompleter(Completer<T> var1) throws Exception;
    }

    private static final class SafeFuture<T>
    implements ListenableFuture<T> {
        final WeakReference<Completer<T>> completerWeakReference;
        private final AbstractResolvableFuture<T> delegate = new AbstractResolvableFuture<T>(this){
            final SafeFuture this$0;
            {
                this.this$0 = safeFuture;
            }

            @Override
            protected String pendingToString() {
                Completer completer = (Completer)this.this$0.completerWeakReference.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + completer.tag + "]";
            }
        };

        SafeFuture(Completer<T> completer) {
            this.completerWeakReference = new WeakReference<Completer<Completer<T>>>(completer);
        }

        public void addListener(Runnable runnable2, Executor executor) {
            this.delegate.addListener(runnable2, executor);
        }

        public boolean cancel(boolean bl) {
            Completer completer = (Completer)this.completerWeakReference.get();
            if ((bl = this.delegate.cancel(bl)) && completer != null) {
                completer.fireCancellationListeners();
            }
            return bl;
        }

        boolean cancelWithoutNotifyingCompleter(boolean bl) {
            return this.delegate.cancel(bl);
        }

        public T get() throws InterruptedException, ExecutionException {
            return this.delegate.get();
        }

        public T get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.delegate.get(l, timeUnit);
        }

        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        public boolean isDone() {
            return this.delegate.isDone();
        }

        boolean set(T t) {
            return this.delegate.set(t);
        }

        boolean setException(Throwable throwable) {
            return this.delegate.setException(throwable);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }
}

