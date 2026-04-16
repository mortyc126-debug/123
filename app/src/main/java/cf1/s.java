package cf1;

import com.google.android.material.R;
import ld1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements q {
    public static final s a = new s();
    public static final ld1.q b;
    public static final ld1.q c;
    public static final ld1.q d;
    public static final ld1.q e;

    static {
        d dVar = ld1.r.Companion;
        b = i.u(dVar, R.dimen.abc_disabled_alpha_material_dark);
        c = i.u(dVar, R.dimen.abc_dropdownitem_text_padding_right);
        d = i.u(dVar, R.dimen.abc_dropdownitem_text_padding_right);
        e = i.u(dVar, R.dimen.abc_dropdownitem_text_padding_right);
    }

    @Override // cf1.q
    public final ld1.r a() {
        return d;
    }

    @Override // cf1.q
    public final ld1.r b() {
        return c;
    }

    @Override // cf1.q
    public final ld1.r c() {
        return e;
    }

    @Override // cf1.q
    public final ld1.r d() {
        return b;
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof s);
    }

    public final int hashCode() {
        return 554976576;
    }

    public final String toString() {
        return "TrackPrimary";
    }
}
