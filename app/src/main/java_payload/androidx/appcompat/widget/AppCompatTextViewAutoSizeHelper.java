/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.RectF
 *  android.os.Build$VERSION
 *  android.text.Layout$Alignment
 *  android.text.StaticLayout
 *  android.text.StaticLayout$Builder
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.View
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

class AppCompatTextViewAutoSizeHelper {
    private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
    private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    private static final String TAG = "ACTVAutoSizeHelper";
    private static final RectF TEMP_RECTF = new RectF();
    static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0f;
    private static final int VERY_WIDE = 0x100000;
    private static ConcurrentHashMap<String, Field> sTextViewFieldByNameCache;
    private static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache;
    private float mAutoSizeMaxTextSizeInPx = -1.0f;
    private float mAutoSizeMinTextSizeInPx = -1.0f;
    private float mAutoSizeStepGranularityInPx = -1.0f;
    private int[] mAutoSizeTextSizesInPx = new int[0];
    private int mAutoSizeTextType = 0;
    private final Context mContext;
    private boolean mHasPresetAutoSizeValues = false;
    private final Impl mImpl;
    private boolean mNeedsAutoSizeText = false;
    private TextPaint mTempTextPaint;
    private final TextView mTextView;

    static {
        sTextViewMethodByNameCache = new ConcurrentHashMap();
        sTextViewFieldByNameCache = new ConcurrentHashMap();
    }

    AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.mTextView = textView;
        this.mContext = this.mTextView.getContext();
        this.mImpl = Build.VERSION.SDK_INT >= 29 ? new Impl29() : new Impl23();
    }

    private static <T> T accessAndReturnWithDefault(Object object, String string2, T t) {
        Field field;
        block3: {
            try {
                field = AppCompatTextViewAutoSizeHelper.getTextViewField(string2);
                if (field != null) break block3;
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.w((String)TAG, (String)("Failed to access TextView#" + string2 + " member"), (Throwable)illegalAccessException);
                return t;
            }
            return t;
        }
        object = field.get(object);
        return (T)object;
    }

    private int[] cleanupAutoSizePresetSizes(int[] nArray) {
        int n;
        int n2 = nArray.length;
        if (n2 == 0) {
            return nArray;
        }
        Arrays.sort(nArray);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (n = 0; n < n2; ++n) {
            int n3 = nArray[n];
            if (n3 <= 0 || Collections.binarySearch(arrayList, n3) >= 0) continue;
            arrayList.add(n3);
        }
        if (n2 == arrayList.size()) {
            return nArray;
        }
        n2 = arrayList.size();
        nArray = new int[n2];
        for (n = 0; n < n2; ++n) {
            nArray[n] = (Integer)arrayList.get(n);
        }
        return nArray;
    }

    private void clearAutoSizeConfiguration() {
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = -1.0f;
        this.mAutoSizeMaxTextSizeInPx = -1.0f;
        this.mAutoSizeStepGranularityInPx = -1.0f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mNeedsAutoSizeText = false;
    }

    private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence charSequence, Layout.Alignment alignment, int n) {
        float f = AppCompatTextViewAutoSizeHelper.accessAndReturnWithDefault(this.mTextView, "mSpacingMult", Float.valueOf(1.0f)).floatValue();
        float f2 = AppCompatTextViewAutoSizeHelper.accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", Float.valueOf(0.0f)).floatValue();
        boolean bl = AppCompatTextViewAutoSizeHelper.accessAndReturnWithDefault(this.mTextView, "mIncludePad", true);
        return new StaticLayout(charSequence, this.mTempTextPaint, n, alignment, f, f2, bl);
    }

    private int findLargestTextSizeWhichFits(RectF rectF) {
        int n = this.mAutoSizeTextSizesInPx.length;
        if (n != 0) {
            int n2 = 0;
            int n3 = 0 + 1;
            --n;
            while (n3 <= n) {
                n2 = (n3 + n) / 2;
                if (this.suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[n2], rectF)) {
                    int n4 = n2 + 1;
                    n2 = n3;
                    n3 = n4;
                    continue;
                }
                n2 = n = n2 - 1;
            }
            return this.mAutoSizeTextSizesInPx[n2];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private static Field getTextViewField(String string2) {
        Field field;
        block4: {
            Field field2;
            try {
                field = field2 = sTextViewFieldByNameCache.get(string2);
                if (field2 != null) break block4;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                Log.w((String)TAG, (String)("Failed to access TextView#" + string2 + " member"), (Throwable)noSuchFieldException);
                return null;
            }
            field = field2 = TextView.class.getDeclaredField(string2);
            if (field2 == null) break block4;
            field2.setAccessible(true);
            sTextViewFieldByNameCache.put(string2, field2);
            field = field2;
        }
        return field;
    }

    private static Method getTextViewMethod(String string2) {
        Method method;
        block4: {
            Method method2;
            try {
                method = method2 = sTextViewMethodByNameCache.get(string2);
                if (method2 != null) break block4;
            }
            catch (Exception exception) {
                Log.w((String)TAG, (String)("Failed to retrieve TextView#" + string2 + "() method"), (Throwable)exception);
                return null;
            }
            method = method2 = TextView.class.getDeclaredMethod(string2, new Class[0]);
            if (method2 == null) break block4;
            method2.setAccessible(true);
            sTextViewMethodByNameCache.put(string2, method2);
            method = method2;
        }
        return method;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static <T> T invokeAndReturnWithDefault(Object object, String object2, T t) {
        Throwable throwable2;
        boolean bl;
        block4: {
            Object var5_5 = null;
            bl = false;
            try {
                try {
                    object = object2 = (object = AppCompatTextViewAutoSizeHelper.getTextViewMethod((String)object2).invoke(object, new Object[0]));
                    if (object2 != null) return (T)object;
                    object = object2;
                    return (T)object;
                }
                catch (Exception exception) {
                    boolean bl2;
                    bl = bl2 = true;
                    bl = bl2;
                    StringBuilder stringBuilder = new StringBuilder();
                    bl = bl2;
                    Log.w((String)TAG, (String)stringBuilder.append("Failed to invoke TextView#").append((String)object2).append("() method").toString(), (Throwable)exception);
                    object = var5_5;
                    object = var5_5;
                }
            }
            catch (Throwable throwable2) {
                break block4;
            }
            object = t;
            return (T)object;
        }
        if (!bl) throw throwable2;
        throw throwable2;
    }

    private void setRawTextSize(float f) {
        if (f != this.mTextView.getPaint().getTextSize()) {
            this.mTextView.getPaint().setTextSize(f);
            boolean bl = Api18Impl.isInLayout((View)this.mTextView);
            if (this.mTextView.getLayout() != null) {
                block7: {
                    this.mNeedsAutoSizeText = false;
                    Method method = AppCompatTextViewAutoSizeHelper.getTextViewMethod("nullLayouts");
                    if (method == null) break block7;
                    try {
                        method.invoke((Object)this.mTextView, new Object[0]);
                    }
                    catch (Exception exception) {
                        Log.w((String)TAG, (String)"Failed to invoke TextView#nullLayouts() method", (Throwable)exception);
                    }
                }
                if (!bl) {
                    this.mTextView.requestLayout();
                } else {
                    this.mTextView.forceLayout();
                }
                this.mTextView.invalidate();
            }
        }
    }

    private boolean setupAutoSizeText() {
        if (this.supportsAutoSizeText() && this.mAutoSizeTextType == 1) {
            if (!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
                int n = (int)Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx) + 1;
                int[] nArray = new int[n];
                for (int i = 0; i < n; ++i) {
                    nArray[i] = Math.round(this.mAutoSizeMinTextSizeInPx + (float)i * this.mAutoSizeStepGranularityInPx);
                }
                this.mAutoSizeTextSizesInPx = this.cleanupAutoSizePresetSizes(nArray);
            }
            this.mNeedsAutoSizeText = true;
        } else {
            this.mNeedsAutoSizeText = false;
        }
        return this.mNeedsAutoSizeText;
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray typedArray) {
        int n = typedArray.length();
        int[] nArray = new int[n];
        if (n > 0) {
            for (int i = 0; i < n; ++i) {
                nArray[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.mAutoSizeTextSizesInPx = this.cleanupAutoSizePresetSizes(nArray);
            this.setupAutoSizeUniformPresetSizesConfiguration();
        }
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        int n = this.mAutoSizeTextSizesInPx.length;
        boolean bl = n > 0;
        this.mHasPresetAutoSizeValues = bl;
        if (this.mHasPresetAutoSizeValues) {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = this.mAutoSizeTextSizesInPx[0];
            this.mAutoSizeMaxTextSizeInPx = this.mAutoSizeTextSizesInPx[n - 1];
            this.mAutoSizeStepGranularityInPx = -1.0f;
        }
        return this.mHasPresetAutoSizeValues;
    }

    private boolean suggestedSizeFitsInSpace(int n, RectF rectF) {
        CharSequence charSequence = this.mTextView.getText();
        Object object = this.mTextView.getTransformationMethod();
        CharSequence charSequence2 = charSequence;
        if (object != null) {
            object = object.getTransformation(charSequence, (View)this.mTextView);
            charSequence2 = charSequence;
            if (object != null) {
                charSequence2 = object;
            }
        }
        int n2 = Api16Impl.getMaxLines(this.mTextView);
        this.initTempTextPaint(n);
        charSequence = this.createLayout(charSequence2, AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), n2);
        if (n2 != -1 && (charSequence.getLineCount() > n2 || charSequence.getLineEnd(charSequence.getLineCount() - 1) != charSequence2.length())) {
            return false;
        }
        return !((float)charSequence.getHeight() > rectF.bottom);
    }

    private boolean supportsAutoSizeText() {
        return this.mTextView instanceof AppCompatEditText ^ true;
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float f, float f2, float f3) throws IllegalArgumentException {
        if (!(f <= 0.0f)) {
            if (!(f2 <= f)) {
                if (!(f3 <= 0.0f)) {
                    this.mAutoSizeTextType = 1;
                    this.mAutoSizeMinTextSizeInPx = f;
                    this.mAutoSizeMaxTextSizeInPx = f2;
                    this.mAutoSizeStepGranularityInPx = f3;
                    this.mHasPresetAutoSizeValues = false;
                    return;
                }
                throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
            }
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void autoSizeText() {
        if (!this.isAutoSizeEnabled()) {
            return;
        }
        if (this.mNeedsAutoSizeText) {
            if (this.mTextView.getMeasuredHeight() <= 0) return;
            if (this.mTextView.getMeasuredWidth() <= 0) {
                return;
            }
            int n = this.mImpl.isHorizontallyScrollable(this.mTextView) ? 0x100000 : this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft() - this.mTextView.getTotalPaddingRight();
            int n2 = this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom() - this.mTextView.getCompoundPaddingTop();
            if (n <= 0) return;
            if (n2 <= 0) {
                return;
            }
            RectF rectF = TEMP_RECTF;
            synchronized (rectF) {
                TEMP_RECTF.setEmpty();
                AppCompatTextViewAutoSizeHelper.TEMP_RECTF.right = n;
                AppCompatTextViewAutoSizeHelper.TEMP_RECTF.bottom = n2;
                float f = this.findLargestTextSizeWhichFits(TEMP_RECTF);
                if (f != this.mTextView.getTextSize()) {
                    this.setTextSizeInternal(0, f);
                }
            }
        }
        this.mNeedsAutoSizeText = true;
    }

    StaticLayout createLayout(CharSequence charSequence, Layout.Alignment alignment, int n, int n2) {
        return Api23Impl.createStaticLayoutForMeasuring(charSequence, alignment, n, n2, this.mTextView, this.mTempTextPaint, this.mImpl);
    }

    int getAutoSizeMaxTextSize() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    int getAutoSizeMinTextSize() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    int getAutoSizeStepGranularity() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    void initTempTextPaint(int n) {
        if (this.mTempTextPaint == null) {
            this.mTempTextPaint = new TextPaint();
        } else {
            this.mTempTextPaint.reset();
        }
        this.mTempTextPaint.set(this.mTextView.getPaint());
        this.mTempTextPaint.setTextSize((float)n);
    }

    boolean isAutoSizeEnabled() {
        boolean bl = this.supportsAutoSizeText() && this.mAutoSizeTextType != 0;
        return bl;
    }

    void loadFromAttributes(AttributeSet attributeSet, int n) {
        float f = -1.0f;
        float f2 = -1.0f;
        float f3 = -1.0f;
        TypedArray typedArray = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, n, 0);
        ViewCompat.saveAttributeDataForStyleable((View)this.mTextView, this.mTextView.getContext(), R.styleable.AppCompatTextView, attributeSet, typedArray, n, 0);
        if (typedArray.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
            this.mAutoSizeTextType = typedArray.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        if (typedArray.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity)) {
            f3 = typedArray.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f);
        }
        if (typedArray.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize)) {
            f = typedArray.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f);
        }
        if (typedArray.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize)) {
            f2 = typedArray.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f);
        }
        if (typedArray.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) && (n = typedArray.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            attributeSet = typedArray.getResources().obtainTypedArray(n);
            this.setupAutoSizeUniformPresetSizes((TypedArray)attributeSet);
            attributeSet.recycle();
        }
        typedArray.recycle();
        if (this.supportsAutoSizeText()) {
            if (this.mAutoSizeTextType == 1) {
                if (!this.mHasPresetAutoSizeValues) {
                    attributeSet = this.mContext.getResources().getDisplayMetrics();
                    float f4 = f;
                    if (f == -1.0f) {
                        f4 = TypedValue.applyDimension((int)2, (float)12.0f, (DisplayMetrics)attributeSet);
                    }
                    f = f2;
                    if (f2 == -1.0f) {
                        f = TypedValue.applyDimension((int)2, (float)112.0f, (DisplayMetrics)attributeSet);
                    }
                    f2 = f3;
                    if (f3 == -1.0f) {
                        f2 = 1.0f;
                    }
                    this.validateAndSetAutoSizeTextTypeUniformConfiguration(f4, f, f2);
                }
                this.setupAutoSizeText();
            }
        } else {
            this.mAutoSizeTextType = 0;
        }
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int n, int n2, int n3, int n4) throws IllegalArgumentException {
        if (this.supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            this.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension((int)n4, (float)n, (DisplayMetrics)displayMetrics), TypedValue.applyDimension((int)n4, (float)n2, (DisplayMetrics)displayMetrics), TypedValue.applyDimension((int)n4, (float)n3, (DisplayMetrics)displayMetrics));
            if (this.setupAutoSizeText()) {
                this.autoSizeText();
            }
        }
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] nArray, int n) throws IllegalArgumentException {
        if (this.supportsAutoSizeText()) {
            int n2 = nArray.length;
            if (n2 > 0) {
                int[] nArray2;
                int[] nArray3 = new int[n2];
                if (n == 0) {
                    nArray2 = Arrays.copyOf(nArray, n2);
                } else {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    int n3 = 0;
                    while (true) {
                        nArray2 = nArray3;
                        if (n3 >= n2) break;
                        nArray3[n3] = Math.round(TypedValue.applyDimension((int)n, (float)nArray[n3], (DisplayMetrics)displayMetrics));
                        ++n3;
                    }
                }
                this.mAutoSizeTextSizesInPx = this.cleanupAutoSizePresetSizes(nArray2);
                if (!this.setupAutoSizeUniformPresetSizesConfiguration()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(nArray));
                }
            } else {
                this.mHasPresetAutoSizeValues = false;
            }
            if (this.setupAutoSizeText()) {
                this.autoSizeText();
            }
        }
    }

    void setAutoSizeTextTypeWithDefaults(int n) {
        if (this.supportsAutoSizeText()) {
            switch (n) {
                default: {
                    throw new IllegalArgumentException("Unknown auto-size text type: " + n);
                }
                case 1: {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    this.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension((int)2, (float)12.0f, (DisplayMetrics)displayMetrics), TypedValue.applyDimension((int)2, (float)112.0f, (DisplayMetrics)displayMetrics), 1.0f);
                    if (!this.setupAutoSizeText()) break;
                    this.autoSizeText();
                    break;
                }
                case 0: {
                    this.clearAutoSizeConfiguration();
                }
            }
        }
    }

    void setTextSizeInternal(int n, float f) {
        Resources resources = this.mContext == null ? Resources.getSystem() : this.mContext.getResources();
        this.setRawTextSize(TypedValue.applyDimension((int)n, (float)f, (DisplayMetrics)resources.getDisplayMetrics()));
    }

    private static final class Api16Impl {
        private Api16Impl() {
        }

        static StaticLayout createStaticLayoutForMeasuring(CharSequence charSequence, Layout.Alignment alignment, int n, TextView textView, TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, n, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        static int getMaxLines(TextView textView) {
            return textView.getMaxLines();
        }
    }

    private static final class Api18Impl {
        private Api18Impl() {
        }

        static boolean isInLayout(View view) {
            return view.isInLayout();
        }
    }

    private static final class Api23Impl {
        private Api23Impl() {
        }

        static StaticLayout createStaticLayoutForMeasuring(CharSequence charSequence, Layout.Alignment alignment, int n, int n2, TextView textView, TextPaint textPaint, Impl impl) {
            charSequence = StaticLayout.Builder.obtain((CharSequence)charSequence, (int)0, (int)charSequence.length(), (TextPaint)textPaint, (int)n);
            alignment = charSequence.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (n2 == -1) {
                n2 = Integer.MAX_VALUE;
            }
            alignment.setMaxLines(n2);
            try {
                impl.computeAndSetTextDirection((StaticLayout.Builder)charSequence, textView);
            }
            catch (ClassCastException classCastException) {
                Log.w((String)AppCompatTextViewAutoSizeHelper.TAG, (String)"Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return charSequence.build();
        }
    }

    private static class Impl {
        Impl() {
        }

        void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
        }

        boolean isHorizontallyScrollable(TextView textView) {
            return AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getHorizontallyScrolling", false);
        }
    }

    private static class Impl23
    extends Impl {
        Impl23() {
        }

        @Override
        void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    private static class Impl29
    extends Impl23 {
        Impl29() {
        }

        @Override
        void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override
        boolean isHorizontallyScrollable(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }
}

