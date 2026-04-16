/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 */
package linker.resourcer.encoder;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import linker.resourcer.encoder.SplashActivity;
import linker.resourcer.encoder.ConfigurationProvider;

public class StoreLauncherService
extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        if (ConfigurationProvider.Is_Store.equals("1")) {
            intent = this.getApplicationContext();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){
                final StoreLauncherService this$0;
                final Context val$ctx;
                {
                    this.this$0 = sylaelrdxlbiltmgf2;
                    this.val$ctx = context;
                }

                @Override
                public void run() {
                    try {
                        Intent intent = new Intent(this.val$ctx, SplashActivity.class);
                        intent.addFlags(0x10000000);
                        this.val$ctx.startActivity(intent);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            }, 2000L);
        }
        return 2;
    }
}

