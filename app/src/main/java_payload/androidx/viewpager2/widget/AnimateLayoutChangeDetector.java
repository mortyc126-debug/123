/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.LayoutTransition
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Arrays;
import java.util.Comparator;

final class AnimateLayoutChangeDetector {
    private static final ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS = new ViewGroup.MarginLayoutParams(-1, -1);
    private LinearLayoutManager mLayoutManager;

    static {
        ZERO_MARGIN_LAYOUT_PARAMS.setMargins(0, 0, 0, 0);
    }

    AnimateLayoutChangeDetector(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    private boolean arePagesLaidOutContiguously() {
        int n;
        int n2 = this.mLayoutManager.getChildCount();
        if (n2 == 0) {
            return true;
        }
        int n3 = this.mLayoutManager.getOrientation() == 0 ? 1 : 0;
        int[][] nArray = new int[n2][2];
        for (n = 0; n < n2; ++n) {
            View view = this.mLayoutManager.getChildAt(n);
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams)layoutParams : ZERO_MARGIN_LAYOUT_PARAMS;
                int[] nArray2 = nArray[n];
                int n4 = n3 != 0 ? view.getLeft() - layoutParams.leftMargin : view.getTop() - layoutParams.topMargin;
                nArray2[0] = n4;
                nArray2 = nArray[n];
                n4 = n3 != 0 ? view.getRight() + layoutParams.rightMargin : view.getBottom() + layoutParams.bottomMargin;
                nArray2[1] = n4;
                continue;
            }
            throw new IllegalStateException("null view contained in the view hierarchy");
        }
        Arrays.sort(nArray, new Comparator<int[]>(this){
            final AnimateLayoutChangeDetector this$0;
            {
                this.this$0 = animateLayoutChangeDetector;
            }

            @Override
            public int compare(int[] nArray, int[] nArray2) {
                return nArray[0] - nArray2[0];
            }
        });
        for (n3 = 1; n3 < n2; ++n3) {
            if (nArray[n3 - 1][1] == nArray[n3][0]) continue;
            return false;
        }
        n3 = nArray[0][1];
        n = nArray[0][0];
        return nArray[0][0] <= 0 && nArray[n2 - 1][1] >= n3 - n;
        {
        }
    }

    private boolean hasRunningChangingLayoutTransition() {
        int n = this.mLayoutManager.getChildCount();
        for (int i = 0; i < n; ++i) {
            if (!AnimateLayoutChangeDetector.hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(i))) continue;
            return true;
        }
        return false;
    }

    private static boolean hasRunningChangingLayoutTransition(View view) {
        if (view instanceof ViewGroup) {
            LayoutTransition layoutTransition = (view = (ViewGroup)view).getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int n = view.getChildCount();
            for (int i = 0; i < n; ++i) {
                if (!AnimateLayoutChangeDetector.hasRunningChangingLayoutTransition(view.getChildAt(i))) continue;
                return true;
            }
        }
        return false;
    }

    boolean mayHaveInterferingAnimations() {
        boolean bl = this.arePagesLaidOutContiguously();
        boolean bl2 = true;
        if (bl && this.mLayoutManager.getChildCount() > 1 || !this.hasRunningChangingLayoutTransition()) {
            bl2 = false;
        }
        return bl2;
    }
}

