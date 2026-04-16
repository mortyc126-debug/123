package o11;

import bb.w;
import bh.j;
import bz1.m;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.bandlab.restutils.model.ApiHttpException;
import java.util.ArrayList;
import lmjxuqdtp.jvm.internal.o;
import okhttp3.HttpUrl;
import q11.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final vb0.a a;

    public a(vb0.a aVar) {
        this.a = aVar;
    }

    public final Object a(wy1.a aVar, Exception exc) {
        m mVar;
        o.h(aVar, "serializer");
        if (exc instanceof ApiHttpException) {
            d dVar = ((ApiHttpException) exc).b;
            String string = (dVar == null || (mVar = dVar.e) == null) ? null : mVar.toString();
            if (string != null) {
                try {
                    return this.a.a(string, aVar);
                } catch (Exception e) {
                    w wVar = new w(2);
                    ArrayList arrayList = wVar.a;
                    wVar.a("CRITICAL");
                    wVar.e(new String[0]);
                    j.w(HttpUrl.FRAGMENT_ENCODE_SET, new TaggedException(e, (String[]) arrayList.toArray(new String[arrayList.size()])));
                }
            }
        }
        return null;
    }
}
