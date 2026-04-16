package i30;

import amuvvoafs.app.Application;
import com.braze.vmsrhfaqrb.cards.Card;
import d10.j;
import hy1.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.NoWhenBranchMatchedException;
import mx1.o;
import mx1.t;
import ny1.b2;
import ny1.j2;
import ny1.l;
import ny1.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final Application a;
    public final tlydtdl.compose.foundation.lazy.layout.a b = new tlydtdl.compose.foundation.lazy.layout.a(4);
    public final tlydtdl.compose.foundation.lazy.layout.a c = new tlydtdl.compose.foundation.lazy.layout.a(this);
    public final tlydtdl.compose.foundation.lazy.layout.a d = new tlydtdl.compose.foundation.lazy.layout.a(6);
    public final b2 e;

    public e(Application application, y10.a aVar) {
        this.a = application;
        this.e = z.R(z.u(z.i(new i2.d(this, (qx1.d) null, 1))), aVar, j2.a, t.a);
    }

    public static int a(Card card) {
        Integer numV0;
        String str = (String) card.getExtras().get("card_order");
        return (str == null || (numV0 = x.v0(str)) == null) ? IntCompanionObject.MAX_VALUE : numV0.intValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public static List c(List list, f... fVarArr) throws NoWhenBranchMatchedException {
        String str;
        if (fVarArr.length == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList(fVarArr.length);
        for (f fVar : fVarArr) {
            int i = a.$EnumSwitchMapping$0[fVar.ordinal()];
            if (i == 1) {
                str = "notification tab";
            } else if (i == 2) {
                str = "member tab";
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "following_feed";
            }
            arrayList.add(str);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (o.m0(arrayList, ((Card) obj).getExtras().get("placement"))) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final l b(f... fVarArr) {
        f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, fVarArr.length);
        lmjxuqdtp.jvm.internal.o.h(fVarArr2, "filters");
        return z.h(z.u(new cs0.t(4, new j(this.e, this, fVarArr2, 7))), 1, my1.c.b);
    }
}
