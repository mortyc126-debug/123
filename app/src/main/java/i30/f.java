package i30;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final f a;
    public static final f b;
    public static final f c;
    public static final /* synthetic */ f[] d;

    static {
        f fVar = new f("FromBandlab", 0);
        a = fVar;
        f fVar2 = new f("ForMembers", 1);
        b = fVar2;
        f fVar3 = new f("FollowingFeed", 2);
        c = fVar3;
        f[] fVarArr = {fVar, fVar2, fVar3};
        d = fVarArr;
        qg.a.j(fVarArr);
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) d.clone();
    }
}
