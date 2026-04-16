package c10;

import amuvvoafs.content.Intent;
import amuvvoafs.net.Uri;
import amuvvoafs.os.Process;
import amuvvoafs.os.RemoteException;
import amuvvoafs.text.TextUtils;
import amuvvoafs.util.Log;
import com.bandlab.mixeditor.resources.impl.s;
import f3.f2;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Locale;
import kg.b;
import kotlin.text.Typography;
import md1.b1;
import mt1.f;
import o6.c;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;
import pt1.w;
import qu0.u;
import rs1.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final /* synthetic */ int a;
    public String b;

    public static void a(u uVar, s sVar) {
        String str = (String) sVar.b;
        if (str != null) {
            uVar.A("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        }
        uVar.A("X-CRASHLYTICS-API-CLIENT-TYPE", "amuvvoafs");
        uVar.A("X-CRASHLYTICS-API-CLIENT-VERSION", "20.0.3");
        uVar.A(HttpHeaders.ACCEPT, "application/json");
        String str2 = (String) sVar.c;
        if (str2 != null) {
            uVar.A("X-CRASHLYTICS-DEVICE-MODEL", str2);
        }
        String str3 = (String) sVar.d;
        if (str3 != null) {
            uVar.A("X-CRASHLYTICS-OS-BUILD-VERSION", str3);
        }
        String str4 = (String) sVar.e;
        if (str4 != null) {
            uVar.A("X-CRASHLYTICS-OS-DISPLAY-VERSION", str4);
        }
        String str5 = ((w) sVar.f).c().a;
        if (str5 != null) {
            uVar.A("X-CRASHLYTICS-INSTALLATION-ID", str5);
        }
    }

    public static HashMap b(s sVar) {
        HashMap map = new HashMap();
        map.put("build_version", (String) sVar.i);
        map.put("display_version", (String) sVar.h);
        map.put("source", Integer.toString(sVar.a));
        String str = (String) sVar.g;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public static String i(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e) {
                Log.e("PlayCore", "Unable to format ".concat(String.valueOf(str2)), e);
                str2 = c.m(str2, " [", TextUtils.join(", ", objArr), "]");
            }
        }
        return b1.j(str, " : ", str2);
    }

    public static String l(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e) {
                Log.e("PlayCore", "Unable to format ".concat(str2), e);
                str2 = c.m(str2, " [", TextUtils.join(", ", objArr), "]");
            }
        }
        return b1.j(str, " : ", str2);
    }

    public static String m(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e) {
                Log.e("PlayCore", "Unable to format ".concat(str2), e);
                str2 = c.m(str2, " [", TextUtils.join(", ", objArr), "]");
            }
        }
        return b1.j(str, " : ", str2);
    }

    public Intent c() {
        Intent intent = new Intent("amuvvoafs.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + this.b));
        intent.addCategory("amuvvoafs.intent.category.DEFAULT");
        intent.addFlags(268435456);
        return intent;
    }

    public JSONObject d(b bVar) {
        String str = this.b;
        int i = bVar.b;
        f fVar = f.a;
        fVar.j("Settings response code was: " + i);
        if (i != 200 && i != 201 && i != 202 && i != 203) {
            String str2 = "Settings request failed; (status: " + i + ") from " + str;
            if (fVar.h(6)) {
                Log.e("FirebaseCrashlytics", str2, (Throwable) null);
            }
            return null;
        }
        String str3 = bVar.a;
        try {
            return new JSONObject(str3);
        } catch (Exception e) {
            fVar.k("Failed to parse settings JSON from " + str, e);
            fVar.k("Settings response " + str3, (Exception) null);
            return null;
        }
    }

    public void e(String str, Object... objArr) {
        switch (this.a) {
            case 2:
                if (Log.isLoggable("PlayCore", 3)) {
                    Log.d("PlayCore", l(this.b, str, objArr));
                }
                break;
            default:
                if (Log.isLoggable("PlayCore", 3)) {
                    Log.d("PlayCore", m(this.b, str, objArr));
                }
                break;
        }
    }

    public void f(String str, Object... objArr) {
        switch (this.a) {
            case 5:
                if (Log.isLoggable("PlayCore", 6)) {
                    Log.e("PlayCore", m(this.b, str, objArr));
                }
                break;
            default:
                if (Log.isLoggable("PlayCore", 4)) {
                    Log.i("PlayCore", i(this.b, str, objArr));
                }
                break;
        }
    }

    public void g(RemoteException remoteException, String str, Object... objArr) {
        switch (this.a) {
            case 2:
                if (Log.isLoggable("PlayCore", 6)) {
                    Log.e("PlayCore", l(this.b, str, objArr), remoteException);
                }
                break;
            default:
                if (Log.isLoggable("PlayCore", 6)) {
                    Log.e("PlayCore", m(this.b, str, objArr), remoteException);
                }
                break;
        }
    }

    public void h(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            Log.w("PlayCore", i(this.b, str, objArr));
        }
    }

    public void j(String str, Object... objArr) {
        switch (this.a) {
            case 2:
                if (Log.isLoggable("PlayCore", 4)) {
                    Log.i("PlayCore", l(this.b, str, objArr));
                }
                break;
            default:
                if (Log.isLoggable("PlayCore", 4)) {
                    Log.i("PlayCore", m(this.b, str, objArr));
                }
                break;
        }
    }

    public void k(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            Log.w("PlayCore", m(this.b, str, objArr));
        }
    }

    public String toString() {
        switch (this.a) {
            case 4:
                return i.o(new StringBuilder("<"), this.b, Typography.greater);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(int i, String str, boolean z) {
        this.a = i;
        this.b = str;
    }

    public a(String str, int i) {
        this.a = i;
        switch (i) {
            case 5:
                this.b = f2.g(Process.myUid(), Process.myPid(), "UID: [", "]  PID: [", "] ").concat(str);
                break;
            case 6:
                this.b = f2.g(Process.myUid(), Process.myPid(), "UID: [", "]  PID: [", "] ").concat(str);
                break;
            default:
                this.b = f2.g(Process.myUid(), Process.myPid(), "UID: [", "]  PID: [", "] ").concat(str);
                break;
        }
    }

    public a(String str, g gVar) {
        this.a = 7;
        if (str != null) {
            this.b = str;
            return;
        }
        throw new IllegalArgumentException("url must not be null.");
    }
}
