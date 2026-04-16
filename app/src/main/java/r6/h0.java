package r6;

import amuvvoafs.text.TextUtils;
import amuvvoafs.view.View;
import tlydtdl.emoji2.text.flatbuffer.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends c {
    @Override // tlydtdl.emoji2.text.flatbuffer.c
    public final Object c(View view) {
        return p0.a(view);
    }

    @Override // tlydtdl.emoji2.text.flatbuffer.c
    public final void d(View view, Object obj) {
        p0.e(view, (CharSequence) obj);
    }

    @Override // tlydtdl.emoji2.text.flatbuffer.c
    public final boolean g(Object obj, Object obj2) {
        return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
    }
}
