/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class Dimension {
    public static final Object FIXED_DIMENSION = new Object();
    public static final Object PARENT_DIMENSION;
    public static final Object PERCENT_DIMENSION;
    public static final Object SPREAD_DIMENSION;
    public static final Object WRAP_DIMENSION;
    private final int WRAP_CONTENT;
    Object mInitialValue;
    boolean mIsSuggested = false;
    int mMax = Integer.MAX_VALUE;
    int mMin = 0;
    float mPercent = 1.0f;
    float mRatio = 1.0f;
    int mValue = 0;

    static {
        WRAP_DIMENSION = new Object();
        SPREAD_DIMENSION = new Object();
        PARENT_DIMENSION = new Object();
        PERCENT_DIMENSION = new Object();
    }

    private Dimension() {
        this.WRAP_CONTENT = -2;
        this.mInitialValue = WRAP_DIMENSION;
    }

    private Dimension(Object object) {
        this.WRAP_CONTENT = -2;
        this.mInitialValue = WRAP_DIMENSION;
        this.mInitialValue = object;
    }

    public static Dimension Fixed(int n) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(n);
        return dimension;
    }

    public static Dimension Fixed(Object object) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(object);
        return dimension;
    }

    public static Dimension Parent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension Percent(Object object, float f) {
        Dimension dimension = new Dimension(PERCENT_DIMENSION);
        dimension.percent(object, f);
        return dimension;
    }

    public static Dimension Spread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension Suggested(int n) {
        Dimension dimension = new Dimension();
        dimension.suggested(n);
        return dimension;
    }

    public static Dimension Suggested(Object object) {
        Dimension dimension = new Dimension();
        dimension.suggested(object);
        return dimension;
    }

    public static Dimension Wrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    public void apply(State state, ConstraintWidget constraintWidget, int n) {
        if (n == 0) {
            if (this.mIsSuggested) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                n = 0;
                if (this.mInitialValue == WRAP_DIMENSION) {
                    n = 1;
                } else if (this.mInitialValue == PERCENT_DIMENSION) {
                    n = 2;
                }
                constraintWidget.setHorizontalMatchStyle(n, this.mMin, this.mMax, this.mPercent);
            } else {
                if (this.mMin > 0) {
                    constraintWidget.setMinWidth(this.mMin);
                }
                if (this.mMax < Integer.MAX_VALUE) {
                    constraintWidget.setMaxWidth(this.mMax);
                }
                if (this.mInitialValue == WRAP_DIMENSION) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                } else if (this.mInitialValue == PARENT_DIMENSION) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                } else if (this.mInitialValue == null) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidget.setWidth(this.mValue);
                }
            }
        } else if (this.mIsSuggested) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            n = 0;
            if (this.mInitialValue == WRAP_DIMENSION) {
                n = 1;
            } else if (this.mInitialValue == PERCENT_DIMENSION) {
                n = 2;
            }
            constraintWidget.setVerticalMatchStyle(n, this.mMin, this.mMax, this.mPercent);
        } else {
            if (this.mMin > 0) {
                constraintWidget.setMinHeight(this.mMin);
            }
            if (this.mMax < Integer.MAX_VALUE) {
                constraintWidget.setMaxHeight(this.mMax);
            }
            if (this.mInitialValue == WRAP_DIMENSION) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            } else if (this.mInitialValue == PARENT_DIMENSION) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            } else if (this.mInitialValue == null) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setHeight(this.mValue);
            }
        }
    }

    public Dimension fixed(int n) {
        this.mInitialValue = null;
        this.mValue = n;
        return this;
    }

    public Dimension fixed(Object object) {
        this.mInitialValue = object;
        if (object instanceof Integer) {
            this.mValue = (Integer)object;
            this.mInitialValue = null;
        }
        return this;
    }

    float getRatio() {
        return this.mRatio;
    }

    int getValue() {
        return this.mValue;
    }

    public Dimension max(int n) {
        if (this.mMax >= 0) {
            this.mMax = n;
        }
        return this;
    }

    public Dimension max(Object object) {
        if (object == WRAP_DIMENSION && this.mIsSuggested) {
            this.mInitialValue = WRAP_DIMENSION;
            this.mMax = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension min(int n) {
        if (n >= 0) {
            this.mMin = n;
        }
        return this;
    }

    public Dimension min(Object object) {
        if (object == WRAP_DIMENSION) {
            this.mMin = -2;
        }
        return this;
    }

    public Dimension percent(Object object, float f) {
        this.mPercent = f;
        return this;
    }

    public Dimension ratio(float f) {
        return this;
    }

    void setRatio(float f) {
        this.mRatio = f;
    }

    void setValue(int n) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = n;
    }

    public Dimension suggested(int n) {
        this.mIsSuggested = true;
        return this;
    }

    public Dimension suggested(Object object) {
        this.mInitialValue = object;
        this.mIsSuggested = true;
        return this;
    }

    public static enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT;

    }
}

