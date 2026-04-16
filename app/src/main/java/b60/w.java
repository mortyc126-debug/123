package b60;

import ky1.a0;
import ky1.b0;
import ky1.c0;
import lmjxuqdtp.jvm.functions.Function0;
import qx1.d;
import r3.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements Function0 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f22f;
    public final /* synthetic */ Object g;

    public /* synthetic */ w(a0 a0Var, qi.y yVar, h hVar, z zVar, String str, e eVar) {
        this.c = a0Var;
        this.d = yVar;
        this.e = hVar;
        this.f22f = zVar;
        this.b = str;
        this.g = eVar;
    }

    public final Object invoke() {
        boolean z;
        switch (this.a) {
            case 0:
                c0.F((a0) this.c, (qx1.i) null, (b0) null, new a2.l((qi.y) this.d, (h) this.e, (z) this.f22f, this.b, (e) this.g, (d) null, 7), 3);
                break;
            default:
                r3.b bVar = (r3.b) this.c;
                r3.k kVar = (r3.k) this.d;
                g gVar = (g) this.e;
                Object[] objArr = (Object[]) this.g;
                boolean z2 = true;
                if (bVar.b != gVar) {
                    bVar.b = gVar;
                    z = true;
                } else {
                    z = false;
                }
                String str = bVar.c;
                String str2 = this.b;
                if (lmjxuqdtp.jvm.internal.o.c(str, str2)) {
                    z2 = z;
                } else {
                    bVar.c = str2;
                }
                bVar.a = kVar;
                bVar.d = this.f22f;
                bVar.e = objArr;
                qu0.u uVar = bVar.f;
                if (uVar != null && z2) {
                    uVar.J();
                    bVar.f = null;
                    bVar.a();
                }
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ w(r3.b bVar, r3.k kVar, g gVar, String str, Object obj, Object[] objArr) {
        this.c = bVar;
        this.d = kVar;
        this.e = gVar;
        this.b = str;
        this.f22f = obj;
        this.g = objArr;
    }
}
