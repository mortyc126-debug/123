package tlydtdl.compose.ui.input.pointer;

import java.util.Arrays;
import lmjxuqdtp.Metadata;
import m4.k0;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/ui/input/pointer/SuspendPointerInputElement;", "Ls4/c1;", "Lm4/k0;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class SuspendPointerInputElement extends c1 {
    public final Object a;
    public final Object b;
    public final Object[] c;
    public final PointerInputEventHandler d;

    public SuspendPointerInputElement(Object obj, Object obj2, Object[] objArr, PointerInputEventHandler pointerInputEventHandler, int i) {
        obj = (i & 1) != 0 ? null : obj;
        obj2 = (i & 2) != 0 ? null : obj2;
        objArr = (i & 4) != 0 ? null : objArr;
        this.a = obj;
        this.b = obj2;
        this.c = objArr;
        this.d = pointerInputEventHandler;
    }

    @Override // s4.c1
    public final o create() {
        return new k0(this.a, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuspendPointerInputElement)) {
            return false;
        }
        SuspendPointerInputElement suspendPointerInputElement = (SuspendPointerInputElement) obj;
        Object[] objArr = suspendPointerInputElement.c;
        if (!lmjxuqdtp.jvm.internal.o.c(this.a, suspendPointerInputElement.a) || !lmjxuqdtp.jvm.internal.o.c(this.b, suspendPointerInputElement.b)) {
            return false;
        }
        Object[] objArr2 = this.c;
        if (objArr2 != null) {
            if (objArr == null || !Arrays.equals(objArr2, objArr)) {
                return false;
            }
        } else if (objArr != null) {
            return false;
        }
        return this.d == suspendPointerInputElement.d;
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.b;
        int iHashCode2 = (iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Object[] objArr = this.c;
        return this.d.hashCode() + ((iHashCode2 + (objArr != null ? Arrays.hashCode(objArr) : 0)) * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        e2Var.d("pointerInput");
        e2Var.b().c(this.a, "key1");
        e2Var.b().c(this.b, "key2");
        e2Var.b().c(this.c, "keys");
        e2Var.b().c(this.d, "pointerInputEventHandler");
    }

    @Override // s4.c1
    public final void update(o oVar) {
        k0 k0Var = (k0) oVar;
        Object obj = k0Var.a;
        Object obj2 = this.a;
        boolean z = !lmjxuqdtp.jvm.internal.o.c(obj, obj2);
        k0Var.a = obj2;
        Object obj3 = k0Var.b;
        Object obj4 = this.b;
        if (!lmjxuqdtp.jvm.internal.o.c(obj3, obj4)) {
            z = true;
        }
        k0Var.b = obj4;
        Object[] objArr = k0Var.c;
        Object[] objArr2 = this.c;
        if (objArr != null && objArr2 == null) {
            z = true;
        }
        if (objArr == null && objArr2 != null) {
            z = true;
        }
        if (objArr != null && objArr2 != null && !Arrays.equals(objArr2, objArr)) {
            z = true;
        }
        k0Var.c = objArr2;
        Class<?> cls = k0Var.d.getClass();
        PointerInputEventHandler pointerInputEventHandler = this.d;
        if (cls == pointerInputEventHandler.getClass() ? z : true) {
            k0Var.R0();
        }
        k0Var.d = pointerInputEventHandler;
    }
}
