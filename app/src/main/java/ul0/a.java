package ul0;

import com.bandlab.mixeditor.library.sounds.mysounds.uploads.screen.service.MySoundsUploadsService;
import fy1.l;
import jx0.h;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.v;
import mt.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final /* synthetic */ l[] b;
    public final b a;

    static {
        l vVar = new v(a.class, "service", "getService()Lcom/bandlab/mixeditor/library/sounds/mysounds/uploads/screen/service/MySoundsUploadsService;", 0);
        d0.a.getClass();
        b = new l[]{vVar};
    }

    public a(b bVar) {
        this.a = bVar;
    }

    public final MySoundsUploadsService a() {
        return (MySoundsUploadsService) new h(d0.a(MySoundsUploadsService.class), this.a).t(b[0]);
    }
}
