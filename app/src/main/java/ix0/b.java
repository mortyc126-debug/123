package ix0;

import lx0.m;
import lx0.n;
import lx0.r;
import lx0.s;
import lx0.t;
import lx0.u;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b c;
    public static final b d;
    public static final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f233f;
    public static final b g;
    public static final b h;
    public static final b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f234j;
    public static final b k;
    public static final b l;
    public static final b m;
    public static final b n;
    public static final b o;
    public static final b p;
    public static final b q;
    public static final /* synthetic */ b[] r;
    public final String a;
    public final u b;

    static {
        b bVar = new b("AudioStretch", 0, "audiostretch_top_button");
        c = bVar;
        b bVar2 = new b("Splitter", 1, "splitter_top_button", r.INSTANCE);
        d = bVar2;
        t tVar = t.INSTANCE;
        b bVar3 = new b("SpatialStudio", 2, "spatial_studio_top_button", tVar);
        e = bVar3;
        b bVar4 = new b("SongStarter", 3, "songstarter_top_button");
        f233f = bVar4;
        b bVar5 = new b("Metronome", 4, "metronome_top_button");
        g = bVar5;
        b bVar6 = new b("Tuner", 5, "tuner_top_button");
        h = bVar6;
        b bVar7 = new b("Mastering", 6, "mastering_top_button", m.INSTANCE);
        i = bVar7;
        b bVar8 = new b("StudioNewTrack", 7, "studio_new_track_membership_button", s.INSTANCE);
        f234j = bVar8;
        b bVar9 = new b("Feed", 8, "feed_top_button", tVar);
        k = bVar9;
        b bVar10 = new b("Discover", 9, "discover_top_button", tVar);
        l = bVar10;
        b bVar11 = new b("Create", 10, "create_top_button", tVar);
        m = bVar11;
        b bVar12 = new b("Beats", 11, "beats_top_button", tVar);
        n = bVar12;
        b bVar13 = new b("Library", 12, "library_top_button", tVar);
        o = bVar13;
        b bVar14 = new b("Profile", 13, "profile_top_button", tVar);
        p = bVar14;
        b bVar15 = new b("ArtistServices", 14, "artist_services_top_button", tVar);
        q = bVar15;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14, bVar15};
        r = bVarArr;
        qg.a.j(bVarArr);
    }

    public b(String str, int i2, String str2, u uVar) {
        this.a = str2;
        this.b = uVar;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) r.clone();
    }

    public /* synthetic */ b(String str, int i2, String str2) {
        this(str, i2, str2, n.INSTANCE);
    }
}
