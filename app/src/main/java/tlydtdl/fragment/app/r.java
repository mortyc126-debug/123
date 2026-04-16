package tlydtdl.fragment.app;

import amuvvoafs.util.Log;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.WeakHashMap;
import lmjxuqdtp.jvm.internal.o;
import o6.c;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r {
    public final ViewGroup a;
    public final ArrayList b;
    public final ArrayList c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f590f;

    public r(ViewGroup viewGroup) {
        o.h(viewGroup, "container");
        this.a = viewGroup;
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public static void f(q1.f fVar, View view) {
        WeakHashMap weakHashMap = r6.u0.a;
        String strF = r6.l0.f(view);
        if (strF != null) {
            fVar.put(strF, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    f(fVar, childAt);
                }
            }
        }
    }

    public static final r j(ViewGroup viewGroup, k1 k1Var) {
        o.h(viewGroup, "container");
        o.h(k1Var, "fragmentManager");
        o.g(k1Var.L(), "fragmentManager.specialEffectsControllerFactory");
        Object tag = viewGroup.getTag(2131428517);
        if (tag instanceof r) {
            return (r) tag;
        }
        r rVar = new r(viewGroup);
        viewGroup.setTag(2131428517, rVar);
        return rVar;
    }

    public static boolean k(ArrayList arrayList) {
        boolean z;
        Iterator it = arrayList.iterator();
        loop0: while (true) {
            z = true;
            while (it.hasNext()) {
                j2 j2Var = (j2) it.next();
                if (!j2Var.k.isEmpty()) {
                    ArrayList arrayList2 = j2Var.k;
                    if (arrayList2 == null || !arrayList2.isEmpty()) {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            if (!((i2) it2.next()).b()) {
                                break;
                            }
                        }
                    }
                }
                z = false;
            }
            break loop0;
        }
        if (z) {
            ArrayList arrayList3 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                mx1.o.i0(arrayList3, ((j2) it3.next()).k);
            }
            if (!arrayList3.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final void a(j2 j2Var) {
        o.h(j2Var, "operation");
        if (j2Var.i) {
            int i = j2Var.a;
            View viewRequireView = j2Var.c.requireView();
            o.g(viewRequireView, "operation.fragment.requireView()");
            i.a(i, viewRequireView, this.a);
            j2Var.i = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x0436 A[LOOP:7: B:147:0x0430->B:149:0x0436, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.util.ArrayList r27, boolean r28) {
        /*
            Method dump skipped, instruction units count: 1297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.fragment.app.r.b(java.util.ArrayList, boolean):void");
    }

    public final void c(List list) {
        ArrayList arrayListS = i.s("operations", list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            mx1.o.i0(arrayListS, ((j2) it.next()).k);
        }
        List listM1 = mx1.o.m1(mx1.o.r1(arrayListS));
        int size = listM1.size();
        for (int i = 0; i < size; i++) {
            ((i2) listM1.get(i)).d(this.a);
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            a((j2) list.get(i2));
        }
        List listM12 = mx1.o.m1(list);
        int size3 = listM12.size();
        for (int i3 = 0; i3 < size3; i3++) {
            j2 j2Var = (j2) listM12.get(i3);
            if (j2Var.k.isEmpty()) {
                j2Var.b();
            }
        }
    }

    public final void d(int i, int i2, t1 t1Var) {
        synchronized (this.b) {
            try {
                k0 k0Var = t1Var.c;
                o.g(k0Var, "fragmentStateManager.fragment");
                j2 j2VarG = g(k0Var);
                if (j2VarG == null) {
                    k0 k0Var2 = t1Var.c;
                    j2VarG = (k0Var2.mTransitioning || k0Var2.mRemoving) ? h(k0Var2) : null;
                }
                if (j2VarG != null) {
                    j2VarG.d(i, i2);
                    return;
                }
                j2 j2Var = new j2(i, i2, t1Var);
                this.b.add(j2Var);
                j2Var.d.add(new h2(this, j2Var, 0));
                j2Var.d.add(new h2(this, j2Var, 2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        boolean z;
        if (this.f590f) {
            return;
        }
        if (!this.a.isAttachedToWindow()) {
            i();
            this.e = false;
            return;
        }
        synchronized (this.b) {
            try {
                ArrayList<j2> arrayListO1 = mx1.o.o1(this.c);
                this.c.clear();
                Iterator it = arrayListO1.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    j2 j2Var = (j2) it.next();
                    if (this.b.isEmpty() || !j2Var.c.mTransitioning) {
                        z = false;
                    }
                    j2Var.g = z;
                }
                for (j2 j2Var2 : arrayListO1) {
                    if (this.d) {
                        if (k1.N(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Completing non-seekable operation " + j2Var2);
                        }
                        j2Var2.b();
                    } else {
                        if (k1.N(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + j2Var2);
                        }
                        j2Var2.a(this.a);
                    }
                    this.d = false;
                    if (!j2Var2.f585f) {
                        this.c.add(j2Var2);
                    }
                }
                if (!this.b.isEmpty()) {
                    n();
                    ArrayList arrayListO12 = mx1.o.o1(this.b);
                    if (arrayListO12.isEmpty()) {
                        return;
                    }
                    this.b.clear();
                    this.c.addAll(arrayListO12);
                    if (k1.N(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    b(arrayListO12, this.e);
                    boolean zK = k(arrayListO12);
                    Iterator it2 = arrayListO12.iterator();
                    boolean z2 = true;
                    while (it2.hasNext()) {
                        if (!((j2) it2.next()).c.mTransitioning) {
                            z2 = false;
                        }
                    }
                    if (!z2 || zK) {
                        z = false;
                    }
                    this.d = z;
                    if (k1.N(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Operation seekable = " + zK + " \ntransition = " + z2);
                    }
                    if (!z2) {
                        m(arrayListO12);
                        c(arrayListO12);
                    } else if (zK) {
                        m(arrayListO12);
                        int size = arrayListO12.size();
                        for (int i = 0; i < size; i++) {
                            a((j2) arrayListO12.get(i));
                        }
                    }
                    this.e = false;
                    if (k1.N(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final j2 g(k0 k0Var) {
        Object next;
        Iterator it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            j2 j2Var = (j2) next;
            if (o.c(j2Var.c, k0Var) && !j2Var.e) {
                break;
            }
        }
        return (j2) next;
    }

    public final j2 h(k0 k0Var) {
        Object next;
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            j2 j2Var = (j2) next;
            if (o.c(j2Var.c, k0Var) && !j2Var.e) {
                break;
            }
        }
        return (j2) next;
    }

    public final void i() {
        if (k1.N(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.a.isAttachedToWindow();
        synchronized (this.b) {
            try {
                n();
                m(this.b);
                ArrayList<j2> arrayListO1 = mx1.o.o1(this.c);
                Iterator it = arrayListO1.iterator();
                while (it.hasNext()) {
                    ((j2) it.next()).g = false;
                }
                for (j2 j2Var : arrayListO1) {
                    if (k1.N(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? HttpUrl.FRAGMENT_ENCODE_SET : "Container " + this.a + " is not attached to window. ") + "Cancelling running operation " + j2Var);
                    }
                    j2Var.a(this.a);
                }
                ArrayList<j2> arrayListO12 = mx1.o.o1(this.b);
                Iterator it2 = arrayListO12.iterator();
                while (it2.hasNext()) {
                    ((j2) it2.next()).g = false;
                }
                for (j2 j2Var2 : arrayListO12) {
                    if (k1.N(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? HttpUrl.FRAGMENT_ENCODE_SET : "Container " + this.a + " is not attached to window. ") + "Cancelling pending operation " + j2Var2);
                    }
                    j2Var2.a(this.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l() {
        Object objPrevious;
        synchronized (this.b) {
            try {
                n();
                ArrayList arrayList = this.b;
                ListIterator listIterator = arrayList.listIterator(arrayList.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    j2 j2Var = (j2) objPrevious;
                    View view = j2Var.c.mView;
                    o.g(view, "operation.fragment.mView");
                    char c = 4;
                    if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                        int visibility = view.getVisibility();
                        if (visibility == 0) {
                            c = 2;
                        } else if (visibility != 4) {
                            if (visibility != 8) {
                                throw new IllegalArgumentException("Unknown visibility " + visibility);
                            }
                            c = 3;
                        }
                    }
                    if (j2Var.a == 2 && c != 2) {
                        break;
                    }
                }
                j2 j2Var2 = (j2) objPrevious;
                k0 k0Var = j2Var2 != null ? j2Var2.c : null;
                this.f590f = k0Var != null ? k0Var.isPostponed() : false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            j2 j2Var = (j2) list.get(i);
            t1 t1Var = j2Var.l;
            if (!j2Var.h) {
                j2Var.h = true;
                int i2 = j2Var.b;
                if (i2 == 2) {
                    k0 k0Var = t1Var.c;
                    o.g(k0Var, "fragmentStateManager.fragment");
                    View viewFindFocus = k0Var.mView.findFocus();
                    if (viewFindFocus != null) {
                        k0Var.setFocusedView(viewFindFocus);
                        if (k1.N(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + k0Var);
                        }
                    }
                    View viewRequireView = j2Var.c.requireView();
                    o.g(viewRequireView, "this.fragment.requireView()");
                    if (viewRequireView.getParent() == null) {
                        if (k1.N(2)) {
                            Log.v("FragmentManager", "Adding fragment " + k0Var + " view " + viewRequireView + " to container in onStart");
                        }
                        t1Var.b();
                        viewRequireView.setAlpha(0.0f);
                    }
                    if (viewRequireView.getAlpha() == 0.0f && viewRequireView.getVisibility() == 0) {
                        if (k1.N(2)) {
                            Log.v("FragmentManager", "Making view " + viewRequireView + " INVISIBLE in onStart");
                        }
                        viewRequireView.setVisibility(4);
                    }
                    viewRequireView.setAlpha(k0Var.getPostOnViewCreatedAlpha());
                    if (k1.N(2)) {
                        Log.v("FragmentManager", "Setting view alpha to " + k0Var.getPostOnViewCreatedAlpha() + " in onStart");
                    }
                } else if (i2 == 3) {
                    k0 k0Var2 = t1Var.c;
                    o.g(k0Var2, "fragmentStateManager.fragment");
                    View viewRequireView2 = k0Var2.requireView();
                    o.g(viewRequireView2, "fragment.requireView()");
                    if (k1.N(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewRequireView2.findFocus() + " on view " + viewRequireView2 + " for Fragment " + k0Var2);
                    }
                    viewRequireView2.clearFocus();
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            mx1.o.i0(arrayList, ((j2) it.next()).k);
        }
        List listM1 = mx1.o.m1(mx1.o.r1(arrayList));
        int size2 = listM1.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ((i2) listM1.get(i3)).g(this.a);
        }
    }

    public final void n() {
        for (j2 j2Var : this.b) {
            int i = 2;
            if (j2Var.b == 2) {
                View viewRequireView = j2Var.c.requireView();
                o.g(viewRequireView, "fragment.requireView()");
                int visibility = viewRequireView.getVisibility();
                if (visibility != 0) {
                    i = 4;
                    if (visibility != 4) {
                        if (visibility != 8) {
                            throw new IllegalArgumentException(c.k(visibility, "Unknown visibility "));
                        }
                        i = 3;
                    }
                }
                j2Var.d(i, 1);
            }
        }
    }
}
