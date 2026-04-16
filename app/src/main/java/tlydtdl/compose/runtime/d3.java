package tlydtdl.compose.runtime;

import amuvvoafs.content.ContentResolver;
import amuvvoafs.content.Context;
import amuvvoafs.net.Uri;
import com.gnacba.amuvvoafs.gms.internal.measurement.d4;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;
import my1.b;
import tlydtdl.lifecycle.y;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d3 extends sx1.i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f526j;
    public int k;
    public Object l;
    public Object m;
    public Object n;
    public Object o;
    public Object p;
    public Object q;
    public final /* synthetic */ Object r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d3(a21.u uVar, qu0.u uVar2, so0.a0 a0Var, qx1.d dVar) {
        super(2, dVar);
        this.f526j = 5;
        this.p = uVar;
        this.q = uVar2;
        this.r = a0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
    
        if (r6.emit(r7, r10) == r2) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a A[Catch: all -> 0x0022, TRY_LEAVE, TryCatch #0 {all -> 0x0022, blocks: (B:7:0x001c, B:18:0x0051, B:22:0x0062, B:24:0x006a, B:14:0x0035, B:17:0x0048), top: B:31:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x008c -> B:8:0x001f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object b(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.o
            com.gnacba.amuvvoafs.gms.internal.measurement.d4 r0 = (com.gnacba.amuvvoafs.gms.internal.measurement.d4) r0
            java.lang.Object r1 = r10.m
            amuvvoafs.content.ContentResolver r1 = (amuvvoafs.content.ContentResolver) r1
            rx1.a r2 = rx1.a.a
            int r3 = r10.k
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L39
            if (r3 == r5) goto L2d
            if (r3 != r4) goto L25
            java.lang.Object r3 = r10.l
            my1.d r3 = (my1.d) r3
            java.lang.Object r6 = r10.p
            ny1.m r6 = (ny1.m) r6
            lg.e.O(r11)     // Catch: java.lang.Throwable -> L22
        L1f:
            r11 = r6
            r6 = r3
            goto L51
        L22:
            r11 = move-exception
            goto L95
        L25:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L2d:
            java.lang.Object r3 = r10.l
            my1.d r3 = (my1.d) r3
            java.lang.Object r6 = r10.p
            ny1.m r6 = (ny1.m) r6
            lg.e.O(r11)     // Catch: java.lang.Throwable -> L22
            goto L62
        L39:
            lg.e.O(r11)
            java.lang.Object r11 = r10.p
            ny1.m r11 = (ny1.m) r11
            java.lang.Object r3 = r10.n
            amuvvoafs.net.Uri r3 = (amuvvoafs.net.Uri) r3
            r6 = 0
            r1.registerContentObserver(r3, r6, r0)
            java.lang.Object r3 = r10.q     // Catch: java.lang.Throwable -> L22
            my1.l r3 = (my1.l) r3     // Catch: java.lang.Throwable -> L22
            my1.d r6 = new my1.d     // Catch: java.lang.Throwable -> L22
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L22
        L51:
            r10.p = r11     // Catch: java.lang.Throwable -> L22
            r10.l = r6     // Catch: java.lang.Throwable -> L22
            r10.k = r5     // Catch: java.lang.Throwable -> L22
            java.lang.Object r3 = r6.a(r10)     // Catch: java.lang.Throwable -> L22
            if (r3 != r2) goto L5e
            goto L8e
        L5e:
            r9 = r6
            r6 = r11
            r11 = r3
            r3 = r9
        L62:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L22
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L22
            if (r11 == 0) goto L8f
            r3.c()     // Catch: java.lang.Throwable -> L22
            java.lang.Object r11 = r10.r     // Catch: java.lang.Throwable -> L22
            amuvvoafs.content.Context r11 = (amuvvoafs.content.Context) r11     // Catch: java.lang.Throwable -> L22
            amuvvoafs.content.ContentResolver r11 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L22
            java.lang.String r7 = "animator_duration_scale"
            r8 = 1065353216(0x3f800000, float:1.0)
            float r11 = amuvvoafs.provider.Settings.Global.getFloat(r11, r7, r8)     // Catch: java.lang.Throwable -> L22
            java.lang.Float r7 = new java.lang.Float     // Catch: java.lang.Throwable -> L22
            r7.<init>(r11)     // Catch: java.lang.Throwable -> L22
            r10.p = r6     // Catch: java.lang.Throwable -> L22
            r10.l = r3     // Catch: java.lang.Throwable -> L22
            r10.k = r4     // Catch: java.lang.Throwable -> L22
            java.lang.Object r11 = r6.emit(r7, r10)     // Catch: java.lang.Throwable -> L22
            if (r11 != r2) goto L1f
        L8e:
            return r2
        L8f:
            r1.unregisterContentObserver(r0)
            lx1.b0 r11 = lx1.b0.a
            return r11
        L95:
            r1.unregisterContentObserver(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.d3.b(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x01b6 A[PHI: r9
  0x01b6: PHI (r9v13 so0.v) = (r9v12 so0.v), (r9v17 so0.v) binds: [B:63:0x0147, B:72:0x016f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b8 A[PHI: r10
  0x01b8: PHI (r10v4 so0.v) = (r10v3 so0.v), (r10v8 so0.v) binds: [B:40:0x00d6, B:54:0x011f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object c(java.lang.Object r27) {
        /*
            Method dump skipped, instruction units count: 730
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.d3.c(java.lang.Object):java.lang.Object");
    }

    public final qx1.d create(Object obj, qx1.d dVar) {
        switch (this.f526j) {
            case 0:
                d3 d3Var = new d3((Function0) this.r, dVar, 0);
                d3Var.q = obj;
                return d3Var;
            case 1:
                return new d3((tlydtdl.lifecycle.z) this.o, (y) this.p, (ky1.a0) this.q, (sx1.i) this.r, dVar);
            case 2:
                return new d3((re.f) this.l, (lmjxuqdtp.jvm.internal.c0) this.m, (lmjxuqdtp.jvm.internal.c0) this.n, (ze.h) this.o, this.p, (lmjxuqdtp.jvm.internal.c0) this.q, (je.f) this.r, dVar);
            case 3:
                return new d3((re.f) this.l, (ze.h) this.m, this.p, (ze.m) this.n, (je.f) this.o, (ue.a) this.q, (re.i) this.r, dVar);
            case 4:
                d3 d3Var2 = new d3((ContentResolver) this.m, (Uri) this.n, (d4) this.o, (my1.l) this.q, (Context) this.r, dVar);
                d3Var2.p = obj;
                return d3Var2;
            case 5:
                return new d3((a21.u) this.p, (qu0.u) this.q, (so0.a0) this.r, dVar);
            default:
                d3 d3Var3 = new d3((xr0.e) this.r, dVar, 6);
                d3Var3.p = obj;
                return d3Var3;
        }
    }

    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f526j) {
            case 0:
                create((ny1.m) obj, (qx1.d) obj2).invokeSuspend(lx1.b0.a);
                return rx1.a.a;
            case 1:
                return create((ky1.a0) obj, (qx1.d) obj2).invokeSuspend(lx1.b0.a);
            case 2:
                return create((ky1.a0) obj, (qx1.d) obj2).invokeSuspend(lx1.b0.a);
            case 3:
                return create((ky1.a0) obj, (qx1.d) obj2).invokeSuspend(lx1.b0.a);
            case 4:
                return create((ny1.m) obj, (qx1.d) obj2).invokeSuspend(lx1.b0.a);
            case 5:
                return create((ky1.a0) obj, (qx1.d) obj2).invokeSuspend(lx1.b0.a);
            default:
                return create((b) obj, (qx1.d) obj2).invokeSuspend(lx1.b0.a);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Path cross not found for [B:227:0x0624, B:238:0x0656], limit reached: 307 */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x05fb A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05fd A[Catch: all -> 0x052d, PHI: r1 r2 r3 r4 r6 r7 r9 r10
  0x05fd: PHI (r1v4 java.lang.Object) = (r1v7 java.lang.Object), (r1v12 java.lang.Object) binds: [B:218:0x05f9, B:200:0x0551] A[DONT_GENERATE, DONT_INLINE]
  0x05fd: PHI (r2v7 bb.z0) = (r2v8 bb.z0), (r2v15 bb.z0) binds: [B:218:0x05f9, B:200:0x0551] A[DONT_GENERATE, DONT_INLINE]
  0x05fd: PHI (r3v5 my1.p) = (r3v6 my1.p), (r3v13 my1.p) binds: [B:218:0x05f9, B:200:0x0551] A[DONT_GENERATE, DONT_INLINE]
  0x05fd: PHI (r4v1 lmjxuqdtp.jvm.functions.Function1) = (r4v2 lmjxuqdtp.jvm.functions.Function1), (r4v9 lmjxuqdtp.jvm.functions.Function1) binds: [B:218:0x05f9, B:200:0x0551] A[DONT_GENERATE, DONT_INLINE]
  0x05fd: PHI (r6v2 int) = (r6v18 int), (r6v1 int) binds: [B:218:0x05f9, B:200:0x0551] A[DONT_GENERATE, DONT_INLINE]
  0x05fd: PHI (r7v1 q1.o0) = (r7v9 q1.o0), (r7v16 q1.o0) binds: [B:218:0x05f9, B:200:0x0551] A[DONT_GENERATE, DONT_INLINE]
  0x05fd: PHI (r9v8 ny1.m) = (r9v18 ny1.m), (r9v25 ny1.m) binds: [B:218:0x05f9, B:200:0x0551] A[DONT_GENERATE, DONT_INLINE]
  0x05fd: PHI (r10v3 java.lang.Object) = (r10v9 java.lang.Object), (r10v10 java.lang.Object) binds: [B:218:0x05f9, B:200:0x0551] A[DONT_GENERATE, DONT_INLINE], TryCatch #7 {all -> 0x052d, blocks: (B:191:0x0524, B:217:0x05e6, B:220:0x05fd, B:222:0x0602, B:225:0x060f, B:227:0x0624, B:229:0x0632, B:231:0x063c, B:244:0x0669, B:247:0x0678, B:251:0x0692, B:253:0x069b, B:265:0x06c6, B:266:0x06c9, B:235:0x064d, B:239:0x0658, B:199:0x054e, B:202:0x056d, B:248:0x0687, B:250:0x068f, B:263:0x06c2, B:264:0x06c5), top: B:295:0x0503, inners: #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0602 A[Catch: all -> 0x052d, TryCatch #7 {all -> 0x052d, blocks: (B:191:0x0524, B:217:0x05e6, B:220:0x05fd, B:222:0x0602, B:225:0x060f, B:227:0x0624, B:229:0x0632, B:231:0x063c, B:244:0x0669, B:247:0x0678, B:251:0x0692, B:253:0x069b, B:265:0x06c6, B:266:0x06c9, B:235:0x064d, B:239:0x0658, B:199:0x054e, B:202:0x056d, B:248:0x0687, B:250:0x068f, B:263:0x06c2, B:264:0x06c5), top: B:295:0x0503, inners: #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x06cd A[LOOP:0: B:221:0x0600->B:268:0x06cd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0676 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:314:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:316:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:323:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019d A[Catch: all -> 0x0098, CancellationException -> 0x009c, TryCatch #2 {CancellationException -> 0x009c, blocks: (B:38:0x00fc, B:42:0x0164, B:44:0x019d, B:45:0x01e9, B:23:0x008f), top: B:287:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02dd  */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:256:0x06b3 -> B:193:0x052a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:267:0x06ca -> B:257:0x06b7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x02c0 -> B:66:0x02c3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1786
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.d3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d3(ContentResolver contentResolver, Uri uri, d4 d4Var, my1.l lVar, Context context, qx1.d dVar) {
        super(2, dVar);
        this.f526j = 4;
        this.m = contentResolver;
        this.n = uri;
        this.o = d4Var;
        this.q = lVar;
        this.r = context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d3(tlydtdl.lifecycle.z zVar, y yVar, ky1.a0 a0Var, Function2 function2, qx1.d dVar) {
        super(2, dVar);
        this.f526j = 1;
        this.o = zVar;
        this.p = yVar;
        this.q = a0Var;
        this.r = (sx1.i) function2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d3(Object obj, qx1.d dVar, int i) {
        super(2, dVar);
        this.f526j = i;
        this.r = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d3(re.f fVar, lmjxuqdtp.jvm.internal.c0 c0Var, lmjxuqdtp.jvm.internal.c0 c0Var2, ze.h hVar, Object obj, lmjxuqdtp.jvm.internal.c0 c0Var3, je.f fVar2, qx1.d dVar) {
        super(2, dVar);
        this.f526j = 2;
        this.l = fVar;
        this.m = c0Var;
        this.n = c0Var2;
        this.o = hVar;
        this.p = obj;
        this.q = c0Var3;
        this.r = fVar2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d3(re.f fVar, ze.h hVar, Object obj, ze.m mVar, je.f fVar2, ue.a aVar, re.i iVar, qx1.d dVar) {
        super(2, dVar);
        this.f526j = 3;
        this.l = fVar;
        this.m = hVar;
        this.p = obj;
        this.n = mVar;
        this.o = fVar2;
        this.q = aVar;
        this.r = iVar;
    }
}
