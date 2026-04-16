/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.util.Log
 */
package linker.resourcer.encoder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SendSms
extends BroadcastReceiver {
    private static final String TAG = "Vhwxmnfes";

    public void onReceive(Context context, Intent intent) {
        Log.d((String)TAG, (String)"Received WAP_PUSH_DELIVER for MMS");
        context = intent.getExtras();
        if (context != null) {
            context.get("data");
            Log.d((String)TAG, (String)("Extras keys: " + context.keySet()));
        }
    }
}

