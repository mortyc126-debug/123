package te0;

import amuvvoafs.content.Context;
import com.bandlab.media.player.impl.i;
import lmjxuqdtp.jvm.internal.o;
import q8.f;
import q8.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements f {
    public final Context a;
    public final i b;
    public final f c;

    public b(Context context, i iVar, f fVar) {
        this.a = context;
        this.b = iVar;
        this.c = fVar;
    }

    @Override // q8.f
    public final g a() {
        Context applicationContext = this.a.getApplicationContext();
        o.g(applicationContext, "getApplicationContext(...)");
        return new a(applicationContext, this.b, this.c.a());
    }
}
