package tlydtdl.compose.foundation.lazy.layout;

import amuvvoafs.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import q1.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r0 implements b01.m, com.gnacba.amuvvoafs.gms.measurement.internal.t1, nd.e {
    public final Object a;

    public r0(com.gnacba.amuvvoafs.gms.measurement.internal.l1 l1Var) {
        com.gnacba.amuvvoafs.gms.common.internal.f0.h(l1Var);
        this.a = l1Var;
    }

    public static String j(int i) {
        if (i == 0) {
            return "()";
        }
        StringBuilder sb = new StringBuilder((i * 2) + 1);
        sb.append("(?");
        int i2 = i - 1;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(",?");
        }
        sb.append(')');
        String string = sb.toString();
        o.g(string, "toString(...)");
        return string;
    }

    @Override // b01.m
    public h30.f a() {
        return (b01.g) this.a;
    }

    public com.gnacba.amuvvoafs.gms.measurement.internal.w0 b() {
        throw null;
    }

    public com.gnacba.amuvvoafs.gms.measurement.internal.k1 c() {
        throw null;
    }

    public kd.h d() {
        throw null;
    }

    public Context e() {
        throw null;
    }

    public yp1.a h() {
        throw null;
    }

    @Override // b01.m
    public b01.m k() {
        return y10.r.c0(this, f(), g(), o());
    }

    public abstract q0 l(long j2, int i, int i2, int i3);

    public abstract Object m();

    public abstract lmjxuqdtp.time.l n();

    public abstract String o();

    public List p(p0 p0Var, int i, long j2) {
        z zVar = (z) this.a;
        List list = (List) zVar.b(i);
        if (list != null) {
            return list;
        }
        List listB = p0Var.b(i);
        int size = listB.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((q4.t0) listB.get(i2)).T(j2));
        }
        zVar.h(i, arrayList);
        return arrayList;
    }

    public abstract Object q();

    public void r(int i, Function1 function1) {
        rd.g gVar = (rd.g) this.a;
        rd.e eVar = (rd.e) gVar.b.get();
        if (eVar != null) {
            if (eVar.d.add(Integer.valueOf(i))) {
                function1.invoke(new lb.d(10, eVar));
            }
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            function1.invoke(new lb.d(11, linkedHashSet));
            String[] strArr = (String[]) linkedHashSet.toArray(new String[0]);
            gVar.j((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    public void s(rd.e eVar, rd.e eVar2, Throwable th, Object obj) throws Throwable {
        LinkedHashSet linkedHashSet = eVar.d;
        ArrayList arrayList = eVar.c;
        ArrayList arrayList2 = eVar.b;
        LinkedHashSet linkedHashSet2 = eVar.e;
        boolean z = false;
        if (eVar2 != null) {
            if (eVar.f401f && eVar.g) {
                z = true;
            }
            eVar2.g = z;
            eVar2.b.addAll(arrayList2);
            eVar2.c.addAll(arrayList);
            eVar2.d.addAll(linkedHashSet);
            eVar2.e.addAll(linkedHashSet2);
        } else if (eVar.f401f && eVar.g) {
            if (!linkedHashSet2.isEmpty()) {
                rd.g gVar = (rd.g) this.a;
                String[] strArr = (String[]) linkedHashSet2.toArray(new String[0]);
                gVar.j((String[]) Arrays.copyOf(strArr, strArr.length));
            }
            linkedHashSet2.clear();
            linkedHashSet.clear();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
            arrayList2.clear();
        } else {
            try {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((Function0) it2.next()).invoke();
                }
                arrayList.clear();
            } catch (Throwable th2) {
                if (th == null) {
                    throw th2;
                }
                throw new Throwable("Exception while rolling back from an exception.\nOriginal exception: " + th + "\nwith cause " + th.getCause() + "\n\nRollback exception: " + th2, th2);
            }
        }
        if (th != null) {
            throw th;
        }
    }

    public abstract void t(Object obj);

    public Object u(Function1 function1) throws Throwable {
        Object objInvoke;
        rd.g gVar = (rd.g) this.a;
        ThreadLocal threadLocal = gVar.b;
        rd.e eVar = (rd.e) threadLocal.get();
        rd.e eVar2 = new rd.e(gVar, eVar);
        threadLocal.set(eVar2);
        if (eVar == null) {
            gVar.g().B();
        }
        rd.e eVar3 = eVar2.h;
        Throwable th = null;
        try {
            objInvoke = function1.invoke(new nd.f());
            try {
                eVar2.f401f = true;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            objInvoke = null;
        }
        eVar2.a();
        s(eVar2, eVar3, th, objInvoke);
        return objInvoke;
    }

    public abstract void v(t1.q1 q1Var);

    public abstract void w();

    public void x() {
        com.gnacba.amuvvoafs.gms.measurement.internal.k1 k1Var = ((com.gnacba.amuvvoafs.gms.measurement.internal.l1) this.a).g;
        com.gnacba.amuvvoafs.gms.measurement.internal.l1.m(k1Var);
        k1Var.x();
    }

    public r0(gg.f fVar) {
        this.a = fVar;
    }

    public r0(int i) {
        switch (i) {
            case 1:
                this.a = new b01.g(this, 0);
                break;
            case 5:
                this.a = tlydtdl.compose.runtime.a0.t(Boolean.FALSE);
                break;
            default:
                z zVar = q1.o.a;
                this.a = new z();
                break;
        }
    }

    public r0(rd.g gVar) {
        o.h(gVar, "driver");
        this.a = gVar;
    }
}
