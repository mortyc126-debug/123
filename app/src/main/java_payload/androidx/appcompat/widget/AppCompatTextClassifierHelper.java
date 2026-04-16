/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.textclassifier.TextClassificationManager
 *  android.view.textclassifier.TextClassifier
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.Preconditions;

final class AppCompatTextClassifierHelper {
    private TextClassifier mTextClassifier;
    private TextView mTextView;

    AppCompatTextClassifierHelper(TextView textView) {
        this.mTextView = Preconditions.checkNotNull(textView);
    }

    public TextClassifier getTextClassifier() {
        if (this.mTextClassifier == null) {
            return Api26Impl.getTextClassifier(this.mTextView);
        }
        return this.mTextClassifier;
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        this.mTextClassifier = textClassifier;
    }

    private static final class Api26Impl {
        private Api26Impl() {
        }

        static TextClassifier getTextClassifier(TextView textView) {
            if ((textView = (TextClassificationManager)textView.getContext().getSystemService(TextClassificationManager.class)) != null) {
                return textView.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
    }
}

