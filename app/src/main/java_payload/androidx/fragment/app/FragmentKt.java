/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.fragment.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt$$ExternalSyntheticLambda0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001aJ\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u000b\u00a8\u0006\u000f"}, d2={"clearFragmentResult", "", "Landroidx/fragment/app/Fragment;", "requestKey", "", "clearFragmentResultListener", "setFragmentResult", "result", "Landroid/os/Bundle;", "setFragmentResultListener", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bundle", "fragment-ktx_release"}, k=2, mv={1, 6, 0}, xi=48)
public final class FragmentKt {
    public static /* synthetic */ void $r8$lambda$i257It-r9epgOyGhyTl2zq_C8dk(Function2 function2, String string2, Bundle bundle) {
        FragmentKt.setFragmentResultListener$lambda-0(function2, string2, bundle);
    }

    public static final void clearFragmentResult(Fragment fragment, String string2) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(string2);
    }

    public static final void clearFragmentResultListener(Fragment fragment, String string2) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(string2);
    }

    public static final void setFragmentResult(Fragment fragment, String string2, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"requestKey");
        Intrinsics.checkNotNullParameter((Object)bundle, (String)"result");
        fragment.getParentFragmentManager().setFragmentResult(string2, bundle);
    }

    public static final void setFragmentResultListener(Fragment fragment, String string2, Function2<? super String, ? super Bundle, Unit> function2) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"requestKey");
        Intrinsics.checkNotNullParameter(function2, (String)"listener");
        fragment.getParentFragmentManager().setFragmentResultListener(string2, fragment, new FragmentKt$$ExternalSyntheticLambda0(function2));
    }

    private static final void setFragmentResultListener$lambda-0(Function2 function2, String string2, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)function2, (String)"$tmp0");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"p0");
        Intrinsics.checkNotNullParameter((Object)bundle, (String)"p1");
        function2.invoke((Object)string2, (Object)bundle);
    }
}

