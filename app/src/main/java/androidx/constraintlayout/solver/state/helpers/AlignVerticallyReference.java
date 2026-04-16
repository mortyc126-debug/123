/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;

public class AlignVerticallyReference
extends HelperReference {
    private float mBias = 0.5f;
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    public AlignVerticallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
    }

    @Override
    public void apply() {
        for (Object object : this.mReferences) {
            object = this.mState.constraints(object);
            ((ConstraintReference)object).clearVertical();
            if (this.mTopToTop != null) {
                ((ConstraintReference)object).topToTop(this.mTopToTop);
            } else if (this.mTopToBottom != null) {
                ((ConstraintReference)object).topToBottom(this.mTopToBottom);
            } else {
                ((ConstraintReference)object).topToTop(State.PARENT);
            }
            if (this.mBottomToTop != null) {
                ((ConstraintReference)object).bottomToTop(this.mBottomToTop);
            } else if (this.mBottomToBottom != null) {
                ((ConstraintReference)object).bottomToBottom(this.mBottomToBottom);
            } else {
                ((ConstraintReference)object).bottomToBottom(State.PARENT);
            }
            if (this.mBias == 0.5f) continue;
            ((ConstraintReference)object).verticalBias(this.mBias);
        }
    }

    public void bias(float f) {
        this.mBias = f;
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

