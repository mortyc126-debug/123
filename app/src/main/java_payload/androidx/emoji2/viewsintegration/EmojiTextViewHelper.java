/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.InputFilter
 *  android.text.method.PasswordTransformationMethod
 *  android.text.method.TransformationMethod
 *  android.util.SparseArray
 *  android.widget.TextView
 */
package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.viewsintegration.EmojiInputFilter;
import androidx.emoji2.viewsintegration.EmojiTransformationMethod;

public final class EmojiTextViewHelper {
    private final HelperInternal mHelper;

    public EmojiTextViewHelper(TextView textView) {
        this(textView, true);
    }

    public EmojiTextViewHelper(TextView textView, boolean bl) {
        Preconditions.checkNotNull(textView, "textView cannot be null");
        this.mHelper = !bl ? new SkippingHelper19(textView) : new HelperInternal19(textView);
    }

    public InputFilter[] getFilters(InputFilter[] inputFilterArray) {
        return this.mHelper.getFilters(inputFilterArray);
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    public void setAllCaps(boolean bl) {
        this.mHelper.setAllCaps(bl);
    }

    public void setEnabled(boolean bl) {
        this.mHelper.setEnabled(bl);
    }

    public void updateTransformationMethod() {
        this.mHelper.updateTransformationMethod();
    }

    public TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
        return this.mHelper.wrapTransformationMethod(transformationMethod);
    }

    static class HelperInternal {
        HelperInternal() {
        }

        InputFilter[] getFilters(InputFilter[] inputFilterArray) {
            return inputFilterArray;
        }

        public boolean isEnabled() {
            return false;
        }

        void setAllCaps(boolean bl) {
        }

        void setEnabled(boolean bl) {
        }

        void updateTransformationMethod() {
        }

        TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
            return transformationMethod;
        }
    }

    private static class HelperInternal19
    extends HelperInternal {
        private final EmojiInputFilter mEmojiInputFilter;
        private boolean mEnabled;
        private final TextView mTextView;

        HelperInternal19(TextView textView) {
            this.mTextView = textView;
            this.mEnabled = true;
            this.mEmojiInputFilter = new EmojiInputFilter(textView);
        }

        private InputFilter[] addEmojiInputFilterIfMissing(InputFilter[] inputFilterArray) {
            int n = inputFilterArray.length;
            for (int i = 0; i < n; ++i) {
                if (inputFilterArray[i] != this.mEmojiInputFilter) continue;
                return inputFilterArray;
            }
            InputFilter[] inputFilterArray2 = new InputFilter[inputFilterArray.length + 1];
            System.arraycopy(inputFilterArray, 0, inputFilterArray2, 0, n);
            inputFilterArray2[n] = this.mEmojiInputFilter;
            return inputFilterArray2;
        }

        private SparseArray<InputFilter> getEmojiInputFilterPositionArray(InputFilter[] inputFilterArray) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArray.length; ++i) {
                if (!(inputFilterArray[i] instanceof EmojiInputFilter)) continue;
                sparseArray.put(i, (Object)inputFilterArray[i]);
            }
            return sparseArray;
        }

        private InputFilter[] removeEmojiInputFilterIfPresent(InputFilter[] inputFilterArray) {
            SparseArray<InputFilter> sparseArray = this.getEmojiInputFilterPositionArray(inputFilterArray);
            if (sparseArray.size() == 0) {
                return inputFilterArray;
            }
            int n = inputFilterArray.length;
            InputFilter[] inputFilterArray2 = new InputFilter[inputFilterArray.length - sparseArray.size()];
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                int n3 = n2;
                if (sparseArray.indexOfKey(i) < 0) {
                    inputFilterArray2[n2] = inputFilterArray[i];
                    n3 = n2 + 1;
                }
                n2 = n3;
            }
            return inputFilterArray2;
        }

        private TransformationMethod unwrapForDisabled(TransformationMethod transformationMethod) {
            if (transformationMethod instanceof EmojiTransformationMethod) {
                return ((EmojiTransformationMethod)transformationMethod).getOriginalTransformationMethod();
            }
            return transformationMethod;
        }

        private void updateFilters() {
            InputFilter[] inputFilterArray = this.mTextView.getFilters();
            this.mTextView.setFilters(this.getFilters(inputFilterArray));
        }

        private TransformationMethod wrapForEnabled(TransformationMethod transformationMethod) {
            if (transformationMethod instanceof EmojiTransformationMethod) {
                return transformationMethod;
            }
            if (transformationMethod instanceof PasswordTransformationMethod) {
                return transformationMethod;
            }
            return new EmojiTransformationMethod(transformationMethod);
        }

        @Override
        InputFilter[] getFilters(InputFilter[] inputFilterArray) {
            if (!this.mEnabled) {
                return this.removeEmojiInputFilterIfPresent(inputFilterArray);
            }
            return this.addEmojiInputFilterIfMissing(inputFilterArray);
        }

        @Override
        public boolean isEnabled() {
            return this.mEnabled;
        }

        @Override
        void setAllCaps(boolean bl) {
            if (bl) {
                this.updateTransformationMethod();
            }
        }

        @Override
        void setEnabled(boolean bl) {
            this.mEnabled = bl;
            this.updateTransformationMethod();
            this.updateFilters();
        }

        void setEnabledUnsafe(boolean bl) {
            this.mEnabled = bl;
        }

        @Override
        void updateTransformationMethod() {
            TransformationMethod transformationMethod = this.wrapTransformationMethod(this.mTextView.getTransformationMethod());
            this.mTextView.setTransformationMethod(transformationMethod);
        }

        @Override
        TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
            if (this.mEnabled) {
                return this.wrapForEnabled(transformationMethod);
            }
            return this.unwrapForDisabled(transformationMethod);
        }
    }

    private static class SkippingHelper19
    extends HelperInternal {
        private final HelperInternal19 mHelperDelegate;

        SkippingHelper19(TextView textView) {
            this.mHelperDelegate = new HelperInternal19(textView);
        }

        private boolean skipBecauseEmojiCompatNotInitialized() {
            return EmojiCompat.isConfigured() ^ true;
        }

        @Override
        InputFilter[] getFilters(InputFilter[] inputFilterArray) {
            if (this.skipBecauseEmojiCompatNotInitialized()) {
                return inputFilterArray;
            }
            return this.mHelperDelegate.getFilters(inputFilterArray);
        }

        @Override
        public boolean isEnabled() {
            return this.mHelperDelegate.isEnabled();
        }

        @Override
        void setAllCaps(boolean bl) {
            if (this.skipBecauseEmojiCompatNotInitialized()) {
                return;
            }
            this.mHelperDelegate.setAllCaps(bl);
        }

        @Override
        void setEnabled(boolean bl) {
            if (this.skipBecauseEmojiCompatNotInitialized()) {
                this.mHelperDelegate.setEnabledUnsafe(bl);
            } else {
                this.mHelperDelegate.setEnabled(bl);
            }
        }

        @Override
        void updateTransformationMethod() {
            if (this.skipBecauseEmojiCompatNotInitialized()) {
                return;
            }
            this.mHelperDelegate.updateTransformationMethod();
        }

        @Override
        TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
            if (this.skipBecauseEmojiCompatNotInitialized()) {
                return transformationMethod;
            }
            return this.mHelperDelegate.wrapTransformationMethod(transformationMethod);
        }
    }
}

