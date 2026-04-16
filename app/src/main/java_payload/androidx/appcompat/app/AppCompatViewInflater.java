/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.InflateException
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final int[] sAccessibilityHeading;
    private static final int[] sAccessibilityPaneTitle;
    private static final String[] sClassPrefixList;
    private static final SimpleArrayMap<String, Constructor<? extends View>> sConstructorMap;
    private static final Class<?>[] sConstructorSignature;
    private static final int[] sOnClickAttrs;
    private static final int[] sScreenReaderFocusable;
    private final Object[] mConstructorArgs = new Object[2];

    static {
        sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
        sOnClickAttrs = new int[]{16843375};
        sAccessibilityHeading = new int[]{16844160};
        sAccessibilityPaneTitle = new int[]{16844156};
        sScreenReaderFocusable = new int[]{16844148};
        sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
        sConstructorMap = new SimpleArrayMap();
    }

    private void backportAccessibilityAttributes(Context context, View view, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, sAccessibilityHeading);
        if (typedArray.hasValue(0)) {
            ViewCompat.setAccessibilityHeading(view, typedArray.getBoolean(0, false));
        }
        typedArray.recycle();
        typedArray = context.obtainStyledAttributes(attributeSet, sAccessibilityPaneTitle);
        if (typedArray.hasValue(0)) {
            ViewCompat.setAccessibilityPaneTitle(view, typedArray.getString(0));
        }
        typedArray.recycle();
        context = context.obtainStyledAttributes(attributeSet, sScreenReaderFocusable);
        if (context.hasValue(0)) {
            ViewCompat.setScreenReaderFocusable(view, context.getBoolean(0, false));
        }
        context.recycle();
    }

    private void checkOnClickListener(View view, AttributeSet object) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper && ViewCompat.hasOnClickListeners(view)) {
            if ((object = (context = context.obtainStyledAttributes(object, sOnClickAttrs)).getString(0)) != null) {
                view.setOnClickListener((View.OnClickListener)new DeclaredOnClickListener(view, (String)object));
            }
            context.recycle();
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    private View createViewByPrefix(Context var1_1, String var2_3, String var3_4) throws ClassNotFoundException, InflateException {
        var5_5 = AppCompatViewInflater.sConstructorMap.get(var2_3);
        var4_6 = var5_5;
        if (var5_5 != null) ** GOTO lbl14
        if (var3_4 != null) {
            var4_6 = new Constructor<View>();
            var3_4 = var4_6.append(var3_4).append(var2_3).toString();
        } else {
            var3_4 = var2_3;
        }
        try {
            var4_6 = Class.forName(var3_4, false, var1_1.getClassLoader()).asSubclass(View.class).getConstructor(AppCompatViewInflater.sConstructorSignature);
            AppCompatViewInflater.sConstructorMap.put(var2_3, var4_6);
lbl14:
            // 2 sources

            var4_6.setAccessible(true);
            var1_1 = var4_6.newInstance(this.mConstructorArgs);
            return var1_1;
        }
        catch (Exception var1_2) {
            return null;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private View createViewFromTag(Context context, String string2, AttributeSet attributeSet) {
        String string3 = string2;
        if (string2.equals("view")) {
            string3 = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[1] = attributeSet;
            if (-1 == string3.indexOf(46)) {
                int n = 0;
                while (true) {
                    if (n >= sClassPrefixList.length) {
                        this.mConstructorArgs[0] = null;
                        this.mConstructorArgs[1] = null;
                        return null;
                    }
                    string2 = this.createViewByPrefix(context, string3, sClassPrefixList[n]);
                    if (string2 != null) {
                        this.mConstructorArgs[0] = null;
                        this.mConstructorArgs[1] = null;
                        return string2;
                    }
                    ++n;
                }
            }
        }
        catch (Exception exception) {
            return null;
        }
        try {
            context = this.createViewByPrefix(context, string3, null);
            return context;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            this.mConstructorArgs[0] = null;
            this.mConstructorArgs[1] = null;
        }
    }

    private static Context themifyContext(Context context, AttributeSet object, boolean bl, boolean bl2) {
        block7: {
            int n;
            block8: {
                object = context.obtainStyledAttributes(object, R.styleable.View, 0, 0);
                int n2 = 0;
                if (bl) {
                    n2 = object.getResourceId(R.styleable.View_android_theme, 0);
                }
                n = n2;
                if (bl2) {
                    n = n2;
                    if (n2 == 0) {
                        n = n2 = object.getResourceId(R.styleable.View_theme, 0);
                        if (n2 != 0) {
                            Log.i((String)LOG_TAG, (String)"app:theme is now deprecated. Please move to using android:theme instead.");
                            n = n2;
                        }
                    }
                }
                object.recycle();
                object = context;
                if (n == 0) break block7;
                if (!(context instanceof ContextThemeWrapper)) break block8;
                object = context;
                if (((ContextThemeWrapper)context).getThemeResId() == n) break block7;
            }
            object = new ContextThemeWrapper(context, n);
        }
        return object;
    }

    private void verifyNotNull(View view, String string2) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(this.getClass().getName() + " asked to inflate view for <" + string2 + ">, but returned null");
    }

    protected AppCompatAutoCompleteTextView createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    protected AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    protected AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    protected AppCompatCheckedTextView createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    protected AppCompatEditText createEditText(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    protected AppCompatImageButton createImageButton(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    protected AppCompatImageView createImageView(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    protected AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    protected AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    protected AppCompatRatingBar createRatingBar(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    protected AppCompatSeekBar createSeekBar(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    protected AppCompatSpinner createSpinner(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    protected AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    protected AppCompatToggleButton createToggleButton(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    protected View createView(Context context, String string2, AttributeSet attributeSet) {
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public final View createView(View object, String string2, Context context, AttributeSet attributeSet, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        void var11_34;
        void var1_21;
        int n;
        void var2_22;
        void var4_24;
        Context context2;
        void var3_23;
        block43: {
            void var8_28;
            void var1_5;
            block42: {
                void var7_27;
                void var6_26;
                block41: {
                    void var5_25;
                    context2 = var3_23;
                    if (var5_25 != false) {
                        context2 = var3_23;
                        if (object != null) {
                            context2 = object.getContext();
                        }
                    }
                    if (var6_26 != false) break block41;
                    void var1_2 = context2;
                    if (var7_27 == false) break block42;
                }
                Context context3 = AppCompatViewInflater.themifyContext(context2, (AttributeSet)var4_24, (boolean)var6_26, (boolean)var7_27);
            }
            context2 = var1_5;
            if (var8_28 != false) {
                context2 = TintContextWrapper.wrap((Context)var1_5);
            }
            switch (var2_22.hashCode()) {
                case 2001146706: {
                    if (!var2_22.equals("Button")) break;
                    n = 2;
                    break block43;
                }
                case 1666676343: {
                    if (!var2_22.equals("EditText")) break;
                    n = 3;
                    break block43;
                }
                case 1601505219: {
                    if (!var2_22.equals("CheckBox")) break;
                    n = 6;
                    break block43;
                }
                case 1413872058: {
                    if (!var2_22.equals("AutoCompleteTextView")) break;
                    n = 9;
                    break block43;
                }
                case 1125864064: {
                    if (!var2_22.equals("ImageView")) break;
                    n = 1;
                    break block43;
                }
                case 799298502: {
                    if (!var2_22.equals("ToggleButton")) break;
                    n = 13;
                    break block43;
                }
                case 776382189: {
                    if (!var2_22.equals("RadioButton")) break;
                    n = 7;
                    break block43;
                }
                case -339785223: {
                    if (!var2_22.equals("Spinner")) break;
                    n = 4;
                    break block43;
                }
                case -658531749: {
                    if (!var2_22.equals("SeekBar")) break;
                    n = 12;
                    break block43;
                }
                case -937446323: {
                    if (!var2_22.equals("ImageButton")) break;
                    n = 5;
                    break block43;
                }
                case -938935918: {
                    if (!var2_22.equals("TextView")) break;
                    n = 0;
                    break block43;
                }
                case -1346021293: {
                    if (!var2_22.equals("MultiAutoCompleteTextView")) break;
                    n = 10;
                    break block43;
                }
                case -1455429095: {
                    if (!var2_22.equals("CheckedTextView")) break;
                    n = 8;
                    break block43;
                }
                case -1946472170: {
                    if (!var2_22.equals("RatingBar")) break;
                    n = 11;
                    break block43;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                View view = this.createView(context2, (String)var2_22, (AttributeSet)var4_24);
                break;
            }
            case 13: {
                AppCompatToggleButton appCompatToggleButton = this.createToggleButton(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatToggleButton, (String)var2_22);
                break;
            }
            case 12: {
                AppCompatSeekBar appCompatSeekBar = this.createSeekBar(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatSeekBar, (String)var2_22);
                break;
            }
            case 11: {
                AppCompatRatingBar appCompatRatingBar = this.createRatingBar(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatRatingBar, (String)var2_22);
                break;
            }
            case 10: {
                AppCompatMultiAutoCompleteTextView appCompatMultiAutoCompleteTextView = this.createMultiAutoCompleteTextView(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatMultiAutoCompleteTextView, (String)var2_22);
                break;
            }
            case 9: {
                AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = this.createAutoCompleteTextView(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatAutoCompleteTextView, (String)var2_22);
                break;
            }
            case 8: {
                AppCompatCheckedTextView appCompatCheckedTextView = this.createCheckedTextView(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatCheckedTextView, (String)var2_22);
                break;
            }
            case 7: {
                AppCompatRadioButton appCompatRadioButton = this.createRadioButton(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatRadioButton, (String)var2_22);
                break;
            }
            case 6: {
                AppCompatCheckBox appCompatCheckBox = this.createCheckBox(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatCheckBox, (String)var2_22);
                break;
            }
            case 5: {
                AppCompatImageButton appCompatImageButton = this.createImageButton(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatImageButton, (String)var2_22);
                break;
            }
            case 4: {
                AppCompatSpinner appCompatSpinner = this.createSpinner(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatSpinner, (String)var2_22);
                break;
            }
            case 3: {
                AppCompatEditText appCompatEditText = this.createEditText(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatEditText, (String)var2_22);
                break;
            }
            case 2: {
                AppCompatButton appCompatButton = this.createButton(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatButton, (String)var2_22);
                break;
            }
            case 1: {
                AppCompatImageView appCompatImageView = this.createImageView(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatImageView, (String)var2_22);
                break;
            }
            case 0: {
                AppCompatTextView appCompatTextView = this.createTextView(context2, (AttributeSet)var4_24);
                this.verifyNotNull((View)appCompatTextView, (String)var2_22);
            }
        }
        void var11_31 = var1_21;
        if (var1_21 == null) {
            void var11_32 = var1_21;
            if (var3_23 != context2) {
                View view = this.createViewFromTag(context2, (String)var2_22, (AttributeSet)var4_24);
            }
        }
        if (var11_34 != null) {
            this.checkOnClickListener((View)var11_34, (AttributeSet)var4_24);
            this.backportAccessibilityAttributes(context2, (View)var11_34, (AttributeSet)var4_24);
        }
        return var11_34;
    }

    private static class DeclaredOnClickListener
    implements View.OnClickListener {
        private final View mHostView;
        private final String mMethodName;
        private Context mResolvedContext;
        private Method mResolvedMethod;

        public DeclaredOnClickListener(View view, String string2) {
            this.mHostView = view;
            this.mMethodName = string2;
        }

        private void resolveMethod(Context object) {
            while (object != null) {
                block5: {
                    Method method;
                    if (object.isRestricted() || (method = object.getClass().getMethod(this.mMethodName, View.class)) == null) break block5;
                    try {
                        this.mResolvedMethod = method;
                        this.mResolvedContext = object;
                        return;
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        // empty catch block
                    }
                }
                if (object instanceof ContextWrapper) {
                    object = ((ContextWrapper)object).getBaseContext();
                    continue;
                }
                object = null;
            }
            int n = this.mHostView.getId();
            object = n == -1 ? "" : " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(n) + "'";
            throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + (String)object);
        }

        public void onClick(View view) {
            if (this.mResolvedMethod == null) {
                this.resolveMethod(this.mHostView.getContext());
            }
            try {
                this.mResolvedMethod.invoke((Object)this.mResolvedContext, view);
                return;
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new IllegalStateException("Could not execute method for android:onClick", invocationTargetException);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", illegalAccessException);
            }
        }
    }
}

