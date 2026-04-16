/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import android.database.Cursor;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.Closeable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Landroidx/room/RoomOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "configuration", "Landroidx/room/DatabaseConfiguration;", "delegate", "Landroidx/room/RoomOpenHelper$Delegate;", "legacyHash", "", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;)V", "identityHash", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;Ljava/lang/String;)V", "checkIdentity", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "createMasterTableIfNotExists", "onConfigure", "onCreate", "onDowngrade", "oldVersion", "", "newVersion", "onOpen", "onUpgrade", "updateIdentity", "Companion", "Delegate", "ValidationResult", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public class RoomOpenHelper
extends SupportSQLiteOpenHelper.Callback {
    public static final Companion Companion = new Companion(null);
    private DatabaseConfiguration configuration;
    private final Delegate delegate;
    private final String identityHash;
    private final String legacyHash;

    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate, String string2) {
        Intrinsics.checkNotNullParameter((Object)databaseConfiguration, (String)"configuration");
        Intrinsics.checkNotNullParameter((Object)delegate, (String)"delegate");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"legacyHash");
        this(databaseConfiguration, delegate, "", string2);
    }

    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate, String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)databaseConfiguration, (String)"configuration");
        Intrinsics.checkNotNullParameter((Object)delegate, (String)"delegate");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"identityHash");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"legacyHash");
        super(delegate.version);
        this.configuration = databaseConfiguration;
        this.delegate = delegate;
        this.identityHash = string2;
        this.legacyHash = string3;
    }

    private final void checkIdentity(SupportSQLiteDatabase object) {
        ValidationResult validationResult;
        block14: {
            block13: {
                block12: {
                    Object object2;
                    block11: {
                        if (!Companion.hasRoomMasterTable$room_runtime_release((SupportSQLiteDatabase)object)) break block12;
                        object = object.query(new SimpleSQLiteQuery("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
                        object2 = (Closeable)object;
                        try {
                            object = (Cursor)object2;
                            if (object.moveToFirst()) {
                                object = object.getString(0);
                                break block11;
                            }
                            object = null;
                            object = null;
                        }
                        catch (Throwable throwable) {
                            try {
                                throw throwable;
                            }
                            catch (Throwable throwable2) {
                                CloseableKt.closeFinally((Closeable)object2, (Throwable)throwable);
                                throw throwable2;
                            }
                        }
                    }
                    CloseableKt.closeFinally((Closeable)object2, null);
                    if (!Intrinsics.areEqual((Object)this.identityHash, (Object)object) && !Intrinsics.areEqual((Object)this.legacyHash, (Object)object)) {
                        object2 = new StringBuilder().append("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: ").append(this.identityHash);
                        object2 = ((StringBuilder)object2).append(", found: ");
                        throw new IllegalStateException(((StringBuilder)object2).append((String)object).toString());
                    }
                    break block13;
                }
                validationResult = this.delegate.onValidateSchema((SupportSQLiteDatabase)object);
                if (!validationResult.isValid) break block14;
                this.delegate.onPostMigrate((SupportSQLiteDatabase)object);
                this.updateIdentity((SupportSQLiteDatabase)object);
            }
            return;
        }
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResult.expectedFoundMsg);
    }

    private final void createMasterTableIfNotExists(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private final void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.createMasterTableIfNotExists(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    @Override
    public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        super.onConfigure(supportSQLiteDatabase);
    }

    @Override
    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        boolean bl = Companion.hasEmptySchema$room_runtime_release(supportSQLiteDatabase);
        this.delegate.createAllTables(supportSQLiteDatabase);
        if (!bl) {
            ValidationResult validationResult = this.delegate.onValidateSchema(supportSQLiteDatabase);
            if (!validationResult.isValid) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResult.expectedFoundMsg);
            }
        }
        this.updateIdentity(supportSQLiteDatabase);
        this.delegate.onCreate(supportSQLiteDatabase);
    }

    @Override
    public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        this.onUpgrade(supportSQLiteDatabase, n, n2);
    }

    @Override
    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        super.onOpen(supportSQLiteDatabase);
        this.checkIdentity(supportSQLiteDatabase);
        this.delegate.onOpen(supportSQLiteDatabase);
        this.configuration = null;
    }

    @Override
    public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        boolean bl = false;
        boolean bl2 = false;
        Object object = this.configuration;
        if (object != null) {
            object = ((DatabaseConfiguration)object).migrationContainer;
            object = ((RoomDatabase.MigrationContainer)object).findMigrationPath(n, n2);
            bl = bl2;
            if (object != null) {
                this.delegate.onPreMigrate(supportSQLiteDatabase);
                object = ((Iterable)object).iterator();
                while (object.hasNext()) {
                    ((Migration)object.next()).migrate(supportSQLiteDatabase);
                }
                object = this.delegate.onValidateSchema(supportSQLiteDatabase);
                if (((ValidationResult)object).isValid) {
                    this.delegate.onPostMigrate(supportSQLiteDatabase);
                    this.updateIdentity(supportSQLiteDatabase);
                    bl = true;
                } else {
                    throw new IllegalStateException("Migration didn't properly handle: " + ((ValidationResult)object).expectedFoundMsg);
                }
            }
        }
        if (!bl) {
            object = this.configuration;
            if (object != null && !((DatabaseConfiguration)object).isMigrationRequired(n, n2)) {
                this.delegate.dropAllTables(supportSQLiteDatabase);
                this.delegate.createAllTables(supportSQLiteDatabase);
            } else {
                throw new IllegalStateException("A migration from " + n + " to " + n2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
        }
    }

    @Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b\t\u00a8\u0006\n"}, d2={"Landroidx/room/RoomOpenHelper$Companion;", "", "()V", "hasEmptySchema", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "hasEmptySchema$room_runtime_release", "hasRoomMasterTable", "hasRoomMasterTable$room_runtime_release", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean hasEmptySchema$room_runtime_release(SupportSQLiteDatabase closeable) {
            boolean bl;
            block5: {
                boolean bl2;
                Cursor cursor;
                Intrinsics.checkNotNullParameter((Object)closeable, (String)"db");
                closeable = closeable.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
                closeable = closeable;
                try {
                    cursor = (Cursor)closeable;
                    boolean bl3 = cursor.moveToFirst();
                    bl = bl2 = false;
                    if (!bl3) break block5;
                }
                catch (Throwable throwable) {
                    try {
                        throw throwable;
                    }
                    catch (Throwable throwable2) {
                        CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
                        throw throwable2;
                    }
                }
                int n = cursor.getInt(0);
                bl = bl2;
                if (n != 0) break block5;
                bl = true;
            }
            CloseableKt.closeFinally((Closeable)closeable, null);
            return bl;
        }

        public final boolean hasRoomMasterTable$room_runtime_release(SupportSQLiteDatabase closeable) {
            boolean bl;
            block5: {
                boolean bl2;
                Cursor cursor;
                Intrinsics.checkNotNullParameter((Object)closeable, (String)"db");
                closeable = closeable.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
                closeable = closeable;
                try {
                    cursor = (Cursor)closeable;
                    boolean bl3 = cursor.moveToFirst();
                    bl = bl2 = false;
                    if (!bl3) break block5;
                }
                catch (Throwable throwable) {
                    try {
                        throw throwable;
                    }
                    catch (Throwable throwable2) {
                        CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
                        throw throwable2;
                    }
                }
                int n = cursor.getInt(0);
                bl = bl2;
                if (n == 0) break block5;
                bl = true;
            }
            CloseableKt.closeFinally((Closeable)closeable, null);
            return bl;
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0015R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Landroidx/room/RoomOpenHelper$Delegate;", "", "version", "", "(I)V", "createAllTables", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "dropAllTables", "onCreate", "onOpen", "onPostMigrate", "onPreMigrate", "onValidateSchema", "Landroidx/room/RoomOpenHelper$ValidationResult;", "db", "validateMigration", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static abstract class Delegate {
        public final int version;

        public Delegate(int n) {
            this.version = n;
        }

        public abstract void createAllTables(SupportSQLiteDatabase var1);

        public abstract void dropAllTables(SupportSQLiteDatabase var1);

        public abstract void onCreate(SupportSQLiteDatabase var1);

        public abstract void onOpen(SupportSQLiteDatabase var1);

        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"database");
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"database");
        }

        public ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
            this.validateMigration(supportSQLiteDatabase);
            return new ValidationResult(true, null);
        }

        @Deprecated(message="Use [onValidateSchema(SupportSQLiteDatabase)]")
        protected void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Landroidx/room/RoomOpenHelper$ValidationResult;", "", "isValid", "", "expectedFoundMsg", "", "(ZLjava/lang/String;)V", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean bl, String string2) {
            this.isValid = bl;
            this.expectedFoundMsg = string2;
        }
    }
}

