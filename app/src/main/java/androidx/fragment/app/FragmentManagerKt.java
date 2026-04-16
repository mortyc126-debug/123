/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.fragment.app;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\bH\u0086\b\u00f8\u0001\u0000\u001a3\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\bH\u0086\b\u00f8\u0001\u0000\u001a=\u0010\n\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\bH\u0087\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\f"}, d2={"commit", "", "Landroidx/fragment/app/FragmentManager;", "allowStateLoss", "", "body", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/ExtensionFunctionType;", "commitNow", "transaction", "now", "fragment-ktx_release"}, k=2, mv={1, 6, 0}, xi=48)
public final class FragmentManagerKt {
    public static final void commit(FragmentManager object, boolean bl, Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter(function1, (String)"body");
        object = ((FragmentManager)object).beginTransaction();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"beginTransaction()");
        function1.invoke(object);
        if (bl) {
            ((FragmentTransaction)object).commitAllowingStateLoss();
        } else {
            ((FragmentTransaction)object).commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager object, boolean bl, Function1 function1, int n, Object object2) {
        if ((n & 1) != 0) {
            bl = false;
        }
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)function1, (String)"body");
        object = ((FragmentManager)object).beginTransaction();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"beginTransaction()");
        function1.invoke(object);
        if (bl) {
            ((FragmentTransaction)object).commitAllowingStateLoss();
        } else {
            ((FragmentTransaction)object).commit();
        }
    }

    public static final void commitNow(FragmentManager object, boolean bl, Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter(function1, (String)"body");
        object = ((FragmentManager)object).beginTransaction();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"beginTransaction()");
        function1.invoke(object);
        if (bl) {
            ((FragmentTransaction)object).commitNowAllowingStateLoss();
        } else {
            ((FragmentTransaction)object).commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager object, boolean bl, Function1 function1, int n, Object object2) {
        if ((n & 1) != 0) {
            bl = false;
        }
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)function1, (String)"body");
        object = ((FragmentManager)object).beginTransaction();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"beginTransaction()");
        function1.invoke(object);
        if (bl) {
            ((FragmentTransaction)object).commitNowAllowingStateLoss();
        } else {
            ((FragmentTransaction)object).commitNow();
        }
    }

    @Deprecated(message="Use commit { .. } or commitNow { .. } extensions")
    public static final void transaction(FragmentManager object, boolean bl, boolean bl2, Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter(function1, (String)"body");
        object = ((FragmentManager)object).beginTransaction();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"beginTransaction()");
        function1.invoke(object);
        if (bl) {
            if (bl2) {
                ((FragmentTransaction)object).commitNowAllowingStateLoss();
            } else {
                ((FragmentTransaction)object).commitNow();
            }
        } else if (bl2) {
            ((FragmentTransaction)object).commitAllowingStateLoss();
        } else {
            ((FragmentTransaction)object).commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager object, boolean bl, boolean bl2, Function1 function1, int n, Object object2) {
        if ((n & 1) != 0) {
            bl = false;
        }
        if ((n & 2) != 0) {
            bl2 = false;
        }
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)function1, (String)"body");
        object = ((FragmentManager)object).beginTransaction();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"beginTransaction()");
        function1.invoke(object);
        if (bl) {
            if (bl2) {
                ((FragmentTransaction)object).commitNowAllowingStateLoss();
            } else {
                ((FragmentTransaction)object).commitNow();
            }
        } else if (bl2) {
            ((FragmentTransaction)object).commitAllowingStateLoss();
        } else {
            ((FragmentTransaction)object).commit();
        }
    }
}

