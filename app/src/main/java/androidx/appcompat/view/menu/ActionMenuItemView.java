/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.widget.Button
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;

public class ActionMenuItemView
extends AppCompatTextView
implements MenuView.ItemView,
View.OnClickListener,
ActionMenuView.ActionMenuChildView {
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private Drawable mIcon;
    MenuItemImpl mItemData;
    MenuBuilder.ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    PopupCallback mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        Resources resources = context.getResources();
        this.mAllowTextWithIcon = this.shouldAllowTextWithIcon();
        context = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, n, 0);
        this.mMinWidth = context.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        context.recycle();
        this.mMaxIconSize = (int)(32.0f * resources.getDisplayMetrics().density + 0.5f);
        this.setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        this.setSaveEnabled(false);
    }

    private boolean shouldAllowTextWithIcon() {
        Configuration configuration2 = this.getContext().getResources().getConfiguration();
        int n = configuration2.screenWidthDp;
        int n2 = configuration2.screenHeightDp;
        boolean bl = n >= 480 || n >= 640 && n2 >= 480 || configuration2.orientation == 2;
        return bl;
    }

    private void updateTextButtonVisibility() {
        boolean bl = TextUtils.isEmpty((CharSequence)this.mTitle);
        boolean bl2 = true;
        if (!(this.mIcon == null || this.mItemData.showsTextAsAction() && (this.mAllowTextWithIcon || this.mExpandedFormat))) {
            bl2 = false;
        }
        bl2 = (bl ^ true) & bl2;
        Object var4_3 = null;
        CharSequence charSequence = bl2 ? this.mTitle : null;
        this.setText(charSequence);
        charSequence = this.mItemData.getContentDescription();
        if (TextUtils.isEmpty((CharSequence)charSequence)) {
            charSequence = bl2 ? null : this.mItemData.getTitle();
            this.setContentDescription(charSequence);
        } else {
            this.setContentDescription(charSequence);
        }
        charSequence = this.mItemData.getTooltipText();
        if (TextUtils.isEmpty((CharSequence)charSequence)) {
            charSequence = bl2 ? var4_3 : this.mItemData.getTitle();
            TooltipCompat.setTooltipText((View)this, charSequence);
        } else {
            TooltipCompat.setTooltipText((View)this, charSequence);
        }
    }

    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public boolean hasText() {
        return TextUtils.isEmpty((CharSequence)this.getText()) ^ true;
    }

    @Override
    public void initialize(MenuItemImpl menuItemImpl, int n) {
        this.mItemData = menuItemImpl;
        this.setIcon(menuItemImpl.getIcon());
        this.setTitle(menuItemImpl.getTitleForItemView(this));
        this.setId(menuItemImpl.getItemId());
        n = menuItemImpl.isVisible() ? 0 : 8;
        this.setVisibility(n);
        this.setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.mForwardingListener == null) {
            this.mForwardingListener = new ActionMenuItemForwardingListener(this);
        }
    }

    @Override
    public boolean needsDividerAfter() {
        return this.hasText();
    }

    @Override
    public boolean needsDividerBefore() {
        boolean bl = this.hasText() && this.mItemData.getIcon() == null;
        return bl;
    }

    public void onClick(View view) {
        if (this.mItemInvoker != null) {
            this.mItemInvoker.invokeItem(this.mItemData);
        }
    }

    public void onConfigurationChanged(Configuration configuration2) {
        super.onConfigurationChanged(configuration2);
        this.mAllowTextWithIcon = this.shouldAllowTextWithIcon();
        this.updateTextButtonVisibility();
    }

    @Override
    protected void onMeasure(int n, int n2) {
        boolean bl = this.hasText();
        if (bl && this.mSavedPaddingLeft >= 0) {
            super.setPadding(this.mSavedPaddingLeft, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
        super.onMeasure(n, n2);
        int n3 = View.MeasureSpec.getMode((int)n);
        n = View.MeasureSpec.getSize((int)n);
        int n4 = this.getMeasuredWidth();
        n = n3 == Integer.MIN_VALUE ? Math.min(n, this.mMinWidth) : this.mMinWidth;
        if (n3 != 0x40000000 && this.mMinWidth > 0 && n4 < n) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)n, (int)0x40000000), n2);
        }
        if (!bl && this.mIcon != null) {
            super.setPadding((this.getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mItemData.hasSubMenu() && this.mForwardingListener != null && this.mForwardingListener.onTouch((View)this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override
    public boolean prefersCondensedTitle() {
        return true;
    }

    @Override
    public void setCheckable(boolean bl) {
    }

    @Override
    public void setChecked(boolean bl) {
    }

    public void setExpandedFormat(boolean bl) {
        if (this.mExpandedFormat != bl) {
            this.mExpandedFormat = bl;
            if (this.mItemData != null) {
                this.mItemData.actionFormatChanged();
            }
        }
    }

    @Override
    public void setIcon(Drawable drawable2) {
        this.mIcon = drawable2;
        if (drawable2 != null) {
            float f;
            int n = drawable2.getIntrinsicWidth();
            int n2 = drawable2.getIntrinsicHeight();
            int n3 = n;
            int n4 = n2;
            if (n > this.mMaxIconSize) {
                f = (float)this.mMaxIconSize / (float)n;
                n3 = this.mMaxIconSize;
                n4 = (int)((float)n2 * f);
            }
            n = n3;
            n2 = n4;
            if (n4 > this.mMaxIconSize) {
                f = (float)this.mMaxIconSize / (float)n4;
                n2 = this.mMaxIconSize;
                n = (int)((float)n3 * f);
            }
            drawable2.setBounds(0, 0, n, n2);
        }
        this.setCompoundDrawables(drawable2, null, null, null);
        this.updateTextButtonVisibility();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.mItemInvoker = itemInvoker;
    }

    public void setPadding(int n, int n2, int n3, int n4) {
        this.mSavedPaddingLeft = n;
        super.setPadding(n, n2, n3, n4);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.mPopupCallback = popupCallback;
    }

    @Override
    public void setShortcut(boolean bl, char c) {
    }

    @Override
    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.updateTextButtonVisibility();
    }

    @Override
    public boolean showsIcon() {
        return true;
    }

    private class ActionMenuItemForwardingListener
    extends ForwardingListener {
        final ActionMenuItemView this$0;

        public ActionMenuItemForwardingListener(ActionMenuItemView actionMenuItemView) {
            this.this$0 = actionMenuItemView;
            super((View)actionMenuItemView);
        }

        @Override
        public ShowableListMenu getPopup() {
            if (this.this$0.mPopupCallback != null) {
                return this.this$0.mPopupCallback.getPopup();
            }
            return null;
        }

        @Override
        protected boolean onForwardingStarted() {
            Object object = this.this$0.mItemInvoker;
            boolean bl = false;
            if (object != null && this.this$0.mItemInvoker.invokeItem(this.this$0.mItemData)) {
                object = this.getPopup();
                boolean bl2 = bl;
                if (object != null) {
                    bl2 = bl;
                    if (object.isShowing()) {
                        bl2 = true;
                    }
                }
                return bl2;
            }
            return false;
        }
    }

    public static abstract class PopupCallback {
        public abstract ShowableListMenu getPopup();
    }
}

