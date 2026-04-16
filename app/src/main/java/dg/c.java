package dg;

import a4.b1;
import bg.e;
import bg.f;
import com.gnacba.amuvvoafs.gms.internal.ads.cy;
import g4.d0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import jx0.h;
import lf.d;
import lmjxuqdtp.jvm.internal.o;
import mx1.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements f {
    public final /* synthetic */ int a;
    public final e b;
    public Object c;

    public c(int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = e.a;
                break;
            default:
                this.b = e.a;
                break;
        }
    }

    public final void a(d dVar) {
        hg.c cVar;
        ArrayList arrayList;
        switch (this.a) {
            case 0:
                Object obj = hg.c.b;
                String str = dVar.a.e;
                o.h(str, "instanceName");
                synchronized (hg.c.b) {
                    try {
                        LinkedHashMap linkedHashMap = hg.c.c;
                        Object cVar2 = linkedHashMap.get(str);
                        if (cVar2 == null) {
                            cVar2 = new hg.c();
                            linkedHashMap.put(str, cVar2);
                        }
                        cVar = (hg.c) cVar2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.c = cVar.a;
                return;
            default:
                String str2 = dVar.a.e;
                Object obj2 = kf.a.c;
                kf.a aVarB = h02.a.B(str2);
                this.c = aVarB;
                h hVar = aVarB.b;
                b1 b1Var = new b1(25, dVar);
                synchronized (hVar.b) {
                    hVar.c = b1Var;
                    arrayList = new ArrayList();
                    ((ArrayBlockingQueue) hVar.d).drainTo(arrayList);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    b1Var.invoke((kf.b) it.next());
                }
                return;
        }
    }

    public final ag.a b(ag.a aVar) {
        hg.b bVar;
        switch (this.a) {
            case 0:
                if (aVar.P != null) {
                    d0 d0Var = (d0) this.c;
                    if (d0Var == null) {
                        o.m("eventBridge");
                        throw null;
                    }
                    hg.d dVar = hg.d.a;
                    hg.a aVar2 = new hg.a(aVar.a(), aVar.O, aVar.P, aVar.Q, aVar.R);
                    synchronized (d0Var.b) {
                        try {
                            LinkedHashMap linkedHashMap = (LinkedHashMap) d0Var.c;
                            Object bVar2 = linkedHashMap.get(dVar);
                            if (bVar2 == null) {
                                bVar2 = new hg.b();
                                linkedHashMap.put(dVar, bVar2);
                            }
                            bVar = (hg.b) bVar2;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    synchronized (bVar.a) {
                        bVar.b.offer(aVar2);
                    }
                }
                return aVar;
            default:
                LinkedHashMap linkedHashMap2 = aVar.P;
                if (linkedHashMap2 != null && !linkedHashMap2.isEmpty() && !o.c(aVar.a(), "$exposure")) {
                    HashMap map = new HashMap();
                    for (Map.Entry entry : linkedHashMap2.entrySet()) {
                        String str = (String) entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Map) {
                            try {
                                map.put(str, (Map) value);
                            } catch (ClassCastException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    kf.a aVar3 = (kf.a) this.c;
                    if (aVar3 == null) {
                        o.m("connector");
                        throw null;
                    }
                    cy cyVar = aVar3.a;
                    kf.c cVarJ = cyVar.j();
                    String str2 = cVarJ.a;
                    String str3 = cVarJ.b;
                    LinkedHashMap linkedHashMapF0 = z.f0(cVarJ.c);
                    for (Map.Entry entry2 : map.entrySet()) {
                        String str4 = (String) entry2.getKey();
                        Map map2 = (Map) entry2.getValue();
                        int iHashCode = str4.hashCode();
                        if (iHashCode != 1186238) {
                            if (iHashCode != 146417720) {
                                if (iHashCode == 1142092165 && str4.equals("$unset")) {
                                    Iterator it = map2.entrySet().iterator();
                                    while (it.hasNext()) {
                                        linkedHashMapF0.remove(((Map.Entry) it.next()).getKey());
                                    }
                                }
                            } else if (str4.equals("$clearAll")) {
                                linkedHashMapF0.clear();
                            }
                        } else if (str4.equals("$set")) {
                            linkedHashMapF0.putAll(map2);
                        }
                    }
                    cyVar.o(new kf.c(linkedHashMapF0, str2, str3));
                }
                return aVar;
        }
    }

    public final e getType() {
        switch (this.a) {
        }
        return this.b;
    }
}
