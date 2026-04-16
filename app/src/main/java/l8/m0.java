package l8;

import amuvvoafs.net.Uri;
import amuvvoafs.os.Bundle;
import com.gnacba.common.collect.f1;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {
    public CharSequence A;
    public Integer B;
    public Integer C;
    public CharSequence D;
    public CharSequence E;
    public CharSequence F;
    public Integer G;
    public Bundle H;
    public com.gnacba.common.collect.k0 I;
    public CharSequence a;
    public CharSequence b;
    public CharSequence c;
    public CharSequence d;
    public CharSequence e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f302f;
    public CharSequence g;
    public Long h;
    public b1 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b1 f303j;
    public byte[] k;
    public Integer l;
    public Uri m;
    public Integer n;
    public Integer o;
    public Integer p;
    public Boolean q;
    public Boolean r;
    public Integer s;
    public Integer t;
    public Integer u;
    public Integer v;
    public Integer w;
    public Integer x;
    public CharSequence y;
    public CharSequence z;

    public m0() {
        com.gnacba.common.collect.h0 h0Var = com.gnacba.common.collect.k0.b;
        this.I = f1.e;
    }

    public final void a(int i, byte[] bArr) {
        if (this.k == null || i == 3 || !Objects.equals(this.l, 3)) {
            this.k = (byte[]) bArr.clone();
            this.l = Integer.valueOf(i);
        }
    }

    public final void b(byte[] bArr, Integer num) {
        this.k = bArr == null ? null : (byte[]) bArr.clone();
        this.l = num;
    }

    public final void c(Long l) {
        o8.b.c(l == null || l.longValue() >= 0);
        this.h = l;
    }
}
