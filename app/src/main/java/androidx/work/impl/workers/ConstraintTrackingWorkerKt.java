/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.workers;

import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.utils.futures.SettableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"ARGUMENT_CLASS_NAME", "", "TAG", "setFailed", "", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "setRetry", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class ConstraintTrackingWorkerKt {
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME";
    private static final String TAG;

    static {
        String string2 = Logger.tagWithPrefix("ConstraintTrkngWrkr");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"tagWithPrefix(\"ConstraintTrkngWrkr\")");
        TAG = string2;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    public static final /* synthetic */ boolean access$setFailed(SettableFuture settableFuture) {
        return ConstraintTrackingWorkerKt.setFailed(settableFuture);
    }

    public static final /* synthetic */ boolean access$setRetry(SettableFuture settableFuture) {
        return ConstraintTrackingWorkerKt.setRetry(settableFuture);
    }

    private static final boolean setFailed(SettableFuture<ListenableWorker.Result> settableFuture) {
        return settableFuture.set(ListenableWorker.Result.failure());
    }

    private static final boolean setRetry(SettableFuture<ListenableWorker.Result> settableFuture) {
        return settableFuture.set(ListenableWorker.Result.retry());
    }
}

