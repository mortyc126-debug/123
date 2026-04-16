/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.text.Editable
 *  android.text.method.KeyListener
 *  android.util.AttributeSet
 *  android.view.ActionMode$Callback
 *  android.view.DragEvent
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.textclassifier.TextClassifier
 *  android.widget.EditText
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatEmojiEditTextHelper;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.appcompat.widget.AppCompatReceiveContentHelper;
import androidx.appcompat.widget.AppCompatTextClassifierHelper;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.EmojiCompatConfigurationView;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatEditText
extends EditText
implements TintableBackgroundView,
OnReceiveContentViewBehavior,
EmojiCompatConfigurationView,
TintableCompoundDrawablesView {
    private final AppCompatEmojiEditTextHelper mAppCompatEmojiEditTextHelper;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener;
    private SuperCaller mSuperCaller;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int n) {
        super(TintContextWrapper.wrap(context), attributeSet, n);
        ThemeUtils.checkAppCompatTheme((View)this, this.getContext());
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper((View)this);
        this.mBackgroundTintHelper.loadFromAttributes(attributeSet, n);
        this.mTextHelper = new AppCompatTextHelper((TextView)this);
        this.mTextHelper.loadFromAttributes(attributeSet, n);
        this.mTextHelper.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper((TextView)this);
        this.mDefaultOnReceiveContentListener = new TextViewOnReceiveContentListener();
        this.mAppCompatEmojiEditTextHelper = new AppCompatEmojiEditTextHelper(this);
        this.mAppCompatEmojiEditTextHelper.loadFromAttributes(attributeSet, n);
        this.initEmojiKeyListener(this.mAppCompatEmojiEditTextHelper);
    }

    private SuperCaller getSuperCaller() {
        if (this.mSuperCaller == null) {
            this.mSuperCaller = new SuperCaller(this);
        }
        return this.mSuperCaller;
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

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
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

    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    public TextClassifier getTextClassifier() {
        if (Build.VERSION.SDK_INT < 28 && this.mTextClassifierHelper != null) {
            return this.mTextClassifierHelper.getTextClassifier();
        }
        return this.getSuperCaller().getTextClassifier();
    }

    void initEmojiKeyListener(AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper) {
        KeyListener keyListener = this.getKeyListener();
        if (appCompatEmojiEditTextHelper.isEmojiCapableKeyListener(keyListener)) {
            boolean bl = super.isFocusable();
            boolean bl2 = super.isClickable();
            boolean bl3 = super.isLongClickable();
            int n = super.getInputType();
            if ((appCompatEmojiEditTextHelper = appCompatEmojiEditTextHelper.getKeyListener(keyListener)) == keyListener) {
                return;
            }
            super.setKeyListener((KeyListener)appCompatEmojiEditTextHelper);
            super.setRawInputType(n);
            super.setFocusable(bl);
            super.setClickable(bl2);
            super.setLongClickable(bl3);
        }
    }

    @Override
    public boolean isEmojiCompatEnabled() {
        return this.mAppCompatEmojiEditTextHelper.isEnabled();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnection;
        InputConnection inputConnection2 = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.populateSurroundingTextIfNeeded((TextView)this, inputConnection2, editorInfo);
        inputConnection2 = inputConnection = AppCompatHintHelper.onCreateInputConnection(inputConnection2, editorInfo, (View)this);
        if (inputConnection != null) {
            inputConnection2 = inputConnection;
            if (Build.VERSION.SDK_INT <= 30) {
                String[] stringArray = ViewCompat.getOnReceiveContentMimeTypes((View)this);
                inputConnection2 = inputConnection;
                if (stringArray != null) {
                    EditorInfoCompat.setContentMimeTypes(editorInfo, stringArray);
                    inputConnection2 = InputConnectionCompat.createWrapper((View)this, inputConnection, editorInfo);
                }
            }
        }
        return this.mAppCompatEmojiEditTextHelper.onCreateInputConnection(inputConnection2, editorInfo);
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        if (AppCompatReceiveContentHelper.maybeHandleDragEventViaPerformReceiveContent((View)this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override
    public ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent((View)this, contentInfoCompat);
    }

    public boolean onTextContextMenuItem(int n) {
        if (AppCompatReceiveContentHelper.maybeHandleMenuActionViaPerformReceiveContent((TextView)this, n)) {
            return true;
        }
        return super.onTextContextMenuItem(n);
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

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback2) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback((TextView)this, callback2));
    }

    @Override
    public void setEmojiCompatEnabled(boolean bl) {
        this.mAppCompatEmojiEditTextHelper.setEnabled(bl);
    }

    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.getKeyListener(keyListener));
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

    class SuperCaller {
        final AppCompatEditText this$0;

        SuperCaller(AppCompatEditText appCompatEditText) {
            this.this$0 = appCompatEditText;
        }

        public TextClassifier getTextClassifier() {
            return AppCompatEditText.super.getTextClassifier();
        }

        public void setTextClassifier(TextClassifier textClassifier) {
            AppCompatEditText.super.setTextClassifier(textClassifier);
        }
    }
}

