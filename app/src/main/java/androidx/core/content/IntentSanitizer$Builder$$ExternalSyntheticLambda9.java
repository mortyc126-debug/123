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

public final class IntentSanitizer$Builder$$ExternalSyntheticLambda9
implements Predicate {
    public final ComponentName f$0;

    public /* synthetic */ IntentSanitizer$Builder$$ExternalSyntheticLambda9(ComponentName componentName) {
        this.f$0 = componentName;
    }

    public final boolean test(Object object) {
        return IntentSanitizer.Builder.$r8$lambda$f9aU52V4hLVPTW2v-TcMiSk5YDc(this.f$0, (ComponentName)object);
    }
}

