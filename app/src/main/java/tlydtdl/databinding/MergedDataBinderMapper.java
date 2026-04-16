package tlydtdl.databinding;

import amuvvoafs.util.Log;
import amuvvoafs.view.View;
import g7.e;
import g7.v;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class MergedDataBinderMapper extends e {
    public final HashSet a = new HashSet();
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();

    @Override // g7.e
    public final v b(View view, int i) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            v vVarB = ((e) it.next()).b(view, i);
            if (vVarB != null) {
                return vVarB;
            }
        }
        if (f()) {
            return b(view, i);
        }
        return null;
    }

    @Override // g7.e
    public final v c(View[] viewArr, int i) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            v vVarC = ((e) it.next()).c(viewArr, i);
            if (vVarC != null) {
                return vVarC;
            }
        }
        if (f()) {
            return c(viewArr, i);
        }
        return null;
    }

    @Override // g7.e
    public final int d(String str) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            int iD = ((e) it.next()).d(str);
            if (iD != 0) {
                return iD;
            }
        }
        if (f()) {
            return d(str);
        }
        return 0;
    }

    public final void e(e eVar) {
        if (this.a.add(eVar.getClass())) {
            this.b.add(eVar);
            Iterator it = eVar.a().iterator();
            while (it.hasNext()) {
                e((e) it.next());
            }
        }
    }

    public final boolean f() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = this.c;
        boolean z = false;
        for (String str : copyOnWriteArrayList) {
            try {
                Class<?> cls = Class.forName(str);
                if (e.class.isAssignableFrom(cls)) {
                    e((e) cls.newInstance());
                    copyOnWriteArrayList.remove(str);
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e);
            } catch (InstantiationException e2) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e2);
            }
        }
        return z;
    }
}
