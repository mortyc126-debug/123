package g4;

import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final String a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f155f;
    public final float g;
    public final float h;
    public final List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f156j;

    public d(String str, float f2, float f3, float f4, float f5, float f7, float f8, float f9, List list, int i) {
        str = (i & 1) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str;
        f2 = (i & 2) != 0 ? 0.0f : f2;
        f3 = (i & 4) != 0 ? 0.0f : f3;
        f4 = (i & 8) != 0 ? 0.0f : f4;
        f5 = (i & 16) != 0 ? 1.0f : f5;
        f7 = (i & 32) != 0 ? 1.0f : f7;
        f8 = (i & 64) != 0 ? 0.0f : f8;
        f9 = (i & 128) != 0 ? 0.0f : f9;
        if ((i & 256) != 0) {
            int i2 = j0.a;
            list = mx1.t.a;
        }
        ArrayList arrayList = new ArrayList();
        this.a = str;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f155f = f7;
        this.g = f8;
        this.h = f9;
        this.i = list;
        this.f156j = arrayList;
    }
}
