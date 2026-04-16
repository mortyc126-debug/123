/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.strictmode.RetainInstanceUsageViolation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Landroidx/fragment/app/strictmode/GetRetainInstanceUsageViolation;", "Landroidx/fragment/app/strictmode/RetainInstanceUsageViolation;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "fragment_release"}, k=1, mv={1, 6, 0}, xi=48)
public final class GetRetainInstanceUsageViolation
extends RetainInstanceUsageViolation {
    public GetRetainInstanceUsageViolation(Fragment fragment) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"fragment");
        super(fragment, "Attempting to get retain instance for fragment " + fragment);
    }
}

