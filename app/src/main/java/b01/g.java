package b01;

import h30.d;
import hy1.x;
import tlydtdl.compose.foundation.lazy.layout.r0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements d {
    public final /* synthetic */ int a;
    public final /* synthetic */ m b;

    public /* synthetic */ g(m mVar, int i) {
        this.a = i;
        this.b = mVar;
    }

    public final Object a(Object obj) {
        lmjxuqdtp.time.l lVarA;
        Enum enumM;
        int i = this.a;
        m mVar = this.b;
        switch (i) {
            case 0:
                String str = (String) obj;
                if (str == null || hy1.q.L0(str)) {
                    return null;
                }
                try {
                    lmjxuqdtp.time.l lVar = lmjxuqdtp.time.l.c;
                    return lmjxuqdtp.time.k.d(str);
                } catch (Exception e) {
                    s02.b bVar = s02.d.a;
                    String strConcat = "Fail to parse instant from long ".concat(str);
                    bVar.getClass();
                    s02.b.u(strConcat, e);
                    Long lW0 = x.w0(str);
                    if (lW0 == null) {
                        s02.b.s("Fail to parse instant from long ".concat(str), e);
                        lVarA = ((r0) mVar).n();
                    } else {
                        lmjxuqdtp.time.l lVar2 = lmjxuqdtp.time.l.c;
                        lVarA = lmjxuqdtp.time.k.a(lW0.longValue());
                    }
                    return lVarA;
                }
            default:
                String str2 = (String) obj;
                c cVar = (c) mVar;
                if (str2 == null || (enumM = aq1.b.m(str2, cVar.t())) == null) {
                    return null;
                }
                return enumM;
        }
    }

    public final Object b(Object obj) {
        switch (this.a) {
            case 0:
                lmjxuqdtp.time.l lVar = (lmjxuqdtp.time.l) obj;
                if (lVar != null) {
                    return lVar.toString();
                }
                return null;
            default:
                Enum r2 = (Enum) obj;
                if (r2 != null) {
                    return r2.name();
                }
                return null;
        }
    }

    public final Object e() {
        switch (this.a) {
            case 0:
                return ((r0) this.b).n();
            default:
                return null;
        }
    }

    public final String getKey() {
        switch (this.a) {
            case 0:
                return ((r0) this.b).o();
            default:
                return ((c) this.b).u();
        }
    }
}
