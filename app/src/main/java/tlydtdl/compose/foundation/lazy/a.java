package tlydtdl.compose.foundation.lazy;

import f2.d;
import t3.p;
import tlydtdl.compose.runtime.k1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    static p a(a aVar, p pVar) {
        return pVar.then(new ParentSizeElement((k1) null, ((d) aVar).b, "fillParentMaxHeight", 2));
    }

    static p b(a aVar, p pVar) {
        d dVar = (d) aVar;
        return pVar.then(new ParentSizeElement(dVar.a, dVar.b, "fillParentMaxSize"));
    }

    static p c(a aVar, p pVar) {
        return pVar.then(new ParentSizeElement(((d) aVar).a, (k1) null, "fillParentMaxWidth", 4));
    }
}
