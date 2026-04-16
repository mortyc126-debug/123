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
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DelegatingWorkerFactory
extends WorkerFactory {
    private static final String TAG = Logger.tagWithPrefix("DelegatingWkrFctry");
    private final List<WorkerFactory> mFactories = new CopyOnWriteArrayList<WorkerFactory>();

    public final void addFactory(WorkerFactory workerFactory) {
        this.mFactories.add(workerFactory);
    }

    @Override
    public final ListenableWorker createWorker(Context context, String string2, WorkerParameters workerParameters) {
        for (WorkerFactory workerFactory : this.mFactories) {
            try {
                ListenableWorker object = workerFactory.createWorker(context, string2, workerParameters);
                if (object == null) continue;
                return object;
            }
            catch (Throwable throwable) {
                string2 = "Unable to instantiate a ListenableWorker (" + string2 + ")";
                Logger.get().error(TAG, string2, throwable);
                throw throwable;
            }
        }
        return null;
    }

    List<WorkerFactory> getFactories() {
        return this.mFactories;
    }
}

