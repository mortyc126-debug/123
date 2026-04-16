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
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"Landroidx/work/impl/workers/CombineContinuationsWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class CombineContinuationsWorker
extends Worker {
    public CombineContinuationsWorker(Context context, WorkerParameters workerParameters) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)workerParameters, (String)"workerParams");
        super(context, workerParameters);
    }

    @Override
    public ListenableWorker.Result doWork() {
        ListenableWorker.Result result2 = ListenableWorker.Result.success(this.getInputData());
        Intrinsics.checkNotNullExpressionValue((Object)result2, (String)"success(inputData)");
        return result2;
    }
}

