package vd0;

import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import com.bandlab.media.chooser.dialog.screen.MediaChooserDialogActivity;
import lmjxuqdtp.jvm.internal.o;
import td0.c;
import td0.i;
import xu0.x;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends x {
    public static final b a = new b();
    public static final wy1.a b = i.Companion.serializer();

    public final Intent a(Context context, Object obj) {
        c cVar = (c) obj;
        o.h(cVar, "input");
        MediaChooserDialogActivity.m.getClass();
        return f.b(context, cVar);
    }

    public final wy1.a d() {
        return b;
    }
}
