package ln1;

import amuvvoafs.os.Bundle;
import com.facebook.appevents.r;
import com.facebook.i0;
import com.facebook.internal.d0;
import com.facebook.internal.g0;
import com.facebook.s;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.LinkedHashMap;
import java.util.Map;
import lmjxuqdtp.jvm.internal.o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static final ru1.c a = new ru1.c(s.a());

    public static j a(String str, Bundle bundle, r rVar, JSONObject jSONObject, JSONObject jSONObject2) {
        if (str.equals(jn1.s.c.a())) {
            Map map = r.b;
            String string = Boolean.toString(jSONObject.optBoolean("autoRenewing", false));
            o.g(string, "toString(\n              …      )\n                )");
            e.k("fb_iap_subs_auto_renewing", string, bundle, rVar);
            String strOptString = jSONObject2.optString("subscriptionPeriod");
            o.g(strOptString, "skuDetailsJSON.optString…_IAP_SUBSCRIPTION_PERIOD)");
            e.k("fb_iap_subs_period", strOptString, bundle, rVar);
            String strOptString2 = jSONObject2.optString("freeTrialPeriod");
            o.g(strOptString2, "skuDetailsJSON.optString…GP_IAP_FREE_TRIAL_PERIOD)");
            e.k("fb_free_trial_period", strOptString2, bundle, rVar);
            String strOptString3 = jSONObject2.optString("introductoryPriceCycles");
            o.g(strOptString3, "introductoryPriceCycles");
            if (strOptString3.length() > 0) {
                e.k("fb_intro_price_cycles", strOptString3, bundle, rVar);
            }
            String strOptString4 = jSONObject2.optString("introductoryPricePeriod");
            o.g(strOptString4, "introductoryPricePeriod");
            if (strOptString4.length() > 0) {
                e.k("fb_intro_period", strOptString4, bundle, rVar);
            }
            String strOptString5 = jSONObject2.optString("introductoryPriceAmountMicros");
            o.g(strOptString5, "introductoryPriceAmountMicros");
            if (strOptString5.length() > 0) {
                e.k("fb_intro_price_amount_micros", strOptString5, bundle, rVar);
            }
        }
        BigDecimal bigDecimal = new BigDecimal(jSONObject2.getLong("price_amount_micros") / 1000000.0d);
        Currency currency = Currency.getInstance(jSONObject2.getString("price_currency_code"));
        o.g(currency, "getInstance(skuDetailsJS…RICE_CURRENCY_CODE_V2V4))");
        return new j(bigDecimal, currency, bundle, rVar);
    }

    public static ArrayList b(String str, Bundle bundle, r rVar, JSONObject jSONObject) throws JSONException {
        if (!str.equals(jn1.s.c.a())) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("oneTimePurchaseOfferDetails");
            if (jSONObject2 == null) {
                return null;
            }
            BigDecimal bigDecimal = new BigDecimal(jSONObject2.getLong("priceAmountMicros") / 1000000.0d);
            Currency currency = Currency.getInstance(jSONObject2.getString("priceCurrencyCode"));
            o.g(currency, "getInstance(oneTimePurch…RICE_CURRENCY_CODE_V5V7))");
            return ct1.b.E(new j[]{new j(bigDecimal, currency, bundle, rVar)});
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "subscriptionOfferDetails";
        JSONArray jSONArray = jSONObject.getJSONArray("subscriptionOfferDetails");
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        int i = 0;
        while (i < length) {
            JSONObject jSONObject3 = jSONObject.getJSONArray(str2).getJSONObject(i);
            if (jSONObject3 == null) {
                return null;
            }
            Bundle bundle2 = new Bundle(bundle);
            r rVar2 = new r();
            LinkedHashMap linkedHashMap = rVar.a;
            for (com.facebook.appevents.s sVar : linkedHashMap.keySet()) {
                Map map = (Map) linkedHashMap.get(sVar);
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        String str4 = str2;
                        int i2 = length;
                        Object obj = map.get(str3);
                        if (obj != null) {
                            rVar2.a(sVar, str3, obj);
                        }
                        str2 = str4;
                        length = i2;
                    }
                }
            }
            String str5 = str2;
            int i3 = length;
            String string = jSONObject3.getString("basePlanId");
            Map map2 = r.b;
            o.g(string, "basePlanId");
            e.k("fb_iap_base_plan", string, bundle2, rVar2);
            JSONObject jSONObject4 = jSONObject3.getJSONArray("pricingPhases").getJSONObject(r5.length() - 1);
            if (jSONObject4 == null) {
                return null;
            }
            String strOptString = jSONObject4.optString("billingPeriod");
            o.g(strOptString, "subscriptionJSON.optStri…IOD\n                    )");
            e.k("fb_iap_subs_period", strOptString, bundle2, rVar2);
            if (!jSONObject4.has("recurrenceMode") || jSONObject4.getInt("recurrenceMode") == 3) {
                e.k("fb_iap_subs_auto_renewing", "false", bundle2, rVar2);
            } else {
                e.k("fb_iap_subs_auto_renewing", "true", bundle2, rVar2);
            }
            BigDecimal bigDecimal2 = new BigDecimal(jSONObject4.getLong("priceAmountMicros") / 1000000.0d);
            Currency currency2 = Currency.getInstance(jSONObject4.getString("priceCurrencyCode"));
            o.g(currency2, "getInstance(subscription…RICE_CURRENCY_CODE_V5V7))");
            arrayList.add(new j(bigDecimal2, currency2, bundle2, rVar2));
            i++;
            str2 = str5;
            length = i3;
        }
        return arrayList;
    }

    public static final boolean c() {
        d0 d0VarB = g0.b(s.b());
        return d0VarB != null && i0.c() && d0VarB.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00dc A[Catch: Exception -> 0x0045, JSONException -> 0x0048, TryCatch #7 {JSONException -> 0x0048, Exception -> 0x0045, blocks: (B:6:0x0025, B:8:0x003b, B:13:0x004b, B:21:0x00dc, B:22:0x00e3, B:23:0x00eb, B:25:0x00f1, B:26:0x0109, B:28:0x0111, B:29:0x011e, B:31:0x0126, B:33:0x012e, B:19:0x00d6), top: B:126:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f1 A[Catch: Exception -> 0x0045, JSONException -> 0x0048, LOOP:0: B:23:0x00eb->B:25:0x00f1, LOOP_END, TryCatch #7 {JSONException -> 0x0048, Exception -> 0x0045, blocks: (B:6:0x0025, B:8:0x003b, B:13:0x004b, B:21:0x00dc, B:22:0x00e3, B:23:0x00eb, B:25:0x00f1, B:26:0x0109, B:28:0x0111, B:29:0x011e, B:31:0x0126, B:33:0x012e, B:19:0x00d6), top: B:126:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0111 A[Catch: Exception -> 0x0045, JSONException -> 0x0048, TryCatch #7 {JSONException -> 0x0048, Exception -> 0x0045, blocks: (B:6:0x0025, B:8:0x003b, B:13:0x004b, B:21:0x00dc, B:22:0x00e3, B:23:0x00eb, B:25:0x00f1, B:26:0x0109, B:28:0x0111, B:29:0x011e, B:31:0x0126, B:33:0x012e, B:19:0x00d6), top: B:126:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011e A[Catch: Exception -> 0x0045, JSONException -> 0x0048, TryCatch #7 {JSONException -> 0x0048, Exception -> 0x0045, blocks: (B:6:0x0025, B:8:0x003b, B:13:0x004b, B:21:0x00dc, B:22:0x00e3, B:23:0x00eb, B:25:0x00f1, B:26:0x0109, B:28:0x0111, B:29:0x011e, B:31:0x0126, B:33:0x012e, B:19:0x00d6), top: B:126:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(int r16, java.lang.String r17, java.lang.String r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 785
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ln1.k.d(int, java.lang.String, java.lang.String, boolean, boolean):void");
    }
}
