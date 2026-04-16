/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.Editable$Factory
 */
package androidx.emoji2.viewsintegration;

import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

final class EmojiEditableFactory
extends Editable.Factory {
    private static final Object INSTANCE_LOCK = new Object();
    private static volatile Editable.Factory sInstance;
    private static Class<?> sWatcherClass;

    private EmojiEditableFactory() {
        try {
            sWatcherClass = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, ((Object)((Object)this)).getClass().getClassLoader());
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Editable.Factory getInstance() {
        if (sInstance != null) return sInstance;
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            if (sInstance != null) return sInstance;
            EmojiEditableFactory emojiEditableFactory = new EmojiEditableFactory();
            sInstance = emojiEditableFactory;
            return sInstance;
        }
    }

    public Editable newEditable(CharSequence charSequence) {
        if (sWatcherClass != null) {
            return SpannableBuilder.create(sWatcherClass, charSequence);
        }
        return super.newEditable(charSequence);
    }
}

