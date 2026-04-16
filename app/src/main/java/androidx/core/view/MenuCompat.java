/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.Menu
 *  android.view.MenuItem
 */
package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenu;

public final class MenuCompat {
    private MenuCompat() {
    }

    public static void setGroupDividerEnabled(Menu menu, boolean bl) {
        if (menu instanceof SupportMenu) {
            ((SupportMenu)menu).setGroupDividerEnabled(bl);
        } else if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setGroupDividerEnabled(menu, bl);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int n) {
        menuItem.setShowAsAction(n);
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static void setGroupDividerEnabled(Menu menu, boolean bl) {
            menu.setGroupDividerEnabled(bl);
        }
    }
}

