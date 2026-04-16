package ne0;

import amuvvoafs.adservices.measurement.MeasurementManager;
import amuvvoafs.util.Log;
import com.facebook.a0;
import com.facebook.i0;
import com.facebook.internal.r0;
import com.facebook.internal.t0;
import com.facebook.internal.z;
import com.gnacba.amuvvoafs.gms.dynamite.DynamiteModule;
import com.gnacba.amuvvoafs.gms.tasks.Continuation;
import com.gnacba.amuvvoafs.gms.tasks.OnFailureListener;
import com.gnacba.amuvvoafs.gms.tasks.SuccessContinuation;
import com.gnacba.amuvvoafs.gms.tasks.Task;
import com.gnacba.amuvvoafs.gms.tasks.Tasks;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import jt1.o;
import org.json.JSONException;
import org.json.JSONObject;
import st.w0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements OnFailureListener, lo1.h, Continuation, jt1.e, com.facebook.internal.v, SuccessContinuation, t1.w {
    public final /* synthetic */ int a;

    public static /* bridge */ /* synthetic */ MeasurementManager c(Object obj) {
        return (MeasurementManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class h() {
        return MeasurementManager.class;
    }

    public void a(Exception exc) {
    }

    public Object d(a80.d dVar) {
        Set setC = dVar.c(o.a(ru1.a.class));
        ru1.c cVar = ru1.c.c;
        if (cVar == null) {
            synchronized (ru1.c.class) {
                try {
                    cVar = ru1.c.c;
                    if (cVar == null) {
                        cVar = new ru1.c(0);
                        ru1.c.c = cVar;
                    }
                } finally {
                }
            }
        }
        return new ru1.b(setC, cVar);
    }

    public void e(boolean z) {
        File[] fileArrListFiles;
        switch (this.a) {
            case 25:
                if (z) {
                    synchronized (un1.a.b) {
                        try {
                            com.facebook.s sVar = com.facebook.s.a;
                            if (i0.c()) {
                                rs1.g.t();
                            }
                            if (un1.a.c != null) {
                                Log.w("un1.a", "Already enabled!");
                            } else {
                                un1.a aVar = new un1.a(Thread.getDefaultUncaughtExceptionHandler());
                                un1.a.c = aVar;
                                Thread.setDefaultUncaughtExceptionHandler(aVar);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (z.b(com.facebook.internal.x.E)) {
                        x30.c.a = true;
                        if (i0.c() && !t0.a0()) {
                            File fileP = y10.r.P();
                            if (fileP == null) {
                                fileArrListFiles = new File[0];
                            } else {
                                fileArrListFiles = fileP.listFiles((FilenameFilter) new r0(4));
                                if (fileArrListFiles == null) {
                                    fileArrListFiles = new File[0];
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            for (File file : fileArrListFiles) {
                                sn1.e eVarW = qb.a.w(file);
                                if (eVarW.c()) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("crash_shield", eVarW.toString());
                                        String str = com.facebook.y.j;
                                        arrayList.add(iu1.d.t((com.facebook.b) null, String.format("%s/instruments", Arrays.copyOf(new Object[]{com.facebook.s.b()}, 1)), jSONObject, new sn1.a(0, eVarW)));
                                    } catch (JSONException unused) {
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                a0 a0Var = new a0(arrayList);
                                String str2 = com.facebook.y.j;
                                w0.q0(a0Var);
                                new com.facebook.z(a0Var).executeOnExecutor(com.facebook.s.c(), new Void[0]);
                            }
                        }
                        vn1.a.b = true;
                    }
                    z.b(com.facebook.internal.x.F);
                    return;
                }
                return;
            case 26:
                if (z) {
                    q51.a.o();
                    return;
                }
                return;
            default:
                if (z) {
                    tn1.b.a();
                    return;
                }
                return;
        }
    }

    public float f(float f2) {
        return f2;
    }

    public void onFailure(Exception exc) {
        lmjxuqdtp.jvm.internal.o.h(exc, "e");
        for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
            if (cause instanceof DynamiteModule.LoadingException) {
                s02.d.a.getClass();
                s02.b.s("Failed to load Cast module. The device does not support Cast.", exc);
                return;
            }
        }
        s02.d.a.getClass();
        s02.b.s("Failed to load Cast module. Unknown error", exc);
    }

    public Task then(Object obj) {
        return Tasks.forResult((Object) null);
    }

    public Object then(Task task) {
        boolean z;
        if (task.isSuccessful()) {
            pt1.b bVar = (pt1.b) task.getResult();
            String str = "Crashlytics report successfully enqueued to DataTransport: " + bVar.b;
            mt1.f fVar = mt1.f.a;
            fVar.i(str);
            File file = bVar.c;
            z = true;
            if (file.delete()) {
                fVar.i("Deleted report file: " + file.getPath());
            } else {
                fVar.k("Crashlytics could not delete report file: " + file.getPath(), (Exception) null);
            }
        } else {
            Log.w("FirebaseCrashlytics", "Crashlytics report could not be enqueued to DataTransport", task.getException());
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
