/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Handler
 *  android.os.Message
 *  android.util.Log
 */
package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock;
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts;
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> mReceivers = new HashMap();

    static {
        mLock = new Object();
    }

    private LocalBroadcastManager(Context context) {
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = context;
        this.mHandler = new Handler(this, context.getMainLooper()){
            final LocalBroadcastManager this$0;
            {
                this.this$0 = localBroadcastManager;
                super(looper);
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    default: {
                        super.handleMessage(message);
                        break;
                    }
                    case 1: {
                        this.this$0.executePendingBroadcasts();
                    }
                }
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static LocalBroadcastManager getInstance(Context object) {
        Object object2 = mLock;
        synchronized (object2) {
            LocalBroadcastManager localBroadcastManager;
            if (mInstance != null) return mInstance;
            mInstance = localBroadcastManager = new LocalBroadcastManager(object.getApplicationContext());
            return mInstance;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void executePendingBroadcasts() {
        Throwable throwable2;
        block5: while (true) {
            BroadcastRecord[] broadcastRecordArray;
            int n;
            Object object = this.mReceivers;
            synchronized (object) {
                n = this.mPendingBroadcasts.size();
                if (n <= 0) {
                    return;
                }
                broadcastRecordArray = new BroadcastRecord[n];
                try {
                    this.mPendingBroadcasts.toArray(broadcastRecordArray);
                    this.mPendingBroadcasts.clear();
                    // MONITOREXIT @DISABLED, blocks:[1, 3, 5] lbl13 : MonitorExitStatement: MONITOREXIT : var5_6
                    n = 0;
                }
                catch (Throwable throwable2) {
                    break;
                }
            }
            while (true) {
                if (n >= broadcastRecordArray.length) continue block5;
                object = broadcastRecordArray[n];
                int n2 = ((BroadcastRecord)object).receivers.size();
                for (int i = 0; i < n2; ++i) {
                    ReceiverRecord receiverRecord = ((BroadcastRecord)object).receivers.get(i);
                    if (receiverRecord.dead) continue;
                    receiverRecord.receiver.onReceive(this.mAppContext, ((BroadcastRecord)object).intent);
                }
                ++n;
            }
            break;
        }
        {
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerReceiver(BroadcastReceiver object, IntentFilter intentFilter) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> hashMap = this.mReceivers;
        synchronized (hashMap) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, (BroadcastReceiver)object);
            Object object2 = this.mReceivers.get(object);
            ArrayList<ReceiverRecord> arrayList = object2;
            if (object2 == null) {
                arrayList = new ArrayList<ReceiverRecord>(1);
                this.mReceivers.put((BroadcastReceiver)object, arrayList);
            }
            arrayList.add(receiverRecord);
            int n = 0;
            while (n < intentFilter.countActions()) {
                object2 = intentFilter.getAction(n);
                arrayList = this.mActions.get(object2);
                object = arrayList;
                if (arrayList == null) {
                    object = new ArrayList(1);
                    this.mActions.put((String)object2, (ArrayList<ReceiverRecord>)object);
                }
                object.add(receiverRecord);
                ++n;
            }
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean sendBroadcast(Intent var1_1) {
        var8_2 = this.mReceivers;
        synchronized (var8_2) {
            block23: {
                var11_3 = var1_1.getAction();
                var7_4 = var1_1.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
                var9_5 = var1_1.getData();
                var12_6 = var1_1.getScheme();
                var10_7 = var1_1.getCategories();
                var2_8 = (var1_1.getFlags() & 8) != 0 ? 1 : 0;
                if (var2_8 != 0) {
                    var5_9 = new Object();
                    Log.v((String)"LocalBroadcastManager", (String)var5_9.append("Resolving type ").append((String)var7_4).append(" scheme ").append(var12_6).append(" of intent ").append(var1_1).toString());
                }
                if ((var13_10 = this.mActions.get(var1_1.getAction())) == null) break block23;
                if (var2_8 != 0) {
                    var5_9 = new Object();
                    Log.v((String)"LocalBroadcastManager", (String)var5_9.append("Action list: ").append(var13_10).toString());
                }
                var6_11 = null;
                for (var3_12 = 0; var3_12 < var13_10.size(); ++var3_12) {
                    block24: {
                        var14_14 = var13_10.get(var3_12);
                        if (var2_8 != 0) {
                            var5_9 = new Object();
                            Log.v((String)"LocalBroadcastManager", (String)var5_9.append("Matching against filter ").append(var14_14.filter).toString());
                        }
                        if (!var14_14.broadcasting) break block24;
                        if (var2_8 != 0) {
                            Log.v((String)"LocalBroadcastManager", (String)"  Filter's target already added");
                        }
                        ** GOTO lbl62
                    }
                    var5_9 = var14_14.filter;
                    var4_13 = var5_9.match(var11_3, (String)var7_4, var12_6, var9_5, var10_7, "LocalBroadcastManager");
                    if (var4_13 >= 0) {
                        if (var2_8 != 0) {
                            var5_9 = new Object();
                            Log.v((String)"LocalBroadcastManager", (String)var5_9.append("  Filter matched!  match=0x").append(Integer.toHexString(var4_13)).toString());
                        }
                        var5_9 = var6_11 == null ? new Object() : var6_11;
                        var5_9.add(var14_14);
                        var14_14.broadcasting = true;
                    } else {
                        if (var2_8 != 0) {
                            switch (var4_13) {
                                default: {
                                    var5_9 = "unknown reason";
                                    break;
                                }
                                case -1: {
                                    var5_9 = "type";
                                    break;
                                }
                                case -2: {
                                    var5_9 = "data";
                                    break;
                                }
                                case -3: {
                                    var5_9 = "action";
                                    break;
                                }
                                case -4: {
                                    var5_9 = "category";
                                }
                            }
                            var14_14 = new StringBuilder();
                            Log.v((String)"LocalBroadcastManager", (String)var14_14.append("  Filter did not match: ").append((String)var5_9).toString());
                        }
lbl62:
                        // 4 sources

                        var5_9 = var6_11;
                    }
                    var6_11 = var5_9;
                }
                if (var6_11 != null) {
                    for (var2_8 = 0; var2_8 < var6_11.size(); ++var2_8) {
                        ((ReceiverRecord)var6_11.get((int)var2_8)).broadcasting = false;
                    }
                    var7_4 = this.mPendingBroadcasts;
                    var5_9 = new Object(var1_1, (ArrayList<ReceiverRecord>)var6_11);
                    var7_4.add(var5_9);
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(Intent intent) {
        if (this.sendBroadcast(intent)) {
            this.executePendingBroadcasts();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver2) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> hashMap = this.mReceivers;
        synchronized (hashMap) {
            ArrayList<ReceiverRecord> arrayList = this.mReceivers.remove(broadcastReceiver2);
            if (arrayList == null) {
                return;
            }
            int n = arrayList.size() - 1;
            while (n >= 0) {
                ReceiverRecord receiverRecord = arrayList.get(n);
                receiverRecord.dead = true;
                for (int i = 0; i < receiverRecord.filter.countActions(); ++i) {
                    String string2 = receiverRecord.filter.getAction(i);
                    ArrayList<ReceiverRecord> arrayList2 = this.mActions.get(string2);
                    if (arrayList2 == null) continue;
                    for (int j = arrayList2.size() - 1; j >= 0; --j) {
                        ReceiverRecord receiverRecord2 = arrayList2.get(j);
                        if (receiverRecord2.receiver != broadcastReceiver2) continue;
                        receiverRecord2.dead = true;
                        arrayList2.remove(j);
                    }
                    if (arrayList2.size() > 0) continue;
                    this.mActions.remove(string2);
                }
                --n;
            }
            return;
        }
    }

    private static final class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent;
            this.receivers = arrayList;
        }
    }

    private static final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver2) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.receiver);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.filter);
            if (this.dead) {
                stringBuilder.append(" DEAD");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}

