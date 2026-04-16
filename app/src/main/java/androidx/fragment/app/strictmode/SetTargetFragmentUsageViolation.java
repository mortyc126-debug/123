/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.strictmode.TargetFragmentUsageViolation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Landroidx/fragment/app/strictmode/SetTargetFragmentUsageViolation;", "Landroidx/fragment/app/strictmode/TargetFragmentUsageViolation;", "fragment", "Landroidx/fragment/app/Fragment;", "targetFragment", "requestCode", "", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;I)V", "getRequestCode", "()I", "getTargetFragment", "()Landroidx/fragment/app/Fragment;", "fragment_release"}, k=1, mv={1, 6, 0}, xi=48)
public final class SetTargetFragmentUsageViolation
extends TargetFragmentUsageViolation {
    private final int requestCode;
    private final Fragment targetFragment;

    public SetTargetFragmentUsageViolation(Fragment fragment, Fragment fragment2, int n) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"fragment");
        Intrinsics.checkNotNullParameter((Object)fragment2, (String)"targetFragment");
        StringBuilder stringBuilder = new StringBuilder().append("Attempting to set target fragment ").append(fragment2).append(" with request code ");
        stringBuilder = stringBuilder.append(n);
        stringBuilder = stringBuilder.append(" for fragment ");
        super(fragment, stringBuilder.append(fragment).toString());
        this.targetFragment = fragment2;
        this.requestCode = n;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final Fragment getTargetFragment() {
        return this.targetFragment;
    }
}

