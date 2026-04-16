package cg0;

import a2.o3;
import a21.a0;
import a21.j;
import a21.k;
import a21.n;
import a21.q;
import a21.r;
import a21.u;
import a21.x;
import bb.w;
import bz1.m;
import com.bandlab.audiocore.generated.AutoPitchData;
import com.bandlab.audiocore.generated.AuxData;
import com.bandlab.audiocore.generated.FloatParamAutomationData;
import com.bandlab.audiocore.generated.FloatParamData;
import com.bandlab.audiocore.generated.InstrumentData;
import com.bandlab.audiocore.generated.KeySignature;
import com.bandlab.audiocore.generated.MasteringData;
import com.bandlab.audiocore.generated.MixData;
import com.bandlab.audiocore.generated.MixDataChangeSet;
import com.bandlab.audiocore.generated.MixHandler;
import com.bandlab.audiocore.generated.MixStatus;
import com.bandlab.audiocore.generated.MusicUtils;
import com.bandlab.audiocore.generated.PatternData;
import com.bandlab.audiocore.generated.RegionData;
import com.bandlab.audiocore.generated.SamplerKitData;
import com.bandlab.audiocore.generated.TimeSignature;
import com.bandlab.audiocore.generated.TrackData;
import com.bandlab.audiocore.generated.TrackDataChangeSet;
import com.bandlab.audiocore.generated.TrackType;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.bandlab.revision.state.EffectDataChain;
import iu1.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kd.h;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import lx1.l;
import mx1.p;
import mx1.t;
import mx1.v;
import mx1.z;
import okhttp3.HttpUrl;
import st.w0;
import uo0.e;
import y11.b3;
import y11.c2;
import y11.d2;
import y11.f1;
import y11.g2;
import y11.n0;
import y11.o1;
import y11.o4;
import y11.q0;
import y11.q4;
import y11.r1;
import y11.s2;
import y11.t0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final e a;
    public final vb0.a b;
    public final lt.b c;
    public final h d;

    public a(d dVar, e eVar, c cVar, vb0.a aVar, lt.b bVar, h hVar) {
        this.a = eVar;
        this.b = aVar;
        this.c = bVar;
        this.d = hVar;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final l a(a21.e eVar, MixDataChangeSet mixDataChangeSet) throws NoWhenBranchMatchedException {
        Set setR1;
        String str;
        q4 q4Var;
        r1 r1VarG;
        Iterator it;
        t arrayList;
        String str2;
        m mVarB;
        a21.m pVar;
        a21.m mVar;
        t tVar;
        a21.m mVar2;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        u uVar;
        List list;
        n0 n0Var;
        u uVarA;
        ArrayList<FloatParamAutomationData> automationCurve;
        ArrayList automationCurve2;
        a21.e eVar2 = eVar;
        o.h(eVar2, "preparedRevision");
        String str3 = eVar2.c;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList modifiedTracks = mixDataChangeSet.getModifiedTracks();
        o.g(modifiedTracks, "getModifiedTracks(...)");
        ArrayList arrayList5 = new ArrayList();
        Iterator it2 = modifiedTracks.iterator();
        while (it2.hasNext()) {
            TrackDataChangeSet trackDataChangeSet = (TrackDataChangeSet) it2.next();
            String trackId = trackDataChangeSet.getTrackId();
            o.g(trackId, "getTrackId(...)");
            u uVarB = eVar2.b(trackId);
            if (uVarB == null) {
                w wVar = new w(2);
                ArrayList arrayList6 = wVar.a;
                wVar.a("CRITICAL");
                wVar.e(new String[0]);
                String[] strArr = (String[]) arrayList6.toArray(new String[arrayList6.size()]);
                DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Can't find modified track!!"), (String[]) Arrays.copyOf(strArr, strArr.length)));
                str2 = str3;
                it = it2;
                arrayList4 = arrayList5;
                uVarA = null;
            } else {
                n nVar = uVarB.o;
                k kVarA = uVarB.c;
                n0 n0Var2 = uVarB.j;
                ArrayList<RegionData> addedRegions = trackDataChangeSet.getAddedRegions();
                o.g(addedRegions, "getAddedRegions(...)");
                ArrayList arrayList7 = new ArrayList(p.c0(addedRegions, 10));
                for (RegionData regionData : addedRegions) {
                    o.e(regionData);
                    Object objQ = qs1.p.q(regionData);
                    lg.e.O(objQ);
                    arrayList7.add((a21.c) objQ);
                }
                int iR = z.R(p.c0(arrayList7, 10));
                if (iR < 16) {
                    iR = 16;
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(iR);
                for (Object obj : arrayList7) {
                    linkedHashMap3.put(x.a(((a21.c) obj).a), obj);
                }
                ArrayList<RegionData> modifiedRegions = trackDataChangeSet.getModifiedRegions();
                o.g(modifiedRegions, "getModifiedRegions(...)");
                it = it2;
                ArrayList arrayList8 = new ArrayList(p.c0(modifiedRegions, 10));
                for (RegionData regionData2 : modifiedRegions) {
                    o.e(regionData2);
                    Object objQ2 = qs1.p.q(regionData2);
                    lg.e.O(objQ2);
                    arrayList8.add((a21.c) objQ2);
                }
                int iR2 = z.R(p.c0(arrayList8, 10));
                if (iR2 < 16) {
                    iR2 = 16;
                }
                LinkedHashMap linkedHashMap4 = new LinkedHashMap(iR2);
                for (Object obj2 : arrayList8) {
                    linkedHashMap4.put(x.a(((a21.c) obj2).a), obj2);
                }
                ArrayList deletedRegions = trackDataChangeSet.getDeletedRegions();
                o.g(deletedRegions, "getDeletedRegions(...)");
                ArrayList arrayList9 = new ArrayList(p.c0(deletedRegions, 10));
                Iterator it3 = deletedRegions.iterator();
                while (it3.hasNext()) {
                    String id = ((RegionData) it3.next()).getId();
                    o.g(id, "getId(...)");
                    x.b(id);
                    arrayList9.add(x.a(id));
                }
                ArrayList patterns = trackDataChangeSet.getPatterns();
                if (patterns != null) {
                    arrayList = new ArrayList(p.c0(patterns, 10));
                    Iterator it4 = patterns.iterator();
                    while (it4.hasNext()) {
                        PatternData patternData = (PatternData) it4.next();
                        Iterator it5 = it4;
                        ArrayList noteRows = patternData.getNoteRows();
                        o.g(noteRows, "getNoteRows(...)");
                        String sampleId = patternData.getSampleId();
                        o.g(sampleId, "getSampleId(...)");
                        arrayList.add(new g2(noteRows, sampleId));
                        it4 = it5;
                        str3 = str3;
                    }
                } else {
                    arrayList = null;
                }
                str2 = str3;
                InstrumentData instrumentData = trackDataChangeSet.getInstrumentData();
                if (instrumentData != null) {
                    String soundbank = instrumentData.getSoundbank();
                    o.g(soundbank, "getSoundbank(...)");
                    mVarB = this.b.c(soundbank);
                } else {
                    mVarB = null;
                }
                a21.m mVar3 = uVarB.b;
                if ((mVar3 instanceof a21.l) || (mVar3 instanceof a21.o) || (mVar3 instanceof q)) {
                    pVar = mVar3;
                } else if (mVar3 instanceof a21.m) {
                    t tVar2 = arrayList == null ? mVar3.a : arrayList;
                    if (mVarB == null) {
                        mVarB = mVar3.b.b();
                    }
                    r rVarA = r.a(mVar3.b, mVarB);
                    o.h(tVar2, "patterns");
                    pVar = new a21.m(tVar2, rVarA);
                } else {
                    if (!(mVar3 instanceof a21.p)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (mVarB == null) {
                        mVarB = ((a21.p) mVar3).b.b();
                    }
                    a21.p pVar2 = (a21.p) mVar3;
                    r rVarA2 = r.a(pVar2.b, mVarB);
                    String str4 = pVar2.a;
                    o.h(str4, "typeSlug");
                    pVar = new a21.p(str4, rVarA2);
                }
                Boolean isFrozen = trackDataChangeSet.getIsFrozen();
                boolean zBooleanValue = isFrozen != null ? isFrozen.booleanValue() : uVarB.l;
                if (trackDataChangeSet.getIsMuted() == null && trackDataChangeSet.getIsSolo() == null) {
                    mVar = pVar;
                    tVar = arrayList;
                } else {
                    Boolean isMuted = trackDataChangeSet.getIsMuted();
                    boolean zBooleanValue2 = isMuted != null ? isMuted.booleanValue() : kVarA.b;
                    Boolean isSolo = trackDataChangeSet.getIsSolo();
                    mVar = pVar;
                    tVar = arrayList;
                    kVarA = k.a(kVarA, isSolo != null ? isSolo.booleanValue() : kVarA.a, zBooleanValue2, false, 4);
                }
                FloatParamData pan = trackDataChangeSet.getPan();
                if (pan == null || (automationCurve2 = pan.getAutomationCurve()) == null) {
                    mVar2 = mVar3;
                    arrayList2 = null;
                } else {
                    arrayList2 = new ArrayList(p.c0(automationCurve2, 10));
                    for (Iterator it6 = automationCurve2.iterator(); it6.hasNext(); it6 = it6) {
                        FloatParamAutomationData floatParamAutomationData = (FloatParamAutomationData) it6.next();
                        arrayList2.add(new q0(floatParamAutomationData.getPosition(), floatParamAutomationData.getValue()));
                        mVar3 = mVar3;
                    }
                    mVar2 = mVar3;
                }
                FloatParamData volume = trackDataChangeSet.getVolume();
                if (volume == null || (automationCurve = volume.getAutomationCurve()) == null) {
                    arrayList3 = arrayList2;
                    arrayList4 = arrayList5;
                    uVar = uVarB;
                    list = null;
                } else {
                    ArrayList arrayList10 = new ArrayList(p.c0(automationCurve, 10));
                    for (FloatParamAutomationData floatParamAutomationData2 : automationCurve) {
                        arrayList10.add(new q0(floatParamAutomationData2.getPosition(), floatParamAutomationData2.getValue()));
                        arrayList2 = arrayList2;
                        uVarB = uVarB;
                        arrayList5 = arrayList5;
                    }
                    arrayList3 = arrayList2;
                    arrayList4 = arrayList5;
                    uVar = uVarB;
                    list = arrayList10;
                }
                if (arrayList3 == null && list == null) {
                    n0Var = n0Var2;
                } else {
                    List list2 = arrayList3 == null ? n0Var2 != null ? n0Var2.a : null : arrayList3;
                    if (list == null) {
                        list = n0Var2 != null ? n0Var2.b : null;
                    }
                    n0Var = new n0(list2, list);
                }
                ArrayList effectChain = trackDataChangeSet.getEffectChain();
                EffectDataChain effectDataChain = effectChain != null ? new EffectDataChain(effectChain) : nVar.c;
                String trackId2 = trackDataChangeSet.getTrackId();
                LinkedHashMap linkedHashMapY = z.Y(linkedHashMap3, linkedHashMap4);
                int iR3 = z.R(p.c0(arrayList9, 10));
                if (iR3 < 16) {
                    iR3 = 16;
                }
                LinkedHashMap linkedHashMap5 = new LinkedHashMap(iR3);
                for (Object obj3 : arrayList9) {
                    ((x) obj3).getClass();
                    linkedHashMap5.put(obj3, null);
                }
                linkedHashMap.put(trackId2, new z11.q(z.Y(linkedHashMapY, linkedHashMap5)));
                t tVar3 = t.a;
                t tVar4 = tVar == null ? tVar3 : tVar;
                int iR4 = z.R(p.c0(tVar4, 10));
                if (iR4 < 16) {
                    iR4 = 16;
                }
                LinkedHashMap linkedHashMap6 = new LinkedHashMap(iR4);
                Iterator it7 = tVar4.iterator();
                while (it7.hasNext()) {
                    String strD = ((g2) it7.next()).d();
                    a21.z.b(strD);
                    linkedHashMap6.put(a21.z.a(strD), new j(strD, true, 0.0d, (String) null, 124));
                }
                LinkedHashMap linkedHashMapY2 = mx1.u.a;
                for (a21.c cVar : z.Y(linkedHashMap4, linkedHashMap3).values()) {
                    t tVar5 = cVar.n;
                    if (tVar5 == null) {
                        tVar5 = tVar3;
                    }
                    t tVar6 = tVar3;
                    ArrayList arrayList11 = new ArrayList(p.c0(tVar5, 10));
                    Iterator it8 = tVar5.iterator();
                    while (it8.hasNext()) {
                        arrayList11.add(a21.z.a(((a21.b) it8.next()).a()));
                    }
                    Set setR12 = mx1.o.r1(mx1.o.S0(arrayList11, a21.z.a(cVar.b)));
                    int iR5 = z.R(p.c0(setR12, 10));
                    if (iR5 < 16) {
                        iR5 = 16;
                    }
                    LinkedHashMap linkedHashMap7 = new LinkedHashMap(iR5);
                    for (Object obj4 : setR12) {
                        linkedHashMap7.put(obj4, new j(((a21.z) obj4).g(), mVar2.a(), 0.0d, (String) null, 124));
                    }
                    linkedHashMapY2 = z.Y(linkedHashMapY2, linkedHashMap7);
                    tVar3 = tVar6;
                }
                linkedHashMap2.putAll(z.Y(linkedHashMapY2, linkedHashMap6));
                u uVar2 = uVar;
                LinkedHashMap linkedHashMapY3 = z.Y(z.Y(z.V(uVar2.d, arrayList9), linkedHashMap3), linkedHashMap4);
                n nVarA = n.a(nVar, (String) null, effectDataChain, 3);
                FloatParamData volume2 = trackDataChangeSet.getVolume();
                double value = volume2 != null ? volume2.getValue() : uVar2.f;
                FloatParamData pan2 = trackDataChangeSet.getPan();
                uVarA = u.a(uVar2, (String) null, mVar, kVarA, linkedHashMapY3, value, (String) null, (o4) null, pan2 != null ? pan2.getValue() : uVar2.i, n0Var, zBooleanValue, nVarA, 13521);
            }
            ArrayList arrayList12 = arrayList4;
            if (uVarA != null) {
                arrayList12.add(uVarA);
            }
            arrayList5 = arrayList12;
            it2 = it;
            str3 = str2;
            eVar2 = eVar;
        }
        String str5 = str3;
        ArrayList arrayList13 = arrayList5;
        ArrayList deletedTracks = mixDataChangeSet.getDeletedTracks();
        o.g(deletedTracks, "getDeletedTracks(...)");
        if (deletedTracks.isEmpty()) {
            setR1 = v.a;
        } else {
            String str6 = "We can delete tracks with engine data, but it is not expected: " + mixDataChangeSet.getDeletedTracks();
            w wVar2 = new w(2);
            ArrayList arrayList14 = wVar2.a;
            wVar2.a("CRITICAL");
            wVar2.e(new String[0]);
            String[] strArr2 = (String[]) arrayList14.toArray(new String[arrayList14.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException(str6), (String[]) Arrays.copyOf(strArr2, strArr2.length)));
            ArrayList deletedTracks2 = mixDataChangeSet.getDeletedTracks();
            o.g(deletedTracks2, "getDeletedTracks(...)");
            ArrayList arrayList15 = new ArrayList(p.c0(deletedTracks2, 10));
            Iterator it9 = deletedTracks2.iterator();
            while (it9.hasNext()) {
                String id2 = ((TrackData) it9.next()).getId();
                o.g(id2, "getId(...)");
                arrayList15.add(new q4(id2));
            }
            setR1 = mx1.o.r1(arrayList15);
        }
        ArrayList addedTracks = mixDataChangeSet.getAddedTracks();
        o.g(addedTracks, "getAddedTracks(...)");
        if (!addedTracks.isEmpty()) {
            String str7 = "The engine does not have enough information to add tracks! This is an error (tracks : " + mixDataChangeSet.getAddedTracks() + ")";
            w wVar3 = new w(2);
            ArrayList arrayList16 = wVar3.a;
            wVar3.a("CRITICAL");
            wVar3.e(new String[0]);
            String[] strArr3 = (String[]) arrayList16.toArray(new String[arrayList16.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException(str7), (String[]) Arrays.copyOf(strArr3, strArr3.length)));
        }
        List list3 = eVar.b;
        ArrayList arrayList17 = new ArrayList();
        for (Object obj5 : list3) {
            if (!setR1.contains(new q4(((u) obj5).a))) {
                arrayList17.add(obj5);
            }
        }
        List listF0 = com.facebook.appevents.p.f0(arrayList17, arrayList13);
        LinkedHashMap linkedHashMapY4 = z.Y(linkedHashMap2, eVar.d);
        ArrayList arrayList18 = new ArrayList(p.c0(listF0, 10));
        Iterator it10 = listF0.iterator();
        while (it10.hasNext()) {
            arrayList18.add(new q4(((u) it10.next()).a));
        }
        if (str5 != null) {
            str = str5;
            q4Var = new q4(str);
        } else {
            str = str5;
            q4Var = null;
        }
        String str8 = !mx1.o.m0(arrayList18, q4Var) ? null : str;
        MasteringData mastering = mixDataChangeSet.getMastering();
        if (mastering == null || (r1VarG = kp1.e.G(mastering)) == null) {
            r1VarG = eVar.i;
        }
        return new l(a21.e.a(eVar, (String) null, listF0, str8, linkedHashMapY4, (LinkedHashMap) null, (String) null, (d2) null, (o1) null, r1VarG, 0.0d, (ArrayList) null, (a0) null, 7921), linkedHashMap);
    }

    public final Object b(MixData mixData) {
        HashMap duplicateTrackIds = MixHandler.getDuplicateTrackIds(mixData);
        o.g(duplicateTrackIds, "getDuplicateTrackIds(...)");
        HashMap duplicateRegionIds = MixHandler.getDuplicateRegionIds(mixData);
        o.g(duplicateRegionIds, "getDuplicateRegionIds(...)");
        MixStatus mixStatusCleanupMix = MixHandler.cleanupMix(mixData, this.c.d());
        o.g(mixStatusCleanupMix, "cleanupMix(...)");
        if (mixStatusCleanupMix.getResult().getOk() && duplicateTrackIds.isEmpty() && duplicateRegionIds.isEmpty()) {
            return b0.a;
        }
        StringBuilder sb = new StringBuilder();
        if (!mixStatusCleanupMix.getResult().getOk()) {
            sb.append("ISSUES: " + mixStatusCleanupMix.getResult().getMsg() + " ");
        }
        if (!duplicateTrackIds.isEmpty() || !duplicateRegionIds.isEmpty()) {
            sb.append("DUPLICATES: Tracks: " + duplicateTrackIds + ", Regions: " + duplicateRegionIds);
        }
        return lg.e.u(new IllegalStateException(sb.toString()));
    }

    public final a21.e c(a21.e eVar) {
        o.h(eVar, "preparedRevision");
        MixStatus mixStatusCleanupMix = MixHandler.cleanupMix(com.facebook.appevents.h.O(eVar, this.a, this.d), this.c.d());
        o.g(mixStatusCleanupMix, "cleanupMix(...)");
        MixData mix = mixStatusCleanupMix.getMix();
        o.g(mix, "getMix(...)");
        return e(eVar, mix);
    }

    public final MixData d(s2 s2Var) {
        String str;
        List list = s2Var.c;
        List list2 = t.a;
        if (list == null) {
            list = list2;
        }
        ArrayList arrayListP = com.facebook.appevents.l.P(list, new o3(22, this));
        List list3 = s2Var.f;
        if (list3 != null) {
            list2 = list3;
        }
        ArrayList arrayList = new ArrayList(p.c0(list2, 10));
        Iterator it = list2.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (!zHasNext) {
                break;
            }
            t0 t0Var = (t0) it.next();
            TrackType trackType = TrackType.AUX;
            String strC = t0Var.c();
            String strA = t0Var.a();
            if (strA == null) {
                strA = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            String strD = t0Var.d();
            if (strD == null) {
                strD = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            arrayList.add(new TrackData(trackType, strC, strA, strD, e.b(this.a, t0Var.b()), 0, new FloatParamData(HttpUrl.FRAGMENT_ENCODE_SET, t0Var.e(), new ArrayList()), new FloatParamData(HttpUrl.FRAGMENT_ENCODE_SET, 0.0d, new ArrayList()), false, false, (InstrumentData) null, HttpUrl.FRAGMENT_ENCODE_SET, new ArrayList(), b.a, (AutoPitchData) null, false, HttpUrl.FRAGMENT_ENCODE_SET, (SamplerKitData) null, (ArrayList) null, false, true));
        }
        d2 d2Var = s2Var.v;
        if (d2Var == null) {
            d2Var = new d2();
        }
        String strA2 = b3.a(s2Var);
        double d = s2Var.w;
        c2 c2Var = d2Var.b;
        AuxData auxData = b.a;
        TimeSignature timeSignature = c2Var != null ? new TimeSignature(c2Var.a, c2Var.b) : new TimeSignature(4, 4);
        String str2 = s2Var.l;
        if (str2 != null) {
            str = str2;
        }
        KeySignature keySig = MusicUtils.parseKeySig(str);
        o.g(keySig, "parseKeySig(...)");
        double d3 = d2Var.a;
        ArrayList arrayList2 = new ArrayList(mx1.o.R0(arrayListP, arrayList));
        r1 r1Var = s2Var.z;
        return new MixData(strA2, d, timeSignature, keySig, d3, arrayList2, r1Var != null ? kp1.e.F(r1Var) : null);
    }

    public final a21.e e(a21.e eVar, MixData mixData) {
        String str;
        e eVar2;
        o.h(eVar, "preparedRevision");
        d2 d2Var = new d2((int) mixData.getTempo(), new c2(mixData.getTimeSig().getBeats(), mixData.getTimeSig().getBeatUnit()));
        KeySignature keySig = mixData.getKeySig();
        o.e(keySig);
        if (MusicUtils.keySigIsUndefined(keySig)) {
            keySig = null;
        }
        if (keySig != null) {
            String strKeySigToString = MusicUtils.keySigToString(keySig);
            o.g(strKeySigToString, "keySigToString(...)");
            str = strKeySigToString;
        } else {
            str = null;
        }
        double volume = mixData.getVolume();
        ArrayList tracks = mixData.getTracks();
        o.g(tracks, "getTracks(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : tracks) {
            if (((TrackData) obj).getType() == TrackType.AUX) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(p.c0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            eVar2 = this.a;
            if (!zHasNext) {
                break;
            }
            TrackData trackData = (TrackData) it.next();
            String id = trackData.getId();
            o.g(id, "getId(...)");
            float value = (float) trackData.getVolume().getValue();
            String name = trackData.getName();
            String preset = trackData.getPreset();
            ArrayList effectChain = trackData.getEffectChain();
            o.g(effectChain, "getEffectChain(...)");
            arrayList2.add(new t0(id, value, name, preset, eVar2.c(effectChain, true)));
        }
        ArrayList tracks2 = mixData.getTracks();
        o.g(tracks2, "getTracks(...)");
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = tracks2.iterator();
        while (it2.hasNext()) {
            SamplerKitData samplerKit = ((TrackData) it2.next()).getSamplerKit();
            ArrayList sampleIds = samplerKit != null ? samplerKit.getSampleIds() : null;
            if (sampleIds != null) {
                arrayList3.add(sampleIds);
            }
        }
        ArrayList<String> arrayListD0 = p.d0(arrayList3);
        int iR = z.R(p.c0(arrayListD0, 10));
        if (iR < 16) {
            iR = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iR);
        for (String str2 : arrayListD0) {
            o.e(str2);
            a21.z.b(str2);
            linkedHashMap.put(a21.z.a(str2), new j(str2, false, 0.0d, (String) null, 124));
        }
        MixDataChangeSet mixDataChangeSet = MixHandler.getMixDataChangeSet(com.facebook.appevents.h.O(eVar, eVar2, this.d), mixData);
        o.g(mixDataChangeSet, "getMixDataChangeSet(...)");
        return a21.e.a((a21.e) a(eVar, mixDataChangeSet).a, (String) null, (List) null, (String) null, (Map) null, linkedHashMap, str, d2Var, (o1) null, (r1) null, volume, arrayList2, (a0) null, 6543);
    }

    public final MixData f(a21.e eVar) {
        o.h(eVar, "preparedRevision");
        MixStatus mixStatusCleanupMix = MixHandler.cleanupMix(com.facebook.appevents.h.O(eVar, this.a, this.d), this.c.d());
        o.g(mixStatusCleanupMix, "cleanupMix(...)");
        MixData mix = mixStatusCleanupMix.getMix();
        o.g(mix, "getMix(...)");
        return mix;
    }

    public final MixData g(f1 f1Var) {
        o.h(f1Var, "rev");
        MixStatus mixStatusCleanupMix = MixHandler.cleanupMix(d(w0.C0(f1Var)), this.c.d());
        o.g(mixStatusCleanupMix, "cleanupMix(...)");
        MixData mix = mixStatusCleanupMix.getMix();
        o.g(mix, "getMix(...)");
        return mix;
    }
}
