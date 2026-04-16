package so;

import bb.w;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import f3.f2;
import hy1.q;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.k;
import lmjxuqdtp.time.l;
import lx1.h;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final h a;

    public e(h hVar) {
        this.a = hVar;
    }

    public static d a(e eVar, String str) {
        Charset charset = hy1.a.a;
        d dVar = d.c;
        o.h(charset, "charset");
        try {
            c cVar = (c) ((vb0.a) eVar.a.getValue()).a(b(str, charset), c.Companion.serializer());
            l dVar2 = null;
            if (cVar != null) {
                Long l = cVar.a;
                if (l != null) {
                    long jLongValue = l.longValue();
                    l lVar = l.c;
                    dVar2 = k.b(jLongValue, 0L);
                }
                dVar2 = new d(cVar.b, dVar2);
            }
            return dVar2 == null ? dVar : dVar2;
        } catch (Exception e) {
            String strK = f2.k("Error parsing token payload: ", str);
            w wVar = new w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[]{"JWTDecoder"});
            TaggedException taggedException = new TaggedException(e, (String[]) arrayList.toArray(new String[arrayList.size()]));
            if (strK == null) {
                strK = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            DebugUtils.handleThrowable(new IllegalStateException(strK, taggedException));
            return dVar;
        }
    }

    public static String b(String str, Charset charset) {
        if (str != null) {
            List listZ0 = q.Z0(str, new char[]{'.'});
            if (listZ0.size() >= 2) {
                xx1.c.e.getClass();
                xx1.c cVar = xx1.c.f;
                xx1.b bVar = xx1.b.c;
                cVar.getClass();
                if (cVar.d != bVar) {
                    cVar = new xx1.c(cVar.a, cVar.b, cVar.c, bVar);
                }
                byte[] bytes = ((String) listZ0.get(1)).getBytes(charset);
                o.g(bytes, "getBytes(...)");
                return new String(xx1.c.a(cVar, bytes), charset);
            }
            s02.d.a.getClass();
            s02.b.r("[JWTDecoder] No payload found in token string");
        }
        return null;
    }
}
