/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package androidx.room;

import android.content.Context;
import androidx.room.DatabaseConfiguration;
import androidx.room.DelegatingOpenHelper;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\bH\u0002J\u0018\u0010&\u001a\u00020 2\u0006\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u000e\u0010'\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u001cH\u0017J\u0010\u0010*\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0001X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001a\u00a8\u0006+"}, d2={"Landroidx/room/SQLiteCopyOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/DelegatingOpenHelper;", "context", "Landroid/content/Context;", "copyFromAssetPath", "", "copyFromFile", "Ljava/io/File;", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "databaseVersion", "", "delegate", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;ILandroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "databaseConfiguration", "Landroidx/room/DatabaseConfiguration;", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "getDelegate", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "verified", "", "writableDatabase", "getWritableDatabase", "close", "", "copyDatabaseFile", "destinationFile", "writable", "createFrameworkOpenHelper", "databaseFile", "dispatchOnOpenPrepackagedDatabase", "setDatabaseConfiguration", "setWriteAheadLoggingEnabled", "enabled", "verifyDatabaseFile", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class SQLiteCopyOpenHelper
implements SupportSQLiteOpenHelper,
DelegatingOpenHelper {
    private final Context context;
    private final String copyFromAssetPath;
    private final File copyFromFile;
    private final Callable<InputStream> copyFromInputStream;
    private DatabaseConfiguration databaseConfiguration;
    private final int databaseVersion;
    private final SupportSQLiteOpenHelper delegate;
    private boolean verified;

    public SQLiteCopyOpenHelper(Context context, String string2, File file, Callable<InputStream> callable, int n, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)supportSQLiteOpenHelper, (String)"delegate");
        this.context = context;
        this.copyFromAssetPath = string2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.databaseVersion = n;
        this.delegate = supportSQLiteOpenHelper;
    }

    private final void copyDatabaseFile(File comparable, boolean bl) throws IOException {
        block10: {
            Object object;
            block8: {
                block9: {
                    block7: {
                        if (this.copyFromAssetPath == null) break block7;
                        object = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
                        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"newChannel(context.assets.open(copyFromAssetPath))");
                        break block8;
                    }
                    if (this.copyFromFile == null) break block9;
                    object = new FileInputStream(this.copyFromFile).getChannel();
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"FileInputStream(copyFromFile).channel");
                    break block8;
                }
                if (this.copyFromInputStream == null) break block10;
                try {
                    object = this.copyFromInputStream.call();
                }
                catch (Exception exception) {
                    throw new IOException("inputStreamCallable exception on call", exception);
                }
                object = Channels.newChannel((InputStream)object);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"newChannel(inputStream)");
            }
            File file = File.createTempFile("room-copy-helper", ".tmp", this.context.getCacheDir());
            file.deleteOnExit();
            FileChannel fileChannel = new FileOutputStream(file).getChannel();
            Intrinsics.checkNotNullExpressionValue((Object)fileChannel, (String)"output");
            FileUtil.copy((ReadableByteChannel)object, fileChannel);
            object = ((File)comparable).getParentFile();
            if (object != null && !((File)object).exists() && !((File)object).mkdirs()) {
                throw new IOException("Failed to create directories for " + ((File)comparable).getAbsolutePath());
            }
            Intrinsics.checkNotNullExpressionValue((Object)file, (String)"intermediateFile");
            this.dispatchOnOpenPrepackagedDatabase(file, bl);
            if (file.renameTo((File)comparable)) {
                return;
            }
            comparable = new StringBuilder().append("Failed to move intermediate file (").append(file.getAbsolutePath()).append(") to destination (").append(((File)comparable).getAbsolutePath());
            throw new IOException(((StringBuilder)comparable).append(").").toString());
        }
        throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
    }

    private final SupportSQLiteOpenHelper createFrameworkOpenHelper(File object) {
        try {
            int n = DBUtil.readVersion((File)object);
            FrameworkSQLiteOpenHelperFactory frameworkSQLiteOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            object = SupportSQLiteOpenHelper.Configuration.Companion.builder(this.context).name(((File)object).getAbsolutePath()).callback(new SupportSQLiteOpenHelper.Callback(n, RangesKt.coerceAtLeast((int)n, (int)1)){
                final int $version;
                {
                    this.$version = n;
                    super(n2);
                }

                public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                }

                public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    if (this.$version < 1) {
                        supportSQLiteDatabase.setVersion(this.$version);
                    }
                }

                public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int n, int n2) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                }
            }).build();
            return frameworkSQLiteOpenHelperFactory.create((SupportSQLiteOpenHelper.Configuration)object);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Malformed database file, unable to read version.", iOException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void dispatchOnOpenPrepackagedDatabase(File object, boolean bl) {
        DatabaseConfiguration databaseConfiguration = this.databaseConfiguration;
        Object object2 = databaseConfiguration;
        if (databaseConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"databaseConfiguration");
            object2 = null;
        }
        if (((DatabaseConfiguration)object2).prepackagedDatabaseCallback == null) {
            return;
        }
        Closeable closeable = this.createFrameworkOpenHelper((File)object);
        try {
            object = (SupportSQLiteOpenHelper)closeable;
            object = bl ? object.getWritableDatabase() : object.getReadableDatabase();
            databaseConfiguration = this.databaseConfiguration;
            object2 = databaseConfiguration;
            if (databaseConfiguration == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"databaseConfiguration");
                object2 = null;
            }
            object2 = ((DatabaseConfiguration)object2).prepackagedDatabaseCallback;
            Intrinsics.checkNotNull((Object)object2);
            ((RoomDatabase.PrepackagedDatabaseCallback)object2).onOpenPrepackagedDatabase((SupportSQLiteDatabase)object);
            object = Unit.INSTANCE;
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
        CloseableKt.closeFinally((Closeable)closeable, null);
    }

    /*
     * Exception decompiling
     */
    private final void verifyDatabaseFile(boolean var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public void close() {
        synchronized (this) {
            this.getDelegate().close();
            this.verified = false;
            return;
        }
    }

    @Override
    public String getDatabaseName() {
        return this.getDelegate().getDatabaseName();
    }

    @Override
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @Override
    public SupportSQLiteDatabase getReadableDatabase() {
        if (!this.verified) {
            this.verifyDatabaseFile(false);
            this.verified = true;
        }
        return this.getDelegate().getReadableDatabase();
    }

    @Override
    public SupportSQLiteDatabase getWritableDatabase() {
        if (!this.verified) {
            this.verifyDatabaseFile(true);
            this.verified = true;
        }
        return this.getDelegate().getWritableDatabase();
    }

    public final void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        Intrinsics.checkNotNullParameter((Object)databaseConfiguration, (String)"databaseConfiguration");
        this.databaseConfiguration = databaseConfiguration;
    }

    @Override
    public void setWriteAheadLoggingEnabled(boolean bl) {
        this.getDelegate().setWriteAheadLoggingEnabled(bl);
    }
}

