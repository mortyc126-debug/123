package s4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class w {
    public static final w a;
    public static final w b;
    public static final w c;
    public static final w d;
    public static final /* synthetic */ w[] e;

    static {
        w wVar = new w("LookaheadMeasurement", 0);
        a = wVar;
        w wVar2 = new w("LookaheadPlacement", 1);
        b = wVar2;
        w wVar3 = new w("Measurement", 2);
        c = wVar3;
        w wVar4 = new w("Placement", 3);
        d = wVar4;
        w[] wVarArr = {wVar, wVar2, wVar3, wVar4};
        e = wVarArr;
        qg.a.j(wVarArr);
    }

    public static w valueOf(String str) {
        return (w) Enum.valueOf(w.class, str);
    }

    public static w[] values() {
        return (w[]) e.clone();
    }
}
