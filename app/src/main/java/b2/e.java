package b2;

import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.z;
import lx1.b0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ z b;
    public final /* synthetic */ Function1 c;

    public /* synthetic */ e(z zVar, Function1 function1, int i) {
        this.a = i;
        this.b = zVar;
        this.c = function1;
    }

    public final Object invoke(Object obj) {
        int i = this.a;
        float fFloatValue = ((Float) obj).floatValue();
        switch (i) {
            case 0:
                z zVar = this.b;
                float f2 = zVar.a - fFloatValue;
                zVar.a = f2;
                this.c.invoke(Float.valueOf(f2));
                break;
            default:
                z zVar2 = this.b;
                float f3 = zVar2.a - fFloatValue;
                zVar2.a = f3;
                this.c.invoke(Float.valueOf(f3));
                break;
        }
        return b0.a;
    }
}
