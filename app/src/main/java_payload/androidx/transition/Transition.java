/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Path
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.InflateException
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.WindowId
 *  android.view.animation.AnimationUtils
 *  android.widget.ListView
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.transition.PathMotion;
import androidx.transition.Styleable;
import androidx.transition.Transition$SeekController$$ExternalSyntheticLambda0;
import androidx.transition.Transition$TransitionNotification$$ExternalSyntheticLambda0;
import androidx.transition.Transition$TransitionNotification$$ExternalSyntheticLambda1;
import androidx.transition.Transition$TransitionNotification$$ExternalSyntheticLambda2;
import androidx.transition.Transition$TransitionNotification$$ExternalSyntheticLambda3;
import androidx.transition.Transition$TransitionNotification$$ExternalSyntheticLambda4;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionPropagation;
import androidx.transition.TransitionSeekController;
import androidx.transition.TransitionSet;
import androidx.transition.TransitionValues;
import androidx.transition.TransitionValuesMaps;
import androidx.transition.VelocityTracker1D;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

public abstract class Transition
implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER;
    private static final Animator[] EMPTY_ANIMATOR_ARRAY;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION;
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators;
    private Animator[] mAnimatorCache;
    ArrayList<Animator> mAnimators;
    boolean mCanRemoveViews = false;
    private Transition mCloneParent = null;
    ArrayList<Animator> mCurrentAnimators;
    long mDuration = -1L;
    private TransitionValuesMaps mEndValues;
    private ArrayList<TransitionValues> mEndValuesList;
    boolean mEnded = false;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<TransitionListener> mListeners = null;
    private TransitionListener[] mListenersCache;
    private int[] mMatchOrder;
    private String mName = this.getClass().getName();
    private ArrayMap<String, String> mNameOverrides;
    int mNumInstances = 0;
    TransitionSet mParent = null;
    private PathMotion mPathMotion;
    private boolean mPaused = false;
    TransitionPropagation mPropagation;
    SeekController mSeekController;
    long mSeekOffsetInParent;
    private long mStartDelay = -1L;
    private TransitionValuesMaps mStartValues;
    private ArrayList<TransitionValues> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    ArrayList<View> mTargets = new ArrayList();
    long mTotalDuration;

    static {
        EMPTY_ANIMATOR_ARRAY = new Animator[0];
        DEFAULT_MATCH_ORDER = new int[]{2, 1, 3, 4};
        STRAIGHT_PATH_MOTION = new PathMotion(){

            @Override
            public Path getPath(float f, float f2, float f3, float f4) {
                Path path2 = new Path();
                path2.moveTo(f, f2);
                path2.lineTo(f3, f4);
                return path2;
            }
        };
        sRunningAnimators = new ThreadLocal();
    }

    public Transition() {
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mCurrentAnimators = new ArrayList();
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
    }

    public Transition(Context object, AttributeSet attributeSet) {
        int n;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mCurrentAnimators = new ArrayList();
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        TypedArray typedArray = object.obtainStyledAttributes(attributeSet, Styleable.TRANSITION);
        attributeSet = (XmlResourceParser)attributeSet;
        long l = TypedArrayUtils.getNamedInt(typedArray, (XmlPullParser)attributeSet, "duration", 1, -1);
        if (l >= 0L) {
            this.setDuration(l);
        }
        if ((l = (long)TypedArrayUtils.getNamedInt(typedArray, (XmlPullParser)attributeSet, "startDelay", 2, -1)) > 0L) {
            this.setStartDelay(l);
        }
        if ((n = TypedArrayUtils.getNamedResourceId(typedArray, (XmlPullParser)attributeSet, "interpolator", 0, 0)) > 0) {
            this.setInterpolator((TimeInterpolator)AnimationUtils.loadInterpolator((Context)object, (int)n));
        }
        if ((object = TypedArrayUtils.getNamedString(typedArray, (XmlPullParser)attributeSet, "matchOrder", 3)) != null) {
            this.setMatchOrder(Transition.parseMatchOrder((String)object));
        }
        typedArray.recycle();
    }

    static /* synthetic */ Transition access$002(Transition transition, Transition transition2) {
        transition.mCloneParent = transition2;
        return transition2;
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> object, ArrayMap<View, TransitionValues> arrayMap) {
        int n;
        for (n = 0; n < ((SimpleArrayMap)object).size(); ++n) {
            TransitionValues transitionValues = (TransitionValues)((SimpleArrayMap)object).valueAt(n);
            if (!this.isValidTarget(transitionValues.view)) continue;
            this.mStartValuesList.add(transitionValues);
            this.mEndValuesList.add(null);
        }
        for (n = 0; n < arrayMap.size(); ++n) {
            object = (TransitionValues)arrayMap.valueAt(n);
            if (!this.isValidTarget(((TransitionValues)object).view)) continue;
            this.mEndValuesList.add((TransitionValues)object);
            this.mStartValuesList.add(null);
        }
    }

    private static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues object) {
        transitionValuesMaps.mViewValues.put(view, (TransitionValues)object);
        int n = view.getId();
        if (n >= 0) {
            if (transitionValuesMaps.mIdValues.indexOfKey(n) >= 0) {
                transitionValuesMaps.mIdValues.put(n, null);
            } else {
                transitionValuesMaps.mIdValues.put(n, (Object)view);
            }
        }
        if ((object = ViewCompat.getTransitionName(view)) != null) {
            if (transitionValuesMaps.mNameValues.containsKey(object)) {
                transitionValuesMaps.mNameValues.put((String)object, null);
            } else {
                transitionValuesMaps.mNameValues.put((String)object, view);
            }
        }
        if (view.getParent() instanceof ListView && (object = (ListView)view.getParent()).getAdapter().hasStableIds()) {
            long l = object.getItemIdAtPosition(object.getPositionForView(view));
            if (transitionValuesMaps.mItemIdValues.indexOfKey(l) >= 0) {
                view = transitionValuesMaps.mItemIdValues.get(l);
                if (view != null) {
                    view.setHasTransientState(false);
                    transitionValuesMaps.mItemIdValues.put(l, null);
                }
            } else {
                view.setHasTransientState(true);
                transitionValuesMaps.mItemIdValues.put(l, view);
            }
        }
    }

    private static boolean alreadyContains(int[] nArray, int n) {
        int n2 = nArray[n];
        for (int i = 0; i < n; ++i) {
            if (nArray[i] != n2) continue;
            return true;
        }
        return false;
    }

    private void captureHierarchy(View view, boolean bl) {
        int n;
        int n2;
        if (view == null) {
            return;
        }
        int n3 = view.getId();
        if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(n3)) {
            return;
        }
        if (this.mTargetExcludes != null && this.mTargetExcludes.contains(view)) {
            return;
        }
        if (this.mTargetTypeExcludes != null) {
            n2 = this.mTargetTypeExcludes.size();
            for (n = 0; n < n2; ++n) {
                if (!this.mTargetTypeExcludes.get(n).isInstance(view)) continue;
                return;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            TransitionValues transitionValues = new TransitionValues(view);
            if (bl) {
                this.captureStartValues(transitionValues);
            } else {
                this.captureEndValues(transitionValues);
            }
            transitionValues.mTargetedTransitions.add(this);
            this.capturePropagationValues(transitionValues);
            if (bl) {
                Transition.addViewValues(this.mStartValues, view, transitionValues);
            } else {
                Transition.addViewValues(this.mEndValues, view, transitionValues);
            }
        }
        if (view instanceof ViewGroup) {
            if (this.mTargetIdChildExcludes != null && this.mTargetIdChildExcludes.contains(n3)) {
                return;
            }
            if (this.mTargetChildExcludes != null && this.mTargetChildExcludes.contains(view)) {
                return;
            }
            if (this.mTargetTypeChildExcludes != null) {
                n2 = this.mTargetTypeChildExcludes.size();
                for (n = 0; n < n2; ++n) {
                    if (!this.mTargetTypeChildExcludes.get(n).isInstance(view)) continue;
                    return;
                }
            }
            view = (ViewGroup)view;
            for (n = 0; n < view.getChildCount(); ++n) {
                this.captureHierarchy(view.getChildAt(n), bl);
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int n, boolean bl) {
        ArrayList<Integer> arrayList2 = arrayList;
        if (n > 0) {
            arrayList2 = bl ? ArrayListManager.add(arrayList, n) : ArrayListManager.remove(arrayList, n);
        }
        return arrayList2;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean bl) {
        ArrayList<T> arrayList2 = arrayList;
        if (t != null) {
            arrayList2 = bl ? ArrayListManager.add(arrayList, t) : ArrayListManager.remove(arrayList, t);
        }
        return arrayList2;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> clazz, boolean bl) {
        ArrayList<Class<?>> arrayList2 = arrayList;
        if (clazz != null) {
            arrayList2 = bl ? ArrayListManager.add(arrayList, clazz) : ArrayListManager.remove(arrayList, clazz);
        }
        return arrayList2;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean bl) {
        ArrayList<View> arrayList2 = arrayList;
        if (view != null) {
            arrayList2 = bl ? ArrayListManager.add(arrayList, view) : ArrayListManager.remove(arrayList, view);
        }
        return arrayList2;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> arrayMap;
        ArrayMap<Object, AnimationInfo> arrayMap2 = arrayMap = sRunningAnimators.get();
        if (arrayMap == null) {
            arrayMap2 = new ArrayMap();
            sRunningAnimators.set(arrayMap2);
        }
        return arrayMap2;
    }

    private static boolean isValidMatch(int n) {
        boolean bl = true;
        if (n < 1 || n > 4) {
            bl = false;
        }
        return bl;
    }

    private static boolean isValueChanged(TransitionValues object, TransitionValues object2, String string2) {
        object = ((TransitionValues)object).values.get(string2);
        object2 = ((TransitionValues)object2).values.get(string2);
        boolean bl = object == null && object2 == null ? false : (object != null && object2 != null ? object.equals(object2) ^ true : true);
        return bl;
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        int n = sparseArray.size();
        for (int i = 0; i < n; ++i) {
            View view;
            View view2 = (View)sparseArray.valueAt(i);
            if (view2 == null || !this.isValidTarget(view2) || (view = (View)sparseArray2.get(sparseArray.keyAt(i))) == null || !this.isValidTarget(view)) continue;
            TransitionValues transitionValues = (TransitionValues)arrayMap.get(view2);
            TransitionValues transitionValues2 = (TransitionValues)arrayMap2.get(view);
            if (transitionValues == null || transitionValues2 == null) continue;
            this.mStartValuesList.add(transitionValues);
            this.mEndValuesList.add(transitionValues2);
            arrayMap.remove(view2);
            arrayMap2.remove(view);
        }
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i = arrayMap.size() - 1; i >= 0; --i) {
            TransitionValues transitionValues;
            Object object = (View)arrayMap.keyAt(i);
            if (object == null || !this.isValidTarget((View)object) || (transitionValues = (TransitionValues)arrayMap2.remove(object)) == null || !this.isValidTarget(transitionValues.view)) continue;
            object = (TransitionValues)arrayMap.removeAt(i);
            this.mStartValuesList.add((TransitionValues)object);
            this.mEndValuesList.add(transitionValues);
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        int n = longSparseArray.size();
        for (int i = 0; i < n; ++i) {
            View view;
            View view2 = longSparseArray.valueAt(i);
            if (view2 == null || !this.isValidTarget(view2) || (view = longSparseArray2.get(longSparseArray.keyAt(i))) == null || !this.isValidTarget(view)) continue;
            TransitionValues transitionValues = (TransitionValues)arrayMap.get(view2);
            TransitionValues transitionValues2 = (TransitionValues)arrayMap2.get(view);
            if (transitionValues == null || transitionValues2 == null) continue;
            this.mStartValuesList.add(transitionValues);
            this.mEndValuesList.add(transitionValues2);
            arrayMap.remove(view2);
            arrayMap2.remove(view);
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        int n = arrayMap3.size();
        for (int i = 0; i < n; ++i) {
            View view;
            View view2 = (View)arrayMap3.valueAt(i);
            if (view2 == null || !this.isValidTarget(view2) || (view = (View)arrayMap4.get(arrayMap3.keyAt(i))) == null || !this.isValidTarget(view)) continue;
            TransitionValues transitionValues = (TransitionValues)arrayMap.get(view2);
            TransitionValues transitionValues2 = (TransitionValues)arrayMap2.get(view);
            if (transitionValues == null || transitionValues2 == null) continue;
            this.mStartValuesList.add(transitionValues);
            this.mEndValuesList.add(transitionValues2);
            arrayMap.remove(view2);
            arrayMap2.remove(view);
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<View, TransitionValues>(transitionValuesMaps.mViewValues);
        ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap<View, TransitionValues>(transitionValuesMaps2.mViewValues);
        block6: for (int i = 0; i < this.mMatchOrder.length; ++i) {
            switch (this.mMatchOrder[i]) {
                default: {
                    continue block6;
                }
                case 4: {
                    this.matchItemIds(arrayMap, arrayMap2, transitionValuesMaps.mItemIdValues, transitionValuesMaps2.mItemIdValues);
                    continue block6;
                }
                case 3: {
                    this.matchIds(arrayMap, arrayMap2, transitionValuesMaps.mIdValues, transitionValuesMaps2.mIdValues);
                    continue block6;
                }
                case 2: {
                    this.matchNames(arrayMap, arrayMap2, transitionValuesMaps.mNameValues, transitionValuesMaps2.mNameValues);
                    continue block6;
                }
                case 1: {
                    this.matchInstances(arrayMap, arrayMap2);
                }
            }
        }
        this.addUnmatched(arrayMap, arrayMap2);
    }

    private void notifyFromTransition(Transition transition, TransitionNotification transitionNotification, boolean bl) {
        if (this.mCloneParent != null) {
            this.mCloneParent.notifyFromTransition(transition, transitionNotification, bl);
        }
        if (this.mListeners != null && !this.mListeners.isEmpty()) {
            int n = this.mListeners.size();
            TransitionListener[] transitionListenerArray = this.mListenersCache == null ? new TransitionListener[n] : this.mListenersCache;
            this.mListenersCache = null;
            transitionListenerArray = this.mListeners.toArray(transitionListenerArray);
            for (int i = 0; i < n; ++i) {
                transitionNotification.notifyListener(transitionListenerArray[i], transition, bl);
                transitionListenerArray[i] = null;
            }
            this.mListenersCache = transitionListenerArray;
        }
    }

    private static int[] parseMatchOrder(String object) {
        StringTokenizer stringTokenizer = new StringTokenizer((String)object, ",");
        object = new int[stringTokenizer.countTokens()];
        int n = 0;
        while (stringTokenizer.hasMoreTokens()) {
            Object object2;
            block8: {
                block4: {
                    block7: {
                        block6: {
                            block5: {
                                block3: {
                                    object2 = stringTokenizer.nextToken().trim();
                                    if (!MATCH_ID_STR.equalsIgnoreCase((String)object2)) break block3;
                                    object[n] = 3;
                                    break block4;
                                }
                                if (!MATCH_INSTANCE_STR.equalsIgnoreCase((String)object2)) break block5;
                                object[n] = true;
                                break block4;
                            }
                            if (!MATCH_NAME_STR.equalsIgnoreCase((String)object2)) break block6;
                            object[n] = 2;
                            break block4;
                        }
                        if (!MATCH_ITEM_ID_STR.equalsIgnoreCase((String)object2)) break block7;
                        object[n] = 4;
                        break block4;
                    }
                    if (!((String)object2).isEmpty()) break block8;
                    object2 = new int[((Object)object).length - 1];
                    System.arraycopy(object, 0, object2, 0, n);
                    object = object2;
                    --n;
                }
                ++n;
                continue;
            }
            throw new InflateException("Unknown match type in matchOrder: '" + (String)object2 + "'");
        }
        return object;
    }

    private void runAnimator(Animator animator2, ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator2 != null) {
            animator2.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, arrayMap){
                final Transition this$0;
                final ArrayMap val$runningAnimators;
                {
                    this.this$0 = transition;
                    this.val$runningAnimators = arrayMap;
                }

                public void onAnimationEnd(Animator animator2) {
                    this.val$runningAnimators.remove(animator2);
                    this.this$0.mCurrentAnimators.remove(animator2);
                }

                public void onAnimationStart(Animator animator2) {
                    this.this$0.mCurrentAnimators.add(animator2);
                }
            });
            this.animate(animator2);
        }
    }

    public Transition addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    public Transition addTarget(int n) {
        if (n != 0) {
            this.mTargetIds.add(n);
        }
        return this;
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public Transition addTarget(Class<?> clazz) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList();
        }
        this.mTargetTypes.add(clazz);
        return this;
    }

    public Transition addTarget(String string2) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList();
        }
        this.mTargetNames.add(string2);
        return this;
    }

    protected void animate(Animator animator2) {
        if (animator2 == null) {
            this.end();
        } else {
            if (this.getDuration() >= 0L) {
                animator2.setDuration(this.getDuration());
            }
            if (this.getStartDelay() >= 0L) {
                animator2.setStartDelay(this.getStartDelay() + animator2.getStartDelay());
            }
            if (this.getInterpolator() != null) {
                animator2.setInterpolator(this.getInterpolator());
            }
            animator2.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this){
                final Transition this$0;
                {
                    this.this$0 = transition;
                }

                public void onAnimationEnd(Animator animator2) {
                    this.this$0.end();
                    animator2.removeListener((Animator.AnimatorListener)this);
                }
            });
            animator2.start();
        }
    }

    protected void cancel() {
        int n = this.mCurrentAnimators.size();
        Animator[] animatorArray = this.mCurrentAnimators.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        --n;
        while (n >= 0) {
            Animator animator2 = animatorArray[n];
            animatorArray[n] = null;
            animator2.cancel();
            --n;
        }
        this.mAnimatorCache = animatorArray;
        this.notifyListeners(TransitionNotification.ON_CANCEL, false);
    }

    public abstract void captureEndValues(TransitionValues var1);

    void capturePropagationValues(TransitionValues transitionValues) {
        if (this.mPropagation != null && !transitionValues.values.isEmpty()) {
            boolean bl;
            String[] stringArray = this.mPropagation.getPropagationProperties();
            if (stringArray == null) {
                return;
            }
            boolean bl2 = true;
            int n = 0;
            while (true) {
                bl = bl2;
                if (n >= stringArray.length) break;
                if (!transitionValues.values.containsKey(stringArray[n])) {
                    bl = false;
                    break;
                }
                ++n;
            }
            if (!bl) {
                this.mPropagation.captureValues(transitionValues);
            }
        }
    }

    public abstract void captureStartValues(TransitionValues var1);

    void captureValues(ViewGroup object, boolean bl) {
        Object object2;
        Object object3;
        int n;
        this.clearValues(bl);
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0 || this.mTargetNames != null && !this.mTargetNames.isEmpty() || this.mTargetTypes != null && !this.mTargetTypes.isEmpty()) {
            this.captureHierarchy((View)object, bl);
        } else {
            for (n = 0; n < this.mTargetIds.size(); ++n) {
                object3 = object.findViewById(this.mTargetIds.get(n).intValue());
                if (object3 == null) continue;
                object2 = new TransitionValues((View)object3);
                if (bl) {
                    this.captureStartValues((TransitionValues)object2);
                } else {
                    this.captureEndValues((TransitionValues)object2);
                }
                ((TransitionValues)object2).mTargetedTransitions.add(this);
                this.capturePropagationValues((TransitionValues)object2);
                if (bl) {
                    Transition.addViewValues(this.mStartValues, object3, (TransitionValues)object2);
                    continue;
                }
                Transition.addViewValues(this.mEndValues, object3, (TransitionValues)object2);
            }
            for (n = 0; n < this.mTargets.size(); ++n) {
                object3 = this.mTargets.get(n);
                object = new TransitionValues((View)object3);
                if (bl) {
                    this.captureStartValues((TransitionValues)object);
                } else {
                    this.captureEndValues((TransitionValues)object);
                }
                ((TransitionValues)object).mTargetedTransitions.add(this);
                this.capturePropagationValues((TransitionValues)object);
                if (bl) {
                    Transition.addViewValues(this.mStartValues, object3, (TransitionValues)object);
                    continue;
                }
                Transition.addViewValues(this.mEndValues, object3, (TransitionValues)object);
            }
        }
        if (!bl && this.mNameOverrides != null) {
            int n2 = this.mNameOverrides.size();
            object = new ArrayList(n2);
            for (n = 0; n < n2; ++n) {
                object3 = (String)this.mNameOverrides.keyAt(n);
                ((ArrayList)object).add((View)this.mStartValues.mNameValues.remove(object3));
            }
            for (n = 0; n < n2; ++n) {
                object3 = (View)((ArrayList)object).get(n);
                if (object3 == null) continue;
                object2 = (String)this.mNameOverrides.valueAt(n);
                this.mStartValues.mNameValues.put((String)object2, (View)object3);
            }
        }
    }

    void clearValues(boolean bl) {
        if (bl) {
            this.mStartValues.mViewValues.clear();
            this.mStartValues.mIdValues.clear();
            this.mStartValues.mItemIdValues.clear();
        } else {
            this.mEndValues.mViewValues.clear();
            this.mEndValues.mIdValues.clear();
            this.mEndValues.mItemIdValues.clear();
        }
    }

    public Transition clone() {
        try {
            Transition transition = (Transition)super.clone();
            Object object = new ArrayList();
            transition.mAnimators = object;
            transition.mStartValues = object = new TransitionValuesMaps();
            transition.mEndValues = object = new TransitionValuesMaps();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            transition.mSeekController = null;
            transition.mCloneParent = this;
            transition.mListeners = null;
            return transition;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    void createAnimators(ViewGroup object, TransitionValuesMaps object2, TransitionValuesMaps transitionValuesMaps, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long l;
        ArrayMap<Animator, AnimationInfo> arrayMap = Transition.getRunningAnimators();
        long l2 = Long.MAX_VALUE;
        SparseIntArray sparseIntArray = new SparseIntArray();
        int n = arrayList.size();
        int n2 = this.getRootTransition().mSeekController != null ? 1 : 0;
        int n3 = n2;
        n2 = 0;
        while (n2 < n) {
            int n4;
            Object object3 = arrayList.get(n2);
            object2 = arrayList2.get(n2);
            if (object3 != null && !((TransitionValues)object3).mTargetedTransitions.contains(this)) {
                object3 = null;
            }
            Object object4 = object2;
            if (object2 != null) {
                object4 = object2;
                if (!((TransitionValues)object2).mTargetedTransitions.contains(this)) {
                    object4 = null;
                }
            }
            if (object3 == null && object4 == null) {
                n4 = n3;
                n3 = n2;
                n2 = n4;
            } else {
                n4 = object3 != null && object4 != null && !this.isTransitionRequired((TransitionValues)object3, (TransitionValues)object4) ? 0 : 1;
                if (n4 != 0) {
                    object2 = this.createAnimator((ViewGroup)object, (TransitionValues)object3, (TransitionValues)object4);
                    if (object2 != null) {
                        Object object5;
                        View view = null;
                        Object object6 = null;
                        if (object4 != null) {
                            block23: {
                                view = ((TransitionValues)object4).view;
                                String[] stringArray = this.getTransitionProperties();
                                if (stringArray != null && stringArray.length > 0) {
                                    object5 = new TransitionValues(view);
                                    object6 = (TransitionValues)transitionValuesMaps.mViewValues.get(view);
                                    if (object6 != null) {
                                        for (n4 = 0; n4 < stringArray.length; ++n4) {
                                            ((TransitionValues)object5).values.put(stringArray[n4], object6.values.get(stringArray[n4]));
                                        }
                                        n4 = n3;
                                        n3 = n2;
                                        n2 = n4;
                                    } else {
                                        n4 = n2;
                                        n2 = n3;
                                        n3 = n4;
                                    }
                                    int n5 = arrayMap.size();
                                    for (n4 = 0; n4 < n5; ++n4) {
                                        object6 = (AnimationInfo)arrayMap.get((Animator)arrayMap.keyAt(n4));
                                        if (object6.mValues == null || object6.mView != view || !object6.mName.equals(this.getName()) || !object6.mValues.equals(object5)) continue;
                                        object2 = object5;
                                        object5 = null;
                                        break block23;
                                    }
                                    object6 = object5;
                                    object5 = object2;
                                    object2 = object6;
                                } else {
                                    n4 = n2;
                                    object5 = object2;
                                    n2 = n3;
                                    n3 = n4;
                                    object2 = object6;
                                }
                            }
                            object6 = view;
                        } else {
                            n4 = n2;
                            object6 = ((TransitionValues)object3).view;
                            object5 = object2;
                            n2 = n3;
                            n3 = n4;
                            object2 = view;
                        }
                        if (object5 != null) {
                            if (this.mPropagation != null) {
                                l = this.mPropagation.getStartDelay((ViewGroup)object, this, (TransitionValues)object3, (TransitionValues)object4);
                                sparseIntArray.put(this.mAnimators.size(), (int)l);
                                l2 = Math.min(l, l2);
                            }
                            object3 = new AnimationInfo((View)object6, this.getName(), this, object.getWindowId(), (TransitionValues)object2, (Animator)object5);
                            object2 = object5;
                            if (n2 != 0) {
                                object2 = new AnimatorSet();
                                object2.play((Animator)object5);
                            }
                            arrayMap.put((Animator)object2, (AnimationInfo)object3);
                            this.mAnimators.add((Animator)object2);
                        }
                    } else {
                        n4 = n3;
                        n3 = n2;
                        n2 = n4;
                    }
                } else {
                    n4 = n2;
                    n2 = n3;
                    n3 = n4;
                }
            }
            n4 = n3 + 1;
            n3 = n2;
            n2 = n4;
        }
        if (sparseIntArray.size() != 0) {
            for (n2 = 0; n2 < sparseIntArray.size(); ++n2) {
                n3 = sparseIntArray.keyAt(n2);
                object = (AnimationInfo)arrayMap.get(this.mAnimators.get(n3));
                long l3 = sparseIntArray.valueAt(n2);
                l = object.mAnimator.getStartDelay();
                object.mAnimator.setStartDelay(l3 - l2 + l);
            }
        }
    }

    TransitionSeekController createSeekController() {
        this.mSeekController = new SeekController(this);
        this.addListener(this.mSeekController);
        return this.mSeekController;
    }

    protected void end() {
        --this.mNumInstances;
        if (this.mNumInstances == 0) {
            View view;
            int n;
            this.notifyListeners(TransitionNotification.ON_END, false);
            for (n = 0; n < this.mStartValues.mItemIdValues.size(); ++n) {
                view = this.mStartValues.mItemIdValues.valueAt(n);
                if (view == null) continue;
                view.setHasTransientState(false);
            }
            for (n = 0; n < this.mEndValues.mItemIdValues.size(); ++n) {
                view = this.mEndValues.mItemIdValues.valueAt(n);
                if (view == null) continue;
                view.setHasTransientState(false);
            }
            this.mEnded = true;
        }
    }

    public Transition excludeChildren(int n, boolean bl) {
        this.mTargetIdChildExcludes = this.excludeId(this.mTargetIdChildExcludes, n, bl);
        return this;
    }

    public Transition excludeChildren(View view, boolean bl) {
        this.mTargetChildExcludes = this.excludeView(this.mTargetChildExcludes, view, bl);
        return this;
    }

    public Transition excludeChildren(Class<?> clazz, boolean bl) {
        this.mTargetTypeChildExcludes = this.excludeType(this.mTargetTypeChildExcludes, clazz, bl);
        return this;
    }

    public Transition excludeTarget(int n, boolean bl) {
        this.mTargetIdExcludes = this.excludeId(this.mTargetIdExcludes, n, bl);
        return this;
    }

    public Transition excludeTarget(View view, boolean bl) {
        this.mTargetExcludes = this.excludeView(this.mTargetExcludes, view, bl);
        return this;
    }

    public Transition excludeTarget(Class<?> clazz, boolean bl) {
        this.mTargetTypeExcludes = this.excludeType(this.mTargetTypeExcludes, clazz, bl);
        return this;
    }

    public Transition excludeTarget(String string2, boolean bl) {
        this.mTargetNameExcludes = Transition.excludeObject(this.mTargetNameExcludes, string2, bl);
        return this;
    }

    void forceToEnd(ViewGroup viewGroup) {
        Object object = Transition.getRunningAnimators();
        int n = ((SimpleArrayMap)object).size();
        if (viewGroup != null && n != 0) {
            viewGroup = viewGroup.getWindowId();
            ArrayMap arrayMap = new ArrayMap((SimpleArrayMap)object);
            ((SimpleArrayMap)object).clear();
            --n;
            while (n >= 0) {
                object = (AnimationInfo)arrayMap.valueAt(n);
                if (((AnimationInfo)object).mView != null && viewGroup.equals((Object)((AnimationInfo)object).mWindowId)) {
                    ((Animator)arrayMap.keyAt(n)).end();
                }
                --n;
            }
            return;
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        if (this.mEpicenterCallback == null) {
            return null;
        }
        return this.mEpicenterCallback.onGetEpicenter(this);
    }

    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    TransitionValues getMatchedTransitionValues(View object, boolean bl) {
        int n;
        if (this.mParent != null) {
            return this.mParent.getMatchedTransitionValues((View)object, bl);
        }
        ArrayList<TransitionValues> arrayList = bl ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int n2 = arrayList.size();
        int n3 = -1;
        int n4 = 0;
        while (true) {
            n = n3;
            if (n4 >= n2) break;
            TransitionValues transitionValues = arrayList.get(n4);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.view == object) {
                n = n4;
                break;
            }
            ++n4;
        }
        object = null;
        if (n >= 0) {
            object = bl ? this.mEndValuesList : this.mStartValuesList;
            object = (TransitionValues)((ArrayList)object).get(n);
        }
        return object;
    }

    public String getName() {
        return this.mName;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public final Transition getRootTransition() {
        if (this.mParent != null) {
            return this.mParent.getRootTransition();
        }
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    final long getTotalDurationMillis() {
        return this.mTotalDuration;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public TransitionValues getTransitionValues(View view, boolean bl) {
        if (this.mParent != null) {
            return this.mParent.getTransitionValues(view, bl);
        }
        TransitionValuesMaps transitionValuesMaps = bl ? this.mStartValues : this.mEndValues;
        return (TransitionValues)transitionValuesMaps.mViewValues.get(view);
    }

    boolean hasAnimators() {
        return this.mCurrentAnimators.isEmpty() ^ true;
    }

    public boolean isSeekingSupported() {
        return false;
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        boolean bl;
        block5: {
            boolean bl2 = false;
            boolean bl3 = false;
            bl = bl2;
            if (transitionValues == null) break block5;
            bl = bl2;
            if (transitionValues2 != null) {
                Object object = this.getTransitionProperties();
                if (object != null) {
                    int n = ((String[])object).length;
                    int n2 = 0;
                    while (true) {
                        bl = bl3;
                        if (n2 >= n) break block5;
                        if (Transition.isValueChanged(transitionValues, transitionValues2, (String)object[n2])) {
                            bl = true;
                            break block5;
                        }
                        ++n2;
                    }
                }
                object = transitionValues.values.keySet().iterator();
                do {
                    bl = bl2;
                    if (!object.hasNext()) break block5;
                } while (!Transition.isValueChanged(transitionValues, transitionValues2, (String)object.next()));
                bl = true;
            }
        }
        return bl;
    }

    boolean isValidTarget(View view) {
        int n;
        int n2 = view.getId();
        if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(n2)) {
            return false;
        }
        if (this.mTargetExcludes != null && this.mTargetExcludes.contains(view)) {
            return false;
        }
        if (this.mTargetTypeExcludes != null) {
            int n3 = this.mTargetTypeExcludes.size();
            for (n = 0; n < n3; ++n) {
                if (!this.mTargetTypeExcludes.get(n).isInstance(view)) continue;
                return false;
            }
        }
        if (this.mTargetNameExcludes != null && ViewCompat.getTransitionName(view) != null && this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(view))) {
            return false;
        }
        if (this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (this.mTargetTypes == null || this.mTargetTypes.isEmpty()) && (this.mTargetNames == null || this.mTargetNames.isEmpty())) {
            return true;
        }
        if (!this.mTargetIds.contains(n2) && !this.mTargets.contains(view)) {
            if (this.mTargetNames != null && this.mTargetNames.contains(ViewCompat.getTransitionName(view))) {
                return true;
            }
            if (this.mTargetTypes != null) {
                for (n = 0; n < this.mTargetTypes.size(); ++n) {
                    if (!this.mTargetTypes.get(n).isInstance(view)) continue;
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    void notifyListeners(TransitionNotification transitionNotification, boolean bl) {
        this.notifyFromTransition(this, transitionNotification, bl);
    }

    public void pause(View animatorArray) {
        if (!this.mEnded) {
            int n = this.mCurrentAnimators.size();
            animatorArray = this.mCurrentAnimators.toArray(this.mAnimatorCache);
            this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
            --n;
            while (n >= 0) {
                Animator animator2 = animatorArray[n];
                animatorArray[n] = null;
                animator2.pause();
                --n;
            }
            this.mAnimatorCache = animatorArray;
            this.notifyListeners(TransitionNotification.ON_PAUSE, false);
            this.mPaused = true;
        }
    }

    void playTransition(ViewGroup viewGroup) {
        this.mStartValuesList = new ArrayList();
        this.mEndValuesList = new ArrayList();
        this.matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> arrayMap = Transition.getRunningAnimators();
        int n = arrayMap.size();
        WindowId windowId = viewGroup.getWindowId();
        --n;
        while (n >= 0) {
            AnimationInfo animationInfo;
            Animator animator2 = (Animator)arrayMap.keyAt(n);
            if (animator2 != null && (animationInfo = (AnimationInfo)arrayMap.get(animator2)) != null && animationInfo.mView != null && windowId.equals((Object)animationInfo.mWindowId)) {
                boolean bl;
                TransitionValues transitionValues = animationInfo.mValues;
                View view = animationInfo.mView;
                TransitionValues transitionValues2 = this.getTransitionValues(view, true);
                TransitionValues transitionValues3 = this.getMatchedTransitionValues(view, true);
                Object object = transitionValues3;
                if (transitionValues2 == null) {
                    object = transitionValues3;
                    if (transitionValues3 == null) {
                        object = (TransitionValues)this.mEndValues.mViewValues.get(view);
                    }
                }
                if (bl = (transitionValues2 != null || object != null) && animationInfo.mTransition.isTransitionRequired(transitionValues, (TransitionValues)object)) {
                    object = animationInfo.mTransition;
                    if (((Transition)object).getRootTransition().mSeekController != null) {
                        animator2.cancel();
                        ((Transition)object).mCurrentAnimators.remove(animator2);
                        arrayMap.remove(animator2);
                        if (((Transition)object).mCurrentAnimators.size() == 0) {
                            ((Transition)object).notifyListeners(TransitionNotification.ON_CANCEL, false);
                            if (!((Transition)object).mEnded) {
                                ((Transition)object).mEnded = true;
                                ((Transition)object).notifyListeners(TransitionNotification.ON_END, false);
                            }
                        }
                    } else if (!animator2.isRunning() && !animator2.isStarted()) {
                        arrayMap.remove(animator2);
                    } else {
                        animator2.cancel();
                    }
                }
            }
            --n;
        }
        this.createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        if (this.mSeekController == null) {
            this.runAnimators();
        } else if (Build.VERSION.SDK_INT >= 34) {
            this.prepareAnimatorsForSeeking();
            this.mSeekController.initPlayTime();
            this.mSeekController.ready();
        }
    }

    void prepareAnimatorsForSeeking() {
        ArrayMap<Animator, AnimationInfo> arrayMap = Transition.getRunningAnimators();
        this.mTotalDuration = 0L;
        for (int i = 0; i < this.mAnimators.size(); ++i) {
            Animator animator2 = this.mAnimators.get(i);
            AnimationInfo animationInfo = (AnimationInfo)arrayMap.get(animator2);
            if (animator2 == null || animationInfo == null) continue;
            if (this.getDuration() >= 0L) {
                animationInfo.mAnimator.setDuration(this.getDuration());
            }
            if (this.getStartDelay() >= 0L) {
                animationInfo.mAnimator.setStartDelay(this.getStartDelay() + animationInfo.mAnimator.getStartDelay());
            }
            if (this.getInterpolator() != null) {
                animationInfo.mAnimator.setInterpolator(this.getInterpolator());
            }
            this.mCurrentAnimators.add(animator2);
            this.mTotalDuration = Math.max(this.mTotalDuration, Impl26.getTotalDuration(animator2));
        }
        this.mAnimators.clear();
    }

    public Transition removeListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            return this;
        }
        if (!this.mListeners.remove(transitionListener) && this.mCloneParent != null) {
            this.mCloneParent.removeListener(transitionListener);
        }
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public Transition removeTarget(int n) {
        if (n != 0) {
            this.mTargetIds.remove((Object)n);
        }
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public Transition removeTarget(Class<?> clazz) {
        if (this.mTargetTypes != null) {
            this.mTargetTypes.remove(clazz);
        }
        return this;
    }

    public Transition removeTarget(String string2) {
        if (this.mTargetNames != null) {
            this.mTargetNames.remove(string2);
        }
        return this;
    }

    public void resume(View animatorArray) {
        if (this.mPaused) {
            if (!this.mEnded) {
                int n = this.mCurrentAnimators.size();
                animatorArray = this.mCurrentAnimators.toArray(this.mAnimatorCache);
                this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
                --n;
                while (n >= 0) {
                    Animator animator2 = animatorArray[n];
                    animatorArray[n] = null;
                    animator2.resume();
                    --n;
                }
                this.mAnimatorCache = animatorArray;
                this.notifyListeners(TransitionNotification.ON_RESUME, false);
            }
            this.mPaused = false;
        }
    }

    protected void runAnimators() {
        this.start();
        ArrayMap<Animator, AnimationInfo> arrayMap = Transition.getRunningAnimators();
        for (Animator animator2 : this.mAnimators) {
            if (!arrayMap.containsKey(animator2)) continue;
            this.start();
            this.runAnimator(animator2, arrayMap);
        }
        this.mAnimators.clear();
        this.end();
    }

    void setCanRemoveViews(boolean bl) {
        this.mCanRemoveViews = bl;
    }

    void setCurrentPlayTimeMillis(long l, long l2) {
        block3: {
            long l3 = this.getTotalDurationMillis();
            boolean bl = l < l2;
            if (l2 < 0L && l >= 0L || l2 > l3 && l <= l3) {
                this.mEnded = false;
                this.notifyListeners(TransitionNotification.ON_START, bl);
            }
            int n = this.mCurrentAnimators.size();
            Animator[] animatorArray = this.mCurrentAnimators.toArray(this.mAnimatorCache);
            this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
            for (int i = 0; i < n; ++i) {
                Animator animator2 = animatorArray[i];
                animatorArray[i] = null;
                long l4 = Impl26.getTotalDuration(animator2);
                Impl26.setCurrentPlayTime(animator2, Math.min(Math.max(0L, l), l4));
            }
            this.mAnimatorCache = animatorArray;
            if ((l <= l3 || l2 > l3) && (l >= 0L || l2 < 0L)) break block3;
            if (l > l3) {
                this.mEnded = true;
            }
            this.notifyListeners(TransitionNotification.ON_END, bl);
        }
    }

    public Transition setDuration(long l) {
        this.mDuration = l;
        return this;
    }

    public void setEpicenterCallback(EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int ... nArray) {
        if (nArray != null && nArray.length != 0) {
            for (int i = 0; i < nArray.length; ++i) {
                if (Transition.isValidMatch(nArray[i])) {
                    if (!Transition.alreadyContains(nArray, i)) {
                        continue;
                    }
                    throw new IllegalArgumentException("matches contains a duplicate value");
                }
                throw new IllegalArgumentException("matches contains invalid value");
            }
            this.mMatchOrder = (int[])nArray.clone();
        } else {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
        }
    }

    public void setPathMotion(PathMotion pathMotion) {
        this.mPathMotion = pathMotion == null ? STRAIGHT_PATH_MOTION : pathMotion;
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    public Transition setStartDelay(long l) {
        this.mStartDelay = l;
        return this;
    }

    protected void start() {
        if (this.mNumInstances == 0) {
            this.notifyListeners(TransitionNotification.ON_START, false);
            this.mEnded = false;
        }
        ++this.mNumInstances;
    }

    public String toString() {
        return this.toString("");
    }

    String toString(String charSequence) {
        charSequence = new StringBuilder((String)charSequence).append(this.getClass().getSimpleName()).append("@").append(Integer.toHexString(this.hashCode())).append(": ");
        if (this.mDuration != -1L) {
            ((StringBuilder)charSequence).append("dur(").append(this.mDuration).append(") ");
        }
        if (this.mStartDelay != -1L) {
            ((StringBuilder)charSequence).append("dly(").append(this.mStartDelay).append(") ");
        }
        if (this.mInterpolator != null) {
            ((StringBuilder)charSequence).append("interp(").append(this.mInterpolator).append(") ");
        }
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            int n;
            ((StringBuilder)charSequence).append("tgts(");
            if (this.mTargetIds.size() > 0) {
                for (n = 0; n < this.mTargetIds.size(); ++n) {
                    if (n > 0) {
                        ((StringBuilder)charSequence).append(", ");
                    }
                    ((StringBuilder)charSequence).append(this.mTargetIds.get(n));
                }
            }
            if (this.mTargets.size() > 0) {
                for (n = 0; n < this.mTargets.size(); ++n) {
                    if (n > 0) {
                        ((StringBuilder)charSequence).append(", ");
                    }
                    ((StringBuilder)charSequence).append(this.mTargets.get(n));
                }
            }
            ((StringBuilder)charSequence).append(")");
        }
        return ((StringBuilder)charSequence).toString();
    }

    private static class AnimationInfo {
        Animator mAnimator;
        String mName;
        Transition mTransition;
        TransitionValues mValues;
        View mView;
        WindowId mWindowId;

        AnimationInfo(View view, String string2, Transition transition, WindowId windowId, TransitionValues transitionValues, Animator animator2) {
            this.mView = view;
            this.mName = string2;
            this.mValues = transitionValues;
            this.mWindowId = windowId;
            this.mTransition = transition;
            this.mAnimator = animator2;
        }
    }

    private static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> add(ArrayList<T> arrayList, T t) {
            ArrayList<Object> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList();
            }
            if (!arrayList2.contains(t)) {
                arrayList2.add(t);
            }
            return arrayList2;
        }

        static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t) {
            ArrayList<T> arrayList2 = arrayList;
            if (arrayList != null) {
                arrayList.remove(t);
                arrayList2 = arrayList;
                if (arrayList.isEmpty()) {
                    arrayList2 = null;
                }
            }
            return arrayList2;
        }
    }

    public static abstract class EpicenterCallback {
        public abstract Rect onGetEpicenter(Transition var1);
    }

    private static class Impl26 {
        private Impl26() {
        }

        static long getTotalDuration(Animator animator2) {
            return animator2.getTotalDuration();
        }

        static void setCurrentPlayTime(Animator animator2, long l) {
            ((AnimatorSet)animator2).setCurrentPlayTime(l);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface MatchOrder {
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    class SeekController
    extends TransitionListenerAdapter
    implements TransitionSeekController,
    DynamicAnimation.OnAnimationUpdateListener {
        private long mCurrentPlayTime;
        private boolean mIsCanceled;
        private boolean mIsReady;
        private Consumer<TransitionSeekController>[] mListenerCache;
        private ArrayList<Consumer<TransitionSeekController>> mOnProgressListeners;
        private ArrayList<Consumer<TransitionSeekController>> mOnReadyListeners;
        private Runnable mResetToStartState;
        private SpringAnimation mSpringAnimation;
        private final VelocityTracker1D mVelocityTracker;
        final Transition this$0;

        SeekController(Transition transition) {
            this.this$0 = transition;
            this.mCurrentPlayTime = -1L;
            this.mOnReadyListeners = null;
            this.mOnProgressListeners = null;
            this.mListenerCache = null;
            this.mVelocityTracker = new VelocityTracker1D();
        }

        private void callProgressListeners() {
            if (this.mOnProgressListeners != null && !this.mOnProgressListeners.isEmpty()) {
                int n = this.mOnProgressListeners.size();
                if (this.mListenerCache == null) {
                    this.mListenerCache = new Consumer[n];
                }
                Consumer<TransitionSeekController>[] consumerArray = this.mOnProgressListeners.toArray(this.mListenerCache);
                this.mListenerCache = null;
                for (int i = 0; i < n; ++i) {
                    consumerArray[i].accept(this);
                    consumerArray[i] = null;
                }
                this.mListenerCache = consumerArray;
                return;
            }
        }

        private void ensureAnimation() {
            if (this.mSpringAnimation != null) {
                return;
            }
            this.mVelocityTracker.addDataPoint(AnimationUtils.currentAnimationTimeMillis(), this.mCurrentPlayTime);
            this.mSpringAnimation = new SpringAnimation(new FloatValueHolder());
            SpringForce springForce = new SpringForce();
            springForce.setDampingRatio(1.0f);
            springForce.setStiffness(200.0f);
            this.mSpringAnimation.setSpring(springForce);
            this.mSpringAnimation.setStartValue(this.mCurrentPlayTime);
            this.mSpringAnimation.addUpdateListener(this);
            this.mSpringAnimation.setStartVelocity(this.mVelocityTracker.calculateVelocity());
            this.mSpringAnimation.setMaxValue(this.getDurationMillis() + 1L);
            this.mSpringAnimation.setMinValue(-1.0f);
            this.mSpringAnimation.setMinimumVisibleChange(4.0f);
            this.mSpringAnimation.addEndListener(new Transition$SeekController$$ExternalSyntheticLambda0(this));
        }

        @Override
        public void addOnProgressChangedListener(Consumer<TransitionSeekController> consumer) {
            if (this.mOnProgressListeners == null) {
                this.mOnProgressListeners = new ArrayList();
            }
            this.mOnProgressListeners.add(consumer);
        }

        @Override
        public void addOnReadyListener(Consumer<TransitionSeekController> consumer) {
            if (this.isReady()) {
                consumer.accept(this);
                return;
            }
            if (this.mOnReadyListeners == null) {
                this.mOnReadyListeners = new ArrayList();
            }
            this.mOnReadyListeners.add(consumer);
        }

        @Override
        public void animateToEnd() {
            this.ensureAnimation();
            this.mSpringAnimation.animateToFinalPosition(this.getDurationMillis() + 1L);
        }

        @Override
        public void animateToStart(Runnable runnable2) {
            this.mResetToStartState = runnable2;
            this.ensureAnimation();
            this.mSpringAnimation.animateToFinalPosition(0.0f);
        }

        @Override
        public float getCurrentFraction() {
            return (float)this.getCurrentPlayTimeMillis() / (float)this.getDurationMillis();
        }

        @Override
        public long getCurrentPlayTimeMillis() {
            return Math.min(this.getDurationMillis(), Math.max(0L, this.mCurrentPlayTime));
        }

        @Override
        public long getDurationMillis() {
            return this.this$0.getTotalDurationMillis();
        }

        void initPlayTime() {
            long l = this.getDurationMillis();
            long l2 = 0L;
            if (l == 0L) {
                l2 = 1L;
            }
            this.this$0.setCurrentPlayTimeMillis(l2, this.mCurrentPlayTime);
            this.mCurrentPlayTime = l2;
        }

        @Override
        public boolean isReady() {
            return this.mIsReady;
        }

        /* synthetic */ void lambda$ensureAnimation$0$androidx-transition-Transition$SeekController(DynamicAnimation object, boolean bl, float f, float f2) {
            if (!bl) {
                boolean bl2 = f < 1.0f;
                if (bl2) {
                    long l = this.getDurationMillis();
                    Transition transition = ((TransitionSet)this.this$0).getTransitionAt(0);
                    object = transition.mCloneParent;
                    Transition.access$002(transition, null);
                    this.this$0.setCurrentPlayTimeMillis(-1L, this.mCurrentPlayTime);
                    this.this$0.setCurrentPlayTimeMillis(l, -1L);
                    this.mCurrentPlayTime = l;
                    if (this.mResetToStartState != null) {
                        this.mResetToStartState.run();
                    }
                    this.this$0.mAnimators.clear();
                    if (object != null) {
                        ((Transition)object).notifyListeners(TransitionNotification.ON_END, true);
                    }
                } else {
                    this.this$0.notifyListeners(TransitionNotification.ON_END, false);
                }
            }
        }

        @Override
        public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
            long l = Math.max(-1L, Math.min(this.getDurationMillis() + 1L, Math.round((double)f)));
            this.this$0.setCurrentPlayTimeMillis(l, this.mCurrentPlayTime);
            this.mCurrentPlayTime = l;
            this.callProgressListeners();
        }

        @Override
        public void onTransitionCancel(Transition transition) {
            this.mIsCanceled = true;
        }

        public void ready() {
            this.mIsReady = true;
            if (this.mOnReadyListeners != null) {
                ArrayList<Consumer<TransitionSeekController>> arrayList = this.mOnReadyListeners;
                this.mOnReadyListeners = null;
                for (int i = 0; i < arrayList.size(); ++i) {
                    arrayList.get(i).accept(this);
                }
            }
            this.callProgressListeners();
        }

        @Override
        public void removeOnProgressChangedListener(Consumer<TransitionSeekController> consumer) {
            if (this.mOnProgressListeners != null) {
                this.mOnProgressListeners.remove(consumer);
            }
        }

        @Override
        public void removeOnReadyListener(Consumer<TransitionSeekController> consumer) {
            if (this.mOnReadyListeners != null) {
                this.mOnReadyListeners.remove(consumer);
                if (this.mOnReadyListeners.isEmpty()) {
                    this.mOnReadyListeners = null;
                }
            }
        }

        @Override
        public void setCurrentFraction(float f) {
            if (this.mSpringAnimation == null) {
                this.setCurrentPlayTimeMillis((long)((float)this.getDurationMillis() * f));
                return;
            }
            throw new IllegalStateException("setCurrentFraction() called after animation has been started");
        }

        @Override
        public void setCurrentPlayTimeMillis(long l) {
            if (this.mSpringAnimation == null) {
                if (l != this.mCurrentPlayTime && this.isReady()) {
                    long l2;
                    long l3 = l2 = l;
                    if (!this.mIsCanceled) {
                        if (l2 == 0L && this.mCurrentPlayTime > 0L) {
                            l = -1L;
                        } else {
                            l3 = this.getDurationMillis();
                            l = l2;
                            if (l2 == l3) {
                                l = l2;
                                if (this.mCurrentPlayTime < l3) {
                                    l = 1L + l3;
                                }
                            }
                        }
                        l3 = l;
                        if (l != this.mCurrentPlayTime) {
                            this.this$0.setCurrentPlayTimeMillis(l, this.mCurrentPlayTime);
                            this.mCurrentPlayTime = l;
                            l3 = l;
                        }
                    }
                    this.callProgressListeners();
                    this.mVelocityTracker.addDataPoint(AnimationUtils.currentAnimationTimeMillis(), l3);
                    return;
                }
                return;
            }
            throw new IllegalStateException("setCurrentPlayTimeMillis() called after animation has been started");
        }
    }

    public static interface TransitionListener {
        public void onTransitionCancel(Transition var1);

        public void onTransitionEnd(Transition var1);

        default public void onTransitionEnd(Transition transition, boolean bl) {
            this.onTransitionEnd(transition);
        }

        public void onTransitionPause(Transition var1);

        public void onTransitionResume(Transition var1);

        public void onTransitionStart(Transition var1);

        default public void onTransitionStart(Transition transition, boolean bl) {
            this.onTransitionStart(transition);
        }
    }

    static interface TransitionNotification {
        public static final TransitionNotification ON_CANCEL;
        public static final TransitionNotification ON_END;
        public static final TransitionNotification ON_PAUSE;
        public static final TransitionNotification ON_RESUME;
        public static final TransitionNotification ON_START;

        static {
            ON_START = new Transition$TransitionNotification$$ExternalSyntheticLambda0();
            ON_END = new Transition$TransitionNotification$$ExternalSyntheticLambda1();
            ON_CANCEL = new Transition$TransitionNotification$$ExternalSyntheticLambda2();
            ON_PAUSE = new Transition$TransitionNotification$$ExternalSyntheticLambda3();
            ON_RESUME = new Transition$TransitionNotification$$ExternalSyntheticLambda4();
        }

        public static /* synthetic */ void lambda$static$0(TransitionListener transitionListener, Transition transition, boolean bl) {
            transitionListener.onTransitionCancel(transition);
        }

        public static /* synthetic */ void lambda$static$1(TransitionListener transitionListener, Transition transition, boolean bl) {
            transitionListener.onTransitionPause(transition);
        }

        public static /* synthetic */ void lambda$static$2(TransitionListener transitionListener, Transition transition, boolean bl) {
            transitionListener.onTransitionResume(transition);
        }

        public void notifyListener(TransitionListener var1, Transition var2, boolean var3);
    }
}

