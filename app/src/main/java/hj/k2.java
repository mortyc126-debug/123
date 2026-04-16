package hj;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k2 {
    public final int a;
    public final d3 b;
    public final ArrayList c;
    public final d3 d;

    public k2(d3 d3Var, int i, float f2, float f3) {
        this.a = i;
        float f4 = d3Var.a;
        float f5 = d3Var.b;
        this.b = new d3(f4, (i * f2) + f5);
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            float f7 = (i2 * f2) + f5;
            arrayList.add(new d3(f7 + f3, (f7 + f2) - f3));
        }
        this.c = arrayList;
        this.d = new d3(f4 + f3, f5 - f3);
    }
}
