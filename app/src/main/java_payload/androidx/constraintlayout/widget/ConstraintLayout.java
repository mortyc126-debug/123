/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.ConstraintsChangedListener;
import androidx.constraintlayout.widget.Guideline;
import androidx.constraintlayout.widget.Placeholder;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout
extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.1";
    SparseArray<View> mChildrenByIds = new SparseArray();
    private ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList(4);
    protected ConstraintLayoutStates mConstraintLayoutSpec = null;
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    protected ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight;
    private int mMaxWidth = Integer.MAX_VALUE;
    Measurer mMeasurer;
    private Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOnMeasureHeightMeasureSpec = 0;
    private int mOnMeasureWidthMeasureSpec = 0;
    private int mOptimizationLevel = 263;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

    public ConstraintLayout(Context context) {
        super(context);
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.init(null, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.init(attributeSet, n, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.init(attributeSet, n, n2);
    }

    private int getPaddingWidth() {
        int n = Math.max(0, this.getPaddingLeft()) + Math.max(0, this.getPaddingRight());
        int n2 = Math.max(0, this.getPaddingStart()) + Math.max(0, this.getPaddingEnd());
        if (n2 > 0) {
            n = n2;
        }
        return n;
    }

    private final ConstraintWidget getTargetWidget(int n) {
        View view;
        if (n == 0) {
            return this.mLayoutWidget;
        }
        Object object = view = (View)this.mChildrenByIds.get(n);
        if (view == null) {
            object = view = this.findViewById(n);
            if (view != null) {
                object = view;
                if (view != this) {
                    object = view;
                    if (view.getParent() == this) {
                        this.onViewAdded(view);
                        object = view;
                    }
                }
            }
        }
        if (object == this) {
            return this.mLayoutWidget;
        }
        object = object == null ? null : ((LayoutParams)object.getLayoutParams()).widget;
        return object;
    }

    private void init(AttributeSet attributeSet, int n, int n2) {
        this.mLayoutWidget.setCompanionWidget((Object)this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(this.getId(), (Object)this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, n, n2);
            n2 = attributeSet.getIndexCount();
            for (n = 0; n < n2; ++n) {
                int n3 = attributeSet.getIndex(n);
                if (n3 == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = attributeSet.getDimensionPixelOffset(n3, this.mMinWidth);
                    continue;
                }
                if (n3 == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = attributeSet.getDimensionPixelOffset(n3, this.mMinHeight);
                    continue;
                }
                if (n3 == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = attributeSet.getDimensionPixelOffset(n3, this.mMaxWidth);
                    continue;
                }
                if (n3 == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = attributeSet.getDimensionPixelOffset(n3, this.mMaxHeight);
                    continue;
                }
                if (n3 == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = attributeSet.getInt(n3, this.mOptimizationLevel);
                    continue;
                }
                if (n3 == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    if ((n3 = attributeSet.getResourceId(n3, 0)) == 0) continue;
                    try {
                        this.parseLayoutDescription(n3);
                    }
                    catch (Resources.NotFoundException notFoundException) {
                        this.mConstraintLayoutSpec = null;
                    }
                    continue;
                }
                if (n3 != R.styleable.ConstraintLayout_Layout_constraintSet) continue;
                n3 = attributeSet.getResourceId(n3, 0);
                try {
                    ConstraintSet constraintSet;
                    this.mConstraintSet = constraintSet = new ConstraintSet();
                    this.mConstraintSet.load(this.getContext(), n3);
                }
                catch (Resources.NotFoundException notFoundException) {
                    this.mConstraintSet = null;
                }
                this.mConstraintSetId = n3;
            }
            attributeSet.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void setChildrenConstraints() {
        int n;
        View view;
        Object object;
        int n2;
        boolean bl = this.isInEditMode();
        int n3 = this.getChildCount();
        for (n2 = 0; n2 < n3; ++n2) {
            object = this.getViewWidget(this.getChildAt(n2));
            if (object == null) continue;
            ((ConstraintWidget)object).reset();
        }
        if (bl) {
            for (n2 = 0; n2 < n3; ++n2) {
                view = this.getChildAt(n2);
                try {
                    String string2 = this.getResources().getResourceName(view.getId());
                    this.setDesignInformation(0, string2, view.getId());
                    n = string2.indexOf(47);
                    object = string2;
                    if (n != -1) {
                        object = string2.substring(n + 1);
                    }
                    this.getTargetWidget(view.getId()).setDebugName((String)object);
                    continue;
                }
                catch (Resources.NotFoundException notFoundException) {
                    // empty catch block
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (n2 = 0; n2 < n3; ++n2) {
                object = this.getChildAt(n2);
                if (object.getId() != this.mConstraintSetId || !(object instanceof Constraints)) continue;
                this.mConstraintSet = ((Constraints)((Object)object)).getConstraintSet();
            }
        }
        if (this.mConstraintSet != null) {
            this.mConstraintSet.applyToInternal(this, true);
        }
        this.mLayoutWidget.removeAllChildren();
        n = this.mConstraintHelpers.size();
        if (n > 0) {
            for (n2 = 0; n2 < n; ++n2) {
                this.mConstraintHelpers.get(n2).updatePreLayout(this);
            }
        }
        for (n2 = 0; n2 < n3; ++n2) {
            object = this.getChildAt(n2);
            if (!(object instanceof Placeholder)) continue;
            ((Placeholder)((Object)object)).updatePreLayout(this);
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, (Object)this.mLayoutWidget);
        this.mTempMapIdToWidget.put(this.getId(), (Object)this.mLayoutWidget);
        for (n2 = 0; n2 < n3; ++n2) {
            object = this.getChildAt(n2);
            ConstraintWidget constraintWidget = this.getViewWidget((View)object);
            this.mTempMapIdToWidget.put(object.getId(), (Object)constraintWidget);
        }
        n2 = 0;
        while (n2 < n3) {
            view = this.getChildAt(n2);
            object = this.getViewWidget(view);
            if (object != null) {
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                this.mLayoutWidget.add((ConstraintWidget)object);
                this.applyConstraintsFromLayoutParams(bl, view, (ConstraintWidget)object, layoutParams, this.mTempMapIdToWidget);
            }
            ++n2;
        }
        return;
    }

    private boolean updateHierarchy() {
        boolean bl;
        int n = this.getChildCount();
        boolean bl2 = false;
        int n2 = 0;
        while (true) {
            bl = bl2;
            if (n2 >= n) break;
            if (this.getChildAt(n2).isLayoutRequested()) {
                bl = true;
                break;
            }
            ++n2;
        }
        if (bl) {
            this.setChildrenConstraints();
        }
        return bl;
    }

    public void addView(View view, int n, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, n, layoutParams);
    }

    protected void applyConstraintsFromLayoutParams(boolean bl, View object, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> object2) {
        layoutParams.validate();
        layoutParams.helped = false;
        constraintWidget.setVisibility(object.getVisibility());
        if (layoutParams.isInPlaceholder) {
            constraintWidget.setInPlaceholder(true);
            constraintWidget.setVisibility(8);
        }
        constraintWidget.setCompanionWidget(object);
        if (object instanceof ConstraintHelper) {
            ((ConstraintHelper)((Object)object)).resolveRtl(constraintWidget, this.mLayoutWidget.isRtl());
        }
        if (layoutParams.isGuideline) {
            object = (androidx.constraintlayout.solver.widgets.Guideline)constraintWidget;
            int n = layoutParams.resolvedGuideBegin;
            int n2 = layoutParams.resolvedGuideEnd;
            float f = layoutParams.resolvedGuidePercent;
            if (f != -1.0f) {
                object.setGuidePercent(f);
            } else if (n != -1) {
                object.setGuideBegin(n);
            } else if (n2 != -1) {
                object.setGuideEnd(n2);
            }
        } else {
            int n = layoutParams.resolvedLeftToLeft;
            int n3 = layoutParams.resolvedLeftToRight;
            int n4 = layoutParams.resolvedRightToLeft;
            int n5 = layoutParams.resolvedRightToRight;
            int n6 = layoutParams.resolveGoneLeftMargin;
            int n7 = layoutParams.resolveGoneRightMargin;
            float f = layoutParams.resolvedHorizontalBias;
            if (layoutParams.circleConstraint != -1) {
                object = (ConstraintWidget)object2.get(layoutParams.circleConstraint);
                if (object != null) {
                    constraintWidget.connectCircularConstraint((ConstraintWidget)object, layoutParams.circleAngle, layoutParams.circleRadius);
                }
            } else {
                if (n != -1) {
                    object = (ConstraintWidget)object2.get(n);
                    if (object != null) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)object, ConstraintAnchor.Type.LEFT, layoutParams.leftMargin, n6);
                    }
                } else if (n3 != -1 && (object = (ConstraintWidget)object2.get(n3)) != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)object, ConstraintAnchor.Type.RIGHT, layoutParams.leftMargin, n6);
                }
                if (n4 != -1) {
                    object = (ConstraintWidget)object2.get(n4);
                    if (object != null) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)object, ConstraintAnchor.Type.LEFT, layoutParams.rightMargin, n7);
                    }
                } else if (n5 != -1 && (object = (ConstraintWidget)object2.get(n5)) != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)object, ConstraintAnchor.Type.RIGHT, layoutParams.rightMargin, n7);
                }
                if (layoutParams.topToTop != -1) {
                    object = (ConstraintWidget)object2.get(layoutParams.topToTop);
                    if (object != null) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, (ConstraintWidget)object, ConstraintAnchor.Type.TOP, layoutParams.topMargin, layoutParams.goneTopMargin);
                    }
                } else if (layoutParams.topToBottom != -1 && (object = (ConstraintWidget)object2.get(layoutParams.topToBottom)) != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, (ConstraintWidget)object, ConstraintAnchor.Type.BOTTOM, layoutParams.topMargin, layoutParams.goneTopMargin);
                }
                if (layoutParams.bottomToTop != -1) {
                    object = (ConstraintWidget)object2.get(layoutParams.bottomToTop);
                    if (object != null) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)object, ConstraintAnchor.Type.TOP, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
                    }
                } else if (layoutParams.bottomToBottom != -1 && (object = (ConstraintWidget)object2.get(layoutParams.bottomToBottom)) != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)object, ConstraintAnchor.Type.BOTTOM, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
                }
                if (layoutParams.baselineToBaseline != -1) {
                    object = (View)this.mChildrenByIds.get(layoutParams.baselineToBaseline);
                    if ((object2 = (ConstraintWidget)object2.get(layoutParams.baselineToBaseline)) != null && object != null && object.getLayoutParams() instanceof LayoutParams) {
                        object = (LayoutParams)object.getLayoutParams();
                        layoutParams.needsBaseline = true;
                        object.needsBaseline = true;
                        constraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE).connect(((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, true);
                        constraintWidget.setHasBaseline(true);
                        object.widget.setHasBaseline(true);
                        constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).reset();
                        constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
                    }
                }
                if (f >= 0.0f) {
                    constraintWidget.setHorizontalBiasPercent(f);
                }
                if (layoutParams.verticalBias >= 0.0f) {
                    constraintWidget.setVerticalBiasPercent(layoutParams.verticalBias);
                }
            }
            if (bl && (layoutParams.editorAbsoluteX != -1 || layoutParams.editorAbsoluteY != -1)) {
                constraintWidget.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY);
            }
            if (!layoutParams.horizontalDimensionFixed) {
                if (layoutParams.width == -1) {
                    if (layoutParams.constrainedWidth) {
                        constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    } else {
                        constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                    }
                    constraintWidget.getAnchor((ConstraintAnchor.Type)ConstraintAnchor.Type.LEFT).mMargin = layoutParams.leftMargin;
                    constraintWidget.getAnchor((ConstraintAnchor.Type)ConstraintAnchor.Type.RIGHT).mMargin = layoutParams.rightMargin;
                } else {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    constraintWidget.setWidth(0);
                }
            } else {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setWidth(layoutParams.width);
                if (layoutParams.width == -2) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            }
            if (!layoutParams.verticalDimensionFixed) {
                if (layoutParams.height == -1) {
                    if (layoutParams.constrainedHeight) {
                        constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    } else {
                        constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                    }
                    constraintWidget.getAnchor((ConstraintAnchor.Type)ConstraintAnchor.Type.TOP).mMargin = layoutParams.topMargin;
                    constraintWidget.getAnchor((ConstraintAnchor.Type)ConstraintAnchor.Type.BOTTOM).mMargin = layoutParams.bottomMargin;
                } else {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    constraintWidget.setHeight(0);
                }
            } else {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setHeight(layoutParams.height);
                if (layoutParams.height == -2) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            }
            constraintWidget.setDimensionRatio(layoutParams.dimensionRatio);
            constraintWidget.setHorizontalWeight(layoutParams.horizontalWeight);
            constraintWidget.setVerticalWeight(layoutParams.verticalWeight);
            constraintWidget.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
            constraintWidget.setVerticalChainStyle(layoutParams.verticalChainStyle);
            constraintWidget.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
            constraintWidget.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
        }
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void dispatchDraw(Canvas canvas) {
        int n;
        int n2;
        if (this.mConstraintHelpers != null && (n2 = this.mConstraintHelpers.size()) > 0) {
            for (n = 0; n < n2; ++n) {
                this.mConstraintHelpers.get(n).updatePreDraw(this);
            }
        }
        super.dispatchDraw(canvas);
        if (this.isInEditMode()) {
            n = this.getChildCount();
            float f = this.getWidth();
            float f2 = this.getHeight();
            for (n2 = 0; n2 < n; ++n2) {
                Paint paint = this.getChildAt(n2);
                if (paint.getVisibility() == 8 || (paint = paint.getTag()) == null || !(paint instanceof String) || ((String[])(paint = ((String)paint).split(","))).length != 4) continue;
                int n3 = Integer.parseInt(paint[0]);
                int n4 = Integer.parseInt(paint[1]);
                int n5 = Integer.parseInt(paint[2]);
                int n6 = Integer.parseInt(paint[3]);
                n3 = (int)((float)n3 / 1080.0f * f);
                n4 = (int)((float)n4 / 1920.0f * f2);
                n5 = (int)((float)n5 / 1080.0f * f);
                n6 = (int)((float)n6 / 1920.0f * f2);
                paint = new Paint();
                paint.setColor(-65536);
                canvas.drawLine((float)n3, (float)n4, (float)(n3 + n5), (float)n4, paint);
                canvas.drawLine((float)(n3 + n5), (float)n4, (float)(n3 + n5), (float)(n4 + n6), paint);
                canvas.drawLine((float)(n3 + n5), (float)(n4 + n6), (float)n3, (float)(n4 + n6), paint);
                canvas.drawLine((float)n3, (float)(n4 + n6), (float)n3, (float)n4, paint);
                paint.setColor(-16711936);
                canvas.drawLine((float)n3, (float)n4, (float)(n3 + n5), (float)(n4 + n6), paint);
                canvas.drawLine((float)n3, (float)(n4 + n6), (float)(n3 + n5), (float)n4, paint);
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    public void forceLayout() {
        this.markHierarchyDirty();
        super.forceLayout();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    public Object getDesignInformation(int n, Object object) {
        if (n == 0 && object instanceof String) {
            object = (String)object;
            if (this.mDesignIds != null && this.mDesignIds.containsKey(object)) {
                return this.mDesignIds.get(object);
            }
        }
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public View getViewById(int n) {
        return (View)this.mChildrenByIds.get(n);
    }

    public final ConstraintWidget getViewWidget(View object) {
        if (object == this) {
            return this.mLayoutWidget;
        }
        object = object == null ? null : ((LayoutParams)object.getLayoutParams()).widget;
        return object;
    }

    protected boolean isRtl() {
        int n = this.getContext().getApplicationInfo().flags;
        boolean bl = false;
        n = (n & 0x400000) != 0 ? 1 : 0;
        boolean bl2 = bl;
        if (n != 0) {
            bl2 = bl;
            if (1 == this.getLayoutDirection()) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public void loadLayoutDescription(int n) {
        if (n != 0) {
            try {
                ConstraintLayoutStates constraintLayoutStates;
                this.mConstraintLayoutSpec = constraintLayoutStates = new ConstraintLayoutStates(this.getContext(), this, n);
            }
            catch (Resources.NotFoundException notFoundException) {
                this.mConstraintLayoutSpec = null;
            }
        } else {
            this.mConstraintLayoutSpec = null;
        }
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        n2 = this.getChildCount();
        bl = this.isInEditMode();
        for (n = 0; n < n2; ++n) {
            View view = this.getChildAt(n);
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if (view.getVisibility() == 8 && !layoutParams.isGuideline && !layoutParams.isHelper && !layoutParams.isVirtualGroup && !bl || layoutParams.isInPlaceholder) continue;
            int n5 = constraintWidget.getX();
            int n6 = constraintWidget.getY();
            n3 = constraintWidget.getWidth() + n5;
            n4 = constraintWidget.getHeight() + n6;
            view.layout(n5, n6, n3, n4);
            if (!(view instanceof Placeholder) || (layoutParams = ((Placeholder)view).getContent()) == null) continue;
            layoutParams.setVisibility(0);
            layoutParams.layout(n5, n6, n3, n4);
        }
        n2 = this.mConstraintHelpers.size();
        if (n2 > 0) {
            for (n = 0; n < n2; ++n) {
                this.mConstraintHelpers.get(n).updatePostLayout(this);
            }
        }
    }

    protected void onMeasure(int n, int n2) {
        this.mOnMeasureWidthMeasureSpec = n;
        this.mOnMeasureHeightMeasureSpec = n2;
        this.mLayoutWidget.setRtl(this.isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (this.updateHierarchy()) {
                this.mLayoutWidget.updateHierarchy();
            }
        }
        this.resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, n, n2);
        this.resolveMeasuredDimension(n, n2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        Object object = this.getViewWidget(view);
        if (view instanceof Guideline && !(object instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
            object = (LayoutParams)view.getLayoutParams();
            ((LayoutParams)((Object)object)).widget = new androidx.constraintlayout.solver.widgets.Guideline();
            ((LayoutParams)((Object)object)).isGuideline = true;
            ((androidx.constraintlayout.solver.widgets.Guideline)((LayoutParams)((Object)object)).widget).setOrientation(((LayoutParams)((Object)object)).orientation);
        }
        if (view instanceof ConstraintHelper) {
            object = (ConstraintHelper)view;
            ((ConstraintHelper)((Object)object)).validateParams();
            ((LayoutParams)view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(object)) {
                this.mConstraintHelpers.add((ConstraintHelper)((Object)object));
            }
        }
        this.mChildrenByIds.put(view.getId(), (Object)view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget constraintWidget = this.getViewWidget(view);
        this.mLayoutWidget.remove(constraintWidget);
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    protected void parseLayoutDescription(int n) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(this.getContext(), this, n);
    }

    public void removeView(View view) {
        super.removeView(view);
    }

    public void requestLayout() {
        this.markHierarchyDirty();
        super.requestLayout();
    }

    protected void resolveMeasuredDimension(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5 = this.mMeasurer.paddingHeight;
        int n6 = this.mMeasurer.paddingWidth;
        n = ConstraintLayout.resolveSizeAndState((int)(n3 + n6), (int)n, (int)0);
        n3 = ConstraintLayout.resolveSizeAndState((int)(n4 + n5), (int)n2, (int)(0 << 16));
        n2 = Math.min(this.mMaxWidth, n & 0xFFFFFF);
        n3 = Math.min(this.mMaxHeight, n3 & 0xFFFFFF);
        n = n2;
        if (bl) {
            n = n2 | 0x1000000;
        }
        n2 = n3;
        if (bl2) {
            n2 = n3 | 0x1000000;
        }
        this.setMeasuredDimension(n, n2);
        this.mLastMeasureWidth = n;
        this.mLastMeasureHeight = n2;
    }

    protected void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n2);
        int n5 = View.MeasureSpec.getSize((int)n2);
        int n6 = View.MeasureSpec.getMode((int)n3);
        int n7 = View.MeasureSpec.getSize((int)n3);
        int n8 = Math.max(0, this.getPaddingTop());
        int n9 = Math.max(0, this.getPaddingBottom());
        int n10 = n8 + n9;
        int n11 = this.getPaddingWidth();
        this.mMeasurer.captureLayoutInfos(n2, n3, n8, n9, n11, n10);
        n3 = Math.max(0, this.getPaddingStart());
        n2 = Math.max(0, this.getPaddingEnd());
        if (n3 <= 0 && n2 <= 0) {
            n2 = Math.max(0, this.getPaddingLeft());
        } else if (!this.isRtl()) {
            n2 = n3;
        }
        n3 = n5 - n11;
        this.setSelfDimensionBehaviour(constraintWidgetContainer, n4, n3, n6, n7 -= n10);
        constraintWidgetContainer.measure(n, n4, n3, n6, n7, this.mLastMeasureWidth, this.mLastMeasureHeight, n2, n8);
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int n, Object object, Object object2) {
        if (n == 0 && object instanceof String && object2 instanceof Integer) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap();
            }
            String string2 = (String)object;
            n = string2.indexOf("/");
            object = string2;
            if (n != -1) {
                object = string2.substring(n + 1);
            }
            n = (Integer)object2;
            this.mDesignIds.put((String)object, n);
        }
    }

    public void setId(int n) {
        this.mChildrenByIds.remove(this.getId());
        super.setId(n);
        this.mChildrenByIds.put(this.getId(), (Object)this);
    }

    public void setMaxHeight(int n) {
        if (n == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = n;
        this.requestLayout();
    }

    public void setMaxWidth(int n) {
        if (n == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = n;
        this.requestLayout();
    }

    public void setMinHeight(int n) {
        if (n == this.mMinHeight) {
            return;
        }
        this.mMinHeight = n;
        this.requestLayout();
    }

    public void setMinWidth(int n) {
        if (n == this.mMinWidth) {
            return;
        }
        this.mMinWidth = n;
        this.requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        if (this.mConstraintLayoutSpec != null) {
            this.mConstraintLayoutSpec.setOnConstraintsChanged(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int n) {
        this.mOptimizationLevel = n;
        this.mLayoutWidget.setOptimizationLevel(n);
    }

    protected void setSelfDimensionBehaviour(ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3, int n4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int n5 = this.mMeasurer.paddingHeight;
        int n6 = this.mMeasurer.paddingWidth;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        int n7 = 0;
        int n8 = 0;
        int n9 = this.getChildCount();
        switch (n) {
            default: {
                n = n7;
                break;
            }
            case 0x40000000: {
                n = Math.min(this.mMaxWidth - n6, n2);
                break;
            }
            case 0: {
                dimensionBehaviour2 = dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                n = n7;
                if (n9 != 0) break;
                n = Math.max(0, this.mMinWidth);
                dimensionBehaviour2 = dimensionBehaviour;
                break;
            }
            case -2147483648: {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                n = n2;
                dimensionBehaviour2 = dimensionBehaviour;
                if (n9 != 0) break;
                n = Math.max(0, this.mMinWidth);
                dimensionBehaviour2 = dimensionBehaviour;
            }
        }
        switch (n3) {
            default: {
                n2 = n8;
                break;
            }
            case 0x40000000: {
                n2 = Math.min(this.mMaxHeight - n5, n4);
                break;
            }
            case 0: {
                dimensionBehaviour3 = dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                n2 = n8;
                if (n9 != 0) break;
                n2 = Math.max(0, this.mMinHeight);
                dimensionBehaviour3 = dimensionBehaviour;
                break;
            }
            case -2147483648: {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                n2 = n4;
                dimensionBehaviour3 = dimensionBehaviour;
                if (n9 != 0) break;
                n2 = Math.max(0, this.mMinHeight);
                dimensionBehaviour3 = dimensionBehaviour;
            }
        }
        if (n != constraintWidgetContainer.getWidth() || n2 != constraintWidgetContainer.getHeight()) {
            constraintWidgetContainer.invalidateMeasures();
        }
        constraintWidgetContainer.setX(0);
        constraintWidgetContainer.setY(0);
        constraintWidgetContainer.setMaxWidth(this.mMaxWidth - n6);
        constraintWidgetContainer.setMaxHeight(this.mMaxHeight - n5);
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour2);
        constraintWidgetContainer.setWidth(n);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour3);
        constraintWidgetContainer.setHeight(n2);
        constraintWidgetContainer.setMinWidth(this.mMinWidth - n6);
        constraintWidgetContainer.setMinHeight(this.mMinHeight - n5);
    }

    public void setState(int n, int n2, int n3) {
        if (this.mConstraintLayoutSpec != null) {
            this.mConstraintLayoutSpec.updateConstraints(n, n2, n3);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public static class LayoutParams
    extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public int baselineToBaseline;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;
        public String dimensionRatio;
        int dimensionRatioSide;
        float dimensionRatioValue;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        boolean horizontalDimensionFixed;
        public float horizontalWeight;
        boolean isGuideline;
        boolean isHelper;
        boolean isInPlaceholder;
        boolean isVirtualGroup;
        public int leftToLeft;
        public int leftToRight;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        boolean needsBaseline;
        public int orientation;
        int resolveGoneLeftMargin;
        int resolveGoneRightMargin;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias;
        int resolvedLeftToLeft;
        int resolvedLeftToRight;
        int resolvedRightToLeft;
        int resolvedRightToRight;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        boolean verticalDimensionFixed;
        public float verticalWeight;
        ConstraintWidget widget;

        public LayoutParams(int n, int n2) {
            super(n, n2);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        /*
         * Unable to fully structure code
         */
        public LayoutParams(Context var1_1, AttributeSet var2_2) {
            super(var1_1, (AttributeSet)var2_2);
            var6_9 = -1;
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            var5_10 = 0;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            var1_1 = var1_1.obtainStyledAttributes((AttributeSet)var2_2, R.styleable.ConstraintLayout_Layout);
            var10_11 = var1_1.getIndexCount();
            var7_12 = 0;
            while (var7_12 < var10_11) {
                var11_17 = var1_1.getIndex(var7_12);
                switch (Table.map.get(var11_17)) {
                    default: {
                        var8_15 = var6_9;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 51: {
                        this.constraintTag = var1_1.getString(var11_17);
                        var8_15 = var6_9;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 50: {
                        this.editorAbsoluteY = var1_1.getDimensionPixelOffset(var11_17, this.editorAbsoluteY);
                        var8_15 = var6_9;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 49: {
                        this.editorAbsoluteX = var1_1.getDimensionPixelOffset(var11_17, this.editorAbsoluteX);
                        var8_15 = var6_9;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 48: {
                        this.verticalChainStyle = var1_1.getInt(var11_17, var5_10);
                        var8_15 = var6_9;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 47: {
                        this.horizontalChainStyle = var1_1.getInt(var11_17, var5_10);
                        var8_15 = var6_9;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 46: {
                        this.verticalWeight = var1_1.getFloat(var11_17, this.verticalWeight);
                        var8_15 = var6_9;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 45: {
                        this.horizontalWeight = var1_1.getFloat(var11_17, this.horizontalWeight);
                        var8_15 = var6_9;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 44: {
                        this.dimensionRatio = var1_1.getString(var11_17);
                        this.dimensionRatioValue = NaNf;
                        this.dimensionRatioSide = var6_9;
                        if (this.dimensionRatio == null) ** GOTO lbl165
                        var6_9 = this.dimensionRatio.length();
                        var8_15 = this.dimensionRatio.indexOf(44);
                        if (var8_15 > 0 && var8_15 < var6_9 - 1) {
                            var2_2 = this.dimensionRatio.substring(var5_10, var8_15);
                            if (var2_2.equalsIgnoreCase("W")) {
                                this.dimensionRatioSide = var5_10;
                            } else if (var2_2.equalsIgnoreCase("H")) {
                                this.dimensionRatioSide = 1;
                            }
                            var5_10 = var8_15 + 1;
                        } else {
                            var5_10 = 0;
                        }
                        var8_15 = this.dimensionRatio.indexOf(58);
                        if (var8_15 < 0 || var8_15 >= var6_9 - 1) ** GOTO lbl155
                        var13_19 = this.dimensionRatio.substring(var5_10, var8_15);
                        var2_2 = this.dimensionRatio.substring(var8_15 + 1);
                        if (var13_19.length() <= 0 || var2_2.length() <= 0) ** GOTO lbl162
                        try {
                            var4_14 = Float.parseFloat(var13_19);
                            var3_13 = Float.parseFloat((String)var2_2);
                        }
                        catch (NumberFormatException var2_3) {}
                        if (!(var4_14 > 0.0f) || !(var3_13 > 0.0f)) ** GOTO lbl162
                        if (this.dimensionRatioSide != 1) ** GOTO lbl152
                        this.dimensionRatioValue = Math.abs(var3_13 / var4_14);
                        ** GOTO lbl162
lbl152:
                        // 1 sources

                        this.dimensionRatioValue = Math.abs(var4_14 / var3_13);
                        ** GOTO lbl162
lbl155:
                        // 1 sources

                        var2_2 = this.dimensionRatio.substring(var5_10);
                        if (var2_2.length() > 0) {
                            try {
                                this.dimensionRatioValue = Float.parseFloat((String)var2_2);
                            }
                            catch (NumberFormatException var2_4) {
                                // empty catch block
                            }
                        }
lbl162:
                        // 9 sources

                        var6_9 = 0;
                        var5_10 = -1;
                        break;
lbl165:
                        // 1 sources

                        var6_9 = 0;
                        var5_10 = -1;
                        break;
                    }
                    case 42: {
                        var6_9 = 0;
                        var5_10 = -1;
                        break;
                    }
                    case 41: {
                        var6_9 = 0;
                        var5_10 = -1;
                        break;
                    }
                    case 40: {
                        var6_9 = 0;
                        var5_10 = -1;
                        break;
                    }
                    case 39: {
                        var6_9 = 0;
                        var5_10 = -1;
                        break;
                    }
                    case 38: {
                        this.matchConstraintPercentHeight = Math.max(0.0f, var1_1.getFloat(var11_17, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        var6_9 = 0;
                        var5_10 = -1;
                        break;
                    }
                    case 37: {
                        try {
                            this.matchConstraintMaxHeight = var1_1.getDimensionPixelSize(var11_17, this.matchConstraintMaxHeight);
                            var6_9 = 0;
                            var5_10 = -1;
                        }
                        catch (Exception var2_5) {
                            if (var1_1.getInt(var11_17, this.matchConstraintMaxHeight) == -2) {
                                this.matchConstraintMaxHeight = -2;
                            }
                            var6_9 = 0;
                            var5_10 = -1;
                        }
                        break;
                    }
                    case 36: {
                        try {
                            this.matchConstraintMinHeight = var1_1.getDimensionPixelSize(var11_17, this.matchConstraintMinHeight);
                            var6_9 = 0;
                            var5_10 = -1;
                        }
                        catch (Exception var2_6) {
                            if (var1_1.getInt(var11_17, this.matchConstraintMinHeight) == -2) {
                                this.matchConstraintMinHeight = -2;
                            }
                            var6_9 = 0;
                            var5_10 = -1;
                        }
                        break;
                    }
                    case 35: {
                        this.matchConstraintPercentWidth = Math.max(0.0f, var1_1.getFloat(var11_17, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        var6_9 = 0;
                        var5_10 = -1;
                        break;
                    }
                    case 34: {
                        try {
                            this.matchConstraintMaxWidth = var1_1.getDimensionPixelSize(var11_17, this.matchConstraintMaxWidth);
                            var6_9 = 0;
                            var5_10 = -1;
                        }
                        catch (Exception var2_7) {
                            if (var1_1.getInt(var11_17, this.matchConstraintMaxWidth) == -2) {
                                this.matchConstraintMaxWidth = -2;
                            }
                            var6_9 = 0;
                            var5_10 = -1;
                        }
                        break;
                    }
                    case 33: {
                        try {
                            this.matchConstraintMinWidth = var1_1.getDimensionPixelSize(var11_17, this.matchConstraintMinWidth);
                            var6_9 = 0;
                            var5_10 = -1;
                        }
                        catch (Exception var2_8) {
                            if (var1_1.getInt(var11_17, this.matchConstraintMinWidth) == -2) {
                                this.matchConstraintMinWidth = -2;
                            }
                            var6_9 = 0;
                            var5_10 = -1;
                        }
                        break;
                    }
                    case 32: {
                        this.matchConstraintDefaultHeight = var1_1.getInt(var11_17, 0);
                        if (this.matchConstraintDefaultHeight == 1) {
                            Log.e((String)"ConstraintLayout", (String)"layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            var6_9 = 0;
                            var5_10 = -1;
                            break;
                        }
                        var6_9 = 0;
                        var5_10 = -1;
                        break;
                    }
                    case 31: {
                        var6_9 = 0;
                        this.matchConstraintDefaultWidth = var1_1.getInt(var11_17, 0);
                        if (this.matchConstraintDefaultWidth == 1) {
                            Log.e((String)"ConstraintLayout", (String)"layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            var5_10 = -1;
                            break;
                        }
                        var5_10 = -1;
                        break;
                    }
                    case 30: {
                        this.verticalBias = var1_1.getFloat(var11_17, this.verticalBias);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 29: {
                        this.horizontalBias = var1_1.getFloat(var11_17, this.horizontalBias);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 28: {
                        this.constrainedHeight = var1_1.getBoolean(var11_17, this.constrainedHeight);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 27: {
                        this.constrainedWidth = var1_1.getBoolean(var11_17, this.constrainedWidth);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 26: {
                        this.goneEndMargin = var1_1.getDimensionPixelSize(var11_17, this.goneEndMargin);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 25: {
                        this.goneStartMargin = var1_1.getDimensionPixelSize(var11_17, this.goneStartMargin);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 24: {
                        this.goneBottomMargin = var1_1.getDimensionPixelSize(var11_17, this.goneBottomMargin);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 23: {
                        this.goneRightMargin = var1_1.getDimensionPixelSize(var11_17, this.goneRightMargin);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 22: {
                        this.goneTopMargin = var1_1.getDimensionPixelSize(var11_17, this.goneTopMargin);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 21: {
                        this.goneLeftMargin = var1_1.getDimensionPixelSize(var11_17, this.goneLeftMargin);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 20: {
                        var8_15 = var5_10;
                        var12_18 = this.endToEnd = var1_1.getResourceId(var11_17, this.endToEnd);
                        var9_16 = -1;
                        var6_9 = var8_15;
                        var5_10 = var9_16;
                        if (var12_18 != -1) break;
                        this.endToEnd = var1_1.getInt(var11_17, -1);
                        var6_9 = var8_15;
                        var5_10 = var9_16;
                        break;
                    }
                    case 19: {
                        var8_15 = var6_9;
                        var9_16 = var5_10;
                        this.endToStart = var1_1.getResourceId(var11_17, this.endToStart);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        if (this.endToStart != var8_15) break;
                        this.endToStart = var1_1.getInt(var11_17, var8_15);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        break;
                    }
                    case 18: {
                        var8_15 = var6_9;
                        var9_16 = var5_10;
                        this.startToStart = var1_1.getResourceId(var11_17, this.startToStart);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        if (this.startToStart != var8_15) break;
                        this.startToStart = var1_1.getInt(var11_17, var8_15);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        break;
                    }
                    case 17: {
                        var8_15 = var6_9;
                        var9_16 = var5_10;
                        this.startToEnd = var1_1.getResourceId(var11_17, this.startToEnd);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        if (this.startToEnd != var8_15) break;
                        this.startToEnd = var1_1.getInt(var11_17, var8_15);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        break;
                    }
                    case 16: {
                        var8_15 = var6_9;
                        var9_16 = var5_10;
                        this.baselineToBaseline = var1_1.getResourceId(var11_17, this.baselineToBaseline);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        if (this.baselineToBaseline != var8_15) break;
                        this.baselineToBaseline = var1_1.getInt(var11_17, var8_15);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        break;
                    }
                    case 15: {
                        var8_15 = var6_9;
                        var9_16 = var5_10;
                        this.bottomToBottom = var1_1.getResourceId(var11_17, this.bottomToBottom);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        if (this.bottomToBottom != var8_15) break;
                        this.bottomToBottom = var1_1.getInt(var11_17, var8_15);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        break;
                    }
                    case 14: {
                        var8_15 = var6_9;
                        var9_16 = var5_10;
                        this.bottomToTop = var1_1.getResourceId(var11_17, this.bottomToTop);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        if (this.bottomToTop != var8_15) break;
                        this.bottomToTop = var1_1.getInt(var11_17, var8_15);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        break;
                    }
                    case 13: {
                        var8_15 = var6_9;
                        var9_16 = var5_10;
                        this.topToBottom = var1_1.getResourceId(var11_17, this.topToBottom);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        if (this.topToBottom != var8_15) break;
                        this.topToBottom = var1_1.getInt(var11_17, var8_15);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        break;
                    }
                    case 12: {
                        var8_15 = var6_9;
                        var9_16 = var5_10;
                        this.topToTop = var1_1.getResourceId(var11_17, this.topToTop);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        if (this.topToTop != var8_15) break;
                        this.topToTop = var1_1.getInt(var11_17, var8_15);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        break;
                    }
                    case 11: {
                        var8_15 = var6_9;
                        var9_16 = var5_10;
                        this.rightToRight = var1_1.getResourceId(var11_17, this.rightToRight);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        if (this.rightToRight != var8_15) break;
                        this.rightToRight = var1_1.getInt(var11_17, var8_15);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        break;
                    }
                    case 10: {
                        var8_15 = var6_9;
                        var9_16 = var5_10;
                        this.rightToLeft = var1_1.getResourceId(var11_17, this.rightToLeft);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        if (this.rightToLeft != var8_15) break;
                        this.rightToLeft = var1_1.getInt(var11_17, var8_15);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        break;
                    }
                    case 9: {
                        var8_15 = var6_9;
                        var9_16 = var5_10;
                        this.leftToRight = var1_1.getResourceId(var11_17, this.leftToRight);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        if (this.leftToRight != var8_15) break;
                        this.leftToRight = var1_1.getInt(var11_17, var8_15);
                        var6_9 = var9_16;
                        var5_10 = var8_15;
                        break;
                    }
                    case 8: {
                        this.leftToLeft = var1_1.getResourceId(var11_17, this.leftToLeft);
                        if (this.leftToLeft == var6_9) {
                            this.leftToLeft = var1_1.getInt(var11_17, var6_9);
                            var8_15 = -1;
                            var6_9 = var5_10;
                            var5_10 = var8_15;
                            break;
                        }
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 7: {
                        this.guidePercent = var1_1.getFloat(var11_17, this.guidePercent);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 6: {
                        this.guideEnd = var1_1.getDimensionPixelOffset(var11_17, this.guideEnd);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 5: {
                        this.guideBegin = var1_1.getDimensionPixelOffset(var11_17, this.guideBegin);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 4: {
                        this.circleAngle = var1_1.getFloat(var11_17, this.circleAngle) % 360.0f;
                        if (this.circleAngle < 0.0f) {
                            this.circleAngle = (360.0f - this.circleAngle) % 360.0f;
                            var8_15 = -1;
                            var6_9 = var5_10;
                            var5_10 = var8_15;
                            break;
                        }
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 3: {
                        this.circleRadius = var1_1.getDimensionPixelSize(var11_17, this.circleRadius);
                        var8_15 = -1;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 2: {
                        var8_15 = var5_10;
                        var12_18 = this.circleConstraint = var1_1.getResourceId(var11_17, this.circleConstraint);
                        var9_16 = -1;
                        var6_9 = var8_15;
                        var5_10 = var9_16;
                        if (var12_18 != -1) break;
                        this.circleConstraint = var1_1.getInt(var11_17, -1);
                        var6_9 = var8_15;
                        var5_10 = var9_16;
                        break;
                    }
                    case 1: {
                        var8_15 = var6_9;
                        this.orientation = var1_1.getInt(var11_17, this.orientation);
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                        break;
                    }
                    case 0: {
                        var8_15 = var6_9;
                        var6_9 = var5_10;
                        var5_10 = var8_15;
                    }
                }
                var8_15 = var7_12 + 1;
                var7_12 = var6_9;
                var6_9 = var5_10;
                var5_10 = var7_12;
                var7_12 = var8_15;
            }
            var1_1.recycle();
            this.validate();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams)layoutParams);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.guidePercent = layoutParams.guidePercent;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.goneLeftMargin = layoutParams.goneLeftMargin;
            this.goneTopMargin = layoutParams.goneTopMargin;
            this.goneRightMargin = layoutParams.goneRightMargin;
            this.goneBottomMargin = layoutParams.goneBottomMargin;
            this.goneStartMargin = layoutParams.goneStartMargin;
            this.goneEndMargin = layoutParams.goneEndMargin;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.dimensionRatioValue = layoutParams.dimensionRatioValue;
            this.dimensionRatioSide = layoutParams.dimensionRatioSide;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = layoutParams.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = layoutParams.matchConstraintPercentHeight;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.horizontalDimensionFixed = layoutParams.horizontalDimensionFixed;
            this.verticalDimensionFixed = layoutParams.verticalDimensionFixed;
            this.needsBaseline = layoutParams.needsBaseline;
            this.isGuideline = layoutParams.isGuideline;
            this.resolvedLeftToLeft = layoutParams.resolvedLeftToLeft;
            this.resolvedLeftToRight = layoutParams.resolvedLeftToRight;
            this.resolvedRightToLeft = layoutParams.resolvedRightToLeft;
            this.resolvedRightToRight = layoutParams.resolvedRightToRight;
            this.resolveGoneLeftMargin = layoutParams.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = layoutParams.resolveGoneRightMargin;
            this.resolvedHorizontalBias = layoutParams.resolvedHorizontalBias;
            this.constraintTag = layoutParams.constraintTag;
            this.widget = layoutParams.widget;
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.widget;
        }

        public void reset() {
            if (this.widget != null) {
                this.widget.reset();
            }
        }

        public void resolveLayoutDirection(int n) {
            int n2 = this.leftMargin;
            int n3 = this.rightMargin;
            super.resolveLayoutDirection(n);
            n = 1 == this.getLayoutDirection() ? 1 : 0;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            this.resolvedHorizontalBias = this.horizontalBias;
            this.resolvedGuideBegin = this.guideBegin;
            this.resolvedGuideEnd = this.guideEnd;
            this.resolvedGuidePercent = this.guidePercent;
            if (n != 0) {
                n = 0;
                if (this.startToEnd != -1) {
                    this.resolvedRightToLeft = this.startToEnd;
                    n = 1;
                } else if (this.startToStart != -1) {
                    this.resolvedRightToRight = this.startToStart;
                    n = 1;
                }
                if (this.endToStart != -1) {
                    this.resolvedLeftToRight = this.endToStart;
                    n = 1;
                }
                if (this.endToEnd != -1) {
                    this.resolvedLeftToLeft = this.endToEnd;
                    n = 1;
                }
                if (this.goneStartMargin != -1) {
                    this.resolveGoneRightMargin = this.goneStartMargin;
                }
                if (this.goneEndMargin != -1) {
                    this.resolveGoneLeftMargin = this.goneEndMargin;
                }
                if (n != 0) {
                    this.resolvedHorizontalBias = 1.0f - this.horizontalBias;
                }
                if (this.isGuideline && this.orientation == 1) {
                    if (this.guidePercent != -1.0f) {
                        this.resolvedGuidePercent = 1.0f - this.guidePercent;
                        this.resolvedGuideBegin = -1;
                        this.resolvedGuideEnd = -1;
                    } else if (this.guideBegin != -1) {
                        this.resolvedGuideEnd = this.guideBegin;
                        this.resolvedGuideBegin = -1;
                        this.resolvedGuidePercent = -1.0f;
                    } else if (this.guideEnd != -1) {
                        this.resolvedGuideBegin = this.guideEnd;
                        this.resolvedGuideEnd = -1;
                        this.resolvedGuidePercent = -1.0f;
                    }
                }
            } else {
                if (this.startToEnd != -1) {
                    this.resolvedLeftToRight = this.startToEnd;
                }
                if (this.startToStart != -1) {
                    this.resolvedLeftToLeft = this.startToStart;
                }
                if (this.endToStart != -1) {
                    this.resolvedRightToLeft = this.endToStart;
                }
                if (this.endToEnd != -1) {
                    this.resolvedRightToRight = this.endToEnd;
                }
                if (this.goneStartMargin != -1) {
                    this.resolveGoneLeftMargin = this.goneStartMargin;
                }
                if (this.goneEndMargin != -1) {
                    this.resolveGoneRightMargin = this.goneEndMargin;
                }
            }
            if (this.endToStart == -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
                if (this.rightToLeft != -1) {
                    this.resolvedRightToLeft = this.rightToLeft;
                    if (this.rightMargin <= 0 && n3 > 0) {
                        this.rightMargin = n3;
                    }
                } else if (this.rightToRight != -1) {
                    this.resolvedRightToRight = this.rightToRight;
                    if (this.rightMargin <= 0 && n3 > 0) {
                        this.rightMargin = n3;
                    }
                }
                if (this.leftToLeft != -1) {
                    this.resolvedLeftToLeft = this.leftToLeft;
                    if (this.leftMargin <= 0 && n2 > 0) {
                        this.leftMargin = n2;
                    }
                } else if (this.leftToRight != -1) {
                    this.resolvedLeftToRight = this.leftToRight;
                    if (this.leftMargin <= 0 && n2 > 0) {
                        this.leftMargin = n2;
                    }
                }
            }
        }

        public void setWidgetDebugName(String string2) {
            this.widget.setDebugName(string2);
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (this.width == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            if (this.height == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            if (this.width == 0 || this.width == -1) {
                this.horizontalDimensionFixed = false;
                if (this.width == 0 && this.matchConstraintDefaultWidth == 1) {
                    this.width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.verticalDimensionFixed = false;
                if (this.height == 0 && this.matchConstraintDefaultHeight == 1) {
                    this.height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
                    this.widget = new androidx.constraintlayout.solver.widgets.Guideline();
                }
                ((androidx.constraintlayout.solver.widgets.Guideline)this.widget).setOrientation(this.orientation);
            }
        }

        private static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TAG = 51;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED = 0;
            public static final SparseIntArray map = new SparseIntArray();

            static {
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                map.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }

            private Table() {
            }
        }
    }

    class Measurer
    implements BasicMeasure.Measurer {
        ConstraintLayout layout;
        int layoutHeightSpec;
        int layoutWidthSpec;
        int paddingBottom;
        int paddingHeight;
        int paddingTop;
        int paddingWidth;
        final ConstraintLayout this$0;

        public Measurer(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
            this.this$0 = constraintLayout;
            this.layout = constraintLayout2;
        }

        public void captureLayoutInfos(int n, int n2, int n3, int n4, int n5, int n6) {
            this.paddingTop = n3;
            this.paddingBottom = n4;
            this.paddingWidth = n5;
            this.paddingHeight = n6;
            this.layoutWidthSpec = n;
            this.layoutHeightSpec = n2;
        }

        @Override
        public final void didMeasures() {
            int n;
            int n2 = this.layout.getChildCount();
            for (n = 0; n < n2; ++n) {
                View view = this.layout.getChildAt(n);
                if (!(view instanceof Placeholder)) continue;
                ((Placeholder)view).updatePostMeasure(this.layout);
            }
            n2 = this.layout.mConstraintHelpers.size();
            if (n2 > 0) {
                for (n = 0; n < n2; ++n) {
                    ((ConstraintHelper)((Object)this.layout.mConstraintHelpers.get(n))).updatePostMeasure(this.layout);
                }
            }
        }

        @Override
        public final void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
            if (constraintWidget == null) {
                return;
            }
            if (constraintWidget.getVisibility() == 8 && !constraintWidget.isInPlaceholder()) {
                measure.measuredWidth = 0;
                measure.measuredHeight = 0;
                measure.measuredBaseline = 0;
                return;
            }
            Object object = measure.horizontalBehavior;
            Object object2 = measure.verticalBehavior;
            int n = measure.horizontalDimension;
            int n2 = measure.verticalDimension;
            int n3 = 0;
            int n4 = 0;
            int n5 = this.paddingTop + this.paddingBottom;
            int n6 = this.paddingWidth;
            int n7 = 0;
            int n8 = 0;
            View view = (View)constraintWidget.getCompanionWidget();
            switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[object.ordinal()]) {
                default: {
                    break;
                }
                case 4: {
                    n6 = ViewGroup.getChildMeasureSpec((int)this.layoutWidthSpec, (int)n6, (int)-2);
                    n7 = 1;
                    n3 = constraintWidget.mMatchConstraintDefaultWidth == 1 ? 1 : 0;
                    constraintWidget.wrapMeasure[2] = 0;
                    if (measure.useCurrentDimensions) {
                        n = n3 != 0 && constraintWidget.wrapMeasure[3] != 0 && constraintWidget.wrapMeasure[0] != constraintWidget.getWidth() || view instanceof Placeholder ? 1 : 0;
                        if (n3 == 0 || n != 0) {
                            n3 = View.MeasureSpec.makeMeasureSpec((int)constraintWidget.getWidth(), (int)0x40000000);
                            n7 = 0;
                            break;
                        }
                    }
                    n3 = n6;
                    break;
                }
                case 3: {
                    n3 = ViewGroup.getChildMeasureSpec((int)this.layoutWidthSpec, (int)(constraintWidget.getHorizontalMargin() + n6), (int)-1);
                    constraintWidget.wrapMeasure[2] = -1;
                    break;
                }
                case 2: {
                    n3 = ViewGroup.getChildMeasureSpec((int)this.layoutWidthSpec, (int)n6, (int)-2);
                    n7 = 1;
                    constraintWidget.wrapMeasure[2] = -2;
                    break;
                }
                case 1: {
                    n3 = View.MeasureSpec.makeMeasureSpec((int)n, (int)0x40000000);
                    constraintWidget.wrapMeasure[2] = n;
                }
            }
            switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[object2.ordinal()]) {
                default: {
                    n = n4;
                    break;
                }
                case 4: {
                    n6 = ViewGroup.getChildMeasureSpec((int)this.layoutHeightSpec, (int)n5, (int)-2);
                    n8 = 1;
                    n = constraintWidget.mMatchConstraintDefaultHeight == 1 ? 1 : 0;
                    constraintWidget.wrapMeasure[3] = 0;
                    if (measure.useCurrentDimensions) {
                        n4 = n != 0 && constraintWidget.wrapMeasure[2] != 0 && constraintWidget.wrapMeasure[1] != constraintWidget.getHeight() || view instanceof Placeholder ? 1 : 0;
                        if (n != 0) {
                            n = n6;
                            if (n4 == 0) break;
                        }
                        n = View.MeasureSpec.makeMeasureSpec((int)constraintWidget.getHeight(), (int)0x40000000);
                        n8 = 0;
                        break;
                    }
                    n = n6;
                    break;
                }
                case 3: {
                    n = ViewGroup.getChildMeasureSpec((int)this.layoutHeightSpec, (int)(constraintWidget.getVerticalMargin() + n5), (int)-1);
                    constraintWidget.wrapMeasure[3] = -1;
                    break;
                }
                case 2: {
                    n = ViewGroup.getChildMeasureSpec((int)this.layoutHeightSpec, (int)n5, (int)-2);
                    n8 = 1;
                    constraintWidget.wrapMeasure[3] = -2;
                    break;
                }
                case 1: {
                    n = View.MeasureSpec.makeMeasureSpec((int)n2, (int)0x40000000);
                    constraintWidget.wrapMeasure[3] = n2;
                }
            }
            n4 = object == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
            int n9 = object2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
            n6 = object2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && object2 != ConstraintWidget.DimensionBehaviour.FIXED ? 0 : 1;
            n2 = object != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && object != ConstraintWidget.DimensionBehaviour.FIXED ? 0 : 1;
            boolean bl = n4 != 0 && constraintWidget.mDimensionRatio > 0.0f;
            n5 = n9 != 0 && constraintWidget.mDimensionRatio > 0.0f ? 1 : 0;
            object2 = (LayoutParams)view.getLayoutParams();
            if (!measure.useCurrentDimensions && n4 != 0 && constraintWidget.mMatchConstraintDefaultWidth == 0 && n9 != 0 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                n3 = 0;
                n = 0;
                n7 = 0;
            } else {
                if (view instanceof VirtualLayout && constraintWidget instanceof androidx.constraintlayout.solver.widgets.VirtualLayout) {
                    object = (androidx.constraintlayout.solver.widgets.VirtualLayout)constraintWidget;
                    ((VirtualLayout)view).onMeasure((androidx.constraintlayout.solver.widgets.VirtualLayout)object, n3, n);
                } else {
                    view.measure(n3, n);
                }
                int n10 = view.getMeasuredWidth();
                n9 = view.getMeasuredHeight();
                int n11 = view.getBaseline();
                if (n7 != 0) {
                    constraintWidget.wrapMeasure[0] = n10;
                    constraintWidget.wrapMeasure[2] = n9;
                } else {
                    constraintWidget.wrapMeasure[0] = 0;
                    constraintWidget.wrapMeasure[2] = 0;
                }
                if (n8 != 0) {
                    constraintWidget.wrapMeasure[1] = n9;
                    constraintWidget.wrapMeasure[3] = n10;
                } else {
                    constraintWidget.wrapMeasure[1] = 0;
                    constraintWidget.wrapMeasure[3] = 0;
                }
                n8 = constraintWidget.mMatchConstraintMinWidth > 0 ? Math.max(constraintWidget.mMatchConstraintMinWidth, n10) : n10;
                n7 = n8;
                if (constraintWidget.mMatchConstraintMaxWidth > 0) {
                    n7 = Math.min(constraintWidget.mMatchConstraintMaxWidth, n8);
                }
                n4 = constraintWidget.mMatchConstraintMinHeight > 0 ? Math.max(constraintWidget.mMatchConstraintMinHeight, n9) : n9;
                n8 = n4;
                if (constraintWidget.mMatchConstraintMaxHeight > 0) {
                    n8 = Math.min(constraintWidget.mMatchConstraintMaxHeight, n4);
                }
                if (bl && n6 != 0) {
                    float f = constraintWidget.mDimensionRatio;
                    n6 = (int)((float)n8 * f + 0.5f);
                    n4 = n8;
                } else {
                    n6 = n7;
                    n4 = n8;
                    if (n5 != 0) {
                        n6 = n7;
                        n4 = n8;
                        if (n2 != 0) {
                            float f = constraintWidget.mDimensionRatio;
                            n4 = (int)((float)n7 / f + 0.5f);
                            n6 = n7;
                        }
                    }
                }
                if (n10 == n6 && n9 == n4) {
                    n3 = n6;
                    n = n4;
                    n7 = n11;
                } else {
                    if (n10 != n6) {
                        n3 = View.MeasureSpec.makeMeasureSpec((int)n6, (int)0x40000000);
                    }
                    if (n9 != n4) {
                        n = View.MeasureSpec.makeMeasureSpec((int)n4, (int)0x40000000);
                    }
                    view.measure(n3, n);
                    n3 = view.getMeasuredWidth();
                    n = view.getMeasuredHeight();
                    n7 = view.getBaseline();
                }
            }
            boolean bl2 = n7 != -1;
            boolean bl3 = n3 != measure.horizontalDimension || n != measure.verticalDimension;
            measure.measuredNeedsSolverPass = bl3;
            if (((LayoutParams)((Object)object2)).needsBaseline) {
                bl2 = true;
            }
            if (bl2 && n7 != -1 && constraintWidget.getBaselineDistance() != n7) {
                measure.measuredNeedsSolverPass = true;
            }
            measure.measuredWidth = n3;
            measure.measuredHeight = n;
            measure.measuredHasBaseline = bl2;
            measure.measuredBaseline = n7;
        }
    }
}

