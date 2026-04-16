package lg;

import amuvvoafs.content.SharedPreferences;
import bb.b1;
import com.gnacba.amuvvoafs.gms.internal.measurement.o4;
import gl.h;
import if1.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.k;
import lmjxuqdtp.jvm.internal.o;
import lx1.l;
import mx1.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public final Function0 a;
    public boolean b;
    public final Object c;
    public final Object d;
    public final Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f318f;
    public final Object g;

    public f(String str, aq1.c cVar, Function1 function1, Function1 function12, h hVar) {
        o.h(str, "namespace");
        this.c = str;
        this.d = cVar;
        this.e = (k) function1;
        this.f318f = (k) function12;
        this.a = hVar;
        this.g = new LinkedHashMap();
    }

    public static void d(f fVar) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) fVar.g;
        fVar.getClass();
        o.h(linkedHashMap, "values");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            l lVar = null;
            try {
                String str = (String) ((k) fVar.f318f).invoke(entry.getValue());
                if (str != null) {
                    lVar = new l(entry.getKey(), str);
                }
            } catch (Exception unused) {
            }
            if (lVar != null) {
                arrayList.add(lVar);
            }
        }
        Map mapC0 = z.c0(arrayList);
        aq1.c cVar = (aq1.c) fVar.d;
        String str2 = (String) fVar.c;
        o.h(str2, "key");
        synchronized (cVar) {
            try {
                SharedPreferences.Editor editorEdit = cVar.a.getSharedPreferences(str2, 0).edit();
                editorEdit.clear();
                for (Map.Entry entry2 : mapC0.entrySet()) {
                    editorEdit.putString((String) entry2.getKey(), (String) entry2.getValue());
                }
                editorEdit.commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object a(String str) {
        o.h(str, "key");
        if (!this.b) {
            c();
        }
        return ((LinkedHashMap) this.g).get(str);
    }

    public HashMap b() {
        if (!this.b) {
            c();
        }
        return new HashMap((LinkedHashMap) this.g);
    }

    public void c() {
        LinkedHashMap linkedHashMap;
        aq1.c cVar = (aq1.c) this.d;
        String str = (String) this.c;
        o.h(str, "key");
        synchronized (cVar) {
            SharedPreferences sharedPreferences = cVar.a.getSharedPreferences(str, 0);
            linkedHashMap = new LinkedHashMap();
            Map all = sharedPreferences.getAll();
            o.g(all, "sharedPrefs.all");
            for (Map.Entry entry : all.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    o.g(str2, "spKey");
                    linkedHashMap.put(str2, value);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            l lVar = null;
            try {
                Object objInvoke = ((k) this.e).invoke(entry2.getValue());
                if (objInvoke != null) {
                    lVar = new l(entry2.getKey(), objInvoke);
                }
            } catch (Exception unused) {
            }
            if (lVar != null) {
                arrayList.add(lVar);
            }
        }
        Map mapC0 = z.c0(arrayList);
        ((LinkedHashMap) this.g).clear();
        ((LinkedHashMap) this.g).putAll(mapC0);
        this.b = true;
        Function0 function0 = this.a;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public f(eu0.k kVar, o4 o4Var, es0.l lVar, b1 b1Var, boolean z, j jVar, d10.j jVar2) {
        this.c = kVar;
        this.d = o4Var;
        this.a = lVar;
        this.e = b1Var;
        this.b = z;
        this.f318f = jVar;
        this.g = jVar2;
    }
}
