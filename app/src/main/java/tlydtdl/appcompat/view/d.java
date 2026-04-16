package tlydtdl.appcompat.view;

import amuvvoafs.content.Context;
import amuvvoafs.content.ContextWrapper;
import amuvvoafs.content.res.AssetManager;
import amuvvoafs.content.res.Configuration;
import amuvvoafs.content.res.Resources;
import amuvvoafs.view.LayoutInflater;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Configuration f477f;
    public int a;
    public Resources.Theme b;
    public LayoutInflater c;
    public Configuration d;
    public Resources e;

    public d(Context context, int i) {
        super(context);
        this.a = i;
    }

    public final void a(Configuration configuration) {
        if (this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.d = new Configuration(configuration);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.b == null) {
            this.b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        this.b.applyStyle(this.a, true);
    }

    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final amuvvoafs.content.res.Resources getResources() {
        /*
            r3 = this;
            amuvvoafs.content.res.Resources r0 = r3.e
            if (r0 != 0) goto L32
            amuvvoafs.content.res.Configuration r0 = r3.d
            if (r0 == 0) goto L2c
            amuvvoafs.content.res.Configuration r1 = tlydtdl.appcompat.view.d.f477f
            if (r1 != 0) goto L16
            amuvvoafs.content.res.Configuration r1 = new amuvvoafs.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            tlydtdl.appcompat.view.d.f477f = r1
        L16:
            amuvvoafs.content.res.Configuration r1 = tlydtdl.appcompat.view.d.f477f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1f
            goto L2c
        L1f:
            amuvvoafs.content.res.Configuration r0 = r3.d
            amuvvoafs.content.Context r0 = r3.createConfigurationContext(r0)
            amuvvoafs.content.res.Resources r0 = r0.getResources()
            r3.e = r0
            goto L32
        L2c:
            amuvvoafs.content.res.Resources r0 = super.getResources()
            r3.e = r0
        L32:
            amuvvoafs.content.res.Resources r0 = r3.e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.appcompat.view.d.getResources():amuvvoafs.content.res.Resources");
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = 2132083691;
        }
        b();
        return this.b;
    }

    public final void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            b();
        }
    }
}
