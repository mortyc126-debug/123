package tlydtdl.localbroadcastmanager.content;

import amuvvoafs.media.MediaCodec;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import amuvvoafs.os.Message;
import amuvvoafs.util.Log;
import amuvvoafs.util.SparseArray;
import bb.b1;
import bb.d0;
import bb.f;
import bb.m;
import bb.n;
import bb.p;
import bb.s;
import bb.s0;
import bb.t0;
import bb.u;
import bb.v;
import bb.v0;
import bb.w0;
import bb.y0;
import bb.z0;
import com.gnacba.amuvvoafs.gms.internal.ads.u02;
import com.gnacba.amuvvoafs.gms.internal.ads.v02;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Handler {
    public final /* synthetic */ int a = 2;
    public final Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(v02 v02Var, Looper looper) {
        super(looper);
        Objects.requireNonNull(v02Var);
        this.b = v02Var;
    }

    public final void handleMessage(Message message) {
        switch (this.a) {
            case 0:
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                } else {
                    ((LocalBroadcastManager) this.b).executePendingBroadcasts();
                    return;
                }
            case 1:
                u uVar = (u) this.b;
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                    uVar.f = false;
                    uVar.e(uVar.e);
                    return;
                }
                uVar.h = false;
                bb.a aVar = uVar.d;
                if (aVar != null) {
                    v vVar = uVar.g;
                    f fVar = aVar.a;
                    d0 d0VarD = fVar.d(uVar);
                    if (d0VarD != null) {
                        fVar.n(d0VarD, vVar);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                s0 s0Var = (s0) ((WeakReference) this.b).get();
                if (s0Var != null) {
                    SparseArray sparseArray = s0Var.h;
                    y0 y0Var = s0Var.i;
                    ArrayList arrayList = y0Var.k;
                    int i2 = message.what;
                    int i3 = message.arg1;
                    int i4 = message.arg2;
                    Object obj = message.obj;
                    Bundle bundlePeekData = message.peekData();
                    switch (i2) {
                        case 0:
                            if (i3 == s0Var.g) {
                                s0Var.g = 0;
                                if (y0Var.n == s0Var) {
                                    y0Var.k();
                                }
                            }
                            if (((v0) sparseArray.get(i3)) != null) {
                                sparseArray.remove(i3);
                                v0.a((Bundle) null, (String) null);
                                return;
                            }
                            return;
                        case 1:
                            return;
                        case 2:
                            if (obj == null || (obj instanceof Bundle)) {
                                Bundle bundle = (Bundle) obj;
                                if (s0Var.f == 0 && i3 == s0Var.g && i4 >= 1) {
                                    s0Var.g = 0;
                                    s0Var.f = i4;
                                    v vVarA = v.a(bundle);
                                    if (y0Var.n == s0Var) {
                                        y0Var.f(vVarA);
                                    }
                                    if (y0Var.n == s0Var) {
                                        y0Var.o = true;
                                        int size = arrayList.size();
                                        for (int i6 = 0; i6 < size; i6++) {
                                            ((t0) arrayList.get(i6)).c(y0Var.n);
                                        }
                                        n nVar = ((u) y0Var).e;
                                        if (nVar != null) {
                                            s0 s0Var2 = y0Var.n;
                                            int i7 = s0Var2.d;
                                            s0Var2.d = i7 + 1;
                                            s0Var2.b(10, i7, 0, nVar.a, (Bundle) null);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            }
                            break;
                        case 3:
                            if (obj == null || (obj instanceof Bundle)) {
                                Bundle bundle2 = (Bundle) obj;
                                v0 v0Var = (v0) sparseArray.get(i3);
                                if (v0Var != null) {
                                    sparseArray.remove(i3);
                                    v0Var.b(bundle2);
                                    return;
                                }
                            }
                            break;
                        case 4:
                            if (obj == null || (obj instanceof Bundle)) {
                                string = bundlePeekData != null ? bundlePeekData.getString("error") : null;
                                Bundle bundle3 = (Bundle) obj;
                                if (((v0) sparseArray.get(i3)) != null) {
                                    sparseArray.remove(i3);
                                    v0.a(bundle3, string);
                                    return;
                                }
                            }
                            break;
                        case 5:
                            if (obj == null || (obj instanceof Bundle)) {
                                Bundle bundle4 = (Bundle) obj;
                                if (s0Var.f != 0) {
                                    v vVarA2 = v.a(bundle4);
                                    if (y0Var.n == s0Var) {
                                        y0Var.f(vVarA2);
                                        return;
                                    }
                                    return;
                                }
                            }
                            break;
                        case 6:
                            if (obj instanceof Bundle) {
                                Bundle bundle5 = (Bundle) obj;
                                v0 v0Var2 = (v0) sparseArray.get(i3);
                                if (bundle5.containsKey("routeId")) {
                                    sparseArray.remove(i3);
                                    v0Var2.b(bundle5);
                                } else {
                                    v0Var2.getClass();
                                    v0.a(bundle5, "DynamicGroupRouteController is created without valid route id.");
                                }
                            } else {
                                Log.w("MediaRouteProviderProxy", "No further information on the dynamic group controller");
                            }
                            break;
                        case 7:
                            if (obj == null || (obj instanceof Bundle)) {
                                Bundle bundle6 = (Bundle) obj;
                                if (s0Var.f != 0) {
                                    Bundle parcelable = bundle6.getParcelable("groupRoute");
                                    m mVar = parcelable != null ? new m(parcelable) : null;
                                    ArrayList parcelableArrayList = bundle6.getParcelableArrayList("dynamicRoutes");
                                    ArrayList arrayList2 = new ArrayList();
                                    Iterator it = parcelableArrayList.iterator();
                                    while (it.hasNext()) {
                                        arrayList2.add(p.a((Bundle) it.next()));
                                    }
                                    if (y0Var.n == s0Var) {
                                        Iterator it2 = arrayList.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                u02 u02Var = (t0) it2.next();
                                                if (u02Var.a() == i4) {
                                                    string = u02Var;
                                                }
                                            }
                                        }
                                        if (string instanceof w0) {
                                            ((w0) string).k(mVar, arrayList2);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            }
                            break;
                        case 8:
                            if (y0Var.n == s0Var) {
                                Iterator it3 = arrayList.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        u02 u02Var2 = (t0) it3.next();
                                        if (u02Var2.a() == i4) {
                                            string = u02Var2;
                                        }
                                    }
                                }
                                z0 z0Var = y0Var.p;
                                if (z0Var != null && (string instanceof s)) {
                                    s sVar = (s) string;
                                    f fVar2 = (f) ((b1) z0Var.b).c;
                                    if (fVar2.e == sVar) {
                                        fVar2.j(fVar2.c(), 2, true);
                                    }
                                }
                                if (string != null) {
                                    arrayList.remove(string);
                                    string.b();
                                    y0Var.l();
                                }
                            }
                            break;
                    }
                    int i8 = y0.q;
                    return;
                }
                return;
            default:
                v02 v02Var = (v02) this.b;
                v02Var.getClass();
                int i9 = message.what;
                if (i9 == 1) {
                    u02 u02Var3 = (u02) message.obj;
                    try {
                        v02Var.a.queueInputBuffer(u02Var3.a, 0, u02Var3.b, u02Var3.d, u02Var3.e);
                        break;
                    } catch (RuntimeException e) {
                        AtomicReference atomicReference = v02Var.d;
                        while (!atomicReference.compareAndSet(null, e) && atomicReference.get() == null) {
                        }
                    }
                    string = u02Var3;
                } else if (i9 == 2) {
                    u02 u02Var4 = (u02) message.obj;
                    int i10 = u02Var4.a;
                    MediaCodec.CryptoInfo cryptoInfo = u02Var4.c;
                    long j2 = u02Var4.d;
                    int i11 = u02Var4.e;
                    try {
                        synchronized (v02.h) {
                            v02Var.a.queueSecureInputBuffer(i10, 0, cryptoInfo, j2, i11);
                            break;
                        }
                    } catch (RuntimeException e2) {
                        AtomicReference atomicReference2 = v02Var.d;
                        while (!atomicReference2.compareAndSet(null, e2) && atomicReference2.get() == null) {
                        }
                    }
                    string = u02Var4;
                } else if (i9 == 3) {
                    v02Var.e.a();
                } else if (i9 != 4) {
                    AtomicReference atomicReference3 = v02Var.d;
                    IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(message.what));
                    while (!atomicReference3.compareAndSet(null, illegalStateException) && atomicReference3.get() == null) {
                    }
                } else {
                    try {
                        v02Var.a.setParameters((Bundle) message.obj);
                        break;
                    } catch (RuntimeException e3) {
                        AtomicReference atomicReference4 = v02Var.d;
                        while (!atomicReference4.compareAndSet(null, e3) && atomicReference4.get() == null) {
                        }
                    }
                }
                if (string != null) {
                    ArrayDeque arrayDeque = v02.g;
                    synchronized (arrayDeque) {
                        arrayDeque.add(string);
                        break;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(LocalBroadcastManager localBroadcastManager, Looper looper) {
        super(looper);
        this.b = localBroadcastManager;
    }

    public a(u uVar) {
        this.b = uVar;
    }

    public a(s0 s0Var) {
        this.b = new WeakReference(s0Var);
    }
}
