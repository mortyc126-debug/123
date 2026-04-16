package tlydtdl.core.app;

import amuvvoafs.app.Notification;
import amuvvoafs.app.NotificationChannel;
import amuvvoafs.media.AudioAttributes;
import amuvvoafs.net.Uri;
import amuvvoafs.os.Build;
import amuvvoafs.provider.Settings;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public final String a;
    public CharSequence b;
    public final int c;
    public String d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f558f;
    public Uri g;
    public AudioAttributes h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f559j;
    public boolean k;
    public long[] l;
    public String m;
    public String n;

    public k(String str, int i) {
        this.f558f = true;
        this.g = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.f559j = 0;
        str.getClass();
        this.a = str;
        this.c = i;
        this.h = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public final NotificationChannel a() {
        String str;
        String str2;
        int i = Build.VERSION.SDK_INT;
        NotificationChannel notificationChannel = new NotificationChannel(this.a, this.b, this.c);
        notificationChannel.setDescription(this.d);
        notificationChannel.setGroup(this.e);
        notificationChannel.setShowBadge(this.f558f);
        notificationChannel.setSound(this.g, this.h);
        notificationChannel.enableLights(this.i);
        notificationChannel.setLightColor(this.f559j);
        notificationChannel.setVibrationPattern(this.l);
        notificationChannel.enableVibration(this.k);
        if (i >= 30 && (str = this.m) != null && (str2 = this.n) != null) {
            j.d(notificationChannel, str, str2);
        }
        return notificationChannel;
    }

    public final fp1.i b() {
        fp1.i iVar = new fp1.i(this.a, this.c);
        iVar.V(this.b);
        iVar.R(this.d);
        iVar.S(this.e);
        iVar.W(this.f558f);
        iVar.X(this.g, this.h);
        iVar.U(this.i);
        iVar.T(this.f559j);
        iVar.Y(this.k);
        iVar.Z(this.l);
        iVar.Q(this.m, this.n);
        return iVar;
    }

    public k(NotificationChannel notificationChannel) {
        this(notificationChannel.getId(), notificationChannel.getImportance());
        this.b = notificationChannel.getName();
        this.d = notificationChannel.getDescription();
        this.e = notificationChannel.getGroup();
        this.f558f = notificationChannel.canShowBadge();
        this.g = notificationChannel.getSound();
        this.h = notificationChannel.getAudioAttributes();
        this.i = notificationChannel.shouldShowLights();
        this.f559j = notificationChannel.getLightColor();
        this.k = notificationChannel.shouldVibrate();
        this.l = notificationChannel.getVibrationPattern();
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.m = j.b(notificationChannel);
            this.n = j.a(notificationChannel);
        }
        notificationChannel.canBypassDnd();
        notificationChannel.getLockscreenVisibility();
        if (i >= 29) {
            i.a(notificationChannel);
        }
        if (i >= 30) {
            j.c(notificationChannel);
        }
    }
}
