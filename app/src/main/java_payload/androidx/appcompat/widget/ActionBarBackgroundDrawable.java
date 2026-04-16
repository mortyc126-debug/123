/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.drawable.Drawable
 */
package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

class ActionBarBackgroundDrawable
extends Drawable {
    final ActionBarContainer mContainer;

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.mContainer = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (this.mContainer.mIsSplit) {
            if (this.mContainer.mSplitBackground != null) {
                this.mContainer.mSplitBackground.draw(canvas);
            }
        } else {
            if (this.mContainer.mBackground != null) {
                this.mContainer.mBackground.draw(canvas);
            }
            if (this.mContainer.mStackedBackground != null && this.mContainer.mIsStacked) {
                this.mContainer.mStackedBackground.draw(canvas);
            }
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        if (this.mContainer.mIsSplit) {
            if (this.mContainer.mSplitBackground != null) {
                Api21Impl.getOutline(this.mContainer.mBackground, outline);
            }
        } else if (this.mContainer.mBackground != null) {
            Api21Impl.getOutline(this.mContainer.mBackground, outline);
        }
    }

    public void setAlpha(int n) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        public static void getOutline(Drawable drawable2, Outline outline) {
            drawable2.getOutline(outline);
        }
    }
}

