package g4;

import a4.d1;
import java.util.ArrayList;
import okhttp3.HttpUrl;
import org.apache.commons.net.bsd.RCommandClient;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final String a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f157f;
    public final int g;
    public final boolean h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f158j;
    public boolean k;

    public e(String str, float f2, float f3, float f4, float f5, long j2, int i, boolean z, int i2) {
        str = (i2 & 1) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str;
        long j3 = (i2 & 32) != 0 ? a4.y.h : j2;
        int i3 = (i2 & 64) != 0 ? 5 : i;
        boolean z2 = (i2 & 128) != 0 ? false : z;
        this.a = str;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f157f = j3;
        this.g = i3;
        this.h = z2;
        ArrayList arrayList = new ArrayList();
        this.i = arrayList;
        d dVar = new d(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, RCommandClient.MAX_CLIENT_PORT);
        this.f158j = dVar;
        arrayList.add(dVar);
    }

    public static void a(e eVar, ArrayList arrayList, d1 d1Var) {
        if (eVar.k) {
            p4.a.b("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
        }
        ((d) o6.c.h(1, eVar.i)).f156j.add(new m0(HttpUrl.FRAGMENT_ENCODE_SET, arrayList, 0, d1Var, 1.0f, null, 1.0f, 1.0f, 0, 2, 1.0f, 0.0f, 1.0f, 0.0f));
    }

    public final f b() {
        if (this.k) {
            p4.a.b("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
        }
        while (true) {
            ArrayList arrayList = this.i;
            if (arrayList.size() <= 1) {
                d dVar = this.f158j;
                f fVar = new f(this.a, this.b, this.c, this.d, this.e, new i0(dVar.a, dVar.b, dVar.c, dVar.d, dVar.e, dVar.f155f, dVar.g, dVar.h, dVar.i, dVar.f156j), this.f157f, this.g, this.h);
                this.k = true;
                return fVar;
            }
            if (this.k) {
                p4.a.b("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
            }
            d dVar2 = (d) arrayList.remove(arrayList.size() - 1);
            ((d) o6.c.h(1, arrayList)).f156j.add(new i0(dVar2.a, dVar2.b, dVar2.c, dVar2.d, dVar2.e, dVar2.f155f, dVar2.g, dVar2.h, dVar2.i, dVar2.f156j));
        }
    }
}
