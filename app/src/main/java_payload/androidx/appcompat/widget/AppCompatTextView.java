/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.text.InputFilter
 *  android.util.AttributeSet
 *  android.view.ActionMode$Callback
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.textclassifier.TextClassifier
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatEmojiTextHelper;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.appcompat.widget.AppCompatTextClassifierHelper;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.EmojiCompatConfigurationView;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView
extends TextView
implements TintableBackgroundView,
TintableCompoundDrawablesView,
AutoSizeableTextView,
EmojiCompatConfigurationView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private AppCompatEmojiTextHelper mEmojiTextViewHelper;
    private boolean mIsSetTypefaceProcessing = false;
    private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
    private SuperCaller mSuperCaller = null;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int n) {
        super(TintContextWrapper.wrap(context), attributeSet, n);
        ThemeUtils.checkAppCompatTheme((View)this, this.getContext());
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper((View)this);
        this.mBackgroundTintHelper.loadFromAttributes(attributeSet, n);
        this.mTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper.loadFromAttributes(attributeSet, n);
        this.mTextHelper.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
        this.getEmojiTextViewHelper().loadFromAttributes(attributeSet, n);
    }

    private void consumeTextFutureAndSetBlocking() {
        if (this.mPrecomputedTextFuture != null) {
            try {
                Future<PrecomputedTextCompat> future = this.mPrecomputedTextFuture;
                this.mPrecomputedTextFuture = null;
                TextViewCompat.setPrecomputedText(this, future.get());
            }
            catch (ExecutionException executionException) {
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mEmojiTextViewHelper == null) {
            this.mEmojiTextViewHelper = new AppCompatEmojiTextHelper(this);
        }
        return this.mEmojiTextViewHelper;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.applySupportBackgroundTint();
        }
        if (this.mTextHelper != null) {
            this.mTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override
    public int getAutoSizeMaxTextSize() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return this.getSuperCaller().getAutoSizeMaxTextSize();
        }
        if (this.mTextHelper != null) {
            return this.mTextHelper.getAutoSizeMaxTextSize();
        }
        return -1;
    }

    @Override
    public int getAutoSizeMinTextSize() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return this.getSuperCaller().getAutoSizeMinTextSize();
        }
        if (this.mTextHelper != null) {
            return this.mTextHelper.getAutoSizeMinTextSize();
        }
        return -1;
    }

    @Override
    public int getAutoSizeStepGranularity() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return this.getSuperCaller().getAutoSizeStepGranularity();
        }
        if (this.mTextHelper != null) {
            return this.mTextHelper.getAutoSizeStepGranularity();
        }
        return -1;
    }

    @Override
    public int[] getAutoSizeTextAvailableSizes() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return this.getSuperCaller().getAutoSizeTextAvailableSizes();
        }
        if (this.mTextHelper != null) {
            return this.mTextHelper.getAutoSizeTextAvailableSizes();
        }
        return new int[0];
    }

    @Override
    public int getAutoSizeTextType() {
        boolean bl = ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE;
        int n = 0;
        if (bl) {
            if (this.getSuperCaller().getAutoSizeTextType() == 1) {
                n = 1;
            }
            return n;
        }
        if (this.mTextHelper != null) {
            return this.mTextHelper.getAutoSizeTextType();
        }
        return 0;
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.getFirstBaselineToTopHeight(this);
    }

    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.getLastBaselineToBottomHeight(this);
    }

    SuperCaller getSuperCaller() {
        if (this.mSuperCaller == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.mSuperCaller = new SuperCallerApi28(this);
            } else if (Build.VERSION.SDK_INT >= 26) {
                this.mSuperCaller = new SuperCallerApi26(this);
            }
        }
        return this.mSuperCaller;
    }

    @Override
    public ColorStateList getSupportBackgroundTintList() {
        ColorStateList colorStateList = this.mBackgroundTintHelper != null ? this.mBackgroundTintHelper.getSupportBackgroundTintList() : null;
        return colorStateList;
    }

    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        PorterDuff.Mode mode = this.mBackgroundTintHelper != null ? this.mBackgroundTintHelper.getSupportBackgroundTintMode() : null;
        return mode;
    }

    @Override
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    @Override
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    public CharSequence getText() {
        this.consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        if (Build.VERSION.SDK_INT < 28 && this.mTextClassifierHelper != null) {
            return this.mTextClassifierHelper.getTextClassifier();
        }
        return this.getSuperCaller().getTextClassifier();
    }

    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return TextViewCompat.getTextMetricsParams(this);
    }

    @Override
    public boolean isEmojiCompatEnabled() {
        return this.getEmojiTextViewHelper().isEnabled();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.populateSurroundingTextIfNeeded(this, inputConnection, editorInfo);
        return AppCompatHintHelper.onCreateInputConnection(inputConnection, editorInfo, (View)this);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        if (this.mTextHelper != null) {
            this.mTextHelper.onLayout(bl, n, n2, n3, n4);
        }
    }

    protected void onMeasure(int n, int n2) {
        this.consumeTextFutureAndSetBlocking();
        super.onMeasure(n, n2);
    }

    protected void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
        super.onTextChanged(charSequence, n, n2, n3);
        n = this.mTextHelper != null && !ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && this.mTextHelper.isAutoSizeEnabled() ? 1 : 0;
        if (n != 0) {
            this.mTextHelper.autoSizeText();
        }
    }

    public void setAllCaps(boolean bl) {
        super.setAllCaps(bl);
        this.getEmojiTextViewHelper().setAllCaps(bl);
    }

    @Override
    public void setAutoSizeTextTypeUniformWithConfiguration(int n, int n2, int n3, int n4) throws IllegalArgumentException {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            this.getSuperCaller().setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        } else if (this.mTextHelper != null) {
            this.mTextHelper.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        }
    }

    @Override
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] nArray, int n) throws IllegalArgumentException {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            this.getSuperCaller().setAutoSizeTextTypeUniformWithPresetSizes(nArray, n);
        } else if (this.mTextHelper != null) {
            this.mTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n);
        }
    }

    @Override
    public void setAutoSizeTextTypeWithDefaults(int n) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            this.getSuperCaller().setAutoSizeTextTypeWithDefaults(n);
        } else if (this.mTextHelper != null) {
            this.mTextHelper.setAutoSizeTextTypeWithDefaults(n);
        }
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        super.setBackgroundDrawable(drawable2);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.onSetBackgroundDrawable(drawable2);
        }
    }

    public void setBackgroundResource(int n) {
        super.setBackgroundResource(n);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.onSetBackgroundResource(n);
        }
    }

    public void setCompoundDrawables(Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        super.setCompoundDrawables(drawable2, drawable3, drawable4, drawable5);
        if (this.mTextHelper != null) {
            this.mTextHelper.onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        super.setCompoundDrawablesRelative(drawable2, drawable3, drawable4, drawable5);
        if (this.mTextHelper != null) {
            this.mTextHelper.onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int n, int n2, int n3, int n4) {
        Context context = this.getContext();
        Drawable drawable2 = null;
        Drawable drawable3 = n != 0 ? AppCompatResources.getDrawable(context, n) : null;
        Drawable drawable4 = n2 != 0 ? AppCompatResources.getDrawable(context, n2) : null;
        Drawable drawable5 = n3 != 0 ? AppCompatResources.getDrawable(context, n3) : null;
        if (n4 != 0) {
            drawable2 = AppCompatResources.getDrawable(context, n4);
        }
        this.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable3, drawable4, drawable5, drawable2);
        if (this.mTextHelper != null) {
            this.mTextHelper.onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
        if (this.mTextHelper != null) {
            this.mTextHelper.onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int n, int n2, int n3, int n4) {
        Context context = this.getContext();
        Drawable drawable2 = null;
        Drawable drawable3 = n != 0 ? AppCompatResources.getDrawable(context, n) : null;
        Drawable drawable4 = n2 != 0 ? AppCompatResources.getDrawable(context, n2) : null;
        Drawable drawable5 = n3 != 0 ? AppCompatResources.getDrawable(context, n3) : null;
        if (n4 != 0) {
            drawable2 = AppCompatResources.getDrawable(context, n4);
        }
        this.setCompoundDrawablesWithIntrinsicBounds(drawable3, drawable4, drawable5, drawable2);
        if (this.mTextHelper != null) {
            this.mTextHelper.onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
        if (this.mTextHelper != null) {
            this.mTextHelper.onSetCompoundDrawables();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback2) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback2));
    }

    @Override
    public void setEmojiCompatEnabled(boolean bl) {
        this.getEmojiTextViewHelper().setEnabled(bl);
    }

    public void setFilters(InputFilter[] inputFilterArray) {
        super.setFilters(this.getEmojiTextViewHelper().getFilters(inputFilterArray));
    }

    public void setFirstBaselineToTopHeight(int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.getSuperCaller().setFirstBaselineToTopHeight(n);
        } else {
            TextViewCompat.setFirstBaselineToTopHeight(this, n);
        }
    }

    public void setLastBaselineToBottomHeight(int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.getSuperCaller().setLastBaselineToBottomHeight(n);
        } else {
            TextViewCompat.setLastBaselineToBottomHeight(this, n);
        }
    }

    public void setLineHeight(int n) {
        TextViewCompat.setLineHeight(this, n);
    }

    public void setPrecomputedText(PrecomputedTextCompat precomputedTextCompat) {
        TextViewCompat.setPrecomputedText(this, precomputedTextCompat);
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.setSupportBackgroundTintMode(mode);
        }
    }

    @Override
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.setCompoundDrawableTintList(colorStateList);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.setCompoundDrawableTintMode(mode);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    public void setTextAppearance(Context context, int n) {
        super.setTextAppearance(context, n);
        if (this.mTextHelper != null) {
            this.mTextHelper.onSetTextAppearance(context, n);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        if (Build.VERSION.SDK_INT < 28 && this.mTextClassifierHelper != null) {
            this.mTextClassifierHelper.setTextClassifier(textClassifier);
            return;
        }
        this.getSuperCaller().setTextClassifier(textClassifier);
    }

    public void setTextFuture(Future<PrecomputedTextCompat> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            this.requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(PrecomputedTextCompat.Params params) {
        TextViewCompat.setTextMetricsParams(this, params);
    }

    public void setTextSize(int n, float f) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            super.setTextSize(n, f);
        } else if (this.mTextHelper != null) {
            this.mTextHelper.setTextSize(n, f);
        }
    }

    public void setTypeface(Typeface typeface, int n) {
        Typeface typeface2;
        if (this.mIsSetTypefaceProcessing) {
            return;
        }
        Typeface typeface3 = typeface2 = null;
        if (typeface != null) {
            typeface3 = typeface2;
            if (n > 0) {
                typeface3 = TypefaceCompat.create(this.getContext(), typeface, n);
            }
        }
        this.mIsSetTypefaceProcessing = true;
        if (typeface3 != null) {
            typeface = typeface3;
        }
        try {
            super.setTypeface(typeface, n);
            return;
        }
        finally {
            this.mIsSetTypefaceProcessing = false;
        }
    }

    private static interface SuperCaller {
        public int getAutoSizeMaxTextSize();

        public int getAutoSizeMinTextSize();

        public int getAutoSizeStepGranularity();

        public int[] getAutoSizeTextAvailableSizes();

        public int getAutoSizeTextType();

        public TextClassifier getTextClassifier();

        public void setAutoSizeTextTypeUniformWithConfiguration(int var1, int var2, int var3, int var4);

        public void setAutoSizeTextTypeUniformWithPresetSizes(int[] var1, int var2);

        public void setAutoSizeTextTypeWithDefaults(int var1);

        public void setFirstBaselineToTopHeight(int var1);

        public void setLastBaselineToBottomHeight(int var1);

        public void setTextClassifier(TextClassifier var1);
    }

    class SuperCallerApi26
    implements SuperCaller {
        final AppCompatTextView this$0;

        SuperCallerApi26(AppCompatTextView appCompatTextView) {
            this.this$0 = appCompatTextView;
        }

        @Override
        public int getAutoSizeMaxTextSize() {
            return AppCompatTextView.super.getAutoSizeMaxTextSize();
        }

        @Override
        public int getAutoSizeMinTextSize() {
            return AppCompatTextView.super.getAutoSizeMinTextSize();
        }

        @Override
        public int getAutoSizeStepGranularity() {
            return AppCompatTextView.super.getAutoSizeStepGranularity();
        }

        @Override
        public int[] getAutoSizeTextAvailableSizes() {
            return AppCompatTextView.super.getAutoSizeTextAvailableSizes();
        }

        @Override
        public int getAutoSizeTextType() {
            return AppCompatTextView.super.getAutoSizeTextType();
        }

        @Override
        public TextClassifier getTextClassifier() {
            return AppCompatTextView.super.getTextClassifier();
        }

        @Override
        public void setAutoSizeTextTypeUniformWithConfiguration(int n, int n2, int n3, int n4) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        }

        @Override
        public void setAutoSizeTextTypeUniformWithPresetSizes(int[] nArray, int n) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n);
        }

        @Override
        public void setAutoSizeTextTypeWithDefaults(int n) {
            AppCompatTextView.super.setAutoSizeTextTypeWithDefaults(n);
        }

        @Override
        public void setFirstBaselineToTopHeight(int n) {
        }

        @Override
        public void setLastBaselineToBottomHeight(int n) {
        }

        @Override
        public void setTextClassifier(TextClassifier textClassifier) {
            AppCompatTextView.super.setTextClassifier(textClassifier);
        }
    }

    class SuperCallerApi28
    extends SuperCallerApi26 {
        final AppCompatTextView this$0;

        SuperCallerApi28(AppCompatTextView appCompatTextView) {
            this.this$0 = appCompatTextView;
            super(appCompatTextView);
        }

        @Override
        public void setFirstBaselineToTopHeight(int n) {
            AppCompatTextView.super.setFirstBaselineToTopHeight(n);
        }

        @Override
        public void setLastBaselineToBottomHeight(int n) {
            AppCompatTextView.super.setLastBaselineToBottomHeight(n);
        }
    }
}

