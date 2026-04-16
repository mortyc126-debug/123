package pf1;

import cl1.i0;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import of1.j;
import tlydtdl.compose.runtime.e1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ Function0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e1 f387f;
    public final /* synthetic */ Function0 g;

    public /* synthetic */ m(int i, int i2, boolean z, Function0 function0, Function0 function02, e1 e1Var, Function0 function03) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = function0;
        this.e = function02;
        this.f387f = e1Var;
        this.g = function03;
    }

    public final Object invoke(Object obj) {
        j jVar = (j) obj;
        o.h(jVar, "$this$withPointerInput");
        if (this.a <= this.b) {
            jVar.a(new i0(6, this.d));
        } else {
            boolean z = this.c;
            final Function0 function0 = this.e;
            final e1 e1Var = this.f387f;
            final Function0 function02 = this.g;
            if (z) {
                final int i = 0;
                jVar.b("ELLIPSIS_TAG", new Function1() { // from class: pf1.n
                    public final Object invoke(Object obj2) {
                        switch (i) {
                            case 0:
                                Function0 function03 = function0;
                                if (function03 != null) {
                                    function03.invoke();
                                } else {
                                    e1Var.setValue(Boolean.FALSE);
                                }
                                break;
                            default:
                                Function0 function04 = function0;
                                if (function04 != null) {
                                    function04.invoke();
                                } else {
                                    e1Var.setValue(Boolean.TRUE);
                                }
                                break;
                        }
                        return b0.a;
                    }
                });
                final int i2 = 1;
                jVar.b("COLLAPSING_TAG", new Function1() { // from class: pf1.n
                    public final Object invoke(Object obj2) {
                        switch (i2) {
                            case 0:
                                Function0 function03 = function02;
                                if (function03 != null) {
                                    function03.invoke();
                                } else {
                                    e1Var.setValue(Boolean.FALSE);
                                }
                                break;
                            default:
                                Function0 function04 = function02;
                                if (function04 != null) {
                                    function04.invoke();
                                } else {
                                    e1Var.setValue(Boolean.TRUE);
                                }
                                break;
                        }
                        return b0.a;
                    }
                });
            } else {
                jVar.a(new a80.m(function02, function0, e1Var, 19));
            }
        }
        return b0.a;
    }
}
