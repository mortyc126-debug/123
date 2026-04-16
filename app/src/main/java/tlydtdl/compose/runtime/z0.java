package tlydtdl.compose.runtime;

import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ z0(int i, Function1 function1) {
        this.a = i;
        this.b = function1;
    }

    public final Object invoke(Object obj) {
        long j2;
        switch (this.a) {
            case 0:
                return this.b.invoke(Long.valueOf(((Number) obj).longValue() / 1000000));
            default:
                s3.j jVar = (s3.j) obj;
                synchronized (s3.l.c) {
                    j2 = s3.l.e;
                    s3.l.e = ((long) 1) + j2;
                }
                return new s3.e(j2, jVar, this.b);
        }
    }
}
