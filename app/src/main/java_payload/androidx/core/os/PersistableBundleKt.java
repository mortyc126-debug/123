/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.PersistableBundle
 *  kotlin.Metadata
 *  kotlin.Pair
 */
package androidx.core.os;

import android.os.PersistableBundle;
import androidx.core.os.PersistableBundleApi21ImplKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a=\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007\u00a2\u0006\u0002\u0010\u0007\u001a\u001a\u0010\b\u001a\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tH\u0007\u00a8\u0006\n"}, d2={"persistableBundleOf", "Landroid/os/PersistableBundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/PersistableBundle;", "toPersistableBundle", "", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class PersistableBundleKt {
    public static final PersistableBundle persistableBundleOf() {
        return PersistableBundleApi21ImplKt.createPersistableBundle(0);
    }

    public static final PersistableBundle persistableBundleOf(Pair<String, ? extends Object> ... pairArray) {
        PersistableBundle persistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(pairArray.length);
        for (Pair<String, ? extends Object> pair : pairArray) {
            PersistableBundleApi21ImplKt.putValue(persistableBundle, (String)pair.component1(), pair.component2());
        }
        return persistableBundle;
    }

    public static final PersistableBundle toPersistableBundle(Map<String, ? extends Object> object) {
        PersistableBundle persistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(object.size());
        for (Map.Entry entry : object.entrySet()) {
            PersistableBundleApi21ImplKt.putValue(persistableBundle, (String)entry.getKey(), entry.getValue());
        }
        return persistableBundle;
    }
}

