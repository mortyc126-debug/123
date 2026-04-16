package rd;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f401f;
    public final e h;
    public final /* synthetic */ g i;
    public final long a = Thread.currentThread().getId();
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final LinkedHashSet d = new LinkedHashSet();
    public final LinkedHashSet e = new LinkedHashSet();
    public boolean g = true;

    public e(g gVar, e eVar) {
        this.i = gVar;
        this.h = eVar;
    }

    public final void a() {
        if (this.a != Thread.currentThread().getId()) {
            throw new IllegalStateException("Transaction objects (`TransactionWithReturn` and `TransactionWithoutReturn`) must be used\nonly within the transaction lambda scope.");
        }
        boolean z = this.f401f && this.g;
        g gVar = this.i;
        e eVar = this.h;
        if (eVar == null) {
            if (z) {
                gVar.g().z();
                gVar.g().H();
            } else {
                gVar.g().H();
            }
        }
        gVar.b.set(eVar);
        qd.e.a.getClass();
    }
}
