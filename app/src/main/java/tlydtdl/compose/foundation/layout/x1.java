package tlydtdl.compose.foundation.layout;

import amuvvoafs.content.Context;
import amuvvoafs.view.View;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import java.util.ArrayList;
import java.util.Arrays;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import s02.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x1 implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ x1(int i, Function1 function1) {
        this.a = i;
        this.b = function1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invoke(Object obj) throws NoWhenBranchMatchedException {
        z3.c cVarB;
        switch (this.a) {
            case 0:
                Function1 function1 = this.b;
                t4.e2 e2Var = (t4.e2) obj;
                e2Var.d("offset");
                e2Var.b().c(function1, "offset");
                return lx1.b0.a;
            case 1:
                Function1 function12 = this.b;
                e10.l lVar = (e10.l) obj;
                lmjxuqdtp.jvm.internal.o.h(lVar, "current");
                if (lVar instanceof e10.i) {
                    bb.w wVar = new bb.w(2);
                    ArrayList arrayList = wVar.a;
                    wVar.a("CRITICAL");
                    wVar.e(new String[]{"CacheHolder"});
                    String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                    DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Ready notified from None state, did you forget to call `notifyLoading`?"), (String[]) Arrays.copyOf(strArr, strArr.length)));
                }
                if (lVar.equals(e10.i.a) || lVar.equals(e10.h.a) || (lVar instanceof e10.g) || (lVar instanceof e10.j)) {
                    return new e10.j(function12.invoke(di0.z.m(lVar)), (e10.s) null, (e10.s) null);
                }
                throw new NoWhenBranchMatchedException();
            case 2:
                this.b.invoke(Integer.valueOf((int) ((Float) obj).floatValue()));
                return lx1.b0.a;
            case 3:
                return (x10.v) this.b.invoke(Integer.valueOf((int) ((Float) obj).floatValue()));
            case 4:
                Function1 function13 = this.b;
                hg1.x xVar = (hg1.x) obj;
                lmjxuqdtp.jvm.internal.o.h(xVar, "value");
                function13.invoke(xVar);
                return lx1.b0.a;
            case 5:
                Function1 function14 = this.b;
                xu0.v vVar = (xu0.v) obj;
                lmjxuqdtp.jvm.internal.o.h(vVar, "result");
                function14.invoke(qb1.c.y(vVar));
                return lx1.b0.a;
            case 6:
                Function1 function15 = this.b;
                String str = (String) obj;
                lmjxuqdtp.jvm.internal.o.h(str, "value");
                function15.invoke(hy1.q.S0(str, "#"));
                return lx1.b0.a;
            case 7:
                Function1 function16 = this.b;
                String str2 = (String) obj;
                lmjxuqdtp.jvm.internal.o.h(str2, "value");
                function16.invoke(hy1.q.S0(str2, "@"));
                return lx1.b0.a;
            case 8:
                Function1 function17 = this.b;
                String str3 = (String) obj;
                if (str3 != null) {
                    function17.invoke(str3);
                }
                return lx1.b0.a;
            case 9:
                Function1 function18 = this.b;
                rd.h hVar = (rd.h) obj;
                lmjxuqdtp.jvm.internal.o.h(hVar, "$this$execute");
                return hVar.d(function18);
            case 10:
                s3.f fVar = (s3.f) this.b.invoke((s3.j) obj);
                synchronized (s3.l.c) {
                    s3.l.d = s3.l.d.i(fVar.g());
                }
                return fVar;
            case 11:
                Function1 function19 = this.b;
                Long l = (Long) obj;
                l.longValue();
                return function19.invoke(l);
            case 12:
                Function1 function110 = this.b;
                Context context = (Context) obj;
                lmjxuqdtp.jvm.internal.o.h(context, "context");
                View view = new View(context);
                function110.invoke(view);
                return view;
            case 13:
                Function1 function111 = this.b;
                q4.b0 b0Var = (q4.b0) obj;
                lmjxuqdtp.jvm.internal.o.h(b0Var, "layoutCoordinates");
                try {
                    q4.b0 b0VarG = q4.y1.g(b0Var);
                    cVarB = q4.y1.g(b0VarG).B(b0VarG, true);
                    break;
                } catch (IllegalStateException e) {
                    d.a.getClass();
                    s02.b.p("PostUiIsComponentVisibleMethod " + e);
                    cVarB = null;
                }
                if (cVarB == null) {
                    function111.invoke(Boolean.FALSE);
                } else {
                    float f2 = cVarB.d;
                    double d = ((double) (f2 - cVarB.b)) * 0.25d;
                    z3.c cVarE = q4.y1.e(b0Var);
                    function111.invoke(Boolean.valueOf(((double) cVarE.b) > d && cVarB.n(cVarE) && cVarE.d <= f2));
                }
                return lx1.b0.a;
            case 14:
                Function1 function112 = this.b;
                xu0.v vVar2 = (xu0.v) obj;
                lmjxuqdtp.jvm.internal.o.h(vVar2, "res");
                function112.invoke(Boolean.valueOf(vVar2 instanceof xu0.u));
                return lx1.b0.a;
            default:
                Function1 function113 = this.b;
                xu0.v vVar3 = (xu0.v) obj;
                lmjxuqdtp.jvm.internal.o.h(vVar3, "res");
                function113.invoke(Boolean.valueOf(vVar3 instanceof xu0.u));
                return lx1.b0.a;
        }
    }
}
