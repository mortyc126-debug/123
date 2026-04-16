/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.helpers.ChainReference;

public class HorizontalChainReference
extends ChainReference {
    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override
    public void apply() {
        Object object = null;
        ConstraintReference constraintReference = null;
        for (Object object2 : this.mReferences) {
            this.mState.constraints(object2).clearHorizontal();
        }
        for (Object object3 : this.mReferences) {
            Object object2;
            object2 = this.mState.constraints(object3);
            object3 = object;
            if (object == null) {
                object3 = object2;
                if (this.mStartToStart != null) {
                    ((ConstraintReference)object3).startToStart(this.mStartToStart);
                } else if (this.mStartToEnd != null) {
                    ((ConstraintReference)object3).startToEnd(this.mStartToEnd);
                } else {
                    ((ConstraintReference)object3).startToStart(State.PARENT);
                }
            }
            if (constraintReference != null) {
                constraintReference.endToStart(((ConstraintReference)object2).getKey());
                ((ConstraintReference)object2).startToEnd(constraintReference.getKey());
            }
            constraintReference = object2;
            object = object3;
        }
        if (constraintReference != null) {
            if (this.mEndToStart != null) {
                constraintReference.endToStart(this.mEndToStart);
            } else if (this.mEndToEnd != null) {
                constraintReference.endToEnd(this.mEndToEnd);
            } else {
                constraintReference.endToEnd(State.PARENT);
            }
        }
        if (object != null && this.mBias != 0.5f) {
            ((ConstraintReference)object).horizontalBias(this.mBias);
        }
        switch (1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()]) {
            default: {
                break;
            }
            case 3: {
                ((ConstraintReference)object).setHorizontalChainStyle(2);
                break;
            }
            case 2: {
                ((ConstraintReference)object).setHorizontalChainStyle(1);
                break;
            }
            case 1: {
                ((ConstraintReference)object).setHorizontalChainStyle(0);
            }
        }
    }

    public void endToEnd(Object object) {
        this.mEndToEnd = object;
    }

    public void endToStart(Object object) {
        this.mEndToStart = object;
    }

    public void startToEnd(Object object) {
        this.mStartToEnd = object;
    }

    public void startToStart(Object object) {
        this.mStartToStart = object;
    }
}

