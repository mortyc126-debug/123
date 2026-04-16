/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 */
package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public final class MarginPageTransformer
implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(int n) {
        Preconditions.checkArgumentNonnegative(n, "Margin must be non-negative");
        this.mMarginPx = n;
    }

    private ViewPager2 requireViewPager(View view) {
        view = view.getParent();
        ViewParent viewParent = view.getParent();
        if (view instanceof RecyclerView && viewParent instanceof ViewPager2) {
            return (ViewPager2)viewParent;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override
    public void transformPage(View view, float f) {
        ViewPager2 viewPager2 = this.requireViewPager(view);
        f = (float)this.mMarginPx * f;
        if (viewPager2.getOrientation() == 0) {
            if (viewPager2.isRtl()) {
                f = -f;
            }
            view.setTranslationX(f);
        } else {
            view.setTranslationY(f);
        }
    }
}

