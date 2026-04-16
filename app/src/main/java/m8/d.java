package m8;

import a2.x3;
import amuvvoafs.content.Context;
import amuvvoafs.media.AudioManager;
import amuvvoafs.os.Looper;
import amuvvoafs.view.View;
import bb.w;
import bh.j;
import bz1.c;
import cn1.k;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.facebook.appevents.p;
import com.facebook.internal.t0;
import com.gnacba.amuvvoafs.gms.internal.ads.py0;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.gnacba.amuvvoafs.gms.tasks.Task;
import com.google.android.material.R;
import d5.h0;
import d5.p0;
import d5.t;
import di0.z;
import f3.f2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.LongCompanionObject;
import ky1.a0;
import ky1.c0;
import ky1.e1;
import ky1.f1;
import ld1.r;
import lf.y;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.g0;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import mx1.n;
import o8.b;
import okhttp3.HttpUrl;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import p02.u;
import p5.q;
import q4.t1;
import st.w0;
import t4.r0;
import tlydtdl.compose.foundation.layout.j2;
import tlydtdl.compose.foundation.layout.l2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.s0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.f3;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.tooling.DiagnosticComposeException;
import tlydtdl.compose.runtime.u1;
import tlydtdl.compose.runtime.x0;
import vx1.a;
import x10.v;
import y11.b3;
import y11.d2;
import y11.d4;
import y11.g1;
import y11.g3;
import y11.h3;
import y11.l1;
import y11.o1;
import y11.r1;
import y11.s2;
import y11.v2;
import yy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static AudioManager a;

    public static final void A(ArrayList arrayList, long j2, Function1 function1) {
        int size = arrayList.size();
        for (int iX = x(p0.g(j2), arrayList); iX < size; iX++) {
            t tVar = (t) arrayList.get(iX);
            if (tVar.b >= p0.f(j2)) {
                return;
            }
            if (tVar.b != tVar.c) {
                function1.invoke(tVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00d0 A[Catch: all -> 0x00e3, Exception -> 0x00e7, TryCatch #8 {Exception -> 0x00e7, all -> 0x00e3, blocks: (B:156:0x00c2, B:158:0x00d0, B:160:0x00d4, B:167:0x00ec, B:169:0x0106, B:171:0x0113, B:178:0x0132, B:180:0x0138, B:183:0x0144, B:185:0x0148, B:186:0x0151, B:174:0x011d, B:176:0x012a, B:208:0x01b4, B:209:0x01bb), top: B:230:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0138 A[Catch: all -> 0x00e3, Exception -> 0x00e7, TryCatch #8 {Exception -> 0x00e7, all -> 0x00e3, blocks: (B:156:0x00c2, B:158:0x00d0, B:160:0x00d4, B:167:0x00ec, B:169:0x0106, B:171:0x0113, B:178:0x0132, B:180:0x0138, B:183:0x0144, B:185:0x0148, B:186:0x0151, B:174:0x011d, B:176:0x012a, B:208:0x01b4, B:209:0x01bb), top: B:230:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0144 A[Catch: all -> 0x00e3, Exception -> 0x00e7, TryCatch #8 {Exception -> 0x00e7, all -> 0x00e3, blocks: (B:156:0x00c2, B:158:0x00d0, B:160:0x00d4, B:167:0x00ec, B:169:0x0106, B:171:0x0113, B:178:0x0132, B:180:0x0138, B:183:0x0144, B:185:0x0148, B:186:0x0151, B:174:0x011d, B:176:0x012a, B:208:0x01b4, B:209:0x01bb), top: B:230:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0148 A[Catch: all -> 0x00e3, Exception -> 0x00e7, TryCatch #8 {Exception -> 0x00e7, all -> 0x00e3, blocks: (B:156:0x00c2, B:158:0x00d0, B:160:0x00d4, B:167:0x00ec, B:169:0x0106, B:171:0x0113, B:178:0x0132, B:180:0x0138, B:183:0x0144, B:185:0x0148, B:186:0x0151, B:174:0x011d, B:176:0x012a, B:208:0x01b4, B:209:0x01bb), top: B:230:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0151 A[Catch: all -> 0x00e3, Exception -> 0x00e7, TRY_LEAVE, TryCatch #8 {Exception -> 0x00e7, all -> 0x00e3, blocks: (B:156:0x00c2, B:158:0x00d0, B:160:0x00d4, B:167:0x00ec, B:169:0x0106, B:171:0x0113, B:178:0x0132, B:180:0x0138, B:183:0x0144, B:185:0x0148, B:186:0x0151, B:174:0x011d, B:176:0x012a, B:208:0x01b4, B:209:0x01bb), top: B:230:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x01b4 A[Catch: all -> 0x00e3, Exception -> 0x00e7, TRY_ENTER, TryCatch #8 {Exception -> 0x00e7, all -> 0x00e3, blocks: (B:156:0x00c2, B:158:0x00d0, B:160:0x00d4, B:167:0x00ec, B:169:0x0106, B:171:0x0113, B:178:0x0132, B:180:0x0138, B:183:0x0144, B:185:0x0148, B:186:0x0151, B:174:0x011d, B:176:0x012a, B:208:0x01b4, B:209:0x01bb), top: B:230:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:231:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.internal.d B(amuvvoafs.content.Context r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.d.B(amuvvoafs.content.Context):com.facebook.internal.d");
    }

    public static synchronized AudioManager C(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                a = null;
            }
            AudioManager audioManager = a;
            if (audioManager != null) {
                return audioManager;
            }
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null && looperMyLooper != Looper.getMainLooper()) {
                py0 py0Var = new py0(5);
                b.o().execute(new k(17, applicationContext, py0Var));
                py0Var.d();
                AudioManager audioManager2 = a;
                audioManager2.getClass();
                return audioManager2;
            }
            AudioManager audioManager3 = (AudioManager) applicationContext.getSystemService("audio");
            a = audioManager3;
            audioManager3.getClass();
            return audioManager3;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x004e A[PHI: r1
  0x004e: PHI (r1v9 java.lang.String) = (r1v7 java.lang.String), (r1v10 java.lang.String) binds: [B:81:0x005a, B:74:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final m10.r D(y11.l1 r9) {
        /*
            java.lang.String r0 = "<this>"
            lmjxuqdtp.jvm.internal.o.h(r9, r0)
            m10.q r0 = r9.n
            y11.d4 r1 = r9.h
            y11.z3 r1 = st1.t1.s(r1)
            long r7 = r1.a
            y11.g4 r1 = r9.b()
            r2 = 0
            if (r1 == 0) goto L19
            m10.w r1 = r1.a
            goto L1a
        L19:
            r1 = r2
        L1a:
            m10.w r3 = m10.w.b
            java.lang.String r4 = ""
            if (r1 != r3) goto L47
            if (r0 == 0) goto L25
            java.lang.String r1 = r0.b
            goto L26
        L25:
            r1 = r2
        L26:
            if (r1 != 0) goto L29
            goto L2a
        L29:
            r4 = r1
        L2a:
            if (r0 == 0) goto L2f
            java.lang.String r0 = r0.a
            goto L30
        L2f:
            r0 = r2
        L30:
            y11.g4 r1 = r9.b()
            if (r1 == 0) goto L39
            java.lang.String r1 = r1.c
            goto L3a
        L39:
            r1 = r2
        L3a:
            y11.g4 r9 = r9.b()
            if (r9 == 0) goto L42
            java.lang.String r2 = r9.b
        L42:
            r6 = r1
            r5 = r2
        L44:
            r3 = r4
            r4 = r0
            goto L70
        L47:
            if (r0 == 0) goto L50
            java.lang.String r1 = r0.b
            if (r1 != 0) goto L4e
            goto L50
        L4e:
            r4 = r1
            goto L5c
        L50:
            y11.g4 r1 = r9.b()
            if (r1 == 0) goto L59
            java.lang.String r1 = r1.c
            goto L5a
        L59:
            r1 = r2
        L5a:
            if (r1 != 0) goto L4e
        L5c:
            if (r0 == 0) goto L62
            java.lang.String r0 = r0.a
            if (r0 != 0) goto L6d
        L62:
            y11.g4 r9 = r9.b()
            if (r9 == 0) goto L6c
            java.lang.String r9 = r9.b
            r0 = r9
            goto L6d
        L6c:
            r0 = r2
        L6d:
            r5 = r2
            r6 = r5
            goto L44
        L70:
            m10.r r2 = new m10.r
            r2.<init>(r3, r4, r5, r6, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.d.D(y11.l1):m10.r");
    }

    public static final long E(double d) {
        return K(4294967296L, (float) d);
    }

    public static final long F(int i) {
        return K(4294967296L, i);
    }

    public static final void G(a0 a0Var, Function1 function1) {
        o.h(a0Var, "<this>");
        qx1.i coroutineContext = a0Var.getCoroutineContext();
        f1 f1Var = coroutineContext.get(e1.a);
        if (f1Var != null) {
            f1Var.K(function1);
            return;
        }
        throw new IllegalArgumentException(("Job is not found in scope " + a0Var + " context " + coroutineContext).toString());
    }

    public static boolean H(String str) {
        return ("Connection".equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || HttpHeaders.UPGRADE.equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean I(Context context) {
        Method methodP = t0.P("com.gnacba.amuvvoafs.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[]{Context.class});
        if (methodP != null) {
            Object objY = t0.Y((Object) null, methodP, new Object[]{context});
            if ((objY instanceof Integer) && objY.equals(0)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean J(l1 l1Var) {
        o.h(l1Var, "<this>");
        String str = l1Var.a;
        return (p.U(str) || o.c(str, b3.a.a)) ? false : true;
    }

    public static final long K(long j2, float f2) {
        long jFloatToRawIntBits = j2 | (((long) Float.floatToRawIntBits(f2)) & 4294967295L);
        q[] qVarArr = p5.p.b;
        return jFloatToRawIntBits;
    }

    public static final Object L(h30.f fVar, Object obj) {
        o.h(fVar, "configSelector");
        s02.b bVar = s02.d.a;
        String str = "Remote Config: key=" + fVar.getKey() + ", value=" + obj;
        bVar.getClass();
        s02.b.p(str);
        if (obj == null || obj.equals(HttpUrl.FRAGMENT_ENCODE_SET)) {
            s02.b.p("Remote Config: config is " + obj + ", fall back to " + fVar.e());
            return fVar.e();
        }
        try {
            return fVar.a(obj);
        } catch (Throwable th) {
            w wVar = new w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[0]);
            j.w(HttpUrl.FRAGMENT_ENCODE_SET, new TaggedException(th, (String[]) arrayList.toArray(new String[arrayList.size()])));
            s02.b bVar2 = s02.d.a;
            String str2 = "Remote Config: can't parse config, fall back to " + fVar.e();
            bVar2.getClass();
            s02.b.p(str2);
            return fVar.e();
        }
    }

    public static final byte[] M(InputStream inputStream) throws IOException {
        o.h(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        t(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        o.g(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static final String N(l1 l1Var) {
        o.h(l1Var, "<this>");
        String str = l1Var.a;
        if (str == null || !p.T(str)) {
            str = null;
        }
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public static final void O(int i, int i2, Object[] objArr) {
        o.h(objArr, "<this>");
        while (i < i2) {
            objArr[i] = null;
            i++;
        }
    }

    public static final l1 P(y11.f1 f1Var) {
        h3 h3VarA;
        o.h(f1Var, "<this>");
        String id = f1Var.getId();
        String strP = f1Var.p();
        g1 g1VarL = f1Var.L();
        if (g1VarL != null) {
            h3.Companion.getClass();
            h3VarA = g3.a(g1VarL);
        } else {
            h3VarA = null;
        }
        String title = f1Var.getTitle();
        String description = f1Var.getDescription();
        d4 d4VarY0 = f1Var.y0();
        String strM = f1Var.M();
        String key = f1Var.getKey();
        v2 v2VarV = f1Var.v();
        o1 o1VarP0 = f1Var.p0();
        String strS = f1Var.S();
        if (strS == null) {
            strS = b3.b.o;
        }
        String str = strS;
        m10.q qVarH0 = f1Var.h0();
        boolean zR0 = f1Var.r0();
        boolean zQ = f1Var.Q();
        List listH = f1Var.h();
        List listM1 = listH != null ? mx1.o.m1(listH) : null;
        boolean zO = f1Var.o();
        boolean zE = f1Var.E();
        d2 d2VarX = f1Var.X();
        double volume = f1Var.getVolume();
        String strB0 = f1Var.b0();
        String strP2 = f1Var.P();
        r1 r1VarR = f1Var.R();
        s2 s2Var = f1Var instanceof s2 ? (s2) f1Var : null;
        return new l1(id, strP, h3VarA, title, description, d4VarY0, strM, key, v2VarV, o1VarP0, str, qVarH0, zR0, zQ, listM1, zO, zE, d2VarX, volume, strB0, strP2, r1VarR, s2Var != null ? s2Var.A : null, f1Var.k(), f1Var.m0(), 24);
    }

    public static final boolean Q(Throwable th, Function0 function0) {
        List listK;
        Object objInvoke;
        o.h(th, "<this>");
        Integer num = a.a;
        DiagnosticComposeException diagnosticComposeException = null;
        if (num == null || num.intValue() >= 19) {
            Throwable[] suppressed = th.getSuppressed();
            o.g(suppressed, "getSuppressed(...)");
            listK = n.K(suppressed);
        } else {
            Method method = ux1.a.b;
            listK = (method == null || (objInvoke = method.invoke(th, null)) == null) ? mx1.t.a : n.K((Throwable[]) objInvoke);
        }
        boolean z = false;
        if (!listK.isEmpty()) {
            Iterator it = listK.iterator();
            while (it.hasNext()) {
                if (((Throwable) it.next()) instanceof DiagnosticComposeException) {
                    return false;
                }
            }
        }
        try {
            List list = (List) function0.invoke();
            boolean zIsEmpty = list.isEmpty();
            z = !zIsEmpty;
            if (!zIsEmpty) {
                diagnosticComposeException = new DiagnosticComposeException(list);
            }
        } catch (Throwable th2) {
            diagnosticComposeException = th2;
        }
        if (diagnosticComposeException != null) {
            h02.a.k(th, diagnosticComposeException);
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:269:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:463:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(lmjxuqdtp.jvm.functions.Function0 r29, java.lang.String r30, lmjxuqdtp.jvm.functions.Function0 r31, t3.p r32, java.lang.String r33, java.lang.String r34, ld1.r r35, ld1.r r36, ld1.r r37, boolean r38, lmjxuqdtp.jvm.functions.Function0 r39, lmjxuqdtp.jvm.functions.Function0 r40, java.lang.String r41, java.lang.String r42, tlydtdl.compose.foundation.layout.s0 r43, tlydtdl.compose.runtime.m r44, int r45, int r46, int r47) {
        /*
            Method dump skipped, instruction units count: 922
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.d.a(lmjxuqdtp.jvm.functions.Function0, java.lang.String, lmjxuqdtp.jvm.functions.Function0, t3.p, java.lang.String, java.lang.String, ld1.r, ld1.r, ld1.r, boolean, lmjxuqdtp.jvm.functions.Function0, lmjxuqdtp.jvm.functions.Function0, java.lang.String, java.lang.String, tlydtdl.compose.foundation.layout.s0, tlydtdl.compose.runtime.m, int, int, int):void");
    }

    public static final void b(xd1.d dVar, t3.p pVar, s0 s0Var, tlydtdl.compose.runtime.m mVar, int i, int i2) {
        int i3;
        s sVar;
        t3.p pVar2;
        s0 s0Var2;
        int i4;
        t3.p pVar3;
        s0 s0Var3;
        s sVar2 = (s) mVar;
        sVar2.h0(2063247182);
        if ((i & 6) == 0) {
            i3 = (sVar2.g(dVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= sVar2.g(pVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= ((i2 & 4) == 0 && sVar2.g(s0Var)) ? 256 : 128;
        }
        if (sVar2.W(i3 & 1, (i3 & 147) != 146)) {
            sVar2.b0();
            if ((i & 1) == 0 || sVar2.D()) {
                t3.p pVar4 = i6 != 0 ? t3.m.a : pVar;
                if ((i2 & 4) != 0) {
                    i4 = i3 & (-897);
                    pVar3 = pVar4;
                    s0Var3 = new s0(7);
                } else {
                    i4 = i3;
                    pVar3 = pVar4;
                    s0Var3 = s0Var;
                }
            } else {
                sVar2.Z();
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                s0Var3 = s0Var;
                i4 = i3;
                pVar3 = pVar;
            }
            sVar2.s();
            if (dVar == null) {
                a2 a2VarV = sVar2.v();
                if (a2VarV != null) {
                    a2VarV.d = new xd1.a(dVar, pVar3, s0Var3, i, i2, 0);
                    return;
                }
                return;
            }
            sVar = sVar2;
            t3.p pVar5 = pVar3;
            s0 s0Var4 = s0Var3;
            t1.a(pVar5, dVar.f, s0Var4, q3.p.d(-170461450, new uc0.b(13, dVar), sVar2), sVar, (i4 & 896) | ((i4 >> 3) & 14) | 3072, 0);
            s0Var2 = s0Var4;
            pVar2 = pVar5;
        } else {
            sVar = sVar2;
            sVar.Z();
            pVar2 = pVar;
            s0Var2 = s0Var;
        }
        a2 a2VarV2 = sVar.v();
        if (a2VarV2 != null) {
            a2VarV2.d = new xd1.a(dVar, pVar2, s0Var2, i, i2, 1);
        }
    }

    public static final void c(ny1.l lVar, t3.p pVar, s0 s0Var, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        t3.p pVar2;
        s0 s0Var2;
        int i3;
        o.h(lVar, "flow");
        s sVar = (s) mVar;
        sVar.h0(-1637861439);
        if ((i & 6) == 0) {
            i2 = (sVar.i(lVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i4 = i2 | 48;
        if ((i & 384) == 0) {
            i4 = i2 | 176;
        }
        if (sVar.W(i4 & 1, (i4 & 147) != 146)) {
            sVar.b0();
            if ((i & 1) == 0 || sVar.D()) {
                s0Var = new s0(7);
                i3 = i4 & (-897);
                pVar = t3.m.a;
            } else {
                sVar.Z();
                i3 = i4 & (-897);
            }
            t3.p pVar3 = pVar;
            s0 s0Var3 = s0Var;
            sVar.s();
            b((xd1.d) w0.p(lVar, (Object) null, sVar, (i3 & 14) | 48).getValue(), pVar3, s0Var3, sVar, i3 & 1008, 0);
            pVar2 = pVar3;
            s0Var2 = s0Var3;
        } else {
            sVar.Z();
            pVar2 = pVar;
            s0Var2 = s0Var;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new je1.o(lVar, pVar2, s0Var2, i, 1);
        }
    }

    public static bz1.s d(Function1 function1) throws NoWhenBranchMatchedException {
        bz1.b bVar = c.d;
        o.h(bVar, "from");
        bz1.h hVar = new bz1.h();
        bz1.j jVar = ((c) bVar).a;
        hVar.a = jVar.a;
        hVar.b = jVar.d;
        hVar.c = jVar.b;
        hVar.d = jVar.c;
        String str = jVar.e;
        hVar.e = jVar.f;
        String str2 = jVar.g;
        bz1.a aVar = jVar.i;
        hVar.f = jVar.h;
        hVar.g = ((c) bVar).b;
        function1.invoke(hVar);
        if (!o.c(str, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        bz1.j jVar2 = new bz1.j(hVar.a, hVar.c, hVar.d, hVar.b, str, hVar.e, str2, hVar.f, aVar);
        xwfkdfdvbiz.serialization.modules.d dVar = hVar.g;
        o.h(dVar, "module");
        bz1.s sVar = new bz1.s(jVar2, dVar);
        if (!dVar.equals(xwfkdfdvbiz.serialization.modules.g.a)) {
            boolean z = jVar2.i != bz1.a.a;
            xwfkdfdvbiz.serialization.modules.d dVar2 = dVar;
            for (Map.Entry entry : dVar2.a.entrySet()) {
                fy1.c cVar = (fy1.c) entry.getKey();
                xwfkdfdvbiz.serialization.modules.b bVar2 = (xwfkdfdvbiz.serialization.modules.c) entry.getValue();
                if (bVar2 instanceof xwfkdfdvbiz.serialization.modules.a) {
                    o.f(cVar, "null cannot be cast to non-null type lmjxuqdtp.reflect.KClass<lmjxuqdtp.Any>");
                    o.f(((xwfkdfdvbiz.serialization.modules.a) bVar2).b(), "null cannot be cast to non-null type xwfkdfdvbiz.serialization.KSerializer<lmjxuqdtp.Any>");
                } else {
                    if (!(bVar2 instanceof xwfkdfdvbiz.serialization.modules.b)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Function1 function1B = bVar2.b();
                    o.h(cVar, "kClass");
                    o.h(function1B, "provider");
                }
            }
            for (Map.Entry entry2 : dVar2.b.entrySet()) {
                fy1.c cVar2 = (fy1.c) entry2.getKey();
                for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                    lmjxuqdtp.jvm.internal.f fVar = (fy1.c) entry3.getKey();
                    wy1.a aVar2 = (wy1.a) entry3.getValue();
                    o.f(cVar2, "null cannot be cast to non-null type lmjxuqdtp.reflect.KClass<lmjxuqdtp.Any>");
                    o.f(fVar, "null cannot be cast to non-null type lmjxuqdtp.reflect.KClass<lmjxuqdtp.Any>");
                    o.f(aVar2, "null cannot be cast to non-null type xwfkdfdvbiz.serialization.KSerializer<T of xwfkdfdvbiz.serialization.internal.Platform_commonKt.cast>");
                    yy1.h descriptor = aVar2.getDescriptor();
                    j4 j4VarD = descriptor.d();
                    if ((j4VarD instanceof e) || o.c(j4VarD, yy1.j.c)) {
                        throw new IllegalArgumentException("Serializer for " + fVar.f() + " can't be registered as a subclass for polymorphic serialization because its kind " + j4VarD + " is not concrete. To work with multiple hierarchies, register it as a base class.");
                    }
                    if (z && (o.c(j4VarD, yy1.l.d) || o.c(j4VarD, yy1.l.e) || (j4VarD instanceof yy1.g) || (j4VarD instanceof yy1.k))) {
                        throw new IllegalArgumentException("Serializer for " + fVar.f() + " of kind " + j4VarD + " cannot be serialized polymorphically with class discriminator.");
                    }
                    if (z) {
                        int iE = descriptor.e();
                        for (int i = 0; i < iE; i++) {
                            String strF = descriptor.f(i);
                            if (o.c(strF, jVar2.g)) {
                                throw new IllegalArgumentException("Polymorphic serializer for " + fVar + " has property '" + strF + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
                            }
                        }
                    }
                }
            }
            for (Map.Entry entry4 : dVar2.c.entrySet()) {
                fy1.c cVar3 = (fy1.c) entry4.getKey();
                Function1 function12 = (Function1) entry4.getValue();
                o.f(cVar3, "null cannot be cast to non-null type lmjxuqdtp.reflect.KClass<lmjxuqdtp.Any>");
                o.f(function12, "null cannot be cast to non-null type lmjxuqdtp.Function1<@[ParameterName(name = \"value\")] lmjxuqdtp.Any, xwfkdfdvbiz.serialization.SerializationStrategy<lmjxuqdtp.Any>?>");
                g0.d(1, function12);
            }
            for (Map.Entry entry5 : dVar2.e.entrySet()) {
                fy1.c cVar4 = (fy1.c) entry5.getKey();
                Function1 function13 = (Function1) entry5.getValue();
                o.f(cVar4, "null cannot be cast to non-null type lmjxuqdtp.reflect.KClass<lmjxuqdtp.Any>");
                o.f(function13, "null cannot be cast to non-null type lmjxuqdtp.Function1<@[ParameterName(name = \"className\")] lmjxuqdtp.String?, xwfkdfdvbiz.serialization.DeserializationStrategy<lmjxuqdtp.Any>?>");
                g0.d(1, function13);
            }
        }
        return sVar;
    }

    public static final z3.c e(long j2, long j3) {
        return new z3.c(Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)));
    }

    public static final z3.c f(long j2, float f2) {
        int i = (int) (j2 >> 32);
        int i2 = (int) (j2 & 4294967295L);
        return new z3.c(Float.intBitsToFloat(i) - f2, Float.intBitsToFloat(i2) - f2, Float.intBitsToFloat(i) + f2, Float.intBitsToFloat(i2) + f2);
    }

    public static final z3.c g(long j2, long j3) {
        int i = (int) (j2 >> 32);
        int i2 = (int) (j2 & 4294967295L);
        return new z3.c(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j3 & 4294967295L)) + Float.intBitsToFloat(i2));
    }

    public static final void h(int i, int i2, tlydtdl.compose.runtime.m mVar, t3.p pVar) {
        int i3;
        a2 a2VarV;
        ef1.a aVar;
        s sVar = (s) mVar;
        sVar.h0(-1722730703);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (sVar.g(pVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        boolean z = true;
        if (sVar.W(i3 & 1, (i3 & 3) != 2)) {
            if (i4 != 0) {
                pVar = t3.m.a;
            }
            if (!((Boolean) w0.r(ef1.g.c, sVar, 0, 7).getValue()).booleanValue()) {
                a2VarV = sVar.v();
                if (a2VarV != null) {
                    aVar = new ef1.a(pVar, i, i2, 0);
                    a2VarV.d = aVar;
                }
                return;
            }
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (objR == x0Var) {
                objR = tlydtdl.compose.runtime.a0.t(Boolean.FALSE);
                sVar.q0(objR);
            }
            tlydtdl.compose.runtime.e1 e1Var = (tlydtdl.compose.runtime.e1) objR;
            Object objR2 = sVar.R();
            if (objR2 == x0Var) {
                objR2 = tlydtdl.compose.runtime.a0.t(null);
                sVar.q0(objR2);
            }
            tlydtdl.compose.runtime.e1 e1Var2 = (tlydtdl.compose.runtime.e1) objR2;
            View view = (View) sVar.k(r0.f);
            boolean zG = sVar.g(view);
            Object objR3 = sVar.R();
            if (zG || objR3 == x0Var) {
                objR3 = view.getRootView();
                sVar.q0(objR3);
            }
            View view2 = (View) objR3;
            tlydtdl.compose.runtime.e1 e1VarR = w0.r(ef1.f.b, sVar, 0, 7);
            boolean zG2 = sVar.g((WeakReference) e1VarR.getValue()) | sVar.g(view2);
            Object objR4 = sVar.R();
            if (zG2 || objR4 == x0Var) {
                WeakReference weakReference = (WeakReference) e1VarR.getValue();
                if ((weakReference != null ? (View) weakReference.get() : null) != null) {
                    WeakReference weakReference2 = (WeakReference) e1VarR.getValue();
                    if ((weakReference2 != null ? (View) weakReference2.get() : null) != view2) {
                        z = false;
                    }
                }
                objR4 = Boolean.valueOf(z);
                sVar.q0(objR4);
            }
            if (((Boolean) objR4).booleanValue() && ((Boolean) e1Var.getValue()).booleanValue()) {
                sVar.f0(-1305691856);
                Object objR5 = sVar.R();
                if (objR5 == x0Var) {
                    objR5 = new x3(3, e1Var2);
                    sVar.q0(objR5);
                }
                tlydtdl.compose.foundation.layout.s.a(tlydtdl.compose.ui.layout.a.d(pVar, (Function1) objR5), sVar, 0);
                Object objR6 = sVar.R();
                if (objR6 == x0Var) {
                    objR6 = new x3(4, e1Var2);
                    sVar.q0(objR6);
                }
                tlydtdl.compose.runtime.a0.d(b0.a, (Function1) objR6, sVar);
            } else {
                sVar.f0(-1307119375);
            }
            sVar.r(false);
            Object objR7 = sVar.R();
            if (objR7 == x0Var) {
                objR7 = new x3(5, e1Var);
                sVar.q0(objR7);
            }
            st1.t1.h((tlydtdl.lifecycle.g0) null, (Function1) objR7, sVar, 390);
        } else {
            sVar.Z();
        }
        a2VarV = sVar.v();
        if (a2VarV != null) {
            aVar = new ef1.a(pVar, i, i2, 1);
            a2VarV.d = aVar;
        }
    }

    public static final void i(Function0 function0, Function0 function02, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        o.h(function0, "onTermsOfUseClicked");
        o.h(function02, "onPrivacyPolicyClicked");
        s sVar = (s) mVar;
        sVar.h0(-195073575);
        if ((i & 6) == 0) {
            i2 = i | (sVar.i(function0) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.i(function02) ? 32 : 16;
        }
        if (sVar.W(i2 & 1, (i2 & 19) != 18)) {
            String strN = x10.a.N(sVar, 2132020352);
            String strN2 = x10.a.N(sVar, 2132019785);
            String strM = x10.a.M(2132017194, new Object[]{strN, strN2}, sVar);
            ld1.d dVar = r.Companion;
            int i3 = i2;
            long jE = i.e(R.dimen.m3_comp_fab_primary_large_icon_size, 0, sVar, dVar);
            Object[] objArr = {strN, strN2, strM};
            boolean zG = sVar.g(strM) | sVar.g(strN) | sVar.f(jE) | sVar.g(strN2);
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (zG || objR == x0Var) {
                pf1.d dVar2 = new pf1.d(strM, strN, jE, strN2, 2);
                sVar.q0(dVar2);
                objR = dVar2;
            }
            Function1 function1 = (Function1) objR;
            boolean z = ((i3 & 14) == 4) | ((i3 & 112) == 32);
            Object objR2 = sVar.R();
            if (z || objR2 == x0Var) {
                objR2 = new kf1.c(function0, function02, 1);
                sVar.q0(objR2);
            }
            z10.d.h(x30.c.p(objArr, function1, (Function1) objR2, sVar), i.u(dVar, R.dimen.m3_comp_fab_primary_large_icon_size), of1.q.b(), o2.e(t3.m.a, 1.0f), false, (of1.e) null, 3, (Function1) null, sVar, 3072, 176);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new an0.i(function0, function02, i, 20);
        }
    }

    public static final void j(f3 f3Var, t3.p pVar, tlydtdl.compose.foundation.layout.h hVar, t3.g gVar, tlydtdl.compose.runtime.m mVar, int i) {
        tlydtdl.compose.foundation.layout.h hVar2;
        t3.g gVar2;
        o.h(f3Var, "timeState");
        s sVar = (s) mVar;
        sVar.h0(353646872);
        int i2 = i | (sVar.g(f3Var) ? 4 : 2);
        if (sVar.W(i2 & 1, (i2 & 1171) != 1170)) {
            hVar2 = hVar;
            gVar2 = gVar;
            l2 l2VarA = j2.a(hVar2, gVar2, sVar, 54);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            t3.p pVarX = j4.x(sVar, pVar);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, l2VarA, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            Object objR = sVar.R();
            if (objR == tlydtdl.compose.runtime.l.a) {
                objR = tlydtdl.compose.runtime.a0.q(new lu0.g(f3Var, 4));
                sVar.q0(objR);
            }
            f3 f3Var2 = (f3) objR;
            h0 h0Var = of1.q.h().a().a;
            ld1.d dVar = r.Companion;
            h0 h0VarA = h0.a(h0Var, i.e(R.dimen.m3_comp_fab_primary_large_icon_size, 0, sVar, dVar), 65534);
            h0 h0VarA2 = h0.a(of1.q.h().a().a, o6.c.f(dVar, R.dimen.m3_comp_fab_primary_large_icon_size, sVar, 0, 0.5f), 65534);
            x10.c cVar = v.Companion;
            d5.d dVar2 = new d5.d();
            int iK = dVar2.k(h0VarA);
            try {
                dVar2.f((String) ((lx1.l) f3Var2.getValue()).a);
                dVar2.h(iK);
                iK = dVar2.k(h0VarA2);
                try {
                    dVar2.f((String) ((lx1.l) f3Var2.getValue()).b);
                    dVar2.h(iK);
                    d5.g gVarL = dVar2.l();
                    cVar.getClass();
                    x10.l lVarD = x10.c.d(gVarL);
                    dVar.getClass();
                    z10.d.h(lVarD, new ld1.q(R.dimen.m3_comp_fab_primary_large_icon_size), of1.q.h(), (t3.p) null, false, of1.e.f370f, 0, (Function1) null, sVar, 0, 216);
                    sVar.r(true);
                } finally {
                }
            } finally {
            }
        } else {
            hVar2 = hVar;
            gVar2 = gVar;
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new com.bandlab.uikit.compose.bottomsheet.b(f3Var, pVar, hVar2, gVar2, i, 6);
        }
    }

    public static final String k(Object[] objArr, int i, int i2, mx1.h hVar) {
        StringBuilder sb = new StringBuilder((i2 * 3) + 2);
        sb.append("[");
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i + i3];
            if (obj == hVar) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String string = sb.toString();
        o.g(string, "toString(...)");
        return string;
    }

    public static final Object l(Task task, sx1.c cVar) throws Exception {
        if (!task.isComplete()) {
            ky1.m mVar = new ky1.m(1, z.C(cVar));
            mVar.s();
            task.addOnCompleteListener(uy1.a.a, new u(mVar, 3));
            Object objQ = mVar.q();
            rx1.a aVar = rx1.a.a;
            return objQ;
        }
        Exception exception = task.getException();
        if (exception != null) {
            throw exception;
        }
        if (!task.isCanceled()) {
            return task.getResult();
        }
        throw new CancellationException("Task " + task + " was cancelled normally.");
    }

    public static final Object m(Function1 function1, Function1 function12, sx1.c cVar) {
        return c0.o(new ah.m(function1, function12, (qx1.d) null), cVar);
    }

    public static final ArrayList n(String str) {
        o.h(str, "action");
        ArrayList arrayList = new ArrayList();
        f2.z("action", str, arrayList);
        return arrayList;
    }

    public static final ArrayList o(Function1 function1) {
        ArrayList arrayList = new ArrayList();
        function1.invoke(new qi.r(arrayList));
        return arrayList;
    }

    public static final void p(a0 a0Var, CancellationException cancellationException) {
        o.h(a0Var, "<this>");
        qx1.i coroutineContext = a0Var.getCoroutineContext();
        f1 f1Var = coroutineContext.get(e1.a);
        if (f1Var != null) {
            Iterator it = f1Var.getChildren().iterator();
            while (it.hasNext()) {
                ((f1) it.next()).a(cancellationException);
            }
        } else {
            throw new IllegalArgumentException(("Job is not found in scope " + a0Var + " context " + coroutineContext).toString());
        }
    }

    public static final void q(long j2) {
        q[] qVarArr = p5.p.b;
        if ((j2 & 1095216660480L) == 0) {
            p5.j.a("Cannot perform operation for Unspecified type.");
        }
    }

    public static final void r(long j2, long j3) {
        q[] qVarArr = p5.p.b;
        if ((j2 & 1095216660480L) == 0 || (1095216660480L & j3) == 0) {
            p5.j.a("Cannot perform operation for Unspecified type.");
        }
        if (q.a(p5.p.b(j2), p5.p.b(j3))) {
            return;
        }
        p5.j.a("Cannot perform operation for " + ((Object) q.b(p5.p.b(j2))) + " and " + ((Object) q.b(p5.p.b(j3))));
    }

    public static long s(int i, int i2) {
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    public static final long t(InputStream inputStream, OutputStream outputStream) throws IOException {
        o.h(inputStream, "<this>");
        o.h(outputStream, "out");
        byte[] bArr = new byte[8192];
        int i = inputStream.read(bArr);
        long j2 = 0;
        while (i >= 0) {
            outputStream.write(bArr, 0, i);
            j2 += (long) i;
            i = inputStream.read(bArr);
        }
        return j2;
    }

    public static ev0.b0 u(iw1.b bVar, iw1.b bVar2, iw1.b bVar3, iw1.b bVar4, iw1.b bVar5, iw1.b bVar6) {
        o.h(bVar, "mixer");
        o.h(bVar2, "membershipRepo");
        o.h(bVar3, "mixEditorNavigation");
        o.h(bVar4, "uiStateRepository");
        o.h(bVar5, "availabilityProvider");
        o.h(bVar6, "messageHolder");
        return new ev0.b0(bVar, bVar2, bVar3, bVar4, bVar5, bVar6, 1);
    }

    public static yt.a v(iw1.b bVar) {
        o.h(bVar, "context");
        return new yt.a(bVar, 24);
    }

    public static final Object w(Duration duration, y yVar) {
        Object objP = c0.p(duration.compareTo(Duration.ZERO) <= 0 ? 0L : duration.compareTo(ChronoUnit.MILLIS.getDuration()) <= 0 ? 1L : (duration.getSeconds() < 9223372036854775L || (duration.getSeconds() == 9223372036854775L && duration.getNano() < 807000000)) ? duration.toMillis() : LongCompanionObject.MAX_VALUE, yVar);
        return objP == rx1.a.a ? objP : b0.a;
    }

    public static final int x(int i, List list) {
        int i2;
        int i3 = ((t) mx1.o.G0(list)).c;
        if (i > ((t) mx1.o.G0(list)).c) {
            j5.a.a("Index " + i + " should be less or equal than last line's end " + i3);
        }
        int size = list.size() - 1;
        int i4 = 0;
        while (true) {
            if (i4 > size) {
                i2 = -(i4 + 1);
                break;
            }
            i2 = (i4 + size) >>> 1;
            t tVar = (t) list.get(i2);
            byte b = tVar.b > i ? (byte) 1 : tVar.c <= i ? (byte) -1 : (byte) 0;
            if (b >= 0) {
                if (b <= 0) {
                    break;
                }
                size = i2 - 1;
            } else {
                i4 = i2 + 1;
            }
        }
        if (i2 >= 0 && i2 < list.size()) {
            return i2;
        }
        StringBuilder sbR = o6.c.r(i2, "Found paragraph index ", " should be in range [0, ");
        sbR.append(list.size());
        sbR.append(").\nDebug info: index=");
        sbR.append(i);
        sbR.append(", paragraphs=[");
        sbR.append(r5.a.a(list, (String) null, new cz.b0(4), 31));
        sbR.append(']');
        j5.a.a(sbR.toString());
        return i2;
    }

    public static final int y(int i, List list) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            t tVar = (t) list.get(i3);
            byte b = tVar.d > i ? (byte) 1 : tVar.e <= i ? (byte) -1 : (byte) 0;
            if (b < 0) {
                i2 = i3 + 1;
            } else {
                if (b <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final int z(ArrayList arrayList, float f2) {
        if (f2 <= 0.0f) {
            return 0;
        }
        if (f2 >= ((t) mx1.o.G0(arrayList)).g) {
            return ct1.b.z(arrayList);
        }
        int size = arrayList.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            t tVar = (t) arrayList.get(i2);
            byte b = tVar.f76f > f2 ? (byte) 1 : tVar.g <= f2 ? (byte) -1 : (byte) 0;
            if (b < 0) {
                i = i2 + 1;
            } else {
                if (b <= 0) {
                    return i2;
                }
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }
}
