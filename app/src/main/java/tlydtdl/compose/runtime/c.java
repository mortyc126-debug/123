package tlydtdl.compose.runtime;

import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface c {
    void a(int i, int i2, int i3);

    void b(int i, int i2);

    default void c(Object obj, Function2 function2) {
        function2.invoke(f(), obj);
    }

    void d(int i, Object obj);

    default void e() {
    }

    Object f();

    void h(int i, Object obj);

    void i(Object obj);

    void j();

    void l();
}
