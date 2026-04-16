package oz0;

import aj.a;
import lx1.j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class q {
    public static final p Companion;
    public static final Object a;
    public static final q b;
    public static final q c;
    public static final /* synthetic */ q[] d;

    static {
        q qVar = new q("Released", 0);
        b = qVar;
        q qVar2 = new q("Draft", 1);
        c = qVar2;
        q[] qVarArr = {qVar, qVar2};
        d = qVarArr;
        qg.a.j(qVarArr);
        Companion = new p();
        a = hs1.d.E(j.a, new ow.a(6));
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) d.clone();
    }
}
