/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;

class TooltipPopup {
    private static final String TAG = "TooltipPopup";
    private final View mContentView;
    private final Context mContext;
    private final WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();
    private final TextView mMessageView;
    private final int[] mTmpAnchorPos;
    private final int[] mTmpAppPos;
    private final Rect mTmpDisplayFrame = new Rect();

    TooltipPopup(Context context) {
        this.mTmpAnchorPos = new int[2];
        this.mTmpAppPos = new int[2];
        this.mContext = context;
        this.mContentView = LayoutInflater.from((Context)this.mContext).inflate(R.layout.abc_tooltip, null);
        this.mMessageView = (TextView)this.mContentView.findViewById(R.id.message);
        this.mLayoutParams.setTitle((CharSequence)this.getClass().getSimpleName());
        this.mLayoutParams.packageName = this.mContext.getPackageName();
        this.mLayoutParams.type = 1002;
        this.mLayoutParams.width = -2;
        this.mLayoutParams.height = -2;
        this.mLayoutParams.format = -3;
        this.mLayoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        this.mLayoutParams.flags = 24;
    }

    private void computePosition(View object, int n, int n2, boolean bl, WindowManager.LayoutParams layoutParams) {
        int n3;
        layoutParams.token = object.getApplicationWindowToken();
        int n4 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (object.getWidth() < n4) {
            n = object.getWidth() / 2;
        }
        if (object.getHeight() >= n4) {
            n4 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            n3 = n2 + n4;
            n4 = n2 - n4;
            n2 = n3;
        } else {
            n2 = object.getHeight();
            n4 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = this.mContext.getResources();
        n3 = bl ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch;
        int n5 = resources.getDimensionPixelOffset(n3);
        resources = TooltipPopup.getAppRootView(object);
        if (resources == null) {
            Log.e((String)TAG, (String)"Cannot find app view");
            return;
        }
        resources.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
        if (this.mTmpDisplayFrame.left < 0 && this.mTmpDisplayFrame.top < 0) {
            Resources resources2 = this.mContext.getResources();
            n3 = resources2.getIdentifier("status_bar_height", "dimen", "android");
            n3 = n3 != 0 ? resources2.getDimensionPixelSize(n3) : 0;
            resources2 = resources2.getDisplayMetrics();
            this.mTmpDisplayFrame.set(0, n3, resources2.widthPixels, resources2.heightPixels);
        }
        resources.getLocationOnScreen(this.mTmpAppPos);
        object.getLocationOnScreen(this.mTmpAnchorPos);
        object = this.mTmpAnchorPos;
        object[0] = object[0] - this.mTmpAppPos[0];
        object = this.mTmpAnchorPos;
        object[1] = object[1] - this.mTmpAppPos[1];
        layoutParams.x = this.mTmpAnchorPos[0] + n - resources.getWidth() / 2;
        n = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        this.mContentView.measure(n, n);
        n = this.mContentView.getMeasuredHeight();
        n4 = this.mTmpAnchorPos[1] + n4 - n5 - n;
        n2 = this.mTmpAnchorPos[1] + n2 + n5;
        layoutParams.y = bl ? (n4 >= 0 ? n4 : n2) : (n2 + n <= this.mTmpDisplayFrame.height() ? n2 : n4);
    }

    private static View getAppRootView(View view) {
        View view2 = view.getRootView();
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof WindowManager.LayoutParams && ((WindowManager.LayoutParams)layoutParams).type == 2) {
            return view2;
        }
        view = view.getContext();
        while (view instanceof ContextWrapper) {
            if (view instanceof Activity) {
                return ((Activity)view).getWindow().getDecorView();
            }
            view = ((ContextWrapper)view).getBaseContext();
        }
        return view2;
    }

    void hide() {
        if (!this.isShowing()) {
            return;
        }
        ((WindowManager)this.mContext.getSystemService("window")).removeView(this.mContentView);
    }

    boolean isShowing() {
        boolean bl = this.mContentView.getParent() != null;
        return bl;
    }

    void show(View view, int n, int n2, boolean bl, CharSequence charSequence) {
        if (this.isShowing()) {
            this.hide();
        }
        this.mMessageView.setText(charSequence);
        this.computePosition(view, n, n2, bl, this.mLayoutParams);
        ((WindowManager)this.mContext.getSystemService("window")).addView(this.mContentView, (ViewGroup.LayoutParams)this.mLayoutParams);
    }
}

