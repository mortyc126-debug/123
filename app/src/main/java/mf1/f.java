package mf1;

import c4.d;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ Function3 a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;

    public /* synthetic */ f(Function3 function3, float f2, float f3) {
        this.a = function3;
        this.b = f2;
        this.c = f3;
    }

    public final Object invoke(Object obj) {
        d dVar = (d) obj;
        o.h(dVar, "$this$drawBehind");
        this.a.invoke(dVar, Float.valueOf(this.b), Float.valueOf(this.c));
        return b0.a;
    }
}
