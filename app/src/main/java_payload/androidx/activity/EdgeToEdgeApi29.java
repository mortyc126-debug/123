/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.Window
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.activity.EdgeToEdgeImpl;
import androidx.activity.SystemBarStyle;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0017\u00a8\u0006\u000f"}, d2={"Landroidx/activity/EdgeToEdgeApi29;", "Landroidx/activity/EdgeToEdgeImpl;", "()V", "setUp", "", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", "window", "Landroid/view/Window;", "view", "Landroid/view/View;", "statusBarIsDark", "", "navigationBarIsDark", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
final class EdgeToEdgeApi29
implements EdgeToEdgeImpl {
    @Override
    public void setUp(SystemBarStyle object, SystemBarStyle systemBarStyle, Window window, View view, boolean bl, boolean bl2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"statusBarStyle");
        Intrinsics.checkNotNullParameter((Object)systemBarStyle, (String)"navigationBarStyle");
        Intrinsics.checkNotNullParameter((Object)window, (String)"window");
        Intrinsics.checkNotNullParameter((Object)view, (String)"view");
        boolean bl3 = false;
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(((SystemBarStyle)object).getScrimWithEnforcedContrast$activity_release(bl));
        window.setNavigationBarColor(systemBarStyle.getScrimWithEnforcedContrast$activity_release(bl2));
        window.setStatusBarContrastEnforced(false);
        if (systemBarStyle.getNightMode$activity_release() == 0) {
            bl3 = true;
        }
        window.setNavigationBarContrastEnforced(bl3);
        object = new WindowInsetsControllerCompat(window, view);
        ((WindowInsetsControllerCompat)object).setAppearanceLightStatusBars(bl ^ true);
        ((WindowInsetsControllerCompat)object).setAppearanceLightNavigationBars(bl2 ^ true);
    }
}

