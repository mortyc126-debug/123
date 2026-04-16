/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.ObjectAnimatorUtils;
import androidx.transition.R;
import androidx.transition.RectEvaluator;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionUtils;
import androidx.transition.TransitionValues;
import androidx.transition.ViewGroupUtils;
import androidx.transition.ViewUtils;
import org.xmlpull.v1.XmlPullParser;

public class ChangeBounds
extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY;
    private static final Property<View, PointF> POSITION_PROPERTY;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY;
    private static final RectEvaluator sRectEvaluator;
    private static final String[] sTransitionProperties;
    private boolean mResizeClip = false;

    static {
        sTransitionProperties = new String[]{PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
        TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "topLeft"){

            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.setTopLeft(pointF);
            }
        };
        BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "bottomRight"){

            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.setBottomRight(pointF);
            }
        };
        BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "bottomRight"){

            public PointF get(View view) {
                return null;
            }

            public void set(View view, PointF pointF) {
                ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
            }
        };
        TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "topLeft"){

            public PointF get(View view) {
                return null;
            }

            public void set(View view, PointF pointF) {
                ViewUtils.setLeftTopRightBottom(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
            }
        };
        POSITION_PROPERTY = new Property<View, PointF>(PointF.class, "position"){

            public PointF get(View view) {
                return null;
            }

            public void set(View view, PointF pointF) {
                int n = Math.round(pointF.x);
                int n2 = Math.round(pointF.y);
                ViewUtils.setLeftTopRightBottom(view, n, n2, view.getWidth() + n, view.getHeight() + n2);
            }
        };
        sRectEvaluator = new RectEvaluator();
    }

    public ChangeBounds() {
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean bl = TypedArrayUtils.getNamedBoolean((TypedArray)context, (XmlPullParser)((XmlResourceParser)attributeSet), "resizeClip", 0, false);
        context.recycle();
        this.setResizeClip(bl);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.isLaidOut() || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
            if (this.mResizeClip) {
                transitionValues.values.put(PROPNAME_CLIP, view.getClipBounds());
            }
        }
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        Rect rect;
        this.captureValues(transitionValues);
        if (this.mResizeClip && (rect = (Rect)transitionValues.view.getTag(R.id.transition_clip)) != null) {
            transitionValues.values.put(PROPNAME_CLIP, rect);
        }
    }

    @Override
    public Animator createAnimator(ViewGroup object, TransitionValues object2, TransitionValues transitionValues) {
        block22: {
            block23: {
                int n;
                int n2;
                int n3;
                int n4;
                int n5;
                int n6;
                int n7;
                int n8;
                int n9;
                int n10;
                int n11;
                int n12;
                int n13;
                View view;
                ViewGroup viewGroup;
                block28: {
                    int n14;
                    block27: {
                        block25: {
                            block26: {
                                block24: {
                                    if (object2 == null || transitionValues == null) break block22;
                                    viewGroup = ((TransitionValues)object2).values;
                                    object = transitionValues.values;
                                    viewGroup = (ViewGroup)viewGroup.get(PROPNAME_PARENT);
                                    object = (ViewGroup)object.get(PROPNAME_PARENT);
                                    if (viewGroup == null || object == null) break block23;
                                    view = transitionValues.view;
                                    object = (Rect)((TransitionValues)object2).values.get(PROPNAME_BOUNDS);
                                    viewGroup = (Rect)transitionValues.values.get(PROPNAME_BOUNDS);
                                    n13 = ((Rect)object).left;
                                    n12 = viewGroup.left;
                                    n11 = ((Rect)object).top;
                                    n10 = viewGroup.top;
                                    n9 = ((Rect)object).right;
                                    n8 = viewGroup.right;
                                    n7 = ((Rect)object).bottom;
                                    n6 = viewGroup.bottom;
                                    n5 = n9 - n13;
                                    n4 = n7 - n11;
                                    n3 = n8 - n12;
                                    n2 = n6 - n10;
                                    object2 = (Rect)((TransitionValues)object2).values.get(PROPNAME_CLIP);
                                    transitionValues = (Rect)transitionValues.values.get(PROPNAME_CLIP);
                                    int n15 = 0;
                                    n = 0;
                                    if (n5 != 0 && n4 != 0) break block24;
                                    n14 = n15;
                                    if (n3 == 0) break block25;
                                    n14 = n15;
                                    if (n2 == 0) break block25;
                                }
                                if (n13 != n12 || n11 != n10) {
                                    n = 0 + 1;
                                }
                                if (n9 != n8) break block26;
                                n14 = n;
                                if (n7 == n6) break block25;
                            }
                            n14 = n + 1;
                        }
                        if (object2 != null && !object2.equals((Object)transitionValues)) break block27;
                        n = n14;
                        if (object2 != null) break block28;
                        n = n14;
                        if (transitionValues == null) break block28;
                    }
                    n = n14 + 1;
                }
                if (n > 0) {
                    if (!this.mResizeClip) {
                        ViewUtils.setLeftTopRightBottom(view, n13, n11, n9, n7);
                        if (n == 2) {
                            if (n5 == n3 && n4 == n2) {
                                object = this.getPathMotion().getPath(n13, n11, n12, n10);
                                object = ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, (Path)object);
                            } else {
                                object2 = new ViewBounds(view);
                                object = this.getPathMotion().getPath(n13, n11, n12, n10);
                                transitionValues = ObjectAnimatorUtils.ofPointF(object2, TOP_LEFT_PROPERTY, (Path)object);
                                object = this.getPathMotion().getPath(n9, n7, n8, n6);
                                viewGroup = ObjectAnimatorUtils.ofPointF(object2, BOTTOM_RIGHT_PROPERTY, (Path)object);
                                object = new AnimatorSet();
                                object.playTogether(new Animator[]{transitionValues, viewGroup});
                                object.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, (ViewBounds)object2){
                                    private final ViewBounds mViewBounds;
                                    final ChangeBounds this$0;
                                    final ViewBounds val$viewBounds;
                                    {
                                        this.this$0 = changeBounds;
                                        this.val$viewBounds = viewBounds;
                                        this.mViewBounds = this.val$viewBounds;
                                    }
                                });
                            }
                        } else if (n13 == n12 && n11 == n10) {
                            object = this.getPathMotion().getPath(n9, n7, n8, n6);
                            object = ObjectAnimatorUtils.ofPointF(view, BOTTOM_RIGHT_ONLY_PROPERTY, (Path)object);
                        } else {
                            object = this.getPathMotion().getPath(n13, n11, n12, n10);
                            object = ObjectAnimatorUtils.ofPointF(view, TOP_LEFT_ONLY_PROPERTY, (Path)object);
                        }
                    } else {
                        boolean bl;
                        ViewUtils.setLeftTopRightBottom(view, n13, n11, n13 + Math.max(n5, n3), n11 + Math.max(n4, n2));
                        object = null;
                        if (n13 != n12 || n11 != n10) {
                            object = this.getPathMotion().getPath(n13, n11, n12, n10);
                            object = ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, (Path)object);
                        }
                        boolean bl2 = object2 == null;
                        if (bl2) {
                            object2 = new Rect(0, 0, n5, n4);
                        }
                        if (bl = transitionValues == null) {
                            transitionValues = new Rect(0, 0, n3, n2);
                        }
                        viewGroup = null;
                        if (!object2.equals((Object)transitionValues)) {
                            view.setClipBounds((Rect)object2);
                            viewGroup = ObjectAnimator.ofObject((Object)view, (String)"clipBounds", (TypeEvaluator)sRectEvaluator, (Object[])new Object[]{object2, transitionValues});
                            object2 = new ClipListener(view, (Rect)object2, bl2, (Rect)transitionValues, bl, n13, n11, n9, n7, n12, n10, n8, n6);
                            viewGroup.addListener((Animator.AnimatorListener)object2);
                            this.addListener((Transition.TransitionListener)object2);
                            object2 = viewGroup;
                        } else {
                            object2 = viewGroup;
                        }
                        object = TransitionUtils.mergeAnimators((Animator)object, (Animator)object2);
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        object2 = (ViewGroup)view.getParent();
                        ViewGroupUtils.suppressLayout((ViewGroup)object2, true);
                        this.getRootTransition().addListener(new SuppressLayoutListener((ViewGroup)object2));
                    }
                    return object;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override
    public boolean isSeekingSupported() {
        return true;
    }

    public void setResizeClip(boolean bl) {
        this.mResizeClip = bl;
    }

    private static class ClipListener
    extends AnimatorListenerAdapter
    implements Transition.TransitionListener {
        private final int mEndBottom;
        private final Rect mEndClip;
        private final boolean mEndClipIsNull;
        private final int mEndLeft;
        private final int mEndRight;
        private final int mEndTop;
        private boolean mIsCanceled;
        private final int mStartBottom;
        private final Rect mStartClip;
        private final boolean mStartClipIsNull;
        private final int mStartLeft;
        private final int mStartRight;
        private final int mStartTop;
        private final View mView;

        ClipListener(View view, Rect rect, boolean bl, Rect rect2, boolean bl2, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
            this.mView = view;
            this.mStartClip = rect;
            this.mStartClipIsNull = bl;
            this.mEndClip = rect2;
            this.mEndClipIsNull = bl2;
            this.mStartLeft = n;
            this.mStartTop = n2;
            this.mStartRight = n3;
            this.mStartBottom = n4;
            this.mEndLeft = n5;
            this.mEndTop = n6;
            this.mEndRight = n7;
            this.mEndBottom = n8;
        }

        public void onAnimationEnd(Animator animator2) {
            this.onAnimationEnd(animator2, false);
        }

        public void onAnimationEnd(Animator animator2, boolean bl) {
            if (this.mIsCanceled) {
                return;
            }
            animator2 = null;
            if (bl) {
                if (!this.mStartClipIsNull) {
                    animator2 = this.mStartClip;
                }
            } else if (!this.mEndClipIsNull) {
                animator2 = this.mEndClip;
            }
            this.mView.setClipBounds((Rect)animator2);
            if (bl) {
                ViewUtils.setLeftTopRightBottom(this.mView, this.mStartLeft, this.mStartTop, this.mStartRight, this.mStartBottom);
            } else {
                ViewUtils.setLeftTopRightBottom(this.mView, this.mEndLeft, this.mEndTop, this.mEndRight, this.mEndBottom);
            }
        }

        public void onAnimationStart(Animator animator2) {
            this.onAnimationStart(animator2, false);
        }

        public void onAnimationStart(Animator animator2, boolean bl) {
            int n = Math.max(this.mStartRight - this.mStartLeft, this.mEndRight - this.mEndLeft);
            int n2 = Math.max(this.mStartBottom - this.mStartTop, this.mEndBottom - this.mEndTop);
            int n3 = bl ? this.mEndLeft : this.mStartLeft;
            int n4 = bl ? this.mEndTop : this.mStartTop;
            ViewUtils.setLeftTopRightBottom(this.mView, n3, n4, n3 + n, n4 + n2);
            animator2 = bl ? this.mEndClip : this.mStartClip;
            this.mView.setClipBounds((Rect)animator2);
        }

        @Override
        public void onTransitionCancel(Transition transition) {
            this.mIsCanceled = true;
        }

        @Override
        public void onTransitionEnd(Transition transition) {
        }

        @Override
        public void onTransitionPause(Transition transition) {
            transition = this.mView.getClipBounds();
            this.mView.setTag(R.id.transition_clip, (Object)transition);
            transition = this.mEndClipIsNull ? null : this.mEndClip;
            this.mView.setClipBounds((Rect)transition);
        }

        @Override
        public void onTransitionResume(Transition transition) {
            transition = (Rect)this.mView.getTag(R.id.transition_clip);
            this.mView.setTag(R.id.transition_clip, null);
            this.mView.setClipBounds((Rect)transition);
        }

        @Override
        public void onTransitionStart(Transition transition) {
        }
    }

    private static class SuppressLayoutListener
    extends TransitionListenerAdapter {
        boolean mCanceled = false;
        final ViewGroup mParent;

        SuppressLayoutListener(ViewGroup viewGroup) {
            this.mParent = viewGroup;
        }

        @Override
        public void onTransitionCancel(Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
            this.mCanceled = true;
        }

        @Override
        public void onTransitionEnd(Transition transition) {
            if (!this.mCanceled) {
                ViewGroupUtils.suppressLayout(this.mParent, false);
            }
            transition.removeListener(this);
        }

        @Override
        public void onTransitionPause(Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
        }

        @Override
        public void onTransitionResume(Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, true);
        }
    }

    private static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private final View mView;

        ViewBounds(View view) {
            this.mView = view;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        void setBottomRight(PointF pointF) {
            this.mRight = Math.round(pointF.x);
            this.mBottom = Math.round(pointF.y);
            ++this.mBottomRightCalls;
            if (this.mTopLeftCalls == this.mBottomRightCalls) {
                this.setLeftTopRightBottom();
            }
        }

        void setTopLeft(PointF pointF) {
            this.mLeft = Math.round(pointF.x);
            this.mTop = Math.round(pointF.y);
            ++this.mTopLeftCalls;
            if (this.mTopLeftCalls == this.mBottomRightCalls) {
                this.setLeftTopRightBottom();
            }
        }
    }
}

