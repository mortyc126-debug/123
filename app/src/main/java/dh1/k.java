package dh1;

import hs1.d;
import tx1.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class k {
    public static final j Companion;
    public static final Object a;
    public static final /* synthetic */ k[] b;
    public static final /* synthetic */ b c;

    static {
        k[] kVarArr = {new k("Other", 0), new k("Male", 1), new k("Female", 2)};
        b = kVarArr;
        c = qg.a.j(kVarArr);
        Companion = new j();
        a = d.E(lx1.j.a, new cl1.x(13));
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) b.clone();
    }
}
