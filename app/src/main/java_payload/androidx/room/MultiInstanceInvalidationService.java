/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Intent
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteCallbackList
 *  android.os.RemoteException
 *  android.util.Log
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.ExperimentalRoomApi;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalRoomApi
@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2={"Landroidx/room/MultiInstanceInvalidationService;", "Landroid/app/Service;", "()V", "binder", "Landroidx/room/IMultiInstanceInvalidationService$Stub;", "callbackList", "Landroid/os/RemoteCallbackList;", "Landroidx/room/IMultiInstanceInvalidationCallback;", "getCallbackList$room_runtime_release", "()Landroid/os/RemoteCallbackList;", "clientNames", "", "", "", "getClientNames$room_runtime_release", "()Ljava/util/Map;", "maxClientId", "getMaxClientId$room_runtime_release", "()I", "setMaxClientId$room_runtime_release", "(I)V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class MultiInstanceInvalidationService
extends Service {
    private final IMultiInstanceInvalidationService.Stub binder;
    private final RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList;
    private final Map<Integer, String> clientNames = new LinkedHashMap();
    private int maxClientId;

    public MultiInstanceInvalidationService() {
        this.callbackList = (RemoteCallbackList)new RemoteCallbackList<IMultiInstanceInvalidationCallback>(this){
            final MultiInstanceInvalidationService this$0;
            {
                this.this$0 = multiInstanceInvalidationService;
            }

            public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object object) {
                Intrinsics.checkNotNullParameter((Object)iMultiInstanceInvalidationCallback, (String)"callback");
                Intrinsics.checkNotNullParameter((Object)object, (String)"cookie");
                this.this$0.getClientNames$room_runtime_release().remove((Integer)object);
            }
        };
        this.binder = new IMultiInstanceInvalidationService.Stub(this){
            final MultiInstanceInvalidationService this$0;
            {
                this.this$0 = multiInstanceInvalidationService;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void broadcastInvalidation(int n, String[] unit) {
                Intrinsics.checkNotNullParameter((Object)unit, (String)"tables");
                RemoteCallbackList<IMultiInstanceInvalidationCallback> remoteCallbackList = this.this$0.getCallbackList$room_runtime_release();
                MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
                synchronized (remoteCallbackList) {
                    String string2 = multiInstanceInvalidationService.getClientNames$room_runtime_release().get(n);
                    if (string2 == null) {
                        Log.w((String)"ROOM", (String)"Remote invalidation client ID not registered");
                        return;
                    }
                    int n2 = multiInstanceInvalidationService.getCallbackList$room_runtime_release().beginBroadcast();
                    int n3 = 0;
                    while (true) {
                        if (n3 >= n2) {
                            multiInstanceInvalidationService.getCallbackList$room_runtime_release().finishBroadcast();
                            unit = Unit.INSTANCE;
                            return;
                        }
                        try {
                            boolean bl;
                            Object object = multiInstanceInvalidationService.getCallbackList$room_runtime_release().getBroadcastCookie(n3);
                            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlin.Int");
                            int n4 = (Integer)object;
                            object = multiInstanceInvalidationService.getClientNames$room_runtime_release().get(n4);
                            if (n != n4 && (bl = Intrinsics.areEqual((Object)string2, (Object)object))) {
                                try {
                                    ((IMultiInstanceInvalidationCallback)multiInstanceInvalidationService.getCallbackList$room_runtime_release().getBroadcastItem(n3)).onInvalidation((String[])unit);
                                }
                                catch (RemoteException remoteException) {
                                    Log.w((String)"ROOM", (String)"Error invoking a remote callback", (Throwable)remoteException);
                                }
                            }
                            ++n3;
                        }
                        catch (Throwable throwable) {
                            multiInstanceInvalidationService.getCallbackList$room_runtime_release().finishBroadcast();
                            throw throwable;
                        }
                    }
                }
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String string2) {
                Intrinsics.checkNotNullParameter((Object)iMultiInstanceInvalidationCallback, (String)"callback");
                int n = 0;
                if (string2 == null) {
                    return 0;
                }
                RemoteCallbackList<IMultiInstanceInvalidationCallback> remoteCallbackList = this.this$0.getCallbackList$room_runtime_release();
                MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
                synchronized (remoteCallbackList) {
                    block5: {
                        multiInstanceInvalidationService.setMaxClientId$room_runtime_release(multiInstanceInvalidationService.getMaxClientId$room_runtime_release() + 1);
                        int n2 = multiInstanceInvalidationService.getMaxClientId$room_runtime_release();
                        if (!multiInstanceInvalidationService.getCallbackList$room_runtime_release().register((IInterface)iMultiInstanceInvalidationCallback, (Object)n2)) break block5;
                        multiInstanceInvalidationService.getClientNames$room_runtime_release().put(n2, string2);
                        return n2;
                    }
                    multiInstanceInvalidationService.setMaxClientId$room_runtime_release(multiInstanceInvalidationService.getMaxClientId$room_runtime_release() - 1);
                    multiInstanceInvalidationService.getMaxClientId$room_runtime_release();
                    return n;
                }
            }

            public void unregisterCallback(IMultiInstanceInvalidationCallback object, int n) {
                Intrinsics.checkNotNullParameter((Object)object, (String)"callback");
                RemoteCallbackList<IMultiInstanceInvalidationCallback> remoteCallbackList = this.this$0.getCallbackList$room_runtime_release();
                MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
                synchronized (remoteCallbackList) {
                    multiInstanceInvalidationService.getCallbackList$room_runtime_release().unregister((IInterface)object);
                    object = multiInstanceInvalidationService.getClientNames$room_runtime_release().remove(n);
                    return;
                }
            }
        };
    }

    public final RemoteCallbackList<IMultiInstanceInvalidationCallback> getCallbackList$room_runtime_release() {
        return this.callbackList;
    }

    public final Map<Integer, String> getClientNames$room_runtime_release() {
        return this.clientNames;
    }

    public final int getMaxClientId$room_runtime_release() {
        return this.maxClientId;
    }

    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter((Object)intent, (String)"intent");
        return (IBinder)this.binder;
    }

    public final void setMaxClientId$room_runtime_release(int n) {
        this.maxClientId = n;
    }
}

