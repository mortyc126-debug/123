/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipData$Item
 */
package androidx.core.view;

import android.content.ClipData;
import java.util.function.Predicate;

public final class ContentInfoCompat$Api31Impl$$ExternalSyntheticLambda0
implements androidx.core.util.Predicate {
    public final Predicate f$0;

    public /* synthetic */ ContentInfoCompat$Api31Impl$$ExternalSyntheticLambda0(Predicate predicate) {
        this.f$0 = predicate;
    }

    public final boolean test(Object object) {
        return this.f$0.test((ClipData.Item)object);
    }
}

