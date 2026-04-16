package w3;

import amuvvoafs.view.DragEvent;
import amuvvoafs.view.View;
import fz1.v;
import lmjxuqdtp.jvm.internal.y;
import q1.a;
import q1.g;
import s4.c1;
import s4.f2;
import t3.o;
import t4.e2;
import tlydtdl.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements View.OnDragListener, e {
    public final my1.e a;
    public final h b = new h(null, 3);
    public final g c = new g(0);
    public final AndroidDragAndDropManager$modifier$1 d = new c1() { // from class: tlydtdl.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1
        @Override // s4.c1
        public final o create() {
            return this.a.b;
        }

        public final boolean equals(Object obj) {
            return obj == this;
        }

        public final int hashCode() {
            return this.a.b.hashCode();
        }

        @Override // s4.c1
        public final void inspectableProperties(e2 e2Var) {
            e2Var.d("RootDragAndDropNode");
        }

        @Override // s4.c1
        public final /* bridge */ /* synthetic */ void update(o oVar) {
        }
    };

    /* JADX WARN: Type inference failed for: r3v3, types: [tlydtdl.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1] */
    public b(my1.e eVar) {
        this.a = eVar;
    }

    public final boolean onDrag(View view, DragEvent dragEvent) {
        d dVar = new d(dragEvent);
        int action = dragEvent.getAction();
        g gVar = this.c;
        h hVar = this.b;
        switch (action) {
            case 1:
                y yVar = new y();
                v vVar = new v(dVar, hVar, yVar, 2);
                if (vVar.invoke(hVar) == f2.a) {
                    s4.g.z(hVar, vVar);
                }
                boolean z = yVar.a;
                gVar.getClass();
                a aVar = new a(gVar);
                while (aVar.hasNext()) {
                    ((i) aVar.next()).e0(dVar);
                }
                break;
            case 2:
                hVar.f0(dVar);
                break;
            case 4:
                hVar.K(dVar);
                gVar.clear();
                break;
            case 5:
                hVar.G0(dVar);
                break;
            case 6:
                hVar.D0(dVar);
                break;
        }
        return false;
    }
}
