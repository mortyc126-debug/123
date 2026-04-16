package jp1;

import amuvvoafs.content.Context;
import amuvvoafs.os.RemoteException;
import com.gnacba.amuvvoafs.gms.cast.framework.ModuleUnavailableException;
import com.gnacba.amuvvoafs.gms.common.internal.f0;
import com.gnacba.amuvvoafs.gms.internal.cast.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static final op1.b b = new op1.b("Session", (String) null);
    public final x a;

    public f(Context context, String str, String str2) {
        x xVarQ4;
        try {
            xVarQ4 = e.b(context).q4(str, str2, new z(this));
        } catch (ModuleUnavailableException | RemoteException e) {
            e.a.a(e, "Unable to call %s on %s.", new Object[]{"newSessionImpl", com.gnacba.amuvvoafs.gms.internal.cast.g.class.getSimpleName()});
            xVarQ4 = null;
        }
        this.a = xVarQ4;
    }

    public final boolean a() {
        f0.d("Must be called from the main thread.");
        v vVar = this.a;
        if (vVar != null) {
            try {
                return vVar.zzp();
            } catch (RemoteException e) {
                b.a(e, "Unable to call %s on %s.", new Object[]{"isConnected", x.class.getSimpleName()});
            }
        }
        return false;
    }

    public final void b(int i) {
        v vVar = this.a;
        if (vVar == null) {
            return;
        }
        try {
            vVar.p4(i);
        } catch (RemoteException e) {
            b.a(e, "Unable to call %s on %s.", new Object[]{"notifySessionEnded", x.class.getSimpleName()});
        }
    }

    public final int c() {
        f0.d("Must be called from the main thread.");
        v vVar = this.a;
        if (vVar != null) {
            try {
                if (vVar.o4() >= 211100000) {
                    return vVar.zzf();
                }
            } catch (RemoteException e) {
                b.a(e, "Unable to call %s on %s.", new Object[]{"getSessionStartType", x.class.getSimpleName()});
            }
        }
        return 0;
    }

    public final bq1.a d() {
        v vVar = this.a;
        if (vVar != null) {
            try {
                return vVar.zzg();
            } catch (RemoteException e) {
                b.a(e, "Unable to call %s on %s.", new Object[]{"getWrappedObject", x.class.getSimpleName()});
            }
        }
        return null;
    }
}
