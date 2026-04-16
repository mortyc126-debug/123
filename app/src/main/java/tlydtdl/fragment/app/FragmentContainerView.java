package tlydtdl.fragment.app;

import amuvvoafs.animation.LayoutTransition;
import amuvvoafs.content.Context;
import amuvvoafs.content.res.TypedArray;
import amuvvoafs.graphics.Canvas;
import amuvvoafs.os.Bundle;
import amuvvoafs.util.AttributeSet;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import amuvvoafs.view.WindowInsets;
import amuvvoafs.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.internal.o;
import okhttp3.HttpUrl;
import r6.j0;
import r6.z1;
import tlydtdl.compose.foundation.layout.m;
import tlydtdl.fragment.app.Fragment;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00028\u0000\"\n\b\u0000\u0010\u0010*\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Ltlydtdl/fragment/app/FragmentContainerView;", "Lamuvvoafs/widget/FrameLayout;", "Lamuvvoafs/animation/LayoutTransition;", "transition", "Llx1/b0;", "setLayoutTransition", "(Lamuvvoafs/animation/LayoutTransition;)V", "Lamuvvoafs/view/View$OnApplyWindowInsetsListener;", "listener", "setOnApplyWindowInsetsListener", "(Lamuvvoafs/view/View$OnApplyWindowInsetsListener;)V", HttpUrl.FRAGMENT_ENCODE_SET, "drawDisappearingViewsFirst", "setDrawDisappearingViewsLast", "(Z)V", "Ltlydtdl/fragment/app/k0;", "F", "getFragment", "()Ltlydtdl/fragment/app/k0;", "a/a", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = m.g)
public final class FragmentContainerView extends FrameLayout {
    public final ArrayList a;
    public final ArrayList b;
    public View.OnApplyWindowInsetsListener c;
    public boolean d;

    public FragmentContainerView(Context context) {
        super(context);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = true;
    }

    public final void a(View view) {
        if (this.b.contains(view)) {
            this.a.add(view);
        }
    }

    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        o.h(view, "child");
        Object tag = view.getTag(2131427913);
        if ((tag instanceof k0 ? (k0) tag : null) != null) {
            super/*amuvvoafs.view.ViewGroup*/.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        z1 z1VarG;
        o.h(windowInsets, "insets");
        z1 z1VarG2 = z1.g(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.c;
        if (onApplyWindowInsetsListener != null) {
            z1VarG = z1.g(null, a.a.K(onApplyWindowInsetsListener, this, windowInsets));
        } else {
            WeakHashMap weakHashMap = r6.u0.a;
            WindowInsets windowInsetsF = z1VarG2.f();
            if (windowInsetsF != null) {
                WindowInsets windowInsetsB = j0.b(this, windowInsetsF);
                if (!windowInsetsB.equals(windowInsetsF)) {
                    z1VarG2 = z1.g(this, windowInsetsB);
                }
            }
            z1VarG = z1VarG2;
        }
        if (!z1VarG.a.o()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                r6.u0.b(z1VarG, getChildAt(i));
            }
        }
        return windowInsets;
    }

    public final void dispatchDraw(Canvas canvas) {
        o.h(canvas, "canvas");
        if (this.d) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                super/*amuvvoafs.view.ViewGroup*/.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super/*amuvvoafs.view.View*/.dispatchDraw(canvas);
    }

    public final boolean drawChild(Canvas canvas, View view, long j2) {
        o.h(canvas, "canvas");
        o.h(view, "child");
        if (this.d) {
            ArrayList arrayList = this.a;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super/*amuvvoafs.view.ViewGroup*/.drawChild(canvas, view, j2);
    }

    public final void endViewTransition(View view) {
        o.h(view, "view");
        this.b.remove(view);
        if (this.a.remove(view)) {
            this.d = true;
        }
        super/*amuvvoafs.view.ViewGroup*/.endViewTransition(view);
    }

    public final <F extends k0> F getFragment() {
        return (F) k1.F(this).D(getId());
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        o.h(windowInsets, "insets");
        return windowInsets;
    }

    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super/*amuvvoafs.view.ViewGroup*/.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                o.g(childAt, "view");
                a(childAt);
            }
        }
    }

    public final void removeView(View view) {
        o.h(view, "view");
        a(view);
        super/*amuvvoafs.view.ViewGroup*/.removeView(view);
    }

    public final void removeViewAt(int i) {
        View childAt = getChildAt(i);
        o.g(childAt, "view");
        a(childAt);
        super/*amuvvoafs.view.ViewGroup*/.removeViewAt(i);
    }

    public final void removeViewInLayout(View view) {
        o.h(view, "view");
        a(view);
        super/*amuvvoafs.view.ViewGroup*/.removeViewInLayout(view);
    }

    public final void removeViews(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            o.g(childAt, "view");
            a(childAt);
        }
        super/*amuvvoafs.view.ViewGroup*/.removeViews(i, i2);
    }

    public final void removeViewsInLayout(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            o.g(childAt, "view");
            a(childAt);
        }
        super/*amuvvoafs.view.ViewGroup*/.removeViewsInLayout(i, i2);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.d = z;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.c = onApplyWindowInsetsListener;
    }

    public final void startViewTransition(View view) {
        o.h(view, "view");
        if (view.getParent() == this) {
            this.b.add(view);
        }
        super/*amuvvoafs.view.ViewGroup*/.startViewTransition(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        String str;
        super(context, attributeSet, 0);
        o.h(context, "context");
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t7.a.b, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
                str = "amuvvoafs:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.Fragment$InstantiationException */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, k1 k1Var) throws Fragment.InstantiationException {
        View view;
        super(context, attributeSet);
        o.h(context, "context");
        o.h(attributeSet, "attrs");
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t7.a.b, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(0) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(1);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        k0 k0VarD = k1Var.D(id);
        if (classAttribute != null && k0VarD == null) {
            if (id == -1) {
                throw new IllegalStateException(i.n("FragmentContainerView must have an amuvvoafs:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : HttpUrl.FRAGMENT_ENCODE_SET));
            }
            a1 a1VarK = k1Var.K();
            context.getClassLoader();
            k0 k0VarInstantiate = k0.instantiate(a1VarK.a.x.b, classAttribute, null);
            o.g(k0VarInstantiate, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            k0VarInstantiate.mFragmentId = id;
            k0VarInstantiate.mContainerId = id;
            k0VarInstantiate.mTag = string;
            k0VarInstantiate.mFragmentManager = k1Var;
            k0VarInstantiate.mHost = k1Var.x;
            k0VarInstantiate.onInflate(context, attributeSet, (Bundle) null);
            a aVar = new a(k1Var);
            aVar.p = true;
            k0VarInstantiate.mContainer = this;
            k0VarInstantiate.mInDynamicContainer = true;
            aVar.e(getId(), k0VarInstantiate, string, 1);
            if (!aVar.g) {
                aVar.h = false;
                aVar.r.B(aVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        for (t1 t1Var : k1Var.c.d()) {
            k0 k0Var = t1Var.c;
            if (k0Var.mContainerId == getId() && (view = k0Var.mView) != null && view.getParent() == null) {
                k0Var.mContainer = this;
                t1Var.b();
                t1Var.k();
            }
        }
    }
}
