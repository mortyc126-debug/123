package x5;

import java.util.ArrayList;
import y5.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i extends d {
    public d[] q0 = new d[4];
    public int r0 = 0;

    public final void R(int i, ArrayList arrayList, m mVar) {
        for (int i2 = 0; i2 < this.r0; i2++) {
            mVar.a(this.q0[i2]);
        }
        for (int i3 = 0; i3 < this.r0; i3++) {
            q8.c.o(this.q0[i3], i, arrayList, mVar);
        }
    }

    public void S() {
    }
}
