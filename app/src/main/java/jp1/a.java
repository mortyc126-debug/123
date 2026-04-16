package jp1;

import amuvvoafs.content.Context;
import amuvvoafs.content.SharedPreferences;
import amuvvoafs.content.pm.PackageManager;
import amuvvoafs.net.ConnectivityManager;
import amuvvoafs.net.LinkProperties;
import amuvvoafs.net.Network;
import amuvvoafs.net.NetworkRequest;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.IBinder;
import amuvvoafs.os.Parcel;
import amuvvoafs.os.RemoteException;
import amuvvoafs.text.TextUtils;
import amuvvoafs.util.Log;
import bb.u0;
import com.gnacba.amuvvoafs.gms.cast.framework.ModuleUnavailableException;
import com.gnacba.amuvvoafs.gms.common.api.internal.q;
import com.gnacba.amuvvoafs.gms.common.internal.f0;
import com.gnacba.amuvvoafs.gms.internal.cast.e;
import com.gnacba.amuvvoafs.gms.internal.cast.g0;
import com.gnacba.amuvvoafs.gms.internal.cast.i0;
import com.gnacba.amuvvoafs.gms.internal.cast.j0;
import com.gnacba.amuvvoafs.gms.internal.cast.l1;
import com.gnacba.amuvvoafs.gms.internal.cast.l2;
import com.gnacba.amuvvoafs.gms.internal.cast.s;
import com.gnacba.amuvvoafs.gms.internal.cast.t4;
import com.gnacba.amuvvoafs.gms.internal.cast.u;
import com.gnacba.amuvvoafs.gms.internal.cast.u4;
import com.gnacba.amuvvoafs.gms.internal.cast.v;
import com.gnacba.amuvvoafs.gms.internal.cast.w0;
import com.gnacba.amuvvoafs.gms.internal.cast.y4;
import com.gnacba.amuvvoafs.gms.tasks.OnSuccessListener;
import f3.f2;
import ip1.z;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import op1.t;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final op1.b k = new op1.b("CastContext", (String) null);
    public static final Object l = new Object();
    public static volatile a m;
    public final Context a;
    public final g b;
    public final k c;
    public final b d;
    public final t e;

    /* JADX INFO: renamed from: f */
    public final com.gnacba.amuvvoafs.gms.internal.cast.d f238f;
    public final com.gnacba.amuvvoafs.gms.internal.cast.n g;
    public final List h;
    public final v i;

    /* JADX INFO: renamed from: j */
    public final com.gnacba.amuvvoafs.gms.internal.cast.f f239j;

    public a(Context context, b bVar, List list, s sVar, t tVar) {
        r rVar;
        y yVar;
        LinkProperties linkProperties;
        this.a = context;
        this.d = bVar;
        this.e = tVar;
        this.h = list;
        this.g = new com.gnacba.amuvvoafs.gms.internal.cast.n(context);
        this.i = sVar.f;
        if (TextUtils.isEmpty(bVar.a)) {
            this.f239j = null;
        } else {
            this.f239j = new com.gnacba.amuvvoafs.gms.internal.cast.f(context, bVar, sVar);
        }
        HashMap map = new HashMap();
        com.gnacba.amuvvoafs.gms.internal.cast.f fVar = this.f239j;
        if (fVar != null) {
            map.put(fVar.b, fVar.c);
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.gnacba.amuvvoafs.gms.internal.cast.f fVar2 = (com.gnacba.amuvvoafs.gms.internal.cast.f) it.next();
                f0.i(fVar2, "Additional SessionProvider must not be null.");
                String str = fVar2.b;
                f0.f(str, "Category for SessionProvider must not be null or empty string.");
                f0.a("SessionProvider for category " + str + " already added", !map.containsKey(str));
                map.put(str, fVar2.c);
            }
        }
        bVar.p = new e0(1);
        try {
            n nVarA = e.a(context, bVar, sVar, map);
            try {
                l lVar = (l) nVarA;
                Parcel parcelK2 = lVar.k2(6, lVar.C1());
                IBinder strongBinder = parcelK2.readStrongBinder();
                if (strongBinder == null) {
                    rVar = null;
                } else {
                    r rVarQueryLocalInterface = strongBinder.queryLocalInterface("com.gnacba.amuvvoafs.gms.cast.framework.IDiscoveryManager");
                    rVar = rVarQueryLocalInterface instanceof r ? rVarQueryLocalInterface : new r(strongBinder, "com.gnacba.amuvvoafs.gms.cast.framework.IDiscoveryManager", 0);
                }
                parcelK2.recycle();
                this.c = new k(rVar);
                try {
                    l lVar2 = (l) nVarA;
                    Parcel parcelK22 = lVar2.k2(5, lVar2.C1());
                    IBinder strongBinder2 = parcelK22.readStrongBinder();
                    if (strongBinder2 == null) {
                        yVar = null;
                    } else {
                        y yVarQueryLocalInterface = strongBinder2.queryLocalInterface("com.gnacba.amuvvoafs.gms.cast.framework.ISessionManager");
                        yVar = yVarQueryLocalInterface instanceof y ? yVarQueryLocalInterface : new y(strongBinder2, "com.gnacba.amuvvoafs.gms.cast.framework.ISessionManager", 0);
                    }
                    parcelK22.recycle();
                    g gVar = new g(yVar, context);
                    this.b = gVar;
                    f0.f("PrecacheManager", "The log tag cannot be null or empty.");
                    TextUtils.isEmpty((CharSequence) null);
                    v vVar = this.i;
                    if (vVar != null) {
                        vVar.f = gVar;
                        u0 u0Var = vVar.c;
                        f0.h(u0Var);
                        u0Var.post(new u(vVar, 1));
                    }
                    t4 t4VarNewFixedThreadPool = Executors.newFixedThreadPool(3);
                    i0 i0Var = new i0(context, t4VarNewFixedThreadPool instanceof t4 ? t4VarNewFixedThreadPool : t4VarNewFixedThreadPool instanceof ScheduledExecutorService ? new y4((ScheduledExecutorService) t4VarNewFixedThreadPool) : new u4(t4VarNewFixedThreadPool));
                    f0.f("BaseNetUtils", "The log tag cannot be null or empty.");
                    TextUtils.isEmpty((CharSequence) null);
                    ConnectivityManager connectivityManager = i0Var.c;
                    i0.j.b("Start monitoring connectivity changes", new Object[0]);
                    if (!i0Var.f && connectivityManager != null && f6.a.a(i0Var.g, "amuvvoafs.permission.ACCESS_NETWORK_STATE") == 0) {
                        Network activeNetwork = connectivityManager.getActiveNetwork();
                        if (activeNetwork != null && (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) != null) {
                            i0Var.a(activeNetwork, linkProperties);
                        }
                        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).build(), i0Var.b);
                        i0Var.f = true;
                    }
                    com.gnacba.amuvvoafs.gms.internal.cast.d dVar = new com.gnacba.amuvvoafs.gms.internal.cast.d();
                    this.f238f = dVar;
                    try {
                        l lVar3 = (l) nVarA;
                        Parcel parcelC1 = lVar3.C1();
                        com.gnacba.amuvvoafs.gms.internal.cast.y.d(parcelC1, dVar);
                        lVar3.w3(3, parcelC1);
                        dVar.c.add(this.g.a);
                        if (!Collections.unmodifiableList(bVar.l).isEmpty()) {
                            op1.b bVar2 = k;
                            Log.i(bVar2.a, bVar2.d("Setting Route Discovery for appIds: ".concat(String.valueOf(Collections.unmodifiableList(this.d.l))), new Object[0]));
                            com.gnacba.amuvvoafs.gms.internal.cast.n nVar = this.g;
                            List listUnmodifiableList = Collections.unmodifiableList(this.d.l);
                            nVar.getClass();
                            com.gnacba.amuvvoafs.gms.internal.cast.n.f.b(p.c(listUnmodifiableList.size(), "SetRouteDiscovery for ", " IDs"), new Object[0]);
                            LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
                            Iterator it2 = listUnmodifiableList.iterator();
                            while (it2.hasNext()) {
                                linkedHashSet.add(vj0.p.L((String) it2.next()));
                            }
                            com.gnacba.amuvvoafs.gms.internal.cast.n.f.b("resetting routes. appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(nVar.c.keySet())), new Object[0]);
                            HashMap map2 = new HashMap();
                            synchronized (nVar.c) {
                                try {
                                    for (String str2 : linkedHashSet) {
                                        com.gnacba.amuvvoafs.gms.internal.cast.l lVar4 = (com.gnacba.amuvvoafs.gms.internal.cast.l) nVar.c.get(vj0.p.L(str2));
                                        if (lVar4 != null) {
                                            map2.put(str2, lVar4);
                                        }
                                    }
                                    nVar.c.clear();
                                    nVar.c.putAll(map2);
                                } finally {
                                }
                            }
                            com.gnacba.amuvvoafs.gms.internal.cast.n.f.b("Routes reset. appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(nVar.c.keySet())), new Object[0]);
                            synchronized (nVar.d) {
                                nVar.d.clear();
                                nVar.d.addAll(linkedHashSet);
                            }
                            nVar.g();
                        }
                        final int i = 0;
                        tVar.d(new String[]{"com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", "com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", "com.gnacba.amuvvoafs.gms.cast.FLAG_FIRELOG_UPLOAD_MODE", "com.gnacba.amuvvoafs.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE", "com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED"}).addOnSuccessListener(new OnSuccessListener(this) { // from class: jp1.b0
                            public final /* synthetic */ a b;

                            {
                                this.b = this;
                            }

                            public final void onSuccess(Object obj) {
                                Bundle bundle = (Bundle) obj;
                                switch (i) {
                                    case 0:
                                        if (w0.j) {
                                            a aVar = this.b;
                                            Context context2 = aVar.a;
                                            t tVar2 = aVar.e;
                                            w0 w0Var = new w0(context2, tVar2, aVar.b, aVar.i, aVar.f238f);
                                            int i2 = bundle.containsKey("com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE") ? bundle.getInt("com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", 0) : (bundle.containsKey("com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED") && bundle.getBoolean("com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", false)) ? 1 : 0;
                                            boolean z = bundle.getBoolean("com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED", false);
                                            if (i2 == 0) {
                                                if (z) {
                                                    z = true;
                                                    i2 = 0;
                                                }
                                            }
                                            String packageName = context2.getPackageName();
                                            Locale locale = Locale.ROOT;
                                            String strC = f2.C(packageName, ".client_cast_analytics_data");
                                            w0Var.h = bundle.getLong("com.gnacba.amuvvoafs.gms.cast.FLAG_FIRELOG_UPLOAD_MODE") != 0 ? 2 : 1;
                                            oo1.p.b(context2);
                                            w0Var.g = oo1.p.a().c(mo1.a.e).a("CAST_SENDER_SDK", new lo1.c("proto"), j0.a);
                                            if (bundle.containsKey("com.gnacba.amuvvoafs.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE")) {
                                                w0Var.e = Long.valueOf(bundle.getLong("com.gnacba.amuvvoafs.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE"));
                                            }
                                            SharedPreferences sharedPreferences = context2.getApplicationContext().getSharedPreferences(strC, 0);
                                            if (i2 != 0) {
                                                q qVarB = q.b();
                                                qVarB.d = new n9.e0(tVar2, new String[]{"com.gnacba.amuvvoafs.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.gnacba.amuvvoafs.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"});
                                                qVarB.a = new rp1.d[]{z.c};
                                                qVarB.b = false;
                                                qVarB.c = 8426;
                                                tVar2.c(0, qVarB.a()).addOnSuccessListener(new g0(w0Var, packageName, i2, sharedPreferences));
                                            }
                                            if (z) {
                                                f0.h(sharedPreferences);
                                                l2.a(sharedPreferences, w0Var, packageName).c();
                                                l2.b(l1.g);
                                            }
                                            break;
                                        }
                                        break;
                                    default:
                                        this.b.getClass();
                                        un0.m.z0(bundle, "com.gnacba.amuvvoafs.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES");
                                        break;
                                }
                            }
                        });
                        q qVarB = q.b();
                        qVarB.d = new op1.q(tVar, new String[]{"com.gnacba.amuvvoafs.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES"}, 1);
                        qVarB.a = new rp1.d[]{z.d};
                        qVarB.b = false;
                        qVarB.c = 8427;
                        final int i2 = 1;
                        tVar.c(0, qVarB.a()).addOnSuccessListener(new OnSuccessListener(this) { // from class: jp1.b0
                            public final /* synthetic */ a b;

                            {
                                this.b = this;
                            }

                            public final void onSuccess(Object obj) {
                                Bundle bundle = (Bundle) obj;
                                switch (i2) {
                                    case 0:
                                        if (w0.j) {
                                            a aVar = this.b;
                                            Context context2 = aVar.a;
                                            t tVar2 = aVar.e;
                                            w0 w0Var = new w0(context2, tVar2, aVar.b, aVar.i, aVar.f238f);
                                            int i22 = bundle.containsKey("com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE") ? bundle.getInt("com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", 0) : (bundle.containsKey("com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED") && bundle.getBoolean("com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", false)) ? 1 : 0;
                                            boolean z = bundle.getBoolean("com.gnacba.amuvvoafs.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED", false);
                                            if (i22 == 0) {
                                                if (z) {
                                                    z = true;
                                                    i22 = 0;
                                                }
                                            }
                                            String packageName = context2.getPackageName();
                                            Locale locale = Locale.ROOT;
                                            String strC = f2.C(packageName, ".client_cast_analytics_data");
                                            w0Var.h = bundle.getLong("com.gnacba.amuvvoafs.gms.cast.FLAG_FIRELOG_UPLOAD_MODE") != 0 ? 2 : 1;
                                            oo1.p.b(context2);
                                            w0Var.g = oo1.p.a().c(mo1.a.e).a("CAST_SENDER_SDK", new lo1.c("proto"), j0.a);
                                            if (bundle.containsKey("com.gnacba.amuvvoafs.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE")) {
                                                w0Var.e = Long.valueOf(bundle.getLong("com.gnacba.amuvvoafs.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE"));
                                            }
                                            SharedPreferences sharedPreferences = context2.getApplicationContext().getSharedPreferences(strC, 0);
                                            if (i22 != 0) {
                                                q qVarB2 = q.b();
                                                qVarB2.d = new n9.e0(tVar2, new String[]{"com.gnacba.amuvvoafs.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.gnacba.amuvvoafs.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"});
                                                qVarB2.a = new rp1.d[]{z.c};
                                                qVarB2.b = false;
                                                qVarB2.c = 8426;
                                                tVar2.c(0, qVarB2.a()).addOnSuccessListener(new g0(w0Var, packageName, i22, sharedPreferences));
                                            }
                                            if (z) {
                                                f0.h(sharedPreferences);
                                                l2.a(sharedPreferences, w0Var, packageName).c();
                                                l2.b(l1.g);
                                            }
                                            break;
                                        }
                                        break;
                                    default:
                                        this.b.getClass();
                                        un0.m.z0(bundle, "com.gnacba.amuvvoafs.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES");
                                        break;
                                }
                            }
                        });
                    } catch (RemoteException e) {
                        throw new IllegalStateException("Failed to call addAppVisibilityListener", e);
                    }
                } catch (RemoteException e2) {
                    throw new IllegalStateException("Failed to call getSessionManagerImpl", e2);
                }
            } catch (RemoteException e3) {
                throw new IllegalStateException("Failed to call getDiscoveryManagerImpl", e3);
            }
        } catch (RemoteException e4) {
            throw new IllegalStateException("Failed to call newCastContextImpl", e4);
        }
    }

    public static a b(Context context) {
        f0.d("Must be called from the main thread.");
        if (m == null) {
            synchronized (l) {
                if (m == null) {
                    Context applicationContext = context.getApplicationContext();
                    d dVarC = c(applicationContext);
                    b castOptions = dVarC.getCastOptions(applicationContext);
                    t tVar = new t(applicationContext);
                    try {
                        m = new a(applicationContext, castOptions, dVarC.getAdditionalSessionProviders(applicationContext), new s(applicationContext, bb.f0.d(applicationContext), castOptions, tVar), tVar);
                    } catch (ModuleUnavailableException e) {
                        throw new RuntimeException((Throwable) e);
                    }
                }
            }
        }
        return m;
    }

    public static d c(Context context) {
        try {
            Bundle bundle = aq1.d.a(context).d(128, context.getPackageName()).metaData;
            if (bundle == null) {
                k.c(new Object[0]);
            }
            String string = bundle.getString("com.gnacba.amuvvoafs.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME");
            if (string != null) {
                return (d) Class.forName(string).asSubclass(d.class).getDeclaredConstructor(null).newInstance(null);
            }
            throw new IllegalStateException("The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.gnacba.amuvvoafs.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME.");
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e) {
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        }
    }

    public final g a() {
        f0.d("Must be called from the main thread.");
        return this.b;
    }
}
