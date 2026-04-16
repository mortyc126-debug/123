/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.CancellationSignal
 *  android.os.OperationCanceledException
 */
package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.OperationCanceledException;
import androidx.core.os.CancellationSignal;

public final class ContentResolverCompat {
    private ContentResolverCompat() {
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] stringArray, String string2, String[] stringArray2, String string3, android.os.CancellationSignal cancellationSignal) {
        try {
            contentResolver = contentResolver.query(uri, stringArray, string2, stringArray2, string3, cancellationSignal);
            return contentResolver;
        }
        catch (Exception exception) {
            if (exception instanceof OperationCanceledException) {
                throw new androidx.core.os.OperationCanceledException();
            }
            throw exception;
        }
    }

    @Deprecated
    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] stringArray, String string2, String[] stringArray2, String string3, CancellationSignal cancellationSignal) {
        cancellationSignal = cancellationSignal != null ? (android.os.CancellationSignal)cancellationSignal.getCancellationSignalObject() : null;
        return ContentResolverCompat.query(contentResolver, uri, stringArray, string2, stringArray2, string3, (android.os.CancellationSignal)cancellationSignal);
    }
}

