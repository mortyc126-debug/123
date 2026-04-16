/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.workers.DiagnosticsWorkerKt;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"Landroidx/work/impl/workers/DiagnosticsWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "parameters", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class DiagnosticsWorker
extends Worker {
    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)workerParameters, (String)"parameters");
        super(context, workerParameters);
    }

    @Override
    public ListenableWorker.Result doWork() {
        Object object = WorkManagerImpl.getInstance(this.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getInstance(applicationContext)");
        Object object2 = ((WorkManagerImpl)object).getWorkDatabase();
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"workManager.workDatabase");
        Object object3 = ((WorkDatabase)object2).workSpecDao();
        Object object4 = ((WorkDatabase)object2).workNameDao();
        WorkTagDao workTagDao = ((WorkDatabase)object2).workTagDao();
        object2 = ((WorkDatabase)object2).systemIdInfoDao();
        long l = ((WorkManagerImpl)object).getConfiguration().getClock().currentTimeMillis();
        long l2 = TimeUnit.DAYS.toMillis(1L);
        List<WorkSpec> list = object3.getRecentlyCompletedWork(l - l2);
        object = object3.getRunningWork();
        object3 = object3.getAllEligibleWorkSpecsForScheduling(200);
        if (((Collection)list).isEmpty() ^ true) {
            Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), "Recently completed work:\n\n");
            Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), DiagnosticsWorkerKt.access$workSpecRows((WorkNameDao)object4, workTagDao, (SystemIdInfoDao)object2, list));
        }
        if (((Collection)object).isEmpty() ^ true) {
            Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), "Running work:\n\n");
            Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), DiagnosticsWorkerKt.access$workSpecRows((WorkNameDao)object4, workTagDao, (SystemIdInfoDao)object2, (List)object));
        }
        if (((Collection)object3).isEmpty() ^ true) {
            Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), "Enqueued work:\n\n");
            Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), DiagnosticsWorkerKt.access$workSpecRows((WorkNameDao)object4, workTagDao, (SystemIdInfoDao)object2, (List)object3));
        }
        object4 = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"success()");
        return object4;
    }
}

