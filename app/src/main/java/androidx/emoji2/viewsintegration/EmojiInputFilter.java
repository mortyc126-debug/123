/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.InputFilter
 *  android.text.Selection
 *  android.text.Spannable
 *  android.text.Spanned
 *  android.widget.TextView
 */
package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class EmojiInputFilter
implements InputFilter {
    private EmojiCompat.InitCallback mInitCallback;
    private final TextView mTextView;

    EmojiInputFilter(TextView textView) {
        this.mTextView = textView;
    }

    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(this.mTextView, this);
        }
        return this.mInitCallback;
    }

    static void updateSelection(Spannable spannable, int n, int n2) {
        if (n >= 0 && n2 >= 0) {
            Selection.setSelection((Spannable)spannable, (int)n, (int)n2);
        } else if (n >= 0) {
            Selection.setSelection((Spannable)spannable, (int)n);
        } else if (n2 >= 0) {
            Selection.setSelection((Spannable)spannable, (int)n2);
        }
    }

    public CharSequence filter(CharSequence charSequence, int n, int n2, Spanned spanned, int n3, int n4) {
        if (this.mTextView.isInEditMode()) {
            return charSequence;
        }
        switch (EmojiCompat.get().getLoadState()) {
            default: {
                return charSequence;
            }
            case 1: {
                boolean bl;
                boolean bl2 = bl = true;
                if (n4 == 0) {
                    bl2 = bl;
                    if (n3 == 0) {
                        bl2 = bl;
                        if (spanned.length() == 0) {
                            bl2 = bl;
                            if (charSequence == this.mTextView.getText()) {
                                bl2 = false;
                            }
                        }
                    }
                }
                if (bl2 && charSequence != null) {
                    if (n != 0 || n2 != charSequence.length()) {
                        charSequence = charSequence.subSequence(n, n2);
                    }
                    return EmojiCompat.get().process(charSequence, 0, charSequence.length());
                }
                return charSequence;
            }
            case 0: 
            case 3: 
        }
        EmojiCompat.get().registerInitCallback(this.getInitCallback());
        return charSequence;
    }

    private static class InitCallbackImpl
    extends EmojiCompat.InitCallback {
        private final Reference<EmojiInputFilter> mEmojiInputFilterReference;
        private final Reference<TextView> mViewRef;

        InitCallbackImpl(TextView textView, EmojiInputFilter emojiInputFilter) {
            this.mViewRef = new WeakReference<TextView>(textView);
            this.mEmojiInputFilterReference = new WeakReference<EmojiInputFilter>(emojiInputFilter);
        }

        private boolean isInputFilterCurrentlyRegisteredOnTextView(TextView inputFilterArray, InputFilter inputFilter) {
            if (inputFilter != null && inputFilterArray != null) {
                if ((inputFilterArray = inputFilterArray.getFilters()) == null) {
                    return false;
                }
                for (int i = 0; i < inputFilterArray.length; ++i) {
                    if (inputFilterArray[i] != inputFilter) continue;
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override
        public void onInitialized() {
            super.onInitialized();
            TextView textView = this.mViewRef.get();
            if (!this.isInputFilterCurrentlyRegisteredOnTextView(textView, this.mEmojiInputFilterReference.get())) {
                return;
            }
            if (textView.isAttachedToWindow()) {
                CharSequence charSequence;
                CharSequence charSequence2 = textView.getText();
                if (charSequence2 == (charSequence = EmojiCompat.get().process(charSequence2))) {
                    return;
                }
                int n = Selection.getSelectionStart((CharSequence)charSequence);
                int n2 = Selection.getSelectionEnd((CharSequence)charSequence);
                textView.setText(charSequence);
                if (charSequence instanceof Spannable) {
                    EmojiInputFilter.updateSelection((Spannable)charSequence, n, n2);
                }
            }
        }
    }
}

