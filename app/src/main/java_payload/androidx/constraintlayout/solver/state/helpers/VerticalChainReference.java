/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.helpers.ChainReference;

public class VerticalChainReference
extends ChainReference {
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    @Override
    public void apply() {
        Object object = null;
        Object object2 = null;
        for (Object object3 : this.mReferences) {
            this.mState.constraints(object3).clearVertical();
        }
        for (Object object4 : this.mReferences) {
            Object object3;
            object4 = this.mState.constraints(object4);
            object3 = object;
            if (object == null) {
                object3 = object4;
                if (this.mTopToTop != null) {
                    ((ConstraintReference)object3).topToTop(this.mTopToTop);
                } else if (this.mTopToBottom != null) {
                    ((ConstraintReference)object3).topToBottom(this.mTopToBottom);
                } else {
                    ((ConstraintReference)object3).topToTop(State.PARENT);
                }
            }
            if (object2 != null) {
                ((ConstraintReference)object2).bottomToTop(((ConstraintReference)object4).getKey());
                ((ConstraintReference)object4).topToBottom(((ConstraintReference)object2).getKey());
            }
            object2 = object4;
            object = object3;
        }
        if (object2 != null) {
            if (this.mBottomToTop != null) {
                ((ConstraintReference)object2).bottomToTop(this.mBottomToTop);
            } else if (this.mBottomToBottom != null) {
                ((ConstraintReference)object2).bottomToBottom(this.mBottomToBottom);
            } else {
                ((ConstraintReference)object2).bottomToBottom(State.PARENT);
            }
        }
        if (object != null && this.mBias != 0.5f) {
            ((ConstraintReference)object).verticalBias(this.mBias);
        }
        switch (1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()]) {
            default: {
                break;
            }
            case 3: {
                ((ConstraintReference)object).setVerticalChainStyle(2);
                break;
            }
            case 2: {
                ((ConstraintReference)object).setVerticalChainStyle(1);
                break;
            }
            case 1: {
                ((ConstraintReference)object).setVerticalChainStyle(0);
            }
        }
    }

    public void bottomToBottom(Object object) {
        this.mBottomToBottom = object;
    }

    public void bottomToTop(Object object) {
        this.mBottomToTop = object;
    }

    public void topToBottom(Object object) {
        this.mTopToBottom = object;
    }

    public void topToTop(Object object) {
        this.mTopToTop = object;
    }
}

