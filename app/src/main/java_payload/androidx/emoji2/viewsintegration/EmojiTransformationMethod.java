/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.text.method.TransformationMethod
 *  android.view.View
 */
package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

class EmojiTransformationMethod
implements TransformationMethod {
    private final TransformationMethod mTransformationMethod;

    EmojiTransformationMethod(TransformationMethod transformationMethod) {
        this.mTransformationMethod = transformationMethod;
    }

    public TransformationMethod getOriginalTransformationMethod() {
        return this.mTransformationMethod;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        CharSequence charSequence2 = charSequence;
        if (this.mTransformationMethod != null) {
            charSequence2 = this.mTransformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence2 != null) {
            switch (EmojiCompat.get().getLoadState()) {
                default: {
                    break;
                }
                case 1: {
                    return EmojiCompat.get().process(charSequence2);
                }
            }
        }
        return charSequence2;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean bl, int n, Rect rect) {
        if (this.mTransformationMethod != null) {
            this.mTransformationMethod.onFocusChanged(view, charSequence, bl, n, rect);
        }
    }
}

