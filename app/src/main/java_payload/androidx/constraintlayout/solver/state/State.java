/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.Dimension;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.Reference;
import androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.solver.state.helpers.BarrierReference;
import androidx.constraintlayout.solver.state.helpers.GuidelineReference;
import androidx.constraintlayout.solver.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.solver.state.helpers.VerticalChainReference;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.WidgetContainer;
import java.util.HashMap;

public class State {
    static final int CONSTRAINT_RATIO = 2;
    static final int CONSTRAINT_SPREAD = 0;
    static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT = 0;
    static final int UNKNOWN = -1;
    protected HashMap<Object, HelperReference> mHelperReferences;
    public final ConstraintReference mParent;
    protected HashMap<Object, Reference> mReferences = new HashMap();
    private int numHelpers = 0;

    public State() {
        this.mHelperReferences = new HashMap();
        this.mParent = new ConstraintReference(this);
        this.mReferences.put(PARENT, this.mParent);
    }

    private String createHelperKey() {
        StringBuilder stringBuilder = new StringBuilder().append("__HELPER_KEY_");
        int n = this.numHelpers;
        this.numHelpers = n + 1;
        return stringBuilder.append(n).append("__").toString();
    }

    public void apply(ConstraintWidgetContainer iterator2) {
        Object object4;
        ((WidgetContainer)((Object)iterator2)).removeAllChildren();
        this.mParent.getWidth().apply(this, (ConstraintWidget)((Object)iterator2), 0);
        this.mParent.getHeight().apply(this, (ConstraintWidget)((Object)iterator2), 1);
        for (Object object2 : this.mHelperReferences.keySet()) {
            object4 = this.mHelperReferences.get(object2).getHelperWidget();
            if (object4 == null) continue;
            Reference iterator3 = this.mReferences.get(object2);
            Object object3 = iterator3;
            if (iterator3 == null) {
                object3 = this.constraints(object2);
            }
            object3.setConstraintWidget((ConstraintWidget)object4);
        }
        for (Object object3 : this.mReferences.keySet()) {
            Reference reference = this.mReferences.get(object3);
            if (reference != this.mParent) {
                object4 = reference.getConstraintWidget();
                ((ConstraintWidget)object4).setParent(null);
                if (reference instanceof GuidelineReference) {
                    reference.apply();
                }
                ((WidgetContainer)((Object)iterator2)).add((ConstraintWidget)object4);
                continue;
            }
            reference.setConstraintWidget((ConstraintWidget)((Object)iterator2));
        }
        for (Object object3 : this.mHelperReferences.keySet()) {
            if (((HelperReference)(object3 = this.mHelperReferences.get(object3))).getHelperWidget() == null) continue;
            for (Object object4 : ((HelperReference)object3).mReferences) {
                object4 = this.mReferences.get(object4);
                ((HelperReference)object3).getHelperWidget().add(object4.getConstraintWidget());
            }
            ((HelperReference)object3).apply();
        }
        for (Object object3 : this.mReferences.keySet()) {
            this.mReferences.get(object3).apply();
        }
    }

    public BarrierReference barrier(Object object, Direction direction) {
        object = (BarrierReference)this.helper(object, Helper.BARRIER);
        ((BarrierReference)object).setBarrierDirection(direction);
        return object;
    }

    public AlignHorizontallyReference centerHorizontally(Object ... objectArray) {
        AlignHorizontallyReference alignHorizontallyReference = (AlignHorizontallyReference)this.helper(null, Helper.ALIGN_HORIZONTALLY);
        alignHorizontallyReference.add(objectArray);
        return alignHorizontallyReference;
    }

    public AlignVerticallyReference centerVertically(Object ... objectArray) {
        AlignVerticallyReference alignVerticallyReference = (AlignVerticallyReference)this.helper(null, Helper.ALIGN_VERTICALLY);
        alignVerticallyReference.add(objectArray);
        return alignVerticallyReference;
    }

