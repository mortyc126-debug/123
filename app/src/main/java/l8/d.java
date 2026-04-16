package l8;

import amuvvoafs.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final d g = new d(0, 0, 1, 1, 0);
    public static final String h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f285j;
    public static final String k;
    public static final String l;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f0.d f286f;

    static {
        int i2 = o8.f0.a;
        h = Integer.toString(0, 36);
        i = Integer.toString(1, 36);
        f285j = Integer.toString(2, 36);
        k = Integer.toString(3, 36);
        l = Integer.toString(4, 36);
    }

    public d(int i2, int i3, int i4, int i6, int i7) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i6;
        this.e = i7;
    }

    public static d a(Bundle bundle) {
        String str = h;
        int i2 = bundle.containsKey(str) ? bundle.getInt(str) : 0;
        String str2 = i;
        int i3 = bundle.containsKey(str2) ? bundle.getInt(str2) : 0;
        String str3 = f285j;
        int i4 = bundle.containsKey(str3) ? bundle.getInt(str3) : 1;
        String str4 = k;
        int i6 = bundle.containsKey(str4) ? bundle.getInt(str4) : 1;
        String str5 = l;
        return new d(i2, i3, i4, i6, bundle.containsKey(str5) ? bundle.getInt(str5) : 0);
    }

    public final f0.d b() {
        if (this.f286f == null) {
            this.f286f = new f0.d(this);
        }
        return this.f286f;
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(h, this.a);
        bundle.putInt(i, this.b);
        bundle.putInt(f285j, this.c);
        bundle.putInt(k, this.d);
        bundle.putInt(l, this.e);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.a == dVar.a && this.b == dVar.b && this.c == dVar.c && this.d == dVar.d && this.e == dVar.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((527 + this.a) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }
}
