package iu;

import jg1.h;
import lmjxuqdtp.jvm.internal.o;
import m10.j0;
import vu0.d;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements d {
    public final String a;
    public final String b;
    public final j0 c;
    public final int d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f232f;

    public a(String str, String str2, j0 j0Var, int i, boolean z, h hVar) {
        o.h(str, "id");
        this.a = str;
        this.b = str2;
        this.c = j0Var;
        this.d = i;
        this.e = z;
        this.f232f = hVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return o.c(this.a, aVar.a) && this.b.equals(aVar.b) && o.c(this.c, aVar.c) && this.d == aVar.d && this.e == aVar.e && this.f232f.equals(aVar.f232f);
    }

    public final String getId() {
        return this.a;
    }

    public final int hashCode() {
        int iD = s1.a.d(this.a.hashCode() * 31, 31, this.b);
        j0 j0Var = this.c;
        return this.f232f.hashCode() + s1.a.f(s1.a.c(this.d, (iD + (j0Var == null ? 0 : j0Var.hashCode())) * 31, 31), 31, this.e);
    }

    public final String toString() {
        StringBuilder sbJ = p.j("BeatsCollectionListItemUiState(id=", this.a, ", name=", this.b, ", picture=");
        sbJ.append(this.c);
        sbJ.append(", beatsCount=");
        sbJ.append(this.d);
        sbJ.append(", hasSalesBadge=");
        sbJ.append(this.e);
        sbJ.append(", open=");
        sbJ.append(this.f232f);
        sbJ.append(")");
        return sbJ.toString();
    }
}
