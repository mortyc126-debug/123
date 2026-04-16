package tlydtdl.fragment.app;

import amuvvoafs.content.Context;
import amuvvoafs.content.ContextWrapper;
import amuvvoafs.content.res.Configuration;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Looper;
import amuvvoafs.util.Log;
import amuvvoafs.view.Menu;
import amuvvoafs.view.MenuInflater;
import amuvvoafs.view.MenuItem;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import amuvvoafs.view.ViewParent;
import cc.e;
import com.gnacba.amuvvoafs.gms.internal.ads.cy;
import com.gnacba.amuvvoafs.gms.internal.ads.vi1;
import f6.d;
import i.i;
import i.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kd.h;
import lmjxuqdtp.jvm.internal.o;
import o6.c;
import okhttp3.HttpUrl;
import r6.l;
import tlydtdl.core.app.g;
import tlydtdl.core.app.p0;
import tlydtdl.lifecycle.z;
import u7.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k1 {
    public k0 A;
    public final a1 B;
    public final h C;
    public i.h D;
    public i.h E;
    public i.h F;
    public ArrayDeque G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public ArrayList M;
    public ArrayList N;
    public ArrayList O;
    public o1 P;
    public final a0 Q;
    public boolean b;
    public ArrayList e;
    public f.a0 g;
    public final vi1 p;
    public final CopyOnWriteArrayList q;
    public final w0 r;
    public final w0 s;
    public final w0 t;
    public final w0 u;
    public final z0 v;
    public int w;
    public s0 x;
    public q0 y;
    public k0 z;
    public final ArrayList a = new ArrayList();
    public final u1 c = new u1();
    public ArrayList d = new ArrayList();

    /* JADX INFO: renamed from: f */
    public final u0 f587f = new u0(this);
    public a h = null;
    public boolean i = false;

    /* JADX INFO: renamed from: j */
    public final y0 f588j = new y0(this);
    public final AtomicInteger k = new AtomicInteger();
    public final Map l = Collections.synchronizedMap(new HashMap());
    public final Map m = Collections.synchronizedMap(new HashMap());
    public final Map n = Collections.synchronizedMap(new HashMap());
    public final ArrayList o = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v17, types: [tlydtdl.fragment.app.w0] */
    /* JADX WARN: Type inference failed for: r0v18, types: [tlydtdl.fragment.app.w0] */
    /* JADX WARN: Type inference failed for: r0v19, types: [tlydtdl.fragment.app.w0] */
    /* JADX WARN: Type inference failed for: r0v20, types: [tlydtdl.fragment.app.w0] */
    public k1() {
        vi1 vi1Var = new vi1();
        vi1Var.a = this;
        vi1Var.b = new CopyOnWriteArrayList();
        this.p = vi1Var;
        this.q = new CopyOnWriteArrayList();
        final int i = 0;
        this.r = new q6.a(this) { // from class: tlydtdl.fragment.app.w0
            public final /* synthetic */ k1 b;

            {
                this.b = this;
            }

            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        k1 k1Var = this.b;
                        if (k1Var.P()) {
                            k1Var.j(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        k1 k1Var2 = this.b;
                        if (k1Var2.P() && num.intValue() == 80) {
                            k1Var2.n(false);
                            break;
                        }
                        break;
                    case 2:
                        g gVar = (g) obj;
                        k1 k1Var3 = this.b;
                        if (k1Var3.P()) {
                            k1Var3.o(gVar.a(), false);
                        }
                        break;
                    default:
                        tlydtdl.core.app.s0 s0Var = (tlydtdl.core.app.s0) obj;
                        k1 k1Var4 = this.b;
                        if (k1Var4.P()) {
                            k1Var4.t(s0Var.a(), false);
                        }
                        break;
                }
            }
        };
        final int i2 = 1;
        this.s = new q6.a(this) { // from class: tlydtdl.fragment.app.w0
            public final /* synthetic */ k1 b;

            {
                this.b = this;
            }

            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        k1 k1Var = this.b;
                        if (k1Var.P()) {
                            k1Var.j(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        k1 k1Var2 = this.b;
                        if (k1Var2.P() && num.intValue() == 80) {
                            k1Var2.n(false);
                            break;
                        }
                        break;
                    case 2:
                        g gVar = (g) obj;
                        k1 k1Var3 = this.b;
                        if (k1Var3.P()) {
                            k1Var3.o(gVar.a(), false);
                        }
                        break;
                    default:
                        tlydtdl.core.app.s0 s0Var = (tlydtdl.core.app.s0) obj;
                        k1 k1Var4 = this.b;
                        if (k1Var4.P()) {
                            k1Var4.t(s0Var.a(), false);
                        }
                        break;
                }
            }
        };
        final int i3 = 2;
        this.t = new q6.a(this) { // from class: tlydtdl.fragment.app.w0
            public final /* synthetic */ k1 b;

            {
                this.b = this;
            }

            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        k1 k1Var = this.b;
                        if (k1Var.P()) {
                            k1Var.j(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        k1 k1Var2 = this.b;
                        if (k1Var2.P() && num.intValue() == 80) {
                            k1Var2.n(false);
                            break;
                        }
                        break;
                    case 2:
                        g gVar = (g) obj;
                        k1 k1Var3 = this.b;
                        if (k1Var3.P()) {
                            k1Var3.o(gVar.a(), false);
                        }
                        break;
                    default:
                        tlydtdl.core.app.s0 s0Var = (tlydtdl.core.app.s0) obj;
                        k1 k1Var4 = this.b;
                        if (k1Var4.P()) {
                            k1Var4.t(s0Var.a(), false);
                        }
                        break;
                }
            }
        };
        final int i4 = 3;
        this.u = new q6.a(this) { // from class: tlydtdl.fragment.app.w0
            public final /* synthetic */ k1 b;

            {
                this.b = this;
            }

            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        k1 k1Var = this.b;
                        if (k1Var.P()) {
                            k1Var.j(false, configuration);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        k1 k1Var2 = this.b;
                        if (k1Var2.P() && num.intValue() == 80) {
                            k1Var2.n(false);
                            break;
                        }
                        break;
                    case 2:
                        g gVar = (g) obj;
                        k1 k1Var3 = this.b;
                        if (k1Var3.P()) {
                            k1Var3.o(gVar.a(), false);
                        }
                        break;
                    default:
                        tlydtdl.core.app.s0 s0Var = (tlydtdl.core.app.s0) obj;
                        k1 k1Var4 = this.b;
                        if (k1Var4.P()) {
                            k1Var4.t(s0Var.a(), false);
                        }
                        break;
                }
            }
        };
        this.v = new z0(this);
        this.w = -1;
        this.B = new a1(this);
        this.C = new h(3);
        this.G = new ArrayDeque();
        this.Q = new a0(1, this);
    }

    public static k1 F(FragmentContainerView fragmentContainerView) {
        FragmentActivity fragmentActivity;
        k0 k0Var;
        FragmentContainerView fragmentContainerView2 = fragmentContainerView;
        while (true) {
            fragmentActivity = null;
            if (fragmentContainerView2 == null) {
                k0Var = null;
                break;
            }
            Object tag = fragmentContainerView2.getTag(2131427913);
            k0Var = tag instanceof k0 ? (k0) tag : null;
            if (k0Var != null) {
                break;
            }
            ViewParent parent = fragmentContainerView2.getParent();
            fragmentContainerView2 = parent instanceof View ? (View) parent : null;
        }
        if (k0Var != null) {
            if (k0Var.isAdded()) {
                return k0Var.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + k0Var + " that owns View " + fragmentContainerView + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = fragmentContainerView.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + fragmentContainerView + " is not within a subclass of FragmentActivity.");
    }

    public static HashSet H(a aVar) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < aVar.a.size(); i++) {
            k0 k0Var = ((v1) aVar.a.get(i)).b;
            if (k0Var != null && aVar.g) {
                hashSet.add(k0Var);
            }
        }
        return hashSet;
    }

    public static boolean N(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean O(k0 k0Var) {
        if (k0Var.mHasMenu && k0Var.mMenuVisible) {
            return true;
        }
        boolean zO = false;
        for (k0 k0Var2 : k0Var.mChildFragmentManager.c.e()) {
            if (k0Var2 != null) {
                zO = O(k0Var2);
            }
            if (zO) {
                return true;
            }
        }
        return false;
    }

    public static boolean Q(k0 k0Var) {
        if (k0Var == null) {
            return true;
        }
        k1 k1Var = k0Var.mFragmentManager;
        return k0Var.equals(k1Var.A) && Q(k1Var.z);
    }

    public static void k0(k0 k0Var) {
        if (N(2)) {
            Log.v("FragmentManager", "show: " + k0Var);
        }
        if (k0Var.mHidden) {
            k0Var.mHidden = false;
            k0Var.mHiddenChanged = !k0Var.mHiddenChanged;
        }
    }

    public final boolean A(boolean z) {
        boolean zA;
        a aVar;
        z(z);
        if (!this.i && (aVar = this.h) != null) {
            aVar.s = false;
            aVar.h();
            if (N(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.h + " as part of execPendingActions for actions " + this.a);
            }
            this.h.i(false, false);
            this.a.add(0, this.h);
            Iterator it = this.h.a.iterator();
            while (it.hasNext()) {
                k0 k0Var = ((v1) it.next()).b;
                if (k0Var != null) {
                    k0Var.mTransitioning = false;
                }
            }
            this.h = null;
        }
        boolean z2 = false;
        while (true) {
            ArrayList arrayList = this.M;
            ArrayList arrayList2 = this.N;
            synchronized (this.a) {
                if (this.a.isEmpty()) {
                    zA = false;
                } else {
                    try {
                        int size = this.a.size();
                        zA = false;
                        for (int i = 0; i < size; i++) {
                            zA |= ((h1) this.a.get(i)).a(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (!zA) {
                break;
            }
            this.b = true;
            try {
                a0(this.M, this.N);
                d();
                z2 = true;
            } catch (Throwable th) {
                d();
                throw th;
            }
        }
        n0();
        if (this.L) {
            this.L = false;
            for (t1 t1Var : this.c.d()) {
                k0 k0Var2 = t1Var.c;
                if (k0Var2.mDeferStart) {
                    if (this.b) {
                        this.L = true;
                    } else {
                        k0Var2.mDeferStart = false;
                        t1Var.k();
                    }
                }
            }
        }
        this.c.b.values().removeAll(Collections.singleton(null));
        return z2;
    }

    public final void B(a aVar, boolean z) {
        if (z && (this.x == null || this.K)) {
            return;
        }
        z(z);
        a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.s = false;
            aVar2.h();
            if (N(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.h + " as part of execSingleAction for action " + aVar);
            }
            this.h.i(false, false);
            this.h.a(this.M, this.N);
            Iterator it = this.h.a.iterator();
            while (it.hasNext()) {
                k0 k0Var = ((v1) it.next()).b;
                if (k0Var != null) {
                    k0Var.mTransitioning = false;
                }
            }
            this.h = null;
        }
        aVar.a(this.M, this.N);
        this.b = true;
        try {
            a0(this.M, this.N);
            d();
            n0();
            boolean z2 = this.L;
            u1 u1Var = this.c;
            if (z2) {
                this.L = false;
                for (t1 t1Var : u1Var.d()) {
                    k0 k0Var2 = t1Var.c;
                    if (k0Var2.mDeferStart) {
                        if (this.b) {
                            this.L = true;
                        } else {
                            k0Var2.mDeferStart = false;
                            t1Var.k();
                        }
                    }
                }
            }
            u1Var.b.values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:340:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x021e A[PHI: r15
  0x021e: PHI (r15v14 int) = (r15v13 int), (r15v16 int) binds: [B:377:0x020b, B:381:0x0215] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void C(java.util.ArrayList r26, java.util.ArrayList r27, int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 1312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.fragment.app.k1.C(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final k0 D(int i) {
        u1 u1Var = this.c;
        ArrayList arrayList = u1Var.a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            k0 k0Var = (k0) arrayList.get(size);
            if (k0Var != null && k0Var.mFragmentId == i) {
                return k0Var;
            }
        }
        for (t1 t1Var : u1Var.b.values()) {
            if (t1Var != null) {
                k0 k0Var2 = t1Var.c;
                if (k0Var2.mFragmentId == i) {
                    return k0Var2;
                }
            }
        }
        return null;
    }

    public final k0 E(String str) {
        u1 u1Var = this.c;
        ArrayList arrayList = u1Var.a;
        if (str != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                k0 k0Var = (k0) arrayList.get(size);
                if (k0Var != null && str.equals(k0Var.mTag)) {
                    return k0Var;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (t1 t1Var : u1Var.b.values()) {
            if (t1Var != null) {
                k0 k0Var2 = t1Var.c;
                if (str.equals(k0Var2.mTag)) {
                    return k0Var2;
                }
            }
        }
        return null;
    }

    public final void G() {
        for (r rVar : f()) {
            if (rVar.f590f) {
                if (N(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                rVar.f590f = false;
                rVar.e();
            }
        }
    }

    public final int I() {
        return this.d.size() + (this.h != null ? 1 : 0);
    }

    public final ViewGroup J(k0 k0Var) {
        ViewGroup viewGroup = k0Var.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (k0Var.mContainerId <= 0 || !this.y.c()) {
            return null;
        }
        ViewGroup viewGroupB = this.y.b(k0Var.mContainerId);
        if (viewGroupB instanceof ViewGroup) {
            return viewGroupB;
        }
        return null;
    }

    public final a1 K() {
        k0 k0Var = this.z;
        return k0Var != null ? k0Var.mFragmentManager.K() : this.B;
    }

    public final h L() {
        k0 k0Var = this.z;
        return k0Var != null ? k0Var.mFragmentManager.L() : this.C;
    }

    public final void M(k0 k0Var) {
        if (N(2)) {
            Log.v("FragmentManager", "hide: " + k0Var);
        }
        if (k0Var.mHidden) {
            return;
        }
        k0Var.mHidden = true;
        k0Var.mHiddenChanged = true ^ k0Var.mHiddenChanged;
        j0(k0Var);
    }

    public final boolean P() {
        k0 k0Var = this.z;
        if (k0Var == null) {
            return true;
        }
        return k0Var.isAdded() && this.z.getParentFragmentManager().P();
    }

    public final boolean R() {
        return this.I || this.J;
    }

    public final void S(int i, boolean z) {
        s0 s0Var;
        if (this.x == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.w) {
            this.w = i;
            u1 u1Var = this.c;
            HashMap map = u1Var.b;
            Iterator it = u1Var.a.iterator();
            while (it.hasNext()) {
                t1 t1Var = (t1) map.get(((k0) it.next()).mWho);
                if (t1Var != null) {
                    t1Var.k();
                }
            }
            for (t1 t1Var2 : map.values()) {
                if (t1Var2 != null) {
                    t1Var2.k();
                    k0 k0Var = t1Var2.c;
                    if (k0Var.mRemoving && !k0Var.isInBackStack()) {
                        if (k0Var.mBeingSaved && !u1Var.c.containsKey(k0Var.mWho)) {
                            u1Var.i(t1Var2.n(), k0Var.mWho);
                        }
                        u1Var.h(t1Var2);
                    }
                }
            }
            for (t1 t1Var3 : u1Var.d()) {
                k0 k0Var2 = t1Var3.c;
                if (k0Var2.mDeferStart) {
                    if (this.b) {
                        this.L = true;
                    } else {
                        k0Var2.mDeferStart = false;
                        t1Var3.k();
                    }
                }
            }
            if (this.H && (s0Var = this.x) != null && this.w == 7) {
                ((o0) s0Var).e.invalidateMenu();
                this.H = false;
            }
        }
    }

    public final void T() {
        if (this.x == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.g = false;
        for (k0 k0Var : this.c.f()) {
            if (k0Var != null) {
                k0Var.noteStateNotSaved();
            }
        }
    }

    public final void U() {
        y(new i1(this, -1, 0), false);
    }

    public final boolean V() {
        return W(-1, 0);
    }

    public final boolean W(int i, int i2) {
        A(false);
        z(true);
        k0 k0Var = this.A;
        if (k0Var != null && i < 0 && k0Var.getChildFragmentManager().V()) {
            return true;
        }
        boolean zX = X(this.M, this.N, i, i2);
        if (zX) {
            this.b = true;
            try {
                a0(this.M, this.N);
            } finally {
                d();
            }
        }
        n0();
        boolean z = this.L;
        u1 u1Var = this.c;
        if (z) {
            this.L = false;
            for (t1 t1Var : u1Var.d()) {
                k0 k0Var2 = t1Var.c;
                if (k0Var2.mDeferStart) {
                    if (this.b) {
                        this.L = true;
                    } else {
                        k0Var2.mDeferStart = false;
                        t1Var.k();
                    }
                }
            }
        }
        u1Var.b.values().removeAll(Collections.singleton(null));
        return zX;
    }

    public final boolean X(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        boolean z = (i2 & 1) != 0;
        int size = -1;
        if (!this.d.isEmpty()) {
            if (i < 0) {
                size = z ? 0 : this.d.size() - 1;
            } else {
                int size2 = this.d.size() - 1;
                while (size2 >= 0) {
                    a aVar = (a) this.d.get(size2);
                    if (i >= 0 && i == aVar.t) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    size = size2;
                } else if (z) {
                    size = size2;
                    while (size > 0) {
                        a aVar2 = (a) this.d.get(size - 1);
                        if (i < 0 || i != aVar2.t) {
                            break;
                        }
                        size--;
                    }
                } else if (size2 != this.d.size() - 1) {
                    size = size2 + 1;
                }
            }
        }
        if (size < 0) {
            return false;
        }
        for (int size3 = this.d.size() - 1; size3 >= size; size3--) {
            arrayList.add((a) this.d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void Y(st1.t1 t1Var, boolean z) {
        vi1 vi1Var = this.p;
        vi1Var.getClass();
        ((CopyOnWriteArrayList) vi1Var.b).add(new v0(t1Var, z));
    }

    public final void Z(k0 k0Var) {
        if (N(2)) {
            Log.v("FragmentManager", "remove: " + k0Var + " nesting=" + k0Var.mBackStackNesting);
        }
        boolean zIsInBackStack = k0Var.isInBackStack();
        if (k0Var.mDetached && zIsInBackStack) {
            return;
        }
        u1 u1Var = this.c;
        synchronized (u1Var.a) {
            u1Var.a.remove(k0Var);
        }
        k0Var.mAdded = false;
        if (O(k0Var)) {
            this.H = true;
        }
        k0Var.mRemoving = true;
        j0(k0Var);
    }

    public final t1 a(k0 k0Var) {
        String str = k0Var.mPreviousWho;
        if (str != null) {
            b.c(k0Var, str);
        }
        if (N(2)) {
            Log.v("FragmentManager", "add: " + k0Var);
        }
        t1 t1VarH = h(k0Var);
        k0Var.mFragmentManager = this;
        u1 u1Var = this.c;
        u1Var.g(t1VarH);
        if (!k0Var.mDetached) {
            u1Var.a(k0Var);
            k0Var.mRemoving = false;
            if (k0Var.mView == null) {
                k0Var.mHiddenChanged = false;
            }
            if (O(k0Var)) {
                this.H = true;
            }
        }
        return t1VarH;
    }

    public final void a0(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((a) arrayList.get(i)).p) {
                if (i2 != i) {
                    C(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((a) arrayList.get(i2)).p) {
                        i2++;
                    }
                }
                C(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            C(arrayList, arrayList2, i2, size);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(s0 s0Var, q0 q0Var, k0 k0Var) {
        if (this.x != null) {
            throw new IllegalStateException("Already attached");
        }
        this.x = s0Var;
        this.y = q0Var;
        this.z = k0Var;
        CopyOnWriteArrayList copyOnWriteArrayList = this.q;
        if (k0Var != null) {
            copyOnWriteArrayList.add(new c1(k0Var));
        } else if (s0Var instanceof p1) {
            copyOnWriteArrayList.add((p1) s0Var);
        }
        if (this.z != null) {
            n0();
        }
        if (s0Var instanceof f.c0) {
            f.c0 c0Var = (f.c0) s0Var;
            f.a0 onBackPressedDispatcher = c0Var.getOnBackPressedDispatcher();
            this.g = onBackPressedDispatcher;
            tlydtdl.lifecycle.g0 g0Var = c0Var;
            if (k0Var != null) {
                g0Var = k0Var;
            }
            onBackPressedDispatcher.a(g0Var, this.f588j);
        }
        if (k0Var != null) {
            o1 o1Var = k0Var.mFragmentManager.P;
            HashMap map = o1Var.c;
            o1 o1Var2 = (o1) map.get(k0Var.mWho);
            if (o1Var2 == null) {
                o1Var2 = new o1(o1Var.e);
                map.put(k0Var.mWho, o1Var2);
            }
            this.P = o1Var2;
        } else if (s0Var instanceof tlydtdl.lifecycle.w1) {
            tlydtdl.lifecycle.v1 viewModelStore = ((tlydtdl.lifecycle.w1) s0Var).getViewModelStore();
            o.h(viewModelStore, "store");
            b8.a aVar = b8.a.b;
            o.h(aVar, "defaultCreationExtras");
            cy cyVar = new cy(viewModelStore, o1.h, aVar);
            lmjxuqdtp.jvm.internal.f fVarA = lmjxuqdtp.jvm.internal.d0.a(o1.class);
            String strE = fVarA.e();
            if (strE == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.P = (o1) cyVar.k(fVarA, "tlydtdl.lifecycle.ViewModelProvider.DefaultKey:".concat(strE));
        } else {
            this.P = new o1(false);
        }
        this.P.g = R();
        this.c.d = this.P;
        cc.g gVar = this.x;
        if ((gVar instanceof cc.g) && k0Var == null) {
            e savedStateRegistry = gVar.getSavedStateRegistry();
            savedStateRegistry.c("amuvvoafs:support:fragments", new l0(1, this));
            Bundle bundleA = savedStateRegistry.a("amuvvoafs:support:fragments");
            if (bundleA != null) {
                b0(bundleA);
            }
        }
        j jVar = this.x;
        if (jVar instanceof j) {
            i activityResultRegistry = jVar.getActivityResultRegistry();
            String strK = f3.f2.k("FragmentManager:", k0Var != null ? i.p(new StringBuilder(), k0Var.mWho, ":") : HttpUrl.FRAGMENT_ENCODE_SET);
            this.D = activityResultRegistry.d(f3.f2.C(strK, "StartActivityForResult"), new d1(4), new x0(this, 1));
            this.E = activityResultRegistry.d(f3.f2.C(strK, "StartIntentSenderForResult"), new d1(0), new x0(this, 2));
            this.F = activityResultRegistry.d(f3.f2.C(strK, "RequestPermissions"), new d1(2), new x0(this, 0));
        }
        Object obj = this.x;
        if (obj instanceof d) {
            ((d) obj).addOnConfigurationChangedListener(this.r);
        }
        Object obj2 = this.x;
        if (obj2 instanceof f6.e) {
            ((f6.e) obj2).addOnTrimMemoryListener(this.s);
        }
        Object obj3 = this.x;
        if (obj3 instanceof p0) {
            ((p0) obj3).addOnMultiWindowModeChangedListener(this.t);
        }
        Object obj4 = this.x;
        if (obj4 instanceof tlydtdl.core.app.q0) {
            ((tlydtdl.core.app.q0) obj4).addOnPictureInPictureModeChangedListener(this.u);
        }
        Object obj5 = this.x;
        if ((obj5 instanceof l) && k0Var == null) {
            ((l) obj5).addMenuProvider(this.v);
        }
    }

    public final void b0(Bundle bundle) {
        vi1 vi1Var;
        t1 t1Var;
        Bundle bundle2;
        Bundle bundle3;
        for (String str : bundle.keySet()) {
            if (str.startsWith("result_") && (bundle3 = bundle.getBundle(str)) != null) {
                bundle3.setClassLoader(this.x.b.getClassLoader());
                this.m.put(str.substring(7), bundle3);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle.keySet()) {
            if (str2.startsWith("fragment_") && (bundle2 = bundle.getBundle(str2)) != null) {
                bundle2.setClassLoader(this.x.b.getClassLoader());
                map.put(str2.substring(9), bundle2);
            }
        }
        u1 u1Var = this.c;
        HashMap map2 = u1Var.c;
        HashMap map3 = u1Var.b;
        map2.clear();
        map2.putAll(map);
        m1 parcelable = bundle.getParcelable("state");
        if (parcelable == null) {
            return;
        }
        map3.clear();
        Iterator it = parcelable.a.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            vi1Var = this.p;
            if (!zHasNext) {
                break;
            }
            Bundle bundleI = u1Var.i(null, (String) it.next());
            if (bundleI != null) {
                k0 k0Var = (k0) this.P.b.get(bundleI.getParcelable("state").b);
                if (k0Var != null) {
                    if (N(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + k0Var);
                    }
                    t1Var = new t1(vi1Var, u1Var, k0Var, bundleI);
                } else {
                    t1Var = new t1(this.p, this.c, this.x.b.getClassLoader(), K(), bundleI);
                }
                k0 k0Var2 = t1Var.c;
                k0Var2.mSavedFragmentState = bundleI;
                k0Var2.mFragmentManager = this;
                if (N(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + k0Var2.mWho + "): " + k0Var2);
                }
                t1Var.l(this.x.b.getClassLoader());
                u1Var.g(t1Var);
                t1Var.e = this.w;
            }
        }
        o1 o1Var = this.P;
        o1Var.getClass();
        for (k0 k0Var3 : new ArrayList(o1Var.b.values())) {
            if (map3.get(k0Var3.mWho) == null) {
                if (N(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + k0Var3 + " that was not found in the set of active Fragments " + parcelable.a);
                }
                this.P.i(k0Var3);
                k0Var3.mFragmentManager = this;
                t1 t1Var2 = new t1(vi1Var, u1Var, k0Var3);
                t1Var2.e = 1;
                t1Var2.k();
                k0Var3.mRemoving = true;
                t1Var2.k();
            }
        }
        ArrayList<String> arrayList = parcelable.b;
        u1Var.a.clear();
        if (arrayList != null) {
            for (String str3 : arrayList) {
                k0 k0VarB = u1Var.b(str3);
                if (k0VarB == null) {
                    throw new IllegalStateException(i.n("No instantiated fragment for (", str3, ")"));
                }
                if (N(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + k0VarB);
                }
                u1Var.a(k0VarB);
            }
        }
        if (parcelable.c != null) {
            this.d = new ArrayList(parcelable.c.length);
            int i = 0;
            while (true) {
                b[] bVarArr = parcelable.c;
                if (i >= bVarArr.length) {
                    break;
                }
                a aVarA = bVarArr[i].a(this);
                if (N(2)) {
                    StringBuilder sbR = c.r(i, "restoreAllState: back stack #", " (index ");
                    sbR.append(aVarA.t);
                    sbR.append("): ");
                    sbR.append(aVarA);
                    Log.v("FragmentManager", sbR.toString());
                    PrintWriter printWriter = new PrintWriter((Writer) new g2());
                    aVarA.j("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(aVarA);
                i++;
            }
        } else {
            this.d = new ArrayList();
        }
        this.k.set(parcelable.d);
        String str4 = parcelable.e;
        if (str4 != null) {
            k0 k0VarB2 = u1Var.b(str4);
            this.A = k0VarB2;
            s(k0VarB2);
        }
        ArrayList arrayList2 = parcelable.f;
        if (arrayList2 != null) {
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                this.l.put((String) arrayList2.get(i2), (c) parcelable.g.get(i2));
            }
        }
        this.G = new ArrayDeque(parcelable.h);
    }

    public final void c(k0 k0Var) {
        if (N(2)) {
            Log.v("FragmentManager", "attach: " + k0Var);
        }
        if (k0Var.mDetached) {
            k0Var.mDetached = false;
            if (k0Var.mAdded) {
                return;
            }
            this.c.a(k0Var);
            if (N(2)) {
                Log.v("FragmentManager", "add from attach: " + k0Var);
            }
            if (O(k0Var)) {
                this.H = true;
            }
        }
    }

    public final Bundle c0() {
        b[] bVarArr;
        ArrayList arrayList;
        Bundle bundle = new Bundle();
        G();
        x();
        A(true);
        this.I = true;
        this.P.g = true;
        u1 u1Var = this.c;
        u1Var.getClass();
        HashMap map = u1Var.b;
        ArrayList arrayList2 = new ArrayList(map.size());
        for (t1 t1Var : map.values()) {
            if (t1Var != null) {
                k0 k0Var = t1Var.c;
                u1Var.i(t1Var.n(), k0Var.mWho);
                arrayList2.add(k0Var.mWho);
                if (N(2)) {
                    Log.v("FragmentManager", "Saved state of " + k0Var + ": " + k0Var.mSavedFragmentState);
                }
            }
        }
        HashMap map2 = this.c.c;
        if (!map2.isEmpty()) {
            u1 u1Var2 = this.c;
            synchronized (u1Var2.a) {
                try {
                    bVarArr = null;
                    if (u1Var2.a.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(u1Var2.a.size());
                        for (k0 k0Var2 : u1Var2.a) {
                            arrayList.add(k0Var2.mWho);
                            if (N(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + k0Var2.mWho + "): " + k0Var2);
                            }
                        }
                    }
                } finally {
                }
            }
            int size = this.d.size();
            if (size > 0) {
                bVarArr = new b[size];
                for (int i = 0; i < size; i++) {
                    bVarArr[i] = new b((a) this.d.get(i));
                    if (N(2)) {
                        StringBuilder sbR = c.r(i, "saveAllState: adding back stack #", ": ");
                        sbR.append(this.d.get(i));
                        Log.v("FragmentManager", sbR.toString());
                    }
                }
            }
            m1 m1Var = new m1();
            m1Var.a = arrayList2;
            m1Var.b = arrayList;
            m1Var.c = bVarArr;
            m1Var.d = this.k.get();
            k0 k0Var3 = this.A;
            if (k0Var3 != null) {
                m1Var.e = k0Var3.mWho;
            }
            m1Var.f.addAll(this.l.keySet());
            m1Var.g.addAll(this.l.values());
            m1Var.h = new ArrayList(this.G);
            bundle.putParcelable("state", m1Var);
            for (String str : this.m.keySet()) {
                bundle.putBundle(f3.f2.k("result_", str), (Bundle) this.m.get(str));
            }
            for (String str2 : map2.keySet()) {
                bundle.putBundle(f3.f2.k("fragment_", str2), (Bundle) map2.get(str2));
            }
        } else if (N(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public final void d() {
        this.b = false;
        this.N.clear();
        this.M.clear();
    }

    public final void d0() {
        synchronized (this.a) {
            try {
                if (this.a.size() == 1) {
                    this.x.c.removeCallbacks(this.Q);
                    this.x.c.post(this.Q);
                    n0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(String str) {
        f1 f1Var = (f1) this.n.remove(str);
        if (f1Var != null) {
            f1Var.a.d(f1Var.c);
        }
        if (N(2)) {
            Log.v("FragmentManager", "Clearing FragmentResultListener for key ".concat(str));
        }
    }

    public final void e0(k0 k0Var, boolean z) {
        FragmentContainerView fragmentContainerViewJ = J(k0Var);
        if (fragmentContainerViewJ == null || !(fragmentContainerViewJ instanceof FragmentContainerView)) {
            return;
        }
        fragmentContainerViewJ.setDrawDisappearingViewsLast(!z);
    }

    public final HashSet f() {
        r rVar;
        HashSet hashSet = new HashSet();
        Iterator it = this.c.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((t1) it.next()).c.mContainer;
            if (viewGroup != null) {
                o.h(L(), "factory");
                Object tag = viewGroup.getTag(2131428517);
                if (tag instanceof r) {
                    rVar = (r) tag;
                } else {
                    rVar = new r(viewGroup);
                    viewGroup.setTag(2131428517, rVar);
                }
                hashSet.add(rVar);
            }
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f0(amuvvoafs.os.Bundle r4, java.lang.String r5) {
        /*
            r3 = this;
            java.util.Map r0 = r3.n
            java.lang.Object r0 = r0.get(r5)
            tlydtdl.fragment.app.f1 r0 = (tlydtdl.fragment.app.f1) r0
            if (r0 == 0) goto L1c
            tlydtdl.lifecycle.y r1 = tlydtdl.lifecycle.y.d
            tlydtdl.lifecycle.z r2 = r0.a
            tlydtdl.lifecycle.y r2 = r2.b()
            int r1 = r2.compareTo(r1)
            if (r1 < 0) goto L1c
            r0.k(r4, r5)
            goto L21
        L1c:
            java.util.Map r0 = r3.m
            r0.put(r5, r4)
        L21:
            r0 = 2
            boolean r0 = N(r0)
            if (r0 == 0) goto L43
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Setting fragment result with key "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r5 = " and result "
            r0.append(r5)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r5 = "FragmentManager"
            amuvvoafs.util.Log.v(r5, r4)
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.fragment.app.k1.f0(amuvvoafs.os.Bundle, java.lang.String):void");
    }

    public final HashSet g(ArrayList arrayList, int i, int i2) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            Iterator it = ((a) arrayList.get(i)).a.iterator();
            while (it.hasNext()) {
                k0 k0Var = ((v1) it.next()).b;
                if (k0Var != null && (viewGroup = k0Var.mContainer) != null) {
                    hashSet.add(r.j(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    public final void g0(String str, tlydtdl.lifecycle.g0 g0Var, q1 q1Var) {
        z lifecycle = g0Var.getLifecycle();
        if (lifecycle.b() == tlydtdl.lifecycle.y.a) {
            return;
        }
        b1 b1Var = new b1(this, str, q1Var, lifecycle);
        f1 f1Var = (f1) this.n.put(str, new f1(lifecycle, q1Var, b1Var));
        if (f1Var != null) {
            f1Var.a.d(f1Var.c);
        }
        if (N(2)) {
            Log.v("FragmentManager", "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycle + " and listener " + q1Var);
        }
        lifecycle.a(b1Var);
    }

    public final t1 h(k0 k0Var) {
        String str = k0Var.mWho;
        u1 u1Var = this.c;
        t1 t1Var = (t1) u1Var.b.get(str);
        if (t1Var != null) {
            return t1Var;
        }
        t1 t1Var2 = new t1(this.p, u1Var, k0Var);
        t1Var2.l(this.x.b.getClassLoader());
        t1Var2.e = this.w;
        return t1Var2;
    }

    public final void h0(k0 k0Var, tlydtdl.lifecycle.y yVar) {
        if (k0Var.equals(this.c.b(k0Var.mWho)) && (k0Var.mHost == null || k0Var.mFragmentManager == this)) {
            k0Var.mMaxState = yVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + k0Var + " is not an active fragment of FragmentManager " + this);
    }

    public final void i(k0 k0Var) {
        if (N(2)) {
            Log.v("FragmentManager", "detach: " + k0Var);
        }
        if (k0Var.mDetached) {
            return;
        }
        k0Var.mDetached = true;
        if (k0Var.mAdded) {
            if (N(2)) {
                Log.v("FragmentManager", "remove from detach: " + k0Var);
            }
            u1 u1Var = this.c;
            synchronized (u1Var.a) {
                u1Var.a.remove(k0Var);
            }
            k0Var.mAdded = false;
            if (O(k0Var)) {
                this.H = true;
            }
            j0(k0Var);
        }
    }

    public final void i0(k0 k0Var) {
        if (k0Var != null) {
            if (!k0Var.equals(this.c.b(k0Var.mWho)) || (k0Var.mHost != null && k0Var.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + k0Var + " is not an active fragment of FragmentManager " + this);
            }
        }
        k0 k0Var2 = this.A;
        this.A = k0Var;
        s(k0Var2);
        s(this.A);
    }

    public final void j(boolean z, Configuration configuration) {
        if (z && (this.x instanceof d)) {
            l0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (k0 k0Var : this.c.f()) {
            if (k0Var != null) {
                k0Var.performConfigurationChanged(configuration);
                if (z) {
                    k0Var.mChildFragmentManager.j(true, configuration);
                }
            }
        }
    }

    public final void j0(k0 k0Var) {
        ViewGroup viewGroupJ = J(k0Var);
        if (viewGroupJ != null) {
            if (k0Var.getPopExitAnim() + k0Var.getPopEnterAnim() + k0Var.getExitAnim() + k0Var.getEnterAnim() > 0) {
                if (viewGroupJ.getTag(2131428739) == null) {
                    viewGroupJ.setTag(2131428739, k0Var);
                }
                ((k0) viewGroupJ.getTag(2131428739)).setPopDirection(k0Var.getPopDirection());
            }
        }
    }

    public final boolean k(MenuItem menuItem) {
        if (this.w < 1) {
            return false;
        }
        for (k0 k0Var : this.c.f()) {
            if (k0Var != null && k0Var.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean l(Menu menu, MenuInflater menuInflater) {
        if (this.w < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (k0 k0Var : this.c.f()) {
            if (k0Var != null && k0Var.isMenuVisible() && k0Var.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(k0Var);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i = 0; i < this.e.size(); i++) {
                k0 k0Var2 = (k0) this.e.get(i);
                if (arrayList == null || !arrayList.contains(k0Var2)) {
                    k0Var2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public final void l0(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter((Writer) new g2());
        s0 s0Var = this.x;
        if (s0Var == null) {
            try {
                w("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw illegalStateException;
            }
        }
        try {
            ((o0) s0Var).e.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw illegalStateException;
        }
    }

    public final void m() throws Exception {
        boolean zIsChangingConfigurations = true;
        this.K = true;
        A(true);
        x();
        s0 s0Var = this.x;
        boolean z = s0Var instanceof tlydtdl.lifecycle.w1;
        u1 u1Var = this.c;
        if (z) {
            zIsChangingConfigurations = u1Var.d.f589f;
        } else {
            FragmentActivity fragmentActivity = s0Var.b;
            if (fragmentActivity != null) {
                zIsChangingConfigurations = true ^ fragmentActivity.isChangingConfigurations();
            }
        }
        if (zIsChangingConfigurations) {
            Iterator it = this.l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((c) it.next()).a.iterator();
                while (it2.hasNext()) {
                    u1Var.d.g((String) it2.next(), false);
                }
            }
        }
        v(-1);
        Object obj = this.x;
        if (obj instanceof f6.e) {
            ((f6.e) obj).removeOnTrimMemoryListener(this.s);
        }
        Object obj2 = this.x;
        if (obj2 instanceof d) {
            ((d) obj2).removeOnConfigurationChangedListener(this.r);
        }
        Object obj3 = this.x;
        if (obj3 instanceof p0) {
            ((p0) obj3).removeOnMultiWindowModeChangedListener(this.t);
        }
        Object obj4 = this.x;
        if (obj4 instanceof tlydtdl.core.app.q0) {
            ((tlydtdl.core.app.q0) obj4).removeOnPictureInPictureModeChangedListener(this.u);
        }
        Object obj5 = this.x;
        if ((obj5 instanceof l) && this.z == null) {
            ((l) obj5).removeMenuProvider(this.v);
        }
        this.x = null;
        this.y = null;
        this.z = null;
        if (this.g != null) {
            this.f588j.e();
            this.g = null;
        }
        i.h hVar = this.D;
        if (hVar != null) {
            hVar.b();
            this.E.b();
            this.F.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0028, code lost:
    
        ((java.util.concurrent.CopyOnWriteArrayList) r0.b).remove(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m0(st1.t1 r6) {
        /*
            r5 = this;
            com.gnacba.amuvvoafs.gms.internal.ads.vi1 r0 = r5.p
            r0.getClass()
            java.lang.String r1 = "cb"
            lmjxuqdtp.jvm.internal.o.h(r6, r1)
            java.lang.Object r1 = r0.b
            java.util.concurrent.CopyOnWriteArrayList r1 = (java.util.concurrent.CopyOnWriteArrayList) r1
            monitor-enter(r1)
            java.lang.Object r2 = r0.b     // Catch: java.lang.Throwable -> L30
            java.util.concurrent.CopyOnWriteArrayList r2 = (java.util.concurrent.CopyOnWriteArrayList) r2     // Catch: java.lang.Throwable -> L30
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L30
            r3 = 0
        L18:
            if (r3 >= r2) goto L35
            java.lang.Object r4 = r0.b     // Catch: java.lang.Throwable -> L30
            java.util.concurrent.CopyOnWriteArrayList r4 = (java.util.concurrent.CopyOnWriteArrayList) r4     // Catch: java.lang.Throwable -> L30
            java.lang.Object r4 = r4.get(r3)     // Catch: java.lang.Throwable -> L30
            tlydtdl.fragment.app.v0 r4 = (tlydtdl.fragment.app.v0) r4     // Catch: java.lang.Throwable -> L30
            st1.t1 r4 = r4.a     // Catch: java.lang.Throwable -> L30
            if (r4 != r6) goto L32
            java.lang.Object r6 = r0.b     // Catch: java.lang.Throwable -> L30
            java.util.concurrent.CopyOnWriteArrayList r6 = (java.util.concurrent.CopyOnWriteArrayList) r6     // Catch: java.lang.Throwable -> L30
            r6.remove(r3)     // Catch: java.lang.Throwable -> L30
            goto L35
        L30:
            r6 = move-exception
            goto L37
        L32:
            int r3 = r3 + 1
            goto L18
        L35:
            monitor-exit(r1)
            return
        L37:
            monitor-exit(r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.fragment.app.k1.m0(st1.t1):void");
    }

    public final void n(boolean z) {
        if (z && (this.x instanceof f6.e)) {
            l0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (k0 k0Var : this.c.f()) {
            if (k0Var != null) {
                k0Var.performLowMemory();
                if (z) {
                    k0Var.mChildFragmentManager.n(true);
                }
            }
        }
    }

    public final void n0() {
        synchronized (this.a) {
            try {
                if (!this.a.isEmpty()) {
                    this.f588j.f(true);
                    if (N(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                boolean z = I() > 0 && Q(this.z);
                if (N(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z);
                }
                this.f588j.f(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o(boolean z, boolean z2) {
        if (z2 && (this.x instanceof p0)) {
            l0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (k0 k0Var : this.c.f()) {
            if (k0Var != null) {
                k0Var.performMultiWindowModeChanged(z);
                if (z2) {
                    k0Var.mChildFragmentManager.o(z, true);
                }
            }
        }
    }

    public final void p() {
        for (k0 k0Var : this.c.e()) {
            if (k0Var != null) {
                k0Var.onHiddenChanged(k0Var.isHidden());
                k0Var.mChildFragmentManager.p();
            }
        }
    }

    public final boolean q(MenuItem menuItem) {
        if (this.w < 1) {
            return false;
        }
        for (k0 k0Var : this.c.f()) {
            if (k0Var != null && k0Var.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void r(Menu menu) {
        if (this.w < 1) {
            return;
        }
        for (k0 k0Var : this.c.f()) {
            if (k0Var != null) {
                k0Var.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void s(k0 k0Var) {
        if (k0Var != null) {
            if (k0Var.equals(this.c.b(k0Var.mWho))) {
                k0Var.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final void t(boolean z, boolean z2) {
        if (z2 && (this.x instanceof tlydtdl.core.app.q0)) {
            l0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (k0 k0Var : this.c.f()) {
            if (k0Var != null) {
                k0Var.performPictureInPictureModeChanged(z);
                if (z2) {
                    k0Var.mChildFragmentManager.t(z, true);
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        k0 k0Var = this.z;
        if (k0Var != null) {
            sb.append(k0Var.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.z)));
            sb.append("}");
        } else {
            s0 s0Var = this.x;
            if (s0Var != null) {
                sb.append(s0Var.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.x)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final boolean u(Menu menu) {
        boolean z = false;
        if (this.w < 1) {
            return false;
        }
        for (k0 k0Var : this.c.f()) {
            if (k0Var != null && k0Var.isMenuVisible() && k0Var.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final void v(int i) {
        try {
            this.b = true;
            for (t1 t1Var : this.c.b.values()) {
                if (t1Var != null) {
                    t1Var.e = i;
                }
            }
            S(i, false);
            Iterator it = f().iterator();
            while (it.hasNext()) {
                ((r) it.next()).i();
            }
            this.b = false;
            A(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final void w(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String strC = f3.f2.C(str, "    ");
        u1 u1Var = this.c;
        ArrayList arrayList = u1Var.a;
        String strC2 = f3.f2.C(str, "    ");
        HashMap map = u1Var.b;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (t1 t1Var : map.values()) {
                printWriter.print(str);
                if (t1Var != null) {
                    k0 k0Var = t1Var.c;
                    printWriter.println(k0Var);
                    k0Var.dump(strC2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size2 = arrayList.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size2; i++) {
                k0 k0Var2 = (k0) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(k0Var2.toString());
            }
        }
        ArrayList arrayList2 = this.e;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size; i2++) {
                k0 k0Var3 = (k0) this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(k0Var3.toString());
            }
        }
        int size3 = this.d.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                a aVar = (a) this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.j(strC, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.k.get());
        synchronized (this.a) {
            try {
                int size4 = this.a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        Object obj = (h1) this.a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.y);
        if (this.z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    public final void x() {
        Iterator it = f().iterator();
        while (it.hasNext()) {
            ((r) it.next()).i();
        }
    }

    public final void y(h1 h1Var, boolean z) {
        if (!z) {
            if (this.x == null) {
                if (!this.K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (R()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.a) {
            try {
                if (this.x == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.a.add(h1Var);
                    d0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.x == null) {
            if (!this.K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.x.c.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z && R()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.M == null) {
            this.M = new ArrayList();
            this.N = new ArrayList();
        }
    }
}
