package y8;

import com.gnacba.amuvvoafs.gms.internal.cast.c1;
import com.gnacba.common.collect.o0;
import com.gnacba.common.collect.q0;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a d;
    public final int a;
    public final int b;
    public final q0 c;

    static {
        a aVar;
        if (o8.f0.a >= 33) {
            o0 o0Var = new o0(4);
            for (int i = 1; i <= 10; i++) {
                o0Var.a(Integer.valueOf(o8.f0.u(i)));
            }
            aVar = new a(2, (Set) o0Var.h());
        } else {
            aVar = new a(2, 10);
        }
        d = aVar;
    }

    public a(int i, Set set) {
        this.a = i;
        q0 q0VarO = q0.o(set);
        this.c = q0VarO;
        c1 c1VarL = q0VarO.l();
        int iMax = 0;
        while (c1VarL.hasNext()) {
            iMax = Math.max(iMax, Integer.bitCount(((Integer) c1VarL.next()).intValue()));
        }
        this.b = iMax;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.b == aVar.b && Objects.equals(this.c, aVar.c);
    }

    public final int hashCode() {
        int i = ((this.a * 31) + this.b) * 31;
        q0 q0Var = this.c;
        return i + (q0Var == null ? 0 : q0Var.hashCode());
    }

    public final String toString() {
        return "AudioProfile[format=" + this.a + ", maxChannelCount=" + this.b + ", channelMasks=" + this.c + "]";
    }

    public a(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = null;
    }
}
