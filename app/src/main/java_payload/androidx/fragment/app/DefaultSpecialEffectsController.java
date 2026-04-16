/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class DefaultSpecialEffectsController
extends SpecialEffectsController {
    DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(List<AnimationInfo> object, List<SpecialEffectsController.Operation> object2, boolean bl, Map<SpecialEffectsController.Operation, Boolean> object3) {
        Object object4 = this.getContainer();
        Context context = object4.getContext();
        Object object5 = new ArrayList();
        Object object6 = object.iterator();
        boolean bl2 = false;
        while (object6.hasNext()) {
            object = object6.next();
            if (((SpecialEffectsInfo)object).isVisibilityUnchanged()) {
                ((SpecialEffectsInfo)object).completeSpecialEffect();
                continue;
            }
            FragmentAnim.AnimationOrAnimator animationOrAnimator = ((AnimationInfo)object).getAnimation(context);
            if (animationOrAnimator == null) {
                ((SpecialEffectsInfo)object).completeSpecialEffect();
                continue;
            }
            animationOrAnimator = animationOrAnimator.animator;
            if (animationOrAnimator == null) {
                ((ArrayList)object5).add(object);
                continue;
            }
            SpecialEffectsController.Operation operation = ((SpecialEffectsInfo)object).getOperation();
            Fragment fragment = operation.getFragment();
            if (Boolean.TRUE.equals(object3.get(operation))) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)"FragmentManager", (String)("Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition."));
                }
                ((SpecialEffectsInfo)object).completeSpecialEffect();
                continue;
            }
            boolean bl3 = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
            if (bl3) {
                object2.remove(operation);
            }
            fragment = fragment.mView;
            object4.startViewTransition((View)fragment);
            animationOrAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, (ViewGroup)object4, (View)fragment, bl3, operation, (AnimationInfo)object){
                final DefaultSpecialEffectsController this$0;
                final AnimationInfo val$animationInfo;
                final ViewGroup val$container;
                final boolean val$isHideOperation;
                final SpecialEffectsController.Operation val$operation;
                final View val$viewToAnimate;
                {
                    this.this$0 = defaultSpecialEffectsController;
                    this.val$container = viewGroup;
                    this.val$viewToAnimate = view;
                    this.val$isHideOperation = bl;
                    this.val$operation = operation;
                    this.val$animationInfo = animationInfo;
                }

                public void onAnimationEnd(Animator animator2) {
                    this.val$container.endViewTransition(this.val$viewToAnimate);
                    if (this.val$isHideOperation) {
                        this.val$operation.getFinalState().applyState(this.val$viewToAnimate);
                    }
                    this.val$animationInfo.completeSpecialEffect();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v((String)"FragmentManager", (String)("Animator from operation " + this.val$operation + " has ended."));
                    }
                }
            });
            animationOrAnimator.setTarget(fragment);
            animationOrAnimator.start();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v((String)"FragmentManager", (String)("Animator from operation " + operation + " has started."));
            }
            ((SpecialEffectsInfo)object).getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener(this, (Animator)animationOrAnimator, operation){
                final DefaultSpecialEffectsController this$0;
                final Animator val$animator;
                final SpecialEffectsController.Operation val$operation;
                {
                    this.this$0 = defaultSpecialEffectsController;
                    this.val$animator = animator2;
                    this.val$operation = operation;
                }

                @Override
                public void onCancel() {
                    this.val$animator.end();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v((String)"FragmentManager", (String)("Animator from operation " + this.val$operation + " has been canceled."));
                    }
                }
            });
            bl2 = true;
        }
        object2 = ((ArrayList)object5).iterator();
        object = object4;
        while (object2.hasNext()) {
            object3 = (AnimationInfo)object2.next();
            object4 = ((SpecialEffectsInfo)object3).getOperation();
            object5 = ((SpecialEffectsController.Operation)object4).getFragment();
            if (bl) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)"FragmentManager", (String)("Ignoring Animation set on " + object5 + " as Animations cannot run alongside Transitions."));
                }
                ((SpecialEffectsInfo)object3).completeSpecialEffect();
                continue;
            }
            if (bl2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)"FragmentManager", (String)("Ignoring Animation set on " + object5 + " as Animations cannot run alongside Animators."));
                }
                ((SpecialEffectsInfo)object3).completeSpecialEffect();
                continue;
            }
            object5 = ((Fragment)object5).mView;
            object6 = Preconditions.checkNotNull(Preconditions.checkNotNull(((AnimationInfo)object3).getAnimation((Context)context)).animation);
            if (((SpecialEffectsController.Operation)object4).getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                object5.startAnimation(object6);
                ((SpecialEffectsInfo)object3).completeSpecialEffect();
            } else {
                object.startViewTransition((View)object5);
                object6 = new FragmentAnim.EndViewTransitionAnimation((Animation)object6, (ViewGroup)object, (View)object5);
                object6.setAnimationListener(new Animation.AnimationListener(this, (SpecialEffectsController.Operation)object4, (ViewGroup)object, (View)object5, (AnimationInfo)object3){
                    final DefaultSpecialEffectsController this$0;
                    final AnimationInfo val$animationInfo;
                    final ViewGroup val$container;
                    final SpecialEffectsController.Operation val$operation;
                    final View val$viewToAnimate;
                    {
                        this.this$0 = defaultSpecialEffectsController;
                        this.val$operation = operation;
                        this.val$container = viewGroup;
                        this.val$viewToAnimate = view;
                        this.val$animationInfo = animationInfo;
                    }

                    public void onAnimationEnd(Animation animation) {
                        this.val$container.post(new Runnable(this){
                            final 4 this$1;
                            {
                                this.this$1 = var1_1;
                            }

                            @Override
                            public void run() {
                                this.this$1.val$container.endViewTransition(this.this$1.val$viewToAnimate);
                                this.this$1.val$animationInfo.completeSpecialEffect();
                            }
                        });
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v((String)"FragmentManager", (String)("Animation from operation " + this.val$operation + " has ended."));
                        }
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v((String)"FragmentManager", (String)("Animation from operation " + this.val$operation + " has reached onAnimationStart."));
                        }
                    }
                });
                object5.startAnimation(object6);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)"FragmentManager", (String)("Animation from operation " + object4 + " has started."));
                }
            }
            ((SpecialEffectsInfo)object3).getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener(this, (View)object5, (ViewGroup)object, (AnimationInfo)object3, (SpecialEffectsController.Operation)object4){
                final DefaultSpecialEffectsController this$0;
                final AnimationInfo val$animationInfo;
                final ViewGroup val$container;
                final SpecialEffectsController.Operation val$operation;
                final View val$viewToAnimate;
                {
                    this.this$0 = defaultSpecialEffectsController;
                    this.val$viewToAnimate = view;
                    this.val$container = viewGroup;
                    this.val$animationInfo = animationInfo;
                    this.val$operation = operation;
                }

                @Override
                public void onCancel() {
                    this.val$viewToAnimate.clearAnimation();
                    this.val$container.endViewTransition(this.val$viewToAnimate);
                    this.val$animationInfo.completeSpecialEffect();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v((String)"FragmentManager", (String)("Animation from operation " + this.val$operation + " has been cancelled."));
                    }
                }
            });
        }
    }

    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(List<TransitionInfo> object, List<SpecialEffectsController.Operation> object2, boolean bl, SpecialEffectsController.Operation operation32, SpecialEffectsController.Operation iterator2) {
        Object object3;
        ArrayList<View> arrayList;
        int n;
        ArrayMap<String, View> arrayMap;
        Object object5;
        Object object6;
        Object object7;
        Object object8;
        Object object9;
        SpecialEffectsController.Operation operation2 = operation32;
        Object object10 = iterator2;
        HashMap<SpecialEffectsController.Operation, Boolean> hashMap = new HashMap<SpecialEffectsController.Operation, Boolean>();
        Object object11 = object.iterator();
        View view = null;
        while (object11.hasNext()) {
            object9 = (TransitionInfo)object11.next();
            if (((SpecialEffectsInfo)object9).isVisibilityUnchanged()) continue;
            object8 = ((TransitionInfo)object9).getHandlingImpl();
            if (view == null) {
                object7 = object8;
            } else {
                object7 = view;
                if (object8 != null) {
                    if (view == object8) {
                        object7 = view;
                    } else {
                        throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + ((SpecialEffectsInfo)object9).getOperation().getFragment() + " returned Transition " + ((TransitionInfo)object9).getTransition() + " which uses a different Transition  type than other Fragments.");
                    }
                }
            }
            view = object7;
        }
        if (view == null) {
            object2 = object.iterator();
            while (object2.hasNext()) {
                object = (TransitionInfo)object2.next();
                hashMap.put(((SpecialEffectsInfo)object).getOperation(), false);
                ((SpecialEffectsInfo)object).completeSpecialEffect();
            }
            return hashMap;
        }
        object11 = new View(this.getContainer().getContext());
        object8 = null;
        object7 = new Rect();
        Object object12 = new ArrayList();
        object9 = new ArrayList();
        ArrayMap<String, String> arrayMap2 = new ArrayMap<String, String>();
        Object object13 = object.iterator();
        Object object14 = null;
        boolean bl2 = false;
        FragmentTransitionImpl fragmentTransitionImpl = view;
        view = object10;
        object10 = object14;
        while (true) {
            boolean bl3 = object13.hasNext();
            object6 = "FragmentManager";
            if (!bl3) break;
            object14 = (TransitionInfo)object13.next();
            if (object14.hasSharedElementTransition() && operation2 != null && view != null) {
                int n2;
                object5 = fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(object14.getSharedElementTransition()));
                arrayMap = ((SpecialEffectsController.Operation)((Object)iterator2)).getFragment().getSharedElementSourceNames();
                object14 = operation32.getFragment().getSharedElementSourceNames();
                object8 = operation32.getFragment().getSharedElementTargetNames();
                for (n = 0; n < ((ArrayList)object8).size(); ++n) {
                    n2 = ((ArrayList)((Object)arrayMap)).indexOf(((ArrayList)object8).get(n));
                    if (n2 == -1) continue;
                    ((ArrayList)((Object)arrayMap)).set(n2, object14.get(n));
                }
                arrayList = ((SpecialEffectsController.Operation)((Object)iterator2)).getFragment().getSharedElementTargetNames();
                if (!bl) {
                    object8 = operation32.getFragment().getExitTransitionCallback();
                    object14 = ((SpecialEffectsController.Operation)((Object)iterator2)).getFragment().getEnterTransitionCallback();
                } else {
                    object8 = operation32.getFragment().getEnterTransitionCallback();
                    object14 = ((SpecialEffectsController.Operation)((Object)iterator2)).getFragment().getExitTransitionCallback();
                }
                n = ((ArrayList)((Object)arrayMap)).size();
                for (n2 = 0; n2 < n; ++n2) {
                    arrayMap2.put((String)((ArrayList)((Object)arrayMap)).get(n2), (String)arrayList.get(n2));
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)"FragmentManager", (String)">>> entering view names <<<");
                    for (String string2 : arrayList) {
                        Log.v((String)"FragmentManager", (String)("Name: " + string2));
                    }
                    Log.v((String)"FragmentManager", (String)">>> exiting view names <<<");
                    object6 = ((ArrayList)((Object)arrayMap)).iterator();
                    while (object6.hasNext()) {
                        String string3 = (String)object6.next();
                        Log.v((String)"FragmentManager", (String)("Name: " + string3));
                    }
                }
                ArrayMap<String, View> object42 = new ArrayMap<String, View>();
                this.findNamedViews(object42, operation32.getFragment().mView);
                object42.retainAll((Collection<?>)((Object)arrayMap));
                if (object8 != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v((String)"FragmentManager", (String)("Executing exit callback for operation " + operation2));
                    }
                    ((SharedElementCallback)object8).onMapSharedElements((List<String>)((Object)arrayMap), object42);
                    for (n = ((ArrayList)((Object)arrayMap)).size() - 1; n >= 0; --n) {
                        object3 = (String)((ArrayList)((Object)arrayMap)).get(n);
                        object6 = (View)object42.get(object3);
                        if (object6 == null) {
                            arrayMap2.remove(object3);
                            continue;
                        }
                        if (((String)object3).equals(ViewCompat.getTransitionName((View)object6))) continue;
                        object3 = (String)arrayMap2.remove(object3);
                        arrayMap2.put(ViewCompat.getTransitionName((View)object6), (String)object3);
                    }
                    object6 = object8;
                    object8 = arrayMap;
                } else {
                    arrayMap2.retainAll(object42.keySet());
                    object6 = object8;
                    object8 = arrayMap;
                }
                arrayMap = new ArrayMap<String, View>();
                this.findNamedViews(arrayMap, ((SpecialEffectsController.Operation)((Object)iterator2)).getFragment().mView);
                arrayMap.retainAll(arrayList);
                arrayMap.retainAll(arrayMap2.values());
                if (object14 != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v((String)"FragmentManager", (String)("Executing enter callback for operation " + view));
                    }
                    object14.onMapSharedElements(arrayList, arrayMap);
                    for (n = arrayList.size() - 1; n >= 0; --n) {
                        object3 = (String)arrayList.get(n);
                        object6 = (View)arrayMap.get(object3);
                        if (object6 == null) {
                            object6 = FragmentTransition.findKeyForValue(arrayMap2, (String)object3);
                            if (object6 == null) continue;
                            arrayMap2.remove(object6);
                            continue;
                        }
                        if (((String)object3).equals(ViewCompat.getTransitionName((View)object6)) || (object3 = FragmentTransition.findKeyForValue(arrayMap2, (String)object3)) == null) continue;
                        arrayMap2.put((String)object3, ViewCompat.getTransitionName((View)object6));
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap2, arrayMap);
                }
                this.retainMatchingViews(object42, arrayMap2.keySet());
                this.retainMatchingViews(arrayMap, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    object8 = null;
                    ((ArrayList)object12).clear();
                    ((ArrayList)object9).clear();
                    object14 = view;
                    view = object7;
                    object7 = object14;
                } else {
                    FragmentTransition.callSharedElementStartEnd(((SpecialEffectsController.Operation)((Object)iterator2)).getFragment(), operation32.getFragment(), bl, object42, true);
                    OneShotPreDrawListener.add((View)this.getContainer(), new Runnable(this, (SpecialEffectsController.Operation)((Object)iterator2), operation32, bl, arrayMap){
                        final DefaultSpecialEffectsController this$0;
                        final SpecialEffectsController.Operation val$firstOut;
                        final boolean val$isPop;
                        final SpecialEffectsController.Operation val$lastIn;
                        final ArrayMap val$lastInViews;
                        {
                            this.this$0 = defaultSpecialEffectsController;
                            this.val$lastIn = operation;
                            this.val$firstOut = operation2;
                            this.val$isPop = bl;
                            this.val$lastInViews = arrayMap;
                        }

                        @Override
                        public void run() {
                            FragmentTransition.callSharedElementStartEnd(this.val$lastIn.getFragment(), this.val$firstOut.getFragment(), this.val$isPop, this.val$lastInViews, false);
                        }
                    });
                    ((ArrayList)object12).addAll(object42.values());
                    if (!((ArrayList)object8).isEmpty()) {
                        object10 = (View)object42.get((String)((ArrayList)object8).get(0));
                        fragmentTransitionImpl.setEpicenter(object5, (View)object10);
                    }
                    ((ArrayList)object9).addAll(arrayMap.values());
                    if (!arrayList.isEmpty() && (view = (View)arrayMap.get((String)arrayList.get(0))) != null) {
                        bl2 = true;
                        OneShotPreDrawListener.add((View)this.getContainer(), new Runnable(this, fragmentTransitionImpl, view, (Rect)object7){
                            final DefaultSpecialEffectsController this$0;
                            final FragmentTransitionImpl val$impl;
                            final Rect val$lastInEpicenterRect;
                            final View val$lastInEpicenterView;
                            {
                                this.this$0 = defaultSpecialEffectsController;
                                this.val$impl = fragmentTransitionImpl;
                                this.val$lastInEpicenterView = view;
                                this.val$lastInEpicenterRect = rect;
                            }

                            @Override
                            public void run() {
                                this.val$impl.getBoundsOnScreen(this.val$lastInEpicenterView, this.val$lastInEpicenterRect);
                            }
                        });
                    }
                    view = object7;
                    fragmentTransitionImpl.setSharedElementTargets(object5, (View)object11, (ArrayList<View>)object12);
                    fragmentTransitionImpl.scheduleRemoveTargets(object5, null, null, null, null, object5, (ArrayList<View>)object9);
                    operation2 = operation32;
                    hashMap.put(operation2, true);
                    object7 = iterator2;
                    hashMap.put((SpecialEffectsController.Operation)object7, true);
                    object8 = object5;
                }
            } else {
                object14 = object7;
                object7 = view;
                view = object14;
            }
            object14 = view;
            view = object7;
            object7 = object14;
        }
        arrayMap = object7;
        object14 = object11;
        object7 = view;
        arrayList = new ArrayList();
        object5 = null;
        object13 = null;
        Iterator iterator3 = object.iterator();
        view = object12;
        object12 = object10;
        object11 = object6;
        object10 = object7;
        object7 = object13;
        object6 = object5;
        while (iterator3.hasNext()) {
            object5 = (TransitionInfo)iterator3.next();
            if (((SpecialEffectsInfo)object5).isVisibilityUnchanged()) {
                hashMap.put(((SpecialEffectsInfo)object5).getOperation(), false);
                ((SpecialEffectsInfo)object5).completeSpecialEffect();
                continue;
            }
            object13 = fragmentTransitionImpl.cloneTransition(((TransitionInfo)object5).getTransition());
            object3 = ((SpecialEffectsInfo)object5).getOperation();
            n = object8 != null && (object3 == operation2 || object3 == object10) ? 1 : 0;
            if (object13 == null) {
                if (n == 0) {
                    hashMap.put((SpecialEffectsController.Operation)object3, false);
                    ((SpecialEffectsInfo)object5).completeSpecialEffect();
                }
            } else {
                object10 = new ArrayList();
                this.captureTransitioningViews((ArrayList<View>)object10, ((SpecialEffectsController.Operation)object3).getFragment().mView);
                if (n != 0) {
                    if (object3 == operation2) {
                        ((ArrayList)object10).removeAll((Collection<?>)view);
                    } else {
                        ((ArrayList)object10).removeAll((Collection<?>)object9);
                    }
                }
                if (((ArrayList)object10).isEmpty()) {
                    fragmentTransitionImpl.addTarget(object13, (View)object14);
                } else {
                    fragmentTransitionImpl.addTargets(object13, (ArrayList<View>)object10);
                    fragmentTransitionImpl.scheduleRemoveTargets(object13, object13, (ArrayList<View>)object10, null, null, null, null);
                    if (((SpecialEffectsController.Operation)object3).getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                        object2.remove(object3);
                        ArrayList<View> arrayList2 = new ArrayList<View>((Collection<View>)object10);
                        arrayList2.remove(((SpecialEffectsController.Operation)object3).getFragment().mView);
                        fragmentTransitionImpl.scheduleHideFragmentView(object13, ((SpecialEffectsController.Operation)object3).getFragment().mView, arrayList2);
                        OneShotPreDrawListener.add((View)this.getContainer(), new Runnable(this, (ArrayList)object10){
                            final DefaultSpecialEffectsController this$0;
                            final ArrayList val$transitioningViews;
                            {
                                this.this$0 = defaultSpecialEffectsController;
                                this.val$transitioningViews = arrayList;
                            }

                            @Override
                            public void run() {
                                FragmentTransition.setViewVisibility(this.val$transitioningViews, 4);
                            }
                        });
                    }
                }
                if (((SpecialEffectsController.Operation)object3).getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                    arrayList.addAll((Collection<View>)object10);
                    if (bl2) {
                        fragmentTransitionImpl.setEpicenter(object13, (Rect)arrayMap);
                    }
                } else {
                    fragmentTransitionImpl.setEpicenter(object13, (View)object12);
                }
                hashMap.put((SpecialEffectsController.Operation)object3, true);
                if (((TransitionInfo)object5).isOverlapAllowed()) {
                    object6 = fragmentTransitionImpl.mergeTransitionsTogether(object6, object13, null);
                } else {
                    object7 = fragmentTransitionImpl.mergeTransitionsTogether(object7, object13, null);
                }
            }
            object10 = iterator2;
        }
        object2 = fragmentTransitionImpl.mergeTransitionsInSequence(object6, object7, object8);
        if (object2 == null) {
            return hashMap;
        }
        object = object.iterator();
        while (object.hasNext()) {
            object14 = (TransitionInfo)object.next();
            if (object14.isVisibilityUnchanged()) continue;
            object12 = object14.getTransition();
            object10 = object14.getOperation();
            bl2 = object8 != null && (object10 == operation2 || object10 == iterator2);
            if (object12 != null || bl2) {
                if (!ViewCompat.isLaidOut((View)this.getContainer())) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v((String)object11, (String)("SpecialEffectsController: Container " + this.getContainer() + " has not been laid out. Completing operation " + object10));
                    }
                    object14.completeSpecialEffect();
                } else {
                    fragmentTransitionImpl.setListenerForTransitionEnd(object14.getOperation().getFragment(), object2, object14.getSignal(), new Runnable(this, (TransitionInfo)object14, (SpecialEffectsController.Operation)object10){
                        final DefaultSpecialEffectsController this$0;
                        final SpecialEffectsController.Operation val$operation;
                        final TransitionInfo val$transitionInfo;
                        {
                            this.this$0 = defaultSpecialEffectsController;
                            this.val$transitionInfo = transitionInfo;
                            this.val$operation = operation;
                        }

                        @Override
                        public void run() {
                            this.val$transitionInfo.completeSpecialEffect();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v((String)"FragmentManager", (String)("Transition for operation " + this.val$operation + "has completed"));
                            }
                        }
                    });
                }
            }
            operation2 = operation32;
        }
        if (!ViewCompat.isLaidOut((View)this.getContainer())) {
            return hashMap;
        }
        FragmentTransition.setViewVisibility(arrayList, 4);
        object = fragmentTransitionImpl.prepareSetNameOverridesReordered((ArrayList<View>)object9);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)object11, (String)">>>>> Beginning transition <<<<<");
            Log.v((String)object11, (String)">>>>> SharedElementFirstOutViews <<<<<");
            for (SpecialEffectsController.Operation operation32 : view) {
                Log.v((String)object11, (String)("View: " + operation32 + " Name: " + ViewCompat.getTransitionName((View)operation32)));
            }
            Log.v((String)object11, (String)">>>>> SharedElementLastInViews <<<<<");
            iterator2 = ((ArrayList)object9).iterator();
            while (iterator2.hasNext()) {
                operation32 = (View)iterator2.next();
                Log.v((String)object11, (String)("View: " + operation32 + " Name: " + ViewCompat.getTransitionName((View)operation32)));
            }
        }
        fragmentTransitionImpl.beginDelayedTransition(this.getContainer(), object2);
        fragmentTransitionImpl.setNameOverridesReordered((View)this.getContainer(), (ArrayList<View>)view, (ArrayList<View>)object9, (ArrayList<String>)object, (Map<String, String>)arrayMap2);
        FragmentTransition.setViewVisibility(arrayList, 0);
        fragmentTransitionImpl.swapSharedElementTargets(object8, (ArrayList<View>)view, (ArrayList<View>)object9);
        return hashMap;
    }

    private void syncAnimations(List<SpecialEffectsController.Operation> object) {
        Fragment fragment = object.get(object.size() - 1).getFragment();
        object = object.iterator();
        while (object.hasNext()) {
            SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation)object.next();
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    void applyContainerChanges(SpecialEffectsController.Operation operation) {
        View view = operation.getFragment().mView;
        operation.getFinalState().applyState(view);
    }

    void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup)view;
            if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                if (!arrayList.contains(view)) {
                    arrayList.add((View)viewGroup);
                }
            } else {
                int n = viewGroup.getChildCount();
                for (int i = 0; i < n; ++i) {
                    view = viewGroup.getChildAt(i);
                    if (view.getVisibility() != 0) continue;
                    this.captureTransitioningViews(arrayList, view);
                }
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    @Override
    void executeOperations(List<SpecialEffectsController.Operation> object, boolean bl) {
        ArrayList<AnimationInfo> arrayList;
        Object object2;
        Object object3;
        Object object4;
        Object object5 = object.iterator();
        ArrayList<SpecialEffectsController.Operation> arrayList2 = null;
        ArrayList<AnimationInfo> arrayList3 = null;
        while (object5.hasNext()) {
            object4 = object5.next();
            object3 = SpecialEffectsController.Operation.State.from(((SpecialEffectsController.Operation)object4).getFragment().mView);
            switch (10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[((SpecialEffectsController.Operation)object4).getFinalState().ordinal()]) {
                default: {
                    object2 = arrayList2;
                    arrayList = arrayList3;
                    break;
                }
                case 4: {
                    object2 = arrayList2;
                    arrayList = arrayList3;
                    if (object3 == SpecialEffectsController.Operation.State.VISIBLE) break;
                    arrayList = object4;
                    object2 = arrayList2;
                    break;
                }
                case 1: 
                case 2: 
                case 3: {
                    object2 = arrayList2;
                    arrayList = arrayList3;
                    if (object3 != SpecialEffectsController.Operation.State.VISIBLE) break;
                    object2 = arrayList2;
                    arrayList = arrayList3;
                    if (arrayList2 != null) break;
                    object2 = object4;
                    arrayList = arrayList3;
                }
            }
            arrayList2 = object2;
            arrayList3 = arrayList;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)"FragmentManager", (String)("Executing operations from " + arrayList2 + " to " + arrayList3));
        }
        arrayList = new ArrayList<AnimationInfo>();
        object4 = new ArrayList();
        object2 = new ArrayList<SpecialEffectsController.Operation>((Collection<SpecialEffectsController.Operation>)object);
        this.syncAnimations((List<SpecialEffectsController.Operation>)object);
        object = object.iterator();
        while (object.hasNext()) {
            object5 = (SpecialEffectsController.Operation)object.next();
            object3 = new CancellationSignal();
            ((SpecialEffectsController.Operation)object5).markStartedSpecialEffect((CancellationSignal)object3);
            arrayList.add(new AnimationInfo((SpecialEffectsController.Operation)object5, (CancellationSignal)object3, bl));
            object3 = new CancellationSignal();
            ((SpecialEffectsController.Operation)object5).markStartedSpecialEffect((CancellationSignal)object3);
            boolean bl2 = bl ? object5 == arrayList2 : object5 == arrayList3;
            object4.add(new TransitionInfo((SpecialEffectsController.Operation)object5, (CancellationSignal)object3, bl, bl2));
            ((SpecialEffectsController.Operation)object5).addCompletionListener(new Runnable(this, (List)object2, (SpecialEffectsController.Operation)object5){
                final DefaultSpecialEffectsController this$0;
                final List val$awaitingContainerChanges;
                final SpecialEffectsController.Operation val$operation;
                {
                    this.this$0 = defaultSpecialEffectsController;
                    this.val$awaitingContainerChanges = list;
                    this.val$operation = operation;
                }

                @Override
                public void run() {
                    if (this.val$awaitingContainerChanges.contains(this.val$operation)) {
                        this.val$awaitingContainerChanges.remove(this.val$operation);
                        this.this$0.applyContainerChanges(this.val$operation);
                    }
                }
            });
        }
        object = this.startTransitions((List<TransitionInfo>)object4, (List<SpecialEffectsController.Operation>)object2, bl, (SpecialEffectsController.Operation)((Object)arrayList2), (SpecialEffectsController.Operation)((Object)arrayList3));
        this.startAnimations((List<AnimationInfo>)arrayList, (List<SpecialEffectsController.Operation>)object2, object.containsValue(true), (Map<SpecialEffectsController.Operation, Boolean>)object);
        object = object2.iterator();
        while (object.hasNext()) {
            this.applyContainerChanges((SpecialEffectsController.Operation)object.next());
        }
        object2.clear();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)"FragmentManager", (String)("Completed executing operations from " + arrayList2 + " to " + arrayList3));
        }
    }

    void findNamedViews(Map<String, View> map2, View view) {
        String string2 = ViewCompat.getTransitionName(view);
        if (string2 != null) {
            map2.put(string2, view);
        }
        if (view instanceof ViewGroup) {
            view = (ViewGroup)view;
            int n = view.getChildCount();
            for (int i = 0; i < n; ++i) {
                string2 = view.getChildAt(i);
                if (string2.getVisibility() != 0) continue;
                this.findNamedViews(map2, (View)string2);
            }
        }
    }

    void retainMatchingViews(ArrayMap<String, View> object, Collection<String> collection) {
        object = ((ArrayMap)object).entrySet().iterator();
        while (object.hasNext()) {
            if (collection.contains(ViewCompat.getTransitionName((View)((Map.Entry)object.next()).getValue()))) continue;
            object.remove();
        }
    }

    private static class AnimationInfo
    extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim = false;

        AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean bl) {
            super(operation, cancellationSignal);
            this.mIsPop = bl;
        }

        FragmentAnim.AnimationOrAnimator getAnimation(Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            Fragment fragment = this.getOperation().getFragment();
            boolean bl = this.getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE;
            this.mAnimation = FragmentAnim.loadAnimation(context, fragment, bl, this.mIsPop);
            this.mLoadedAnim = true;
            return this.mAnimation;
        }
    }

    private static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation mOperation;
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            boolean bl = state2 == (state = this.mOperation.getFinalState()) || state2 != SpecialEffectsController.Operation.State.VISIBLE && state != SpecialEffectsController.Operation.State.VISIBLE;
            return bl;
        }
    }

    private static class TransitionInfo
    extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        private final Object mSharedElementTransition;
        private final Object mTransition;

        TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal object, boolean bl, boolean bl2) {
            super(operation, (CancellationSignal)object);
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                object = bl ? operation.getFragment().getReenterTransition() : operation.getFragment().getEnterTransition();
                this.mTransition = object;
                boolean bl3 = bl ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
                this.mOverlapAllowed = bl3;
            } else {
                object = bl ? operation.getFragment().getReturnTransition() : operation.getFragment().getExitTransition();
                this.mTransition = object;
                this.mOverlapAllowed = true;
            }
            this.mSharedElementTransition = bl2 ? (bl ? operation.getFragment().getSharedElementReturnTransition() : operation.getFragment().getSharedElementEnterTransition()) : null;
        }

        private FragmentTransitionImpl getHandlingImpl(Object object) {
            if (object == null) {
                return null;
            }
            if (FragmentTransition.PLATFORM_IMPL != null && FragmentTransition.PLATFORM_IMPL.canHandle(object)) {
                return FragmentTransition.PLATFORM_IMPL;
            }
            if (FragmentTransition.SUPPORT_IMPL != null && FragmentTransition.SUPPORT_IMPL.canHandle(object)) {
                return FragmentTransition.SUPPORT_IMPL;
            }
            throw new IllegalArgumentException("Transition " + object + " for fragment " + this.getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }

        FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl fragmentTransitionImpl = this.getHandlingImpl(this.mTransition);
            FragmentTransitionImpl fragmentTransitionImpl2 = this.getHandlingImpl(this.mSharedElementTransition);
            if (fragmentTransitionImpl != null && fragmentTransitionImpl2 != null && fragmentTransitionImpl != fragmentTransitionImpl2) {
                throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
            }
            if (fragmentTransitionImpl == null) {
                fragmentTransitionImpl = fragmentTransitionImpl2;
            }
            return fragmentTransitionImpl;
        }

        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            boolean bl = this.mSharedElementTransition != null;
            return bl;
        }

        boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }
    }
}

