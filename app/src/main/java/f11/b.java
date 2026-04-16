package f11;

import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import com.bandlab.quickupload.QuickUploadActivity;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import xu0.x;
import y11.l1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends x {
    public static final b a = new b();
    public static final wy1.a b = l1.Companion.serializer();

    public final Intent a(Context context, Object obj) {
        o.h((b0) obj, "input");
        return new Intent(context, QuickUploadActivity.class);
    }

    public final wy1.a d() {
        return b;
    }
}
