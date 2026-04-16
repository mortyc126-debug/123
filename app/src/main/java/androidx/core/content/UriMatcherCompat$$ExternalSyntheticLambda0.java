/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.UriMatcher
 *  android.net.Uri
 */
package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.content.UriMatcherCompat;
import androidx.core.util.Predicate;

public final class UriMatcherCompat$$ExternalSyntheticLambda0
implements Predicate {
    public final UriMatcher f$0;

    public /* synthetic */ UriMatcherCompat$$ExternalSyntheticLambda0(UriMatcher uriMatcher) {
        this.f$0 = uriMatcher;
    }

    public final boolean test(Object object) {
        return UriMatcherCompat.lambda$asPredicate$0(this.f$0, (Uri)object);
    }
}

