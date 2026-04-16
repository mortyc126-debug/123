/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.method.KeyListener
 *  android.text.method.NumberKeyListener
 *  android.util.AttributeSet
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.widget.EditText
 */
package androidx.appcompat.widget;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

class AppCompatEmojiEditTextHelper {
    private final EmojiEditTextHelper mEmojiEditTextHelper;
    private final EditText mView;

    AppCompatEmojiEditTextHelper(EditText editText) {
        this.mView = editText;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(editText, false);
    }

    KeyListener getKeyListener(KeyListener keyListener) {
        if (this.isEmojiCapableKeyListener(keyListener)) {
            return this.mEmojiEditTextHelper.getKeyListener(keyListener);
        }
        return keyListener;
    }

    boolean isEmojiCapableKeyListener(KeyListener keyListener) {
        return keyListener instanceof NumberKeyListener ^ true;
    }

    boolean isEnabled() {
        return this.mEmojiEditTextHelper.isEnabled();
    }

    void loadFromAttributes(AttributeSet attributeSet, int n) {
        attributeSet = this.mView.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, n, 0);
        boolean bl = true;
        try {
            if (attributeSet.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled)) {
                bl = attributeSet.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true);
            }
            this.setEnabled(bl);
            return;
        }
        finally {
            attributeSet.recycle();
        }
    }

    InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.mEmojiEditTextHelper.onCreateInputConnection(inputConnection, editorInfo);
    }

    void setEnabled(boolean bl) {
        this.mEmojiEditTextHelper.setEnabled(bl);
    }
}

