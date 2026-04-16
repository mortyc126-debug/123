/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b\u00a8\u0006\u0005"}, d2={"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class UriKt {
    public static final File toFile(Uri uri) {
        if (Intrinsics.areEqual((Object)uri.getScheme(), (Object)"file")) {
            String string2 = uri.getPath();
            if (string2 != null) {
                return new File(string2);
            }
            throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
    }

    public static final Uri toUri(File file) {
        return Uri.fromFile((File)file);
    }

    public static final Uri toUri(String string2) {
        return Uri.parse((String)string2);
    }
}

