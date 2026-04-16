package rd1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends s {
    public static final b a = new b();
    public static final ld1.q b;
    public static final ld1.q c;
    public static final ld1.q d;

    static {
        ld1.d dVar = ld1.r.Companion;
        b = i.u(dVar, 2131100952);
        c = i.u(dVar, 2131100952);
        d = i.u(dVar, 2131100950);
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
        return this == obj || (obj instanceof b);
    }

    public final int hashCode() {
        return 484727994;
    }

    public final String toString() {
        return "BoostSecondary";
    }
}
