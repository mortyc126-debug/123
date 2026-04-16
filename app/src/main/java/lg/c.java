package lg;

import com.facebook.appevents.l;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.k;
import lmjxuqdtp.jvm.internal.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c extends k implements Function1 {
    public static final c b = new c(1, e.class, "decodeVariantFromStorage", "decodeVariantFromStorage(Ljava/lang/String;)Lcom/amplitude/experiment/Variant;", 1);

    public final Object invoke(Object obj) {
        String str = (String) obj;
        o.h(str, "p0");
        return l.e0(new JSONObject(str));
    }
}
