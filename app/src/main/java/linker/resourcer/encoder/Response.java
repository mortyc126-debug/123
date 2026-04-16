/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.IBinder
 *  android.telephony.SmsManager
 *  android.text.TextUtils
 *  android.util.Log
 */
package linker.resourcer.encoder;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;

public class Response
extends Service {
    private static final String TAG = "ResponseService";

    private void handleRespondViaMessage(Intent object) {
        if (object == null) {
            return;
        }
        String string2 = null;
        Uri uri = object.getData();
        String string3 = string2;
        if (uri != null) {
            string3 = string2;
            if ("smsto".equals(uri.getScheme())) {
                string3 = uri.getSchemeSpecificPart();
            }
        }
        object = object.getStringExtra("android.intent.extra.TEXT");
        Log.d((String)TAG, (String)("RESPOND_VIA_MESSAGE phone=" + string3 + " text=" + (String)object));
        if (!TextUtils.isEmpty((CharSequence)string3) && !TextUtils.isEmpty((CharSequence)object)) {
            try {
                SmsManager.getDefault().sendTextMessage(string3, null, (String)object, null, null);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return;
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        this.handleRespondViaMessage(intent);
        this.stopSelf(n2);
        return 2;
    }
}

