/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextWatcher
 *  android.text.method.KeyListener
 *  android.text.method.NumberKeyListener
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.widget.EditText
 *  android.widget.TextView
 */
package androidx.emoji2.viewsintegration;

import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.emoji2.viewsintegration.EmojiEditableFactory;
import androidx.emoji2.viewsintegration.EmojiInputConnection;
import androidx.emoji2.viewsintegration.EmojiKeyListener;
import androidx.emoji2.viewsintegration.EmojiTextWatcher;

public final class EmojiEditTextHelper {
    private int mEmojiReplaceStrategy = 0;
    private final HelperInternal mHelper;
    private int mMaxEmojiCount = Integer.MAX_VALUE;

    public EmojiEditTextHelper(EditText editText) {
        this(editText, true);
    }

    public EmojiEditTextHelper(EditText editText, boolean bl) {
        Preconditions.checkNotNull(editText, "editText cannot be null");
        this.mHelper = new HelperInternal19(editText, bl);
    }

    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    public KeyListener getKeyListener(KeyListener keyListener) {
        return this.mHelper.getKeyListener(keyListener);
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    public InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.mHelper.onCreateInputConnection(inputConnection, editorInfo);
    }

    public void setEmojiReplaceStrategy(int n) {
        this.mEmojiReplaceStrategy = n;
        this.mHelper.setEmojiReplaceStrategy(n);
    }

    public void setEnabled(boolean bl) {
        this.mHelper.setEnabled(bl);
    }

    public void setMaxEmojiCount(int n) {
        Preconditions.checkArgumentNonnegative(n, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = n;
        this.mHelper.setMaxEmojiCount(n);
    }

    static class HelperInternal {
        HelperInternal() {
        }

        KeyListener getKeyListener(KeyListener keyListener) {
            return keyListener;
        }

        boolean isEnabled() {
            return false;
        }

        InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection;
        }

        void setEmojiReplaceStrategy(int n) {
        }

        void setEnabled(boolean bl) {
        }

        void setMaxEmojiCount(int n) {
        }
    }

    private static class HelperInternal19
    extends HelperInternal {
        private final EditText mEditText;
        private final EmojiTextWatcher mTextWatcher;

        HelperInternal19(EditText editText, boolean bl) {
            this.mEditText = editText;
            this.mTextWatcher = new EmojiTextWatcher(this.mEditText, bl);
            this.mEditText.addTextChangedListener((TextWatcher)this.mTextWatcher);
            this.mEditText.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        @Override
        KeyListener getKeyListener(KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return new EmojiKeyListener(keyListener);
        }

        @Override
        boolean isEnabled() {
            return this.mTextWatcher.isEnabled();
        }

        @Override
        InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
            if (inputConnection instanceof EmojiInputConnection) {
                return inputConnection;
            }
            return new EmojiInputConnection((TextView)this.mEditText, inputConnection, editorInfo);
        }

        @Override
        void setEmojiReplaceStrategy(int n) {
            this.mTextWatcher.setEmojiReplaceStrategy(n);
        }

        @Override
        void setEnabled(boolean bl) {
            this.mTextWatcher.setEnabled(bl);
        }

        @Override
        void setMaxEmojiCount(int n) {
            this.mTextWatcher.setMaxEmojiCount(n);
        }
    }
}

