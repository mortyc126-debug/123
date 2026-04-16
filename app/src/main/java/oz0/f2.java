package oz0;

import aj.a;
import lx1.j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class f2 {
    public static final e2 Companion;
    public static final Object a;
    public static final f2 b;
    public static final f2 c;
    public static final f2 d;
    public static final f2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f2 f380f;
    public static final f2 g;
    public static final f2 h;
    public static final /* synthetic */ f2[] i;

    static {
        f2 f2Var = new f2("Revision", 0);
        b = f2Var;
        f2 f2Var2 = new f2("Image", 1);
        c = f2Var2;
        f2 f2Var3 = new f2("Video", 2);
        d = f2Var3;
        f2 f2Var4 = new f2("Text", 3);
        e = f2Var4;
        f2 f2Var5 = new f2("Link", 4);
        f380f = f2Var5;
        f2 f2Var6 = new f2("Show", 5);
        g = f2Var6;
        f2 f2Var7 = new f2("Track", 6);
        h = f2Var7;
        f2[] f2VarArr = {f2Var, f2Var2, f2Var3, f2Var4, f2Var5, f2Var6, f2Var7};
        i = f2VarArr;
        qg.a.j(f2VarArr);
        Companion = new e2();
        a = hs1.d.E(j.a, new ow.a(17));
    }

    public static f2 valueOf(String str) {
        return (f2) Enum.valueOf(f2.class, str);
    }

    public static f2[] values() {
        return (f2[]) i.clone();
    }
}
