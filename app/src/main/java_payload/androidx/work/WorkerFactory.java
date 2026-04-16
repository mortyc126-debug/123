/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;

public abstract class WorkerFactory {
    private static final String TAG = Logger.tagWithPrefix("WorkerFactory");

    public static WorkerFactory getDefaultWorkerFactory() {
        return new WorkerFactory(){

            @Override
            public ListenableWorker createWorker(Context context, String string2, WorkerParameters workerParameters) {
                return null;
            }
        };
    }

    public abstract ListenableWorker createWorker(Context var1, String var2, WorkerParameters var3);

    public final ListenableWorker createWorkerWithDefaultFallback(Context object, String string2, WorkerParameters workerParameters) {
        ListenableWorker listenableWorker = this.createWorker((Context)object, string2, workerParameters);
        Object object2 = listenableWorker;
        if (listenableWorker == null) {
            Object object3 = null;
            try {
                object3 = object2 = Class.forName(string2).asSubclass(ListenableWorker.class);
            }
            catch (Throwable throwable) {
                Logger.get().error(TAG, "Invalid class: " + string2, throwable);
            }
            object2 = listenableWorker;
            if (object3 != null) {
                try {
                    object2 = (ListenableWorker)((Class)object3).getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(object, workerParameters);
                }
                catch (Throwable throwable) {
                    Logger.get().error(TAG, "Could not instantiate " + string2, throwable);
                    object2 = listenableWorker;
                }
            }
        }
        if (object2 != null && ((ListenableWorker)object2).isUsed()) {
            object = this.getClass().getName();
            throw new IllegalStateException("WorkerFactory (" + (String)object + ") returned an instance of a ListenableWorker (" + string2 + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
        }
        return object2;
    }
}

