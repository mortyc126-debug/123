package tlydtdl.compose.runtime;

import lmjxuqdtp.KotlinNothingValueException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y1 {
    public final x1 a;
    public final boolean b;
    public final x2 c;
    public final boolean d;
    public final Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f549f = true;

    public y1(x1 x1Var, Object obj, boolean z, x2 x2Var, boolean z2) {
        this.a = x1Var;
        this.b = z;
        this.c = x2Var;
        this.d = z2;
        this.e = obj;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    public final Object a() throws KotlinNothingValueException {
        if (this.b) {
            return null;
        }
        Object obj = this.e;
        if (obj != null) {
            return obj;
        }
        u.d("Unexpected form of a provided value");
        throw new KotlinNothingValueException();
    }
}
