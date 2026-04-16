/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 */
package androidx.dynamicanimation.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

class AnimationHandler {
    private static final long FRAME_DELAY_MS = 10L;
    public static final ThreadLocal<AnimationHandler> sAnimatorHandler = new ThreadLocal();
    final ArrayList<AnimationFrameCallback> mAnimationCallbacks;
    private final AnimationCallbackDispatcher mCallbackDispatcher;
    long mCurrentFrameTime = 0L;
    private final SimpleArrayMap<AnimationFrameCallback, Long> mDelayedCallbackStartTime = new SimpleArrayMap();
    private boolean mListDirty = false;
    private AnimationFrameCallbackProvider mProvider;

    AnimationHandler() {
        this.mAnimationCallbacks = new ArrayList();
        this.mCallbackDispatcher = new AnimationCallbackDispatcher(this);
    }

    private void cleanUpList() {
        if (this.mListDirty) {
            for (int i = this.mAnimationCallbacks.size() - 1; i >= 0; --i) {
                if (this.mAnimationCallbacks.get(i) != null) continue;
                this.mAnimationCallbacks.remove(i);
            }
            this.mListDirty = false;
        }
    }

    public static long getFrameTime() {
        if (sAnimatorHandler.get() == null) {
            return 0L;
        }
        return AnimationHandler.sAnimatorHandler.get().mCurrentFrameTime;
    }

    public static AnimationHandler getInstance() {
        if (sAnimatorHandler.get() == null) {
            sAnimatorHandler.set(new AnimationHandler());
        }
        return sAnimatorHandler.get();
    }

    private boolean isCallbackDue(AnimationFrameCallback animationFrameCallback, long l) {
        Long l2 = this.mDelayedCallbackStartTime.get(animationFrameCallback);
        if (l2 == null) {
            return true;
        }
        if (l2 < l) {
            this.mDelayedCallbackStartTime.remove(animationFrameCallback);
            return true;
        }
        return false;
    }

    public void addAnimationFrameCallback(AnimationFrameCallback animationFrameCallback, long l) {
        if (this.mAnimationCallbacks.size() == 0) {
            this.getProvider().postFrameCallback();
        }
        if (!this.mAnimationCallbacks.contains(animationFrameCallback)) {
            this.mAnimationCallbacks.add(animationFrameCallback);
        }
        if (l > 0L) {
            this.mDelayedCallbackStartTime.put(animationFrameCallback, SystemClock.uptimeMillis() + l);
        }
    }

    void doAnimationFrame(long l) {
        long l2 = SystemClock.uptimeMillis();
        for (int i = 0; i < this.mAnimationCallbacks.size(); ++i) {
            AnimationFrameCallback animationFrameCallback = this.mAnimationCallbacks.get(i);
            if (animationFrameCallback == null || !this.isCallbackDue(animationFrameCallback, l2)) continue;
            animationFrameCallback.doAnimationFrame(l);
        }
        this.cleanUpList();
    }

    AnimationFrameCallbackProvider getProvider() {
        if (this.mProvider == null) {
            this.mProvider = new FrameCallbackProvider16(this.mCallbackDispatcher);
        }
        return this.mProvider;
    }

    public void removeCallback(AnimationFrameCallback animationFrameCallback) {
        this.mDelayedCallbackStartTime.remove(animationFrameCallback);
        int n = this.mAnimationCallbacks.indexOf(animationFrameCallback);
        if (n >= 0) {
            this.mAnimationCallbacks.set(n, null);
            this.mListDirty = true;
        }
    }

    public void setProvider(AnimationFrameCallbackProvider animationFrameCallbackProvider) {
        this.mProvider = animationFrameCallbackProvider;
    }

    class AnimationCallbackDispatcher {
        final AnimationHandler this$0;

        AnimationCallbackDispatcher(AnimationHandler animationHandler) {
            this.this$0 = animationHandler;
        }

        void dispatchAnimationFrame() {
            this.this$0.mCurrentFrameTime = SystemClock.uptimeMillis();
            this.this$0.doAnimationFrame(this.this$0.mCurrentFrameTime);
            if (this.this$0.mAnimationCallbacks.size() > 0) {
                this.this$0.getProvider().postFrameCallback();
            }
        }
    }

    static interface AnimationFrameCallback {
        public boolean doAnimationFrame(long var1);
    }

    static abstract class AnimationFrameCallbackProvider {
        final AnimationCallbackDispatcher mDispatcher;

        AnimationFrameCallbackProvider(AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.mDispatcher = animationCallbackDispatcher;
        }

        abstract void postFrameCallback();
    }

    private static class FrameCallbackProvider14
    extends AnimationFrameCallbackProvider {
        private final Handler mHandler;
        long mLastFrameTime = -1L;
        private final Runnable mRunnable = new Runnable(this){
            final FrameCallbackProvider14 this$0;
            {
                this.this$0 = frameCallbackProvider14;
            }

            @Override
            public void run() {
                this.this$0.mLastFrameTime = SystemClock.uptimeMillis();
                this.this$0.mDispatcher.dispatchAnimationFrame();
            }
        };

        FrameCallbackProvider14(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override
        void postFrameCallback() {
            long l = Math.max(10L - (SystemClock.uptimeMillis() - this.mLastFrameTime), 0L);
            this.mHandler.postDelayed(this.mRunnable, l);
        }
    }

    private static class FrameCallbackProvider16
    extends AnimationFrameCallbackProvider {
        private final Choreographer mChoreographer = Choreographer.getInstance();
        private final Choreographer.FrameCallback mChoreographerCallback = new Choreographer.FrameCallback(this){
            final FrameCallbackProvider16 this$0;
            {
                this.this$0 = frameCallbackProvider16;
            }

            public void doFrame(long l) {
                this.this$0.mDispatcher.dispatchAnimationFrame();
            }
        };

        FrameCallbackProvider16(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
        }

        @Override
        void postFrameCallback() {
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }
}

