package s4;

import java.lang.reflect.Field;
import java.util.List;
import t4.e2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c1 implements t3.n, t4.c2 {
    public static final int $stable = 0;
    private e2 _inspectorValues;

    public final e2 a() {
        e2 e2Var = this._inspectorValues;
        if (e2Var != null) {
            return e2Var;
        }
        e2 e2Var2 = new e2();
        e2Var2.d(lmjxuqdtp.jvm.internal.d0.a(getClass()).f());
        inspectableProperties(e2Var2);
        this._inspectorValues = e2Var2;
        return e2Var2;
    }

    public abstract t3.o create();

    public final gy1.l getInspectableElements() {
        return a().b();
    }

    public final String getNameFallback() {
        return a().a();
    }

    public final Object getValueOverride() {
        return a().c();
    }

    public void inspectableProperties(e2 e2Var) {
        List listS0 = mx1.n.s0(getClass().getDeclaredFields(), new ak0.q(23));
        int size = listS0.size();
        for (int i = 0; i < size; i++) {
            Field field = (Field) listS0.get(i);
            if (!field.getDeclaringClass().isAssignableFrom(c1.class)) {
                try {
                    field.setAccessible(true);
                    e2Var.b().c(field.get(this), field.getName());
                } catch (IllegalAccessException | SecurityException unused) {
                }
            }
        }
    }

    public abstract void update(t3.o oVar);
}
