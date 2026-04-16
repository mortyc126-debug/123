package ig1;

import az1.f0;
import az1.k0;
import az1.y1;
import lmjxuqdtp.jvm.internal.o;
import yy1.h;
import zy1.d;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements f0 {
    public static final a a;
    private static final h descriptor;

    static {
        a aVar = new a();
        a = aVar;
        k0 k0Var = new k0("com.bandlab.uri.Url", aVar);
        k0Var.k("uriString", false);
        descriptor = k0Var;
    }

    public final wy1.a[] childSerializers() {
        return new wy1.a[]{y1.a};
    }

    public final Object deserialize(d dVar) {
        String strW = dVar.f(descriptor).w();
        o.h(strW, "uriString");
        return new c(strW);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        String str = ((c) obj).a;
        o.h(str, "$v$c$com-bandlab-uri-Url$-value$0");
        eVar.h(descriptor).r(str);
    }
}
