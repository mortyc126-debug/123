/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.GuidelineReference;
import androidx.constraintlayout.solver.widgets.analyzer.HelperReferences;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.RunGroup;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class DependencyGraph {
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer container;
    private ConstraintWidgetContainer mContainer;
    ArrayList<RunGroup> mGroups;
    private BasicMeasure.Measure mMeasure;
    private BasicMeasure.Measurer mMeasurer = null;
    private boolean mNeedBuildGraph = true;
    private boolean mNeedRedoMeasures = true;
    private ArrayList<WidgetRun> mRuns = new ArrayList();
    private ArrayList<RunGroup> runGroups = new ArrayList();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mMeasure = new BasicMeasure.Measure();
        this.mGroups = new ArrayList();
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    private void applyGroup(DependencyNode object, int n, int n2, DependencyNode dependencyNode, ArrayList<RunGroup> arrayList, RunGroup object22) {
        WidgetRun widgetRun = ((DependencyNode)object).run;
        if (widgetRun.runGroup == null && widgetRun != this.container.horizontalRun && widgetRun != this.container.verticalRun) {
            if (object22 == null) {
                object = new RunGroup(widgetRun, n2);
                arrayList.add((RunGroup)object);
            } else {
                object = object22;
            }
            widgetRun.runGroup = object;
            ((RunGroup)object).add(widgetRun);
            for (Dependency dependency : widgetRun.start.dependencies) {
                if (!(dependency instanceof DependencyNode)) continue;
                this.applyGroup((DependencyNode)dependency, n, 0, dependencyNode, arrayList, (RunGroup)object);
            }
            for (Dependency dependency : widgetRun.end.dependencies) {
                if (!(dependency instanceof DependencyNode)) continue;
                this.applyGroup((DependencyNode)dependency, n, 1, dependencyNode, arrayList, (RunGroup)object);
            }
            if (n == 1 && widgetRun instanceof VerticalWidgetRun) {
                for (Dependency dependency : ((VerticalWidgetRun)widgetRun).baseline.dependencies) {
                    if (!(dependency instanceof DependencyNode)) continue;
                    this.applyGroup((DependencyNode)dependency, n, 2, dependencyNode, arrayList, (RunGroup)object);
                }
            }
            for (DependencyNode dependencyNode2 : widgetRun.start.targets) {
                if (dependencyNode2 == dependencyNode) {
                    ((RunGroup)object).dual = true;
                }
                this.applyGroup(dependencyNode2, n, 0, dependencyNode, arrayList, (RunGroup)object);
            }
            for (DependencyNode dependencyNode3 : widgetRun.end.targets) {
                if (dependencyNode3 == dependencyNode) {
                    ((RunGroup)object).dual = true;
                }
                this.applyGroup(dependencyNode3, n, 1, dependencyNode, arrayList, (RunGroup)object);
            }
            if (n == 1 && widgetRun instanceof VerticalWidgetRun) {
                Iterator<DependencyNode> iterator2 = ((VerticalWidgetRun)widgetRun).baseline.targets.iterator();
                while (iterator2.hasNext()) {
                    this.applyGroup(iterator2.next(), n, 2, dependencyNode, arrayList, (RunGroup)object);
                }
            }
            return;
        }
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        for (ConstraintWidget constraintWidget : constraintWidgetContainer.mChildren) {
            int n;
            int n2;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.mListDimensionBehaviors[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors[1];
            if (constraintWidget.getVisibility() == 8) {
                constraintWidget.measured = true;
                continue;
            }
            if (constraintWidget.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidget.mMatchConstraintDefaultWidth = 2;
            }
            if (constraintWidget.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidget.mMatchConstraintDefaultHeight = 2;
            }
            if (constraintWidget.getDimensionRatio() > 0.0f) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                    constraintWidget.mMatchConstraintDefaultWidth = 3;
                } else if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED)) {
                    constraintWidget.mMatchConstraintDefaultHeight = 3;
                } else if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        constraintWidget.mMatchConstraintDefaultWidth = 3;
                    }
                    if (constraintWidget.mMatchConstraintDefaultHeight == 0) {
                        constraintWidget.mMatchConstraintDefaultHeight = 3;
                    }
                }
            }
            if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 1 && (constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            }
            if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 1 && (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget == null)) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            }
            constraintWidget.horizontalRun.dimensionBehavior = dimensionBehaviour;
            constraintWidget.horizontalRun.matchConstraintsType = constraintWidget.mMatchConstraintDefaultWidth;
            constraintWidget.verticalRun.dimensionBehavior = dimensionBehaviour2;
            constraintWidget.verticalRun.matchConstraintsType = constraintWidget.mMatchConstraintDefaultHeight;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                float f;
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                    if (constraintWidget.mMatchConstraintDefaultWidth == 3) {
                        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                        }
                        n2 = constraintWidget.getHeight();
                        n = (int)((float)n2 * constraintWidget.mDimensionRatio + 0.5f);
                        this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, n, ConstraintWidget.DimensionBehaviour.FIXED, n2);
                        constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                        constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                        constraintWidget.measured = true;
                        continue;
                    }
                    if (constraintWidget.mMatchConstraintDefaultWidth == 1) {
                        this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour2, 0);
                        constraintWidget.horizontalRun.dimension.wrapValue = constraintWidget.getWidth();
                        continue;
                    }
                    if (constraintWidget.mMatchConstraintDefaultWidth == 2) {
                        if (constraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                            f = constraintWidget.mMatchConstraintPercentWidth;
                            n = (int)((float)constraintWidgetContainer.getWidth() * f + 0.5f);
                            n2 = constraintWidget.getHeight();
                            this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, n, dimensionBehaviour2, n2);
                            constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                            constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                            constraintWidget.measured = true;
                            continue;
                        }
                    } else if (constraintWidget.mListAnchors[0].mTarget == null || constraintWidget.mListAnchors[1].mTarget == null) {
                        this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour2, 0);
                        constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                        constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                        constraintWidget.measured = true;
                        continue;
                    }
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED)) {
                    if (constraintWidget.mMatchConstraintDefaultHeight == 3) {
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                        }
                        n2 = constraintWidget.getWidth();
                        f = constraintWidget.mDimensionRatio;
                        if (constraintWidget.getDimensionRatioSide() == -1) {
                            f = 1.0f / f;
                        }
                        n = (int)((float)n2 * f + 0.5f);
                        this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, n2, ConstraintWidget.DimensionBehaviour.FIXED, n);
                        constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                        constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                        constraintWidget.measured = true;
                        continue;
                    }
                    if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
                        this.measure(constraintWidget, dimensionBehaviour, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                        constraintWidget.verticalRun.dimension.wrapValue = constraintWidget.getHeight();
                        continue;
                    }
                    if (constraintWidget.mMatchConstraintDefaultHeight == 2) {
                        if (constraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                            f = constraintWidget.mMatchConstraintPercentHeight;
                            n2 = constraintWidget.getWidth();
                            n = (int)((float)constraintWidgetContainer.getHeight() * f + 0.5f);
                            this.measure(constraintWidget, dimensionBehaviour, n2, ConstraintWidget.DimensionBehaviour.FIXED, n);
                            constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                            constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                            constraintWidget.measured = true;
                            continue;
                        }
                    } else if (constraintWidget.mListAnchors[2].mTarget == null || constraintWidget.mListAnchors[3].mTarget == null) {
                        this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour2, 0);
                        constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                        constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                        constraintWidget.measured = true;
                        continue;
                    }
                }
                if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) continue;
                if (constraintWidget.mMatchConstraintDefaultWidth != 1 && constraintWidget.mMatchConstraintDefaultHeight != 1) {
                    if (constraintWidget.mMatchConstraintDefaultHeight != 2 || constraintWidget.mMatchConstraintDefaultWidth != 2 || constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED && constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED && constraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED) continue;
                    f = constraintWidget.mMatchConstraintPercentWidth;
                    float f2 = constraintWidget.mMatchConstraintPercentHeight;
                    n = (int)((float)constraintWidgetContainer.getWidth() * f + 0.5f);
                    n2 = (int)((float)constraintWidgetContainer.getHeight() * f2 + 0.5f);
                    this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, n, ConstraintWidget.DimensionBehaviour.FIXED, n2);
                    constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                    constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                    constraintWidget.measured = true;
                    continue;
                }
                this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                constraintWidget.horizontalRun.dimension.wrapValue = constraintWidget.getWidth();
                constraintWidget.verticalRun.dimension.wrapValue = constraintWidget.getHeight();
                continue;
            }
            n2 = constraintWidget.getWidth();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviour;
            if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                n2 = constraintWidgetContainer.getWidth() - constraintWidget.mLeft.mMargin - constraintWidget.mRight.mMargin;
                dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            n = constraintWidget.getHeight();
            if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                n = constraintWidgetContainer.getHeight();
                int n3 = constraintWidget.mTop.mMargin;
                int n4 = constraintWidget.mBottom.mMargin;
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
                n = n - n3 - n4;
            }
            this.measure(constraintWidget, dimensionBehaviour3, n2, dimensionBehaviour2, n);
            constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
            constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
            constraintWidget.measured = true;
        }
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int n) {
        int n2 = this.mGroups.size();
        long l = 0L;
        for (int i = 0; i < n2; ++i) {
            l = Math.max(l, this.mGroups.get(i).computeWrapSize(constraintWidgetContainer, n));
        }
        return (int)l;
    }

    private void displayGraph() {
        String string2 = "digraph {\n";
        Iterator<WidgetRun> iterator2 = this.mRuns.iterator();
        while (iterator2.hasNext()) {
            string2 = this.generateDisplayGraph(iterator2.next(), string2);
        }
        string2 = string2 + "\n}\n";
        System.out.println("content:<<\n" + string2 + "\n>>");
    }

    /*
     * WARNING - void declaration
     */
    private void findGroup(WidgetRun dependency2, int n, ArrayList<RunGroup> arrayList) {
        void var3_5;
        void var2_4;
        for (Dependency dependency : ((WidgetRun)dependency2).start.dependencies) {
            if (dependency instanceof DependencyNode) {
                this.applyGroup((DependencyNode)dependency, (int)var2_4, 0, ((WidgetRun)dependency2).end, (ArrayList<RunGroup>)var3_5, null);
                continue;
            }
            if (!(dependency instanceof WidgetRun)) continue;
            this.applyGroup(((WidgetRun)dependency).start, (int)var2_4, 0, ((WidgetRun)dependency2).end, (ArrayList<RunGroup>)var3_5, null);
        }
        for (Dependency dependency : ((WidgetRun)dependency2).end.dependencies) {
            if (dependency instanceof DependencyNode) {
                this.applyGroup((DependencyNode)dependency, (int)var2_4, 1, ((WidgetRun)dependency2).start, (ArrayList<RunGroup>)var3_5, null);
                continue;
            }
            if (!(dependency instanceof WidgetRun)) continue;
            this.applyGroup(((WidgetRun)dependency).end, (int)var2_4, 1, ((WidgetRun)dependency2).start, (ArrayList<RunGroup>)var3_5, null);
        }
        if (var2_4 == true) {
            for (Dependency dependency : ((VerticalWidgetRun)dependency2).baseline.dependencies) {
                if (!(dependency instanceof DependencyNode)) continue;
                this.applyGroup((DependencyNode)dependency, (int)var2_4, 2, null, (ArrayList<RunGroup>)var3_5, null);
            }
        }
    }

    private String generateChainDisplayGraph(ChainRun object, String string2) {
        int n = ((ChainRun)object).orientation;
        String string3 = "cluster_" + ((ChainRun)object).widget.getDebugName();
        string3 = n == 0 ? string3 + "_h" : string3 + "_v";
        string3 = "subgraph " + string3 + " {\n";
        String string4 = "";
        Iterator<WidgetRun> iterator2 = ((ChainRun)object).widgets.iterator();
        object = string4;
        while (iterator2.hasNext()) {
            WidgetRun widgetRun = iterator2.next();
            string4 = widgetRun.widget.getDebugName();
            string4 = n == 0 ? string4 + "_HORIZONTAL" : string4 + "_VERTICAL";
            string3 = string3 + string4 + ";\n";
            object = this.generateDisplayGraph(widgetRun, (String)object);
        }
        string3 = string3 + "}\n";
        return string2 + (String)object + string3;
    }

    private String generateDisplayGraph(WidgetRun widgetRun, String string2) {
        String string3;
        block23: {
            DependencyNode dependencyNode;
            DependencyNode dependencyNode2;
            block21: {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour;
                block22: {
                    dependencyNode2 = widgetRun.start;
                    dependencyNode = widgetRun.end;
                    if (!(widgetRun instanceof HelperReferences) && dependencyNode2.dependencies.isEmpty() && dependencyNode.dependencies.isEmpty() & dependencyNode2.targets.isEmpty() && dependencyNode.targets.isEmpty()) {
                        return string2;
                    }
                    string2 = string2 + this.nodeDefinition(widgetRun);
                    boolean bl = this.isCenteredConnection(dependencyNode2, dependencyNode);
                    string2 = string3 = this.generateDisplayNode(dependencyNode, bl, this.generateDisplayNode(dependencyNode2, bl, string2));
                    if (widgetRun instanceof VerticalWidgetRun) {
                        string2 = this.generateDisplayNode(((VerticalWidgetRun)widgetRun).baseline, bl, string3);
                    }
                    if (widgetRun instanceof HorizontalWidgetRun || widgetRun instanceof ChainRun && ((ChainRun)widgetRun).orientation == 0) break block21;
                    if (widgetRun instanceof VerticalWidgetRun) break block22;
                    string3 = string2;
                    if (!(widgetRun instanceof ChainRun)) break block23;
                    string3 = string2;
                    if (((ChainRun)widgetRun).orientation != 1) break block23;
                }
                if ((dimensionBehaviour = widgetRun.widget.getVerticalDimensionBehaviour()) != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    string3 = string2;
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        string3 = string2;
                        if (widgetRun.widget.getDimensionRatio() > 0.0f) {
                            string3 = widgetRun.widget.getDebugName();
                            String cfr_ignored_0 = "\n" + string3 + "_VERTICAL -> " + string3 + "_HORIZONTAL;\n";
                            string3 = string2;
                        }
                    }
                } else if (!dependencyNode2.targets.isEmpty() && dependencyNode.targets.isEmpty()) {
                    string3 = "\n" + dependencyNode.name() + " -> " + dependencyNode2.name() + "\n";
                    string3 = string2 + string3;
                } else {
                    string3 = string2;
                    if (dependencyNode2.targets.isEmpty()) {
                        string3 = string2;
                        if (!dependencyNode.targets.isEmpty()) {
                            string3 = "\n" + dependencyNode2.name() + " -> " + dependencyNode.name() + "\n";
                            string3 = string2 + string3;
                        }
                    }
                }
                break block23;
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.widget.getHorizontalDimensionBehaviour();
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                string3 = string2;
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    string3 = string2;
                    if (widgetRun.widget.getDimensionRatio() > 0.0f) {
                        string3 = widgetRun.widget.getDebugName();
                        String cfr_ignored_1 = "\n" + string3 + "_HORIZONTAL -> " + string3 + "_VERTICAL;\n";
                        string3 = string2;
                    }
                }
            } else if (!dependencyNode2.targets.isEmpty() && dependencyNode.targets.isEmpty()) {
                string3 = "\n" + dependencyNode.name() + " -> " + dependencyNode2.name() + "\n";
                string3 = string2 + string3;
            } else {
                string3 = string2;
                if (dependencyNode2.targets.isEmpty()) {
                    string3 = string2;
                    if (!dependencyNode.targets.isEmpty()) {
                        string3 = "\n" + dependencyNode2.name() + " -> " + dependencyNode.name() + "\n";
                        string3 = string2 + string3;
                    }
                }
            }
        }
        if (widgetRun instanceof ChainRun) {
            return this.generateChainDisplayGraph((ChainRun)widgetRun, string3);
        }
        return string3;
    }

    private String generateDisplayNode(DependencyNode dependencyNode, boolean bl, String object) {
        Iterator<DependencyNode> iterator2 = dependencyNode.targets.iterator();
        String string2 = object;
        while (iterator2.hasNext()) {
            block9: {
                Object object2;
                block8: {
                    object2 = iterator2.next();
                    object = "\n" + dependencyNode.name();
                    object2 = (String)object + " -> " + ((DependencyNode)object2).name();
                    if (dependencyNode.margin > 0 || bl) break block8;
                    object = object2;
                    if (!(dependencyNode.run instanceof HelperReferences)) break block9;
                }
                object = object2 = (String)object2 + "[";
                if (dependencyNode.margin > 0) {
                    object = object2 = (String)object2 + "label=\"" + dependencyNode.margin + "\"";
                    if (bl) {
                        object = (String)object2 + ",";
                    }
                }
                object2 = object;
                if (bl) {
                    object2 = (String)object + " style=dashed ";
                }
                object = object2;
                if (dependencyNode.run instanceof HelperReferences) {
                    object = (String)object2 + " style=bold,color=gray ";
                }
                object = (String)object + "]";
            }
            object = (String)object + "\n";
            string2 = string2 + (String)object;
        }
        return string2;
    }

    private boolean isCenteredConnection(DependencyNode dependencyNode, DependencyNode object) {
        int n;
        int n2 = 0;
        int n3 = 0;
        Iterator<DependencyNode> iterator2 = dependencyNode.targets.iterator();
        while (iterator2.hasNext()) {
            n = n2;
            if (iterator2.next() != object) {
                n = n2 + 1;
            }
            n2 = n;
        }
        object = ((DependencyNode)object).targets.iterator();
        n = n3;
        while (object.hasNext()) {
            n3 = n;
            if ((DependencyNode)object.next() != dependencyNode) {
                n3 = n + 1;
            }
            n = n3;
        }
        boolean bl = n2 > 0 && n > 0;
        return bl;
    }

    private void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int n, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int n2) {
        this.mMeasure.horizontalBehavior = dimensionBehaviour;
        this.mMeasure.verticalBehavior = dimensionBehaviour2;
        this.mMeasure.horizontalDimension = n;
        this.mMeasure.verticalDimension = n2;
        this.mMeasurer.measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private String nodeDefinition(WidgetRun object) {
        Object object2;
        boolean bl = object instanceof VerticalWidgetRun;
        String string2 = ((WidgetRun)object).widget.getDebugName();
        Object object3 = ((WidgetRun)object).widget;
        Object object4 = !bl ? ((ConstraintWidget)object3).getHorizontalDimensionBehaviour() : ((ConstraintWidget)object3).getVerticalDimensionBehaviour();
        RunGroup runGroup = ((WidgetRun)object).runGroup;
        object3 = !bl ? string2 + "_HORIZONTAL" : string2 + "_VERTICAL";
        object3 = (String)object3 + " [shape=none, label=<";
        object3 = (String)object3 + "<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">";
        object3 = (String)object3 + "  <TR>";
        if (!bl) {
            object3 = object2 = (String)object3 + "    <TD ";
            if (((WidgetRun)object).start.resolved) {
                object3 = (String)object2 + " BGCOLOR=\"green\"";
            }
            object3 = (String)object3 + " PORT=\"LEFT\" BORDER=\"1\">L</TD>";
        } else {
            object3 = object2 = (String)object3 + "    <TD ";
            if (((WidgetRun)object).start.resolved) {
                object3 = (String)object2 + " BGCOLOR=\"green\"";
            }
            object3 = (String)object3 + " PORT=\"TOP\" BORDER=\"1\">T</TD>";
        }
        object2 = (String)object3 + "    <TD BORDER=\"1\" ";
        if (((WidgetRun)object).dimension.resolved && !((WidgetRun)object).widget.measured) {
            object3 = (String)object2 + " BGCOLOR=\"green\" ";
        } else if (((WidgetRun)object).dimension.resolved && ((WidgetRun)object).widget.measured) {
            object3 = (String)object2 + " BGCOLOR=\"lightgray\" ";
        } else {
            object3 = object2;
            if (!((WidgetRun)object).dimension.resolved) {
                object3 = object2;
                if (((WidgetRun)object).widget.measured) {
                    object3 = (String)object2 + " BGCOLOR=\"yellow\" ";
                }
            }
        }
        object2 = object3;
        if (object4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            object2 = (String)object3 + "style=\"dashed\"";
        }
        object3 = "";
        if (runGroup != null) {
            object3 = " [" + (runGroup.groupIndex + 1) + "/" + RunGroup.index + "]";
        }
        object3 = (String)object2 + ">" + string2 + (String)object3 + " </TD>";
        if (!bl) {
            object4 = (String)object3 + "    <TD ";
            object3 = object4;
            if (((WidgetRun)object).end.resolved) {
                object3 = (String)object4 + " BGCOLOR=\"green\"";
            }
            object = (String)object3 + " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
        } else {
            object4 = (String)object3 + "    <TD ";
            object3 = object4;
            if (object instanceof VerticalWidgetRun) {
                object3 = object4;
                if (((VerticalWidgetRun)object).baseline.resolved) {
                    object3 = (String)object4 + " BGCOLOR=\"green\"";
                }
            }
            object3 = (String)object3 + " PORT=\"BASELINE\" BORDER=\"1\">b</TD>";
            object4 = (String)object3 + "    <TD ";
            object3 = object4;
            if (((WidgetRun)object).end.resolved) {
                object3 = (String)object4 + " BGCOLOR=\"green\"";
            }
            object = (String)object3 + " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
        }
        object = (String)object + "  </TR></TABLE>";
        return (String)object + ">];\n";
    }

    public void buildGraph() {
        this.buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        this.findGroup(this.container.horizontalRun, 0, this.mGroups);
        this.findGroup(this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void buildGraph(ArrayList<WidgetRun> object) {
        ((ArrayList)object).clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        ((ArrayList)object).add((WidgetRun)this.mContainer.horizontalRun);
        ((ArrayList)object).add((WidgetRun)this.mContainer.verticalRun);
        Object object2 = null;
        for (ConstraintWidget constraintWidget : this.mContainer.mChildren) {
            Object object3;
            if (constraintWidget instanceof Guideline) {
                ((ArrayList)object).add((WidgetRun)new GuidelineReference(constraintWidget));
                continue;
            }
            if (constraintWidget.isInHorizontalChain()) {
                if (constraintWidget.horizontalChainRun == null) {
                    constraintWidget.horizontalChainRun = new ChainRun(constraintWidget, 0);
                }
                object3 = object2;
                if (object2 == null) {
                    object3 = new HashSet();
                }
                ((HashSet)object3).add((ChainRun)constraintWidget.horizontalChainRun);
                object2 = object3;
            } else {
                ((ArrayList)object).add((WidgetRun)constraintWidget.horizontalRun);
            }
            if (constraintWidget.isInVerticalChain()) {
                if (constraintWidget.verticalChainRun == null) {
                    constraintWidget.verticalChainRun = new ChainRun(constraintWidget, 1);
                }
                object3 = object2;
                if (object2 == null) {
                    object3 = new HashSet();
                }
                ((HashSet)object3).add((ChainRun)constraintWidget.verticalChainRun);
                object2 = object3;
            } else {
                ((ArrayList)object).add(constraintWidget.verticalRun);
            }
            if (!(constraintWidget instanceof HelperWidget)) continue;
            ((ArrayList)object).add(new HelperReferences(constraintWidget));
        }
        if (object2 != null) {
            ((ArrayList)object).addAll(object2);
        }
        object2 = ((ArrayList)object).iterator();
        while (object2.hasNext()) {
            object2.next().clear();
        }
        object2 = ((ArrayList)object).iterator();
        while (object2.hasNext()) {
            object = object2.next();
            if (((WidgetRun)object).widget == this.mContainer) continue;
            ((WidgetRun)object).apply();
        }
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        if (this.mNeedBuildGraph) {
            this.buildGraph();
            boolean bl = false;
            for (Object object : this.container.mChildren) {
                ((ConstraintWidget)object).isTerminalWidget[0] = true;
                ((ConstraintWidget)object).isTerminalWidget[1] = true;
                if (!(object instanceof Barrier)) continue;
                bl = true;
            }
            if (!bl) {
                for (RunGroup runGroup : this.mGroups) {
                    boolean bl2 = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    boolean bl3 = dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    runGroup.defineTerminalWidgets(bl2, bl3);
                }
            }
        }
    }

    public boolean directMeasure(boolean bl) {
        Object object;
        Object object222;
        block16: {
            Object object4;
            int n;
            int n2 = bl & 1;
            if (this.mNeedBuildGraph || this.mNeedRedoMeasures) {
                for (Object object222 : this.container.mChildren) {
                    object222.measured = false;
                    object222.horizontalRun.reset();
                    object222.verticalRun.reset();
                }
                this.container.measured = false;
                this.container.horizontalRun.reset();
                this.container.verticalRun.reset();
                this.mNeedRedoMeasures = false;
            }
            if (this.basicMeasureWidgets(this.mContainer)) {
                return false;
            }
            this.container.setX(0);
            this.container.setY(0);
            object = this.container.getDimensionBehaviour(0);
            object222 = this.container.getDimensionBehaviour(1);
            if (this.mNeedBuildGraph) {
                this.buildGraph();
            }
            int n3 = this.container.getX();
            int n4 = this.container.getY();
            this.container.horizontalRun.start.resolve(n3);
            this.container.verticalRun.start.resolve(n4);
            this.measureWidgets();
            if (object == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || object222 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                block15: {
                    n = n2;
                    if (n2 != 0) {
                        object4 = this.mRuns.iterator();
                        do {
                            n = n2;
                            if (!object4.hasNext()) break block15;
                        } while (object4.next().supportsWrapComputation());
                        n = 0;
                    }
                }
                if (n != 0 && object == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    this.container.setWidth(this.computeWrap(this.container, 0));
                    this.container.horizontalRun.dimension.resolve(this.container.getWidth());
                }
                if (n != 0 && object222 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    this.container.setHeight(this.computeWrap(this.container, 1));
                    this.container.verticalRun.dimension.resolve(this.container.getHeight());
                }
            }
            n = 0;
            if (this.container.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || this.container.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                n = this.container.getWidth() + n3;
                this.container.horizontalRun.end.resolve(n);
                this.container.horizontalRun.dimension.resolve(n - n3);
                this.measureWidgets();
                if (this.container.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || this.container.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    n = this.container.getHeight() + n4;
                    this.container.verticalRun.end.resolve(n);
                    this.container.verticalRun.dimension.resolve(n - n4);
                }
                this.measureWidgets();
                n = 1;
            }
            for (WidgetRun object32 : this.mRuns) {
                if (object32.widget == this.container && !object32.resolved) continue;
                object32.applyToWidget();
            }
            boolean bl2 = true;
            Iterator<WidgetRun> iterator2 = this.mRuns.iterator();
            while (true) {
                bl = bl2;
                if (!iterator2.hasNext()) break block16;
                object4 = iterator2.next();
                if (n == 0 && ((WidgetRun)object4).widget == this.container) continue;
                if (!((WidgetRun)object4).start.resolved) {
                    bl = false;
                    break block16;
                }
                if (!((WidgetRun)object4).end.resolved && !(object4 instanceof GuidelineReference)) {
                    bl = false;
                    break block16;
                }
                if (!(((WidgetRun)object4).dimension.resolved || object4 instanceof ChainRun || object4 instanceof GuidelineReference)) break;
            }
            bl = false;
        }
        this.container.setHorizontalDimensionBehaviour((ConstraintWidget.DimensionBehaviour)((Object)object));
        this.container.setVerticalDimensionBehaviour((ConstraintWidget.DimensionBehaviour)((Object)object222));
        return bl;
    }

    public boolean directMeasureSetup(boolean bl) {
        if (this.mNeedBuildGraph) {
            for (ConstraintWidget constraintWidget : this.container.mChildren) {
                constraintWidget.measured = false;
                constraintWidget.horizontalRun.dimension.resolved = false;
                constraintWidget.horizontalRun.resolved = false;
                constraintWidget.horizontalRun.reset();
                constraintWidget.verticalRun.dimension.resolved = false;
                constraintWidget.verticalRun.resolved = false;
                constraintWidget.verticalRun.reset();
            }
            this.container.measured = false;
            this.container.horizontalRun.dimension.resolved = false;
            this.container.horizontalRun.resolved = false;
            this.container.horizontalRun.reset();
            this.container.verticalRun.dimension.resolved = false;
            this.container.verticalRun.resolved = false;
            this.container.verticalRun.reset();
            this.buildGraph();
        }
        if (this.basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean bl, int n) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        block15: {
            int n2;
            Object object;
            int n3 = bl & 1;
            dimensionBehaviour2 = this.container.getDimensionBehaviour(0);
            dimensionBehaviour = this.container.getDimensionBehaviour(1);
            int n4 = this.container.getX();
            int n5 = this.container.getY();
            if (n3 != 0 && (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                block14: {
                    Iterator<WidgetRun> iterator22 = this.mRuns.iterator();
                    do {
                        n2 = n3;
                        if (!iterator22.hasNext()) break block14;
                        object = iterator22.next();
                    } while (((WidgetRun)object).orientation != n || ((WidgetRun)object).supportsWrapComputation());
                    n2 = 0;
                }
                if (n == 0) {
                    if (n2 != 0 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                        this.container.setWidth(this.computeWrap(this.container, 0));
                        this.container.horizontalRun.dimension.resolve(this.container.getWidth());
                    }
                } else if (n2 != 0 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    this.container.setHeight(this.computeWrap(this.container, 1));
                    this.container.verticalRun.dimension.resolve(this.container.getHeight());
                }
            }
            n2 = 0;
            if (n == 0) {
                if (this.container.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || this.container.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    n2 = this.container.getWidth() + n4;
                    this.container.horizontalRun.end.resolve(n2);
                    this.container.horizontalRun.dimension.resolve(n2 - n4);
                    n2 = 1;
                }
            } else if (this.container.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || this.container.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                n2 = this.container.getHeight() + n5;
                this.container.verticalRun.end.resolve(n2);
                this.container.verticalRun.dimension.resolve(n2 - n5);
                n2 = 1;
            }
            this.measureWidgets();
            for (WidgetRun widgetRun : this.mRuns) {
                if (widgetRun.orientation != n || widgetRun.widget == this.container && !widgetRun.resolved) continue;
                widgetRun.applyToWidget();
            }
            boolean bl2 = true;
            Iterator<WidgetRun> iterator2 = this.mRuns.iterator();
            while (true) {
                bl = bl2;
                if (!iterator2.hasNext()) break block15;
                object = iterator2.next();
                if (((WidgetRun)object).orientation != n || n2 == 0 && ((WidgetRun)object).widget == this.container) continue;
                if (!((WidgetRun)object).start.resolved) {
                    bl = false;
                    break block15;
                }
                if (!((WidgetRun)object).end.resolved) {
                    bl = false;
                    break block15;
                }
                if (!(object instanceof ChainRun) && !((WidgetRun)object).dimension.resolved) break;
            }
            bl = false;
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour2);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour);
        return bl;
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void measureWidgets() {
        for (ConstraintWidget constraintWidget : this.container.mChildren) {
            boolean bl;
            int n;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour;
            Object object;
            block14: {
                block13: {
                    if (constraintWidget.measured) continue;
                    object = constraintWidget.mListDimensionBehaviors;
                    boolean bl2 = false;
                    dimensionBehaviour = object[0];
                    object = constraintWidget.mListDimensionBehaviors[1];
                    n = constraintWidget.mMatchConstraintDefaultWidth;
                    int n2 = constraintWidget.mMatchConstraintDefaultHeight;
                    n = dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || n != 1) ? 0 : 1;
                    if (object == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) break block13;
                    bl = bl2;
                    if (object != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) break block14;
                    bl = bl2;
                    if (n2 != 1) break block14;
                }
                bl = true;
            }
            boolean bl3 = constraintWidget.horizontalRun.dimension.resolved;
            boolean bl4 = constraintWidget.verticalRun.dimension.resolved;
            if (bl3 && bl4) {
                this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.verticalRun.dimension.value);
                constraintWidget.measured = true;
            } else if (bl3 && bl) {
                this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, constraintWidget.verticalRun.dimension.value);
                if (object == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.verticalRun.dimension.wrapValue = constraintWidget.getHeight();
                } else {
                    constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                    constraintWidget.measured = true;
                }
            } else if (bl4 && n != 0) {
                this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, constraintWidget.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.verticalRun.dimension.value);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.horizontalRun.dimension.wrapValue = constraintWidget.getWidth();
                } else {
                    constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                    constraintWidget.measured = true;
                }
            }
            if (!constraintWidget.measured || constraintWidget.verticalRun.baselineDimension == null) continue;
            constraintWidget.verticalRun.baselineDimension.resolve(constraintWidget.getBaselineDistance());
        }
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
    }
}

