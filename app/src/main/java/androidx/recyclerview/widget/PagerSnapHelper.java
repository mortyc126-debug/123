/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.animation.Interpolator
 */
package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

public class PagerSnapHelper
extends SnapHelper {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    private OrientationHelper mHorizontalHelper;
    private OrientationHelper mVerticalHelper;

    private int distanceToCenter(RecyclerView.LayoutManager layoutManager, View view, OrientationHelper orientationHelper) {
        return orientationHelper.getDecoratedStart(view) + orientationHelper.getDecoratedMeasurement(view) / 2 - (orientationHelper.getStartAfterPadding() + orientationHelper.getTotalSpace() / 2);
    }

    private View findCenterView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int n = layoutManager.getChildCount();
        if (n == 0) {
            return null;
        }
        View view = null;
        int n2 = orientationHelper.getStartAfterPadding();
        int n3 = orientationHelper.getTotalSpace() / 2;
        int n4 = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            View view2 = layoutManager.getChildAt(i);
            int n5 = Math.abs(orientationHelper.getDecoratedStart(view2) + orientationHelper.getDecoratedMeasurement(view2) / 2 - (n2 + n3));
            int n6 = n4;
            if (n5 < n4) {
                n6 = n5;
                view = view2;
            }
            n4 = n6;
        }
        return view;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.mHorizontalHelper == null || this.mHorizontalHelper.mLayoutManager != layoutManager) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.mHorizontalHelper;
    }

    private OrientationHelper getOrientationHelper(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return this.getVerticalHelper(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return this.getHorizontalHelper(layoutManager);
        }
        return null;
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.mVerticalHelper == null || this.mVerticalHelper.mLayoutManager != layoutManager) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.mVerticalHelper;
    }

    private boolean isForwardFling(RecyclerView.LayoutManager layoutManager, int n, int n2) {
        boolean bl = layoutManager.canScrollHorizontally();
        boolean bl2 = true;
        boolean bl3 = true;
        if (bl) {
            if (n <= 0) {
                bl3 = false;
            }
            return bl3;
        }
        bl3 = n2 > 0 ? bl2 : false;
        return bl3;
    }

    private boolean isReverseLayout(RecyclerView.LayoutManager layoutManager) {
        int n = layoutManager.getItemCount();
        boolean bl = layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider;
        boolean bl2 = false;
        if (bl && (layoutManager = ((RecyclerView.SmoothScroller.ScrollVectorProvider)((Object)layoutManager)).computeScrollVectorForPosition(n - 1)) != null) {
            if (((PointF)layoutManager).x < 0.0f || ((PointF)layoutManager).y < 0.0f) {
                bl2 = true;
            }
            return bl2;
        }
        return false;
    }

    @Override
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] nArray = new int[]{layoutManager.canScrollHorizontally() ? this.distanceToCenter(layoutManager, view, this.getHorizontalHelper(layoutManager)) : 0, layoutManager.canScrollVertically() ? this.distanceToCenter(layoutManager, view, this.getVerticalHelper(layoutManager)) : 0};
        return nArray;
    }

    @Override
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new LinearSmoothScroller(this, this.mRecyclerView.getContext()){
            final PagerSnapHelper this$0;
            {
                this.this$0 = pagerSnapHelper;
                super(context);
            }

            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / (float)displayMetrics.densityDpi;
            }

            @Override
            protected int calculateTimeForScrolling(int n) {
                return Math.min(100, super.calculateTimeForScrolling(n));
            }

            @Override
            protected void onTargetFound(View object, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                object = this.this$0.calculateDistanceToFinalSnap(this.this$0.mRecyclerView.getLayoutManager(), (View)object);
                View view = object[0];
                View view2 = object[1];
                int n = this.calculateTimeForDeceleration(Math.max(Math.abs((int)view), Math.abs((int)view2)));
                if (n > 0) {
                    action.update((int)view, (int)view2, n, (Interpolator)this.mDecelerateInterpolator);
                }
            }
        };
    }

    @Override
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return this.findCenterView(layoutManager, this.getVerticalHelper(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return this.findCenterView(layoutManager, this.getHorizontalHelper(layoutManager));
        }
        return null;
    }

    @Override
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int n, int n2) {
        int n3 = layoutManager.getItemCount();
        if (n3 == 0) {
            return -1;
        }
        OrientationHelper orientationHelper = this.getOrientationHelper(layoutManager);
        if (orientationHelper == null) {
            return -1;
        }
        View view = null;
        int n4 = Integer.MIN_VALUE;
        View view2 = null;
        int n5 = Integer.MAX_VALUE;
        int n6 = layoutManager.getChildCount();
        for (int i = 0; i < n6; ++i) {
            int n7;
            View view3;
            View view4 = layoutManager.getChildAt(i);
            if (view4 == null) {
                view3 = view2;
                n7 = n5;
            } else {
                int n8 = this.distanceToCenter(layoutManager, view4, orientationHelper);
                View view5 = view;
                int n9 = n4;
                if (n8 <= 0) {
                    view5 = view;
                    n9 = n4;
                    if (n8 > n4) {
                        n9 = n8;
                        view5 = view4;
                    }
                }
                view = view5;
                n4 = n9;
                view3 = view2;
                n7 = n5;
                if (n8 >= 0) {
                    view = view5;
                    n4 = n9;
                    view3 = view2;
                    n7 = n5;
                    if (n8 < n5) {
                        n7 = n8;
                        view3 = view4;
                        n4 = n9;
                        view = view5;
                    }
                }
            }
            view2 = view3;
            n5 = n7;
        }
        boolean bl = this.isForwardFling(layoutManager, n, n2);
        if (bl && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (!bl && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!bl) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        n2 = layoutManager.getPosition(view);
        n = this.isReverseLayout(layoutManager) == bl ? -1 : 1;
        if ((n += n2) >= 0 && n < n3) {
            return n;
        }
        return -1;
    }
}

