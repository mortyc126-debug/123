package o6;

import amuvvoafs.net.Uri;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public final Uri a;
    public final int b;
    public final int c;
    public final boolean d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f361f;

    public i(Uri uri, int i, int i2, boolean z, int i3) {
        uri.getClass();
        this.a = uri;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = null;
        this.f361f = i3;
    }

    public i(String str, String str2) {
        this.a = new Uri.Builder().scheme("systemfont").authority(str).build();
        this.b = 0;
        this.c = 400;
        this.d = false;
        this.e = str2;
        this.f361f = 0;
    }
}
