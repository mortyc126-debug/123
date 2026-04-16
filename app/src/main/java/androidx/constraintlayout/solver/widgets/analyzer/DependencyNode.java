/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.List;

public class DependencyNode
implements Dependency {
    public boolean delegateToWidgetRun = false;
    List<Dependency> dependencies;
    int margin;
    DimensionDependency marginDependency = null;
    int marginFactor = 1;
    public boolean readyToSolve = false;
    public boolean resolved = false;
    WidgetRun run;
    List<DependencyNode> targets;
    Type type = Type.UNKNOWN;
    public Dependency updateDelegate = null;
    public int value;

    public DependencyNode(WidgetRun widgetRun) {
        this.dependencies = new ArrayList<Dependency>();
        this.targets = new ArrayList<DependencyNode>();
        this.run = widgetRun;
    }

    public void addDependency(Dependency dependency) {
        this.dependencies.add(dependency);
        if (this.resolved) {
            dependency.update(dependency);
        }
    }

    public void clear() {
        this.targets.clear();
        this.dependencies.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        String string2 = this.run.widget.getDebugName();
        string2 = this.type != Type.LEFT && this.type != Type.RIGHT ? string2 + "_VERTICAL" : string2 + "_HORIZONTAL";
        return string2 + ":" + this.type.name();
    }

    public void resolve(int n) {
        if (this.resolved) {
            return;
        }
        this.resolved = true;
        this.value = n;
        for (Dependency dependency : this.dependencies) {
            dependency.update(dependency);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append(this.run.widget.getDebugName()).append(":").append((Object)this.type).append("(");
        Object object = this.resolved ? Integer.valueOf(this.value) : "unresolved";
        return stringBuilder.append(object).append(") <t=").append(this.targets.size()).append(":d=").append(this.dependencies.size()).append(">").toString();
    }

    @Override
    public void update(Dependency object) {
        object = this.targets.iterator();
        while (object.hasNext()) {
            if (((DependencyNode)object.next()).resolved) continue;
            return;
        }
        this.readyToSolve = true;
        if (this.updateDelegate != null) {
            this.updateDelegate.update(this);
        }
        if (this.delegateToWidgetRun) {
            this.run.update(this);
            return;
        }
        object = null;
        int n = 0;
        for (DependencyNode dependencyNode : this.targets) {
            if (dependencyNode instanceof DimensionDependency) continue;
            object = dependencyNode;
            ++n;
        }
        if (object != null && n == 1 && ((DependencyNode)object).resolved) {
            if (this.marginDependency != null) {
                if (this.marginDependency.resolved) {
                    this.margin = this.marginFactor * this.marginDependency.value;
                } else {
                    return;
                }
            }
            this.resolve(((DependencyNode)object).value + this.margin);
        }
        if (this.updateDelegate != null) {
            this.updateDelegate.update(this);
        }
    }

    static enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE;

    }
}

