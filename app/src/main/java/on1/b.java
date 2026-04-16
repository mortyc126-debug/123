package on1;

import amuvvoafs.util.Log;
import com.facebook.internal.d0;
import com.facebook.internal.g0;
import com.facebook.internal.t0;
import com.facebook.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import lmjxuqdtp.jvm.internal.o;
import org.json.JSONObject;
import vn1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static boolean b;
    public static final b a = new b();
    public static final ArrayList c = new ArrayList();
    public static final CopyOnWriteArraySet d = new CopyOnWriteArraySet();

    public final String a(String str, String str2) {
        if (!a.b(this)) {
            try {
                try {
                    for (a aVar : new ArrayList(c)) {
                        if (aVar != null && o.c(str, aVar.a())) {
                            for (String str3 : ((HashMap) aVar.b()).keySet()) {
                                if (o.c(str2, str3)) {
                                    return (String) ((HashMap) aVar.b()).get(str3);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    Log.w("on1.b", "getMatchedRuleType failed", e);
                }
            } catch (Throwable th) {
                a.a(this, th);
                return null;
            }
        }
        return null;
    }

    public final void b() {
        String str;
        CopyOnWriteArraySet copyOnWriteArraySet = d;
        ArrayList arrayList = c;
        if (a.b(this)) {
            return;
        }
        try {
            d0 d0VarK = g0.k(s.b(), false);
            if (d0VarK != null && (str = d0VarK.m) != null && str.length() != 0) {
                JSONObject jSONObject = new JSONObject(str);
                arrayList.clear();
                copyOnWriteArraySet.clear();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (jSONObject2 != null) {
                        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("restrictive_param");
                        o.g(next, "key");
                        a aVar = new a(new HashMap(), next);
                        if (jSONObjectOptJSONObject != null) {
                            aVar.c(t0.u(jSONObjectOptJSONObject));
                            arrayList.add(aVar);
                        }
                        if (jSONObject2.has("process_event_name")) {
                            copyOnWriteArraySet.add(aVar.a());
                        }
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            a.a(this, th);
        }
    }
}
