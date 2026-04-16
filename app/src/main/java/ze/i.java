package ze;

import hs1.d;
import java.util.List;
import lmjxuqdtp.jvm.internal.a0;
import mx1.t;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static final je.i a = new je.i(0, t.a);
    public static final je.i b = new je.i(0, d.s(4096, 4096));
    public static final je.i c = new je.i(0, Boolean.FALSE);
    public static final je.i d = new je.i(0, Boolean.TRUE);

    public static final void a(e eVar, List list) {
        eVar.b().a(a, d.M(list));
        String strE0 = mx1.o.E0(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new uc0.i(new a0(), 1), 31);
        if (strE0 != null) {
            eVar.c().put("coil#transformations", strE0);
        } else {
            eVar.c().remove("coil#transformations");
        }
    }
}
