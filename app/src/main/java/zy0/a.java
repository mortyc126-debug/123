package zy0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f760f;
    public static final a g;
    public static final a h;
    public static final a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ a[] f761j;

    static {
        a aVar = new a("PageHeader", 0);
        a = aVar;
        a aVar2 = new a("ExploreTile", 1);
        b = aVar2;
        a aVar3 = new a("FollowingTile", 2);
        c = aVar3;
        a aVar4 = new a("ProfileFeedTile", 3);
        d = aVar4;
        a aVar5 = new a("ProfileTabTile", 4);
        a aVar6 = new a("MediaFeedTile", 5);
        e = aVar6;
        a aVar7 = new a("MediaFeedHashTags", 6);
        a aVar8 = new a("SearchTab", 7);
        f760f = aVar8;
        a aVar9 = new a("UserProfileMusicTabAlbums", 8);
        g = aVar9;
        a aVar10 = new a("UserProfileMusicTabPlaylists", 9);
        h = aVar10;
        a aVar11 = new a("OtherTiles", 10);
        i = aVar11;
        a[] aVarArr = {aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11};
        f761j = aVarArr;
        qg.a.j(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f761j.clone();
    }
}
