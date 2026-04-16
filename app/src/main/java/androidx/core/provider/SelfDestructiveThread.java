/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Message
 */
package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private Handler.Callback mCallback;
    private final int mDestructAfterMillisec;
    private int mGeneration;
    private Handler mHandler;
    private final Object mLock = new Object();
    private final int mPriority;
    private HandlerThread mThread;
    private final String mThreadName;

    public SelfDestructiveThread(String string2, int n, int n2) {
        this.mCallback = new Handler.Callback(this){
            final SelfDestructiveThread this$0;
            {
                this.this$0 = selfDestructiveThread;
            }

            public boolean handleMessage(Message message) {
                switch (message.what) {
                    default: {
                        return true;
                    }
                    case 1: {
                        this.this$0.onInvokeRunnable((Runnable)message.obj);
                        return true;
                    }
                    case 0: 
                }
                this.this$0.onDestruction();
                return true;
            }
        };
        this.mThreadName = string2;
        this.mPriority = n;
        this.mDestructAfterMillisec = n2;
        this.mGeneration = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void post(Runnable runnable2) {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mThread == null) {
                HandlerThread handlerThread;
                this.mThread = handlerThread = new HandlerThread(this.mThreadName, this.mPriority);
                this.mThread.start();
                handlerThread = new Handler(this.mThread.getLooper(), this.mCallback);
                this.mHandler = handlerThread;
                ++this.mGeneration;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, (Object)runnable2));
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getGeneration() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mGeneration;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isRunning() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mThread == null) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void onDestruction() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mHandler.hasMessages(1)) {
                return;
            }
            this.mThread.quit();
            this.mThread = null;
            this.mHandler = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void onInvokeRunnable(Runnable runnable2) {
        runnable2.run();
        Object object = this.mLock;
        synchronized (object) {
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), (long)this.mDestructAfterMillisec);
            return;
        }
    }

    public <T> void postAndReply(Callable<T> callable, ReplyCallback<T> replyCallback) {
        this.post(new Runnable(){
            final SelfDestructiveThread this$0;
            final Callable val$callable;
            final Handler val$calleeHandler;
            final ReplyCallback val$reply;
            {
                this.this$0 = selfDestructiveThread;
                this.val$callable = callable;
                this.val$calleeHandler = handler;
                this.val$reply = replyCallback;
            }

            @Override
            public void run() {
                Object v;
                try {
                    v = this.val$callable.call();
                }
                catch (Exception exception) {
                    v = null;
                }
                this.val$calleeHandler.post(new Runnable(){
                    final 2 this$1;
                    final Object val$result;
                    {
                        this.this$1 = var1_1;
                        this.val$result = object;
                    }

                    @Override
                    public void run() {
                        this.this$1.val$reply.onReply(this.val$result);
                    }
                });
            }
        });
    }

    /*
     * Unable to fully structure code
     */
    public <T> T postAndWait(Callable<T> var1_1, int var2_4) throws InterruptedException {
        block8: {
            var7_5 = new ReentrantLock();
            var9_6 = var7_5.newCondition();
            var8_7 = new AtomicReference<V>();
            var10_8 = new AtomicBoolean(true);
            this.post(new Runnable(){
                final SelfDestructiveThread this$0;
                final Callable val$callable;
                final Condition val$cond;
                final AtomicReference val$holder;
                final ReentrantLock val$lock;
                final AtomicBoolean val$running;
                {
                    this.this$0 = selfDestructiveThread;
                    this.val$holder = atomicReference;
                    this.val$callable = callable;
                    this.val$lock = reentrantLock;
                    this.val$running = atomicBoolean;
                    this.val$cond = condition;
                }

                @Override
                public void run() {
                    try {
                        this.val$holder.set(this.val$callable.call());
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    this.val$lock.lock();
                    try {
                        this.val$running.set(false);
                        this.val$cond.signal();
                        return;
                    }
                    finally {
                        this.val$lock.unlock();
                    }
                }
            });
            var7_5.lock();
            if (var10_8.get()) break block8;
            var1_1 = var8_7.get();
            var7_5.unlock();
            return (T)var1_1;
        }
        try {
            var3_9 = TimeUnit.MILLISECONDS.toNanos(var2_4);
            while (true) lbl-1000:
            // 2 sources

            {
                try {
                    var3_9 = var5_10 = var9_6.awaitNanos(var3_9);
                }
                catch (InterruptedException var1_2) {
                    // empty catch block
                }
                break;
            }
        }
        catch (Throwable var1_3) {
            var7_5.unlock();
            throw var1_3;
        }
        {
            if (var10_8.get()) continue;
            var1_1 = var8_7.get();
            var7_5.unlock();
            return (T)var1_1;
            ** while (var3_9 > 0L)
        }
lbl31:
        // 2 sources

        var1_1 = new InterruptedException("timeout");
        throw var1_1;
    }

    public static interface ReplyCallback<T> {
        public void onReply(T var1);
    }
}

