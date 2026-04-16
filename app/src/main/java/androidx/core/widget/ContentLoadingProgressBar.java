/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.widget.ProgressBar
 */
package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.widget.ContentLoadingProgressBar$$ExternalSyntheticLambda0;
import androidx.core.widget.ContentLoadingProgressBar$$ExternalSyntheticLambda1;
import androidx.core.widget.ContentLoadingProgressBar$$ExternalSyntheticLambda2;
import androidx.core.widget.ContentLoadingProgressBar$$ExternalSyntheticLambda3;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ContentLoadingProgressBar
extends ProgressBar {
    private static final int MIN_DELAY_MS = 500;
    private static final int MIN_SHOW_TIME_MS = 500;
    private final Runnable mDelayedHide = new ContentLoadingProgressBar$$ExternalSyntheticLambda2(this);
    private final Runnable mDelayedShow = new ContentLoadingProgressBar$$ExternalSyntheticLambda3(this);
    boolean mDismissed = false;
    boolean mPostedHide = false;
    boolean mPostedShow = false;
    long mStartTime = -1L;

    public static /* synthetic */ void $r8$lambda$Ije3417V0uZgdBrD9pbxQ2_AHiI(ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.hideOnUiThread();
    }

    public static /* synthetic */ void $r8$lambda$tmknj5M20Tn8TaJxR587u-39ZDQ(ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.showOnUiThread();
    }

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    private void hideOnUiThread() {
        this.mDismissed = true;
        this.removeCallbacks(this.mDelayedShow);
        this.mPostedShow = false;
        long l = System.currentTimeMillis() - this.mStartTime;
        if (l < 500L && this.mStartTime != -1L) {
            if (!this.mPostedHide) {
                this.postDelayed(this.mDelayedHide, 500L - l);
                this.mPostedHide = true;
            }
        } else {
            this.setVisibility(8);
        }
    }

    private void removeCallbacks() {
        this.removeCallbacks(this.mDelayedHide);
        this.removeCallbacks(this.mDelayedShow);
    }

    private void showOnUiThread() {
        this.mStartTime = -1L;
        this.mDismissed = false;
        this.removeCallbacks(this.mDelayedHide);
        this.mPostedHide = false;
        if (!this.mPostedShow) {
            this.postDelayed(this.mDelayedShow, 500L);
            this.mPostedShow = true;
        }
    }

    public void hide() {
        this.post(new ContentLoadingProgressBar$$ExternalSyntheticLambda1(this));
    }

    /* synthetic */ void lambda$new$0$androidx-core-widget-ContentLoadingProgressBar() {
        this.mPostedHide = false;
        this.mStartTime = -1L;
        this.setVisibility(8);
    }

    /* synthetic */ void lambda$new$1$androidx-core-widget-ContentLoadingProgressBar() {
        this.mPostedShow = false;
        if (!this.mDismissed) {
            this.mStartTime = System.currentTimeMillis();
            this.setVisibility(0);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.removeCallbacks();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks();
    }

    public void show() {
        this.post(new ContentLoadingProgressBar$$ExternalSyntheticLambda0(this));
    }
}

