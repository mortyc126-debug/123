package v80;

import bh.j;
import com.bandlab.bandlab.utils.debug.TaggedException;
import java.util.ArrayList;
import ky1.a0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.g;
import lmjxuqdtp.time.i;
import lmjxuqdtp.time.n;
import qu0.u;
import u80.l;
import v1.f0;
import x30.c;
import x80.f;
import xu0.w;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements l {
    public final a0 a;
    public final Function1 b;
    public final h c;

    static {
        int i = g.d;
        n.s(1, i.e);
    }

    public d(a0 a0Var, u uVar, f fVar, Function1 function1) {
        o.h(a0Var, "scope");
        this.a = a0Var;
        this.b = function1;
        this.c = new h(0, c.x(z10.d.D((w) uVar.b, (String) null), (a) uVar.c, new f0(1, fVar, this)), uVar);
    }

    public final void b(u80.f fVar) {
        h hVar = this.c;
        hVar.getClass();
        try {
            ((i.d) hVar.b).a(fVar);
        } catch (Exception e) {
            bb.w wVar = new bb.w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[]{"FilePicker"});
            j.w("Failed to launch system picker", new TaggedException(e, (String[]) arrayList.toArray(new String[arrayList.size()])));
            ((rs0.f) ((u) hVar.c).d).invoke();
        }
    }
}
