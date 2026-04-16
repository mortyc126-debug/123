package cn1;

import a1.b;
import amuvvoafs.app.Activity;
import amuvvoafs.os.Handler;
import amuvvoafs.util.Log;
import amuvvoafs.view.View;
import com.facebook.s;
import java.lang.ref.WeakReference;
import java.util.TimerTask;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vn1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends TimerTask {
    public final /* synthetic */ n a;

    public m(n nVar) {
        this.a = nVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        WeakReference weakReference;
        try {
            boolean zB = a.b(n.class);
            Handler handler = null;
            n nVar = this.a;
            if (zB) {
                weakReference = null;
            } else {
                try {
                    weakReference = nVar.b;
                } catch (Throwable th) {
                    a.a(n.class, th);
                    weakReference = null;
                }
            }
            Activity activity = (Activity) weakReference.get();
            View viewZ = ln1.e.z(activity);
            if (activity != null && viewZ != null) {
                String simpleName = activity.getClass().getSimpleName();
                e eVar = e.a;
                boolean z = false;
                if (!a.b(e.class)) {
                    try {
                        z = e.g.get();
                    } catch (Throwable th2) {
                        a.a(e.class, th2);
                    }
                }
                if (z) {
                    FutureTask futureTask = new FutureTask(new l(viewZ));
                    if (!a.b(n.class)) {
                        try {
                            handler = nVar.a;
                        } catch (Throwable th3) {
                            a.a(n.class, th3);
                        }
                    }
                    handler.post(futureTask);
                    String str = HttpUrl.FRAGMENT_ENCODE_SET;
                    try {
                        str = (String) futureTask.get(1L, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        Log.e(n.a(), "Failed to take screenshot.", e);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("screenname", simpleName);
                        jSONObject.put("screenshot", str);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(dn1.e.c(viewZ));
                        jSONObject.put("view", jSONArray);
                    } catch (JSONException unused) {
                        Log.e(n.a(), "Failed to create JSONObject");
                    }
                    String string = jSONObject.toString();
                    lmjxuqdtp.jvm.internal.o.g(string, "viewTree.toString()");
                    if (a.b(n.class)) {
                        return;
                    }
                    try {
                        if (!a.b(nVar)) {
                            try {
                                s.c().execute(new b(18, string, nVar));
                            } catch (Throwable th4) {
                                a.a(nVar, th4);
                            }
                        }
                    } catch (Throwable th5) {
                        a.a(n.class, th5);
                    }
                }
            }
        } catch (Exception e2) {
            Log.e(n.a(), "UI Component tree indexing failure!", e2);
        }
    }
}
