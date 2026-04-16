/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;

public class AlignHorizontallyReference
extends HelperReference {
    private float mBias = 0.5f;
    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    public AlignHorizontallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
    }

    @Override
    public void apply() {
        for (Object object : this.mReferences) {
            object = this.mState.constraints(object);
            ((ConstraintReference)object).clearHorizontal();
            if (this.mStartToStart != null) {
                ((ConstraintReference)object).startToStart(this.mStartToStart);
            } else if (this.mStartToEnd != null) {
                ((ConstraintReference)object).startToEnd(this.mStartToEnd);
            } else {
                ((ConstraintReference)object).startToStart(State.PARENT);
            }
            if (this.mEndToStart != null) {
                ((ConstraintReference)object).endToStart(this.mEndToStart);
            } else if (this.mEndToEnd != null) {
                ((ConstraintReference)object).endToEnd(this.mEndToEnd);
            } else {
                ((ConstraintReference)object).endToEnd(State.PARENT);
            }
            if (this.mBias == 0.5f) continue;
            ((ConstraintReference)object).horizontalBias(this.mBias);
        }
    }

    public void bias(float f) {
        this.mBias = f;
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

