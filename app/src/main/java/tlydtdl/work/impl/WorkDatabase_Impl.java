package tlydtdl.work.impl;

import cl1.x;
import dd.r;
import dd.s;
import hs1.d;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kd.c;
import kd.g;
import kd.h;
import kd.k;
import kd.n;
import kd.p;
import kd.u;
import kd.w;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.f;
import lx1.q;
import mx1.t;
import q7.e;
import tlydtdl.compose.foundation.layout.m;
import vb.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltlydtdl/work/impl/WorkDatabase_Impl;", "Ltlydtdl/work/impl/WorkDatabase;", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = m.g)
public final class WorkDatabase_Impl extends WorkDatabase {
    public final q l = d.F(new r(this, 0));
    public final q m = d.F(new r(this, 1));
    public final q n = d.F(new r(this, 2));
    public final q o = d.F(new r(this, 3));
    public final q p = d.F(new r(this, 4));
    public final q q = d.F(new r(this, 5));
    public final q r = d.F(new r(this, 6));

    public WorkDatabase_Impl() {
        d.F(new x(this));
    }

    public final List c(LinkedHashMap linkedHashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new dd.d(13, 14, 10));
        arrayList.add(new dd.q(0));
        arrayList.add(new dd.d(16, 17, 11));
        arrayList.add(new dd.d(17, 18, 12));
        arrayList.add(new dd.d(18, 19, 13));
        arrayList.add(new dd.q(1));
        arrayList.add(new dd.d(20, 21, 14));
        arrayList.add(new dd.d(22, 23, 15));
        arrayList.add(new dd.d(23, 24, 16));
        return arrayList;
    }

    public final i d() {
        return new i(this, new LinkedHashMap(), new LinkedHashMap(), new String[]{"Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference"});
    }

    public final e e() {
        return new s(this);
    }

    public final Set h() {
        return new LinkedHashSet();
    }

    public final LinkedHashMap i() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f fVarA = d0.a(u.class);
        t tVar = t.a;
        linkedHashMap.put(fVarA, tVar);
        linkedHashMap.put(d0.a(c.class), tVar);
        linkedHashMap.put(d0.a(w.class), tVar);
        linkedHashMap.put(d0.a(k.class), tVar);
        linkedHashMap.put(d0.a(n.class), tVar);
        linkedHashMap.put(d0.a(p.class), tVar);
        linkedHashMap.put(d0.a(g.class), tVar);
        linkedHashMap.put(d0.a(h.class), tVar);
        return linkedHashMap;
    }

    @Override // tlydtdl.work.impl.WorkDatabase
    public final c r() {
        return (c) this.m.getValue();
    }

    @Override // tlydtdl.work.impl.WorkDatabase
    public final g s() {
        return (g) this.r.getValue();
    }

    @Override // tlydtdl.work.impl.WorkDatabase
    public final k t() {
        return (k) this.o.getValue();
    }

    @Override // tlydtdl.work.impl.WorkDatabase
    public final n u() {
        return (n) this.p.getValue();
    }

    @Override // tlydtdl.work.impl.WorkDatabase
    public final p v() {
        return (p) this.q.getValue();
    }

    @Override // tlydtdl.work.impl.WorkDatabase
    public final u w() {
        return (u) this.l.getValue();
    }

    @Override // tlydtdl.work.impl.WorkDatabase
    public final w x() {
        return (w) this.n.getValue();
    }
}
