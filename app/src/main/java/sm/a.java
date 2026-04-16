package sm;

import amuvvoafs.view.View;
import com.bandlab.bandlab.feature.mixeditor.MixEditorActivity;
import com.ironsource.adqualitysdk.sdk.i.a0;
import dr0.c;
import dr0.g;
import ek.e;
import i5.w;
import ky1.f1;
import l20.k;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import my1.y;
import ny1.m;
import ny1.p2;
import ny1.y1;
import qx1.d;
import sx1.i;
import t4.b2;
import t4.h2;
import t4.t0;
import t5.c0;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.g2;
import tlydtdl.compose.runtime.k1;
import u70.j;
import uc0.h;
import uo0.q;
import uq0.g0;
import uq0.l;
import vb.i0;
import vy0.f;
import w2.c1;
import w2.r0;
import x10.v;
import xu1.e0;
import xu1.n;
import xu1.q0;
import xu1.v0;
import yr.d1;
import yr.m0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f473j;
    public int k;
    public Object l;
    public final /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, Object obj2, d dVar, int i) {
        super(2, dVar);
        this.f473j = i;
        this.l = obj;
        this.m = obj2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    private final Object b(Object obj) throws NoWhenBranchMatchedException {
        r70.a aVar = (r70.a) this.m;
        g gVar = (g) aVar.d;
        e eVar = (e) this.l;
        rx1.a aVar2 = rx1.a.a;
        int i = this.k;
        if (i == 0) {
            lg.e.O(obj);
            ek.b bVarB = eVar.b();
            if (bVarB instanceof ek.b) {
                if (bVarB.a()) {
                    gVar.b(new c(a0.v(v.Companion, 2132018940), new f(29, aVar, eVar), (Function0) null, (Function0) null, 12));
                } else {
                    String strB = eVar.a().b();
                    this.l = null;
                    this.k = 1;
                    if (r70.a.b(aVar, strB, this) == aVar2) {
                        return aVar2;
                    }
                }
            } else {
                if (!o.c(bVarB, ek.c.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                x10.c cVar = v.Companion;
                String[] strArr = {String.valueOf(eVar.a().a() + 1)};
                cVar.getClass();
                gVar.b(new dr0.e(x10.c.g(strArr, 2132018941), -1.0f, (Function0) null));
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lg.e.O(obj);
        }
        return b0.a;
    }

    public final d create(Object obj, d dVar) {
        switch (this.f473j) {
            case 0:
                a aVar = new a((aq1.c) this.m, dVar, 0);
                aVar.l = obj;
                return aVar;
            case 1:
                a aVar2 = new a((t0) this.m, dVar, 1);
                aVar2.l = obj;
                return aVar2;
            case 2:
                return new a((g2) this.l, (View) this.m, dVar, 2);
            case 3:
                return new a((p2) this.l, (h2) this.m, dVar, 3);
            case 4:
                a aVar3 = new a((c0) this.m, dVar, 4);
                aVar3.l = obj;
                return aVar3;
            case 5:
                return new a((tf.c) this.m, dVar, 5);
            case 6:
                return new a((e1) this.l, (Function1) this.m, dVar, 6);
            case 7:
                return new a((f2.a0) this.l, (e1) this.m, dVar, 7);
            case 8:
                a aVar4 = new a((j) this.m, dVar, 8);
                aVar4.l = obj;
                return aVar4;
            case 9:
                return new a((h) this.m, dVar, 9);
            case 10:
                return new a((k1) this.l, (k1) this.m, dVar, 10);
            case 11:
                a aVar5 = new a((q) this.m, dVar, 11);
                aVar5.l = obj;
                return aVar5;
            case 12:
                a aVar6 = new a((l) this.m, dVar, 12);
                aVar6.l = obj;
                return aVar6;
            case 13:
                a aVar7 = new a((g0) this.m, dVar, 13);
                aVar7.l = obj;
                return aVar7;
            case 14:
                return new a((MixEditorActivity) this.l, (ur.b) this.m, dVar, 14);
            case 15:
                return new a((uu0.b) this.l, (uu0.a) this.m, dVar, 15);
            case 16:
                return new a((i0) this.l, (Function0) this.m, dVar, 16);
            case 17:
                return new a((c1) this.l, (w2.j) this.m, dVar, 17);
            case 18:
                return new a((y1) this.l, (w2.j) this.m, dVar, 18);
            case 19:
                return new a((f1) this.l, (w2.o) this.m, dVar, 19);
            case 20:
                a aVar8 = new a((r0) this.m, dVar, 20);
                aVar8.l = obj;
                return aVar8;
            case 21:
                a aVar9 = new a((lmjxuqdtp.jvm.internal.c0) this.l, (Function2) this.m, dVar);
                aVar9.k = ((Number) obj).intValue();
                return aVar9;
            case 22:
                a aVar10 = new a((x2.h) this.m, dVar, 22);
                aVar10.l = obj;
                return aVar10;
            case 23:
                return new a((n) this.l, (q0) this.m, dVar, 23);
            case 24:
                return new a((v0) this.l, (e0) this.m, dVar, 24);
            case 25:
                return new a((xz0.b0) this.l, (e1) this.m, dVar, 25);
            case 26:
                a aVar11 = new a((ym0.j) this.m, dVar, 26);
                aVar11.l = obj;
                return aVar11;
            case 27:
                a aVar12 = new a((m0) this.m, dVar, 27);
                aVar12.l = obj;
                return aVar12;
            case 28:
                a aVar13 = new a((r70.a) this.m, dVar, 28);
                aVar13.l = obj;
                return aVar13;
            default:
                a aVar14 = new a((d1) this.m, dVar, 29);
                aVar14.l = obj;
                return aVar14;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        switch (this.f473j) {
            case 0:
                return create((y) obj, (d) obj2).invokeSuspend(b0.a);
            case 1:
                create((b2) obj, (d) obj2).invokeSuspend(b0.a);
                return rx1.a.a;
            case 2:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 3:
                create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
                return rx1.a.a;
            case 4:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 5:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 6:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 7:
                return create((b0) obj, (d) obj2).invokeSuspend(b0.a);
            case 8:
                return create((k) obj, (d) obj2).invokeSuspend(b0.a);
            case 9:
                return create((b0) obj, (d) obj2).invokeSuspend(b0.a);
            case 10:
                create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
                return rx1.a.a;
            case 11:
                return create((m) obj, (d) obj2).invokeSuspend(b0.a);
            case 12:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 13:
                return create((to0.f) obj, (d) obj2).invokeSuspend(b0.a);
            case 14:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 15:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 16:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 17:
                create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
                return rx1.a.a;
            case 18:
                create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
                return rx1.a.a;
            case 19:
                create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
                return rx1.a.a;
            case 20:
                create((t0) obj, (d) obj2).invokeSuspend(b0.a);
                return rx1.a.a;
            case 21:
                a aVarCreate = create(Integer.valueOf(((Number) obj).intValue()), (d) obj2);
                b0 b0Var = b0.a;
                aVarCreate.invokeSuspend(b0Var);
                return b0Var;
            case 22:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 23:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 24:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 25:
                return create((ky1.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 26:
                return create((w) obj, (d) obj2).invokeSuspend(b0.a);
            case 27:
                return create((yr.a0) obj, (d) obj2).invokeSuspend(b0.a);
            case 28:
                return create((e) obj, (d) obj2).invokeSuspend(b0.a);
            default:
                return create((uo0.c) obj, (d) obj2).invokeSuspend(b0.a);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:508:0x09bf, B:510:0x09c3], limit reached: 626 */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0793 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:427:0x084d  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0903  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x090d  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0986  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x09cd A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:638:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:644:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r13v29, types: [tlydtdl.compose.runtime.e1] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v31, types: [int] */
    /* JADX WARN: Type inference failed for: r6v32, types: [a2.c1, lmjxuqdtp.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:163:0x0350 -> B:165:0x0353). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:374:0x0791 -> B:376:0x0794). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:461:0x0901 -> B:463:0x0905). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:504:0x09a5 -> B:506:0x09a9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws lmjxuqdtp.NoWhenBranchMatchedException, lmjxuqdtp.KotlinNothingValueException {
        /*
            Method dump skipped, instruction units count: 2880
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sm.a.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, d dVar, int i) {
        super(2, dVar);
        this.f473j = i;
        this.m = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(lmjxuqdtp.jvm.internal.c0 c0Var, Function2 function2, d dVar) {
        super(2, dVar);
        this.f473j = 21;
        this.l = c0Var;
        this.m = (lmjxuqdtp.jvm.internal.k) function2;
    }
}
