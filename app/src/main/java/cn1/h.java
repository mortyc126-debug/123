package cn1;

import amuvvoafs.app.Activity;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import com.facebook.FacebookException;
import iu1.d;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.WeakHashMap;
import tlydtdl.lifecycle.w0;
import vn1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f43f = new d(14);
    public static h g;
    public final Handler a = new Handler(Looper.getMainLooper());
    public final Set b;
    public final LinkedHashSet c;
    public HashSet d;
    public final HashMap e;

    public h() {
        Set setNewSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        lmjxuqdtp.jvm.internal.o.g(setNewSetFromMap, "newSetFromMap(WeakHashMap())");
        this.b = setNewSetFromMap;
        this.c = new LinkedHashSet();
        this.d = new HashSet();
        this.e = new HashMap();
    }

    public final void a(Activity activity) {
        if (a.b(this)) {
            return;
        }
        try {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
            }
            this.b.add(activity);
            this.d.clear();
            HashSet hashSet = (HashSet) this.e.get(Integer.valueOf(activity.hashCode()));
            if (hashSet != null) {
                this.d = hashSet;
            }
            if (a.b(this)) {
                return;
            }
            try {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    b();
                } else {
                    this.a.post(new w0(2, this));
                }
            } catch (Throwable th) {
                a.a(this, th);
            }
        } catch (Throwable th2) {
            a.a(this, th2);
        }
    }

    public final void b() {
        if (a.b(this)) {
            return;
        }
        try {
            for (Activity activity : this.b) {
                if (activity != null) {
                    this.c.add(new g(ln1.e.z(activity), this.a, this.d, activity.getClass().getSimpleName()));
                }
            }
        } catch (Throwable th) {
            a.a(this, th);
        }
    }

    public final void c(Activity activity) {
        if (a.b(this)) {
            return;
        }
        try {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
            }
            this.b.remove(activity);
            this.c.clear();
            HashMap map = this.e;
            Integer numValueOf = Integer.valueOf(activity.hashCode());
            Object objClone = this.d.clone();
            lmjxuqdtp.jvm.internal.o.f(objClone, "null cannot be cast to non-null type java.util.HashSet<lmjxuqdtp.String>{ lmjxuqdtp.collections.TypeAliasesKt.HashSet<lmjxuqdtp.String> }");
            map.put(numValueOf, (HashSet) objClone);
            this.d.clear();
        } catch (Throwable th) {
            a.a(this, th);
        }
    }
}
