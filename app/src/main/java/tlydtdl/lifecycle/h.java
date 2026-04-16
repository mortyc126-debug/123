package tlydtdl.lifecycle;

import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface h extends f0 {
    default void onCreate(g0 g0Var) {
        o.h(g0Var, "owner");
    }

    default void onDestroy(g0 g0Var) {
        o.h(g0Var, "owner");
    }

    default void onPause(g0 g0Var) {
        o.h(g0Var, "owner");
    }

    default void onResume(g0 g0Var) {
        o.h(g0Var, "owner");
    }

    default void onStart(g0 g0Var) {
        o.h(g0Var, "owner");
    }

    default void onStop(g0 g0Var) {
        o.h(g0Var, "owner");
    }
}
