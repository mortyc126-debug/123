/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.TypedArray
 *  android.text.InputFilter
 *  android.text.method.TransformationMethod
 *  android.util.AttributeSet
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

class AppCompatEmojiTextHelper {
    private final EmojiTextViewHelper mEmojiTextViewHelper;
    private final TextView mView;

    AppCompatEmojiTextHelper(TextView textView) {
        this.mView = textView;
        this.mEmojiTextViewHelper = new EmojiTextViewHelper(textView, false);
    }

    InputFilter[] getFilters(InputFilter[] inputFilterArray) {
        return this.mEmojiTextViewHelper.getFilters(inputFilterArray);
    }

    public boolean isEnabled() {
        return this.mEmojiTextViewHelper.isEnabled();
    }

    void loadFromAttributes(AttributeSet attributeSet, int n) {
        TypedArray typedArray = this.mView.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, n, 0);
        boolean bl = true;
        try {
            if (typedArray.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled)) {
                bl = typedArray.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true);
            }
            this.setEnabled(bl);
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    void setAllCaps(boolean bl) {
        this.mEmojiTextViewHelper.setAllCaps(bl);
    }

    void setEnabled(boolean bl) {
        this.mEmojiTextViewHelper.setEnabled(bl);
    }

    public TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
        return this.mEmojiTextViewHelper.wrapTransformationMethod(transformationMethod);
    }
}

