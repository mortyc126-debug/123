/*
 * Decompiled with CFR 0.152.
 */
package androidx.room;

import androidx.room.InvalidationTracker;

public final class InvalidationTracker$$ExternalSyntheticLambda0
implements Runnable {
    public final InvalidationTracker f$0;

    public /* synthetic */ InvalidationTracker$$ExternalSyntheticLambda0(InvalidationTracker invalidationTracker) {
        this.f$0 = invalidationTracker;
    }

    @Override
    public final void run() {
        this.f$0.onAutoCloseCallback$room_runtime_release();
    }
}

