/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u00a8\u0006\u0003"}, d2={"checkParallelism", "", "", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class LimitedDispatcherKt {
    public static final void checkParallelism(int n) {
        boolean bl = true;
        if (n < 1) {
            bl = false;
        }
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + n).toString());
    }
}

