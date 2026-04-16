package s4;

import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends lmjxuqdtp.jvm.internal.p implements Function0 {
    public static final j d = new j(0, 0);
    public static final j e = new j(0, 1);
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(int i, int i2) {
        super(i);
        this.c = i2;
    }

    public final Object invoke() {
        switch (this.c) {
            case 0:
                return new j0(2);
            default:
                return new j0(3);
        }
    }
}
