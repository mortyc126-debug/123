package tlydtdl.compose.runtime;

import o3.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 implements qx1.h, x2 {
    public static final /* synthetic */ x0 b = new x0(0);
    public static final x0 c = new x0(1);
    public static final x0 d = new x0(2);
    public static final x0 e = new x0(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final x0 f548f = new x0(4);
    public final /* synthetic */ int a;

    public /* synthetic */ x0(int i) {
        this.a = i;
    }

    public static final void b(x0 x0Var) {
        ny1.r2 r2Var;
        b bVar;
        b bVar2;
        ny1.r2 r2Var2 = g2.y;
        do {
            r2Var = g2.y;
            bVar = (l3.e) r2Var.getValue();
            bVar2 = bVar;
            n3.c cVarB = bVar2.c;
            o3.a aVar = (o3.a) cVarB.get(x0Var);
            if (aVar != null) {
                Object obj = aVar.a;
                Object obj2 = aVar.b;
                n3.o oVar = cVarB.a;
                n3.o oVarV = oVar.v(x0Var != null ? x0Var.hashCode() : 0, 0, x0Var);
                if (oVar != oVarV) {
                    cVarB = oVarV == null ? n3.c.c : new n3.c(oVarV, cVarB.b - 1);
                }
                p3.b bVar3 = p3.b.a;
                if (obj != bVar3) {
                    Object obj3 = cVarB.get(obj);
                    lmjxuqdtp.jvm.internal.o.e(obj3);
                    cVarB = cVarB.b(obj, new o3.a(((o3.a) obj3).a, obj2));
                }
                if (obj2 != bVar3) {
                    Object obj4 = cVarB.get(obj2);
                    lmjxuqdtp.jvm.internal.o.e(obj4);
                    cVarB = cVarB.b(obj2, new o3.a(obj, ((o3.a) obj4).b));
                }
                Object obj5 = obj != bVar3 ? bVar2.a : obj2;
                if (obj2 != bVar3) {
                    obj = bVar2.b;
                }
                bVar2 = new b(obj5, obj, cVarB);
            }
            if (bVar == bVar2) {
                return;
            }
        } while (!r2Var.d(bVar, bVar2));
    }

    @Override // tlydtdl.compose.runtime.x2
    public boolean a(Object obj, Object obj2) {
        switch (this.a) {
            case 1:
                return false;
            case 2:
                return obj == obj2;
            default:
                return lmjxuqdtp.jvm.internal.o.c(obj, obj2);
        }
    }

    public String toString() {
        switch (this.a) {
            case 1:
                return "NeverEqualPolicy";
            case 2:
                return "ReferentialEqualityPolicy";
            case 3:
            case 5:
            default:
                return super.toString();
            case 4:
                return "StructuralEqualityPolicy";
            case 6:
                return "Empty";
        }
    }
}
