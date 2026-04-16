package fz0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final c a;
    public static final c b;
    public static final c c;
    public static final /* synthetic */ c[] d;

    static {
        c cVar = new c("Time", 0);
        a = cVar;
        c cVar2 = new c("UsernameOrBoosted", 1);
        b = cVar2;
        c cVar3 = new c("CreatorTime", 2);
        c = cVar3;
        c[] cVarArr = {cVar, cVar2, cVar3};
        d = cVarArr;
        qg.a.j(cVarArr);
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) d.clone();
    }
}
