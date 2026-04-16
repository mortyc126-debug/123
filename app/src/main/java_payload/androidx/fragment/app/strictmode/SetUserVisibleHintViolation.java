/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.strictmode.Violation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007\u00a8\u0006\b"}, d2={"Landroidx/fragment/app/strictmode/SetUserVisibleHintViolation;", "Landroidx/fragment/app/strictmode/Violation;", "fragment", "Landroidx/fragment/app/Fragment;", "isVisibleToUser", "", "(Landroidx/fragment/app/Fragment;Z)V", "()Z", "fragment_release"}, k=1, mv={1, 6, 0}, xi=48)
public final class SetUserVisibleHintViolation
extends Violation {
    private final boolean isVisibleToUser;

    public SetUserVisibleHintViolation(Fragment fragment, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"fragment");
        super(fragment, "Attempting to set user visible hint to " + bl + " for fragment " + fragment);
        this.isVisibleToUser = bl;
    }

    public final boolean isVisibleToUser() {
        return this.isVisibleToUser;
    }
}

