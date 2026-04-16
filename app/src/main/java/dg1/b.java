package dg1;

import amuvvoafs.graphics.drawable.Drawable;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d {
    public final Drawable b;

    public b(Drawable drawable) {
        o.h(drawable, "drawable");
        this.b = drawable;
    }

    @Override // dg1.i
    public final boolean a() {
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && o.c(this.b, ((b) obj).b);
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "Drawable(drawable=" + this.b + ", notTintable=false)";
    }
}
