/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0002"}, d2={"TAG", "", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class BroadcastReceiverConstraintTrackerKt {
    private static final String TAG;

    static {
        String string2 = Logger.tagWithPrefix("BrdcstRcvrCnstrntTrckr");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"tagWithPrefix(\"BrdcstRcvrCnstrntTrckr\")");
        TAG = string2;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }
}

