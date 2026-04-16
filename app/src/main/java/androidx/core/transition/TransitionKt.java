/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.transition.Transition
 *  android.transition.Transition$TransitionListener
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package androidx.core.transition;

import android.transition.Transition;
import androidx.core.transition.TransitionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001a\u00c6\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u00a8\u0006\u0013"}, d2={"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class TransitionKt {
    public static final Transition.TransitionListener addListener(Transition transition, Function1<? super Transition, Unit> object, Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function12, Function1<? super Transition, Unit> function13, Function1<? super Transition, Unit> function14) {
        object = new Transition.TransitionListener((Function1<? super Transition, Unit>)object, function13, function14, function12, function1){
            final Function1<Transition, Unit> $onCancel;
            final Function1<Transition, Unit> $onEnd;
            final Function1<Transition, Unit> $onPause;
            final Function1<Transition, Unit> $onResume;
            final Function1<Transition, Unit> $onStart;
            {
                this.$onEnd = function1;
                this.$onResume = function12;
                this.$onPause = function13;
                this.$onCancel = function14;
                this.$onStart = function15;
            }

            public void onTransitionCancel(Transition transition) {
                this.$onCancel.invoke((Object)transition);
            }

            public void onTransitionEnd(Transition transition) {
                this.$onEnd.invoke((Object)transition);
            }

            public void onTransitionPause(Transition transition) {
                this.$onPause.invoke((Object)transition);
            }

            public void onTransitionResume(Transition transition) {
                this.$onResume.invoke((Object)transition);
            }

            public void onTransitionStart(Transition transition) {
                this.$onStart.invoke((Object)transition);
            }
        };
        transition.addListener((Transition.TransitionListener)object);
        return (Transition.TransitionListener)object;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, Function1 object, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int n, Object object2) {
        if ((n & 1) != 0) {
            object = addListener.1.INSTANCE;
        }
        if ((n & 2) != 0) {
            function1 = addListener.2.INSTANCE;
        }
        if ((n & 4) != 0) {
            function12 = addListener.3.INSTANCE;
        }
        if ((n & 8) != 0) {
            function13 = addListener.4.INSTANCE;
        }
        if ((n & 0x10) != 0) {
            function14 = addListener.5.INSTANCE;
        }
        object = new /* invalid duplicate definition of identical inner class */;
        transition.addListener((Transition.TransitionListener)object);
        return (Transition.TransitionListener)object;
    }

    public static final Transition.TransitionListener doOnCancel(Transition transition, Function1<? super Transition, Unit> object) {
        object = new Transition.TransitionListener((Function1)object){
            final Function1 $onCancel;
            {
                this.$onCancel = function1;
            }

            public void onTransitionCancel(Transition transition) {
                this.$onCancel.invoke((Object)transition);
            }

            public void onTransitionEnd(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }

            public void onTransitionStart(Transition transition) {
            }
        };
        transition.addListener((Transition.TransitionListener)object);
        return (Transition.TransitionListener)object;
    }

    public static final Transition.TransitionListener doOnEnd(Transition transition, Function1<? super Transition, Unit> object) {
        object = new Transition.TransitionListener((Function1)object){
            final Function1 $onEnd;
            {
                this.$onEnd = function1;
            }

            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
                this.$onEnd.invoke((Object)transition);
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }

            public void onTransitionStart(Transition transition) {
            }
        };
        transition.addListener((Transition.TransitionListener)object);
        return (Transition.TransitionListener)object;
    }

    public static final Transition.TransitionListener doOnPause(Transition transition, Function1<? super Transition, Unit> object) {
        object = new Transition.TransitionListener((Function1)object){
            final Function1 $onPause;
            {
                this.$onPause = function1;
            }

            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
                this.$onPause.invoke((Object)transition);
            }

            public void onTransitionResume(Transition transition) {
            }

            public void onTransitionStart(Transition transition) {
            }
        };
        transition.addListener((Transition.TransitionListener)object);
        return (Transition.TransitionListener)object;
    }

    public static final Transition.TransitionListener doOnResume(Transition transition, Function1<? super Transition, Unit> object) {
        object = new Transition.TransitionListener((Function1)object){
            final Function1 $onResume;
            {
                this.$onResume = function1;
            }

            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
                this.$onResume.invoke((Object)transition);
            }

            public void onTransitionStart(Transition transition) {
            }
        };
        transition.addListener((Transition.TransitionListener)object);
        return (Transition.TransitionListener)object;
    }

    public static final Transition.TransitionListener doOnStart(Transition transition, Function1<? super Transition, Unit> object) {
        object = new Transition.TransitionListener((Function1)object){
            final Function1 $onStart;
            {
                this.$onStart = function1;
            }

            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }

            public void onTransitionStart(Transition transition) {
                this.$onStart.invoke((Object)transition);
            }
        };
        transition.addListener((Transition.TransitionListener)object);
        return (Transition.TransitionListener)object;
    }
}

