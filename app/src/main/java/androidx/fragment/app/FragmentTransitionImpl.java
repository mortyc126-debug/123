/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class FragmentTransitionImpl {
    protected static void bfsAddViewChildren(List<View> list, View view) {
        int n = list.size();
        if (FragmentTransitionImpl.containedBeforeIndex(list, view, n)) {
            return;
        }
        if (ViewCompat.getTransitionName(view) != null) {
            list.add(view);
        }
        for (int i = n; i < list.size(); ++i) {
            view = list.get(i);
            if (!(view instanceof ViewGroup)) continue;
            view = (ViewGroup)view;
            int n2 = view.getChildCount();
            for (int j = 0; j < n2; ++j) {
                View view2 = view.getChildAt(j);
                if (FragmentTransitionImpl.containedBeforeIndex(list, view2, n) || ViewCompat.getTransitionName(view2) == null) continue;
                list.add(view2);
            }
        }
    }

    private static boolean containedBeforeIndex(List<View> list, View view, int n) {
        for (int i = 0; i < n; ++i) {
            if (list.get(i) != view) continue;
            return true;
        }
        return false;
    }

    protected static boolean isNullOrEmpty(List list) {
        boolean bl = list == null || list.isEmpty();
        return bl;
    }

    public abstract void addTarget(Object var1, View var2);

    public abstract void addTargets(Object var1, ArrayList<View> var2);

    public abstract void beginDelayedTransition(ViewGroup var1, Object var2);

    public abstract boolean canHandle(Object var1);

    public abstract Object cloneTransition(Object var1);

    protected void getBoundsOnScreen(View view, Rect rect) {
        if (!ViewCompat.isAttachedToWindow(view)) {
            return;
        }
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, (float)view.getWidth(), (float)view.getHeight());
        view.getMatrix().mapRect(rectF);
        rectF.offset((float)view.getLeft(), (float)view.getTop());
        Object object = view.getParent();
        while (object instanceof View) {
            object = (View)object;
            rectF.offset((float)(-object.getScrollX()), (float)(-object.getScrollY()));
            object.getMatrix().mapRect(rectF);
            rectF.offset((float)object.getLeft(), (float)object.getTop());
            object = object.getParent();
        }
        object = new int[2];
        view.getRootView().getLocationOnScreen((int[])object);
        rectF.offset((float)object[0], (float)object[1]);
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public abstract Object mergeTransitionsInSequence(Object var1, Object var2, Object var3);

    public abstract Object mergeTransitionsTogether(Object var1, Object var2, Object var3);

    ArrayList<String> prepareSetNameOverridesReordered(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<String>();
        int n = arrayList.size();
        for (int i = 0; i < n; ++i) {
            View view = arrayList.get(i);
            arrayList2.add(ViewCompat.getTransitionName(view));
            ViewCompat.setTransitionName(view, null);
        }
        return arrayList2;
    }

    public abstract void removeTarget(Object var1, View var2);

    public abstract void replaceTargets(Object var1, ArrayList<View> var2, ArrayList<View> var3);

    public abstract void scheduleHideFragmentView(Object var1, View var2, ArrayList<View> var3);

    public abstract void scheduleRemoveTargets(Object var1, Object var2, ArrayList<View> var3, Object var4, ArrayList<View> var5, Object var6, ArrayList<View> var7);

    public abstract void setEpicenter(Object var1, Rect var2);

    public abstract void setEpicenter(Object var1, View var2);

    public void setListenerForTransitionEnd(Fragment fragment, Object object, CancellationSignal cancellationSignal, Runnable runnable2) {
        runnable2.run();
    }

    void setNameOverridesReordered(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map2) {
        int n = arrayList2.size();
        ArrayList<String> arrayList4 = new ArrayList<String>();
        block0: for (int i = 0; i < n; ++i) {
            Object object = arrayList.get(i);
            String string2 = ViewCompat.getTransitionName((View)object);
            arrayList4.add(string2);
            if (string2 == null) continue;
            ViewCompat.setTransitionName((View)object, null);
            object = map2.get(string2);
            for (int j = 0; j < n; ++j) {
                if (!((String)object).equals(arrayList3.get(j))) continue;
                ViewCompat.setTransitionName(arrayList2.get(j), string2);
                continue block0;
            }
        }
        OneShotPreDrawListener.add(view, new Runnable(this, n, arrayList2, arrayList3, arrayList, arrayList4){
            final FragmentTransitionImpl this$0;
            final ArrayList val$inNames;
            final int val$numSharedElements;
            final ArrayList val$outNames;
            final ArrayList val$sharedElementsIn;
            final ArrayList val$sharedElementsOut;
            {
                this.this$0 = fragmentTransitionImpl;
                this.val$numSharedElements = n;
                this.val$sharedElementsIn = arrayList;
                this.val$inNames = arrayList2;
                this.val$sharedElementsOut = arrayList3;
                this.val$outNames = arrayList4;
            }

            @Override
            public void run() {
                for (int i = 0; i < this.val$numSharedElements; ++i) {
                    ViewCompat.setTransitionName((View)this.val$sharedElementsIn.get(i), (String)this.val$inNames.get(i));
                    ViewCompat.setTransitionName((View)this.val$sharedElementsOut.get(i), (String)this.val$outNames.get(i));
                }
            }
        });
    }

    public abstract void setSharedElementTargets(Object var1, View var2, ArrayList<View> var3);

    public abstract void swapSharedElementTargets(Object var1, ArrayList<View> var2, ArrayList<View> var3);

    public abstract Object wrapTransitionInSet(Object var1);
}

