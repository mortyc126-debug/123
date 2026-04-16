/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.text.method.PasswordTransformationMethod
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mFontWeight = -1;
    private int mStyle = 0;
    private final TextView mView;

    AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
    }

    private void applyCompoundDrawableTint(Drawable drawable2, TintInfo tintInfo) {
        if (drawable2 != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable2, tintInfo, this.mView.getDrawableState());
        }
    }

    private static TintInfo createTintInfo(Context object, AppCompatDrawableManager appCompatDrawableManager, int n) {
        if ((appCompatDrawableManager = appCompatDrawableManager.getTintList((Context)object, n)) != null) {
            object = new TintInfo();
            object.mHasTintList = true;
            object.mTintList = appCompatDrawableManager;
            return object;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void setCompoundDrawables(Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6, Drawable drawable7) {
        if (drawable6 == null && drawable7 == null) {
            if (drawable2 == null && drawable3 == null && drawable4 == null) {
                if (drawable5 == null) return;
            }
            if ((drawable7 = Api17Impl.getCompoundDrawablesRelative(this.mView))[0] == null && drawable7[2] == null) {
                drawable7 = this.mView.getCompoundDrawables();
                drawable6 = this.mView;
                if (drawable2 == null) {
                    drawable2 = drawable7[0];
                }
                if (drawable3 == null) {
                    drawable3 = drawable7[1];
                }
                if (drawable4 == null) {
                    drawable4 = drawable7[2];
                }
                if (drawable5 == null) {
                    drawable5 = drawable7[3];
                }
                drawable6.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
                return;
            }
            drawable4 = this.mView;
            drawable6 = drawable7[0];
            drawable2 = drawable3 != null ? drawable3 : drawable7[1];
            Drawable drawable8 = drawable7[2];
            drawable3 = drawable5 != null ? drawable5 : drawable7[3];
            Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds((TextView)drawable4, drawable6, drawable2, drawable8, drawable3);
            return;
        }
        Drawable[] drawableArray = Api17Impl.getCompoundDrawablesRelative(this.mView);
        TextView textView = this.mView;
        drawable2 = drawable6 != null ? drawable6 : drawableArray[0];
        if (drawable3 == null) {
            drawable3 = drawableArray[1];
        }
        drawable4 = drawable7 != null ? drawable7 : drawableArray[2];
        if (drawable5 == null) {
            drawable5 = drawableArray[3];
        }
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, drawable2, drawable3, drawable4, drawable5);
    }

    private void setCompoundTints() {
        this.mDrawableLeftTint = this.mDrawableTint;
        this.mDrawableTopTint = this.mDrawableTint;
        this.mDrawableRightTint = this.mDrawableTint;
        this.mDrawableBottomTint = this.mDrawableTint;
        this.mDrawableStartTint = this.mDrawableTint;
        this.mDrawableEndTint = this.mDrawableTint;
    }

    private void setTextSizeInternal(int n, float f) {
        this.mAutoSizeTextHelper.setTextSizeInternal(n, f);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void updateTypefaceAndStyle(Context object, TintTypedArray tintTypedArray) {
        boolean bl;
        void var2_11;
        this.mStyle = var2_11.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
        int n = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        if (n >= 28) {
            this.mFontWeight = var2_11.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            if (this.mFontWeight != -1) {
                this.mStyle = this.mStyle & 2 | 0;
            }
        }
        if (!var2_11.hasValue(R.styleable.TextAppearance_android_fontFamily) && !var2_11.hasValue(R.styleable.TextAppearance_fontFamily)) {
            if (!var2_11.hasValue(R.styleable.TextAppearance_android_typeface)) return;
            this.mAsyncFontPending = false;
            switch (var2_11.getInt(R.styleable.TextAppearance_android_typeface, 1)) {
                default: {
                    return;
                }
                case 3: {
                    this.mFontTypeface = Typeface.MONOSPACE;
                    return;
                }
                case 2: {
                    this.mFontTypeface = Typeface.SERIF;
                    return;
                }
                case 1: 
            }
            this.mFontTypeface = Typeface.SANS_SERIF;
            return;
        }
        this.mFontTypeface = null;
        n = var2_11.hasValue(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
        int n2 = this.mFontWeight;
        int n3 = this.mStyle;
        if (!object.isRestricted()) {
            ResourcesCompat.FontCallback fontCallback = new ResourcesCompat.FontCallback(this, n2, n3, new WeakReference<TextView>(this.mView)){
                final AppCompatTextHelper this$0;
                final int val$fontWeight;
                final int val$style;
                final WeakReference val$textViewWeak;
                {
                    this.this$0 = appCompatTextHelper;
                    this.val$fontWeight = n;
                    this.val$style = n2;
                    this.val$textViewWeak = weakReference;
                }

                @Override
                public void onFontRetrievalFailed(int n) {
                }

                @Override
                public void onFontRetrieved(Typeface typeface) {
                    Typeface typeface2 = typeface;
                    if (Build.VERSION.SDK_INT >= 28) {
                        typeface2 = typeface;
                        if (this.val$fontWeight != -1) {
                            int n = this.val$fontWeight;
                            boolean bl = (this.val$style & 2) != 0;
                            typeface2 = Api28Impl.create(typeface, n, bl);
                        }
                    }
                    this.this$0.onAsyncTypefaceReceived(this.val$textViewWeak, typeface2);
                }
            };
            try {
                Typeface typeface = var2_11.getFont(n, this.mStyle, fontCallback);
                if (typeface != null) {
                    if (Build.VERSION.SDK_INT >= 28 && this.mFontWeight != -1) {
                        Typeface typeface2 = Typeface.create((Typeface)typeface, (int)0);
                        n3 = this.mFontWeight;
                        bl = (this.mStyle & 2) != 0;
                        this.mFontTypeface = Api28Impl.create(typeface2, n3, bl);
                    } else {
                        this.mFontTypeface = typeface;
                    }
                }
                bl = this.mFontTypeface == null;
                this.mAsyncFontPending = bl;
            }
            catch (Resources.NotFoundException notFoundException) {
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                // empty catch block
            }
        }
        if (this.mFontTypeface != null) return;
        String string2 = var2_11.getString(n);
        if (string2 == null) return;
        if (Build.VERSION.SDK_INT >= 28 && this.mFontWeight != -1) {
            Typeface typeface = Typeface.create((String)string2, (int)0);
            n = this.mFontWeight;
            bl = bl2;
            if ((this.mStyle & 2) != 0) {
                bl = true;
            }
            this.mFontTypeface = Api28Impl.create(typeface, n, bl);
            return;
        }
        this.mFontTypeface = Typeface.create((String)string2, (int)this.mStyle);
    }

    void applyCompoundDrawablesTints() {
        Drawable[] drawableArray;
        if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            drawableArray = this.mView.getCompoundDrawables();
            this.applyCompoundDrawableTint(drawableArray[0], this.mDrawableLeftTint);
            this.applyCompoundDrawableTint(drawableArray[1], this.mDrawableTopTint);
            this.applyCompoundDrawableTint(drawableArray[2], this.mDrawableRightTint);
            this.applyCompoundDrawableTint(drawableArray[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            drawableArray = Api17Impl.getCompoundDrawablesRelative(this.mView);
            this.applyCompoundDrawableTint(drawableArray[0], this.mDrawableStartTint);
            this.applyCompoundDrawableTint(drawableArray[2], this.mDrawableEndTint);
        }
    }

    void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    ColorStateList getCompoundDrawableTintList() {
        ColorStateList colorStateList = this.mDrawableTint != null ? this.mDrawableTint.mTintList : null;
        return colorStateList;
    }

    PorterDuff.Mode getCompoundDrawableTintMode() {
        PorterDuff.Mode mode = this.mDrawableTint != null ? this.mDrawableTint.mTintMode : null;
        return mode;
    }

    boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    void loadFromAttributes(AttributeSet attributeSet, int n) {
        TintTypedArray tintTypedArray;
        Context context = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Object object = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.AppCompatTextHelper, n, 0);
        ViewCompat.saveAttributeDataForStyleable((View)this.mView, this.mView.getContext(), R.styleable.AppCompatTextHelper, attributeSet, ((TintTypedArray)object).getWrappedTypeArray(), n, 0);
        int n2 = ((TintTypedArray)object).getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (((TintTypedArray)object).hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.mDrawableLeftTint = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager, ((TintTypedArray)object).getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (((TintTypedArray)object).hasValue(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.mDrawableTopTint = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager, ((TintTypedArray)object).getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (((TintTypedArray)object).hasValue(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.mDrawableRightTint = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager, ((TintTypedArray)object).getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (((TintTypedArray)object).hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.mDrawableBottomTint = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager, ((TintTypedArray)object).getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (((TintTypedArray)object).hasValue(R.styleable.AppCompatTextHelper_android_drawableStart)) {
            this.mDrawableStartTint = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager, ((TintTypedArray)object).getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (((TintTypedArray)object).hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.mDrawableEndTint = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager, ((TintTypedArray)object).getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        ((TintTypedArray)object).recycle();
        boolean bl = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean bl2 = false;
        boolean bl3 = false;
        int n3 = 0;
        int n4 = 0;
        object = null;
        Object object2 = null;
        Object object3 = null;
        TintTypedArray tintTypedArray2 = null;
        if (n2 != -1) {
            tintTypedArray = TintTypedArray.obtainStyledAttributes(context, n2, R.styleable.TextAppearance);
            bl2 = bl3;
            n3 = n4;
            if (!bl) {
                bl2 = bl3;
                n3 = n4;
                if (tintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps)) {
                    n3 = 1;
                    bl2 = tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
                }
            }
            this.updateTypefaceAndStyle(context, tintTypedArray);
            object3 = tintTypedArray2;
            if (tintTypedArray.hasValue(R.styleable.TextAppearance_textLocale)) {
                object3 = tintTypedArray.getString(R.styleable.TextAppearance_textLocale);
            }
            object = object2;
            if (Build.VERSION.SDK_INT >= 26) {
                object = object2;
                if (tintTypedArray.hasValue(R.styleable.TextAppearance_fontVariationSettings)) {
                    object = tintTypedArray.getString(R.styleable.TextAppearance_fontVariationSettings);
                }
            }
            tintTypedArray.recycle();
        }
        tintTypedArray2 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TextAppearance, n, 0);
        if (!bl && tintTypedArray2.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            bl2 = tintTypedArray2.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
            n3 = 1;
        }
        if (tintTypedArray2.hasValue(R.styleable.TextAppearance_textLocale)) {
            object3 = tintTypedArray2.getString(R.styleable.TextAppearance_textLocale);
        }
        object2 = object;
        if (Build.VERSION.SDK_INT >= 26) {
            object2 = object;
            if (tintTypedArray2.hasValue(R.styleable.TextAppearance_fontVariationSettings)) {
                object2 = tintTypedArray2.getString(R.styleable.TextAppearance_fontVariationSettings);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && tintTypedArray2.hasValue(R.styleable.TextAppearance_android_textSize) && tintTypedArray2.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        this.updateTypefaceAndStyle(context, tintTypedArray2);
        tintTypedArray2.recycle();
        if (false) {
            this.mView.setTextColor(null);
        }
        if (false) {
            this.mView.setHintTextColor(null);
        }
        if (false) {
            this.mView.setLinkTextColor(null);
        }
        if (!bl && n3 != 0) {
            this.setAllCaps(bl2);
        }
        if (this.mFontTypeface != null) {
            if (this.mFontWeight == -1) {
                this.mView.setTypeface(this.mFontTypeface, this.mStyle);
            } else {
                this.mView.setTypeface(this.mFontTypeface);
            }
        }
        if (object2 != null) {
            Api26Impl.setFontVariationSettings(this.mView, (String)object2);
        }
        if (object3 != null) {
            Api24Impl.setTextLocales(this.mView, Api24Impl.forLanguageTags((String)object3));
        }
        this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, n);
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && this.mAutoSizeTextHelper.getAutoSizeTextType() != 0 && ((Object)(object = (Object)this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes())).length > 0) {
            if ((float)Api26Impl.getAutoSizeStepGranularity(this.mView) != -1.0f) {
                Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(this.mView, this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
            } else {
                Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(this.mView, (int[])object, 0);
            }
        }
        TintTypedArray tintTypedArray3 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.AppCompatTextView);
        tintTypedArray = null;
        attributeSet = null;
        n = R.styleable.AppCompatTextView_drawableLeftCompat;
        object = null;
        if ((n = tintTypedArray3.getResourceId(n, -1)) != -1) {
            attributeSet = appCompatDrawableManager.getDrawable(context, n);
        }
        if ((n = tintTypedArray3.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1)) != -1) {
            object = appCompatDrawableManager.getDrawable(context, n);
        }
        object3 = (n = tintTypedArray3.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1)) != -1 ? appCompatDrawableManager.getDrawable(context, n) : null;
        n = tintTypedArray3.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        object2 = n != -1 ? appCompatDrawableManager.getDrawable(context, n) : null;
        n = tintTypedArray3.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        tintTypedArray2 = n != -1 ? appCompatDrawableManager.getDrawable(context, n) : null;
        n = tintTypedArray3.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        if (n != -1) {
            tintTypedArray = appCompatDrawableManager.getDrawable(context, n);
        }
        this.setCompoundDrawables((Drawable)attributeSet, (Drawable)object, (Drawable)object3, (Drawable)object2, (Drawable)tintTypedArray2, (Drawable)tintTypedArray);
        if (tintTypedArray3.hasValue(R.styleable.AppCompatTextView_drawableTint)) {
            attributeSet = tintTypedArray3.getColorStateList(R.styleable.AppCompatTextView_drawableTint);
            TextViewCompat.setCompoundDrawableTintList(this.mView, (ColorStateList)attributeSet);
        }
        if (tintTypedArray3.hasValue(R.styleable.AppCompatTextView_drawableTintMode)) {
            attributeSet = DrawableUtils.parseTintMode(tintTypedArray3.getInt(R.styleable.AppCompatTextView_drawableTintMode, -1), null);
            TextViewCompat.setCompoundDrawableTintMode(this.mView, (PorterDuff.Mode)attributeSet);
        }
        n3 = tintTypedArray3.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        n4 = tintTypedArray3.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        n = tintTypedArray3.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
        tintTypedArray3.recycle();
        if (n3 != -1) {
            TextViewCompat.setFirstBaselineToTopHeight(this.mView, n3);
        }
        if (n4 != -1) {
            TextViewCompat.setLastBaselineToBottomHeight(this.mView, n4);
        }
        if (n != -1) {
            TextViewCompat.setLineHeight(this.mView, n);
        }
    }

    void onAsyncTypefaceReceived(WeakReference<TextView> textView, Typeface typeface) {
        if (this.mAsyncFontPending) {
            this.mFontTypeface = typeface;
            if ((textView = (TextView)textView.get()) != null) {
                if (ViewCompat.isAttachedToWindow((View)textView)) {
                    textView.post(new Runnable(this, textView, typeface, this.mStyle){
                        final AppCompatTextHelper this$0;
                        final int val$style;
                        final TextView val$textView;
                        final Typeface val$typeface;
                        {
                            this.this$0 = appCompatTextHelper;
                            this.val$textView = textView;
                            this.val$typeface = typeface;
                            this.val$style = n;
                        }

                        @Override
                        public void run() {
                            this.val$textView.setTypeface(this.val$typeface, this.val$style);
                        }
                    });
                } else {
                    textView.setTypeface(typeface, this.mStyle);
                }
            }
        }
    }

    void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        if (!ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            this.autoSizeText();
        }
    }

    void onSetCompoundDrawables() {
        this.applyCompoundDrawablesTints();
    }

    void onSetTextAppearance(Context object, int n) {
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(object, n, R.styleable.TextAppearance);
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            this.setAllCaps(tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize) && tintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        this.updateTypefaceAndStyle((Context)object, tintTypedArray);
        if (Build.VERSION.SDK_INT >= 26 && tintTypedArray.hasValue(R.styleable.TextAppearance_fontVariationSettings) && (object = tintTypedArray.getString(R.styleable.TextAppearance_fontVariationSettings)) != null) {
            Api26Impl.setFontVariationSettings(this.mView, (String)object);
        }
        tintTypedArray.recycle();
        if (this.mFontTypeface != null) {
            this.mView.setTypeface(this.mFontTypeface, this.mStyle);
        }
    }

    void populateSurroundingTextIfNeeded(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            EditorInfoCompat.setInitialSurroundingText(editorInfo, textView.getText());
        }
    }

    void setAllCaps(boolean bl) {
        this.mView.setAllCaps(bl);
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int n, int n2, int n3, int n4) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] nArray, int n) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n);
    }

    void setAutoSizeTextTypeWithDefaults(int n) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(n);
    }

    void setCompoundDrawableTintList(ColorStateList colorStateList) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        this.mDrawableTint.mTintList = colorStateList;
        TintInfo tintInfo = this.mDrawableTint;
        boolean bl = colorStateList != null;
        tintInfo.mHasTintList = bl;
        this.setCompoundTints();
    }

    void setCompoundDrawableTintMode(PorterDuff.Mode mode) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        this.mDrawableTint.mTintMode = mode;
        TintInfo tintInfo = this.mDrawableTint;
        boolean bl = mode != null;
        tintInfo.mHasTintMode = bl;
        this.setCompoundTints();
    }

    void setTextSize(int n, float f) {
        if (!ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && !this.isAutoSizeEnabled()) {
            this.setTextSizeInternal(n, f);
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Drawable[] getCompoundDrawablesRelative(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
        }

        static void setTextLocale(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Locale forLanguageTag(String string2) {
            return Locale.forLanguageTag(string2);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList forLanguageTags(String string2) {
            return LocaleList.forLanguageTags((String)string2);
        }

        static void setTextLocales(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static int getAutoSizeStepGranularity(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int n, int n2, int n3, int n4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        }

        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] nArray, int n) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n);
        }

        static boolean setFontVariationSettings(TextView textView, String string2) {
            return textView.setFontVariationSettings(string2);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Typeface create(Typeface typeface, int n, boolean bl) {
            return Typeface.create((Typeface)typeface, (int)n, (boolean)bl);
        }
    }
}

