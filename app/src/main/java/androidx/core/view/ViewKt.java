/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequenceScope
 *  kotlin.sequences.SequencesKt
 */
package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import androidx.core.view.ViewKt$$ExternalSyntheticLambda0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a2\u0010 \u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010'\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010(\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010)\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a2\u0010*\u001a\u00020+*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\b\u001a\u0014\u0010,\u001a\u00020-*\u00020\u00022\b\b\u0002\u0010.\u001a\u00020/\u001a%\u00100\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\u000e\b\u0004\u0010\"\u001a\b\u0012\u0004\u0012\u00020!04H\u0086\b\u001a \u00105\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!04\u001a\u0017\u00106\u001a\u00020!*\u00020\u00022\b\b\u0001\u00107\u001a\u00020\u0013H\u0086\b\u001a7\u00108\u001a\u00020!\"\n\b\u0000\u00109\u0018\u0001*\u00020:*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u00020!0#\u00a2\u0006\u0002\b<H\u0087\b\u00a2\u0006\u0002\b=\u001a&\u00108\u001a\u00020!*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020!0#\u00a2\u0006\u0002\b<H\u0086\b\u001a5\u0010>\u001a\u00020!*\u00020\u00022\b\b\u0003\u0010?\u001a\u00020\u00132\b\b\u0003\u0010@\u001a\u00020\u00132\b\b\u0003\u0010A\u001a\u00020\u00132\b\b\u0003\u0010B\u001a\u00020\u0013H\u0086\b\u001a5\u0010C\u001a\u00020!*\u00020\u00022\b\b\u0003\u0010D\u001a\u00020\u00132\b\b\u0003\u0010@\u001a\u00020\u00132\b\b\u0003\u0010E\u001a\u00020\u00132\b\b\u0003\u0010B\u001a\u00020\u0013H\u0086\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"*\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\"*\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r\"*\u0010\u0010\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r\"\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u0013*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015\"\u0016\u0010\u0018\u001a\u00020\u0013*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\"\u0016\u0010\u001a\u001a\u00020\u0013*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015\"\u0016\u0010\u001c\u001a\u00020\u0013*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015\"\u0016\u0010\u001e\u001a\u00020\u0013*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015\u00a8\u0006F"}, d2={"allViews", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "getAllViews", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "ancestors", "Landroid/view/ViewParent;", "getAncestors", "value", "", "isGone", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isVisible", "setVisible", "marginBottom", "", "getMarginBottom", "(Landroid/view/View;)I", "marginEnd", "getMarginEnd", "marginLeft", "getMarginLeft", "marginRight", "getMarginRight", "marginStart", "getMarginStart", "marginTop", "getMarginTop", "doOnAttach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnDetach", "doOnLayout", "doOnNextLayout", "doOnPreDraw", "Landroidx/core/view/OneShotPreDrawListener;", "drawToBitmap", "Landroid/graphics/Bitmap;", "config", "Landroid/graphics/Bitmap$Config;", "postDelayed", "Ljava/lang/Runnable;", "delayInMillis", "", "Lkotlin/Function0;", "postOnAnimationDelayed", "setPadding", "size", "updateLayoutParams", "T", "Landroid/view/ViewGroup$LayoutParams;", "block", "Lkotlin/ExtensionFunctionType;", "updateLayoutParamsTyped", "updatePadding", "left", "top", "right", "bottom", "updatePaddingRelative", "start", "end", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class ViewKt {
    public static /* synthetic */ void $r8$lambda$3IvyLuEauArsUXsbd_efkmajCrs(Function0 function0) {
        ViewKt.postOnAnimationDelayed$lambda$1(function0);
    }

    public static final void doOnAttach(View view, Function1<? super View, Unit> function1) {
        if (view.isAttachedToWindow()) {
            function1.invoke((Object)view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(view, function1){
                final Function1<View, Unit> $action;
                final View $this_doOnAttach;
                {
                    this.$this_doOnAttach = view;
                    this.$action = function1;
                }

                public void onViewAttachedToWindow(View view) {
                    this.$this_doOnAttach.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
                    this.$action.invoke((Object)view);
                }

                public void onViewDetachedFromWindow(View view) {
                }
            });
        }
    }

    public static final void doOnDetach(View view, Function1<? super View, Unit> function1) {
        if (!view.isAttachedToWindow()) {
            function1.invoke((Object)view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(view, function1){
                final Function1<View, Unit> $action;
                final View $this_doOnDetach;
                {
                    this.$this_doOnDetach = view;
                    this.$action = function1;
                }

                public void onViewAttachedToWindow(View view) {
                }

                public void onViewDetachedFromWindow(View view) {
                    this.$this_doOnDetach.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
                    this.$action.invoke((Object)view);
                }
            });
        }
    }

    public static final void doOnLayout(View view, Function1<? super View, Unit> function1) {
        if (view.isLaidOut() && !view.isLayoutRequested()) {
            function1.invoke((Object)view);
        } else {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener(function1){
                final Function1 $action$inlined;
                {
                    this.$action$inlined = function1;
                }

                public void onLayoutChange(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
                    view.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
                    this.$action$inlined.invoke((Object)view);
                }
            });
        }
    }

    public static final void doOnNextLayout(View view, Function1<? super View, Unit> function1) {
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener(function1){
            final Function1<View, Unit> $action;
            {
                this.$action = function1;
            }

            public void onLayoutChange(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
                view.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
                this.$action.invoke((Object)view);
            }
        });
    }

    public static final OneShotPreDrawListener doOnPreDraw(View view, Function1<? super View, Unit> function1) {
        return OneShotPreDrawListener.add(view, new Runnable(function1, view){
            final Function1<View, Unit> $action;
            final View $this_doOnPreDraw;
            {
                this.$action = function1;
                this.$this_doOnPreDraw = view;
            }

            public final void run() {
                this.$action.invoke((Object)this.$this_doOnPreDraw);
            }
        });
    }

    public static final Bitmap drawToBitmap(View view, Bitmap.Config config) {
        if (view.isLaidOut()) {
            config = Bitmap.createBitmap((int)view.getWidth(), (int)view.getHeight(), (Bitmap.Config)config);
            Canvas canvas = new Canvas((Bitmap)config);
            canvas.translate(-((float)view.getScrollX()), -((float)view.getScrollY()));
            view.draw(canvas);
            return config;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int n, Object object) {
        if ((n & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return ViewKt.drawToBitmap(view, config);
    }

    public static final Sequence<View> getAllViews(View view) {
        return SequencesKt.sequence((Function2)((Function2)new Function2<SequenceScope<? super View>, Continuation<? super Unit>, Object>(view, null){
            final View $this_allViews;
            private Object L$0;
            int label;
            {
                this.$this_allViews = view;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(SequenceScope<? super View> sequenceScope, Continuation<? super Unit> continuation) {
                return (this.create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                block7: {
                    Continuation continuation;
                    Sequence<View> sequence;
                    Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 2: {
                            allViews.1 var2_3 = this;
                            ResultKt.throwOnFailure((Object)object);
                            object = var2_3;
                            break block7;
                        }
                        case 1: {
                            sequence = (Sequence<View>)this.L$0;
                            ResultKt.throwOnFailure((Object)object);
                            object = sequence;
                            break;
                        }
                        case 0: {
                            ResultKt.throwOnFailure((Object)object);
                            sequence = (SequenceScope)this.L$0;
                            View view = this.$this_allViews;
                            continuation = (Continuation)this;
                            this.L$0 = sequence;
                            this.label = 1;
                            object = sequence;
                            if (sequence.yield((Object)view, continuation) != object2) break;
                            return object2;
                        }
                    }
                    if (this.$this_allViews instanceof ViewGroup) {
                        sequence = ViewGroupKt.getDescendants((ViewGroup)this.$this_allViews);
                        continuation = (Continuation)this;
                        this.L$0 = null;
                        this.label = 2;
                        if (object.yieldAll(sequence, continuation) == object2) {
                            return object2;
                        }
                        object = this;
                    }
                }
                return Unit.INSTANCE;
            }
        }));
    }

    public static final Sequence<ViewParent> getAncestors(View view) {
        return SequencesKt.generateSequence((Object)view.getParent(), (Function1)ancestors.1.INSTANCE);
    }

    public static final int getMarginBottom(View object) {
        object = (object = object.getLayoutParams()) instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams)object : null;
        int n = object != null ? object.bottomMargin : 0;
        return n;
    }

    public static final int getMarginEnd(View view) {
        int n = (view = view.getLayoutParams()) instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)view).getMarginEnd() : 0;
        return n;
    }

    public static final int getMarginLeft(View object) {
        object = (object = object.getLayoutParams()) instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams)object : null;
        int n = object != null ? object.leftMargin : 0;
        return n;
    }

    public static final int getMarginRight(View object) {
        object = (object = object.getLayoutParams()) instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams)object : null;
        int n = object != null ? object.rightMargin : 0;
        return n;
    }

    public static final int getMarginStart(View view) {
        int n = (view = view.getLayoutParams()) instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)view).getMarginStart() : 0;
        return n;
    }

    public static final int getMarginTop(View object) {
        object = (object = object.getLayoutParams()) instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams)object : null;
        int n = object != null ? object.topMargin : 0;
        return n;
    }

    public static final boolean isGone(View view) {
        boolean bl = view.getVisibility() == 8;
        return bl;
    }

    public static final boolean isInvisible(View view) {
        boolean bl = view.getVisibility() == 4;
        return bl;
    }

    public static final boolean isVisible(View view) {
        boolean bl = view.getVisibility() == 0;
        return bl;
    }

    public static final Runnable postDelayed(View view, long l, Function0<Unit> object) {
        object = new Runnable((Function0<Unit>)object){
            final Function0<Unit> $action;
            {
                this.$action = function0;
            }

            public final void run() {
                this.$action.invoke();
            }
        };
        view.postDelayed(object, l);
        return object;
    }

    public static final Runnable postOnAnimationDelayed(View view, long l, Function0<Unit> object) {
        object = new ViewKt$$ExternalSyntheticLambda0((Function0)object);
        view.postOnAnimationDelayed(object, l);
        return object;
    }

    private static final void postOnAnimationDelayed$lambda$1(Function0 function0) {
        function0.invoke();
    }

    public static final void setGone(View view, boolean bl) {
        int n = bl ? 8 : 0;
        view.setVisibility(n);
    }

    public static final void setInvisible(View view, boolean bl) {
        int n = bl ? 4 : 0;
        view.setVisibility(n);
    }

    public static final void setPadding(View view, int n) {
        view.setPadding(n, n, n, n);
    }

    public static final void setVisible(View view, boolean bl) {
        int n = bl ? 0 : 8;
        view.setVisibility(n);
    }

    public static final void updateLayoutParams(View view, Function1<? super ViewGroup.LayoutParams, Unit> function1) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            function1.invoke((Object)layoutParams);
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, Function1<? super T, Unit> function1) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.reifiedOperationMarker((int)1, (String)"T");
        function1.invoke((Object)layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(View view, int n, int n2, int n3, int n4) {
        view.setPadding(n, n2, n3, n4);
    }

    public static /* synthetic */ void updatePadding$default(View view, int n, int n2, int n3, int n4, int n5, Object object) {
        if ((n5 & 1) != 0) {
            n = view.getPaddingLeft();
        }
        if ((n5 & 2) != 0) {
            n2 = view.getPaddingTop();
        }
        if ((n5 & 4) != 0) {
            n3 = view.getPaddingRight();
        }
        if ((n5 & 8) != 0) {
            n4 = view.getPaddingBottom();
        }
        view.setPadding(n, n2, n3, n4);
    }

    public static final void updatePaddingRelative(View view, int n, int n2, int n3, int n4) {
        view.setPaddingRelative(n, n2, n3, n4);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int n, int n2, int n3, int n4, int n5, Object object) {
        if ((n5 & 1) != 0) {
            n = view.getPaddingStart();
        }
        if ((n5 & 2) != 0) {
            n2 = view.getPaddingTop();
        }
        if ((n5 & 4) != 0) {
            n3 = view.getPaddingEnd();
        }
        if ((n5 & 8) != 0) {
            n4 = view.getPaddingBottom();
        }
        view.setPaddingRelative(n, n2, n3, n4);
    }
}

