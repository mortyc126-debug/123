/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.LayoutTransition
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowInsets
 *  android.widget.FrameLayout
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001<B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\"\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0017J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0014J \u0010#\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0017\u0010(\u001a\u0002H)\"\n\b\u0000\u0010)*\u0004\u0018\u00010*\u00a2\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0017J\b\u0010-\u001a\u00020\u0016H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0018\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0016J\u0018\u00104\u001a\u00020\u00162\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0016J\u0010\u00105\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0001J\u0012\u00106\u001a\u00020\u00162\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u000eH\u0016J\u0010\u0010;\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2={"Landroidx/fragment/app/FragmentContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fm", "Landroidx/fragment/app/FragmentManager;", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroidx/fragment/app/FragmentManager;)V", "applyWindowInsetsListener", "Landroid/view/View$OnApplyWindowInsetsListener;", "disappearingFragmentChildren", "", "Landroid/view/View;", "drawDisappearingViewsFirst", "", "transitioningFragmentViews", "addDisappearingFragmentView", "", "v", "addView", "child", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "dispatchApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawChild", "drawingTime", "", "endViewTransition", "view", "getFragment", "F", "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", "onApplyWindowInsets", "removeAllViewsInLayout", "removeView", "removeViewAt", "removeViewInLayout", "removeViews", "start", "count", "removeViewsInLayout", "setDrawDisappearingViewsLast", "setLayoutTransition", "transition", "Landroid/animation/LayoutTransition;", "setOnApplyWindowInsetsListener", "listener", "startViewTransition", "Api20Impl", "fragment_release"}, k=1, mv={1, 6, 0}, xi=48)
public final class FragmentContainerView
extends FrameLayout {
    private View.OnApplyWindowInsetsListener applyWindowInsetsListener;
    private final List<View> disappearingFragmentChildren;
    private boolean drawDisappearingViewsFirst;
    private final List<View> transitioningFragmentViews;

    public FragmentContainerView(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        this(context, attributeSet, 0, 4, null);
    }

    public FragmentContainerView(Context object, AttributeSet object2, int n) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"context");
        super(object, (AttributeSet)object2, n);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        if (object2 != null) {
            String string2 = object2.getClassAttribute();
            String string3 = "class";
            Object object3 = R.styleable.FragmentContainerView;
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"FragmentContainerView");
            object3 = object.obtainStyledAttributes((AttributeSet)object2, object3, 0, 0);
            object = string2;
            object2 = string3;
            if (string2 == null) {
                object = object3.getString(R.styleable.FragmentContainerView_android_name);
                object2 = "android:name";
            }
            object3.recycle();
            if (object != null && !this.isInEditMode()) {
                object2 = new StringBuilder().append("FragmentContainerView must be within a FragmentActivity to use ").append((String)object2);
                object2 = ((StringBuilder)object2).append("=\"");
                throw new UnsupportedOperationException(((StringBuilder)object2).append((String)object).append('\"').toString());
            }
        }
    }

    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            n = 0;
        }
        this(context, attributeSet, n);
    }

    public FragmentContainerView(Context object, AttributeSet attributeSet, FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"context");
        Intrinsics.checkNotNullParameter((Object)attributeSet, (String)"attrs");
        Intrinsics.checkNotNullParameter((Object)fragmentManager, (String)"fm");
        super(object, attributeSet);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        String string2 = attributeSet.getClassAttribute();
        Object object2 = R.styleable.FragmentContainerView;
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"FragmentContainerView");
        Object object3 = object.obtainStyledAttributes(attributeSet, (int[])object2, 0, 0);
        object2 = string2;
        if (string2 == null) {
            object2 = object3.getString(R.styleable.FragmentContainerView_android_name);
        }
        string2 = object3.getString(R.styleable.FragmentContainerView_android_tag);
        object3.recycle();
        int n = this.getId();
        object3 = fragmentManager.findFragmentById(n);
        if (object2 != null && object3 == null) {
            if (n == -1) {
                object = string2 != null ? " with tag " + string2 : "";
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + (String)object2 + (String)object);
            }
            object2 = fragmentManager.getFragmentFactory().instantiate(object.getClassLoader(), (String)object2);
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"fm.fragmentFactory.insta\u2026ontext.classLoader, name)");
            ((Fragment)object2).onInflate((Context)object, attributeSet, null);
            fragmentManager.beginTransaction().setReorderingAllowed(true).add((ViewGroup)this, (Fragment)object2, string2).commitNowAllowingStateLoss();
        }
        fragmentManager.onContainerAvailable(this);
    }

    private final void addDisappearingFragmentView(View view) {
        if (this.transitioningFragmentViews.contains(view)) {
            this.disappearingFragmentChildren.add(view);
        }
    }

    public void addView(View object, int n, ViewGroup.LayoutParams object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"child");
        if (FragmentManager.getViewFragment((View)object) != null) {
            super.addView((View)object, n, (ViewGroup.LayoutParams)object2);
            return;
        }
        object2 = new StringBuilder().append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
        object = ((StringBuilder)object2).append(object);
        throw new IllegalStateException(((StringBuilder)object).append(" is not associated with a Fragment.").toString().toString());
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter((Object)windowInsets, (String)"insets");
        Object object = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"toWindowInsetsCompat(insets)");
        if (this.applyWindowInsetsListener != null) {
            object = Api20Impl.INSTANCE;
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.applyWindowInsetsListener;
            Intrinsics.checkNotNull((Object)onApplyWindowInsetsListener);
            object = WindowInsetsCompat.toWindowInsetsCompat(((Api20Impl)object).onApplyWindowInsets(onApplyWindowInsetsListener, (View)this, windowInsets));
        } else {
            object = ViewCompat.onApplyWindowInsets((View)this, (WindowInsetsCompat)object);
        }
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"if (applyWindowInsetsLis\u2026, insetsCompat)\n        }");
        if (!((WindowInsetsCompat)object).isConsumed()) {
            int n = this.getChildCount();
            for (int i = 0; i < n; ++i) {
                ViewCompat.dispatchApplyWindowInsets(this.getChildAt(i), (WindowInsetsCompat)object);
            }
        }
        return windowInsets;
    }

    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter((Object)canvas, (String)"canvas");
        if (this.drawDisappearingViewsFirst) {
            Iterator iterator2 = ((Iterable)this.disappearingFragmentChildren).iterator();
            while (iterator2.hasNext()) {
                super.drawChild(canvas, (View)iterator2.next(), this.getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    protected boolean drawChild(Canvas canvas, View view, long l) {
        Intrinsics.checkNotNullParameter((Object)canvas, (String)"canvas");
        Intrinsics.checkNotNullParameter((Object)view, (String)"child");
        if (this.drawDisappearingViewsFirst && ((Collection)this.disappearingFragmentChildren).isEmpty() ^ true && this.disappearingFragmentChildren.contains(view)) {
            return false;
        }
        return super.drawChild(canvas, view, l);
    }

    public void endViewTransition(View view) {
        Intrinsics.checkNotNullParameter((Object)view, (String)"view");
        this.transitioningFragmentViews.remove(view);
        if (this.disappearingFragmentChildren.remove(view)) {
            this.drawDisappearingViewsFirst = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return (F)FragmentManager.findFragmentManager((View)this).findFragmentById(this.getId());
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter((Object)windowInsets, (String)"insets");
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        for (int i = this.getChildCount() - 1; -1 < i; --i) {
            View view = this.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue((Object)view, (String)"view");
            this.addDisappearingFragmentView(view);
        }
        super.removeAllViewsInLayout();
    }

    public void removeView(View view) {
        Intrinsics.checkNotNullParameter((Object)view, (String)"view");
        this.addDisappearingFragmentView(view);
        super.removeView(view);
    }

    public void removeViewAt(int n) {
        View view = this.getChildAt(n);
        Intrinsics.checkNotNullExpressionValue((Object)view, (String)"view");
        this.addDisappearingFragmentView(view);
        super.removeViewAt(n);
    }

    public void removeViewInLayout(View view) {
        Intrinsics.checkNotNullParameter((Object)view, (String)"view");
        this.addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int n, int n2) {
        for (int i = n; i < n + n2; ++i) {
            View view = this.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue((Object)view, (String)"view");
            this.addDisappearingFragmentView(view);
        }
        super.removeViews(n, n2);
    }

    public void removeViewsInLayout(int n, int n2) {
        for (int i = n; i < n + n2; ++i) {
            View view = this.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue((Object)view, (String)"view");
            this.addDisappearingFragmentView(view);
        }
        super.removeViewsInLayout(n, n2);
    }

    public final void setDrawDisappearingViewsLast(boolean bl) {
        this.drawDisappearingViewsFirst = bl;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Intrinsics.checkNotNullParameter((Object)onApplyWindowInsetsListener, (String)"listener");
        this.applyWindowInsetsListener = onApplyWindowInsetsListener;
    }

    public void startViewTransition(View view) {
        Intrinsics.checkNotNullParameter((Object)view, (String)"view");
        if (view.getParent() == this) {
            this.transitioningFragmentViews.add(view);
        }
        super.startViewTransition(view);
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c1\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004\u00a8\u0006\n"}, d2={"Landroidx/fragment/app/FragmentContainerView$Api20Impl;", "", "()V", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "onApplyWindowInsetsListener", "Landroid/view/View$OnApplyWindowInsetsListener;", "v", "Landroid/view/View;", "insets", "fragment_release"}, k=1, mv={1, 6, 0}, xi=48)
    public static final class Api20Impl {
        public static final Api20Impl INSTANCE = new Api20Impl();

        private Api20Impl() {
        }

        public final WindowInsets onApplyWindowInsets(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
            Intrinsics.checkNotNullParameter((Object)onApplyWindowInsetsListener, (String)"onApplyWindowInsetsListener");
            Intrinsics.checkNotNullParameter((Object)view, (String)"v");
            Intrinsics.checkNotNullParameter((Object)windowInsets, (String)"insets");
            onApplyWindowInsetsListener = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            Intrinsics.checkNotNullExpressionValue((Object)onApplyWindowInsetsListener, (String)"onApplyWindowInsetsListe\u2026lyWindowInsets(v, insets)");
            return onApplyWindowInsetsListener;
        }
    }
}

