package gp;

import amuvvoafs.content.Context;
import com.bandlab.auth.screens.JoinBandlabActivityGraph$$;
import com.bandlab.bandlab.AppGraph$$;
import dp.a;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.d;
import or.b0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements iw1.b {
    public final /* synthetic */ int a;
    public final /* synthetic */ JoinBandlabActivityGraph$$.MetroGraph b;

    public /* synthetic */ v(JoinBandlabActivityGraph$$.MetroGraph metroGraph, int i) {
        this.a = i;
        this.b = metroGraph;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return this.b.b.p();
            case 1:
                return (ro.h) this.b.b.R0.invoke();
            case 2:
                jw1.f fVar = this.b.b.a;
                o.h(fVar, "context");
                Context context = (Context) fVar.a;
                o.h(context, "context");
                return new zo.f(context);
            case 3:
                return this.b.b.U0();
            case 4:
                return (po.g) this.b.b.g1.invoke();
            case 5:
                return (b0) this.b.b.H3.invoke();
            case 6:
                return this.b.b.o1();
            case 7:
                return this.b.b.n1();
            case 8:
                this.b.b.O1.getClass();
                return "market://details?id=com.bandlab.bandlab";
            case 9:
                o.h((AppGraph$$.MetroGraph) this.b.b.b.a, "instance");
                return Boolean.FALSE;
            case 10:
                return Long.valueOf(((Number) this.b.b.l0.invoke()).longValue());
            case 11:
                return this.b.b.s0();
            case 12:
                return this.b.b.z0();
            case 13:
                return this.b.b.C();
            case 14:
                return (lo.i) this.b.b.h1.invoke();
            case 15:
                return this.b.b.o();
            case 16:
                return this.b.b.f1();
            case 17:
                return this.b.b.v();
            case 18:
                this.b.b.getClass();
                return bj.b.a;
            case 19:
                jw1.f fVar2 = this.b.b.a;
                o.h(fVar2, "context");
                Context context2 = (Context) fVar2.a;
                o.h(context2, "context");
                return new a(context2);
            case 20:
                this.b.b.R2.invoke();
                return y10.g.a;
            case 21:
                return (d01.k) this.b.b.A.invoke();
            case 22:
                this.b.b.t();
                return d.a;
            case 23:
                jw1.f fVar3 = this.b.b.a;
                o.h(fVar3, "context");
                Context context3 = (Context) fVar3.a;
                o.h(context3, "context");
                String string = context3.getString(2132019875);
                o.g(string, "getString(...)");
                return string;
            case 24:
                return this.b.b.y0();
            case 25:
                return (qo.a) this.b.b.x.invoke();
            case 26:
                jw1.f fVar4 = this.b.b.a;
                o.h(fVar4, "context");
                o.h((Context) fVar4.a, "context");
                return new aw0.e();
            case 27:
                jw1.f fVar5 = this.b.b.a;
                o.h(fVar5, "context");
                Context context4 = (Context) fVar5.a;
                o.h(context4, "context");
                String string2 = context4.getString(2132018495);
                o.g(string2, "getString(...)");
                return string2;
            case 28:
                return this.b.b.l1();
            default:
                return this.b.b.n();
        }
    }
}
