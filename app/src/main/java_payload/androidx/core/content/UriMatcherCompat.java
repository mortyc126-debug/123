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
import androidx.core.content.UriMatcherCompat$$ExternalSyntheticLambda0;
import androidx.core.util.Predicate;

public class UriMatcherCompat {
    private UriMatcherCompat() {
    }

    public static Predicate<Uri> asPredicate(UriMatcher uriMatcher) {
        return new UriMatcherCompat$$ExternalSyntheticLambda0(uriMatcher);
    }

    static /* synthetic */ boolean lambda$asPredicate$0(UriMatcher uriMatcher, Uri uri) {
        boolean bl = uriMatcher.match(uri) != -1;
        return bl;
    }
}

