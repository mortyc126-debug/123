/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.transition.CanvasUtils;
import androidx.transition.GhostView;
import androidx.transition.GhostViewHolder;
import androidx.transition.R;
import androidx.transition.ViewUtils;

class GhostViewPort
extends ViewGroup
implements GhostView {
    private Matrix mMatrix;
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener(this){
        final GhostViewPort this$0;
        {
            this.this$0 = ghostViewPort;
        }

        public boolean onPreDraw() {
            this.this$0.postInvalidateOnAnimation();
            if (this.this$0.mStartParent != null && this.this$0.mStartView != null) {
                this.this$0.mStartParent.endViewTransition(this.this$0.mStartView);
                this.this$0.mStartParent.postInvalidateOnAnimation();
                this.this$0.mStartParent = null;
                this.this$0.mStartView = null;
            }
            return true;
        }
    };
    int mReferences;
    ViewGroup mStartParent;
    View mStartView;
    final View mView;

    GhostViewPort(View view) {
        super(view.getContext());
        this.mView = view;
        this.setWillNotDraw(false);
        this.setClipChildren(false);
        this.setLayerType(2, null);
    }

    static GhostViewPort addGhost(View object, ViewGroup viewGroup, Matrix object2) {
        if (object.getParent() instanceof ViewGroup) {
            GhostViewHolder ghostViewHolder = GhostViewHolder.getHolder(viewGroup);
            GhostViewPort ghostViewPort = GhostViewPort.getGhostView((View)object);
            int n = 0;
            GhostViewPort ghostViewPort2 = ghostViewPort;
            int n2 = n;
            if (ghostViewPort != null) {
                GhostViewHolder ghostViewHolder2 = (GhostViewHolder)ghostViewPort.getParent();
                ghostViewPort2 = ghostViewPort;
                n2 = n;
                if (ghostViewHolder2 != ghostViewHolder) {
                    n2 = ghostViewPort.mReferences;
                    ghostViewHolder2.removeView((View)ghostViewPort);
                    ghostViewPort2 = null;
                }
            }
            if (ghostViewPort2 == null) {
                ghostViewPort2 = object2;
                if (object2 == null) {
                    ghostViewPort2 = new Matrix();
                    GhostViewPort.calculateMatrix((View)object, viewGroup, (Matrix)ghostViewPort2);
                }
                object2 = new GhostViewPort((View)object);
                ((GhostViewPort)object2).setMatrix((Matrix)ghostViewPort2);
                if (ghostViewHolder == null) {
                    object = new GhostViewHolder(viewGroup);
                } else {
                    ghostViewHolder.popToOverlayTop();
                    object = ghostViewHolder;
                }
                GhostViewPort.copySize((View)viewGroup, (View)object);
                GhostViewPort.copySize((View)viewGroup, (View)object2);
                ((GhostViewHolder)((Object)object)).addGhostView((GhostViewPort)object2);
                ((GhostViewPort)object2).mReferences = n2;
                object = object2;
            } else {
                object = ghostViewPort2;
                if (object2 != null) {
                    ghostViewPort2.setMatrix((Matrix)object2);
                    object = ghostViewPort2;
                }
            }
            ++((GhostViewPort)object).mReferences;
            return object;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    static void calculateMatrix(View view, ViewGroup viewGroup, Matrix matrix) {
        view = (ViewGroup)view.getParent();
        matrix.reset();
        ViewUtils.transformMatrixToGlobal(view, matrix);
        matrix.preTranslate((float)(-view.getScrollX()), (float)(-view.getScrollY()));
        ViewUtils.transformMatrixToLocal((View)viewGroup, matrix);
    }

    static void copySize(View view, View view2) {
        ViewUtils.setLeftTopRightBottom(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static GhostViewPort getGhostView(View view) {
        return (GhostViewPort)view.getTag(R.id.ghost_view);
    }

    static void removeGhost(View object) {
        if ((object = GhostViewPort.getGhostView(object)) != null) {
            --object.mReferences;
            if (object.mReferences <= 0) {
                ((GhostViewHolder)object.getParent()).removeView((View)object);
            }
        }
    }

    static void setGhostView(View view, GhostViewPort ghostViewPort) {
        view.setTag(R.id.ghost_view, (Object)ghostViewPort);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GhostViewPort.setGhostView(this.mView, this);
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 4);
        if (this.mView.getParent() != null) {
            ((View)this.mView.getParent()).invalidate();
        }
    }

    protected void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        GhostViewPort.setGhostView(this.mView, null);
        if (this.mView.getParent() != null) {
            ((View)this.mView.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        CanvasUtils.enableZ(canvas, true);
        canvas.setMatrix(this.mMatrix);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        this.mView.invalidate();
        ViewUtils.setTransitionVisibility(this.mView, 4);
        this.drawChild(canvas, this.mView, this.getDrawingTime());
        CanvasUtils.enableZ(canvas, false);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
    }

    @Override
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        this.mStartParent = viewGroup;
        this.mStartView = view;
    }

    void setMatrix(Matrix matrix) {
        this.mMatrix = matrix;
    }

    @Override
    public void setVisibility(int n) {
        super.setVisibility(n);
        if (GhostViewPort.getGhostView(this.mView) == this) {
            n = n == 0 ? 4 : 0;
            ViewUtils.setTransitionVisibility(this.mView, n);
        }
    }
}

