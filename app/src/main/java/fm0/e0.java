package fm0;

import jw1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements e {
    public static final e0 b = new e0(0);
    public static final e0 c = new e0(1);
    public static final e0 d = new e0(2);
    public final /* synthetic */ int a;

    public /* synthetic */ e0(int i) {
        this.a = i;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return new f0();
            case 1:
                return new n0();
            default:
                return new r0();
        }
    }
}
