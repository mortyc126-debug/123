/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteException
 *  android.util.Log
 *  android.util.Pair
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H'R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0014\u00c0\u0006\u0001"}, d2={"Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Ljava/io/Closeable;", "databaseName", "", "getDatabaseName", "()Ljava/lang/String;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "close", "", "setWriteAheadLoggingEnabled", "enabled", "", "Callback", "Configuration", "Factory", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
public interface SupportSQLiteOpenHelper
extends Closeable {
    @Override
    public void close();

    public String getDatabaseName();

    public SupportSQLiteDatabase getReadableDatabase();

    public SupportSQLiteDatabase getWritableDatabase();

    public void setWriteAheadLoggingEnabled(boolean var1);

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "", "version", "", "(I)V", "deleteDatabaseFile", "", "fileName", "", "onConfigure", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onCorruption", "onCreate", "onDowngrade", "oldVersion", "newVersion", "onOpen", "onUpgrade", "Companion", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static abstract class Callback {
        public static final Companion Companion = new Companion(null);
        private static final String TAG = "SupportSQLite";
        public final int version;

        public Callback(int n) {
            this.version = n;
        }

        private final void deleteDatabaseFile(String string2) {
            int n = 1;
            if (!StringsKt.equals((String)string2, (String)":memory:", (boolean)true)) {
                Object object = string2;
                int n2 = 0;
                int n3 = object.length() - 1;
                boolean bl = false;
                while (n2 <= n3) {
                    int n4 = !bl ? n2 : n3;
                    n4 = Intrinsics.compare((int)object.charAt(n4), (int)32) <= 0 ? 1 : 0;
                    if (!bl) {
                        if (n4 == 0) {
                            bl = true;
                            continue;
                        }
                        ++n2;
                        continue;
                    }
                    if (n4 == 0) break;
                    --n3;
                }
                if ((n3 = ((CharSequence)((Object)object.subSequence(n2, n3 + 1)).toString()).length() == 0 ? n : 0) == 0) {
                    Log.w((String)TAG, (String)("deleting the database file: " + string2));
                    try {
                        object = new File(string2);
                        SupportSQLiteCompat.Api16Impl.deleteDatabase((File)object);
                    }
                    catch (Exception exception) {
                        Log.w((String)TAG, (String)"delete failed: ", (Throwable)exception);
                    }
                    return;
                }
            }
        }

        public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void onCorruption(SupportSQLiteDatabase iterator2) {
            Object object;
            block17: {
                Throwable throwable2;
                Object object2;
                block16: {
                    Intrinsics.checkNotNullParameter((Object)iterator2, (String)"db");
                    Log.e((String)TAG, (String)("Corruption reported by sqlite on database: " + iterator2 + ".path"));
                    if (!iterator2.isOpen()) {
                        if ((iterator2 = iterator2.getPath()) == null) return;
                        this.deleteDatabaseFile((String)((Object)iterator2));
                        return;
                    }
                    object = null;
                    object2 = null;
                    try {
                        try {
                            List<Pair<String, String>> list = iterator2.getAttachedDbs();
                            object = list;
                        }
                        catch (SQLiteException sQLiteException) {
                            // empty catch block
                        }
                    }
                    catch (Throwable throwable2) {
                        break block16;
                    }
                    object2 = object;
                    try {
                        iterator2.close();
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                    break block17;
                }
                if (object2 != null) {
                    iterator2 = ((Iterable)object2).iterator();
                    while (iterator2.hasNext()) {
                        object2 = ((Pair)iterator2.next()).second;
                        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"p.second");
                        this.deleteDatabaseFile((String)object2);
                    }
                    throw throwable2;
                } else {
                    if ((iterator2 = iterator2.getPath()) == null) throw throwable2;
                    this.deleteDatabaseFile((String)((Object)iterator2));
                }
                throw throwable2;
            }
            if (object != null) {
                iterator2 = ((Iterable)object).iterator();
                while (iterator2.hasNext()) {
                    object = ((Pair)iterator2.next()).second;
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"p.second");
                    this.deleteDatabaseFile((String)object);
                }
                return;
            } else {
                if ((iterator2 = iterator2.getPath()) == null) return;
                this.deleteDatabaseFile((String)((Object)iterator2));
            }
        }

        public abstract void onCreate(SupportSQLiteDatabase var1);

        public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int n, int n2) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
            throw new SQLiteException("Can't downgrade database from version " + n + " to " + n2);
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        }

        public abstract void onUpgrade(SupportSQLiteDatabase var1, int var2, int var3);

        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback$Companion;", "", "()V", "TAG", "", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bR\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "", "context", "Landroid/content/Context;", "name", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "useNoBackupDirectory", "", "allowDataLossOnRecovery", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "Builder", "Companion", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Configuration {
        public static final Companion Companion = new Companion(null);
        public final boolean allowDataLossOnRecovery;
        public final Callback callback;
        public final Context context;
        public final String name;
        public final boolean useNoBackupDirectory;

        public Configuration(Context context, String string2, Callback callback2, boolean bl, boolean bl2) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)callback2, (String)"callback");
            this.context = context;
            this.name = string2;
            this.callback = callback2;
            this.useNoBackupDirectory = bl;
            this.allowDataLossOnRecovery = bl2;
        }

        public /* synthetic */ Configuration(Context context, String string2, Callback callback2, boolean bl, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 8) != 0) {
                bl = false;
            }
            if ((n & 0x10) != 0) {
                bl2 = false;
            }
            this(context, string2, callback2, bl, bl2);
        }

        @JvmStatic
        public static final Builder builder(Context context) {
            return Companion.builder(context);
        }

        @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowDataLossOnRecovery", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "name", "", "useNoBackupDirectory", "build", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "noBackupDirectory", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
        public static class Builder {
            private boolean allowDataLossOnRecovery;
            private Callback callback;
            private final Context context;
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(Context context) {
                Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                this.context = context;
            }

            public Builder allowDataLossOnRecovery(boolean bl) {
                this.allowDataLossOnRecovery = bl;
                return this;
            }

            public Configuration build() {
                Callback callback2 = this.callback;
                if (callback2 != null) {
                    CharSequence charSequence;
                    boolean bl;
                    boolean bl2 = this.useNoBackupDirectory;
                    boolean bl3 = bl = true;
                    if (bl2) {
                        charSequence = this.name;
                        bl3 = charSequence == null || charSequence.length() == 0;
                        bl3 = !bl3 ? bl : false;
                    }
                    if (bl3) {
                        Context context = this.context;
                        charSequence = this.name;
                        return new Configuration(context, (String)charSequence, callback2, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
                    }
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
                }
                throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
            }

            public Builder callback(Callback callback2) {
                Intrinsics.checkNotNullParameter((Object)callback2, (String)"callback");
                this.callback = callback2;
                return this;
            }

            public Builder name(String string2) {
                this.name = string2;
                return this;
            }

            public Builder noBackupDirectory(boolean bl) {
                this.useNoBackupDirectory = bl;
                return this;
            }
        }

        @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Companion;", "", "()V", "builder", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "context", "Landroid/content/Context;", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final Builder builder(Context context) {
                Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                return new Builder(context);
            }
        }
    }

    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0006\u00c0\u0006\u0001"}, d2={"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "", "create", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "configuration", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static interface Factory {
        public SupportSQLiteOpenHelper create(Configuration var1);
    }
}

