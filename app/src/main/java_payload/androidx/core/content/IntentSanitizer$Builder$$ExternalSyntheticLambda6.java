/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 */
package androidx.core.content;

import android.content.ComponentName;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

public final class IntentSanitizer$Builder$$ExternalSyntheticLambda6
implements Predicate {
    public final String f$0;

    public /* synthetic */ IntentSanitizer$Builder$$ExternalSyntheticLambda6(String string2) {
        this.f$0 = string2;
    }

    public final boolean test(Object object) {
        return IntentSanitizer.Builder.lambda$allowComponentWithPackage$9(this.f$0, (ComponentName)object);
    }
}

