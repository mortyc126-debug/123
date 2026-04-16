package s51;

import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.k;
import x30.c;
import y11.l1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h extends k implements Function1 {
    public static final h b = new h(1, c.class, "nonNullField", "nonNullField(Ljava/lang/Object;)Ljava/lang/Object;", 1);

    public final Object invoke(Object obj) {
        l1 l1Var = (l1) obj;
        if (l1Var != null) {
            return l1Var;
        }
        throw new NullPointerException("Field is null");
    }
}
