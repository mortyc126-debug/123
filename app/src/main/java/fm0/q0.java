package fm0;

import com.bandlab.restutils.UnauthorizedFileService;
import f3.f2;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 {
    public final UnauthorizedFileService a;
    public final b02.d0 b;
    public final File c;

    public q0(b02.d0 d0Var, UnauthorizedFileService unauthorizedFileService, File file) {
        this.a = unauthorizedFileService;
        this.b = d0Var;
        this.c = file;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ci0.c0 r10, sx1.c r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fm0.q0.a(ci0.c0, sx1.c):java.lang.Object");
    }

    public final File b(String str) {
        return new File(new File(this.c, str), f2.C(ci0.o.c(str), ".wav"));
    }
}
