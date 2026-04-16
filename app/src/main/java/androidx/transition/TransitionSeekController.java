/*
 * Decompiled with CFR 0.152.
 */
package androidx.transition;

import androidx.core.util.Consumer;

public interface TransitionSeekController {
    public void addOnProgressChangedListener(Consumer<TransitionSeekController> var1);

    public void addOnReadyListener(Consumer<TransitionSeekController> var1);

    public void animateToEnd();

    public void animateToStart(Runnable var1);

    public float getCurrentFraction();

    public long getCurrentPlayTimeMillis();

    public long getDurationMillis();

    public boolean isReady();

    public void removeOnProgressChangedListener(Consumer<TransitionSeekController> var1);

    public void removeOnReadyListener(Consumer<TransitionSeekController> var1);

    public void setCurrentFraction(float var1);

    public void setCurrentPlayTimeMillis(long var1);
}

