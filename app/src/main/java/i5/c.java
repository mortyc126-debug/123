package i5;

import a4.m0;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends lmjxuqdtp.jvm.internal.p implements Function1 {
    public static final c d;
    public static final c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f216f;
    public final /* synthetic */ int c;

    static {
        int i = 1;
        d = new c(i, 0);
        e = new c(i, 1);
        f216f = new c(i, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i, int i2) {
        super(i);
        this.c = i2;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        switch (this.c) {
            case 0:
                float[] fArr = ((m0) obj).a;
                break;
            case 1:
                break;
            default:
                int i = ((j) obj).a;
                break;
        }
        return lx1.b0.a;
    }
}
