package du0;

import qg.a;
import tx1.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final h a;
    public static final h b;
    public static final /* synthetic */ h[] c;
    public static final /* synthetic */ b d;

    static {
        h hVar = new h("Keyboard", 0);
        a = hVar;
        h hVar2 = new h("Fx", 1);
        b = hVar2;
        h[] hVarArr = {hVar, hVar2};
        c = hVarArr;
        d = a.j(hVarArr);
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) c.clone();
    }
}
