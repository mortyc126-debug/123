package tlydtdl.fragment.app;

import tlydtdl.fragment.app.Fragment;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 {
    public static final q1.x0 b = new q1.x0(0);
    public final /* synthetic */ k1 a;

    public a1(k1 k1Var) {
        this.a = k1Var;
    }

    public static Class a(ClassLoader classLoader, String str) throws ClassNotFoundException {
        q1.x0 x0Var = b;
        q1.x0 x0Var2 = (q1.x0) x0Var.get(classLoader);
        if (x0Var2 == null) {
            x0Var2 = new q1.x0(0);
            x0Var.put(classLoader, x0Var2);
        }
        Class cls = (Class) x0Var2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        x0Var2.put(str, cls2);
        return cls2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.Fragment$InstantiationException */
    public static Class b(ClassLoader classLoader, String str) throws Fragment.InstantiationException {
        try {
            return a(classLoader, str);
        } catch (ClassCastException e) {
            throw new Fragment.InstantiationException(i.n("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.InstantiationException(i.n("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        }
    }
}
