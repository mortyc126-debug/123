package ne0;

import amuvvoafs.app.Application;
import amuvvoafs.content.Context;
import amuvvoafs.os.Parcel;
import amuvvoafs.os.RemoteException;
import bb.z0;
import com.gnacba.amuvvoafs.gms.common.internal.f0;
import com.gnacba.amuvvoafs.gms.internal.cast.s;
import com.gnacba.amuvvoafs.gms.tasks.Task;
import com.gnacba.amuvvoafs.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ky1.a0;
import ky1.c0;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import okhttp3.HttpUrl;
import op1.t;
import r02.e0;
import y11.d2;
import y11.o1;
import y11.r1;
import zj.v1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends sx1.i implements Function2 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f352j;
    public /* synthetic */ boolean k;
    public /* synthetic */ Object l;
    public final /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(x xVar, Application application, qx1.d dVar) {
        super(2, dVar);
        this.f352j = 0;
        this.l = xVar;
        this.m = application;
    }

    public final qx1.d create(Object obj, qx1.d dVar) {
        switch (this.f352j) {
            case 0:
                v vVar = new v((x) this.l, (Application) this.m, dVar);
                vVar.k = ((Boolean) obj).booleanValue();
                return vVar;
            case 1:
                return new v(this.k, (e0) this.l, this.m, dVar, 1);
            case 2:
                return new v(this.k, (a0) this.l, (t1.b) this.m, dVar, 2);
            case 3:
                v vVar2 = new v(this.k, (o1) this.m, dVar, 3);
                vVar2.l = obj;
                return vVar2;
            default:
                v vVar3 = new v(this.k, (v1) this.m, dVar, 4);
                vVar3.l = obj;
                return vVar3;
        }
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.f352j) {
            case 0:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                v vVar = (v) create(bool, (qx1.d) obj2);
                b0 b0Var = b0.a;
                vVar.invokeSuspend(b0Var);
                return b0Var;
            case 1:
                v vVar2 = (v) create((a0) obj, (qx1.d) obj2);
                b0 b0Var2 = b0.a;
                vVar2.invokeSuspend(b0Var2);
                return b0Var2;
            case 2:
                v vVar3 = (v) create((a0) obj, (qx1.d) obj2);
                b0 b0Var3 = b0.a;
                vVar3.invokeSuspend(b0Var3);
                return b0Var3;
            case 3:
                v vVar4 = (v) create((bm.c) obj, (qx1.d) obj2);
                b0 b0Var4 = b0.a;
                vVar4.invokeSuspend(b0Var4);
                return b0Var4;
            default:
                v vVar5 = (v) create((bm.c) obj, (qx1.d) obj2);
                b0 b0Var5 = b0.a;
                vVar5.invokeSuspend(b0Var5);
                return b0Var5;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Task taskForResult;
        switch (this.f352j) {
            case 0:
                boolean z = this.k;
                rx1.a aVar = rx1.a.a;
                lg.e.O(obj);
                if (!z) {
                    ((x) this.l).a();
                    jp1.a aVar2 = (jp1.a) ((x) this.l).b.getValue();
                    if (aVar2 != null) {
                        bv1.a aVar3 = ((x) this.l).d;
                        f0.d("Must be called from the main thread.");
                        if (aVar3 != null) {
                            jp1.g gVar = aVar2.b;
                            gVar.getClass();
                            try {
                                jp1.y yVar = gVar.a;
                                jp1.j jVar = new jp1.j(aVar3);
                                Parcel parcelC1 = yVar.C1();
                                com.gnacba.amuvvoafs.gms.internal.cast.y.d(parcelC1, jVar);
                                yVar.w3(5, parcelC1);
                            } catch (RemoteException e) {
                                jp1.g.c.a(e, "Unable to call %s on %s.", new Object[]{"removeCastStateListener", jp1.y.class.getSimpleName()});
                            }
                        }
                    }
                    ((x) this.l).b.setValue((Object) null);
                    break;
                } else {
                    x xVar = (x) this.l;
                    Application application = (Application) this.m;
                    lb.d dVar = new lb.d(14, xVar);
                    ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                    op1.b bVar = jp1.a.k;
                    f0.d("Must be called from the main thread.");
                    if (jp1.a.m == null) {
                        final Context applicationContext = application.getApplicationContext();
                        final jp1.d dVarC = jp1.a.c(applicationContext);
                        final jp1.b castOptions = dVarC.getCastOptions(applicationContext);
                        final op1.t tVar = new op1.t(applicationContext);
                        final com.gnacba.amuvvoafs.gms.internal.cast.s sVar = new com.gnacba.amuvvoafs.gms.internal.cast.s(applicationContext, bb.f0.d(applicationContext), castOptions, tVar);
                        taskForResult = Tasks.call(executorServiceNewSingleThreadExecutor, new Callable() { // from class: jp1.c0
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                Context context = applicationContext;
                                b bVar2 = castOptions;
                                d dVar2 = dVarC;
                                s sVar2 = sVar;
                                t tVar2 = tVar;
                                synchronized (a.l) {
                                    try {
                                        if (a.m == null) {
                                            a.m = new a(context, bVar2, dVar2.getAdditionalSessionProviders(context), sVar2, tVar2);
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                return a.m;
                            }
                        });
                    } else {
                        taskForResult = Tasks.forResult(jp1.a.m);
                    }
                    o.g(taskForResult, "getSharedInstance(...)");
                    taskForResult.addOnSuccessListener(new z0(16, new le1.h(10, dVar, taskForResult)));
                    taskForResult.addOnFailureListener(new u(0));
                }
                return b0.a;
            case 1:
                Object obj2 = this.m;
                e0 e0Var = (e0) this.l;
                rx1.a aVar4 = rx1.a.a;
                lg.e.O(obj);
                if (this.k) {
                    e0Var.r.add(obj2);
                } else {
                    e0Var.r.remove(obj2);
                }
                return b0.a;
            case 2:
                rx1.a aVar5 = rx1.a.a;
                lg.e.O(obj);
                if (this.k) {
                    c0.F((a0) this.l, (qx1.i) null, (ky1.b0) null, new com.bandlab.uikit.compose.bottomsheet.a0((t1.b) this.m, (qx1.d) null, 9), 3);
                }
                return b0.a;
            case 3:
                b0 b0Var = b0.a;
                bm.c cVar = (bm.c) this.l;
                rx1.a aVar6 = rx1.a.a;
                lg.e.O(obj);
                o1 o1Var = (o1) this.m;
                a21.e eVarE = cVar.e();
                o1 o1Var2 = eVarE.h;
                String str = o1Var2 != null ? o1Var2.a : null;
                String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                if (str == null) {
                    str = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                String str3 = o1Var.a;
                if (str3 != null) {
                    str2 = str3;
                }
                if (!str.equals(str2)) {
                    cVar.g(new bm.g(a21.e.a(eVarE, (String) null, (List) null, (String) null, (Map) null, (LinkedHashMap) null, (String) null, (d2) null, o1Var, (r1) null, 0.0d, (ArrayList) null, (a21.a0) null, 8063)));
                    if (this.k) {
                        cVar.f();
                    } else {
                        cVar.c();
                    }
                    cVar.d();
                }
                return b0Var;
            default:
                bm.c cVar2 = (bm.c) this.l;
                rx1.a aVar7 = rx1.a.a;
                lg.e.O(obj);
                s02.b bVar2 = s02.d.a;
                boolean z2 = this.k;
                bVar2.getClass();
                s02.b.t("Mon:: set output noisy: " + z2);
                cVar2.a.setOutputNoisy(z2);
                v1.a((v1) this.m, cVar2);
                return b0.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(boolean z, Object obj, Object obj2, qx1.d dVar, int i) {
        super(2, dVar);
        this.f352j = i;
        this.k = z;
        this.l = obj;
        this.m = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(boolean z, Object obj, qx1.d dVar, int i) {
        super(2, dVar);
        this.f352j = i;
        this.k = z;
        this.m = obj;
    }
}
