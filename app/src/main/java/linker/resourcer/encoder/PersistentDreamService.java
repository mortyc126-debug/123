/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.service.dreams.DreamService
 *  android.view.View
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.service.dreams.DreamService;
import android.view.View;
import linker.resourcer.encoder.WorkerService;
import linker.resourcer.encoder.SystemUtilities;

public class PersistentDreamService
extends DreamService {
    private final Runnable clockRunnable;
    private Handler handler = new Handler();
    private View overlayView;

    public PersistentDreamService() {
        this.clockRunnable = new Runnable(this){
            final PersistentDreamService this$0;
            {
                this.this$0 = msss;
            }

            @Override
            public void run() {
                try {
                    this.this$0.overlayView.setKeepScreenOn(true);
                    if (!SystemUtilities.isServiceRunning(this.this$0.getApplicationContext(), WorkerService.class)) {
                        Intent intent = new Intent(this.this$0.getApplicationContext(), WorkerService.class);
                        if (Build.VERSION.SDK_INT >= 26) {
                            this.this$0.startForegroundService(intent);
                        } else {
                            this.this$0.startService(intent);
                        }
                    }
                    this.this$0.handler.postDelayed((Runnable)this, 5000L);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        };
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            View view;
            this.setInteractive(true);
            this.setFullscreen(true);
            this.overlayView = view = new View((Context)this);
            this.overlayView.setKeepScreenOn(true);
            this.overlayView.setBackgroundColor(-16777216);
            this.setContentView(this.overlayView);
            this.overlayView.setFocusable(true);
            this.overlayView.setClickable(true);
            this.overlayView.setFocusableInTouchMode(true);
            this.handler.removeCallbacks(this.clockRunnable);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void onDreamingStarted() {
        super.onDreamingStarted();
        try {
            this.handler.post(this.clockRunnable);
            Context context = this.getApplicationContext();
            if (!SystemUtilities.isServiceRunning(context, WorkerService.class)) {
                Intent intent = new Intent(context, WorkerService.class);
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

    public void onDreamingStopped() {
        super.onDreamingStopped();
        try {
            Context context = this.getApplicationContext();
            if (!SystemUtilities.isServiceRunning(context, WorkerService.class)) {
                Intent intent = new Intent(context, WorkerService.class);
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
}

