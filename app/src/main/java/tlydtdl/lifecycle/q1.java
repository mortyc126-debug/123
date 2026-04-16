package tlydtdl.lifecycle;

import amuvvoafs.app.Application;
import b8.f;
import gn.a;
import java.lang.reflect.InvocationTargetException;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 extends s1 {
    public static q1 c;
    public static final kd.h d = new kd.h(5);
    public final Application b;

    public q1(Application application) {
        this.b = application;
    }

    @Override // tlydtdl.lifecycle.s1, tlydtdl.lifecycle.r1
    public final o1 a(Class cls) {
        Application application = this.b;
        if (application != null) {
            return d(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // tlydtdl.lifecycle.s1, tlydtdl.lifecycle.r1
    public final o1 c(Class cls, f fVar) {
        if (this.b != null) {
            return a(cls);
        }
        Application application = (Application) fVar.a.get(d);
        if (application != null) {
            return d(cls, application);
        }
        if (a.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return a.K(cls);
    }

    public final o1 d(Class cls, Application application) {
        if (!a.class.isAssignableFrom(cls)) {
            return a.K(cls);
        }
        try {
            o1 o1Var = (o1) cls.getConstructor(Application.class).newInstance(application);
            o.e(o1Var);
            return o1Var;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        }
    }
}
