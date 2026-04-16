/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl;

import androidx.work.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0002X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"DATABASE_EXTRA_FILES", "", "", "[Ljava/lang/String;", "TAG", "WORK_DATABASE_NAME", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class WorkDatabasePathHelperKt {
    private static final String[] DATABASE_EXTRA_FILES;
    private static final String TAG;
    public static final String WORK_DATABASE_NAME = "androidx.work.workdb";

    static {
        String string2 = Logger.tagWithPrefix("WrkDbPathHelper");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"tagWithPrefix(\"WrkDbPathHelper\")");
        TAG = string2;
        DATABASE_EXTRA_FILES = new String[]{"-journal", "-shm", "-wal"};
    }

    public static final /* synthetic */ String[] access$getDATABASE_EXTRA_FILES$p() {
        return DATABASE_EXTRA_FILES;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }
}

