/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

class TouchResponse {
    private static final boolean DEBUG = false;
    static final int FLAG_DISABLE_POST_SCROLL = 1;
    static final int FLAG_DISABLE_SCROLL = 2;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final float[][] TOUCH_DIRECTION;
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final float[][] TOUCH_SIDES;
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP = 0;
    private float[] mAnchorDpDt = new float[2];
    private float mDragScale = 1.0f;
    private boolean mDragStarted = false;
    private float mDragThreshold = 10.0f;
    private int mFlags = 0;
    private float mLastTouchX;
    private float mLastTouchY;
    private int mLimitBoundsTo = -1;
    private float mMaxAcceleration = 1.2f;
    private float mMaxVelocity = 4.0f;
    private final MotionLayout mMotionLayout;
    private boolean mMoveWhenScrollAtTop = true;
    private int mOnTouchUp = 0;
    private int mTouchAnchorId = -1;
    private int mTouchAnchorSide = 0;
    private float mTouchAnchorX = 0.5f;
    private float mTouchAnchorY = 0.5f;
    private float mTouchDirectionX = 0.0f;
    private float mTouchDirectionY = 1.0f;
    private int mTouchRegionId = -1;
    private int mTouchSide = 0;

    static {
        float[] fArray = new float[]{0.5f, 0.0f};
        float[] fArray2 = new float[]{1.0f, 0.5f};
        TOUCH_SIDES = new float[][]{fArray, {0.0f, 0.5f}, {1.0f, 0.5f}, {0.5f, 1.0f}, {0.5f, 0.5f}, {0.0f, 0.5f}, fArray2};
        fArray = new float[]{1.0f, 0.0f};
        fArray2 = new float[]{-1.0f, 0.0f};
        TOUCH_DIRECTION = new float[][]{{0.0f, -1.0f}, {0.0f, 1.0f}, {-1.0f, 0.0f}, fArray, fArray2, {1.0f, 0.0f}};
    }

    TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.mMotionLayout = motionLayout;
        this.fillFromAttributeList(context, Xml.asAttributeSet((XmlPullParser)xmlPullParser));
    }

    private void fill(TypedArray typedArray) {
        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; ++i) {
            int n2 = typedArray.getIndex(i);
            if (n2 == R.styleable.OnSwipe_touchAnchorId) {
                this.mTouchAnchorId = typedArray.getResourceId(n2, this.mTouchAnchorId);
                continue;
            }
            if (n2 == R.styleable.OnSwipe_touchAnchorSide) {
                this.mTouchAnchorSide = typedArray.getInt(n2, this.mTouchAnchorSide);
                this.mTouchAnchorX = TOUCH_SIDES[this.mTouchAnchorSide][0];
                this.mTouchAnchorY = TOUCH_SIDES[this.mTouchAnchorSide][1];
                continue;
            }
            if (n2 == R.styleable.OnSwipe_dragDirection) {
                this.mTouchSide = typedArray.getInt(n2, this.mTouchSide);
                this.mTouchDirectionX = TOUCH_DIRECTION[this.mTouchSide][0];
                this.mTouchDirectionY = TOUCH_DIRECTION[this.mTouchSide][1];
                continue;
            }
            if (n2 == R.styleable.OnSwipe_maxVelocity) {
                this.mMaxVelocity = typedArray.getFloat(n2, this.mMaxVelocity);
                continue;
            }
            if (n2 == R.styleable.OnSwipe_maxAcceleration) {
                this.mMaxAcceleration = typedArray.getFloat(n2, this.mMaxAcceleration);
                continue;
            }
            if (n2 == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.mMoveWhenScrollAtTop = typedArray.getBoolean(n2, this.mMoveWhenScrollAtTop);
                continue;
            }
            if (n2 == R.styleable.OnSwipe_dragScale) {
                this.mDragScale = typedArray.getFloat(n2, this.mDragScale);
                continue;
            }
            if (n2 == R.styleable.OnSwipe_dragThreshold) {
                this.mDragThreshold = typedArray.getFloat(n2, this.mDragThreshold);
                continue;
            }
            if (n2 == R.styleable.OnSwipe_touchRegionId) {
                this.mTouchRegionId = typedArray.getResourceId(n2, this.mTouchRegionId);
                continue;
            }
            if (n2 == R.styleable.OnSwipe_onTouchUp) {
                this.mOnTouchUp = typedArray.getInt(n2, this.mOnTouchUp);
                continue;
            }
            if (n2 == R.styleable.OnSwipe_nestedScrollFlags) {
                this.mFlags = typedArray.getInteger(n2, 0);
                continue;
            }
            if (n2 != R.styleable.OnSwipe_limitBoundsTo) continue;
            this.mLimitBoundsTo = typedArray.getResourceId(n2, 0);
        }
    }

    private void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
        this.fill((TypedArray)context);
        context.recycle();
    }

    float dot(float f, float f2) {
        return this.mTouchDirectionX * f + this.mTouchDirectionY * f2;
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getFlags() {
        return this.mFlags;
    }

    RectF getLimitBoundsTo(ViewGroup viewGroup, RectF rectF) {
        if (this.mLimitBoundsTo == -1) {
            return null;
        }
        if ((viewGroup = viewGroup.findViewById(this.mLimitBoundsTo)) == null) {
            return null;
        }
        rectF.set((float)viewGroup.getLeft(), (float)viewGroup.getTop(), (float)viewGroup.getRight(), (float)viewGroup.getBottom());
        return rectF;
    }

    int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    float getProgressDirection(float f, float f2) {
        float f3 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, f3, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        if (this.mTouchDirectionX != 0.0f) {
            if (this.mAnchorDpDt[0] == 0.0f) {
                this.mAnchorDpDt[0] = 1.0E-7f;
            }
            f = this.mTouchDirectionX * f / this.mAnchorDpDt[0];
        } else {
            if (this.mAnchorDpDt[1] == 0.0f) {
                this.mAnchorDpDt[1] = 1.0E-7f;
            }
            f = this.mTouchDirectionY * f2 / this.mAnchorDpDt[1];
        }
        return f;
    }

    RectF getTouchRegion(ViewGroup viewGroup, RectF rectF) {
        if (this.mTouchRegionId == -1) {
            return null;
        }
        if ((viewGroup = viewGroup.findViewById(this.mTouchRegionId)) == null) {
            return null;
        }
        rectF.set((float)viewGroup.getLeft(), (float)viewGroup.getTop(), (float)viewGroup.getRight(), (float)viewGroup.getBottom());
        return rectF;
    }

    int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    void processTouchEvent(MotionEvent object, MotionLayout.MotionTracker motionTracker, int n, MotionScene motionScene) {
        motionTracker.addMovement((MotionEvent)object);
        switch (object.getAction()) {
            default: {
                break;
            }
            case 2: {
                float f = object.getRawY() - this.mLastTouchY;
                float f2 = object.getRawX() - this.mLastTouchX;
                if (!(Math.abs(this.mTouchDirectionX * f2 + this.mTouchDirectionY * f) > this.mDragThreshold) && !this.mDragStarted) break;
                float f3 = this.mMotionLayout.getProgress();
                if (!this.mDragStarted) {
                    this.mDragStarted = true;
                    this.mMotionLayout.setProgress(f3);
                }
                if (this.mTouchAnchorId != -1) {
                    this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, f3, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                } else {
                    float f4 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                    this.mAnchorDpDt[1] = this.mTouchDirectionY * f4;
                    this.mAnchorDpDt[0] = this.mTouchDirectionX * f4;
                }
                if ((double)Math.abs((this.mTouchDirectionX * this.mAnchorDpDt[0] + this.mTouchDirectionY * this.mAnchorDpDt[1]) * this.mDragScale) < 0.01) {
                    this.mAnchorDpDt[0] = 0.01f;
                    this.mAnchorDpDt[1] = 0.01f;
                }
                f2 = this.mTouchDirectionX != 0.0f ? (f2 /= this.mAnchorDpDt[0]) : f / this.mAnchorDpDt[1];
                f2 = Math.max(Math.min(f3 + f2, 1.0f), 0.0f);
                if (f2 != this.mMotionLayout.getProgress()) {
                    this.mMotionLayout.setProgress(f2);
                    motionTracker.computeCurrentVelocity(1000);
                    f2 = motionTracker.getXVelocity();
                    f3 = motionTracker.getYVelocity();
                    f2 = this.mTouchDirectionX != 0.0f ? (f2 /= this.mAnchorDpDt[0]) : f3 / this.mAnchorDpDt[1];
                    this.mMotionLayout.mLastVelocity = f2;
                } else {
                    this.mMotionLayout.mLastVelocity = 0.0f;
                }
                this.mLastTouchX = object.getRawX();
                this.mLastTouchY = object.getRawY();
                break;
            }
            case 1: {
                float f;
                this.mDragStarted = false;
                motionTracker.computeCurrentVelocity(1000);
                float f5 = motionTracker.getXVelocity();
                float f6 = motionTracker.getYVelocity();
                float f7 = this.mMotionLayout.getProgress();
                if (this.mTouchAnchorId != -1) {
                    this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, f7, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                } else {
                    f = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                    this.mAnchorDpDt[1] = this.mTouchDirectionY * f;
                    this.mAnchorDpDt[0] = this.mTouchDirectionX * f;
                }
                f = this.mTouchDirectionX;
                f = this.mAnchorDpDt[0];
                f = this.mTouchDirectionY;
                f = this.mAnchorDpDt[1];
                f5 = this.mTouchDirectionX != 0.0f ? (f5 /= this.mAnchorDpDt[0]) : f6 / this.mAnchorDpDt[1];
                f6 = !Float.isNaN(f5) ? f7 + f5 / 3.0f : f7;
                if (f6 != 0.0f && f6 != 1.0f && this.mOnTouchUp != 3) {
                    object = this.mMotionLayout;
                    n = this.mOnTouchUp;
                    f6 = (double)f6 < 0.5 ? 0.0f : 1.0f;
                    ((MotionLayout)object).touchAnimateTo(n, f6, f5);
                    if (!(0.0f >= f7) && !(1.0f <= f7)) break;
                    this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    break;
                }
                if (!(0.0f >= f6) && !(1.0f <= f6)) break;
                this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                break;
            }
            case 0: {
                this.mLastTouchX = object.getRawX();
                this.mLastTouchY = object.getRawY();
                this.mDragStarted = false;
            }
        }
    }

    void scrollMove(float f, float f2) {
        float f3 = this.mTouchDirectionX;
        f3 = this.mTouchDirectionY;
        f3 = this.mMotionLayout.getProgress();
        if (!this.mDragStarted) {
            this.mDragStarted = true;
            this.mMotionLayout.setProgress(f3);
        }
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, f3, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        if ((double)Math.abs(this.mTouchDirectionX * this.mAnchorDpDt[0] + this.mTouchDirectionY * this.mAnchorDpDt[1]) < 0.01) {
            this.mAnchorDpDt[0] = 0.01f;
            this.mAnchorDpDt[1] = 0.01f;
        }
        f = this.mTouchDirectionX != 0.0f ? this.mTouchDirectionX * f / this.mAnchorDpDt[0] : this.mTouchDirectionY * f2 / this.mAnchorDpDt[1];
        if ((f = Math.max(Math.min(f3 + f, 1.0f), 0.0f)) != this.mMotionLayout.getProgress()) {
            this.mMotionLayout.setProgress(f);
        }
    }

    void scrollUp(float f, float f2) {
        boolean bl = false;
        this.mDragStarted = false;
        float f3 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, f3, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f4 = this.mTouchDirectionX;
        f4 = this.mAnchorDpDt[0];
        f4 = this.mTouchDirectionY;
        f4 = this.mAnchorDpDt[1];
        float f5 = this.mTouchDirectionX;
        f4 = 0.0f;
        f = f5 != 0.0f ? this.mTouchDirectionX * f / this.mAnchorDpDt[0] : this.mTouchDirectionY * f2 / this.mAnchorDpDt[1];
        f2 = f3;
        if (!Float.isNaN(f)) {
            f2 = f3 + f / 3.0f;
        }
        if (f2 != 0.0f) {
            int n = f2 != 1.0f ? 1 : 0;
            if (this.mOnTouchUp != 3) {
                bl = true;
            }
            if (bl & n) {
                MotionLayout motionLayout = this.mMotionLayout;
                n = this.mOnTouchUp;
                f2 = (double)f2 < 0.5 ? f4 : 1.0f;
                motionLayout.touchAnimateTo(n, f2, f);
            }
        }
    }

    public void setAnchorId(int n) {
        this.mTouchAnchorId = n;
    }

    void setDown(float f, float f2) {
        this.mLastTouchX = f;
        this.mLastTouchY = f2;
    }

    public void setMaxAcceleration(float f) {
        this.mMaxAcceleration = f;
    }

    public void setMaxVelocity(float f) {
        this.mMaxVelocity = f;
    }

    public void setRTL(boolean bl) {
        if (bl) {
            TouchResponse.TOUCH_DIRECTION[4] = TOUCH_DIRECTION[3];
            TouchResponse.TOUCH_DIRECTION[5] = TOUCH_DIRECTION[2];
            TouchResponse.TOUCH_SIDES[5] = TOUCH_SIDES[2];
            TouchResponse.TOUCH_SIDES[6] = TOUCH_SIDES[1];
        } else {
            TouchResponse.TOUCH_DIRECTION[4] = TOUCH_DIRECTION[2];
            TouchResponse.TOUCH_DIRECTION[5] = TOUCH_DIRECTION[3];
            TouchResponse.TOUCH_SIDES[5] = TOUCH_SIDES[1];
            TouchResponse.TOUCH_SIDES[6] = TOUCH_SIDES[2];
        }
        this.mTouchAnchorX = TOUCH_SIDES[this.mTouchAnchorSide][0];
        this.mTouchAnchorY = TOUCH_SIDES[this.mTouchAnchorSide][1];
        this.mTouchDirectionX = TOUCH_DIRECTION[this.mTouchSide][0];
        this.mTouchDirectionY = TOUCH_DIRECTION[this.mTouchSide][1];
    }

    public void setTouchAnchorLocation(float f, float f2) {
        this.mTouchAnchorX = f;
        this.mTouchAnchorY = f2;
    }

    void setUpTouchEvent(float f, float f2) {
        this.mLastTouchX = f;
        this.mLastTouchY = f2;
        this.mDragStarted = false;
    }

    void setupTouch() {
        NestedScrollView nestedScrollView = null;
        if (this.mTouchAnchorId != -1) {
            View view = this.mMotionLayout.findViewById(this.mTouchAnchorId);
            nestedScrollView = view;
            if (view == null) {
                Log.e((String)TAG, (String)("cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId)));
                nestedScrollView = view;
            }
        }
        if (nestedScrollView instanceof NestedScrollView) {
            nestedScrollView = nestedScrollView;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener(this){
                final TouchResponse this$0;
                {
                    this.this$0 = touchResponse;
                }

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(this){
                final TouchResponse this$0;
                {
                    this.this$0 = touchResponse;
                }

                @Override
                public void onScrollChange(NestedScrollView nestedScrollView, int n, int n2, int n3, int n4) {
                }
            });
        }
    }

    public String toString() {
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }
}

