/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.core.content;

import android.net.Uri;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

public final class IntentSanitizer$Builder$$ExternalSyntheticLambda3
implements Predicate {
    public final String f$0;

    public /* synthetic */ IntentSanitizer$Builder$$ExternalSyntheticLambda3(String string2) {
        this.f$0 = string2;
    }

    public final boolean test(Object object) {
        return IntentSanitizer.Builder.lambda$allowExtraStreamUriWithAuthority$15(this.f$0, (Uri)object);
    }
}

