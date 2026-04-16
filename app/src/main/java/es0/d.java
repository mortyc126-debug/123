package es0;

import com.bandlab.audiocore.generated.AudioApi;
import com.bandlab.audiocore.generated.AudioDeviceFormat;
import com.bandlab.audiocore.generated.AudioIoStateChange;
import di0.y;
import dm.f;
import im.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ky1.y0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function3;
import lx1.b0;
import mx1.z;
import nc0.n;
import so0.v;
import zg0.k;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends sx1.i implements Function3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f106j;
    public /* synthetic */ Object k;
    public /* synthetic */ Object l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i, int i2, qx1.d dVar) {
        super(i, dVar);
        this.f106j = i2;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f106j) {
            case 0:
                d dVar = new d(3, 0, (qx1.d) obj3);
                dVar.k = (gf0.j) obj;
                dVar.l = (List) obj2;
                return dVar.invokeSuspend(b0.a);
            case 1:
                d dVar2 = new d(3, 1, (qx1.d) obj3);
                dVar2.k = (ed0.e) obj;
                dVar2.l = (ed0.e) obj2;
                return dVar2.invokeSuspend(b0.a);
            case 2:
                d dVar3 = new d(3, 2, (qx1.d) obj3);
                dVar3.k = (f) obj;
                dVar3.l = (f) obj2;
                return dVar3.invokeSuspend(b0.a);
            case 3:
                d dVar4 = new d(3, 3, (qx1.d) obj3);
                dVar4.k = obj;
                dVar4.l = obj2;
                return dVar4.invokeSuspend(b0.a);
            case 4:
                d dVar5 = new d(3, 4, (qx1.d) obj3);
                dVar5.k = (m7.e) obj;
                dVar5.l = (o7.h) obj2;
                return dVar5.invokeSuspend(b0.a);
            case 5:
                d dVar6 = new d(3, 5, (qx1.d) obj3);
                dVar6.k = (re0.j) obj;
                dVar6.l = (ke0.c) obj2;
                return dVar6.invokeSuspend(b0.a);
            case 6:
                d dVar7 = new d(3, 6, (qx1.d) obj3);
                dVar7.k = (n) obj;
                dVar7.l = (oc0.f) obj2;
                return dVar7.invokeSuspend(b0.a);
            case 7:
                d dVar8 = new d(3, 7, (qx1.d) obj3);
                dVar8.k = (re0.e) obj;
                dVar8.l = (List) obj2;
                return dVar8.invokeSuspend(b0.a);
            case 8:
                d dVar9 = new d(3, 8, (qx1.d) obj3);
                dVar9.k = (tl0.r) obj;
                dVar9.l = (y) obj2;
                return dVar9.invokeSuspend(b0.a);
            case 9:
                d dVar10 = new d(3, 9, (qx1.d) obj3);
                dVar10.l = (List) obj;
                dVar10.k = (Set) obj2;
                return dVar10.invokeSuspend(b0.a);
            case 10:
                d dVar11 = new d(3, 10, (qx1.d) obj3);
                dVar11.k = (Set) obj;
                dVar11.l = (v) obj2;
                return dVar11.invokeSuspend(b0.a);
            case 11:
                d dVar12 = new d(3, 11, (qx1.d) obj3);
                dVar12.k = (lx1.l) obj;
                dVar12.l = (ay0.l) obj2;
                return dVar12.invokeSuspend(b0.a);
            case 12:
                d dVar13 = new d(3, 12, (qx1.d) obj3);
                dVar13.k = (Map) obj;
                dVar13.l = (Map) obj2;
                return dVar13.invokeSuspend(b0.a);
            case 13:
                d dVar14 = new d(3, 13, (qx1.d) obj3);
                dVar14.k = (k) obj;
                dVar14.l = (a21.e) obj2;
                return dVar14.invokeSuspend(b0.a);
            case 14:
                d dVar15 = new d(3, 14, (qx1.d) obj3);
                dVar15.k = (Set) obj;
                dVar15.l = (Map) obj2;
                return dVar15.invokeSuspend(b0.a);
            case 15:
                d dVar16 = new d(3, 15, (qx1.d) obj3);
                dVar16.k = (c60.h) obj;
                dVar16.l = (xs0.b) obj2;
                return dVar16.invokeSuspend(b0.a);
            case 16:
                d dVar17 = new d(3, 16, (qx1.d) obj3);
                dVar17.k = (j80.i) obj;
                dVar17.l = (n) obj2;
                return dVar17.invokeSuspend(b0.a);
            default:
                d dVar18 = new d(3, 17, (qx1.d) obj3);
                dVar18.k = (n) obj;
                dVar18.l = obj2;
                return dVar18.invokeSuspend(b0.a);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
        jm.c cVar;
        nc0.l jVar;
        switch (this.f106j) {
            case 0:
                gf0.j jVar2 = (gf0.j) this.k;
                List<gf0.h> list = (List) this.l;
                rx1.a aVar = rx1.a.a;
                lg.e.O(obj);
                ArrayList arrayList = new ArrayList(mx1.p.c0(list, 10));
                for (gf0.h hVar : list) {
                    arrayList.add(new c(hVar.b, hVar.equals(jVar2)));
                }
                return arrayList;
            case 1:
                ed0.e eVar = (ed0.e) this.k;
                ed0.e eVar2 = (ed0.e) this.l;
                rx1.a aVar2 = rx1.a.a;
                lg.e.O(obj);
                if (eVar2.a != null && !eVar2.equals(eVar)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 2:
                f fVar = (f) this.k;
                f fVar2 = (f) this.l;
                rx1.a aVar3 = rx1.a.a;
                lg.e.O(obj);
                AudioIoStateChange audioIoStateChange = fVar2.d;
                AudioIoStateChange audioIoStateChange2 = AudioIoStateChange.STOPPED;
                if (audioIoStateChange == audioIoStateChange2) {
                    return null;
                }
                if ((fVar != null ? fVar.d : null) == audioIoStateChange2) {
                    return null;
                }
                arrayList = fVar != null ? fVar.e : null;
                AudioDeviceFormat audioDeviceFormat = fVar2.e;
                y0 y0Var = im.y.a;
                AudioApi audioApi = audioDeviceFormat.getAudioApi();
                lmjxuqdtp.jvm.internal.o.g(audioApi, "getAudioApi(...)");
                int i = x.$EnumSwitchMapping$0[audioApi.ordinal()];
                if (i == 1) {
                    cVar = jm.c.b;
                } else if (i == 2) {
                    cVar = jm.c.c;
                } else {
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    cVar = jm.c.d;
                }
                return new jm.g(audioDeviceFormat.getSampleRate(), audioDeviceFormat.getFramesPerBuffer(), audioDeviceFormat.getNBits(), audioDeviceFormat.getNBuffers(), arrayList != null ? arrayList.getNChannels() : 0, audioDeviceFormat.getNChannels(), arrayList != null ? arrayList.getLowLatency() : false, cVar);
            case 3:
                Object obj2 = this.k;
                Object obj3 = this.l;
                rx1.a aVar4 = rx1.a.a;
                lg.e.O(obj);
                return ct1.b.C(new Object[]{obj2, obj3});
            case 4:
                rx1.a aVar5 = rx1.a.a;
                lg.e.O(obj);
                m7.e eVar3 = (m7.e) this.k;
                o7.h hVar2 = (o7.h) this.l;
                Set setKeySet = hVar2.a().keySet();
                ArrayList arrayList2 = new ArrayList(mx1.p.c0(setKeySet, 10));
                Iterator it = setKeySet.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((o7.f) it.next()).a);
                }
                LinkedHashMap linkedHashMapB = eVar3.b();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : linkedHashMapB.entrySet()) {
                    if (!arrayList2.contains((String) entry.getKey())) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                o7.b bVarC = hVar2.c();
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    String str = (String) entry2.getKey();
                    Object value = entry2.getValue();
                    if (value instanceof Boolean) {
                        bVarC.g(un0.m.C(str), value);
                    } else if (value instanceof Float) {
                        bVarC.g(un0.m.f0(str), value);
                    } else if (value instanceof Integer) {
                        bVarC.g(un0.m.m0(str), value);
                    } else if (value instanceof Long) {
                        bVarC.g(un0.m.n0(str), value);
                    } else if (value instanceof String) {
                        bVarC.g(un0.m.x0(str), value);
                    } else if (value instanceof Set) {
                        bVarC.g(un0.m.y0(str), (Set) value);
                    }
                }
                return new o7.b(z.f0(bVarC.a()), true);
            case 5:
                re0.j jVar3 = (re0.j) this.k;
                ke0.c cVar2 = (ke0.c) this.l;
                rx1.a aVar6 = rx1.a.a;
                lg.e.O(obj);
                return new lx1.l(jVar3, cVar2);
            case 6:
                nc0.j jVar4 = (n) this.k;
                oc0.c cVar3 = (oc0.f) this.l;
                rx1.a aVar7 = rx1.a.a;
                lg.e.O(obj);
                if (!lmjxuqdtp.jvm.internal.o.c(cVar3, oc0.d.a)) {
                    if (lmjxuqdtp.jvm.internal.o.c(cVar3, oc0.e.a)) {
                        arrayList = jVar4 instanceof nc0.j ? jVar4 : null;
                        if (arrayList == null) {
                            jVar = new nc0.l(jVar4.b());
                        }
                        return arrayList;
                    }
                    if (!(cVar3 instanceof oc0.c)) {
                        if (lmjxuqdtp.jvm.internal.o.c(cVar3, oc0.b.a)) {
                            return jVar4;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayList = jVar4 instanceof nc0.l ? (nc0.l) jVar4 : null;
                    if (arrayList == null) {
                        jVar = new nc0.j(cVar3.a(), jVar4.b());
                    }
                    return arrayList;
                }
                jVar = new nc0.l(jVar4.b());
                return jVar;
            case 7:
                re0.e eVar4 = (re0.e) this.k;
                List list2 = (List) this.l;
                rx1.a aVar8 = rx1.a.a;
                lg.e.O(obj);
                if (eVar4 == null) {
                    return null;
                }
                for (Object obj4 : list2) {
                    if (lmjxuqdtp.jvm.internal.o.c(((oj1.r) obj4).a.a, eVar4.c().a)) {
                        return obj4;
                    }
                }
                return null;
            case 8:
                tl0.s sVar = (tl0.r) this.k;
                y yVar = (y) this.l;
                rx1.a aVar9 = rx1.a.a;
                lg.e.O(obj);
                if (sVar instanceof tl0.n) {
                    return di0.z.P(yVar, new sr0.d(14, sVar));
                }
                if (!(sVar instanceof tl0.s)) {
                    throw new NoWhenBranchMatchedException();
                }
                tc0.l lVarO = q6.f.o(yVar);
                List<uj0.y> list3 = lVarO.a;
                if (list3 != null) {
                    arrayList = new ArrayList(mx1.p.c0(list3, 10));
                    for (uj0.y yVarO : list3) {
                        if (yVarO instanceof uj0.y) {
                            uj0.y yVar2 = yVarO;
                            tl0.s sVar2 = sVar;
                            if (ci0.o.b(yVar2.a(), sVar2.a().a())) {
                                yVarO = qk0.a.o(yVar2, sVar2.a());
                            }
                        }
                        arrayList.add(yVarO);
                    }
                }
                return y.a(yVar, new tc0.l(arrayList, lVarO.b), 0, 6);
            case 9:
                List list4 = (List) this.l;
                Set set = (Set) this.k;
                rx1.a aVar10 = rx1.a.a;
                ArrayList arrayListT = bh.j.t(obj);
                for (Object obj5 : list4) {
                    if (set.contains(((v) obj5).getId())) {
                        arrayListT.add(obj5);
                    }
                }
                return arrayListT;
            case 10:
                Set set2 = (Set) this.k;
                v vVar = (v) this.l;
                rx1.a aVar11 = rx1.a.a;
                lg.e.O(obj);
                return Boolean.valueOf(mx1.o.m0(set2, vVar != null ? vVar.getId() : null));
            case 11:
                lx1.l lVar = (lx1.l) this.k;
                ay0.l lVar2 = (ay0.l) this.l;
                rx1.a aVar12 = rx1.a.a;
                lg.e.O(obj);
                return new lx1.l(lVar.b, lVar2);
            case 12:
                Map map = (Map) this.k;
                Map map2 = (Map) this.l;
                rx1.a aVar13 = rx1.a.a;
                lg.e.O(obj);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(z.R(map.size()));
                for (Map.Entry entry3 : map.entrySet()) {
                    Object key = entry3.getKey();
                    String str2 = (String) entry3.getKey();
                    ij.j jVarA = (ij.j) entry3.getValue();
                    if (lmjxuqdtp.jvm.internal.o.c(map2.get(str2), Boolean.TRUE)) {
                        jVarA = ij.j.a(jVarA);
                    }
                    linkedHashMap2.put(key, jVarA);
                }
                return linkedHashMap2;
            case 13:
                k kVar = (k) this.k;
                a21.e eVar5 = (a21.e) this.l;
                rx1.a aVar14 = rx1.a.a;
                lg.e.O(obj);
                if (kVar == null && !eVar5.b.isEmpty()) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 14:
                Set set3 = (Set) this.k;
                Map map3 = (Map) this.l;
                rx1.a aVar15 = rx1.a.a;
                lg.e.O(obj);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (Object obj6 : set3) {
                    String str3 = (String) obj6;
                    if (!map3.keySet().contains(str3) || lmjxuqdtp.jvm.internal.o.c(map3.get(str3), Boolean.FALSE)) {
                        linkedHashSet.add(obj6);
                    }
                }
                return linkedHashSet;
            case 15:
                c60.h hVar3 = (c60.h) this.k;
                xs0.b bVar = (xs0.b) this.l;
                rx1.a aVar16 = rx1.a.a;
                lg.e.O(obj);
                if (bVar == xs0.b.c) {
                    return hVar3;
                }
                return null;
            case 16:
                j80.i iVar = (j80.i) this.k;
                nc0.i iVar2 = (n) this.l;
                rx1.a aVar17 = rx1.a.a;
                lg.e.O(obj);
                if ((iVar2 instanceof nc0.i) && iVar2.a.isEmpty()) {
                    arrayList = iVar != null ? ct1.b.B(iVar.G()) : null;
                    if (arrayList != null) {
                        return arrayList;
                    }
                }
                return mx1.t.a;
            default:
                n nVar = (n) this.k;
                Object obj7 = this.l;
                rx1.a aVar18 = rx1.a.a;
                lg.e.O(obj);
                lx1.l lVar3 = new lx1.l(nVar, obj7);
                if ((nVar instanceof nc0.i) || !nVar.b().isEmpty()) {
                    return lVar3;
                }
                return null;
        }
    }
}
