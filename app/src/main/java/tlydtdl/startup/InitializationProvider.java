package tlydtdl.startup;

import amuvvoafs.content.ComponentName;
import amuvvoafs.content.ContentProvider;
import amuvvoafs.content.ContentValues;
import amuvvoafs.content.Context;
import amuvvoafs.content.pm.PackageManager;
import amuvvoafs.database.Cursor;
import amuvvoafs.net.Uri;
import amuvvoafs.os.Trace;
import com.facebook.appevents.h;
import ic.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class InitializationProvider extends ContentProvider {
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    public final String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.startup.StartupException */
    public final boolean onCreate() throws StartupException {
        Context context = getContext();
        if (context == null) {
            throw new StartupException();
        }
        if (context.getApplicationContext() == null) {
            return true;
        }
        a aVarC = a.c(context);
        Class<?> cls = getClass();
        Context context2 = aVarC.c;
        try {
            try {
                Trace.beginSection(h.R("Startup"));
                aVarC.a(context2.getPackageManager().getProviderInfo(new ComponentName(context2, cls), 128).metaData);
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                throw new StartupException(e);
            }
        } finally {
            Trace.endSection();
        }
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalStateException("Not allowed.");
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }
}
