package tlydtdl.sqlite.db.framework;

import amuvvoafs.content.Context;
import amuvvoafs.database.DatabaseErrorHandler;
import amuvvoafs.database.sqlite.SQLiteDatabase;
import amuvvoafs.database.sqlite.SQLiteException;
import amuvvoafs.database.sqlite.SQLiteOpenHelper;
import amuvvoafs.util.Log;
import amuvvoafs.util.Pair;
import com.gnacba.amuvvoafs.gms.internal.ads.ds0;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import uc0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends SQLiteOpenHelper {
    public static final /* synthetic */ int h = 0;
    public final Context a;
    public final ru1.c b;
    public final ds0 c;
    public final boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final hc.a f607f;
    public boolean g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, String str, final ru1.c cVar, final ds0 ds0Var, boolean z) {
        String string;
        super(context, str, (SQLiteDatabase.CursorFactory) null, ds0Var.b, new DatabaseErrorHandler() { // from class: tlydtdl.sqlite.db.framework.d
            public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                int i = f.h;
                o.e(sQLiteDatabase);
                c cVarX = p.x(cVar, sQLiteDatabase);
                ds0Var.getClass();
                Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + cVarX + ".path");
                SQLiteDatabase sQLiteDatabase2 = cVarX.a;
                if (!sQLiteDatabase2.isOpen()) {
                    String path = sQLiteDatabase2.getPath();
                    if (path != null) {
                        ds0.f(path);
                        return;
                    }
                    return;
                }
                List attachedDbs = null;
                try {
                    try {
                        attachedDbs = sQLiteDatabase2.getAttachedDbs();
                    } catch (SQLiteException unused) {
                    }
                    try {
                        cVarX.close();
                    } catch (IOException unused2) {
                    }
                    if (attachedDbs != null) {
                        return;
                    }
                } finally {
                    if (attachedDbs != null) {
                        Iterator it = attachedDbs.iterator();
                        while (it.hasNext()) {
                            Object obj = ((Pair) it.next()).second;
                            o.g(obj, "second");
                            ds0.f((String) obj);
                        }
                    } else {
                        String path2 = sQLiteDatabase2.getPath();
                        if (path2 != null) {
                            ds0.f(path2);
                        }
                    }
                }
            }
        });
        o.h(context, "context");
        o.h(ds0Var, "callback");
        this.a = context;
        this.b = cVar;
        this.c = ds0Var;
        this.d = z;
        if (str == null) {
            string = UUID.randomUUID().toString();
            o.g(string, "toString(...)");
        } else {
            string = str;
        }
        this.f607f = new hc.a(context.getCacheDir(), string, false);
    }

    public final gc.a a(boolean z) {
        hc.a aVar = this.f607f;
        try {
            aVar.a((this.g || getDatabaseName() == null) ? false : true);
            this.e = false;
            SQLiteDatabase sQLiteDatabaseB = b(z);
            if (!this.e) {
                c cVarX = p.x(this.b, sQLiteDatabaseB);
                aVar.b();
                return cVarX;
            }
            close();
            gc.a aVarA = a(z);
            aVar.b();
            return aVarA;
        } catch (Throwable th) {
            aVar.b();
            throw th;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final SQLiteDatabase b(boolean z) throws Throwable {
        SQLiteDatabase readableDatabase;
        SQLiteDatabase readableDatabase2;
        File parentFile;
        String databaseName = getDatabaseName();
        boolean z2 = this.g;
        Context context = this.a;
        if (databaseName != null && !z2 && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
            }
        }
        try {
            if (z) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                o.e(writableDatabase);
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase3 = getReadableDatabase();
            o.e(readableDatabase3);
            return readableDatabase3;
        } catch (Throwable unused) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
            try {
                if (z) {
                    readableDatabase2 = getWritableDatabase();
                    o.e(readableDatabase2);
                } else {
                    readableDatabase2 = getReadableDatabase();
                    o.e(readableDatabase2);
                }
                return readableDatabase2;
            } catch (Throwable th) {
                th = th;
                if (th instanceof FrameworkSQLiteOpenHelper$OpenHelper$CallbackException) {
                    FrameworkSQLiteOpenHelper$OpenHelper$CallbackException frameworkSQLiteOpenHelper$OpenHelper$CallbackException = (FrameworkSQLiteOpenHelper$OpenHelper$CallbackException) th;
                    int iOrdinal = frameworkSQLiteOpenHelper$OpenHelper$CallbackException.a.ordinal();
                    th = frameworkSQLiteOpenHelper$OpenHelper$CallbackException.b;
                    if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                        throw th;
                    }
                    if (iOrdinal != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (!(th instanceof SQLiteException)) {
                        throw th;
                    }
                }
                if (!(th instanceof SQLiteException) || databaseName == null || !this.d) {
                    throw th;
                }
                context.deleteDatabase(databaseName);
                try {
                    if (z) {
                        readableDatabase = getWritableDatabase();
                        o.e(readableDatabase);
                    } else {
                        readableDatabase = getReadableDatabase();
                        o.e(readableDatabase);
                    }
                    return readableDatabase;
                } catch (FrameworkSQLiteOpenHelper$OpenHelper$CallbackException e) {
                    throw e.b;
                }
            }
        }
    }

    public final void close() {
        hc.a aVar = this.f607f;
        try {
            aVar.a(aVar.a);
            super.close();
            this.b.b = null;
            this.g = false;
        } finally {
            aVar.b();
        }
    }

    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        o.h(sQLiteDatabase, "db");
        boolean z = this.e;
        ds0 ds0Var = this.c;
        if (!z && ds0Var.b != sQLiteDatabase.getVersion()) {
            sQLiteDatabase.setMaxSqlCacheSize(1);
        }
        try {
            p.x(this.b, sQLiteDatabase);
            ds0Var.getClass();
        } catch (Throwable th) {
            throw new FrameworkSQLiteOpenHelper$OpenHelper$CallbackException(e.a, th);
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        o.h(sQLiteDatabase, "sqLiteDatabase");
        try {
            this.c.h(p.x(this.b, sQLiteDatabase));
        } catch (Throwable th) {
            throw new FrameworkSQLiteOpenHelper$OpenHelper$CallbackException(e.b, th);
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        o.h(sQLiteDatabase, "db");
        this.e = true;
        try {
            this.c.i(p.x(this.b, sQLiteDatabase), i, i2);
        } catch (Throwable th) {
            throw new FrameworkSQLiteOpenHelper$OpenHelper$CallbackException(e.d, th);
        }
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        o.h(sQLiteDatabase, "db");
        if (!this.e) {
            try {
                this.c.j(p.x(this.b, sQLiteDatabase));
            } catch (Throwable th) {
                throw new FrameworkSQLiteOpenHelper$OpenHelper$CallbackException(e.e, th);
            }
        }
        this.g = true;
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        o.h(sQLiteDatabase, "sqLiteDatabase");
        this.e = true;
        try {
            this.c.k(p.x(this.b, sQLiteDatabase), i, i2);
        } catch (Throwable th) {
            throw new FrameworkSQLiteOpenHelper$OpenHelper$CallbackException(e.c, th);
        }
    }
}
