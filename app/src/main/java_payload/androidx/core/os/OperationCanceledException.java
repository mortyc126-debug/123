/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.os;

import androidx.core.util.ObjectsCompat;

public class OperationCanceledException
extends RuntimeException {
    public OperationCanceledException() {
        this((String)null);
    }

    public OperationCanceledException(String string2) {
        super(ObjectsCompat.toString(string2, "The operation has been canceled."));
    }
}

