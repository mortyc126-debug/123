package rd1;

import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends com.facebook.appevents.l {
    public static final k0 a = new k0();
    public static final ld1.q b;
    public static final ld1.q c;
    public static final ld1.q d;
    public static final ld1.q e;

    static {
        ld1.d dVar = ld1.r.Companion;
        b = i.u(dVar, R.dimen.m3_comp_fab_primary_large_container_height);
        c = i.u(dVar, 2131100895);
        d = i.u(dVar, R.dimen.abc_list_item_height_large_material);
        e = i.u(dVar, 2131100957);
    }

    public final ld1.r D() {
        return c;
    }

    public final ld1.r E() {
        return d;
    }

    public final ld1.r H() {
        return b;
    }

    public final ld1.r J() {
        return e;
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof k0);
    }

    public final int hashCode() {
        return -505836122;
    }

    public final String toString() {
        return "Overlay";
    }
}
