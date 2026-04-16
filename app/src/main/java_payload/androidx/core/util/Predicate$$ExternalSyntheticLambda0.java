/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.util;

import androidx.core.util.Predicate;

public final class Predicate$$ExternalSyntheticLambda0
implements Predicate {
    public final Predicate f$0;
    public final Predicate f$1;

    public /* synthetic */ Predicate$$ExternalSyntheticLambda0(Predicate predicate, Predicate predicate2) {
        this.f$0 = predicate;
        this.f$1 = predicate2;
    }

    public final boolean test(Object object) {
        return Predicate.lambda$or$2(this.f$0, this.f$1, object);
    }
}

