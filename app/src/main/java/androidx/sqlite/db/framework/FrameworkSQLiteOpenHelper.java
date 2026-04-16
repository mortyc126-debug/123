/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.DatabaseErrorHandler
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteException
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.util.Log
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$$ExternalSyntheticLambda0;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\tH\u0017R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014*\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2={"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "useNoBackupDirectory", "", "allowDataLossOnRecovery", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "delegate", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "getDelegate$delegate", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;)Ljava/lang/Object;", "getDelegate", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "lazyDelegate", "Lkotlin/Lazy;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "writeAheadLoggingEnabled", "close", "", "setWriteAheadLoggingEnabled", "enabled", "Companion", "DBRefHolder", "OpenHelper", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class FrameworkSQLiteOpenHelper
implements SupportSQLiteOpenHelper {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SupportSQLite";
    private final boolean allowDataLossOnRecovery;
    private final SupportSQLiteOpenHelper.Callback callback;
    private final Context context;
    private final Lazy<OpenHelper> lazyDelegate;
    private final String name;
    private final boolean useNoBackupDirectory;
    private boolean writeAheadLoggingEnabled;

    public FrameworkSQLiteOpenHelper(Context context, String string2, SupportSQLiteOpenHelper.Callback callback2) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)callback2, (String)"callback");
        this(context, string2, callback2, false, false, 24, null);
    }

    public FrameworkSQLiteOpenHelper(Context context, String string2, SupportSQLiteOpenHelper.Callback callback2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)callback2, (String)"callback");
        this(context, string2, callback2, bl, false, 16, null);
    }

    public FrameworkSQLiteOpenHelper(Context context, String string2, SupportSQLiteOpenHelper.Callback callback2, boolean bl, boolean bl2) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)callback2, (String)"callback");
        this.context = context;
        this.name = string2;
        this.callback = callback2;
        this.useNoBackupDirectory = bl;
        this.allowDataLossOnRecovery = bl2;
        this.lazyDelegate = LazyKt.lazy((Function0)((Function0)new Function0<OpenHelper>(this){
            final FrameworkSQLiteOpenHelper this$0;
            {
                this.this$0 = frameworkSQLiteOpenHelper;
                super(0);
            }

            public final OpenHelper invoke() {
                Object object;
                if (FrameworkSQLiteOpenHelper.access$getName$p(this.this$0) != null && FrameworkSQLiteOpenHelper.access$getUseNoBackupDirectory$p(this.this$0)) {
                    object = new File(SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(FrameworkSQLiteOpenHelper.access$getContext$p(this.this$0)), FrameworkSQLiteOpenHelper.access$getName$p(this.this$0));
                    object = new OpenHelper(FrameworkSQLiteOpenHelper.access$getContext$p(this.this$0), object.getAbsolutePath(), new DBRefHolder(null), FrameworkSQLiteOpenHelper.access$getCallback$p(this.this$0), FrameworkSQLiteOpenHelper.access$getAllowDataLossOnRecovery$p(this.this$0));
                } else {
                    object = new OpenHelper(FrameworkSQLiteOpenHelper.access$getContext$p(this.this$0), FrameworkSQLiteOpenHelper.access$getName$p(this.this$0), new DBRefHolder(null), FrameworkSQLiteOpenHelper.access$getCallback$p(this.this$0), FrameworkSQLiteOpenHelper.access$getAllowDataLossOnRecovery$p(this.this$0));
                }
                SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled((SQLiteOpenHelper)object, FrameworkSQLiteOpenHelper.access$getWriteAheadLoggingEnabled$p(this.this$0));
                return object;
            }
        }));
    }

    public /* synthetic */ FrameworkSQLiteOpenHelper(Context context, String string2, SupportSQLiteOpenHelper.Callback callback2, boolean bl, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 8) != 0) {
            bl = false;
        }
        if ((n & 0x10) != 0) {
            bl2 = false;
        }
        this(context, string2, callback2, bl, bl2);
    }

    public static final /* synthetic */ boolean access$getAllowDataLossOnRecovery$p(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        return frameworkSQLiteOpenHelper.allowDataLossOnRecovery;
    }

    public static final /* synthetic */ SupportSQLiteOpenHelper.Callback access$getCallback$p(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        return frameworkSQLiteOpenHelper.callback;
    }

    public static final /* synthetic */ Context access$getContext$p(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        return frameworkSQLiteOpenHelper.context;
    }

    public static final /* synthetic */ String access$getName$p(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        return frameworkSQLiteOpenHelper.name;
    }

    public static final /* synthetic */ boolean access$getUseNoBackupDirectory$p(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        return frameworkSQLiteOpenHelper.useNoBackupDirectory;
    }

    public static final /* synthetic */ boolean access$getWriteAheadLoggingEnabled$p(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        return frameworkSQLiteOpenHelper.writeAheadLoggingEnabled;
    }

    private final OpenHelper getDelegate() {
        return (OpenHelper)((Object)this.lazyDelegate.getValue());
    }

    private static Object getDelegate$delegate(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        return frameworkSQLiteOpenHelper.lazyDelegate;
    }

    @Override
    public void close() {
        if (this.lazyDelegate.isInitialized()) {
            this.getDelegate().close();
        }
    }

    @Override
    public String getDatabaseName() {
        return this.name;
    }

    @Override
    public SupportSQLiteDatabase getReadableDatabase() {
        return this.getDelegate().getSupportDatabase(false);
    }

    @Override
    public SupportSQLiteDatabase getWritableDatabase() {
        return this.getDelegate().getSupportDatabase(true);
    }

    @Override
    public void setWriteAheadLoggingEnabled(boolean bl) {
        if (this.lazyDelegate.isInitialized()) {
            SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(this.getDelegate(), bl);
        }
        this.writeAheadLoggingEnabled = bl;
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$Companion;", "", "()V", "TAG", "", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2={"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "", "db", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "(Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;)V", "getDb", "()Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "setDb", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
    private static final class DBRefHolder {
        private FrameworkSQLiteDatabase db;

        public DBRefHolder(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.db = frameworkSQLiteDatabase;
        }

        public final FrameworkSQLiteDatabase getDb() {
            return this.db;
        }

        public final void setDb(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.db = frameworkSQLiteDatabase;
        }
    }

    @Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000 /2\u00020\u0001:\u0003-./B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J \u0010'\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016J \u0010,\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2={"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "dbRef", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "allowDataLossOnRecovery", "", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;Z)V", "getAllowDataLossOnRecovery", "()Z", "getCallback", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "getContext", "()Landroid/content/Context;", "getDbRef", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "lock", "Landroidx/sqlite/util/ProcessLock;", "migrated", "opened", "close", "", "getSupportDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "writable", "getWrappedDb", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "sqLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getWritableOrReadableDatabase", "innerGetDatabase", "onConfigure", "db", "onCreate", "onDowngrade", "oldVersion", "", "newVersion", "onOpen", "onUpgrade", "CallbackException", "CallbackName", "Companion", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
    private static final class OpenHelper
    extends SQLiteOpenHelper {
        public static final Companion Companion = new Companion(null);
        private final boolean allowDataLossOnRecovery;
        private final SupportSQLiteOpenHelper.Callback callback;
        private final Context context;
        private final DBRefHolder dbRef;
        private final ProcessLock lock;
        private boolean migrated;
        private boolean opened;

        public static /* synthetic */ void $r8$lambda$wesXNSdtx2gMKZWCPManFjtpLB8(SupportSQLiteOpenHelper.Callback callback2, DBRefHolder dBRefHolder, SQLiteDatabase sQLiteDatabase) {
            OpenHelper._init_$lambda$0(callback2, dBRefHolder, sQLiteDatabase);
        }

        public OpenHelper(Context object, String object2, DBRefHolder dBRefHolder, SupportSQLiteOpenHelper.Callback callback2, boolean bl) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"context");
            Intrinsics.checkNotNullParameter((Object)dBRefHolder, (String)"dbRef");
            Intrinsics.checkNotNullParameter((Object)callback2, (String)"callback");
            super(object, (String)object2, null, callback2.version, (DatabaseErrorHandler)new FrameworkSQLiteOpenHelper$OpenHelper$$ExternalSyntheticLambda0(callback2, dBRefHolder));
            this.context = object;
            this.dbRef = dBRefHolder;
            this.callback = callback2;
            this.allowDataLossOnRecovery = bl;
            if (object2 == null) {
                object = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"randomUUID().toString()");
            } else {
                object = object2;
            }
            object2 = this.context.getCacheDir();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"context.cacheDir");
            this.lock = new ProcessLock((String)object, (File)object2, false);
        }

        private static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback callback2, DBRefHolder dBRefHolder, SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)callback2, (String)"$callback");
            Intrinsics.checkNotNullParameter((Object)dBRefHolder, (String)"$dbRef");
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue((Object)sQLiteDatabase, (String)"dbObj");
            callback2.onCorruption(companion.getWrappedDb(dBRefHolder, sQLiteDatabase));
        }

        private final SQLiteDatabase getWritableOrReadableDatabase(boolean bl) {
            SQLiteDatabase sQLiteDatabase;
            if (bl) {
                sQLiteDatabase = super.getWritableDatabase();
                Intrinsics.checkNotNullExpressionValue((Object)sQLiteDatabase, (String)"{\n                super.\u2026eDatabase()\n            }");
            } else {
                sQLiteDatabase = super.getReadableDatabase();
                Intrinsics.checkNotNullExpressionValue((Object)sQLiteDatabase, (String)"{\n                super.\u2026eDatabase()\n            }");
            }
            return sQLiteDatabase;
        }

        private final SQLiteDatabase innerGetDatabase(boolean bl) {
            Object object;
            String string2 = this.getDatabaseName();
            if (string2 != null && (object = this.context.getDatabasePath(string2).getParentFile()) != null) {
                ((File)object).mkdirs();
                if (!((File)object).isDirectory()) {
                    Log.w((String)FrameworkSQLiteOpenHelper.TAG, (String)("Invalid database parent file, not a directory: " + object));
                }
            }
            try {
                object = this.getWritableOrReadableDatabase(bl);
                return object;
            }
            catch (Throwable throwable) {
                Object object2;
                super.close();
                try {
                    Thread.sleep(500L);
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                try {
                    object2 = this.getWritableOrReadableDatabase(bl);
                    return object2;
                }
                catch (Throwable throwable2) {
                    block18: {
                        block19: {
                            block17: {
                                block16: {
                                    super.close();
                                    if (!(throwable2 instanceof CallbackException)) break block16;
                                    object2 = ((CallbackException)throwable2).getCause();
                                    CallbackName callbackName = ((CallbackException)throwable2).getCallbackName();
                                    switch (WhenMappings.$EnumSwitchMapping$0[callbackName.ordinal()]) {
                                        default: {
                                            if (!(object2 instanceof SQLiteException)) break;
                                            break block17;
                                        }
                                        case 1: 
                                        case 2: 
                                        case 3: 
                                        case 4: {
                                            throw object2;
                                        }
                                    }
                                    throw object2;
                                }
                                if (!(throwable2 instanceof SQLiteException)) break block18;
                                if (string2 == null || !this.allowDataLossOnRecovery) break block19;
                            }
                            this.context.deleteDatabase(string2);
                            try {
                                string2 = this.getWritableOrReadableDatabase(bl);
                                return string2;
                            }
                            catch (CallbackException callbackException) {
                                throw callbackException.getCause();
                            }
                        }
                        throw throwable2;
                    }
                    throw throwable2;
                }
            }
        }

        public void close() {
            try {
                ProcessLock.lock$default(this.lock, false, 1, null);
                super.close();
                this.dbRef.setDb(null);
                this.opened = false;
                return;
            }
            finally {
                this.lock.unlock();
            }
        }

        public final boolean getAllowDataLossOnRecovery() {
            return this.allowDataLossOnRecovery;
        }

        public final SupportSQLiteOpenHelper.Callback getCallback() {
            return this.callback;
        }

        public final Context getContext() {
            return this.context;
        }

        public final DBRefHolder getDbRef() {
            return this.dbRef;
        }

        public final SupportSQLiteDatabase getSupportDatabase(boolean bl) {
            Object object = this.lock;
            boolean bl2 = !this.opened && this.getDatabaseName() != null;
            try {
                ((ProcessLock)object).lock(bl2);
                this.migrated = false;
                object = this.innerGetDatabase(bl);
                if (this.migrated) {
                    this.close();
                    object = this.getSupportDatabase(bl);
                    return object;
                }
                object = this.getWrappedDb((SQLiteDatabase)object);
                return object;
            }
            finally {
                this.lock.unlock();
            }
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, sQLiteDatabase);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"db");
            try {
                this.callback.onConfigure(this.getWrappedDb(sQLiteDatabase));
                return;
            }
            catch (Throwable throwable) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, throwable);
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"sqLiteDatabase");
            try {
                this.callback.onCreate(this.getWrappedDb(sQLiteDatabase));
                return;
            }
            catch (Throwable throwable) {
                throw new CallbackException(CallbackName.ON_CREATE, throwable);
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
            Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"db");
            this.migrated = true;
            try {
                this.callback.onDowngrade(this.getWrappedDb(sQLiteDatabase), n, n2);
                return;
            }
            catch (Throwable throwable) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, throwable);
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"db");
            if (!this.migrated) {
                try {
                    this.callback.onOpen(this.getWrappedDb(sQLiteDatabase));
                }
                catch (Throwable throwable) {
                    throw new CallbackException(CallbackName.ON_OPEN, throwable);
                }
            }
            this.opened = true;
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
            Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"sqLiteDatabase");
            this.migrated = true;
            try {
                this.callback.onUpgrade(this.getWrappedDb(sQLiteDatabase), n, n2);
                return;
            }
            catch (Throwable throwable) {
                throw new CallbackException(CallbackName.ON_UPGRADE, throwable);
            }
        }

        @Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "callbackName", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "cause", "", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;Ljava/lang/Throwable;)V", "getCallbackName", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "getCause", "()Ljava/lang/Throwable;", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
        private static final class CallbackException
        extends RuntimeException {
            private final CallbackName callbackName;
            private final Throwable cause;

            public CallbackException(CallbackName callbackName, Throwable throwable) {
                Intrinsics.checkNotNullParameter((Object)((Object)callbackName), (String)"callbackName");
                Intrinsics.checkNotNullParameter((Object)throwable, (String)"cause");
                super(throwable);
                this.callbackName = callbackName;
                this.cause = throwable;
            }

            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override
            public Throwable getCause() {
                return this.cause;
            }
        }

        @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "", "(Ljava/lang/String;I)V", "ON_CONFIGURE", "ON_CREATE", "ON_UPGRADE", "ON_DOWNGRADE", "ON_OPEN", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
        public static enum CallbackName {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN;

        }

        @Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2={"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$Companion;", "", "()V", "getWrappedDb", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "refHolder", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "sqLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final FrameworkSQLiteDatabase getWrappedDb(DBRefHolder object, SQLiteDatabase object2) {
                Intrinsics.checkNotNullParameter((Object)object, (String)"refHolder");
                Intrinsics.checkNotNullParameter((Object)object2, (String)"sqLiteDatabase");
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = ((DBRefHolder)object).getDb();
                if (frameworkSQLiteDatabase != null && frameworkSQLiteDatabase.isDelegate((SQLiteDatabase)object2)) {
                    object = frameworkSQLiteDatabase;
                } else {
                    object2 = new FrameworkSQLiteDatabase((SQLiteDatabase)object2);
                    ((DBRefHolder)object).setDb((FrameworkSQLiteDatabase)object2);
                    object = object2;
                }
                return object;
            }
        }

        @Metadata(k=3, mv={1, 7, 1}, xi=48)
        public final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[CallbackName.values().length];
                try {
                    nArray[CallbackName.ON_CONFIGURE.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[CallbackName.ON_CREATE.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[CallbackName.ON_UPGRADE.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[CallbackName.ON_DOWNGRADE.ordinal()] = 4;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[CallbackName.ON_OPEN.ordinal()] = 5;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }
}

