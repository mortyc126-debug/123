/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.Chain;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.WidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer
extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    BasicMeasure mBasicMeasureSolver = new BasicMeasure(this);
    int mDebugSolverPassCount = 0;
    public DependencyGraph mDependencyGraph = new DependencyGraph(this);
    public boolean mGroupsWrapOptimized = false;
    private boolean mHeightMeasuredTooSmall = false;
    ChainHead[] mHorizontalChainsArray;
    int mHorizontalChainsSize = 0;
    public boolean mHorizontalWrapOptimized = false;
    private boolean mIsRtl = false;
    protected BasicMeasure.Measurer mMeasurer = null;
    public Metrics mMetrics;
    private int mOptimizationLevel = 263;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver = false;
    protected LinearSystem mSystem = new LinearSystem();
    ChainHead[] mVerticalChainsArray = new ChainHead[4];
    int mVerticalChainsSize = 0;
    public boolean mVerticalWrapOptimized = false;
    private boolean mWidthMeasuredTooSmall = false;
    public int mWrapFixedHeight = 0;
    public int mWrapFixedWidth = 0;

    public ConstraintWidgetContainer() {
        this.mHorizontalChainsArray = new ChainHead[4];
    }

    public ConstraintWidgetContainer(int n, int n2) {
        super(n, n2);
        this.mHorizontalChainsArray = new ChainHead[4];
    }

    public ConstraintWidgetContainer(int n, int n2, int n3, int n4) {
        super(n, n2, n3, n4);
        this.mHorizontalChainsArray = new ChainHead[4];
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        if (this.mHorizontalChainsSize + 1 >= this.mHorizontalChainsArray.length) {
            this.mHorizontalChainsArray = Arrays.copyOf(this.mHorizontalChainsArray, this.mHorizontalChainsArray.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, this.isRtl());
        ++this.mHorizontalChainsSize;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        if (this.mVerticalChainsSize + 1 >= this.mVerticalChainsArray.length) {
            this.mVerticalChainsArray = Arrays.copyOf(this.mVerticalChainsArray, this.mVerticalChainsArray.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, this.isRtl());
        ++this.mVerticalChainsSize;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    void addChain(ConstraintWidget constraintWidget, int n) {
        if (n == 0) {
            this.addHorizontalChain(constraintWidget);
        } else if (n == 1) {
            this.addVerticalChain(constraintWidget);
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        Object object;
        int n;
        this.addToSolver(linearSystem);
        int n2 = this.mChildren.size();
        boolean bl = false;
        for (n = 0; n < n2; ++n) {
            object = (ConstraintWidget)this.mChildren.get(n);
            object.setInBarrier(0, false);
            object.setInBarrier(1, false);
            if (!(object instanceof Barrier)) continue;
            bl = true;
        }
        if (bl) {
            for (n = 0; n < n2; ++n) {
                object = (ConstraintWidget)this.mChildren.get(n);
                if (!(object instanceof Barrier)) continue;
                ((Barrier)object).markWidgets();
            }
        }
        for (n = 0; n < n2; ++n) {
            object = (ConstraintWidget)this.mChildren.get(n);
            if (!object.addFirst()) continue;
            object.addToSolver(linearSystem);
        }
        for (n = 0; n < n2; ++n) {
            ConstraintWidget constraintWidget = (ConstraintWidget)this.mChildren.get(n);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                object = constraintWidget.mListDimensionBehaviors[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.mListDimensionBehaviors[1];
                if (object == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem);
                if (object == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour((ConstraintWidget.DimensionBehaviour)((Object)object));
                }
                if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) continue;
                constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour);
                continue;
            }
            Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
            if (constraintWidget.addFirst()) continue;
            constraintWidget.addToSolver(linearSystem);
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 1);
        }
        return true;
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(this.getHorizontalDimensionBehaviour(), this.getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean bl) {
        return this.mDependencyGraph.directMeasure(bl);
    }

    public boolean directMeasureSetup(boolean bl) {
        return this.mDependencyGraph.directMeasureSetup(bl);
    }

    public boolean directMeasureWithOrientation(boolean bl, int n) {
        return this.mDependencyGraph.directMeasureWithOrientation(bl, n);
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<Guideline>();
        int n = this.mChildren.size();
        for (int i = 0; i < n; ++i) {
            ConstraintWidget constraintWidget = (ConstraintWidget)this.mChildren.get(i);
            if (!(constraintWidget instanceof Guideline) || ((Guideline)(constraintWidget = (Guideline)constraintWidget)).getOrientation() != 0) continue;
            arrayList.add((Guideline)constraintWidget);
        }
        return arrayList;
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    @Override
    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<Guideline>();
        int n = this.mChildren.size();
        for (int i = 0; i < n; ++i) {
            ConstraintWidget constraintWidget = (ConstraintWidget)this.mChildren.get(i);
            if (!(constraintWidget instanceof Guideline) || ((Guideline)(constraintWidget = (Guideline)constraintWidget)).getOrientation() != 1) continue;
            arrayList.add((Guideline)constraintWidget);
        }
        return arrayList;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    @Override
    public void layout() {
        ConstraintWidget constraintWidget;
        this.mX = 0;
        this.mY = 0;
        int n = Math.max(0, this.getWidth());
        int n2 = Math.max(0, this.getHeight());
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        int n3 = !this.optimizeFor(64) && !this.optimizeFor(128) ? 0 : 1;
        this.mSystem.graphOptimizer = false;
        this.mSystem.newgraphOptimizer = false;
        if (this.mOptimizationLevel != 0 && n3 != 0) {
            this.mSystem.newgraphOptimizer = true;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.mListDimensionBehaviors[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mListDimensionBehaviors[0];
        ArrayList arrayList = this.mChildren;
        boolean bl = this.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || this.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        this.resetChains();
        int n4 = this.mChildren.size();
        for (n3 = 0; n3 < n4; ++n3) {
            constraintWidget = (ConstraintWidget)this.mChildren.get(n3);
            if (!(constraintWidget instanceof WidgetContainer)) continue;
            ((WidgetContainer)constraintWidget).layout();
        }
        boolean bl2 = true;
        n3 = 0;
        int n5 = 0;
        while (bl2) {
            boolean bl3;
            int n6;
            block30: {
                block29: {
                    block28: {
                        int n7;
                        block26: {
                            n6 = n5 + 1;
                            bl3 = bl2;
                            this.mSystem.reset();
                            bl3 = bl2;
                            this.resetChains();
                            bl3 = bl2;
                            this.createObjectVariables(this.mSystem);
                            for (n5 = 0; n5 < n4; ++n5) {
                                bl3 = bl2;
                                ((ConstraintWidget)this.mChildren.get(n5)).createObjectVariables(this.mSystem);
                                continue;
                            }
                            bl3 = bl2;
                            bl2 = this.addChildrenToSolver(this.mSystem);
                            if (!bl2) break block26;
                            bl3 = bl2;
                            try {
                                this.mSystem.minimize();
                            }
                            catch (Exception exception) {
                                exception.printStackTrace();
                                System.out.println("EXCEPTION : " + exception);
                            }
                        }
                        bl3 = bl2;
                        if (bl3) {
                            this.updateChildrenFromSolver(this.mSystem, Optimizer.flags);
                        } else {
                            this.updateFromSolver(this.mSystem);
                            for (n5 = 0; n5 < n4; ++n5) {
                                ((ConstraintWidget)this.mChildren.get(n5)).updateFromSolver(this.mSystem);
                            }
                        }
                        bl3 = false;
                        if (!bl || n6 >= 8 || !Optimizer.flags[2]) break block28;
                        int n8 = 0;
                        n5 = 0;
                        for (n7 = 0; n7 < n4; ++n7) {
                            constraintWidget = (ConstraintWidget)this.mChildren.get(n7);
                            n8 = Math.max(n8, constraintWidget.mX + constraintWidget.getWidth());
                            n5 = Math.max(n5, constraintWidget.mY + constraintWidget.getHeight());
                        }
                        bl2 = bl3;
                        n8 = Math.max(this.mMinWidth, n8);
                        n7 = Math.max(this.mMinHeight, n5);
                        n5 = n3;
                        bl3 = bl2;
                        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            n5 = n3;
                            bl3 = bl2;
                            if (this.getWidth() < n8) {
                                this.setWidth(n8);
                                this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                n5 = 1;
                                bl3 = true;
                            }
                        }
                        n3 = n5;
                        bl2 = bl3;
                        if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) break block29;
                        n3 = n5;
                        bl2 = bl3;
                        if (this.getHeight() >= n7) break block29;
                        this.setHeight(n7);
                        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        n3 = 1;
                        bl3 = true;
                        break block30;
                    }
                    bl2 = false;
                }
                bl3 = bl2;
            }
            n5 = Math.max(this.mMinWidth, this.getWidth());
            if (n5 > this.getWidth()) {
                this.setWidth(n5);
                this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                n3 = 1;
                bl3 = true;
            }
            if ((n5 = Math.max(this.mMinHeight, this.getHeight())) > this.getHeight()) {
                this.setHeight(n5);
                this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                n3 = 1;
                bl3 = true;
            }
            if (n3 == 0) {
                bl2 = bl3;
                n5 = n3;
                if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    bl2 = bl3;
                    n5 = n3;
                    if (n > 0) {
                        bl2 = bl3;
                        n5 = n3;
                        if (this.getWidth() > n) {
                            this.mWidthMeasuredTooSmall = true;
                            n5 = 1;
                            this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                            this.setWidth(n);
                            bl2 = true;
                        }
                    }
                }
                if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && n2 > 0 && this.getHeight() > n2) {
                    this.mHeightMeasuredTooSmall = true;
                    n3 = 1;
                    this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                    this.setHeight(n2);
                    bl3 = true;
                } else {
                    bl3 = bl2;
                    n3 = n5;
                }
            }
            n5 = n6;
            bl2 = bl3;
        }
        this.mChildren = arrayList;
        if (n3 != 0) {
            this.mListDimensionBehaviors[0] = dimensionBehaviour2;
            this.mListDimensionBehaviors[1] = dimensionBehaviour;
        }
        this.resetSolverVariables(this.mSystem.getCache());
    }

    public long measure(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        this.mPaddingLeft = n8;
        this.mPaddingTop = n9;
        return this.mBasicMeasureSolver.solverMeasure(this, n, n8, n9, n2, n3, n4, n5, n6, n7);
    }

    public boolean optimizeFor(int n) {
        boolean bl = (this.mOptimizationLevel & n) == n;
        return bl;
    }

    @Override
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
        this.mDependencyGraph.setMeasurer(measurer);
    }

    public void setOptimizationLevel(int n) {
        this.mOptimizationLevel = n;
        LinearSystem.OPTIMIZED_ENGINE = Optimizer.enabled(n, 256);
    }

    public void setPadding(int n, int n2, int n3, int n4) {
        this.mPaddingLeft = n;
        this.mPaddingTop = n2;
        this.mPaddingRight = n3;
        this.mPaddingBottom = n4;
    }

    public void setRtl(boolean bl) {
        this.mIsRtl = bl;
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] blArray) {
        blArray[2] = false;
        this.updateFromSolver(linearSystem);
        int n = this.mChildren.size();
        for (int i = 0; i < n; ++i) {
            ((ConstraintWidget)this.mChildren.get(i)).updateFromSolver(linearSystem);
        }
    }

    @Override
    public void updateFromRuns(boolean bl, boolean bl2) {
        super.updateFromRuns(bl, bl2);
        int n = this.mChildren.size();
        for (int i = 0; i < n; ++i) {
            ((ConstraintWidget)this.mChildren.get(i)).updateFromRuns(bl, bl2);
        }
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }
}

