package s4;

import q4.v0;
import q4.w0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface a0 extends n {
    default int maxIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        return q8.j.v(new z(this), wVar, vVar, i);
    }

    default int maxIntrinsicWidth(q4.w wVar, q4.v vVar, int i) {
        return q8.j.w(new li.a(this), wVar, vVar, i);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    v0 mo1789measure3p2s80s(w0 w0Var, q4.t0 t0Var, long j2);

    default int minIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        return q8.j.x(new pt1.l(8, this), wVar, vVar, i);
    }

    default int minIntrinsicWidth(q4.w wVar, q4.v vVar, int i) {
        return q8.j.y(new z(this), wVar, vVar, i);
    }
}
