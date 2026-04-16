/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HelperReferences;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;

class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int direction;
    public boolean dual = false;
    WidgetRun firstRun = null;
    int groupIndex = 0;
    WidgetRun lastRun = null;
    public int position = 0;
    ArrayList<WidgetRun> runs = new ArrayList();

    public RunGroup(WidgetRun widgetRun, int n) {
        this.groupIndex = index++;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = n;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int n) {
        Iterator<WidgetRun> iterator2;
        if (!widgetRun.widget.isTerminalWidget[n]) {
            return false;
        }
        for (Dependency dependency : widgetRun.start.dependencies) {
            if (!(dependency instanceof DependencyNode)) continue;
            dependency = (DependencyNode)dependency;
            if (((DependencyNode)dependency).run == widgetRun || dependency != ((DependencyNode)dependency).run.start) continue;
            if (widgetRun instanceof ChainRun) {
                iterator2 = ((ChainRun)widgetRun).widgets.iterator();
                while (iterator2.hasNext()) {
                    this.defineTerminalWidget(iterator2.next(), n);
                }
            } else if (!(widgetRun instanceof HelperReferences)) {
                widgetRun.widget.isTerminalWidget[n] = false;
            }
            this.defineTerminalWidget(((DependencyNode)dependency).run, n);
        }
        for (Dependency dependency : widgetRun.end.dependencies) {
            if (!(dependency instanceof DependencyNode)) continue;
            dependency = (DependencyNode)dependency;
            if (((DependencyNode)dependency).run == widgetRun || dependency != ((DependencyNode)dependency).run.start) continue;
            if (widgetRun instanceof ChainRun) {
                iterator2 = ((ChainRun)widgetRun).widgets.iterator();
                while (iterator2.hasNext()) {
                    this.defineTerminalWidget(iterator2.next(), n);
                }
            } else if (!(widgetRun instanceof HelperReferences)) {
                widgetRun.widget.isTerminalWidget[n] = false;
            }
            this.defineTerminalWidget(((DependencyNode)dependency).run, n);
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long l) {
        long l2;
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return l;
        }
        long l3 = l;
        int n = dependencyNode.dependencies.size();
        for (int i = 0; i < n; ++i) {
            Dependency dependency = dependencyNode.dependencies.get(i);
            l2 = l3;
            if (dependency instanceof DependencyNode) {
                dependency = (DependencyNode)dependency;
                l2 = ((DependencyNode)dependency).run == widgetRun ? l3 : Math.min(l3, this.traverseEnd((DependencyNode)dependency, (long)((DependencyNode)dependency).margin + l));
            }
            l3 = l2;
        }
        l2 = l3;
        if (dependencyNode == widgetRun.end) {
            l2 = widgetRun.getWrapDimension();
            l2 = Math.min(Math.min(l3, this.traverseEnd(widgetRun.start, l - l2)), l - l2 - (long)widgetRun.start.margin);
        }
        return l2;
    }

    private long traverseStart(DependencyNode dependencyNode, long l) {
        long l2;
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return l;
        }
        long l3 = l;
        int n = dependencyNode.dependencies.size();
        for (int i = 0; i < n; ++i) {
            Dependency dependency = dependencyNode.dependencies.get(i);
            l2 = l3;
            if (dependency instanceof DependencyNode) {
                dependency = (DependencyNode)dependency;
                l2 = ((DependencyNode)dependency).run == widgetRun ? l3 : Math.max(l3, this.traverseStart((DependencyNode)dependency, (long)((DependencyNode)dependency).margin + l));
            }
            l3 = l2;
        }
        l2 = l3;
        if (dependencyNode == widgetRun.start) {
            l2 = widgetRun.getWrapDimension();
            l2 = Math.max(Math.max(l3, this.traverseStart(widgetRun.end, l + l2)), l + l2 - (long)widgetRun.end.margin);
        }
        return l2;
    }

    public void add(WidgetRun widgetRun) {
        this.runs.add(widgetRun);
        this.lastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer object, int n) {
        long l;
        if (this.firstRun instanceof ChainRun ? ((ChainRun)this.firstRun).orientation != n : (n == 0 ? !(this.firstRun instanceof HorizontalWidgetRun) : !(this.firstRun instanceof VerticalWidgetRun))) {
            return 0L;
        }
        DependencyNode dependencyNode = n == 0 ? ((ConstraintWidgetContainer)object).horizontalRun.start : ((ConstraintWidgetContainer)object).verticalRun.start;
        object = n == 0 ? ((ConstraintWidgetContainer)object).horizontalRun.end : ((ConstraintWidgetContainer)object).verticalRun.end;
        boolean bl = this.firstRun.start.targets.contains(dependencyNode);
        boolean bl2 = this.firstRun.end.targets.contains(object);
        long l2 = this.firstRun.getWrapDimension();
        if (bl && bl2) {
            long l3;
            l = this.traverseStart(this.firstRun.start, 0L);
            long l4 = this.traverseEnd(this.firstRun.end, 0L);
            l = l3 = l - l2;
            if (l3 >= (long)(-this.firstRun.end.margin)) {
                l = l3 + (long)this.firstRun.end.margin;
            }
            l3 = l4 = -l4 - l2 - (long)this.firstRun.start.margin;
            if (l4 >= (long)this.firstRun.start.margin) {
                l3 = l4 - (long)this.firstRun.start.margin;
            }
            float f = this.firstRun.widget.getBiasPercent(n);
            l4 = 0L;
            if (f > 0.0f) {
                l4 = (long)((float)l3 / f + (float)l / (1.0f - f));
            }
            l = (long)((float)l4 * f + 0.5f);
            l3 = (long)((float)l4 * (1.0f - f) + 0.5f);
            l = (long)this.firstRun.start.margin + (l + l2 + l3) - (long)this.firstRun.end.margin;
        } else if (bl) {
            l = Math.max(this.traverseStart(this.firstRun.start, this.firstRun.start.margin), (long)this.firstRun.start.margin + l2);
        } else if (bl2) {
            long l5 = this.traverseEnd(this.firstRun.end, this.firstRun.end.margin);
            l = -this.firstRun.end.margin;
            l = Math.max(-l5, l + l2);
        } else {
            l = (long)this.firstRun.start.margin + this.firstRun.getWrapDimension() - (long)this.firstRun.end.margin;
        }
        return l;
    }

    public void defineTerminalWidgets(boolean bl, boolean bl2) {
        if (bl && this.firstRun instanceof HorizontalWidgetRun) {
            this.defineTerminalWidget(this.firstRun, 0);
        }
        if (bl2 && this.firstRun instanceof VerticalWidgetRun) {
            this.defineTerminalWidget(this.firstRun, 1);
        }
    }
}

