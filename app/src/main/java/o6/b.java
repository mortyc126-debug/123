package o6;

import amuvvoafs.content.ContentProviderClient;
import amuvvoafs.content.ContentUris;
import amuvvoafs.content.Context;
import amuvvoafs.content.pm.PackageManager;
import amuvvoafs.content.pm.ProviderInfo;
import amuvvoafs.content.pm.Signature;
import amuvvoafs.content.res.Resources;
import amuvvoafs.database.Cursor;
import amuvvoafs.graphics.Typeface;
import amuvvoafs.net.Uri;
import amuvvoafs.os.Build;
import amuvvoafs.os.CancellationSignal;
import amuvvoafs.os.RemoteException;
import amuvvoafs.os.Trace;
import amuvvoafs.util.Log;
import b02.d0;
import com.facebook.appevents.h;
import com.facebook.appevents.l;
import i6.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import q1.u;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final u a = new u(2);
    public static final tlydtdl.compose.foundation.lazy.layout.a b = new tlydtdl.compose.foundation.lazy.layout.a(11);

    public static d0 a(Context context, List list) {
        String str;
        Typeface typefaceC;
        Trace.beginSection(h.R("FontProvider.getFontFamilyResult"));
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                d dVar = (d) list.get(i);
                if (Build.VERSION.SDK_INT < 31 || (typefaceC = g.c((str = dVar.e))) == null || g.d(typefaceC) == null) {
                    ProviderInfo providerInfoB = b(context.getPackageManager(), dVar, context.getResources());
                    if (providerInfoB == null) {
                        return new d0(11, (byte) 0);
                    }
                    arrayList.add(c(context, dVar, providerInfoB.authority));
                } else {
                    arrayList.add(new i[]{new i(str, dVar.f360f)});
                }
            }
            return new d0(arrayList);
        } finally {
            Trace.endSection();
        }
    }

    public static ProviderInfo b(PackageManager packageManager, d dVar, Resources resources) {
        tlydtdl.compose.foundation.lazy.layout.a aVar = b;
        u uVar = a;
        Trace.beginSection(h.R("FontProvider.getProvider"));
        try {
            List listW = dVar.d;
            String str = dVar.a;
            String str2 = dVar.b;
            if (listW == null) {
                listW = l.W(resources, 0);
            }
            a aVar2 = new a();
            aVar2.a = str;
            aVar2.b = str2;
            aVar2.c = listW;
            ProviderInfo providerInfo = (ProviderInfo) uVar.c(aVar2);
            if (providerInfo != null) {
                return providerInfo;
            }
            ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (providerInfoResolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
            }
            if (!providerInfoResolveContentProvider.packageName.equals(str2)) {
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str2);
            }
            Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            Collections.sort(arrayList, aVar);
            for (int i = 0; i < listW.size(); i++) {
                ArrayList arrayList2 = new ArrayList((Collection) listW.get(i));
                Collections.sort(arrayList2, aVar);
                if (arrayList.size() == arrayList2.size()) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (!Arrays.equals((byte[]) arrayList.get(i2), (byte[]) arrayList2.get(i2))) {
                            break;
                        }
                    }
                    uVar.d(aVar2, providerInfoResolveContentProvider);
                    return providerInfoResolveContentProvider;
                }
            }
            Trace.endSection();
            return null;
        } finally {
            Trace.endSection();
        }
    }

    public static i[] c(Context context, d dVar, String str) {
        Trace.beginSection(h.R("FontProvider.query"));
        try {
            ArrayList arrayList = new ArrayList();
            Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
            Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
            Cursor cursorQuery = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                Trace.beginSection(h.R("ContentQueryWrapper.query"));
                try {
                    String[] strArr2 = {dVar.c};
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uriBuild, strArr, "query = ?", strArr2, (String) null, (CancellationSignal) null);
                        } catch (RemoteException e) {
                            Log.w("FontsProvider", "Unable to query the content provider", e);
                        }
                    }
                    Trace.endSection();
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        int columnIndex = cursorQuery.getColumnIndex("result_code");
                        ArrayList arrayList2 = new ArrayList();
                        int columnIndex2 = cursorQuery.getColumnIndex("_id");
                        int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                        int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                        int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                        while (cursorQuery.moveToNext()) {
                            int i = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                            arrayList2.add(new i(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, i));
                        }
                        arrayList = arrayList2;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    return (i[]) arrayList.toArray(new i[0]);
                } finally {
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                }
                throw th;
            }
        } finally {
        }
    }
}
