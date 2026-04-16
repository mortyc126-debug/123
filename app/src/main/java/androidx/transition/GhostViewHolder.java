/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.transition.GhostViewPort;
import androidx.transition.R;
import androidx.transition.ViewGroupUtils;
import java.util.ArrayList;

class GhostViewHolder
extends FrameLayout {
    private boolean mAttached;
    private ViewGroup mParent;

    GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        this.setClipChildren(false);
        this.mParent = viewGroup;
        this.mParent.setTag(R.id.ghost_view_holder, (Object)this);
        this.mParent.getOverlay().add((View)this);
        this.mAttached = true;
    }

    static GhostViewHolder getHolder(ViewGroup viewGroup) {
        return (GhostViewHolder)((Object)viewGroup.getTag(R.id.ghost_view_holder));
    }

    private int getInsertIndex(ArrayList<View> arrayList) {
        ArrayList<View> arrayList2 = new ArrayList<View>();
        int n = 0;
        int n2 = this.getChildCount() - 1;
        while (n <= n2) {
            int n3 = (n + n2) / 2;
            GhostViewHolder.getParents(((GhostViewPort)this.getChildAt((int)n3)).mView, arrayList2);
            if (GhostViewHolder.isOnTop(arrayList, arrayList2)) {
                n = n3 + 1;
            } else {
                n2 = n3 - 1;
            }
            arrayList2.clear();
        }
        return n;
    }

    private static void getParents(View view, ArrayList<View> arrayList) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof ViewGroup) {
            GhostViewHolder.getParents((View)viewParent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean isOnTop(View view, View view2) {
        boolean bl;
        ViewGroup viewGroup = (ViewGroup)view.getParent();
        int n = viewGroup.getChildCount();
        if (Api21Impl.getZ(view) != Api21Impl.getZ(view2)) {
            boolean bl2 = Api21Impl.getZ(view) > Api21Impl.getZ(view2);
            return bl2;
        }
        boolean bl3 = true;
        int n2 = 0;
        while (true) {
            bl = bl3;
            if (n2 >= n) break;
            View view3 = viewGroup.getChildAt(ViewGroupUtils.getChildDrawingOrder(viewGroup, n2));
            if (view3 == view) {
                bl = false;
                break;
            }
            if (view3 == view2) {
                bl = true;
                break;
            }
            ++n2;
        }
        return bl;
    }

    private static boolean isOnTop(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        boolean bl = arrayList.isEmpty();
        boolean bl2 = true;
        if (!bl && !arrayList2.isEmpty() && arrayList.get(0) == arrayList2.get(0)) {
            int n = Math.min(arrayList.size(), arrayList2.size());
            for (int i = 1; i < n; ++i) {
                View view;
                View view2 = arrayList.get(i);
                if (view2 == (view = arrayList2.get(i))) continue;
                return GhostViewHolder.isOnTop(view2, view);
            }
            if (arrayList2.size() != n) {
                bl2 = false;
            }
            return bl2;
        }
        return true;
    }

    void addGhostView(GhostViewPort ghostViewPort) {
        ArrayList<View> arrayList = new ArrayList<View>();
        GhostViewHolder.getParents(ghostViewPort.mView, arrayList);
        int n = this.getInsertIndex(arrayList);
        if (n >= 0 && n < this.getChildCount()) {
            this.addView((View)ghostViewPort, n);
        } else {
            this.addView((View)ghostViewPort);
        }
    }

    public void onViewAdded(View view) {
        if (this.mAttached) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (this.getChildCount() == 1 && this.getChildAt(0) == view || this.getChildCount() == 0) {
            this.mParent.setTag(R.id.ghost_view_holder, null);
            this.mParent.getOverlay().remove((View)this);
            this.mAttached = false;
        }
    }

    void popToOverlayTop() {
        if (this.mAttached) {
            this.mParent.getOverlay().remove((View)this);
            this.mParent.getOverlay().add((View)this);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static float getZ(View view) {
            return view.getZ();
        }
    }
}

