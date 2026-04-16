package rd1;

import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends s {
    public static final n a = new n();
    public static final ld1.q b;
    public static final ld1.q c;
    public static final ld1.q d;

    static {
        ld1.d dVar = ld1.r.Companion;
        b = i.u(dVar, R.dimen.m3_comp_elevated_card_icon_size);
        c = i.u(dVar, R.dimen.m3_comp_elevated_card_icon_size);
        d = i.u(dVar, 2131100909);
    }

    @Override // rd1.s
    public final ld1.r a() {
        return d;
    }

    @Override // rd1.s
    public final ld1.r c() {
        return c;
    }

    @Override // rd1.s
    public final ld1.r d() {
        return b;
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof n);
    }

    public final int hashCode() {
        return -2136612231;
    }

    public final String toString() {
        return "Primary";
    }
}
