/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import java.util.function.Supplier;

public final class Utf8Old$$ExternalSyntheticThreadLocal1
extends ThreadLocal {
    public final Supplier initialValueSupplier;

    public /* synthetic */ Utf8Old$$ExternalSyntheticThreadLocal1(Supplier supplier) {
        this.initialValueSupplier = supplier;
    }

    protected /* synthetic */ Object initialValue() {
        return this.initialValueSupplier.get();
    }
}

