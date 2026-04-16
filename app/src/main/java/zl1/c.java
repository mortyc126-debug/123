package zl1;

import com.braze.requests.d;
import java.util.ArrayList;
import java.util.List;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ d b;
    public final /* synthetic */ List c;

    public /* synthetic */ c(d dVar, ArrayList arrayList, int i) {
        this.a = i;
        this.b = dVar;
        this.c = arrayList;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return d.a(this.b, this.c);
            default:
                return d.b(this.b, this.c);
        }
    }
}
