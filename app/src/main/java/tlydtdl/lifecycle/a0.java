package tlydtdl.lifecycle;

import a2.w3;
import ak.i3;
import ak.l2;
import au0.j0;
import bj.e;
import com.bandlab.arrangement.view.ArrangementView;
import com.bandlab.audiocore.generated.MeterLevels;
import com.bandlab.bandlab.media.editor.MixEditorService;
import com.gnacba.firebase.crashlytics.FirebaseCrashlytics;
import es0.t;
import gz0.f;
import is0.g;
import java.util.List;
import java.util.Set;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import nc0.n;
import tlydtdl.compose.runtime.e1;
import uo0.a;
import zg0.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends sx1.i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f596j;
    public /* synthetic */ Object k;
    public final /* synthetic */ Object l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(Object obj, Object obj2, qx1.d dVar, int i) {
        super(2, dVar);
        this.f596j = i;
        this.k = obj;
        this.l = obj2;
    }

    public final qx1.d create(Object obj, qx1.d dVar) {
        switch (this.f596j) {
            case 0:
                a0 a0Var = new a0((b0) this.l, dVar, 0);
                a0Var.k = obj;
                return a0Var;
            case 1:
                a0 a0Var2 = new a0((at.c) this.l, dVar, 1);
                a0Var2.k = obj;
                return a0Var2;
            case 2:
                a0 a0Var3 = new a0((j0) this.l, dVar, 2);
                a0Var3.k = obj;
                return a0Var3;
            case 3:
                a0 a0Var4 = new a0((bn0.j) this.l, dVar, 3);
                a0Var4.k = obj;
                return a0Var4;
            case 4:
                return new a0((a) this.k, (bp0.l) this.l, dVar, 4);
            case 5:
                return new a0((tlydtdl.compose.foundation.lazy.layout.r1) this.k, (String) this.l, dVar, 5);
            case 6:
                return new a0((e) this.k, (FirebaseCrashlytics) this.l, dVar, 6);
            case 7:
                a0 a0Var5 = new a0((du.d) this.l, dVar, 7);
                a0Var5.k = obj;
                return a0Var5;
            case 8:
                a0 a0Var6 = new a0((t) this.l, dVar, 8);
                a0Var6.k = obj;
                return a0Var6;
            case 9:
                a0 a0Var7 = new a0((f80.m) this.l, dVar, 9);
                a0Var7.k = obj;
                return a0Var7;
            case 10:
                return new a0((fg.m) this.k, (String) this.l, dVar, 10);
            case 11:
                a0 a0Var8 = new a0((fg0.e) this.l, dVar, 11);
                a0Var8.k = obj;
                return a0Var8;
            case 12:
                a0 a0Var9 = new a0((e1) this.l, dVar, 12);
                a0Var9.k = obj;
                return a0Var9;
            case 13:
                return new a0((w3) this.k, (Function1) this.l, dVar, 13);
            case 14:
                a0 a0Var10 = new a0((gj.a) this.l, dVar, 14);
                a0Var10.k = obj;
                return a0Var10;
            case 15:
                a0 a0Var11 = new a0((gn0.j) this.l, dVar, 15);
                a0Var11.k = obj;
                return a0Var11;
            case 16:
                a0 a0Var12 = new a0((f) this.l, dVar, 16);
                a0Var12.k = obj;
                return a0Var12;
            case 17:
                a0 a0Var13 = new a0((ArrangementView) this.l, dVar, 17);
                a0Var13.k = obj;
                return a0Var13;
            case 18:
                a0 a0Var14 = new a0((il.e) this.l, dVar, 18);
                a0Var14.k = obj;
                return a0Var14;
            case 19:
                a0 a0Var15 = new a0((g) this.l, dVar, 19);
                a0Var15.k = obj;
                return a0Var15;
            case 20:
                a0 a0Var16 = new a0((bb.v) this.l, dVar, 20);
                a0Var16.k = obj;
                return a0Var16;
            case 21:
                a0 a0Var17 = new a0((k7.x0) this.l, dVar, 21);
                a0Var17.k = obj;
                return a0Var17;
            case 22:
                a0 a0Var18 = new a0((kp.e) this.l, dVar, 22);
                a0Var18.k = obj;
                return a0Var18;
            case 23:
                a0 a0Var19 = new a0((Function0) this.l, dVar, 23);
                a0Var19.k = obj;
                return a0Var19;
            case 24:
                a0 a0Var20 = new a0((MixEditorService) this.l, dVar, 24);
                a0Var20.k = obj;
                return a0Var20;
            case 25:
                return new a0((lt.b) this.k, (String) this.l, dVar, 25);
            case 26:
                return new a0((jx0.h) this.k, (js0.t) this.l, dVar, 26);
            case 27:
                a0 a0Var21 = new a0((Set) this.l, dVar, 27);
                a0Var21.k = obj;
                return a0Var21;
            case 28:
                a0 a0Var22 = new a0((Function2) this.l, dVar, 28);
                a0Var22.k = obj;
                return a0Var22;
            default:
                a0 a0Var23 = new a0((oc0.l) this.l, dVar, 29);
                a0Var23.k = obj;
                return a0Var23;
        }
    }

    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f596j) {
            case 0:
                a0 a0Var = (a0) create((ky1.a0) obj, (qx1.d) obj2);
                lx1.b0 b0Var = lx1.b0.a;
                a0Var.invokeSuspend(b0Var);
                return b0Var;
            case 1:
                a0 a0Var2 = (a0) create((s00.g) obj, (qx1.d) obj2);
                lx1.b0 b0Var2 = lx1.b0.a;
                a0Var2.invokeSuspend(b0Var2);
                return b0Var2;
            case 2:
                a0 a0Var3 = (a0) create((b2) obj, (qx1.d) obj2);
                lx1.b0 b0Var3 = lx1.b0.a;
                a0Var3.invokeSuspend(b0Var3);
                return b0Var3;
            case 3:
                a0 a0Var4 = (a0) create((MeterLevels) obj, (qx1.d) obj2);
                lx1.b0 b0Var4 = lx1.b0.a;
                a0Var4.invokeSuspend(b0Var4);
                return b0Var4;
            case 4:
                return ((a0) create((ky1.a0) obj, (qx1.d) obj2)).invokeSuspend(lx1.b0.a);
            case 5:
                a0 a0Var5 = (a0) create((ky1.a0) obj, (qx1.d) obj2);
                lx1.b0 b0Var5 = lx1.b0.a;
                a0Var5.invokeSuspend(b0Var5);
                return b0Var5;
            case 6:
                a0 a0Var6 = (a0) create((ky1.a0) obj, (qx1.d) obj2);
                lx1.b0 b0Var6 = lx1.b0.a;
                a0Var6.invokeSuspend(b0Var6);
                return b0Var6;
            case 7:
                return ((a0) create((n) obj, (qx1.d) obj2)).invokeSuspend(lx1.b0.a);
            case 8:
                a0 a0Var7 = (a0) create((a21.e) obj, (qx1.d) obj2);
                lx1.b0 b0Var7 = lx1.b0.a;
                a0Var7.invokeSuspend(b0Var7);
                return b0Var7;
            case 9:
                a0 a0Var8 = (a0) create((lx1.l) obj, (qx1.d) obj2);
                lx1.b0 b0Var8 = lx1.b0.a;
                a0Var8.invokeSuspend(b0Var8);
                return b0Var8;
            case 10:
                a0 a0Var9 = (a0) create((ky1.a0) obj, (qx1.d) obj2);
                lx1.b0 b0Var9 = lx1.b0.a;
                a0Var9.invokeSuspend(b0Var9);
                return b0Var9;
            case 11:
                a0 a0Var10 = (a0) create((bk.n) obj, (qx1.d) obj2);
                lx1.b0 b0Var10 = lx1.b0.a;
                a0Var10.invokeSuspend(b0Var10);
                return b0Var10;
            case 12:
                a0 a0Var11 = (a0) create((f2.q) obj, (qx1.d) obj2);
                lx1.b0 b0Var11 = lx1.b0.a;
                a0Var11.invokeSuspend(b0Var11);
                return b0Var11;
            case 13:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                a0 a0Var12 = (a0) create(bool, (qx1.d) obj2);
                lx1.b0 b0Var12 = lx1.b0.a;
                a0Var12.invokeSuspend(b0Var12);
                return b0Var12;
            case 14:
                a0 a0Var13 = (a0) create((s00.k) obj, (qx1.d) obj2);
                lx1.b0 b0Var13 = lx1.b0.a;
                a0Var13.invokeSuspend(b0Var13);
                return b0Var13;
            case 15:
                return ((a0) create((ed0.e) obj, (qx1.d) obj2)).invokeSuspend(lx1.b0.a);
            case 16:
                a0 a0Var14 = (a0) create((gz0.b) obj, (qx1.d) obj2);
                lx1.b0 b0Var14 = lx1.b0.a;
                a0Var14.invokeSuspend(b0Var14);
                return b0Var14;
            case 17:
                a0 a0Var15 = (a0) create((dh0.f) obj, (qx1.d) obj2);
                lx1.b0 b0Var15 = lx1.b0.a;
                a0Var15.invokeSuspend(b0Var15);
                return b0Var15;
            case 18:
                a0 a0Var16 = (a0) create((ed0.e) obj, (qx1.d) obj2);
                lx1.b0 b0Var16 = lx1.b0.a;
                a0Var16.invokeSuspend(b0Var16);
                return b0Var16;
            case 19:
                return ((a0) create((i3) obj, (qx1.d) obj2)).invokeSuspend(lx1.b0.a);
            case 20:
                a0 a0Var17 = (a0) create((List) obj, (qx1.d) obj2);
                lx1.b0 b0Var17 = lx1.b0.a;
                a0Var17.invokeSuspend(b0Var17);
                return b0Var17;
            case 21:
                return ((a0) create((k7.x0) obj, (qx1.d) obj2)).invokeSuspend(lx1.b0.a);
            case 22:
                a0 a0Var18 = (a0) create((String) obj, (qx1.d) obj2);
                lx1.b0 b0Var18 = lx1.b0.a;
                a0Var18.invokeSuspend(b0Var18);
                return b0Var18;
            case 23:
                return ((a0) create((ky1.a0) obj, (qx1.d) obj2)).invokeSuspend(lx1.b0.a);
            case 24:
                a0 a0Var19 = (a0) create((l2) obj, (qx1.d) obj2);
                lx1.b0 b0Var19 = lx1.b0.a;
                a0Var19.invokeSuspend(b0Var19);
                return b0Var19;
            case 25:
                return ((a0) create((ky1.a0) obj, (qx1.d) obj2)).invokeSuspend(lx1.b0.a);
            case 26:
                a0 a0Var20 = (a0) create((ky1.a0) obj, (qx1.d) obj2);
                lx1.b0 b0Var20 = lx1.b0.a;
                a0Var20.invokeSuspend(b0Var20);
                return b0Var20;
            case 27:
                return ((a0) create((o7.h) obj, (qx1.d) obj2)).invokeSuspend(lx1.b0.a);
            case 28:
                a0 a0Var21 = (a0) create((n) obj, (qx1.d) obj2);
                lx1.b0 b0Var21 = lx1.b0.a;
                a0Var21.invokeSuspend(b0Var21);
                return b0Var21;
            default:
                a0 a0Var22 = (a0) create((n) obj, (qx1.d) obj2);
                lx1.b0 b0Var22 = lx1.b0.a;
                a0Var22.invokeSuspend(b0Var22);
                return b0Var22;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01b7, code lost:
    
        return r9.invoke();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01ba, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01bb, code lost:
    
        r2.k();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01be, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:240:0x067f  */
    /* JADX WARN: Type inference failed for: r0v110, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v42, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v46, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2114
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.lifecycle.a0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(Object obj, qx1.d dVar, int i) {
        super(2, dVar);
        this.f596j = i;
        this.l = obj;
    }
}
