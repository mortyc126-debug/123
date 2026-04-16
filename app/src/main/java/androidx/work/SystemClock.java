/*
 * Decompiled with CFR 0.152.
 */
package androidx.work;

import androidx.work.Clock;

public class SystemClock
implements Clock {
    @Override
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}

