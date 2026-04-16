package r6;

import amuvvoafs.os.Build;
import amuvvoafs.view.WindowInsets;
import amuvvoafs.view.WindowInsetsAnimation;
import i11.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 extends WindowInsetsAnimation.Callback {
    public final tlydtdl.datastore.preferences.protobuf.k a;
    public List b;
    public ArrayList c;
    public final HashMap d;

    public f1(tlydtdl.datastore.preferences.protobuf.k kVar) {
        super(kVar.a);
        this.d = new HashMap();
        this.a = kVar;
    }

    public final i1 a(WindowInsetsAnimation windowInsetsAnimation) {
        i1 i1Var = (i1) this.d.get(windowInsetsAnimation);
        if (i1Var == null) {
            i1Var = new i1(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                i1Var.a = new g1(windowInsetsAnimation);
            }
            this.d.put(windowInsetsAnimation, i1Var);
        }
        return i1Var;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        this.a.d(a(windowInsetsAnimation));
        this.d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        this.a.e(a(windowInsetsAnimation));
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.c = arrayList2;
            this.b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimation = (WindowInsetsAnimation) list.get(size);
            i1 i1VarA = a(windowInsetsAnimation);
            i1VarA.a.e(windowInsetsAnimation.getFraction());
            this.c.add(i1VarA);
        }
        return this.a.f(z1.g(null, windowInsets), this.b).f();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        c cVarG = this.a.g(a(windowInsetsAnimation), new c(bounds));
        cVarG.getClass();
        e1.c();
        return e1.a(((i6.c) cVarG.b).e(), ((i6.c) cVarG.c).e());
    }
}
