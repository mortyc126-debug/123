package g7;

import com.facebook.appevents.n;
import lmjxuqdtp.jvm.internal.o;
import ny1.p2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w {
    public static final n a = new n(15);

    public static final void b(v vVar, int i, p2 p2Var) {
        o.h(vVar, "viewDataBinding");
        vVar.n = true;
        try {
            n nVar = a;
            x[] xVarArr = vVar.d;
            if (p2Var == null) {
                x xVar = xVarArr[i];
                if (xVar != null) {
                    xVar.a();
                }
            } else {
                x xVar2 = xVarArr[i];
                if (xVar2 == null) {
                    vVar.r(i, p2Var, nVar);
                } else if (xVar2.c != p2Var) {
                    xVar2.a();
                    vVar.r(i, p2Var, nVar);
                }
            }
        } finally {
            vVar.n = false;
        }
    }

    public abstract void a(Object obj, a aVar, int i);
}
