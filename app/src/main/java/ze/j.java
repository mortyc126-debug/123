package ze;

import amuvvoafs.graphics.Bitmap;
import amuvvoafs.graphics.ColorSpace;
import amuvvoafs.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static final je.i a = new je.i(0, ff.f.a);
    public static final je.i b = new je.i(0, gf.o.b);
    public static final je.i c = new je.i(0, (Object) null);
    public static final je.i d;
    public static final je.i e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final je.i f736f;
    public static final je.i g;

    static {
        Boolean bool = Boolean.TRUE;
        d = new je.i(0, bool);
        e = new je.i(0, (Object) null);
        f736f = new je.i(0, bool);
        g = new je.i(0, Boolean.FALSE);
    }

    public static final void a(e eVar, int i) {
        eVar.b().a(a, i > 0 ? new ff.b(i) : ff.f.a);
    }

    public static final Bitmap.Config b(m mVar) {
        return (Bitmap.Config) je.o.e(mVar, b);
    }

    public static final ColorSpace c(m mVar) {
        return (ColorSpace) je.o.e(mVar, c);
    }

    public static final void d(e eVar, ImageView imageView) {
        eVar.d = new df.a(imageView);
    }
}
