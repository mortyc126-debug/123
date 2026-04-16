package cf1;

import a2.j1;
import com.bandlab.global.player.ui.internal.f;
import com.bandlab.global.player.ui.internal.h;
import dn0.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements j1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ z(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final void a(float f2) {
        switch (this.a) {
            case 0:
                ((b0) this.b).b(f2);
                break;
            case 1:
                h hVar = (h) this.b;
                f.a((f) hVar.o, hVar.i(f2));
                break;
            case 2:
                h hVar2 = (h) this.b;
                com.bandlab.uikit.compose.bottomsheet.r.a((com.bandlab.uikit.compose.bottomsheet.r) hVar2.o, hVar2.h(f2));
                break;
            default:
                ((b) this.b).a.invoke(Float.valueOf(f2));
                break;
        }
    }
}
