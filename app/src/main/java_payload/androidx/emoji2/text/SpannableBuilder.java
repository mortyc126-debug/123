/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.Editable
 *  android.text.SpanWatcher
 *  android.text.Spannable
 *  android.text.SpannableStringBuilder
 *  android.text.TextWatcher
 */
package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiSpan;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class SpannableBuilder
extends SpannableStringBuilder {
    private final Class<?> mWatcherClass;
    private final List<WatcherWrapper> mWatchers = new ArrayList<WatcherWrapper>();

    SpannableBuilder(Class<?> clazz) {
        Preconditions.checkNotNull(clazz, "watcherClass cannot be null");
        this.mWatcherClass = clazz;
    }

    SpannableBuilder(Class<?> clazz, CharSequence charSequence) {
        super(charSequence);
        Preconditions.checkNotNull(clazz, "watcherClass cannot be null");
        this.mWatcherClass = clazz;
    }

    SpannableBuilder(Class<?> clazz, CharSequence charSequence, int n, int n2) {
        super(charSequence, n, n2);
        Preconditions.checkNotNull(clazz, "watcherClass cannot be null");
        this.mWatcherClass = clazz;
    }

    private void blockWatchers() {
        for (int i = 0; i < this.mWatchers.size(); ++i) {
            this.mWatchers.get(i).blockCalls();
        }
    }

    public static SpannableBuilder create(Class<?> clazz, CharSequence charSequence) {
        return new SpannableBuilder(clazz, charSequence);
    }

    private void fireWatchers() {
        for (int i = 0; i < this.mWatchers.size(); ++i) {
            this.mWatchers.get(i).onTextChanged((CharSequence)((Object)this), 0, this.length(), this.length());
        }
    }

    private WatcherWrapper getWatcherFor(Object object) {
        for (int i = 0; i < this.mWatchers.size(); ++i) {
            WatcherWrapper watcherWrapper = this.mWatchers.get(i);
            if (watcherWrapper.mObject != object) continue;
            return watcherWrapper;
        }
        return null;
    }

    private boolean isWatcher(Class<?> clazz) {
        boolean bl = this.mWatcherClass == clazz;
        return bl;
    }

    private boolean isWatcher(Object object) {
        boolean bl = object != null && this.isWatcher(object.getClass());
        return bl;
    }

    private void unblockwatchers() {
        for (int i = 0; i < this.mWatchers.size(); ++i) {
            this.mWatchers.get(i).unblockCalls();
        }
    }

    public SpannableStringBuilder append(char c) {
        super.append(c);
        return this;
    }

    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public SpannableStringBuilder append(CharSequence charSequence, int n, int n2) {
        super.append(charSequence, n, n2);
        return this;
    }

    public SpannableStringBuilder append(CharSequence charSequence, Object object, int n) {
        super.append(charSequence, object, n);
        return this;
    }

    public void beginBatchEdit() {
        this.blockWatchers();
    }

    public SpannableStringBuilder delete(int n, int n2) {
        super.delete(n, n2);
        return this;
    }

    public void endBatchEdit() {
        this.unblockwatchers();
        this.fireWatchers();
    }

    public int getSpanEnd(Object object) {
        Object object2 = object;
        if (this.isWatcher(object)) {
            WatcherWrapper watcherWrapper = this.getWatcherFor(object);
            object2 = object;
            if (watcherWrapper != null) {
                object2 = watcherWrapper;
            }
        }
        return super.getSpanEnd(object2);
    }

    public int getSpanFlags(Object object) {
        Object object2 = object;
        if (this.isWatcher(object)) {
            WatcherWrapper watcherWrapper = this.getWatcherFor(object);
            object2 = object;
            if (watcherWrapper != null) {
                object2 = watcherWrapper;
            }
        }
        return super.getSpanFlags(object2);
    }

    public int getSpanStart(Object object) {
        Object object2 = object;
        if (this.isWatcher(object)) {
            WatcherWrapper watcherWrapper = this.getWatcherFor(object);
            object2 = object;
            if (watcherWrapper != null) {
                object2 = watcherWrapper;
            }
        }
        return super.getSpanStart(object2);
    }

    public <T> T[] getSpans(int n, int n2, Class<T> objectArray) {
        if (this.isWatcher((Class<?>)objectArray)) {
            WatcherWrapper[] watcherWrapperArray = (WatcherWrapper[])super.getSpans(n, n2, WatcherWrapper.class);
            objectArray = (Object[])Array.newInstance(objectArray, watcherWrapperArray.length);
            for (n = 0; n < watcherWrapperArray.length; ++n) {
                objectArray[n] = watcherWrapperArray[n].mObject;
            }
            return objectArray;
        }
        return super.getSpans(n, n2, objectArray);
    }

    public SpannableStringBuilder insert(int n, CharSequence charSequence) {
        super.insert(n, charSequence);
        return this;
    }

    public SpannableStringBuilder insert(int n, CharSequence charSequence, int n2, int n3) {
        super.insert(n, charSequence, n2, n3);
        return this;
    }

    public int nextSpanTransition(int n, int n2, Class clazz) {
        Class<WatcherWrapper> clazz2;
        block3: {
            block2: {
                if (clazz == null) break block2;
                clazz2 = clazz;
                if (!this.isWatcher(clazz)) break block3;
            }
            clazz2 = WatcherWrapper.class;
        }
        return super.nextSpanTransition(n, n2, clazz2);
    }

    public void removeSpan(Object object) {
        WatcherWrapper watcherWrapper;
        if (this.isWatcher(object)) {
            WatcherWrapper watcherWrapper2;
            watcherWrapper = watcherWrapper2 = this.getWatcherFor(object);
            if (watcherWrapper2 != null) {
                object = watcherWrapper2;
                watcherWrapper = watcherWrapper2;
            }
        } else {
            watcherWrapper = null;
        }
        super.removeSpan(object);
        if (watcherWrapper != null) {
            this.mWatchers.remove(watcherWrapper);
        }
    }

    public SpannableStringBuilder replace(int n, int n2, CharSequence charSequence) {
        this.blockWatchers();
        super.replace(n, n2, charSequence);
        this.unblockwatchers();
        return this;
    }

    public SpannableStringBuilder replace(int n, int n2, CharSequence charSequence, int n3, int n4) {
        this.blockWatchers();
        super.replace(n, n2, charSequence, n3, n4);
        this.unblockwatchers();
        return this;
    }

    public void setSpan(Object object, int n, int n2, int n3) {
        Object object2 = object;
        if (this.isWatcher(object)) {
            object2 = new WatcherWrapper(object);
            this.mWatchers.add((WatcherWrapper)object2);
        }
        super.setSpan(object2, n, n2, n3);
    }

    public CharSequence subSequence(int n, int n2) {
        return new SpannableBuilder(this.mWatcherClass, (CharSequence)((Object)this), n, n2);
    }

    private static class WatcherWrapper
    implements TextWatcher,
    SpanWatcher {
        private final AtomicInteger mBlockCalls = new AtomicInteger(0);
        final Object mObject;

        WatcherWrapper(Object object) {
            this.mObject = object;
        }

        private boolean isEmojiSpan(Object object) {
            return object instanceof EmojiSpan;
        }

        public void afterTextChanged(Editable editable) {
            ((TextWatcher)this.mObject).afterTextChanged(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            ((TextWatcher)this.mObject).beforeTextChanged(charSequence, n, n2, n3);
        }

        final void blockCalls() {
            this.mBlockCalls.incrementAndGet();
        }

        public void onSpanAdded(Spannable spannable, Object object, int n, int n2) {
            if (this.mBlockCalls.get() > 0 && this.isEmojiSpan(object)) {
                return;
            }
            ((SpanWatcher)this.mObject).onSpanAdded(spannable, object, n, n2);
        }

        public void onSpanChanged(Spannable spannable, Object object, int n, int n2, int n3, int n4) {
            if (this.mBlockCalls.get() > 0 && this.isEmojiSpan(object)) {
                return;
            }
            int n5 = n;
            int n6 = n3;
            if (Build.VERSION.SDK_INT < 28) {
                int n7 = n;
                if (n > n2) {
                    n7 = 0;
                }
                n5 = n7;
                n6 = n3;
                if (n3 > n4) {
                    n6 = 0;
                    n5 = n7;
                }
            }
            ((SpanWatcher)this.mObject).onSpanChanged(spannable, object, n5, n2, n6, n4);
        }

        public void onSpanRemoved(Spannable spannable, Object object, int n, int n2) {
            if (this.mBlockCalls.get() > 0 && this.isEmojiSpan(object)) {
                return;
            }
            ((SpanWatcher)this.mObject).onSpanRemoved(spannable, object, n, n2);
        }

        public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            ((TextWatcher)this.mObject).onTextChanged(charSequence, n, n2, n3);
        }

        final void unblockCalls() {
            this.mBlockCalls.decrementAndGet();
        }
    }
}

