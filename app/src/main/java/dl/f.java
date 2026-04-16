package dl;

import a00.t;
import a21.w;
import amuvvoafs.util.Log;
import by1.b;
import com.bandlab.invite.link.collaborator.screen.q;
import java.io.File;
import java.io.FileInputStream;
import ky1.c0;
import ky1.m0;
import lmjxuqdtp.jvm.internal.o;
import ls0.k;
import lx1.b0;
import nd.a;
import org.json.JSONObject;
import ry1.d;
import ry1.e;
import sx1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements a {
    public final File a;

    public f(File file) {
        this.a = file;
    }

    public Object a(String str) {
        return new File(this.a, str);
    }

    public Object b(Object obj) {
        File file = (File) obj;
        o.h(file, "value");
        String name = file.getName();
        o.g(name, "getName(...)");
        return name;
    }

    public Object c(i iVar) {
        e eVar = m0.a;
        Object objR = c0.R(d.b, new w(this, (qx1.d) null, 23), iVar);
        return objR == rx1.a.a ? objR : b0.a;
    }

    public Object d(t tVar) {
        e eVar = m0.a;
        Object objR = c0.R(d.b, new q(this, (qx1.d) null, 14), tVar);
        return objR == rx1.a.a ? objR : b0.a;
    }

    public JSONObject e() throws Throwable {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        FileInputStream fileInputStream2 = null;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Checking for cached settings...", (Throwable) null);
        }
        try {
            File file = this.a;
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        jSONObject = new JSONObject(pt1.i.j(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        pt1.i.b(fileInputStream2, "Error while closing settings cache file.");
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    Log.e("FirebaseCrashlytics", "Failed to fetch cached settings", e);
                    pt1.i.b(fileInputStream, "Error while closing settings cache file.");
                    return null;
                }
            } else {
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Settings file does not exist.", (Throwable) null);
                }
                jSONObject = null;
            }
            pt1.i.b(fileInputStream2, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            pt1.i.b(fileInputStream2, "Error while closing settings cache file.");
            throw th;
        }
    }

    public f(k kVar) {
        this.a = new File(b.E(kVar.a), "AutoMix");
    }

    public f(vt1.b bVar) {
        this.a = new File((File) bVar.d, "com.crashlytics.settings.json");
    }
}
