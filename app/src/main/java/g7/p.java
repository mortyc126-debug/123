package g7;

import amuvvoafs.content.pm.PackageManager;
import amuvvoafs.content.pm.Signature;
import amuvvoafs.os.Bundle;
import amuvvoafs.util.Log;
import cd.i0;
import com.gnacba.amuvvoafs.gms.internal.ads.b2;
import com.gnacba.amuvvoafs.gms.internal.ads.u8;
import com.gnacba.amuvvoafs.gms.internal.play_grouping.zzp;
import com.gnacba.amuvvoafs.gms.tasks.Continuation;
import com.gnacba.amuvvoafs.gms.tasks.Task;
import com.gnacba.amuvvoafs.gms.tasks.Tasks;
import com.gnacba.amuvvoafs.play.core.grouping.service.GroupingApiException;
import com.google.android.material.R;
import d5.h0;
import d5.q0;
import i3.c;
import iz1.b0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Set;
import k7.b;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.internal.o;
import ny1.z;
import of1.n;
import org.apache.commons.net.tftp.TFTP;
import org.json.JSONException;
import org.json.JSONObject;
import p5.i;
import qq1.k0;
import qq1.m0;
import qq1.u;
import t4.r1;
import tlydtdl.compose.runtime.l;
import tlydtdl.datastore.core.CorruptionException;
import tlydtdl.media3.common.ParserException;
import tlydtdl.media3.datasource.DataSourceException;
import tlydtdl.media3.datasource.HttpDataSource;
import tlydtdl.media3.exoplayer.upstream.Loader;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class p implements d, hu1.a, Continuation, b, nt1.a, k0 {
    public static final /* synthetic */ p b = new p(3);
    public static p c;
    public final /* synthetic */ int a;

    public /* synthetic */ p(int i) {
        this.a = i;
    }

    public static final gs0.a c(p pVar) {
        Boolean bool = Boolean.FALSE;
        return new gs0.a(z.c(bool), new a10.b(8), z.c(bool));
    }

    public static i3.b d(long j2) {
        Set set = c.b;
        Set set2 = i3.a.b;
        float fC = i.c(j2);
        int i = 0;
        float f2 = 0;
        if (Float.compare(fC, f2) < 0) {
            throw new IllegalArgumentException("Width must not be negative");
        }
        if (set.isEmpty()) {
            throw new IllegalArgumentException("Must support at least one size class");
        }
        List list = c.c;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            int i4 = ((c) list.get(i2)).a;
            if (set.contains(new c(i4))) {
                if (Float.compare(fC, ch0.b.j(i4)) >= 0) {
                    i3 = i4;
                    break;
                }
                i3 = i4;
            }
            i2++;
        }
        Set set3 = i3.a.b;
        float fB = i.b(j2);
        if (Float.compare(fB, f2) < 0) {
            throw new IllegalArgumentException("Width must not be negative");
        }
        if (set2.isEmpty()) {
            throw new IllegalArgumentException("Must support at least one size class");
        }
        List list2 = i3.a.c;
        int size2 = list2.size();
        int i6 = 2;
        while (true) {
            if (i >= size2) {
                break;
            }
            int i7 = ((i3.a) list2.get(i)).a;
            if (set2.contains(new i3.a(i7))) {
                if (Float.compare(fB, i0.m(i7)) >= 0) {
                    i6 = i7;
                    break;
                }
                i6 = i7;
            }
            i++;
        }
        return new i3.b(i3, i6);
    }

    public static me1.d e(x10.v vVar, dg1.g gVar, ld1.q qVar, String str, Function0 function0, int i) {
        dg1.g gVar2 = (i & 2) != 0 ? null : gVar;
        ld1.q qVarU = (i & 8) != 0 ? i.u(ld1.r.Companion, R.dimen.m3_comp_fab_primary_pressed_container_elevation) : qVar;
        String str2 = (i & 16) != 0 ? null : str;
        o.h(function0, "onClick");
        return new me1.d(vVar, i.u(ld1.r.Companion, R.dimen.m3_comp_fab_primary_large_icon_size), gVar2, (dg1.g) null, qVarU, (ld1.q) null, (n) null, false, false, str2, function0, 2016);
    }

    public static n f(q0 q0Var) {
        h0 h0Var = q0Var.a;
        return new n(p5.p.c(h0Var.b), p5.p.c(q0Var.b.c), h0Var.c, h0Var.g, h0Var.d, Float.valueOf(p5.p.c(h0Var.h)), h0Var.m);
    }

    public static u8 h(b2 b2Var, bb.o oVar) {
        HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = (IOException) oVar.c;
        if (!(invalidResponseCodeException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return null;
        }
        int i = invalidResponseCodeException.d;
        if (i != 403 && i != 404 && i != 410 && i != 416 && i != 500 && i != 503) {
            return null;
        }
        if (b2Var.b(1)) {
            return new u8(1, 300000L);
        }
        if (b2Var.b(2)) {
            return new u8(2, 60000L);
        }
        return null;
    }

    public static long j(bb.o oVar) {
        Throwable cause = (IOException) oVar.c;
        if ((cause instanceof ParserException) || (cause instanceof FileNotFoundException) || (cause instanceof HttpDataSource.CleartextNotPermittedException) || (cause instanceof Loader.UnexpectedLoaderException)) {
            return -9223372036854775807L;
        }
        int i = DataSourceException.b;
        while (cause != null) {
            if ((cause instanceof DataSourceException) && ((DataSourceException) cause).a == 2008) {
                return -9223372036854775807L;
            }
            cause = cause.getCause();
        }
        return Math.min((oVar.b - 1) * 1000, TFTP.DEFAULT_TIMEOUT);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public static i90.g l(String str) throws NoWhenBranchMatchedException {
        int i;
        i90.b bVar = i90.b.a;
        i90.d[] dVarArr = i90.d.a;
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            i = 4099;
        } else if (iOrdinal == 1) {
            i = 8194;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = 0;
        }
        return new i90.g(i, str, null, true);
    }

    public static me1.d m(x10.v vVar, dg1.g gVar, Function0 function0, int i) {
        dg1.g gVar2 = (i & 2) != 0 ? null : gVar;
        String str = (i & 8) == 0 ? "SampleItem.FavoriteButton" : null;
        o.h(function0, "onClick");
        return new me1.d(vVar, i.u(ld1.r.Companion, 2131100957), gVar2, (dg1.g) null, (ld1.r) null, (ld1.q) null, (n) null, false, false, str, function0, 2032);
    }

    public static n n(float f2, float f3) {
        return new n(f2, f3, h5.s.g);
    }

    public static n p(float f2, float f3) {
        return new n(f2, f3, h5.s.f);
    }

    public static n q(float f2, tlydtdl.compose.runtime.m mVar, int i) {
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        p5.c cVar = (p5.c) sVar.k(r1.h);
        boolean zG = sVar.g(cVar) | ((((i & 14) ^ 6) > 4 && sVar.d(f2)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && sVar.g(null)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && sVar.g(null)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) > 2048 && sVar.g(null)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) > 16384 && sVar.g(null)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) > 131072 && sVar.g(null)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) > 1048576 && sVar.g(null)) || (i & 1572864) == 1048576);
        Object objR = sVar.R();
        if (zG || objR == l.a) {
            float fC = p5.p.c(cVar.o(f2));
            n nVar = new n(fC / 1.3f, fC, null, null, null, null, null);
            sVar.q0(nVar);
            objR = nVar;
        }
        return (n) objR;
    }

    public static me1.d r(x10.v vVar, boolean z, ld1.q qVar, ld1.q qVar2, Function0 function0, int i) {
        ld1.q qVarU = (i & 4) != 0 ? i.u(ld1.r.Companion, R.dimen.m3_comp_fab_primary_large_icon_size) : qVar;
        ld1.q qVarU2 = (i & 8) != 0 ? i.u(ld1.r.Companion, 2131100927) : qVar2;
        o.h(vVar, "textRes");
        o.h(function0, "onClick");
        return new me1.d(vVar, qVarU, (dg1.d) null, z ? new dg1.g(2131231282, false) : null, qVarU2, (ld1.q) null, (n) null, z, false, (String) null, function0, 3940);
    }

    public static JSONObject s() {
        av1.g gVar;
        av1.g gVar2;
        av1.g gVar3;
        av1.g gVar4;
        av1.g gVar5;
        try {
            JSONObject jSONObject = new JSONObject();
            nw1.c cVarK = nw1.c.k();
            boolean zV = false;
            jSONObject.put("expectDelayedSessionInitialization", (cVarK == null || (gVar5 = cVarK.b) == null) ? false : gVar5.v("bnc_delayed_session_init_used"));
            jSONObject.put("testMode", lg.e.a);
            nw1.c cVarK2 = nw1.c.k();
            jSONObject.put("instantDeepLinkingEnabled", (cVarK2 == null || (gVar4 = cVarK2.b) == null) ? false : gVar4.v("bnc_instant_deep_linking_enabled"));
            nw1.c cVarK3 = nw1.c.k();
            if (cVarK3 != null && (gVar3 = cVarK3.b) != null) {
                zV = gVar3.v("bnc_defer_init_for_plugin_runtime");
            }
            jSONObject.put("deferInitForPluginRuntime", zV);
            nw1.c cVarK4 = nw1.c.k();
            String strM = null;
            String strM2 = (cVarK4 == null || (gVar2 = cVarK4.b) == null) ? null : gVar2.M("bnc_branch_key_source");
            String str = "unknown";
            if (strM2 == null) {
                strM2 = "unknown";
            }
            jSONObject.put("branch_key_source", strM2);
            nw1.c cVarK5 = nw1.c.k();
            if (cVarK5 != null && (gVar = cVarK5.b) != null) {
                strM = gVar.M("bnc_branch_key_source");
            }
            if (strM != null) {
                str = strM;
            }
            jSONObject.put("branch_key_fallback_used", str.equals("branchKey"));
            return jSONObject;
        } catch (NullPointerException e) {
            h02.a.U("Error serializing configuration - null reference: " + e.getMessage());
            return new JSONObject();
        } catch (JSONException e2) {
            h02.a.U("Error serializing configuration - JSON error: " + e2.getMessage());
            return new JSONObject();
        } catch (Exception e3) {
            h02.a.U("Error serializing configuration - unexpected error: " + e3.getMessage());
            return new JSONObject();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public static i90.g t(String str, Function0 function0) throws NoWhenBranchMatchedException {
        int i;
        i90.d[] dVarArr = i90.d.a;
        int i2 = i90.f.$EnumSwitchMapping$1[i90.c.a.ordinal()];
        if (i2 == 1) {
            i = 4099;
        } else if (i2 == 2) {
            i = 4097;
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = 0;
        }
        return new i90.g(i, str, function0, false);
    }

    public static he1.i u(int i, int i2, x10.v vVar, x10.v vVar2, int i3) {
        x10.v vVar3 = (i3 & 4) != 0 ? null : vVar;
        x10.v vVar4 = (i3 & 32) != 0 ? null : vVar2;
        String str = i + "/" + i2;
        x10.v.Companion.getClass();
        return new he1.i(vVar3, (n) null, (x10.r) null, x10.c.d(str), vVar4, 14);
    }

    @Override // g7.d
    public x a(v vVar, int i, ReferenceQueue referenceQueue) {
        return new u(vVar, i, referenceQueue).d();
    }

    public Object b(CorruptionException corruptionException) throws CorruptionException {
        throw corruptionException;
    }

    public void g(Bundle bundle) {
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Skipping logging Crashlytics event to Firebase, no Firebase Analytics", (Throwable) null);
        }
    }

    public int i(int i) {
        return i == 7 ? 6 : 3;
    }

    public Signature[] k(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public Object then(Task task) {
        c10.a aVar = hs1.b.c;
        if (task.isSuccessful()) {
            Bundle bundle = (Bundle) task.getResult();
            int i = bundle.getInt("error");
            return i != 0 ? Tasks.forException(new GroupingApiException(i)) : Tasks.forResult(bundle);
        }
        if (task.isCanceled()) {
            return Tasks.forException(new GroupingApiException(3));
        }
        Exception exception = task.getException();
        return exception != null ? exception instanceof zzp ? Tasks.forException(new GroupingApiException(2)) : Tasks.forException(exception) : Tasks.forException(new GroupingApiException(3));
    }

    public void v(String str) {
        Log.w("Experiment", str);
    }

    public Object zza() {
        switch (this.a) {
            case 27:
                return new qq1.a();
            default:
                u uVar = qq1.v.b;
                qq1.s.d(uVar);
                return new m0(uVar);
        }
    }

    public p(String str, b0 b0Var, iz1.i0 i0Var) {
        this.a = 8;
        o.h(i0Var, "httpClient");
    }
}
