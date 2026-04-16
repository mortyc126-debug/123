/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 */
package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.activity.Api19Impl;
import androidx.activity.Api26Impl;
import androidx.activity.PipHintTrackerKt;
import androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0;
import androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006"}, d2={"trackPipAnimationHintView", "", "Landroid/app/Activity;", "view", "Landroid/view/View;", "(Landroid/app/Activity;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class PipHintTrackerKt {
    public static final /* synthetic */ Rect access$trackPipAnimationHintView$positionInWindow(View view) {
        return PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view);
    }

    public static final Object trackPipAnimationHintView(Activity object, View view, Continuation<? super Unit> continuation) {
        object = FlowKt.callbackFlow((Function2)new Function2<ProducerScope<? super Rect>, Continuation<? super Unit>, Object>(view, null){
            final View $view;
            private Object L$0;
            int label;

            public static /* synthetic */ void $r8$lambda$3HoOD4FOOs4BK4W3sogOQmeeOUI(ProducerScope producerScope, View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
                trackPipAnimationHintView.flow.1.invokeSuspend$lambda$0(producerScope, view, n, n2, n3, n4, n5, n6, n7, n8);
            }

            public static /* synthetic */ void $r8$lambda$tX1ZAZ_6mxGyPSL59qbNSbD0n4g(ProducerScope producerScope, View view) {
                trackPipAnimationHintView.flow.1.invokeSuspend$lambda$1(producerScope, view);
            }
            {
                this.$view = view;
                super(2, continuation);
            }

            private static final void invokeSuspend$lambda$0(ProducerScope producerScope, View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
                if (n != n5 || n3 != n7 || n2 != n6 || n4 != n8) {
                    producerScope.trySend-JP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(view));
                }
            }

            private static final void invokeSuspend$lambda$1(ProducerScope producerScope, View view) {
                producerScope.trySend-JP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(view));
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(ProducerScope<? super Rect> producerScope, Continuation<? super Unit> continuation) {
                return (this.create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)object);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        object = (ProducerScope)this.L$0;
                        PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0 pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0((ProducerScope)object);
                        PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1((ProducerScope)object, this.$view);
                        View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener((ProducerScope<? super Rect>)object, this.$view, pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1, pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0){
                            final ProducerScope<Rect> $$this$callbackFlow;
                            final View.OnLayoutChangeListener $layoutChangeListener;
                            final ViewTreeObserver.OnScrollChangedListener $scrollChangeListener;
                            final View $view;
                            {
                                this.$$this$callbackFlow = producerScope;
                                this.$view = view;
                                this.$scrollChangeListener = onScrollChangedListener;
                                this.$layoutChangeListener = onLayoutChangeListener;
                            }

                            public void onViewAttachedToWindow(View view) {
                                this.$$this$callbackFlow.trySend-JP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(this.$view));
                                this.$view.getViewTreeObserver().addOnScrollChangedListener(this.$scrollChangeListener);
                                this.$view.addOnLayoutChangeListener(this.$layoutChangeListener);
                            }

                            public void onViewDetachedFromWindow(View view) {
                                view.getViewTreeObserver().removeOnScrollChangedListener(this.$scrollChangeListener);
                                view.removeOnLayoutChangeListener(this.$layoutChangeListener);
                            }
                        };
                        if (Api19Impl.INSTANCE.isAttachedToWindow(this.$view)) {
                            object.trySend-JP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(this.$view));
                            this.$view.getViewTreeObserver().addOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1);
                            this.$view.addOnLayoutChangeListener((View.OnLayoutChangeListener)pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0);
                        }
                        this.$view.addOnAttachStateChangeListener(onAttachStateChangeListener);
                        pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1 = (Function0)new Function0<Unit>(this.$view, (ViewTreeObserver.OnScrollChangedListener)pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1, (View.OnLayoutChangeListener)pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0, onAttachStateChangeListener){
                            final trackPipAnimationHintView.flow.attachStateChangeListener.1 $attachStateChangeListener;
                            final View.OnLayoutChangeListener $layoutChangeListener;
                            final ViewTreeObserver.OnScrollChangedListener $scrollChangeListener;
                            final View $view;
                            {
                                this.$view = view;
                                this.$scrollChangeListener = onScrollChangedListener;
                                this.$layoutChangeListener = onLayoutChangeListener;
                                this.$attachStateChangeListener = var4_4;
                                super(0);
                            }

                            public final void invoke() {
                                this.$view.getViewTreeObserver().removeOnScrollChangedListener(this.$scrollChangeListener);
                                this.$view.removeOnLayoutChangeListener(this.$layoutChangeListener);
                                this.$view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this.$attachStateChangeListener);
                            }
                        };
                        onAttachStateChangeListener = (Continuation)this;
                        this.label = 1;
                        if (ProduceKt.awaitClose(object, (Function0<Unit>)pipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1, (Continuation<? super Unit>)onAttachStateChangeListener) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        }).collect(new FlowCollector((Activity)object){
            final Activity $this_trackPipAnimationHintView;
            {
                this.$this_trackPipAnimationHintView = activity;
            }

            public final Object emit(Rect rect, Continuation<? super Unit> continuation) {
                Api26Impl.INSTANCE.setPipParamsSourceRectHint(this.$this_trackPipAnimationHintView, rect);
                return Unit.INSTANCE;
            }
        }, continuation);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}

