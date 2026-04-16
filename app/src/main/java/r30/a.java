package r30;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a a;
    public static final /* synthetic */ a[] b;
    public static final /* synthetic */ tx1.b c;

    static {
        a aVar = new a("RecentProjects", 0);
        a = aVar;
        a[] aVarArr = {aVar, new a("TrackTypes", 1), new a("Tools", 2), new a("Songbook", 3), new a("MembershipBanner", 4), new a("Shortcuts", 5)};
        b = aVarArr;
        c = qg.a.j(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) b.clone();
    }
}
