package tlydtdl.core.app;

import amuvvoafs.app.Notification;
import amuvvoafs.app.PendingIntent;
import amuvvoafs.content.Context;
import amuvvoafs.graphics.Bitmap;
import amuvvoafs.graphics.drawable.Icon;
import amuvvoafs.os.Bundle;
import amuvvoafs.widget.RemoteViews;
import java.util.ArrayList;
import tlydtdl.core.graphics.drawable.IconCompat;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t {
    public Notification A;
    public RemoteViews B;
    public RemoteViews C;
    public String D;
    public String F;
    public final boolean G;
    public final Notification H;
    public Icon I;
    public final ArrayList J;
    public final Context a;
    public CharSequence e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f563f;
    public PendingIntent g;
    public IconCompat h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f564j;
    public boolean l;
    public e0 m;
    public CharSequence n;
    public int o;
    public int p;
    public boolean q;
    public String r;
    public boolean s;
    public boolean u;
    public boolean v;
    public String w;
    public Bundle x;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public boolean k = true;
    public boolean t = false;
    public int y = 0;
    public int z = 0;
    public int E = 0;

    public t(Context context, String str) {
        Notification notification = new Notification();
        this.H = notification;
        this.a = context;
        this.D = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f564j = 0;
        this.J = new ArrayList();
        this.G = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification a() {
        Bundle bundle;
        RemoteViews remoteViewsMakeHeadsUpContentView;
        RemoteViews remoteViewsMakeBigContentView;
        i0 i0Var = new i0(this);
        t tVar = i0Var.c;
        e0 e0Var = tVar.m;
        if (e0Var != null) {
            e0Var.apply(i0Var);
        }
        RemoteViews remoteViewsMakeContentView = e0Var != null ? e0Var.makeContentView(i0Var) : null;
        Notification notificationBuild = i0Var.b.build();
        if (remoteViewsMakeContentView != null) {
            notificationBuild.contentView = remoteViewsMakeContentView;
        } else {
            RemoteViews remoteViews = tVar.B;
            if (remoteViews != null) {
                notificationBuild.contentView = remoteViews;
            }
        }
        if (e0Var != null && (remoteViewsMakeBigContentView = e0Var.makeBigContentView(i0Var)) != null) {
            notificationBuild.bigContentView = remoteViewsMakeBigContentView;
        }
        if (e0Var != null && (remoteViewsMakeHeadsUpContentView = tVar.m.makeHeadsUpContentView(i0Var)) != null) {
            notificationBuild.headsUpContentView = remoteViewsMakeHeadsUpContentView;
        }
        if (e0Var != null && (bundle = notificationBuild.extras) != null) {
            e0Var.addCompatExtras(bundle);
        }
        return notificationBuild;
    }

    public final void c(int i) {
        Notification notification = this.H;
        notification.defaults = i;
        if ((i & 4) != 0) {
            notification.flags |= 1;
        }
    }

    public final void d(int i, boolean z) {
        Notification notification = this.H;
        if (z) {
            notification.flags = i | notification.flags;
        } else {
            notification.flags = (~i) & notification.flags;
        }
    }

    public final void e(Bitmap bitmap) {
        this.h = bitmap == null ? null : IconCompat.a(bitmap);
    }

    public final void f(e0 e0Var) {
        if (this.m != e0Var) {
            this.m = e0Var;
            if (e0Var != null) {
                e0Var.setBuilder(this);
            }
        }
    }
}
