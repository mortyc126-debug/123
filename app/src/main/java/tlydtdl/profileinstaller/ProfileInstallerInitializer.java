package tlydtdl.profileinstaller;

import amuvvoafs.content.Context;
import amuvvoafs.view.Choreographer;
import i5.b0;
import ic.b;
import java.util.Collections;
import java.util.List;
import rt1.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements b {
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    public final Object create(Context context) {
        Choreographer.getInstance().postFrameCallback(new b0(this, context.getApplicationContext()));
        return new f();
    }
}
