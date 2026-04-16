/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 0x40000000;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private Measure mMeasure;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList();

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mMeasure = new Measure();
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, boolean bl) {
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        this.mMeasure.measuredNeedsSolverPass = false;
        this.mMeasure.useCurrentDimensions = bl;
        boolean bl2 = this.mMeasure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean bl3 = this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        bl2 = bl2 && constraintWidget.mDimensionRatio > 0.0f;
        bl3 = bl3 && constraintWidget.mDimensionRatio > 0.0f;
        if (bl2 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (bl3 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        this.mMeasure.useCurrentDimensions = false;
        return this.mMeasure.measuredNeedsSolverPass;
    }

    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer) {
        int n = constraintWidgetContainer.mChildren.size();
        Measurer measurer = constraintWidgetContainer.getMeasurer();
        for (int i = 0; i < n; ++i) {
            Object object = (ConstraintWidget)constraintWidgetContainer.mChildren.get(i);
            if (object instanceof Guideline || ((ConstraintWidget)object).horizontalRun.dimension.resolved && ((ConstraintWidget)object).verticalRun.dimension.resolved) continue;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ((ConstraintWidget)object).getDimensionBehaviour(0);
            boolean bl = true;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ((ConstraintWidget)object).getDimensionBehaviour(1);
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || ((ConstraintWidget)object).mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || ((ConstraintWidget)object).mMatchConstraintDefaultHeight == 1) {
                bl = false;
            }
            if (bl) continue;
            this.measure(measurer, (ConstraintWidget)object, false);
            if (constraintWidgetContainer.mMetrics == null) continue;
            object = constraintWidgetContainer.mMetrics;
            ++((Metrics)object).measuredWidgets;
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, String string2, int n, int n2) {
        int n3 = constraintWidgetContainer.getMinWidth();
        int n4 = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(n);
        constraintWidgetContainer.setHeight(n2);
        constraintWidgetContainer.setMinWidth(n3);
        constraintWidgetContainer.setMinHeight(n4);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        Object object;
        Measurer measurer = constraintWidgetContainer.getMeasurer();
        n9 = constraintWidgetContainer.mChildren.size();
        int n10 = constraintWidgetContainer.getWidth();
        int n11 = constraintWidgetContainer.getHeight();
        boolean bl = Optimizer.enabled(n, 128);
        n = !bl && !Optimizer.enabled(n, 64) ? 0 : 1;
        if (n != 0) {
            for (n2 = 0; n2 < n9; ++n2) {
                object = (ConstraintWidget)constraintWidgetContainer.mChildren.get(n2);
                n3 = ((ConstraintWidget)object).getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
                n8 = ((ConstraintWidget)object).getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
                n3 = n3 != 0 && n8 != 0 && ((ConstraintWidget)object).getDimensionRatio() > 0.0f ? 1 : 0;
                if (((ConstraintWidget)object).isInHorizontalChain() && n3 != 0) {
                    n = 0;
                    break;
                }
                if (((ConstraintWidget)object).isInVerticalChain() && n3 != 0) {
                    n = 0;
                    break;
                }
                if (object instanceof VirtualLayout) {
                    n = 0;
                    break;
                }
                if (!((ConstraintWidget)object).isInHorizontalChain() && !((ConstraintWidget)object).isInVerticalChain()) {
                    continue;
                }
                n = 0;
                break;
            }
        }
        if (n != 0 && LinearSystem.sMetrics != null) {
            object = LinearSystem.sMetrics;
            ++((Metrics)object).measures;
        }
        boolean bl2 = false;
        n2 = n4 == 0x40000000 && n6 == 0x40000000 || bl ? 1 : 0;
        n3 = 0;
        n8 = 0;
        if ((n2 & n) != 0) {
            boolean bl3;
            n3 = Math.min(constraintWidgetContainer.getMaxWidth(), n5);
            n5 = Math.min(constraintWidgetContainer.getMaxHeight(), n7);
            if (n4 == 0x40000000 && constraintWidgetContainer.getWidth() != n3) {
                constraintWidgetContainer.setWidth(n3);
                constraintWidgetContainer.invalidateGraph();
            }
            if (n6 == 0x40000000 && constraintWidgetContainer.getHeight() != n5) {
                constraintWidgetContainer.setHeight(n5);
                constraintWidgetContainer.invalidateGraph();
            }
            if (n4 == 0x40000000 && n6 == 0x40000000) {
                bl2 = constraintWidgetContainer.directMeasure(bl);
                n = 2;
            } else {
                bl3 = constraintWidgetContainer.directMeasureSetup(bl);
                if (n4 == 0x40000000) {
                    bl3 &= constraintWidgetContainer.directMeasureWithOrientation(bl, 0);
                    n2 = 0 + 1;
                } else {
                    n2 = n8;
                }
                bl2 = bl3;
                n = n2;
                if (n6 == 0x40000000) {
                    bl2 = bl3 & constraintWidgetContainer.directMeasureWithOrientation(bl, 1);
                    n = n2 + 1;
                }
            }
            if (bl2) {
                bl3 = n4 == 0x40000000;
                bl = n6 == 0x40000000;
                constraintWidgetContainer.updateFromRuns(bl3, bl);
            }
            n2 = n3;
        } else {
            n2 = n5;
            n5 = n7;
            n = n3;
        }
        if (!bl2 || n != 2) {
            if (n9 > 0) {
                this.measureChildren(constraintWidgetContainer);
            }
            n4 = constraintWidgetContainer.getOptimizationLevel();
            int n12 = this.mVariableDimensionsWidgets.size();
            if (n9 > 0) {
                this.solveLinearSystem(constraintWidgetContainer, "First pass", n10, n11);
            }
            if (n12 > 0) {
                Object object2;
                int n13;
                n3 = constraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 1 : 0;
                n8 = constraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 1 : 0;
                n7 = Math.max(constraintWidgetContainer.getWidth(), this.constraintWidgetContainer.getMinWidth());
                int n14 = Math.max(constraintWidgetContainer.getHeight(), this.constraintWidgetContainer.getMinHeight());
                int n15 = 0;
                n9 = n;
                int n16 = n5;
                int n17 = n2;
                n5 = n11;
                n6 = n10;
                n = n14;
                n2 = n7;
                n7 = n15;
                for (n13 = 0; n13 < n12; ++n13) {
                    object = this.mVariableDimensionsWidgets.get(n13);
                    if (!(object instanceof VirtualLayout)) continue;
                    n11 = ((ConstraintWidget)object).getWidth();
                    n14 = ((ConstraintWidget)object).getHeight();
                    n7 |= this.measure(measurer, (ConstraintWidget)object, true);
                    if (constraintWidgetContainer.mMetrics != null) {
                        object2 = constraintWidgetContainer.mMetrics;
                        ++((Metrics)object2).measuredMatchWidgets;
                    }
                    n15 = ((ConstraintWidget)object).getWidth();
                    n10 = ((ConstraintWidget)object).getHeight();
                    if (n15 != n11) {
                        ((ConstraintWidget)object).setWidth(n15);
                        if (n3 != 0 && ((ConstraintWidget)object).getRight() > n2) {
                            n2 = Math.max(n2, ((ConstraintWidget)object).getRight() + ((ConstraintWidget)object).getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                        }
                        n7 = 1;
                    }
                    if (n10 != n14) {
                        ((ConstraintWidget)object).setHeight(n10);
                        if (n8 != 0 && ((ConstraintWidget)object).getBottom() > n) {
                            n = Math.max(n, ((ConstraintWidget)object).getBottom() + ((ConstraintWidget)object).getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                        }
                        n7 = 1;
                    }
                    n7 |= ((VirtualLayout)object).needSolverPass();
                }
                n9 = n4;
                n16 = n5;
                n17 = n6;
                n6 = n;
                n5 = n12;
                n4 = n3;
                for (n13 = 0; n13 < 2; ++n13) {
                    n = n6;
                    n3 = n5;
                    for (n14 = 0; n14 < n3; ++n14) {
                        object2 = this.mVariableDimensionsWidgets.get(n14);
                        if (object2 instanceof Helper && !(object2 instanceof VirtualLayout) || object2 instanceof Guideline || ((ConstraintWidget)object2).getVisibility() == 8 || ((ConstraintWidget)object2).horizontalRun.dimension.resolved && ((ConstraintWidget)object2).verticalRun.dimension.resolved || object2 instanceof VirtualLayout) continue;
                        n5 = ((ConstraintWidget)object2).getWidth();
                        n11 = ((ConstraintWidget)object2).getHeight();
                        n10 = ((ConstraintWidget)object2).getBaselineDistance();
                        n6 = n7 | this.measure(measurer, (ConstraintWidget)object2, true);
                        if (constraintWidgetContainer.mMetrics != null) {
                            object = constraintWidgetContainer.mMetrics;
                            ++((Metrics)object).measuredMatchWidgets;
                        }
                        n12 = ((ConstraintWidget)object2).getWidth();
                        n7 = ((ConstraintWidget)object2).getHeight();
                        if (n12 != n5) {
                            ((ConstraintWidget)object2).setWidth(n12);
                            if (n4 != 0 && ((ConstraintWidget)object2).getRight() > n2) {
                                n2 = Math.max(n2, ((ConstraintWidget)object2).getRight() + ((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            n6 = 1;
                        }
                        n5 = n;
                        if (n7 != n11) {
                            ((ConstraintWidget)object2).setHeight(n7);
                            n5 = n;
                            if (n8 != 0) {
                                n5 = n;
                                if (((ConstraintWidget)object2).getBottom() > n) {
                                    n5 = Math.max(n, ((ConstraintWidget)object2).getBottom() + ((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                                }
                            }
                            n6 = 1;
                        }
                        if (((ConstraintWidget)object2).hasBaseline() && n10 != ((ConstraintWidget)object2).getBaselineDistance()) {
                            n7 = 1;
                            n = n5;
                            continue;
                        }
                        n = n5;
                        n7 = n6;
                    }
                    if (n7 != 0) {
                        this.solveLinearSystem(constraintWidgetContainer, "intermediate pass", n17, n16);
                        n7 = 0;
                    }
                    n5 = n3;
                    n6 = n;
                }
                n = n9;
                if (n7 != 0) {
                    this.solveLinearSystem(constraintWidgetContainer, "2nd pass", n17, n16);
                    n = 0;
                    if (constraintWidgetContainer.getWidth() < n2) {
                        constraintWidgetContainer.setWidth(n2);
                        n = 1;
                    }
                    n2 = n;
                    if (constraintWidgetContainer.getHeight() < n6) {
                        constraintWidgetContainer.setHeight(n6);
                        n2 = 1;
                    }
                    n = n9;
                    if (n2 != 0) {
                        this.solveLinearSystem(constraintWidgetContainer, "3rd pass", n17, n16);
                        n = n9;
                    }
                }
            } else {
                n = n4;
            }
            constraintWidgetContainer.setOptimizationLevel(n);
        }
        return 0L;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mVariableDimensionsWidgets.clear();
        int n = constraintWidgetContainer.mChildren.size();
        for (int i = 0; i < n; ++i) {
            ConstraintWidget constraintWidget = (ConstraintWidget)constraintWidgetContainer.mChildren.get(i);
            if (constraintWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && constraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) continue;
            this.mVariableDimensionsWidgets.add(constraintWidget);
        }
        constraintWidgetContainer.invalidateGraph();
    }

    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public static enum MeasureType {

    }

    public static interface Measurer {
        public void didMeasures();

        public void measure(ConstraintWidget var1, Measure var2);
    }
}

