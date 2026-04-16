package i5;

import qg.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    public static final y a;
    public static final y b;
    public static final y c;
    public static final y d;
    public static final /* synthetic */ y[] e;

    static {
        y yVar = new y("StartInput", 0);
        a = yVar;
        y yVar2 = new y("StopInput", 1);
        b = yVar2;
        y yVar3 = new y("ShowKeyboard", 2);
        c = yVar3;
        y yVar4 = new y("HideKeyboard", 3);
        d = yVar4;
        y[] yVarArr = {yVar, yVar2, yVar3, yVar4};
        e = yVarArr;
        a.j(yVarArr);
    }

    public static y valueOf(String str) {
        return (y) Enum.valueOf(y.class, str);
    }

    public static y[] values() {
        return (y[]) e.clone();
    }
}
