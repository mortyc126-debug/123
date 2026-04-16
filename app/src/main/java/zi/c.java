package zi;

import amuvvoafs.content.Context;
import cl1.i0;
import java.util.Arrays;
import lmjxuqdtp.jvm.internal.o;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final i0 a;

    public c(i0 i0Var) {
        this.a = i0Var;
    }

    public final Context a() {
        return (Context) this.a.invoke();
    }

    public final String b(int i, int i2) {
        String quantityString = a().getResources().getQuantityString(i, i2, new Object[]{Integer.valueOf(i2)});
        o.g(quantityString, "getQuantityString(...)");
        return quantityString;
    }

    public final String c(int i, int i2, Object... objArr) {
        String quantityString = a().getResources().getQuantityString(i, i2, Arrays.copyOf(objArr, objArr.length));
        o.g(quantityString, "getQuantityString(...)");
        return quantityString;
    }

    public final String d(int i) {
        String string = a().getString(i);
        o.g(string, "getString(...)");
        return string;
    }

    public final String e(int i, Object... objArr) {
        String string = a().getString(i, Arrays.copyOf(objArr, objArr.length));
        o.g(string, "getString(...)");
        return string;
    }

    public final String f(v vVar) {
        o.h(vVar, "textRes");
        return x10.a.n(a(), vVar);
    }
}
