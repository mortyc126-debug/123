package gp;

import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import com.bandlab.auth.screens.JoinBandlabActivity;
import com.bandlab.auth.screens.JoinBandlabActivityGraph$$;
import com.bandlab.bandlab.AppGraph$$;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import qo.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements q00.b {
    public static final x a = new x();

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public static Intent b(x xVar, Context context, vi.f fVar, qo.i iVar, String str, int i) throws NoWhenBranchMatchedException {
        o0 i0Var;
        if ((i & 4) != 0) {
            iVar = null;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        xVar.getClass();
        o.h(fVar, "screen");
        Intent intent = new Intent(context, JoinBandlabActivity.class);
        int iOrdinal = fVar.ordinal();
        if (iOrdinal == 0) {
            i0Var = m0.INSTANCE;
        } else if (iOrdinal == 1) {
            i0Var = new i0(str);
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i0Var = n0.INSTANCE;
        }
        di0.z.M(intent, new m(new i(i0Var), iVar instanceof d, iVar == null), m.Companion.serializer());
        return intent;
    }

    public Object a(Object obj, Object obj2) {
        JoinBandlabActivity joinBandlabActivity = (JoinBandlabActivity) obj;
        AppGraph$$.MetroGraph metroGraph = (AppGraph$$.MetroGraph) obj2;
        o.h(joinBandlabActivity, "root");
        o.h(metroGraph, "serviceProvider");
        return new JoinBandlabActivityGraph$$.MetroGraph(joinBandlabActivity, metroGraph);
    }
}
