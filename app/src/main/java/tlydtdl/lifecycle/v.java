package tlydtdl.lifecycle;

import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public static x a(y yVar) {
        o.h(yVar, "state");
        int i = u.$EnumSwitchMapping$0[yVar.ordinal()];
        if (i == 1) {
            return x.ON_DESTROY;
        }
        if (i == 2) {
            return x.ON_STOP;
        }
        if (i != 3) {
            return null;
        }
        return x.ON_PAUSE;
    }

    public static x b(y yVar) {
        o.h(yVar, "state");
        int i = u.$EnumSwitchMapping$0[yVar.ordinal()];
        if (i == 1) {
            return x.ON_START;
        }
        if (i == 2) {
            return x.ON_RESUME;
        }
        if (i != 5) {
            return null;
        }
        return x.ON_CREATE;
    }

    public static x c(y yVar) {
        o.h(yVar, "state");
        int i = u.$EnumSwitchMapping$0[yVar.ordinal()];
        if (i == 1) {
            return x.ON_CREATE;
        }
        if (i == 2) {
            return x.ON_START;
        }
        if (i != 3) {
            return null;
        }
        return x.ON_RESUME;
    }
}
