package q8;

import amuvvoafs.content.Context;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements f {
    public final Context a;
    public final f b;

    public m(Context context) {
        this(context, new o());
    }

    @Override // q8.f
    public final g a() {
        return new n(this.a, this.b.a());
    }

    public m(Context context, f fVar) {
        this.a = context.getApplicationContext();
        fVar.getClass();
        this.b = fVar;
    }
}
