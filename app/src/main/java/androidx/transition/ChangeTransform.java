/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.Animator$AnimatorPauseListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.transition.FloatArrayEvaluator;
import androidx.transition.GhostView;
import androidx.transition.GhostViewUtils;
import androidx.transition.MatrixUtils;
import androidx.transition.PropertyValuesHolderUtils;
import androidx.transition.R;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionValues;
import androidx.transition.ViewUtils;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform
extends Transition {
    private static final Property<PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY;
    private static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    private static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    private static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
    private static final String PROPNAME_PARENT = "android:changeTransform:parent";
    private static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    private static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION;
    private static final Property<PathAnimatorMatrix, PointF> TRANSLATIONS_PROPERTY;
    private static final String[] sTransitionProperties;
    private boolean mReparent = true;
    private Matrix mTempMatrix = new Matrix();
    boolean mUseOverlay = true;

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};
        NON_TRANSLATIONS_PROPERTY = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations"){

            public float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
                return null;
            }

            public void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArray) {
                pathAnimatorMatrix.setValues(fArray);
            }
        };
        TRANSLATIONS_PROPERTY = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations"){

            public PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
                return null;
            }

            public void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
                pathAnimatorMatrix.setTranslation(pointF);
            }
        };
        SUPPORTS_VIEW_REMOVAL_SUPPRESSION = true;
    }

    public ChangeTransform() {
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_TRANSFORM);
        this.mUseOverlay = TypedArrayUtils.getNamedBoolean((TypedArray)context, (XmlPullParser)attributeSet, "reparentWithOverlay", 1, true);
        this.mReparent = TypedArrayUtils.getNamedBoolean((TypedArray)context, (XmlPullParser)attributeSet, "reparent", 0, true);
        context.recycle();
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() == 8) {
            return;
        }
        transitionValues.values.put(PROPNAME_PARENT, view.getParent());
        Transforms transforms = new Transforms(view);
        transitionValues.values.put(PROPNAME_TRANSFORMS, transforms);
        transforms = view.getMatrix();
        transforms = transforms != null && !transforms.isIdentity() ? new Matrix((Matrix)transforms) : null;
        transitionValues.values.put(PROPNAME_MATRIX, transforms);
        if (this.mReparent) {
            transforms = new Matrix();
            ViewGroup viewGroup = (ViewGroup)view.getParent();
            ViewUtils.transformMatrixToGlobal((View)viewGroup, (Matrix)transforms);
            transforms.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
            transitionValues.values.put(PROPNAME_PARENT_MATRIX, transforms);
            transitionValues.values.put(PROPNAME_INTERMEDIATE_MATRIX, view.getTag(R.id.transition_transform));
            transitionValues.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, view.getTag(R.id.parent_matrix));
        }
    }

    private void createGhostView(ViewGroup object, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = transitionValues2.view;
        Object object2 = new Matrix((Matrix)transitionValues2.values.get(PROPNAME_PARENT_MATRIX));
        ViewUtils.transformMatrixToLocal((View)object, (Matrix)object2);
        object2 = GhostViewUtils.addGhost(view, object, (Matrix)object2);
        if (object2 == null) {
            return;
        }
        object2.reserveEndViewTransition((ViewGroup)transitionValues.values.get(PROPNAME_PARENT), transitionValues.view);
        object = this;
        while (object.mParent != null) {
            object = object.mParent;
        }
        object.addListener(new GhostListener(view, (GhostView)object2));
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            if (transitionValues.view != transitionValues2.view) {
                ViewUtils.setTransitionAlpha(transitionValues.view, 0.0f);
            }
            ViewUtils.setTransitionAlpha(view, 1.0f);
        }
    }

    private ObjectAnimator createTransformAnimator(TransitionValues object, TransitionValues transitionValues, boolean bl) {
        object = (Matrix)object.values.get(PROPNAME_MATRIX);
        Object object2 = (Matrix)transitionValues.values.get(PROPNAME_MATRIX);
        Object object3 = object;
        if (object == null) {
            object3 = MatrixUtils.IDENTITY_MATRIX;
        }
        object = object2;
        if (object2 == null) {
            object = MatrixUtils.IDENTITY_MATRIX;
        }
        if (object3.equals(object)) {
            return null;
        }
        object2 = (Transforms)transitionValues.values.get(PROPNAME_TRANSFORMS);
        transitionValues = transitionValues.view;
        ChangeTransform.setIdentityTransforms((View)transitionValues);
        Object object4 = new float[9];
        object3.getValues(object4);
        float[] fArray = new float[9];
        object.getValues(fArray);
        object3 = new PathAnimatorMatrix((View)transitionValues, (float[])object4);
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, (TypeEvaluator)new FloatArrayEvaluator(new float[9]), (Object[])new float[][]{object4, fArray});
        object4 = this.getPathMotion().getPath(object4[2], object4[5], fArray[2], fArray[5]);
        object4 = ObjectAnimator.ofPropertyValuesHolder((Object)object3, (PropertyValuesHolder[])new PropertyValuesHolder[]{propertyValuesHolder, PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, (Path)object4)});
        object = new Listener((View)transitionValues, (Transforms)object2, (PathAnimatorMatrix)object3, (Matrix)object, bl, this.mUseOverlay);
        object4.addListener((Animator.AnimatorListener)object);
        object4.addPauseListener((Animator.AnimatorPauseListener)object);
        return object4;
    }

    private boolean parentsMatch(ViewGroup object, ViewGroup viewGroup) {
        boolean bl = false;
        boolean bl2 = this.isValidTarget((View)object);
        boolean bl3 = false;
        boolean bl4 = false;
        if (bl2 && this.isValidTarget((View)viewGroup)) {
            object = this.getMatchedTransitionValues((View)object, true);
            bl3 = bl;
            if (object != null) {
                bl3 = bl4;
                if (viewGroup == object.view) {
                    bl3 = true;
                }
            }
        } else if (object == viewGroup) {
            bl3 = true;
        }
        return bl3;
    }

    static void setIdentityTransforms(View view) {
        ChangeTransform.setTransforms(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void setMatricesForParent(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = (Matrix)transitionValues2.values.get(PROPNAME_PARENT_MATRIX);
        transitionValues2.view.setTag(R.id.parent_matrix, (Object)matrix);
        Matrix matrix2 = this.mTempMatrix;
        matrix2.reset();
        matrix.invert(matrix2);
        matrix = (Matrix)transitionValues.values.get(PROPNAME_MATRIX);
        transitionValues2 = matrix;
        if (matrix == null) {
            transitionValues2 = new Matrix();
            transitionValues.values.put(PROPNAME_MATRIX, transitionValues2);
        }
        transitionValues2.postConcat((Matrix)transitionValues.values.get(PROPNAME_PARENT_MATRIX));
        transitionValues2.postConcat(matrix2);
    }

    static void setTransforms(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        ViewCompat.setTranslationZ(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
        if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            ((ViewGroup)transitionValues.view.getParent()).startViewTransition(transitionValues.view);
        }
    }

    @Override
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues != null && transitionValues2 != null && transitionValues.values.containsKey(PROPNAME_PARENT) && transitionValues2.values.containsKey(PROPNAME_PARENT)) {
            ViewGroup viewGroup2 = (ViewGroup)transitionValues.values.get(PROPNAME_PARENT);
            ViewGroup viewGroup3 = (ViewGroup)transitionValues2.values.get(PROPNAME_PARENT);
            boolean bl = this.mReparent && !this.parentsMatch(viewGroup2, viewGroup3);
            viewGroup3 = (Matrix)transitionValues.values.get(PROPNAME_INTERMEDIATE_MATRIX);
            if (viewGroup3 != null) {
                transitionValues.values.put(PROPNAME_MATRIX, viewGroup3);
            }
            if ((viewGroup3 = (Matrix)transitionValues.values.get(PROPNAME_INTERMEDIATE_PARENT_MATRIX)) != null) {
                transitionValues.values.put(PROPNAME_PARENT_MATRIX, viewGroup3);
            }
            if (bl) {
                this.setMatricesForParent(transitionValues, transitionValues2);
            }
            viewGroup3 = this.createTransformAnimator(transitionValues, transitionValues2, bl);
            if (bl && viewGroup3 != null && this.mUseOverlay) {
                this.createGhostView(viewGroup, transitionValues, transitionValues2);
            } else if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
                viewGroup2.endViewTransition(transitionValues.view);
            }
            return viewGroup3;
        }
        return null;
    }

    public boolean getReparent() {
        return this.mReparent;
    }

    public boolean getReparentWithOverlay() {
        return this.mUseOverlay;
    }

    @Override
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setReparent(boolean bl) {
        this.mReparent = bl;
    }

    public void setReparentWithOverlay(boolean bl) {
        this.mUseOverlay = bl;
    }

    private static class GhostListener
    extends TransitionListenerAdapter {
        private GhostView mGhostView;
        private View mView;

        GhostListener(View view, GhostView ghostView) {
            this.mView = view;
            this.mGhostView = ghostView;
        }

        @Override
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            GhostViewUtils.removeGhost(this.mView);
            this.mView.setTag(R.id.transition_transform, null);
            this.mView.setTag(R.id.parent_matrix, null);
        }

        @Override
        public void onTransitionPause(Transition transition) {
            this.mGhostView.setVisibility(4);
        }

        @Override
        public void onTransitionResume(Transition transition) {
            this.mGhostView.setVisibility(0);
        }
    }

    private static class Listener
    extends AnimatorListenerAdapter {
        private final Matrix mEndMatrix;
        private final boolean mHandleParentChange;
        private boolean mIsCanceled;
        private final PathAnimatorMatrix mPathAnimatorMatrix;
        private final Matrix mTempMatrix = new Matrix();
        private final Transforms mTransforms;
        private final boolean mUseOverlay;
        private final View mView;

        Listener(View view, Transforms transforms, PathAnimatorMatrix pathAnimatorMatrix, Matrix matrix, boolean bl, boolean bl2) {
            this.mHandleParentChange = bl;
            this.mUseOverlay = bl2;
            this.mView = view;
            this.mTransforms = transforms;
            this.mPathAnimatorMatrix = pathAnimatorMatrix;
            this.mEndMatrix = matrix;
        }

        private void setCurrentMatrix(Matrix matrix) {
            this.mTempMatrix.set(matrix);
            this.mView.setTag(R.id.transition_transform, (Object)this.mTempMatrix);
            this.mTransforms.restore(this.mView);
        }

        public void onAnimationCancel(Animator animator2) {
            this.mIsCanceled = true;
        }

        public void onAnimationEnd(Animator animator2) {
            if (!this.mIsCanceled) {
                if (this.mHandleParentChange && this.mUseOverlay) {
                    this.setCurrentMatrix(this.mEndMatrix);
                } else {
                    this.mView.setTag(R.id.transition_transform, null);
                    this.mView.setTag(R.id.parent_matrix, null);
                }
            }
            ViewUtils.setAnimationMatrix(this.mView, null);
            this.mTransforms.restore(this.mView);
        }

        public void onAnimationPause(Animator animator2) {
            this.setCurrentMatrix(this.mPathAnimatorMatrix.getMatrix());
        }

        public void onAnimationResume(Animator animator2) {
            ChangeTransform.setIdentityTransforms(this.mView);
        }
    }

    private static class PathAnimatorMatrix {
        private final Matrix mMatrix = new Matrix();
        private float mTranslationX;
        private float mTranslationY;
        private final float[] mValues;
        private final View mView;

        PathAnimatorMatrix(View view, float[] fArray) {
            this.mView = view;
            this.mValues = (float[])fArray.clone();
            this.mTranslationX = this.mValues[2];
            this.mTranslationY = this.mValues[5];
            this.setAnimationMatrix();
        }

        private void setAnimationMatrix() {
            this.mValues[2] = this.mTranslationX;
            this.mValues[5] = this.mTranslationY;
            this.mMatrix.setValues(this.mValues);
            ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
        }

        Matrix getMatrix() {
            return this.mMatrix;
        }

        void setTranslation(PointF pointF) {
            this.mTranslationX = pointF.x;
            this.mTranslationY = pointF.y;
            this.setAnimationMatrix();
        }

        void setValues(float[] fArray) {
            System.arraycopy(fArray, 0, this.mValues, 0, fArray.length);
            this.setAnimationMatrix();
        }
    }

    private static class Transforms {
        final float mRotationX;
        final float mRotationY;
        final float mRotationZ;
        final float mScaleX;
        final float mScaleY;
        final float mTranslationX;
        final float mTranslationY;
        final float mTranslationZ;

        Transforms(View view) {
            this.mTranslationX = view.getTranslationX();
            this.mTranslationY = view.getTranslationY();
            this.mTranslationZ = ViewCompat.getTranslationZ(view);
            this.mScaleX = view.getScaleX();
            this.mScaleY = view.getScaleY();
            this.mRotationX = view.getRotationX();
            this.mRotationY = view.getRotationY();
            this.mRotationZ = view.getRotation();
        }

        public boolean equals(Object object) {
            boolean bl = object instanceof Transforms;
            boolean bl2 = false;
            if (!bl) {
                return false;
            }
            object = (Transforms)object;
            bl = bl2;
            if (((Transforms)object).mTranslationX == this.mTranslationX) {
                bl = bl2;
                if (((Transforms)object).mTranslationY == this.mTranslationY) {
                    bl = bl2;
                    if (((Transforms)object).mTranslationZ == this.mTranslationZ) {
                        bl = bl2;
                        if (((Transforms)object).mScaleX == this.mScaleX) {
                            bl = bl2;
                            if (((Transforms)object).mScaleY == this.mScaleY) {
                                bl = bl2;
                                if (((Transforms)object).mRotationX == this.mRotationX) {
                                    bl = bl2;
                                    if (((Transforms)object).mRotationY == this.mRotationY) {
                                        bl = bl2;
                                        if (((Transforms)object).mRotationZ == this.mRotationZ) {
                                            bl = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return bl;
        }

        public int hashCode() {
            float f = this.mTranslationX;
            int n = 0;
            int n2 = f != 0.0f ? Float.floatToIntBits(this.mTranslationX) : 0;
            int n3 = this.mTranslationY != 0.0f ? Float.floatToIntBits(this.mTranslationY) : 0;
            int n4 = this.mTranslationZ != 0.0f ? Float.floatToIntBits(this.mTranslationZ) : 0;
            int n5 = this.mScaleX != 0.0f ? Float.floatToIntBits(this.mScaleX) : 0;
            int n6 = this.mScaleY != 0.0f ? Float.floatToIntBits(this.mScaleY) : 0;
            int n7 = this.mRotationX != 0.0f ? Float.floatToIntBits(this.mRotationX) : 0;
            int n8 = this.mRotationY != 0.0f ? Float.floatToIntBits(this.mRotationY) : 0;
            if (this.mRotationZ != 0.0f) {
                n = Float.floatToIntBits(this.mRotationZ);
            }
            return ((((((n2 * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n;
        }

        public void restore(View view) {
            ChangeTransform.setTransforms(view, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
        }
    }
}

