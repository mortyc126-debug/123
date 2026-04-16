package g10;

import amuvvoafs.os.Build;
import amuvvoafs.view.Window;
import bb.w;
import bh.j;
import com.bandlab.bandlab.utils.debug.TaggedException;
import java.util.ArrayList;
import lmjxuqdtp.jvm.functions.Function0;
import lx1.b0;
import r6.a2;
import r6.b2;
import r6.c2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Window b;

    public /* synthetic */ d(Window window, int i) {
        this.a = i;
        this.b = window;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                Window window = this.b;
                m80.b bVar = new m80.b(window.getDecorView());
                int i = Build.VERSION.SDK_INT;
                try {
                    (i >= 35 ? new c2(window, bVar) : i >= 30 ? new b2(window, bVar) : new a2(window, bVar)).r0(2);
                } catch (IllegalStateException e) {
                    w wVar = new w(2);
                    ArrayList arrayList = wVar.a;
                    wVar.a("CRITICAL");
                    wVar.e(new String[0]);
                    j.w("Cannot show navigation bar", new TaggedException(e, (String[]) arrayList.toArray(new String[arrayList.size()])));
                }
                break;
            default:
                g6.e.c(this.b);
                break;
        }
        return b0.a;
    }
}
