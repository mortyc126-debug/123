/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProviderClient
 *  android.content.ContentUris
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.content.pm.Signature
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.CancellationSignal
 *  android.os.RemoteException
 *  android.util.Log
 */
package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontProvider$$ExternalSyntheticLambda0;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = new FontProvider$$ExternalSyntheticLambda0();

    private FontProvider() {
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatureArray) {
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        int n = signatureArray.length;
        for (int i = 0; i < n; ++i) {
            arrayList.add(signatureArray[i].toByteArray());
        }
        return arrayList;
    }

    private static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); ++i) {
            if (Arrays.equals(list.get(i), list2.get(i))) continue;
            return false;
        }
        return true;
    }

    private static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        if (fontRequest.getCertificates() != null) {
            return fontRequest.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    static FontsContractCompat.FontFamilyResult getFontFamilyResult(Context context, FontRequest fontRequest, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfo = FontProvider.getProvider(context.getPackageManager(), fontRequest, context.getResources());
        if (providerInfo == null) {
            return FontsContractCompat.FontFamilyResult.create(1, null);
        }
        return FontsContractCompat.FontFamilyResult.create(0, FontProvider.query(context, fontRequest, providerInfo.authority, cancellationSignal));
    }

    static ProviderInfo getProvider(PackageManager object, FontRequest object2, Resources object3) throws PackageManager.NameNotFoundException {
        String string2 = ((FontRequest)object2).getProviderAuthority();
        ProviderInfo providerInfo = object.resolveContentProvider(string2, 0);
        if (providerInfo != null) {
            if (providerInfo.packageName.equals(((FontRequest)object2).getProviderPackage())) {
                object = FontProvider.convertToByteArrayList(object.getPackageInfo((String)providerInfo.packageName, (int)64).signatures);
                Collections.sort(object, sByteArrayComparator);
                object3 = FontProvider.getCertificates((FontRequest)object2, (Resources)object3);
                for (int i = 0; i < object3.size(); ++i) {
                    object2 = new ArrayList((Collection)object3.get(i));
                    Collections.sort(object2, sByteArrayComparator);
                    if (!FontProvider.equalsByteArrayList((List<byte[]>)object, (List<byte[]>)object2)) continue;
                    return providerInfo;
                }
                return null;
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + string2 + ", but package was not " + ((FontRequest)object2).getProviderPackage());
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + string2);
    }

    static /* synthetic */ int lambda$static$0(byte[] byArray, byte[] byArray2) {
        if (byArray.length != byArray2.length) {
            return byArray.length - byArray2.length;
        }
        for (int i = 0; i < byArray.length; ++i) {
            if (byArray[i] == byArray2[i]) continue;
            return byArray[i] - byArray2[i];
        }
        return 0;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static FontsContractCompat.FontInfo[] query(Context object, FontRequest object2, String string2, CancellationSignal cancellationSignal) {
        void var0_3;
        ContentQueryWrapper contentQueryWrapper;
        block8: {
            block7: {
                ArrayList arrayList = new ArrayList();
                Uri uri = new Uri.Builder().scheme("content").authority(string2).build();
                Uri uri2 = new Uri.Builder().scheme("content").authority(string2).appendPath("file").build();
                Object var15_10 = null;
                contentQueryWrapper = ContentQueryWrapper.make((Context)object, uri);
                try {
                    object = ((FontRequest)object2).getQuery();
                    string2 = contentQueryWrapper.query(uri, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{object}, null, cancellationSignal);
                    object = arrayList;
                    if (string2 == null) break block7;
                    object = arrayList;
                }
                catch (Throwable throwable) {
                    object2 = var15_10;
                    break block8;
                }
                try {
                    if (string2.getCount() <= 0) break block7;
                    int n = string2.getColumnIndex("result_code");
                    object = new ArrayList();
                    int n2 = string2.getColumnIndex("_id");
                    int n3 = string2.getColumnIndex("file_id");
                    int n4 = string2.getColumnIndex("font_ttc_index");
                    int n5 = string2.getColumnIndex("font_weight");
                    int n6 = string2.getColumnIndex("font_italic");
                    while (string2.moveToNext()) {
                        int n7 = n != -1 ? string2.getInt(n) : 0;
                        int n8 = n4 != -1 ? string2.getInt(n4) : 0;
                        object2 = n3 == -1 ? ContentUris.withAppendedId((Uri)uri, (long)string2.getLong(n2)) : ContentUris.withAppendedId((Uri)uri2, (long)string2.getLong(n3));
                        int n9 = n5 != -1 ? string2.getInt(n5) : 400;
                        boolean bl = n6 != -1 && string2.getInt(n6) == 1;
                        ((ArrayList)object).add(FontsContractCompat.FontInfo.create((Uri)object2, n8, n9, bl, n7));
                    }
                }
                catch (Throwable throwable) {
                    object2 = string2;
                    break block8;
                }
            }
            if (string2 != null) {
                string2.close();
            }
            contentQueryWrapper.close();
            return ((ArrayList)object).toArray(new FontsContractCompat.FontInfo[0]);
        }
        if (object2 != null) {
            object2.close();
        }
        contentQueryWrapper.close();
        throw var0_3;
    }

    private static interface ContentQueryWrapper {
        public static ContentQueryWrapper make(Context context, Uri uri) {
            return new ContentQueryWrapperApi24Impl(context, uri);
        }

        public void close();

        public Cursor query(Uri var1, String[] var2, String var3, String[] var4, String var5, CancellationSignal var6);
    }

    private static class ContentQueryWrapperApi16Impl
    implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi16Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override
        public void close() {
            if (this.mClient != null) {
                this.mClient.release();
            }
        }

        @Override
        public Cursor query(Uri uri, String[] stringArray, String string2, String[] stringArray2, String string3, CancellationSignal cancellationSignal) {
            if (this.mClient == null) {
                return null;
            }
            try {
                uri = this.mClient.query(uri, stringArray, string2, stringArray2, string3, cancellationSignal);
                return uri;
            }
            catch (RemoteException remoteException) {
                Log.w((String)"FontsProvider", (String)"Unable to query the content provider", (Throwable)remoteException);
                return null;
            }
        }
    }

    private static class ContentQueryWrapperApi24Impl
    implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi24Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override
        public void close() {
            if (this.mClient != null) {
                this.mClient.close();
            }
        }

        @Override
        public Cursor query(Uri uri, String[] stringArray, String string2, String[] stringArray2, String string3, CancellationSignal cancellationSignal) {
            if (this.mClient == null) {
                return null;
            }
            try {
                uri = this.mClient.query(uri, stringArray, string2, stringArray2, string3, cancellationSignal);
                return uri;
            }
            catch (RemoteException remoteException) {
                Log.w((String)"FontsProvider", (String)"Unable to query the content provider", (Throwable)remoteException);
                return null;
            }
        }
    }
}

