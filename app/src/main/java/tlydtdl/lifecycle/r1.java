package tlydtdl.lifecycle;

import lmjxuqdtp.jvm.internal.f;
import uc0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface r1 {
    default o1 a(Class cls) {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    default o1 b(f fVar, b8.f fVar2) {
        return c(p.v(fVar), fVar2);
    }

    default o1 c(Class cls, b8.f fVar) {
        return a(cls);
    }
}
