package bh;

import com.ironsource.mediationsdk.IronSource;
import java.util.List;
import lg.e;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import my1.y;
import ny1.m;
import qx1.d;
import sx1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f27j;
    public int k;
    public /* synthetic */ Object l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i, int i2, d dVar) {
        super(i, dVar);
        this.f27j = i2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, lmjxuqdtp.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, lmjxuqdtp.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, lmjxuqdtp.jvm.functions.Function1] */
    public final d create(Object obj, d dVar) {
        switch (this.f27j) {
            case 0:
                b bVar = new b(2, 0, dVar);
                bVar.l = obj;
                return bVar;
            case 1:
                b bVar2 = new b(2, 1, dVar);
                bVar2.l = obj;
                return bVar2;
            case 2:
                return new b(2, (Function1) this.l, dVar);
            case 3:
                return new b(3, (Function1) this.l, dVar);
            case 4:
                return new b(4, (Function1) this.l, dVar);
            case 5:
                b bVar3 = new b(this.k, dVar);
                bVar3.l = obj;
                return bVar3;
            case 6:
                b bVar4 = new b(2, 6, dVar);
                bVar4.l = obj;
                return bVar4;
            default:
                b bVar5 = new b(2, 7, dVar);
                bVar5.l = obj;
                return bVar5;
        }
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.f27j) {
        }
        return create((m) obj, (d) obj2).invokeSuspend(b0.a);
    }

    /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.Object, lmjxuqdtp.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.lang.Object, lmjxuqdtp.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.lang.Object, lmjxuqdtp.jvm.functions.Function1] */
    public final Object invokeSuspend(Object obj) {
        int i = this.f27j;
        b0 b0Var = b0.a;
        switch (i) {
            case 0:
                y yVar = (y) this.l;
                rx1.a aVar = rx1.a.a;
                int i2 = this.k;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                    return b0Var;
                }
                e.O(obj);
                IronSource.setLevelPlayInterstitialListener(new a(yVar));
                g gVar = new g(24);
                this.l = null;
                this.k = 1;
                return e.r(yVar, gVar, this) == aVar ? aVar : b0Var;
            case 1:
                m mVar = (m) this.l;
                rx1.a aVar2 = rx1.a.a;
                int i3 = this.k;
                if (i3 != 0) {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                    return b0Var;
                }
                e.O(obj);
                this.l = null;
                this.k = 1;
                return mVar.emit(b0Var, this) == aVar2 ? aVar2 : b0Var;
            case 2:
                rx1.a aVar3 = rx1.a.a;
                int i4 = this.k;
                if (i4 != 0) {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                    return obj;
                }
                e.O(obj);
                ?? r82 = this.l;
                this.k = 1;
                Object objInvoke = r82.invoke(this);
                return objInvoke == aVar3 ? aVar3 : objInvoke;
            case 3:
                rx1.a aVar4 = rx1.a.a;
                int i6 = this.k;
                if (i6 != 0) {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                    return obj;
                }
                e.O(obj);
                ?? r83 = this.l;
                this.k = 1;
                Object objInvoke2 = r83.invoke(this);
                return objInvoke2 == aVar4 ? aVar4 : objInvoke2;
            case 4:
                rx1.a aVar5 = rx1.a.a;
                int i7 = this.k;
                if (i7 != 0) {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                    return obj;
                }
                e.O(obj);
                ?? r84 = this.l;
                this.k = 1;
                Object objInvoke3 = r84.invoke(this);
                return objInvoke3 == aVar5 ? aVar5 : objInvoke3;
            case 5:
                List list = (List) this.l;
                rx1.a aVar6 = rx1.a.a;
                e.O(obj);
                return Boolean.valueOf(this.k < list.size());
            case 6:
                m mVar2 = (m) this.l;
                rx1.a aVar7 = rx1.a.a;
                int i8 = this.k;
                if (i8 != 0) {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                    return b0Var;
                }
                e.O(obj);
                nc0.k kVar = new nc0.k();
                this.l = null;
                this.k = 1;
                return mVar2.emit(kVar, this) == aVar7 ? aVar7 : b0Var;
            default:
                m mVar3 = (m) this.l;
                rx1.a aVar8 = rx1.a.a;
                int i9 = this.k;
                if (i9 != 0) {
                    if (i9 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                    return b0Var;
                }
                e.O(obj);
                this.l = null;
                this.k = 1;
                return mVar3.emit(b0Var, this) == aVar8 ? aVar8 : b0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i, Function1 function1, d dVar) {
        super(2, dVar);
        this.f27j = i;
        this.l = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i, d dVar) {
        super(2, dVar);
        this.f27j = 5;
        this.k = i;
    }
}
