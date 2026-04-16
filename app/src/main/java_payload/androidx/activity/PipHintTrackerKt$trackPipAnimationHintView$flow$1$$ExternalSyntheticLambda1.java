/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 */
package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.activity.PipHintTrackerKt;
import kotlinx.coroutines.channels.ProducerScope;

public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1
implements ViewTreeObserver.OnScrollChangedListener {
    public final ProducerScope f$0;
    public final View f$1;

    public /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1(ProducerScope producerScope, View view) {
        this.f$0 = producerScope;
        this.f$1 = view;
    }

    public final void onScrollChanged() {
        PipHintTrackerKt.trackPipAnimationHintView.flow.1.$r8$lambda$tX1ZAZ_6mxGyPSL59qbNSbD0n4g(this.f$0, this.f$1);
    }
}

