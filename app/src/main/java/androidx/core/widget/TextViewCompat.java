/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.res.ColorStateList
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.icu.text.DecimalFormatSymbols
 *  android.os.Build$VERSION
 *  android.text.Editable
 *  android.text.PrecomputedText
 *  android.text.PrecomputedText$Params
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 *  android.text.method.PasswordTransformationMethod
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.widget.TextView
 */
package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import androidx.core.widget.AutoSizeableTextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;

    private TextViewCompat() {
    }

    public static int getAutoSizeMaxTextSize(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeMaxTextSize(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView)textView).getAutoSizeMaxTextSize();
        }
        return -1;
    }

    public static int getAutoSizeMinTextSize(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeMinTextSize(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView)textView).getAutoSizeMinTextSize();
        }
        return -1;
    }

    public static int getAutoSizeStepGranularity(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeStepGranularity(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView)textView).getAutoSizeStepGranularity();
        }
        return -1;
    }

    public static int[] getAutoSizeTextAvailableSizes(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeTextAvailableSizes(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView)textView).getAutoSizeTextAvailableSizes();
        }
        return new int[0];
    }

    public static int getAutoSizeTextType(TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeTextType(textView);
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView)textView).getAutoSizeTextType();
        }
        return 0;
    }

    public static ColorStateList getCompoundDrawableTintList(TextView textView) {
        Preconditions.checkNotNull(textView);
        return Api23Impl.getCompoundDrawableTintList(textView);
    }

    public static PorterDuff.Mode getCompoundDrawableTintMode(TextView textView) {
        Preconditions.checkNotNull(textView);
        return Api23Impl.getCompoundDrawableTintMode(textView);
    }

    public static Drawable[] getCompoundDrawablesRelative(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static int getFirstBaselineToTopHeight(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int getMaxLines(TextView textView) {
        return textView.getMaxLines();
    }

    public static int getMinLines(TextView textView) {
        return textView.getMinLines();
    }

    private static int getTextDirection(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 7;
        }
        return 1;
    }

    private static TextDirectionHeuristic getTextDirectionHeuristic(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        int n = Build.VERSION.SDK_INT;
        byte by = 0;
        if (n >= 28 && (textView.getInputType() & 0xF) == 3) {
            by = Character.getDirectionality(Api28Impl.getDigitStrings(Api24Impl.getInstance(textView.getTextLocale()))[0].codePointAt(0));
            if (by != 1 && by != 2) {
                return TextDirectionHeuristics.LTR;
            }
            return TextDirectionHeuristics.RTL;
        }
        if (textView.getLayoutDirection() == 1) {
            by = 1;
        }
        switch (textView.getTextDirection()) {
            default: {
                textView = by != 0 ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            case 7: {
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            }
            case 6: {
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            case 5: {
                return TextDirectionHeuristics.LOCALE;
            }
            case 4: {
                return TextDirectionHeuristics.RTL;
            }
            case 3: {
                return TextDirectionHeuristics.LTR;
            }
            case 2: {
                return TextDirectionHeuristics.ANYRTL_LTR;
            }
        }
        return textView;
    }

    public static PrecomputedTextCompat.Params getTextMetricsParams(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PrecomputedTextCompat.Params(Api28Impl.getTextMetricsParams(textView));
        }
        PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(new TextPaint((Paint)textView.getPaint()));
        builder.setBreakStrategy(Api23Impl.getBreakStrategy(textView));
        builder.setHyphenationFrequency(Api23Impl.getHyphenationFrequency(textView));
        builder.setTextDirection(TextViewCompat.getTextDirectionHeuristic(textView));
        return builder.build();
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int n, int n2, int n3, int n4) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(textView, n, n2, n3, n4);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView)textView).setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        }
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] nArray, int n) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(textView, nArray, n);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView)textView).setAutoSizeTextTypeUniformWithPresetSizes(nArray, n);
        }
    }

    public static void setAutoSizeTextTypeWithDefaults(TextView textView, int n) {
        if (Build.VERSION.SDK_INT >= 27) {
            Api26Impl.setAutoSizeTextTypeWithDefaults(textView, n);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView)textView).setAutoSizeTextTypeWithDefaults(n);
        }
    }

    public static void setCompoundDrawableTintList(TextView textView, ColorStateList colorStateList) {
        Preconditions.checkNotNull(textView);
        Api23Impl.setCompoundDrawableTintList(textView, colorStateList);
    }

    public static void setCompoundDrawableTintMode(TextView textView, PorterDuff.Mode mode) {
        Preconditions.checkNotNull(textView);
        Api23Impl.setCompoundDrawableTintMode(textView, mode);
    }

    public static void setCompoundDrawablesRelative(TextView textView, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        textView.setCompoundDrawablesRelative(drawable2, drawable3, drawable4, drawable5);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int n, int n2, int n3, int n4) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(n, n2, n3, n4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
    }

    public static void setCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback2) {
        textView.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(textView, callback2));
    }

    public static void setFirstBaselineToTopHeight(TextView textView, int n) {
        Preconditions.checkArgumentNonnegative(n);
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setFirstBaselineToTopHeight(textView, n);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int n2 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (n > Math.abs(n2)) {
            textView.setPadding(textView.getPaddingLeft(), n + n2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void setLastBaselineToBottomHeight(TextView textView, int n) {
        Preconditions.checkArgumentNonnegative(n);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int n2 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (n > Math.abs(n2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), n - n2);
        }
    }

    public static void setLineHeight(TextView textView, int n) {
        Preconditions.checkArgumentNonnegative(n);
        int n2 = textView.getPaint().getFontMetricsInt(null);
        if (n != n2) {
            textView.setLineSpacing((float)(n - n2), 1.0f);
        }
    }

    public static void setLineHeight(TextView textView, int n, float f) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setLineHeight(textView, n, f);
        } else {
            TextViewCompat.setLineHeight(textView, Math.round(TypedValue.applyDimension((int)n, (float)f, (DisplayMetrics)textView.getResources().getDisplayMetrics())));
        }
    }

    public static void setPrecomputedText(TextView textView, PrecomputedTextCompat precomputedTextCompat) {
        block4: {
            block3: {
                block2: {
                    if (Build.VERSION.SDK_INT < 29) break block2;
                    textView.setText(Api28Impl.castToCharSequence(precomputedTextCompat.getPrecomputedText()));
                    break block3;
                }
                if (!TextViewCompat.getTextMetricsParams(textView).equalsWithoutTextDirection(precomputedTextCompat.getParams())) break block4;
                textView.setText((CharSequence)((Object)precomputedTextCompat));
            }
            return;
        }
        throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }

    public static void setTextAppearance(TextView textView, int n) {
        textView.setTextAppearance(n);
    }

    public static void setTextMetricsParams(TextView textView, PrecomputedTextCompat.Params params) {
        textView.setTextDirection(TextViewCompat.getTextDirection(params.getTextDirection()));
        textView.getPaint().set(params.getTextPaint());
        Api23Impl.setBreakStrategy(textView, params.getBreakStrategy());
        Api23Impl.setHyphenationFrequency(textView, params.getHyphenationFrequency());
    }

    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(ActionMode.Callback callback2) {
        if (callback2 instanceof OreoCallback && Build.VERSION.SDK_INT >= 26) {
            return ((OreoCallback)callback2).getWrappedCallback();
        }
        return callback2;
    }

    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback2) {
        if (Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT <= 27 && !(callback2 instanceof OreoCallback) && callback2 != null) {
            return new OreoCallback(callback2, textView);
        }
        return callback2;
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int getBreakStrategy(TextView textView) {
            return textView.getBreakStrategy();
        }

        static ColorStateList getCompoundDrawableTintList(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        static PorterDuff.Mode getCompoundDrawableTintMode(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        static int getHyphenationFrequency(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        static void setBreakStrategy(TextView textView, int n) {
            textView.setBreakStrategy(n);
        }

        static void setCompoundDrawableTintList(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        static void setCompoundDrawableTintMode(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        static void setHyphenationFrequency(TextView textView, int n) {
            textView.setHyphenationFrequency(n);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static DecimalFormatSymbols getInstance(Locale locale) {
            return DecimalFormatSymbols.getInstance((Locale)locale);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static int getAutoSizeMaxTextSize(TextView textView) {
            return textView.getAutoSizeMaxTextSize();
        }

        static int getAutoSizeMinTextSize(TextView textView) {
            return textView.getAutoSizeMinTextSize();
        }

        static int getAutoSizeStepGranularity(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static int[] getAutoSizeTextAvailableSizes(TextView textView) {
            return textView.getAutoSizeTextAvailableSizes();
        }

        static int getAutoSizeTextType(TextView textView) {
            return textView.getAutoSizeTextType();
        }

        static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int n, int n2, int n3, int n4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        }

        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] nArray, int n) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n);
        }

        static void setAutoSizeTextTypeWithDefaults(TextView textView, int n) {
            textView.setAutoSizeTextTypeWithDefaults(n);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static CharSequence castToCharSequence(PrecomputedText precomputedText) {
            return precomputedText;
        }

        static String[] getDigitStrings(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        static PrecomputedText.Params getTextMetricsParams(TextView textView) {
            return textView.getTextMetricsParams();
        }

        static void setFirstBaselineToTopHeight(TextView textView, int n) {
            textView.setFirstBaselineToTopHeight(n);
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        public static void setLineHeight(TextView textView, int n, float f) {
            textView.setLineHeight(n, f);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface AutoSizeTextType {
    }

    private static class OreoCallback
    implements ActionMode.Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences;
        private Class<?> mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        OreoCallback(ActionMode.Callback callback2, TextView textView) {
            this.mCallback = callback2;
            this.mTextView = textView;
            this.mInitializedMenuBuilderReferences = false;
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo resolveInfo, TextView textView) {
            return this.createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", this.isEditable(textView) ^ true).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        private List<ResolveInfo> getSupportedActivities(Context context, PackageManager packageManager2) {
            ArrayList<ResolveInfo> arrayList = new ArrayList<ResolveInfo>();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (PackageManager packageManager2 : packageManager2.queryIntentActivities(this.createProcessTextIntent(), 0)) {
                if (!this.isSupportedActivity((ResolveInfo)packageManager2, context)) continue;
                arrayList.add((ResolveInfo)packageManager2);
            }
            return arrayList;
        }

        private boolean isEditable(TextView textView) {
            boolean bl = textView instanceof Editable && textView.onCheckIsTextEditor() && textView.isEnabled();
            return bl;
        }

        private boolean isSupportedActivity(ResolveInfo resolveInfo, Context context) {
            boolean bl;
            block2: {
                boolean bl2 = context.getPackageName().equals(resolveInfo.activityInfo.packageName);
                bl = true;
                if (bl2) {
                    return true;
                }
                if (!resolveInfo.activityInfo.exported) {
                    return false;
                }
                if (resolveInfo.activityInfo.permission == null || context.checkSelfPermission(resolveInfo.activityInfo.permission) == 0) break block2;
                bl = false;
            }
            return bl;
        }

        private void recomputeProcessTextMenuItems(Menu menu) {
            block12: {
                int n;
                Object object;
                PackageManager packageManager;
                Context context;
                block11: {
                    context = this.mTextView.getContext();
                    packageManager = context.getPackageManager();
                    if (!this.mInitializedMenuBuilderReferences) {
                        this.mInitializedMenuBuilderReferences = true;
                        try {
                            this.mMenuBuilderClass = Class.forName("com.android.internal.view.menu.MenuBuilder");
                            this.mMenuBuilderRemoveItemAtMethod = this.mMenuBuilderClass.getDeclaredMethod("removeItemAt", Integer.TYPE);
                            this.mCanUseMenuBuilderReferences = true;
                            break block11;
                        }
                        catch (NoSuchMethodException noSuchMethodException) {
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            // empty catch block
                        }
                        this.mMenuBuilderClass = null;
                        this.mMenuBuilderRemoveItemAtMethod = null;
                        this.mCanUseMenuBuilderReferences = false;
                    }
                }
                try {
                    object = this.mCanUseMenuBuilderReferences && this.mMenuBuilderClass.isInstance(menu) ? this.mMenuBuilderRemoveItemAtMethod : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                }
                catch (InvocationTargetException invocationTargetException) {
                    break block12;
                }
                catch (IllegalAccessException illegalAccessException) {
                    break block12;
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    // empty catch block
                }
                for (n = menu.size() - 1; n >= 0; --n) {
                    MenuItem menuItem = menu.getItem(n);
                    if (menuItem.getIntent() == null || !"android.intent.action.PROCESS_TEXT".equals(menuItem.getIntent().getAction())) continue;
                    ((Method)object).invoke((Object)menu, n);
                    continue;
                }
                object = this.getSupportedActivities(context, packageManager);
                for (n = 0; n < object.size(); ++n) {
                    context = (ResolveInfo)object.get(n);
                    menu.add(0, 0, n + 100, context.loadLabel(packageManager)).setIntent(this.createProcessTextIntentForResolveInfo((ResolveInfo)context, this.mTextView)).setShowAsAction(1);
                }
                return;
            }
        }

        ActionMode.Callback getWrappedCallback() {
            return this.mCallback;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mCallback.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mCallback.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.mCallback.onDestroyActionMode(actionMode);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            this.recomputeProcessTextMenuItems(menu);
            return this.mCallback.onPrepareActionMode(actionMode, menu);
        }
    }
}

