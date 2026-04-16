package cn1;

import amuvvoafs.app.Activity;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import amuvvoafs.util.Log;
import com.facebook.b0;
import com.facebook.d0;
import com.facebook.internal.j0;
import com.facebook.s;
import com.facebook.y;
import iu1.d;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.concurrent.RejectedExecutionException;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
import vn1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static final String e;
    public final WeakReference b;
    public Timer c;
    public String d = null;
    public final Handler a = new Handler(Looper.getMainLooper());

    static {
        String canonicalName = n.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        e = canonicalName;
    }

    public n(Activity activity) {
        this.b = new WeakReference(activity);
    }

    public static final /* synthetic */ String a() {
        if (a.b(n.class)) {
            return null;
        }
        try {
            return e;
        } catch (Throwable th) {
            a.a(n.class, th);
            return null;
        }
    }

    public final void b(y yVar, String str) {
        String str2 = e;
        if (a.b(this) || yVar == null) {
            return;
        }
        try {
            b0 b0VarC = yVar.c();
            try {
                JSONObject jSONObject = b0VarC.b;
                if (jSONObject == null) {
                    Log.e(str2, "Error sending UI component tree to Facebook: " + b0VarC.c);
                    return;
                }
                if ("true".equals(jSONObject.optString("success"))) {
                    d dVar = j0.c;
                    d.p(d0.c, str2, "Successfully send UI component tree to server");
                    this.d = str;
                }
                if (jSONObject.has("is_app_indexing_enabled")) {
                    boolean z = jSONObject.getBoolean("is_app_indexing_enabled");
                    if (a.b(e.class)) {
                        return;
                    }
                    try {
                        e.g.set(z);
                    } catch (Throwable th) {
                        a.a(e.class, th);
                    }
                }
            } catch (JSONException e2) {
                Log.e(str2, "Error decoding server response.", e2);
            }
        } catch (Throwable th2) {
            a.a(this, th2);
        }
    }

    public final void c() {
        if (a.b(this)) {
            return;
        }
        try {
            try {
                s.c().execute(new k(0, this, new m(this)));
            } catch (RejectedExecutionException e2) {
                Log.e(e, "Error scheduling indexing job", e2);
            }
        } catch (Throwable th) {
            a.a(this, th);
        }
    }
}
