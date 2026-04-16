/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Process
 */
package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.provider.CalleeHandler;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class RequestExecutor {
    private RequestExecutor() {
    }

    static ThreadPoolExecutor createDefaultExecutor(String object, int n, int n2) {
        object = new DefaultThreadFactory((String)object, n);
        object = new ThreadPoolExecutor(0, 1, (long)n2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(), (ThreadFactory)object);
        ((ThreadPoolExecutor)object).allowCoreThreadTimeOut(true);
        return object;
    }

    static Executor createHandlerExecutor(Handler handler) {
        return new HandlerExecutor(handler);
    }

    static <T> void execute(Executor executor, Callable<T> callable, Consumer<T> consumer) {
        executor.execute(new ReplyRunnable<T>(CalleeHandler.create(), callable, consumer));
    }

    static <T> T submit(ExecutorService object, Callable<T> callable, int n) throws InterruptedException {
        object = object.submit(callable);
        long l = n;
        try {
            object = object.get(l, TimeUnit.MILLISECONDS);
        }
        catch (TimeoutException timeoutException) {
            throw new InterruptedException("timeout");
        }
        catch (InterruptedException interruptedException) {
            throw interruptedException;
        }
        catch (ExecutionException executionException) {
            throw new RuntimeException(executionException);
        }
        return (T)object;
    }

    private static class DefaultThreadFactory
    implements ThreadFactory {
        private int mPriority;
        private String mThreadName;

        DefaultThreadFactory(String string2, int n) {
            this.mThreadName = string2;
            this.mPriority = n;
        }

        @Override
        public Thread newThread(Runnable runnable2) {
            return new ProcessPriorityThread(runnable2, this.mThreadName, this.mPriority);
        }

        private static class ProcessPriorityThread
        extends Thread {
            private final int mPriority;

            ProcessPriorityThread(Runnable runnable2, String string2, int n) {
                super(runnable2, string2);
                this.mPriority = n;
            }

            @Override
            public void run() {
                Process.setThreadPriority((int)this.mPriority);
                super.run();
            }
        }
    }

    private static class HandlerExecutor
    implements Executor {
        private final Handler mHandler;

        HandlerExecutor(Handler handler) {
            this.mHandler = Preconditions.checkNotNull(handler);
        }

        @Override
        public void execute(Runnable runnable2) {
            if (this.mHandler.post(Preconditions.checkNotNull(runnable2))) {
                return;
            }
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    private static class ReplyRunnable<T>
    implements Runnable {
        private Callable<T> mCallable;
        private Consumer<T> mConsumer;
        private Handler mHandler;

        ReplyRunnable(Handler handler, Callable<T> callable, Consumer<T> consumer) {
            this.mCallable = callable;
            this.mConsumer = consumer;
            this.mHandler = handler;
        }

        @Override
        public void run() {
            T t;
            try {
                t = this.mCallable.call();
            }
            catch (Exception exception) {
                t = null;
            }
            Consumer<T> consumer = this.mConsumer;
            this.mHandler.post(new Runnable(){
                final ReplyRunnable this$0;
                final Consumer val$consumer;
                final Object val$result;
                {
                    this.this$0 = replyRunnable;
                    this.val$consumer = consumer;
                    this.val$result = object;
                }

                @Override
                public void run() {
                    this.val$consumer.accept(this.val$result);
                }
            });
        }
    }
}

