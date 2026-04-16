/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 */
package androidx.activity;

import android.view.View;
import androidx.activity.PipHintTrackerKt;
import kotlinx.coroutines.channels.ProducerScope;

public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0
implements View.OnLayoutChangeListener {
    public final ProducerScope f$0;

    public /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0(ProducerScope producerScope) {
        this.f$0 = producerScope;
    }

    public final void onLayoutChange(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        PipHintTrackerKt.trackPipAnimationHintView.flow.1.$r8$lambda$3HoOD4FOOs4BK4W3sogOQmeeOUI(this.f$0, view, n, n2, n3, n4, n5, n6, n7, n8);
    }
}

