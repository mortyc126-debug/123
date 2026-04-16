package lg;

import cd.i0;
import ig.p;
import java.util.Map;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.k;
import lmjxuqdtp.jvm.internal.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d extends k implements Function1 {
    public static final d b = new d(1, e.class, "encodeVariantToStorage", "encodeVariantToStorage(Lcom/amplitude/experiment/Variant;)Ljava/lang/String;", 1);

    public final Object invoke(Object obj) {
        p pVar = (p) obj;
        o.h(pVar, "p0");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", pVar.d);
            String str = pVar.a;
            if (str != null) {
                jSONObject.put("value", str);
            }
            Object obj2 = pVar.b;
            if (obj2 != null) {
                jSONObject.put("payload", obj2);
            }
            String str2 = pVar.c;
            if (str2 != null) {
                jSONObject.put("expKey", str2);
            }
            Map map = pVar.e;
            if (map != null) {
                jSONObject.put("metadata", by1.b.U(map));
            }
        } catch (JSONException unused) {
            g7.p pVar2 = i0.a;
            if (pVar2 != null) {
                pVar2.v("Error converting Variant to json string");
            }
        }
        String string = jSONObject.toString();
        o.g(string, "jsonObject.toString()");
        return string;
    }
}
