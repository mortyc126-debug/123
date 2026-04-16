/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package androidx.work.impl;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.Api21Impl;
import androidx.work.impl.WorkDatabasePathHelperKt;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\r"}, d2={"Landroidx/work/impl/WorkDatabasePathHelper;", "", "()V", "getDatabasePath", "Ljava/io/File;", "context", "Landroid/content/Context;", "getDefaultDatabasePath", "getNoBackupPath", "migrateDatabase", "", "migrationPaths", "", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class WorkDatabasePathHelper {
    public static final WorkDatabasePathHelper INSTANCE = new WorkDatabasePathHelper();

    private WorkDatabasePathHelper() {
    }

    private final File getNoBackupPath(Context context) {
        return new File(Api21Impl.INSTANCE.getNoBackupFilesDir(context), "androidx.work.workdb");
    }

    @JvmStatic
    public static final void migrateDatabase(Context object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"context");
        if (INSTANCE.getDefaultDatabasePath((Context)object).exists()) {
            Logger.get().debug(WorkDatabasePathHelperKt.access$getTAG$p(), "Migrating WorkDatabase to the no-backup directory");
            for (Map.Entry<File, File> entry : INSTANCE.migrationPaths((Context)object).entrySet()) {
                object = entry.getKey();
                File object2 = entry.getValue();
                if (!((File)object).exists()) continue;
                if (object2.exists()) {
                    Logger.get().warning(WorkDatabasePathHelperKt.access$getTAG$p(), "Over-writing contents of " + object2);
                }
                object = ((File)object).renameTo(object2) ? "Migrated " + object + "to " + object2 : "Renaming " + object + " to " + object2 + " failed";
                Logger.get().debug(WorkDatabasePathHelperKt.access$getTAG$p(), (String)object);
            }
        }
    }

    public final File getDatabasePath(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return this.getNoBackupPath(context);
    }

    public final File getDefaultDatabasePath(Context object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"context");
        object = object.getDatabasePath("androidx.work.workdb");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"context.getDatabasePath(WORK_DATABASE_NAME)");
        return object;
    }

    public final Map<File, File> migrationPaths(Context stringArray) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"context");
        File file = this.getDefaultDatabasePath((Context)stringArray);
        File file2 = this.getDatabasePath((Context)stringArray);
        String[] stringArray2 = WorkDatabasePathHelperKt.access$getDATABASE_EXTRA_FILES$p();
        Map map2 = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)stringArray2.length), (int)16));
        int n = stringArray2.length;
        stringArray = stringArray2;
        for (int i = 0; i < n; ++i) {
            String string2 = stringArray2[i];
            string2 = TuplesKt.to((Object)new File(file.getPath() + string2), (Object)new File(file2.getPath() + string2));
            map2.put(string2.getFirst(), string2.getSecond());
        }
        return MapsKt.plus((Map)map2, (Pair)TuplesKt.to((Object)file, (Object)file2));
    }
}

