package tlydtdl.compose.foundation.lazy.layout;

import tlydtdl.compose.runtime.f3;
import tlydtdl.compose.runtime.x0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 implements f3 {
    public final int a;
    public final int b;
    public final tlydtdl.compose.runtime.n1 c;
    public int d;

    public t0(int i, int i2, int i3) {
        this.a = i2;
        this.b = i3;
        int i4 = (i / i2) * i2;
        this.c = new tlydtdl.compose.runtime.n1(st.w0.D0(Math.max(i4 - i3, 0), i4 + i2 + i3), x0.f548f);
        this.d = i;
    }

    public final void b(int i) {
        if (i != this.d) {
            this.d = i;
            int i2 = this.a;
            int i3 = (i / i2) * i2;
            int i4 = this.b;
            this.c.setValue(st.w0.D0(Math.max(i3 - i4, 0), i3 + i2 + i4));
        }
    }

    @Override // tlydtdl.compose.runtime.f3
    public final Object getValue() {
        return (ey1.k) this.c.getValue();
    }
}
