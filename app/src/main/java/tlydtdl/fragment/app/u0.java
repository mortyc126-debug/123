package tlydtdl.fragment.app;

import amuvvoafs.content.Context;
import amuvvoafs.content.res.TypedArray;
import amuvvoafs.util.AttributeSet;
import amuvvoafs.util.Log;
import amuvvoafs.view.LayoutInflater;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import tlydtdl.fragment.app.Fragment;
import u7.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 implements LayoutInflater.Factory2 {
    public final k1 a;

    public u0(k1 k1Var) {
        this.a = k1Var;
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.Fragment$InstantiationException */
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) throws Fragment.InstantiationException {
        boolean zIsAssignableFrom;
        t1 t1VarH;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        k1 k1Var = this.a;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, k1Var);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue((String) null, "class");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t7.a.a);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes.getString(0);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
            String string = typedArrayObtainStyledAttributes.getString(2);
            typedArrayObtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = k0.class.isAssignableFrom(a1.a(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique amuvvoafs:id, amuvvoafs:tag, or have a parent with an id for " + attributeValue);
                    }
                    k0 k0VarD = resourceId != -1 ? k1Var.D(resourceId) : null;
                    if (k0VarD == null && string != null) {
                        k0VarD = k1Var.E(string);
                    }
                    if (k0VarD == null && id != -1) {
                        k0VarD = k1Var.D(id);
                    }
                    if (k0VarD == null) {
                        a1 a1VarK = k1Var.K();
                        context.getClassLoader();
                        k0VarD = k0.instantiate(a1VarK.a.x.b, attributeValue, null);
                        k0VarD.mFromLayout = true;
                        k0VarD.mFragmentId = resourceId != 0 ? resourceId : id;
                        k0VarD.mContainerId = id;
                        k0VarD.mTag = string;
                        k0VarD.mInLayout = true;
                        k0VarD.mFragmentManager = k1Var;
                        s0 s0Var = k1Var.x;
                        k0VarD.mHost = s0Var;
                        k0VarD.onInflate((Context) s0Var.b, attributeSet, k0VarD.mSavedFragmentState);
                        t1VarH = k1Var.a(k0VarD);
                        if (k1.N(2)) {
                            Log.v("FragmentManager", "Fragment " + k0VarD + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (k0VarD.mInLayout) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                        }
                        k0VarD.mInLayout = true;
                        k0VarD.mFragmentManager = k1Var;
                        s0 s0Var2 = k1Var.x;
                        k0VarD.mHost = s0Var2;
                        k0VarD.onInflate((Context) s0Var2.b, attributeSet, k0VarD.mSavedFragmentState);
                        t1VarH = k1Var.h(k0VarD);
                        if (k1.N(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + k0VarD + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    b.d(k0VarD, viewGroup);
                    k0VarD.mContainer = viewGroup;
                    t1VarH.k();
                    t1VarH.j();
                    View view2 = k0VarD.mView;
                    if (view2 == null) {
                        throw new IllegalStateException(i.n("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (k0VarD.mView.getTag() == null) {
                        k0VarD.mView.setTag(string);
                    }
                    k0VarD.mView.addOnAttachStateChangeListener(new t0(this, t1VarH));
                    return k0VarD.mView;
                }
            }
        }
        return null;
    }
}
