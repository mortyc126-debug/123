/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.fragment.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a-\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a;\u0010\n\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u00a8\u0006\u000b"}, d2={"add", "Landroidx/fragment/app/FragmentTransaction;", "F", "Landroidx/fragment/app/Fragment;", "containerViewId", "", "tag", "", "args", "Landroid/os/Bundle;", "replace", "fragment-ktx_release"}, k=2, mv={1, 6, 0}, xi=48)
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, int n, String object, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)fragmentTransaction, (String)"<this>");
        Intrinsics.reifiedOperationMarker((int)4, (String)"F");
        Class<Fragment> clazz = Fragment.class;
        fragmentTransaction = fragmentTransaction.add(n, Fragment.class, bundle, (String)object);
        Intrinsics.checkNotNullExpressionValue((Object)fragmentTransaction, (String)"add(containerViewId, F::class.java, args, tag)");
        object = fragmentTransaction;
        return fragmentTransaction;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, String object, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)fragmentTransaction, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)object, (String)"tag");
        Intrinsics.reifiedOperationMarker((int)4, (String)"F");
        Class<Fragment> clazz = Fragment.class;
        fragmentTransaction = fragmentTransaction.add(Fragment.class, bundle, (String)object);
        Intrinsics.checkNotNullExpressionValue((Object)fragmentTransaction, (String)"add(F::class.java, args, tag)");
        object = fragmentTransaction;
        return fragmentTransaction;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, int n, String object, Bundle bundle, int n2, Object clazz) {
        if ((n2 & 2) != 0) {
            object = null;
        }
        if ((n2 & 4) != 0) {
            bundle = null;
        }
        Intrinsics.checkNotNullParameter((Object)fragmentTransaction, (String)"<this>");
        Intrinsics.reifiedOperationMarker((int)4, (String)"F");
        clazz = Fragment.class;
        fragmentTransaction = fragmentTransaction.add(n, Fragment.class, bundle, (String)object);
        Intrinsics.checkNotNullExpressionValue((Object)fragmentTransaction, (String)"add(containerViewId, F::class.java, args, tag)");
        object = fragmentTransaction;
        return fragmentTransaction;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, String object, Bundle bundle, int n, Object clazz) {
        if ((n & 2) != 0) {
            bundle = null;
        }
        Intrinsics.checkNotNullParameter((Object)fragmentTransaction, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)object, (String)"tag");
        Intrinsics.reifiedOperationMarker((int)4, (String)"F");
        clazz = Fragment.class;
        fragmentTransaction = fragmentTransaction.add(Fragment.class, bundle, (String)object);
        Intrinsics.checkNotNullExpressionValue((Object)fragmentTransaction, (String)"add(F::class.java, args, tag)");
        object = fragmentTransaction;
        return fragmentTransaction;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction fragmentTransaction, int n, String object, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)fragmentTransaction, (String)"<this>");
        Intrinsics.reifiedOperationMarker((int)4, (String)"F");
        Class<Fragment> clazz = Fragment.class;
        object = fragmentTransaction.replace(n, Fragment.class, bundle, (String)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"replace(containerViewId, F::class.java, args, tag)");
        fragmentTransaction = (FragmentTransaction)object;
        return object;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction fragmentTransaction, int n, String object, Bundle bundle, int n2, Object clazz) {
        if ((n2 & 2) != 0) {
            object = null;
        }
        if ((n2 & 4) != 0) {
            bundle = null;
        }
        Intrinsics.checkNotNullParameter((Object)fragmentTransaction, (String)"<this>");
        Intrinsics.reifiedOperationMarker((int)4, (String)"F");
        clazz = Fragment.class;
        fragmentTransaction = fragmentTransaction.replace(n, Fragment.class, bundle, (String)object);
        Intrinsics.checkNotNullExpressionValue((Object)fragmentTransaction, (String)"replace(containerViewId, F::class.java, args, tag)");
        object = fragmentTransaction;
        return fragmentTransaction;
    }
}

