/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.DashPathEffect
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathEffect
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.Interpolator
 *  android.widget.TextView
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.DesignTool;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionInterpolator;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.TouchResponse;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.solver.widgets.WidgetContainer;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.core.view.NestedScrollingParent3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MotionLayout
extends ConstraintLayout
implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    boolean firstDown = true;
    private float lastPos;
    private float lastY;
    private long mAnimationStartTime = 0L;
    private int mBeginState = -1;
    private RectF mBoundsCheck;
    int mCurrentState = -1;
    int mDebugPath = 0;
    private DecelerateInterpolator mDecelerateLogic;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    private int mEndState = -1;
    int mEndWrapHeight;
    int mEndWrapWidth;
    HashMap<View, MotionController> mFrameArrayList = new HashMap();
    private int mFrames = 0;
    int mHeightMeasureMode;
    private boolean mInLayout = false;
    boolean mInTransition = false;
    boolean mIndirectTransition = false;
    private boolean mInteractionEnabled = true;
    Interpolator mInterpolator;
    boolean mIsAnimating = false;
    private boolean mKeepAnimating = false;
    private KeyCache mKeyCache;
    private long mLastDrawTime = -1L;
    private float mLastFps = 0.0f;
    private int mLastHeightMeasureSpec = 0;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    float mLastVelocity = 0.0f;
    private int mLastWidthMeasureSpec = 0;
    private float mListenerPosition = 0.0f;
    private int mListenerState = 0;
    protected boolean mMeasureDuringTransition = false;
    Model mModel;
    private boolean mNeedsFireTransitionCompleted = false;
    int mOldHeight;
    int mOldWidth;
    private ArrayList<MotionHelper> mOnHideHelpers = null;
    private ArrayList<MotionHelper> mOnShowHelpers = null;
    float mPostInterpolationPosition;
    private View mRegionView = null;
    MotionScene mScene;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private StateCache mStateCache;
    private StopLogic mStopLogic = new StopLogic();
    private boolean mTemporalInterpolator = false;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration = 1.0f;
    float mTransitionGoalPosition = 0.0f;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition = 0.0f;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private ArrayList<TransitionListener> mTransitionListeners = null;
    float mTransitionPosition = 0.0f;
    TransitionState mTransitionState;
    boolean mUndergoingMotion = false;
    int mWidthMeasureMode;

    public MotionLayout(Context context) {
        super(context);
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.mKeyCache = new KeyCache();
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mBoundsCheck = new RectF();
        this.mTransitionCompleted = new ArrayList();
        this.init(null);
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.mKeyCache = new KeyCache();
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mBoundsCheck = new RectF();
        this.mTransitionCompleted = new ArrayList();
        this.init(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.mKeyCache = new KeyCache();
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mBoundsCheck = new RectF();
        this.mTransitionCompleted = new ArrayList();
        this.init(attributeSet);
    }

    private void checkStructure() {
        if (this.mScene == null) {
            Log.e((String)TAG, (String)"CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        this.checkStructure(this.mScene.getStartId(), this.mScene.getConstraintSet(this.mScene.getStartId()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        for (MotionScene.Transition transition : this.mScene.getDefinedTransitions()) {
            if (transition == this.mScene.mCurrentTransition) {
                Log.v((String)TAG, (String)"CHECK: CURRENT");
            }
            this.checkStructure(transition);
            int n = transition.getStartConstraintSetId();
            int n2 = transition.getEndConstraintSetId();
            String string2 = Debug.getName(this.getContext(), n);
            String object = Debug.getName(this.getContext(), n2);
            if (sparseIntArray.get(n) == n2) {
                Log.e((String)TAG, (String)("CHECK: two transitions with the same start and end " + string2 + "->" + object));
            }
            if (sparseIntArray2.get(n2) == n) {
                Log.e((String)TAG, (String)("CHECK: you can't have reverse transitions" + string2 + "->" + object));
            }
            sparseIntArray.put(n, n2);
            sparseIntArray2.put(n2, n);
            if (this.mScene.getConstraintSet(n) == null) {
                Log.e((String)TAG, (String)(" no such constraintSetStart " + string2));
            }
            if (this.mScene.getConstraintSet(n2) != null) continue;
            Log.e((String)TAG, (String)(" no such constraintSetEnd " + string2));
        }
    }

    private void checkStructure(int n, ConstraintSet constraintSet) {
        Object object;
        String string2 = Debug.getName(this.getContext(), n);
        int n2 = this.getChildCount();
        for (n = 0; n < n2; ++n) {
            object = this.getChildAt(n);
            int n3 = object.getId();
            if (n3 == -1) {
                Log.w((String)TAG, (String)("CHECK: " + string2 + " ALL VIEWS SHOULD HAVE ID's " + object.getClass().getName() + " does not!"));
            }
            if (constraintSet.getConstraint(n3) != null) continue;
            Log.w((String)TAG, (String)("CHECK: " + string2 + " NO CONSTRAINTS for " + Debug.getName((View)object)));
        }
        int[] nArray = constraintSet.getKnownIds();
        for (n = 0; n < nArray.length; ++n) {
            n2 = nArray[n];
            object = Debug.getName(this.getContext(), n2);
            if (this.findViewById(nArray[n]) == null) {
                Log.w((String)TAG, (String)("CHECK: " + string2 + " NO View matches id " + (String)object));
            }
            if (constraintSet.getHeight(n2) == -1) {
                Log.w((String)TAG, (String)("CHECK: " + string2 + "(" + (String)object + ") no LAYOUT_HEIGHT"));
            }
            if (constraintSet.getWidth(n2) != -1) continue;
            Log.w((String)TAG, (String)("CHECK: " + string2 + "(" + (String)object + ") no LAYOUT_HEIGHT"));
        }
    }

    private void checkStructure(MotionScene.Transition transition) {
        Log.v((String)TAG, (String)("CHECK: transition = " + transition.debugString(this.getContext())));
        Log.v((String)TAG, (String)("CHECK: transition.setDuration = " + transition.getDuration()));
        if (transition.getStartConstraintSetId() == transition.getEndConstraintSetId()) {
            Log.e((String)TAG, (String)"CHECK: start and end constraint set should not be the same!");
        }
    }

    private void computeCurrentPositions() {
        int n = this.getChildCount();
        for (int i = 0; i < n; ++i) {
            View view = this.getChildAt(i);
            MotionController motionController = this.mFrameArrayList.get(view);
            if (motionController == null) continue;
            motionController.setStartCurrentState(view);
        }
    }

    private void debugPos() {
        for (int i = 0; i < this.getChildCount(); ++i) {
            View view = this.getChildAt(i);
            Log.v((String)TAG, (String)(" " + Debug.getLocation() + " " + Debug.getName((View)this) + " " + Debug.getName(this.getContext(), this.mCurrentState) + " " + Debug.getName(view) + view.getLeft() + " " + view.getTop()));
        }
    }

    private void evaluateLayout() {
        int n;
        float f;
        int n2;
        long l;
        block17: {
            block16: {
                float f2;
                float f3;
                block15: {
                    block14: {
                        f3 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
                        l = this.getNanoTime();
                        f2 = 0.0f;
                        if (!(this.mInterpolator instanceof StopLogic)) {
                            f2 = (float)(l - this.mTransitionLastTime) * f3 * 1.0E-9f / this.mTransitionDuration;
                        }
                        f2 = this.mTransitionLastPosition + f2;
                        n2 = 0;
                        if (this.mTransitionInstantly) {
                            f2 = this.mTransitionGoalPosition;
                        }
                        if (f3 > 0.0f && f2 >= this.mTransitionGoalPosition) break block14;
                        f = f2;
                        n = n2;
                        if (!(f3 <= 0.0f)) break block15;
                        f = f2;
                        n = n2;
                        if (!(f2 <= this.mTransitionGoalPosition)) break block15;
                    }
                    f = this.mTransitionGoalPosition;
                    n = 1;
                }
                f2 = f;
                if (this.mInterpolator != null) {
                    f2 = f;
                    if (n == 0) {
                        if (this.mTemporalInterpolator) {
                            f2 = l - this.mAnimationStartTime;
                            f2 = this.mInterpolator.getInterpolation(f2 * 1.0E-9f);
                        } else {
                            f2 = this.mInterpolator.getInterpolation(f);
                        }
                    }
                }
                if (f3 > 0.0f && f2 >= this.mTransitionGoalPosition) break block16;
                f = f2;
                if (!(f3 <= 0.0f)) break block17;
                f = f2;
                if (!(f2 <= this.mTransitionGoalPosition)) break block17;
            }
            f = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = f;
        n2 = this.getChildCount();
        l = this.getNanoTime();
        for (n = 0; n < n2; ++n) {
            View view = this.getChildAt(n);
            MotionController motionController = this.mFrameArrayList.get(view);
            if (motionController == null) continue;
            motionController.interpolate(view, f, l, this.mKeyCache);
        }
        if (this.mMeasureDuringTransition) {
            this.requestLayout();
        }
    }

    private void fireTransitionChange() {
        if ((this.mTransitionListener != null || this.mTransitionListeners != null && !this.mTransitionListeners.isEmpty()) && this.mListenerPosition != this.mTransitionPosition) {
            Iterator<TransitionListener> iterator2;
            if (this.mListenerState != -1) {
                if (this.mTransitionListener != null) {
                    this.mTransitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
                }
                if (this.mTransitionListeners != null) {
                    iterator2 = this.mTransitionListeners.iterator();
                    while (iterator2.hasNext()) {
                        iterator2.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
                    }
                }
                this.mIsAnimating = true;
            }
            this.mListenerState = -1;
            this.mListenerPosition = this.mTransitionPosition;
            if (this.mTransitionListener != null) {
                this.mTransitionListener.onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
            }
            if (this.mTransitionListeners != null) {
                iterator2 = this.mTransitionListeners.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
                }
            }
            this.mIsAnimating = true;
        }
    }

    private void fireTransitionStarted(MotionLayout motionLayout, int n, int n2) {
        if (this.mTransitionListener != null) {
            this.mTransitionListener.onTransitionStarted(this, n, n2);
        }
        if (this.mTransitionListeners != null) {
            Iterator<TransitionListener> iterator2 = this.mTransitionListeners.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().onTransitionStarted(motionLayout, n, n2);
            }
        }
    }

    private boolean handlesTouchEvent(float f, float f2, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup)view;
            int n = viewGroup.getChildCount();
            for (int i = 0; i < n; ++i) {
                View view2 = viewGroup.getChildAt(i);
                if (!this.handlesTouchEvent((float)view.getLeft() + f, (float)view.getTop() + f2, view2, motionEvent)) continue;
                return true;
            }
        }
        this.mBoundsCheck.set((float)view.getLeft() + f, (float)view.getTop() + f2, (float)view.getRight() + f, (float)view.getBottom() + f2);
        return motionEvent.getAction() == 0 ? this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent) : view.onTouchEvent(motionEvent);
    }

    private void init(AttributeSet attributeSet) {
        IS_IN_EDIT_MODE = this.isInEditMode();
        if (attributeSet != null) {
            attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int n = attributeSet.getIndexCount();
            boolean bl = true;
            for (int i = 0; i < n; ++i) {
                boolean bl2;
                int n2;
                int n3 = attributeSet.getIndex(i);
                if (n3 == R.styleable.MotionLayout_layoutDescription) {
                    n2 = attributeSet.getResourceId(n3, -1);
                    this.mScene = new MotionScene(this.getContext(), this, n2);
                    bl2 = bl;
                } else if (n3 == R.styleable.MotionLayout_currentState) {
                    this.mCurrentState = attributeSet.getResourceId(n3, -1);
                    bl2 = bl;
                } else if (n3 == R.styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = attributeSet.getFloat(n3, 0.0f);
                    this.mInTransition = true;
                    bl2 = bl;
                } else if (n3 == R.styleable.MotionLayout_applyMotionScene) {
                    bl2 = attributeSet.getBoolean(n3, bl);
                } else {
                    int n4 = R.styleable.MotionLayout_showPaths;
                    n2 = 0;
                    if (n3 == n4) {
                        bl2 = bl;
                        if (this.mDebugPath == 0) {
                            if (attributeSet.getBoolean(n3, false)) {
                                n2 = 2;
                            }
                            this.mDebugPath = n2;
                            bl2 = bl;
                        }
                    } else {
                        bl2 = bl;
                        if (n3 == R.styleable.MotionLayout_motionDebug) {
                            this.mDebugPath = attributeSet.getInt(n3, 0);
                            bl2 = bl;
                        }
                    }
                }
                bl = bl2;
            }
            attributeSet.recycle();
            if (this.mScene == null) {
                Log.e((String)TAG, (String)"WARNING NO app:layoutDescription tag");
            }
            if (!bl) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            this.checkStructure();
        }
        if (this.mCurrentState == -1 && this.mScene != null) {
            this.mCurrentState = this.mScene.getStartId();
            this.mBeginState = this.mScene.getStartId();
            this.mEndState = this.mScene.getEndId();
        }
    }

    private void onNewStateAttachHandlers() {
        if (this.mScene == null) {
            return;
        }
        if (this.mScene.autoTransition(this, this.mCurrentState)) {
            this.requestLayout();
            return;
        }
        if (this.mCurrentState != -1) {
            this.mScene.addOnClickListeners(this, this.mCurrentState);
        }
        if (this.mScene.supportTouch()) {
            this.mScene.setupTouch();
        }
    }

    private void processTransitionCompleted() {
        if (this.mTransitionListener == null && (this.mTransitionListeners == null || this.mTransitionListeners.isEmpty())) {
            return;
        }
        this.mIsAnimating = false;
        for (Integer n : this.mTransitionCompleted) {
            if (this.mTransitionListener != null) {
                this.mTransitionListener.onTransitionCompleted(this, n);
            }
            if (this.mTransitionListeners == null) continue;
            Iterator<TransitionListener> iterator2 = this.mTransitionListeners.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().onTransitionCompleted(this, n);
            }
        }
        this.mTransitionCompleted.clear();
    }

    private void setupMotionViews() {
        block11: {
            float f;
            float f2;
            MotionController motionController;
            int n;
            int n2 = this.getChildCount();
            this.mModel.build();
            int n3 = 1;
            this.mInTransition = true;
            int n4 = this.getWidth();
            int n5 = this.getHeight();
            int n6 = this.mScene.gatPathMotionArc();
            if (n6 != -1) {
                for (n = 0; n < n2; ++n) {
                    motionController = this.mFrameArrayList.get(this.getChildAt(n));
                    if (motionController == null) continue;
                    motionController.setPathMotionArc(n6);
                }
            }
            for (n = 0; n < n2; ++n) {
                motionController = this.mFrameArrayList.get(this.getChildAt(n));
                if (motionController == null) continue;
                this.mScene.getKeyFrames(motionController);
                motionController.setup(n4, n5, this.mTransitionDuration, this.getNanoTime());
            }
            float f3 = this.mScene.getStaggered();
            if (f3 == 0.0f) break block11;
            n = (double)f3 < 0.0 ? n3 : 0;
            n5 = 0;
            float f4 = Math.abs(f3);
            float f5 = Float.MAX_VALUE;
            f3 = -3.4028235E38f;
            n4 = 0;
            while (true) {
                n3 = n5;
                if (n4 >= n2) break;
                motionController = this.mFrameArrayList.get(this.getChildAt(n4));
                if (!Float.isNaN(motionController.mMotionStagger)) {
                    n3 = 1;
                    break;
                }
                f2 = motionController.getFinalX();
                f = motionController.getFinalY();
                f = n != 0 ? (f -= f2) : (f += f2);
                f5 = Math.min(f5, f);
                f3 = Math.max(f3, f);
                ++n4;
            }
            if (n3 != 0) {
                f2 = Float.MAX_VALUE;
                f3 = -3.4028235E38f;
                for (n3 = 0; n3 < n2; ++n3) {
                    motionController = this.mFrameArrayList.get(this.getChildAt(n3));
                    f = f2;
                    f5 = f3;
                    if (!Float.isNaN(motionController.mMotionStagger)) {
                        f = Math.min(f2, motionController.mMotionStagger);
                        f5 = Math.max(f3, motionController.mMotionStagger);
                    }
                    f2 = f;
                    f3 = f5;
                }
                for (n3 = 0; n3 < n2; ++n3) {
                    motionController = this.mFrameArrayList.get(this.getChildAt(n3));
                    if (Float.isNaN(motionController.mMotionStagger)) continue;
                    motionController.mStaggerScale = 1.0f / (1.0f - f4);
                    motionController.mStaggerOffset = n != 0 ? f4 - (f3 - motionController.mMotionStagger) / (f3 - f2) * f4 : f4 - (motionController.mMotionStagger - f2) * f4 / (f3 - f2);
                }
            } else {
                for (n3 = 0; n3 < n2; ++n3) {
                    motionController = this.mFrameArrayList.get(this.getChildAt(n3));
                    f = motionController.getFinalX();
                    f2 = motionController.getFinalY();
                    f = n != 0 ? f2 - f : f2 + f;
                    motionController.mStaggerScale = 1.0f / (1.0f - f4);
                    motionController.mStaggerOffset = f4 - (f - f5) * f4 / (f3 - f5);
                }
            }
        }
    }

    private static boolean willJump(float f, float f2, float f3) {
        boolean bl = true;
        boolean bl2 = true;
        if (f > 0.0f) {
            float f4 = f / f3;
            if (!(f2 + (f * f4 - f3 * f4 * f4 / 2.0f) > 1.0f)) {
                bl2 = false;
            }
            return bl2;
        }
        float f5 = -f / f3;
        bl2 = f2 + (f * f5 + f3 * f5 * f5 / 2.0f) < 0.0f ? bl : false;
        return bl2;
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new ArrayList();
        }
        this.mTransitionListeners.add(transitionListener);
    }

    void animateTo(float f) {
        if (this.mScene == null) {
            return;
        }
        if (this.mTransitionLastPosition != this.mTransitionPosition && this.mTransitionInstantly) {
            this.mTransitionLastPosition = this.mTransitionPosition;
        }
        if (this.mTransitionLastPosition == f) {
            return;
        }
        this.mTemporalInterpolator = false;
        float f2 = this.mTransitionLastPosition;
        this.mTransitionGoalPosition = f;
        this.mTransitionDuration = (float)this.mScene.getDuration() / 1000.0f;
        this.setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = this.getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f2;
        this.mTransitionLastPosition = f2;
        this.invalidate();
    }

    void disableAutoTransition(boolean bl) {
        if (this.mScene == null) {
            return;
        }
        this.mScene.disableAutoTransition(bl);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        this.evaluate(false);
        super.dispatchDraw(canvas);
        if (this.mScene == null) {
            return;
        }
        if ((this.mDebugPath & 1) == 1 && !this.isInEditMode()) {
            ++this.mFrames;
            long l = this.getNanoTime();
            if (this.mLastDrawTime != -1L) {
                long l2 = l - this.mLastDrawTime;
                if (l2 > 200000000L) {
                    this.mLastFps = (float)((int)((float)this.mFrames / ((float)l2 * 1.0E-9f) * 100.0f)) / 100.0f;
                    this.mFrames = 0;
                    this.mLastDrawTime = l;
                }
            } else {
                this.mLastDrawTime = l;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            float f = (float)((int)(this.getProgress() * 1000.0f)) / 10.0f;
            String string2 = this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ";
            StringBuilder stringBuilder = new StringBuilder().append(string2).append(Debug.getState(this, this.mEndState)).append(" (progress: ").append(f).append(" ) state=");
            string2 = this.mCurrentState == -1 ? "undefined" : Debug.getState(this, this.mCurrentState);
            string2 = stringBuilder.append(string2).toString();
            paint.setColor(-16777216);
            canvas.drawText(string2, 11.0f, (float)(this.getHeight() - 29), paint);
            paint.setColor(-7864184);
            canvas.drawText(string2, 10.0f, (float)(this.getHeight() - 30), paint);
        }
        if (this.mDebugPath > 1) {
            if (this.mDevModeDraw == null) {
                this.mDevModeDraw = new DevModeDraw(this);
            }
            this.mDevModeDraw.draw(canvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
        }
    }

    public void enableTransition(int n, boolean bl) {
        MotionScene.Transition transition = this.getTransition(n);
        if (bl) {
            transition.setEnable(true);
            return;
        }
        if (transition == this.mScene.mCurrentTransition) {
            for (MotionScene.Transition transition2 : this.mScene.getTransitionsWithState(this.mCurrentState)) {
                if (!transition2.isEnabled()) continue;
                this.mScene.mCurrentTransition = transition2;
                break;
            }
        }
        transition.setEnable(false);
    }

    void evaluate(boolean bl) {
        int n;
        int n2;
        block46: {
            block51: {
                float f;
                long l;
                float f2;
                int n3;
                block50: {
                    block49: {
                        float f3;
                        float f4;
                        block48: {
                            block47: {
                                block45: {
                                    if (this.mTransitionLastTime == -1L) {
                                        this.mTransitionLastTime = this.getNanoTime();
                                    }
                                    if (this.mTransitionLastPosition > 0.0f && this.mTransitionLastPosition < 1.0f) {
                                        this.mCurrentState = -1;
                                    }
                                    n3 = 0;
                                    n2 = 0;
                                    if (this.mKeepAnimating) break block45;
                                    n = n3;
                                    if (!this.mInTransition) break block46;
                                    if (bl) break block45;
                                    n = n3;
                                    if (this.mTransitionGoalPosition == this.mTransitionLastPosition) break block46;
                                }
                                f2 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
                                l = this.getNanoTime();
                                f4 = 0.0f;
                                if (!(this.mInterpolator instanceof MotionInterpolator)) {
                                    this.mLastVelocity = f4 = (float)(l - this.mTransitionLastTime) * f2 * 1.0E-9f / this.mTransitionDuration;
                                }
                                f3 = this.mTransitionLastPosition + f4;
                                n3 = 0;
                                if (this.mTransitionInstantly) {
                                    f3 = this.mTransitionGoalPosition;
                                }
                                if (f2 > 0.0f && f3 >= this.mTransitionGoalPosition) break block47;
                                f = f3;
                                n = n3;
                                if (!(f2 <= 0.0f)) break block48;
                                f = f3;
                                n = n3;
                                if (!(f3 <= this.mTransitionGoalPosition)) break block48;
                            }
                            f = this.mTransitionGoalPosition;
                            this.mInTransition = false;
                            n = 1;
                        }
                        this.mTransitionLastPosition = f;
                        this.mTransitionPosition = f;
                        this.mTransitionLastTime = l;
                        f3 = f;
                        if (this.mInterpolator != null) {
                            f3 = f;
                            if (n == 0) {
                                if (this.mTemporalInterpolator) {
                                    f3 = l - this.mAnimationStartTime;
                                    this.mTransitionLastPosition = f = this.mInterpolator.getInterpolation(f3 * 1.0E-9f);
                                    this.mTransitionLastTime = l;
                                    if (this.mInterpolator instanceof MotionInterpolator) {
                                        this.mLastVelocity = f4 = ((MotionInterpolator)this.mInterpolator).getVelocity();
                                        if (Math.abs(f4) * this.mTransitionDuration <= 1.0E-5f) {
                                            this.mInTransition = false;
                                        }
                                        f3 = f;
                                        if (f4 > 0.0f) {
                                            f3 = f;
                                            if (f >= 1.0f) {
                                                f3 = 1.0f;
                                                this.mTransitionLastPosition = 1.0f;
                                                this.mInTransition = false;
                                            }
                                        }
                                        if (f4 < 0.0f && f3 <= 0.0f) {
                                            this.mTransitionLastPosition = 0.0f;
                                            this.mInTransition = false;
                                            f3 = 0.0f;
                                        }
                                    } else {
                                        f3 = f;
                                    }
                                } else {
                                    f3 = this.mInterpolator.getInterpolation(f);
                                    this.mLastVelocity = this.mInterpolator instanceof MotionInterpolator ? ((MotionInterpolator)this.mInterpolator).getVelocity() : (this.mInterpolator.getInterpolation(f + f4) - f3) * f2 / f4;
                                }
                            }
                        }
                        if (Math.abs(this.mLastVelocity) > 1.0E-5f) {
                            this.setState(TransitionState.MOVING);
                        }
                        if (f2 > 0.0f && f3 >= this.mTransitionGoalPosition) break block49;
                        f = f3;
                        if (!(f2 <= 0.0f)) break block50;
                        f = f3;
                        if (!(f3 <= this.mTransitionGoalPosition)) break block50;
                    }
                    f = this.mTransitionGoalPosition;
                    this.mInTransition = false;
                }
                if (f >= 1.0f || f <= 0.0f) {
                    this.mInTransition = false;
                    this.setState(TransitionState.FINISHED);
                }
                n3 = this.getChildCount();
                this.mKeepAnimating = false;
                l = this.getNanoTime();
                this.mPostInterpolationPosition = f;
                for (n = 0; n < n3; ++n) {
                    View view = this.getChildAt(n);
                    MotionController motionController = this.mFrameArrayList.get(view);
                    if (motionController == null) continue;
                    bl = this.mKeepAnimating;
                    this.mKeepAnimating = motionController.interpolate(view, f, l, this.mKeyCache) | bl;
                }
                n = f2 > 0.0f && f >= this.mTransitionGoalPosition || f2 <= 0.0f && f <= this.mTransitionGoalPosition ? 1 : 0;
                if (!this.mKeepAnimating && !this.mInTransition && n != 0) {
                    this.setState(TransitionState.FINISHED);
                }
                if (this.mMeasureDuringTransition) {
                    this.requestLayout();
                }
                bl = this.mKeepAnimating;
                n = n == 0 ? 1 : 0;
                this.mKeepAnimating = bl | n;
                n = n2;
                if (f <= 0.0f) {
                    n = n2;
                    if (this.mBeginState != -1) {
                        n = n2;
                        if (this.mCurrentState != this.mBeginState) {
                            n = 1;
                            this.mCurrentState = this.mBeginState;
                            this.mScene.getConstraintSet(this.mBeginState).applyCustomAttributes(this);
                            this.setState(TransitionState.FINISHED);
                        }
                    }
                }
                n2 = n;
                if ((double)f >= 1.0) {
                    n2 = n;
                    if (this.mCurrentState != this.mEndState) {
                        n2 = 1;
                        this.mCurrentState = this.mEndState;
                        this.mScene.getConstraintSet(this.mEndState).applyCustomAttributes(this);
                        this.setState(TransitionState.FINISHED);
                    }
                }
                if (!this.mKeepAnimating && !this.mInTransition) {
                    if (f2 > 0.0f && f == 1.0f || f2 < 0.0f && f == 0.0f) {
                        this.setState(TransitionState.FINISHED);
                    }
                } else {
                    this.invalidate();
                }
                if (!this.mKeepAnimating && this.mInTransition && f2 > 0.0f && f == 1.0f) break block51;
                n = n2;
                if (!(f2 < 0.0f)) break block46;
                n = n2;
                if (f != 0.0f) break block46;
            }
            this.onNewStateAttachHandlers();
            n = n2;
        }
        if (this.mTransitionLastPosition >= 1.0f) {
            if (this.mCurrentState != this.mEndState) {
                n = 1;
            }
            this.mCurrentState = this.mEndState;
            n2 = n;
        } else {
            n2 = n;
            if (this.mTransitionLastPosition <= 0.0f) {
                if (this.mCurrentState != this.mBeginState) {
                    n = 1;
                }
                this.mCurrentState = this.mBeginState;
                n2 = n;
            }
        }
        this.mNeedsFireTransitionCompleted |= n2;
        if (n2 != 0 && !this.mInLayout) {
            this.requestLayout();
        }
        this.mTransitionPosition = this.mTransitionLastPosition;
    }

    protected void fireTransitionCompleted() {
        if ((this.mTransitionListener != null || this.mTransitionListeners != null && !this.mTransitionListeners.isEmpty()) && this.mListenerState == -1) {
            this.mListenerState = this.mCurrentState;
            int n = -1;
            if (!this.mTransitionCompleted.isEmpty()) {
                n = this.mTransitionCompleted.get(this.mTransitionCompleted.size() - 1);
            }
            if (n != this.mCurrentState && this.mCurrentState != -1) {
                this.mTransitionCompleted.add(this.mCurrentState);
            }
        }
        this.processTransitionCompleted();
    }

    public void fireTrigger(int n, boolean bl, float f) {
        if (this.mTransitionListener != null) {
            this.mTransitionListener.onTransitionTrigger(this, n, bl, f);
        }
        if (this.mTransitionListeners != null) {
            Iterator<TransitionListener> iterator2 = this.mTransitionListeners.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().onTransitionTrigger(this, n, bl, f);
            }
        }
    }

    void getAnchorDpDt(int n, float f, float f2, float f3, float[] object) {
        Object object2 = this.mFrameArrayList;
        View view = this.getViewById(n);
        if ((object2 = ((HashMap)object2).get(view)) != null) {
            ((MotionController)object2).getDpDt(f, f2, f3, (float[])object);
            f2 = view.getY();
            f3 = f - this.lastPos;
            float f4 = this.lastY;
            if (f3 != 0.0f) {
                f3 = (f2 - f4) / f3;
            }
            this.lastPos = f;
            this.lastY = f2;
        } else {
            object = view == null ? (Object)("" + n) : (Object)view.getContext().getResources().getResourceName(n);
            Log.w((String)TAG, (String)("WARNING could not find view id " + (String)object));
        }
    }

    public ConstraintSet getConstraintSet(int n) {
        if (this.mScene == null) {
            return null;
        }
        return this.mScene.getConstraintSet(n);
    }

    public int[] getConstraintSetIds() {
        if (this.mScene == null) {
            return null;
        }
        return this.mScene.getConstraintSetIds();
    }

    String getConstraintSetNames(int n) {
        if (this.mScene == null) {
            return null;
        }
        return this.mScene.lookUpConstraintName(n);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public void getDebugMode(boolean bl) {
        int n = bl ? 2 : 1;
        this.mDebugPath = n;
        this.invalidate();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        if (this.mScene == null) {
            return null;
        }
        return this.mScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene.Transition getTransition(int n) {
        return this.mScene.getTransitionById(n);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache(this);
        }
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        if (this.mScene != null) {
            this.mTransitionDuration = (float)this.mScene.getDuration() / 1000.0f;
        }
        return (long)(this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f, float f2, float[] fArray, int n) {
        float f3 = this.mLastVelocity;
        float f4 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            f3 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
            float f5 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + 1.0E-5f);
            f4 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            f3 = f3 * ((f5 - f4) / 1.0E-5f) / this.mTransitionDuration;
        }
        if (this.mInterpolator instanceof MotionInterpolator) {
            f3 = ((MotionInterpolator)this.mInterpolator).getVelocity();
        }
        MotionController motionController = this.mFrameArrayList.get(view);
        if ((n & 1) == 0) {
            motionController.getPostLayoutDvDp(f4, view.getWidth(), view.getHeight(), f, f2, fArray);
        } else {
            motionController.getDpDt(f4, f, f2, fArray);
        }
        if (n < 2) {
            fArray[0] = fArray[0] * f3;
            fArray[1] = fArray[1] * f3;
        }
    }

    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void loadLayoutDescription(int n) {
        if (n != 0) {
            try {
                MotionScene motionScene;
                this.mScene = motionScene = new MotionScene(this.getContext(), this, n);
                if (!this.isAttachedToWindow()) return;
                this.mScene.readFallback(this);
                this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
                this.rebuildScene();
                this.mScene.setRtl(this.isRtl());
                return;
            }
            catch (Exception exception) {
                throw new IllegalArgumentException("unable to parse MotionScene file", exception);
            }
        } else {
            this.mScene = null;
        }
    }

    int lookUpConstraintId(String string2) {
        if (this.mScene == null) {
            return 0;
        }
        return this.mScene.lookUpConstraintId(string2);
    }

    protected MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mScene != null && this.mCurrentState != -1) {
            ConstraintSet constraintSet = this.mScene.getConstraintSet(this.mCurrentState);
            this.mScene.readFallback(this);
            if (constraintSet != null) {
                constraintSet.applyTo(this);
            }
            this.mBeginState = this.mCurrentState;
        }
        this.onNewStateAttachHandlers();
        if (this.mStateCache != null) {
            this.mStateCache.apply();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mScene != null && this.mInteractionEnabled) {
            TouchResponse touchResponse;
            MotionScene.Transition transition = this.mScene.mCurrentTransition;
            if (transition != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null) {
                if (motionEvent.getAction() == 0 && (transition = touchResponse.getTouchRegion(this, new RectF())) != null && !transition.contains(motionEvent.getX(), motionEvent.getY())) {
                    return false;
                }
                int n = touchResponse.getTouchRegionId();
                if (n != -1) {
                    if (this.mRegionView == null || this.mRegionView.getId() != n) {
                        this.mRegionView = this.findViewById(n);
                    }
                    if (this.mRegionView != null) {
                        this.mBoundsCheck.set((float)this.mRegionView.getLeft(), (float)this.mRegionView.getTop(), (float)this.mRegionView.getRight(), (float)this.mRegionView.getBottom());
                        if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !this.handlesTouchEvent(0.0f, 0.0f, this.mRegionView, motionEvent)) {
                            return this.onTouchEvent(motionEvent);
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override
    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        this.mInLayout = true;
        if (this.mScene == null) {
            super.onLayout(bl, n, n2, n3, n4);
            this.mInLayout = false;
            return;
        }
        n = n3 - n;
        n2 = n4 - n2;
        try {
            if (this.mLastLayoutWidth != n || this.mLastLayoutHeight != n2) {
                this.rebuildScene();
                this.evaluate(true);
            }
            this.mLastLayoutWidth = n;
            this.mLastLayoutHeight = n2;
            this.mOldWidth = n;
            this.mOldHeight = n2;
            return;
        }
        finally {
            this.mInLayout = false;
        }
    }

    @Override
    protected void onMeasure(int n, int n2) {
        int n3;
        int n4;
        block11: {
            int n5;
            int n6;
            block10: {
                if (this.mScene == null) {
                    super.onMeasure(n, n2);
                    return;
                }
                n4 = this.mLastWidthMeasureSpec == n && this.mLastHeightMeasureSpec == n2 ? 0 : 1;
                if (this.mNeedsFireTransitionCompleted) {
                    this.mNeedsFireTransitionCompleted = false;
                    this.onNewStateAttachHandlers();
                    this.processTransitionCompleted();
                    n4 = 1;
                }
                if (this.mDirtyHierarchy) {
                    n4 = 1;
                }
                this.mLastWidthMeasureSpec = n;
                this.mLastHeightMeasureSpec = n2;
                n6 = this.mScene.getStartId();
                n5 = this.mScene.getEndId();
                n3 = 1;
                if (n4 != 0) break block10;
                n4 = n3;
                if (!this.mModel.isNotConfiguredWith(n6, n5)) break block11;
            }
            n4 = n3;
            if (this.mBeginState != -1) {
                super.onMeasure(n, n2);
                this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(n6), this.mScene.getConstraintSet(n5));
                this.mModel.reEvaluateState();
                this.mModel.setMeasuredId(n6, n5);
                n4 = 0;
            }
        }
        if (this.mMeasureDuringTransition || n4 != 0) {
            n2 = this.getPaddingTop();
            n4 = this.getPaddingBottom();
            n = this.getPaddingLeft();
            n3 = this.getPaddingRight();
            n = this.mLayoutWidget.getWidth() + (n + n3);
            n2 = this.mLayoutWidget.getHeight() + (n2 + n4);
            if (this.mWidthMeasureMode == Integer.MIN_VALUE || this.mWidthMeasureMode == 0) {
                n = (int)((float)this.mStartWrapWidth + this.mPostInterpolationPosition * (float)(this.mEndWrapWidth - this.mStartWrapWidth));
                this.requestLayout();
            }
            if (this.mHeightMeasureMode == Integer.MIN_VALUE || this.mHeightMeasureMode == 0) {
                n2 = (int)((float)this.mStartWrapHeight + this.mPostInterpolationPosition * (float)(this.mEndWrapHeight - this.mStartWrapHeight));
                this.requestLayout();
            }
            this.setMeasuredDimension(n, n2);
        }
        this.evaluateLayout();
    }

    @Override
    public boolean onNestedFling(View view, float f, float f2, boolean bl) {
        return false;
    }

    @Override
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override
    public void onNestedPreScroll(View view, int n, int n2, int[] nArray, int n3) {
        if (this.mScene != null && this.mScene.mCurrentTransition != null) {
            float f;
            TouchResponse touchResponse;
            if (!this.mScene.mCurrentTransition.isEnabled()) {
                return;
            }
            MotionScene.Transition transition = this.mScene.mCurrentTransition;
            if (transition != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && (n3 = touchResponse.getTouchRegionId()) != -1 && view.getId() != n3) {
                return;
            }
            if (this.mScene != null && this.mScene.getMoveWhenScrollAtTop() && (this.mTransitionPosition == 1.0f || this.mTransitionPosition == 0.0f) && view.canScrollVertically(-1)) {
                return;
            }
            if (transition.getTouchResponse() != null && (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 1) != 0) {
                f = this.mScene.getProgressDirection(n, n2);
                if (this.mTransitionLastPosition <= 0.0f && f < 0.0f || this.mTransitionLastPosition >= 1.0f && f > 0.0f) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new Runnable(this, view){
                        final MotionLayout this$0;
                        final View val$target;
                        {
                            this.this$0 = motionLayout;
                            this.val$target = view;
                        }

                        @Override
                        public void run() {
                            this.val$target.setNestedScrollingEnabled(true);
                        }
                    });
                    return;
                }
            }
            f = this.mTransitionPosition;
            long l = this.getNanoTime();
            this.mScrollTargetDX = n;
            this.mScrollTargetDY = n2;
            this.mScrollTargetDT = (float)((double)(l - this.mScrollTargetTime) * 1.0E-9);
            this.mScrollTargetTime = l;
            this.mScene.processScrollMove(n, n2);
            if (f != this.mTransitionPosition) {
                nArray[0] = n;
                nArray[1] = n2;
            }
            this.evaluate(false);
            if (nArray[0] != 0 || nArray[1] != 0) {
                this.mUndergoingMotion = true;
            }
            return;
        }
    }

    @Override
    public void onNestedScroll(View view, int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void onNestedScroll(View view, int n, int n2, int n3, int n4, int n5, int[] nArray) {
        if (this.mUndergoingMotion || n != 0 || n2 != 0) {
            nArray[0] = nArray[0] + n3;
            nArray[1] = nArray[1] + n4;
        }
        this.mUndergoingMotion = false;
    }

    @Override
    public void onNestedScrollAccepted(View view, View view2, int n, int n2) {
    }

    public void onRtlPropertiesChanged(int n) {
        if (this.mScene != null) {
            this.mScene.setRtl(this.isRtl());
        }
    }

    @Override
    public boolean onStartNestedScroll(View view, View view2, int n, int n2) {
        return this.mScene != null && this.mScene.mCurrentTransition != null && this.mScene.mCurrentTransition.getTouchResponse() != null && (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) == 0;
        {
        }
    }

    @Override
    public void onStopNestedScroll(View view, int n) {
        if (this.mScene == null) {
            return;
        }
        this.mScene.processScrollUp(this.mScrollTargetDX / this.mScrollTargetDT, this.mScrollTargetDY / this.mScrollTargetDT);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mScene != null && this.mInteractionEnabled && this.mScene.supportTouch()) {
            MotionScene.Transition transition = this.mScene.mCurrentTransition;
            if (transition != null && !transition.isEnabled()) {
                return super.onTouchEvent(motionEvent);
            }
            this.mScene.processTouchEvent(motionEvent, this.getCurrentState(), this);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            view = (MotionHelper)view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new ArrayList();
            }
            this.mTransitionListeners.add((TransitionListener)view);
            if (view.isUsedOnShow()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList();
                }
                this.mOnShowHelpers.add((MotionHelper)view);
            }
            if (view.isUseOnHide()) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new ArrayList();
                }
                this.mOnHideHelpers.add((MotionHelper)view);
            }
        }
    }

    @Override
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (this.mOnShowHelpers != null) {
            this.mOnShowHelpers.remove(view);
        }
        if (this.mOnHideHelpers != null) {
            this.mOnHideHelpers.remove(view);
        }
    }

    @Override
    protected void parseLayoutDescription(int n) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e((String)TAG, (String)"This method is deprecated. Please call rebuildScene() instead.");
        this.rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        this.invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            return false;
        }
        return this.mTransitionListeners.remove(transitionListener);
    }

    @Override
    public void requestLayout() {
        if (!this.mMeasureDuringTransition && this.mCurrentState == -1 && this.mScene != null && this.mScene.mCurrentTransition != null && this.mScene.mCurrentTransition.getLayoutDuringTransition() == 0) {
            return;
        }
        super.requestLayout();
    }

    public void setDebugMode(int n) {
        this.mDebugPath = n;
        this.invalidate();
    }

    public void setInteractionEnabled(boolean bl) {
        this.mInteractionEnabled = bl;
    }

    public void setInterpolatedProgress(float f) {
        if (this.mScene != null) {
            this.setState(TransitionState.MOVING);
            Interpolator interpolator2 = this.mScene.getInterpolator();
            if (interpolator2 != null) {
                this.setProgress(interpolator2.getInterpolation(f));
                return;
            }
        }
        this.setProgress(f);
    }

    public void setOnHide(float f) {
        if (this.mOnHideHelpers != null) {
            int n = this.mOnHideHelpers.size();
            for (int i = 0; i < n; ++i) {
                this.mOnHideHelpers.get(i).setProgress(f);
            }
        }
    }

    public void setOnShow(float f) {
        if (this.mOnShowHelpers != null) {
            int n = this.mOnShowHelpers.size();
            for (int i = 0; i < n; ++i) {
                this.mOnShowHelpers.get(i).setProgress(f);
            }
        }
    }

    public void setProgress(float f) {
        if (!this.isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache(this);
            }
            this.mStateCache.setProgress(f);
            return;
        }
        if (f <= 0.0f) {
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                this.setState(TransitionState.FINISHED);
            }
        } else if (f >= 1.0f) {
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                this.setState(TransitionState.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            this.setState(TransitionState.MOVING);
        }
        if (this.mScene == null) {
            return;
        }
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = f;
        this.mTransitionPosition = f;
        this.mTransitionLastTime = -1L;
        this.mAnimationStartTime = -1L;
        this.mInterpolator = null;
        this.mInTransition = true;
        this.invalidate();
    }

    public void setProgress(float f, float f2) {
        if (!this.isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache(this);
            }
            this.mStateCache.setProgress(f);
            this.mStateCache.setVelocity(f2);
            return;
        }
        this.setProgress(f);
        this.setState(TransitionState.MOVING);
        this.mLastVelocity = f2;
        this.animateTo(1.0f);
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        this.mScene.setRtl(this.isRtl());
        this.rebuildScene();
    }

    @Override
    public void setState(int n, int n2, int n3) {
        this.setState(TransitionState.SETUP);
        this.mCurrentState = n;
        this.mBeginState = -1;
        this.mEndState = -1;
        if (this.mConstraintLayoutSpec != null) {
            this.mConstraintLayoutSpec.updateConstraints(n, n2, n3);
        } else if (this.mScene != null) {
            this.mScene.getConstraintSet(n).applyTo(this);
        }
    }

    void setState(TransitionState transitionState) {
        if (transitionState == TransitionState.FINISHED && this.mCurrentState == -1) {
            return;
        }
        TransitionState transitionState2 = this.mTransitionState;
        this.mTransitionState = transitionState;
        if (transitionState2 == TransitionState.MOVING && transitionState == TransitionState.MOVING) {
            this.fireTransitionChange();
        }
        switch (2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[transitionState2.ordinal()]) {
            default: {
                break;
            }
            case 3: {
                if (transitionState != TransitionState.FINISHED) break;
                this.fireTransitionCompleted();
                break;
            }
            case 1: 
            case 2: {
                if (transitionState == TransitionState.MOVING) {
                    this.fireTransitionChange();
                }
                if (transitionState != TransitionState.FINISHED) break;
                this.fireTransitionCompleted();
            }
        }
    }

    public void setTransition(int n) {
        if (this.mScene != null) {
            MotionScene.Transition transition = this.getTransition(n);
            n = this.mCurrentState;
            this.mBeginState = transition.getStartConstraintSetId();
            this.mEndState = transition.getEndConstraintSetId();
            if (!this.isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache(this);
                }
                this.mStateCache.setStartState(this.mBeginState);
                this.mStateCache.setEndState(this.mEndState);
                return;
            }
            float f = Float.NaN;
            if (this.mCurrentState == this.mBeginState) {
                f = 0.0f;
            } else if (this.mCurrentState == this.mEndState) {
                f = 1.0f;
            }
            this.mScene.setTransition(transition);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            this.rebuildScene();
            float f2 = Float.isNaN(f) ? 0.0f : f;
            this.mTransitionLastPosition = f2;
            if (Float.isNaN(f)) {
                Log.v((String)TAG, (String)(Debug.getLocation() + " transitionToStart "));
                this.transitionToStart();
            } else {
                this.setProgress(f);
            }
        }
    }

    public void setTransition(int n, int n2) {
        if (!this.isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache(this);
            }
            this.mStateCache.setStartState(n);
            this.mStateCache.setEndState(n2);
            return;
        }
        if (this.mScene != null) {
            this.mBeginState = n;
            this.mEndState = n2;
            this.mScene.setTransition(n, n2);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(n), this.mScene.getConstraintSet(n2));
            this.rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            this.transitionToStart();
        }
    }

    protected void setTransition(MotionScene.Transition transition) {
        this.mScene.setTransition(transition);
        this.setState(TransitionState.SETUP);
        if (this.mCurrentState == this.mScene.getEndId()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        long l = transition.isTransitionFlag(1) ? -1L : this.getNanoTime();
        this.mTransitionLastTime = l;
        int n = this.mScene.getStartId();
        int n2 = this.mScene.getEndId();
        if (n == this.mBeginState && n2 == this.mEndState) {
            return;
        }
        this.mBeginState = n;
        this.mEndState = n2;
        this.mScene.setTransition(this.mBeginState, this.mEndState);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        this.rebuildScene();
    }

    public void setTransitionDuration(int n) {
        if (this.mScene == null) {
            Log.e((String)TAG, (String)"MotionScene not defined");
            return;
        }
        this.mScene.setDuration(n);
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache(this);
        }
        this.mStateCache.setTransitionState(bundle);
        if (this.isAttachedToWindow()) {
            this.mStateCache.apply();
        }
    }

    public String toString() {
        Context context = this.getContext();
        return Debug.getName(context, this.mBeginState) + "->" + Debug.getName(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    public void touchAnimateTo(int n, float f, float f2) {
        if (this.mScene == null) {
            return;
        }
        if (this.mTransitionLastPosition == f) {
            return;
        }
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = this.getNanoTime();
        this.mTransitionDuration = (float)this.mScene.getDuration() / 1000.0f;
        this.mTransitionGoalPosition = f;
        this.mInTransition = true;
        switch (n) {
            default: {
                break;
            }
            case 5: {
                if (MotionLayout.willJump(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration())) {
                    this.mDecelerateLogic.config(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
                    this.mInterpolator = this.mDecelerateLogic;
                    break;
                }
                this.mStopLogic.config(this.mTransitionLastPosition, f, f2, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
                this.mLastVelocity = 0.0f;
                n = this.mCurrentState;
                this.mTransitionGoalPosition = f;
                this.mCurrentState = n;
                this.mInterpolator = this.mStopLogic;
                break;
            }
            case 4: {
                this.mDecelerateLogic.config(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
                this.mInterpolator = this.mDecelerateLogic;
                break;
            }
            case 3: {
                break;
            }
            case 0: 
            case 1: 
            case 2: {
                if (n == 1) {
                    f = 0.0f;
                } else if (n == 2) {
                    f = 1.0f;
                }
                this.mStopLogic.config(this.mTransitionLastPosition, f, f2, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
                n = this.mCurrentState;
                this.mTransitionGoalPosition = f;
                this.mCurrentState = n;
                this.mInterpolator = this.mStopLogic;
            }
        }
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = this.getNanoTime();
        this.invalidate();
    }

    public void transitionToEnd() {
        this.animateTo(1.0f);
    }

    public void transitionToStart() {
        this.animateTo(0.0f);
    }

    public void transitionToState(int n) {
        if (!this.isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache(this);
            }
            this.mStateCache.setEndState(n);
            return;
        }
        this.transitionToState(n, -1, -1);
    }

    public void transitionToState(int n, int n2, int n3) {
        MotionController motionController;
        if (this.mScene != null && this.mScene.mStateSet != null && (n2 = this.mScene.mStateSet.convertToConstraintSet(this.mCurrentState, n, n2, n3)) != -1) {
            n = n2;
        }
        if (this.mCurrentState == n) {
            return;
        }
        if (this.mBeginState == n) {
            this.animateTo(0.0f);
            return;
        }
        if (this.mEndState == n) {
            this.animateTo(1.0f);
            return;
        }
        this.mEndState = n;
        if (this.mCurrentState != -1) {
            this.setTransition(this.mCurrentState, n);
            this.animateTo(1.0f);
            this.mTransitionLastPosition = 0.0f;
            this.transitionToEnd();
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = this.getNanoTime();
        this.mAnimationStartTime = this.getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        this.mTransitionDuration = (float)this.mScene.getDuration() / 1000.0f;
        this.mBeginState = -1;
        this.mScene.setTransition(this.mBeginState, this.mEndState);
        this.mScene.getStartId();
        int n4 = this.getChildCount();
        this.mFrameArrayList.clear();
        for (n2 = 0; n2 < n4; ++n2) {
            View view = this.getChildAt(n2);
            motionController = new MotionController(view);
            this.mFrameArrayList.put(view, motionController);
        }
        this.mInTransition = true;
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(n));
        this.rebuildScene();
        this.mModel.build();
        this.computeCurrentPositions();
        n3 = this.getWidth();
        n2 = this.getHeight();
        for (n = 0; n < n4; ++n) {
            motionController = this.mFrameArrayList.get(this.getChildAt(n));
            this.mScene.getKeyFrames(motionController);
            motionController.setup(n3, n2, this.mTransitionDuration, this.getNanoTime());
        }
        float f = this.mScene.getStaggered();
        if (f != 0.0f) {
            float f2;
            float f3;
            float f4 = Float.MAX_VALUE;
            float f5 = -3.4028235E38f;
            for (n = 0; n < n4; ++n) {
                motionController = this.mFrameArrayList.get(this.getChildAt(n));
                f3 = motionController.getFinalX();
                f2 = motionController.getFinalY();
                f4 = Math.min(f4, f2 + f3);
                f5 = Math.max(f5, f2 + f3);
            }
            n = n3;
            for (n2 = 0; n2 < n4; ++n2) {
                motionController = this.mFrameArrayList.get(this.getChildAt(n2));
                f2 = motionController.getFinalX();
                f3 = motionController.getFinalY();
                motionController.mStaggerScale = 1.0f / (1.0f - f);
                motionController.mStaggerOffset = f - (f2 + f3 - f4) * f / (f5 - f4);
            }
        }
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        this.invalidate();
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.rebuildScene();
    }

    public void updateState(int n, ConstraintSet constraintSet) {
        if (this.mScene != null) {
            this.mScene.setConstraintSet(n, constraintSet);
        }
        this.updateState();
        if (this.mCurrentState == n) {
            constraintSet.applyTo(this);
        }
    }

    class DecelerateInterpolator
    extends MotionInterpolator {
        float currentP;
        float initalV;
        float maxA;
        final MotionLayout this$0;

        DecelerateInterpolator(MotionLayout motionLayout) {
            this.this$0 = motionLayout;
            this.initalV = 0.0f;
            this.currentP = 0.0f;
        }

        public void config(float f, float f2, float f3) {
            this.initalV = f;
            this.currentP = f2;
            this.maxA = f3;
        }

        @Override
        public float getInterpolation(float f) {
            if (this.initalV > 0.0f) {
                float f2 = f;
                if (this.initalV / this.maxA < f) {
                    f2 = this.initalV / this.maxA;
                }
                this.this$0.mLastVelocity = this.initalV - this.maxA * f2;
                f = this.initalV;
                float f3 = this.maxA * f2 * f2 / 2.0f;
                return this.currentP + (f * f2 - f3);
            }
            float f4 = f;
            if (-this.initalV / this.maxA < f) {
                f4 = -this.initalV / this.maxA;
            }
            this.this$0.mLastVelocity = this.initalV + this.maxA * f4;
            float f5 = this.initalV;
            f = this.maxA * f4 * f4 / 2.0f;
            return this.currentP + (f5 * f4 + f);
        }

        @Override
        public float getVelocity() {
            return this.this$0.mLastVelocity;
        }
    }

    private class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;
        final int DIAMOND_SIZE;
        final int GRAPH_COLOR;
        final int KEYFRAME_COLOR;
        final int RED_COLOR;
        final int SHADOW_COLOR;
        Rect mBounds;
        DashPathEffect mDashPathEffect;
        Paint mFillPaint;
        int mKeyFrameCount;
        float[] mKeyFramePoints;
        Paint mPaint;
        Paint mPaintGraph;
        Paint mPaintKeyframes;
        Path mPath;
        int[] mPathMode;
        float[] mPoints;
        boolean mPresentationMode;
        private float[] mRectangle;
        int mShadowTranslate;
        Paint mTextPaint;
        final MotionLayout this$0;

        public DevModeDraw(MotionLayout motionLayout) {
            this.this$0 = motionLayout;
            this.RED_COLOR = -21965;
            this.KEYFRAME_COLOR = -2067046;
            this.GRAPH_COLOR = -13391360;
            this.SHADOW_COLOR = 0x77000000;
            this.DIAMOND_SIZE = 10;
            this.mBounds = new Rect();
            this.mPresentationMode = false;
            this.mShadowTranslate = 1;
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaintKeyframes = new Paint();
            this.mPaintKeyframes.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(Paint.Style.STROKE);
            this.mPaintGraph = new Paint();
            this.mPaintGraph.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(Paint.Style.STROKE);
            this.mTextPaint = new Paint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(motionLayout.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            this.mFillPaint = new Paint();
            this.mFillPaint.setAntiAlias(true);
            this.mDashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mPaintGraph.setPathEffect((PathEffect)this.mDashPathEffect);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode) {
                this.mPaint.setStrokeWidth(8.0f);
                this.mFillPaint.setStrokeWidth(8.0f);
                this.mPaintKeyframes.setStrokeWidth(8.0f);
                this.mShadowTranslate = 4;
            }
        }

        private void drawBasicPath(Canvas canvas) {
            canvas.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathAsConfigured(Canvas canvas) {
            boolean bl = false;
            boolean bl2 = false;
            for (int i = 0; i < this.mKeyFrameCount; ++i) {
                if (this.mPathMode[i] == 1) {
                    bl = true;
                }
                if (this.mPathMode[i] != 2) continue;
                bl2 = true;
            }
            if (bl) {
                this.drawPathRelative(canvas);
            }
            if (bl2) {
                this.drawPathCartesian(canvas);
            }
        }

        private void drawPathCartesian(Canvas canvas) {
            float f = this.mPoints[0];
            float f2 = this.mPoints[1];
            float f3 = this.mPoints[this.mPoints.length - 2];
            float f4 = this.mPoints[this.mPoints.length - 1];
            canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.mPaintGraph);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(Canvas canvas, float f, float f2) {
            float f3 = this.mPoints[0];
            float f4 = this.mPoints[1];
            float f5 = this.mPoints[this.mPoints.length - 2];
            float f6 = this.mPoints[this.mPoints.length - 1];
            float f7 = Math.min(f3, f5);
            float f8 = Math.max(f4, f6);
            float f9 = f - Math.min(f3, f5);
            float f10 = Math.max(f4, f6) - f2;
            String string2 = "" + (float)((int)((double)(f9 * 100.0f / Math.abs(f5 - f3)) + 0.5)) / 100.0f;
            this.getTextBounds(string2, this.mTextPaint);
            canvas.drawText(string2, f9 / 2.0f - (float)(this.mBounds.width() / 2) + f7, f2 - 20.0f, this.mTextPaint);
            canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.mPaintGraph);
            string2 = "" + (float)((int)((double)(f10 * 100.0f / Math.abs(f6 - f4)) + 0.5)) / 100.0f;
            this.getTextBounds(string2, this.mTextPaint);
            canvas.drawText(string2, f + 5.0f, f8 - (f10 / 2.0f - (float)(this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), this.mPaintGraph);
        }

        private void drawPathRelative(Canvas canvas) {
            canvas.drawLine(this.mPoints[0], this.mPoints[1], this.mPoints[this.mPoints.length - 2], this.mPoints[this.mPoints.length - 1], this.mPaintGraph);
        }

        private void drawPathRelativeTicks(Canvas canvas, float f, float f2) {
            float f3 = this.mPoints[0];
            float f4 = this.mPoints[1];
            float f5 = this.mPoints[this.mPoints.length - 2];
            float f6 = this.mPoints[this.mPoints.length - 1];
            float f7 = (float)Math.hypot(f3 - f5, f4 - f6);
            float f8 = ((f - f3) * (f5 - f3) + (f2 - f4) * (f6 - f4)) / (f7 * f7);
            f3 += (f5 - f3) * f8;
            f6 = f4 + (f6 - f4) * f8;
            Path path2 = new Path();
            path2.moveTo(f, f2);
            path2.lineTo(f3, f6);
            f4 = (float)Math.hypot(f3 - f, f6 - f2);
            String string2 = "" + (float)((int)(f4 * 100.0f / f7)) / 100.0f;
            this.getTextBounds(string2, this.mTextPaint);
            canvas.drawTextOnPath(string2, path2, f4 / 2.0f - (float)(this.mBounds.width() / 2), -20.0f, this.mTextPaint);
            canvas.drawLine(f, f2, f3, f6, this.mPaintGraph);
        }

        private void drawPathScreenTicks(Canvas canvas, float f, float f2, int n, int n2) {
            String string2 = "" + (float)((int)((double)((f - (float)(n / 2)) * 100.0f / (float)(this.this$0.getWidth() - n)) + 0.5)) / 100.0f;
            this.getTextBounds(string2, this.mTextPaint);
            canvas.drawText(string2, f / 2.0f - (float)(this.mBounds.width() / 2) + 0.0f, f2 - 20.0f, this.mTextPaint);
            canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.mPaintGraph);
            string2 = "" + (float)((int)((double)((f2 - (float)(n2 / 2)) * 100.0f / (float)(this.this$0.getHeight() - n2)) + 0.5)) / 100.0f;
            this.getTextBounds(string2, this.mTextPaint);
            canvas.drawText(string2, f + 5.0f, 0.0f - (f2 / 2.0f - (float)(this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawRectangle(Canvas canvas, MotionController motionController) {
            this.mPath.reset();
            for (int i = 0; i <= 50; ++i) {
                motionController.buildRect((float)i / (float)50, this.mRectangle, 0);
                this.mPath.moveTo(this.mRectangle[0], this.mRectangle[1]);
                this.mPath.lineTo(this.mRectangle[2], this.mRectangle[3]);
                this.mPath.lineTo(this.mRectangle[4], this.mRectangle[5]);
                this.mPath.lineTo(this.mRectangle[6], this.mRectangle[7]);
                this.mPath.close();
            }
            this.mPaint.setColor(0x44000000);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.mPath, this.mPaint);
            canvas.translate(-2.0f, -2.0f);
            this.mPaint.setColor(-65536);
            canvas.drawPath(this.mPath, this.mPaint);
        }

        private void drawTicks(Canvas canvas, int n, int n2, MotionController motionController) {
            int n3;
            int n4;
            if (motionController.mView != null) {
                n4 = motionController.mView.getWidth();
                n3 = motionController.mView.getHeight();
            } else {
                n4 = 0;
                n3 = 0;
            }
            for (int i = 1; i < n2 - 1; ++i) {
                if (n == 4 && this.mPathMode[i - 1] == 0) continue;
                float f = this.mKeyFramePoints[i * 2];
                float f2 = this.mKeyFramePoints[i * 2 + 1];
                this.mPath.reset();
                this.mPath.moveTo(f, f2 + 10.0f);
                this.mPath.lineTo(f + 10.0f, f2);
                this.mPath.lineTo(f, f2 - 10.0f);
                this.mPath.lineTo(f - 10.0f, f2);
                this.mPath.close();
                motionController.getKeyFrame(i - 1);
                if (n == 4) {
                    if (this.mPathMode[i - 1] == 1) {
                        this.drawPathRelativeTicks(canvas, f - 0.0f, f2 - 0.0f);
                    } else if (this.mPathMode[i - 1] == 2) {
                        this.drawPathCartesianTicks(canvas, f - 0.0f, f2 - 0.0f);
                    } else if (this.mPathMode[i - 1] == 3) {
                        this.drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, n4, n3);
                    }
                    canvas.drawPath(this.mPath, this.mFillPaint);
                }
                if (n == 2) {
                    this.drawPathRelativeTicks(canvas, f - 0.0f, f2 - 0.0f);
                }
                if (n == 3) {
                    this.drawPathCartesianTicks(canvas, f - 0.0f, f2 - 0.0f);
                }
                if (n == 6) {
                    this.drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, n4, n3);
                }
                if (0.0f == 0.0f && 0.0f == 0.0f) {
                    canvas.drawPath(this.mPath, this.mFillPaint);
                    continue;
                }
                this.drawTranslation(canvas, f - 0.0f, f2 - 0.0f, f, f2);
            }
            if (this.mPoints.length > 1) {
                canvas.drawCircle(this.mPoints[0], this.mPoints[1], 8.0f, this.mPaintKeyframes);
                canvas.drawCircle(this.mPoints[this.mPoints.length - 2], this.mPoints[this.mPoints.length - 1], 8.0f, this.mPaintKeyframes);
            }
        }

        private void drawTranslation(Canvas canvas, float f, float f2, float f3, float f4) {
            canvas.drawRect(f, f2, f3, f4, this.mPaintGraph);
            canvas.drawLine(f, f2, f3, f4, this.mPaintGraph);
        }

        /*
         * WARNING - void declaration
         */
        public void draw(Canvas canvas, HashMap<View, MotionController> object2, int n, int n2) {
            if (object2 != null && ((HashMap)object2).size() != 0) {
                void var4_6;
                canvas.save();
                if (!this.this$0.isInEditMode() && (var4_6 & 1) == 2) {
                    String string2 = this.this$0.getContext().getResources().getResourceName(this.this$0.mEndState) + ":" + this.this$0.getProgress();
                    canvas.drawText(string2, 10.0f, (float)(this.this$0.getHeight() - 30), this.mTextPaint);
                    canvas.drawText(string2, 11.0f, (float)(this.this$0.getHeight() - 29), this.mPaint);
                }
                for (MotionController motionController : ((HashMap)object2).values()) {
                    void var3_5;
                    int n3;
                    int n4 = n3 = motionController.getDrawPath();
                    if (var4_6 > 0) {
                        n4 = n3;
                        if (n3 == 0) {
                            n4 = 1;
                        }
                    }
                    if (n4 == 0) continue;
                    this.mKeyFrameCount = motionController.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
                    if (n4 < 1) continue;
                    n3 = var3_5 / 16;
                    if (this.mPoints == null || this.mPoints.length != n3 * 2) {
                        this.mPoints = new float[n3 * 2];
                        this.mPath = new Path();
                    }
                    canvas.translate((float)this.mShadowTranslate, (float)this.mShadowTranslate);
                    this.mPaint.setColor(0x77000000);
                    this.mFillPaint.setColor(0x77000000);
                    this.mPaintKeyframes.setColor(0x77000000);
                    this.mPaintGraph.setColor(0x77000000);
                    motionController.buildPath(this.mPoints, n3);
                    this.drawAll(canvas, n4, this.mKeyFrameCount, motionController);
                    this.mPaint.setColor(-21965);
                    this.mPaintKeyframes.setColor(-2067046);
                    this.mFillPaint.setColor(-2067046);
                    this.mPaintGraph.setColor(-13391360);
                    canvas.translate((float)(-this.mShadowTranslate), (float)(-this.mShadowTranslate));
                    this.drawAll(canvas, n4, this.mKeyFrameCount, motionController);
                    if (n4 != 5) continue;
                    this.drawRectangle(canvas, motionController);
                }
                canvas.restore();
                return;
            }
        }

        public void drawAll(Canvas canvas, int n, int n2, MotionController motionController) {
            if (n == 4) {
                this.drawPathAsConfigured(canvas);
            }
            if (n == 2) {
                this.drawPathRelative(canvas);
            }
            if (n == 3) {
                this.drawPathCartesian(canvas);
            }
            this.drawBasicPath(canvas);
            this.drawTicks(canvas, n, n2, motionController);
        }

        void getTextBounds(String string2, Paint paint) {
            paint.getTextBounds(string2, 0, string2.length(), this.mBounds);
        }
    }

    class Model {
        ConstraintSet mEnd;
        int mEndId;
        ConstraintWidgetContainer mLayoutEnd;
        ConstraintWidgetContainer mLayoutStart;
        ConstraintSet mStart;
        int mStartId;
        final MotionLayout this$0;

        Model(MotionLayout motionLayout) {
            this.this$0 = motionLayout;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mStart = null;
            this.mEnd = null;
        }

        private void debugLayout(String object, ConstraintWidgetContainer constraintWidgetContainer) {
            Object object2 = (View)constraintWidgetContainer.getCompanionWidget();
            String string2 = (String)object + " " + Debug.getName(object2);
            Log.v((String)MotionLayout.TAG, (String)(string2 + "  ========= " + constraintWidgetContainer));
            int n = constraintWidgetContainer.getChildren().size();
            for (int i = 0; i < n; ++i) {
                String string3 = string2 + "[" + i + "] ";
                ConstraintWidget constraintWidget = constraintWidgetContainer.getChildren().get(i);
                CharSequence charSequence = new StringBuilder().append("");
                object = constraintWidget.mTop.mTarget;
                object2 = "_";
                object = object != null ? "T" : "_";
                object = charSequence.append((String)object).toString();
                charSequence = new StringBuilder().append((String)object);
                object = constraintWidget.mBottom.mTarget != null ? "B" : "_";
                object = charSequence.append((String)object).toString();
                charSequence = new StringBuilder().append((String)object);
                object = constraintWidget.mLeft.mTarget != null ? "L" : "_";
                object = charSequence.append((String)object).toString();
                charSequence = new StringBuilder().append((String)object);
                object = object2;
                if (constraintWidget.mRight.mTarget != null) {
                    object = "R";
                }
                charSequence = charSequence.append((String)object).toString();
                View view = (View)constraintWidget.getCompanionWidget();
                object2 = Debug.getName(view);
                object = object2;
                if (view instanceof TextView) {
                    object = (String)object2 + "(" + ((TextView)view).getText() + ")";
                }
                Log.v((String)MotionLayout.TAG, (String)(string3 + "  " + (String)object + " " + constraintWidget + " " + (String)charSequence));
            }
            Log.v((String)MotionLayout.TAG, (String)(string2 + " done. "));
        }

        private void debugLayoutParam(String string2, ConstraintLayout.LayoutParams object) {
            CharSequence charSequence = new StringBuilder().append(" ");
            CharSequence charSequence2 = object.startToStart != -1 ? "SS" : "__";
            charSequence2 = charSequence.append((String)charSequence2).toString();
            StringBuilder stringBuilder = new StringBuilder().append((String)charSequence2);
            int n = object.startToEnd;
            charSequence = "|__";
            charSequence2 = n != -1 ? "|SE" : "|__";
            charSequence2 = stringBuilder.append((String)charSequence2).toString();
            stringBuilder = new StringBuilder().append((String)charSequence2);
            charSequence2 = object.endToStart != -1 ? "|ES" : "|__";
            charSequence2 = stringBuilder.append((String)charSequence2).toString();
            stringBuilder = new StringBuilder().append((String)charSequence2);
            charSequence2 = object.endToEnd != -1 ? "|EE" : "|__";
            charSequence2 = stringBuilder.append((String)charSequence2).toString();
            stringBuilder = new StringBuilder().append((String)charSequence2);
            charSequence2 = object.leftToLeft != -1 ? "|LL" : "|__";
            charSequence2 = stringBuilder.append((String)charSequence2).toString();
            stringBuilder = new StringBuilder().append((String)charSequence2);
            charSequence2 = object.leftToRight != -1 ? "|LR" : "|__";
            charSequence2 = stringBuilder.append((String)charSequence2).toString();
            stringBuilder = new StringBuilder().append((String)charSequence2);
            charSequence2 = object.rightToLeft != -1 ? "|RL" : "|__";
            charSequence2 = stringBuilder.append((String)charSequence2).toString();
            stringBuilder = new StringBuilder().append((String)charSequence2);
            charSequence2 = object.rightToRight != -1 ? "|RR" : "|__";
            charSequence2 = stringBuilder.append((String)charSequence2).toString();
            stringBuilder = new StringBuilder().append((String)charSequence2);
            charSequence2 = object.topToTop != -1 ? "|TT" : "|__";
            charSequence2 = stringBuilder.append((String)charSequence2).toString();
            stringBuilder = new StringBuilder().append((String)charSequence2);
            charSequence2 = object.topToBottom != -1 ? "|TB" : "|__";
            charSequence2 = stringBuilder.append((String)charSequence2).toString();
            stringBuilder = new StringBuilder().append((String)charSequence2);
            charSequence2 = object.bottomToTop != -1 ? "|BT" : "|__";
            charSequence2 = stringBuilder.append((String)charSequence2).toString();
            stringBuilder = new StringBuilder().append((String)charSequence2);
            charSequence2 = charSequence;
            if (object.bottomToBottom != -1) {
                charSequence2 = "|BB";
            }
            object = stringBuilder.append((String)charSequence2).toString();
            Log.v((String)MotionLayout.TAG, (String)(string2 + (String)object));
        }

        private void debugWidget(String string2, ConstraintWidget constraintWidget) {
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2 = new StringBuilder().append(" ");
            Object object = constraintWidget.mTop.mTarget;
            String string3 = "B";
            CharSequence charSequence = "__";
            if (object != null) {
                stringBuilder = new StringBuilder().append("T");
                object = constraintWidget.mTop.mTarget.mType == ConstraintAnchor.Type.TOP ? "T" : "B";
                object = stringBuilder.append((String)object).toString();
            } else {
                object = "__";
            }
            object = stringBuilder2.append((String)object).toString();
            stringBuilder2 = new StringBuilder().append((String)object);
            if (constraintWidget.mBottom.mTarget != null) {
                stringBuilder = new StringBuilder().append("B");
                object = string3;
                if (constraintWidget.mBottom.mTarget.mType == ConstraintAnchor.Type.TOP) {
                    object = "T";
                }
                object = stringBuilder.append((String)object).toString();
            } else {
                object = "__";
            }
            object = stringBuilder2.append((String)object).toString();
            stringBuilder2 = new StringBuilder().append((String)object);
            object = constraintWidget.mLeft.mTarget;
            string3 = "R";
            if (object != null) {
                stringBuilder = new StringBuilder().append("L");
                object = constraintWidget.mLeft.mTarget.mType == ConstraintAnchor.Type.LEFT ? "L" : "R";
                object = stringBuilder.append((String)object).toString();
            } else {
                object = "__";
            }
            object = stringBuilder2.append((String)object).toString();
            stringBuilder2 = new StringBuilder().append((String)object);
            object = charSequence;
            if (constraintWidget.mRight.mTarget != null) {
                charSequence = new StringBuilder().append("R");
                object = string3;
                if (constraintWidget.mRight.mTarget.mType == ConstraintAnchor.Type.LEFT) {
                    object = "L";
                }
                object = ((StringBuilder)charSequence).append((String)object).toString();
            }
            object = stringBuilder2.append((String)object).toString();
            Log.v((String)MotionLayout.TAG, (String)(string2 + (String)object + " ---  " + constraintWidget));
        }

        private void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet object) {
            SparseArray sparseArray = new SparseArray();
            Object object2 = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, (Object)constraintWidgetContainer);
            sparseArray.put(this.this$0.getId(), (Object)constraintWidgetContainer);
            for (ConstraintWidget constraintWidget : constraintWidgetContainer.getChildren()) {
                sparseArray.put(((View)constraintWidget.getCompanionWidget()).getId(), (Object)constraintWidget);
            }
            for (ConstraintWidget constraintWidget : constraintWidgetContainer.getChildren()) {
                View view = (View)constraintWidget.getCompanionWidget();
                ((ConstraintSet)((Object)object)).applyToLayoutParams(view.getId(), (ConstraintLayout.LayoutParams)((Object)object2));
                constraintWidget.setWidth(((ConstraintSet)((Object)object)).getWidth(view.getId()));
                constraintWidget.setHeight(((ConstraintSet)((Object)object)).getHeight(view.getId()));
                if (view instanceof ConstraintHelper) {
                    ((ConstraintSet)((Object)object)).applyToHelper((ConstraintHelper)view, constraintWidget, (ConstraintLayout.LayoutParams)((Object)object2), (SparseArray<ConstraintWidget>)sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier)view).validateParams();
                    }
                }
                ((ConstraintLayout.LayoutParams)((Object)object2)).resolveLayoutDirection(this.this$0.getLayoutDirection());
                this.this$0.applyConstraintsFromLayoutParams(false, view, constraintWidget, (ConstraintLayout.LayoutParams)((Object)object2), (SparseArray<ConstraintWidget>)sparseArray);
                if (((ConstraintSet)((Object)object)).getVisibilityMode(view.getId()) == 1) {
                    constraintWidget.setVisibility(view.getVisibility());
                    continue;
                }
                constraintWidget.setVisibility(((ConstraintSet)((Object)object)).getVisibility(view.getId()));
            }
            for (ConstraintWidget constraintWidget : constraintWidgetContainer.getChildren()) {
                if (!(constraintWidget instanceof VirtualLayout)) continue;
                object2 = (ConstraintHelper)((Object)constraintWidget.getCompanionWidget());
                Helper helper = (Helper)((Object)constraintWidget);
                ((ConstraintHelper)((Object)object2)).updatePreLayout(constraintWidgetContainer, helper, (SparseArray<ConstraintWidget>)sparseArray);
                ((VirtualLayout)helper).captureWidgets();
            }
        }

        public void build() {
            MotionController motionController;
            View view;
            int n;
            int n2 = this.this$0.getChildCount();
            this.this$0.mFrameArrayList.clear();
            for (n = 0; n < n2; ++n) {
                view = this.this$0.getChildAt(n);
                motionController = new MotionController(view);
                this.this$0.mFrameArrayList.put(view, motionController);
            }
            for (n = 0; n < n2; ++n) {
                ConstraintWidget constraintWidget;
                view = this.this$0.getChildAt(n);
                motionController = this.this$0.mFrameArrayList.get(view);
                if (motionController == null) continue;
                if (this.mStart != null) {
                    constraintWidget = this.getWidget(this.mLayoutStart, view);
                    if (constraintWidget != null) {
                        motionController.setStartState(constraintWidget, this.mStart);
                    } else if (this.this$0.mDebugPath != 0) {
                        Log.e((String)MotionLayout.TAG, (String)(Debug.getLocation() + "no widget for  " + Debug.getName(view) + " (" + view.getClass().getName() + ")"));
                    }
                }
                if (this.mEnd == null) continue;
                constraintWidget = this.getWidget(this.mLayoutEnd, view);
                if (constraintWidget != null) {
                    motionController.setEndState(constraintWidget, this.mEnd);
                    continue;
                }
                if (this.this$0.mDebugPath == 0) continue;
                Log.e((String)MotionLayout.TAG, (String)(Debug.getLocation() + "no widget for  " + Debug.getName(view) + " (" + view.getClass().getName() + ")"));
            }
        }

        void copy(ConstraintWidgetContainer object, ConstraintWidgetContainer constraintWidget3) {
            ArrayList<ConstraintWidget> arrayList = ((WidgetContainer)object).getChildren();
            HashMap<ConstraintWidget, ConstraintWidget> hashMap = new HashMap<ConstraintWidget, ConstraintWidget>();
            hashMap.put((ConstraintWidget)object, constraintWidget3);
            ((WidgetContainer)constraintWidget3).getChildren().clear();
            constraintWidget3.copy((ConstraintWidget)object, hashMap);
            for (ConstraintWidget constraintWidget2 : arrayList) {
                object = constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Barrier ? new androidx.constraintlayout.solver.widgets.Barrier() : (constraintWidget2 instanceof Guideline ? new Guideline() : (constraintWidget2 instanceof Flow ? new Flow() : (constraintWidget2 instanceof Helper ? new HelperWidget() : new ConstraintWidget())));
                ((WidgetContainer)constraintWidget3).add((ConstraintWidget)object);
                hashMap.put(constraintWidget2, (ConstraintWidget)object);
            }
            for (ConstraintWidget constraintWidget3 : arrayList) {
                hashMap.get(constraintWidget3).copy(constraintWidget3, hashMap);
            }
        }

        ConstraintWidget getWidget(ConstraintWidgetContainer constraintWidget, View view) {
            if (constraintWidget.getCompanionWidget() == view) {
                return constraintWidget;
            }
            ArrayList<ConstraintWidget> arrayList = ((WidgetContainer)constraintWidget).getChildren();
            int n = arrayList.size();
            for (int i = 0; i < n; ++i) {
                constraintWidget = arrayList.get(i);
                if (constraintWidget.getCompanionWidget() != view) continue;
                return constraintWidget;
            }
            return null;
        }

        void initFrom(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.mStart = constraintSet;
            this.mEnd = constraintSet2;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(this.this$0.mLayoutWidget.getMeasurer());
            this.mLayoutEnd.setMeasurer(this.this$0.mLayoutWidget.getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            this.copy(this.this$0.mLayoutWidget, this.mLayoutStart);
            this.copy(this.this$0.mLayoutWidget, this.mLayoutEnd);
            if ((double)this.this$0.mTransitionLastPosition > 0.5) {
                if (constraintSet != null) {
                    this.setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
                this.setupConstraintWidget(this.mLayoutEnd, constraintSet2);
            } else {
                this.setupConstraintWidget(this.mLayoutEnd, constraintSet2);
                if (constraintSet != null) {
                    this.setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
            }
            this.mLayoutStart.setRtl(this.this$0.isRtl());
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(this.this$0.isRtl());
            this.mLayoutEnd.updateHierarchy();
            constraintWidgetContainer = this.this$0.getLayoutParams();
            if (constraintWidgetContainer != null) {
                if (((ViewGroup.LayoutParams)constraintWidgetContainer).width == -2) {
                    this.mLayoutStart.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    this.mLayoutEnd.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
                if (((ViewGroup.LayoutParams)constraintWidgetContainer).height == -2) {
                    this.mLayoutStart.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    this.mLayoutEnd.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            }
        }

        public boolean isNotConfiguredWith(int n, int n2) {
            boolean bl = n != this.mStartId || n2 != this.mEndId;
            return bl;
        }

        public void measure(int n, int n2) {
            boolean bl;
            int n3;
            int n4 = View.MeasureSpec.getMode((int)n);
            int n5 = View.MeasureSpec.getMode((int)n2);
            this.this$0.mWidthMeasureMode = n4;
            this.this$0.mHeightMeasureMode = n5;
            int n6 = this.this$0.getOptimizationLevel();
            if (this.this$0.mCurrentState == this.this$0.getStartState()) {
                this.this$0.resolveSystem(this.mLayoutEnd, n6, n, n2);
                if (this.mStart != null) {
                    this.this$0.resolveSystem(this.mLayoutStart, n6, n, n2);
                }
            } else {
                if (this.mStart != null) {
                    this.this$0.resolveSystem(this.mLayoutStart, n6, n, n2);
                }
                this.this$0.resolveSystem(this.mLayoutEnd, n6, n, n2);
            }
            if ((n3 = this.this$0.getParent() instanceof MotionLayout && n4 == 0x40000000 && n5 == 0x40000000 ? 0 : 1) != 0) {
                this.this$0.mWidthMeasureMode = n4;
                this.this$0.mHeightMeasureMode = n5;
                if (this.this$0.mCurrentState == this.this$0.getStartState()) {
                    this.this$0.resolveSystem(this.mLayoutEnd, n6, n, n2);
                    if (this.mStart != null) {
                        this.this$0.resolveSystem(this.mLayoutStart, n6, n, n2);
                    }
                } else {
                    if (this.mStart != null) {
                        this.this$0.resolveSystem(this.mLayoutStart, n6, n, n2);
                    }
                    this.this$0.resolveSystem(this.mLayoutEnd, n6, n, n2);
                }
                this.this$0.mStartWrapWidth = this.mLayoutStart.getWidth();
                this.this$0.mStartWrapHeight = this.mLayoutStart.getHeight();
                this.this$0.mEndWrapWidth = this.mLayoutEnd.getWidth();
                this.this$0.mEndWrapHeight = this.mLayoutEnd.getHeight();
                MotionLayout motionLayout = this.this$0;
                bl = this.this$0.mStartWrapWidth != this.this$0.mEndWrapWidth || this.this$0.mStartWrapHeight != this.this$0.mEndWrapHeight;
                motionLayout.mMeasureDuringTransition = bl;
            }
            n3 = this.this$0.mStartWrapWidth;
            n4 = this.this$0.mStartWrapHeight;
            if (this.this$0.mWidthMeasureMode == Integer.MIN_VALUE || this.this$0.mWidthMeasureMode == 0) {
                n3 = (int)((float)this.this$0.mStartWrapWidth + this.this$0.mPostInterpolationPosition * (float)(this.this$0.mEndWrapWidth - this.this$0.mStartWrapWidth));
            }
            if (this.this$0.mHeightMeasureMode == Integer.MIN_VALUE || this.this$0.mHeightMeasureMode == 0) {
                n4 = (int)((float)this.this$0.mStartWrapHeight + this.this$0.mPostInterpolationPosition * (float)(this.this$0.mEndWrapHeight - this.this$0.mStartWrapHeight));
            }
            bl = this.mLayoutStart.isWidthMeasuredTooSmall() || this.mLayoutEnd.isWidthMeasuredTooSmall();
            boolean bl2 = this.mLayoutStart.isHeightMeasuredTooSmall() || this.mLayoutEnd.isHeightMeasuredTooSmall();
            this.this$0.resolveMeasuredDimension(n, n2, n3, n4, bl, bl2);
        }

        public void reEvaluateState() {
            this.measure(this.this$0.mLastWidthMeasureSpec, this.this$0.mLastHeightMeasureSpec);
            this.this$0.setupMotionViews();
        }

        public void setMeasuredId(int n, int n2) {
            this.mStartId = n;
            this.mEndId = n2;
        }
    }

    protected static interface MotionTracker {
        public void addMovement(MotionEvent var1);

        public void clear();

        public void computeCurrentVelocity(int var1);

        public void computeCurrentVelocity(int var1, float var2);

        public float getXVelocity();

        public float getXVelocity(int var1);

        public float getYVelocity();

        public float getYVelocity(int var1);

        public void recycle();
    }

    private static class MyTracker
    implements MotionTracker {
        private static MyTracker me = new MyTracker();
        VelocityTracker tracker;

        private MyTracker() {
        }

        public static MyTracker obtain() {
            MyTracker.me.tracker = VelocityTracker.obtain();
            return me;
        }

        @Override
        public void addMovement(MotionEvent motionEvent) {
            if (this.tracker != null) {
                this.tracker.addMovement(motionEvent);
            }
        }

        @Override
        public void clear() {
            this.tracker.clear();
        }

        @Override
        public void computeCurrentVelocity(int n) {
            this.tracker.computeCurrentVelocity(n);
        }

        @Override
        public void computeCurrentVelocity(int n, float f) {
            this.tracker.computeCurrentVelocity(n, f);
        }

        @Override
        public float getXVelocity() {
            return this.tracker.getXVelocity();
        }

        @Override
        public float getXVelocity(int n) {
            return this.tracker.getXVelocity(n);
        }

        @Override
        public float getYVelocity() {
            return this.tracker.getYVelocity();
        }

        @Override
        public float getYVelocity(int n) {
            return this.getYVelocity(n);
        }

        @Override
        public void recycle() {
            this.tracker.recycle();
            this.tracker = null;
        }
    }

    class StateCache {
        final String KeyEndState;
        final String KeyProgress;
        final String KeyStartState;
        final String KeyVelocity;
        int endState;
        float mProgress;
        float mVelocity;
        int startState;
        final MotionLayout this$0;

        StateCache(MotionLayout motionLayout) {
            this.this$0 = motionLayout;
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.startState = -1;
            this.endState = -1;
            this.KeyProgress = "motion.progress";
            this.KeyVelocity = "motion.velocity";
            this.KeyStartState = "motion.StartState";
            this.KeyEndState = "motion.EndState";
        }

        void apply() {
            if (this.startState != -1 || this.endState != -1) {
                if (this.startState == -1) {
                    this.this$0.transitionToState(this.endState);
                } else if (this.endState == -1) {
                    this.this$0.setState(this.startState, -1, -1);
                } else {
                    this.this$0.setTransition(this.startState, this.endState);
                }
                this.this$0.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.mVelocity)) {
                if (Float.isNaN(this.mProgress)) {
                    return;
                }
                this.this$0.setProgress(this.mProgress);
                return;
            }
            this.this$0.setProgress(this.mProgress, this.mVelocity);
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.startState = -1;
            this.endState = -1;
        }

        public Bundle getTransitionState() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.mProgress);
            bundle.putFloat("motion.velocity", this.mVelocity);
            bundle.putInt("motion.StartState", this.startState);
            bundle.putInt("motion.EndState", this.endState);
            return bundle;
        }

        public void recordState() {
            this.endState = this.this$0.mEndState;
            this.startState = this.this$0.mBeginState;
            this.mVelocity = this.this$0.getVelocity();
            this.mProgress = this.this$0.getProgress();
        }

        public void setEndState(int n) {
            this.endState = n;
        }

        public void setProgress(float f) {
            this.mProgress = f;
        }

        public void setStartState(int n) {
            this.startState = n;
        }

        public void setTransitionState(Bundle bundle) {
            this.mProgress = bundle.getFloat("motion.progress");
            this.mVelocity = bundle.getFloat("motion.velocity");
            this.startState = bundle.getInt("motion.StartState");
            this.endState = bundle.getInt("motion.EndState");
        }

        public void setVelocity(float f) {
            this.mVelocity = f;
        }
    }

    public static interface TransitionListener {
        public void onTransitionChange(MotionLayout var1, int var2, int var3, float var4);

        public void onTransitionCompleted(MotionLayout var1, int var2);

        public void onTransitionStarted(MotionLayout var1, int var2, int var3);

        public void onTransitionTrigger(MotionLayout var1, int var2, boolean var3, float var4);
    }

    static enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED;

    }
}

