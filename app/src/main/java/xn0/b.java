package xn0;

import lx1.j;
import wy1.f;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@f
public final class b {
    public static final a Companion;
    public static final Object a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f696f;
    public static final b g;
    public static final b h;
    public static final b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f697j;
    public static final b k;
    public static final /* synthetic */ b[] l;

    static {
        b bVar = new b("VoiceTrack", 0);
        b = bVar;
        b bVar2 = new b("GuitarTrack", 1);
        c = bVar2;
        b bVar3 = new b("BassTrack", 2);
        d = bVar3;
        b bVar4 = new b("LooperTrack", 3);
        e = bVar4;
        b bVar5 = new b("MidiTrack", 4);
        f696f = bVar5;
        b bVar6 = new b("SamplerTrack", 5);
        g = bVar6;
        b bVar7 = new b("ImportTrack", 6);
        h = bVar7;
        b bVar8 = new b("OpenSounds", 7);
        i = bVar8;
        b bVar9 = new b("Sequencer", 8);
        f697j = bVar9;
        b bVar10 = new b("None", 9);
        k = bVar10;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9, bVar10};
        l = bVarArr;
        qg.a.j(bVarArr);
        Companion = new a();
        a = hs1.d.E(j.a, new x1.a(25));
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) l.clone();
    }
}
