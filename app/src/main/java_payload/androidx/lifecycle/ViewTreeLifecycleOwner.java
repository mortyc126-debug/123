/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 */
package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.runtime.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u00a2\u0006\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0007\u00a2\u0006\u0002\b\u0007\u00a8\u0006\b"}, d2={"findViewTreeLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/view/View;", "get", "setViewTreeLifecycleOwner", "", "lifecycleOwner", "set", "lifecycle-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class ViewTreeLifecycleOwner {
    public static final LifecycleOwner get(View view) {
        Intrinsics.checkNotNullParameter((Object)view, (String)"<this>");
        return (LifecycleOwner)SequencesKt.firstOrNull((Sequence)SequencesKt.mapNotNull((Sequence)SequencesKt.generateSequence((Object)view, (Function1)findViewTreeLifecycleOwner.1.INSTANCE), (Function1)findViewTreeLifecycleOwner.2.INSTANCE));
    }

    public static final void set(View view, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter((Object)view, (String)"<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, (Object)lifecycleOwner);
    }
}

