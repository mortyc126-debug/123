package b8;

import amuvvoafs.util.Log;
import com.facebook.appevents.p;
import dd.j;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import kd.l;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import md1.b1;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final LinkedHashMap a;

    public e(List list) {
        String strB0;
        o.h(list, "data");
        this.a = new LinkedHashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                ct1.b.X();
                throw null;
            }
            if (obj == null || !(obj instanceof vu0.d) || (strB0 = ((vu0.d) obj).getId()) == null) {
                strB0 = p.b0();
            }
            Collection collectionValues = this.a.values();
            int iIntValue = ((Number) linkedHashMap.getOrDefault(strB0, 0)).intValue();
            String str = strB0;
            while (collectionValues.contains(str)) {
                iIntValue++;
                str = ((Object) strB0) + "_" + iIntValue;
            }
            if (iIntValue > 0) {
                linkedHashMap.put(strB0, Integer.valueOf(iIntValue));
                d("Item with key " + strB0 + " is repeated " + obj);
            }
            this.a.put(Integer.valueOf(i), str);
            i = i2;
        }
    }

    public void a(lmjxuqdtp.jvm.internal.f fVar, Function1 function1) {
        o.h(function1, "initializer");
        LinkedHashMap linkedHashMap = this.a;
        if (!linkedHashMap.containsKey(fVar)) {
            linkedHashMap.put(fVar, new g(fVar, function1));
            return;
        }
        throw new IllegalArgumentException(("A `initializer` with the same `clazz` has already been added: " + fVar.e() + '.').toString());
    }

    public void b(zb.a aVar) {
        o.h(aVar, "migration");
        int i = aVar.a;
        int i2 = aVar.b;
        Integer numValueOf = Integer.valueOf(i);
        LinkedHashMap linkedHashMap = this.a;
        Object treeMap = linkedHashMap.get(numValueOf);
        if (treeMap == null) {
            treeMap = new TreeMap();
            linkedHashMap.put(numValueOf, treeMap);
        }
        TreeMap treeMap2 = (TreeMap) treeMap;
        if (treeMap2.containsKey(Integer.valueOf(i2))) {
            Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i2)) + " with " + aVar);
        }
        treeMap2.put(Integer.valueOf(i2), aVar);
    }

    public d c() {
        Collection collectionValues = this.a.values();
        o.h(collectionValues, "initializers");
        g[] gVarArr = (g[]) collectionValues.toArray(new g[0]);
        return new d((g[]) Arrays.copyOf(gVarArr, gVarArr.length));
    }

    public void d(String str) {
        s02.d.a.getClass();
        s02.b.x(str);
    }

    public void e(String str, iw1.b bVar) {
        o.h(bVar, "providerOfValue");
        this.a.put(str, bVar);
    }

    public List f(String str) {
        o.h(str, "workSpecId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = this.a;
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            if (o.c(((l) entry.getKey()).b(), str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            linkedHashMap2.remove((l) it.next());
        }
        return mx1.o.m1(linkedHashMap.values());
    }

    public String g(int i) {
        String strB0;
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        d("No cached key is found for item " + i);
        vu0.d dVarValueOf = Integer.valueOf(i);
        if (!(dVarValueOf instanceof vu0.d) || (strB0 = dVarValueOf.getId()) == null) {
            strB0 = p.b0();
        }
        return b1.j(strB0, "_", p.b0());
    }

    public void h(String str) {
        String lowerCase = HttpHeaders.CACHE_CONTROL.toLowerCase(Locale.ROOT);
        o.g(lowerCase, "toLowerCase(...)");
        this.a.put(lowerCase, ct1.b.E(new String[]{str}));
    }

    public j i(l lVar) {
        LinkedHashMap linkedHashMap = this.a;
        Object jVar = linkedHashMap.get(lVar);
        if (jVar == null) {
            jVar = new j(lVar);
            linkedHashMap.put(lVar, jVar);
        }
        return (j) jVar;
    }

    public e(ve.o oVar) {
        Map map = oVar.a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), mx1.o.o1((Collection) entry.getValue()));
        }
        this.a = linkedHashMap;
    }

    public e(int i, boolean z) {
        switch (i) {
            case 1:
                this.a = new LinkedHashMap();
                break;
            case 2:
            case 3:
            default:
                this.a = new LinkedHashMap();
                break;
            case 4:
                this.a = new LinkedHashMap(0, 0.75f, true);
                break;
            case 5:
                this.a = new LinkedHashMap();
                break;
        }
    }

    public e(int i) {
        this.a = jw1.b.d(i);
    }
}
