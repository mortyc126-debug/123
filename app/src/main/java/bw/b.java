package bw;

import d5.d;
import java.util.List;
import lmjxuqdtp.jvm.functions.Function1;
import lx1.b0;
import m2.k1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ List b;
    public final /* synthetic */ long c;

    public /* synthetic */ b(int i, long j2, List list) {
        this.a = i;
        this.b = list;
        this.c = j2;
    }

    public final Object invoke(Object obj) {
        d dVar = (d) obj;
        switch (this.a) {
            case 0:
                lmjxuqdtp.jvm.internal.o.h(dVar, "$this$buildAnnotatedTextRes");
                h02.a.o(dVar, this.b, this.c);
                break;
            default:
                lmjxuqdtp.jvm.internal.o.h(dVar, "$this$buildInlineContentTextRes");
                k1.m(dVar, "ICON_BEAT_PRICE");
                dVar.f(" ");
                h02.a.o(dVar, this.b, this.c);
                break;
        }
        return b0.a;
    }
}
