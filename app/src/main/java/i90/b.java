package i90;

import org.apache.http.protocol.HTTP;
import qg.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a;
    public static final /* synthetic */ b[] b;

    static {
        b bVar = new b("Fade", 0);
        b bVar2 = new b(HTTP.CONN_CLOSE, 1);
        b bVar3 = new b("None", 2);
        a = bVar3;
        b[] bVarArr = {bVar, bVar2, bVar3};
        b = bVarArr;
        a.j(bVarArr);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) b.clone();
    }
}
