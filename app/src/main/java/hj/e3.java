package hj;

import amuvvoafs.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import lmjxuqdtp.jvm.internal.o;
import py1.d;
import qx1.i;
import s02.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e3 implements ky1.a0, View.OnAttachStateChangeListener {
    public final View a;
    public final ky1.a0 b;
    public final HashSet c;

    public e3(View view) {
        ry1.e eVar = ky1.m0.a;
        d dVarB = ky1.c0.b(py1.m.a);
        this.a = view;
        this.b = dVarB;
        this.c = new HashSet();
        view.addOnAttachStateChangeListener(this);
    }

    public final i getCoroutineContext() {
        return this.b.getCoroutineContext();
    }

    public final void onViewAttachedToWindow(View view) {
        o.h(view, "v");
        HashSet hashSet = this.c;
        if (!hashSet.isEmpty()) {
            b bVar = s02.d.a;
            String str = "Coroutine scope's associated view attached to window. Start " + hashSet.size() + " pending jobs";
            bVar.getClass();
            b.p(str);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((ky1.f1) it.next()).start();
        }
        hashSet.clear();
    }

    public final void onViewDetachedFromWindow(View view) {
        o.h(view, "v");
        m8.d.p(this.b, new CancellationException(view.getClass().getName().concat(" detached from window")));
        this.c.clear();
    }
}
