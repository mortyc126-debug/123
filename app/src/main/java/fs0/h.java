package fs0;

import com.google.android.material.R;
import ld1.r;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import of1.q;
import t3.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ x10.v c;

    public /* synthetic */ h(int i, x10.v vVar, boolean z) {
        this.a = i;
        this.b = z;
        this.c = vVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        ld1.d dVar;
        int i;
        ld1.d dVar2;
        int i2;
        switch (this.a) {
            case 0:
                tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj;
                int iIntValue = ((Integer) obj2).intValue();
                tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
                if (sVar.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                    if (this.b) {
                        dVar = r.Companion;
                        i = R.dimen.m3_comp_fab_primary_large_icon_size;
                    } else {
                        dVar = r.Companion;
                        i = R.dimen.m3_comp_elevated_button_disabled_container_elevation;
                    }
                    un0.m.s(this.c, (p) null, i.u(dVar, i), true, sVar, 3072, 2);
                } else {
                    sVar.Z();
                }
                break;
            case 1:
                tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar2;
                if (sVar2.W(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    if (this.b) {
                        sVar2.f0(-1415060593);
                        z10.d.h(bn1.c.C(this.c), i.u(r.Companion, R.dimen.m3_comp_fab_primary_pressed_container_elevation), q.d(), (p) null, false, (of1.e) null, 6, (Function1) null, sVar2, 0, 184);
                    } else {
                        sVar2.f0(-1427539519);
                    }
                    sVar2.r(false);
                } else {
                    sVar2.Z();
                }
                break;
            default:
                tlydtdl.compose.runtime.m mVar3 = (tlydtdl.compose.runtime.m) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                tlydtdl.compose.runtime.s sVar3 = (tlydtdl.compose.runtime.s) mVar3;
                if (sVar3.W(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    if (this.b) {
                        dVar2 = r.Companion;
                        i2 = R.dimen.m3_comp_fab_primary_pressed_container_elevation;
                    } else {
                        dVar2 = r.Companion;
                        i2 = R.dimen.m3_comp_elevated_button_disabled_container_elevation;
                    }
                    uc0.p.a(this.c, (p) null, false, i.u(dVar2, i2), of1.e.d, (String) null, sVar3, 0, 38);
                } else {
                    sVar3.Z();
                }
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ h(x10.v vVar, boolean z) {
        this.a = 2;
        this.c = vVar;
        this.b = z;
    }
}
