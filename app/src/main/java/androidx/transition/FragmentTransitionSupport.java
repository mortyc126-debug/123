/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.FragmentTransitionSupport$$ExternalSyntheticLambda0;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSeekController;
import androidx.transition.TransitionSet;
import java.util.ArrayList;
import java.util.List;

public class FragmentTransitionSupport
extends FragmentTransitionImpl {
    private static boolean hasSimpleTarget(Transition transition) {
        boolean bl = !(FragmentTransitionSupport.isNullOrEmpty(transition.getTargetIds()) && FragmentTransitionSupport.isNullOrEmpty(transition.getTargetNames()) && FragmentTransitionSupport.isNullOrEmpty(transition.getTargetTypes()));
        return bl;
    }

    static /* synthetic */ void lambda$setListenerForTransitionEnd$0(Runnable runnable2, Transition transition, Runnable runnable3) {
        if (runnable2 == null) {
            transition.cancel();
            runnable3.run();
        } else {
            runnable2.run();
        }
    }

    @Override
    public void addTarget(Object object, View view) {
        if (object != null) {
            ((Transition)object).addTarget(view);
        }
    }

    @Override
    public void addTargets(Object object, ArrayList<View> arrayList) {
        block4: {
            block3: {
                if ((object = (Transition)object) == null) {
                    return;
                }
                if (!(object instanceof TransitionSet)) break block3;
                object = (TransitionSet)object;
                int n = ((TransitionSet)object).getTransitionCount();
                for (int i = 0; i < n; ++i) {
                    this.addTargets(((TransitionSet)object).getTransitionAt(i), arrayList);
                }
                break block4;
            }
            if (FragmentTransitionSupport.hasSimpleTarget((Transition)object) || !FragmentTransitionSupport.isNullOrEmpty(((Transition)object).getTargets())) break block4;
            int n = arrayList.size();
            for (int i = 0; i < n; ++i) {
                ((Transition)object).addTarget(arrayList.get(i));
            }
        }
    }

    public void animateToEnd(Object object) {
        ((TransitionSeekController)object).animateToEnd();
    }

    public void animateToStart(Object object, Runnable runnable2) {
        ((TransitionSeekController)object).animateToStart(runnable2);
    }

    @Override
    public void beginDelayedTransition(ViewGroup viewGroup, Object object) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition)object);
    }

    @Override
    public boolean canHandle(Object object) {
        return object instanceof Transition;
    }

    @Override
    public Object cloneTransition(Object object) {
        Transition transition = null;
        if (object != null) {
            transition = ((Transition)object).clone();
        }
        return transition;
    }

    public Object controlDelayedTransition(ViewGroup viewGroup, Object object) {
        return TransitionManager.controlDelayedTransition(viewGroup, (Transition)object);
    }

    public boolean isSeekingSupported() {
        return true;
    }

    public boolean isSeekingSupported(Object object) {
        boolean bl = ((Transition)object).isSeekingSupported();
        if (!bl) {
            Log.v((String)"FragmentManager", (String)("Predictive back not available for AndroidX Transition " + object + ". Please enable seeking support for the designated transition by overriding isSeekingSupported()."));
        }
        return bl;
    }

    @Override
    public Object mergeTransitionsInSequence(Object object, Object object2, Object object3) {
        Object var4_4 = null;
        object = (Transition)object;
        object2 = (Transition)object2;
        object3 = (Transition)object3;
        if (object != null && object2 != null) {
            object = new TransitionSet().addTransition((Transition)object).addTransition((Transition)object2).setOrdering(1);
        } else if (object == null) {
            object = var4_4;
            if (object2 != null) {
                object = object2;
            }
        }
        if (object3 != null) {
            object2 = new TransitionSet();
            if (object != null) {
                ((TransitionSet)object2).addTransition((Transition)object);
            }
            ((TransitionSet)object2).addTransition((Transition)object3);
            return object2;
        }
        return object;
    }

    @Override
    public Object mergeTransitionsTogether(Object object, Object object2, Object object3) {
        TransitionSet transitionSet = new TransitionSet();
        if (object != null) {
            transitionSet.addTransition((Transition)object);
        }
        if (object2 != null) {
            transitionSet.addTransition((Transition)object2);
        }
        if (object3 != null) {
            transitionSet.addTransition((Transition)object3);
        }
        return transitionSet;
    }

    @Override
    public void removeTarget(Object object, View view) {
        if (object != null) {
            ((Transition)object).removeTarget(view);
        }
    }

    @Override
    public void replaceTargets(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        block4: {
            List<View> list;
            block3: {
                if (!((object = (Transition)object) instanceof TransitionSet)) break block3;
                object = (TransitionSet)object;
                int n = ((TransitionSet)object).getTransitionCount();
                for (int i = 0; i < n; ++i) {
                    this.replaceTargets(((TransitionSet)object).getTransitionAt(i), arrayList, arrayList2);
                }
                break block4;
            }
            if (FragmentTransitionSupport.hasSimpleTarget((Transition)object) || (list = ((Transition)object).getTargets()).size() != arrayList.size() || !list.containsAll(arrayList)) break block4;
            int n = arrayList2 == null ? 0 : arrayList2.size();
            for (int i = 0; i < n; ++i) {
                ((Transition)object).addTarget(arrayList2.get(i));
            }
            for (n = arrayList.size() - 1; n >= 0; --n) {
                ((Transition)object).removeTarget(arrayList.get(n));
            }
        }
    }

    @Override
    public void scheduleHideFragmentView(Object object, View view, ArrayList<View> arrayList) {
        ((Transition)object).addListener(new Transition.TransitionListener(){
            final FragmentTransitionSupport this$0;
            final ArrayList val$exitingViews;
            final View val$fragmentView;
            {
                this.this$0 = fragmentTransitionSupport;
                this.val$fragmentView = view;
                this.val$exitingViews = arrayList;
            }

            @Override
            public void onTransitionCancel(Transition transition) {
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                this.val$fragmentView.setVisibility(8);
                int n = this.val$exitingViews.size();
                for (int i = 0; i < n; ++i) {
                    ((View)this.val$exitingViews.get(i)).setVisibility(0);
                }
            }

            @Override
            public void onTransitionPause(Transition transition) {
            }

            @Override
            public void onTransitionResume(Transition transition) {
            }

            @Override
            public void onTransitionStart(Transition transition) {
                transition.removeListener(this);
                transition.addListener(this);
            }
        });
    }

    @Override
    public void scheduleRemoveTargets(Object object, Object object2, ArrayList<View> arrayList, Object object3, ArrayList<View> arrayList2, Object object4, ArrayList<View> arrayList3) {
        ((Transition)object).addListener(new TransitionListenerAdapter(this, object2, arrayList, object3, arrayList2, object4, arrayList3){
            final FragmentTransitionSupport this$0;
            final Object val$enterTransition;
            final ArrayList val$enteringViews;
            final Object val$exitTransition;
            final ArrayList val$exitingViews;
            final Object val$sharedElementTransition;
            final ArrayList val$sharedElementsIn;
            {
                this.this$0 = fragmentTransitionSupport;
                this.val$enterTransition = object;
                this.val$enteringViews = arrayList;
                this.val$exitTransition = object2;
                this.val$exitingViews = arrayList2;
                this.val$sharedElementTransition = object3;
                this.val$sharedElementsIn = arrayList3;
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
            }

            @Override
            public void onTransitionStart(Transition transition) {
                if (this.val$enterTransition != null) {
                    this.this$0.replaceTargets(this.val$enterTransition, this.val$enteringViews, null);
                }
                if (this.val$exitTransition != null) {
                    this.this$0.replaceTargets(this.val$exitTransition, this.val$exitingViews, null);
                }
                if (this.val$sharedElementTransition != null) {
                    this.this$0.replaceTargets(this.val$sharedElementTransition, this.val$sharedElementsIn, null);
                }
            }
        });
    }

    public void setCurrentPlayTime(Object object, float f) {
        if ((object = (TransitionSeekController)object).isReady()) {
            long l;
            long l2 = l = (long)((float)object.getDurationMillis() * f);
            if (l == 0L) {
                l2 = 1L;
            }
            l = l2;
            if (l2 == object.getDurationMillis()) {
                l = object.getDurationMillis() - 1L;
            }
            object.setCurrentPlayTimeMillis(l);
        }
    }

    @Override
    public void setEpicenter(Object object, Rect rect) {
        if (object != null) {
            ((Transition)object).setEpicenterCallback(new Transition.EpicenterCallback(this, rect){
                final FragmentTransitionSupport this$0;
                final Rect val$epicenter;
                {
                    this.this$0 = fragmentTransitionSupport;
                    this.val$epicenter = rect;
                }

                @Override
                public Rect onGetEpicenter(Transition transition) {
                    if (this.val$epicenter != null && !this.val$epicenter.isEmpty()) {
                        return this.val$epicenter;
                    }
                    return null;
                }
            });
        }
    }

    @Override
    public void setEpicenter(Object object, View view) {
        if (view != null) {
            object = (Transition)object;
            Rect rect = new Rect();
            this.getBoundsOnScreen(view, rect);
            ((Transition)object).setEpicenterCallback(new Transition.EpicenterCallback(this, rect){
                final FragmentTransitionSupport this$0;
                final Rect val$epicenter;
                {
                    this.this$0 = fragmentTransitionSupport;
                    this.val$epicenter = rect;
                }

                @Override
                public Rect onGetEpicenter(Transition transition) {
                    return this.val$epicenter;
                }
            });
        }
    }

    @Override
    public void setListenerForTransitionEnd(Fragment fragment, Object object, CancellationSignal cancellationSignal, Runnable runnable2) {
        this.setListenerForTransitionEnd(fragment, object, cancellationSignal, null, runnable2);
    }

    public void setListenerForTransitionEnd(Fragment object, Object object2, CancellationSignal cancellationSignal, Runnable runnable2, Runnable runnable3) {
        object = (Transition)object2;
        cancellationSignal.setOnCancelListener(new FragmentTransitionSupport$$ExternalSyntheticLambda0(runnable2, (Transition)object, runnable3));
        ((Transition)object).addListener(new Transition.TransitionListener(){
            final FragmentTransitionSupport this$0;
            final Runnable val$transitionCompleteRunnable;
            {
                this.this$0 = fragmentTransitionSupport;
                this.val$transitionCompleteRunnable = runnable2;
            }

            @Override
            public void onTransitionCancel(Transition transition) {
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                this.val$transitionCompleteRunnable.run();
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
        });
    }

    @Override
    public void setSharedElementTargets(Object object, View view, ArrayList<View> arrayList) {
        object = (TransitionSet)object;
        List<View> list = ((Transition)object).getTargets();
        list.clear();
        int n = arrayList.size();
        for (int i = 0; i < n; ++i) {
            FragmentTransitionSupport.bfsAddViewChildren(list, arrayList.get(i));
        }
        list.add(view);
        arrayList.add(view);
        this.addTargets(object, arrayList);
    }

    @Override
    public void swapSharedElementTargets(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if ((object = (TransitionSet)object) != null) {
            ((Transition)object).getTargets().clear();
            ((Transition)object).getTargets().addAll(arrayList2);
            this.replaceTargets(object, arrayList, arrayList2);
        }
    }

    @Override
    public Object wrapTransitionInSet(Object object) {
        if (object == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition)object);
        return transitionSet;
    }
}

