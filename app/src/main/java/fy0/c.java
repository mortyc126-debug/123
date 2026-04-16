package fy0;

import ct1.b;
import lmjxuqdtp.jvm.internal.o;
import m8.d;
import qi.c0;
import qi.h;
import qi.y;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final y a;

    public c(y yVar) {
        this.a = yVar;
    }

    public final void a(String str, String str2) {
        o.h(str, "id");
        y.k(this.a, "collection_track_play", b.C(new c0[]{new c0("item_name", str), new c0("collection_name", str2)}), (h) null, 12);
    }

    public final void b(a aVar) {
        y.k(this.a, "playlist_create", d.o(new f40.c(16, aVar)), h.c, 8);
    }

    public final void c(String str) {
        o.h(str, "collectionId");
        y.k(this.a, "collection_play", b.B(new c0("collection_id", str)), (h) null, 12);
    }
}