    public ConstraintReference constraints(Object object) {
        Reference reference;
        Reference reference2 = reference = this.mReferences.get(object);
        if (reference == null) {
            reference2 = this.createConstraintReference(object);
            this.mReferences.put(object, reference2);
            reference2.setKey(object);
        }
        if (reference2 instanceof ConstraintReference) {
            return (ConstraintReference)reference2;
        }
        return null;
    }

    public int convertDimension(Object object) {
        if (object instanceof Float) {
            return ((Float)object).intValue();
        }
        if (object instanceof Integer) {
            return (Integer)object;
        }
        return 0;
    }

    public ConstraintReference createConstraintReference(Object object) {
        return new ConstraintReference(this);
    }

    public void directMapping() {
        for (Object object : this.mReferences.keySet()) {
            this.constraints(object).setView(object);
        }
    }

    public GuidelineReference guideline(Object object, int n) {
        Reference reference;
        Reference reference2 = reference = this.mReferences.get(object);
        if (reference == null) {
            reference2 = new GuidelineReference(this);
            ((GuidelineReference)reference2).setOrientation(n);
            ((GuidelineReference)reference2).setKey(object);
            this.mReferences.put(object, reference2);
        }
        return (GuidelineReference)reference2;
    }

    public State height(Dimension dimension) {
        return this.setHeight(dimension);
    }

    public HelperReference helper(Object object, Helper helper) {
        Object object2 = object;
        if (object == null) {
            object2 = this.createHelperKey();
        }
        HelperReference helperReference = this.mHelperReferences.get(object2);
        object = helperReference;
        if (helperReference == null) {
            switch (1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[helper.ordinal()]) {
                default: {
                    object = new HelperReference(this, helper);
                    break;
                }
                case 5: {
                    object = new BarrierReference(this);
                    break;
                }
                case 4: {
                    object = new AlignVerticallyReference(this);
                    break;
                }
                case 3: {
                    object = new AlignHorizontallyReference(this);
                    break;
                }
                case 2: {
                    object = new VerticalChainReference(this);
                    break;
                }
                case 1: {
                    object = new HorizontalChainReference(this);
                }
            }
            this.mHelperReferences.put(object2, (HelperReference)object);
        }
        return object;
    }

    public HorizontalChainReference horizontalChain(Object ... objectArray) {
        HorizontalChainReference horizontalChainReference = (HorizontalChainReference)this.helper(null, Helper.HORIZONTAL_CHAIN);
        horizontalChainReference.add(objectArray);
        return horizontalChainReference;
    }

    public GuidelineReference horizontalGuideline(Object object) {
        return this.guideline(object, 0);
    }

    public void map(Object object, Object object2) {
        this.constraints(object).setView(object2);
    }

    Reference reference(Object object) {
        return this.mReferences.get(object);
    }

    public void reset() {
        this.mHelperReferences.clear();
    }

    public State setHeight(Dimension dimension) {
        this.mParent.setHeight(dimension);
        return this;
    }

    public State setWidth(Dimension dimension) {
        this.mParent.setWidth(dimension);
        return this;
    }

    public VerticalChainReference verticalChain(Object ... objectArray) {
        VerticalChainReference verticalChainReference = (VerticalChainReference)this.helper(null, Helper.VERTICAL_CHAIN);
        verticalChainReference.add(objectArray);
        return verticalChainReference;
    }

    public GuidelineReference verticalGuideline(Object object) {
        return this.guideline(object, 1);
    }

    public State width(Dimension dimension) {
        return this.setWidth(dimension);
    }

    public static enum Chain {
        SPREAD,
        SPREAD_INSIDE,
        PACKED;

    }

    public static enum Constraint {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BASELINE_TO_BASELINE,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY;

    }

    public static enum Direction {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM;

    }

    public static enum Helper {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        FLOW;

    }
}

