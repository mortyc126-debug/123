package ln1;

import com.facebook.s;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.internal.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends p implements Function0 {
    public static final h c = new h(0);

    public final Object invoke() {
        return s.a().getSharedPreferences("com.facebook.sdk.APPLINK_INFO", 0);
    }
}
