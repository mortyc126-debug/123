/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Flow
extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private int[] mAlignedDimensions = null;
    private ArrayList<WidgetsList> mChainList = new ArrayList();
    private ConstraintWidget[] mDisplayedWidgets;
    private int mDisplayedWidgetsCount = 0;
    private float mFirstHorizontalBias = 0.5f;
    private int mFirstHorizontalStyle = -1;
    private float mFirstVerticalBias = 0.5f;
    private int mFirstVerticalStyle = -1;
    private int mHorizontalAlign = 2;
    private float mHorizontalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mHorizontalStyle = -1;
    private float mLastHorizontalBias = 0.5f;
    private int mLastHorizontalStyle = -1;
    private float mLastVerticalBias = 0.5f;
    private int mLastVerticalStyle = -1;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private int mVerticalAlign = 2;
    private float mVerticalBias = 0.5f;
    private int mVerticalGap = 0;
    private int mVerticalStyle = -1;
    private int mWrapMode = 0;

    private void createAlignedConstraints(boolean bl) {
        if (this.mAlignedDimensions != null && this.mAlignedBiggestElementsInCols != null && this.mAlignedBiggestElementsInRows != null) {
            ConstraintWidget constraintWidget;
            ConstraintWidget constraintWidget2;
            int n;
            int n2;
            for (n2 = 0; n2 < this.mDisplayedWidgetsCount; ++n2) {
                this.mDisplayedWidgets[n2].resetAnchors();
            }
            int n3 = this.mAlignedDimensions[0];
            int n4 = this.mAlignedDimensions[1];
            ConstraintWidget constraintWidget3 = null;
            for (n2 = 0; n2 < n3; ++n2) {
                n = n2;
                if (bl) {
                    n = n3 - n2 - 1;
                }
                constraintWidget2 = this.mAlignedBiggestElementsInCols[n];
                constraintWidget = constraintWidget3;
                if (constraintWidget2 != null) {
                    if (constraintWidget2.getVisibility() == 8) {
                        constraintWidget = constraintWidget3;
                    } else {
                        if (n2 == 0) {
                            constraintWidget2.connect(constraintWidget2.mLeft, this.mLeft, this.getPaddingLeft());
                            constraintWidget2.setHorizontalChainStyle(this.mHorizontalStyle);
                            constraintWidget2.setHorizontalBiasPercent(this.mHorizontalBias);
                        }
                        if (n2 == n3 - 1) {
                            constraintWidget2.connect(constraintWidget2.mRight, this.mRight, this.getPaddingRight());
                        }
                        if (n2 > 0) {
                            constraintWidget2.connect(constraintWidget2.mLeft, constraintWidget3.mRight, this.mHorizontalGap);
                            constraintWidget3.connect(constraintWidget3.mRight, constraintWidget2.mLeft, 0);
                        }
                        constraintWidget = constraintWidget2;
                    }
                }
                constraintWidget3 = constraintWidget;
            }
            constraintWidget = constraintWidget3;
            for (n2 = 0; n2 < n4; ++n2) {
                constraintWidget2 = this.mAlignedBiggestElementsInRows[n2];
                constraintWidget3 = constraintWidget;
                if (constraintWidget2 != null) {
                    if (constraintWidget2.getVisibility() == 8) {
                        constraintWidget3 = constraintWidget;
                    } else {
                        if (n2 == 0) {
                            constraintWidget2.connect(constraintWidget2.mTop, this.mTop, this.getPaddingTop());
                            constraintWidget2.setVerticalChainStyle(this.mVerticalStyle);
                            constraintWidget2.setVerticalBiasPercent(this.mVerticalBias);
                        }
                        if (n2 == n4 - 1) {
                            constraintWidget2.connect(constraintWidget2.mBottom, this.mBottom, this.getPaddingBottom());
                        }
                        if (n2 > 0) {
                            constraintWidget2.connect(constraintWidget2.mTop, constraintWidget.mBottom, this.mVerticalGap);
                            constraintWidget.connect(constraintWidget.mBottom, constraintWidget2.mTop, 0);
                        }
                        constraintWidget3 = constraintWidget2;
                    }
                }
                constraintWidget = constraintWidget3;
            }
            for (n2 = 0; n2 < n3; ++n2) {
                for (n = 0; n < n4; ++n) {
                    int n5 = n * n3 + n2;
                    if (this.mOrientation == 1) {
                        n5 = n2 * n4 + n;
                    }
                    if (n5 >= this.mDisplayedWidgets.length || (constraintWidget3 = this.mDisplayedWidgets[n5]) == null || constraintWidget3.getVisibility() == 8) continue;
                    constraintWidget = this.mAlignedBiggestElementsInCols[n2];
                    constraintWidget2 = this.mAlignedBiggestElementsInRows[n];
                    if (constraintWidget3 != constraintWidget) {
                        constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget.mLeft, 0);
                        constraintWidget3.connect(constraintWidget3.mRight, constraintWidget.mRight, 0);
                    }
                    if (constraintWidget3 == constraintWidget2) continue;
                    constraintWidget3.connect(constraintWidget3.mTop, constraintWidget2.mTop, 0);
                    constraintWidget3.connect(constraintWidget3.mBottom, constraintWidget2.mBottom, 0);
                }
            }
            return;
        }
    }

    private final int getWidgetHeight(ConstraintWidget constraintWidget, int n) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.mMatchConstraintDefaultHeight == 0) {
                return 0;
            }
            if (constraintWidget.mMatchConstraintDefaultHeight == 2) {
                if ((n = (int)(constraintWidget.mMatchConstraintPercentHeight * (float)n)) != constraintWidget.getHeight()) {
                    this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, n);
                }
                return n;
            }
            if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
                return constraintWidget.getHeight();
            }
            if (constraintWidget.mMatchConstraintDefaultHeight == 3) {
                return (int)((float)constraintWidget.getWidth() * constraintWidget.mDimensionRatio + 0.5f);
            }
        }
        return constraintWidget.getHeight();
    }

    private final int getWidgetWidth(ConstraintWidget constraintWidget, int n) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.mMatchConstraintDefaultWidth == 0) {
                return 0;
            }
            if (constraintWidget.mMatchConstraintDefaultWidth == 2) {
                if ((n = (int)(constraintWidget.mMatchConstraintPercentWidth * (float)n)) != constraintWidget.getWidth()) {
                    this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, n, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return n;
            }
            if (constraintWidget.mMatchConstraintDefaultWidth == 1) {
                return constraintWidget.getWidth();
            }
            if (constraintWidget.mMatchConstraintDefaultWidth == 3) {
                return (int)((float)constraintWidget.getHeight() * constraintWidget.mDimensionRatio + 0.5f);
            }
        }
        return constraintWidget.getWidth();
    }

    private void measureAligned(ConstraintWidget[] constraintWidgetArray, int n, int n2, int n3, int[] nArray) {
        ConstraintWidget constraintWidget;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        block45: {
            block44: {
                n10 = 0;
                n9 = 0;
                n8 = 0;
                if (n2 == 0) {
                    n7 = this.mMaxElementsWrap;
                    n6 = n9;
                    n5 = n7;
                    if (n7 <= 0) {
                        n6 = 0;
                        n5 = 0;
                        for (n4 = 0; n4 < n; ++n4) {
                            n7 = n6;
                            if (n4 > 0) {
                                n7 = n6 + this.mHorizontalGap;
                            }
                            if ((constraintWidget = constraintWidgetArray[n4]) == null) {
                                n6 = n7;
                                continue;
                            }
                            n6 = n7 + this.getWidgetWidth(constraintWidget, n3);
                            if (n6 > n3) break;
                            ++n5;
                        }
                        n6 = n9;
                    }
                } else {
                    n6 = n7 = this.mMaxElementsWrap;
                    n5 = n8;
                    if (n7 <= 0) {
                        n4 = 0;
                        n7 = 0;
                        n9 = 0;
                        while (true) {
                            n6 = n7;
                            n5 = n8;
                            if (n9 >= n) break;
                            n6 = n4;
                            if (n9 > 0) {
                                n6 = n4 + this.mVerticalGap;
                            }
                            if ((constraintWidget = constraintWidgetArray[n9]) == null) {
                                n4 = n6;
                            } else {
                                n4 = n6 + this.getWidgetHeight(constraintWidget, n3);
                                if (n4 > n3) {
                                    n6 = n7;
                                    n5 = n8;
                                    break;
                                }
                                ++n7;
                            }
                            ++n9;
                        }
                    }
                }
                if (this.mAlignedDimensions == null) {
                    this.mAlignedDimensions = new int[2];
                }
                if (n6 == 0 && n2 == 1) break block44;
                n7 = n10;
                n4 = n6;
                n9 = n5;
                if (n5 != 0) break block45;
                n7 = n10;
                n4 = n6;
                n9 = n5;
                if (n2 != 0) break block45;
            }
            n7 = 1;
            n9 = n5;
            n4 = n6;
        }
        while (n7 == 0) {
            if (n2 == 0) {
                n4 = (int)Math.ceil((float)n / (float)n9);
                n5 = n9;
            } else {
                n5 = (int)Math.ceil((float)n / (float)n4);
            }
            if (this.mAlignedBiggestElementsInCols != null && this.mAlignedBiggestElementsInCols.length >= n5) {
                Arrays.fill(this.mAlignedBiggestElementsInCols, null);
            } else {
                this.mAlignedBiggestElementsInCols = new ConstraintWidget[n5];
            }
            if (this.mAlignedBiggestElementsInRows != null && this.mAlignedBiggestElementsInRows.length >= n4) {
                Arrays.fill(this.mAlignedBiggestElementsInRows, null);
            } else {
                this.mAlignedBiggestElementsInRows = new ConstraintWidget[n4];
            }
            for (n6 = 0; n6 < n5; ++n6) {
                for (n9 = 0; n9 < n4; ++n9) {
                    n10 = n9 * n5 + n6;
                    if (n2 == 1) {
                        n10 = n6 * n4 + n9;
                    }
                    if (n10 >= constraintWidgetArray.length || (constraintWidget = constraintWidgetArray[n10]) == null) continue;
                    n10 = this.getWidgetWidth(constraintWidget, n3);
                    if (this.mAlignedBiggestElementsInCols[n6] == null || this.mAlignedBiggestElementsInCols[n6].getWidth() < n10) {
                        this.mAlignedBiggestElementsInCols[n6] = constraintWidget;
                    }
                    n10 = this.getWidgetHeight(constraintWidget, n3);
                    if (this.mAlignedBiggestElementsInRows[n9] != null && this.mAlignedBiggestElementsInRows[n9].getHeight() >= n10) continue;
                    this.mAlignedBiggestElementsInRows[n9] = constraintWidget;
                }
            }
            n6 = 0;
            for (n9 = 0; n9 < n5; ++n9) {
                constraintWidget = this.mAlignedBiggestElementsInCols[n9];
                n10 = n6;
                if (constraintWidget != null) {
                    n10 = n6;
                    if (n9 > 0) {
                        n10 = n6 + this.mHorizontalGap;
                    }
                    n10 += this.getWidgetWidth(constraintWidget, n3);
                }
                n6 = n10;
            }
            n9 = 0;
            for (n10 = 0; n10 < n4; ++n10) {
                constraintWidget = this.mAlignedBiggestElementsInRows[n10];
                n8 = n9;
                if (constraintWidget != null) {
                    n8 = n9;
                    if (n10 > 0) {
                        n8 = n9 + this.mVerticalGap;
                    }
                    n8 += this.getWidgetHeight(constraintWidget, n3);
                }
                n9 = n8;
            }
            nArray[0] = n6;
            nArray[1] = n9;
            if (n2 == 0) {
                if (n6 > n3) {
                    if (n5 > 1) {
                        --n5;
                        n6 = n7;
                    } else {
                        n6 = 1;
                    }
                } else {
                    n6 = 1;
                }
            } else if (n9 > n3) {
                if (n4 > 1) {
                    --n4;
                    n6 = n7;
                } else {
                    n6 = 1;
                }
            } else {
                n6 = 1;
            }
            n7 = n6;
            n9 = n5;
        }
        this.mAlignedDimensions[0] = n9;
        this.mAlignedDimensions[1] = n4;
    }

    private void measureChainWrap(ConstraintWidget[] object, int n, int n2, int n3, int[] nArray) {
        int n4;
        Object object2;
        int n5;
        int n6;
        if (n == 0) {
            return;
        }
        this.mChainList.clear();
        Object object3 = new WidgetsList(this, n2, this.mLeft, this.mTop, this.mRight, this.mBottom, n3);
        this.mChainList.add((WidgetsList)object3);
        int n7 = 0;
        int n8 = 0;
        if (n2 == 0) {
            n6 = 0;
            for (n5 = 0; n5 < n; ++n5) {
                object2 = object[n5];
                n4 = this.getWidgetWidth((ConstraintWidget)object2, n3);
                if (((ConstraintWidget)object2).getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ++n8;
                }
                if ((n7 = (n6 == n3 || this.mHorizontalGap + n6 + n4 > n3) && ((WidgetsList)object3).biggest != null ? 1 : 0) == 0 && n5 > 0 && this.mMaxElementsWrap > 0 && n5 % this.mMaxElementsWrap == 0) {
                    n7 = 1;
                }
                if (n7 != 0) {
                    object3 = new WidgetsList(this, n2, this.mLeft, this.mTop, this.mRight, this.mBottom, n3);
                    ((WidgetsList)object3).setStartIndex(n5);
                    this.mChainList.add((WidgetsList)object3);
                    n7 = n4;
                } else {
                    n7 = n5 > 0 ? n6 + (this.mHorizontalGap + n4) : n4;
                }
                ((WidgetsList)object3).add((ConstraintWidget)object2);
                n6 = n7;
            }
            object = object3;
        } else {
            n6 = 0;
            for (n5 = 0; n5 < n; ++n5) {
                object2 = object[n5];
                n4 = this.getWidgetHeight((ConstraintWidget)object2, n3);
                if (((ConstraintWidget)object2).getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ++n7;
                }
                if ((n8 = (n6 == n3 || this.mVerticalGap + n6 + n4 > n3) && ((WidgetsList)object3).biggest != null ? 1 : 0) == 0 && n5 > 0 && this.mMaxElementsWrap > 0 && n5 % this.mMaxElementsWrap == 0) {
                    n8 = 1;
                }
                if (n8 != 0) {
                    object3 = new WidgetsList(this, n2, this.mLeft, this.mTop, this.mRight, this.mBottom, n3);
                    ((WidgetsList)object3).setStartIndex(n5);
                    this.mChainList.add((WidgetsList)object3);
                    n8 = n4;
                } else {
                    n8 = n5 > 0 ? n6 + (this.mVerticalGap + n4) : n4;
                }
                ((WidgetsList)object3).add((ConstraintWidget)object2);
                n6 = n8;
            }
            object = object3;
            n8 = n7;
        }
        int n9 = this.mChainList.size();
        ConstraintAnchor constraintAnchor = this.mLeft;
        object = this.mTop;
        Object object4 = this.mRight;
        object2 = this.mBottom;
        int n10 = this.getPaddingLeft();
        int n11 = this.getPaddingTop();
        n4 = this.getPaddingRight();
        n6 = this.getPaddingBottom();
        n = this.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1;
        if (n8 > 0 && n != 0) {
            for (n7 = 0; n7 < n9; ++n7) {
                object3 = this.mChainList.get(n7);
                if (n2 == 0) {
                    ((WidgetsList)object3).measureMatchConstraints(n3 - ((WidgetsList)object3).getWidth());
                    continue;
                }
                ((WidgetsList)object3).measureMatchConstraints(n3 - ((WidgetsList)object3).getHeight());
            }
        }
        n = 0;
        n8 = 0;
        for (n5 = 0; n5 < n9; ++n5) {
            WidgetsList widgetsList = this.mChainList.get(n5);
            if (n2 == 0) {
                if (n5 < n9 - 1) {
                    object3 = ((WidgetsList)this.mChainList.get((int)(n5 + 1))).biggest.mTop;
                    n7 = 0;
                } else {
                    object3 = this.mBottom;
                    n7 = this.getPaddingBottom();
                }
                object2 = ((WidgetsList)widgetsList).biggest.mBottom;
                widgetsList.setup(n2, constraintAnchor, (ConstraintAnchor)object, (ConstraintAnchor)object4, (ConstraintAnchor)object3, n10, n11, n4, n7, n3);
                n11 = 0;
                n = Math.max(n, widgetsList.getWidth());
                n8 = n6 = n8 + widgetsList.getHeight();
                if (n5 > 0) {
                    n8 = n6 + this.mVerticalGap;
                }
                object = object2;
                object2 = object3;
                n6 = n7;
                continue;
            }
            if (n5 < n9 - 1) {
                object3 = ((WidgetsList)this.mChainList.get((int)(n5 + 1))).biggest.mLeft;
                n7 = 0;
            } else {
                object3 = this.mRight;
                n7 = this.getPaddingRight();
            }
            object4 = ((WidgetsList)widgetsList).biggest.mRight;
            widgetsList.setup(n2, constraintAnchor, (ConstraintAnchor)object, (ConstraintAnchor)object3, (ConstraintAnchor)object2, n10, n11, n7, n6, n3);
            constraintAnchor = object4;
            n10 = 0;
            n += widgetsList.getWidth();
            n8 = Math.max(n8, widgetsList.getHeight());
            if (n5 > 0) {
                n += this.mHorizontalGap;
                object4 = object3;
                n4 = n7;
                continue;
            }
            n4 = n7;
            object4 = object3;
        }
        nArray[0] = n;
        nArray[1] = n8;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArray, int n, int n2, int n3, int[] nArray) {
        WidgetsList widgetsList;
        if (n == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(this, n2, this.mLeft, this.mTop, this.mRight, this.mBottom, n3);
            this.mChainList.add(widgetsList);
        } else {
            widgetsList = this.mChainList.get(0);
            widgetsList.clear();
            widgetsList.setup(n2, this.mLeft, this.mTop, this.mRight, this.mBottom, this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom(), n3);
        }
        for (n2 = 0; n2 < n; ++n2) {
            widgetsList.add(constraintWidgetArray[n2]);
        }
        nArray[0] = widgetsList.getWidth();
        nArray[1] = widgetsList.getHeight();
    }

    @Override
    public void addToSolver(LinearSystem object) {
        super.addToSolver((LinearSystem)object);
        boolean bl = this.getParent() != null ? ((ConstraintWidgetContainer)this.getParent()).isRtl() : false;
        switch (this.mWrapMode) {
            default: {
                break;
            }
            case 2: {
                this.createAlignedConstraints(bl);
                break;
            }
            case 1: {
                int n = this.mChainList.size();
                for (int i = 0; i < n; ++i) {
                    object = this.mChainList.get(i);
                    boolean bl2 = i == n - 1;
                    ((WidgetsList)object).createConstraints(bl, i, bl2);
                }
                break;
            }
            case 0: {
                if (this.mChainList.size() <= 0) break;
                this.mChainList.get(0).createConstraints(bl, 0, true);
            }
        }
        this.needsCallbackFromSolver(false);
    }

    @Override
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        constraintWidget = (Flow)constraintWidget;
        this.mHorizontalStyle = ((Flow)constraintWidget).mHorizontalStyle;
        this.mVerticalStyle = ((Flow)constraintWidget).mVerticalStyle;
        this.mFirstHorizontalStyle = ((Flow)constraintWidget).mFirstHorizontalStyle;
        this.mFirstVerticalStyle = ((Flow)constraintWidget).mFirstVerticalStyle;
        this.mLastHorizontalStyle = ((Flow)constraintWidget).mLastHorizontalStyle;
        this.mLastVerticalStyle = ((Flow)constraintWidget).mLastVerticalStyle;
        this.mHorizontalBias = ((Flow)constraintWidget).mHorizontalBias;
        this.mVerticalBias = ((Flow)constraintWidget).mVerticalBias;
        this.mFirstHorizontalBias = ((Flow)constraintWidget).mFirstHorizontalBias;
        this.mFirstVerticalBias = ((Flow)constraintWidget).mFirstVerticalBias;
        this.mLastHorizontalBias = ((Flow)constraintWidget).mLastHorizontalBias;
        this.mLastVerticalBias = ((Flow)constraintWidget).mLastVerticalBias;
        this.mHorizontalGap = ((Flow)constraintWidget).mHorizontalGap;
        this.mVerticalGap = ((Flow)constraintWidget).mVerticalGap;
        this.mHorizontalAlign = ((Flow)constraintWidget).mHorizontalAlign;
        this.mVerticalAlign = ((Flow)constraintWidget).mVerticalAlign;
        this.mWrapMode = ((Flow)constraintWidget).mWrapMode;
        this.mMaxElementsWrap = ((Flow)constraintWidget).mMaxElementsWrap;
        this.mOrientation = ((Flow)constraintWidget).mOrientation;
    }

    @Override
    public void measure(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        if (this.mWidgetsCount > 0 && !this.measureChildren()) {
            this.setMeasure(0, 0);
            this.needsCallbackFromSolver(false);
            return;
        }
        int n7 = this.getPaddingLeft();
        int n8 = this.getPaddingRight();
        int n9 = this.getPaddingTop();
        int n10 = this.getPaddingBottom();
        int[] nArray = new int[2];
        int n11 = this.mOrientation == 1 ? n4 - n9 - n10 : n2 - n7 - n8;
        if (this.mOrientation == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArray = this.mWidgets;
        int n12 = 0;
        for (n6 = 0; n6 < this.mWidgetsCount; ++n6) {
            n5 = n12;
            if (this.mWidgets[n6].getVisibility() == 8) {
                n5 = n12 + 1;
            }
            n12 = n5;
        }
        n6 = this.mWidgetsCount;
        if (n12 > 0) {
            constraintWidgetArray = new ConstraintWidget[this.mWidgetsCount - n12];
            n12 = 0;
            for (n5 = 0; n5 < this.mWidgetsCount; ++n5) {
                ConstraintWidget constraintWidget = this.mWidgets[n5];
                int n13 = n12;
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArray[n12] = constraintWidget;
                    n13 = n12 + 1;
                }
                n12 = n13;
            }
            n6 = n12;
        }
        this.mDisplayedWidgets = constraintWidgetArray;
        this.mDisplayedWidgetsCount = n6;
        switch (this.mWrapMode) {
            default: {
                break;
            }
            case 2: {
                this.measureAligned(constraintWidgetArray, n6, this.mOrientation, n11, nArray);
                break;
            }
            case 1: {
                this.measureChainWrap(constraintWidgetArray, n6, this.mOrientation, n11, nArray);
                break;
            }
            case 0: {
                this.measureNoWrap(constraintWidgetArray, n6, this.mOrientation, n11, nArray);
            }
        }
        boolean bl = false;
        n5 = nArray[0] + n7 + n8;
        n12 = nArray[1] + n9 + n10;
        n6 = 0;
        n11 = 0;
        if (n != 0x40000000) {
            if (n == Integer.MIN_VALUE) {
                n2 = Math.min(n5, n2);
            } else {
                n2 = n6;
                if (n == 0) {
                    n2 = n5;
                }
            }
        }
        if (n3 == 0x40000000) {
            n = n4;
        } else if (n3 == Integer.MIN_VALUE) {
            n = Math.min(n12, n4);
        } else {
            n = n11;
            if (n3 == 0) {
                n = n12;
            }
        }
        this.setMeasure(n2, n);
        this.setWidth(n2);
        this.setHeight(n);
        if (this.mWidgetsCount > 0) {
            bl = true;
        }
        this.needsCallbackFromSolver(bl);
    }

    public void setFirstHorizontalBias(float f) {
        this.mFirstHorizontalBias = f;
    }

    public void setFirstHorizontalStyle(int n) {
        this.mFirstHorizontalStyle = n;
    }

    public void setFirstVerticalBias(float f) {
        this.mFirstVerticalBias = f;
    }

    public void setFirstVerticalStyle(int n) {
        this.mFirstVerticalStyle = n;
    }

    public void setHorizontalAlign(int n) {
        this.mHorizontalAlign = n;
    }

    public void setHorizontalBias(float f) {
        this.mHorizontalBias = f;
    }

    public void setHorizontalGap(int n) {
        this.mHorizontalGap = n;
    }

    public void setHorizontalStyle(int n) {
        this.mHorizontalStyle = n;
    }

    public void setLastHorizontalBias(float f) {
        this.mLastHorizontalBias = f;
    }

    public void setLastHorizontalStyle(int n) {
        this.mLastHorizontalStyle = n;
    }

    public void setLastVerticalBias(float f) {
        this.mLastVerticalBias = f;
    }

    public void setLastVerticalStyle(int n) {
        this.mLastVerticalStyle = n;
    }

    public void setMaxElementsWrap(int n) {
        this.mMaxElementsWrap = n;
    }

    public void setOrientation(int n) {
        this.mOrientation = n;
    }

    public void setVerticalAlign(int n) {
        this.mVerticalAlign = n;
    }

    public void setVerticalBias(float f) {
        this.mVerticalBias = f;
    }

    public void setVerticalGap(int n) {
        this.mVerticalGap = n;
    }

    public void setVerticalStyle(int n) {
        this.mVerticalStyle = n;
    }

    public void setWrapMode(int n) {
        this.mWrapMode = n;
    }

    private class WidgetsList {
        private ConstraintWidget biggest;
        int biggestDimension;
        private ConstraintAnchor mBottom;
        private int mCount;
        private int mHeight;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mNbMatchConstraintsWidgets;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private int mStartIndex;
        private ConstraintAnchor mTop;
        private int mWidth;
        final Flow this$0;

        public WidgetsList(Flow flow2, int n, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int n2) {
            this.this$0 = flow2;
            this.mOrientation = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
            this.mMax = 0;
            this.mOrientation = n;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = flow2.getPaddingLeft();
            this.mPaddingTop = flow2.getPaddingTop();
            this.mPaddingRight = flow2.getPaddingRight();
            this.mPaddingBottom = flow2.getPaddingBottom();
            this.mMax = n2;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int n = this.mCount;
            for (int i = 0; i < n && this.mStartIndex + i < this.this$0.mDisplayedWidgetsCount; ++i) {
                int n2;
                int n3;
                ConstraintWidget constraintWidget = this.this$0.mDisplayedWidgets[this.mStartIndex + i];
                if (this.mOrientation == 0) {
                    n3 = constraintWidget.getWidth();
                    n2 = this.this$0.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        n2 = 0;
                    }
                    this.mWidth += n3 + n2;
                    n2 = this.this$0.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest != null && this.biggestDimension >= n2) continue;
                    this.biggest = constraintWidget;
                    this.biggestDimension = n2;
                    this.mHeight = n2;
                    continue;
                }
                int n4 = this.this$0.getWidgetWidth(constraintWidget, this.mMax);
                n3 = this.this$0.getWidgetHeight(constraintWidget, this.mMax);
                n2 = this.this$0.mVerticalGap;
                if (constraintWidget.getVisibility() == 8) {
                    n2 = 0;
                }
                this.mHeight += n3 + n2;
                if (this.biggest != null && this.biggestDimension >= n4) continue;
                this.biggest = constraintWidget;
                this.biggestDimension = n4;
                this.mWidth = n4;
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            if (this.mOrientation == 0) {
                int n = this.this$0.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ++this.mNbMatchConstraintsWidgets;
                    n = 0;
                }
                int n2 = this.this$0.mHorizontalGap;
                if (constraintWidget.getVisibility() == 8) {
                    n2 = 0;
                }
                this.mWidth += n + n2;
                n = this.this$0.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < n) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = n;
                    this.mHeight = n;
                }
            } else {
                int n = this.this$0.getWidgetWidth(constraintWidget, this.mMax);
                int n3 = this.this$0.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ++this.mNbMatchConstraintsWidgets;
                    n3 = 0;
                }
                int n4 = this.this$0.mVerticalGap;
                if (constraintWidget.getVisibility() == 8) {
                    n4 = 0;
                }
                this.mHeight += n3 + n4;
                if (this.biggest == null || this.biggestDimension < n) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = n;
                    this.mWidth = n;
                }
            }
            ++this.mCount;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean bl, int n, boolean bl2) {
            block61: {
                block60: {
                    int n2;
                    int n3;
                    int n4;
                    boolean bl3;
                    ConstraintWidget constraintWidget;
                    int n5;
                    int n6;
                    block62: {
                        ConstraintWidget constraintWidget2;
                        n6 = this.mCount;
                        for (n5 = 0; n5 < n6 && this.mStartIndex + n5 < this.this$0.mDisplayedWidgetsCount; ++n5) {
                            constraintWidget = this.this$0.mDisplayedWidgets[this.mStartIndex + n5];
                            if (constraintWidget == null) continue;
                            constraintWidget.resetAnchors();
                        }
                        if (n6 == 0 || this.biggest == null) break block61;
                        bl3 = bl2 && n == 0;
                        n4 = -1;
                        n3 = -1;
                        for (n5 = 0; n5 < n6; ++n5) {
                            int n7 = n5;
                            if (bl) {
                                n7 = n6 - 1 - n5;
                            }
                            if (this.mStartIndex + n7 >= this.this$0.mDisplayedWidgetsCount) break;
                            n2 = n4;
                            int n8 = n3;
                            if (this.this$0.mDisplayedWidgets[this.mStartIndex + n7].getVisibility() == 0) {
                                n3 = n4;
                                if (n4 == -1) {
                                    n3 = n5;
                                }
                                n8 = n5;
                                n2 = n3;
                            }
                            n4 = n2;
                            n3 = n8;
                        }
                        constraintWidget = null;
                        ConstraintWidget constraintWidget3 = null;
                        if (this.mOrientation != 0) break block62;
                        ConstraintWidget constraintWidget4 = this.biggest;
                        constraintWidget4.setVerticalChainStyle(this.this$0.mVerticalStyle);
                        n5 = n2 = this.mPaddingTop;
                        if (n > 0) {
                            n5 = n2 + this.this$0.mVerticalGap;
                        }
                        constraintWidget4.mTop.connect(this.mTop, n5);
                        if (bl2) {
                            constraintWidget4.mBottom.connect(this.mBottom, this.mPaddingBottom);
                        }
                        if (n > 0) {
                            this.mTop.mOwner.mBottom.connect(constraintWidget4.mTop, 0);
                        }
                        constraintWidget = constraintWidget2 = constraintWidget4;
                        if (this.this$0.mVerticalAlign == 3) {
                            constraintWidget = constraintWidget2;
                            if (!constraintWidget4.hasBaseline()) {
                                n = 0;
                                while (true) {
                                    constraintWidget = constraintWidget2;
                                    if (n >= n6) break;
                                    n5 = n;
                                    if (bl) {
                                        n5 = n6 - 1 - n;
                                    }
                                    if (this.mStartIndex + n5 >= this.this$0.mDisplayedWidgetsCount) {
                                        constraintWidget = constraintWidget2;
                                        break;
                                    }
                                    constraintWidget = this.this$0.mDisplayedWidgets[this.mStartIndex + n5];
                                    if (constraintWidget.hasBaseline()) break;
                                    ++n;
                                }
                            }
                        }
                        constraintWidget2 = constraintWidget3;
                        for (n = 0; n < n6; ++n) {
                            block63: {
                                block64: {
                                    n5 = n;
                                    if (bl) {
                                        n5 = n6 - 1 - n;
                                    }
                                    if (this.mStartIndex + n5 >= this.this$0.mDisplayedWidgetsCount) break block60;
                                    constraintWidget3 = this.this$0.mDisplayedWidgets[this.mStartIndex + n5];
                                    if (n == 0) {
                                        constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, this.mPaddingLeft);
                                    }
                                    if (n5 == 0) {
                                        float f;
                                        n2 = this.this$0.mHorizontalStyle;
                                        float f2 = this.this$0.mHorizontalBias;
                                        if (this.mStartIndex == 0 && this.this$0.mFirstHorizontalStyle != -1) {
                                            n5 = this.this$0.mFirstHorizontalStyle;
                                            f = this.this$0.mFirstHorizontalBias;
                                        } else {
                                            n5 = n2;
                                            f = f2;
                                            if (bl2) {
                                                n5 = n2;
                                                f = f2;
                                                if (this.this$0.mLastHorizontalStyle != -1) {
                                                    n5 = this.this$0.mLastHorizontalStyle;
                                                    f = this.this$0.mLastHorizontalBias;
                                                }
                                            }
                                        }
                                        constraintWidget3.setHorizontalChainStyle(n5);
                                        constraintWidget3.setHorizontalBiasPercent(f);
                                    }
                                    if (n == n6 - 1) {
                                        constraintWidget3.connect(constraintWidget3.mRight, this.mRight, this.mPaddingRight);
                                    }
                                    if (constraintWidget2 != null) {
                                        constraintWidget3.mLeft.connect(constraintWidget2.mRight, this.this$0.mHorizontalGap);
                                        if (n == n4) {
                                            constraintWidget3.mLeft.setGoneMargin(this.mPaddingLeft);
                                        }
                                        constraintWidget2.mRight.connect(constraintWidget3.mLeft, 0);
                                        if (n == n3 + 1) {
                                            constraintWidget2.mRight.setGoneMargin(this.mPaddingRight);
                                        }
                                    }
                                    if (constraintWidget3 == constraintWidget4) break block63;
                                    if (this.this$0.mVerticalAlign != 3 || !constraintWidget.hasBaseline() || constraintWidget3 == constraintWidget || !constraintWidget3.hasBaseline()) break block64;
                                    constraintWidget3.mBaseline.connect(constraintWidget.mBaseline, 0);
                                    break block63;
                                }
                                switch (this.this$0.mVerticalAlign) {
                                    default: {
                                        if (!bl3) break;
                                        constraintWidget3.mTop.connect(this.mTop, this.mPaddingTop);
                                        constraintWidget3.mBottom.connect(this.mBottom, this.mPaddingBottom);
                                        break block63;
                                    }
                                    case 1: {
                                        constraintWidget3.mBottom.connect(constraintWidget4.mBottom, 0);
                                        break block63;
                                    }
                                    case 0: {
                                        constraintWidget3.mTop.connect(constraintWidget4.mTop, 0);
                                        break block63;
                                    }
                                }
                                constraintWidget3.mTop.connect(constraintWidget4.mTop, 0);
                                constraintWidget3.mBottom.connect(constraintWidget4.mBottom, 0);
                            }
                            constraintWidget2 = constraintWidget3;
                        }
                        break block60;
                    }
                    ConstraintWidget constraintWidget5 = this.biggest;
                    constraintWidget5.setHorizontalChainStyle(this.this$0.mHorizontalStyle);
                    n5 = n2 = this.mPaddingLeft;
                    if (n > 0) {
                        n5 = n2 + this.this$0.mHorizontalGap;
                    }
                    if (bl) {
                        constraintWidget5.mRight.connect(this.mRight, n5);
                        if (bl2) {
                            constraintWidget5.mLeft.connect(this.mLeft, this.mPaddingRight);
                        }
                        if (n > 0) {
                            this.mRight.mOwner.mLeft.connect(constraintWidget5.mRight, 0);
                        }
                    } else {
                        constraintWidget5.mLeft.connect(this.mLeft, n5);
                        if (bl2) {
                            constraintWidget5.mRight.connect(this.mRight, this.mPaddingRight);
                        }
                        if (n > 0) {
                            this.mLeft.mOwner.mRight.connect(constraintWidget5.mLeft, 0);
                        }
                    }
                    for (n5 = 0; n5 < n6 && this.mStartIndex + n5 < this.this$0.mDisplayedWidgetsCount; ++n5) {
                        ConstraintWidget constraintWidget6 = this.this$0.mDisplayedWidgets[this.mStartIndex + n5];
                        if (n5 == 0) {
                            float f;
                            constraintWidget6.connect(constraintWidget6.mTop, this.mTop, this.mPaddingTop);
                            n2 = this.this$0.mVerticalStyle;
                            float f3 = this.this$0.mVerticalBias;
                            if (this.mStartIndex == 0 && this.this$0.mFirstVerticalStyle != -1) {
                                n = this.this$0.mFirstVerticalStyle;
                                f = this.this$0.mFirstVerticalBias;
                            } else {
                                n = n2;
                                f = f3;
                                if (bl2) {
                                    n = n2;
                                    f = f3;
                                    if (this.this$0.mLastVerticalStyle != -1) {
                                        n = this.this$0.mLastVerticalStyle;
                                        f = this.this$0.mLastVerticalBias;
                                    }
                                }
                            }
                            constraintWidget6.setVerticalChainStyle(n);
                            constraintWidget6.setVerticalBiasPercent(f);
                        }
                        if (n5 == n6 - 1) {
                            constraintWidget6.connect(constraintWidget6.mBottom, this.mBottom, this.mPaddingBottom);
                        }
                        if (constraintWidget != null) {
                            constraintWidget6.mTop.connect(constraintWidget.mBottom, this.this$0.mVerticalGap);
                            if (n5 == n4) {
                                constraintWidget6.mTop.setGoneMargin(this.mPaddingTop);
                            }
                            constraintWidget.mBottom.connect(constraintWidget6.mTop, 0);
                            if (n5 == n3 + 1) {
                                constraintWidget.mBottom.setGoneMargin(this.mPaddingBottom);
                            }
                        }
                        if (constraintWidget6 != constraintWidget5) {
                            if (bl) {
                                switch (this.this$0.mHorizontalAlign) {
                                    default: {
                                        break;
                                    }
                                    case 2: {
                                        constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                        constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                        break;
                                    }
                                    case 1: {
                                        constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                        break;
                                    }
                                    case 0: {
                                        constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                        break;
                                    }
                                }
                            } else {
                                switch (this.this$0.mHorizontalAlign) {
                                    default: {
                                        break;
                                    }
                                    case 2: {
                                        if (bl3) {
                                            constraintWidget6.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                            constraintWidget6.mRight.connect(this.mRight, this.mPaddingRight);
                                            break;
                                        }
                                        constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                        constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                        break;
                                    }
                                    case 1: {
                                        constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                        break;
                                    }
                                    case 0: {
                                        constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                        break;
                                    }
                                }
                            }
                        }
                        constraintWidget = constraintWidget6;
                    }
                }
                return;
            }
        }

        public int getHeight() {
            if (this.mOrientation == 1) {
                return this.mHeight - this.this$0.mVerticalGap;
            }
            return this.mHeight;
        }

        public int getWidth() {
            if (this.mOrientation == 0) {
                return this.mWidth - this.this$0.mHorizontalGap;
            }
            return this.mWidth;
        }

        public void measureMatchConstraints(int n) {
            if (this.mNbMatchConstraintsWidgets == 0) {
                return;
            }
            int n2 = this.mCount;
            int n3 = n / this.mNbMatchConstraintsWidgets;
            for (n = 0; n < n2 && this.mStartIndex + n < this.this$0.mDisplayedWidgetsCount; ++n) {
                ConstraintWidget constraintWidget = this.this$0.mDisplayedWidgets[this.mStartIndex + n];
                if (this.mOrientation == 0) {
                    if (constraintWidget == null || constraintWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultWidth != 0) continue;
                    this.this$0.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, n3, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    continue;
                }
                if (constraintWidget == null || constraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultHeight != 0) continue;
                this.this$0.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, n3);
            }
            this.recomputeDimensions();
        }

        public void setStartIndex(int n) {
            this.mStartIndex = n;
        }

        public void setup(int n, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int n2, int n3, int n4, int n5, int n6) {
            this.mOrientation = n;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = n2;
            this.mPaddingTop = n3;
            this.mPaddingRight = n4;
            this.mPaddingBottom = n5;
            this.mMax = n6;
        }
    }
}

