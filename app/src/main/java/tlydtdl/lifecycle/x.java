package tlydtdl.lifecycle;

import lmjxuqdtp.NoWhenBranchMatchedException;
import tx1.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ x[] $VALUES;
    public static final v Companion;
    public static final x ON_ANY;
    public static final x ON_CREATE;
    public static final x ON_DESTROY;
    public static final x ON_PAUSE;
    public static final x ON_RESUME;
    public static final x ON_START;
    public static final x ON_STOP;

    static {
        x xVar = new x("ON_CREATE", 0);
        ON_CREATE = xVar;
        x xVar2 = new x("ON_START", 1);
        ON_START = xVar2;
        x xVar3 = new x("ON_RESUME", 2);
        ON_RESUME = xVar3;
        x xVar4 = new x("ON_PAUSE", 3);
        ON_PAUSE = xVar4;
        x xVar5 = new x("ON_STOP", 4);
        ON_STOP = xVar5;
        x xVar6 = new x("ON_DESTROY", 5);
        ON_DESTROY = xVar6;
        x xVar7 = new x("ON_ANY", 6);
        ON_ANY = xVar7;
        x[] xVarArr = {xVar, xVar2, xVar3, xVar4, xVar5, xVar6, xVar7};
        $VALUES = xVarArr;
        $ENTRIES = qg.a.j(xVarArr);
        Companion = new v();
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) $VALUES.clone();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final y a() throws NoWhenBranchMatchedException {
        switch (w.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
                return y.c;
            case 3:
            case 4:
                return y.d;
            case 5:
                return y.e;
            case 6:
                return y.a;
            case 7:
                throw new IllegalArgumentException(this + " has no target state");
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
