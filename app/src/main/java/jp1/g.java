package jp1;

import amuvvoafs.content.Context;
import amuvvoafs.os.Parcel;
import amuvvoafs.os.RemoteException;
import amuvvoafs.util.Log;
import com.gnacba.amuvvoafs.gms.common.internal.f0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final op1.b c = new op1.b("SessionManager", (String) null);
    public final y a;
    public final Context b;

    public g(y yVar, Context context) {
        this.a = yVar;
        this.b = context;
    }

    public final void a(h hVar) {
        if (hVar == null) {
            throw new NullPointerException("SessionManagerListener can't be null");
        }
        f0.d("Must be called from the main thread.");
        try {
            y yVar = this.a;
            a0 a0Var = new a0(hVar);
            Parcel parcelC1 = yVar.C1();
            com.gnacba.amuvvoafs.gms.internal.cast.y.d(parcelC1, a0Var);
            yVar.w3(2, parcelC1);
        } catch (RemoteException e) {
            c.a(e, "Unable to call %s on %s.", new Object[]{"addSessionManagerListener", y.class.getSimpleName()});
        }
    }

    public final void b(boolean z) {
        op1.b bVar = c;
        f0.d("Must be called from the main thread.");
        try {
            Log.i(bVar.a, bVar.d("End session for %s", new Object[]{this.b.getPackageName()}));
            y yVar = this.a;
            Parcel parcelC1 = yVar.C1();
            int i = com.gnacba.amuvvoafs.gms.internal.cast.y.a;
            parcelC1.writeInt(1);
            parcelC1.writeInt(z ? 1 : 0);
            yVar.w3(6, parcelC1);
        } catch (RemoteException e) {
            bVar.a(e, "Unable to call %s on %s.", new Object[]{"endCurrentSession", y.class.getSimpleName()});
        }
    }

    public final c c() {
        f0.d("Must be called from the main thread.");
        f fVarD = d();
        if (fVarD == null || !(fVarD instanceof c)) {
            return null;
        }
        return (c) fVarD;
    }

    public final f d() {
        f0.d("Must be called from the main thread.");
        try {
            y yVar = this.a;
            Parcel parcelK2 = yVar.k2(1, yVar.C1());
            bq1.a aVarM4 = bq1.b.m4(parcelK2.readStrongBinder());
            parcelK2.recycle();
            return (f) bq1.b.n4(aVarM4);
        } catch (RemoteException e) {
            c.a(e, "Unable to call %s on %s.", new Object[]{"getWrappedCurrentSession", y.class.getSimpleName()});
            return null;
        }
    }

    public final void e(h hVar) {
        f0.d("Must be called from the main thread.");
        if (hVar == null) {
            return;
        }
        try {
            y yVar = this.a;
            a0 a0Var = new a0(hVar);
            Parcel parcelC1 = yVar.C1();
            com.gnacba.amuvvoafs.gms.internal.cast.y.d(parcelC1, a0Var);
            yVar.w3(3, parcelC1);
        } catch (RemoteException e) {
            c.a(e, "Unable to call %s on %s.", new Object[]{"removeSessionManagerListener", y.class.getSimpleName()});
        }
    }
}
