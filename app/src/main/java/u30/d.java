package u30;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final /* synthetic */ d[] e;

    static {
        d dVar = new d("Unknown", 0);
        a = dVar;
        d dVar2 = new d("MidiEditor", 1);
        b = dVar2;
        d dVar3 = new d("Multitrack", 2);
        c = dVar3;
        d dVar4 = new d("Instrument", 3);
        d = dVar4;
        d[] dVarArr = {dVar, dVar2, dVar3, dVar4};
        e = dVarArr;
        qg.a.j(dVarArr);
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) e.clone();
    }
}
