/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.Animator$AnimatorPauseListener
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package androidx.core.animation;

import android.animation.Animator;
import androidx.core.animation.AnimatorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u00a1\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001aT\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0002\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a-\u0010\u0013\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001a2\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a-\u0010\u0015\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001a2\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u00a8\u0006\u0017"}, d2={"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "", "onStart", "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class AnimatorKt {
    public static final Animator.AnimatorListener addListener(Animator animator2, Function1<? super Animator, Unit> object, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12, Function1<? super Animator, Unit> function13) {
        object = new Animator.AnimatorListener(function13, (Function1<? super Animator, Unit>)object, function12, function1){
            final Function1<Animator, Unit> $onCancel;
            final Function1<Animator, Unit> $onEnd;
            final Function1<Animator, Unit> $onRepeat;
            final Function1<Animator, Unit> $onStart;
            {
                this.$onRepeat = function1;
                this.$onEnd = function12;
                this.$onCancel = function13;
                this.$onStart = function14;
            }

            public void onAnimationCancel(Animator animator2) {
                this.$onCancel.invoke((Object)animator2);
            }

            public void onAnimationEnd(Animator animator2) {
                this.$onEnd.invoke((Object)animator2);
            }

            public void onAnimationRepeat(Animator animator2) {
                this.$onRepeat.invoke((Object)animator2);
            }

            public void onAnimationStart(Animator animator2) {
                this.$onStart.invoke((Object)animator2);
            }
        };
        animator2.addListener((Animator.AnimatorListener)object);
        return (Animator.AnimatorListener)object;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator2, Function1 object, Function1 function1, Function1 function12, Function1 function13, int n, Object object2) {
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
        object = new /* invalid duplicate definition of identical inner class */;
        animator2.addListener((Animator.AnimatorListener)object);
        return (Animator.AnimatorListener)object;
    }

    public static final Animator.AnimatorPauseListener addPauseListener(Animator animator2, Function1<? super Animator, Unit> object, Function1<? super Animator, Unit> function1) {
        object = new Animator.AnimatorPauseListener(function1, (Function1<? super Animator, Unit>)object){
            final Function1<Animator, Unit> $onPause;
            final Function1<Animator, Unit> $onResume;
            {
                this.$onPause = function1;
                this.$onResume = function12;
            }

            public void onAnimationPause(Animator animator2) {
                this.$onPause.invoke((Object)animator2);
            }

            public void onAnimationResume(Animator animator2) {
                this.$onResume.invoke((Object)animator2);
            }
        };
        animator2.addPauseListener((Animator.AnimatorPauseListener)object);
        return (Animator.AnimatorPauseListener)object;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator2, Function1 function1, Function1 function12, int n, Object object) {
        if ((n & 1) != 0) {
            function1 = addPauseListener.1.INSTANCE;
        }
        if ((n & 2) != 0) {
            function12 = addPauseListener.2.INSTANCE;
        }
        return AnimatorKt.addPauseListener(animator2, (Function1<? super Animator, Unit>)function1, (Function1<? super Animator, Unit>)function12);
    }

    public static final Animator.AnimatorListener doOnCancel(Animator animator2, Function1<? super Animator, Unit> object) {
        object = new Animator.AnimatorListener((Function1)object){
            final Function1 $onCancel;
            {
                this.$onCancel = function1;
            }

            public void onAnimationCancel(Animator animator2) {
                this.$onCancel.invoke((Object)animator2);
            }

            public void onAnimationEnd(Animator animator2) {
            }

            public void onAnimationRepeat(Animator animator2) {
            }

            public void onAnimationStart(Animator animator2) {
            }
        };
        animator2.addListener((Animator.AnimatorListener)object);
        return (Animator.AnimatorListener)object;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator animator2, Function1<? super Animator, Unit> object) {
        object = new Animator.AnimatorListener((Function1)object){
            final Function1 $onEnd;
            {
                this.$onEnd = function1;
            }

            public void onAnimationCancel(Animator animator2) {
            }

            public void onAnimationEnd(Animator animator2) {
                this.$onEnd.invoke((Object)animator2);
            }

            public void onAnimationRepeat(Animator animator2) {
            }

            public void onAnimationStart(Animator animator2) {
            }
        };
        animator2.addListener((Animator.AnimatorListener)object);
        return (Animator.AnimatorListener)object;
    }

    public static final Animator.AnimatorPauseListener doOnPause(Animator animator2, Function1<? super Animator, Unit> function1) {
        return AnimatorKt.addPauseListener$default(animator2, null, function1, 1, null);
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator animator2, Function1<? super Animator, Unit> object) {
        object = new Animator.AnimatorListener((Function1)object){
            final Function1 $onRepeat;
            {
                this.$onRepeat = function1;
            }

            public void onAnimationCancel(Animator animator2) {
            }

            public void onAnimationEnd(Animator animator2) {
            }

            public void onAnimationRepeat(Animator animator2) {
                this.$onRepeat.invoke((Object)animator2);
            }

            public void onAnimationStart(Animator animator2) {
            }
        };
        animator2.addListener((Animator.AnimatorListener)object);
        return (Animator.AnimatorListener)object;
    }

    public static final Animator.AnimatorPauseListener doOnResume(Animator animator2, Function1<? super Animator, Unit> function1) {
        return AnimatorKt.addPauseListener$default(animator2, function1, null, 2, null);
    }

    public static final Animator.AnimatorListener doOnStart(Animator animator2, Function1<? super Animator, Unit> object) {
        object = new Animator.AnimatorListener((Function1)object){
            final Function1 $onStart;
            {
                this.$onStart = function1;
            }

            public void onAnimationCancel(Animator animator2) {
            }

            public void onAnimationEnd(Animator animator2) {
            }

            public void onAnimationRepeat(Animator animator2) {
            }

            public void onAnimationStart(Animator animator2) {
                this.$onStart.invoke((Object)animator2);
            }
        };
        animator2.addListener((Animator.AnimatorListener)object);
        return (Animator.AnimatorListener)object;
    }
}

