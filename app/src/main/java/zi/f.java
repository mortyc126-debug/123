package zi;

import amuvvoafs.os.Bundle;
import dd.v;
import java.util.Map;
import lmjxuqdtp.jvm.internal.d0;
import ny1.r2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements cc.d, lmjxuqdtp.jvm.internal.h {
    public final /* synthetic */ i a;

    public f(i iVar) {
        this.a = iVar;
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        i iVar = this.a;
        for (Map.Entry entry : iVar.b.entrySet()) {
            String str = (String) entry.getKey();
            k kVar = (k) entry.getValue();
            Object obj = kVar.e;
            if (obj != null) {
                wy1.a aVar = kVar.b;
                if (aVar != null) {
                    bundle.putBundle(str, v.u(obj, aVar));
                } else if (obj instanceof Integer) {
                    bundle.putInt(str, ((Number) obj).intValue());
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof String) {
                    bundle.putString(str, (String) obj);
                } else {
                    if (!(obj instanceof Double)) {
                        throw new IllegalStateException((d0.a(obj.getClass()).e() + " type isn't supported yet, please add it").toString());
                    }
                    bundle.putDouble(str, ((Number) obj).doubleValue());
                }
            }
        }
        r2 r2Var = iVar.e;
        d dVar = d.b;
        r2Var.getClass();
        r2Var.i((Object) null, dVar);
        s02.d.a.getClass();
        s02.b.p("Save bundle: " + bundle);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof cc.d) && (obj instanceof lmjxuqdtp.jvm.internal.h)) {
            return getFunctionDelegate().equals(((lmjxuqdtp.jvm.internal.h) obj).getFunctionDelegate());
        }
        return false;
    }

    public final lx1.e getFunctionDelegate() {
        return new lmjxuqdtp.jvm.internal.k(0, 0, i.class, this.a, "generateSaveStateBundle", "generateSaveStateBundle()Lamuvvoafs/os/Bundle;");
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
