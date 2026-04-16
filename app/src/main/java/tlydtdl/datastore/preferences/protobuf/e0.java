package tlydtdl.datastore.preferences.protobuf;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 {
    public static final t b = new t(1);
    public final Object a;

    public e0(m mVar) {
        y.a(mVar, "output");
        this.a = mVar;
        mVar.b = this;
    }

    public void a(int i, Object obj, u0 u0Var) {
        m mVar = (m) this.a;
        mVar.l0(i, 3);
        u0Var.e((a) obj, mVar.b);
        mVar.l0(i, 4);
    }

    public e0() {
        j0 j0Var;
        r0 r0Var = r0.c;
        try {
            j0Var = (j0) Class.forName("tlydtdl.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            j0Var = b;
        }
        j0[] j0VarArr = {t.b, j0Var};
        d0 d0Var = new d0();
        d0Var.a = j0VarArr;
        Charset charset = y.a;
        this.a = d0Var;
    }
}
