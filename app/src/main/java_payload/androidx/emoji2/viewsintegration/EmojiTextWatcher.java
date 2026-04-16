/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.Selection
 *  android.text.Spannable
 *  android.text.TextWatcher
 *  android.widget.EditText
 */
package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.viewsintegration.EmojiInputFilter;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class EmojiTextWatcher
implements TextWatcher {
    private final EditText mEditText;
    private int mEmojiReplaceStrategy = 0;
    private boolean mEnabled;
    private final boolean mExpectInitializedEmojiCompat;
    private EmojiCompat.InitCallback mInitCallback;
    private int mMaxEmojiCount = Integer.MAX_VALUE;

    EmojiTextWatcher(EditText editText, boolean bl) {
        this.mEditText = editText;
        this.mExpectInitializedEmojiCompat = bl;
        this.mEnabled = true;
    }

    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(this.mEditText);
        }
        return this.mInitCallback;
    }

    static void processTextOnEnablingEvent(EditText editText, int n) {
        if (n == 1 && editText != null && editText.isAttachedToWindow()) {
            editText = editText.getEditableText();
            n = Selection.getSelectionStart((CharSequence)editText);
            int n2 = Selection.getSelectionEnd((CharSequence)editText);
            EmojiCompat.get().process((CharSequence)editText);
            EmojiInputFilter.updateSelection((Spannable)editText, n, n2);
        }
    }

    private boolean shouldSkipForDisabledOrNotConfigured() {
        boolean bl = !this.mEnabled || !this.mExpectInitializedEmojiCompat && !EmojiCompat.isConfigured();
        return bl;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
    }

    int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
        if (!this.mEditText.isInEditMode() && !this.shouldSkipForDisabledOrNotConfigured()) {
            if (n2 <= n3 && charSequence instanceof Spannable) {
                switch (EmojiCompat.get().getLoadState()) {
                    default: {
                        break;
                    }
                    case 1: {
                        charSequence = (Spannable)charSequence;
                        EmojiCompat.get().process(charSequence, n, n + n3, this.mMaxEmojiCount, this.mEmojiReplaceStrategy);
                        break;
                    }
                    case 0: 
                    case 3: {
                        EmojiCompat.get().registerInitCallback(this.getInitCallback());
                    }
                }
            }
            return;
        }
    }

    void setEmojiReplaceStrategy(int n) {
        this.mEmojiReplaceStrategy = n;
    }

    public void setEnabled(boolean bl) {
        if (this.mEnabled != bl) {
            if (this.mInitCallback != null) {
                EmojiCompat.get().unregisterInitCallback(this.mInitCallback);
            }
            this.mEnabled = bl;
            if (this.mEnabled) {
                EmojiTextWatcher.processTextOnEnablingEvent(this.mEditText, EmojiCompat.get().getLoadState());
            }
        }
    }

    void setMaxEmojiCount(int n) {
        this.mMaxEmojiCount = n;
    }

    private static class InitCallbackImpl
    extends EmojiCompat.InitCallback {
        private final Reference<EditText> mViewRef;

        InitCallbackImpl(EditText editText) {
            this.mViewRef = new WeakReference<EditText>(editText);
        }

        @Override
        public void onInitialized() {
            super.onInitialized();
            EmojiTextWatcher.processTextOnEnablingEvent(this.mViewRef.get(), 1);
        }
    }
}

