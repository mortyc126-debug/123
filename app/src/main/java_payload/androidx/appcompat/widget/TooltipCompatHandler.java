/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnHoverListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewConfiguration
 *  android.view.accessibility.AccessibilityManager
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.TooltipCompatHandler$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.TooltipCompatHandler$$ExternalSyntheticLambda1;
import androidx.appcompat.widget.TooltipPopup;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class TooltipCompatHandler
implements View.OnLongClickListener,
View.OnHoverListener,
View.OnAttachStateChangeListener {
    private static final long HOVER_HIDE_TIMEOUT_MS = 15000L;
    private static final long HOVER_HIDE_TIMEOUT_SHORT_MS = 3000L;
    private static final long LONG_CLICK_HIDE_TIMEOUT_MS = 2500L;
    private static final String TAG = "TooltipCompatHandler";
    private static TooltipCompatHandler sActiveHandler;
    private static TooltipCompatHandler sPendingHandler;
    private final View mAnchor;
    private int mAnchorX;
    private int mAnchorY;
    private boolean mForceNextChangeSignificant;
    private boolean mFromTouch;
    private final Runnable mHideRunnable;
    private final int mHoverSlop;
    private TooltipPopup mPopup;
    private final Runnable mShowRunnable = new TooltipCompatHandler$$ExternalSyntheticLambda0(this);
    private final CharSequence mTooltipText;

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        this.mHideRunnable = new TooltipCompatHandler$$ExternalSyntheticLambda1(this);
        this.mAnchor = view;
        this.mTooltipText = charSequence;
        this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get((Context)this.mAnchor.getContext()));
        this.forceNextChangeSignificant();
        this.mAnchor.setOnLongClickListener((View.OnLongClickListener)this);
        this.mAnchor.setOnHoverListener((View.OnHoverListener)this);
    }

    private void cancelPendingShow() {
        this.mAnchor.removeCallbacks(this.mShowRunnable);
    }

    private void forceNextChangeSignificant() {
        this.mForceNextChangeSignificant = true;
    }

    private void scheduleShow() {
        this.mAnchor.postDelayed(this.mShowRunnable, (long)ViewConfiguration.getLongPressTimeout());
    }

    private static void setPendingHandler(TooltipCompatHandler tooltipCompatHandler) {
        if (sPendingHandler != null) {
            sPendingHandler.cancelPendingShow();
        }
        if ((sPendingHandler = tooltipCompatHandler) != null) {
            sPendingHandler.scheduleShow();
        }
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        if (sPendingHandler != null && TooltipCompatHandler.sPendingHandler.mAnchor == view) {
            TooltipCompatHandler.setPendingHandler(null);
        }
        if (TextUtils.isEmpty((CharSequence)charSequence)) {
            if (sActiveHandler != null && TooltipCompatHandler.sActiveHandler.mAnchor == view) {
                sActiveHandler.hide();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
        } else {
            new TooltipCompatHandler(view, charSequence);
        }
    }

    private boolean updateAnchorPos(MotionEvent motionEvent) {
        int n = (int)motionEvent.getX();
        int n2 = (int)motionEvent.getY();
        if (!this.mForceNextChangeSignificant && Math.abs(n - this.mAnchorX) <= this.mHoverSlop && Math.abs(n2 - this.mAnchorY) <= this.mHoverSlop) {
            return false;
        }
        this.mAnchorX = n;
        this.mAnchorY = n2;
        this.mForceNextChangeSignificant = false;
        return true;
    }

    void hide() {
        if (sActiveHandler == this) {
            sActiveHandler = null;
            if (this.mPopup != null) {
                this.mPopup.hide();
                this.mPopup = null;
                this.forceNextChangeSignificant();
                this.mAnchor.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
            } else {
                Log.e((String)TAG, (String)"sActiveHandler.mPopup == null");
            }
        }
        if (sPendingHandler == this) {
            TooltipCompatHandler.setPendingHandler(null);
        }
        this.mAnchor.removeCallbacks(this.mHideRunnable);
    }

    /* synthetic */ void lambda$new$0$androidx-appcompat-widget-TooltipCompatHandler() {
        this.show(false);
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.mPopup != null && this.mFromTouch) {
            return false;
        }
        view = (AccessibilityManager)this.mAnchor.getContext().getSystemService("accessibility");
        if (view.isEnabled() && view.isTouchExplorationEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            default: {
                break;
            }
            case 10: {
                this.forceNextChangeSignificant();
                this.hide();
                break;
            }
            case 7: {
                if (!this.mAnchor.isEnabled() || this.mPopup != null || !this.updateAnchorPos(motionEvent)) break;
                TooltipCompatHandler.setPendingHandler(this);
            }
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.mAnchorX = view.getWidth() / 2;
        this.mAnchorY = view.getHeight() / 2;
        this.show(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.hide();
    }

    void show(boolean bl) {
        if (!ViewCompat.isAttachedToWindow(this.mAnchor)) {
            return;
        }
        TooltipCompatHandler.setPendingHandler(null);
        if (sActiveHandler != null) {
            sActiveHandler.hide();
        }
        sActiveHandler = this;
        this.mFromTouch = bl;
        this.mPopup = new TooltipPopup(this.mAnchor.getContext());
        this.mPopup.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
        this.mAnchor.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        long l = this.mFromTouch ? 2500L : ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 1) == 1 ? 3000L - (long)ViewConfiguration.getLongPressTimeout() : 15000L - (long)ViewConfiguration.getLongPressTimeout());
        this.mAnchor.removeCallbacks(this.mHideRunnable);
        this.mAnchor.postDelayed(this.mHideRunnable, l);
    }
}

