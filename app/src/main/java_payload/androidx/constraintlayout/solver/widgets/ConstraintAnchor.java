/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintAnchor {
    private static final boolean ALLOW_BINARY = false;
    private static final int UNSET_GONE_MARGIN = -1;
    private HashSet<ConstraintAnchor> mDependents = null;
    int mGoneMargin = -1;
    public int mMargin = 0;
    public final ConstraintWidget mOwner;
    SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final Type mType;

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type2) {
        this.mOwner = constraintWidget;
        this.mType = type2;
    }

    private boolean isConnectionToMe(ConstraintWidget object, HashSet<ConstraintWidget> hashSet) {
        if (hashSet.contains(object)) {
            return false;
        }
        hashSet.add((ConstraintWidget)object);
        if (object == this.getOwner()) {
            return true;
        }
        object = ((ConstraintWidget)object).getAnchors();
        int n = ((ArrayList)object).size();
        for (int i = 0; i < n; ++i) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor)((ArrayList)object).get(i);
            if (!constraintAnchor.isSimilarDimensionConnection(this) || !constraintAnchor.isConnected() || !this.isConnectionToMe(constraintAnchor.getTarget().getOwner(), hashSet)) continue;
            return true;
        }
        return false;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int n) {
        return this.connect(constraintAnchor, n, -1, false);
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int n, int n2, boolean bl) {
        if (constraintAnchor == null) {
            this.reset();
            return true;
        }
        if (!bl && !this.isValidConnection(constraintAnchor)) {
            return false;
        }
        this.mTarget = constraintAnchor;
        if (this.mTarget.mDependents == null) {
            this.mTarget.mDependents = new HashSet();
        }
        this.mTarget.mDependents.add(this);
        this.mMargin = n > 0 ? n : 0;
        this.mGoneMargin = n2;
        return true;
    }

    public void copyFrom(ConstraintAnchor constraintAnchor, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        if (this.mTarget != null && this.mTarget.mDependents != null) {
            this.mTarget.mDependents.remove(this);
        }
        if (constraintAnchor.mTarget != null) {
            Type type2 = constraintAnchor.mTarget.getType();
            this.mTarget = hashMap.get(constraintAnchor.mTarget.mOwner).getAnchor(type2);
        } else {
            this.mTarget = null;
        }
        if (this.mTarget != null) {
            if (this.mTarget.mDependents == null) {
                this.mTarget.mDependents = new HashSet();
            }
            this.mTarget.mDependents.add(this);
        }
        this.mMargin = constraintAnchor.mMargin;
        this.mGoneMargin = constraintAnchor.mGoneMargin;
    }

    public int getMargin() {
        if (this.mOwner.getVisibility() == 8) {
            return 0;
        }
        if (this.mGoneMargin > -1 && this.mTarget != null && this.mTarget.mOwner.getVisibility() == 8) {
            return this.mGoneMargin;
        }
        return this.mMargin;
    }

    public final ConstraintAnchor getOpposite() {
        switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.mType.name());
            }
            case 5: {
                return this.mOwner.mTop;
            }
            case 4: {
                return this.mOwner.mBottom;
            }
            case 3: {
                return this.mOwner.mLeft;
            }
            case 2: {
                return this.mOwner.mRight;
            }
            case 1: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
        }
        return null;
    }

    public ConstraintWidget getOwner() {
        return this.mOwner;
    }

    public SolverVariable getSolverVariable() {
        return this.mSolverVariable;
    }

    public ConstraintAnchor getTarget() {
        return this.mTarget;
    }

    public Type getType() {
        return this.mType;
    }

    public boolean hasCenteredDependents() {
        if (this.mDependents == null) {
            return false;
        }
        Iterator<ConstraintAnchor> iterator2 = this.mDependents.iterator();
        while (iterator2.hasNext()) {
            if (!iterator2.next().getOpposite().isConnected()) continue;
            return true;
        }
        return false;
    }

    public boolean hasDependents() {
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        boolean bl = false;
        if (hashSet == null) {
            return false;
        }
        if (this.mDependents.size() > 0) {
            bl = true;
        }
        return bl;
    }

    public boolean isConnected() {
        boolean bl = this.mTarget != null;
        return bl;
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget) {
        if (this.isConnectionToMe(constraintWidget, new HashSet<ConstraintWidget>())) {
            return false;
        }
        ConstraintWidget constraintWidget2 = this.getOwner().getParent();
        if (constraintWidget2 == constraintWidget) {
            return true;
        }
        return constraintWidget.getParent() == constraintWidget2;
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget, ConstraintAnchor constraintAnchor) {
        return this.isConnectionAllowed(constraintWidget);
    }

    public boolean isSideAnchor() {
        switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.mType.name());
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return true;
            }
            case 1: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
        }
        return false;
    }

    public boolean isSimilarDimensionConnection(ConstraintAnchor object) {
        Type type2 = object.getType();
        object = this.mType;
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        if (type2 == object) {
            return true;
        }
        switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.mType.name());
            }
            case 9: {
                return false;
            }
            case 4: 
            case 5: 
            case 6: 
            case 8: {
                bl2 = bl3;
                if (type2 != Type.TOP) {
                    bl2 = bl3;
                    if (type2 != Type.BOTTOM) {
                        bl2 = bl3;
                        if (type2 != Type.CENTER_Y) {
                            bl2 = type2 == Type.BASELINE ? bl3 : false;
                        }
                    }
                }
                return bl2;
            }
            case 2: 
            case 3: 
            case 7: {
                bl2 = bl;
                if (type2 != Type.LEFT) {
                    bl2 = bl;
                    if (type2 != Type.RIGHT) {
                        bl2 = type2 == Type.CENTER_X ? bl : false;
                    }
                }
                return bl2;
            }
            case 1: 
        }
        if (type2 == Type.BASELINE) {
            bl2 = false;
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isValidConnection(ConstraintAnchor constraintAnchor) {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type type2 = constraintAnchor.getType();
        if (type2 == this.mType) {
            if (this.mType != Type.BASELINE) return true;
            if (!constraintAnchor.getOwner().hasBaseline()) return false;
            if (this.getOwner().hasBaseline()) return true;
            return false;
        }
        switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.mType.name());
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return false;
            }
            case 4: 
            case 5: {
                boolean bl4 = type2 == Type.TOP || type2 == Type.BOTTOM;
                bl2 = bl4;
                if (!(constraintAnchor.getOwner() instanceof Guideline)) return bl2;
                if (bl4) return true;
                bl4 = bl3;
                if (type2 != Type.CENTER_Y) return bl4;
                return true;
            }
            case 2: 
            case 3: {
                boolean bl5 = type2 == Type.LEFT || type2 == Type.RIGHT;
                bl2 = bl5;
                if (!(constraintAnchor.getOwner() instanceof Guideline)) return bl2;
                if (bl5) return true;
                bl5 = bl;
                if (type2 != Type.CENTER_X) return bl5;
                return true;
            }
            case 1: 
        }
        boolean bl6 = bl2;
        if (type2 == Type.BASELINE) return bl6;
        bl6 = bl2;
        if (type2 == Type.CENTER_X) return bl6;
        bl6 = bl2;
        if (type2 == Type.CENTER_Y) return bl6;
        return true;
    }

    public boolean isVerticalAnchor() {
        switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.mType.name());
            }
            case 4: 
            case 5: 
            case 6: 
            case 8: 
            case 9: {
                return true;
            }
            case 1: 
            case 2: 
            case 3: 
            case 7: 
        }
        return false;
    }

    public void reset() {
        if (this.mTarget != null && this.mTarget.mDependents != null) {
            this.mTarget.mDependents.remove(this);
        }
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
    }

    public void resetSolverVariable(Cache cache2) {
        if (this.mSolverVariable == null) {
            this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            this.mSolverVariable.reset();
        }
    }

    public void setGoneMargin(int n) {
        if (this.isConnected()) {
            this.mGoneMargin = n;
        }
    }

    public void setMargin(int n) {
        if (this.isConnected()) {
            this.mMargin = n;
        }
    }

    public String toString() {
        return this.mOwner.getDebugName() + ":" + this.mType.toString();
    }

    public static enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y;

    }
}

