/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.content;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

public final class IntentSanitizer$Builder$$ExternalSyntheticLambda5
implements Predicate {
    public final Class f$0;
    public final Predicate f$1;

    public /* synthetic */ IntentSanitizer$Builder$$ExternalSyntheticLambda5(Class clazz, Predicate predicate) {
        this.f$0 = clazz;
        this.f$1 = predicate;
    }

    public final boolean test(Object object) {
        return IntentSanitizer.Builder.lambda$allowExtra$13(this.f$0, this.f$1, object);
    }
}

