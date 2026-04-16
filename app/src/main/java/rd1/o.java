package rd1;

import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends s {
    public static final o a = new o();
    public static final ld1.q b;
    public static final ld1.q c;
    public static final ld1.q d;

    static {
        ld1.d dVar = ld1.r.Companion;
        b = i.u(dVar, R.dimen.m3_comp_fab_primary_large_icon_size);
        c = i.u(dVar, R.dimen.m3_comp_fab_primary_large_icon_size);
        d = i.u(dVar, 2131100911);
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
        return this == obj || (obj instanceof o);
    }

    public final int hashCode() {
        return 734659627;
    }

    public final String toString() {
        return "Secondary";
    }
}
