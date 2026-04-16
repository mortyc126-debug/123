/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.HashMap;

public class Barrier
extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private boolean mAllowsGoneWidget = true;
    private int mBarrierType = 0;
    private int mMargin = 0;

    @Override
    public void addToSolver(LinearSystem linearSystem) {
        int n;
        this.mListAnchors[0] = this.mLeft;
        this.mListAnchors[2] = this.mTop;
        this.mListAnchors[1] = this.mRight;
        this.mListAnchors[3] = this.mBottom;
        for (n = 0; n < this.mListAnchors.length; ++n) {
            this.mListAnchors[n].mSolverVariable = linearSystem.createObjectVariable(this.mListAnchors[n]);
        }
        if (this.mBarrierType >= 0 && this.mBarrierType < 4) {
            ConstraintWidget constraintWidget;
            boolean bl;
            ConstraintAnchor constraintAnchor = this.mListAnchors[this.mBarrierType];
            boolean bl2 = false;
            n = 0;
            while (true) {
                bl = bl2;
                if (n >= this.mWidgetsCount) break;
                constraintWidget = this.mWidgets[n];
                if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                    if ((this.mBarrierType == 0 || this.mBarrierType == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) {
                        bl = true;
                        break;
                    }
                    if ((this.mBarrierType == 2 || this.mBarrierType == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                        bl = true;
                        break;
                    }
                }
                ++n;
            }
            n = !this.mLeft.hasCenteredDependents() && !this.mRight.hasCenteredDependents() ? 0 : 1;
            int n2 = !this.mTop.hasCenteredDependents() && !this.mBottom.hasCenteredDependents() ? 0 : 1;
            n2 = !bl && (this.mBarrierType == 0 && n != 0 || this.mBarrierType == 2 && n2 != 0 || this.mBarrierType == 1 && n != 0 || this.mBarrierType == 3 && n2 != 0) ? 1 : 0;
            n = 5;
            if (n2 == 0) {
                n = 4;
            }
            for (n2 = 0; n2 < this.mWidgetsCount; ++n2) {
                int n3;
                SolverVariable solverVariable;
                constraintWidget = this.mWidgets[n2];
                if (!this.mAllowsGoneWidget && !constraintWidget.allowedInBarrier()) continue;
                constraintWidget.mListAnchors[this.mBarrierType].mSolverVariable = solverVariable = linearSystem.createObjectVariable(constraintWidget.mListAnchors[this.mBarrierType]);
                int n4 = n3 = 0;
                if (constraintWidget.mListAnchors[this.mBarrierType].mTarget != null) {
                    n4 = n3;
                    if (constraintWidget.mListAnchors[this.mBarrierType].mTarget.mOwner == this) {
                        n4 = 0 + constraintWidget.mListAnchors[this.mBarrierType].mMargin;
                    }
                }
                if (this.mBarrierType != 0 && this.mBarrierType != 2) {
                    linearSystem.addGreaterBarrier(constraintAnchor.mSolverVariable, solverVariable, this.mMargin + n4, bl);
                } else {
                    linearSystem.addLowerBarrier(constraintAnchor.mSolverVariable, solverVariable, this.mMargin - n4, bl);
                }
                linearSystem.addEquality(constraintAnchor.mSolverVariable, solverVariable, this.mMargin + n4, n);
            }
            if (this.mBarrierType == 0) {
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
            } else if (this.mBarrierType == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
            } else if (this.mBarrierType == 2) {
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
            } else if (this.mBarrierType == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
            }
            return;
        }
    }

    @Override
    public boolean allowedInBarrier() {
        return true;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        constraintWidget = (Barrier)constraintWidget;
        this.mBarrierType = ((Barrier)constraintWidget).mBarrierType;
        this.mAllowsGoneWidget = ((Barrier)constraintWidget).mAllowsGoneWidget;
        this.mMargin = ((Barrier)constraintWidget).mMargin;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    protected void markWidgets() {
        for (int i = 0; i < this.mWidgetsCount; ++i) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (this.mBarrierType != 0 && this.mBarrierType != 1) {
                if (this.mBarrierType != 2 && this.mBarrierType != 3) continue;
                constraintWidget.setInBarrier(1, true);
                continue;
            }
            constraintWidget.setInBarrier(0, true);
        }
    }

    public void setAllowsGoneWidget(boolean bl) {
        this.mAllowsGoneWidget = bl;
    }

    public void setBarrierType(int n) {
        this.mBarrierType = n;
    }

    public void setMargin(int n) {
        this.mMargin = n;
    }

    @Override
    public String toString() {
        String string2 = "[Barrier] " + this.getDebugName() + " {";
        for (int i = 0; i < this.mWidgetsCount; ++i) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            String string3 = string2;
            if (i > 0) {
                string3 = string2 + ", ";
            }
            string2 = string3 + constraintWidget.getDebugName();
        }
        return string2 + "}";
    }
}

