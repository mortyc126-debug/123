/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.Window
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.activity;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdgeApi23;
import androidx.activity.EdgeToEdgeApi26;
import androidx.activity.EdgeToEdgeApi29;
import androidx.activity.EdgeToEdgeImpl;
import androidx.activity.SystemBarStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u000b\u001a\u00020\f*\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\b\u0011\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"DefaultDarkScrim", "", "getDefaultDarkScrim$annotations", "()V", "getDefaultDarkScrim", "()I", "DefaultLightScrim", "getDefaultLightScrim$annotations", "getDefaultLightScrim", "Impl", "Landroidx/activity/EdgeToEdgeImpl;", "enableEdgeToEdge", "", "Landroidx/activity/ComponentActivity;", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", "enable", "activity_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class EdgeToEdge {
    private static final int DefaultDarkScrim;
    private static final int DefaultLightScrim;
    private static EdgeToEdgeImpl Impl;

    static {
        DefaultLightScrim = Color.argb((int)230, (int)255, (int)255, (int)255);
        DefaultDarkScrim = Color.argb((int)128, (int)27, (int)27, (int)27);
    }

    public static final void enable(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter((Object)componentActivity, (String)"<this>");
        EdgeToEdge.enable$default(componentActivity, null, null, 3, null);
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle) {
        Intrinsics.checkNotNullParameter((Object)componentActivity, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)systemBarStyle, (String)"statusBarStyle");
        EdgeToEdge.enable$default(componentActivity, systemBarStyle, null, 2, null);
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2) {
        Intrinsics.checkNotNullParameter((Object)componentActivity, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)systemBarStyle, (String)"statusBarStyle");
        Intrinsics.checkNotNullParameter((Object)systemBarStyle2, (String)"navigationBarStyle");
        View view = componentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue((Object)view, (String)"window.decorView");
        Object object = systemBarStyle.getDetectDarkMode$activity_release();
        Object object2 = view.getResources();
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"view.resources");
        boolean bl = (Boolean)object.invoke(object2);
        object2 = systemBarStyle2.getDetectDarkMode$activity_release();
        object = view.getResources();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"view.resources");
        boolean bl2 = (Boolean)object2.invoke(object);
        object2 = Impl;
        object = object2;
        if (object2 == null) {
            object = Build.VERSION.SDK_INT >= 29 ? (EdgeToEdgeImpl)new EdgeToEdgeApi29() : (Build.VERSION.SDK_INT >= 26 ? (EdgeToEdgeImpl)new EdgeToEdgeApi26() : (EdgeToEdgeImpl)new EdgeToEdgeApi23());
        }
        componentActivity = componentActivity.getWindow();
        Intrinsics.checkNotNullExpressionValue((Object)componentActivity, (String)"window");
        object.setUp(systemBarStyle, systemBarStyle2, (Window)componentActivity, view, bl, bl2);
    }

    public static /* synthetic */ void enable$default(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, int n, Object object) {
        if ((n & 1) != 0) {
            systemBarStyle = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, 0, 0, null, 4, null);
        }
        if ((n & 2) != 0) {
            systemBarStyle2 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, DefaultLightScrim, DefaultDarkScrim, null, 4, null);
        }
        EdgeToEdge.enable(componentActivity, systemBarStyle, systemBarStyle2);
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }
}

