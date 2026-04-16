package cn1;

import amuvvoafs.os.Handler;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewTreeObserver;
import com.facebook.appevents.p;
import com.facebook.internal.d0;
import com.facebook.internal.g0;
import com.facebook.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vn1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
    public final WeakReference a;
    public ArrayList b;
    public final HashSet c;
    public final String d;

    public g(View view, Handler handler, HashSet hashSet, String str) {
        lmjxuqdtp.jvm.internal.o.h(handler, "handler");
        lmjxuqdtp.jvm.internal.o.h(hashSet, "listenerSet");
        this.a = new WeakReference(view);
        this.c = hashSet;
        this.d = str;
        handler.postDelayed(this, 200L);
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x009e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a0 A[Catch: all -> 0x00ac, TryCatch #2 {all -> 0x00ac, blocks: (B:34:0x007e, B:43:0x00a0, B:45:0x00a8, B:40:0x0098, B:37:0x0088), top: B:108:0x007e, outer: #0, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn1.g.a():void");
    }

    public final void onGlobalLayout() {
        a();
    }

    public final void onScrollChanged() {
        a();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (a.b(this)) {
            return;
        }
        try {
            d0 d0VarB = g0.b(s.b());
            if (d0VarB != null && d0VarB.h) {
                JSONArray jSONArray = d0VarB.i;
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null) {
                    try {
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            lmjxuqdtp.jvm.internal.o.g(jSONObject, "array.getJSONObject(i)");
                            arrayList.add(p.G(jSONObject));
                        }
                    } catch (IllegalArgumentException | JSONException unused) {
                    }
                }
                this.b = arrayList;
                View view = (View) this.a.get();
                if (view == null) {
                    return;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                    viewTreeObserver.addOnScrollChangedListener(this);
                }
                a();
            }
        } catch (Throwable th) {
            a.a(this, th);
        }
    }
}
