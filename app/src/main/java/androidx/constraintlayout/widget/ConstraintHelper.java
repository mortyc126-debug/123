/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper
extends View {
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds = new int[32];
    private HashMap<Integer, String> mMap = new HashMap();
    protected String mReferenceIds;
    protected boolean mUseViewMeasure = false;
    private View[] mViews = null;
    protected Context myContext;

    public ConstraintHelper(Context context) {
        super(context);
        this.myContext = context;
        this.init(null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.myContext = context;
        this.init(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.myContext = context;
        this.init(attributeSet);
    }

    private void addID(String object) {
        if (object != null && object.length() != 0) {
            int n;
            if (this.myContext == null) {
                return;
            }
            String string2 = object.trim();
            if (this.getParent() instanceof ConstraintLayout) {
                object = (ConstraintLayout)this.getParent();
            }
            if ((n = this.findId(string2)) != 0) {
                this.mMap.put(n, string2);
                this.addRscID(n);
            } else {
                Log.w((String)"ConstraintHelper", (String)("Could not find id of \"" + string2 + "\""));
            }
            return;
        }
    }

    private void addRscID(int n) {
        if (n == this.getId()) {
            return;
        }
        if (this.mCount + 1 > this.mIds.length) {
            this.mIds = Arrays.copyOf(this.mIds, this.mIds.length * 2);
        }
        this.mIds[this.mCount] = n;
        ++this.mCount;
    }

    private int[] convertReferenceString(View object, String object2) {
        String[] stringArray = ((String)object2).split(",");
        object.getContext();
        object2 = new int[stringArray.length];
        int n = 0;
        for (int i = 0; i < stringArray.length; ++i) {
            int n2 = this.findId(stringArray[i].trim());
            int n3 = n;
            if (n2 != 0) {
                object2[n] = n2;
                n3 = n + 1;
            }
            n = n3;
        }
        object = object2;
        if (n != stringArray.length) {
            object = Arrays.copyOf((int[])object2, n);
        }
        return object;
    }

    private int findId(ConstraintLayout constraintLayout, String string2) {
        if (string2 != null && constraintLayout != null) {
            Resources resources = this.myContext.getResources();
            if (resources == null) {
                return 0;
            }
            int n = constraintLayout.getChildCount();
            for (int i = 0; i < n; ++i) {
                View view = constraintLayout.getChildAt(i);
                if (view.getId() == -1) continue;
                String string3 = null;
                try {
                    String string4;
                    string3 = string4 = resources.getResourceEntryName(view.getId());
                }
                catch (Resources.NotFoundException notFoundException) {
                    // empty catch block
                }
                if (!string2.equals(string3)) continue;
                return view.getId();
            }
            return 0;
        }
        return 0;
    }

    private int findId(String string2) {
        int n;
        ConstraintLayout constraintLayout = null;
        if (this.getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout)this.getParent();
        }
        int n2 = n = 0;
        if (this.isInEditMode()) {
            n2 = n;
            if (constraintLayout != null) {
                Object object = constraintLayout.getDesignInformation(0, string2);
                n2 = n;
                if (object instanceof Integer) {
                    n2 = (Integer)object;
                }
            }
        }
        n = n2;
        if (n2 == 0) {
            n = n2;
            if (constraintLayout != null) {
                n = this.findId(constraintLayout, string2);
            }
        }
        n2 = n;
        if (n == 0) {
            try {
                n2 = R.id.class.getField(string2).getInt(null);
            }
            catch (Exception exception) {
                n2 = n;
            }
        }
        n = n2;
        if (n2 == 0) {
            n = this.myContext.getResources().getIdentifier(string2, "id", this.myContext.getPackageName());
        }
        return n;
    }

    public void addView(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e((String)"ConstraintHelper", (String)"Views added to a ConstraintHelper need to have an id");
            return;
        }
        if (view.getParent() == null) {
            Log.e((String)"ConstraintHelper", (String)"Views added to a ConstraintHelper need to have a parent");
            return;
        }
        this.mReferenceIds = null;
        this.addRscID(view.getId());
        this.requestLayout();
    }

    protected void applyLayoutFeatures() {
        ViewParent viewParent = this.getParent();
        if (viewParent != null && viewParent instanceof ConstraintLayout) {
            this.applyLayoutFeatures((ConstraintLayout)viewParent);
        }
    }

    protected void applyLayoutFeatures(ConstraintLayout constraintLayout) {
        int n = this.getVisibility();
        float f = this.getElevation();
        for (int i = 0; i < this.mCount; ++i) {
            View view = constraintLayout.getViewById(this.mIds[i]);
            if (view == null) continue;
            view.setVisibility(n);
            if (!(f > 0.0f)) continue;
            view.setTranslationZ(view.getTranslationZ() + f);
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    protected View[] getViews(ConstraintLayout constraintLayout) {
        if (this.mViews == null || this.mViews.length != this.mCount) {
            this.mViews = new View[this.mCount];
        }
        for (int i = 0; i < this.mCount; ++i) {
            int n = this.mIds[i];
            this.mViews[i] = constraintLayout.getViewById(n);
        }
        return this.mViews;
    }

    protected void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int n = attributeSet.getIndexCount();
            for (int i = 0; i < n; ++i) {
                int n2 = attributeSet.getIndex(i);
                if (n2 != R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) continue;
                this.mReferenceIds = attributeSet.getString(n2);
                this.setIds(this.mReferenceIds);
            }
        }
    }

    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams object, SparseArray<ConstraintWidget> sparseArray) {
        if (constraint.layout.mReferenceIds != null) {
            this.setReferencedIds(constraint.layout.mReferenceIds);
        } else if (constraint.layout.mReferenceIdString != null && constraint.layout.mReferenceIdString.length() > 0) {
            constraint.layout.mReferenceIds = this.convertReferenceString(this, constraint.layout.mReferenceIdString);
        }
        helperWidget.removeAllIds();
        if (constraint.layout.mReferenceIds != null) {
            for (int i = 0; i < constraint.layout.mReferenceIds.length; ++i) {
                object = (ConstraintWidget)sparseArray.get(constraint.layout.mReferenceIds[i]);
                if (object == null) continue;
                helperWidget.add((ConstraintWidget)object);
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mReferenceIds != null) {
            this.setIds(this.mReferenceIds);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    protected void onMeasure(int n, int n2) {
        if (this.mUseViewMeasure) {
            super.onMeasure(n, n2);
        } else {
            this.setMeasuredDimension(0, 0);
        }
    }

    public void removeView(View view) {
        int n = view.getId();
        if (n == -1) {
            return;
        }
        this.mReferenceIds = null;
        for (int i = 0; i < this.mCount; ++i) {
            if (this.mIds[i] != n) continue;
            while (i < this.mCount - 1) {
                this.mIds[i] = this.mIds[i + 1];
                ++i;
            }
            this.mIds[this.mCount - 1] = 0;
            --this.mCount;
            break;
        }
        this.requestLayout();
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean bl) {
    }

    protected void setIds(String string2) {
        this.mReferenceIds = string2;
        if (string2 == null) {
            return;
        }
        int n = 0;
        this.mCount = 0;
        while (true) {
            int n2;
            if ((n2 = string2.indexOf(44, n)) == -1) {
                this.addID(string2.substring(n));
                return;
            }
            this.addID(string2.substring(n, n2));
            n = n2 + 1;
        }
    }

    public void setReferencedIds(int[] nArray) {
        this.mReferenceIds = null;
        this.mCount = 0;
        for (int i = 0; i < nArray.length; ++i) {
            this.addRscID(nArray[i]);
        }
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    public void updatePreLayout(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
        helper.removeAllIds();
        for (int i = 0; i < this.mCount; ++i) {
            helper.add((ConstraintWidget)sparseArray.get(this.mIds[i]));
        }
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        if (this.isInEditMode()) {
            this.setIds(this.mReferenceIds);
        }
        if (this.mHelperWidget == null) {
            return;
        }
        this.mHelperWidget.removeAllIds();
        for (int i = 0; i < this.mCount; ++i) {
            View view;
            int n = this.mIds[i];
            View view2 = view = constraintLayout.getViewById(n);
            if (view == null) {
                String string2 = this.mMap.get(n);
                n = this.findId(constraintLayout, string2);
                view2 = view;
                if (n != 0) {
                    this.mIds[i] = n;
                    this.mMap.put(n, string2);
                    view2 = constraintLayout.getViewById(n);
                }
            }
            if (view2 == null) continue;
            this.mHelperWidget.add(constraintLayout.getViewWidget(view2));
        }
        this.mHelperWidget.updateConstraints(constraintLayout.mLayoutWidget);
    }

    public void validateParams() {
        if (this.mHelperWidget == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams)layoutParams).widget = (ConstraintWidget)((Object)this.mHelperWidget);
        }
    }
}

