package o81;

import qg.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ b[] f364f;
    public final long a;

    static {
        b bVar = new b(0, 1500L, "SHORT");
        b bVar2 = new b(1, 3000L, "LONG");
        b = bVar2;
        b bVar3 = new b(2, 5000L, "LONGER");
        c = bVar3;
        b bVar4 = new b(3, 10000L, "LONGEST");
        d = bVar4;
        b bVar5 = new b(4, 0L, "PERMANENT");
        e = bVar5;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5};
        f364f = bVarArr;
        a.j(bVarArr);
    }

    public b(int i, long j2, String str) {
        this.a = j2;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f364f.clone();
    }
}
