package g4;

import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends lmjxuqdtp.jvm.internal.p implements Function0 {
    public static final h d;
    public static final h e;
    public final /* synthetic */ int c;

    static {
        int i = 0;
        d = new h(i, 0);
        e = new h(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(int i, int i2) {
        super(i);
        this.c = i2;
    }

    public final Object invoke() {
        switch (this.c) {
            case 0:
                return o0.f.m();
            default:
                return lx1.b0.a;
        }
    }
}
