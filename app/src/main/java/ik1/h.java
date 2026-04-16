package ik1;

import com.bandlab.videoprocessor.utils.VideoProcessorException;
import java.util.ArrayList;
import mx1.o;
import qi.r;
import qi.y;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public final y a;

    public h(y yVar) {
        this.a = yVar;
    }

    public final void a(j jVar, Exception exc) {
        ArrayList arrayList = new ArrayList();
        r rVar = new r(arrayList);
        rVar.e("triggered_from", jVar.b());
        rVar.e("source", (exc instanceof VideoProcessorException ? ((VideoProcessorException) exc).a : f.a).toString());
        rVar.e("throwable", exc.toString());
        y.k(this.a, "video_processing_error", o.R0(arrayList, jVar.a().o()), (qi.h) null, 12);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(ik1.j r5, lmjxuqdtp.jvm.functions.Function1 r6, sx1.c r7) throws java.lang.Exception {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ik1.g
            if (r0 == 0) goto L13
            r0 = r7
            ik1.g r0 = (ik1.g) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            ik1.g r0 = new ik1.g
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            ik1.j r5 = r0.j
            lg.e.O(r7)     // Catch: java.lang.Exception -> L29
            goto L41
        L29:
            r6 = move-exception
            goto L6b
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            lg.e.O(r7)
            r0.j = r5     // Catch: java.lang.Exception -> L29
            r0.m = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r7 = r6.invoke(r0)     // Catch: java.lang.Exception -> L29
            if (r7 != r1) goto L41
            return r1
        L41:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Exception -> L29
            r6.<init>()     // Catch: java.lang.Exception -> L29
            qi.r r0 = new qi.r     // Catch: java.lang.Exception -> L29
            r0.<init>(r6)     // Catch: java.lang.Exception -> L29
            java.lang.String r1 = "triggered_from"
            java.lang.String r2 = r5.b()     // Catch: java.lang.Exception -> L29
            r0.e(r1, r2)     // Catch: java.lang.Exception -> L29
            qi.y r0 = r4.a     // Catch: java.lang.Exception -> L29
            java.lang.String r1 = "video_processing_success"
            ik1.a r2 = r5.a()     // Catch: java.lang.Exception -> L29
            java.util.List r2 = r2.o()     // Catch: java.lang.Exception -> L29
            java.util.ArrayList r6 = mx1.o.R0(r6, r2)     // Catch: java.lang.Exception -> L29
            r2 = 0
            r3 = 12
            qi.y.k(r0, r1, r6, r2, r3)     // Catch: java.lang.Exception -> L29
            return r7
        L6b:
            r4.a(r5, r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ik1.h.b(ik1.j, lmjxuqdtp.jvm.functions.Function1, sx1.c):java.lang.Object");
    }
}
