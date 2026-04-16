/*
 * Decompiled with CFR 0.152.
 */
package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

public final class LifecycleKt$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ boolean m(AtomicReference atomicReference, Object object, Object object2) {
        do {
            if (!atomicReference.compareAndSet(object, object2)) continue;
            return true;
        } while (atomicReference.get() == object);
        return false;
    }
}

