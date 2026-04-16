/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.util;

import androidx.core.util.Predicate;

public final class Predicate$$ExternalSyntheticLambda4
implements Predicate {
    public final Predicate f$0;

    public /* synthetic */ Predicate$$ExternalSyntheticLambda4(Predicate predicate) {
        this.f$0 = predicate;
    }

    public final boolean test(Object object) {
        return Predicate.lambda$negate$1(this.f$0, object);
    }
}

