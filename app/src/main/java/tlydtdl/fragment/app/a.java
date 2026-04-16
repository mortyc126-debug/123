package tlydtdl.fragment.app;

import amuvvoafs.util.Log;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import u7.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends w1 implements h1 {
    public final k1 r;
    public boolean s;
    public int t;

    public a(k1 k1Var) {
        k1Var.K();
        s0 s0Var = k1Var.x;
        if (s0Var != null) {
            s0Var.b.getClassLoader();
        }
        this.a = new ArrayList();
        this.h = true;
        this.p = false;
        this.t = -1;
        this.r = k1Var;
    }

    @Override // tlydtdl.fragment.app.h1
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (k1.N(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.g) {
            return true;
        }
        this.r.d.add(this);
        return true;
    }

    @Override // tlydtdl.fragment.app.w1
    public final int d() {
        return i(false, true);
    }

    @Override // tlydtdl.fragment.app.w1
    public final void e(int i, k0 k0Var, String str, int i2) {
        String str2 = k0Var.mPreviousWho;
        if (str2 != null) {
            b.c(k0Var, str2);
        }
        Class<?> cls = k0Var.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = k0Var.mTag;
            if (str3 != null && !str.equals(str3)) {
                StringBuilder sb = new StringBuilder("Can't change tag of fragment ");
                sb.append(k0Var);
                sb.append(": was ");
                throw new IllegalStateException(z.p.g(sb, k0Var.mTag, " now ", str));
            }
            k0Var.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + k0Var + " with tag " + str + " to container view with no id");
            }
            int i3 = k0Var.mFragmentId;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + k0Var + ": was " + k0Var.mFragmentId + " now " + i);
            }
            k0Var.mFragmentId = i;
            k0Var.mContainerId = i;
        }
        b(new v1(k0Var, i2));
        k0Var.mFragmentManager = this.r;
    }

    public final void g(int i) {
        ArrayList arrayList = this.a;
        if (this.g) {
            if (k1.N(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                v1 v1Var = (v1) arrayList.get(i2);
                k0 k0Var = v1Var.b;
                if (k0Var != null) {
                    k0Var.mBackStackNesting += i;
                    if (k1.N(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + v1Var.b + " to " + v1Var.b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final void h() {
        ArrayList arrayList = this.a;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            v1 v1Var = (v1) arrayList.get(size);
            if (v1Var.c) {
                if (v1Var.a == 8) {
                    v1Var.c = false;
                    arrayList.remove(size - 1);
                    size--;
                } else {
                    int i = v1Var.b.mContainerId;
                    v1Var.a = 2;
                    v1Var.c = false;
                    for (int i2 = size - 1; i2 >= 0; i2--) {
                        v1 v1Var2 = (v1) arrayList.get(i2);
                        if (v1Var2.c && v1Var2.b.mContainerId == i) {
                            arrayList.remove(i2);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    public final int i(boolean z, boolean z2) {
        if (this.s) {
            throw new IllegalStateException("commit already called");
        }
        if (k1.N(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter((Writer) new g2());
            j("  ", printWriter, true);
            printWriter.close();
        }
        this.s = true;
        boolean z3 = this.g;
        k1 k1Var = this.r;
        if (z3) {
            this.t = k1Var.k.getAndIncrement();
        } else {
            this.t = -1;
        }
        if (z2) {
            k1Var.y(this, z);
        }
        return this.t;
    }

    public final void j(String str, PrintWriter printWriter, boolean z) {
        String str2;
        ArrayList arrayList = this.a;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.s);
            if (this.f592f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f592f));
            }
            if (this.b != 0 || this.c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.c));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.f593j != 0 || this.k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f593j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.k);
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            v1 v1Var = (v1) arrayList.get(i);
            switch (v1Var.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + v1Var.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(v1Var.b);
            if (z) {
                if (v1Var.d != 0 || v1Var.e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(v1Var.d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(v1Var.e));
                }
                if (v1Var.f591f != 0 || v1Var.g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(v1Var.f591f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(v1Var.g));
                }
            }
        }
    }

    public final a k(k0 k0Var) {
        k1 k1Var = k0Var.mFragmentManager;
        if (k1Var == null || k1Var == this.r) {
            b(new v1(k0Var, 3));
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + k0Var.toString() + " is already attached to a FragmentManager.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.t >= 0) {
            sb.append(" #");
            sb.append(this.t);
        }
        if (this.i != null) {
            sb.append(" ");
            sb.append(this.i);
        }
        sb.append("}");
        return sb.toString();
    }
}
