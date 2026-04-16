/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.util.Log
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.MultiInstanceInvalidationClient$$ExternalSyntheticLambda0;
import androidx.room.MultiInstanceInvalidationClient$$ExternalSyntheticLambda1;
import androidx.room.MultiInstanceInvalidationClient$callback$1$$ExternalSyntheticLambda0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u00109\u001a\u00020:R\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u000200\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0011\u00105\u001a\u000206\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108\u00a8\u0006;"}, d2={"Landroidx/room/MultiInstanceInvalidationClient;", "", "context", "Landroid/content/Context;", "name", "", "serviceIntent", "Landroid/content/Intent;", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "executor", "Ljava/util/concurrent/Executor;", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroidx/room/InvalidationTracker;Ljava/util/concurrent/Executor;)V", "appContext", "kotlin.jvm.PlatformType", "callback", "Landroidx/room/IMultiInstanceInvalidationCallback;", "getCallback", "()Landroidx/room/IMultiInstanceInvalidationCallback;", "clientId", "", "getClientId", "()I", "setClientId", "(I)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "getInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "getName", "()Ljava/lang/String;", "observer", "Landroidx/room/InvalidationTracker$Observer;", "getObserver", "()Landroidx/room/InvalidationTracker$Observer;", "setObserver", "(Landroidx/room/InvalidationTracker$Observer;)V", "removeObserverRunnable", "Ljava/lang/Runnable;", "getRemoveObserverRunnable", "()Ljava/lang/Runnable;", "service", "Landroidx/room/IMultiInstanceInvalidationService;", "getService", "()Landroidx/room/IMultiInstanceInvalidationService;", "setService", "(Landroidx/room/IMultiInstanceInvalidationService;)V", "serviceConnection", "Landroid/content/ServiceConnection;", "getServiceConnection", "()Landroid/content/ServiceConnection;", "setUpRunnable", "getSetUpRunnable", "stopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getStopped", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "stop", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class MultiInstanceInvalidationClient {
    private final Context appContext;
    private final IMultiInstanceInvalidationCallback callback;
    private int clientId;
    private final Executor executor;
    private final InvalidationTracker invalidationTracker;
    private final String name;
    public InvalidationTracker.Observer observer;
    private final Runnable removeObserverRunnable;
    private IMultiInstanceInvalidationService service;
    private final ServiceConnection serviceConnection;
    private final Runnable setUpRunnable;
    private final AtomicBoolean stopped;

    public static /* synthetic */ void $r8$lambda$OUFtvTStWETjeJxrBwS2HtXq3VE(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        MultiInstanceInvalidationClient.setUpRunnable$lambda$1(multiInstanceInvalidationClient);
    }

    public static /* synthetic */ void $r8$lambda$at7cvPuqmY8Y6FAv2N0cZPhRid0(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        MultiInstanceInvalidationClient.removeObserverRunnable$lambda$2(multiInstanceInvalidationClient);
    }

    public MultiInstanceInvalidationClient(Context context, String string2, Intent intent, InvalidationTracker invalidationTracker, Executor executor) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        Intrinsics.checkNotNullParameter((Object)intent, (String)"serviceIntent");
        Intrinsics.checkNotNullParameter((Object)invalidationTracker, (String)"invalidationTracker");
        Intrinsics.checkNotNullParameter((Object)executor, (String)"executor");
        this.name = string2;
        this.invalidationTracker = invalidationTracker;
        this.executor = executor;
        this.appContext = context.getApplicationContext();
        this.callback = new IMultiInstanceInvalidationCallback.Stub(this){
            final MultiInstanceInvalidationClient this$0;

            public static /* synthetic */ void $r8$lambda$YbA_oLvwgwIT6Ag339-3Mj03vfc(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] stringArray) {
                callback.1.onInvalidation$lambda$0(multiInstanceInvalidationClient, stringArray);
            }
            {
                this.this$0 = multiInstanceInvalidationClient;
            }

            private static final void onInvalidation$lambda$0(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] stringArray) {
                Intrinsics.checkNotNullParameter((Object)multiInstanceInvalidationClient, (String)"this$0");
                Intrinsics.checkNotNullParameter((Object)stringArray, (String)"$tables");
                multiInstanceInvalidationClient.getInvalidationTracker().notifyObserversByTableNames(Arrays.copyOf(stringArray, stringArray.length));
            }

            public void onInvalidation(String[] stringArray) {
                Intrinsics.checkNotNullParameter((Object)stringArray, (String)"tables");
                this.this$0.getExecutor().execute(new MultiInstanceInvalidationClient$callback$1$$ExternalSyntheticLambda0(this.this$0, stringArray));
            }
        };
        this.stopped = new AtomicBoolean(false);
        this.serviceConnection = new ServiceConnection(this){
            final MultiInstanceInvalidationClient this$0;
            {
                this.this$0 = multiInstanceInvalidationClient;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Intrinsics.checkNotNullParameter((Object)componentName, (String)"name");
                Intrinsics.checkNotNullParameter((Object)iBinder, (String)"service");
                this.this$0.setService(IMultiInstanceInvalidationService.Stub.asInterface(iBinder));
                this.this$0.getExecutor().execute(this.this$0.getSetUpRunnable());
            }

            public void onServiceDisconnected(ComponentName componentName) {
                Intrinsics.checkNotNullParameter((Object)componentName, (String)"name");
                this.this$0.getExecutor().execute(this.this$0.getRemoveObserverRunnable());
                this.this$0.setService(null);
            }
        };
        this.setUpRunnable = new MultiInstanceInvalidationClient$$ExternalSyntheticLambda0(this);
        this.removeObserverRunnable = new MultiInstanceInvalidationClient$$ExternalSyntheticLambda1(this);
        context = ((Collection)this.invalidationTracker.getTableIdLookup$room_runtime_release().keySet()).toArray(new String[0]);
        Intrinsics.checkNotNull((Object)context, (String)"null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.setObserver(new InvalidationTracker.Observer(this, (String[])context){
            final MultiInstanceInvalidationClient this$0;
            {
                this.this$0 = multiInstanceInvalidationClient;
                super(stringArray);
            }

            @Override
            public boolean isRemote$room_runtime_release() {
                return true;
            }

            @Override
            public void onInvalidated(Set<String> stringArray) {
                block4: {
                    Intrinsics.checkNotNullParameter(stringArray, (String)"tables");
                    if (this.this$0.getStopped().get()) {
                        return;
                    }
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.this$0.getService();
                    if (iMultiInstanceInvalidationService == null) break block4;
                    try {
                        int n = this.this$0.getClientId();
                        stringArray = ((Collection)stringArray).toArray(new String[0]);
                        Intrinsics.checkNotNull((Object)stringArray, (String)"null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        iMultiInstanceInvalidationService.broadcastInvalidation(n, stringArray);
                    }
                    catch (RemoteException remoteException) {
                        Log.w((String)"ROOM", (String)"Cannot broadcast invalidation", (Throwable)remoteException);
                    }
                }
            }
        });
        context = this.appContext;
        string2 = this.serviceConnection;
        context.bindService(intent, (ServiceConnection)string2, 1);
    }

    private static final void removeObserverRunnable$lambda$2(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        Intrinsics.checkNotNullParameter((Object)multiInstanceInvalidationClient, (String)"this$0");
        multiInstanceInvalidationClient.invalidationTracker.removeObserver(multiInstanceInvalidationClient.getObserver());
    }

    private static final void setUpRunnable$lambda$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        block3: {
            Intrinsics.checkNotNullParameter((Object)multiInstanceInvalidationClient, (String)"this$0");
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.service;
            if (iMultiInstanceInvalidationService == null) break block3;
            try {
                multiInstanceInvalidationClient.clientId = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.callback, multiInstanceInvalidationClient.name);
                multiInstanceInvalidationClient.invalidationTracker.addObserver(multiInstanceInvalidationClient.getObserver());
            }
            catch (RemoteException remoteException) {
                Log.w((String)"ROOM", (String)"Cannot register multi-instance invalidation callback", (Throwable)remoteException);
            }
        }
    }

    public final IMultiInstanceInvalidationCallback getCallback() {
        return this.callback;
    }

    public final int getClientId() {
        return this.clientId;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public final String getName() {
        return this.name;
    }

    public final InvalidationTracker.Observer getObserver() {
        InvalidationTracker.Observer observer2 = this.observer;
        if (observer2 != null) {
            return observer2;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"observer");
        return null;
    }

    public final Runnable getRemoveObserverRunnable() {
        return this.removeObserverRunnable;
    }

    public final IMultiInstanceInvalidationService getService() {
        return this.service;
    }

    public final ServiceConnection getServiceConnection() {
        return this.serviceConnection;
    }

    public final Runnable getSetUpRunnable() {
        return this.setUpRunnable;
    }

    public final AtomicBoolean getStopped() {
        return this.stopped;
    }

    public final void setClientId(int n) {
        this.clientId = n;
    }

    public final void setObserver(InvalidationTracker.Observer observer2) {
        Intrinsics.checkNotNullParameter((Object)observer2, (String)"<set-?>");
        this.observer = observer2;
    }

    public final void setService(IMultiInstanceInvalidationService iMultiInstanceInvalidationService) {
        this.service = iMultiInstanceInvalidationService;
    }

    public final void stop() {
        if (this.stopped.compareAndSet(false, true)) {
            block4: {
                this.invalidationTracker.removeObserver(this.getObserver());
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.service;
                if (iMultiInstanceInvalidationService == null) break block4;
                try {
                    iMultiInstanceInvalidationService.unregisterCallback(this.callback, this.clientId);
                }
                catch (RemoteException remoteException) {
                    Log.w((String)"ROOM", (String)"Cannot unregister multi-instance invalidation callback", (Throwable)remoteException);
                }
            }
            this.appContext.unbindService(this.serviceConnection);
        }
    }
}

