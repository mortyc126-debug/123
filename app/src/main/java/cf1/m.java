package cf1;

import com.google.android.material.R;
import ld1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements k {
    public static final m a = new m();
    public static final ld1.q b;
    public static final ld1.q c;
    public static final ld1.q d;

    static {
        d dVar = ld1.r.Companion;
        b = i.u(dVar, R.dimen.m3_comp_fab_primary_large_icon_size);
        c = i.u(dVar, R.dimen.m3_comp_fab_primary_pressed_container_elevation);
        d = i.u(dVar, R.dimen.abc_disabled_alpha_material_dark);
    }

    @Override // cf1.k
    public final ld1.r a() {
        return b;
    }

    @Override // cf1.k
    public final ld1.r b() {
        return c;
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof m);
    }

    public final int hashCode() {
        return -1985748395;
    }

    public final String toString() {
        return "ThumbPrimary";
    }
}
