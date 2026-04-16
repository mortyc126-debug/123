package em1;

import com.braze.support.JsonUtils;
import f2.a0;
import i2.b;
import lmjxuqdtp.jvm.functions.Function0;
import org.json.JSONArray;
import tlydtdl.compose.runtime.k1;
import w2.r0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ i(int i, Object obj, int i2) {
        this.a = i2;
        this.b = i;
        this.c = obj;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return JsonUtils.c(this.b, (JSONArray) this.c);
            case 1:
                return new b(this.b, 0.0f, (Function0) this.c);
            case 2:
                a0 a0Var = (a0) this.c;
                return Boolean.valueOf(((k1) a0Var.e.b).h() <= this.b && ((k1) a0Var.e.c).h() < 100);
            default:
                ((r0) this.c).X0(this.b);
                return Boolean.TRUE;
        }
    }

    public /* synthetic */ i(Object obj, int i, int i2) {
        this.a = i2;
        this.c = obj;
        this.b = i;
    }
}
