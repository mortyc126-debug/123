package tw0;

import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import sw0.c;
import sw0.d;
import sw0.e;
import sw0.f;
import sw0.g;
import sw0.h;
import sw0.i;
import sw0.j;
import t3.m;
import t3.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    default p c(Object obj) {
        return m.a;
    }

    default p h(p pVar, Object obj, h hVar) {
        o.h(pVar, "<this>");
        return un0.m.s0(pVar);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    default p i(Object obj, j jVar) throws NoWhenBranchMatchedException {
        if (jVar instanceof c) {
            return m(c(obj), obj, (c) jVar);
        }
        if (jVar instanceof g) {
            p pVarC = c(obj);
            o.h(pVarC, "<this>");
            return pVarC;
        }
        if (jVar instanceof f) {
            p pVarC2 = c(obj);
            o.h(pVarC2, "<this>");
            return pVarC2;
        }
        if (jVar instanceof h) {
            return h(c(obj), obj, (h) jVar);
        }
        if (jVar instanceof d) {
            p pVarC3 = c(obj);
            boolean zC = ((d) jVar).c();
            o.h(pVarC3, "$this$emptyModifier");
            return s(pVarC3, obj, d.b(zC));
        }
        if (!(jVar instanceof e)) {
            throw new NoWhenBranchMatchedException();
        }
        p pVarC4 = c(obj);
        o.h(pVarC4, "<this>");
        return s(pVarC4, obj, (e) jVar);
    }

    default p m(p pVar, Object obj, c cVar) {
        o.h(pVar, "<this>");
        return pVar;
    }

    default p s(p pVar, Object obj, i iVar) {
        return pVar;
    }
}
