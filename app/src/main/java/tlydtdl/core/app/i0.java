package tlydtdl.core.app;

import a3.f1;
import amuvvoafs.app.Notification;
import amuvvoafs.app.PendingIntent;
import amuvvoafs.app.RemoteInput;
import amuvvoafs.content.Context;
import amuvvoafs.graphics.drawable.Icon;
import amuvvoafs.net.Uri;
import amuvvoafs.os.Build;
import amuvvoafs.os.Bundle;
import amuvvoafs.text.TextUtils;
import amuvvoafs.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import okhttp3.HttpUrl;
import q1.g;
import sl0.z;
import tlydtdl.core.graphics.drawable.IconCompat;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 implements h {
    public final Context a;
    public final Notification.Builder b;
    public final t c;
    public final Bundle d;

    public i0(t tVar) {
        ArrayList arrayList;
        new ArrayList();
        this.d = new Bundle();
        this.c = tVar;
        Context context = tVar.a;
        ArrayList arrayList2 = tVar.J;
        ArrayList<r0> arrayList3 = tVar.c;
        ArrayList arrayList4 = tVar.d;
        this.a = context;
        Notification.Builder builder = new Notification.Builder(context, tVar.D);
        this.b = builder;
        Notification notification = tVar.H;
        Icon icon = null;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, (RemoteViews) null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(tVar.e).setContentText(tVar.f563f).setContentInfo((CharSequence) null).setContentIntent(tVar.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent((PendingIntent) null, (notification.flags & 128) != 0).setNumber(tVar.i).setProgress(tVar.o, tVar.p, tVar.q);
        IconCompat iconCompat = tVar.h;
        builder.setLargeIcon(iconCompat == null ? null : iconCompat.g(context));
        builder.setSubText(tVar.n).setUsesChronometer(tVar.l).setPriority(tVar.f564j);
        for (n nVar : tVar.b) {
            IconCompat iconCompatA = nVar.a();
            boolean z = nVar.d;
            Bundle bundle = nVar.a;
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCompatA != null ? iconCompatA.g(icon) : icon, nVar.g, nVar.h);
            t0[] t0VarArr = nVar.c;
            if (t0VarArr != null) {
                for (RemoteInput remoteInput : t0.a(t0VarArr)) {
                    builder2.addRemoteInput(remoteInput);
                }
            }
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putBoolean("amuvvoafs.support.allowGeneratedReplies", z);
            int i = Build.VERSION.SDK_INT;
            builder2.setAllowGeneratedReplies(z);
            bundle2.putInt("amuvvoafs.support.action.semanticAction", 0);
            if (i >= 28) {
                f0.b(builder2);
            }
            if (i >= 29) {
                i.d(builder2);
            }
            if (i >= 31) {
                g0.a(builder2);
            }
            bundle2.putBoolean("amuvvoafs.support.action.showsUserInterface", nVar.e);
            builder2.addExtras(bundle2);
            this.b.addAction(builder2.build());
            icon = null;
        }
        Bundle bundle3 = tVar.x;
        if (bundle3 != null) {
            this.d.putAll(bundle3);
        }
        int i2 = Build.VERSION.SDK_INT;
        this.b.setShowWhen(tVar.k);
        this.b.setLocalOnly(tVar.t);
        this.b.setGroup(tVar.r);
        this.b.setSortKey((String) null);
        this.b.setGroupSummary(tVar.s);
        this.b.setCategory(tVar.w);
        this.b.setColor(tVar.y);
        this.b.setVisibility(tVar.z);
        this.b.setPublicVersion(tVar.A);
        this.b.setSound(notification.sound, notification.audioAttributes);
        if (i2 < 28) {
            if (arrayList3 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList3.size());
                for (r0 r0Var : arrayList3) {
                    CharSequence charSequence = r0Var.a;
                    String str = r0Var.c;
                    if (str == null) {
                        str = charSequence != null ? "name:" + ((Object) charSequence) : HttpUrl.FRAGMENT_ENCODE_SET;
                    }
                    arrayList.add(str);
                }
            }
            if (arrayList != null) {
                if (arrayList2 == null) {
                    arrayList2 = arrayList;
                } else {
                    g gVar = new g(arrayList2.size() + arrayList.size());
                    gVar.addAll(arrayList);
                    gVar.addAll(arrayList2);
                    arrayList2 = new ArrayList((Collection) gVar);
                }
            }
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                this.b.addPerson((String) it.next());
            }
        }
        if (arrayList4.size() > 0) {
            if (tVar.x == null) {
                tVar.x = new Bundle();
            }
            Bundle bundle4 = tVar.x.getBundle("amuvvoafs.car.EXTENSIONS");
            bundle4 = bundle4 == null ? new Bundle() : bundle4;
            Bundle bundle5 = new Bundle(bundle4);
            Bundle bundle6 = new Bundle();
            for (int i3 = 0; i3 < arrayList4.size(); i3++) {
                bundle6.putBundle(Integer.toString(i3), z.D((n) arrayList4.get(i3)));
            }
            bundle4.putBundle("invisible_actions", bundle6);
            bundle5.putBundle("invisible_actions", bundle6);
            if (tVar.x == null) {
                tVar.x = new Bundle();
            }
            tVar.x.putBundle("amuvvoafs.car.EXTENSIONS", bundle4);
            this.d.putBundle("amuvvoafs.car.EXTENSIONS", bundle5);
        }
        int i4 = Build.VERSION.SDK_INT;
        Icon icon2 = tVar.I;
        if (icon2 != null) {
            this.b.setSmallIcon(icon2);
        }
        this.b.setExtras(tVar.x);
        this.b.setRemoteInputHistory((CharSequence[]) null);
        RemoteViews remoteViews = tVar.B;
        if (remoteViews != null) {
            this.b.setCustomContentView(remoteViews);
        }
        RemoteViews remoteViews2 = tVar.C;
        if (remoteViews2 != null) {
            this.b.setCustomBigContentView(remoteViews2);
        }
        this.b.setBadgeIconType(tVar.E);
        this.b.setSettingsText((CharSequence) null);
        this.b.setShortcutId(tVar.F);
        this.b.setTimeoutAfter(0L);
        this.b.setGroupAlertBehavior(0);
        if (tVar.v) {
            this.b.setColorized(tVar.u);
        }
        if (!TextUtils.isEmpty(tVar.D)) {
            this.b.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
        }
        if (i4 >= 28) {
            for (r0 r0Var2 : arrayList3) {
                Notification.Builder builder3 = this.b;
                r0Var2.getClass();
                f0.a(builder3, f1.H(r0Var2));
            }
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            i.b(this.b, tVar.G);
            i.c(this.b);
        }
        if (i6 >= 36) {
            h0.h(this.b);
        }
    }
}
