package zq0;

import d01.i;
import d01.k;
import d10.j;
import fy1.l;
import java.util.List;
import jv0.i0;
import lmjxuqdtp.jvm.internal.d0;
import ny1.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements to0.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ l[] f749f;
    public final ty1.c a = ty1.d.a();
    public String b;
    public final mt.b c;
    public final i d;
    public final h30.g e;

    static {
        l vVar = new lmjxuqdtp.jvm.internal.v(g.class, "service", "getService()Lcom/bandlab/mixeditor/presets/services/ExclusivePresetsService;", 0);
        d0.a.getClass();
        f749f = new l[]{vVar};
    }

    public g(hw.q qVar, l61.u uVar, mt.b bVar, i0 i0Var, k kVar, y10.a aVar) {
        this.c = bVar;
        i iVarA = kVar.a(uVar);
        this.d = iVarA;
        this.e = iVarA.g(aVar);
        z.J(aVar, new j(z.u(((or.q) i0Var).f), qVar.k(jv0.q.g), new zh0.c(this, (qx1.d) null, 1), 9));
    }

    public static so0.n c(wq0.c cVar, List list) {
        String str;
        if (list.isEmpty() || (str = cVar.a) == null) {
            return null;
        }
        return new so0.n(str, cVar.b, list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x02d0, code lost:
    
        if (r5.j(r0, r2) != r3) goto L147;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0208 A[Catch: all -> 0x0044, Exception -> 0x0217, CancellationException -> 0x021c, TryCatch #3 {all -> 0x0044, blocks: (B:16:0x003d, B:108:0x01f7, B:109:0x0202, B:111:0x0208, B:113:0x0212, B:119:0x0220, B:120:0x0222, B:153:0x02d7), top: B:158:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0272 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0273 A[Catch: all -> 0x019d, TryCatch #19 {all -> 0x019d, blocks: (B:135:0x026c, B:140:0x027b, B:146:0x028b, B:143:0x0282, B:148:0x0297, B:138:0x0273, B:83:0x0199, B:67:0x0133, B:69:0x0139, B:73:0x014a, B:76:0x0159, B:102:0x01cf, B:104:0x01e9, B:65:0x0121, B:54:0x00ef, B:58:0x00fc, B:60:0x0103, B:61:0x0105), top: B:172:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0281 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0282 A[Catch: all -> 0x019d, TryCatch #19 {all -> 0x019d, blocks: (B:135:0x026c, B:140:0x027b, B:146:0x028b, B:143:0x0282, B:148:0x0297, B:138:0x0273, B:83:0x0199, B:67:0x0133, B:69:0x0139, B:73:0x014a, B:76:0x0159, B:102:0x01cf, B:104:0x01e9, B:65:0x0121, B:54:0x00ef, B:58:0x00fc, B:60:0x0103, B:61:0x0105), top: B:172:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0199 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0154 -> B:82:0x0197). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x017f -> B:161:0x018a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r20, sx1.c r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 732
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.g.a(java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable b(java.lang.String r11, java.lang.String r12, sx1.c r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof zq0.f
            if (r0 == 0) goto L13
            r0 = r13
            zq0.f r0 = (zq0.f) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            zq0.f r0 = new zq0.f
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            r8 = 0
            if (r2 == 0) goto L30
            if (r2 != r3) goto L28
            lg.e.O(r13)
            goto L4e
        L28:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L30:
            lg.e.O(r13)
            c80.j r4 = new c80.j
            r9 = 27
            r5 = r10
            r6 = r11
            r7 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r11 = 9
            r12 = 50
            com.bandlab.listmanager.pagination.impl.r r11 = ct1.b.r(r12, r12, r11, r4)
            r0.l = r3
            java.lang.Object r13 = aq1.b.I(r11, r0)
            if (r13 != r1) goto L4e
            return r1
        L4e:
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = mx1.p.c0(r13, r12)
            r11.<init>(r12)
            java.util.Iterator r12 = r13.iterator()
        L5f:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L75
            java.lang.Object r13 = r12.next()
            so0.z0 r13 = (so0.z0) r13
            r0 = 7167(0x1bff, float:1.0043E-41)
            so0.z0 r13 = so0.z0.y(r13, r8, r0)
            r11.add(r13)
            goto L5f
        L75:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.g.b(java.lang.String, java.lang.String, sx1.c):java.io.Serializable");
    }
}
