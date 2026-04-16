/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.method.KeyListener
 *  android.view.KeyEvent
 *  android.view.View
 */
package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

final class EmojiKeyListener
implements KeyListener {
    private final EmojiCompatHandleKeyDownHelper mEmojiCompatHandleKeyDownHelper;
    private final KeyListener mKeyListener;

    EmojiKeyListener(KeyListener keyListener) {
        this(keyListener, new EmojiCompatHandleKeyDownHelper());
    }

    EmojiKeyListener(KeyListener keyListener, EmojiCompatHandleKeyDownHelper emojiCompatHandleKeyDownHelper) {
        this.mKeyListener = keyListener;
        this.mEmojiCompatHandleKeyDownHelper = emojiCompatHandleKeyDownHelper;
    }

    public void clearMetaKeyState(View view, Editable editable, int n) {
        this.mKeyListener.clearMetaKeyState(view, editable, n);
    }

    public int getInputType() {
        return this.mKeyListener.getInputType();
    }

    public boolean onKeyDown(View view, Editable editable, int n, KeyEvent keyEvent) {
        boolean bl = this.mEmojiCompatHandleKeyDownHelper.handleKeyDown(editable, n, keyEvent) || this.mKeyListener.onKeyDown(view, editable, n, keyEvent);
        return bl;
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.mKeyListener.onKeyOther(view, editable, keyEvent);
    }

    public boolean onKeyUp(View view, Editable editable, int n, KeyEvent keyEvent) {
        return this.mKeyListener.onKeyUp(view, editable, n, keyEvent);
    }

    public static class EmojiCompatHandleKeyDownHelper {
        public boolean handleKeyDown(Editable editable, int n, KeyEvent keyEvent) {
            return EmojiCompat.handleOnKeyDown(editable, n, keyEvent);
        }
    }
}

