/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.activity;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\b\n\u00a8\u0006\u000b"}, d2={"addCallback", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/activity/OnBackPressedDispatcher;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "enabled", "", "onBackPressed", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "activity_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class OnBackPressedDispatcherKt {
    public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean bl, Function1<? super OnBackPressedCallback, Unit> object) {
        Intrinsics.checkNotNullParameter((Object)onBackPressedDispatcher, (String)"<this>");
        Intrinsics.checkNotNullParameter(object, (String)"onBackPressed");
        object = new OnBackPressedCallback(bl, (Function1<? super OnBackPressedCallback, Unit>)object){
            final Function1<OnBackPressedCallback, Unit> $onBackPressed;
            {
                this.$onBackPressed = function1;
                super(bl);
            }

            public void handleOnBackPressed() {
                this.$onBackPressed.invoke((Object)this);
            }
        };
        if (lifecycleOwner != null) {
            onBackPressedDispatcher.addCallback(lifecycleOwner, (OnBackPressedCallback)object);
        } else {
            onBackPressedDispatcher.addCallback((OnBackPressedCallback)object);
        }
        return (OnBackPressedCallback)object;
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean bl, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((n & 2) != 0) {
            bl = true;
        }
        return OnBackPressedDispatcherKt.addCallback(onBackPressedDispatcher, lifecycleOwner, bl, (Function1<? super OnBackPressedCallback, Unit>)function1);
    }
}

