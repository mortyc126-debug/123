package wz0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f665f;
    public static final e g;
    public static final e h;
    public static final e i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f666j;
    public static final e k;
    public static final e l;
    public static final e m;
    public static final e n;
    public static final /* synthetic */ e[] o;

    static {
        e eVar = new e("Image", 0);
        a = eVar;
        e eVar2 = new e("Video", 1);
        b = eVar2;
        e eVar3 = new e("Text", 2);
        c = eVar3;
        e eVar4 = new e("TextWithBackground", 3);
        d = eVar4;
        e eVar5 = new e("Link", 4);
        e = eVar5;
        e eVar6 = new e("AlbumRepost", 5);
        f665f = eVar6;
        e eVar7 = new e("UnavailableAlbum", 6);
        g = eVar7;
        e eVar8 = new e("TrackRepost", 7);
        h = eVar8;
        e eVar9 = new e("UnavailableTrack", 8);
        i = eVar9;
        e eVar10 = new e("Show", 9);
        f666j = eVar10;
        e eVar11 = new e("Track", 10);
        k = eVar11;
        e eVar12 = new e("Beat", 11);
        l = eVar12;
        e eVar13 = new e("UnavailableBeat", 12);
        m = eVar13;
        e eVar14 = new e("Unknown", 13);
        n = eVar14;
        e[] eVarArr = {eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9, eVar10, eVar11, eVar12, eVar13, eVar14};
        o = eVarArr;
        qg.a.j(eVarArr);
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) o.clone();
    }
}
