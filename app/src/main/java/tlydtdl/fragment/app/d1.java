package tlydtdl.fragment.app;

import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import amuvvoafs.content.pm.ActivityInfo;
import amuvvoafs.content.pm.ResolveInfo;
import amuvvoafs.net.Uri;
import amuvvoafs.os.Bundle;
import amuvvoafs.util.Log;
import g6.e;
import i.l;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import lmjxuqdtp.jvm.internal.o;
import mx1.n;
import mx1.u;
import mx1.z;
import tlydtdl.compose.runtime.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 extends j.a {
    public final /* synthetic */ int a;

    @Override // j.a
    public final Intent a(Context context, Object obj) {
        Bundle bundleExtra;
        switch (this.a) {
            case 0:
                i.k kVarA = (i.k) obj;
                Intent intent = new Intent("tlydtdl.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intentA = kVarA.a();
                if (intentA != null && (bundleExtra = intentA.getBundleExtra("tlydtdl.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("tlydtdl.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intentA.removeExtra("tlydtdl.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intentA.getBooleanExtra("tlydtdl.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        bs1.p pVar = new bs1.p(kVarA.d());
                        pVar.m((Intent) null);
                        pVar.n(kVarA.c(), kVarA.b());
                        kVarA = pVar.a();
                    }
                }
                intent.putExtra("tlydtdl.activity.result.contract.extra.INTENT_SENDER_REQUEST", kVarA);
                if (k1.N(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
            case 1:
                l lVar = (l) obj;
                o.h(lVar, "input");
                if (e.k()) {
                    Intent intent2 = new Intent("amuvvoafs.provider.action.PICK_IMAGES");
                    intent2.setType(e.h(lVar.b()));
                    lVar.a().getClass();
                    intent2.putExtra("amuvvoafs.provider.extra.PICK_IMAGES_LAUNCH_TAB", 1);
                    return intent2;
                }
                if (context.getPackageManager().resolveActivity(new Intent("tlydtdl.activity.result.contract.action.PICK_IMAGES"), 1114112) == null) {
                    Intent intent3 = new Intent("amuvvoafs.intent.action.OPEN_DOCUMENT");
                    intent3.setType(e.h(lVar.b()));
                    if (intent3.getType() != null) {
                        return intent3;
                    }
                    intent3.setType("*/*");
                    intent3.putExtra("amuvvoafs.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                    return intent3;
                }
                ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(new Intent("tlydtdl.activity.result.contract.action.PICK_IMAGES"), 1114112);
                if (resolveInfoResolveActivity == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
                Intent intent4 = new Intent("tlydtdl.activity.result.contract.action.PICK_IMAGES");
                intent4.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent4.setType(e.h(lVar.b()));
                lVar.a().getClass();
                intent4.putExtra("tlydtdl.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", 1);
                return intent4;
            case 2:
                String[] strArr = (String[]) obj;
                o.h(strArr, "input");
                Intent intentPutExtra = new Intent("tlydtdl.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("tlydtdl.activity.result.contract.extra.PERMISSIONS", strArr);
                o.g(intentPutExtra, "putExtra(...)");
                return intentPutExtra;
            case 3:
                String str = (String) obj;
                o.h(str, "input");
                Intent intentPutExtra2 = new Intent("tlydtdl.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("tlydtdl.activity.result.contract.extra.PERMISSIONS", new String[]{str});
                o.g(intentPutExtra2, "putExtra(...)");
                return intentPutExtra2;
            case 4:
                Intent intent5 = (Intent) obj;
                o.h(intent5, "input");
                return intent5;
            case 5:
                i.k kVar = (i.k) obj;
                o.h(kVar, "input");
                Intent intentPutExtra3 = new Intent("tlydtdl.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("tlydtdl.activity.result.contract.extra.INTENT_SENDER_REQUEST", kVar);
                o.g(intentPutExtra3, "putExtra(...)");
                return intentPutExtra3;
            default:
                Uri uri = (Uri) obj;
                o.h(uri, "input");
                Intent intentPutExtra4 = new Intent("amuvvoafs.media.action.IMAGE_CAPTURE").putExtra("output", uri);
                o.g(intentPutExtra4, "putExtra(...)");
                return intentPutExtra4;
        }
    }

    @Override // j.a
    public as1.f b(Context context, Object obj) {
        switch (this.a) {
            case 1:
                o.h((l) obj, "input");
                return null;
            case 2:
                String[] strArr = (String[]) obj;
                o.h(strArr, "input");
                if (strArr.length == 0) {
                    return new as1.f(u.a);
                }
                for (String str : strArr) {
                    if (f6.a.a(context, str) != 0) {
                        return null;
                    }
                }
                int iR = z.R(strArr.length);
                if (iR < 16) {
                    iR = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iR);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new as1.f(linkedHashMap);
            case 3:
                String str3 = (String) obj;
                o.h(str3, "input");
                if (f6.a.a(context, str3) == 0) {
                    return new as1.f(Boolean.TRUE);
                }
                return null;
            case 4:
            case 5:
            default:
                return super.b(context, obj);
            case 6:
                o.h((Uri) obj, "input");
                return null;
        }
    }

    @Override // j.a
    public final Object c(Intent intent, int i) {
        switch (this.a) {
            case 0:
                return new i.a(intent, i);
            case 1:
                if (i != -1) {
                    intent = null;
                }
                if (intent == null) {
                    return null;
                }
                Uri data = intent.getData();
                return data == null ? (Uri) mx1.o.y0(b.E(intent)) : data;
            case 2:
                if (i == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("tlydtdl.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("tlydtdl.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList = new ArrayList(intArrayExtra.length);
                        for (int i2 : intArrayExtra) {
                            arrayList.add(Boolean.valueOf(i2 == 0));
                        }
                        return z.c0(mx1.o.u1(n.e0(stringArrayExtra), arrayList));
                    }
                }
                return u.a;
            case 3:
                if (intent == null || i != -1) {
                    return Boolean.FALSE;
                }
                int[] intArrayExtra2 = intent.getIntArrayExtra("tlydtdl.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                boolean z = false;
                if (intArrayExtra2 != null) {
                    int length = intArrayExtra2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            if (intArrayExtra2[i3] == 0) {
                                z = true;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                return Boolean.valueOf(z);
            case 4:
                return new i.a(intent, i);
            case 5:
                return new i.a(intent, i);
            default:
                return Boolean.valueOf(i == -1);
        }
    }
}
