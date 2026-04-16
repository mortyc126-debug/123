/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import java.util.Arrays;
import java.util.HashMap;

public class HelperWidget
extends ConstraintWidget
implements Helper {
    public ConstraintWidget[] mWidgets = new ConstraintWidget[4];
    public int mWidgetsCount = 0;

    @Override
    public void add(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            if (this.mWidgetsCount + 1 > this.mWidgets.length) {
                this.mWidgets = Arrays.copyOf(this.mWidgets, this.mWidgets.length * 2);
            }
            this.mWidgets[this.mWidgetsCount] = constraintWidget;
            ++this.mWidgetsCount;
            return;
        }
    }

    @Override
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        constraintWidget = (HelperWidget)constraintWidget;
        this.mWidgetsCount = 0;
        int n = ((HelperWidget)constraintWidget).mWidgetsCount;
        for (int i = 0; i < n; ++i) {
            this.add(hashMap.get(((HelperWidget)constraintWidget).mWidgets[i]));
        }
    }

    @Override
    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, null);
    }

    @Override
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
    }
}

