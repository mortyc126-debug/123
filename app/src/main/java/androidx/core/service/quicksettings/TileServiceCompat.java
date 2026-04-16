/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.service.quicksettings.TileService
 */
package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.TileService;
import androidx.core.service.quicksettings.PendingIntentActivityWrapper;

public class TileServiceCompat {
    private static TileServiceWrapper sTileServiceWrapper;

    private TileServiceCompat() {
    }

    public static void clearTileServiceWrapper() {
        sTileServiceWrapper = null;
    }

    public static void setTileServiceWrapper(TileServiceWrapper tileServiceWrapper) {
        sTileServiceWrapper = tileServiceWrapper;
    }

    public static void startActivityAndCollapse(TileService tileService, PendingIntentActivityWrapper pendingIntentActivityWrapper) {
        if (Build.VERSION.SDK_INT >= 34) {
            if (sTileServiceWrapper != null) {
                sTileServiceWrapper.startActivityAndCollapse(pendingIntentActivityWrapper.getPendingIntent());
            } else {
                Api34Impl.startActivityAndCollapse(tileService, pendingIntentActivityWrapper.getPendingIntent());
            }
        } else if (sTileServiceWrapper != null) {
            sTileServiceWrapper.startActivityAndCollapse(pendingIntentActivityWrapper.getIntent());
        } else {
            Api24Impl.startActivityAndCollapse(tileService, pendingIntentActivityWrapper.getIntent());
        }
    }

    private static class Api24Impl {
        private Api24Impl() {
        }

        static void startActivityAndCollapse(TileService tileService, Intent intent) {
            tileService.startActivityAndCollapse(intent);
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static void startActivityAndCollapse(TileService tileService, PendingIntent pendingIntent) {
            tileService.startActivityAndCollapse(pendingIntent);
        }
    }

    static interface TileServiceWrapper {
        public void startActivityAndCollapse(PendingIntent var1);

        public void startActivityAndCollapse(Intent var1);
    }
}

