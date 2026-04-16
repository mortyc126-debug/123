package v80;

import amuvvoafs.content.Context;
import amuvvoafs.content.SharedPreferences;
import amuvvoafs.util.Log;
import b60.z;
import com.bandlab.audiocore.generated.Snap;
import com.bandlab.audiocore.generated.Transport;
import com.bandlab.invite.band.InviteToBandActivity;
import com.bandlab.mixeditor.resources.impl.s;
import com.bandlab.user.profile.screen.UserProfileActivity;
import com.bandlab.write.post.screen.WritePostActivity;
import com.gnacba.amuvvoafs.gms.tasks.SuccessContinuation;
import com.gnacba.amuvvoafs.gms.tasks.Task;
import com.gnacba.amuvvoafs.gms.tasks.TaskCompletionSource;
import com.gnacba.amuvvoafs.gms.tasks.Tasks;
import dh1.e0;
import dh1.w;
import java.io.FileWriter;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import jv0.i0;
import k3.e;
import lmjxuqdtp.jvm.internal.o;
import ny1.r2;
import o10.a4;
import o10.c4;
import okhttp3.HttpUrl;
import org.json.JSONObject;
import qi1.k;
import qo1.b;
import rs1.g;
import rt1.f;
import vo1.j;
import vo1.l;
import w2.i;
import x10.r;
import xu1.a1;
import xu1.o0;
import xu1.z0;
import zk1.a0;
import zk1.b0;
import zk1.m;
import zk1.t;
import zu1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements b, SuccessContinuation, zu1.b, nd.a {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;

    public Object a(String str) {
        Object objA = ((vb0.a) this.b).a(str, (wy1.a) this.c);
        if (objA != null) {
            return objA;
        }
        throw new IllegalArgumentException(i.n("Invalid json in database value: `", str, "`").toString());
    }

    public Object b(Object obj) {
        o.h(obj, "value");
        return ((vb0.a) this.b).b(obj, (wy1.a) this.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(lmjxuqdtp.jvm.functions.Function2 r8, qx1.d r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof yp.w
            if (r0 == 0) goto L13
            r0 = r9
            yp.w r0 = (yp.w) r0
            int r1 = r0.o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.o = r1
            goto L18
        L13:
            yp.w r0 = new yp.w
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.m
            rx1.a r1 = rx1.a.a
            int r2 = r0.o
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L46
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            ty1.a r8 = r0.k
            lg.e.O(r9)     // Catch: java.lang.Throwable -> L2d
            goto L76
        L2d:
            r9 = move-exception
            goto L7e
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            int r8 = r0.l
            ty1.a r2 = r0.k
            sx1.i r4 = r0.j
            lmjxuqdtp.jvm.functions.Function2 r4 = (lmjxuqdtp.jvm.functions.Function2) r4
            lg.e.O(r9)
            r9 = r2
            r2 = r8
            r8 = r4
            goto L60
        L46:
            lg.e.O(r9)
            java.lang.Object r9 = r7.c
            ty1.c r9 = (ty1.c) r9
            r2 = r8
            sx1.i r2 = (sx1.i) r2
            r0.j = r2
            r0.k = r9
            r2 = 0
            r0.l = r2
            r0.o = r4
            java.lang.Object r4 = r9.a(r0)
            if (r4 != r1) goto L60
            goto L72
        L60:
            java.lang.Object r4 = r7.b     // Catch: java.lang.Throwable -> L7a
            yp.b r4 = (yp.b) r4     // Catch: java.lang.Throwable -> L7a
            r0.j = r5     // Catch: java.lang.Throwable -> L7a
            r0.k = r9     // Catch: java.lang.Throwable -> L7a
            r0.l = r2     // Catch: java.lang.Throwable -> L7a
            r0.o = r3     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r8 = r8.invoke(r4, r0)     // Catch: java.lang.Throwable -> L7a
            if (r8 != r1) goto L73
        L72:
            return r1
        L73:
            r6 = r9
            r9 = r8
            r8 = r6
        L76:
            r8.c(r5)
            return r9
        L7a:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L7e:
            r8.c(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: v80.h.c(lmjxuqdtp.jvm.functions.Function2, qx1.d):java.lang.Object");
    }

    public void d(i iVar, int i, int i2, int i3) {
        int i4;
        e eVar = (e) this.c;
        int i6 = eVar.c;
        if (i6 == 0) {
            i4 = 0;
        } else {
            if (i6 == 0) {
                throw new NoSuchElementException("MutableVector is empty.");
            }
            i iVar2 = (i) eVar.a[i6 - 1];
            i4 = iVar2.b - iVar2.d;
        }
        if (iVar == null) {
            int i7 = i - i4;
            iVar = new i(i, i2 + i3, i7, (i2 - i) + i7);
        } else {
            if (iVar.a > i) {
                iVar.a = i;
                iVar.c = i;
            }
            int i8 = iVar.b;
            if (i2 > i8) {
                int i9 = i8 - iVar.d;
                iVar.b = i2;
                iVar.d = i2 - i9;
            }
            iVar.b += i3;
        }
        eVar.d(iVar);
    }

    public void e(z11.e eVar) {
        s02.d.a.getClass();
        s02.b.t("Cycle:: apply state: " + eVar);
        Transport transport = (Transport) this.b;
        transport.setCycleState(eVar.c);
        double d = eVar.a;
        double d3 = eVar.b;
        Snap snapToGrid = transport.getSnapToGrid();
        o.g(snapToGrid, "getSnapToGrid(...)");
        transport.setCycleStartAndEnd(d, d3, snapToGrid != Snap.TO_NONE);
        h();
    }

    public void f() {
        ((e) this.b).k();
    }

    public boolean g() {
        Transport transport = (Transport) this.b;
        return (transport.isPlaying() || transport.isRecording()) ? false : true;
    }

    public Object get() {
        switch (this.a) {
            case 1:
                f fVar = new f();
                g gVar = new g(16);
                Object obj = ((kx1.a) this.b).get();
                kx1.a aVar = (kx1.a) this.c;
                return new j(fVar, gVar, vo1.a.f, (l) obj, aVar);
            default:
                return new o0((z0) ((kx1.a) this.b).get(), (a1) ((c) this.c).get());
        }
    }

    public void h() {
        Transport transport = (Transport) this.b;
        r2 r2Var = (r2) this.c;
        while (true) {
            Object value = r2Var.getValue();
            s02.b bVar = s02.d.a;
            double cycleStartTime = transport.getCycleStartTime();
            double cycleEndTime = transport.getCycleEndTime();
            boolean cycleState = transport.getCycleState();
            double tempo = transport.getTempo();
            int ticksPerQ = transport.getTicksPerQ();
            double barLengthInTicks = transport.getBarLengthInTicks();
            Transport transport2 = transport;
            StringBuilder sb = new StringBuilder("start: ");
            sb.append(cycleStartTime);
            sb.append(", end: ");
            sb.append(cycleEndTime);
            sb.append(", state: ");
            sb.append(cycleState);
            s1.a.w(sb, ", tempo: ", tempo, ", tpq: ");
            sb.append(ticksPerQ);
            sb.append(", bar: ");
            sb.append(barLengthInTicks);
            i.A("Cycle:: edited - ", sb.toString(), bVar);
            if (r2Var.d(value, new z11.e(transport2.getCycleStartTime(), transport2.getCycleEndTime(), transport2.getCycleState(), ((z11.e) value).d))) {
                return;
            } else {
                transport = transport2;
            }
        }
    }

    public xu0.l i(String str, String str2) {
        w wVarC = ((i0) this.c).a.c();
        a0 a0VarD = null;
        m10.i iVarA = wVarC != null ? e0.a(wVarC) : null;
        m mVar = WritePostActivity.n;
        Context context = (Context) this.b;
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String str3 = str;
        if (str2 != null) {
            b0.Companion.getClass();
            a0VarD = t.d(str2);
        }
        zk1.e0 e0Var = new zk1.e0(iVarA, str3, a0VarD, false, false, (zk1.h) null, (nz0.b) null, a4.v, 2032);
        mVar.getClass();
        return new xu0.l(m.b(context, e0Var), -1);
    }

    public xu0.l j(String str) {
        o.h(str, "bandId");
        int i = InviteToBandActivity.n;
        return new xu0.l(k0.d.t((Context) this.c, str), -1);
    }

    public xu0.l k(String str) {
        lh1.a aVar = lh1.a.h;
        o.h(str, "userId");
        return new xu0.l(k.d(UserProfileActivity.m, (Context) this.c, str, (w) null, (oh1.f) null, false, aVar, (q10.i0) null, (lx1.l) null, (c4) null, 476), -1);
    }

    public Task then(Object obj) throws Throwable {
        FileWriter fileWriter;
        z zVar = (z) this.c;
        JSONObject jSONObject = (JSONObject) ((qt1.e) this.b).c.a.submit((Callable) new ig.b(5, this)).get();
        FileWriter fileWriter2 = null;
        if (jSONObject != null) {
            xt1.a aVarT = ((vp1.b) zVar.c).t(jSONObject);
            dl.f fVar = (dl.f) zVar.e;
            long j2 = aVarT.c;
            fVar.getClass();
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "Writing settings to cache file...", (Throwable) null);
            }
            try {
                jSONObject.put("expires_at", j2);
                fileWriter = new FileWriter(fVar.a);
            } catch (Exception e) {
                e = e;
                fileWriter = null;
            } catch (Throwable th) {
                th = th;
                pt1.i.b(fileWriter2, "Failed to close settings writer.");
                throw th;
            }
            try {
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter2 = fileWriter;
                    pt1.i.b(fileWriter2, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                Log.e("FirebaseCrashlytics", "Failed to cache settings", e);
            }
            pt1.i.b(fileWriter, "Failed to close settings writer.");
            z.g("Loaded settings: ", jSONObject);
            String str = (String) ((s) zVar.b).g;
            SharedPreferences.Editor editorEdit = ((Context) zVar.a).getSharedPreferences("com.gnacba.firebase.crashlytics", 0).edit();
            editorEdit.putString("existing_instance_identifier", str);
            editorEdit.apply();
            ((AtomicReference) zVar.h).set(aVarT);
            ((TaskCompletionSource) ((AtomicReference) zVar.i).get()).trySetResult(aVarT);
        }
        return Tasks.forResult((Object) null);
    }

    public String toString() {
        switch (this.a) {
            case 2:
                StringBuilder sb = new StringBuilder("ChangeList(changes=[");
                e eVar = (e) this.b;
                Object[] objArr = eVar.a;
                int i = eVar.c;
                for (int i2 = 0; i2 < i; i2++) {
                    i iVar = (i) objArr[i2];
                    sb.append("(" + iVar.c + ',' + iVar.d + ")->(" + iVar.a + ',' + iVar.b + ')');
                    if (i2 < ((e) this.b).c - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("])");
                String string = sb.toString();
                o.g(string, "toString(...)");
                return string;
            default:
                return super.toString();
        }
    }

    public /* synthetic */ h(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public h(vb0.a aVar, wy1.a aVar2) {
        this.a = 7;
        o.h(aVar, "jsonMapper");
        o.h(aVar2, "serializer");
        this.b = aVar;
        this.c = aVar2;
    }

    public h(d01.k kVar, i11.t tVar) {
        this.a = 10;
        this.b = tVar;
        this.c = kVar.a(ze0.c.c);
    }

    public h(Transport transport) {
        this.a = 11;
        this.b = transport;
        this.c = ny1.z.c(new z11.e(transport.getCycleStartTime(), transport.getCycleEndTime(), transport.getCycleState(), true));
    }

    public h(h hVar) {
        e eVar;
        this.a = 2;
        this.b = new e(0, new i[16]);
        this.c = new e(0, new i[16]);
        if (hVar == null || (eVar = (e) hVar.b) == null) {
            return;
        }
        Object[] objArr = eVar.a;
        int i = eVar.c;
        for (int i2 = 0; i2 < i; i2++) {
            i iVar = (i) objArr[i2];
            ((e) this.b).d(new i(iVar.a, iVar.b, iVar.c, iVar.d));
        }
    }

    public h(yp.b bVar) {
        this.a = 9;
        this.b = bVar;
        this.c = ty1.d.a();
    }

    public h(z zVar, qt1.e eVar) {
        this.a = 5;
        this.c = zVar;
        this.b = eVar;
    }

    public h(r rVar) {
        this.a = 4;
        this.b = ny1.z.c(Boolean.FALSE);
        this.c = rVar;
    }
}
