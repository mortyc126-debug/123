package jn1;

import amuvvoafs.content.SharedPreferences;
import com.facebook.s;
import hy1.q;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import lmjxuqdtp.jvm.internal.m;
import ln1.k;
import mx1.z;
import org.json.JSONObject;
import vn1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final o a = new o();

    public static final void c() {
        if (a.b(o.class)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = s.a().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
            SharedPreferences sharedPreferences2 = s.a().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
            sharedPreferences.edit().clear().apply();
            sharedPreferences2.edit().clear().apply();
            s.a().getSharedPreferences("com.facebook.internal.iap.PRODUCT_DETAILS", 0).edit().clear().apply();
        } catch (Throwable th) {
            a.a(o.class, th);
        }
    }

    public static final void d(ConcurrentHashMap concurrentHashMap, ConcurrentHashMap concurrentHashMap2, boolean z, String str, int i, boolean z2) {
        if (a.b(o.class)) {
            return;
        }
        try {
            lmjxuqdtp.jvm.internal.o.h(concurrentHashMap, "purchaseDetailsMap");
            lmjxuqdtp.jvm.internal.o.h(concurrentHashMap2, "skuDetailsMap");
            m.a(i, "billingClientVersion");
            o oVar = a;
            LinkedHashMap linkedHashMapB = oVar.b(oVar.a(concurrentHashMap, z), concurrentHashMap2, str);
            if (a.b(oVar)) {
                return;
            }
            try {
                for (Map.Entry entry : linkedHashMapB.entrySet()) {
                    k.d(i, (String) entry.getKey(), (String) entry.getValue(), z, z2);
                }
            } catch (Throwable th) {
                a.a(oVar, th);
            }
        } catch (Throwable th2) {
            a.a(o.class, th2);
        }
    }

    public static final void e() {
        if (a.b(o.class)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = s.a().getSharedPreferences("com.facebook.internal.iap.IAP_CACHE_GPBLV2V7", 0);
            long jMax = Math.max(Math.max(sharedPreferences.getLong("TIME_OF_LAST_LOGGED_PURCHASE", 0L), sharedPreferences.getLong("TIME_OF_LAST_LOGGED_SUBSCRIPTION", 0L)), 1736528400000L);
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            SharedPreferences sharedPreferences2 = s.a().getSharedPreferences("com.facebook.internal.iap.PRODUCT_DETAILS", 0);
            if (sharedPreferences2.contains("PURCHASE_DETAILS_SET")) {
                Collection stringSet = sharedPreferences2.getStringSet("PURCHASE_DETAILS_SET", new HashSet());
                copyOnWriteArraySet.addAll(stringSet == null ? new HashSet() : stringSet);
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    try {
                        long j2 = Long.parseLong((String) q.Y0((String) it.next(), new String[]{";"}, 2, 2).get(1)) * 1000;
                        if (Math.abs(String.valueOf(j2).length() - 13) < Math.log10(1000.0d)) {
                            jMax = Math.max(jMax, j2);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            sharedPreferences.edit().putLong("TIME_OF_LAST_LOGGED_SUBSCRIPTION", jMax).apply();
            sharedPreferences.edit().putLong("TIME_OF_LAST_LOGGED_PURCHASE", jMax).apply();
            c();
        } catch (Throwable th) {
            a.a(o.class, th);
        }
    }

    public static final void f() {
        if (a.b(o.class)) {
            return;
        }
        try {
            try {
                s.a().getSharedPreferences("com.facebook.internal.iap.IAP_CACHE_GPBLV2V7", 0).edit().putBoolean("APP_HAS_BEEN_LAUNCHED_KEY", true).apply();
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            a.a(o.class, th);
        }
    }

    public static final void g() {
        if (a.b(o.class)) {
            return;
        }
        try {
            f();
            try {
                SharedPreferences sharedPreferences = s.a().getSharedPreferences("com.facebook.internal.iap.IAP_CACHE_GPBLV2V7", 0);
                long jCurrentTimeMillis = System.currentTimeMillis();
                sharedPreferences.edit().putLong("TIME_OF_LAST_LOGGED_SUBSCRIPTION", jCurrentTimeMillis).apply();
                sharedPreferences.edit().putLong("TIME_OF_LAST_LOGGED_PURCHASE", jCurrentTimeMillis).apply();
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            a.a(o.class, th);
        }
    }

    public final HashMap a(Map map, boolean z) {
        if (a.b(this)) {
            return null;
        }
        try {
            lmjxuqdtp.jvm.internal.o.h(map, "purchaseDetailsMap");
            SharedPreferences sharedPreferences = s.a().getSharedPreferences("com.facebook.internal.iap.IAP_CACHE_GPBLV2V7", 0);
            long j2 = z ? sharedPreferences.getLong("TIME_OF_LAST_LOGGED_SUBSCRIPTION", 1736528400000L) : sharedPreferences.getLong("TIME_OF_LAST_LOGGED_PURCHASE", 1736528400000L);
            long jMax = 0;
            for (Map.Entry entry : z.d0(map).entrySet()) {
                String str = (String) entry.getKey();
                JSONObject jSONObject = (JSONObject) entry.getValue();
                try {
                    if (jSONObject.has("purchaseToken") && jSONObject.has("purchaseTime")) {
                        long j3 = jSONObject.getLong("purchaseTime");
                        if (j3 <= j2) {
                            map.remove(str);
                        }
                        jMax = Math.max(jMax, j3);
                    }
                } catch (Exception unused) {
                }
            }
            if (jMax >= j2) {
                if (z) {
                    sharedPreferences.edit().putLong("TIME_OF_LAST_LOGGED_SUBSCRIPTION", jMax).apply();
                } else {
                    sharedPreferences.edit().putLong("TIME_OF_LAST_LOGGED_PURCHASE", jMax).apply();
                }
            }
            return new HashMap(map);
        } catch (Throwable th) {
            a.a(this, th);
            return null;
        }
    }

    public final LinkedHashMap b(HashMap map, Map map2, String str) {
        if (a.b(this)) {
            return null;
        }
        try {
            lmjxuqdtp.jvm.internal.o.h(map, "purchaseDetailsMap");
            lmjxuqdtp.jvm.internal.o.h(map2, "skuDetailsMap");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                JSONObject jSONObject = (JSONObject) entry.getValue();
                JSONObject jSONObject2 = (JSONObject) map2.get(str2);
                try {
                    jSONObject.put("packageName", str);
                    if (jSONObject2 != null) {
                        String string = jSONObject.toString();
                        lmjxuqdtp.jvm.internal.o.g(string, "purchaseDetail.toString()");
                        String string2 = jSONObject2.toString();
                        lmjxuqdtp.jvm.internal.o.g(string2, "skuDetail.toString()");
                        linkedHashMap.put(string, string2);
                    }
                } catch (Exception unused) {
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            a.a(this, th);
            return null;
        }
    }
}
