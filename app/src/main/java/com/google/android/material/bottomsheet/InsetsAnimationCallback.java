package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.animation.AnimationUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class InsetsAnimationCallback extends WindowInsetsAnimationCompat.Callback {
    private int startTranslationY;
    private int startY;
    private final int[] tmpLocation;
    private final View view;

    public InsetsAnimationCallback(View view) {
        super(0);
        this.tmpLocation = new int[2];
        this.view = view;
    }

    public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.view.getLocationOnScreen(this.tmpLocation);
        this.startY = this.tmpLocation[1];
    }

    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        this.view.getLocationOnScreen(this.tmpLocation);
        int endY = this.tmpLocation[1];
        this.startTranslationY = this.startY - endY;
        this.view.setTranslationY(this.startTranslationY);
        return boundsCompat;
    }

    public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> animationList) {
        Iterator<WindowInsetsAnimationCompat> it = animationList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WindowInsetsAnimationCompat animation = it.next();
            if ((animation.getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
                float translationY = AnimationUtils.lerp(this.startTranslationY, 0, animation.getInterpolatedFraction());
                this.view.setTranslationY(translationY);
                break;
            }
        }
        return insets;
    }

    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.view.setTranslationY(0.0f);
    }
}
