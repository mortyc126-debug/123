/*
 * Decompiled with CFR 0.152.
 */
package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ChannelSegment$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ boolean m(AtomicReferenceArray atomicReferenceArray, int n, Object object, Object object2) {
        do {
            if (!atomicReferenceArray.compareAndSet(n, object, object2)) continue;
            return true;
        } while (atomicReferenceArray.get(n) == object);
        return false;
    }
}

