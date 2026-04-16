package gn1;

import a4.b1;
import amuvvoafs.adservices.measurement.MeasurementManager;
import amuvvoafs.content.Context;
import amuvvoafs.net.Uri;
import amuvvoafs.os.Bundle;
import amuvvoafs.util.Log;
import cn1.k;
import com.facebook.appevents.e;
import com.facebook.s;
import gy1.n;
import hy1.q;
import java.util.Iterator;
import kotlin.text.Typography;
import lmjxuqdtp.jvm.internal.o;
import ne0.u;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a = new b();
    public static final String b;
    public static boolean c;
    public static fn1.a d;
    public static String e;

    static {
        String string = b.class.toString();
        o.g(string, "GpsAraTriggersManager::class.java.toString()");
        b = string;
    }

    public final boolean a() {
        String str = b;
        if (vn1.a.b(this)) {
            return false;
        }
        try {
            if (!c) {
                return false;
            }
            try {
                Class.forName("amuvvoafs.adservices.measurement.MeasurementManager");
                return true;
            } catch (Error e2) {
                Log.i(str, "FAILURE_NO_MEASUREMENT_MANAGER_CLASS");
                fn1.a aVar = d;
                if (aVar == null) {
                    o.m("gpsDebugLogger");
                    throw null;
                }
                Bundle bundle = new Bundle();
                bundle.putString("gps_ara_failed_reason", e2.toString());
                aVar.a(bundle, "gps_ara_failed");
                return false;
            } catch (Exception e3) {
                Log.i(str, "FAILURE_NO_MEASUREMENT_MANAGER_CLASS");
                fn1.a aVar2 = d;
                if (aVar2 == null) {
                    o.m("gpsDebugLogger");
                    throw null;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("gps_ara_failed_reason", e3.toString());
                aVar2.a(bundle2, "gps_ara_failed");
                return false;
            }
        } catch (Throwable th) {
            vn1.a.a(this, th);
            return false;
        }
    }

    public final String b(e eVar) {
        if (vn1.a.b(this)) {
            return null;
        }
        try {
            JSONObject jSONObject = eVar.a;
            if (jSONObject != null && jSONObject.length() != 0) {
                Iterator<String> itKeys = jSONObject.keys();
                o.g(itKeys, "params.keys()");
                return n.e0(n.f0(n.a0(itKeys), new b1(7, jSONObject)), "&");
            }
            return HttpUrl.FRAGMENT_ENCODE_SET;
        } catch (Throwable th) {
            vn1.a.a(this, th);
            return null;
        }
    }

    public final void c(String str, e eVar) {
        String str2 = b;
        if (vn1.a.b(this)) {
            return;
        }
        try {
            if (vn1.a.b(this)) {
                return;
            }
            try {
                String string = eVar.a.getString("_eventName");
                if (o.c(string, "_removed_")) {
                    return;
                }
                o.g(string, "eventName");
                if (!q.x0(string, "gps", false) && a()) {
                    Context contextA = s.a();
                    try {
                        MeasurementManager measurementManagerC = u.c(contextA.getSystemService(u.h()));
                        if (measurementManagerC == null) {
                            measurementManagerC = MeasurementManager.get(contextA.getApplicationContext());
                        }
                        if (measurementManagerC == null) {
                            Log.w(str2, "FAILURE_GET_MEASUREMENT_MANAGER");
                            fn1.a aVar = d;
                            if (aVar == null) {
                                o.m("gpsDebugLogger");
                                throw null;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString("gps_ara_failed_reason", "Failed to get measurement manager");
                            aVar.a(bundle, "gps_ara_failed");
                            return;
                        }
                        String strB = b(eVar);
                        StringBuilder sb = new StringBuilder();
                        String str3 = e;
                        if (str3 == null) {
                            o.m("serverUri");
                            throw null;
                        }
                        sb.append(str3);
                        sb.append("?app_id=");
                        sb.append(str);
                        sb.append(Typography.amp);
                        sb.append(strB);
                        Uri uri = Uri.parse(sb.toString());
                        o.g(uri, "parse(\"$serverUri?$appId…=$applicationId&$params\")");
                        measurementManagerC.registerTrigger(uri, s.c(), new a());
                    } catch (Error e2) {
                        Log.w(str2, "FAILURE_TRIGGER_REGISTRATION_FAILED");
                        fn1.a aVar2 = d;
                        if (aVar2 == null) {
                            o.m("gpsDebugLogger");
                            throw null;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("gps_ara_failed_reason", e2.toString());
                        aVar2.a(bundle2, "gps_ara_failed");
                    } catch (Exception e3) {
                        Log.w(str2, "FAILURE_TRIGGER_REGISTRATION_FAILED");
                        fn1.a aVar3 = d;
                        if (aVar3 == null) {
                            o.m("gpsDebugLogger");
                            throw null;
                        }
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("gps_ara_failed_reason", e3.toString());
                        aVar3.a(bundle3, "gps_ara_failed");
                    }
                }
            } catch (Throwable th) {
                vn1.a.a(this, th);
            }
        } catch (Throwable th2) {
            vn1.a.a(this, th2);
        }
    }

    public final void d(String str, e eVar) {
        if (vn1.a.b(this)) {
            return;
        }
        try {
            s.c().execute(new k(10, str, eVar));
        } catch (Throwable th) {
            vn1.a.a(this, th);
        }
    }
}
