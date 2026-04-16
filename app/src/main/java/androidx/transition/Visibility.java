/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.Animator$AnimatorPauseListener
 *  android.animation.AnimatorListenerAdapter
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.R;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils;
import androidx.transition.TransitionValues;
import androidx.transition.ViewGroupUtils;
import androidx.transition.ViewUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

public abstract class Visibility
extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    private int mMode = 3;

    public Visibility() {
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.VISIBILITY_TRANSITION);
        int n = TypedArrayUtils.getNamedInt((TypedArray)context, (XmlPullParser)((XmlResourceParser)attributeSet), "transitionVisibilityMode", 0, 0);
        context.recycle();
        if (n != 0) {
            this.setMode(n);
        }
    }

    private void captureValues(TransitionValues transitionValues) {
        int n = transitionValues.view.getVisibility();
        transitionValues.values.put(PROPNAME_VISIBILITY, n);
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        int[] nArray = new int[2];
        transitionValues.view.getLocationOnScreen(nArray);
        transitionValues.values.put(PROPNAME_SCREEN_LOCATION, nArray);
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.mVisibilityChange = false;
        visibilityInfo.mFadeIn = false;
        if (transitionValues != null && transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.mStartVisibility = (Integer)transitionValues.values.get(PROPNAME_VISIBILITY);
            visibilityInfo.mStartParent = (ViewGroup)transitionValues.values.get(PROPNAME_PARENT);
        } else {
            visibilityInfo.mStartVisibility = -1;
            visibilityInfo.mStartParent = null;
        }
        if (transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.mEndVisibility = (Integer)transitionValues2.values.get(PROPNAME_VISIBILITY);
            visibilityInfo.mEndParent = (ViewGroup)transitionValues2.values.get(PROPNAME_PARENT);
        } else {
            visibilityInfo.mEndVisibility = -1;
            visibilityInfo.mEndParent = null;
        }
        if (transitionValues != null && transitionValues2 != null) {
            if (visibilityInfo.mStartVisibility == visibilityInfo.mEndVisibility && visibilityInfo.mStartParent == visibilityInfo.mEndParent) {
                return visibilityInfo;
            }
            if (visibilityInfo.mStartVisibility != visibilityInfo.mEndVisibility) {
                if (visibilityInfo.mStartVisibility == 0) {
                    visibilityInfo.mFadeIn = false;
                    visibilityInfo.mVisibilityChange = true;
                } else if (visibilityInfo.mEndVisibility == 0) {
                    visibilityInfo.mFadeIn = true;
                    visibilityInfo.mVisibilityChange = true;
                }
            } else if (visibilityInfo.mEndParent == null) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
            } else if (visibilityInfo.mStartParent == null) {
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
            }
        } else if (transitionValues == null && visibilityInfo.mEndVisibility == 0) {
            visibilityInfo.mFadeIn = true;
            visibilityInfo.mVisibilityChange = true;
        } else if (transitionValues2 == null && visibilityInfo.mStartVisibility == 0) {
            visibilityInfo.mFadeIn = false;
            visibilityInfo.mVisibilityChange = true;
        }
        return visibilityInfo;
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    @Override
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = this.getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (visibilityInfo.mVisibilityChange && (visibilityInfo.mStartParent != null || visibilityInfo.mEndParent != null)) {
            if (visibilityInfo.mFadeIn) {
                return this.onAppear(viewGroup, transitionValues, visibilityInfo.mStartVisibility, transitionValues2, visibilityInfo.mEndVisibility);
            }
            return this.onDisappear(viewGroup, transitionValues, visibilityInfo.mStartVisibility, transitionValues2, visibilityInfo.mEndVisibility);
        }
        return null;
    }

    public int getMode() {
        return this.mMode;
    }

    @Override
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override
    public boolean isTransitionRequired(TransitionValues object, TransitionValues transitionValues) {
        boolean bl;
        block5: {
            block6: {
                boolean bl2 = false;
                if (object == null && transitionValues == null) {
                    return false;
                }
                if (object != null && transitionValues != null && transitionValues.values.containsKey(PROPNAME_VISIBILITY) != ((TransitionValues)object).values.containsKey(PROPNAME_VISIBILITY)) {
                    return false;
                }
                object = this.getVisibilityChangeInfo((TransitionValues)object, transitionValues);
                bl = bl2;
                if (!((VisibilityInfo)object).mVisibilityChange) break block5;
                if (((VisibilityInfo)object).mStartVisibility == 0) break block6;
                bl = bl2;
                if (((VisibilityInfo)object).mEndVisibility != 0) break block5;
            }
            bl = true;
        }
        return bl;
    }

    public boolean isVisible(TransitionValues transitionValues) {
        boolean bl = false;
        if (transitionValues == null) {
            return false;
        }
        int n = (Integer)transitionValues.values.get(PROPNAME_VISIBILITY);
        transitionValues = (View)transitionValues.values.get(PROPNAME_PARENT);
        boolean bl2 = bl;
        if (n == 0) {
            bl2 = bl;
            if (transitionValues != null) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int n, TransitionValues transitionValues2, int n2) {
        if ((this.mMode & 1) == 1 && transitionValues2 != null) {
            if (transitionValues == null) {
                Object object = (View)transitionValues2.view.getParent();
                TransitionValues transitionValues3 = this.getMatchedTransitionValues((View)object, false);
                object = this.getTransitionValues((View)object, false);
                if (this.getVisibilityChangeInfo((TransitionValues)transitionValues3, (TransitionValues)object).mVisibilityChange) {
                    return null;
                }
            }
            return this.onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
        }
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onDisappear(ViewGroup object, TransitionValues object2, int object3, TransitionValues transitionValues, int object4) {
        boolean bl;
        if ((this.mMode & 2) != 2) {
            return null;
        }
        if (object2 == null) {
            return null;
        }
        View view = ((TransitionValues)object2).view;
        Object object5 = transitionValues != null ? transitionValues.view : null;
        View view2 = null;
        View view3 = null;
        Object object6 = null;
        boolean bl2 = false;
        Object object7 = (View)view.getTag(R.id.save_overlay_view);
        if (object7 != null) {
            object5 = object7;
            bl = true;
        } else {
            object3 = 0;
            if (object5 != null && object5.getParent() != null) {
                if (object4 == 4) {
                    object6 = object5;
                } else if (view == object5) {
                    object6 = object5;
                } else {
                    object3 = 1;
                }
            } else if (object5 != null) {
                view2 = object5;
            } else {
                object3 = 1;
            }
            object5 = view2;
            view3 = object6;
            bl = bl2;
            if (object3 != 0) {
                if (view.getParent() == null) {
                    object5 = view;
                    view3 = object6;
                    bl = bl2;
                } else {
                    object5 = view2;
                    view3 = object6;
                    bl = bl2;
                    if (view.getParent() instanceof View) {
                        view3 = (View)view.getParent();
                        object7 = this.getTransitionValues(view3, true);
                        object5 = this.getMatchedTransitionValues(view3, true);
                        if (!this.getVisibilityChangeInfo((TransitionValues)object7, (TransitionValues)object5).mVisibilityChange) {
                            object5 = TransitionUtils.copyViewImage(object, view, view3);
                            view3 = object6;
                            bl = bl2;
                        } else {
                            object3 = view3.getId();
                            if (view3.getParent() == null) {
                                object5 = view2;
                                view3 = object6;
                                bl = bl2;
                                if (object3 != -1) {
                                    object5 = view2;
                                    view3 = object6;
                                    bl = bl2;
                                    if (object.findViewById(object3) != null) {
                                        object5 = view2;
                                        view3 = object6;
                                        bl = bl2;
                                        if (this.mCanRemoveViews) {
                                            object5 = view;
                                            view3 = object6;
                                            bl = bl2;
                                        }
                                    }
                                }
                            } else {
                                bl = bl2;
                                view3 = object6;
                                object5 = view2;
                            }
                        }
                    }
                }
            }
        }
        if (object5 != null) {
            if (!bl) {
                object6 = (int[])((TransitionValues)object2).values.get(PROPNAME_SCREEN_LOCATION);
                object3 = object6[0];
                object4 = object6[1];
                object6 = new int[2];
                object.getLocationOnScreen((int[])object6);
                object5.offsetLeftAndRight(object3 - object6[0] - object5.getLeft());
                object5.offsetTopAndBottom(object4 - object6[1] - object5.getTop());
                object.getOverlay().add(object5);
            }
            object2 = this.onDisappear((ViewGroup)object, (View)object5, (TransitionValues)object2, transitionValues);
            if (!bl) {
                if (object2 == null) {
                    object.getOverlay().remove(object5);
                } else {
                    view.setTag(R.id.save_overlay_view, object5);
                    object = new OverlayListener(this, (ViewGroup)object, (View)object5, view);
                    object2.addListener((Animator.AnimatorListener)object);
                    object2.addPauseListener((Animator.AnimatorPauseListener)object);
                    this.getRootTransition().addListener((Transition.TransitionListener)object);
                }
            }
            return object2;
        }
        if (view3 != null) {
            object3 = view3.getVisibility();
            ViewUtils.setTransitionVisibility(view3, 0);
            object = this.onDisappear((ViewGroup)object, view3, (TransitionValues)object2, transitionValues);
            if (object != null) {
                object2 = new DisappearListener(view3, (int)object4, true);
                object.addListener((Animator.AnimatorListener)object2);
                this.getRootTransition().addListener((Transition.TransitionListener)object2);
            } else {
                ViewUtils.setTransitionVisibility(view3, object3);
            }
            return object;
        }
        return null;
    }

    public void setMode(int n) {
        if ((n & 0xFFFFFFFC) == 0) {
            this.mMode = n;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    private static class DisappearListener
    extends AnimatorListenerAdapter
    implements Transition.TransitionListener {
        boolean mCanceled = false;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final View mView;

        DisappearListener(View view, int n, boolean bl) {
            this.mView = view;
            this.mFinalVisibility = n;
            this.mParent = (ViewGroup)view.getParent();
            this.mSuppressLayout = bl;
            this.suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
                if (this.mParent != null) {
                    this.mParent.invalidate();
                }
            }
            this.suppressLayout(false);
        }

        private void suppressLayout(boolean bl) {
            if (this.mSuppressLayout && this.mLayoutSuppressed != bl && this.mParent != null) {
                this.mLayoutSuppressed = bl;
                ViewGroupUtils.suppressLayout(this.mParent, bl);
            }
        }

        public void onAnimationCancel(Animator animator2) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator2) {
            this.hideViewWhenNotCanceled();
        }

        public void onAnimationEnd(Animator animator2, boolean bl) {
            if (!bl) {
                this.hideViewWhenNotCanceled();
            }
        }

        public void onAnimationRepeat(Animator animator2) {
        }

        public void onAnimationStart(Animator animator2) {
        }

        public void onAnimationStart(Animator animator2, boolean bl) {
            if (bl) {
                ViewUtils.setTransitionVisibility(this.mView, 0);
                if (this.mParent != null) {
                    this.mParent.invalidate();
                }
            }
        }

        @Override
        public void onTransitionCancel(Transition transition) {
        }

        @Override
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        @Override
        public void onTransitionPause(Transition transition) {
            this.suppressLayout(false);
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            }
        }

        @Override
        public void onTransitionResume(Transition transition) {
            this.suppressLayout(true);
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, 0);
            }
        }

        @Override
        public void onTransitionStart(Transition transition) {
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface Mode {
    }

    private class OverlayListener
    extends AnimatorListenerAdapter
    implements Transition.TransitionListener {
        private boolean mHasOverlay;
        private final ViewGroup mOverlayHost;
        private final View mOverlayView;
        private final View mStartView;
        final Visibility this$0;

        OverlayListener(Visibility visibility, ViewGroup viewGroup, View view, View view2) {
            this.this$0 = visibility;
            this.mHasOverlay = true;
            this.mOverlayHost = viewGroup;
            this.mOverlayView = view;
            this.mStartView = view2;
        }

        private void removeFromOverlay() {
            this.mStartView.setTag(R.id.save_overlay_view, null);
            this.mOverlayHost.getOverlay().remove(this.mOverlayView);
            this.mHasOverlay = false;
        }

        public void onAnimationEnd(Animator animator2) {
            this.removeFromOverlay();
        }

        public void onAnimationEnd(Animator animator2, boolean bl) {
            if (!bl) {
                this.removeFromOverlay();
            }
        }

        public void onAnimationPause(Animator animator2) {
            this.mOverlayHost.getOverlay().remove(this.mOverlayView);
        }

        public void onAnimationResume(Animator animator2) {
            if (this.mOverlayView.getParent() == null) {
                this.mOverlayHost.getOverlay().add(this.mOverlayView);
            } else {
                this.this$0.cancel();
            }
        }

        public void onAnimationStart(Animator animator2, boolean bl) {
            if (bl) {
                this.mStartView.setTag(R.id.save_overlay_view, (Object)this.mOverlayView);
                this.mOverlayHost.getOverlay().add(this.mOverlayView);
                this.mHasOverlay = true;
            }
        }

        @Override
        public void onTransitionCancel(Transition transition) {
            if (this.mHasOverlay) {
                this.removeFromOverlay();
            }
        }

        @Override
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        @Override
        public void onTransitionPause(Transition transition) {
        }

        @Override
        public void onTransitionResume(Transition transition) {
        }

        @Override
        public void onTransitionStart(Transition transition) {
        }
    }

    private static class VisibilityInfo {
        ViewGroup mEndParent;
        int mEndVisibility;
        boolean mFadeIn;
        ViewGroup mStartParent;
        int mStartVisibility;
        boolean mVisibilityChange;

        VisibilityInfo() {
        }
    }
}

